/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.inject.Named;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.common.BeanUtil;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.KmuIkkatsuData;
import jp.co.takeda.rdm.dto.ND401DTO;
import jp.co.takeda.rdm.dto.NF011DTO;
import jp.co.takeda.rdm.entity.MRdmHcoKeieitaiEntiry;
import jp.co.takeda.rdm.entity.join.MRdmComCalUsrEntity;
import jp.co.takeda.rdm.entity.join.SelectCntSelectNd401InitEntity;
import jp.co.takeda.rdm.entity.join.SelectComboListEntity;
import jp.co.takeda.rdm.entity.join.SelectHenkanListEntity;
import jp.co.takeda.rdm.entity.join.SelectNd401InitEntity;
import jp.co.takeda.rdm.entity.join.SelectParamNd401Entity;
import jp.co.takeda.rdm.entity.join.SelectParamSwitchEntity;
import jp.co.takeda.rdm.entity.join.SelectRdmComTrtgrpDataEntity;
import jp.co.takeda.rdm.entity.join.TRdmHcpKmuReqEntity;
import jp.co.takeda.rdm.entity.join.TRdmHcpReqEntity;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;

/**
 * Serviceクラス（ND101)
 *
 * @generated
 */
@Named
public class ND401Service extends BaseService {

	/**
	 * ログインスタンス
	 *
	 * @generated
	 */
	private static Log log = LogFactory.getLog(ND401Service.class);

