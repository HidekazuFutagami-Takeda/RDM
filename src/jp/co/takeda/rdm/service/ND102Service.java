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
import jp.co.takeda.rdm.entity.join.SelectDocReqKnrInsChangeEntity;
import jp.co.takeda.rdm.entity.join.SelectHenkanListEntity;
import jp.co.takeda.rdm.entity.join.SelectNd101MainDataEntity;
import jp.co.takeda.rdm.entity.join.SelectNd102ClosedCheckEntity;
import jp.co.takeda.rdm.entity.join.SelectNd102MrDummyCheckEntity;
import jp.co.takeda.rdm.entity.join.SelectNd102MultipleWorkCheckEntity;
import jp.co.takeda.rdm.entity.join.SelectTmrEntity;
import jp.co.takeda.rdm.dto.ND102DTO;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.entity.join.SeqRdmReqIdEntity;
import jp.co.takeda.rdm.entity.join.TRdmHcpKmuReqEntity;
import jp.co.takeda.rdm.entity.join.TRdmReqKnrEntity;
import jp.co.takeda.rdm.entity.join.SelectNd102TrnListEntity;
import jp.co.takeda.rdm.util.DateUtils;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * Serviceクラス（ND102)
 * @generated
 */
@Named
public class ND102Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(ND102Service.class);

    /**
     * イベント処理
     * @param indto ND102DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(ND102DTO indto) {

    	BaseDTO outdto = indto;
    	//1-1 権限判定
        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

        //ドロップダウンリスト等の作成
        setCombo(indto);
        //セッションから権限フラグ、遷移元画面取得
        indto.setMrAdminFlg(loginInfo.getJokenFlg());
        indto.setPreScreenId(loginInfo.getPreScreenId());
        //一時保存押下フラグのセット
        if(StringUtils.isEmpty(indto.getTempButtonExecuted()) || indto.getPreScreenId().equals("ND309")) {
        	indto.setTempButtonExecuted("0");
        }

        SelectDocReqKnrInsChangeEntity selectDocReqKnrInsChangeEntity = new SelectDocReqKnrInsChangeEntity();

        List<SelectDocReqKnrInsChangeEntity> selectDocReqKnrInsChangeList = new ArrayList<SelectDocReqKnrInsChangeEntity>();;
        //遷移元画面フラグ 申請済み、一時保存ボタン押下時:1 申請なしの場合:0
        if(!"9".equals(indto.getDisplayKbn())) {
        	if("0".equals(indto.getDisplayKbn())) {
        		if (!(indto.getPreScreenId().equals("ND309") || indto.getPreScreenId().equals("ND102"))) {
        			indto.setNd102PreScreenId(indto.getPreScreenId());
        		}
        		selectDocReqKnrInsChangeEntity.setInReqFlg(0);
        		selectDocReqKnrInsChangeEntity.setInDocNo(indto.getDocNo());
        		selectDocReqKnrInsChangeEntity.setInInsNo(indto.getInsNo());
        		selectDocReqKnrInsChangeList = dao.select(selectDocReqKnrInsChangeEntity);

        		indto.setReqId("-");
        		indto.setReqShz(loginInfo.getBumonRyakuName());
        		indto.setReqStsNm("-");
        		indto.setReqJgiName(loginInfo.getJgiName());
        		indto.setReqYmdhms("-");
        		//ヘッダ部隠し項目
        		indto.setReqDistCode(loginInfo.getDistCode());
        		indto.setReqBrCode(loginInfo.getBrCode());
        	}else {
        		if (!(indto.getPreScreenId().equals("ND309") || indto.getPreScreenId().equals("ND102"))) {
        			indto.setNd102PreScreenId(indto.getPreScreenId());
        		}
        		selectDocReqKnrInsChangeEntity.setInReqId(indto.getReqId());
        		selectDocReqKnrInsChangeEntity.setInReqFlg(1);
        		selectDocReqKnrInsChangeList = dao.select(selectDocReqKnrInsChangeEntity);

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

        		indto.setShnShaName(StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getShnShaName(), ""));
        		indto.setShnYmdhms(StringUtils.dispYmdhms(selectDocReqKnrInsChangeList.get(0).getShnYmdhms()));
        		indto.setAprShaName(StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getAprShaName(), ""));
        		indto.setAprYmdhms(StringUtils.dispYmdhms(selectDocReqKnrInsChangeList.get(0).getAprYmdhms()));
        		indto.setShnJgiNo(selectDocReqKnrInsChangeList.get(0).getShnJgiNo());
        		indto.setAprJgiNo(selectDocReqKnrInsChangeList.get(0).getAprJgiNo());
        		indto.setShnFlg(StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getShnFlg(), "0"));
        		indto.setAprMemo(StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getAprMemo(), ""));
        		indto.setReqChl(selectDocReqKnrInsChangeList.get(0).getReqChl());

        		//隠し項目（変更後）
        		indto.setPostInsNo(selectDocReqKnrInsChangeList.get(0).getPostInsNo());
        		indto.setPostUltInsNo(selectDocReqKnrInsChangeList.get(0).getPostUltInsNo());
        		indto.setPostDeptCode(selectDocReqKnrInsChangeList.get(0).getPostDeptCode());
        		indto.setPostDeptKn(selectDocReqKnrInsChangeList.get(0).getPostDeptKn());
        		indto.setPostTitleCode(selectDocReqKnrInsChangeList.get(0).getPostTitleCode());
        		indto.setPostJobForm(selectDocReqKnrInsChangeList.get(0).getPostJobForm());
        		indto.setPostDcc(selectDocReqKnrInsChangeList.get(0).getPostDcc());
        		indto.setPostUnivPosCode(selectDocReqKnrInsChangeList.get(0).getPostUnivPosCode());

        		indto.setTrnKbnCd(selectDocReqKnrInsChangeList.get(0).getTrnKbn());
        		//異動区分
        		SelectNd102TrnListEntity selectNd102TrnListEntity = new SelectNd102TrnListEntity();
        		List<SelectNd102TrnListEntity> selectNd102TrnList;
        		selectNd102TrnList = dao.select(selectNd102TrnListEntity);
        		//表示用
        		LinkedHashMap<String, String> mapTrnKbn = new LinkedHashMap<String, String>();
        		mapTrnKbn.put(null, "--選択してください--");
        		for (SelectNd102TrnListEntity outEntity : selectNd102TrnList) {
        			mapTrnKbn.put(outEntity.getTrnValue1(),outEntity.getValue1Kanj());
        		}

        		indto.setPostTrnKbn(mapTrnKbn.get(indto.getTrnKbnCd()));
        	}
        	//以下共通
        	//基本情報
        	indto.setDocKanj(StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getDocKanj(), "-"));

        	//基本情報隠し項目
        	indto.setDocNo(selectDocReqKnrInsChangeList.get(0).getDocNo());
        	indto.setUltDocNo(selectDocReqKnrInsChangeList.get(0).getUltDocNo());

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

        	//表示する適用日の設定
        	if(StringUtils.isEmpty(selectDocReqKnrInsChangeList.get(0).getTekiyoYmd())) {
        		String tempDispTekiyoYmd = indto.getTekiyoInitDay();
        		indto.setDispTekiyoYmd(tempDispTekiyoYmd.substring(0,4) + "-" + tempDispTekiyoYmd.substring(4,6) + "-" +  tempDispTekiyoYmd.substring(6,8));
        	} else {
        		String tempDispTekiyoYmd = selectDocReqKnrInsChangeList.get(0).getTekiyoYmd();
        		indto.setDispTekiyoYmd(tempDispTekiyoYmd.substring(0,4) + "-" + tempDispTekiyoYmd.substring(4,6) + "-" +  tempDispTekiyoYmd.substring(6,8));
        	}

        	//コメント
        	indto.setReqComment(StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getReqComment(), ""));
        	indto.setAprComment(StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getAprComment(), ""));
        }
		//1-3-1　入力項目
		//MR権限の場合、取得した申請管理．申請ステータスが'01'(保存済み)以外の場合は、入力項目はすべて変更不可（非活性）とする
        //管理者権限の場合、取得した申請管理．申請ステータスが'01'(保存済み)、'03'(承認待ち)、'13'(ULT承認待ち)以外の場合は、入力項目はすべて変更不可（非活性）とする
        if (indto.getMrAdminFlg().equals("0")) {
        	if (StringUtils.isEmpty(indto.getReqSts()) || indto.getReqSts().equals("01")) {
        		indto.setInputFlg("1");
        		indto.setReqCommentFlg("1");
        	}else {
        		indto.setInputFlg("0");
        		indto.setReqCommentFlg("0");
        	}
        }else  {
        	if (StringUtils.isEmpty(indto.getReqSts()) || indto.getReqSts().equals("01")||indto.getReqSts().equals("03")||indto.getReqSts().equals("13")||indto.getReqSts().equals("11")) {
        		indto.setInputFlg("1");
        	}else {
        		indto.setInputFlg("0");
        		indto.setReqCommentFlg("0");
        	}
        }

        if(!"9".equals(indto.getDisplayKbn())) {
        	// 取得した申請管理．申請者従業員番号とログインユーザ情報．従業員番号が異なる場合、申請コメント欄は変更不可（非活性）とする
        	if (StringUtils.isEmpty(indto.getReqSts()) || StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getReqJgiNo(), "")
        			.equals(Integer.toString(loginInfo.getJgiNo()))) {
        		if(indto.getMrAdminFlg().equals("1")) {
        			//申請者であり管理者の場合、申請前、保存済みの状態の場合のみ申請コメントを活性
        			if(StringUtils.isEmpty(indto.getReqSts()) || indto.getReqSts().equals("01") || indto.getReqSts().equals("11")) {
        				indto.setReqCommentFlg("1");
        			}else {
        				indto.setReqCommentFlg("0");
        			}
        		}else {
        			if(StringUtils.isEmpty(indto.getReqSts())) {
        				indto.setReqCommentFlg("1");
        			}else {
        				indto.setReqCommentFlg("0");
        			}

        		}

        	} else {
        		indto.setReqCommentFlg("0");
        	}
        } else {
        	// 取得した申請管理．申請者従業員番号とログインユーザ情報．従業員番号が異なる場合、申請コメント欄は変更不可（非活性）とする
        	if (StringUtils.isEmpty(indto.getReqSts())) {
        		if(indto.getMrAdminFlg().equals("1")) {
        			//申請者であり管理者の場合、申請前、保存済みの状態の場合のみ申請コメントを活性
        			if(StringUtils.isEmpty(indto.getReqSts()) || indto.getReqSts().equals("01") || indto.getReqSts().equals("11")) {
        				indto.setReqCommentFlg("1");
        			}else {
        				indto.setReqCommentFlg("0");
        			}
        		}else {
        			if(StringUtils.isEmpty(indto.getReqSts())) {
        				indto.setReqCommentFlg("1");
        			}else {
        				indto.setReqCommentFlg("0");
        			}

        		}

        	} else {
        		indto.setReqCommentFlg("1");
        	}
        }
        //申請前は「申請破棄」ボタンを非活性にする 非活性:0
        if (StringUtils.isEmpty(indto.getReqSts())|| !((indto.getReqSts().equals("01")) || indto.getReqSts().equals("11")|| indto.getReqSts().equals("13"))) {
        	indto.setReqDestBtnFlg("0");
        }else {
        	if(indto.getMrAdminFlg().equals("0") && (indto.getReqSts().equals("11")|| indto.getReqSts().equals("13"))) {
        		indto.setReqDestBtnFlg("0");
        	}else {
        		indto.setReqDestBtnFlg("1");
        	}
        }

        //申請管理．申請ステータスが取得できない（初回DB登録前）場合は、押下可（活性）とする
        //取得した申請管理．申請ステータスが'01'(保存済み)、'03'（承認待ち）、'13'(ULT承認待ち)以外の場合は、押下不可（非活性）とする
		if (indto.getMrAdminFlg().equals("0")) {
			if (StringUtils.isEmpty(indto.getReqSts()) || indto.getReqSts().equals("01")) {
				indto.setTempReqBtnFlg("1");
			} else {
				indto.setTempReqBtnFlg("0");
			}
		} else {
			if (StringUtils.isEmpty(indto.getReqSts()) || (indto.getReqSts().equals("01") ||  indto.getReqSts().equals("13") || indto.getReqSts().equals("11"))) {
				indto.setTempReqBtnFlg("1");
			} else{
				indto.setTempReqBtnFlg("0");
			}
		}
        //申請管理．申請ステータスが取得できない（初回DB登録前）または'01'(保存済み)の場合：申請画面へボタンとして表示する
        if(StringUtils.isEmpty(indto.getReqSts()) || indto.getReqSts().equals("01") || indto.getReqSts().equals("11")) {
        	indto.setReqBtnFlg("1");
        }
        //申請画面へボタン　活性非活性処理
        String tempJgiNo = Integer.toString(loginInfo.getJgiNo());
        if(!"9".equals(indto.getDisplayKbn())) {
        	tempJgiNo = StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getReqJgiNo(), "");
        }
        //MR権限の場合
		if (indto.getMrAdminFlg().equals("0") && ((StringUtils.isEmpty(tempJgiNo) || tempJgiNo.equals(Integer.toString(loginInfo.getJgiNo()))))) {
			if ( StringUtils.isEmpty(indto.getReqSts())|| indto.getReqSts().equals("01")) {
				indto.setReqBtnActiveFlg("1");
			}else {
				indto.setReqBtnActiveFlg("0");
			}

		}else {
			indto.setReqBtnActiveFlg("0");
		}
		//管理者権限の場合
		if (indto.getMrAdminFlg().equals("1")) {
			if (StringUtils.isEmpty(indto.getReqSts())||StringUtils.nvl(indto.getReqSts(), "").equals("01")|| StringUtils.nvl(indto.getReqSts(), "").equals("03")|| StringUtils.nvl(indto.getReqSts(), "").equals("13")|| StringUtils.nvl(indto.getReqSts(), "").equals("11")) {
				indto.setReqBtnFlg("1");
				indto.setReqBtnActiveFlg("1");
			}else {
				indto.setReqBtnActiveFlg("0");
			}

		}

        //ドロップダウンリスト等の作成
        setCombo(indto);

        return outdto;
    }

	/**
     * イベント処理
     * @param indto ND102DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO register(ND102DTO indto) {
    	BaseDTO outdto = indto;
    	setCombo(indto);
		//表示する適用日の設定
		if(!StringUtils.isEmpty(indto.getSelectDay())) {
			indto.setDispTekiyoYmd(indto.getSelectDay());
		}
		LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

        // 現在日付を取得
        Date systemDate = DateUtils.getNowDate();
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
        String sysDate = fmtDate.format(systemDate);

        //選択された異動区分から異動区分（施設コード）を設定
        LinkedHashMap<String, String> mapTrnKbnInsNo = new LinkedHashMap<String, String>();
        mapTrnKbnInsNo = indto.getTrnKbnInsNoCombo();
        indto.setTrnKbnInsNo(mapTrnKbnInsNo.get(indto.getTrnKbnCd()));

        String reqId = indto.getReqId();
        boolean errFlg = false;
        String errMsg = "";

//        //エラーチェック　
//        //一時保存押下時　ifで囲むこと
//    	if(indto.getTempReqBtnFlg().equals("1")) {
//    		// レングスチェック
//            if(indto.getReqComment() != null && indto.getReqComment().length() > 300) {
//            	// 最大文字数を超えています。（申請コメント）
//    			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "申請コメント") + "\n";
//    			errFlg = true;
//            }
//    	}
//        // エラー時処理
//        if(errFlg) {
//        	indto.setMsgStr(errMsg);
//        	init(indto);
//        	return outdto;
//        }
        //一時保存ボタン押下の場合
        if ("0".equals(indto.getButtonFlg()) || indto.getTempButtonExecuted().equals("1")) {
        	// チェック処理（簡易）
        	if(checkInput(loginInfo,indto,false)) {
        		// 編集可能判定
        		if("".equals(indto.getReqSts()) || indto.getReqSts() == null) {
        			// 完全新規(申請管理．申請ステータスが取得できない)の場合は活性
        			indto.setInputFlg("1");
        		} else if(!RdmConstantsData.RDM_JKN_ADMIN.equals(loginInfo.getJokenSetCd()) && !"01".equals(indto.getReqSts())) {
        			// MR権限の場合、取得した申請管理．申請ステータスが'01'(保存済み)以外の場合は、入力項目はすべて変更不可（非活性）とする
        			indto.setInputFlg("0");
        		} else if(RdmConstantsData.RDM_JKN_ADMIN.equals(loginInfo.getJokenSetCd()) && !"01".equals(indto.getReqSts()) && !"11".equals(indto.getReqSts())
        				&& !"03".equals(indto.getReqSts()) && !"13".equals(indto.getReqSts())) {
        			// 管理者権限の場合、取得した申請管理．申請ステータスが'01'(保存済み)、'03'(承認待ち)、'13'(ULT承認待ち)以外の場合は、入力項目はすべて変更不可（非活性）とする
        			indto.setInputFlg("0");
        		} else {
        			indto.setInputFlg("1");
        		}
        		return outdto;
        	}
        }
        //申請ボタン押下の場合または承認ボタン押下の場合
        if ("1".equals(indto.getButtonFlg()) || "3".equals(indto.getButtonFlg())) {
        	// チェック処理（FULL）
        	if(checkInput(loginInfo,indto,true)) {
        		// 編集可能判定
        		if("".equals(indto.getReqSts()) || indto.getReqSts() == null) {
        			// 完全新規(申請管理．申請ステータスが取得できない)の場合は活性
        			indto.setInputFlg("1");
        		} else if(!RdmConstantsData.RDM_JKN_ADMIN.equals(loginInfo.getJokenSetCd()) && !"01".equals(indto.getReqSts())) {
        			// MR権限の場合、取得した申請管理．申請ステータスが'01'(保存済み)以外の場合は、入力項目はすべて変更不可（非活性）とする
        			indto.setInputFlg("0");
        		} else if(RdmConstantsData.RDM_JKN_ADMIN.equals(loginInfo.getJokenSetCd()) && !"01".equals(indto.getReqSts()) && !"11".equals(indto.getReqSts())
        				&& !"03".equals(indto.getReqSts()) && !"13".equals(indto.getReqSts())) {
        			// 管理者権限の場合、取得した申請管理．申請ステータスが'01'(保存済み)、'03'(承認待ち)、'13'(ULT承認待ち)以外の場合は、入力項目はすべて変更不可（非活性）とする
        			indto.setInputFlg("0");
        		} else {
        			indto.setInputFlg("1");
        		}
        		return outdto;
        	}
        }
        //一時保存ボタン押下の場合
        if ("0".equals(indto.getButtonFlg()) || indto.getTempButtonExecuted().equals("1")) {
        	// 申請ステータスを「01：保存済」として各テーブルに画面の申請情報を登録
        	// 申請管理
        	TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity();
        	tRdmReqKnrEntity.setReqId(StringUtils.nvl(indto.getReqId(), ""));
        	TRdmReqKnrEntity tRdmReqKnrData = dao.selectByPK(tRdmReqKnrEntity);

        	if(tRdmReqKnrData == null) {
        		// 新規登録
        		SeqRdmReqIdEntity seqRdmReqIdEntity = new SeqRdmReqIdEntity();
        		List<SeqRdmReqIdEntity> seqRdmReqIdDate = dao.select(seqRdmReqIdEntity);
        		reqId = seqRdmReqIdDate.get(0).getReqId();
        		indto.setReqId(reqId);
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

        		tRdmReqKnrInsData.setReqType("43");

        		tRdmReqKnrInsData.setReqStsCd("01");

        		if (!(StringUtils.isEmpty(indto.getSelectDay()))) {
        			SelectHenkanListEntity haifunHenkan = new SelectHenkanListEntity("ハイフン除去");
        			haifunHenkan.setSearchHenkan(indto.getSelectDay());
        			List<SelectHenkanListEntity> selectHaifun = dao.select(haifunHenkan);
        			indto.setSelectDay(selectHaifun.get(0).getSearchHenkan());
        		}
        		String tekiyoYmd = indto.getSelectDay();
        		if(!StringUtils.isEmpty(tekiyoYmd)) {
        			tekiyoYmd = tekiyoYmd.replace("-", "");
        		}
        		tRdmReqKnrInsData.setTekiyoYmd(tekiyoYmd);
        		tRdmReqKnrInsData.setReqBrCd(loginInfo.getBrCode());
        		tRdmReqKnrInsData.setReqDistCd(loginInfo.getDistCode());
        		tRdmReqKnrInsData.setReqShzNm(loginInfo.getBumonRyakuName());

        		tRdmReqKnrInsData.setReqJgiNo(loginInfo.getJgiNo());
        		tRdmReqKnrInsData.setReqJgiName(loginInfo.getJgiName());
        		tRdmReqKnrInsData.setReqComment(indto.getReqComment());
        		tRdmReqKnrInsData.setDocNo(indto.getDocNo());
        		tRdmReqKnrInsData.setInsNo(StringUtils.nvl(indto.getTrnKbnInsNo(), ""));
        		tRdmReqKnrInsData.setInsShaYmd(systemDate);
        		tRdmReqKnrInsData.setInsShaId(Integer.toString(loginInfo.getJgiNo()));
        		tRdmReqKnrInsData.setUpdShaYmd(systemDate);
        		tRdmReqKnrInsData.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));

        		dao.insertByValue(tRdmReqKnrInsData);

        	}else {
        		TRdmReqKnrEntity tRdmReqKnrUpdData = new TRdmReqKnrEntity("updateND102Data");
        		tRdmReqKnrUpdData.setReqId(reqId);

    			if("11".equals(indto.getReqSts())) {
    				tRdmReqKnrUpdData.setReqStsCd("11");
    			} else if("03".equals(indto.getReqSts()) || "13".equals(indto.getReqSts())) {
    				tRdmReqKnrUpdData.setReqStsCd(indto.getReqSts());
    			} else {
    				tRdmReqKnrUpdData.setReqStsCd("01");
    			}

        		tRdmReqKnrUpdData.setInsNo(StringUtils.nvl(indto.getTrnKbnInsNo(), ""));

        		if (!(StringUtils.isEmpty(indto.getSelectDay()))) {
        			SelectHenkanListEntity haifunHenkan = new SelectHenkanListEntity("ハイフン除去");
        			haifunHenkan.setSearchHenkan(indto.getSelectDay());
        			List<SelectHenkanListEntity> selectHaifun = dao.select(haifunHenkan);
        			indto.setSelectDay(selectHaifun.get(0).getSearchHenkan());
        		}
        		String tekiyoYmd = indto.getSelectDay();
        		if(!StringUtils.isEmpty(tekiyoYmd)) {
        			tekiyoYmd = tekiyoYmd.replace("-", "");
        		}
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


        	if(tRdmHcpKmuReqData == null) {
        		TRdmHcpKmuReqEntity tRdmHcpKmuReqInsData = new TRdmHcpKmuReqEntity();
        		tRdmHcpKmuReqInsData.setReqId(reqId);
        		tRdmHcpKmuReqInsData.setDocNo(indto.getDocNo());
        		tRdmHcpKmuReqInsData.setInsNoMt(indto.getPreInsNo());
        		tRdmHcpKmuReqInsData.setTrnKbn(StringUtils.nvl(indto.getTrnKbnCd(), ""));
        		tRdmHcpKmuReqInsData.setInsNoSk(StringUtils.nvl(indto.getTrnKbnInsNo(), ""));
        		tRdmHcpKmuReqInsData.setJobFormBf(StringUtils.nvl(indto.getPreJobForm(), ""));
        		tRdmHcpKmuReqInsData.setDeptCodeBf(StringUtils.nvl(indto.getPreDeptCode(), ""));
        		tRdmHcpKmuReqInsData.setDeptKanjiBf(StringUtils.nvl(indto.getPreDeptKj(), ""));
        		tRdmHcpKmuReqInsData.setDeptKanaBf(StringUtils.nvl(indto.getPreDeptKn(), ""));
        		tRdmHcpKmuReqInsData.setUnivPosCodeBf(indto.getPreUnivPosCode());
        		tRdmHcpKmuReqInsData.setTitleCodeBf(indto.getPreTitleCode());
        		tRdmHcpKmuReqInsData.setDccTypeBf(indto.getPreDcc());
        		tRdmHcpKmuReqInsData.setJobFormAf("Z");
        		tRdmHcpKmuReqInsData.setDeptCodeAf("9999");
        		tRdmHcpKmuReqInsData.setDeptKanjiAf("Z");
        		tRdmHcpKmuReqInsData.setDeptKanaAf("Z");
        		tRdmHcpKmuReqInsData.setUltDocNo(indto.getUltDocNo());
        		tRdmHcpKmuReqInsData.setInsShaYmd(systemDate);
        		tRdmHcpKmuReqInsData.setInsShaId(Integer.toString(loginInfo.getJgiNo()));
        		tRdmHcpKmuReqInsData.setUpdShaYmd(systemDate);
        		tRdmHcpKmuReqInsData.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));

        		dao.insertByValue(tRdmHcpKmuReqInsData);
        	}else {
        		TRdmHcpKmuReqEntity tRdmHcpKmuReqUpdData = new TRdmHcpKmuReqEntity("updateND102Data");
        		tRdmHcpKmuReqUpdData.setReqId(reqId);
        		tRdmHcpKmuReqUpdData.setTrnKbn(StringUtils.nvl(indto.getTrnKbnCd(), ""));
        		tRdmHcpKmuReqUpdData.setInsNoSk(StringUtils.nvl(indto.getTrnKbnInsNo(), ""));
        		//ult医師コード最新化
        		SelectDocReqKnrInsChangeEntity selectDocReqKnrInsChangeEntity = new SelectDocReqKnrInsChangeEntity();
        		selectDocReqKnrInsChangeEntity.setInReqFlg(0);
        		selectDocReqKnrInsChangeEntity.setInDocNo(indto.getDocNo());
        		selectDocReqKnrInsChangeEntity.setInInsNo(indto.getPreInsNo());
        		String tempUltDocNo;
        		List<SelectDocReqKnrInsChangeEntity> selectDocReqKnrInsChangeList = dao.select(selectDocReqKnrInsChangeEntity);
        		if(selectDocReqKnrInsChangeList == null) {
        			tempUltDocNo = "";
        		}else {
        			tempUltDocNo = StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getUltDocNo(),"");
        		}
        		tRdmHcpKmuReqUpdData.setUltDocNo(tempUltDocNo);
        		//            //異動でない（異動元と異動先の施設コードが同じ、異動先のULT施設コードがnull）場合、現在の所属施設をセット
        		//        	if(indto.getPreUltInsNo().equals(indto.getPostUltInsNo()) || StringUtils.isEmpty(indto.getPostUltInsNo())) {
        		//        		tRdmHcpKmuReqUpdData.setUltInsNo(indto.getPreUltInsNo());
        		//        	}
        		tRdmHcpKmuReqUpdData.setUpdShaYmd(systemDate);
        		tRdmHcpKmuReqUpdData.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));


        		dao.update(tRdmHcpKmuReqUpdData);
        	}
        	indto.setReqId(reqId);

        	// 保存が完了しました。
        	errMsg += loginInfo.getMsgData(RdmConstantsData.I005)+ "\n";
        	errFlg = true;
        	indto.setMsgStr(errMsg);
        	outdto = init(indto);
        }
        if ("1".equals(indto.getButtonFlg()) || "3".equals(indto.getButtonFlg())) {
        	// 申請または承認ボタン押下でエラーなしならボタンフラグを9完了にする
        	indto.setButtonFlg("9");
        	// 編集可能判定
        	if("".equals(indto.getReqSts()) || indto.getReqSts() == null) {
        		// 完全新規(申請管理．申請ステータスが取得できない)の場合は活性
        		indto.setInputFlg("1");
        	} else if(!RdmConstantsData.RDM_JKN_ADMIN.equals(loginInfo.getJokenSetCd()) && !"01".equals(indto.getReqSts())) {
        		// MR権限の場合、取得した申請管理．申請ステータスが'01'(保存済み)以外の場合は、入力項目はすべて変更不可（非活性）とする
        		indto.setInputFlg("0");
        	} else if(RdmConstantsData.RDM_JKN_ADMIN.equals(loginInfo.getJokenSetCd()) && !"01".equals(indto.getReqSts()) && !"11".equals(indto.getReqSts())
        			&& !"03".equals(indto.getReqSts()) && !"13".equals(indto.getReqSts())) {
        		// 管理者権限の場合、取得した申請管理．申請ステータスが'01'(保存済み)、'03'(承認待ち)、'13'(ULT承認待ち)以外の場合は、入力項目はすべて変更不可（非活性）とする
        		indto.setInputFlg("0");
        	} else {
        		indto.setInputFlg("1");
        	}
        }
    	return outdto;
    }

    /**
     * イベント処理
     * @param indto ND102DTO
     * @return 遷移先DTO
     * @customizable
    */
   @Transactional
   public BaseDTO cancel(ND102DTO indto) {
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

       indto.setTempReqBtnFlg("0");


//       indto.setForward(indto.getNd102PreScreenId());

	   return outdto;
   }

    public void setCombo(ND102DTO indto) {
    	//1-2 ドロップダウンリストの生成

        //異動区分
        SelectNd102TrnListEntity selectNd102TrnListEntity = new SelectNd102TrnListEntity();
        List<SelectNd102TrnListEntity> selectNd102TrnList;
        selectNd102TrnList = dao.select(selectNd102TrnListEntity);
        //表示用
        LinkedHashMap<String, String> mapTrnKbn = new LinkedHashMap<String, String>();
        //異動先施設コード保管用
        LinkedHashMap<String, String> mapTrnKbnInsNo = new LinkedHashMap<String, String>();
        mapTrnKbn.put(null, "--選択してください--");
        for (SelectNd102TrnListEntity outEntity : selectNd102TrnList) {
        	mapTrnKbn.put(outEntity.getTrnValue1(),outEntity.getValue1Kanj());
        }

        for (SelectNd102TrnListEntity outEntity : selectNd102TrnList) {
        	mapTrnKbnInsNo.put(outEntity.getTrnValue1(),outEntity.getDummyValue1());
        }

        indto.setTrnKbnInsNoCombo(mapTrnKbnInsNo);
        indto.setTrnKbnCombo(mapTrnKbn);
        if(!(StringUtils.isEmpty(indto.getReqSts()))) {
        	indto.setTrnKbnInsNo(mapTrnKbnInsNo.get(indto.getTrnKbnCd()));
        	indto.setPostInsNo(mapTrnKbnInsNo.get(indto.getTrnKbnCd()));
        }

      //翌日日付_RDM用カレンダー(オンライン用)_生成用エンティティ
    	SelectTmrEntity selectTmrEntity = new SelectTmrEntity();
        //翌日日付_RDM用カレンダー(オンライン用)の帳票一覧を取得する
        List<SelectTmrEntity> selectTmrList = dao.select(selectTmrEntity);

        // SimpleDateFormatで日付フォーマット設定
     	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        //翌日日付データ_取り出す（リストの[0]を取得)
        for (SelectTmrEntity entity : selectTmrList) {
            //検索結果_翌日日付
            indto.setTekiyoInitDay(sdf.format(entity.getCalDate()));
        }


    }

	/**
	 * イベント処理
	 *
	 * @param indto ND102DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO shnComp(ND102DTO indto) {
		BaseDTO outdto = indto;
		// START UOC
		LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();
		// DropDownList作成
		setCombo(indto);
		// 現在日付を取得
		Date systemDate = DateUtils.getNowDate();
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
		String sysDate = fmtDate.format(systemDate);

		// 申請管理の更新を行う
		TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity("updateTRdmReqKnrData");
		tRdmReqKnrEntity.setReqId(indto.getReqId());
		tRdmReqKnrEntity.setShnFlg("1");
		tRdmReqKnrEntity.setShnBrCode(loginInfo.getBrCode());
		tRdmReqKnrEntity.setShnDistCode(loginInfo.getDistCode());
		tRdmReqKnrEntity.setShnShz(loginInfo.getBumonRyakuName());
		tRdmReqKnrEntity.setShnJgiNo(loginInfo.getJgiNo());
		tRdmReqKnrEntity.setShnShaName(loginInfo.getJgiName());
		tRdmReqKnrEntity.setAprMemo(indto.getAprMemo());
		tRdmReqKnrEntity.setShnYmdhms(sysDate);

		dao.update(tRdmReqKnrEntity);

		indto.setShnFlg("1");

		outdto = init(indto);

		// エラーメッセージ表示エリアに（I008）「ステータスを審査済みに変更しました。」完了メッセージを表示
		String infoMsg = loginInfo.getMsgData(RdmConstantsData.I008) + "\n";
		indto.setMsgStr(infoMsg);

		// END UOC
		return outdto;
	}

	/*
	 * エラーありならtrueとし、エラーメッセージをmsgStrにセットする
	 */
	private boolean checkInput(LoginInfo loginInfo, ND102DTO indto, boolean fullchkFlg) {
		boolean errChk = false;
		String msgStr = "";
		String tmpMsgStr = "";
		String alertErrMsg = "";
		String alertErrMsg2 = "";
		if(fullchkFlg) {
			//	１：必須入力チェック
			// 必須入力チェック
			if (indto.getTrnKbnCd() == null || indto.getTrnKbnCd().isEmpty()) {
				// 必須項目にデータを入力してください。（異動区分）
				tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "異動区分") + "\n";
				errChk = true;
			}

		}
		//      ２：レングスチェック
		//      項目                                チェック内容
		int len = 0;
		//      申請コメント                                ３００文字を超えている場合
		if(!StringUtils.isEmpty(indto.getReqComment())) {
			//len = StringUtils.getByteLength(indto.getReqComment());
			len = indto.getReqComment().length();
			if(len > 100) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W009);//最大文字数を超えています。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "申請コメント");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//      審査・承認メモ                                ３００文字を超えている場合
		if(!StringUtils.isEmpty(indto.getAprMemo())) {
			//len = StringUtils.getByteLength(indto.getAprMemo());
			len = indto.getAprMemo().length();
			if(len > 100) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W009);//最大文字数を超えています。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "審査・承認メモ");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}


		if(fullchkFlg) {

			// 整合性チェック
			// 同じ医師で同じ施設に対しての申請がすでに存在している場合

			SelectNd101MainDataEntity paramEntity = new SelectNd101MainDataEntity();
			paramEntity.setSqlId("selectNd101DupData");
			paramEntity.setInDocNo(indto.getDocNo());
			paramEntity.setInInsNo(indto.getPreInsNo());
			paramEntity.setInReqId(StringUtils.setEmptyToNull(indto.getReqId()));
			List<SelectNd101MainDataEntity> mainDataEntityList = dao.select(paramEntity);
			if (mainDataEntityList.size() > 0) {
				// 重複する申請が行われています。（医師コード）
				tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.W008).replace("項目名", "医師コード") + "\n";
				errChk = true;
			}

			// 適用日が翌営業日以降ではない場合
			if (indto.getSelectDay() != null && !indto.getSelectDay().isEmpty()) {
				// 翌日日付_RDM用カレンダー(オンライン用)_生成用エンティティ
				SelectTmrEntity selectTmrEntity = new SelectTmrEntity();

				// 翌日日付_RDM用カレンダー(オンライン用)の帳票一覧を取得する
				List<SelectTmrEntity> selectTmrList = dao.select(selectTmrEntity);

				// SimpleDateFormatで日付フォーマット設定
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				// 翌日日付データ_取り出す（リストの[0]を取得)
				for (SelectTmrEntity entity : selectTmrList) {
					// 検索結果_翌日日付
					indto.setTekiyoInitDay(sdf.format(entity.getCalDate()));
				}
				String tempNextBizDay = indto.getTekiyoInitDay().replace("-", "");
				String tempTekiyoYmd = indto.getSelectDay().replace("-", "");

				Integer nextBizDay = Integer.parseInt(tempNextBizDay);
				Integer tekiyoYmd = Integer.parseInt(tempTekiyoYmd);

				if (tekiyoYmd < nextBizDay) {
					// 適用日は翌営業日以降を指定してください。
					tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.W007) + "\n";
					errChk = true;
				}
			}

