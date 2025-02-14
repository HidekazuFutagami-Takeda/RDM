/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

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
import jp.co.takeda.rdm.entity.MRdmComCalUsrEntity;
import jp.co.takeda.rdm.entity.join.SelectDocReqKnrInsChangeEntity;
import jp.co.takeda.rdm.entity.join.SelectHcpEntity;
import jp.co.takeda.rdm.entity.join.SelectHenkanListEntity;
import jp.co.takeda.rdm.entity.join.SelectNd101ComboListEntity;
import jp.co.takeda.rdm.entity.join.SelectNd101YakushokuComboListEntity;
import jp.co.takeda.rdm.entity.join.SelectTmrEntity;
import jp.co.takeda.rdm.dto.ND101DTO;
import jp.co.takeda.rdm.entity.join.SelectNd101MainDataEntity;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.entity.join.SeqRdmReqIdEntity;
import jp.co.takeda.rdm.entity.join.TRdmHcpKmuReqEntity;
import jp.co.takeda.rdm.entity.join.TRdmReqKnrEntity;
import jp.co.takeda.rdm.util.DateUtils;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * Serviceクラス（ND101)
 * @generated
 */
@Named
public class ND101Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(ND001Service.class);

    /**
     * イベント処理
     * @param indto ND101DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(ND101DTO indto) {

    	BaseDTO outdto = indto;
    	//1-1 権限判定
        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

        setCombo(indto);

        SelectDocReqKnrInsChangeEntity selectDocReqKnrInsChangeEntity = new SelectDocReqKnrInsChangeEntity();

        indto.setTempReqBtnFlg(StringUtils.nvl(indto.getTempReqBtnFlg(), "0"));
        //遷移元画面によってパラメータセットを変更
        if(indto.getPreScreenId().equals("NC011")|| indto.getTempReqBtnFlg().equals("1")) {
        	//例　250130-000001
        	selectDocReqKnrInsChangeEntity.setInReqId(indto.getReqId());
        	selectDocReqKnrInsChangeEntity.setInReqFlg(1);
        }else{
        	selectDocReqKnrInsChangeEntity.setInReqFlg(0);
        	selectDocReqKnrInsChangeEntity.setInDocNo(indto.getDocNo());
        	selectDocReqKnrInsChangeEntity.setInInsNo(indto.getInsNo());
        }
    	List<SelectDocReqKnrInsChangeEntity> selectDocReqKnrInsChangeList = dao.select(selectDocReqKnrInsChangeEntity);

    	if(indto.getPreScreenId().equals("NC011")|| indto.getTempReqBtnFlg().equals("1")) {
    		//ヘッダ部
    		indto.setReqId(StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getReqId(), "-"));
    		indto.setReqShz(selectDocReqKnrInsChangeList.get(0).getReqShz());
    		indto.setReqStsNm(StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getReqStsNm(), "-"));
    		indto.setReqSts(selectDocReqKnrInsChangeList.get(0).getReqSts());
    		indto.setReqJgiName(selectDocReqKnrInsChangeList.get(0).getReqJgiName());
    		indto.setReqYmdhms(StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getReqYmdhms(), "-"));
    		//ヘッダ部隠し項目
    		indto.setReqJgiNo(selectDocReqKnrInsChangeList.get(0).getReqJgiNo());
    		indto.setReqBrCode(selectDocReqKnrInsChangeList.get(0).getReqBrCode());
    		indto.setReqDistCode(selectDocReqKnrInsChangeList.get(0).getReqDistCode());
    		indto.setUpdShaYmd(selectDocReqKnrInsChangeList.get(0).getUpdShaYmd());

    		//隠し項目（変更後）
    		indto.setPostInsNo(selectDocReqKnrInsChangeList.get(0).getPostInsNo());
    		indto.setPostUltInsNo(selectDocReqKnrInsChangeList.get(0).getPostUltInsNo());
    		indto.setPostDeptCode(selectDocReqKnrInsChangeList.get(0).getPostDeptCode());
    		indto.setPostDeptKn(selectDocReqKnrInsChangeList.get(0).getPostDeptKn());
    		indto.setPostTitleCode(selectDocReqKnrInsChangeList.get(0).getPostTitleCode());
    		indto.setPostJobForm(selectDocReqKnrInsChangeList.get(0).getPostJobForm());
    		indto.setPostDcc(selectDocReqKnrInsChangeList.get(0).getPostDcc());
    		indto.setPostUnivPosCode(selectDocReqKnrInsChangeList.get(0).getPostUnivPosCode());
    		//reqSts設定用フラグ　NC011の場合 0

    	}else  {
    		//ヘッダ部　github連携時に修正すること TODO
    		indto.setReqId(StringUtils.nvl(indto.getReqId(), "-"));
    		indto.setReqShz("TestR");
    		if(indto.getTempReqBtnFlg().equals("0")) {
    			indto.setReqStsNm("-");
    		} else {
    			indto.setReqStsNm("保存済み");
    		}
    		indto.setReqJgiName("TestMR");
    		indto.setReqYmdhms("-");
    		//ヘッダ部隠し項目

    		//indto.申請者所属リージョン　loginInfoから取得 TODO
    		//indto.申請者所属エリア　loginInfoから取得 TODO
    		indto.setReqDistCode("testR");
    		indto.setUpdShaYmd("testA");

    		//reqSts設定用フラグ　ND013の場合 1

    	}

        //基本情報
    	indto.setDocKanj(StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getDocKanj(), "-"));

    	//基本情報隠し項目
        indto.setDocNo(selectDocReqKnrInsChangeList.get(0).getDocNo());
        indto.setUltDocNo(selectDocReqKnrInsChangeList.get(0).getUltDocNo());
        indto.setPreHoInsType(StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getPreHoInsType(),""));
        indto.setPostHoInsType(selectDocReqKnrInsChangeList.get(0).getPostHoInsType());


    	//勤務情報（変更前）
    	indto.setPreInsAbbrName(StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getPreInsAbbrName(), "-"));
		indto.setPreDeptKj(StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getPreDeptKj(), "-"));
		indto.setTitlePreTitleKj(StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getTitlePreTitleKj(), "-"));
		indto.setKmuPreCodeKanj(StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getKmuPreCodeKanj(), "-"));
		indto.setYakushinPreCodeKanj(StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getYakushinPreCodeKanj(), "-"));
		indto.setUnivPreTitleKj(StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getUnivPreTitleKj(), "-"));

		//隠し項目（変更前）
		indto.setPreInsNo(selectDocReqKnrInsChangeList.get(0).getPreInsNo());
		indto.setPreUltInsNo(selectDocReqKnrInsChangeList.get(0).getPreUltInsNo());
		indto.setPreDeptCode(selectDocReqKnrInsChangeList.get(0).getPreDeptCode());
		indto.setPreDeptKn(selectDocReqKnrInsChangeList.get(0).getPreDeptKn());
		indto.setPreTitleCode(selectDocReqKnrInsChangeList.get(0).getPreTitleCode());
		indto.setPreJobForm(selectDocReqKnrInsChangeList.get(0).getPreJobForm());
		indto.setPreDcc(selectDocReqKnrInsChangeList.get(0).getPreDcc());
		indto.setPreUnivPosCode(selectDocReqKnrInsChangeList.get(0).getPreUnivPosCode());

		//異動区分　画面表示の切替に使用
		indto.setTrnKbn(selectDocReqKnrInsChangeList.get(0).getTrnKbn());

		//勤務情報（変更後）
		indto.setPostInsAbbrName(selectDocReqKnrInsChangeList.get(0).getPostInsAbbrName());
		indto.setPostDeptKj(selectDocReqKnrInsChangeList.get(0).getPostDeptKj());
		indto.setTitlePostTitleKj(StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getTitlePostTitleKj(),"--なし--"));
		indto.setKmuPostCodeKanj(StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getKmuPostCodeKanj(),"--なし--"));
		indto.setYakushinPostCodeKanj(StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getYakushinPostCodeKanj(),"--なし--"));
		indto.setUnivPostTitleKj(StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getUnivPostTitleKj(),"--なし--"));
		indto.setTekiyoDay(StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getTekiyoYmd(),indto.getTekiyoInitDay()));

		//コメント
		indto.setReqComment(StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getReqComment(), ""));
		indto.setAprComment(StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getAprComment(), ""));

		//入力項目活性・非活性制御
		indto.setInputFlg("1");
		indto.setReqCommentFlg("1");

		indto.setReqDestBtnFlg("1");
		indto.setTempReqBtnFlg("1");
		indto.setReqBtnFlg("1");

//		if (indto.getPreScreenId().equals("NC011")) {
//			indto.setReqShz(StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getReqShz(), "-"));
//			indto.setReqJgiName(StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getReqJgiName(), "-"));
//		}

        //動作確認用にjginoを変換しています。
		//製造完了したら不要 TODO
        if (!(indto.getGamenJgiNo() == null || !(indto.getGamenJgiNo().equals(" ")))){
        	loginInfo.setJgiNo(Integer.parseInt(indto.getGamenJgiNo()));
        }

		//1-3-1　入力項目
		//MR権限の場合、取得した申請管理．申請ステータスが'01'(保存済み)以外の場合は、入力項目はすべて変更不可（非活性）とする
        if (indto.getMrAdminFlg().equals("0")) {
        	if(!(indto.getReqSts().equals("01"))) {
        		indto.setInputFlg("0");
        		indto.setReqCommentFlg("0");
        	}
        }

        //管理者権限の場合、取得した申請管理．申請ステータスが'01'(保存済み)、'03'(承認待ち)、'13'(ULT承認待ち)以外の場合は、入力項目はすべて変更不可（非活性）とする
        if (indto.getMrAdminFlg().equals("1")) {
        	if (indto.getReqSts() == null) {
        		indto.setInputFlg("1");
        	}else if(!(indto.getReqSts().equals("01")||indto.getReqSts().equals("03")||indto.getReqSts().equals("13"))) {
        		indto.setInputFlg("0");
        		indto.setReqCommentFlg("0");
        	}
        }

        //完全新規(申請管理．申請ステータスが取得できない)の場合は活性
        if (indto.getReqSts() == null) {
        	indto.setInputFlg("1");
        }

        //取得した申請管理．申請者従業員番号とログインユーザ情報．従業員番号が異なる場合、申請コメント欄は変更不可（非活性）とする
        if (!(indto.getReqSts() == null) && !(StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getReqJgiNo(),"").equals(Integer.toString(loginInfo.getJgiNo())))) {
        	indto.setReqCommentFlg("0");
        }

        //申請前は「申請破棄」ボタンを非活性にする 非活性:0
        if (indto.getReqSts() == null) {
        	indto.setReqDestBtnFlg("0");
        }else if (!(indto.getReqSts().equals("01"))) {
            indto.setReqDestBtnFlg("0");
        }

        //申請管理．申請ステータスが取得できない（初回DB登録前）場合は、押下可（活性）とする
        //取得した申請管理．申請ステータスが'01'(保存済み)、'03'（承認待ち）、'13'(ULT承認待ち)以外の場合は、押下不可（非活性）とする
        if (indto.getReqSts() == null) {
        	indto.setTempReqBtnFlg("1");
        }else if (!(indto.getReqSts().equals("01")||indto.getReqSts().equals("03")||indto.getReqSts().equals("13"))) {
        	indto.setTempReqBtnFlg("0");
        }

        //申請管理．申請ステータスが取得できない（初回DB登録前）または'01'(保存済み)の場合：申請画面へボタンとして表示する
        if(indto.getReqSts() == null || indto.getReqSts().equals("01")) {
        	indto.setReqBtnFlg("1");
        }

        //自分が申請者(新規申請時または取得した申請管理．申請者従業員番号とログインユーザ情報．従業員番号が一致)の場合
        if(StringUtils.nvl(indto.getReqSts(),"").equals("01") || indto.getReqSts() == null || StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getReqJgiNo(),"").equals(Integer.toString(loginInfo.getJgiNo()))) {
        	indto.setReqBtnFlg("1");
        }



        if ((StringUtils.nvl(indto.getReqSts(),"").equals("01") || indto.getReqSts() == null || StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getReqJgiNo(),"").equals(Integer.toString(loginInfo.getJgiNo())))) {
        		indto.setReqBtnFlg("1");
        }else {
        	if(indto.getMrAdminFlg().equals("0")) {
        		if(!(indto.getReqSts().equals("01"))) {
        			indto.setReqBtnFlg("0");
        		}
        	}

        	if(indto.getMrAdminFlg().equals("1")) {
        		if(!(StringUtils.nvl(indto.getReqSts(),"").equals("01")||StringUtils.nvl(indto.getReqSts(),"").equals("03")||StringUtils.nvl(indto.getReqSts(),"").equals("13"))) {
        			indto.setReqBtnFlg("0");
        		}
        	}
        }

        setCombo(indto);

        return outdto;
    }

	/**
     * イベント処理
     * @param indto ND101DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO register(ND101DTO indto) {
    	BaseDTO outdto = indto;
    	setCombo(indto);
    	LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

        // 現在日付を取得
        Date systemDate = DateUtils.getNowDate();
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
        String sysDate = fmtDate.format(systemDate);

        String reqId = indto.getReqId();
        boolean errFlg = false;
        String errMsg = "";

        //エラーチェック　
        //一時保存押下時　ifで囲むこと
    	if(indto.getTempReqBtnFlg().equals("1")) {
    		// レングスチェック
            if(indto.getReqComment() != null && indto.getReqComment().length() > 300) {
            	// 最大文字数を超えています。（申請コメント）
    			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "申請コメント") + "\n";
    			errFlg = true;
            }
    	}
        // エラー時処理
        if(errFlg) {
        	indto.setMsgStr(errMsg);
        	init(indto);
        	return outdto;
        }

        // 申請ステータスを「01：保存済」として各テーブルに画面の申請情報を登録
        // 申請管理
        TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity();
        tRdmReqKnrEntity.setReqId(StringUtils.nvl(indto.getReqId(), ""));
        TRdmReqKnrEntity tRdmReqKnrData = dao.selectByPK(tRdmReqKnrEntity);

        if(tRdmReqKnrData == null) {
        	// 新規登録
        	// 新規にIDを取得 TODO
//        	SeqRdmReqIdEntity seqRdmReqIdEntity = new SeqRdmReqIdEntity();
//        	List<SeqRdmReqIdEntity> seqRdmReqIdDate = dao.select(seqRdmReqIdEntity);
//        	reqId = seqRdmReqIdDate.get(0).getReqId();
        	reqId = "250211-000001";

        	// レコードを登録
        	TRdmReqKnrEntity tRdmReqKnrInsData = new TRdmReqKnrEntity();
        	tRdmReqKnrInsData.setReqId(reqId);
        	if("1".equals(indto.getMrAdminFlg())) {
        		// 承認者（管理者権限）が申請の場合、'2'(DSG起因)
        		tRdmReqKnrInsData.setReqChl("2");
        		tRdmReqKnrInsData.setReqKngKbn("2");
        	} else {
        		// "MRが申請の場合、'1'(MR起因)
        		tRdmReqKnrInsData.setReqChl("1");
        		tRdmReqKnrInsData.setReqKngKbn("1");
        	}

        	if("0".equals(indto.getMovemedEditFlg())) {
        		tRdmReqKnrInsData.setReqType("42");
        	}else {
        		tRdmReqKnrInsData.setReqType("51");
        	}

        	tRdmReqKnrInsData.setReqStsCd("01");

        	SelectHenkanListEntity haifunHenkan = new SelectHenkanListEntity("ハイフン除去");
        	haifunHenkan.setSearchHenkan(indto.getSelectDay());
        	List<SelectHenkanListEntity> selectHaifun = dao.select(haifunHenkan);
        	indto.setSelectDay(selectHaifun.get(0).getSearchHenkan());


        	tRdmReqKnrInsData.setTekiyoYmd(indto.getSelectDay());
            //TODO
        	//直書きしているため修正必要　loginInfoから取得予定
        	//医薬支店C     brCode
        	tRdmReqKnrInsData.setReqBrCd("aaa");
        	//医薬営業所C   distCode
        	tRdmReqKnrInsData.setReqDistCd("bbb");
        	//組織名称      bumonRyakuName
        	tRdmReqKnrInsData.setReqShzNm("testSosName");

        	tRdmReqKnrInsData.setReqJgiNo(loginInfo.getJgiNo());
        	tRdmReqKnrInsData.setReqJgiName(loginInfo.getJgiName());
        	tRdmReqKnrInsData.setReqComment(indto.getReqComment());
        	tRdmReqKnrInsData.setDocNo(indto.getDocNo());
        	tRdmReqKnrInsData.setInsNo(indto.getInsNo());
        	tRdmReqKnrInsData.setInsShaYmd(systemDate);
        	tRdmReqKnrInsData.setInsShaYmd(systemDate);
        	tRdmReqKnrInsData.setInsShaId(Integer.toString(loginInfo.getJgiNo()));
        	tRdmReqKnrInsData.setUpdShaYmd(systemDate);
        	tRdmReqKnrInsData.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));

        	dao.insertByValue(tRdmReqKnrInsData);

        }else {
        	TRdmReqKnrEntity tRdmReqKnrUpdData = new TRdmReqKnrEntity("updateND101Data");
        	tRdmReqKnrUpdData.setReqId(reqId);

        	if("13".equals(indto.getReqSts())) {
        		tRdmReqKnrUpdData.setReqStsCd("11");
        	} else {
        		tRdmReqKnrUpdData.setReqStsCd("01");
        	}

        	SelectHenkanListEntity haifunHenkan = new SelectHenkanListEntity("ハイフン除去");
        	haifunHenkan.setSearchHenkan(indto.getSelectDay());
        	List<SelectHenkanListEntity> selectHaifun = dao.select(haifunHenkan);
        	indto.setSelectDay(selectHaifun.get(0).getSearchHenkan());

        	String tekiyoYmd = indto.getSelectDay();
        	tRdmReqKnrUpdData.setTekiyoYmd(tekiyoYmd);
        	tRdmReqKnrUpdData.setReqComment(indto.getReqComment());
        	tRdmReqKnrUpdData.setUpdShaYmd(systemDate);
        	tRdmReqKnrUpdData.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));

        	dao.update(tRdmReqKnrUpdData);
        }

        // 勤務先_申請管理
        TRdmHcpKmuReqEntity tRdmHcpKmuReqEntity = new TRdmHcpKmuReqEntity();
        tRdmHcpKmuReqEntity.setReqId(indto.getReqId());
        TRdmHcpKmuReqEntity tRdmHcpKmuReqData = dao.selectByPK(tRdmHcpKmuReqEntity);


        if(tRdmReqKnrData == null) {
        	TRdmHcpKmuReqEntity tRdmHcpKmuReqInsData = new TRdmHcpKmuReqEntity();
        	tRdmHcpKmuReqInsData.setReqId(reqId);
        	tRdmHcpKmuReqInsData.setDocNo(indto.getDocNo());
        	tRdmHcpKmuReqInsData.setInsNoMt(indto.getPreInsNo());
        	tRdmHcpKmuReqInsData.setInsNoSk(StringUtils.nvl(indto.getPostInsNo(), "Z"));
        	tRdmHcpKmuReqInsData.setJobFormBf(StringUtils.nvl(indto.getPreJobForm(), "Z"));
        	tRdmHcpKmuReqInsData.setDeptCodeBf(StringUtils.nvl(indto.getPreDeptCode(), "Z"));
        	tRdmHcpKmuReqInsData.setDeptKanjiBf(StringUtils.nvl(indto.getPreDeptKj(), "Z"));
        	tRdmHcpKmuReqInsData.setDeptKanaBf(StringUtils.nvl(indto.getPreDeptKn(), "Z"));
        	tRdmHcpKmuReqInsData.setUnivPosCodeBf(indto.getPreUnivPosCode());
        	tRdmHcpKmuReqInsData.setTitleCodeBf(indto.getPreTitleCode());
        	tRdmHcpKmuReqInsData.setDccTypeBf(indto.getPreDcc());
        	tRdmHcpKmuReqInsData.setJobFormAf(StringUtils.nvl(indto.getJobForm(), "Z"));
        	tRdmHcpKmuReqInsData.setDeptCodeAf(StringUtils.nvl(indto.getPostDeptCode(), "Z"));
        	tRdmHcpKmuReqInsData.setDeptKanjiAf(StringUtils.nvl(indto.getPostDeptKj(), "Z"));
        	tRdmHcpKmuReqInsData.setDeptKanaAf(StringUtils.nvl(indto.getPostDeptKn(), "Z"));
        	tRdmHcpKmuReqInsData.setUnivPosCodeAf(indto.getDigakuShokui());
        	tRdmHcpKmuReqInsData.setTitleCodeAf(indto.getYakushoku());
        	tRdmHcpKmuReqInsData.setDccTypeAf(indto.getDcc());
        	tRdmHcpKmuReqInsData.setUltDocNo(indto.getUltDocNo());
        	if(indto.getPreUltInsNo().equals(indto.getPostUltInsNo())) {
        		tRdmHcpKmuReqInsData.setUltInsNo(null);
        	}else if(indto.getPostUltInsNo() == null){
        		tRdmHcpKmuReqInsData.setUltInsNo("Z");
        	}else {
        		tRdmHcpKmuReqInsData.setUltInsNo(indto.getPostUltInsNo());
        	}
        	tRdmHcpKmuReqInsData.setInsShaYmd(systemDate);
        	tRdmHcpKmuReqInsData.setInsShaId(Integer.toString(loginInfo.getJgiNo()));
        	tRdmHcpKmuReqInsData.setUpdShaYmd(systemDate);
        	tRdmHcpKmuReqInsData.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));

        	dao.insertByValue(tRdmHcpKmuReqInsData);
        }else {
        	TRdmHcpKmuReqEntity tRdmHcpKmuReqUpdData = new TRdmHcpKmuReqEntity("updateND101Data");
        	tRdmHcpKmuReqUpdData.setReqId(reqId);
        	tRdmHcpKmuReqUpdData.setInsNoSk(StringUtils.nvl(indto.getPostInsNo(), "Z"));
        	tRdmHcpKmuReqUpdData.setJobFormAf(StringUtils.nvl(indto.getJobForm(), "Z"));
        	tRdmHcpKmuReqUpdData.setDeptCodeAf(StringUtils.nvl(indto.getPostDeptCode(), "Z"));
        	tRdmHcpKmuReqUpdData.setDeptKanjiAf(StringUtils.nvl(indto.getPostDeptKj(), "Z"));
        	tRdmHcpKmuReqUpdData.setDeptKanaAf(StringUtils.nvl(indto.getPostDeptKn(), "Z"));
        	tRdmHcpKmuReqUpdData.setUnivPosCodeAf(StringUtils.nvl(indto.getDigakuShokui(),""));
        	tRdmHcpKmuReqUpdData.setTitleCodeAf(StringUtils.nvl(indto.getYakushoku(),""));
        	tRdmHcpKmuReqUpdData.setDccTypeAf(StringUtils.nvl(indto.getDcc(),""));
        	if(indto.getPreUltInsNo().equals(indto.getPostUltInsNo())) {
        		tRdmHcpKmuReqUpdData.setUltInsNo(null);
        	}else if(indto.getPostUltInsNo() == null){
        		tRdmHcpKmuReqUpdData.setUltInsNo("Z");
        	}else {
        		tRdmHcpKmuReqUpdData.setUltInsNo(indto.getPostUltInsNo());
        	}
        	tRdmHcpKmuReqUpdData.setUpdShaYmd(systemDate);
        	tRdmHcpKmuReqUpdData.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));


        	dao.update(tRdmHcpKmuReqUpdData);
        }
        indto.setReqId(reqId);

        outdto = init(indto);

    	return outdto;
    }

    /**
     * イベント処理
     * @param indto ND101DTO
     * @return 遷移先DTO
     * @customizable
    */
   @Transactional
   public BaseDTO cancel(ND101DTO indto) {
	   BaseDTO outdto = indto;
	   setCombo(indto);

       // START UOC
       // 申請管理を物理削除
       TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity();
       tRdmReqKnrEntity.setReqId(indto.getReqId());
       dao.deleteByPK(tRdmReqKnrEntity);
       // 申請管理を物理削除
       TRdmHcpKmuReqEntity tRdmHcpKmuReqEntity = new TRdmHcpKmuReqEntity();
       tRdmHcpKmuReqEntity.setReqId(indto.getReqId());
       dao.deleteByPK(tRdmHcpKmuReqEntity);
       indto.setForward(indto.getPreScreenId());
	   return outdto;
   }

    public void setCombo(ND101DTO indto) {
    	//1-2 ドロップダウンリストの生成
        //役職
    	SelectNd101YakushokuComboListEntity selectNd101YakushokuComboListEntity = new SelectNd101YakushokuComboListEntity();
    	List<SelectNd101YakushokuComboListEntity> selectNd101YakushokuComboList;
    	selectNd101YakushokuComboListEntity.setInDataKbn("0");
    	selectNd101YakushokuComboList = dao.select(selectNd101YakushokuComboListEntity);
    	LinkedHashMap<String, String> mapYakushoku = new LinkedHashMap<String, String>();
    	mapYakushoku.put(null, "--選択してください--");
        for (SelectNd101YakushokuComboListEntity outEntity : selectNd101YakushokuComboList) {
        	mapYakushoku.put(outEntity.getTitleCode(),outEntity.getTitleKj());
        }
        indto.setYakushokuCombo(mapYakushoku);
        if(!(indto.getReqSts() == null)) {
        	indto.setYakushoku(indto.getPostTitleCode());
        }

        //勤務形態
        SelectNd101ComboListEntity selectNd101ComboListEntity = new SelectNd101ComboListEntity();
        List<SelectNd101ComboListEntity> selectNd101ComboList;
        selectNd101ComboListEntity.setInDataKbn("JOB_FORM");
        selectNd101ComboList = dao.select(selectNd101ComboListEntity);
        LinkedHashMap<String, String> mapJobForm = new LinkedHashMap<String, String>();
        mapJobForm.put(null, "--なし--");
        for (SelectNd101ComboListEntity outEntity : selectNd101ComboList) {
        	mapJobForm.put(outEntity.getValue1(),outEntity.getValue1Kanj());
        }
        indto.setJobFormCombo(mapJobForm);
        if(!(indto.getReqSts() == null)) {
        	indto.setJobForm(indto.getPostJobForm());
        }

        //薬審メンバー区分
        SelectNd101ComboListEntity selectNd101ComboListEntity2 = new SelectNd101ComboListEntity();
        List<SelectNd101ComboListEntity> selectNd101ComboList2;
        selectNd101ComboListEntity2.setInDataKbn("DCC");
        selectNd101ComboList2 = dao.select(selectNd101ComboListEntity2);
        LinkedHashMap<String, String> mapDcc = new LinkedHashMap<String, String>();
        mapDcc.put(null, "--なし--");
        for (SelectNd101ComboListEntity outEntity : selectNd101ComboList2) {
        	mapDcc.put(outEntity.getValue1(),outEntity.getValue1Kanj());
        }
        indto.setDccCombo(mapDcc);
        if(!(indto.getReqSts() == null)) {
        	indto.setDcc(indto.getPostDcc());
        }

        //大学職位
    	SelectNd101YakushokuComboListEntity selectNd101YakushokuComboListEntity2 = new SelectNd101YakushokuComboListEntity();
    	List<SelectNd101YakushokuComboListEntity> selectNd101YakushokuComboList2;
    	selectNd101YakushokuComboListEntity2.setInDataKbn("1");
    	selectNd101YakushokuComboList2 = dao.select(selectNd101YakushokuComboListEntity2);
    	LinkedHashMap<String, String> mapDigakuShokui = new LinkedHashMap<String, String>();
    	mapDigakuShokui.put(null, "--選択してください--");
        for (SelectNd101YakushokuComboListEntity outEntity : selectNd101YakushokuComboList2) {
        	mapDigakuShokui.put(outEntity.getTitleCode(),outEntity.getTitleKj());
        }
        indto.setDigakuShokuiCombo(mapDigakuShokui);
        if(!(indto.getReqSts() == null)) {
        	indto.setDigakuShokui(indto.getPostUnivPosCode());
        }

      //翌日日付_RDM用カレンダー(オンライン用)_生成用エンティティ
    	SelectTmrEntity selectTmrEntity = new SelectTmrEntity();

        //翌日日付_RDM用カレンダー(オンライン用)の帳票一覧を取得する
        List<SelectTmrEntity> selectTmrList = dao.select(selectTmrEntity);

        // SimpleDateFormatで日付フォーマット設定
     	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //翌日日付データ_取り出す（リストの[0]を取得)
        for (SelectTmrEntity entity : selectTmrList) {
            //検索結果_翌日日付
            indto.setTekiyoInitDay(sdf.format(entity.getCalDate()));
        }
        //申請一覧からの遷移の場合は適用日を表示する
        if(!(indto.getReqSts() == null)) {
        	indto.setTekiyoDay(indto.getTekiyoDay().substring(0,4) + "-" + indto.getTekiyoDay().substring(4,6) + "-" +  indto.getTekiyoDay().substring(6,8));
        }
    }

}
