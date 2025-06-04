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

import org.springframework.context.annotation.Scope;
import org.springframework.util.StringUtils;

import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

import jp.co.takeda.rdm.common.BaseAction;
import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.NF501DTO;
import jp.co.takeda.rdm.service.NF501Service;
import jp.co.takeda.rdm.util.AppConstant;
import jp.co.takeda.rdm.util.RdmConstantsData;

/**
 * Actionクラス
 *
 * @generated
 */
@Named("NF501Action")
@Scope("request")
public class NF501Action extends BaseAction<NF501DTO> {

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
	private NF501Service nF501Service;

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
	public NF501Action() {
		dto = new NF501DTO();
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

		dto.setTitle("NF501_施設変更履歴");

		// 【仮】権限判別
		// ログインユーザー情報格納
		LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

		// 権限判別
		if (Objects.equals(loginInfo.getJokenSetCd(), "JKN0023")) {// ユーザー権限の場合
			dto.setJokenSetCd("0");
			dto.setMrTrtCd(loginInfo.getTrtCd());// 従業員番号
			dto.setMrJgiNo(loginInfo.getJgiNo());// 領域コード
			dto.setMrBrCode(loginInfo.getBrCode());// 医薬支店C(申請者所属リージョン)
			dto.setMrDistCode(loginInfo.getDistCode());// 医薬営業所コード(申請者所属エリア)
			dto.setLoginJokenSetCd("JKN0023");
		} else {// 管理者権限の場合
			dto.setJokenSetCd("1");
			dto.setLoginJokenSetCd("JKN0850");
		}

		// F層呼び出し
		dto.setFunctionId("Init");
		BaseDTO outdto = nF501Service.init(dto);

//        dto.setSelectListChange("0");
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
		sessionMap.put(AppConstant.SESKEY_NF501_SEARCHKEY, outdto);
		// 検索一覧非表示
		dto.setSearchType("0");
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
		BaseDTO outdto;

		dto.setFunctionId("Search");
		searchSetup();

		// プルダウン・日付データ一覧取得
		outdto = nF501Service.pharmTypeList(dto);
		// 都道府県が選択した場合
		if (!StringUtils.isEmpty(dto.getKensakuAddrCodePref())) {
			// 住所検索
			outdto = nF501Service.searchCtiyName(dto);
			return searchNext(outdto);
		}

		// ログインユーザ情報取得
		LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

		// 入力された日付を保持
		dto.setUpdMstFrom(dto.getKensakuUpdMstFrom());
		dto.setUpdMstTo(dto.getKensakuUpdMstTo());

		// 検索条件がすべて未入力の場合
		if (StringUtils.isEmpty(dto.getKensakuSTantouBrCode()) && StringUtils.isEmpty(dto.getKensakuTantouDistCode()) && dto.getKensakuJgiNo() == 0 &&
			StringUtils.isEmpty(dto.getKensakuShinseiBrCode()) && StringUtils.isEmpty(dto.getKensakuShinseiDistCode()) &&
			StringUtils.isEmpty(dto.getKensakuInsKanj()) && StringUtils.isEmpty(dto.getKensakuInsKana()) &&
			StringUtils.isEmpty(dto.getKensakuReqJgiName()) && StringUtils.isEmpty(dto.getKensakuInsNo()) &&
			StringUtils.isEmpty(dto.getKensakuUltInsNo()) && StringUtils.isEmpty(dto.getKensakuManageCd()) &&
			StringUtils.isEmpty(dto.getKensakuHoInsType()) && StringUtils.isEmpty(dto.getKensakuInsSbt()) &&
			StringUtils.isEmpty(dto.getKensakuPharmType()) && StringUtils.isEmpty(dto.getKensakuInsPhone()) &&
			StringUtils.isEmpty(dto.getKensakuInsPcode()) && StringUtils.isEmpty(dto.getKensakuAddrCodePref()) &&
			StringUtils.isEmpty(dto.getKensakuAddrCodeCity()) && StringUtils.isEmpty(dto.getKensakuInsAddr()) &&
			StringUtils.isEmpty(dto.getKensakuUpdMstFrom()) && StringUtils.isEmpty(dto.getKensakuUpdMstTo())) {

			errChk = true;
			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W001);// 検索条件を入力してください。
			if (errChk) {// エラーありなのでメッセージをセットする
				dto.setMsgStr(tmpMsgStr);
			}
			dto.setSearchType("0");
			return outdto.getForward();
		}

		// SimpleDateFormatで日付フォーマット設定
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 日付チェック 開始日が終了日より後の場合
		if (dto.getKensakuUpdMstFrom() != null && !dto.getKensakuUpdMstFrom().equals(dto.getKensakuUpdMstTo())
				&& !sdf.parse(dto.getKensakuUpdMstFrom()).before(sdf.parse(dto.getKensakuUpdMstTo()))) {
			errChk = true;
			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W003);// 終了日は開始日以降を選択してください。
			if (errChk) {// エラーありなのでメッセージをセットする
				dto.setMsgStr(tmpMsgStr);
			}
			// 入力された日付を保持
			dto.setUpdMstFrom(dto.getKensakuUpdMstFrom());
			dto.setUpdMstTo(dto.getKensakuUpdMstTo());
			// 検索部を非表示
			dto.setSearchType("0");
			return outdto.getForward();
		}

		/*
		 * SelectListChangeが 0:施設一覧検索 1:領域担当者検索
		 */
		if (dto.getSelectListChange() == null) {
			dto.setSelectListChange("0");
		}

		dto.setKensakuBool(true);
		// 件数リセット
		dto.setLineCntAll(0);

		if (dto.getSelectListChange().contains("0")) {
			// 施設一覧検索
			dto.setSelectListChange("0");
			outdto = nF501Service.searchHcoUpd(dto);
			// 検索結果にエラーがある場合
			if (!dto.isKensakuBool()) {// エラーありなのでメッセージをセットする
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W002);// 検索結果が表示上限を超えています。検索条件を絞って再検索してください。。
				// エラーメッセージをdtoに格納
				dto.setMsgStr(tmpMsgStr);
				dto.setSearchType("0");
				return outdto.getForward();
			}
		} else {
			// 領域別担当者検索
			dto.setSelectListChange("1");
			outdto = nF501Service.searchMainIns(dto);
			// 検索結果にエラーがある場合
			if (!dto.isKensakuBool()) {// エラーありなのでメッセージをセットする
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W002);// 検索結果が表示上限を超えています。検索条件を絞って再検索してください。。
				// エラーメッセージをdtoに格納
				dto.setMsgStr(tmpMsgStr);
				dto.setSearchType("0");
				return outdto.getForward();
			}
		}
		// 住所検索
		outdto = nF501Service.searchCtiyName(dto);

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
		sessionMap.put(AppConstant.SESKEY_NF501_SEARCHKEY, outdto);
		// 検索一覧非表示
		dto.setSearchType("1");
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
		BaseDTO outdto = nF501Service.page(dto);
		if (outdto instanceof NF501DTO) {
			// START UOC
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

		// END UOC
	}

	/**
	 * 後処理
	 *
	 * @customizable
	 */
	protected String pageNext(BaseDTO outdto) throws Exception {
		// START UOC

		// END UOC
		setNextDTO(outdto);
		return outdto.getForward();
	}

}