	/**
	 * イベント処理
	 *
	 * @param indto ND101DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO init(ND401DTO indto) {

		BaseDTO outdto = indto;
		// 1-1 権限判定
		LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

		// MR権限の場合検索条件．組織、検索条件．担当者設定する
		if (RdmConstantsData.RDM_JKN_MR.equals(loginInfo.getJokenSetCd())) {
			indto.setKensakuSosCd(loginInfo.getSosCd());
			indto.setKensakuSosName(loginInfo.getBumonRyakuName());
			indto.setKensakuJgiNo(Integer.toString(loginInfo.getJgiNo()));
			indto.setKensakuJgiName(loginInfo.getJgiName());
			indto.setKensakuBrCode(loginInfo.getBrCode());
			indto.setKensakuDistCode(loginInfo.getDistCode());
			indto.setKensakuBumonRank(loginInfo.getBumonRank());
		}

		// 初期表示画面フラグ = 1(初期化)
		indto.setPageFlag("1");

		// ページNO
		indto.setPageCntCur(1);
		return outdto;
	}

	public BaseDTO search(ND401DTO indto) {
		LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

		BaseDTO outdto = indto;

		// DropDownList作成
		createCombo(indto);

		// エラーチェック
		// 検索項目未入力の場合
		boolean inputFlg = false;

		if (!StringUtils.isEmpty(indto.getKensakuSosCd())) {
			inputFlg = true;
		} else if (!StringUtils.isEmpty(indto.getKensakuJgiNo())) {
			inputFlg = true;
		} else if (!StringUtils.isEmpty(indto.getKensakuDeptCode())) {
			inputFlg = true;
		} else if (!StringUtils.isEmpty(indto.getKensakuInsKanj())) {
			inputFlg = true;
		} else if (!StringUtils.isEmpty(indto.getKensakuInsNo())) {
			inputFlg = true;
		} else if (!StringUtils.isEmpty(indto.getKensakuDocKanj())) {
			inputFlg = true;
		} else if (!StringUtils.isEmpty(indto.getKensakuDocNo())) {
			inputFlg = true;
		}

		if (!inputFlg) {
			// 検索条件を入力してください。
			String tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W001);
			// エラーメッセージをdtoに格納
			indto.setMsgStr(tmpMsgStr);
			return outdto;
		}

		// 1-4 件数定義取得
		SelectParamNd401Entity selectParamNd401Entity = new SelectParamNd401Entity();
		List<SelectParamNd401Entity> selectParamNd401List;
		selectParamNd401List = dao.select(selectParamNd401Entity);

		// 1-5 機能定義取得
		SelectParamSwitchEntity selectParamSwitchEntity = new SelectParamSwitchEntity();
		// MN_DOC
		selectParamSwitchEntity.setInParamName(1);

		List<SelectParamSwitchEntity> selectParamSwitchIshiList;
		selectParamSwitchIshiList = dao.select(selectParamSwitchEntity);

		String ishiHenshuFlg = selectParamSwitchIshiList.get(0).getHenshuFlg();

		// MN_KMU
		selectParamSwitchEntity.setInParamName(2);
		List<SelectParamSwitchEntity> selectParamSwitchIshiKinmuList;
		selectParamSwitchIshiKinmuList = dao.select(selectParamSwitchEntity);
		String ishiKinmuHenshuFlg = selectParamSwitchIshiKinmuList.get(0).getHenshuFlg();

		String reqSwitchFlg = "0";

		if ("1".equals(ishiHenshuFlg) && "1".equals(ishiKinmuHenshuFlg)) {
			reqSwitchFlg = "1";
		}

		indto.setReqBtnFlg(reqSwitchFlg);

		SelectCntSelectNd401InitEntity selectParamSelectKmuEntity = new SelectCntSelectNd401InitEntity();
		SelectNd401InitEntity selectNd401InitEntity = new SelectNd401InitEntity();

		// 検索条件_施設名
		// 漢字変換(F_RDM_KJ_HENKAN)
		if (indto.getKensakuInsKanj() != null && !indto.getKensakuInsKanj().isEmpty()) {
			SelectHenkanListEntity henkanEntity = new SelectHenkanListEntity("漢字変換");
			henkanEntity.setSearchHenkan(indto.getKensakuInsKanj());
			// 漢字変換
			List<SelectHenkanListEntity> selectHenkanListEntity = dao.select(henkanEntity);
			// 漢字変換後の値をセット
			String zenkaku = selectHenkanListEntity.get(0).getSearchHenkan();
			selectParamSelectKmuEntity.setKensakuInsKanj(zenkaku);
			selectNd401InitEntity.setKensakuInsKanj(zenkaku);
		}

		// 検索条件_施設固定C
		if (StringUtils.isEmpty(indto.getKensakuInsNo())) {
			indto.setKensakuInsNo(null);
		}
		selectParamSelectKmuEntity.setKensakuInsNo(indto.getKensakuInsNo());

		// 検索条件_医師名
		// 漢字変換(F_RDM_KJ_HENKAN)
		if (indto.getKensakuDocKanj() != null && !indto.getKensakuDocKanj().isEmpty()) {
			SelectHenkanListEntity henkanEntity = new SelectHenkanListEntity("漢字変換");
			henkanEntity.setSearchHenkan(indto.getKensakuDocKanj());
			// 漢字変換
			List<SelectHenkanListEntity> selectHenkanListEntity = dao.select(henkanEntity);
			// 漢字変換後の値をセット
			String zenkaku = selectHenkanListEntity.get(0).getSearchHenkan();
			selectParamSelectKmuEntity.setKensakuDocKanj(zenkaku);
			selectNd401InitEntity.setKensakuDocKanj(zenkaku);
		}

		// 検索条件_医師固定C
		if (StringUtils.isEmpty(indto.getKensakuDocNo())) {
			indto.setKensakuDocNo(null);
		}
		selectParamSelectKmuEntity.setKensakuDocNo(indto.getKensakuDocNo());
		// 検索条件_所属部科コード
		if (StringUtils.isEmpty(indto.getKensakuDeptCode())) {
			indto.setKensakuDeptCode(null);
		}
		selectParamSelectKmuEntity.setKensakuDeptCode(indto.getKensakuDeptCode());
		// 検索条件_組織コード
		if (StringUtils.isEmpty(indto.getKensakuSosCd())) {
			indto.setKensakuSosCd(null);
		}
		selectParamSelectKmuEntity.setKensakuSosCd(indto.getKensakuSosCd());
		// 検索条件_部門ランク
		if (StringUtils.isEmpty(indto.getKensakuBumonRank())) {
			indto.setKensakuBumonRank(null);
		}
		selectParamSelectKmuEntity.setKensakuBumonRank(indto.getKensakuBumonRank());
		// 索条件_医薬支店C
		if (StringUtils.isEmpty(indto.getKensakuBrCode())) {
			indto.setKensakuBrCode(null);
		}
		selectParamSelectKmuEntity.setKensakuBrCode(indto.getKensakuBrCode());
		// 検索条件_担当者コード(従業員番号)
		if (StringUtils.isEmpty(indto.getKensakuJgiNo())) {
			indto.setKensakuJgiNo(null);
		}
		selectParamSelectKmuEntity.setKensakuJgiNo(indto.getKensakuJgiNo());

		// 検索条件
		List<SelectCntSelectNd401InitEntity> selectParamSelectKmuList;
		selectParamSelectKmuList = dao.select(selectParamSelectKmuEntity);
		indto.setPageCnt(selectParamSelectKmuList.get(0).getCntKmu());
		indto.setMaxPageCnt(selectParamNd401List.get(0).getValue());

		if (checkSearchResults(loginInfo, indto, false)) {
			return outdto;
		}

		indto.initPageInfo(indto.getPageCntCur(), selectParamSelectKmuList.get(0).getCntKmu(),
				selectParamNd401List.get(1).getValue());

		// 検索条件_施設固定C
		if (StringUtils.isEmpty(indto.getKensakuInsNo())) {
			indto.setKensakuInsNo(null);
		}
		selectNd401InitEntity.setKensakuInsNo(indto.getKensakuInsNo());
		// 検索条件_医師固定C
		if (StringUtils.isEmpty(indto.getKensakuDocNo())) {
			indto.setKensakuDocNo(null);
		}
		selectNd401InitEntity.setKensakuDocNo(indto.getKensakuDocNo());
		// 検索条件_所属部科コード
		if (StringUtils.isEmpty(indto.getKensakuDeptCode())) {
			indto.setKensakuDeptCode(null);
		}
		selectNd401InitEntity.setKensakuDeptCode(indto.getKensakuDeptCode());
		// 検索条件_組織コード
		if (StringUtils.isEmpty(indto.getKensakuSosCd())) {
			indto.setKensakuSosCd(null);
		}
		selectNd401InitEntity.setKensakuSosCd(indto.getKensakuSosCd());
		// 検索条件_部門ランク
		if (StringUtils.isEmpty(indto.getKensakuBumonRank())) {
			indto.setKensakuBumonRank(null);
		}
		selectNd401InitEntity.setKensakuBumonRank(indto.getKensakuBumonRank());
		// 索条件_医薬支店C
		if (StringUtils.isEmpty(indto.getKensakuBrCode())) {
			indto.setKensakuBrCode(null);
		}
		selectNd401InitEntity.setKensakuBrCode(indto.getKensakuBrCode());
		// 検索条件_担当者コード(従業員番号)
		if (StringUtils.isEmpty(indto.getKensakuJgiNo())) {
			indto.setKensakuJgiNo(null);
		}
		selectNd401InitEntity.setKensakuJgiNo(indto.getKensakuJgiNo());

		// offset limit設定
		selectNd401InitEntity.setInOffset(indto.getLineCntStart() - 1);
		selectNd401InitEntity.setInLimit(selectParamNd401List.get(1).getValue());

		List<SelectNd401InitEntity> selectNd401InitList;
		selectNd401InitList = dao.select(selectNd401InitEntity);

		List<KmuIkkatsuData> kmuIkkatsuDataList = new ArrayList<KmuIkkatsuData>(selectNd401InitList.size());

		for (SelectNd401InitEntity entity : selectNd401InitList) {
			KmuIkkatsuData data = new KmuIkkatsuData();
			BeanUtil.copyProperties(data, entity);

			data.setInsAbbrName(entity.getInsAbbrName());// 施設名
			data.setInsNo(entity.getInsNo());// 施設固定コード
			data.setDocNo(entity.getDocNo());// 医師固定コード
			data.setDocKanj(entity.getDocKanj());// 氏名（漢字）

			data.setPreTitleKj(entity.getPreTitleKj());// 役職（変更前）
			data.setPostTitleKj(entity.getPostTitleKj());// 役職（変更後）
			data.setPreDeptKanji(entity.getPreDeptKanji());// 所属部科名（漢字）（変更前）
			data.setPostDeptKanji(entity.getPostDeptKanji());// 所属部科名（漢字）（変更後）
			data.setPreTitleCode(entity.getPreTitleCode());// 役職コード（変更前）
			data.setPostTitleCode(entity.getPostTitleCode());// 役職コード（変更後）
			data.setPreDeptCode(entity.getPreDeptCode());// 所属部科コード（変更前）
			data.setPostDeptCode(entity.getPostDeptCode());// 所属部科コード（変更後）
			data.setPreDeptKana(entity.getPreDeptKana());// 所属部科名（カナ）（変更前）
			data.setPostDeptKana(entity.getPostDeptKana());// 所属部科名（カナ）（変更後）
			data.setJobForm(entity.getJobForm());// 勤務形態
			data.setUnivPosCode(entity.getUnivPosCode());// 大学職位コード
			data.setDcc(entity.getDcc());// 薬審メンバー区分
			data.setUltInsNo(entity.getUltInsNo());// ULT施設コード
			data.setUltDocNo(entity.getUltDocNo());// ULT医師コード

			kmuIkkatsuDataList.add(data);
		}

		indto.setPageFlag("0");
		indto.setKmuIkkatsuDataList(kmuIkkatsuDataList);

		indto.setSearchType("1");

		return outdto;
	}

	/**
	 * イベント処理
	 *
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

	/**
	 * イベント処理
	 *
	 * @param indto ND401DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO req(ND401DTO indto) {
		BaseDTO outdto = indto;
		LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

		boolean errFlg = false;
		String errMsg = "";

		List<KmuIkkatsuData> kmuIkkatsuDataList = new ArrayList<KmuIkkatsuData>();

		// 変更有のもののみ取得
		for (KmuIkkatsuData entity : indto.getKmuIkkatsuDataList()) {
			if (!entity.getPreTitleCode().equals(entity.getPostTitleCode())) {
				// 役職変更有
				kmuIkkatsuDataList.add(entity);
			} else if (!entity.getPreDeptCode().equals(entity.getPostDeptCode())) {
				// 所属部科変更有
				kmuIkkatsuDataList.add(entity);
			}
		}

		// エラーチェック
		// 勤務先情報が変更されていない場合
		if (kmuIkkatsuDataList.size() == 0) {
			errMsg += loginInfo.getMsgData(RdmConstantsData.W045) + "\n";
			errFlg = true;
		}

		// 必須チェック
		for (KmuIkkatsuData entity : kmuIkkatsuDataList) {
			// 役職が未選択
			if (StringUtils.isEmpty(entity.getPostTitleCode())) {
				// 施設コード_施設略式漢字名、医師コード_必須項目にデータを入力してください。（役職（変更後））
				StringBuilder msgSb = new StringBuilder();
				msgSb.append(entity.getInsNo());
				msgSb.append("_");
				msgSb.append(entity.getInsAbbrName());
				msgSb.append("、");
				msgSb.append(entity.getDocNo());
				msgSb.append("_");
				msgSb.append(entity.getDocKanj());
				msgSb.append("：");

				errMsg += msgSb.toString()
						+ loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "役職（変更後）")
						+ "\n";
				errFlg = true;
			}
		}

		// 整合性チェック
		for (KmuIkkatsuData entity : kmuIkkatsuDataList) {
			// 医師の廃業・死亡申請している場合
			TRdmHcpReqEntity tRdmHcpReqEntity = new TRdmHcpReqEntity();
			tRdmHcpReqEntity.setSqlId("selectND401CheckDelData");
			tRdmHcpReqEntity.setDocNo(entity.getDocNo());

			List<TRdmHcpReqEntity> tRdmHcpReqChkList = dao.select(tRdmHcpReqEntity);
			if (tRdmHcpReqChkList.size() > 0) {
				// 施設コード_施設略式漢字名、医師コード_医師名：医師免許返納・死亡の申請されているため申請できません。（医師固定コード）
				StringBuilder msgSb = new StringBuilder();
				msgSb.append(entity.getInsNo());
				msgSb.append("_");
				msgSb.append(entity.getInsAbbrName());
				msgSb.append("、");
				msgSb.append(entity.getDocNo());
				msgSb.append("_");
				msgSb.append(entity.getDocKanj());
				msgSb.append("：");

				errMsg += msgSb.toString()
						+ loginInfo.getMsgData(RdmConstantsData.W043).replace("（施設名）", "").replace("医師名", "医師固定コード")
						+ "\n";
				errFlg = true;
			}

			// 同一の医師勤務先の異動、削除申請がされている場合
			TRdmHcpKmuReqEntity tRdmHcpKmuReqEntity = new TRdmHcpKmuReqEntity("selectND401CheckData");
			tRdmHcpKmuReqEntity.setDocNo(entity.getDocNo());
			tRdmHcpKmuReqEntity.setInsNoMt(entity.getInsNo());

			List<TRdmHcpKmuReqEntity> tRdmHcpKmuReqChkList = dao.select(tRdmHcpKmuReqEntity);
			if (tRdmHcpKmuReqChkList.size() > 0) {
				// 施設コード_施設略式漢字名、医師コード_医師名：医師勤務先の異動、削除申請がされているため申請できません。（施設固定コード）（医師固定コード）
				StringBuilder msgSb = new StringBuilder();
				msgSb.append(entity.getInsNo());
				msgSb.append("_");
				msgSb.append(entity.getInsAbbrName());
				msgSb.append("、");
				msgSb.append(entity.getDocNo());
				msgSb.append("_");
				msgSb.append(entity.getDocKanj());
				msgSb.append("：");

				errMsg += msgSb.toString() + loginInfo.getMsgData(RdmConstantsData.W044).replace("施設名", "施設固定コード")
						.replace("医師名", "医師固定コード") + "\n";
				errFlg = true;
			}

			//勤務先が廃院
			tRdmHcpKmuReqEntity.setSqlId("selectND401CheckInsDel");
			tRdmHcpKmuReqEntity.setInsNoMt(entity.getInsNo());
			List<TRdmHcpKmuReqEntity> delInsChkList = dao.select(tRdmHcpKmuReqEntity);
			if (delInsChkList.size() > 0) {
				// 施設コード_施設略式漢字名、医師コード_医師名：勤務先が廃院のため申請できません。
				StringBuilder msgSb = new StringBuilder();
				msgSb.append(entity.getInsNo());
				msgSb.append("_");
				msgSb.append(entity.getInsAbbrName());
				msgSb.append("、");
				msgSb.append(entity.getDocNo());
				msgSb.append("_");
				msgSb.append(entity.getDocKanj());
				msgSb.append("：");

				errMsg += msgSb.toString() + loginInfo.getMsgData(RdmConstantsData.W073) + "\n";
				errFlg = true;
			}
		}

		// エラー時処理
		if (errFlg) {
			indto.setMsgStr(errMsg);
			indto.setForward("ND401");

			// DropDownList作成
			createCombo(indto);
			return outdto;
		}

		// 変更有のリストをセット
		indto.setKmuIkkatsuDataList(kmuIkkatsuDataList);

		indto.setForward("ND403Init");
		return outdto;
	}

	/*
	 * ６：範囲チェック 検索結果件数 エラーありならtrueとし、エラーメッセージをmsgStrにセットする
	 */
	private boolean checkSearchResults(LoginInfo loginInfo, ND401DTO indto, boolean fullchkFlg) {

		boolean errChk = false;
		String msgStr = "";
		String tmpMsgStr = "";

		// ６：範囲チェック
		// 検索結果件数
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

	/**
	 * コンボ作成
	 *
	 * @param indto NF011DTO
	 * @return なし
	 * @customizable
	 */
	private void createCombo(ND401DTO indto) {
		// 役職プルダウン
		SelectNd401InitEntity selectNd401DmcMstPostEntity = new SelectNd401InitEntity();
		selectNd401DmcMstPostEntity.setSqlId("selectCntNd401DmcMstPost");
		List<SelectNd401InitEntity> selectNd401DmcMstPostListList = dao.select(selectNd401DmcMstPostEntity);

		// 役職データ_取り出す
		LinkedHashMap<String, String> mapTitleList = new LinkedHashMap<String, String>();
		mapTitleList.put("", "--なし--");
		for (SelectNd401InitEntity outEntity : selectNd401DmcMstPostListList) {
			mapTitleList.put(outEntity.getPuldownTitleCode(), outEntity.getPuldownTitleKj());
		}
		// 役職を格納する
		indto.setTitleMap(mapTitleList);
	}
}
