/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import jp.co.takeda.rdm.common.AuthorizationServiceData;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.common.BeanUtil;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.common.MainMenuData;
import jp.co.takeda.rdm.entity.MRdmFwHelperMatrixEntity;
import jp.co.takeda.rdm.entity.MRdmFwTransitionEntity;
import jp.co.takeda.rdm.entity.RdmMsgMstEntity;
import jp.co.takeda.rdm.entity.SRdmMJgiJokenEntity;
import jp.co.takeda.rdm.entity.MRdmJgiSosMstEntity;
import jp.co.takeda.rdm.entity.join.MRdmParamMstEntity;
import jp.co.takeda.rdm.entity.join.SelectCodeMstEntity;
import jp.co.takeda.rdm.entity.join.SelectLoginJgiNoByUserIdEntity;
import jp.co.takeda.rdm.entity.join.SelectLoginUserIdByJgiNoEntity;
import jp.co.takeda.rdm.exception.UnauthorizedException;
import jp.co.takeda.rdm.util.DateUtils;
import jp.co.takeda.rdm.util.RdmConstantsData;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * メニュー情報取得クラス
 * Serviceクラス（MenuViewBackService)
 * @generated
 */
@Named
public class CommonControlService extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(CommonControlService.class);

    /**
     * ログインユーザ情報取得処理
     * @param loginInfo LoginInfo
     * @customizable
     */
    @Transactional
    public void setUserInfo(LoginInfo loginInfo) {

        //ユーザ情報は未設定の場合
        if (!loginInfo.isJgiNameGetFlag()) {
            //ユーザID
            String userId = loginInfo.getUserId();

            //*****************************************************************************
            //*
            //* ログイン従業員番号検索(DAO)
            //*
            //*****************************************************************************
            //** 変換テーブルよりユーザIDをキーに従業員番号を取得する
            //*****************************************************************************
            if (!loginInfo.isJgiNameGetFlag()) {

                //代行中ではない場合、ユーザID⇒従業員番号
                if (!loginInfo.isActing()) {
                    //受け取る文字は必ず７桁のC123456
                    if(userId != null && jp.co.takeda.rdm.util.StringUtils.getByteLength(userId) == 7 && jp.co.takeda.rdm.util.StringUtils.isSingleByte(userId)) {
                        SelectLoginJgiNoByUserIdEntity loginParam = new SelectLoginJgiNoByUserIdEntity();
                        loginParam.setInUserId(userId);
                        List<SelectLoginJgiNoByUserIdEntity> loginUserList = dao.select(loginParam);
                        SelectLoginJgiNoByUserIdEntity loginEntity = loginUserList.get(0);
                        int jgiNo = loginEntity.getJgiNo();
                        //従業員番号の設定
                        loginInfo.setJgiNo(jgiNo);
                    }

                //代行の場合、従業員番号⇒ユーザID
                } else {
                    SelectLoginUserIdByJgiNoEntity loginParam2 = new SelectLoginUserIdByJgiNoEntity();
                    loginParam2.setInJgiNo(loginInfo.getJgiNo());
                    List<SelectLoginUserIdByJgiNoEntity> loginUserList = dao.select(loginParam2);
                    SelectLoginUserIdByJgiNoEntity loginEntity = loginUserList.get(0);
                    //代行された従業員番号のユーザIDを設定
                    loginInfo.setUserId(loginEntity.getUserId());
                }

                //TODO二神これ消す予定従業員名称の取得＆設定
                /*
                SJkrMJgiMstEntity jgiParam = new SJkrMJgiMstEntity();
                jgiParam.setJgiNo(loginInfo.getJgiNo());
                SJkrMJgiMstEntity jgiEntity = dao.selectByValue(jgiParam).get(0);
                loginInfo.setUserName(jgiEntity.getJgiName());
                loginInfo.setJgiName(jgiEntity.getJgiName());
                */

                MRdmJgiSosMstEntity rdmJgiSosMstParam = new MRdmJgiSosMstEntity();
                rdmJgiSosMstParam.setJgiNo(loginInfo.getJgiNo());

                List<MRdmJgiSosMstEntity> rdmJgiSosMstEntityList = dao.selectByValue(rdmJgiSosMstParam);

                if(!rdmJgiSosMstEntityList.isEmpty()){
	                MRdmJgiSosMstEntity rdmJgiSosMstEntity = rdmJgiSosMstEntityList.get(0);
	                loginInfo.setJgiName(rdmJgiSosMstEntity.getJgiName());
	                loginInfo.setSosCd(rdmJgiSosMstEntity.getSosCd());
	                loginInfo.setBrCode(rdmJgiSosMstEntity.getBrCode());
	                loginInfo.setDistCode(rdmJgiSosMstEntity.getDistCode());
	                loginInfo.setBumonRyakuName(rdmJgiSosMstEntity.getBumonRyakuName());
	                loginInfo.setBumonRank(rdmJgiSosMstEntity.getBumonRank());
	                loginInfo.setUpSosCd(rdmJgiSosMstEntity.getUpSosCd());
	                loginInfo.setTrtCd(rdmJgiSosMstEntity.getTrtCd());
                }

                SRdmMJgiJokenEntity jokenParam = new SRdmMJgiJokenEntity();
                //従業員番号設定
                jokenParam.setJgiNo(loginInfo.getJgiNo());
                //条件設定検索
                List<SRdmMJgiJokenEntity> jokenList = dao.selectByValue(jokenParam);

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
                    loginInfo.setJokenSetCd(RdmConstantsData.RDM_JKN_ADMIN);
                    loginInfo.setJokenFlg(RdmConstantsData.RDM_JKN_ADMIN_FLG);

                //MR権限
                }else if(jokenMrFlg){
                    loginInfo.setJokenSetCd(RdmConstantsData.RDM_JKN_MR);
                    loginInfo.setJokenFlg(RdmConstantsData.RDM_JKN_MR_FLG);
                }

                //TODO二神　これ必要か確認二神ここから
                //代行中なら、本ユーザの名称も取得する

                /*TODO二神
                if (loginInfo.isActing()) {
                    //本ユーザの従業員名称の取得＆設定
                    SJkrMJgiMstEntity jgiParam2 = new SJkrMJgiMstEntity();
                    //TODO二神
                    //jgiParam.setJgiNo(loginInfo.getActorJgiNo());
                    SJkrMJgiMstEntity jgiEntity2 = dao.selectByValue(jgiParam2).get(0);
                    loginInfo.setActorJgiName(jgiEntity2.getJgiName());
                }
                */



                //従業員名称設定済みとする
                loginInfo.setJgiNameGetFlag(true);

//                //従業員関連汎用マスタからジョブ管理時刻を取得
//                SelectCodeMstEntity codeParam = new SelectCodeMstEntity();
//                //データ区分 (パラメータ1)
//                codeParam.setInDataKbn("time_limit");
//                //コード (パラメータ2)
//                codeParam.setInDataCd("0");
//                //担当変更システムコードマスタ検索
//                SelectCodeMstEntity codeMstEntity = (SelectCodeMstEntity)dao.select(codeParam).get(0);
//                //ジョブ管理時刻
//                loginInfo.setTimeData(codeMstEntity.getDataName());
            	MRdmParamMstEntity mRdmParamMstEntity = new MRdmParamMstEntity();
            	mRdmParamMstEntity.setParamName(RdmConstantsData.PARAM_NAME_TIME_LIMIT);
            	mRdmParamMstEntity.setDelFlg("0");
            	List<MRdmParamMstEntity> mRdmParamMstEntityList = dao.selectByValue(mRdmParamMstEntity);
            	//ジョブ管理時刻
            	loginInfo.setTimeData(mRdmParamMstEntityList.get(0).getValue());
                //TODO二神 これ必要か確認二神ここまで

                //RDMシステムメッセージ一覧取得
                List<RdmMsgMstEntity> msgList = dao.selectList(new RdmMsgMstEntity());
                Map<String, RdmMsgMstEntity> msgMap = new HashMap<String, RdmMsgMstEntity>();
                for (RdmMsgMstEntity msgEntity : msgList) {
                    msgMap.put(msgEntity.getMsgCd(), msgEntity);
                }
                loginInfo.setMsgMap(msgMap);
            }
        }

    }

    /**
     * 画面遷移チェック処理
     * @param loginInfo LoginInfo
     * @return チェック結果 null:チェックOK nullではない：エラー
     */
    @Transactional
    public boolean checkTransition(LoginInfo loginInfo) {

        //前画面がなければ、チェックを行わない。
        if( (loginInfo.getPreScreenId() == null || loginInfo.getPreScreenId().equals("")) ||
            (loginInfo.getPreFunctionId() == null || loginInfo.getPreFunctionId().equals("")) ){
          return true;
        }

        //FWヘルパー対応表取得
        MRdmFwHelperMatrixEntity helperParam = new MRdmFwHelperMatrixEntity();
        //画面ID設定
        helperParam.setScreenId(loginInfo.getScreenId());
        //機能ID設定
        helperParam.setFunctionId(loginInfo.getFunctionId());
        //画面IDと機能IDよりヘルパー対応情報を取得する
        MRdmFwHelperMatrixEntity helperMatrixEntiry = dao.selectByPK(helperParam);

        //Wヘルパー対応表取得
        MRdmFwTransitionEntity transitionParam = new MRdmFwTransitionEntity();
        //画面ID設定
        transitionParam.setScreenId(loginInfo.getScreenId());
        //機能ID設定
        transitionParam.setFunctionId(loginInfo.getFunctionId());
        List<MRdmFwTransitionEntity> transitionList = dao.selectByValue(transitionParam);

        //必要なくても、xmlファイル内にはtransition="null"と定義しているはず。
        if(helperMatrixEntiry == null || transitionList.size() == 0) {
            return false;
        }

        boolean check = false;
        int nullCount = 0;
        for (MRdmFwTransitionEntity entity : transitionList){
            //"null"の場合は無視
            if(entity.getPreScreenId() == null || entity.getPreScreenId().equalsIgnoreCase("null")){
                //"null"しかない場合はこのカウンタがtransition.lengthと等しくなるはず。
                nullCount ++;
                continue;
            }

            //画面遷移リスト中に存在する場合はOK:trueを返す。
            if(loginInfo.getPreScreenId().equalsIgnoreCase(entity.getPreScreenId())
                && loginInfo.getPreFunctionId().equalsIgnoreCase(entity.getPreFunctionId())){
                check = true;
                break;
            }
        }
        if(!check){
            //"null"しかない場合は画面遷移OK:trueとする。
            if(transitionList.size() > 0 && nullCount == transitionList.size()){
                check = true;
            }
        }

        //チェックNGの場合
        return check;
    }

    /**
     * <pre>
     * 権限チェックのストアドプロシージャです。
     * </pre>
     */
    private static final String fullProgramAuthenticate = "{call common_pkg.full_program_authenticate(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";


    /**
     * プログラム認証と利用時間帯チェック処理
     * @param loginInfo LoginInfo
     * @customizable
     */
    @Transactional
    public AuthorizationServiceData checkAuthorization(LoginInfo loginInfo) throws SQLException {

        log.info("authData Parameter=========" + loginInfo.getScreenId() + ":" + loginInfo.getFunctionId());
        //FWヘルパー対応表取得
        MRdmFwHelperMatrixEntity helperParam = new MRdmFwHelperMatrixEntity();
        //画面ID設定
        helperParam.setScreenId(loginInfo.getScreenId());
        //機能ID設定
        helperParam.setFunctionId(loginInfo.getFunctionId());
        //画面IDと機能IDよりヘルパー対応情報を取得する
        MRdmFwHelperMatrixEntity helperMatrixEntiry = dao.selectByPK(helperParam);

        //String generationFlgStr = "NEW";
        //利用権限新旧チェック用
        String generationFlgStr = helperMatrixEntiry.getGeneration();
        int generationFlg = 1;

        //チェックを行わない場合はnullを戻します。
        if(loginInfo.getScreenCheckFlg() != 1 && loginInfo.getTimeCheckFlg() != 1){
            log.debug("画面利用権限及び利用時間帯チェックを行いません。[screenId=" + loginInfo.getScreenId() + "][functionId=" + loginInfo.getFunctionId() + "]");
            return null;
        }
        //新旧チェックフラグを数字に変換します。ex) NEW→1
        if (generationFlgStr.equalsIgnoreCase("NEW")) {
            generationFlg = 1;

        } else if (generationFlgStr.equalsIgnoreCase("OLD")) {
            generationFlg = 2;

        } else if (generationFlgStr.equalsIgnoreCase("EITHER")) {
            generationFlg = 3;

        } else if (generationFlgStr.equalsIgnoreCase("BOTH")) {
            generationFlg = 4;

        } else {
            generationFlg = 1;
        }

        //権限チェックを行う旨をロギング
        log.debug("画面利用権限及び利用時間帯チェックを行います。[screenId=" + loginInfo.getScreenId() + "][functionId=" + loginInfo.getFunctionId() + "]");

        //認証データ
        AuthorizationServiceData authData = null;


        //プログラム認証ストアドプロシジャ コールステートメント生成
        CallableStatement cstmt = null;
        try{
            cstmt = dao.getPrepareCall(fullProgramAuthenticate);
            //コーラブルステートメントに引数を設定
            cstmt.setInt    (1, loginInfo.getScreenCheckFlg()); //画面認証チェックフラグ
            cstmt.setInt    (2, loginInfo.getTimeCheckFlg());   //利用時間チェックフラグ
            cstmt.setInt    (3, generationFlg);                 //新旧チェックフラグ
            cstmt.setString (4, loginInfo.getScreenId());       //画面ID
            cstmt.setString (5, loginInfo.getFunctionId());     //機能ID
            cstmt.setInt    (6, loginInfo.getJgiNo());          //従業員番号
            cstmt.setString (7, DateUtils.getSysDate("HHmmss"));//APサーバシステム日付

            //コーラブルステートメントに戻り値型を設定
            cstmt.registerOutParameter (8,  java.sql.Types.INTEGER); //画面認証結果 OK:1 NG:0
            cstmt.registerOutParameter (9,  java.sql.Types.INTEGER); //利用時間チェック結果 OK:1 NG:0
            cstmt.registerOutParameter (10, java.sql.Types.INTEGER); //該当画面ID未登録フラグ(画面管理テーブル) 未登録:1 登録済:0
            cstmt.registerOutParameter (11, java.sql.Types.INTEGER); //サービス停止中フラグ(画面管理テーブル) 停止中:1 稼動中:0
            cstmt.registerOutParameter (12, java.sql.Types.INTEGER); //サービス時間外フラグ サービス時間外:1 サービス時間内:0
            cstmt.registerOutParameter (13, java.sql.Types.INTEGER); //該当画面ID機能ID未登録フラグ(機能管理テーブル) 未登録:1 登録済:0
            cstmt.registerOutParameter (14, java.sql.Types.INTEGER); //サービス停止中フラグ(機能管理テーブル) 停止中:1 稼動中:0
            cstmt.registerOutParameter (15, java.sql.Types.VARCHAR); //サービス停止メッセージ(画面管理テーブル)
            cstmt.registerOutParameter (16, java.sql.Types.VARCHAR); //サービス停止メッセージ(機能管理テーブル)
            cstmt.registerOutParameter (17, java.sql.Types.VARCHAR); //画面名称
            cstmt.registerOutParameter (18, java.sql.Types.VARCHAR); //機能名称
            cstmt.registerOutParameter (19, java.sql.Types.VARCHAR); //サービス開始時間
            cstmt.registerOutParameter (20, java.sql.Types.VARCHAR); //サービス停止時間

            //プログラム認証ストアドプロシジャ呼び出し
            cstmt.execute();

            authData = new AuthorizationServiceData();

            //プロシジャの結果を格納します。
            authData.setAuthStatus         (cstmt.getInt(8));      //画面認証結果 OK:1 NG:0
            authData.setUtilityTimeStatus  (cstmt.getInt(9));      //利用時間チェック結果 OK:1 NG:0
            authData.setUnregisteredScrn   (cstmt.getInt(10));     //該当画面ID未登録フラグ(画面管理テーブル) 未登録:1 登録済:0
            authData.setStopServiceScrn    (cstmt.getInt(11));     //サービス停止中フラグ(画面管理テーブル) 停止中:1 稼動中:0
            authData.setOverTimeService    (cstmt.getInt(12));     //サービス時間外フラグ サービス時間外:1 サービス時間内:0
            authData.setUnregisteredFunc   (cstmt.getInt(13));     //該当画面ID機能ID未登録フラグ(機能管理テーブル) 未登録:1 登録済:0
            authData.setStopServiceFunc    (cstmt.getInt(14));     //サービス停止中フラグ(機能管理テーブル) 停止中:1 稼動中:0
            authData.setStopMsgScrn        (cstmt.getString(15));  //サービス停止メッセージ(画面管理テーブル)
            authData.setStopMsgFunc        (cstmt.getString(16));  //サービス停止メッセージ(機能管理テーブル)
            authData.setScrnName           (cstmt.getString(17));  //画面名称
            authData.setFuncName           (cstmt.getString(18));  //機能名称
            authData.setStartTime          (cstmt.getString(19));  //サービス開始時間
            authData.setEndTime            (cstmt.getString(20));  //サービス停止時間


        }catch(SQLException sqle){
            log.error("SQLException:" + sqle.getMessage());
            throw sqle;
        }finally{
            // Close the statement
            if(cstmt!=null){
                try{
                    cstmt.close();
                }catch(SQLException sqle){
                    cstmt = null;
                }
            }
        }

        return authData;
    }

    /**
     * 従業員番号取得処理
     * @param String userId
     * @customizable
     */
    @Transactional
    public int getJgiNo(String userId) {
        int jgiNo = 0;
        //ユーザIDをもとに従業員番号を取得
        if(userId != null && jp.co.takeda.rdm.util.StringUtils.getByteLength(userId) == 7 && jp.co.takeda.rdm.util.StringUtils.isSingleByte(userId)) {
            SelectLoginJgiNoByUserIdEntity loginParam = new SelectLoginJgiNoByUserIdEntity();
            loginParam.setInUserId(userId);
            List<SelectLoginJgiNoByUserIdEntity> loginUserList = dao.select(loginParam);
            SelectLoginJgiNoByUserIdEntity loginEntity = loginUserList.get(0);
            jgiNo = loginEntity.getJgiNo();
        }
        return jgiNo;
    }

}
