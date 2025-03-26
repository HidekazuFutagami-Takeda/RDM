/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.HcoReqDataList;
import jp.co.takeda.rdm.dto.NF401DTO;
import jp.co.takeda.rdm.entity.join.MRdmParamMstEntity;
import jp.co.takeda.rdm.entity.join.SelectComboListEntity;
import jp.co.takeda.rdm.entity.join.SelectHenkanListEntity;
import jp.co.takeda.rdm.entity.join.SelectNF401MainDataEntity;
import jp.co.takeda.rdm.entity.join.SelectNF401ReqDataEntity;
import jp.co.takeda.rdm.entity.join.SelectParamNF401Entity;
import jp.co.takeda.rdm.entity.join.TRdmReqKnrEntity;
import jp.co.takeda.rdm.util.DateUtils;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;

/**
 * Serviceクラス（NF401)
 * @generated
 */
@Named
public class NF401Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(NF401Service.class);

    /**
     * イベント処理
     * @param indto RDMNF401DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(NF401DTO indto) {
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

        // 一括承認ボタンの活性設定
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

    	// 一括承認ボタン
    	if(mnFac.equals("1") && mnNt.equals("1")) {
			indto.setBtnEnableFlg("1");
		} else {
			indto.setBtnEnableFlg("0");
		}

    	// 却下ボタン
    	if(mnFac.equals("1")) {
			indto.setRejBtnEnableFlg("1");
		} else {
			indto.setRejBtnEnableFlg("0");
		}

        // END UOC
        return outdto;

    }

	public BaseDTO search(NF401DTO indto) {
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
        }

        if (!inputFlg) {
      	  // 検索条件を入力してください。
      	  String tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W001);
      	  //エラーメッセージをdtoに格納
      	  indto.setMsgStr(tmpMsgStr);
      	  return outdto;
      }

        // 一覧表示データ
        List<HcoReqDataList> hcoReqDataList = new ArrayList<HcoReqDataList>();

        // 件数定義取得
  		SelectParamNF401Entity selectParamReqNF401Entity = new SelectParamNF401Entity();
  		List<SelectParamNF401Entity> selectParamNF401List = dao.select(selectParamReqNF401Entity);

  		// 表示データ取得
  		SelectNF401MainDataEntity selectNF401MainDataCntEntity = new SelectNF401MainDataEntity("selectNF401DataListCnt");
  		SelectNF401MainDataEntity selectNF401MainDataEntity = new SelectNF401MainDataEntity("selectNF401DataList");

  		// 組織コード
  		selectNF401MainDataCntEntity.setSosCd(StringUtils.setEmptyToNull(indto.getSosCd()));
  		selectNF401MainDataEntity.setSosCd(StringUtils.setEmptyToNull(indto.getSosCd()));

  		// 部門ランク
  		selectNF401MainDataCntEntity.setBumonRank(StringUtils.setEmptyToNull(indto.getBumonRank()));
  		selectNF401MainDataEntity.setBumonRank(StringUtils.setEmptyToNull(indto.getBumonRank()));

  		// 医薬支店C
  		selectNF401MainDataCntEntity.setBrCode(StringUtils.setEmptyToNull(indto.getBrCode()));
  		selectNF401MainDataEntity.setBrCode(StringUtils.setEmptyToNull(indto.getBrCode()));

  		// 医薬営業所C
  		selectNF401MainDataCntEntity.setDistCode(StringUtils.setEmptyToNull(indto.getDistCode()));
  		selectNF401MainDataEntity.setDistCode(StringUtils.setEmptyToNull(indto.getDistCode()));

  		// 担当者
  		selectNF401MainDataCntEntity.setJgiNo(StringUtils.setEmptyToNull(indto.getJgiNo()));
  		selectNF401MainDataEntity.setJgiNo(StringUtils.setEmptyToNull(indto.getJgiNo()));

  		// 施設固定コード
  		selectNF401MainDataCntEntity.setInsNo(StringUtils.setEmptyToNull(indto.getInsNo()));
  		selectNF401MainDataEntity.setInsNo(StringUtils.setEmptyToNull(indto.getInsNo()));

  		// ULT施設コード
  		selectNF401MainDataCntEntity.setUltInsNo(StringUtils.setEmptyToNull(indto.getUltInsNo()));
  		selectNF401MainDataEntity.setUltInsNo(StringUtils.setEmptyToNull(indto.getUltInsNo()));

  		// 施設略式漢字名
  		// 漢字変換(F_RDM_KJ_HENKAN)
        if(indto.getInsKanjSrch() != null && !indto.getInsKanjSrch().isEmpty()) {
        	SelectHenkanListEntity henkanEntity = new SelectHenkanListEntity("漢字変換");
        	henkanEntity.setSearchHenkan(indto.getInsKanjSrch());
        	// 漢字変換
        	List<SelectHenkanListEntity> selectHenkanListEntity = dao.select(henkanEntity);
        	// 漢字変換後の値をセット
        	String zenkaku = selectHenkanListEntity.get(0).getSearchHenkan();
    		selectNF401MainDataCntEntity.setInsKanjSrch(zenkaku);
    		selectNF401MainDataEntity.setInsKanjSrch(zenkaku);
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
    		selectNF401MainDataCntEntity.setShisetsuNmSrch(zenkaku);
    		selectNF401MainDataEntity.setShisetsuNmSrch(zenkaku);
        }

        // 施設分類
        selectNF401MainDataCntEntity.setInsClass(StringUtils.setEmptyToNull(indto.getInsClass()));
        selectNF401MainDataEntity.setInsClass(StringUtils.setEmptyToNull(indto.getInsClass()));

        // 施設種別
        selectNF401MainDataCntEntity.setInsType(StringUtils.setEmptyToNull(indto.getInsType()));
        selectNF401MainDataEntity.setInsType(StringUtils.setEmptyToNull(indto.getInsType()));

        // 対象区分
  		selectNF401MainDataCntEntity.setHoInsType(StringUtils.setEmptyToNull(indto.getHoInsType()));
  		selectNF401MainDataEntity.setHoInsType(StringUtils.setEmptyToNull(indto.getHoInsType()));

  		// 未審査申請数0のみ対象
  		if("true".equals(indto.getShnFlgChk())) {
  			selectNF401MainDataCntEntity.setShnFlgChk("1");
  	  		selectNF401MainDataEntity.setShnFlgChk("1");
    	} else {
    		selectNF401MainDataCntEntity.setShnFlgChk("0");
  	  		selectNF401MainDataEntity.setShnFlgChk("0");
    	}

        // 件数取得
        List<SelectNF401MainDataEntity> selectNF401MainDataCntList  = dao.select(selectNF401MainDataCntEntity);

        //1000件以上の場合のエラー
        if (selectNF401MainDataCntList.get(0).getCnt() > selectParamNF401List.get(0).getValue()) {
        	  // 検索結果が表示上限を超えています。検索条件を絞って再検索してください。。
        	  String tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W002);
        	  //エラーメッセージをdtoに格納
        	  indto.setMsgStr(tmpMsgStr);
        	  return outdto;
        }

        indto.initPageInfo(indto.getPageCntCur(), selectNF401MainDataCntList.get(0).getCnt(), selectParamNF401List.get(1).getValue());
        selectNF401MainDataEntity.setInOffset(indto.getLineCntStart() - 1);
        selectNF401MainDataEntity.setInLimit(selectParamNF401List.get(1).getValue());
        indto.setPageFlag("0");

        // 一覧を取得する
        List<SelectNF401MainDataEntity> selectNF401MainDataEntityList = dao.select(selectNF401MainDataEntity);

        for (SelectNF401MainDataEntity entity : selectNF401MainDataEntityList) {
        	HcoReqDataList dataRecord = new HcoReqDataList();

        	// 承認待ちフラグ
        	if(entity.getAprWaitCnt() != null && entity.getAprWaitCnt() > 0) {
        		dataRecord.setWaitAppFlg("1");
        	} else {
        		dataRecord.setWaitAppFlg("0");
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
        		dataRecord.setPharmType(" ");
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
            		dataRecord.setNextPharmType(" ");
            	}
        	}

        	// 階級区分
        	if(entity.getInsRank() != null && !entity.getInsRank().isEmpty()) {
        		dataRecord.setInsRank(entity.getInsRank());
        	} else {
        		dataRecord.setInsRank(" ");
        	}
        	if(entity.getNextInsRank() != null && !entity.getNextInsRank().isEmpty()) {
        		dataRecord.setNextInsRank(entity.getNextInsRank());
        	} else {
        		if(entity.getInsRank() != null && !entity.getInsRank().isEmpty()) {
            		dataRecord.setNextInsRank(entity.getInsRank());
            	} else {
            		dataRecord.setNextInsRank(" ");
            	}
        	}

        	// 定訪先区分
        	if(entity.getRegVisType() != null && !entity.getRegVisType().isEmpty()) {
        		dataRecord.setRegVisType(entity.getRegVisType());
        	} else {
        		dataRecord.setRegVisType(" ");
        	}
        	if(entity.getNextRegVisType() != null && !entity.getNextRegVisType().isEmpty()) {
        		dataRecord.setNextRegVisType(entity.getNextRegVisType());
        	} else {
        		if(entity.getRegVisType() != null && !entity.getRegVisType().isEmpty()) {
            		dataRecord.setNextRegVisType(entity.getRegVisType());
            	} else {
            		dataRecord.setNextRegVisType(" ");
            	}
        	}

        	// 重点病院区分
        	if(entity.getImpHosType() != null && !entity.getImpHosType().isEmpty()) {
        		dataRecord.setImpHosType(entity.getImpHosType());
        	} else {
        		dataRecord.setImpHosType(" ");
        	}
        	if(entity.getNextImpHosType() != null && !entity.getNextImpHosType().isEmpty()) {
        		dataRecord.setNextImpHosType(entity.getNextImpHosType());
        	} else {
        		if(entity.getImpHosType() != null && !entity.getImpHosType().isEmpty()) {
            		dataRecord.setNextImpHosType(entity.getImpHosType());
            	} else {
            		dataRecord.setNextImpHosType(" ");
            	}
        	}

        	// 対象区分
        	if(entity.getHoInsType() != null && !entity.getHoInsType().isEmpty()) {
        		dataRecord.setHoInsType(entity.getHoInsType());
        	} else {
        		dataRecord.setHoInsType(" ");
        	}
        	if(entity.getNextHoInsType() != null && !entity.getNextHoInsType().isEmpty()) {
        		dataRecord.setNextHoInsType(entity.getNextHoInsType());
        	} else {
        		if(entity.getHoInsType() != null && !entity.getHoInsType().isEmpty()) {
            		dataRecord.setNextHoInsType(entity.getHoInsType());
            	} else {
            		dataRecord.setNextHoInsType(" ");
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
        	if(entity.getNextManageNm() != null && !entity.getNextManageNm().isEmpty()) {
        		dataRecord.setNextManageNm(entity.getNextManageNm());
        	} else {
        		if(entity.getManageNm() != null && !entity.getManageNm().isEmpty()) {
            		dataRecord.setNextManageNm(entity.getManageNm());
            	} else {
            		dataRecord.setNextManageNm(" ");
            	}
        	}


        	// ワクチン対象区分
        	if(entity.getVacInsType() != null && !entity.getVacInsType().isEmpty()) {
        		dataRecord.setVacInsType(entity.getVacInsType());
        	} else {
        		dataRecord.setVacInsType(" ");
        	}
        	if(entity.getNextVacInsType() != null && !entity.getNextVacInsType().isEmpty()) {
        		dataRecord.setNextVacInsType(entity.getNextVacInsType());
        	} else {
        		if(entity.getVacInsType() != null && !entity.getVacInsType().isEmpty()) {
            		dataRecord.setNextVacInsType(entity.getVacInsType());
            	} else {
            		dataRecord.setNextVacInsType(" ");
            	}
        	}

        	// ワクチン定訪先区分
        	if(entity.getVacVisitType() != null && !entity.getVacVisitType().isEmpty()) {
        		dataRecord.setVacVisitType(entity.getVacVisitType());
        	} else {
        		dataRecord.setVacVisitType(" ");
        	}
        	if(entity.getNextVacVisitType() != null && !entity.getNextVacVisitType().isEmpty()) {
        		dataRecord.setNextVacVisitType(entity.getNextVacVisitType());
        	} else {
        		if(entity.getVacVisitType() != null && !entity.getVacVisitType().isEmpty()) {
            		dataRecord.setNextVacVisitType(entity.getVacVisitType());
            	} else {
            		dataRecord.setNextVacVisitType(" ");
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

        	// 未審査申請数
        	if(entity.getNoShnCnt() != null) {
        		dataRecord.setNoShnCnt(entity.getNoShnCnt());
        	} else {
        		dataRecord.setNoShnCnt(0);
        	}

        	// 申請コメント
        	if(entity.getReqComment() != null && !entity.getReqComment().isEmpty()) {
        		dataRecord.setReqComment(entity.getReqComment());
        	} else {
        		dataRecord.setReqComment(" ");
        	}

        	// 承認・却下コメント
        	if(entity.getAprComment() != null && !entity.getAprComment().isEmpty()) {
        		dataRecord.setAprComment(entity.getAprComment());
        	} else if("0".equals(dataRecord.getWaitAppFlg())){
        		dataRecord.setAprComment(" ");
        	} else {
        		dataRecord.setAprComment("");
        	}

        	hcoReqDataList.add(dataRecord);
        }
        indto.setHcoReqDataList(hcoReqDataList);

        indto.setSrchFlg("1");

        // END UOC
       	return outdto;
	}

	public BaseDTO approve(NF401DTO indto) {
		BaseDTO outdto = indto;
		LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

		// DropDownList作成
        createCombo(indto);

		// 現在日付を取得
		Date systemDate = DateUtils.getNowDate();
		SimpleDateFormat fmtDateTime = new SimpleDateFormat("yyyyMMddHHmmss");
        String sysDateTime = fmtDateTime.format(systemDate);

		// 一括承認処理
		List<HcoReqDataList> hcoReqDataList = indto.getHcoReqDataList();
		List<String> inInsList = new ArrayList<String>();
		Map<String, String> aprComMap = new HashMap<String, String>();

		for(HcoReqDataList entity : hcoReqDataList) {
			if("1".equals(entity.getApprChk())) {
				inInsList.add(entity.getInsNo());

				if(!aprComMap.containsKey(entity.getInsNo())) {
					aprComMap.put(entity.getInsNo(), entity.getAprComment());
				}
			}
		}

		// 処理対象取得
		SelectNF401ReqDataEntity selectNF401ReqDataEntity = new SelectNF401ReqDataEntity();
		selectNF401ReqDataEntity.setInInsNoList(inInsList);
		List<SelectNF401ReqDataEntity> selectNF401ReqDataEntityList = dao.select(selectNF401ReqDataEntity);

		// 排他チェック
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
		Date srchSysDate = null;
		try {
			srchSysDate = fmtDate.parse(indto.getSrchSysDate());
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		for(SelectNF401ReqDataEntity entity : selectNF401ReqDataEntityList) {
			if(srchSysDate.before(entity.getUpdShaYmd())) {
				// 既に他のユーザーによってデータが処理されています。
				indto.setMsgStr(loginInfo.getMsgData(RdmConstantsData.E003));
				return outdto;
			}
		}

		// 一括承認処理
		for(SelectNF401ReqDataEntity entity : selectNF401ReqDataEntityList) {
			TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity("updateNF401Data");

			tRdmReqKnrEntity.setReqId(entity.getReqId());
			if("1".equals(entity.getReqChl()) || "2".equals(entity.getReqChl())) {
				tRdmReqKnrEntity.setReqStsCd("04");
			} else if("3".equals(entity.getReqChl())) {
				tRdmReqKnrEntity.setReqStsCd("14");
			}

			tRdmReqKnrEntity.setAprBrCode(indto.getLoginBrCd());
        	tRdmReqKnrEntity.setAprDistCode(indto.getLoginDistCd());
        	tRdmReqKnrEntity.setAprShz(indto.getLoginShzNm());
        	tRdmReqKnrEntity.setAprJgiNo(Integer.parseInt(indto.getLoginJgiNo()));
        	tRdmReqKnrEntity.setAprShaName(indto.getLoginNm());
        	tRdmReqKnrEntity.setAprYmdhms(sysDateTime);
        	tRdmReqKnrEntity.setAprComment(aprComMap.get(entity.getInsNo()));
        	tRdmReqKnrEntity.setFbReqFlg("1");
        	tRdmReqKnrEntity.setUpdShaYmd(systemDate);
			tRdmReqKnrEntity.setUpdShaId(indto.getLoginJgiNo());

			dao.update(tRdmReqKnrEntity);
		}

		outdto = search(indto);

		return outdto;
	}

	public BaseDTO reject(NF401DTO indto) {
		BaseDTO outdto = indto;
		LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

		// DropDownList作成
        createCombo(indto);

		// 現在日付を取得
		Date systemDate = DateUtils.getNowDate();
		SimpleDateFormat fmtDateTime = new SimpleDateFormat("yyyyMMddHHmmss");
        String sysDateTime = fmtDateTime.format(systemDate);

        // 処理対象取得
        SelectNF401ReqDataEntity selectNF401ReqDataEntity = new SelectNF401ReqDataEntity("selectNF401ReqData");
        selectNF401ReqDataEntity.setInInsNo(indto.getRejectInsNo());
 		List<SelectNF401ReqDataEntity> selectNF401ReqDataEntityList = dao.select(selectNF401ReqDataEntity);

 		// 排他チェック
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
		Date srchSysDate = null;
		try {
			srchSysDate = fmtDate.parse(indto.getSrchSysDate());
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		for(SelectNF401ReqDataEntity entity : selectNF401ReqDataEntityList) {
			if(srchSysDate.before(entity.getUpdShaYmd())) {
				// 既に他のユーザーによってデータが処理されています。
				indto.setMsgStr(loginInfo.getMsgData(RdmConstantsData.E003));
				return outdto;
			}
		}

		// 却下処理
		for(SelectNF401ReqDataEntity entity : selectNF401ReqDataEntityList) {
			TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity("updateNF401Data");

			tRdmReqKnrEntity.setReqId(entity.getReqId());
			if("1".equals(entity.getReqChl()) || "2".equals(entity.getReqChl())) {
				tRdmReqKnrEntity.setReqStsCd("02");
			} else if("3".equals(entity.getReqChl())) {
				tRdmReqKnrEntity.setReqStsCd("12");
			}

			tRdmReqKnrEntity.setAprBrCode(indto.getLoginBrCd());
        	tRdmReqKnrEntity.setAprDistCode(indto.getLoginDistCd());
        	tRdmReqKnrEntity.setAprShz(indto.getLoginShzNm());
        	tRdmReqKnrEntity.setAprJgiNo(Integer.parseInt(indto.getLoginJgiNo()));
        	tRdmReqKnrEntity.setAprShaName(indto.getLoginNm());
        	tRdmReqKnrEntity.setAprYmdhms(sysDateTime);
        	tRdmReqKnrEntity.setAprComment(indto.getRejectComment());
        	tRdmReqKnrEntity.setUpdShaYmd(systemDate);
			tRdmReqKnrEntity.setUpdShaId(indto.getLoginJgiNo());

			dao.update(tRdmReqKnrEntity);
		}

		outdto = search(indto);

		return outdto;
	}

    /**
     * コンボ作成
     * @param indto NF401DTO
     * @return なし
     * @customizable
     */
    private void createCombo(NF401DTO indto){
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
    }
}