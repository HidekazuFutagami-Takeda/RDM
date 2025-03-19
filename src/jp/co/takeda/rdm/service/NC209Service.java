/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import java.util.LinkedHashMap;

import jp.co.takeda.rdm.entity.join.MRdmComCalUsrEntity;
import jp.co.takeda.rdm.entity.join.MRdmHcpShusshinkoEntity;
import jp.co.takeda.rdm.entity.join.MRdmParamMstEntity;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.common.BeanUtil;
import jp.co.takeda.rdm.entity.join.SelectHcpEntity;
import jp.co.takeda.rdm.entity.join.SelectCntSelectHcpEntity;
import jp.co.takeda.rdm.entity.join.SelectComboListEntity;
//import jp.co.takeda.rdm.entity.join.SelectParamNd001Entity;
import jp.co.takeda.rdm.entity.join.SelectParamSwitchEntity;
//import jp.co.takeda.rdm.entity.join.SelectNd001ComboListEntity;
//import jp.co.takeda.rdm.entity.join.SelectNd001ShusshinkoComboListEntity;
//import jp.co.takeda.rdm.entity.join.SelectNd001IkkComboListEntity;
import jp.co.takeda.rdm.entity.join.SelectHenkanListEntity;
import jp.co.takeda.rdm.entity.join.SelectNC209MainDataEntity;
import jp.co.takeda.rdm.dto.NC209DTO;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.dto.HcpData;
import jp.co.takeda.rdm.util.StringUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * Serviceクラス（NC209)
 * @generated
 */
