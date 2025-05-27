/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseEntity;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.HcoUpdHstDataList;
import jp.co.takeda.rdm.dto.MainInsDataList;
import jp.co.takeda.rdm.dto.NF501DTO;
import jp.co.takeda.rdm.entity.join.MRdmComCalUsrEntity;
import jp.co.takeda.rdm.entity.MRdmHcoKeieitaiEntiry;
import jp.co.takeda.rdm.entity.SRdmJkrSosAddrEntiry;
import jp.co.takeda.rdm.entity.join.MRdmCodeMstEntity;
import jp.co.takeda.rdm.entity.join.SelectHcoUpdHstListEntity;
import jp.co.takeda.rdm.entity.join.SelectHenkanListEntity;
import jp.co.takeda.rdm.entity.join.SelectMainInsListEntity;
import jp.co.takeda.rdm.entity.join.SelectParamNF501Entity;

/**
 * Serviceクラス（NF501)
 *
 * @generated
 */
@Named
public class NF501Service extends BaseService {

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
	public BaseDTO init(NF501DTO dto) {
		BaseDTO outdto = dto;
		// START UOC

		// ページ数(現在:１ページ目から)
		dto.setPageCntCur(1);

		// プルダウン・日付データ一覧取得
		outdto = pharmTypeList(dto);

		// 住所検索
		outdto = searchCtiyName(dto);

		// END UOC
		return outdto;
	}

