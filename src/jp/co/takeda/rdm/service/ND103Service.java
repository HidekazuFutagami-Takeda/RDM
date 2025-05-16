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

import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.ND103DTO;
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
 * Serviceクラス（ND103)
 *
 * @generated
 */
@Named
public class ND103Service extends BaseService {

	// ログインユーザ情報取得
	LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

	boolean errChk = false;
	String msgStr = "";
	String tmpMsgStr = "";
	int len = 0;

	/**
	 * イベント処理
	 *
	 * @param dto NC204DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO initReq(ND103DTO dto) {
		BaseDTO outdto = dto;
		// START UOC
		LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

		// ページ数(現在:１ページ目から)
		dto.setPageCntCur(1);

		SelectHcpKmuReqNewEntity paramEntity = new SelectHcpKmuReqNewEntity();

		// 申請IDをセット
		paramEntity.setParamReqId(dto.getParamReqId());
		if (StringUtils.isEmpty(dto.getParamReqId())) {
			dto.setParamReqId("-");
		}
		// 医師固定Cをセット
		paramEntity.setParamDocNo(dto.getParamDocNo());

		// 申請ステータス_生成用エンティティ
		MRdmCodeMstEntity paramStatus = new MRdmCodeMstEntity();
		// 検索条件_申請ステータス
		paramStatus.setCodeName("REQ_STS");
		// 申請ステータスの帳票一覧を取得する
		List<MRdmCodeMstEntity> SelectparamStatusList = dao.selectByValue(paramStatus);

		// 画面初期表示時の帳票一覧を取得する
		List<SelectHcpKmuReqNewEntity> SelectHcpKmuReqNewList = dao.select(paramEntity);

		for (SelectHcpKmuReqNewEntity entity : SelectHcpKmuReqNewList) {

			// 申請者所属
			dto.setReqShz(entity.getReqShz());
			// 申請ステータス(名称)
			for (MRdmCodeMstEntity outEntity : SelectparamStatusList) {
				if (Objects.deepEquals(entity.getReqSts(), outEntity.getValue1())) {
					dto.setReqSts(outEntity.getValue1Kanj());
					break;
				}
			}

			// 保存ボタン活性フラグ
			// '01'(保存済み)、'03'（承認待ち）、'13'(ULT承認待ち)の場合 活性
			if (Objects.deepEquals(entity.getReqSts(), "01") || Objects.deepEquals(entity.getReqSts(), "03")
					|| Objects.deepEquals(entity.getReqSts(), "13")) {

			} else {// その他非活

			}
			if (RdmConstantsData.RDM_JKN_ADMIN.equals(dto.getLoginJokenSetCd())) {// 管理者
				// '01'(保存済み)、'03'（承認待ち）、'13'(ULT承認待ち)の場合 活性
				if (Objects.deepEquals(entity.getReqSts(), "01") || Objects.deepEquals(entity.getReqSts(), "03")
						|| Objects.deepEquals(entity.getReqSts(), "13")) {
					dto.getShinseiButtonFlg();
				} else {// その他非活

				}
			} else {

			}

			// 申請画面 活性フラグ

			// 申請者氏名
			dto.setJgiName(entity.getJgiName());
			// 申請日時
			if (!StringUtils.isEmpty(entity.getReqYmdhms())) {
				String reqYmdhms = entity.getReqYmdhms();
				String yyyy = reqYmdhms.substring(0, 4);
				String mm = reqYmdhms.substring(4, 6);
				String dd = reqYmdhms.substring(6, 8);
				dto.setReqYmdhms(yyyy + "-" + mm + "-" + dd);
			}

			// 申請者従業員番号
			dto.setReqJgiNo(entity.getReqJgiNo());
			// 申請者所属リージョン
			dto.setBrCode(entity.getBrCode());
			// 申請者所属エリア
			dto.setReqDistCode(entity.getReqDistCode());
			// 申請ステータス(コード)
			dto.setReqStsCd(entity.getReqStsCd());
			// 更新日
			dto.setUpdShaYmd(entity.getUpdShaYmd());
			// 氏名（漢字）
			dto.setDocKanj(entity.getDocKanj());
			// 医師固定コード
			dto.setDocNo(entity.getDocNo());
			// ULT医師コード
			dto.setUrlDocNo(entity.getUrlDocNo());
			// 施設略式漢字名
			dto.setInsAbbrName(entity.getInsAbbrName());
			// 所属部科漢字名
			dto.setDeptKj(entity.getDeptKj());

			// 役職コード(異動先)
			dto.setTitleCodeAf(entity.getTitleCodeAf());

			// 勤務形態(異動先)
			dto.setJobFormAf(entity.getJobFormAf());
			// 薬審メンバー区分(異動先)
			dto.setDccTypeAf(entity.getDccTypeAf());
			// 大学職位コード(異動先)
			dto.setUnivPosCodeAf(entity.getUnivPosCodeAf());
			// 適用開始日
			if (!StringUtils.isEmpty(entity.getTekiyoYmd())) {
				String tekiyoYmd = entity.getTekiyoYmd();
				String Tyyyy = tekiyoYmd.substring(0, 4);
				String Tmm = tekiyoYmd.substring(4, 6);
				String Tdd = tekiyoYmd.substring(6, 8);
				dto.setFormTekiyoYmd(Tyyyy + "-" + Tmm + "-" + Tdd);
			}

			// 施設固定コード(異動先)
			dto.setInsNoSk(entity.getInsNoSk());
			// 施設固定コード（所属部課）
			dto.setParamInsNo(entity.getInsNoSk());
			// ULT施設コード
			dto.setUltInsNo(entity.getUltInsNo());
			// 所属部科コード(異動先)
			dto.setDeptCodeAf(entity.getDeptCodeAf());
			// 所属部科カナ名
			dto.setDeptKn(entity.getDeptKn());
			// 申請コメント
			dto.setReqComment(entity.getReqComment());
			// 却下コメント
			dto.setAprComment(entity.getAprComment());
			// 施設分類
			dto.setInsClass(entity.getInsClass());
			// 対象区分
			dto.setHoInsType(entity.getHoInsType());

		}
		// プルダウン生成へ
		pullDown(dto);

		// 編集可能判定
        if("".equals(dto.getReqStsCd()) || dto.getReqStsCd() == null) {
        	// 完全新規(申請管理．申請ステータスが取得できない)の場合は活性
        	dto.setEditApprFlg("1");
        } else if(!RdmConstantsData.RDM_JKN_ADMIN.equals(loginInfo.getJokenSetCd()) && !"01".equals(dto.getReqStsCd())) {
        	// MR権限の場合、取得した申請管理．申請ステータスが'01'(保存済み)以外の場合は、入力項目はすべて変更不可（非活性）とする
        	dto.setEditApprFlg("0");
        } else if(RdmConstantsData.RDM_JKN_ADMIN.equals(loginInfo.getJokenSetCd()) && !"01".equals(dto.getReqStsCd()) && !"11".equals(dto.getReqStsCd())
        			&& !"03".equals(dto.getReqStsCd()) && !"13".equals(dto.getReqStsCd())) {
        	// 管理者権限の場合、取得した申請管理．申請ステータスが'01'(保存済み)、'03'(承認待ち)、'13'(ULT承認待ち)以外の場合は、入力項目はすべて変更不可（非活性）とする
        	dto.setEditApprFlg("0");
        } else {
        	dto.setEditApprFlg("1");
        }

		// END UOC
		return outdto;
	}

	/**
	 * イベント処理
	 *
	 * @param dto NC103DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO initDoc(ND103DTO dto) {
		BaseDTO outdto = dto;

		// ページ数(現在:１ページ目から)
		dto.setPageCntCur(1);

		SelectHcpKmuReqNewEntity paramEntity = new SelectHcpKmuReqNewEntity();

		LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();
		// 申請IDをセット
		paramEntity.setParamReqId(dto.getParamReqId());
		if (StringUtils.isEmpty(dto.getParamReqId())) {
			dto.setParamReqId("-");
			dto.setReqSts("-");
			dto.setReqYmdhms("-");
			dto.setReqShz(loginInfo.getBumonRyakuName());
		}

		// 医師固定Cをセット
		paramEntity.setParamDocNo(dto.getParamDocNo());
		// 画面初期表示時の帳票一覧を取得する
		List<SelectHcpKmuReqNewEntity> SelectHcpKmuReqNewList = dao.select(paramEntity);

		for (SelectHcpKmuReqNewEntity entity : SelectHcpKmuReqNewList) {

			dto.setDocKanj(entity.getDocKanj());
			dto.setDocNo(entity.getDocNo());
			dto.setUltInsNo(entity.getUltInsNo());
		}

		// 適用日
		// 翌営業日をRDM_COMMON.GET_NEXT_BIZDAYから取得する
		// 現在日付を取得
		Date systemDate = DateUtils.getNowDate();
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMdd");
		String sysDate = fmtDate.format(systemDate);

		RdmCommonEntity rdmCommonEntity = new RdmCommonEntity("getNextBizday");
		rdmCommonEntity.setInVBatDate(sysDate);
		List<RdmCommonEntity> rdmCommonEntityList = dao.select(rdmCommonEntity);

		if (rdmCommonEntityList.size() > 0) {
			// "yyyyMMdd"から"yyyy-MM-dd"に変換
			String tekiyoYmd = rdmCommonEntityList.get(0).getNextBizday();
			if (tekiyoYmd != null && tekiyoYmd.length() == 8) {
				StringBuilder sbUrlYmd = new StringBuilder();
				sbUrlYmd.append(tekiyoYmd.substring(0, 4));
				sbUrlYmd.append("-");
				sbUrlYmd.append(tekiyoYmd.substring(4, 6));
				sbUrlYmd.append("-");
				sbUrlYmd.append(tekiyoYmd.substring(6, 8));
				tekiyoYmd = sbUrlYmd.toString();
			}

			dto.setFormTekiyoYmd(tekiyoYmd);
		}

		// プルダウン生成へ
		pullDown(dto);

		// 編集可能判定
        if("".equals(dto.getReqStsCd()) || dto.getReqStsCd() == null) {
        	// 完全新規(申請管理．申請ステータスが取得できない)の場合は活性
        	dto.setEditApprFlg("1");
        } else if(!RdmConstantsData.RDM_JKN_ADMIN.equals(loginInfo.getJokenSetCd()) && !"01".equals(dto.getReqStsCd())) {
        	// MR権限の場合、取得した申請管理．申請ステータスが'01'(保存済み)以外の場合は、入力項目はすべて変更不可（非活性）とする
        	dto.setEditApprFlg("0");
        } else if(RdmConstantsData.RDM_JKN_ADMIN.equals(loginInfo.getJokenSetCd()) && !"01".equals(dto.getReqStsCd()) && !"11".equals(dto.getReqStsCd())
        			&& !"03".equals(dto.getReqStsCd()) && !"13".equals(dto.getReqStsCd())) {
        	// 管理者権限の場合、取得した申請管理．申請ステータスが'01'(保存済み)、'03'(承認待ち)、'13'(ULT承認待ち)以外の場合は、入力項目はすべて変更不可（非活性）とする
        	dto.setEditApprFlg("0");
        } else {
        	dto.setEditApprFlg("1");
        }

		// END UOC
		return outdto;
	}

	/**
	 * 保存処理
	 *
	 * @param dto NC103DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO save(ND103DTO dto) {
		BaseDTO outdto = dto;

		// START UOC
		LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

		String reqId = dto.getParamReqId();

		// 現在日付を取得
		Date systemDate = DateUtils.getNowDate();
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat fmtDateTime = new SimpleDateFormat("yyyyMMddHHmmss");
        String sysDateTime = fmtDateTime.format(systemDate);

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
			tRdmReqKnrInsData.setReqId(dto.getParamReqId());
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
			tRdmReqKnrInsData.setDocNo(dto.getDocNo());
			tRdmReqKnrInsData.setInsNo(dto.getInsNoSk());
			tRdmReqKnrInsData.setReqYmdhms(sysDateTime);//申請日時
			tRdmReqKnrInsData.setInsShaYmd(systemDate);
			// tRdmReqKnrInsData.setInsShaId(String.valueOf(dto.getLoginJgiNo()));
			tRdmReqKnrInsData.setInsShaId(Integer.toString(loginInfo.getJgiNo()));// 作成者
			tRdmReqKnrInsData.setUpdShaYmd(systemDate);
			// tRdmReqKnrInsData.setUpdShaId(String.valueOf(dto.getLoginJgiNo()));
			tRdmReqKnrInsData.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));// 更新者
			// 申請管理 insert処理
			dao.insertByValue(tRdmReqKnrInsData);
		} else {
			// 更新
			TRdmReqKnrEntity tRdmReqKnrUpdData = new TRdmReqKnrEntity("updateND103Data");
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
			tRdmReqKnrUpdData.setReqYmdhms(sysDateTime);//申請日時
			tRdmReqKnrUpdData.setUpdShaYmd(systemDate);
			tRdmReqKnrUpdData.setUpdShaId(String.valueOf(dto.getLoginJgiNo()));

			dao.update(tRdmReqKnrUpdData);
		}

		// 勤務先申請管理 データ格納
		if (tRdmReqKnrData == null) {// 新規

			TRdmHcpKmuReqEntity tRdmHcpKmuReqInsData = new TRdmHcpKmuReqEntity();

			tRdmHcpKmuReqInsData.setReqId(dto.getParamReqId());
			tRdmHcpKmuReqInsData.setDocNo(dto.getDocNo());
			tRdmHcpKmuReqInsData.setInsNoSk(StringUtils.nvl(dto.getInsNoSk(), "Z"));
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

		} else {// 更新
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
			//tRdmHcpKmuReqUpdData.setUltInsNo(dto.getUltInsNo());
			tRdmHcpKmuReqUpdData.setUpdShaYmd(systemDate);
			tRdmHcpKmuReqUpdData.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));

			dao.update(tRdmHcpKmuReqUpdData);
		}

		// END UOC
		return outdto;
	}

	/**
	 *
	 * @param indto
	 * @return
	 */
	@Transactional
	public BaseDTO cancel(ND103DTO indto) {
		BaseDTO outdto = indto;

		// START UOC
		// 申請管理を物理削除
		TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity();
		tRdmReqKnrEntity.setReqId(indto.getParamReqId());
		dao.deleteByPK(tRdmReqKnrEntity);

		// END UOC
		return outdto;
	}

	/**
	 * 更新処理
	 *
	 * @param dto NC204DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO pullDown(ND103DTO dto) {
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

}
