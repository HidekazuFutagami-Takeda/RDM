/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

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
import jp.co.takeda.rdm.dto.HcoReqDataList;
import jp.co.takeda.rdm.dto.HcoSearchDataList;
import jp.co.takeda.rdm.dto.NF401DTO;
import jp.co.takeda.rdm.entity.join.MRdmParamMstEntity;
import jp.co.takeda.rdm.entity.join.SelectComboListEntity;
import jp.co.takeda.rdm.entity.join.SelectHenkanListEntity;
import jp.co.takeda.rdm.entity.join.SelectNF001MainDataEntity;
import jp.co.takeda.rdm.entity.join.SelectNF401MainDataEntity;
import jp.co.takeda.rdm.entity.join.SelectParamNF401Entity;
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
    	if(mnFac.equals("1") && mnNt.equals("1")) {
			indto.setBtnEnableFlg("1");
		} else {
			indto.setBtnEnableFlg("0");
		}

        // END UOC
        return outdto;

    }

	public BaseDTO search(NF401DTO indto) {
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
/*
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
  		if("on".equals(indto.getShnFlgChk())) {
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

        // 一覧を取得する
        List<SelectNF401MainDataEntity> selectNF401MainDataEntityList = dao.select(selectNF401MainDataEntity);

        for (SelectNF401MainDataEntity entity : selectNF401MainDataEntityList) {
        	HcoReqDataList dataRecord = new HcoReqDataList();

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


        	// ベッド数計
        	if(entity.getBedsTot() != null && !entity.getBedsTot().isEmpty()) {
        		dataRecord.setBedsTot(entity.getBedsTot());
        	} else {
        		dataRecord.setBedsTot(" ");
        	}

        	hcoReqDataList.add(dataRecord);
        }
        indto.setHcoReqDataList(hcoReqDataList);
*/
        indto.setSrchFlg("1");

        // END UOC
       	return outdto;
	}

    /**
     * イベント処理
     * @param indto NF401DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO page(NF401DTO indto) {
        BaseDTO outdto = indto;
        // START UOC

        outdto = search(indto);

        // END UOC
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