	/**
	 * イベント処理
	 *
	 * @param dto NF501DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO searchHcoUpd(NF501DTO dto) {
		BaseDTO outdto = dto;
		// START UOC

		// 施設一覧検索件数取得の検索条件の設定
		SelectHcoUpdHstListEntity paramEntity = new SelectHcoUpdHstListEntity();

//		// 条件セット
//		paramEntity.setJokenSetCd(dto.getJokenSetCd());

		// 検索条件_従業員番号(管理者)
		if (StringUtils.isEmpty(dto.getKensakuJgiNo())) {
			dto.setKensakuJgiNo(0);
		}
		paramEntity.setKensakuJgiNo(dto.getKensakuJgiNo());

		// 検索条件_医薬支店C_申請者所属リージョン(管理者)
		if (StringUtils.isEmpty(dto.getKensakuShinseiBrCode())) {
			dto.setKensakuShinseiBrCode(null);
		}
		paramEntity.setKensakuShinseiBrCode(dto.getKensakuShinseiBrCode());

		// 検索条件_医薬営業所C_申請者所属エリア(管理者)
		if (StringUtils.isEmpty(dto.getKensakuShinseiDistCode())) {
			dto.setKensakuShinseiDistCode(null);
		}
		paramEntity.setKensakuShinseiDistCode(dto.getKensakuShinseiDistCode());

		// 検索条件_医薬支店C_担当者所属リージョン(管理者)
		if (StringUtils.isEmpty(dto.getKensakuSTantouBrCode())) {
			dto.setKensakuSTantouBrCode(null);
		}
		paramEntity.setKensakuSTantouBrCode(dto.getKensakuSTantouBrCode());

		// 検索条件_医薬営業所C_担当者所属エリア(管理者)
		if (StringUtils.isEmpty(dto.getKensakuTantouDistCode())) {
			dto.setKensakuTantouDistCode(null);
		}
		paramEntity.setKensakuTantouDistCode(dto.getKensakuTantouDistCode());

		// 検索条件_申請者(管理者)
		if (StringUtils.isEmpty(dto.getKensakuReqJgiName())) {
			dto.setKensakuReqJgiName(null);
		}
		paramEntity.setKensakuReqJgiName(dto.getKensakuReqJgiName());

//		// 従業員番号(MR)
//		if (StringUtils.isEmpty(dto.getMrJgiNo())) {
//			dto.setMrJgiNo(0);
//		}
//		paramEntity.setMrJgiNo(dto.getMrJgiNo());
//
//		// 医薬支店C_申請者所属リージョン(MR)
//		if (StringUtils.isEmpty(dto.getMrBrCode())) {
//			dto.setMrBrCode(null);
//		}
//		paramEntity.setMrBrCode(dto.getMrBrCode());
//
//		// 医薬営業所C_申請者所属エリア(MR)
//		if (StringUtils.isEmpty(dto.getMrDistCode())) {
//			dto.setMrDistCode(null);
//		}
//		paramEntity.setMrDistCode(dto.getMrDistCode());
//
//		// 領域コード(MR)
//		if (StringUtils.isEmpty(dto.getMrTrtCd())) {
//			dto.setMrTrtCd(null);
//		}
//		paramEntity.setMrTrtCd(dto.getMrTrtCd());

		// 検索条件_申請者
		if (StringUtils.isEmpty(dto.getKensakuReqJgiName())) {
			dto.setKensakuReqJgiName(null);
		} else {
			// 漢字変換
			SelectHenkanListEntity kanziHenkan = new SelectHenkanListEntity("漢字変換");
			kanziHenkan.setSearchHenkan(dto.getKensakuReqJgiName());
			// 漢字変換結果を格納
			List<SelectHenkanListEntity> selectKnazi = dao.select(kanziHenkan);
			for (SelectHenkanListEntity kanzi : selectKnazi) {
				paramEntity.setKensakuReqJgiName(kanzi.getSearchHenkan());
			}
		}

		// 検索条件_施設名（全角）
		if (StringUtils.isEmpty(dto.getKensakuInsKanj())) {
			dto.setKensakuInsKanj(null);
		} else {
			// 漢字変換
			SelectHenkanListEntity kanziHenkan = new SelectHenkanListEntity("漢字変換");
			kanziHenkan.setSearchHenkan(dto.getKensakuInsKanj());
			// 漢字変換結果を格納
			List<SelectHenkanListEntity> selectKnazi = dao.select(kanziHenkan);
			for (SelectHenkanListEntity kanzi : selectKnazi) {
				paramEntity.setKensakuInsKanj(kanzi.getSearchHenkan().replaceAll("　", ""));
			}
		}

		// 検索条件_施設名カナ(半角カナ)
		if (StringUtils.isEmpty(dto.getKensakuInsKana())) {
			dto.setKensakuInsKana(null);
		} else {
			// 半角変換
			SelectHenkanListEntity hankakuHenkan = new SelectHenkanListEntity("半角変換");
			hankakuHenkan.setSearchHenkan(dto.getKensakuInsKana());
			// 半角変換結果を格納
			List<SelectHenkanListEntity> selectHankaku = dao.select(hankakuHenkan);
			String henkan = "";
			for (SelectHenkanListEntity hankaku : selectHankaku) {
				henkan = hankaku.getSearchHenkan();
			}
			// ハイフン変換
			SelectHenkanListEntity haihunHenkan = new SelectHenkanListEntity("ハイフン変換");
			haihunHenkan.setSearchHenkan(henkan);
			// ハイフン変換結果を格納
			List<SelectHenkanListEntity> selectHaihun = dao.select(haihunHenkan);
			for (SelectHenkanListEntity haihun : selectHaihun) {
				// 変換した値を格納
				paramEntity.setKensakuInsKana(haihun.getSearchHenkan());
			}
		}
		// 検索条件_施設固定コード
		if (StringUtils.isEmpty(dto.getKensakuInsNo())) {
			dto.setKensakuInsNo(null);
		}
		paramEntity.setKensakuInsNo(dto.getKensakuInsNo());

		// 検索条件_ULTコード
		if (StringUtils.isEmpty(dto.getKensakuUltInsNo())) {
			dto.setKensakuUltInsNo(null);
		}
		paramEntity.setKensakuUltInsNo(dto.getKensakuUltInsNo());

		// 検索条件_経営主体
		if (StringUtils.isEmpty(dto.getKensakuManageCd())) {
			dto.setKensakuManageCd(null);
		}
		paramEntity.setKensakuManageCd(dto.getKensakuManageCd());

		// 検索条件_対象区分
		if (StringUtils.isEmpty(dto.getKensakuHoInsType())) {
			dto.setKensakuHoInsType(null);
		}
		paramEntity.setKensakuHoInsType(dto.getKensakuHoInsType());

		// 検索条件_施設種別
		if (StringUtils.isEmpty(dto.getKensakuInsSbt())) {
			dto.setKensakuInsSbt(null);
		}
		paramEntity.setKensakuInsSbt(dto.getKensakuInsSbt());

		// 検索条件_施設区分
		if (StringUtils.isEmpty(dto.getKensakuPharmType())) {
			dto.setKensakuPharmType(null);
		}
		paramEntity.setKensakuPharmType(dto.getKensakuPharmType());

		// 検索条件_電話番号(半角)
		if (StringUtils.isEmpty(dto.getKensakuInsPhone())) {
			dto.setKensakuInsPhone(null);
		} else {
			// ハイフン除去
			SelectHenkanListEntity haihunHenkan = new SelectHenkanListEntity("ハイフン除去");
			haihunHenkan.setSearchHenkan(dto.getKensakuInsPhone());
			// ハイフン除去
			List<SelectHenkanListEntity> selectHaihun = dao.select(haihunHenkan);
			for (SelectHenkanListEntity haihun : selectHaihun) {
				paramEntity.setKensakuInsPhone(haihun.getSearchHenkan());
				dto.setKensakuInsPhone(haihun.getSearchHenkan());
			}
		}

		// 検索条件_郵便番号(半角)
		if (StringUtils.isEmpty(dto.getKensakuInsPcode())) {
			dto.setKensakuInsPcode(null);
		} else {
			// ハイフン除去
			SelectHenkanListEntity haihunHenkan = new SelectHenkanListEntity("ハイフン除去");
			haihunHenkan.setSearchHenkan(dto.getKensakuInsPcode());
			// ハイフン除去
			List<SelectHenkanListEntity> selectHaihun = dao.select(haihunHenkan);
			for (SelectHenkanListEntity haihun : selectHaihun) {
				paramEntity.setKensakuInsPcode(haihun.getSearchHenkan());
				dto.setKensakuInsPcode(haihun.getSearchHenkan());
			}
		}

		// 検索条件_都道府県
		if (StringUtils.isEmpty(dto.getKensakuAddrCodePref())) {
			dto.setKensakuAddrCodePref(null);
		}
		paramEntity.setKensakuAddrCodePref(dto.getKensakuAddrCodePref());

		// 検索条件_JIS市区町村
		if (StringUtils.isEmpty(dto.getKensakuAddrCodeCity())) {
			dto.setKensakuAddrCodeCity(null);
		} else {
			dto.setKensakuAddrCodeCity(dto.getKensakuAddrCodeCity().substring(2, 4));
		}
		paramEntity.setKensakuAddrCodeCity(dto.getKensakuAddrCodeCity());

		// 検索条件_住所(全角)
		if (StringUtils.isEmpty(dto.getKensakuInsAddr())) {
			dto.setKensakuInsAddr(null);
		} else {
			// 全角変換
			SelectHenkanListEntity zenkakuHenkan = new SelectHenkanListEntity("全角変換");
			zenkakuHenkan.setSearchHenkan(dto.getKensakuInsAddr());
			// 全角変換
			List<SelectHenkanListEntity> selectZenkaku = dao.select(zenkakuHenkan);
			for (SelectHenkanListEntity zenkaku : selectZenkaku) {
				paramEntity.setKensakuInsAddr(zenkaku.getSearchHenkan());
				dto.setKensakuInsAddr(zenkaku.getSearchHenkan());
			}
		}

		// SimpleDateFormatで日付フォーマット設定
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		// 検索条件_更新日(FROM)
		if (dto.getKensakuUpdMstFrom().isEmpty()) {
			dto.setKensakuUpdMstFrom(null);
		}
		try {
			dto.setUpdMstFrom(dto.getKensakuUpdMstFrom());
			paramEntity.setKensakuUpdMstFrom(sdf.parse(dto.getKensakuUpdMstFrom()));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// 検索条件_更新日(TO)
		if (dto.getKensakuUpdMstTo().isEmpty()) {
			dto.setKensakuUpdMstTo(null);
		}
		try {
			dto.setUpdMstTo(dto.getKensakuUpdMstTo());
			paramEntity.setKensakuUpdMstTo(sdf.parse(dto.getKensakuUpdMstTo()));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// ソートID
		paramEntity.setSortId(dto.getSortId());

		// 検索条件をもとに検索結果を格納
		List<BaseEntity> selectParam = dao.select(paramEntity);

		// 件数定義取得
		SelectParamNF501Entity selectParamNF501Entity = new SelectParamNF501Entity();
		List<SelectParamNF501Entity> selectParamNF501List;
		selectParamNF501List = dao.select(selectParamNF501Entity);

		// 検索数格納
		dto.initPageInfo(dto.getPageCntCur(), selectParam.size(), selectParamNF501List.get(1).getValue());
		paramEntity.setInOffset(dto.getLineCntStart() - 1);
		paramEntity.setInLimit(selectParamNF501List.get(1).getValue());

//		SelectPageHcoUpdHstEntity selectPageHcoUpdHstEntity = new SelectPageHcoUpdHstEntity();
//	    List<SelectPageHcoUpdHstEntity> selectPageHcoUpdHstList;
//	    selectPageHcoUpdHstList = dao.select(selectPageHcoUpdHstEntity);

		// 検索結果が0件の場合
		if (CollectionUtils.isEmpty(selectParam)) {
			return outdto;
		}

		// 検索結果が上限以上の場合
		if (selectParam.size() > selectParamNF501List.get(0).getValue()) {

			dto.setKensakuBool(false);
			return outdto;
		}

		// 検索結果画面受け渡し用リスト
		List<HcoUpdHstDataList> hcoUpdHstDataList = new ArrayList<HcoUpdHstDataList>();

		// 検索結果はある場合

		// 画面初期表示時の帳票一覧を取得する
		List<SelectHcoUpdHstListEntity> SelectHcoUpdHstList = dao.select(paramEntity);

		for (SelectHcoUpdHstListEntity entity : SelectHcoUpdHstList) {
			HcoUpdHstDataList dataRecord = new HcoUpdHstDataList();

//              //検索結果_ （来期）項目変更フラグ
			// 下記項目のいずれかが'1'なら
			if (Objects.equals(entity.getHoInsTypeUpdFlg(), "1") || Objects.equals(entity.getPharmTypeUpdFlg(), "1")
					|| Objects.equals(entity.getInsRankUpdFlg(), "1") || Objects.equals(entity.getManageCdUpdFlg(), "1")
					|| Objects.equals(entity.getRegVisTypeUpdFlg(), "1")
					|| Objects.equals(entity.getImpHosTypeUpdFlg(), "1")
					|| Objects.equals(entity.getVacInsTypeUpdFlg(), "1")
					|| Objects.equals(entity.getVacVisitTypeUpdFlg(), "1")
					|| Objects.equals(entity.getBedcntBaseUpdFlg(), "1")
					|| Objects.equals(entity.getBedsTotUpdFlg(), "1")
					|| Objects.equals(entity.getMedBedsTotUpdFlg(), "1")
					|| Objects.equals(entity.getBedcnt01UpdFlg(), "1")
					|| Objects.equals(entity.getBedcnt02UpdFlg(), "1")
					|| Objects.equals(entity.getBedcnt03UpdFlg(), "1")
					|| Objects.equals(entity.getBedcnt04UpdFlg(), "1")
					|| Objects.equals(entity.getBedcnt05UpdFlg(), "1")
					|| Objects.equals(entity.getBedcnt06UpdFlg(), "1")
					|| Objects.equals(entity.getBedcnt07UpdFlg(), "1")
					|| Objects.equals(entity.getDelFlgUpdFlg(), "N")) {
				// （来期）項目変更フラグ
				dataRecord.setHcoNxt("1");
			} else {
				// （来期）項目変更フラグ
				dataRecord.setHcoNxt("");
			}
//                dataRecord.setHcoNxt(entity.getHcoNxt());
//                 //検索結果_その他項目の変更フラグ
//                dataRecord.setOtherChanges(entity.getOtherChanges());

			// 更新フラグがない場合 画面表示しない
			if (!Objects.equals(entity.getHoInsTypeUpdFlg(), "1") && !Objects.equals(entity.getInsAbbrNameUpdFlg(), "1")
					&& !Objects.equals(entity.getInsFormalNameUpdFlg(), "1")
					&& !Objects.equals(entity.getInsPcodeUpdFlg(), "1")
					&& !Objects.equals(entity.getInsAddrUpdFlg(), "1")
					&& !Objects.equals(entity.getInsPhone1UpdFlg(), "1")
					&& !Objects.equals(entity.getInsFax1UpdFlg(), "1")
					&& !Objects.equals(entity.getUltInsNoUpdFlg(), "1")
					&& !Objects.equals(entity.getInsContNameUpdFlg(), "1")
					&& !Objects.equals(entity.getInsRankUpdFlg(), "1")
					&& !Objects.equals(entity.getPharmTypeUpdFlg(), "1")
					&& !Objects.equals(entity.getManageCdUpdFlg(), "1")
					&& !Objects.equals(entity.getAddrCodePrefUpdFlg(), "1")
					&& !Objects.equals(entity.getAddrCodeCityUpdFlg(), "1")
					&& !Objects.equals(entity.getTkCityCdUpdFlg(), "1")
					&& !Objects.equals(entity.getInsPhone2UpdFlg(), "1")
					&& !Objects.equals(entity.getInsFax2UpdFlg(), "1") && !Objects.equals(entity.getInsUrlUpdFlg(), "1")
					&& !Objects.equals(entity.getInsUrlYmdUpdFlg(), "1")
					&& !Objects.equals(entity.getVacInsTypeUpdFlg(), "1")
					&& !Objects.equals(entity.getVacVisitTypeUpdFlg(), "1")
					&& !Objects.equals(entity.getBedcntBaseUpdFlg(), "1")
					&& !Objects.equals(entity.getBedsTotUpdFlg(), "1")
					&& !Objects.equals(entity.getMedBedsTotUpdFlg(), "1")
					&& !Objects.equals(entity.getBedcnt01UpdFlg(), "1")
					&& !Objects.equals(entity.getBedcnt02UpdFlg(), "1")
					&& !Objects.equals(entity.getBedcnt03UpdFlg(), "1")
					&& !Objects.equals(entity.getBedcnt04UpdFlg(), "1")
					&& !Objects.equals(entity.getBedcnt05UpdFlg(), "1")
					&& !Objects.equals(entity.getBedcnt06UpdFlg(), "1")
					&& !Objects.equals(entity.getBedcnt07UpdFlg(), "1")
					&& !Objects.equals(entity.getInsOpenYmdUpdFlg(), "1")
					&& !Objects.equals(entity.getClitemListUpdFlg(), "1")
					&& !Objects.equals(entity.getBedcnt01UpdFlg(), "1") && Objects.equals(dataRecord.getHcoNxt(), "")
					&& !Objects.equals(entity.getDelFlgUpdFlg(), "N")) {
				continue;
			}

			// 検索結果_更新日
			if (entity.getUpdShaYmd() != null) {
				// YYYY/MM/DD型に変換
				String str = new SimpleDateFormat("yyyy/MM/dd").format(entity.getUpdShaYmd());
				dataRecord.setUpdShaYmd(str);
			}

			// 検索結果_申請ID
			dataRecord.setReqId(entity.getReqId());
			// 検索結果_施設固定コード
			dataRecord.setInsNo(entity.getInsNo());
			// 検索結果_対象区分
			LinkedHashMap<String, String> hoInsTypeMap = dto.getHoInsTypeMap();
			String hoInsType = hoInsTypeMap.get(entity.getHoInsType());
			dataRecord.setHoInsType(hoInsType);
			// 検索結果_施設略式漢字名
			dataRecord.setInsAbbrName(entity.getInsAbbrName());
			// 検索結果_施設正式漢字名
			dataRecord.setInsFormalName(entity.getInsFormalName());
			// 検索結果_郵便番号
			dataRecord.setInsPcode(entity.getInsPcode().substring(0, 3) + '-' + entity.getInsPcode().substring(3, 7));
			// 検索結果_施設住所（漢字）
			dataRecord.setInsAddr(entity.getInsAddr());
			// 検索結果_電話番号1
			dataRecord.setInsPhone1(entity.getInsPhone1());
			// 検索結果_FAX番号1
			dataRecord.setInsFax1(entity.getInsFax1());
			// 申請者氏名
			dataRecord.setReqJgiName(entity.getReqJgiName());
			// 承認者氏名
			dataRecord.setAprShaId(entity.getAprShaId());
			// ULT施設コード
			dataRecord.setUltInsNo(entity.getUltInsNo());
			// ULT施設名称
			dataRecord.setShisetsuNmRyaku(entity.getShisetsuNmRyaku());
			// 施設契約漢字名
			dataRecord.setInsContName(entity.getInsContName());
			// 施設区分
			LinkedHashMap<String, String> pharmTypeMap = dto.getPharmTypeMap();
			String pharmType = pharmTypeMap.get(entity.getPharmType());
			dataRecord.setPharmType(pharmType);
			// 階級区分
			LinkedHashMap<String, String> insRankMap = dto.getInsRankMap();
			String insRank = insRankMap.get(entity.getInsRank());
			dataRecord.setInsRank(insRank);
			// 経営主体
			LinkedHashMap<String, String> manageCdMap = dto.getHcoKeieitaiMap();
			String manageCd = manageCdMap.get(entity.getManageCd());
			dataRecord.setManageCd(manageCd);
			// JIS府県名
			dataRecord.setAddrCodePref(entity.getAddrCodePref());
			dataRecord.setAddrNamePref(entity.getAddrNamePref());
			// JIS市区町村名
			dataRecord.setAddrCodeCity(entity.getAddrCodeCity());
			dataRecord.setAddrNameCity(entity.getAddrNameCity());
			// 武田市区郡名
			dataRecord.setTkCityCd(entity.getTkCityCd());
			dataRecord.setTkCityName(entity.getTkCityName());
			// 電話番号2
			dataRecord.setInsPhone2(entity.getInsPhone2());
			// FAX番号2
			dataRecord.setInsFax2(entity.getInsFax2());
			// ホームページアドレス
			dataRecord.setInsUrl(entity.getInsUrl());
			// ホームページアドレス最終更新日
			dataRecord.setInsUrlYmd(entity.getInsUrlYmd());
			// ワクチン対象区分(当期)
			dataRecord.setVacInsType(entity.getVacInsType());
			// ワクチン定訪先区分(当期)
			dataRecord.setVacVisitType(entity.getVacVisitType());
			// 病床(基準)
			dataRecord.setBedcntBase(entity.getBedcntBase());
			// ベッド数計
			dataRecord.setBedsTot(entity.getBedsTot());
			// 医療ベッド数計
			dataRecord.setMedBedsTot(entity.getMedBedsTot());
			// 病床数(一般)
			dataRecord.setBedcnt01(entity.getBedcnt01());
			// 病床数(医療療養)
			dataRecord.setBedcnt02(entity.getBedcnt02());
			// 病床数(精神)
			dataRecord.setBedcnt03(entity.getBedcnt03());
			// 病床数(結核)
			dataRecord.setBedcnt04(entity.getBedcnt04());
			// 病床数(感染症)
			dataRecord.setBedcnt05(entity.getBedcnt05());
			// 病床数(介護療養)
			dataRecord.setBedcnt06(entity.getBedcnt06());
			// 病床数(療養)
			dataRecord.setBedcnt07(entity.getBedcnt07());
			// 開業年
			dataRecord.setInsOpenYear(entity.getInsOpenYear());
			// 開業月
			dataRecord.setInsOpenMonth(entity.getInsOpenMonth());
			// 開業日
			dataRecord.setInsOpenDay(entity.getInsOpenDay());
			// 診療科目
			dataRecord.setClitemList(entity.getClitemList());
			// 申請者所属リージョン
			dataRecord.setReqBrCod(entity.getReqBrCod());
			// 申請者所属エリア
			dataRecord.setReqDistCode(entity.getReqDistCode());
			// 申請者所属
			dataRecord.setReqShz(entity.getReqShz());
			// 承認者所属
			dataRecord.setAprShz(entity.getAprShz());
			/*
			 * 更新フラグ
			 */
			// 対象区分更新フラグ
			dataRecord.setHoInsTypeUpdFlg(entity.getHoInsTypeUpdFlg());
			// 施設略式漢字名更新フラグ
			dataRecord.setInsAbbrNameUpdFlg(entity.getInsAbbrNameUpdFlg());
			// 施設正式漢字名更新フラグ
			dataRecord.setInsFormalNameUpdFlg(entity.getInsFormalNameUpdFlg());
			// 郵便番号更新フラグ
			dataRecord.setInsPcodeUpdFlg(entity.getInsPcodeUpdFlg());
			// 施設住所（漢字）更新フラグ
			dataRecord.setInsAddrUpdFlg(entity.getInsAddrUpdFlg());
			// 電話番号1更新フラグ
			dataRecord.setInsPhone1UpdFlg(entity.getInsPhone1UpdFlg());
			// FAX番号1更新フラグ
			dataRecord.setInsFax1UpdFlg(entity.getInsFax1UpdFlg());
			// ULT施設更新フラグ
			dataRecord.setUltInsNoUpdFlg(entity.getUltInsNoUpdFlg());
			// 施設契約漢字名更新フラグ
			dataRecord.setInsContNameUpdFlg(entity.getInsContNameUpdFlg());
			// 施設区分更新フラグ
			dataRecord.setPharmTypeUpdFlg(entity.getPharmTypeUpdFlg());
			// 階級区分更新フラグ
			dataRecord.setInsRankUpdFlg(entity.getInsRankUpdFlg());
			// 経営主体更新フラグ
			dataRecord.setManageCdUpdFlg(entity.getManageCdUpdFlg());
			// JIS府県名更新フラグ
			dataRecord.setAddrCodePrefUpdFlg(entity.getAddrCodePrefUpdFlg());
			// JIS市区町村名更新フラグ
			dataRecord.setAddrCodeCityUpdFlg(entity.getAddrCodeCityUpdFlg());
			// 武田市区郡名更新フラグ
			dataRecord.setTkCityCdUpdFlg(entity.getTkCityCdUpdFlg());
			// 電話番号2更新フラグ
			dataRecord.setInsPhone2UpdFlg(entity.getInsPhone2UpdFlg());
			// FAX番号2更新フラグ
			dataRecord.setInsFax2UpdFlg(entity.getInsFax2UpdFlg());
			// ホームページアドレス更新フラグ
			dataRecord.setInsUrlUpdFlg(entity.getInsUrlUpdFlg());
			// ホームページアドレス最終更新日更新フラグ
			dataRecord.setInsUrlYmdUpdFlg(entity.getInsUrlYmdUpdFlg());
			// ワクチン対象区分(当期)更新フラグ
			dataRecord.setVacInsTypeUpdFlg(entity.getVacInsTypeUpdFlg());
			// ワクチン定訪先区分(当期)更新フラグ
			dataRecord.setVacVisitTypeUpdFlg(entity.getVacVisitTypeUpdFlg());
			// 病床(基準)更新フラグ
			dataRecord.setBedcntBaseUpdFlg(entity.getBedcntBaseUpdFlg());
			// ベッド数計更新フラグ
			dataRecord.setBedsTotUpdFlg(entity.getBedsTotUpdFlg());
			// 医療ベッド数計更新フラグ
			dataRecord.setMedBedsTotUpdFlg(entity.getMedBedsTotUpdFlg());
			// 病床数(一般)更新フラグ
			dataRecord.setBedcnt01UpdFlg(entity.getBedcnt01UpdFlg());
			// 病床数(医療療養)更新フラグ
			dataRecord.setBedcnt02UpdFlg(entity.getBedcnt02UpdFlg());
			// 病床数(精神)更新フラグ
			dataRecord.setBedcnt03UpdFlg(entity.getBedcnt03UpdFlg());
			// 病床数(結核)更新フラグ
			dataRecord.setBedcnt04UpdFlg(entity.getBedcnt04UpdFlg());
			// 病床数(感染症)更新フラグ
			dataRecord.setBedcnt05UpdFlg(entity.getBedcnt05UpdFlg());
			// 病床数(介護療養)更新フラグ
			dataRecord.setBedcnt06UpdFlg(entity.getBedcnt06UpdFlg());
			// 病床数(療養)更新フラグ
			dataRecord.setBedcnt07UpdFlg(entity.getBedcnt07UpdFlg());
			// 開業年月日更新フラグ
			dataRecord.setInsOpenYmdUpdFlg(entity.getInsOpenYmdUpdFlg());
			// 診療科目更新フラグ
			dataRecord.setClitemListUpdFlg(entity.getClitemListUpdFlg());
			// 削除フラグ更新フラグ
			dataRecord.setDelFlgUpdFlg(entity.getDelFlgUpdFlg());

