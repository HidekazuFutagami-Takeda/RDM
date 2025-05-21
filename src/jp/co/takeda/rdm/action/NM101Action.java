/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.action;

import java.text.SimpleDateFormat;
import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

import jp.co.takeda.rdm.common.BaseAction;
import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.LoginInfo;
//import jp.co.takeda.rdm.dto.JKR040C010DTO;
import jp.co.takeda.rdm.dto.NM101DTO;
import jp.co.takeda.rdm.exception.InvalidRequestException;
import jp.co.takeda.rdm.service.NM101Service;
import jp.co.takeda.rdm.service.NM101Service;
import jp.co.takeda.rdm.util.AppConstant;
import jp.co.takeda.rdm.util.RdmConstantsData;

import org.springframework.context.annotation.Scope;

/**
 * Actionクラス
 *
 * @generated
 */
@Named("nM101Action")
@Scope("request")
public class NM101Action extends BaseAction<NM101DTO> {

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
	private NM101Service NM101Service;

	// START UOC

	// ログインユーザ情報取得
	LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

	boolean errChk = false;
	String msgStr = "";
	String tmpMsgStr = "";
	int len = 0;
	// END UOC

	/**
	 * コンストラクタ
	 *
	 * @generated
	 */
	public NM101Action() {
		dto = new NM101DTO();
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
		// F層呼び出し
		BaseDTO outdto = NM101Service.init(dto);
		return initNext(outdto);
	}

	/**
	 * 前処理
	 *
	 * @customizable
	 */
	protected void initSetup() throws Exception {
		// START UOC
		LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

		// 改ページ設定
		dto.setPageCntCur(1);

		// 画面タイトル制御処理
		String title = "NM101_通知内容詳細";
		dto.setTitle(title);

		// ユーザ権限
		dto.setJokenFlg(loginInfo.getJokenFlg());

		String preScreenId = loginInfo.getPreScreenId();
		preScreenId = dto.getPreScreenId();

		dto.setPreScreenId(preScreenId);

		// 遷移パターン 0:完全新規、1:ULTから作成、2：申請データあり
		// ULTT医師コード ありなしで分岐
		// ND001_医師検索
		// 管理者：1 MR：0
		if ("NC001".equals(preScreenId) || loginInfo.getJokenFlg().equals("1")) {
			// 何もしない
		} else {
			throw new InvalidRequestException();
		}

		// END UOC
	}

	/**
	 * 業務処理
	 *
	 * @customizable
	 */
	@InputConfig(methodName = "validationError")
	public String sort() throws Exception {
		pageSetup();
		// F層呼び出し
		BaseDTO outdto = NM101Service.sort(dto);
		return sortNext(outdto);
	}

	/**
	 * 後処理
	 *
	 * @customizable
	 */
	protected String sortNext(BaseDTO outdto) throws Exception {
		// START UOC
		sessionMap.put(AppConstant.SESKEY_NM101_SEARCHKEY, outdto);
		// END UOC
		setNextDTO(outdto);
		return outdto.getForward();
	}

	/**
	 * 後処理
	 *
	 * @customizable
	 */
	protected String initNext(BaseDTO outdto) throws Exception {
		// START UOC
		// 検索条件をセッションに格納する（ページャ押下時に使用）
		sessionMap.put(AppConstant.SESKEY_NM101_SEARCHKEY, outdto);
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
	public String search() throws Exception {
		BaseDTO outdto = dto;
		searchSetup();
		// F層呼び出し
		outdto = NM101Service.search(dto);

		// 日付チェック
		if (Objects.equals(dto.getBoolKnb(), "1")) {
			errChk = true;
			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W003);// 終了日は開始日以降を選択してください。
			if (errChk) {// エラーありなのでメッセージをセットする
				dto.setMsgStr(tmpMsgStr);
			}
			// 入力された日付を保持
			dto.setInhisYmdhmsFrom(dto.getHisYmdhmsFrom());
			dto.setInhisYmdhmsTo(dto.getHisYmdhmsTo());

		}

		// 検索結果にエラーがある場合
		if (Objects.equals(dto.getBoolKnb(), "2")) {// エラーありなのでメッセージをセットする
			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W002);// 検索結果が表示上限を超えています。検索条件を絞って再検索してください。。
			// エラーメッセージをdtoに格納
			dto.setMsgStr(tmpMsgStr);
		}

		if (outdto instanceof NM101DTO) {
			// START UOC

			// END UOC
		}
		return searchNext(outdto);
	}

	/**
	 * 前処理
	 *
	 * @customizable
	 */
	protected void searchSetup() throws Exception {
		// START UOC

		// END UOC
	}

	/**
	 * 後処理
	 *
	 * @customizable
	 */
	protected String searchNext(BaseDTO outdto) throws Exception {
		// START UOC
		// 検索条件をセッションに格納する（ページャ押下時に使用）
		sessionMap.put(AppConstant.SESKEY_NM101_SEARCHKEY, outdto);
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
	public String page() throws Exception {
		pageSetup();
		// F層呼び出し
		BaseDTO outdto = NM101Service.page(dto);
		if (outdto instanceof NM101DTO) { // START UOC

			// END UOC
		}
		return pageNext(outdto);
	}

	/**
	 * 前処理
	 *
	 * @customizable
	 */
	protected void pageSetup() throws Exception {
		// START UOC
		this.setSearchCon();
		NM101DTO searchKey = (NM101DTO) sessionMap.get(AppConstant.SESKEY_NM101_SEARCHKEY);
        // END UOC
	}

	/**
	 * 後処理
	 *
	 * @customizable
	 */
	protected String pageNext(BaseDTO outdto) throws Exception {
		// START UOC
		sessionMap.put(AppConstant.SESKEY_NM101_SEARCHKEY, outdto);
		// END UOC
		setNextDTO(outdto);
		return outdto.getForward();
	}

	private void setSearchCon() {

	}

	/**
	 * 業務処理
	 *
	 * @customizable
	 */
	public String register() throws Exception {
		registerSetup();
		// F層呼び出し
		BaseDTO outdto = NM101Service.register(dto);
		return registerNext(outdto);
	}

	/**
	 * 前処理
	 *
	 * @customizable
	 */
	protected void registerSetup() throws Exception {
		// START UOC
		LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

		// 改ページ設定
		dto.setPageCntCur(1);
		// END UOC
	}

	/**
	 * 後処理
	 *
	 * @customizable
	 */
	protected String registerNext(BaseDTO outdto) throws Exception {
		// START UOC
		// 検索条件をセッションに格納する（リンク押下時に使用）
		sessionMap.put(AppConstant.SESKEY_NM101_SEARCHKEY, outdto);
		// END UOC
		setNextDTO(outdto);
		return outdto.getForward();
	}

}
