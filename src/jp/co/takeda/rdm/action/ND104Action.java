/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2104, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.util.StringUtils;

import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

import jp.co.takeda.rdm.common.BaseAction;
import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.DAO;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.NC101DTO;
import jp.co.takeda.rdm.dto.ND104DTO;
import jp.co.takeda.rdm.entity.join.MRdmParamMstEntity;
import jp.co.takeda.rdm.entity.join.RdmCommonEntity;
import jp.co.takeda.rdm.entity.join.TRdmReqKnrEntity;
import jp.co.takeda.rdm.service.ND104Service;
import jp.co.takeda.rdm.util.AppConstant;
import jp.co.takeda.rdm.util.DateUtils;
import jp.co.takeda.rdm.util.RdmConstantsData;
import lombok.Getter;
import lombok.Setter;

/**
 * Actionクラス
 * @generated
 */
@Named("ND104Action")
@Scope("request")
public class ND104Action extends BaseAction<ND104DTO> {

    /**
     * シリアルバージョンID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * Serviceオブジェクト
     * @generated
     */
    @Inject
    private ND104Service nD104Service;
    // 確認画面用
    @Getter
    @Setter
    private NC101DTO paramDto;

    /**
     * DAOインスタンス
     * @generated
     */
    @Inject
    protected DAO dao;

    //ログインユーザ情報取得
    LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

    boolean errChk = false;
	String msgStr = "";
	String tmpMsgStr = "";
	int len = 0;

    // START UOC

    // END UOC

    /**
     * コンストラクタ
     * @generated
     */
    public ND104Action() {
        dto = new ND104DTO();
    }

    /**
     * イベント毎のメソッド実行前に共通後処理。<br/>
     * 但し、validationエラー時は実行されない。
     * @return 遷移先（nullの場合、イベントのメソッドを呼び出す）
     * @customizable
     */
    @Before
    public String before() throws Exception {
        // START UOC
        return null;
        // END UOC
    }

    /**
     * イベント毎のメソッド実行前に共通後処理。<br/>
     * 但し、validationエラー時は実行されない。
     * @customizable
     */
    @BeforeResult
    public void beforeResult() throws Exception {
        // START UOC

        // END UOC
    }

    /**
     * validationエラー時に実行する処理。<br/>
     * @customizable
     */
    @InputConfig
    public String validationError() {
        // START UOC
        return "input";
        // END UOC
    }
    /**
     * 業務処理
     * @customizable
     */
    public String init() throws Exception {
        initSetup();

        BaseDTO outdto = dto;

        dto.setTitle("ND104_医師勤務先削除");

        String preScreenId = dto.getBackScreenId();
        if(!"ND104".equals(preScreenId) && !"ND313".equals(preScreenId)) {
        	dto.setPreScreenId(preScreenId);
        }

        //エラーメッセージが定義されている場合
        if (!StringUtils.isEmpty(dto.getMsgStr())) {
            return initNext(outdto);
        }

        if(!"ND313".equals(preScreenId)) {
	        //【仮】権限判別
	      //ログインユーザー情報格納
	        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

	     // 現在日付を取得
	        Date systemDate = DateUtils.getNowDate();
	        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
	        String sysDate = fmtDate.format(systemDate);

	        //ユーザー
	        if (loginInfo.getJokenSetCd() == "0") {
	        	dto.setJokenSetCd("0");
	        }
	        //管理者
	        if (loginInfo.getJokenSetCd() == "1") {
	        	dto.setJokenSetCd("1");
	        	dto.setLoginJgiNo(loginInfo.getJgiNo());
	        }

	    	dto.setMsgStr(null);

	    	dto.setParamReqId(dto.getReqId());

	        //一時保存押下の場合
	         if (Objects.deepEquals(dto.getSaveButtonFlg(), "1")) {
	        	 dto.setSaveButtonFlg("0");

	    		//エラーチェック
	    		int i = dto.getReqComment().length();
	    		if (i >= 300) {//申請コメント文字数が300文字以上の場合
	    			errChk = true;
	    			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "申請コメント") + "\n";;

	        		if(errChk) {//エラーありなのでメッセージをセットする
	        			dto.setMsgStr(tmpMsgStr);
	        			errChk = false;
	        			if (StringUtils.isEmpty(dto.getParamReqId())) {
	        				dto.setParamReqId(null);
	        				dto.setReqSts(null);
	        				dto.setReqYmdhms(null);
	        				dto.setTekiyoYmd(dto.getFormTekiyoYmd());
	        			}
	        		}
	    		}
	    		else {//エラーがない場合更新処理へ
	    			nD104Service.save(dto);
	    			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.I005);//保存メッセージ
	    			dto.setMsgStr(tmpMsgStr);
	    			dto.setSaveButtonFlg("0");
	    		}
	        }

