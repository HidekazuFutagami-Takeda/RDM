/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2311, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.action;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

import jp.co.takeda.rdm.common.BaseAction;
import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.NC101DTO;
import jp.co.takeda.rdm.dto.ND311DTO;
import jp.co.takeda.rdm.entity.join.RdmCommonEntity;
import jp.co.takeda.rdm.entity.join.TRdmReqKnrEntity;
import jp.co.takeda.rdm.service.ND311Service;
import jp.co.takeda.rdm.util.AppConstant;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;
import lombok.Getter;
import lombok.Setter;

/**
 * Actionクラス
 *
 * @generated
 */
@Named("ND311Action")
@Scope("request")
public class ND311Action extends BaseAction<ND311DTO> {

	/**
	 * シリアルバージョンID
	 *
	 * @generated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Serviceオブジェクト
	 *
	 * @generated
	 */
	@Inject
	private ND311Service nD311Service;
	// 確認画面用
	@Getter
	@Setter
	private NC101DTO paramDto;

	// ログインユーザ情報取得
	LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

	boolean errChk = false;
	String msgStr = "";
	String tmpMsgStr = "";
	int len = 0;

	// START UOC

	// END UOC

	/**
	 * コンストラクタ
	 *
	 * @generated
	 */
	public ND311Action() {
		dto = new ND311DTO();
	}

	/**
	 * イベント毎のメソッド実行前に共通後処理。<br/>
	 * 但し、validationエラー時は実行されない。
	 *
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
	 *
	 * @customizable
	 */
	@BeforeResult
	public void beforeResult() throws Exception {
		// START UOC

		// END UOC
	}

	/**
	 * validationエラー時に実行する処理。<br/>
	 *
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
	 *
	 * @customizable
	 */
	public String init() throws Exception {
		initSetup();

		dto.setTitle("ND311_医師勤務先追加 - 申請内容確認");

		BaseDTO outdto = dto;

		dto.setMsgStr(null);

		String tmpMsgStr = "";

		nD311Service.pullDown(dto);

		// 【仮】権限判別
		// ログインユーザー情報格納
		LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

		// ユーザー
		if (loginInfo.getJokenSetCd() == "0") {
			dto.setJokenSetCd("0");
		}
		// 管理者
		if (loginInfo.getJokenSetCd() == "1") {
			dto.setJokenSetCd("1");
			dto.setLoginJgiNo(loginInfo.getJgiNo());
		}

		// 申請者所属エリアセット
		dto.setReqDistCode(loginInfo.getBrCode());
		// 申請者所属リージョンセット
		dto.setBrCode(loginInfo.getBrCode());
		// 申請者セット
		dto.setJgiName(loginInfo.getJgiName());

		dto.setMsgStr(null);

		/*
		 * String reqSts = dto.getReqStsCd(); //申請ステータスが保存済み、初回登録以外の場合 if
		 * (!Objects.equals(reqSts,"01")) { if (!StringUtils.isEmpty(reqSts)) { outdto =
		 * nD311Service.init(dto); return initNext(outdto); } }
		 *
		 * if (!StringUtils.isEmpty(reqSts)) { if (!Objects.equals(reqSts,"01")) {
		 * outdto = nD311Service.init(dto); return initNext(outdto); } }
		 */
		// 施設名 必須入力チェック
		if (StringUtils.isEmpty(dto.getInsAbbrName())) {
			errChk = true;
			tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "施設名") + "\n";
			// 必須項目にデータを入力してください。（施設名）。

			if (errChk) {// エラーありなのでメッセージをセットする
				dto.setMsgStr(tmpMsgStr);
			}
		}

		// 所属部科 必須入力チェック
		if (StringUtils.isEmpty(dto.getDeptKj())) {
			errChk = true;
			tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "所属部科") + "\n";
			// 必須項目にデータを入力してください。（所属部科）

