/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import jp.co.takeda.rdm.entity.MRdmHcpWorkEntity;
import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.HcpWorkData;
import jp.co.takeda.rdm.dto.ND013DTO;
import jp.co.takeda.rdm.util.StringUtils;



/**
 * Serviceクラス（ND013)
 * @generated
 */
@Named
public class ND013Service extends BaseService {

	//ログインユーザ情報取得
    LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

    boolean errChk = false;
	String msgStr = "";
	String tmpMsgStr = "";
	int len = 0;

    /**
     * イベント処理
     * @param dto NC204DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(ND013DTO dto) {
        BaseDTO outdto = dto;
        LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();
        // START UOC

        // ページ数(現在:１ページ目から)
        dto.setPageCntCur(1);

        //ヘッダー部データ
        MRdmHcpWorkEntity paramEntity = new MRdmHcpWorkEntity();
        //医師固定Cをセットする
        paramEntity.setParamDocNo(dto.getParamDocNo());
        //ヘッダー検索区分
        paramEntity.setSearchType("0");
        //画面初期表示時の帳票一覧を取得する
        List<MRdmHcpWorkEntity> SelectHeaderHcpWorkList = dao.select(paramEntity);

        for (MRdmHcpWorkEntity entity : SelectHeaderHcpWorkList) {
        	//武田医師名（漢字）
        	dto.setDocKanj(entity.getDocKanj());
        	//武田医師名（ｶﾅ）
        	dto.setDocKana(entity.getDocKana());
        	//医師固定C
        	dto.setDocNo(entity.getDocNo());
        	dto.setParamDocNo(entity.getDocNo());
        	//医師薬剤師区分
        	dto.setDocType(entity.getDocType());
        	//ULT医師名（漢字）
        	dto.setUltKanj(entity.getUltKanj());
        	//ULT医師名（ｶﾅ）
        	dto.setUltKana(entity.getUltKana());
        	//削除フラグ
        	dto.setDelFlg(entity.getDelFlg());
        }

        //データ部検索区分
        paramEntity.setSearchType("1");
        // ログインユーザID
        paramEntity.setJgiNo(String.valueOf(loginInfo.getJgiNo()));
        paramEntity.setSosCd(String.valueOf(loginInfo.getSosCd()));

        //データ部画面初期表示時の帳票一覧を取得する
        List<MRdmHcpWorkEntity> SelectHcpWorkList = dao.select(paramEntity);

        List<HcpWorkData> SelectHcpWorkDataList = new ArrayList<>();
        dto.setDummyHcoCount(0);
        for (MRdmHcpWorkEntity entity : SelectHcpWorkList) {
        	HcpWorkData dataRecord = new HcpWorkData();

        	//医師メニュースイッチ
        	String ishiMenu = entity.getIshiMenu().substring(1,2);
        	//医師勤務先メニュースイッチ
        	String ishiKinmuEdit = entity.getIshiKinmu().substring(1,2);
        	//アクション編集
        	/*
        	 * 医師メニュースイッチが0
        	 * または
        	 * 医師メニュースイッチが1かつ医師勤務先メニュースイッチが0の場合
        	 * アクション編集に0を挿入
        	 * その他はアクション編集に1を挿入
        	 * */
        	if (ishiMenu.equals("0") || (ishiMenu.equals("1") && ishiKinmuEdit.equals("0"))) {
        		dataRecord.setActionEdit("0");
        	}
        	else {
        		dataRecord.setActionEdit("1");
        	}

        	//アクション削除
        	String ishiKinmuDel = entity.getIshiKinmu().substring(2,3);
        	/*
        	 * 医師メニュースイッチが0
        	 * または
        	 * 医師メニュースイッチが1かつ医師勤務先メニュースイッチが0の場合
        	 * アクション編集に0を挿入
        	 * その他はアクション編集に1を挿入
        	 * */
        	if (ishiMenu.equals("0") || (ishiMenu.equals("1") && ishiKinmuDel.equals("0"))) {
        		dataRecord.setActionDel("0");
        	}
        	else {
        		dataRecord.setActionDel("1");
        	}

        	//勤務先追加ボタン
        	/*
        	 * 医師メニュースイッチが0
        	 * または
        	 * 医師メニュースイッチが1かつ医師勤務先メニュースイッチが0の場合
        	 * アクション編集に0を挿入
        	 * その他はアクション編集に1を挿入
        	 * */
        	//医師勤務先メニュースイッチ 左から1桁目を格納
        	String ishiKinmuNew = entity.getIshiKinmu().substring(0,1);
        	if (ishiMenu.equals("0") || (ishiMenu.equals("1") && ishiKinmuNew .equals("0"))) {
        		dto.setIshiNewKinmu("0");
        	}
        	else {
        		dto.setIshiNewKinmu("1");
        	}

