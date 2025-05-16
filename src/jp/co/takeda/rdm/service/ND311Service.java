/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
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
import jp.co.takeda.rdm.dto.ND103DTO;
import jp.co.takeda.rdm.dto.ND311DTO;
import jp.co.takeda.rdm.entity.MRdmHcpYakusyokuEntity;
import jp.co.takeda.rdm.entity.join.MRdmCodeMstEntity;
import jp.co.takeda.rdm.entity.join.RdmCommonEntity;
import jp.co.takeda.rdm.entity.join.SelectHcpKmuReqNewEntity;
import jp.co.takeda.rdm.entity.join.SeqRdmReqIdEntity;
import jp.co.takeda.rdm.entity.join.TRdmHcpKmuReqEntity;
import jp.co.takeda.rdm.entity.join.TRdmReqKnrEntity;
import jp.co.takeda.rdm.util.DateUtils;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;

/**
 * Serviceクラス（ND311)
 *
 * @generated
 */
@Named
public class ND311Service extends BaseService {

	// ログインユーザ情報取得
	LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

	boolean errChk = false;
	String msgStr = "";
	String tmpMsgStr = "";
	int len = 0;

	/**
	 * イベント処理
	 *
	 * @param dto ND311DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO init(ND311DTO dto) {
		BaseDTO outdto = dto;

		// 初期表示
		SelectHcpKmuReqNewEntity paramEntity = new SelectHcpKmuReqNewEntity();
		// 申請IDをセット
		paramEntity.setParamReqId(dto.getParamReqId());
		// 画面初期表示時の帳票一覧を取得する
		List<SelectHcpKmuReqNewEntity> SelectHcpKmuReqNewList = dao.select(paramEntity);
		/*
		 * //申請ステータス_生成用エンティティ MRdmCodeMstEntity paramStatus = new MRdmCodeMstEntity();
		 * //検索条件_申請ステータス paramStatus.setCodeName("REQ_STS");
		 * paramStatus.setSqlId("selectByValue"); //申請ステータスの帳票一覧を取得する
		 * List<MRdmCodeMstEntity> SelectparamStatusList = dao.select(paramStatus);
		 *
		 * //医師_役職マスタ_生成用エンティティ MRdmHcpYakusyokuEntity paramYakusyoku = new
		 * MRdmHcpYakusyokuEntity(); //検索条件_大学職位利用フラグ=0
		 * paramYakusyoku.setUnivTitleFlg("0"); //役職の帳票一覧を取得する
		 * List<MRdmHcpYakusyokuEntity> SelectYakusyoku = dao.select(paramYakusyoku);
		 *
		 * //医師_役職マスタ_生成用エンティティ MRdmHcpYakusyokuEntity paramDaigakuSyokui = new
		 * MRdmHcpYakusyokuEntity(); //検索条件_大学職位利用フラグ=0
		 * paramDaigakuSyokui.setUnivTitleFlg("1"); //大学職位の帳票一覧を取得する
		 * List<MRdmHcpYakusyokuEntity> SelectDaigakuSyokui =
		 * dao.select(paramDaigakuSyokui);
		 *
		 * //勤務形態_生成用エンティティ MRdmCodeMstEntity paramKinmuKeitai = new
		 * MRdmCodeMstEntity(); //検索条件_勤務形態 paramKinmuKeitai.setCodeName("JOB_FORM");
		 * paramKinmuKeitai.setSqlId("selectByValue"); //勤務形態の帳票一覧を取得する
		 * List<MRdmCodeMstEntity> SelectKinmuKeitaiList = dao.select(paramKinmuKeitai);
		 *
		 * //薬審メンバー区分_生成用エンティティ MRdmCodeMstEntity paramYakushin = new
		 * MRdmCodeMstEntity(); //検索条件_薬審メンバー区分 paramYakushin.setCodeName("DCC");
		 * paramYakushin.setSqlId("selectByValue"); //薬審メンバー区分の帳票一覧を取得する
		 * List<MRdmCodeMstEntity> SelectYakushinList = dao.select(paramYakushin);
		 */
		for (SelectHcpKmuReqNewEntity entity : SelectHcpKmuReqNewList) {

			// 医師メニュースイッチ
			String ishiMenu = entity.getIshiMenu().substring(1, 2);
			// 医師勤務先メニュースイッチ
			String ishiKinmuEdit = entity.getIshiKinmu().substring(0, 1);
			// アクション編集
			/*
			 * 医師メニュースイッチが0 または 医師メニュースイッチが1かつ医師勤務先メニュースイッチが0の場合 アクション編集に0を挿入
			 * その他はアクション編集に1を挿入
			 */
			if (ishiMenu.equals("0") || (ishiMenu.equals("1") && ishiKinmuEdit.equals("0"))) {
				dto.setActionEdit("0");
			} else {
				dto.setActionEdit("1");
			}

			// 申請チャネル
			dto.setReqChl(entity.getReqChl());
			/*
			 * //申請者所属 dto.setReqShz(entity.getReqShz()); //申請ステータス(名称) for
			 * (MRdmCodeMstEntity outEntity : SelectparamStatusList) { if
			 * (Objects.deepEquals(entity.getReqSts(),outEntity.getValue1())) {
			 * dto.setReqSts(outEntity.getValue1Kanj()); break; } }
			 *
			 * //申請者氏名 dto.setJgiName(entity.getJgiName()); //申請日時 if
			 * (!StringUtils.isEmpty(entity.getReqYmdhms())) { String reqYmdhms =
			 * entity.getReqYmdhms(); String yyyy = reqYmdhms.substring(0,4); String mm =
			 * reqYmdhms.substring(4,6); String dd = reqYmdhms.substring(6,8);
			 * dto.setReqYmdhms(yyyy + "-" + mm + "-" + dd); }
			 *
			 * //申請者従業員番号 dto.setReqJgiNo(entity.getReqJgiNo()); //申請者所属リージョン
			 * dto.setBrCode(entity.getBrCode()); //申請者所属エリア
			 * dto.setReqDistCode(entity.getReqDistCode()); //申請ステータス(コード)
			 * dto.setReqStsCd(entity.getReqStsCd()); //更新日
			 * dto.setUpdShaYmd(entity.getUpdShaYmd()); //氏名（漢字）
			 * dto.setDocKanj(entity.getDocKanj()); //医師固定コード
			 * dto.setDocNo(entity.getDocNo()); //ULT医師コード
			 * dto.setUrlDocNo(entity.getUrlDocNo()); //施設略式漢字名
			 * dto.setInsAbbrName(entity.getInsAbbrName()); //所属部科漢字名
			 * dto.setDeptKj(entity.getDeptKj());
			 *
			 * //役職コード(異動先) for (MRdmHcpYakusyokuEntity outEntity : SelectYakusyoku) { if
			 * (Objects.equals(outEntity.getTitleCode(),entity.getTitleCodeAf())) {
			 * dto.setTitleCodeName(outEntity.getTitleKj()); break; } } //勤務形態(異動先) for
			 * (MRdmCodeMstEntity outEntity : SelectKinmuKeitaiList) { if
			 * (Objects.equals(outEntity.getValue1(),entity.getJobFormAf())) {
			 * dto.setJobFormAfName(outEntity.getValue1Kanj()); break; } } //薬審メンバー区分(異動先)
			 * for (MRdmCodeMstEntity outEntity : SelectYakushinList) { if
			 * (Objects.equals(outEntity.getValue1(),entity.getDccTypeAf())) {
			 * dto.setDccTypeAfName(outEntity.getValue1Kanj()); break; } } //大学職位コード(異動先)
			 * for (MRdmHcpYakusyokuEntity outEntity : SelectDaigakuSyokui) { if
			 * (Objects.equals(outEntity.getTitleCode(),entity.getUnivPosCodeAf())) {
			 * dto.setUnivPosCodeAfName(outEntity.getTitleKj()); break; } } //適用開始日 if
			 * (!StringUtils.isEmpty(entity.getTekiyoYmd())) { String tekiyoYmd =
			 * entity.getTekiyoYmd(); String Tyyyy = tekiyoYmd.substring(0,4); String Tmm =
			 * tekiyoYmd.substring(4,6); String Tdd = tekiyoYmd.substring(6,8);
			 * dto.setTekiyoYmd(Tyyyy + "-" + Tmm + "-" + Tdd); }
			 *
			 * //施設固定コード(異動先) dto.setInsNoSk(entity.getInsNoSk()); //ULT施設コード
			 * dto.setUltInsNo(entity.getUltInsNo()); //所属部科コード(異動先)
			 * dto.setDeptCodeAf(entity.getDeptCodeAf()); //所属部科カナ名
			 * dto.setDeptKn(entity.getDeptKn()); //申請コメント
			 * dto.setReqComment(entity.getReqComment()); //却下コメント
			 * dto.setAprComment(entity.getAprComment());
			 */
		}

