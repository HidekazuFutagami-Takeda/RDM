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
import java.util.List;
import javax.inject.Named;
import java.util.LinkedHashMap;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.common.BeanUtil;
import jp.co.takeda.rdm.util.StringUtils;
import jp.co.takeda.rdm.entity.join.SelectCntSelectHcpEntity;
import jp.co.takeda.rdm.entity.join.SelectCntSelectNd401InitEntity;
import jp.co.takeda.rdm.entity.join.SelectHcpEntity;
import jp.co.takeda.rdm.entity.join.SelectHenkanListEntity;
import jp.co.takeda.rdm.entity.join.SelectNd401InitEntity;
import jp.co.takeda.rdm.entity.join.SelectParamNd001Entity;
import jp.co.takeda.rdm.entity.join.SelectParamNd401Entity;
import jp.co.takeda.rdm.entity.join.SelectParamSwitchEntity;
import jp.co.takeda.rdm.dto.HcpData;
import jp.co.takeda.rdm.dto.KmuIkkatsuData;
import jp.co.takeda.rdm.dto.ND001DTO;
import jp.co.takeda.rdm.dto.ND401DTO;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.DateUtils;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * Serviceクラス（ND101)
 * @generated
 */
@Named
public class ND401Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(ND401Service.class);

    /**
     * イベント処理
     * @param indto ND101DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(ND401DTO indto) {

    	BaseDTO outdto = indto;
    	//1-1 権限判定
        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

        //初期表示画面フラグ = 1(初期化)
        indto.setPageFlag("1");

        //ページNO
        indto.setPageCntCur(1);
        return outdto;
    }

    public BaseDTO search(ND401DTO indto) {
    	LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

		BaseDTO outdto = indto;
		SelectHcpEntity selectHcpEntity = new SelectHcpEntity();
		//1-4 件数定義取得
		SelectParamNd401Entity selectParamNd401Entity = new SelectParamNd401Entity();
		List<SelectParamNd401Entity> selectParamNd401List;
		selectParamNd401List = dao.select(selectParamNd401Entity);

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

		SelectCntSelectNd401InitEntity selectParamSelectKmuEntity = new SelectCntSelectNd401InitEntity();


        //検索条件
        //直書きは仮置き、検索部作成出来次第indtoから取得すること

        List<SelectCntSelectNd401InitEntity> selectParamSelectKmuList;
        selectParamSelectKmuList = dao.select(selectParamSelectKmuEntity);
        indto.setPageCnt(selectParamSelectKmuList.get(0).getCntKmu());
        indto.setMaxPageCnt(selectParamNd401List.get(0).getValue());

        if (checkSearchResults(loginInfo, indto, false)) {
        	return outdto;
        }

        //inEntityMainselectHcpEntity.setInOffset(indto.getLineCntStart() - 1);
        //inEntityMain.setInLimit(AppConstant.SHOW_COUNT);

    	//SelectCntHcpEntity selectCntHcpEntity = new SelectCntHcpEntity();
    	//SelectCntHcpEntity selectCntHcpList;
    	//selectCntHcpList = dao.select(selectCntHcpEntity);

        indto.initPageInfo(indto.getPageCntCur(), selectParamSelectKmuList.get(0).getCntKmu(), selectParamNd401List.get(1).getValue());

        //検索条件
        //entitiyから取得している箇所は仮置き、検索部作成出来次第indtoから取得すること


    	SelectNd401InitEntity selectNd401InitEntity = new SelectNd401InitEntity();

    	//offset limit設定
    	selectNd401InitEntity.setInOffset(indto.getLineCntStart() - 1);
    	selectNd401InitEntity.setInLimit(selectParamNd401List.get(1).getValue());

    	List<SelectNd401InitEntity> selectNd401InitList;
    	selectNd401InitList = dao.select(selectNd401InitEntity);

    	List<KmuIkkatsuData> kmuIkkatsuDataList = new ArrayList<KmuIkkatsuData>(selectNd401InitList.size());

    	for(SelectNd401InitEntity entity : selectNd401InitList) {
    		KmuIkkatsuData data = new KmuIkkatsuData();
            BeanUtil.copyProperties(data, entity);
            kmuIkkatsuDataList.add(data);
    	}

    	indto.setPageFlag("0");
    	indto.setKmuIkkatsuDataList(kmuIkkatsuDataList);
        return outdto;
	}


    /**
     * イベント処理
     * @param indto ND401DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO page(ND401DTO indto) {
        BaseDTO outdto = indto;
        // START UOC

        outdto = search(indto);

        // END UOC
        return outdto;
    }

	/*
	 * ６：範囲チェック　
	 * 検索結果件数
	 * エラーありならtrueとし、エラーメッセージをmsgStrにセットする
	 */
	private boolean checkSearchResults(LoginInfo loginInfo, ND401DTO indto, boolean fullchkFlg) {

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