@Named
public class NC209Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(NC209Service.class);

    /**
     * イベント処理
     * @param indto NC209DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(NC209DTO indto) {

    	BaseDTO outdto = indto;
//    	//1-1 権限判定
//        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

        //1-2 ドロップダウンリストの生成
        setCombo(indto);

        //初期表示画面フラグ = 1(初期化)
        indto.setPageFlg(1);

        //ページNO
        indto.setPageCntCur(1);

        //最大件数（エラーチェック用）をパラメータから取得
        if(indto.getMaxPageCnt() == null) {
        	MRdmParamMstEntity mRdmParamMstEntity = new MRdmParamMstEntity();
        	mRdmParamMstEntity.setParamName(RdmConstantsData.PARAM_NAME_MAX_ROWNUM);
        	mRdmParamMstEntity.setDelFlg("0");

        	List<MRdmParamMstEntity> mRdmParamMstEntityList = dao.selectByValue(mRdmParamMstEntity);
        	if(mRdmParamMstEntityList.size() > 0) {
        		String value = mRdmParamMstEntityList.get(0).getValue();
        		indto.setMaxPageCnt(Integer.parseInt(value));
        	}else {
        		indto.setMaxPageCnt(1000);
        	}
        }

        //1画面内の表示件数をパラメータから取得
        if(indto.getPageRowNum() == null) {
        	MRdmParamMstEntity mRdmParamMstEntity2 = new MRdmParamMstEntity();
        	mRdmParamMstEntity2.setParamName(RdmConstantsData.PARAM_NAME_NC209_ROWNUM);
        	mRdmParamMstEntity2.setDelFlg("0");

        	List<MRdmParamMstEntity> mRdmParamMstEntityList2 = dao.selectByValue(mRdmParamMstEntity2);
        	if(mRdmParamMstEntityList2.size() > 0) {
        		String value = mRdmParamMstEntityList2.get(0).getValue();
        		indto.setPageRowNum(Integer.parseInt(value));
        	}else {
               	mRdmParamMstEntity2.setParamName(RdmConstantsData.PARAM_NAME_PAGE_ROWNUM);
               	mRdmParamMstEntityList2 = dao.selectByValue(mRdmParamMstEntity2);
            	if(mRdmParamMstEntityList2.size() > 0) {
            		String value = mRdmParamMstEntityList2.get(0).getValue();
            		indto.setPageRowNum(Integer.parseInt(value));
            	}else {
            		indto.setPageRowNum(100);
            	}
        	}
        }
        return outdto;
    }


    public BaseDTO search(NC209DTO indto) {
    	LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
    	setCombo(indto);
		BaseDTO outdto = indto;
		SelectHcpEntity selectHcpEntity = new SelectHcpEntity();

        //検索文字列変換
        //入力文字列退避
        String tempSearchDocName = indto.getSearchDocName();
        String tempSearchDocKana = indto.getSearchDocKana();
        //nullでない場合、文字列変換
        if(!(indto.getSearchDocName().isEmpty())) {
        	SelectHenkanListEntity kanjiHenkan = new SelectHenkanListEntity("漢字変換");
        	kanjiHenkan.setSearchHenkan(indto.getSearchDocName());
        	List<SelectHenkanListEntity> selectKnaji = dao.select(kanjiHenkan);
        	    indto.setSearchDocName(selectKnaji.get(0).getSearchHenkan());
        	    indto.setSearchDocName(indto.getSearchDocName().replace("　",""));
        }
        if(!(indto.getSearchDocKana().isEmpty())) {
        	SelectHenkanListEntity haifunHenkan = new SelectHenkanListEntity("ハイフン変換");
        	haifunHenkan.setSearchHenkan(indto.getSearchDocKana());
        	List<SelectHenkanListEntity> selectHaifun = dao.select(haifunHenkan);
        	indto.setSearchDocKana(selectHaifun.get(0).getSearchHenkan());

        	SelectHenkanListEntity hankakuHenkan = new SelectHenkanListEntity("半角変換");
        	hankakuHenkan.setSearchHenkan(indto.getSearchDocKana());
        	List<SelectHenkanListEntity> selectHankaku = dao.select(hankakuHenkan);
        	indto.setSearchDocKana(selectHankaku.get(0).getSearchHenkan());
        	indto.setSearchDocKana(indto.getSearchDocKana().replace(" ",""));
        }

        //検索条件
		SelectNC209MainDataEntity paramEntity = new SelectNC209MainDataEntity();

        paramEntity.setInSosCd(StringUtils.setEmptyToNull(indto.getSearchSosCd()));
        if(indto.getSearchTantoCd() != null) {
        	paramEntity.setInJgiNo(StringUtils.setEmptyToNull(Integer.toString(indto.getSearchTantoCd())));
        }
        paramEntity.setInKanjiSrch(StringUtils.setEmptyToNull(indto.getSearchDocName()));
        paramEntity.setInKanaSrch(StringUtils.setEmptyToNull(indto.getSearchDocKana()));
        paramEntity.setInDocType(StringUtils.setEmptyToNull(indto.getSearchDocType()));
        paramEntity.setInDocNo(StringUtils.setEmptyToNull(indto.getSearchDocNo()));
        paramEntity.setInDocAttribute(StringUtils.setEmptyToNull(indto.getSearchDocAttribute()));
        paramEntity.setInMedSch(StringUtils.setEmptyToNull(indto.getSearchMedSch()));
        paramEntity.setInGradYear(StringUtils.setEmptyToNull(indto.getSearchGradYear()));
        paramEntity.setInHUniv(StringUtils.setEmptyToNull(indto.getSearchHUniv()));
        paramEntity.setInInsNo(StringUtils.setEmptyToNull(indto.getSearchInsNo()));
        paramEntity.setInDeptCode(StringUtils.setEmptyToNull(indto.getSearchDeptCd()));

        if (checkInput(loginInfo, indto, paramEntity ,false)) {
        	return outdto;
        }

        //入力_SELECT区分:0、件数が取得
        paramEntity.setInSelectKbn(0);

		List<SelectNC209MainDataEntity> mainCntEntityList = dao.select(paramEntity);

		//件数なので必ず1レコード取得される
        indto.setPageCnt(mainCntEntityList.get(0).getCntRow());

        //最大件数エラーチェック
        if (checkSearchResults(loginInfo, indto, false)) {
        	return outdto;
        }

        //共通　明細行番号(開始)を生成
        indto.initPageInfo(indto.getPageCntCur(), indto.getPageCnt(), indto.getPageRowNum());

        //検索条件（データ部追加条件）
        //入力_SELECT区分:1、データが取得
        paramEntity.setInSelectKbn(1);
        paramEntity.setInOffset(indto.getLineCntStart() - 1);//現ページのオフセット値
        paramEntity.setInLimit(indto.getPageRowNum());//1ページ件数
        paramEntity.setInSortId(indto.getSortCondition());
        String workSortCondition = indto.getSortCondition();


        List<SelectNC209MainDataEntity> mainDataEntityList = dao.select(paramEntity);
		List<HcpData> hcpDataList = new ArrayList<HcpData>(mainDataEntityList.size());
        for (SelectNC209MainDataEntity entity : mainDataEntityList) {
        	HcpData data = new HcpData();
            BeanUtil.copyProperties(data, entity);
            if (entity.getInsName() != null) {
            	data.setInsName(entity.getInsName());
//                data.setInsName(StringUtils.replaceString(entity.getInsName(), "CHR(13)", "CHR(13)"));
            }

            hcpDataList.add(data);
        }

        indto.setHcpDataList(hcpDataList);
		indto.setPageFlg(0);
		indto.setSortCondition(workSortCondition);
		//退避した検索文字をDTOにセット
		indto.setSearchDocName(tempSearchDocName);
		indto.setSearchDocKana(tempSearchDocKana);
		return outdto;
	}

    /**
     * イベント処理
     * @param indto NC209DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO page(NC209DTO indto) {
        BaseDTO outdto = indto;
        // START UOC

        outdto = search(indto);

        // END UOC
        return outdto;
    }

    /**
     * イベント処理
     * @param indto NC209DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO sort(NC209DTO indto) {
        BaseDTO outdto = indto;
        // START UOC

        outdto = search(indto);

        // END UOC
        return outdto;
    }

    public void setCombo(NC209DTO indto) {
//    	LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
//    	indto.setMrAdminFlg(loginInfo.getJokenFlg());
//    	if (RdmConstantsData.RDM_JKN_MR.equals(loginInfo.getJokenSetCd())) {//MRの場合　※不要なら消すこと
//    		if(StringUtils.isEmpty(indto.getSearchSosNm()) && StringUtils.isEmpty(indto.getSearchTantoNm())) {
//    			//組織、担当者がいずれも未設定
//    			indto.setSearchSosCd(loginInfo.getSosCd());
//    			indto.setSearchSosNm(loginInfo.getBumonRyakuName());
//    			indto.setSearchSosRank(loginInfo.getBumonRank());
//    			indto.setSearchTantoCd(loginInfo.getJgiNo());
//    			indto.setSearchTantoNm(loginInfo.getJgiName());
//    		}
//    	}

        //1-2 ドロップダウンリストの生成
        //医師／薬剤師区分
		SelectComboListEntity inEntityCmb = new SelectComboListEntity();
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_DOC_TYPE);
		List<SelectComboListEntity> outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapDocType = new LinkedHashMap<String, String>();
		mapDocType.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapDocType.put(outEntity.getValue(), outEntity.getValue() + ":" + outEntity.getValueKanji());
		}
		indto.setSearchDocTypeCombo(mapDocType);


        //医師属性
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_DOC_ATTRIBUTE);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
        LinkedHashMap<String, String> mapDocAttribute = new LinkedHashMap<String, String>();
        mapDocAttribute.put(null, "--なし--");
        for (SelectComboListEntity outEntity : outMainList) {
        	mapDocAttribute.put(outEntity.getValue(),outEntity.getValueKanji());
        }
        indto.setSearchDocAttributeCombo(mapDocAttribute);

        //出身校
		MRdmHcpShusshinkoEntity inEntitySskCmb = new MRdmHcpShusshinkoEntity();
		inEntitySskCmb.setUnivFlg(1);
		inEntitySskCmb.setDelFlg(0);
		List<MRdmHcpShusshinkoEntity> outMainSskList = dao.selectByValue(inEntitySskCmb);
		LinkedHashMap<String, String> mapMedSchoolCd = new LinkedHashMap<String, String>();
		mapMedSchoolCd.put("", "--なし--");
		for (MRdmHcpShusshinkoEntity outEntity : outMainSskList) {
			mapMedSchoolCd.put(outEntity.getUnivCode(), outEntity.getUnivKj());
		}
        indto.setSearchMedSchCombo(mapMedSchoolCd);

        //卒年
		MRdmComCalUsrEntity inEntityYearCmb = new MRdmComCalUsrEntity();
		inEntityYearCmb.setToday("1");
		MRdmComCalUsrEntity outCalUsr = dao.selectByValue(inEntityYearCmb).get(0);
		int yearInt = Integer.parseInt(outCalUsr.getCalYear());
		LinkedHashMap<String, String> mapYear = new LinkedHashMap<String, String>();
		mapYear.put("", "");
		for (int i = 0; i < 101; i++) {
			String yearStr = Integer.toString(yearInt + 1 - i);
			mapYear.put(yearStr, yearStr);
		}
        indto.setSearchGradYearCombo(mapYear);

        //出身医局校
		inEntitySskCmb.setUnivIkkFlg(1);
		inEntitySskCmb.setDelFlg(0);
		outMainSskList.clear();
		outMainSskList = dao.selectByValue(inEntitySskCmb);
		LinkedHashMap<String, String> mapHomeUnivCd = new LinkedHashMap<String, String>();
		mapHomeUnivCd.put("", "--なし--");
		for (MRdmHcpShusshinkoEntity outEntity : outMainSskList) {
			mapHomeUnivCd.put(outEntity.getUnivCode(), outEntity.getUnivKj());
		}
        indto.setSearchHUnivCombo(mapHomeUnivCd);

    }

	/*
	 * １：必須入力チェック
	 * エラーありならtrueとし、エラーメッセージをmsgStrにセットする
	 */
	private boolean checkInput(LoginInfo loginInfo, NC209DTO indto, SelectNC209MainDataEntity paramEntity, boolean fullchkFlg) {

		boolean errChk = false;
		String msgStr = "";
		String tmpMsgStr = "";

        if (    StringUtils.isEmpty(paramEntity.getInKanjiSrch())    &&
        		StringUtils.isEmpty(paramEntity.getInKanaSrch())     &&
        		StringUtils.isEmpty(paramEntity.getInDocType())      &&
        		StringUtils.isEmpty(paramEntity.getInDocNo())        &&
        		StringUtils.isEmpty(paramEntity.getInDocAttribute()) &&
        		StringUtils.isEmpty(paramEntity.getInMedSch())       &&
        		StringUtils.isEmpty(paramEntity.getInGradYear())     &&
        		StringUtils.isEmpty(paramEntity.getInHUniv())        &&
        		StringUtils.isEmpty(paramEntity.getInGmnBumonRank()) &&
        		StringUtils.isEmpty(paramEntity.getInGmnSosCd())     &&
        		StringUtils.isEmpty(paramEntity.getInGmnJgiNo())     &&
        		StringUtils.isEmpty(paramEntity.getInGmnBrCode())    &&
        		StringUtils.isEmpty(paramEntity.getInGmnDistCode())  &&
        		StringUtils.isEmpty(paramEntity.getInInsNo())        &&
        		StringUtils.isEmpty(paramEntity.getInDeptCode())
        		) {
			errChk = true;
			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W001);// 検索条件を入力してください。
			msgStr = msgStr + tmpMsgStr + "\n";

        }
		if (errChk) {// エラーありなのでメッセージをセットする
			indto.setMsgStr(msgStr);
		}
        return errChk;
	}
	/*
	 * ６：範囲チェック　
	 * 検索結果件数
	 * エラーありならtrueとし、エラーメッセージをmsgStrにセットする
	 */
	private boolean checkSearchResults(LoginInfo loginInfo, NC209DTO indto, boolean fullchkFlg) {

		boolean errChk = false;
		String msgStr = "";
		String tmpMsgStr = "";

		//６：範囲チェック　
		//検索結果件数
		int pageCnt = 0;
		int maxPageCnt = 0;
		pageCnt = indto.getPageCnt();
		maxPageCnt = indto.getMaxPageCnt();
		if (pageCnt > maxPageCnt) {
			errChk = true;
			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W002);// 検索結果が表示上限を超えています。検索条件を絞って再検索してください。
			msgStr = msgStr + tmpMsgStr + "\n";
		}
		if (errChk) {// エラーありなのでメッセージをセットする
			indto.setMsgStr(msgStr);
		}
		return errChk;
	}

}