		return dto;
	}

	/**
	 * イベント処理
	 *
	 * @param dto ND311DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO initReq(ND311DTO dto) {
		BaseDTO outdto = dto;
		// START UOC

		// ページ数(現在:１ページ目から)
		dto.setPageCntCur(1);

		LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

		String reqId = dto.getParamReqId();

		// 現在日付を取得
		Date systemDate = DateUtils.getNowDate();
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");

		LocalDateTime nowDate = LocalDateTime.now();
		ZoneId zone = ZoneId.systemDefault();
		ZonedDateTime zonedDateTime = ZonedDateTime.of(nowDate, zone);

		// 申請管理テーブル データ定義
		// 申請ステータスを「01：保存済」として各テーブルに画面の申請情報を登録
		// 申請管理
		TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity();
		tRdmReqKnrEntity.setReqId(dto.getParamReqId());
		TRdmReqKnrEntity tRdmReqKnrData = dao.selectByPK(tRdmReqKnrEntity);

		if (tRdmReqKnrData == null) {// insert処理

			// 新規にIDを取得 githubで実行
			SeqRdmReqIdEntity seqRdmReqIdEntity = new SeqRdmReqIdEntity();
			List<SeqRdmReqIdEntity> seqRdmReqIdDate = dao.select(seqRdmReqIdEntity);
			reqId = seqRdmReqIdDate.get(0).getReqId();
			dto.setParamReqId(reqId);

			// レコードを登録
			TRdmReqKnrEntity tRdmReqKnrInsData = new TRdmReqKnrEntity();
			tRdmReqKnrInsData.setReqId(reqId);
			if (RdmConstantsData.RDM_JKN_ADMIN.equals(dto.getLoginJokenSetCd())) {
				// 承認者（管理者権限）が申請の場合、'2'(DSG起因)
				tRdmReqKnrInsData.setReqChl("2");
				tRdmReqKnrInsData.setReqKngKbn("2");
			} else {
				// "MRが申請の場合、'1'(MR起因)
				tRdmReqKnrInsData.setReqChl("1");
				tRdmReqKnrInsData.setReqKngKbn("1");
			}
			tRdmReqKnrInsData.setReqType("41");
			tRdmReqKnrInsData.setReqStsCd("01");

			String tekiyoYmd = dto.getFormTekiyoYmd();
			if (tekiyoYmd != null) {
				tekiyoYmd = tekiyoYmd.replace("-", "");
			}
			tRdmReqKnrInsData.setTekiyoYmd(tekiyoYmd);
			tRdmReqKnrInsData.setReqBrCd(dto.getBrCode());
			tRdmReqKnrInsData.setReqDistCd(dto.getLoginDistCd());
			tRdmReqKnrInsData.setReqShzNm(dto.getLoginShzNm());
			tRdmReqKnrInsData.setReqJgiNo(dto.getLoginJgiNo());
			tRdmReqKnrInsData.setReqJgiName(dto.getJgiName());
			tRdmReqKnrInsData.setReqComment(dto.getReqComment());
			tRdmReqKnrInsData.setInsNo(dto.getInsNoSk());
			tRdmReqKnrInsData.setInsShaYmd(systemDate);
			tRdmReqKnrInsData.setInsShaId(String.valueOf(dto.getLoginJgiNo()));
			tRdmReqKnrInsData.setUpdShaYmd(systemDate);
			tRdmReqKnrInsData.setUpdShaId(String.valueOf(dto.getLoginJgiNo()));
			// 申請管理 insert処理
			dao.insertByValue(tRdmReqKnrInsData);
		} else {
			// 申請管理 更新
			TRdmReqKnrEntity tRdmReqKnrUpdData = new TRdmReqKnrEntity("updateNF211Data");
			tRdmReqKnrUpdData.setReqId(dto.getParamReqId());

			if ("13".equals(dto.getReqStsCd())) {
				tRdmReqKnrUpdData.setReqStsCd("11");
			} else {
				tRdmReqKnrUpdData.setReqStsCd("01");
			}
			String tekiyoYmd = dto.getFormTekiyoYmd();
			if (tekiyoYmd != null) {
				tekiyoYmd = tekiyoYmd.replace("-", "");
			}
			tRdmReqKnrUpdData.setTekiyoYmd(tekiyoYmd);
			tRdmReqKnrUpdData.setReqComment(dto.getReqComment());
			tRdmReqKnrUpdData.setUpdShaYmd(systemDate);
			tRdmReqKnrUpdData.setUpdShaId(String.valueOf(dto.getLoginJgiNo()));
			// 申請管理 更新処理
			dao.update(tRdmReqKnrUpdData);
		}

		// 勤務先申請管理 データ格納
		if (tRdmReqKnrData == null) {// 新規

			TRdmHcpKmuReqEntity tRdmHcpKmuReqInsData = new TRdmHcpKmuReqEntity();

			tRdmHcpKmuReqInsData.setReqId(reqId);
			tRdmHcpKmuReqInsData.setDocNo(dto.getDocNo());
			tRdmHcpKmuReqInsData.setJobFormAf(StringUtils.nvl(dto.getJobFormAf(), "Z"));
			tRdmHcpKmuReqInsData.setDeptCodeAf(StringUtils.nvl(dto.getDeptCodeAf(), "Z"));
			tRdmHcpKmuReqInsData.setDeptKanjiAf(StringUtils.nvl(dto.getDeptKj(), "Z"));
			tRdmHcpKmuReqInsData.setDeptKanaAf(StringUtils.nvl(dto.getDeptKn(), "Z"));
			tRdmHcpKmuReqInsData.setUnivPosCodeAf(dto.getUnivPosCodeAf());
			tRdmHcpKmuReqInsData.setTitleCodeAf(dto.getTitleCodeAf());
			tRdmHcpKmuReqInsData.setDccTypeAf(dto.getDccTypeAf());
			//tRdmHcpKmuReqInsData.setUltDocNo(dto.getUrlDocNo());
			//tRdmHcpKmuReqInsData.setUltInsNo(dto.getUltInsNo());
			tRdmHcpKmuReqInsData.setInsShaYmd(systemDate);
			tRdmHcpKmuReqInsData.setInsShaId(Integer.toString(loginInfo.getJgiNo()));
			tRdmHcpKmuReqInsData.setUpdShaYmd(systemDate);
			tRdmHcpKmuReqInsData.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));
			// 勤務先申請管理 insert処理
			dao.insertByValue(tRdmHcpKmuReqInsData);

		} else {// 勤務先申請管理 更新
			TRdmHcpKmuReqEntity tRdmHcpKmuReqUpdData = new TRdmHcpKmuReqEntity("updateND101Data");
			tRdmHcpKmuReqUpdData.setReqId(reqId);
			tRdmHcpKmuReqUpdData.setInsNoSk(StringUtils.nvl(dto.getInsNoSk(), "Z"));
			tRdmHcpKmuReqUpdData.setJobFormAf(StringUtils.nvl(dto.getJobFormAf(), "Z"));
			tRdmHcpKmuReqUpdData.setDeptCodeAf(StringUtils.nvl(dto.getDeptCodeAf(), "Z"));
			tRdmHcpKmuReqUpdData.setDeptKanjiAf(StringUtils.nvl(dto.getDeptKj(), "Z"));
			tRdmHcpKmuReqUpdData.setDeptKanaAf(StringUtils.nvl(dto.getDeptKn(), "Z"));
			tRdmHcpKmuReqUpdData.setUnivPosCodeAf(StringUtils.nvl(dto.getUnivPosCodeAf(), ""));
			tRdmHcpKmuReqUpdData.setTitleCodeAf(StringUtils.nvl(dto.getTitleCodeAf(), ""));
			tRdmHcpKmuReqUpdData.setDccTypeAf(StringUtils.nvl(dto.getDccTypeAf(), ""));
			//tRdmHcpKmuReqUpdData.setUltInsNo(dto.getUltInsNo());
			tRdmHcpKmuReqUpdData.setUpdShaYmd(systemDate);
			tRdmHcpKmuReqUpdData.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));

			dao.update(tRdmHcpKmuReqUpdData);
		}
		// END UOC
		return outdto;
	}

	/**
	 * イベント処理
	 *
	 * @param dto ND311DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO errorCheck(ND311DTO dto) {
		BaseDTO outdto = dto;

		SelectHcpKmuReqNewEntity paramEntity = new SelectHcpKmuReqNewEntity();

		// 申請IDをセット
		paramEntity.setParamReqId(dto.getParamReqId());
		// 医師固定コード
		paramEntity.setDocNo(dto.getDocNo());
		// 施設固定コード(異動先)
		paramEntity.setInsNoSk(dto.getInsNoSk());

		if(!StringUtils.isEmpty(dto.getReqId())) {
			paramEntity.setParamReqId(dto.getReqId());
		}

		paramEntity.setSqlId("errorCheck");

		// 同じ医師で同じ施設に対しての申請がすでに存在している場合
		paramEntity.setErrorCheckFlg("1");
		List<SelectHcpKmuReqNewEntity> juhuku = dao.select(paramEntity);

		// 重複申請チェックエラーがある場合
		if (!CollectionUtils.isEmpty(juhuku)) {
			// 重複申請チェックエラーを定義
			dto.setErrorCheckFlg("2");
			return outdto;
		}

		// 一時保存後、「申請画面へ」ボタン押下時に医師が廃業・死亡申請されている場合
		paramEntity.setErrorCheckFlg("4");
		List<SelectHcpKmuReqNewEntity> seigousei = dao.select(paramEntity);

		// 整合性チェックエラーがある場合
		if (!CollectionUtils.isEmpty(seigousei)) {
			// 整合性チェックエラーを定義
			dto.setErrorCheckFlg("3");
			return outdto;
		}

		// エラーチェック済
		dto.setErrorCheckFlg("1");

		return outdto;

	}

	/**
	 * 申請処理
	 *
	 * @param dto ND311DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO register(ND311DTO dto) {
		BaseDTO outdto = dto;

		LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

		// 現在日付を取得
		Date systemDate = DateUtils.getNowDate();
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat fmtDateTime = new SimpleDateFormat("yyyyMMddHHmmss");
		String sysDateTime = fmtDateTime.format(systemDate);

		if (Objects.deepEquals(dto.getProcessFlg(), "0")) {

			// 申請管理
			TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity();
			tRdmReqKnrEntity.setReqId(dto.getParamReqId());
			TRdmReqKnrEntity tRdmReqKnrData = dao.selectByPK(tRdmReqKnrEntity);

			String reqId = dto.getReqId();

			if (tRdmReqKnrData == null) {
				// 新規登録
				// 新規にIDを取得
				SeqRdmReqIdEntity seqRdmReqIdEntity = new SeqRdmReqIdEntity();
				List<SeqRdmReqIdEntity> seqRdmReqIdDate = dao.select(seqRdmReqIdEntity);
				reqId = seqRdmReqIdDate.get(0).getReqId();

				// レコードを登録
				TRdmReqKnrEntity tRdmReqKnrInsData = new TRdmReqKnrEntity();
				tRdmReqKnrInsData.setReqId(reqId);
				if (RdmConstantsData.RDM_JKN_ADMIN.equals(dto.getLoginJokenSetCd())) {
					// 承認者（管理者権限）が申請の場合、'2'(DSG起因)
					tRdmReqKnrInsData.setReqChl("2");
					tRdmReqKnrInsData.setReqKngKbn("2");
				} else {
					// "MRが申請の場合、'1'(MR起因)
					tRdmReqKnrInsData.setReqChl("1");
					tRdmReqKnrInsData.setReqKngKbn("1");
				}
				tRdmReqKnrInsData.setReqType("41");
				// 申請
				tRdmReqKnrInsData.setReqStsCd("03");

				tRdmReqKnrInsData.setTekiyoYmd(dto.getFormTekiyoYmd().replace("/", ""));

				tRdmReqKnrInsData.setReqBrCd(dto.getLoginBrCd());
				tRdmReqKnrInsData.setReqDistCd(dto.getLoginDistCd());
				tRdmReqKnrInsData.setReqShzNm(dto.getLoginShzNm());
				tRdmReqKnrInsData.setReqJgiNo(dto.getLoginJgiNo());
				tRdmReqKnrInsData.setReqJgiName(dto.getLoginNm());
				tRdmReqKnrInsData.setReqYmdhms(sysDateTime);
				tRdmReqKnrInsData.setReqComment(dto.getReqComment());
				tRdmReqKnrInsData.setInsNo(dto.getInsNoSk());
				tRdmReqKnrInsData.setDocNo(dto.getDocNo());
				tRdmReqKnrInsData.setFbReqFlg("1");
				tRdmReqKnrInsData.setInsShaYmd(systemDate);
				tRdmReqKnrInsData.setInsShaId(Integer.toString(dto.getLoginJgiNo()));
				tRdmReqKnrInsData.setUpdShaYmd(systemDate);
				tRdmReqKnrInsData.setUpdShaId(Integer.toString(dto.getLoginJgiNo()));

				dao.insertByValue(tRdmReqKnrInsData);

			} else {
				// 申請管理 申請
				TRdmReqKnrEntity tRdmReqKnrUpdData = new TRdmReqKnrEntity("updateTRdmReqKnrData");

				tRdmReqKnrUpdData.setReqId(reqId);// 申請ID
				if (RdmConstantsData.RDM_JKN_ADMIN.equals(dto.getLoginJokenSetCd())) {
					// 承認者（管理者権限）が申請の場合、'2'(DSG起因)
					tRdmReqKnrUpdData.setReqKngKbn("2");// 申請者権限区分
				} else {
					// "MRが申請の場合、'1'(MR起因)
					tRdmReqKnrUpdData.setReqKngKbn("1");// 申請者権限区分
				}
				// 申請ステータス
				if (Objects.deepEquals(dto.getReqChl(), "3")) {
					// 申請チャネルが'3'（ULT起因）の場合
					tRdmReqKnrUpdData.setReqStsCd("13");
				} else {
					// 申請チャネルが'1'(MR起因)、'2'(DSG起因)の場合
					tRdmReqKnrUpdData.setReqStsCd("03");
				}

				tRdmReqKnrUpdData.setTekiyoYmd(dto.getFormTekiyoYmd().replace("/", ""));
				tRdmReqKnrUpdData.setReqBrCd(loginInfo.getBrCode());// 申請者所属リージョン
				tRdmReqKnrUpdData.setReqDistCd(dto.getLoginDistCd());// 申請者所属エリア
				tRdmReqKnrUpdData.setReqShzNm(dto.getLoginShzNm());// 申請者所属
				tRdmReqKnrUpdData.setReqJgiNo(loginInfo.getJgiNo());// 申請者従業員番号
				tRdmReqKnrUpdData.setReqJgiName(loginInfo.getJgiName());// 申請者氏名
				tRdmReqKnrUpdData.setReqComment(dto.getReqComment());// 申請コメント
				tRdmReqKnrUpdData.setUpdShaYmd(systemDate);// 更新日
				tRdmReqKnrUpdData.setUpdShaId(String.valueOf(loginInfo.getJgiNo()));// 更新者
				// 申請管理 申請処理
				dao.update(tRdmReqKnrUpdData);
			}

			// 勤務先_申請管理
			if (tRdmReqKnrData == null) {// 新規

				TRdmHcpKmuReqEntity tRdmHcpKmuReqInsData = new TRdmHcpKmuReqEntity();

				tRdmHcpKmuReqInsData.setReqId(reqId);
				tRdmHcpKmuReqInsData.setDocNo(dto.getDocNo());
				tRdmHcpKmuReqInsData.setInsNoSk(dto.getInsNoSk());
				tRdmHcpKmuReqInsData.setJobFormAf(dto.getJobFormAf());
				tRdmHcpKmuReqInsData.setDeptCodeAf(dto.getDeptCodeAf());
				tRdmHcpKmuReqInsData.setDeptKanjiAf(dto.getDeptKj());
				tRdmHcpKmuReqInsData.setDeptKanaAf(dto.getDeptKn());
				tRdmHcpKmuReqInsData.setUnivPosCodeAf(dto.getUnivPosCodeAf());
				tRdmHcpKmuReqInsData.setTitleCodeAf(dto.getTitleCodeAf());
				tRdmHcpKmuReqInsData.setDccTypeAf(dto.getDccTypeAf());
				//tRdmHcpKmuReqInsData.setUltDocNo(dto.getUrlDocNo());
				//tRdmHcpKmuReqInsData.setUltInsNo(dto.getUltInsNo());
				tRdmHcpKmuReqInsData.setInsShaYmd(systemDate);
				tRdmHcpKmuReqInsData.setInsShaId(Integer.toString(loginInfo.getJgiNo()));
				tRdmHcpKmuReqInsData.setUpdShaYmd(systemDate);
				tRdmHcpKmuReqInsData.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));
				// 勤務先申請管理 insert処理
				dao.insertByValue(tRdmHcpKmuReqInsData);

			} else {// 更新
				TRdmHcpKmuReqEntity tRdmHcpKmuReqUpdData = new TRdmHcpKmuReqEntity("updateND101Data");
				tRdmHcpKmuReqUpdData.setReqId(reqId);
				tRdmHcpKmuReqUpdData.setInsNoSk(dto.getInsNoSk());
				tRdmHcpKmuReqUpdData.setJobFormAf(dto.getJobFormAf());
				tRdmHcpKmuReqUpdData.setDeptCodeAf(dto.getDeptCodeAf());
				tRdmHcpKmuReqUpdData.setDeptKanjiAf(dto.getDeptKj());
				tRdmHcpKmuReqUpdData.setDeptKanaAf(dto.getDeptKn());
				tRdmHcpKmuReqUpdData.setUnivPosCodeAf(dto.getUnivPosCodeAf());
				tRdmHcpKmuReqUpdData.setTitleCodeAf(dto.getTitleCodeAf());
				tRdmHcpKmuReqUpdData.setDccTypeAf(dto.getDccTypeAf());
				//tRdmHcpKmuReqUpdData.setUltInsNo(dto.getUltInsNo());
				tRdmHcpKmuReqUpdData.setUpdShaYmd(systemDate);
				tRdmHcpKmuReqUpdData.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));

				dao.update(tRdmHcpKmuReqUpdData);
			}

		} else if (Objects.deepEquals(dto.getProcessFlg(), "1")) {
			// 申請管理 却下処理
			TRdmReqKnrEntity tRdmReqKnrUpdData = new TRdmReqKnrEntity("updateTRdmReqKnrData");
			// 申請IDを指定
			tRdmReqKnrUpdData.setReqId(dto.getParamReqId());
			// 申請ステータス
			if (Objects.deepEquals(dto.getReqChl(), "3")) {
				// 申請チャネルが'3'（ULT起因）の場合
				tRdmReqKnrUpdData.setReqStsCd("12");
			} else {
				// 申請チャネルが'1'(MR起因)、'2'(DSG起因)の場合
				tRdmReqKnrUpdData.setReqStsCd("02");
			}

			tRdmReqKnrUpdData.setTekiyoYmd(dto.getFormTekiyoYmd().replace("/", ""));
			tRdmReqKnrUpdData.setAprBrCode(loginInfo.getBrCode());// 承認者所属リージョン
			tRdmReqKnrUpdData.setAprDistCode(loginInfo.getDistCode());// 承認者所属エリア
			tRdmReqKnrUpdData.setAprShz(dto.getLoginShzNm());// 承認者所属
			tRdmReqKnrUpdData.setAprJgiNo(loginInfo.getJgiNo());// 承認者従業員番号
			tRdmReqKnrUpdData.setAprShaName(loginInfo.getJgiName());// 承認者氏名
			tRdmReqKnrUpdData.setAprYmdhms(sysDateTime);// 承認日時

			tRdmReqKnrUpdData.setAprComment(dto.getAprComment());// 却下コメント

			// 申請管理 却下処理
			dao.update(tRdmReqKnrUpdData);

			TRdmHcpKmuReqEntity tRdmHcpKmuReqUpdData = new TRdmHcpKmuReqEntity("updateND101Data");
			tRdmHcpKmuReqUpdData.setReqId(dto.getParamReqId());
			tRdmHcpKmuReqUpdData.setInsNoSk(StringUtils.nvl(dto.getInsNoSk(), "Z"));
			tRdmHcpKmuReqUpdData.setJobFormAf(StringUtils.nvl(dto.getJobFormAf(), "Z"));
			tRdmHcpKmuReqUpdData.setDeptCodeAf(StringUtils.nvl(dto.getDeptCodeAf(), "Z"));
			tRdmHcpKmuReqUpdData.setDeptKanjiAf(StringUtils.nvl(dto.getDeptKj(), "Z"));
			tRdmHcpKmuReqUpdData.setDeptKanaAf(StringUtils.nvl(dto.getDeptKn(), "Z"));
			tRdmHcpKmuReqUpdData.setUnivPosCodeAf(StringUtils.nvl(dto.getUnivPosCodeAf(), ""));
			tRdmHcpKmuReqUpdData.setTitleCodeAf(StringUtils.nvl(dto.getTitleCodeAf(), ""));
			tRdmHcpKmuReqUpdData.setDccTypeAf(StringUtils.nvl(dto.getDccTypeAf(), ""));
			tRdmHcpKmuReqUpdData.setUltInsNo(dto.getUltInsNo());
			tRdmHcpKmuReqUpdData.setUpdShaYmd(systemDate);
			tRdmHcpKmuReqUpdData.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));

			dao.update(tRdmHcpKmuReqUpdData);
		}

		outdto.setForward("NC101");
		return outdto;
	}

	/**
	 * 更新処理
	 *
	 * @param dto ND311DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO pullDown(ND311DTO dto) {
		BaseDTO outdto = dto;

		// 医師_役職マスタ_生成用エンティティ
		MRdmHcpYakusyokuEntity paramYakusyoku = new MRdmHcpYakusyokuEntity();
		// 検索条件_大学職位利用フラグ=0
		paramYakusyoku.setUnivTitleFlg("0");
		// 役職の帳票一覧を取得する
		List<MRdmHcpYakusyokuEntity> SelectYakusyoku = dao.select(paramYakusyoku);
		// 役職データ_取り出す
		LinkedHashMap<String, String> yakusyokuMap = new LinkedHashMap<String, String>();
		yakusyokuMap.put("", "--なし--");
		for (MRdmHcpYakusyokuEntity outEntity : SelectYakusyoku) {
			yakusyokuMap.put(outEntity.getTitleCode(), outEntity.getTitleKj());
		}
		// 役職区分を格納する
		dto.setYakusyokuMap(yakusyokuMap);

		// 医師_役職マスタ_生成用エンティティ
		MRdmHcpYakusyokuEntity paramDaigakuSyokui = new MRdmHcpYakusyokuEntity();
		// 検索条件_大学職位利用フラグ=0
		paramDaigakuSyokui.setUnivTitleFlg("1");
		// 大学職位の帳票一覧を取得する
		List<MRdmHcpYakusyokuEntity> SelectDaigakuSyokui = dao.select(paramDaigakuSyokui);
		// 大学職位データ_取り出す
		LinkedHashMap<String, String> DaigakuSyokuiMap = new LinkedHashMap<String, String>();
		DaigakuSyokuiMap.put("", "--なし--");
		for (MRdmHcpYakusyokuEntity outEntity : SelectDaigakuSyokui) {
			DaigakuSyokuiMap.put(outEntity.getTitleCode(), outEntity.getTitleKj());
		}
		// 大学職位を格納する
		dto.setDaigakuSyokuiMap(DaigakuSyokuiMap);

		// 勤務形態_生成用エンティティ
		MRdmCodeMstEntity paramKinmuKeitai = new MRdmCodeMstEntity();
		// 検索条件_勤務形態
		paramKinmuKeitai.setCodeName("JOB_FORM");
		// 勤務形態の帳票一覧を取得する
		List<MRdmCodeMstEntity> SelectKinmuKeitaiList = dao.selectByValue(paramKinmuKeitai);
		// 勤務形態データ_取り出す
		LinkedHashMap<String, String> KinmuKeitai = new LinkedHashMap<String, String>();
		KinmuKeitai.put("", "--なし--");
		for (MRdmCodeMstEntity outEntity : SelectKinmuKeitaiList) {
			KinmuKeitai.put(outEntity.getValue1(), outEntity.getValue1Kanj());
		}
		// 勤務形態を格納する
		dto.setKinmuKeitaiMap(KinmuKeitai);

		// 薬審メンバー区分_生成用エンティティ
		MRdmCodeMstEntity paramYakushin = new MRdmCodeMstEntity();
		// 検索条件_薬審メンバー区分
		paramYakushin.setCodeName("DCC");
		// 薬審メンバー区分の帳票一覧を取得する
		List<MRdmCodeMstEntity> SelectYakushinList = dao.selectByValue(paramYakushin);
		// 薬審メンバー区分データ_取り出す
		LinkedHashMap<String, String> yakushinMap = new LinkedHashMap<String, String>();
		yakushinMap.put("", "--なし--");
		for (MRdmCodeMstEntity outEntity : SelectYakushinList) {
			yakushinMap.put(outEntity.getValue1(), outEntity.getValue1Kanj());
		}
		// 薬審メンバー区分を格納する
		dto.setYakushinMap(yakushinMap);
		// END UOC
		return outdto;
	}

	public String getNextBizday() {
		Date systemDate = DateUtils.getNowDate();
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMdd");
		String sysDate = fmtDate.format(systemDate);

		RdmCommonEntity rdmCommonEntity = new RdmCommonEntity("getNextBizday");
		rdmCommonEntity.setInVBatDate(sysDate.replace("-", ""));
		List<RdmCommonEntity> rdmCommonEntityList = dao.select(rdmCommonEntity);

		return rdmCommonEntityList.get(0).getNextBizday();
	}
}
