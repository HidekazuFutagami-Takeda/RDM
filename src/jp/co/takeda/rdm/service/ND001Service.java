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

import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.common.BeanUtil;
import jp.co.takeda.rdm.entity.join.SelectHcpEntity;
import jp.co.takeda.rdm.entity.join.SelectCntSelectHcpEntity;
import jp.co.takeda.rdm.entity.join.SelectParamNd001Entity;
import jp.co.takeda.rdm.entity.join.SelectParamSwitchEntity;
import jp.co.takeda.rdm.entity.join.SelectNd001ComboListEntity;
import jp.co.takeda.rdm.entity.join.SelectNd001ShusshinkoComboListEntity;
import jp.co.takeda.rdm.entity.join.SelectNd001IkkComboListEntity;
import jp.co.takeda.rdm.entity.join.SelectHenkanListEntity;

import jp.co.takeda.rdm.dto.ND001DTO;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.dto.HcpData;
import jp.co.takeda.rdm.util.StringUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * Serviceクラス（ND001)
 * @generated
 */
@Named
public class ND001Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(ND001Service.class);

    /**
     * イベント処理
     * @param indto ND001DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(ND001DTO indto) {

    	BaseDTO outdto = indto;
    	//1-1 権限判定
        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

        //ドロップダウン用に組織名、担当者名を取得する
        setCombo(indto);



        //1-2 ドロップダウンリストの生成
        //未作成
        //初期表示画面フラグ = 1(初期化)
        indto.setPageFlag("1");


        //ページNO
        indto.setPageCntCur(1);

        return outdto;
    }


    public BaseDTO search(ND001DTO indto) {
    	LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
    	setCombo(indto);
		BaseDTO outdto = indto;
		SelectHcpEntity selectHcpEntity = new SelectHcpEntity();
		//1-4 件数定義取得
		SelectParamNd001Entity selectParamNd001Entity = new SelectParamNd001Entity();
		List<SelectParamNd001Entity> selectParamNd001List;
		selectParamNd001List = dao.select(selectParamNd001Entity);

		//1-5 機能定義取得
		SelectParamSwitchEntity selectParamSwitchEntity =new SelectParamSwitchEntity();
		//MN_DOC
		selectParamSwitchEntity.setInParamName(1);
		List<SelectParamSwitchEntity> selectParamSwitchIshiList;
		selectParamSwitchIshiList = dao.select(selectParamSwitchEntity);

		String ishiSinkiFlg = selectParamSwitchIshiList.get(0).getShinkiFlg();
		String ishiHenshuFlg = selectParamSwitchIshiList.get(0).getHenshuFlg();
		String ishiSakujoFlg = selectParamSwitchIshiList.get(0).getSakujoFlg();
		String ishiFukkatsuFlg = selectParamSwitchIshiList.get(0).getFukkatsuFlg();
        //MN_KMU
		selectParamSwitchEntity.setInParamName(2);
		List<SelectParamSwitchEntity> selectParamSwitchIshiKinmuList;
		selectParamSwitchIshiKinmuList = dao.select(selectParamSwitchEntity);
		String ishiKinmuSinkiFlg = selectParamSwitchIshiKinmuList.get(0).getShinkiFlg();
		String ishiKinmuHenshuFlg = selectParamSwitchIshiKinmuList.get(0).getHenshuFlg();
		String ishiKinmuSakujoFlg = selectParamSwitchIshiKinmuList.get(0).getSakujoFlg();

		String ishiKinmuSwitchFlg = null;

		if ((ishiKinmuSinkiFlg.equals("1")) || (ishiKinmuHenshuFlg.equals("1")) || (ishiKinmuSakujoFlg.equals("1"))) {
			ishiKinmuSwitchFlg = "1";
		}else {
			ishiKinmuSwitchFlg = "0";
		}

        SelectCntSelectHcpEntity selectParamSelectHcpEntity = new SelectCntSelectHcpEntity();

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
        //直書きは仮置き、検索部作成出来次第indtoから取得すること
        selectParamSelectHcpEntity.setInSosCd("00127");
        selectParamSelectHcpEntity.setInJgiNo("8830034");
        selectParamSelectHcpEntity.setInKanjiSrch(StringUtils.setEmptyToNull(indto.getSearchDocName()));
        selectParamSelectHcpEntity.setInKanaSrch(StringUtils.setEmptyToNull(indto.getSearchDocKana()));
        selectParamSelectHcpEntity.setInDocType(StringUtils.setEmptyToNull(indto.getSearchDocType()));
        selectParamSelectHcpEntity.setInDocNo(StringUtils.setEmptyToNull(indto.getSearchDocNo()));
        selectParamSelectHcpEntity.setInDcfIshiCd(StringUtils.setEmptyToNull(indto.getSearchDcfIshiCd()));
//        selectParamSelectHcpEntity.setInDcfIshiCd("01133869");
        selectParamSelectHcpEntity.setInDocAttribute(StringUtils.setEmptyToNull(indto.getSearchDocAttribute()));
        selectParamSelectHcpEntity.setInMedSch(StringUtils.setEmptyToNull(indto.getSearchMedSch()));
        selectParamSelectHcpEntity.setInGradYear(StringUtils.setEmptyToNull(indto.getSearchGradYear()));
        selectParamSelectHcpEntity.setInHUniv(StringUtils.setEmptyToNull(indto.getSearchHUniv()));
        selectParamSelectHcpEntity.setInSetsuzoku(StringUtils.setEmptyToNull(indto.getSearchSetsuzoku()));
//        selectParamSelectHcpEntity.setInGmnBumonRank("3");
//        selectParamSelectHcpEntity.setInGmnSosCd("05474");
//        selectParamSelectHcpEntity.setInGmnBrCode("582");
//        selectParamSelectHcpEntity.setInGmnDistCode("040");
//        selectParamSelectHcpEntity.setInGmnJgiNo("3071200");
        selectParamSelectHcpEntity.setInInsNo(StringUtils.setEmptyToNull(indto.getSearchInsNo()));
//        selectParamSelectHcpEntity.setInDeptCode("0900");
        selectParamSelectHcpEntity.setInSortId(indto.getSortCondition());

        String workSortCondition = indto.getSortCondition();


        if (checkInput(loginInfo, indto, selectParamSelectHcpEntity ,false)) {
        	return outdto;
        }

        List<SelectCntSelectHcpEntity> selectParamSelectHcpList;
        selectParamSelectHcpList = dao.select(selectParamSelectHcpEntity);
        indto.setPageCnt(selectParamSelectHcpList.get(0).getCntHcp());
        indto.setMaxPageCnt(selectParamNd001List.get(0).getValue());

        if (checkSearchResults(loginInfo, indto, false)) {
        	return outdto;
        }

        //inEntityMainselectHcpEntity.setInOffset(indto.getLineCntStart() - 1);
        //inEntityMain.setInLimit(AppConstant.SHOW_COUNT);

    	//SelectCntHcpEntity selectCntHcpEntity = new SelectCntHcpEntity();
    	//SelectCntHcpEntity selectCntHcpList;
    	//selectCntHcpList = dao.select(selectCntHcpEntity);

        indto.initPageInfo(indto.getPageCntCur(), selectParamSelectHcpList.get(0).getCntHcp(), selectParamNd001List.get(1).getValue());

        //検索条件
        //entitiyから取得している箇所は仮置き、検索部作成出来次第indtoから取得すること
        selectHcpEntity.setInOffset(indto.getLineCntStart() - 1);
        selectHcpEntity.setInLimit(selectParamNd001List.get(1).getValue());

        selectHcpEntity.setInSosCd(selectParamSelectHcpEntity.getInSosCd());
        selectHcpEntity.setInJgiNo(selectParamSelectHcpEntity.getInJgiNo());
        selectHcpEntity.setInKanjiSrch(selectParamSelectHcpEntity.getInKanjiSrch());
        selectHcpEntity.setInKanaSrch(selectParamSelectHcpEntity.getInKanaSrch());
        selectHcpEntity.setInDocType(selectParamSelectHcpEntity.getInDocType());
        selectHcpEntity.setInDocNo(selectParamSelectHcpEntity.getInDocNo());
        selectHcpEntity.setInDcfIshiCd(selectParamSelectHcpEntity.getInDcfIshiCd());
        selectHcpEntity.setInDocAttribute(selectParamSelectHcpEntity.getInDocAttribute());
        selectHcpEntity.setInMedSch(selectParamSelectHcpEntity.getInMedSch());
        selectHcpEntity.setInGradYear(selectParamSelectHcpEntity.getInGradYear());
        selectHcpEntity.setInHUniv(null);
        selectHcpEntity.setInSetsuzoku(selectParamSelectHcpEntity.getInSetsuzoku());
        selectHcpEntity.setInGmnBumonRank(selectParamSelectHcpEntity.getInGmnBumonRank());
        selectHcpEntity.setInGmnSosCd(selectParamSelectHcpEntity.getInGmnSosCd());
        selectHcpEntity.setInGmnBrCode(selectParamSelectHcpEntity.getInGmnBrCode());
        selectHcpEntity.setInGmnDistCode(selectParamSelectHcpEntity.getInGmnDistCode());
        selectHcpEntity.setInGmnJgiNo(selectParamSelectHcpEntity.getInGmnJgiNo());
        selectHcpEntity.setInInsNo(selectParamSelectHcpEntity.getInInsNo());
        selectHcpEntity.setInSortId(selectParamSelectHcpEntity.getInSortId());





		List<SelectHcpEntity> selectHcpList = dao.select(selectHcpEntity);
		List<HcpData> hcpDataList = new ArrayList<HcpData>(selectHcpList.size());
        for (SelectHcpEntity entity : selectHcpList) {
        	HcpData data = new HcpData();
            BeanUtil.copyProperties(data, entity);
            if (entity.getInsName() != null) {
            	data.setInsName(entity.getInsName());
//                data.setInsName(StringUtils.replaceString(entity.getInsName(), "CHR(13)", "CHR(13)"));
            }
            if (entity.getUltInsName() != null) {
//                data.setUltInsName(StringUtils.replaceString(entity.getUltInsName(), "CHR(13)", "CHR(13)"));
            	data.setUltInsName(entity.getUltInsName());
			}

			// アクションボタンフラグ設定
			// 新規
			if (entity.getShinkiFlg().equals(ishiSinkiFlg)) {
				data.setGamenShinkiFlg("1");
			} else {
				data.setGamenShinkiFlg("0");
			}

			// 編集
			if (entity.getHenshuFlg().equals(ishiHenshuFlg)) {
				data.setGamenKoushinFlg("1");
			} else {
				data.setGamenKoushinFlg("0");
			}

			// 復活
			if (entity.getFukkatsuFlg().equals(ishiFukkatsuFlg)) {
				data.setGamenFukkatsuFlg("1");
			} else {
				data.setGamenFukkatsuFlg("0");
			}
			// 勤務先更新
			if (entity.getHenshuFlg().equals(ishiKinmuSwitchFlg)) {
				data.setGamenKinmuKoushinFlg("1");
			} else {
				data.setGamenKinmuKoushinFlg("0");
			}

			//MR権限の場合
			//もしMR新規判定フラグ、MR更新判定フラグが1でなかった場合は
			//ボタン判定用フラグに0をセット（非活性に）する
			if(indto.getMrAdminFlg().equals("0")) {
				if(!(data.getGamenShinkiFlg().equals(entity.getMrShinkiFlg()))) {
					data.setGamenShinkiFlg("0");
				}

				if(!(data.getGamenKoushinFlg().equals(entity.getMrKoushinFlg()))) {
					data.setGamenKoushinFlg("0");
				}

				if(!(data.getGamenFukkatsuFlg().equals(entity.getMrKoushinFlg()))) {
					data.setGamenFukkatsuFlg("0");
				}

				if(!(data.getGamenKinmuKoushinFlg().equals(entity.getMrKoushinFlg()))) {
					data.setGamenKinmuKoushinFlg("0");
				}
			}

            hcpDataList.add(data);
        }


        indto.setHcpDataList(hcpDataList);
		indto.setPageFlag("0");
		indto.setSortCondition(workSortCondition);
		//退避した検索文字をDTOにセット
		indto.setSearchDocName(tempSearchDocName);
		indto.setSearchDocKana(tempSearchDocKana);
		return outdto;
	}

    /**
     * イベント処理
     * @param indto ND001DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO page(ND001DTO indto) {
        BaseDTO outdto = indto;
        // START UOC

        outdto = search(indto);

        // END UOC
        return outdto;
    }

    /**
     * イベント処理
     * @param indto ND001DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO sort(ND001DTO indto) {
        BaseDTO outdto = indto;
        // START UOC

        outdto = search(indto);

        // END UOC
        return outdto;
    }

    public void setCombo(ND001DTO indto) {
    	LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
    	indto.setMrAdminFlg(loginInfo.getJokenFlg());
    	if (indto.getMrAdminFlg().equals("0")) {
    		indto.setBumonSeiName(loginInfo.getBumonRyakuName());
    		indto.setJgiName(loginInfo.getJgiName());
    	}

        //1-2 ドロップダウンリストの生成
        //医師／薬剤師区分
        SelectNd001ComboListEntity selectNd001ComboListEntity = new SelectNd001ComboListEntity();
        List<SelectNd001ComboListEntity> selectNd001ComboList;
        selectNd001ComboListEntity.setInDataKbn("DOC_TYPE");
        selectNd001ComboList = dao.select(selectNd001ComboListEntity);
        LinkedHashMap<String, String> mapDocType = new LinkedHashMap<String, String>();
        mapDocType.put(null, "--なし--");
        for (SelectNd001ComboListEntity outEntity : selectNd001ComboList) {
        	mapDocType.put(outEntity.getValue1(),outEntity.getValue1Kanj());
        }
        indto.setSearchDocTypeCombo(mapDocType);

        //医師属性
        SelectNd001ComboListEntity selectNd001ComboList2Entity = new SelectNd001ComboListEntity();
        List<SelectNd001ComboListEntity> selectNd001ComboList2;
        selectNd001ComboList2Entity.setInDataKbn("DOC_ATTRIBUTE");
        selectNd001ComboList2 = dao.select(selectNd001ComboList2Entity);
        LinkedHashMap<String, String> mapDocAttribute = new LinkedHashMap<String, String>();
        mapDocAttribute.put(null, "--なし--");
        for (SelectNd001ComboListEntity outEntity : selectNd001ComboList2) {
        	mapDocAttribute.put(outEntity.getValue1(),outEntity.getValue1Kanj());
        }
        indto.setSearchDocAttributeCombo(mapDocAttribute);

        //出身校
        SelectNd001ShusshinkoComboListEntity selectNd001ShussinkoComboListEntity = new SelectNd001ShusshinkoComboListEntity();
        List<SelectNd001ShusshinkoComboListEntity> selectNd001ShussinkoComboList;
        selectNd001ShussinkoComboList = dao.select(selectNd001ShussinkoComboListEntity);
        LinkedHashMap<String, String> mapMedSch = new LinkedHashMap<String, String>();
        mapMedSch.put(null, "--なし--");
        for (SelectNd001ShusshinkoComboListEntity outEntity : selectNd001ShussinkoComboList) {
        	mapMedSch.put(outEntity.getUnivCode(), outEntity.getUnivKj());
        }
        indto.setSearchMedSchCombo(mapMedSch);

        //卒年
		MRdmComCalUsrEntity inEntityYearCmb = new MRdmComCalUsrEntity();
		inEntityYearCmb.setToday("1");
		MRdmComCalUsrEntity outCalUsr = dao.selectByValue(inEntityYearCmb).get(0);
        LinkedHashMap<String, String> mapGradYear = new LinkedHashMap<String, String>();
        mapGradYear.put(null, "");
        Integer thisYear = Integer.parseInt(outCalUsr.getCalYear());
        Integer futureYear = thisYear + 1;
        String futureYearString = Integer.toString(futureYear);
        mapGradYear.put(futureYearString,futureYearString);
        mapGradYear.put(outCalUsr.getCalYear(),outCalUsr.getCalYear());
        for (int i = 1; i < 101; i++){
            Integer year = Integer.parseInt(outCalUsr.getCalYear()) - i;
            String yearString = Integer.toString(year);
            mapGradYear.put(yearString, yearString);
        }
        indto.setSearchGradYearCombo(mapGradYear);


        //出身医局校
        SelectNd001IkkComboListEntity selectNd001IkkComboListEntity = new SelectNd001IkkComboListEntity();
        List<SelectNd001IkkComboListEntity> selectNd001IkkComboList;
        selectNd001IkkComboList = dao.select(selectNd001IkkComboListEntity);
        LinkedHashMap<String, String> mapHUniv = new LinkedHashMap<String, String>();
        mapHUniv.put(null, "--なし--");
        for (SelectNd001IkkComboListEntity outEntity : selectNd001IkkComboList) {
        	mapHUniv.put(outEntity.getUnivCode(), outEntity.getUnivKj());
        }
        indto.setSearchHUnivCombo(mapHUniv);

        //ULT接続
        LinkedHashMap<String, String> mapSetsuzoku = new LinkedHashMap<String, String>();
        mapSetsuzoku.put(null, "--なし--");
        mapSetsuzoku.put("0", "武田情報のみ（ULT医師情報なし）");
        mapSetsuzoku.put("1", "ULT情報のみ（武田医師情報なし）");
        mapSetsuzoku.put("2", "武田-ULT接続済み");
        indto.setSearchSetsuzokuCombo(mapSetsuzoku);


    }

	/*
	 * １：必須入力チェック
	 * エラーありならtrueとし、エラーメッセージをmsgStrにセットする
	 */
	private boolean checkInput(LoginInfo loginInfo, ND001DTO indto, SelectCntSelectHcpEntity selectParamSelectHcpEntity, boolean fullchkFlg) {

		boolean errChk = false;
		String msgStr = "";
		String tmpMsgStr = "";

        if (    StringUtils.isEmpty(selectParamSelectHcpEntity.getInKanjiSrch())    &&
        		StringUtils.isEmpty(selectParamSelectHcpEntity.getInKanaSrch())     &&
        		StringUtils.isEmpty(selectParamSelectHcpEntity.getInDocType())      &&
        		StringUtils.isEmpty(selectParamSelectHcpEntity.getInDocNo())        &&
        		StringUtils.isEmpty(selectParamSelectHcpEntity.getInDcfIshiCd())    &&
        		StringUtils.isEmpty(selectParamSelectHcpEntity.getInDocAttribute()) &&
        		StringUtils.isEmpty(selectParamSelectHcpEntity.getInMedSch())       &&
        		StringUtils.isEmpty(selectParamSelectHcpEntity.getInGradYear())     &&
        		StringUtils.isEmpty(selectParamSelectHcpEntity.getInHUniv())        &&
        		StringUtils.isEmpty(selectParamSelectHcpEntity.getInSetsuzoku())    &&
        		StringUtils.isEmpty(selectParamSelectHcpEntity.getInGmnBumonRank()) &&
        		StringUtils.isEmpty(selectParamSelectHcpEntity.getInGmnSosCd())     &&
        		StringUtils.isEmpty(selectParamSelectHcpEntity.getInGmnJgiNo())     &&
        		StringUtils.isEmpty(selectParamSelectHcpEntity.getInGmnBrCode())    &&
        		StringUtils.isEmpty(selectParamSelectHcpEntity.getInGmnDistCode())  &&
        		StringUtils.isEmpty(selectParamSelectHcpEntity.getInInsNo())        &&
        		StringUtils.isEmpty(selectParamSelectHcpEntity.getInDeptCode())
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
	private boolean checkSearchResults(LoginInfo loginInfo, ND001DTO indto, boolean fullchkFlg) {

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