	         //申請ボタン押下の場合
	         if (Objects.deepEquals(dto.getShinseiButtonFlg(), "1")) {
	        	 dto.setShinseiButtonFlg("0");
	        	//適用日 必須入力チェック
	           	 if (StringUtils.isEmpty(dto.getFormTekiyoYmd())) {
	           		 errChk = true;
	           		 tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.W025).replace("項目名", "適用日") + "\n";
	           		 // 年月日、または年月を入力してください。（適用日）

	            		 if(errChk) {//エラーありなのでメッセージをセットする
	            			dto.setMsgStr(tmpMsgStr);
	            		 }
	           	 }

	           	 //申請コメント レングスチェック
	           	int i = dto.getReqComment().length();
	        		if (i >= 300) {//申請コメント文字数が300文字以上の場合
	        			errChk = true;
	        			tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "申請コメント") + "\n";
	        			// 最大文字数を超えています。（申請コメント）

	            		if(errChk) {//エラーありなのでメッセージをセットする
	            			dto.setMsgStr(tmpMsgStr);
	            		}
	        		}

	//        		//適用日に当日以前の日付が入っている場合
	//        		 // 適用日が翌営業日以降ではない場合
	//               if(dto.getTekiyoYmd() != null && !dto.getTekiyoYmd().isEmpty()) {
	//               	// 翌営業日を取得
	//       	        RdmCommonEntity rdmCommonEntity = new RdmCommonEntity("getNextBizday");
	//       	    	rdmCommonEntity.setInVBatDate(sysDate.replace("-", ""));
	//       	    	List<RdmCommonEntity> rdmCommonEntityList = dao.select(rdmCommonEntity);
	//
	//       	    	Integer nextBizDay = Integer.parseInt(rdmCommonEntityList.get(0).getNextBizday());
	//       	    	Integer tekiyoYmd = Integer.parseInt(dto.getTekiyoYmd().replace("-", ""));
	//
	//       	    	if (tekiyoYmd < nextBizDay) {
	//       	    		// 適用日は翌営業日以降を指定してください。
	//       	    		tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.W007) + "\n";
	//       				//適用日は翌営業日以降を指定してください。
	//
	//       	    	}
	//               }
	//
	//    	       	 // 最終更新日時が、画面OPEN時とボタン押下時で異なっていた場合
	//    	         if(dto.getUpdShaYmd() != null && !dto.getUpdShaYmd().equals("")) {
	//    	         	TRdmReqKnrEntity tRdmReqKnrChkEntity = new TRdmReqKnrEntity("selectNF011DateChkData");
	//    	         	tRdmReqKnrChkEntity.setReqId(dto.getParamReqId());
	//
	//    	         	List<TRdmReqKnrEntity> tRdmReqKnrEntityList = dao.select(tRdmReqKnrChkEntity);
	//
	//    	         	if(tRdmReqKnrEntityList.size() > 0) {
	//    	         		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMddhhmmss");
	//    	         		Date updDate = null;
	//    	                 try {
	//    	 					updDate = sdFormat.parse(dto.getUpdShaYmd());
	//    	 				} catch (ParseException e) {
	//    	 					// TODO 自動生成された catch ブロック
	//    	 					e.printStackTrace();
	//    	 				}
	//    	         		if(!tRdmReqKnrEntityList.get(0).getUpdShaYmd().equals(updDate)) {
	//    	         			// 既に他のユーザーによってデータが処理されています。
	//    	         			tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.E003) + "\n";
	//    	         			//既に他のユーザーによってデータが処理されています。
	//
	//    	         		}
	//    	         	}
	//    	         }

	               dto.setMsgStr(tmpMsgStr);

	               //必須入力チェックがない場合
	           	 if (StringUtils.isEmpty(dto.getMsgStr())) {

	           		//DBエラーチェック処理
	               	 nD104Service.errorCheck(dto);

	               	 if (Objects.deepEquals(dto.getErrorCheckFlg(), "1")) {
	               		 tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.W008.replace("項目名", "医師コード、施設コード") + "\n");//重複する申請が行われています。（施設名）
	               	 }

	               	 if (Objects.deepEquals(dto.getErrorCheckFlg(), "2")) {
	               		 tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.W030);//勤務先が0件になるため申請できません。
	               	 }

	               	 dto.setMsgStr(tmpMsgStr);
	           	 }

	           	 //エラーがない場合
	           	if (StringUtils.isEmpty(dto.getMsgStr())) {
	           		outdto = dto;

	           		// パラメタ情報を取得
	           		String kmuValue = "0";
	                String docValue = "0";

	           		MRdmParamMstEntity mRdmParamMstEntity = new MRdmParamMstEntity();
	        		mRdmParamMstEntity.setParamName("MN_KMU");
	        		mRdmParamMstEntity.setDelFlg("0");
	        		List<MRdmParamMstEntity> mRdmParamMstEntityList = dao.selectByValue(mRdmParamMstEntity);
	        		if(mRdmParamMstEntityList.size() > 0) {
	        			kmuValue = mRdmParamMstEntityList.get(0).getValue().substring(1,2);
	        		}

	        		MRdmParamMstEntity mRdmParamMstEntityDoc = new MRdmParamMstEntity();
	        		mRdmParamMstEntityDoc.setParamName("MN_DOC");
	        		mRdmParamMstEntityDoc.setDelFlg("0");
	        		List<MRdmParamMstEntity> mRdmParamMstEntityDocList = dao.selectByValue(mRdmParamMstEntityDoc);
	        		if(mRdmParamMstEntityList.size() > 0) {
	        			docValue = mRdmParamMstEntityList.get(0).getValue().substring(2,3);
	        		}

	        		if("1".equals(kmuValue) && "1".equals(docValue)) {
	        			dto.setActionEdit("1");
	        		} else {
	        			dto.setActionEdit("0");
	        		}

	           		outdto.setForward("ND313");
	           		dto.setTitle("ND313_医師勤務先削除 - 申請内容確認");

	           		dto.setFormTekiyoYmd(dto.getFormTekiyoYmd().replace("-", "/"));
	           		//outdto.setForward("ND313Init");
	           		return outdto.getForward();
	           	}
	           	//エラーがある場合　入力情報を保持
				dto.setTekiyoYmd(dto.getFormTekiyoYmd());

	         }

	         //親画面 申請ID　空チェック
	         if (!StringUtils.isEmpty(dto.getParamReqId())) {
	         	dto.setParamDocNo(null);
	         	// F層呼び出し
	            outdto = nD104Service.initReq(dto);
	         }

	         //親画面 医師固定コード・施設固定コード　空チェック
	         if (!StringUtils.isEmpty(dto.getParamDocNo()) && !StringUtils.isEmpty(dto.getParamInsNo())) {
	         	dto.setParamReqId(null);

	         	dto.setBumonRyakuName(loginInfo.getBumonRyakuName()); //所属組織名（部門名略式）
	        	dto.setJgiName(loginInfo.getJgiName()); //申請者氏名
	        	dto.setJgiNo(loginInfo.getJgiNo()); //申請者従業員番号
	        	dto.setBrCode(loginInfo.getBrCode()); //申請者医薬支店C
	        	dto.setDistCode(loginInfo.getDistCode()); //申請者医薬営業所C
	         	// F層呼び出し
	             outdto = nD104Service.initDoc(dto);
	         }
        } else {
        	dto.setTekiyoYmd(dto.getFormTekiyoYmd().replace("/", "-"));
        }

        return initNext(outdto);
    }

    /**
     * 前処理
     * @customizable
     */
    protected void initSetup() throws Exception {
        // START UOC

        // END UOC
    }

    /**
     * 後処理
     * @customizable
     */
    protected String initNext(BaseDTO outdto) throws Exception {
        // START UOC
    	// 検索条件をセッションに格納する（ページャ押下時に使用）
    	sessionMap.put(AppConstant.SESKEY_ND104_SEARCHKEY, outdto);

        // END UOC
         setNextDTO(outdto);
        return outdto.getForward();
    }

    /**
     * 業務処理
     * @customizable
     */
    @InputConfig(methodName="validationError")
    public String cancel() throws Exception {
        cancelSetup();
        // F層呼び出し
        BaseDTO outdto = nD104Service.cancel(dto);
        return cancelNext(outdto);
    }

    /**
     * 前処理
     * @customizable
     */
    protected void cancelSetup() throws Exception {
        // START UOC

        // END UOC
    }

    /**
     * 後処理
     * @customizable
     */
    protected String cancelNext(BaseDTO outdto) throws Exception {
        // START UOC

        // END UOC
        setNextDTO(outdto);
        // 完了画面に遷移
        outdto.setForward("NC101");
        setJumpInfo(RdmConstantsData.I016);
        setNextDTO(outdto);
        return outdto.getForward();
    }

    /**
     * 終了画面へ遷移用パラメータ設定。
     * @param dto 登録完了画面DTO
     * @param msgId メッセージID
     */
    private void setJumpInfo(String msgId) {
        // メッセージオブジェクト取得
        LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

        //画面タイトル内容設定
        paramDto = new NC101DTO();
		// 画面タイトル
		paramDto.setTitle("医師勤務先削除");
		// メッセージ１
		if (msgId.equals(RdmConstantsData.I016)) {//I016	一時保存データを破棄しました。
			paramDto.setMessage1(loginInfo.getMsgEntity(RdmConstantsData.I016));
		}
	}
}