        	//医師の廃業・死亡ボタン
        	/*
        	 * 医師メニュースイッチが0
        	 * または
        	 * 医師メニュースイッチが1かつ医師勤務先メニュースイッチが0の場合
        	 * アクション編集に0を挿入
        	 * その他はアクション編集に1を挿入
        	 * */
        	String ishiHaigyouMenu = entity.getIshiMenu().substring(2,3);
        	if (ishiHaigyouMenu.equals("0")) {
        		dto.setIshiHaigyou("0");
        	}
        	else {
        		dto.setIshiHaigyou("1");
        	}

        	//アクション申請A
        	/*
        	 * nullの場合1を挿入
        	 * Notnullは0を挿入
        	 * */
        	if (Objects.equals(entity.getReqA(), null)) {
        		dataRecord.setReqA(1);
        	}
        	else {
        		dataRecord.setReqA(0);
        	}

        	//アクション申請B
        	/*
        	 * nullの場合1を挿入
        	 * Notnullは0を挿入
        	 * */
        	if (Objects.equals(entity.getReqB(), null)) {
        		dataRecord.setReqB(1);
        	}
        	else {
        		dataRecord.setReqB(0);
        	}

        	//施設略式漢字名
        	dataRecord.setInsAbbrName(entity.getInsAbbrName());
        	//対象区分
        	if (StringUtils.isEmpty(entity.getHoInsType())) {
        		entity.setHoInsType("-");
        	}
        	dataRecord.setHoInsType(entity.getHoInsType());
        	//施設住所
        	if (StringUtils.isEmpty(entity.getInsAddr())) {
        		entity.setInsAddr("-");
        	}
        	dataRecord.setInsAddr(entity.getInsAddr());
        	//所属部科
        	if (StringUtils.isEmpty(entity.getDeptKj())) {
        		entity.setDeptKj("-");
        	}
        	dataRecord.setDeptKj(entity.getDeptKj());
        	//役職
        	if (StringUtils.isEmpty(entity.getTitleKj())) {
        		entity.setTitleKj("-");
        	}
        	dataRecord.setTitleKj(entity.getTitleKj());
        	//勤務形態
        	if (StringUtils.isEmpty(entity.getJobForm())) {
        		entity.setJobForm("-");
        	}
        	dataRecord.setJobForm(entity.getJobForm());
        	//大学職位
        	if (StringUtils.isEmpty(entity.getUnivTitle())) {
        		entity.setUnivTitle("-");
        	}
        	dataRecord.setUnivTitle(entity.getUnivTitle());
        	//施設固定コード(隠し)
        	dataRecord.setInsNoKakusi(entity.getInsNoKakusi());

        	//実勤務先判定(ダミー施設コード)
        	/*
        	 * nullの場合ダミー勤務先をカウント
        	 * */
        	if (Objects.equals(entity.getDummyHco(), null)) {
        		dto.setDummyHcoCount(dto.getDummyHcoCount() + 1);
        	}
        	dataRecord.setDummyHco(entity.getDummyHco());

        	dataRecord.setJgiNo(entity.getJgiNo());
        	dataRecord.setSosCd(entity.getSosCd());

