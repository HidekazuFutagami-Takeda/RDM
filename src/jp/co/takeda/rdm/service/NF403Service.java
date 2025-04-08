/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.inject.Named;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.HcoBlkReqDataList;
import jp.co.takeda.rdm.dto.NF403DTO;
import jp.co.takeda.rdm.entity.MRdmHcoKeieitaiEntiry;
import jp.co.takeda.rdm.entity.join.MRdmParamMstEntity;
import jp.co.takeda.rdm.entity.join.SelectComboListEntity;
import jp.co.takeda.rdm.entity.join.SelectHenkanListEntity;
import jp.co.takeda.rdm.entity.join.SelectNF403MainDataEntity;
import jp.co.takeda.rdm.entity.join.SelectParamNF403Entity;
import jp.co.takeda.rdm.entity.join.TRdmReqKnrEntity;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;

/**
 * Serviceクラス（NF403)
 * @generated
 */
@Named
public class NF403Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(NF403Service.class);

    /**
     * イベント処理
     * @param indto RDMNF403DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(NF403DTO indto) {
        BaseDTO outdto = indto;
        // START UOC
        // MR権限の場合、権限エラーでエラー画面に遷移する
        if(RdmConstantsData.RDM_JKN_MR.equals(indto.getLoginJokenSetCd())) {
        	indto.setForward("NC109");
        	return outdto;
        }

        // DropDownList作成
        createCombo(indto);

        // ページ数(現在:１ページ目から)
        indto.setPageCntCur(1);

        indto.setPageFlag("1");

        // 一括申請ボタン・申請チェックボックスの活性設定
        String mnFac = "0";
    	String mnNt = "0";

    	MRdmParamMstEntity mRdmParamMstEntity = new MRdmParamMstEntity();
    	mRdmParamMstEntity.setParamName("MN_FAC");
    	mRdmParamMstEntity.setDelFlg("0");

    	List<MRdmParamMstEntity> mRdmParamMstEntityList = dao.selectByValue(mRdmParamMstEntity);
    	if(mRdmParamMstEntityList.size() > 0) {
    		// valueの左から2桁目
    		mnFac = mRdmParamMstEntityList.get(0).getValue().substring(1,2);
    	}

    	MRdmParamMstEntity mRdmParamMstNtEntity = new MRdmParamMstEntity();
		mRdmParamMstNtEntity.setParamName("MN_NT_FAC");
    	mRdmParamMstNtEntity.setDelFlg("0");

    	List<MRdmParamMstEntity> mRdmParamMstOyaEntityList = dao.selectByValue(mRdmParamMstNtEntity);
    	if(mRdmParamMstOyaEntityList.size() > 0) {
    		// value
    		mnNt = mRdmParamMstOyaEntityList.get(0).getValue();
    	}

    	if(mnFac.equals("1") && mnNt.equals("1")) {
			indto.setBtnEnableFlg("1");
		} else {
			indto.setBtnEnableFlg("0");
		}

    	// END UOC
        return outdto;

    }

	public BaseDTO search(NF403DTO indto) {
		BaseDTO outdto = indto;
		LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

		// DropDownList作成
        createCombo(indto);

        // エラーチェック
        // 検索項目未入力の場合
        boolean inputFlg = false;

        if(indto.getSosCd() != null && !indto.getSosCd().isEmpty()) {
        	inputFlg = true;
        } else if(indto.getJgiNo() != null && !indto.getJgiNo().isEmpty()) {
        	inputFlg = true;
        } else if(indto.getInsNo() != null && !indto.getInsNo().isEmpty()) {
        	inputFlg = true;
        } else if(indto.getUltInsNo() != null && !indto.getUltInsNo().isEmpty()) {
        	inputFlg = true;
        } else if(indto.getInsKanjSrch() != null && !indto.getInsKanjSrch().isEmpty()) {
        	inputFlg = true;
        } else if(indto.getShisetsuNmSrch() != null && !indto.getShisetsuNmSrch().isEmpty()) {
        	inputFlg = true;
        } else if(indto.getInsClass() != null && !indto.getInsClass().isEmpty()) {
        	inputFlg = true;
        } else if(indto.getInsType() != null && !indto.getInsType().isEmpty()) {
        	inputFlg = true;
        } else if(indto.getHoInsType() != null && !indto.getHoInsType().isEmpty()) {
        	inputFlg = true;
        } else if(indto.getUltDif() != null && !indto.getUltDif().isEmpty()) {
        	inputFlg = true;
        }

        if (!inputFlg) {
			// 検索条件を入力してください。
			String tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W001);
			//エラーメッセージをdtoに格納
			indto.setMsgStr(tmpMsgStr);
			return outdto;
        }

        // 一覧表示データ
        List<HcoBlkReqDataList> hcoBlkReqDataList = new ArrayList<HcoBlkReqDataList>();

        // 件数定義取得
  		SelectParamNF403Entity selectParamReqNF403Entity = new SelectParamNF403Entity();
  		List<SelectParamNF403Entity> selectParamNF403List = dao.select(selectParamReqNF403Entity);

  		// 表示データ取得
  		SelectNF403MainDataEntity selectNF403MainDataCntEntity = new SelectNF403MainDataEntity("selectNF403DataListCnt");
  		SelectNF403MainDataEntity selectNF403MainDataEntity = new SelectNF403MainDataEntity("selectNF403DataList");

  		// 組織コード
  		selectNF403MainDataCntEntity.setSosCd(StringUtils.setEmptyToNull(indto.getSosCd()));
  		selectNF403MainDataEntity.setSosCd(StringUtils.setEmptyToNull(indto.getSosCd()));

  		// 部門ランク
  		selectNF403MainDataCntEntity.setBumonRank(StringUtils.setEmptyToNull(indto.getBumonRank()));
  		selectNF403MainDataEntity.setBumonRank(StringUtils.setEmptyToNull(indto.getBumonRank()));

  		// 医薬支店C
  		selectNF403MainDataCntEntity.setBrCode(StringUtils.setEmptyToNull(indto.getBrCode()));
  		selectNF403MainDataEntity.setBrCode(StringUtils.setEmptyToNull(indto.getBrCode()));

  		// 医薬営業所C
  		selectNF403MainDataCntEntity.setDistCode(StringUtils.setEmptyToNull(indto.getDistCode()));
  		selectNF403MainDataEntity.setDistCode(StringUtils.setEmptyToNull(indto.getDistCode()));

  		// 担当者
  		selectNF403MainDataCntEntity.setJgiNo(StringUtils.setEmptyToNull(indto.getJgiNo()));
  		selectNF403MainDataEntity.setJgiNo(StringUtils.setEmptyToNull(indto.getJgiNo()));

  		// 施設固定コード
  		selectNF403MainDataCntEntity.setInsNo(StringUtils.setEmptyToNull(indto.getInsNo()));
  		selectNF403MainDataEntity.setInsNo(StringUtils.setEmptyToNull(indto.getInsNo()));

  		// ULT施設コード
  		selectNF403MainDataCntEntity.setUltInsNo(StringUtils.setEmptyToNull(indto.getUltInsNo()));
  		selectNF403MainDataEntity.setUltInsNo(StringUtils.setEmptyToNull(indto.getUltInsNo()));

  		// 施設略式漢字名
  		// 漢字変換(F_RDM_KJ_HENKAN)
        if(indto.getInsKanjSrch() != null && !indto.getInsKanjSrch().isEmpty()) {
        	SelectHenkanListEntity henkanEntity = new SelectHenkanListEntity("漢字変換");
        	henkanEntity.setSearchHenkan(indto.getInsKanjSrch());
        	// 漢字変換
        	List<SelectHenkanListEntity> selectHenkanListEntity = dao.select(henkanEntity);
        	// 漢字変換後の値をセット
        	String zenkaku = selectHenkanListEntity.get(0).getSearchHenkan();
    		selectNF403MainDataCntEntity.setInsKanjSrch(zenkaku);
    		selectNF403MainDataEntity.setInsKanjSrch(zenkaku);
        }

        // ULT施設名
  		// 漢字変換(F_RDM_KJ_HENKAN)
        if(indto.getShisetsuNmSrch() != null && !indto.getShisetsuNmSrch().isEmpty()) {
        	SelectHenkanListEntity henkanEntity = new SelectHenkanListEntity("漢字変換");
        	henkanEntity.setSearchHenkan(indto.getShisetsuNmSrch());
        	// 漢字変換
        	List<SelectHenkanListEntity> selectHenkanListEntity = dao.select(henkanEntity);
        	// 漢字変換後の値をセット
        	String zenkaku = selectHenkanListEntity.get(0).getSearchHenkan();
    		selectNF403MainDataCntEntity.setShisetsuNmSrch(zenkaku);
    		selectNF403MainDataEntity.setShisetsuNmSrch(zenkaku);
        }

        // 施設分類
        selectNF403MainDataCntEntity.setInsClass(StringUtils.setEmptyToNull(indto.getInsClass()));
        selectNF403MainDataEntity.setInsClass(StringUtils.setEmptyToNull(indto.getInsClass()));

        // 施設種別
        selectNF403MainDataCntEntity.setInsType(StringUtils.setEmptyToNull(indto.getInsType()));
        selectNF403MainDataEntity.setInsType(StringUtils.setEmptyToNull(indto.getInsType()));

        // 対象区分
  		selectNF403MainDataCntEntity.setHoInsType(StringUtils.setEmptyToNull(indto.getHoInsType()));
  		selectNF403MainDataEntity.setHoInsType(StringUtils.setEmptyToNull(indto.getHoInsType()));

  		// ULT差分
  		selectNF403MainDataCntEntity.setUltDif(StringUtils.setEmptyToNull(indto.getUltDif()));
  		selectNF403MainDataEntity.setUltDif(StringUtils.setEmptyToNull(indto.getUltDif()));

        // 件数取得
        List<SelectNF403MainDataEntity> selectNF403MainDataCntList  = dao.select(selectNF403MainDataCntEntity);

        //1000件以上の場合のエラー
        if (selectNF403MainDataCntList.get(0).getCnt() > selectParamNF403List.get(0).getValue()) {
        	  // 検索結果が表示上限を超えています。検索条件を絞って再検索してください。。
        	  String tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W002);
        	  //エラーメッセージをdtoに格納
        	  indto.setMsgStr(tmpMsgStr);
        	  return outdto;
        }

        indto.initPageInfo(indto.getPageCntCur(), selectNF403MainDataCntList.get(0).getCnt(), selectParamNF403List.get(1).getValue());
        selectNF403MainDataEntity.setInOffset(indto.getLineCntStart() - 1);
        selectNF403MainDataEntity.setInLimit(selectParamNF403List.get(1).getValue());
        indto.setPageFlag("0");

        // 一覧を取得する
        List<SelectNF403MainDataEntity> selectNF403MainDataEntityList = dao.select(selectNF403MainDataEntity);

        for (SelectNF403MainDataEntity entity : selectNF403MainDataEntityList) {
        	HcoBlkReqDataList dataRecord = new HcoBlkReqDataList();

        	// 施設種別
        	if(entity.getInsType() != null && !entity.getInsType().isEmpty()) {
        		dataRecord.setInsType(entity.getInsType());
        	} else {
        		dataRecord.setInsType(" ");
        	}

        	// 施設固定コード
        	if(entity.getInsNo() != null && !entity.getInsNo().isEmpty()) {
        		dataRecord.setInsNo(entity.getInsNo());
        	} else {
        		dataRecord.setInsNo(" ");
        	}

      		// 施設略式漢字名
        	if(entity.getInsAbbrName() != null && !entity.getInsAbbrName().isEmpty()) {
        		dataRecord.setInsAbbrName(entity.getInsAbbrName());
        	} else {
        		dataRecord.setInsAbbrName(" ");
        	}

        	// 施設区分
        	if(entity.getPharmType() != null && !entity.getPharmType().isEmpty()) {
        		dataRecord.setPharmType(entity.getPharmType());
        	} else {
        		dataRecord.setPharmType("");
        	}
        	if(entity.getPharmTypeNm() != null && !entity.getPharmTypeNm().isEmpty()) {
        		dataRecord.setPharmTypeNm(entity.getPharmTypeNm());
        	} else {
        		dataRecord.setPharmTypeNm("--なし--");
        	}
        	if(entity.getShisetsuKbn() != null && !entity.getShisetsuKbn().isEmpty()) {
        		dataRecord.setShisetsuKbn(entity.getShisetsuKbn());
        	} else {
        		dataRecord.setShisetsuKbn("--なし--");
        	}
        	dataRecord.setNextPharmType(getReqViewValue(entity.getPharmType(), entity.getNextPharmType()));

        	// 階級区分
        	if(entity.getInsRank() != null && !entity.getInsRank().isEmpty()) {
        		dataRecord.setInsRank(entity.getInsRank());
        	} else {
        		dataRecord.setInsRank("");
        	}
        	if(entity.getInsRankNm() != null && !entity.getInsRankNm().isEmpty()) {
        		dataRecord.setInsRankNm(entity.getInsRankNm());
        	} else {
        		dataRecord.setInsRankNm("--なし--");
        	}
        	dataRecord.setNextInsRank(getReqViewValue(entity.getInsRank(), entity.getNextInsRank()));

        	// 定訪先区分
        	if(entity.getRegVisType() != null && !entity.getRegVisType().isEmpty()) {
        		dataRecord.setRegVisType(entity.getRegVisType());
        	} else {
        		dataRecord.setRegVisType("");
        	}
        	if(entity.getRegVisTypeNm() != null && !entity.getRegVisTypeNm().isEmpty()) {
        		dataRecord.setRegVisTypeNm(entity.getRegVisTypeNm());
        	} else {
        		dataRecord.setRegVisTypeNm("--なし--");
        	}
        	dataRecord.setNextRegVisType(getReqViewValue(entity.getRegVisType(), entity.getNextRegVisType()));

        	// 重点病院区分
        	if(entity.getImpHosType() != null && !entity.getImpHosType().isEmpty()) {
        		dataRecord.setImpHosType(entity.getImpHosType());
        	} else {
        		dataRecord.setImpHosType("");
        	}
        	if(entity.getImpHosTypeNm() != null && !entity.getImpHosTypeNm().isEmpty()) {
        		dataRecord.setImpHosTypeNm(entity.getImpHosTypeNm());
        	} else {
        		dataRecord.setImpHosTypeNm("--なし--");
        	}
        	dataRecord.setNextImpHosType(getReqViewValue(entity.getImpHosType(), entity.getNextImpHosType()));

        	// 対象区分
        	if(entity.getHoInsType() != null && !entity.getHoInsType().isEmpty()) {
        		dataRecord.setHoInsType(entity.getHoInsType());
        	} else {
        		dataRecord.setHoInsType("");
        	}
        	if(entity.getHoInsTypeNm() != null && !entity.getHoInsTypeNm().isEmpty()) {
        		dataRecord.setHoInsTypeNm(entity.getHoInsTypeNm());
        	} else {
        		dataRecord.setHoInsTypeNm("--なし--");
        	}
        	dataRecord.setNextHoInsType(getReqViewValue(entity.getHoInsType(), entity.getNextHoInsType()));

        	// 経営主体
        	if(entity.getManageCd() != null && !entity.getManageCd().isEmpty()) {
        		dataRecord.setManageCd(entity.getManageCd());
        	} else {
        		dataRecord.setManageCd("");
        	}
        	if(entity.getManageNm() != null && !entity.getManageNm().isEmpty()) {
        		dataRecord.setManageNm(entity.getManageNm());
        	} else {
        		dataRecord.setManageNm("--なし--");
        	}
        	if(entity.getKeieitai() != null && !entity.getKeieitai().isEmpty()) {
        		dataRecord.setKeieitai(entity.getKeieitai());
        	} else {
        		dataRecord.setKeieitai("--なし--");
        	}
        	dataRecord.setNextManageCd(getReqViewValue(entity.getManageCd(), entity.getNextManageCd()));

        	// ワクチン対象区分
        	if(entity.getVacInsType() != null && !entity.getVacInsType().isEmpty()) {
        		dataRecord.setVacInsType(entity.getVacInsType());
        	} else {
        		dataRecord.setVacInsType("");
        	}
        	if(entity.getVacInsTypeNm() != null && !entity.getVacInsTypeNm().isEmpty()) {
        		dataRecord.setVacInsTypeNm(entity.getVacInsTypeNm());
        	} else {
        		dataRecord.setVacInsTypeNm("--なし--");
        	}
        	dataRecord.setNextVacInsType(getReqViewValue(entity.getVacInsType(), entity.getNextVacInsType()));

        	// ワクチン定訪先区分
        	if(entity.getVacVisitType() != null && !entity.getVacVisitType().isEmpty()) {
        		dataRecord.setVacVisitType(entity.getVacVisitType());
        	} else {
        		dataRecord.setVacVisitType("");
        	}
        	if(entity.getVacVisitTypeNm() != null && !entity.getVacVisitTypeNm().isEmpty()) {
        		dataRecord.setVacVisitTypeNm(entity.getVacVisitTypeNm());
        	} else {
        		dataRecord.setVacVisitTypeNm("--なし--");
        	}
        	dataRecord.setNextVacVisitType(getReqViewValue(entity.getVacVisitType(), entity.getNextVacVisitType()));

        	// 病床数基準
        	if(entity.getBedCntBase() != null && !entity.getBedCntBase().isEmpty()) {
        		dataRecord.setBedCntBase(entity.getBedCntBase());
        	} else {
        		dataRecord.setBedCntBase(" ");
        	}
        	if(entity.getUltBedCntBase() != null && !entity.getUltBedCntBase().isEmpty()) {
        		dataRecord.setUltBedCntBase(entity.getUltBedCntBase());
        	} else {
        		dataRecord.setUltBedCntBase(" ");
        	}
        	dataRecord.setNextBedCntBase(getReqViewValue(StringUtils.nvl(entity.getBedCntBase(), ""),StringUtils.nvl(entity.getNextBedCntBase(), "")));

        	// 結核
        	if(entity.getBedCnt04() != null && !entity.getBedCnt04().isEmpty()) {
        		dataRecord.setBedCnt04(entity.getBedCnt04());
        	} else {
        		dataRecord.setBedCnt04(" ");
        	}
        	if(entity.getUltBedCnt04() != null && !entity.getUltBedCnt04().isEmpty()) {
        		dataRecord.setUltBedCnt04(entity.getUltBedCnt04());
        	} else {
        		dataRecord.setUltBedCnt04(" ");
        	}
        	dataRecord.setNextBedCnt04(getReqViewValue(StringUtils.nvl(entity.getBedCnt04(), ""),StringUtils.nvl(entity.getNextBedCnt04(), "")));

        	// 一般
        	if(entity.getBedCnt01() != null && !entity.getBedCnt01().isEmpty()) {
        		dataRecord.setBedCnt01(entity.getBedCnt01());
        	} else {
        		dataRecord.setBedCnt01(" ");
        	}
        	if(entity.getUltBedCnt01() != null && !entity.getUltBedCnt01().isEmpty()) {
        		dataRecord.setUltBedCnt01(entity.getUltBedCnt01());
        	} else {
        		dataRecord.setUltBedCnt01(" ");
        	}
        	dataRecord.setNextBedCnt01(getReqViewValue(StringUtils.nvl(entity.getBedCnt01(), ""),StringUtils.nvl(entity.getNextBedCnt01(), "")));

        	// 感染症
        	if(entity.getBedCnt05() != null && !entity.getBedCnt05().isEmpty()) {
        		dataRecord.setBedCnt05(entity.getBedCnt05());
        	} else {
        		dataRecord.setBedCnt05(" ");
        	}
        	if(entity.getUltBedCnt05() != null && !entity.getUltBedCnt05().isEmpty()) {
        		dataRecord.setUltBedCnt05(entity.getUltBedCnt05());
        	} else {
        		dataRecord.setUltBedCnt05(" ");
        	}
        	dataRecord.setNextBedCnt05(getReqViewValue(StringUtils.nvl(entity.getBedCnt05(), ""),StringUtils.nvl(entity.getNextBedCnt05(), "")));

        	// 精神
        	if(entity.getBedCnt03() != null && !entity.getBedCnt03().isEmpty()) {
        		dataRecord.setBedCnt03(entity.getBedCnt03());
        	} else {
        		dataRecord.setBedCnt03(" ");
        	}
        	if(entity.getUltBedCnt03() != null && !entity.getUltBedCnt03().isEmpty()) {
        		dataRecord.setUltBedCnt03(entity.getUltBedCnt03());
        	} else {
        		dataRecord.setUltBedCnt03(" ");
        	}
        	dataRecord.setNextBedCnt03(getReqViewValue(StringUtils.nvl(entity.getBedCnt03(), ""),StringUtils.nvl(entity.getNextBedCnt03(), "")));

        	// 療養
        	if(entity.getBedCnt07() != null && !entity.getBedCnt07().isEmpty()) {
        		dataRecord.setBedCnt07(entity.getBedCnt07());
        	} else {
        		dataRecord.setBedCnt07(" ");
        	}
        	if(entity.getUltBedCnt07() != null && !entity.getUltBedCnt07().isEmpty()) {
        		dataRecord.setUltBedCnt07(entity.getUltBedCnt07());
        	} else {
        		dataRecord.setUltBedCnt07(" ");
        	}
        	dataRecord.setNextBedCnt07(getReqViewValue(StringUtils.nvl(entity.getBedCnt07(), ""),StringUtils.nvl(entity.getNextBedCnt07(), "")));

        	// 医療療養
        	if(entity.getBedCnt02() != null && !entity.getBedCnt02().isEmpty()) {
        		dataRecord.setBedCnt02(entity.getBedCnt02());
        	} else {
        		dataRecord.setBedCnt02(" ");
        	}
        	dataRecord.setNextBedCnt02(getReqViewValue(StringUtils.nvl(entity.getBedCnt02(), ""),StringUtils.nvl(entity.getNextBedCnt02(), "")));

        	// 介護療養
        	if(entity.getBedCnt06() != null && !entity.getBedCnt06().isEmpty()) {
        		dataRecord.setBedCnt06(entity.getBedCnt06());
        	} else {
        		dataRecord.setBedCnt06(" ");
        	}
        	dataRecord.setNextBedCnt06(getReqViewValue(StringUtils.nvl(entity.getBedCnt06(), ""),StringUtils.nvl(entity.getNextBedCnt06(), "")));

        	// ベッド数計
        	if(entity.getBedsTot() != null && !entity.getBedsTot().isEmpty()) {
        		dataRecord.setBedsTot(entity.getBedsTot());
        	} else {
        		dataRecord.setBedsTot(" ");
        	}
        	if(entity.getUltBedsTot() != null && !entity.getUltBedsTot().isEmpty()) {
        		dataRecord.setUltBedsTot(entity.getUltBedsTot());
        	} else {
        		dataRecord.setUltBedsTot(" ");
        	}
        	dataRecord.setNextBedsTot(getReqViewValue(StringUtils.nvl(entity.getBedsTot(), ""),StringUtils.nvl(entity.getNextBedsTot(), "")));

        	// 医療ベッド数計
        	if(entity.getMedBedsTot() != null && !entity.getMedBedsTot().isEmpty()) {
        		dataRecord.setMedBedsTot(entity.getMedBedsTot());
        	} else {
        		dataRecord.setMedBedsTot(" ");
        	}
        	if(entity.getUltMedBedsTot() != null && !entity.getUltMedBedsTot().isEmpty()) {
        		dataRecord.setUltMedBedsTot(entity.getUltMedBedsTot());
        	} else {
        		dataRecord.setUltMedBedsTot(" ");
        	}
        	dataRecord.setNextMedBedsTot(getReqViewValue(StringUtils.nvl(entity.getMedBedsTot(), ""),StringUtils.nvl(entity.getNextMedBedsTot(), "")));

        	// 申請コメント
        	if(entity.getReqComment() != null && !entity.getReqComment().isEmpty()) {
        		dataRecord.setReqComment(entity.getReqComment());
        	} else {
        		dataRecord.setReqComment("");
        	}

        	// ULT差分
        	if(entity.getUltDif() != null && !entity.getUltDif().isEmpty()) {
        		dataRecord.setUltDif(entity.getUltDif());
        	} else {
        		dataRecord.setUltDif(" ");
        	}

        	// カラーフラグ
        	dataRecord.setPharmTypeFlg(entity.getPharmTypeFlg());
        	dataRecord.setInsRankFlg(entity.getInsRankFlg());
        	dataRecord.setRegVisTypeFlg(entity.getRegVisTypeFlg());
        	dataRecord.setImpHosTypeFlg(entity.getImpHosTypeFlg());
        	dataRecord.setHoInsTypeFlg(entity.getHoInsTypeFlg());
        	dataRecord.setManageCdFlg(entity.getManageCdFlg());
        	dataRecord.setVacInsTypeFlg(entity.getVacInsTypeFlg());
        	dataRecord.setVacVisitTypeFlg(entity.getVacVisitTypeFlg());
        	dataRecord.setBedCntBaseFlg(entity.getBedCntBaseFlg());
        	dataRecord.setBedCnt04Flg(entity.getBedCnt04Flg());
        	dataRecord.setBedCnt01Flg(entity.getBedCnt01Flg());
        	dataRecord.setBedCnt05Flg(entity.getBedCnt05Flg());
        	dataRecord.setBedCnt03Flg(entity.getBedCnt03Flg());
        	dataRecord.setBedCnt07Flg(entity.getBedCnt07Flg());
        	dataRecord.setBedCnt02Flg(entity.getBedCnt02Flg());
        	dataRecord.setBedCnt06Flg(entity.getBedCnt06Flg());
        	dataRecord.setBedsTotFlg(entity.getBedsTotFlg());
        	dataRecord.setMedBedsTotFlg(entity.getMedBedsTotFlg());

        	// 画面表示用
        	dataRecord.setTmpPharmType(dataRecord.getNextPharmType());
        	dataRecord.setTmpInsRank(dataRecord.getNextInsRank());
        	dataRecord.setTmpRegVisType(dataRecord.getNextRegVisType());
        	dataRecord.setTmpImpHosType(dataRecord.getNextImpHosType());
        	dataRecord.setTmpManageCd(dataRecord.getNextManageCd());
        	dataRecord.setNextHoInsTypeValue(dataRecord.getNextHoInsType());

        	// 最終更新日
        	if(entity.getUpdShaYmd() != null) {
	    		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
	    		dataRecord.setUpdShaYmd(fmtDate.format(entity.getUpdShaYmd()));
        	}

        	hcoBlkReqDataList.add(dataRecord);
        }
        indto.setHcoBlkReqDataList(hcoBlkReqDataList);

        indto.setSrchFlg("1");

        // END UOC
       	return outdto;
	}

    /**
     * イベント処理
     * @param indto NF403DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO request(NF403DTO indto) {
    	BaseDTO outdto = indto;
    	LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

    	boolean errFlg = false;
		String errMsg = "";

		List<HcoBlkReqDataList> hcoBlkReqDataList = new ArrayList<HcoBlkReqDataList>();

		for(HcoBlkReqDataList entity : indto.getHcoBlkReqDataList()) {
			// 申請チェック有のもののみ取得
			if("1".equals(entity.getReqChk())) {
				hcoBlkReqDataList.add(entity);
			}
		}

		// エラーチェック
		for(HcoBlkReqDataList entity : hcoBlkReqDataList) {
			entity.setTmpPharmType(entity.getNextPharmType());
        	entity.setTmpInsRank(entity.getNextInsRank());
        	entity.setTmpRegVisType(entity.getNextRegVisType());
        	entity.setTmpImpHosType(entity.getNextImpHosType());
        	entity.setTmpManageCd(entity.getNextManageCd());
        	entity.setNextHoInsTypeValue(entity.getNextHoInsType());

			// 「施設コード_施設略式漢字名：」を各エラーメッセージの先頭に追加
			StringBuilder nmSb = new StringBuilder();
			nmSb.append(entity.getInsNo());
			nmSb.append("_");
			nmSb.append(entity.getInsAbbrName());
			nmSb.append(":");
			String msgNm = nmSb.toString();

			// １：必須入力チェック
			if(entity.getInsType() != null && !"04".equals(entity.getInsType())
	        		&& !"05".equals(entity.getInsType()) && !"07".equals(entity.getInsType())) {
		        if(StringUtils.isEmpty(entity.getNextPharmType())) {
		        	// 必須項目にデータを入力してください。（施設区分）
					errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "施設区分") + "\n";
					errFlg = true;
		        }
		        if(StringUtils.isEmpty(entity.getNextInsRank())) {
		        	// 必須項目にデータを入力してください。（階級区分）
		        	errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "階級区分") + "\n";
		        	errFlg = true;
		        }
		        if(StringUtils.isEmpty(entity.getNextRegVisType())) {
		        	// 必須項目にデータを入力してください。（定訪先区分）
		        	errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "定訪先区分") + "\n";
		        	errFlg = true;
		        }
		        if(StringUtils.isEmpty(entity.getNextImpHosType())) {
		        	// 必須項目にデータを入力してください。（重点病院区分）
		        	errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "重点病院区分") + "\n";
		        	errFlg = true;
		        }
		        if(StringUtils.isEmpty(entity.getNextManageCd())) {
		        	// 必須項目にデータを入力してください。（経営主体）
		        	errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "経営主体") + "\n";
		        	errFlg = true;
		        }
	        }

			if(entity.getInsType() != null && ("01".equals(entity.getInsType())
	        		 || "02".equals(entity.getInsType()))) {
				if(StringUtils.isEmpty(entity.getNextBedCntBase())) {
	            	// 必須項目にデータを入力してください。（基準）
	    			errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "基準") + "\n";
	    			errFlg = true;
	            }
				if(StringUtils.isEmpty(entity.getNextBedCnt04())) {
	            	// 必須項目にデータを入力してください。（結核）
	    			errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "結核") + "\n";
	    			errFlg = true;
	            }
				if(StringUtils.isEmpty(entity.getNextBedCnt01())) {
	            	// 必須項目にデータを入力してください。（一般）
	    			errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "一般") + "\n";
	    			errFlg = true;
	            }
				if(StringUtils.isEmpty(entity.getNextBedCnt05())) {
	            	// 必須項目にデータを入力してください。（感染症）
	    			errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "感染症") + "\n";
	    			errFlg = true;
	            }
				if(StringUtils.isEmpty(entity.getNextBedCnt03())) {
	            	// 必須項目にデータを入力してください。（精神）
	    			errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "精神") + "\n";
	    			errFlg = true;
	            }
				if(StringUtils.isEmpty(entity.getNextBedCnt07())) {
	            	// 必須項目にデータを入力してください。（療養）
	    			errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "療養") + "\n";
	    			errFlg = true;
	            }
				if(StringUtils.isEmpty(entity.getNextBedCnt02())) {
	            	// 必須項目にデータを入力してください。（医療療養）
	    			errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "医療療養") + "\n";
	    			errFlg = true;
	            }
				if(StringUtils.isEmpty(entity.getNextBedCnt06())) {
	            	// 必須項目にデータを入力してください。（介護療養）
	    			errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "介護療養") + "\n";
	    			errFlg = true;
	            }
	        }

			// ２：レングスチェック
	        if(entity.getNextBedCntBase() != null && entity.getNextBedCntBase().length() > 4) {
	        	// 最大文字数を超えています。（病床（基準））
				errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "病床（基準）") + "\n";
				errFlg = true;
	        }
	        if(!StringUtils.isNumeric(entity.getNextBedCntBase())) {
	        	// 入力文字種が不正です。（病床（基準））
				errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "病床（基準）") + "\n";
				errFlg = true;
	        }
	        if(entity.getNextBedCnt04() != null && entity.getNextBedCnt04().length() > 4) {
	        	// 最大文字数を超えています。（病床（結核））
				errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "病床（結核）") + "\n";
				errFlg = true;
	        }
	        if(!StringUtils.isNumeric(entity.getNextBedCnt04())) {
	        	// 入力文字種が不正です。（病床（結核））
				errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "病床（結核）") + "\n";
				errFlg = true;
	        }
	        if(entity.getNextBedCnt01() != null && entity.getNextBedCnt01().length() > 4) {
	        	// 最大文字数を超えています。（病床（一般））
				errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "病床（一般）") + "\n";
				errFlg = true;
	        }
	        if(!StringUtils.isNumeric(entity.getNextBedCnt01())) {
	        	// 入力文字種が不正です。（病床（一般））
				errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "病床（一般）") + "\n";
				errFlg = true;
	        }
	        if(entity.getNextBedCnt05() != null && entity.getNextBedCnt05().length() > 4) {
	        	// 最大文字数を超えています。（病床（感染症））
				errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "病床（感染症）") + "\n";
				errFlg = true;
	        }
	        if(!StringUtils.isNumeric(entity.getNextBedCnt05())) {
	        	// 入力文字種が不正です。（病床（感染症））
				errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "病床（感染症）") + "\n";
				errFlg = true;
	        }
	        if(entity.getNextBedCnt03() != null && entity.getNextBedCnt03().length() > 4) {
	        	// 最大文字数を超えています。（病床（精神））
				errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "病床（精神）") + "\n";
				errFlg = true;
	        }
	        if(!StringUtils.isNumeric(entity.getNextBedCnt03())) {
	        	// 入力文字種が不正です。（病床（精神））
				errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "病床（精神）") + "\n";
				errFlg = true;
	        }
	        if(entity.getNextBedCnt07() != null && entity.getNextBedCnt07().length() > 4) {
	        	// 最大文字数を超えています。（病床（療養））
				errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "病床（療養）") + "\n";
				errFlg = true;
	        }
	        if(!StringUtils.isNumeric(entity.getNextBedCnt07())) {
	        	// 入力文字種が不正です。（病床（療養））
				errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "病床（療養）") + "\n";
				errFlg = true;
	        }
	        if(entity.getNextBedCnt02() != null && entity.getNextBedCnt02().length() > 4) {
	        	// 最大文字数を超えています。（病床（医療療養））
				errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "病床（医療療養）") + "\n";
				errFlg = true;
	        }
	        if(!StringUtils.isNumeric(entity.getNextBedCnt02())) {
	        	// 入力文字種が不正です。（病床（医療療養））
				errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "病床（医療療養）") + "\n";
				errFlg = true;
	        }
	        if(entity.getNextBedCnt06() != null && entity.getNextBedCnt06().length() > 4) {
	        	// 最大文字数を超えています。（病床（介護療養））
				errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "病床（介護療養）") + "\n";
				errFlg = true;
	        }
	        if(!StringUtils.isNumeric(entity.getNextBedCnt06())) {
	        	// 入力文字種が不正です。（病床（介護療養））
				errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "病床（介護療養）") + "\n";
				errFlg = true;
	        }
	        if(entity.getNextBedsTot() != null && entity.getNextBedsTot().length() > 5) {
	        	// 最大文字数を超えています。（病床（ベッド数計））
				errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "病床（ベッド数計）") + "\n";
				errFlg = true;
	        }
	        if(entity.getNextMedBedsTot() != null && entity.getNextMedBedsTot().length() > 5) {
	        	// 最大文字数を超えています。病床（（医療ベッド数計））
				errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "病床（医療ベッド数計）") + "\n";
				errFlg = true;
	        }
	        if(entity.getReqComment() != null && StringUtils.getByteLength(entity.getReqComment()) > 300) {
	        	// 最大文字数を超えています。（申請コメント）
				errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "申請コメント") + "\n";
				errFlg = true;
	        }

	        // ７：整合性チェック
	        // 階級区分と病床数の値が適合しない場合
			if((!"01".equals(entity.getInsType()) && !"02".equals(entity.getInsType())) || entity.getNextInsRank() == null) {

			} else if(("01".equals(entity.getNextInsRank()) || "02".equals(entity.getNextInsRank()) || "03".equals(entity.getNextInsRank())
					 || "04".equals(entity.getNextInsRank()) || "05".equals(entity.getNextInsRank()) || "06".equals(entity.getNextInsRank()))
					 && !chkNumRange(entity.getNextBedsTot(), 0, 9999)){
				// 階級区分の範囲とベッド数計が一致するよう入力して下さい。
				errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W023) + "\n";
				errFlg = true;
			} else if(("12".equals(entity.getNextInsRank()) || "13".equals(entity.getNextInsRank()) || "15".equals(entity.getNextInsRank()))
					 && !"0".equals(entity.getNextBedsTot())){
				// 階級区分の範囲とベッド数計が一致するよう入力して下さい。
				errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W023) + "\n";
				errFlg = true;
			} else if(("11".equals(entity.getNextInsRank()) || "14".equals(entity.getNextInsRank()))
					 && !chkNumRange(entity.getNextBedsTot(), 1, 19)){
				// 階級区分の範囲とベッド数計が一致するよう入力して下さい。
				errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W023) + "\n";
				errFlg = true;
			} else if("07".equals(entity.getNextInsRank()) && !chkNumRange(entity.getNextBedsTot(), 100, 9999)){
				// 階級区分の範囲とベッド数計が一致するよう入力して下さい。
				errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W023) + "\n";
				errFlg = true;
			} else if("08".equals(entity.getNextInsRank()) && !chkNumRange(entity.getNextBedsTot(), 200, 9999)){
				// 階級区分の範囲とベッド数計が一致するよう入力して下さい。
				errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W023) + "\n";
				errFlg = true;
			} else if("09".equals(entity.getNextInsRank()) && !chkNumRange(entity.getNextBedsTot(), 20, 99)){
				// 階級区分の範囲とベッド数計が一致するよう入力して下さい。
				errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W023) + "\n";
				errFlg = true;
			} else if("10".equals(entity.getNextInsRank()) && !chkNumRange(entity.getNextBedsTot(), 20, 199)){
				// 階級区分の範囲とベッド数計が一致するよう入力して下さい。
				errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W023) + "\n";
				errFlg = true;
			} else if("16".equals(entity.getNextInsRank())
						&& !("0".equals(StringUtils.nvl(entity.getNextBedCnt01(),"0")) && "0".equals(StringUtils.nvl(entity.getNextBedCnt07(), "0")) && "0".equals(StringUtils.nvl(entity.getNextBedCnt04(),"0"))
								&& "0".equals(StringUtils.nvl(entity.getNextBedCnt05(),"0")) &&chkNumRange(entity.getNextBedCnt03(), 1, 9999))){
				// 階級区分の範囲とベッド数計が一致するよう入力して下さい。
				errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.W023) + "\n";
				errFlg = true;
			}

			// 排他チェック
			TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity("selectNF401DateChkData");
			tRdmReqKnrEntity.setInsNo(entity.getInsNo());
			List<TRdmReqKnrEntity> tRdmReqKnrChkData = dao.select(tRdmReqKnrEntity);

			if(tRdmReqKnrChkData.size() > 0 && tRdmReqKnrChkData.get(0) != null && tRdmReqKnrChkData.get(0).getUpdShaYmd() != null) {
				// 現在日付を取得
				SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
				String updShaYmd = fmtDate.format(tRdmReqKnrChkData.get(0).getUpdShaYmd());

				if(!updShaYmd.equals(entity.getUpdShaYmd())) {
					// 既に他のユーザーによってデータが処理されています。
					errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.E003) + "\n";
					errFlg = true;
				}
			}
		}

		// エラー時処理
		if (errFlg) {
			indto.setMsgStr(errMsg);
			indto.setForward("NF403");

			// DropDownList作成
			createCombo(indto);

			return outdto;
		}

		indto.setForward("NF405Init");
    	return outdto;
    }

    /**
     * コンボ作成
     * @param indto NF401DTO
     * @return なし
     * @customizable
     */
    private void createCombo(NF403DTO indto){
		// 施設分類
    	SelectComboListEntity inEntityCmb = new SelectComboListEntity();
    	inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_INS_CLASS);
        List<SelectComboListEntity> outMainList = dao.select(inEntityCmb);
        LinkedHashMap<String, String> mapDelKbn = new LinkedHashMap<String, String>();
        mapDelKbn.put("", "--なし--");
        for (SelectComboListEntity outEntity : outMainList) {
        	mapDelKbn.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
        }
        indto.setInsClassCombo(mapDelKbn);

        // 施設種別
        inEntityCmb = new SelectComboListEntity();
        inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_INS_TYPE);
        outMainList = dao.select(inEntityCmb);
        LinkedHashMap<String, String> mapInsType = new LinkedHashMap<String, String>();
        mapInsType.put("", "--なし--");
        for (SelectComboListEntity outEntity : outMainList) {
        	mapInsType.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
        }
        indto.setInsTypeCombo(mapInsType);

        // 対象区分
        inEntityCmb = new SelectComboListEntity();
    	inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_HO_INS_TYPE);
        outMainList = dao.select(inEntityCmb);
        LinkedHashMap<String, String> mapHoInsType = new LinkedHashMap<String, String>();
        mapHoInsType.put("", "--なし--");
        for (SelectComboListEntity outEntity : outMainList) {
        	mapHoInsType.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
        }
        indto.setHoInsTypeCombo(mapHoInsType);

        // ULT差分
        LinkedHashMap<String, String> mapUltDif = new LinkedHashMap<String, String>();
        mapUltDif.put("", "--なし--");
        mapUltDif.put("0", "無");
        mapUltDif.put("1", "有");
        indto.setUltDifCombo(mapUltDif);

        // 施設区分
        inEntityCmb = new SelectComboListEntity();
    	inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_PHARM_TYPE);
        outMainList = dao.select(inEntityCmb);
        LinkedHashMap<String, String> mapPharmType = new LinkedHashMap<String, String>();
        mapPharmType.put("", "--なし--");
        for (SelectComboListEntity outEntity : outMainList) {
        	mapPharmType.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
        }
        indto.setPharmTypeCombo(mapPharmType);

        // 階級区分
        inEntityCmb = new SelectComboListEntity();
    	inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_INS_RANK);
        outMainList = dao.select(inEntityCmb);
        LinkedHashMap<String, String> mapInsRank = new LinkedHashMap<String, String>();
        mapInsRank.put("", "--なし--");
        for (SelectComboListEntity outEntity : outMainList) {
        	mapInsRank.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
        }
        indto.setInsRankCombo(mapInsRank);

        // 定訪先区分
        inEntityCmb = new SelectComboListEntity();
    	inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_REG_VIS_TYPE);
        outMainList = dao.select(inEntityCmb);
        LinkedHashMap<String, String> mapRegVisType = new LinkedHashMap<String, String>();
        mapRegVisType.put("", "--なし--");
        for (SelectComboListEntity outEntity : outMainList) {
        	mapRegVisType.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
        }
        indto.setRegVisTypeCombo(mapRegVisType);

        // 重点病院区分
        inEntityCmb = new SelectComboListEntity();
    	inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_IMP_HOS_TYPE);
        outMainList = dao.select(inEntityCmb);
        LinkedHashMap<String, String> mapImpHosType = new LinkedHashMap<String, String>();
        mapImpHosType.put("", "--なし--");
        for (SelectComboListEntity outEntity : outMainList) {
        	mapImpHosType.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
        }
        indto.setImpHosTypeCombo(mapImpHosType);

        // 経営主体
 		MRdmHcoKeieitaiEntiry mRdmHcoKeieitaiCmb = new MRdmHcoKeieitaiEntiry("selectKeieitaiComboList");
 		List<MRdmHcoKeieitaiEntiry> keieiList = dao.select(mRdmHcoKeieitaiCmb);
 		LinkedHashMap<String, String> mapManageCd = new LinkedHashMap<String, String>();
 		mapManageCd.put("", "--なし--");
 		for (MRdmHcoKeieitaiEntiry outEntity : keieiList) {
 			mapManageCd.put(outEntity.getSetDtCd(), outEntity.getSetDtCd()+":"+outEntity.getKeieitaiKj());
 		}
 		indto.setManageCdCombo(mapManageCd);

 		// ワクチン対象区分
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_VAC_INS_TYPE);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapVacInsType = new LinkedHashMap<String, String>();
		mapVacInsType.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapVacInsType.put(outEntity.getValue(), outEntity.getValue() + ":" + outEntity.getValueKanji());
		}
		indto.setVacInsTypeCombo(mapVacInsType);

		// ワクチン定訪先区分
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_VAC_VISIT_TYPE);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapVacVisitType = new LinkedHashMap<String, String>();
		mapVacVisitType.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapVacVisitType.put(outEntity.getValue(), outEntity.getValue() + ":" + outEntity.getValueKanji());
		}
		indto.setVacVisitTypeCombo(mapVacVisitType);
    }

    /**
     * 数値範囲チェック
     * @return n = "", min <= n <= max ならtrue
     */
	public static boolean chkNumRange(String n, int min, int max){
		if(n == null || "".equals(n)){
			return true;
		} else if(!StringUtils.isNumeric(n)){
			return false;
		} else if(Integer.parseInt(n) >= min && Integer.parseInt(n) <= max){
			return true;
		}
		return false;
	}

	/**
    * NULLの場合変更前値、'Z'の場合はブランクを返却
    * @param preValue
    * @param value
    * @return
    */
   public String getReqViewValue(String preValue, String value){
   	String rtnValue = value;

   	if(StringUtils.isEmpty(value)) {
   		rtnValue = preValue;
   	} else if("Z".equals(value)) {
   		rtnValue = "";
   	}

   	return rtnValue;
   }
}