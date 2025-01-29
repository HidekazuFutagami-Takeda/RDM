/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.jkr.service;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import jp.co.takeda.jkr.common.BaseDTO;
import jp.co.takeda.jkr.common.BaseInfoHolder;
import jp.co.takeda.jkr.common.BaseService;
import jp.co.takeda.jkr.common.BeanUtil;
import jp.co.takeda.jkr.common.LoginInfo;
import jp.co.takeda.jkr.dto.ND001DTO;
import jp.co.takeda.jkr.entity.SRdmMParamMstEntity;
import jp.co.takeda.rdm.entity.SRdmMJgiJokenEntity;
import jp.co.takeda.rdm.exception.UnauthorizedException;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;

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
        // START UOC

        //ログインユーザ情報取得
        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

        //*****************************************************************************
        //*
        //* データの初期化
        //*
        //*****************************************************************************
        //** 一覧制御データの初期化を行います。
        //*****************************************************************************
        //権限
        indto.setJokenSetCd("");
        //代行ユーザ組織コード
        indto.setJgiActSosCd("");
        //代行ユーザ表示組織名称
        indto.setJgiActDispSosName("");
        //代行ユーザ上位組織コード
        indto.setJgiActUpSosCd("");
        //領域グループコード
        indto.setTrtGrpCd("");

        //*****************************************************************************
        //*
        //* 条件セット検索(DAO)
        //*
        //*****************************************************************************
        //** ログインユーザの従業員番号から条件セットコードを取得する
        //*****************************************************************************

        SRdmMJgiJokenEntity jokenParam = new SRdmMJgiJokenEntity();
        //従業員番号設定
        jokenParam.setJgiNo(loginInfo.getJgiNo());
        //条件設定検索
        List<SRdmMJgiJokenEntity> jokenList = dao.selectByValue(jokenParam);

        //条件セットリストが0件の場合
        if(jokenList.isEmpty()){
            //メニュー利用権限がありません
            log.error("メニュー利用権限がありません");
            indto.setForward(UnauthorizedException.class.getSimpleName());
            return outdto;
        }

        boolean jokenAdminFlg = false;  //1:管理者権限
        boolean jokenMrFlg = false;  //2:MR権限

        for(SRdmMJgiJokenEntity jokenEntity : jokenList){
            String strJokenSet = jokenEntity.getJokenSetCd();
            if(RdmConstantsData.RDM_JKN_ADMIN.equals(strJokenSet)){
            	jokenAdminFlg = true;  //管理者権限
            }
            if(RdmConstantsData.RDM_JKN_MR.equals(strJokenSet)){
            	jokenMrFlg = true;  //MR権限
            }

        }

        //管理者権限
        if(jokenAdminFlg){
            indto.setJokenSetCd(RdmConstantsData.RDM_JKN_ADMIN);
            loginInfo.setJokenSetCd(RdmConstantsData.RDM_JKN_ADMIN);
            loginInfo.setJokenFlg(RdmConstantsData.RDM_JKN_ADMIN_FLG);

        //MR権限
        }else if(jokenMrFlg){
            indto.setJokenSetCd(RdmConstantsData.RDM_JKN_MR);
            loginInfo.setJokenSetCd(RdmConstantsData.RDM_JKN_MR);
            loginInfo.setJokenFlg(RdmConstantsData.RDM_JKN_MR_FLG);

        }else{

            //メニュー利用権限がありません
            log.error("メニュー利用権限がありません");
            indto.setForward(UnauthorizedException.class.getSimpleName());
            return outdto;
        }

        //パラメタ定義より値を取得
        SRdmMParamMstEntity mParamMst = new SRdmMParamMstEntity();

        List<SRdmMParamMstEntity> mParamMstList = dao.selectList(mParamMst);

        for(SRdmMParamMstEntity mParamMstEntity : mParamMstList){
        	//施設一括更新メニュースイッチ
            if(RdmConstantsData.RDM_PARAM_MST_MENU_MN_IKT_FAC.equals(mParamMstEntity.getParamName())){
            	indto.setMenuMnIktFac(mParamMstEntity.getValue());
            }
            //医師一括更新メニュースイッチ
            else if(RdmConstantsData.RDM_PARAM_MST_MENU_MN_IKT_DOC.equals(mParamMstEntity.getParamName())){
            	indto.setMenuMnIktDoc(mParamMstEntity.getValue());
            }
            //来期用項目メニュースイッチ
            else if(RdmConstantsData.RDM_PARAM_MST_MENU_MN_NT_FAC.equals(mParamMstEntity.getParamName())){
            	indto.setMenuMnNtFac(mParamMstEntity.getValue());
            }
            //親子紐づけ(当期)メニュースイッチ(MN_CT_OYA)はメニューにないので設定なし
            //親子紐づけ(来期)メニュースイッチ(MN_NT_OYA)はメニューにないので設定なし

        }

        // END UOC
        return outdto;
    }

}