			if (errChk) {// エラーありなのでメッセージをセットする
				dto.setMsgStr(tmpMsgStr);
			}
		}

		// 役職 必須入力チェック
		if (StringUtils.isEmpty(dto.getTitleCodeAf())) {
			errChk = true;
			tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "役職") + "\n";
			// 必須項目にデータを入力してください。（役職）

			if (errChk) {// エラーありなのでメッセージをセットする
				dto.setMsgStr(tmpMsgStr);
			}
		}

		// 大学職位
		if (StringUtils.isEmpty(dto.getTitleCodeAf())) {
			if (!StringUtils.isEmpty(dto.getInsAbbrName())) {
				if (Objects.deepEquals(dto.getInsClass(), "01") && Objects.deepEquals(dto.getHoInsType(), "1")) {
					// 施設分類が"01"かつ対象区分が"1"の場合
					errChk = true;
					tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.W031) + "\n";
					// 勤務先が大学附属病院の場合、大学職位を入力してください。
					if (errChk) {// エラーありなのでメッセージをセットする
						dto.setMsgStr(tmpMsgStr);
					}
				}
			}

		}

		// 適用日 必須入力チェック
		if (StringUtils.isEmpty(dto.getFormTekiyoYmd())) {
			errChk = true;
			tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.W025).replace("項目名", "適用日") + "\n";
			// 年月日、または年月を入力してください。（適用日）

			if (errChk) {// エラーありなのでメッセージをセットする
				dto.setMsgStr(tmpMsgStr);
			}
		}

		// 申請コメント レングスチェック
		int i = dto.getReqComment().length();
		if (i >= 300) {// 申請コメント文字数が300文字以上の場合
			errChk = true;
			tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "申請コメント") + "\n";
			// 最大文字数を超えています。（申請コメント）

			if (errChk) {// エラーありなのでメッセージをセットする
				dto.setMsgStr(tmpMsgStr);
			}
		}

		// 適用日に当日以前の日付が入っている場合
		// 適用日が翌営業日以降ではない場合
		if (dto.getFormTekiyoYmd() != null && !dto.getFormTekiyoYmd().isEmpty()) {
			// 翌営業日を取得
			Integer nextBizDay = Integer.parseInt(nD311Service.getNextBizday());
			Integer tekiyoYmd = Integer.parseInt(dto.getFormTekiyoYmd().replace("-", ""));

			if (tekiyoYmd < nextBizDay) {
				// 適用日は翌営業日以降を指定してください。
				errChk = true;
				tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.W007) + "\n";
			}
		}
		// 所属部科を指定する場合に施設を指定しているか
		if (StringUtils.isEmpty(dto.getInsAbbrName())) {
			if (!StringUtils.isEmpty(dto.getDeptKj())) {
				errChk = true;
				tmpMsgStr = tmpMsgStr + loginInfo.getMsgData(RdmConstantsData.W027) + "\n";
				// 所属部科を選択する場合は施設も選択してください。

				if (errChk) {// エラーありなのでメッセージをセットする
					dto.setMsgStr(tmpMsgStr);
				}

			}
		}

		// 最終更新日時が、画面OPEN時とボタン押下時で異なっていた場合
		if (dto.getUpdShaYmd() != null && !dto.getUpdShaYmd().equals("")) {
			TRdmReqKnrEntity tRdmReqKnrChkEntity = new TRdmReqKnrEntity("selectNF011DateChkData");
			tRdmReqKnrChkEntity.setReqId(dto.getParamReqId());
//
//	         	List<TRdmReqKnrEntity> tRdmReqKnrEntityList = dao.select(tRdmReqKnrChkEntity);
//
//	         	if(tRdmReqKnrEntityList.size() > 0) {
//	         		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMddhhmmss");
//	         		Date updDate = null;
//	                 try {
//	 					updDate = sdFormat.parse(dto.getUpdShaYmd());
//	 				} catch (ParseException e) {
//	 					// TODO 自動生成された catch ブロック
//	 					e.printStackTrace();
//	 				}
//	         		if(!tRdmReqKnrEntityList.get(0).getUpdShaYmd().equals(updDate)) {
//	         			// 既に他のユーザーによってデータが処理されています。
//	         			tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.E003) + "\n";
//	         			//既に他のユーザーによってデータが処理されています。
//
//	         		}
//	         	}
		}

		dto.setMsgStr(tmpMsgStr);

		// 必須入力チェックがない場合
		if (StringUtils.isEmpty(dto.getMsgStr())) {

			// DBエラーチェック処理
			nD311Service.errorCheck(dto);

			if (Objects.deepEquals(dto.getErrorCheckFlg(), "2")) {
				tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.W008).replace("項目名", "施設名");// 重複する申請が行われています。（施設名）
			}

			if (Objects.deepEquals(dto.getErrorCheckFlg(), "3")) {
				tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.I010);// 廃業・死亡の申請がされています。よろしいですか？
			}

			dto.setMsgStr(tmpMsgStr);
		}

		// エラーがある場合親画面へ遷移.
		if (!StringUtils.isEmpty(dto.getMsgStr())) {
			dto.setTitle("ND103_医師勤務先追加");
			outdto.setForward("ND103");
			return initNext(outdto);
		}

		// F層呼び出し
		// outdto = nD311Service.initReq(dto);
		outdto = nD311Service.init(dto);

		dto.setReqId(dto.getParamReqId());
		dto.setParamDocNo(null);

		dto.setFormTekiyoYmd(dto.getFormTekiyoYmd().replace("-", "/"));

		return initNext(outdto);
	}

	/**
	 * 前処理
	 *
	 * @customizable
	 */
	protected void initSetup() throws Exception {
		// START UOC

		// END UOC
	}

	/**
	 * 後処理
	 *
	 * @customizable
	 */
	protected String initNext(BaseDTO outdto) throws Exception {
		// START UOC
		// 検索条件をセッションに格納する（ページャ押下時に使用）
		sessionMap.put(AppConstant.SESKEY_ND311_SEARCHKEY, outdto);

		// END UOC
		setNextDTO(outdto);
		return outdto.getForward();
	}

	/**
	 * 業務処理
	 *
	 * @customizable
	 */
	@InputConfig(methodName = "validationError")
	public String register() throws Exception {
		registerSetup();
		// F層呼び出し
		BaseDTO outdto = nD311Service.register(dto);
		return registerNext(outdto);
	}

	/**
	 * 前処理
	 *
	 * @customizable
	 */
	protected void registerSetup() throws Exception {
		// START UOC

		// END UOC
	}

	/**
	 * 後処理
	 *
	 * @customizable
	 */
	protected String registerNext(BaseDTO outdto) throws Exception {
		// START UOC
		// END UOC
		setNextDTO(outdto);

		if ("NC101".equals(dto.getForward())) {
			setJumpInfo(dto.getProcessFlg());
		}

		return outdto.getForward();
	}

	/**
	 * 終了画面へ遷移用パラメータ設定。
	 *
	 * @param dto   登録完了画面DTO
	 * @param msgId メッセージID
	 */
	private void setJumpInfo(String event) {
		// メッセージオブジェクト取得
		LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

		// 画面タイトル内容設定
		paramDto = new NC101DTO();
		// 画面タイトル
		paramDto.setTitle("医師勤務先追加");
		// メッセージ１
		if (event.equals("0")) {// I002 申請が完了しました。
			paramDto.setMessage1(loginInfo.getMsgEntity(RdmConstantsData.I002));
		}
		if (event.equals("2")) {// I003 承認が完了しました。
			paramDto.setMessage1(loginInfo.getMsgEntity(RdmConstantsData.I003));
		}
		if (event.equals("1")) {// I004 却下が完了しました。
			paramDto.setMessage1(loginInfo.getMsgEntity(RdmConstantsData.I004));
		}
	}
}