//			// 整合性チェック
//			// 申請時に既に医師削除申請がされている場合
			if(!indto.getAlertIgnore().equals("1")) {
				SelectNd101MainDataEntity paramEntity2 = new SelectNd101MainDataEntity();
				paramEntity2.setSqlId("selectNd101DelData");
				paramEntity2.setInDocNo(indto.getDocNo());
				List<SelectNd101MainDataEntity> mainDataEntityList2 = dao.select(paramEntity2);
				if (mainDataEntityList2.size() > 0) {
					// 廃業・死亡の申請がされています。よろしいですか？
					alertErrMsg2 += loginInfo.getMsgData(RdmConstantsData.I010) + "\n";
					errChk = true;
				}
			}

			// 整合性チェック
			// 申請時に既に医師削除申請がされている場合（承認済）

			SelectNd101MainDataEntity paramEntity4 = new SelectNd101MainDataEntity();
			paramEntity4.setSqlId("selectNd101DelAppdData");
			paramEntity4.setInDocNo(indto.getDocNo());
			List<SelectNd101MainDataEntity> mainDataEntityList4 = dao.select(paramEntity4);
			if (mainDataEntityList4.size() > 0) {
				// 医師免許返納・死亡状態で、申請できません。
				tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.W040) + "\n";
				errChk = true;
			}

			// 整合性チェック
			//
			SelectNd102MultipleWorkCheckEntity multipleWorkCheckEntity = new SelectNd102MultipleWorkCheckEntity();
			multipleWorkCheckEntity.setInDocNo(indto.getDocNo());
			List<SelectNd102MultipleWorkCheckEntity> multipleWorkCheckList = dao.select(multipleWorkCheckEntity);
			if(multipleWorkCheckList.size() >= 2) {
				// 通常勤務先施設数が2以上のため申請できません。
				tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.W037) + "\n";
				errChk = true;
			}

			// 整合性チェック
			//
			SelectNd102ClosedCheckEntity closedCheckEntity = new SelectNd102ClosedCheckEntity();
			closedCheckEntity.setInDocNo(indto.getDocNo());
			List<SelectNd102ClosedCheckEntity> closedCheckList = dao.select(closedCheckEntity);
			if(!(closedCheckList.isEmpty())) {
				// 医師免許返納・死亡の申請されているため申請できません。
				tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.W038) + "\n";
				errChk = true;
			}

			// 整合性チェック
			//
			if(indto.getMrAdminFlg().equals("1")) {
				SelectNd102MrDummyCheckEntity mrDummyCheckEntity = new SelectNd102MrDummyCheckEntity();
				mrDummyCheckEntity.setInInsNo(indto.getPreInsNo());
				List<SelectNd102MrDummyCheckEntity> MrDummyCheckList = dao.select(mrDummyCheckEntity);
				if(!(MrDummyCheckList.isEmpty())) {
					// 医療機関以外の施設から医療機関以外の施設への申請はできません。
					tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.W039) + "\n";
					errChk = true;
				}
			}

			// 排他チェック
			// 最終更新日時が、画面OPEN時とボタン押下時で異なっていた場合
			if (indto.getUpdShaYmd() != null && !indto.getUpdShaYmd().equals("")) {
				TRdmReqKnrEntity tRdmReqKnrChkEntity = new TRdmReqKnrEntity("selectNd101DateChkData");
				tRdmReqKnrChkEntity.setReqId(indto.getReqId());

				List<TRdmReqKnrEntity> tRdmReqKnrEntityList = dao.select(tRdmReqKnrChkEntity);

				if (tRdmReqKnrEntityList.size() > 0) {
					SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date updDate = null;
					try {
						updDate = sdFormat.parse(indto.getUpdShaYmd());
					} catch (ParseException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
					if (!tRdmReqKnrEntityList.get(0).getUpdShaYmd().equals(updDate)) {
						// 既に他のユーザーによってデータが処理されています。
						tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.E003) + "\n";
						errChk = true;

					}
				}
			}
		}
		if(errChk) {//エラーありなのでメッセージをセットする
			indto.setMsgStr(tmpMsgStr);
			indto.setAlertMsgStr(alertErrMsg);
        	indto.setAlertMsgStr2(alertErrMsg2);
        	indto.setAlertIgnore("0");
		}
		return errChk;
	}
}