			// リストにデータ追加
			hcoUpdHstDataList.add(dataRecord);
		}

		// 検索された帳票一覧をDTOに設定する
		dto.setHcoUpdHstDataList(hcoUpdHstDataList);
		// END UOC
		return dto;
	}

	/**
	 * イベント処理
	 *
	 * @param indto ND001DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO page(NF501DTO dto) {
		BaseDTO outdto = dto;
		// START UOC

		// プルダウン・日付データ一覧取得
		outdto = pharmTypeList(dto);
		// 都道府県が選択した場合
		if (!StringUtils.isEmpty(dto.getKensakuAddrCodePref())) {
			// 住所検索
			outdto = searchCtiyName(dto);
//            return searchNext(outdto);
		}

		/*
		 * SelectListChangeが 1:施設一覧検索 2:領域担当者検索
		 */
		if (dto.getSelectListChange() == null) {
			dto.setSelectListChange("0");
		}
		if (dto.getSelectListChange().contains("0")) {
			// 施設一覧検索
			dto.setSelectListChange("0");
			outdto = searchHcoUpd(dto);
		} else {
			// 領域別担当者検索
			dto.setSelectListChange("1");
			outdto = searchMainIns(dto);
		}

		// プルダウン・日付データ一覧取得
		outdto = pharmTypeList(dto);
		// 都道府県取得
		if (dto.getKensakuAddrCodePref() != null) {
			String sosAddrCode = dto.getKensakuAddrCodePref().substring(0, 2);
			if (sosAddrCode.isEmpty()) {

			}
			dto.setKensakuAddrCodePref(sosAddrCode);
			// 住所検索
			outdto = searchCtiyName(dto);
		}

		// END UOC
		return outdto;
	}

	/**
	 * イベント処理
	 *
	 * @param dto NF501DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO pharmTypeList(NF501DTO dto) {
		BaseDTO outdto = dto;

		// 施設区分_生成用エンティティ
		MRdmCodeMstEntity paramPharmType = new MRdmCodeMstEntity();
		// 検索条件_施設区分
		paramPharmType.setCodeName("PHARM_TYPE");
		// 施設区分の帳票一覧を取得する
		List<MRdmCodeMstEntity> SelectPharmTypeList = dao.selectByValue(paramPharmType);
		// 施設区分データ_取り出す
		LinkedHashMap<String, String> mapPharmType = new LinkedHashMap<String, String>();
		mapPharmType.put("", "--なし--");
		for (MRdmCodeMstEntity outEntity : SelectPharmTypeList) {
			mapPharmType.put(outEntity.getValue1(), outEntity.getValue1Kanj());
		}
		// 施設区分を格納する
		dto.setPharmTypeMap(mapPharmType);

		// 検索条件_階級区分
		paramPharmType.setCodeName("INS_RANK");
		// 階級区分の帳票一覧を取得する
		List<MRdmCodeMstEntity> SelectInsRankList = dao.selectByValue(paramPharmType);
		// 階級区分データ_取り出す
		LinkedHashMap<String, String> insRankMap = new LinkedHashMap<String, String>();
		insRankMap.put("", "--なし--");
		for (MRdmCodeMstEntity outEntity : SelectInsRankList) {
			mapPharmType.put(outEntity.getValue1(), outEntity.getValue1Kanj());
		}
		// 階級区分を格納する
		dto.setInsRankMap(mapPharmType);

		// 検索結果切り替えリスト_作成
		LinkedHashMap<String, String> selectListChangeMap = new LinkedHashMap<String, String>();
		selectListChangeMap.put("0", "施設一覧");
		selectListChangeMap.put("1", "領域別親子一覧");
		// 検索結果切り替えリストを格納する
		dto.setSelectListChangeMap(selectListChangeMap);

		// 検索条件_施設種別
		paramPharmType.setCodeName("INS_TYPE");
		// 施設種別の帳票一覧を取得する
		List<MRdmCodeMstEntity> SelectInsSbtList = dao.selectByValue(paramPharmType);
		// 施設種別データ_取り出す
		LinkedHashMap<String, String> mapInsSbtList = new LinkedHashMap<String, String>();
		mapInsSbtList.put("", "--なし--");
		for (MRdmCodeMstEntity outEntity : SelectInsSbtList) {
			mapInsSbtList.put(outEntity.getValue1(), outEntity.getValue1Kanj());
		}
		// 施設種別を格納する
		dto.setInsSbtMap(mapInsSbtList);

		// 対象区分_施設種別
		paramPharmType.setCodeName("HO_INS_TYPE");
		// 対象区分の帳票一覧を取得する
		List<MRdmCodeMstEntity> SelectHoInsTypeList = dao.selectByValue(paramPharmType);
		// 対象区分データ_取り出す
		LinkedHashMap<String, String> mapHoInsType = new LinkedHashMap<String, String>();
		mapHoInsType.put("", "--なし--");
		for (MRdmCodeMstEntity outEntity : SelectHoInsTypeList) {
			mapHoInsType.put(outEntity.getValue1(), outEntity.getValue1Kanj());
		}
		// 対象区分を格納する
		dto.setHoInsTypeMap(mapHoInsType);

		// 経営主体_生成用エンティティ
		MRdmHcoKeieitaiEntiry paramHcoKeieitai = new MRdmHcoKeieitaiEntiry();
		// 経営主体の帳票一覧を取得する
		List<MRdmHcoKeieitaiEntiry> SelectHcoKeieitai = dao.select(paramHcoKeieitai);

		LinkedHashMap<String, String> mapHcoKeieitai = new LinkedHashMap<String, String>();
		mapHcoKeieitai.put("", "--なし--");
		for (MRdmHcoKeieitaiEntiry outEntity : SelectHcoKeieitai) {
			mapHcoKeieitai.put(outEntity.getSetDtCd(), outEntity.getKeieitaiKj());
		}
		dto.setHcoKeieitaiMap(mapHcoKeieitai);

		// 本日日付_RDM用カレンダー(オンライン用)_生成用エンティティ
		MRdmComCalUsrEntity paramComCalUsrToday = new MRdmComCalUsrEntity();
		paramComCalUsrToday.setToday("1");
		// 本日日付_RDM用カレンダー(オンライン用)の帳票一覧を取得する
		MRdmComCalUsrEntity today = dao.selectByValue(paramComCalUsrToday).get(0);

		// SimpleDateFormatで日付フォーマット設定
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String todayYMD = today.getCalYear() + "-" + today.getCalMonth() + "-" + today.getCalDay();

		// 検索結果_本日日付
		dto.setUpdMstTo(todayYMD);
		dto.setClearUpdMstTo(todayYMD);

		String YMD = today.getCalYear() + today.getCalMonth() + today.getCalDay();

		Date date = null;
		try {
			date = sdf.parse(YMD);
		} catch (ParseException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		calendar.add(Calendar.MONTH, -3);
		date = calendar.getTime();
		String strDate = sdf.format(date);

		dto.setUpdMstFrom(strDate.substring(0, 4) + "-" + strDate.substring(4, 6) + "-" + strDate.substring(6, 8));
		dto.setClearUpdMstFrom(strDate.substring(0, 4) + "-" + strDate.substring(4, 6) + "-" + strDate.substring(6, 8));

//        }
		// END UOC
		return outdto;
	}

	/**
	 * イベント処理
	 *
	 * @param dto NF501DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO searchCtiyName(NF501DTO dto) {
		BaseDTO outdto = dto;

		// 都道府県_組織担当地区情報_生成用エンティティ
		SRdmJkrSosAddrEntiry paramJkrSosAddr = new SRdmJkrSosAddrEntiry();

		// 市区町村_組織担当地区情報_生成用エンティティ
		SRdmJkrSosAddrEntiry paramJkrCityName = new SRdmJkrSosAddrEntiry("");
//    	//ユーザーの場合
//    	if (Objects.equals(dto.getJokenSetCd(), "0")) {
//    		paramJkrCityName.setTrtCd("");
//    		paramJkrCityName.setJgiNo(dto.getKensakuJgiNo());
//    		paramJkrCityName.setBrCode(dto.getKensakuBrCode());
//    		paramJkrSosAddr.setTrtCd("");
//    		paramJkrSosAddr.setJgiNo(dto.getKensakuJgiNo());
//    		paramJkrSosAddr.setBrCode(dto.getKensakuBrCode());
//    	}
//    	//管理者の場合
//    	if (Objects.equals(dto.getJokenSetCd(), "1")) {
//    		paramJkrCityName.setTrtCd(null);
//    		paramJkrSosAddr.setTrtCd(null);
//    	}

		// 都道府県_都道府県_組織担当地区情報の帳票一覧を取得する
		List<SRdmJkrSosAddrEntiry> SelectJkrSosAddr = dao.select(paramJkrSosAddr);
		// 都道府県_組織担当地区情報データ_取り出す
		LinkedHashMap<String, String> mapJkrSosAddr = new LinkedHashMap<String, String>();
		mapJkrSosAddr.put("", "--なし--");
		for (SRdmJkrSosAddrEntiry outEntity : SelectJkrSosAddr) {
			mapJkrSosAddr.put(outEntity.getAddrCodePref(), outEntity.getAddrNamePref());
		}
		dto.setJkrSosAddrMap(mapJkrSosAddr);

		// 市区町村_都道府県_組織担当地区情報の帳票一覧を取得する
		List<SRdmJkrSosAddrEntiry> SelectJkrCityName = dao.select(paramJkrCityName);
		// 市区町村_組織担当地区情報データ_取り出す
		LinkedHashMap<String, String> mapCityName = new LinkedHashMap<String, String>();
		mapCityName.put("", "--なし--");
		for (SRdmJkrSosAddrEntiry outEntity : SelectJkrCityName) {
			// JIS府県コードとJIS市区町村コードを結合
			String ketugouCd = outEntity.getAddrCodePref() + outEntity.getAddrCodeCity();
			mapCityName.put(ketugouCd, outEntity.getAddrNameCity());
		}

		dto.setJkrCityNameMap(mapCityName);

		return outdto;
	}

	/**
	 * イベント処理
	 *
	 * @param dto NF501DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO searchMainIns(NF501DTO dto) {
		BaseDTO outdto = dto;

		// START UOC

		// 領域別担当者の検索条件の設定
		SelectMainInsListEntity paramEntity = new SelectMainInsListEntity();

//		// 条件セット
//		paramEntity.setJokenSetCd(dto.getJokenSetCd());

		// 検索条件_従業員番号(管理者)
		if (StringUtils.isEmpty(dto.getKensakuJgiNo())) {
			dto.setKensakuJgiNo(0);
		}
		paramEntity.setKensakuJgiNo(dto.getKensakuJgiNo());

		// 検索条件_医薬支店C_申請者所属リージョン(管理者)
		if (StringUtils.isEmpty(dto.getKensakuShinseiBrCode())) {
			dto.setKensakuShinseiBrCode(null);
		}
		paramEntity.setKensakuShinseiBrCode(dto.getKensakuShinseiBrCode());

		// 検索条件_医薬営業所C_申請者所属エリア(管理者)
		if (StringUtils.isEmpty(dto.getKensakuShinseiDistCode())) {
			dto.setKensakuShinseiDistCode(null);
		}
		paramEntity.setKensakuShinseiDistCode(dto.getKensakuShinseiDistCode());

		// 検索条件_医薬支店C_担当者所属リージョン(管理者)
		if (StringUtils.isEmpty(dto.getKensakuSTantouBrCode())) {
			dto.setKensakuSTantouBrCode(null);
		}
		paramEntity.setKensakuSTantouBrCode(dto.getKensakuSTantouBrCode());

		// 検索条件_医薬営業所C_担当者所属エリア(管理者)
		if (StringUtils.isEmpty(dto.getKensakuTantouDistCode())) {
			dto.setKensakuTantouDistCode(null);
		}
		paramEntity.setKensakuTantouDistCode(dto.getKensakuTantouDistCode());

		// 検索条件_申請者(管理者)
		if (StringUtils.isEmpty(dto.getKensakuReqJgiName())) {
			dto.setKensakuReqJgiName(null);
		}
		paramEntity.setKensakuReqJgiName(dto.getKensakuReqJgiName());

//		// 従業員番号(MR)
//		if (StringUtils.isEmpty(dto.getMrJgiNo())) {
//			dto.setMrJgiNo(0);
//		}
//		paramEntity.setMrJgiNo(dto.getMrJgiNo());
//
//		// 医薬支店C_申請者所属リージョン(MR)
//		if (StringUtils.isEmpty(dto.getMrBrCode())) {
//			dto.setMrBrCode(null);
//		}
//		paramEntity.setMrBrCode(dto.getMrBrCode());
//
//		// 医薬営業所C_申請者所属エリア(MR)
//		if (StringUtils.isEmpty(dto.getMrDistCode())) {
//			dto.setMrDistCode(null);
//		}
//		paramEntity.setMrDistCode(dto.getMrDistCode());
//
//		// 領域コード(MR)
//		if (StringUtils.isEmpty(dto.getMrTrtCd())) {
//			dto.setMrTrtCd(null);
//		}
//		paramEntity.setMrTrtCd(dto.getMrTrtCd());

		// 検索条件_申請者
		if (StringUtils.isEmpty(dto.getKensakuReqJgiName())) {
			dto.setKensakuReqJgiName(null);
		} else {
			// 漢字変換
			SelectHenkanListEntity kanziHenkan = new SelectHenkanListEntity("漢字変換");
			kanziHenkan.setSearchHenkan(dto.getKensakuReqJgiName());
			// 漢字変換結果を格納
			List<SelectHenkanListEntity> selectKnazi = dao.select(kanziHenkan);
			for (SelectHenkanListEntity kanzi : selectKnazi) {
				paramEntity.setKensakuReqJgiName(kanzi.getSearchHenkan());
				dto.setKensakuReqJgiName(kanzi.getSearchHenkan());
			}
		}

		// 検索条件_施設名（全角）
		if (StringUtils.isEmpty(dto.getKensakuInsKanj())) {
			dto.setKensakuInsKanj(null);
		} else {
			// 漢字変換
			SelectHenkanListEntity kanziHenkan = new SelectHenkanListEntity("漢字変換");
			kanziHenkan.setSearchHenkan(dto.getKensakuInsKanj());
			// 漢字変換結果を格納
			List<SelectHenkanListEntity> selectKnazi = dao.select(kanziHenkan);
			for (SelectHenkanListEntity kanzi : selectKnazi) {
				paramEntity.setKensakuInsKanj(kanzi.getSearchHenkan());
				dto.setKensakuInsKanj(kanzi.getSearchHenkan());
			}
		}

		// 検索条件_施設名カナ(半角カナ)
		if (StringUtils.isEmpty(dto.getKensakuInsKana())) {
			dto.setKensakuInsKana(null);
		} else {
			// 半角変換
			SelectHenkanListEntity hankakuHenkan = new SelectHenkanListEntity("半角変換");
			hankakuHenkan.setSearchHenkan(dto.getKensakuInsKana());
			// 半角変換結果を格納
			List<SelectHenkanListEntity> selectHankaku = dao.select(hankakuHenkan);
			String henkan = "";
			for (SelectHenkanListEntity hankaku : selectHankaku) {
				henkan = hankaku.getSearchHenkan();
			}
			// ハイフン変換
			SelectHenkanListEntity haihunHenkan = new SelectHenkanListEntity("ハイフン変換");
			haihunHenkan.setSearchHenkan(henkan);
			// ハイフン変換結果を格納
			List<SelectHenkanListEntity> selectHaihun = dao.select(haihunHenkan);
			for (SelectHenkanListEntity haihun : selectHaihun) {
				paramEntity.setKensakuInsKana(haihun.getSearchHenkan());
				dto.setKensakuInsKana(haihun.getSearchHenkan());
			}
		}
		// 検索条件_施設固定コード
		if (StringUtils.isEmpty(dto.getKensakuInsNo())) {
			dto.setKensakuInsNo(null);
		}
		paramEntity.setKensakuInsNo(dto.getKensakuInsNo());

		// 検索条件_ULTコード
		if (StringUtils.isEmpty(dto.getKensakuUltInsNo())) {
			dto.setKensakuUltInsNo(null);
		}
		paramEntity.setKensakuUltInsNo(dto.getKensakuUltInsNo());

		// 検索条件_経営主体
		if (StringUtils.isEmpty(dto.getKensakuManageCd())) {
			dto.setKensakuManageCd(null);
		}
		paramEntity.setKensakuManageCd(dto.getKensakuManageCd());

		// 検索条件_対象区分
		if (StringUtils.isEmpty(dto.getKensakuHoInsType())) {
			dto.setKensakuHoInsType(null);
		}
		paramEntity.setKensakuHoInsType(dto.getKensakuHoInsType());

		// 検索条件_施設種別
		if (StringUtils.isEmpty(dto.getKensakuInsSbt())) {
			dto.setKensakuInsSbt(null);
		}
		paramEntity.setKensakuInsSbt(dto.getKensakuInsSbt());

		// 検索条件_施設区分
		if (StringUtils.isEmpty(dto.getKensakuPharmType())) {
			dto.setKensakuPharmType(null);
		}
		paramEntity.setKensakuPharmType(dto.getKensakuPharmType());

		// 検索条件_電話番号(半角)
		if (StringUtils.isEmpty(dto.getKensakuInsPhone())) {
			dto.setKensakuInsPhone(null);
		} else {
			// ハイフン除去
			SelectHenkanListEntity haihunHenkan = new SelectHenkanListEntity("ハイフン除去");
			haihunHenkan.setSearchHenkan(dto.getKensakuInsPhone());
			// ハイフン除去
			List<SelectHenkanListEntity> selectHaihun = dao.select(haihunHenkan);
			for (SelectHenkanListEntity haihun : selectHaihun) {
				paramEntity.setKensakuInsPhone(haihun.getSearchHenkan());
				dto.setKensakuInsPhone(haihun.getSearchHenkan());
			}
		}

		// 検索条件_郵便番号(半角)
		if (StringUtils.isEmpty(dto.getKensakuInsPcode())) {
			dto.setKensakuInsPcode(null);
		} else {
			// ハイフン除去
			SelectHenkanListEntity haihunHenkan = new SelectHenkanListEntity("ハイフン除去");
			haihunHenkan.setSearchHenkan(dto.getKensakuInsPcode());
			// ハイフン除去
			List<SelectHenkanListEntity> selectHaihun = dao.select(haihunHenkan);
			for (SelectHenkanListEntity haihun : selectHaihun) {
				paramEntity.setKensakuInsPcode(haihun.getSearchHenkan());
				dto.setKensakuInsPcode(haihun.getSearchHenkan());
			}
		}

		// 検索条件_都道府県
		if (StringUtils.isEmpty(dto.getKensakuAddrCodePref())) {
			dto.setKensakuAddrCodePref(null);
		}
		paramEntity.setKensakuAddrCodePref(dto.getKensakuAddrCodePref());

		// 検索条件_JIS市区町村
		if (StringUtils.isEmpty(dto.getKensakuAddrCodeCity())) {
			dto.setKensakuAddrCodeCity(null);
		}
		paramEntity.setKensakuAddrCodeCity(dto.getKensakuAddrCodeCity());

		// 検索条件_住所(全角)
		if (StringUtils.isEmpty(dto.getKensakuInsAddr())) {
			dto.setKensakuInsAddr(null);
		} else {
			// 全角変換
			SelectHenkanListEntity zenkakuHenkan = new SelectHenkanListEntity("全角変換");
			zenkakuHenkan.setSearchHenkan(dto.getKensakuInsAddr());
			// 全角変換
			List<SelectHenkanListEntity> selectZenkaku = dao.select(zenkakuHenkan);
			for (SelectHenkanListEntity zenkaku : selectZenkaku) {
				paramEntity.setKensakuInsAddr(zenkaku.getSearchHenkan());
				dto.setKensakuInsAddr(zenkaku.getSearchHenkan());
			}
		}

		// SimpleDateFormatで日付フォーマット設定
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		// 検索条件_更新日(FROM)
		if (dto.getKensakuUpdMstFrom().isEmpty()) {
			dto.setKensakuUpdMstFrom(null);
		}
		try {
			dto.setUpdMstFrom(dto.getKensakuUpdMstFrom());
			paramEntity.setKensakuUpdMstFrom(sdf.parse(dto.getKensakuUpdMstFrom()));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// 検索条件_更新日(TO)
		if (dto.getKensakuUpdMstTo().isEmpty()) {
			dto.setKensakuUpdMstTo(null);
		}
		try {
			dto.setUpdMstTo(dto.getKensakuUpdMstTo());
			paramEntity.setKensakuUpdMstTo(sdf.parse(dto.getKensakuUpdMstTo()));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// ソートID
		paramEntity.setSortId(dto.getSortId());

		// 検索条件をもとに検索結果を格納
		List<BaseEntity> selectParam = dao.select(paramEntity);
		// 検索結果が0件の場合
		if (CollectionUtils.isEmpty(selectParam)) {
			return outdto;
		}

		// 件数定義取得
		SelectParamNF501Entity selectParamNF501Entity = new SelectParamNF501Entity();
		List<SelectParamNF501Entity> selectParamNF501List;
		selectParamNF501List = dao.select(selectParamNF501Entity);

		// 検索結果の件数を取得
//		SelectPageMainInsEntity selectPageMainInsEntity = new SelectPageMainInsEntity();
//	    List<SelectPageMainInsEntity> selectPageMainInsList;
//	    selectPageMainInsList = dao.select(selectPageMainInsEntity);

		// 領域別担当者_検索結果が上限以上の場合
		if (selectParam.size() > selectParamNF501List.get(0).getValue()) {
			dto.setKensakuBool(false);
			return outdto;
		}

		// 領域別担当者検索結果画面受け渡し用リスト
		List<MainInsDataList> mainInsDataList = new ArrayList<MainInsDataList>();
		// 画面初期表示時の帳票一覧を取得する
		List<SelectMainInsListEntity> selectMainInsHstList = dao.select(paramEntity);

		for (SelectMainInsListEntity entity : selectMainInsHstList) {
			MainInsDataList dataRecord = new MainInsDataList();

			// 更新フラグがない場合 表示しない
			if (!Objects.equals(entity.getHoInsTypeUpdFlg(), "1") && !Objects.equals(entity.getInsAbbrNameUpdFlg(), "1")
					&& !Objects.equals(entity.getMainInsNoUpdFlg(), "1")
					&& !Objects.equals(entity.getMainInsNmUpdFlg(), "1")) {
				continue;
			}

			// 検索結果_更新日
			if (entity.getUpdShaYmd() != null) {
				// YYYY/MM/DD型に変換
				String str = new SimpleDateFormat("yyyy/MM/dd").format(entity.getUpdShaYmd());
				dataRecord.setUpdShaYmd(str);
			}

			// 検索結果_申請ID
			dataRecord.setReqId(entity.getReqId());
			// 検索結果_施設固定コード
			dataRecord.setInsNo(entity.getInsNo());
			// 検索結果_対象区分
			LinkedHashMap<String, String> hoInsTypeMap = dto.getHoInsTypeMap();
			String hoInsType = hoInsTypeMap.get(entity.getHoInsType());
			dataRecord.setHoInsType(hoInsType);
			// 検索結果_施設略式漢字名
			dataRecord.setInsAbbrName(entity.getInsAbbrName());
			// 検索結果_親施設コード
			dataRecord.setMainInsNo(entity.getMainInsNo());
			// 検索結果_親施設名
			dataRecord.setMainInsNm(entity.getMainInsNm());
			// 検索結果_領域名（親子）
			if ("・".equals(entity.getTrtNm())) {
				dataRecord.setTrtNm("");
			} else {
				dataRecord.setTrtNm(entity.getTrtNm());
			}
			// 申請者氏名
			dataRecord.setReqJgiName(entity.getReqJgiName());
			// 承認者氏名
			dataRecord.setAprShaId(entity.getAprShaId());
			// 申請者所属エリア
			dataRecord.setReqDistCode(entity.getReqDistCode());
			// 承認者所属
			dataRecord.setReqShz(entity.getReqShz());
			// 承認者所属
			dataRecord.setAprShz(entity.getAprShz());
			// 対象区分更新フラグ
			dataRecord.setHoInsTypeUpdFlg(entity.getHoInsTypeUpdFlg());
			// 施設略式漢字名更新フラグ
			dataRecord.setInsAbbrNameUpdFlg(entity.getInsAbbrNameUpdFlg());
			// 親施設コード更新フラグ
			dataRecord.setMainInsNoUpdFlg(entity.getMainInsNoUpdFlg());
			// 親施設名更新フラグ
			dataRecord.setMainInsNmUpdFlg(entity.getMainInsNmUpdFlg());
			// 削除フラグ更新フラグ
			dataRecord.setDelFlgUpdFlg(entity.getDelFlgUpdFlg());

			// リストにデータ追加
			mainInsDataList.add(dataRecord);
		}
		// 検索数を表示
		dto.initPageInfo(dto.getPageCntCur(), mainInsDataList.size(), selectParamNF501List.get(1).getValue());

		paramEntity.setInOffset(dto.getLineCntStart() - 1);
		paramEntity.setInLimit(selectParamNF501List.get(1).getValue());

		// 検索された帳票一覧をDTOに設定する
		dto.setMainInsDataList(mainInsDataList);

		return outdto;
	}

}
