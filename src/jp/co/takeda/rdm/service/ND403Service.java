/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.KmuIkkatsuData;
import jp.co.takeda.rdm.dto.ND401DTO;
import jp.co.takeda.rdm.dto.ND403DTO;
import jp.co.takeda.rdm.entity.join.SelectHcpWorkEntity;
import jp.co.takeda.rdm.entity.join.SelectNd401InitEntity;
import jp.co.takeda.rdm.entity.join.SelectParamSwitchEntity;
import jp.co.takeda.rdm.entity.join.SeqRdmReqIdEntity;
import jp.co.takeda.rdm.entity.join.TRdmHcpKmuReqEntity;
import jp.co.takeda.rdm.entity.join.TRdmHcpReqEntity;
import jp.co.takeda.rdm.entity.join.TRdmReqKnrEntity;
import jp.co.takeda.rdm.util.DateUtils;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;

/**
 * Serviceクラス（ND403)
 *
 * @generated
 */
@Named
public class ND403Service extends BaseService {

	// ログインユーザ情報取得
	LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

	boolean errChk = false;
	String msgStr = "";
	String tmpMsgStr = "";
	int len = 0;

	/**
	 * イベント処理
	 *
	 * @param dto ND403DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO init(ND403DTO indto) {
		BaseDTO outdto = indto;

		boolean errFlg = false;
		String errMsg = "";

		// 1-1 権限判定
		LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();
		// ND401のデータ
		List<KmuIkkatsuData> kmuIkkatsuDataList = indto.getKmuIkkatsuDataList();

		String ishiFlg;
		String ishiKmuFlg;
		SelectParamSwitchEntity selectParamSwitchEntity = new SelectParamSwitchEntity();
		selectParamSwitchEntity.setInParamName(1);
		List<SelectParamSwitchEntity> selectParamSwitchList = dao.select(selectParamSwitchEntity);

		SelectParamSwitchEntity selectParamSwitchEntity2 = new SelectParamSwitchEntity();
		selectParamSwitchEntity2.setInParamName(2);
		List<SelectParamSwitchEntity> selectParamSwitchList2 = dao.select(selectParamSwitchEntity2);

		if (selectParamSwitchList.size() > 0 && selectParamSwitchList.get(0) != null
				&& selectParamSwitchList2.size() > 0 && selectParamSwitchList2.get(0) != null) {
			ishiFlg = selectParamSwitchList.get(0).getHenshuFlg();
			ishiKmuFlg = selectParamSwitchList2.get(0).getHenshuFlg();

			if (ishiFlg.equals(ishiKmuFlg)) {
				indto.setReqBtnFlg("1");
			} else {
				indto.setReqBtnFlg("0");
			}
		}

		// 役職プルダウン
		SelectNd401InitEntity selectNd401DmcMstPostEntity = new SelectNd401InitEntity();
		selectNd401DmcMstPostEntity.setSqlId("selectCntNd401DmcMstPost");
		List<SelectNd401InitEntity> selectNd401DmcMstPostListList = dao.select(selectNd401DmcMstPostEntity);

		// ND403に格納用
		List<KmuIkkatsuData> kmuIkkatsuDataND403List = new ArrayList<KmuIkkatsuData>();

		for (KmuIkkatsuData entity : kmuIkkatsuDataList) {
			KmuIkkatsuData data = new KmuIkkatsuData();
			// 変更したデータがある場合格納
			if (!(Objects.equals(entity.getPreTitleCode(), entity.getPostTitleCode()))
					|| !(Objects.equals(entity.getPreDeptCode(), entity.getPostDeptCode()))) {

				data.setInsAbbrName(entity.getInsAbbrName());// 施設名
				data.setInsNo(entity.getInsNo());// 施設固定コード
				data.setDocNo(entity.getDocNo());// 医師固定コード
				data.setDocKanj(entity.getDocKanj());// 氏名（漢字）
				// 役職データ_取り出す
				for (SelectNd401InitEntity outEntity : selectNd401DmcMstPostListList) {
					if (Objects.equals(entity.getPreTitleCode(), outEntity.getPuldownTitleCode())) {
						data.setPreTitleKj(outEntity.getPuldownTitleKj());// 役職（変更前）
					}
					if (Objects.equals(entity.getPostTitleCode(), outEntity.getPuldownTitleCode())) {
						data.setPostTitleKj(outEntity.getPuldownTitleKj());// 役職（変更後）
					}
				}

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

				SelectHcpWorkEntity selectHcpWorkEntity = new SelectHcpWorkEntity();
				selectHcpWorkEntity.setSqlId("selectNd403UpdYmd");
				selectHcpWorkEntity.setInDocNo(entity.getDocNo());
				selectHcpWorkEntity.setInInsNo(entity.getInsNo());
				List<SelectHcpWorkEntity> selectHcpWorkList = dao.select(selectHcpWorkEntity);

				if (selectHcpWorkList.size() > 0 && selectHcpWorkList.get(0) != null) {
					data.setUpdShaYmd(selectHcpWorkList.get(0).getUpdShaYmd());
				}

				kmuIkkatsuDataND403List.add(data);

				// 必須チェック
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

				// エラーチェック
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
			}
		}

		// 勤務先情報が変更されていない場合
		if(kmuIkkatsuDataND403List.size() == 0) {
			// 勤務先情報が変更されていません。
			errMsg += loginInfo.getMsgData(RdmConstantsData.W045) + "\n";
			errFlg = true;
		}

		if(errFlg) {
			String title = "ND401_医師勤務先情報一括更新";
            indto.setTitle(title);
        	indto.setMsgStr(errMsg);
        	createCombo(indto);
			outdto.setForward("ND401");
        	return outdto;

		}

		indto.setKmuIkkatsuDataList(kmuIkkatsuDataND403List);

		// 初期表示画面フラグ = 1(初期化)
		indto.setPageFlag("1");

		// ページNO
		indto.setPageCntCur(1);
		return outdto;

	}

	public BaseDTO register(ND403DTO indto) {
		BaseDTO outdto = indto;

		List<KmuIkkatsuData> kmuIkkatsuDataList = indto.getKmuIkkatsuDataList();

		LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

		boolean errFlg = false;
		String errMsg = "";

		// 項目 チェック内容
		// 申請コメント ３００文字を超えている場合
		if (!StringUtils.isEmpty(indto.getReqComment())) {
			// len = StringUtils.getByteLength(indto.getReqComment());
			len = indto.getReqComment().length();
			if (len > 100) {
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W009);// 最大文字数を超えています。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "申請コメント");
				errMsg = errMsg + tmpMsgStr + "\n";
				errFlg = true;
			}
		}

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

			// 排他チェック
			// 最終更新日時が、画面OPEN時とボタン押下時で異なっていた場合
			String updDate = entity.getUpdShaYmd();
			if (indto.getUpdShaYmd() != null && !indto.getUpdShaYmd().equals("")) {
				SelectHcpWorkEntity selectHcpWorkEntity = new SelectHcpWorkEntity();
				selectHcpWorkEntity.setSqlId("selectNd403UpdYmd");
				selectHcpWorkEntity.setInDocNo(entity.getDocNo());
				selectHcpWorkEntity.setInInsNo(entity.getInsNo());
				List<SelectHcpWorkEntity> selectHcpWorkList = dao.select(selectHcpWorkEntity);

				if (selectHcpWorkList.size() > 0 && selectHcpWorkList.get(0) != null) {
					if (!selectHcpWorkList.get(0).getUpdShaYmd().equals(updDate)) {
						// 既に他のユーザーによってデータが処理されています。
						errMsg += loginInfo.getMsgData(RdmConstantsData.E003) + "\n";
						errFlg = true;

					}
				}
			}

		}
		// エラー時処理
		if (errFlg) {
			indto.setMsgStr(errMsg);
			indto.setTitle("ND403_医師勤務先情報一括更新 - 申請内容確認");
			outdto.setForward("ND403");
			return outdto;
		}

		// 現在日付を取得
		Date systemDate = DateUtils.getNowDate();
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
		String sysDate = fmtDate.format(systemDate);
		SimpleDateFormat fmtDateTime = new SimpleDateFormat("yyyyMMddHHmmss");
		String sysDateTime = fmtDateTime.format(systemDate);

		// 申請データ用のdto
		// 登録処理
		for (KmuIkkatsuData entity : indto.getKmuIkkatsuDataList()) {
			// 申請管理
			// 新規にIDを取得
			SeqRdmReqIdEntity seqRdmReqIdEntity = new SeqRdmReqIdEntity();
			List<SeqRdmReqIdEntity> seqRdmReqIdDate = dao.select(seqRdmReqIdEntity);
			String reqId = seqRdmReqIdDate.get(0).getReqId();

			// レコードを登録
			TRdmReqKnrEntity tRdmReqKnrInsData = new TRdmReqKnrEntity();
			tRdmReqKnrInsData.setReqId(reqId);

			// MRが申請の場合、'1'(MR起因)
			// 承認者（管理者権限）が申請の場合、'2'(DSG起因)
			if (loginInfo.getJokenSetCd().equals("JKN0023")) {
				tRdmReqKnrInsData.setReqChl("1");
			} else {
				tRdmReqKnrInsData.setReqChl("2");
			}
			tRdmReqKnrInsData.setReqKngKbn("2");

			tRdmReqKnrInsData.setReqType("51");

			// 申請
			tRdmReqKnrInsData.setReqStsCd("03");

			// 適用開始日未記載

			tRdmReqKnrInsData.setReqBrCd(loginInfo.getBrCode());
			tRdmReqKnrInsData.setReqDistCd(loginInfo.getDistCode());
			tRdmReqKnrInsData.setReqShzNm(loginInfo.getBumonRyakuName());
			tRdmReqKnrInsData.setReqJgiNo(loginInfo.getJgiNo());
			tRdmReqKnrInsData.setReqJgiName(loginInfo.getJgiName());
			tRdmReqKnrInsData.setReqYmdhms(sysDateTime);

			tRdmReqKnrInsData.setReqComment(indto.getReqComment());
			tRdmReqKnrInsData.setInsNo(entity.getInsNo());
			tRdmReqKnrInsData.setDocNo(entity.getDocNo());

			// チェックあり：'1'（FB申請要）
			tRdmReqKnrInsData.setFbReqFlg("1");

			tRdmReqKnrInsData.setInsShaYmd(systemDate);
			tRdmReqKnrInsData.setInsShaId(Integer.toString(loginInfo.getJgiNo()));
			tRdmReqKnrInsData.setUpdShaYmd(systemDate);
			tRdmReqKnrInsData.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));

			dao.insertByValue(tRdmReqKnrInsData);

			// 勤務先_申請管理
			TRdmHcpKmuReqEntity tRdmHcpKmuReqInsData = new TRdmHcpKmuReqEntity();
			tRdmHcpKmuReqInsData.setReqId(reqId);
			tRdmHcpKmuReqInsData.setDocNo(entity.getDocNo());
			tRdmHcpKmuReqInsData.setDeptCodeBf(StringUtils.nvl(entity.getPreDeptCode(), ""));
			tRdmHcpKmuReqInsData.setDeptKanjiBf(StringUtils.nvl(entity.getPreDeptKanji(), ""));
			tRdmHcpKmuReqInsData.setDeptKanaBf(StringUtils.nvl(entity.getPreDeptKana(), ""));
			tRdmHcpKmuReqInsData.setTitleCodeBf(StringUtils.nvl(entity.getPreTitleCode(), ""));
			tRdmHcpKmuReqInsData.setDeptCodeAf(getUpdValue(entity.getPreDeptCode(), entity.getPostDeptCode()));
			tRdmHcpKmuReqInsData.setDeptKanjiAf(getUpdValue(entity.getPreDeptKanji(), entity.getPostDeptKanji()));
			tRdmHcpKmuReqInsData.setDeptKanaAf(getUpdValue(entity.getPreDeptKana(), entity.getPostDeptKana()));
			tRdmHcpKmuReqInsData.setTitleCodeAf(getUpdValue(entity.getPreTitleCode(), entity.getPostTitleCode()));
			tRdmHcpKmuReqInsData.setInsShaYmd(systemDate);
			tRdmHcpKmuReqInsData.setInsShaId(Integer.toString(loginInfo.getJgiNo()));
			tRdmHcpKmuReqInsData.setUpdShaYmd(systemDate);
			tRdmHcpKmuReqInsData.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));

			dao.insertByValue(tRdmHcpKmuReqInsData);
		}
		indto.setForward("NC101");
		// END UOC
		return outdto;
	}

	/**
	 * 値無の場合は'Z'を返却
	 *
	 * @param preValue
	 * @param value
	 * @return
	 */
	public String getUpdValue(String preValue, String value) {
		String rtnValue = value;

		if (value == null || value.equals("")) {
			rtnValue = "Z";
		}

		return rtnValue;
	}

	/**
	 * コンボ作成
	 *
	 * @param indto NF011DTO
	 * @return なし
	 * @customizable
	 */
	private void createCombo(ND403DTO indto) {
		//役職プルダウン
    	SelectNd401InitEntity selectNd401DmcMstPostEntity = new SelectNd401InitEntity();
    	selectNd401DmcMstPostEntity.setSqlId("selectCntNd401DmcMstPost");
    	List<SelectNd401InitEntity> selectNd401DmcMstPostListList = dao.select(selectNd401DmcMstPostEntity);

    	//役職データ_取り出す
        LinkedHashMap<String, String> mapTitleList = new LinkedHashMap<String, String>();
        mapTitleList.put("", "--なし--");
        for (SelectNd401InitEntity outEntity : selectNd401DmcMstPostListList) {
        	mapTitleList.put(outEntity.getPuldownTitleCode(), outEntity.getPuldownTitleKj());
        }
        //役職を格納する
        indto.setTitleMap(mapTitleList);
	}
}
