/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import jp.co.takeda.rdm.entity.join.SelectNF401MainDataEntity;
import jp.co.takeda.rdm.entity.join.SelectNF403MainDataEntity;
import jp.co.takeda.rdm.entity.join.SelectParamNF403Entity;
import jp.co.takeda.rdm.util.DateUtils;
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

		// 現在日付を取得
		Date systemDate = DateUtils.getNowDate();
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
		indto.setSrchSysDate(fmtDate.format(systemDate));

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
        	if(entity.getPharmTypeNm() != null && !entity.getPharmTypeNm().isEmpty()) {
        		dataRecord.setPharmTypeNm(entity.getPharmTypeNm());
        	} else {
        		dataRecord.setPharmTypeNm(" ");
        	}
        	if(entity.getShisetsuKbn() != null && !entity.getShisetsuKbn().isEmpty()) {
        		dataRecord.setShisetsuKbn(entity.getShisetsuKbn());
        	} else {
        		dataRecord.setShisetsuKbn(" ");
        	}
        	if(entity.getNextPharmType() != null && !entity.getNextPharmType().isEmpty()) {
        		dataRecord.setNextPharmType(entity.getNextPharmType());
        	} else {
        		if(entity.getPharmType() != null && !entity.getPharmType().isEmpty()) {
            		dataRecord.setNextPharmType(entity.getPharmType());
            	} else {
            		dataRecord.setNextPharmType("");
            	}
        	}

        	// 階級区分
        	if(entity.getInsRankNm() != null && !entity.getInsRankNm().isEmpty()) {
        		dataRecord.setInsRankNm(entity.getInsRankNm());
        	} else {
        		dataRecord.setInsRankNm(" ");
        	}
        	if(entity.getNextInsRank() != null && !entity.getNextInsRank().isEmpty()) {
        		dataRecord.setNextInsRank(entity.getNextInsRank());
        	} else {
        		if(entity.getInsRank() != null && !entity.getInsRank().isEmpty()) {
            		dataRecord.setNextInsRank(entity.getInsRank());
            	} else {
            		dataRecord.setNextInsRank("");
            	}
        	}

        	// 定訪先区分
        	if(entity.getRegVisTypeNm() != null && !entity.getRegVisTypeNm().isEmpty()) {
        		dataRecord.setRegVisTypeNm(entity.getRegVisTypeNm());
        	} else {
        		dataRecord.setRegVisTypeNm(" ");
        	}
        	if(entity.getNextRegVisType() != null && !entity.getNextRegVisType().isEmpty()) {
        		dataRecord.setNextRegVisType(entity.getNextRegVisType());
        	} else {
        		if(entity.getRegVisType() != null && !entity.getRegVisType().isEmpty()) {
            		dataRecord.setNextRegVisType(entity.getRegVisType());
            	} else {
            		dataRecord.setNextRegVisType("");
            	}
        	}

        	// 重点病院区分
        	if(entity.getImpHosTypeNm() != null && !entity.getImpHosTypeNm().isEmpty()) {
        		dataRecord.setImpHosTypeNm(entity.getImpHosTypeNm());
        	} else {
        		dataRecord.setImpHosTypeNm(" ");
        	}
        	if(entity.getNextImpHosType() != null && !entity.getNextImpHosType().isEmpty()) {
        		dataRecord.setNextImpHosType(entity.getNextImpHosType());
        	} else {
        		if(entity.getImpHosType() != null && !entity.getImpHosType().isEmpty()) {
            		dataRecord.setNextImpHosType(entity.getImpHosType());
            	} else {
            		dataRecord.setNextImpHosType("");
            	}
        	}

        	// 対象区分
        	if(entity.getHoInsTypeNm() != null && !entity.getHoInsTypeNm().isEmpty()) {
        		dataRecord.setHoInsTypeNm(entity.getHoInsTypeNm());
        	} else {
        		dataRecord.setHoInsTypeNm(" ");
        	}
        	if(entity.getNextHoInsType() != null && !entity.getNextHoInsType().isEmpty()) {
        		dataRecord.setNextHoInsType(entity.getNextHoInsType());
        	} else {
        		if(entity.getHoInsType() != null && !entity.getHoInsType().isEmpty()) {
            		dataRecord.setNextHoInsType(entity.getHoInsType());
            	} else {
            		dataRecord.setNextHoInsType("");
            	}
        	}

        	// 経営主体
        	if(entity.getManageNm() != null && !entity.getManageNm().isEmpty()) {
        		dataRecord.setManageNm(entity.getManageNm());
        	} else {
        		dataRecord.setManageNm(" ");
        	}
        	if(entity.getKeieitai() != null && !entity.getKeieitai().isEmpty()) {
        		dataRecord.setKeieitai(entity.getKeieitai());
        	} else {
        		dataRecord.setKeieitai(" ");
        	}
        	if(entity.getNextManageCd() != null && !entity.getNextManageCd().isEmpty()) {
        		dataRecord.setNextManageCd(entity.getNextManageCd());
        	} else {
        		if(entity.getManageCd() != null && !entity.getManageCd().isEmpty()) {
            		dataRecord.setNextManageCd(entity.getManageCd());
            	} else {
            		dataRecord.setNextManageCd("");
            	}
        	}


        	// ワクチン対象区分
        	if(entity.getVacInsTypeNm() != null && !entity.getVacInsTypeNm().isEmpty()) {
        		dataRecord.setVacInsTypeNm(entity.getVacInsTypeNm());
        	} else {
        		dataRecord.setVacInsTypeNm(" ");
        	}
        	if(entity.getNextVacInsType() != null && !entity.getNextVacInsType().isEmpty()) {
        		dataRecord.setNextVacInsType(entity.getNextVacInsType());
        	} else {
        		if(entity.getVacInsType() != null && !entity.getVacInsType().isEmpty()) {
            		dataRecord.setNextVacInsType(entity.getVacInsType());
            	} else {
            		dataRecord.setNextVacInsType("");
            	}
        	}

        	// ワクチン定訪先区分
        	if(entity.getVacVisitTypeNm() != null && !entity.getVacVisitTypeNm().isEmpty()) {
        		dataRecord.setVacVisitTypeNm(entity.getVacVisitTypeNm());
        	} else {
        		dataRecord.setVacVisitTypeNm(" ");
        	}
        	if(entity.getNextVacVisitType() != null && !entity.getNextVacVisitType().isEmpty()) {
        		dataRecord.setNextVacVisitType(entity.getNextVacVisitType());
        	} else {
        		if(entity.getVacVisitType() != null && !entity.getVacVisitType().isEmpty()) {
            		dataRecord.setNextVacVisitType(entity.getVacVisitType());
            	} else {
            		dataRecord.setNextVacVisitType("");
            	}
        	}

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
        	if(entity.getNextBedCntBase() != null && !entity.getNextBedCntBase().isEmpty()) {
        		dataRecord.setNextBedCntBase(entity.getNextBedCntBase());
        	} else {
        		if(entity.getBedCntBase() != null && !entity.getBedCntBase().isEmpty()) {
            		dataRecord.setNextBedCntBase(entity.getBedCntBase());
            	} else {
            		dataRecord.setNextBedCntBase(" ");
            	}
        	}

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
        	if(entity.getNextBedCnt04() != null && !entity.getNextBedCnt04().isEmpty()) {
        		dataRecord.setNextBedCnt04(entity.getNextBedCnt04());
        	} else {
        		if(entity.getBedCnt04() != null && !entity.getBedCnt04().isEmpty()) {
            		dataRecord.setNextBedCnt04(entity.getBedCnt04());
            	} else {
            		dataRecord.setNextBedCnt04(" ");
            	}
        	}

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
        	if(entity.getNextBedCnt01() != null && !entity.getNextBedCnt01().isEmpty()) {
        		dataRecord.setNextBedCnt01(entity.getNextBedCnt01());
        	} else {
        		if(entity.getBedCnt01() != null && !entity.getBedCnt01().isEmpty()) {
            		dataRecord.setNextBedCnt01(entity.getBedCnt01());
            	} else {
            		dataRecord.setNextBedCnt01(" ");
            	}
        	}

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
        	if(entity.getNextBedCnt05() != null && !entity.getNextBedCnt05().isEmpty()) {
        		dataRecord.setNextBedCnt05(entity.getNextBedCnt05());
        	} else {
        		if(entity.getBedCnt05() != null && !entity.getBedCnt05().isEmpty()) {
            		dataRecord.setNextBedCnt05(entity.getBedCnt05());
            	} else {
            		dataRecord.setNextBedCnt05(" ");
            	}
        	}

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
        	if(entity.getNextBedCnt03() != null && !entity.getNextBedCnt03().isEmpty()) {
        		dataRecord.setNextBedCnt03(entity.getNextBedCnt03());
        	} else {
        		if(entity.getBedCnt03() != null && !entity.getBedCnt03().isEmpty()) {
            		dataRecord.setNextBedCnt03(entity.getBedCnt03());
            	} else {
            		dataRecord.setNextBedCnt03(" ");
            	}
        	}

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
        	if(entity.getNextBedCnt07() != null && !entity.getNextBedCnt07().isEmpty()) {
        		dataRecord.setNextBedCnt07(entity.getNextBedCnt07());
        	} else {
        		if(entity.getBedCnt07() != null && !entity.getBedCnt07().isEmpty()) {
            		dataRecord.setNextBedCnt07(entity.getBedCnt07());
            	} else {
            		dataRecord.setNextBedCnt07(" ");
            	}
        	}

        	// 医療療養
        	if(entity.getBedCnt02() != null && !entity.getBedCnt02().isEmpty()) {
        		dataRecord.setBedCnt02(entity.getBedCnt02());
        	} else {
        		dataRecord.setBedCnt02(" ");
        	}
        	if(entity.getNextBedCnt02() != null && !entity.getNextBedCnt02().isEmpty()) {
        		dataRecord.setNextBedCnt02(entity.getNextBedCnt02());
        	} else {
        		if(entity.getBedCnt02() != null && !entity.getBedCnt02().isEmpty()) {
            		dataRecord.setNextBedCnt02(entity.getBedCnt02());
            	} else {
            		dataRecord.setNextBedCnt02(" ");
            	}
        	}

        	// 介護療養
        	if(entity.getBedCnt06() != null && !entity.getBedCnt06().isEmpty()) {
        		dataRecord.setBedCnt06(entity.getBedCnt06());
        	} else {
        		dataRecord.setBedCnt06(" ");
        	}
        	if(entity.getNextBedCnt06() != null && !entity.getNextBedCnt06().isEmpty()) {
        		dataRecord.setNextBedCnt06(entity.getNextBedCnt06());
        	} else {
        		if(entity.getBedCnt06() != null && !entity.getBedCnt06().isEmpty()) {
            		dataRecord.setNextBedCnt06(entity.getBedCnt06());
            	} else {
            		dataRecord.setNextBedCnt06(" ");
            	}
        	}

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
        	if(entity.getNextBedsTot() != null && !entity.getNextBedsTot().isEmpty()) {
        		dataRecord.setNextBedsTot(entity.getNextBedsTot());
        	} else {
        		if(entity.getBedsTot() != null && !entity.getBedsTot().isEmpty()) {
            		dataRecord.setNextBedsTot(entity.getBedsTot());
            	} else {
            		dataRecord.setNextBedsTot(" ");
            	}
        	}

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
        	if(entity.getNextMedBedsTot() != null && !entity.getNextMedBedsTot().isEmpty()) {
        		dataRecord.setNextMedBedsTot(entity.getNextMedBedsTot());
        	} else {
        		if(entity.getMedBedsTot() != null && !entity.getMedBedsTot().isEmpty()) {
            		dataRecord.setNextMedBedsTot(entity.getMedBedsTot());
            	} else {
            		dataRecord.setNextMedBedsTot(" ");
            	}
        	}

        	// 申請コメント
        	if(entity.getReqComment() != null && !entity.getReqComment().isEmpty()) {
        		dataRecord.setReqComment(entity.getReqComment());
        	} else {
        		dataRecord.setReqComment(" ");
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
        	dataRecord.setTmpRegVisType(dataRecord.getRegVisType());
        	dataRecord.setImpHosType(dataRecord.getImpHosType());

        	hcoBlkReqDataList.add(dataRecord);
        }
        indto.setHcoBlkReqDataList(hcoBlkReqDataList);

        indto.setSrchFlg("1");

        // END UOC
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
}