        	dataRecord.setKinmuCount(SelectHcpWorkList.size());
        	//データ部検索結果を格納
        	SelectHcpWorkDataList.add(dataRecord);
        }

    	// 勤務先追加ボタン表示
    	Integer kinmuCount = SelectHcpWorkList.size();
    	dto.setKinmuCount(kinmuCount);
    	if(kinmuCount >= 2) {
    		if("1".equals(dto.getIshiNewKinmu())) {
    			dto.setIshiNewKinmu("2");
    		} else {
    			dto.setIshiNewKinmu("1");
    		}
    	} else if(kinmuCount == 1 && dto.getDummyHcoCount() > 0) {
    		if("1".equals(dto.getIshiNewKinmu())) {
    			dto.setIshiNewKinmu("2");
    		} else {
    			dto.setIshiNewKinmu("1");
    		}
    	} else {
    		dto.setIshiNewKinmu("0");
    	}

        dto.setHcpWorkData(SelectHcpWorkDataList);
        // END UOC
        return outdto;
    }

    /**
     * エラーチェック
     * @param dto NC204DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO errorCheck(ND013DTO dto) {

    	BaseDTO outdto = dto;

    	//エラーチェック
        MRdmHcpWorkEntity paramEntity = new MRdmHcpWorkEntity(dto.getErrorCheckFlg());
        //ダイアログ・エラーメッセージをリセット
        dto.setDialog("");
        dto.setMsgStr("");

        //施設固定コード (隠し項目)をセット
    	paramEntity.setInsNoKakusi(dto.getInsNoKakusi());

    	//医師固定コードをセット
    	paramEntity.setDocNo(dto.getDocNo());

    	dto.setErrorBool(true);

        //勤務先追加 エラーチェック
        if (Objects.equals(dto.getErrorCheckFlg(), "1")) {
        	paramEntity.setErrorCheckFlg("1");
        	List<MRdmHcpWorkEntity> kinmuNew = dao.select(paramEntity);
        	//勤務先追加チェックエラーがある場合
        	if (!CollectionUtils.isEmpty(kinmuNew)) {
        		//エラー判定をfalse
        		dto.setErrorBool(false);

            }
        	dto.setButtonFlg("1");
        	return outdto;
        }
        //「医師の廃業・死亡」ボタン押下 エラーチェック
        if (Objects.equals(dto.getErrorCheckFlg(), "2")) {
        	//重複申請チェック
        	paramEntity.setErrorCheckFlg("21");
        	List<MRdmHcpWorkEntity> juhuku = dao.select(paramEntity);
        	//重複申請チェックエラーがある場合
        	if (!CollectionUtils.isEmpty(juhuku)) {
        		//エラー判定をfalse
        		dto.setErrorBool(false);
            }

        	// 勤務先異動チェック
        	paramEntity.setErrorCheckFlg("23");
        	List<MRdmHcpWorkEntity> idou = dao.select(paramEntity);
        	// 勤務先異動チェックエラーがある場合
        	if (!CollectionUtils.isEmpty(idou)) {
        		//エラー判定をfalse
        		dto.setErrorBool(false);
        		return outdto;
            }

        	//整合性チェック
        	paramEntity.setErrorCheckFlg("24");
        	List<MRdmHcpWorkEntity> seigousei = dao.select(paramEntity);
        	//整合性チェック エラーがある場合
        	if (!CollectionUtils.isEmpty(seigousei)) {
        		//エラー判定をfalse
        		dto.setErrorBool(false);
            }
        	dto.setButtonFlg("1");
        	return outdto;
        }

        //「勤務先削除」ボタン押下時 エラーチェック
        if (Objects.equals(dto.getErrorCheckFlg(), "3")) {
        	//重複申請チェック
        	paramEntity.setErrorCheckFlg("31");
        	List<MRdmHcpWorkEntity> kinmuJuhuku = dao.select(paramEntity);
        	//重複申請チェックエラーがある場合
        	if (!CollectionUtils.isEmpty(kinmuJuhuku)) {
        		dto.setErrorCheckFlg("31");
        		//エラー判定をfalse
        		dto.setErrorBool(false);
        		return outdto;
            }
        	//勤務先0件チェック
        	paramEntity.setErrorCheckFlg("32");
        	List<MRdmHcpWorkEntity> kinmu0 = dao.select(paramEntity);
        	//勤務先が１件以下または空の場合エラー
        	if (kinmu0.size() <= 1) {
        		dto.setErrorCheckFlg("32");
        		//エラー判定をfalse
        		dto.setErrorBool(false);
        		return outdto;
            }
        	dto.setErrorCheckFlg("3");
        	return outdto;
        }

        //「勤務先情報更新」ボタン押下時 エラーチェック
        if (Objects.equals(dto.getErrorCheckFlg(), "4")) {
        	//重複申請チェック
        	paramEntity.setErrorCheckFlg("4");
        	List<MRdmHcpWorkEntity> kinmuJuhuku = dao.select(paramEntity);
        	//重複申請チェックエラーがある場合
        	if (!CollectionUtils.isEmpty(kinmuJuhuku)) {
        		//エラー判定をfalse
        		dto.setErrorBool(false);
        		return outdto;
            }
        }

        //「医療機関への異動」ボタン押下時 エラーチェック
        if (Objects.equals(dto.getErrorCheckFlg(), "5")) {
        	// 整合性チェック
        	paramEntity.setErrorCheckFlg("5");
        	List<MRdmHcpWorkEntity> seigousei = dao.select(paramEntity);
        	// 整合性チェックエラーがある場合
        	if (!CollectionUtils.isEmpty(seigousei)) {
        		//エラー判定をfalse
        		dto.setErrorBool(false);
        		return outdto;
            }
        }

      //「医療機関外への異動」ボタン押下時 エラーチェック
        if (Objects.equals(dto.getErrorCheckFlg(), "6")) {
        	// 重複申請チェック
        	paramEntity.setErrorCheckFlg("6");
        	List<MRdmHcpWorkEntity> juhuku = dao.select(paramEntity);
        	// 重複申請チェックエラーがある場合
        	if (!CollectionUtils.isEmpty(juhuku)) {
        		//エラー判定をfalse
        		dto.setErrorBool(false);
        		return outdto;
            }
        }


    	return outdto;
    }

}
