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
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

import javax.inject.Named;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.HcoJkrData;
import jp.co.takeda.rdm.dto.NF301DTO;
import jp.co.takeda.rdm.entity.join.MRdmCodeMstEntity;
import jp.co.takeda.rdm.entity.join.MRdmComCalUsrEntity;
import jp.co.takeda.rdm.entity.join.MRdmHcoJkrWkEntity;
import jp.co.takeda.rdm.entity.join.MRdmHcoMstEntity;
import jp.co.takeda.rdm.entity.join.MRdmParamMstEntity;
import jp.co.takeda.rdm.entity.join.SRdmJkrSosAddrEntity;
import jp.co.takeda.rdm.entity.join.SelectComboListEntity;
import jp.co.takeda.rdm.entity.join.SelectHcoJkrDataEntity;
import jp.co.takeda.rdm.entity.join.SelectNF301MainDataEntity;
import jp.co.takeda.rdm.entity.join.SelectRdmComTrtgrpDataEntity;
import jp.co.takeda.rdm.entity.join.SeqRdmReqIdEntity;
import jp.co.takeda.rdm.entity.join.TRdmHcoReqEntity;
import jp.co.takeda.rdm.entity.join.TRdmMMdbHcoMstEntity;
import jp.co.takeda.rdm.entity.join.TRdmReqKnrEntity;
import jp.co.takeda.rdm.util.DateUtils;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;

/**
 * Serviceクラス（NF301)
 * @generated
 */
@Named
public class NF301Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(NF301Service.class);

    //20150303 ST-B-367対応 HISOL鈴木 ADD START
    /**
     * 共通処理Serviceオブジェクト
     *   新組織名称(変更前)取得処理
     */
    @javax.inject.Inject
    private CommonControlService commonControlService;
    //20150303 ST-B-367対応 HISOL鈴木 ADD END

    /**
     * イベント処理
     * @param indto NF301DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(NF301DTO indto) {
        BaseDTO outdto = indto;
        // START UOC
        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
        // DropDownList作成
        createCombo(indto);
        // 現在日付を取得
        Date systemDate = DateUtils.getNowDate();
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
        String sysDate = fmtDate.format(systemDate);

        String reqId = indto.getReqId();
        boolean errFlg = false;
        String errMsg = "";

        // 必須入力チェック
        if(indto.getInsType() == null || indto.getInsType().isEmpty()) {
        	// 必須項目にデータを入力してください。（施設種別）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "施設種別") + "\n";
			errFlg = true;
        }
        if(indto.getInsType() != null && ("02".equals(indto.getInsType()) || "04".equals(indto.getInsType())
        		|| "05".equals(indto.getInsType()) || "07".equals(indto.getInsType()))
        		&& (indto.getMainInsCd() == null || indto.getMainInsCd().isEmpty())) {
        	// 必須項目にデータを入力してください。（親施設）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "親施設") + "\n";
			errFlg = true;
        }
        if(indto.getInsAbbrName() == null || indto.getInsAbbrName().isEmpty()) {
        	// 必須項目にデータを入力してください。（施設略式漢字名）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "施設略式漢字名") + "\n";
			errFlg = true;
        }
        if(indto.getInsKana() == null || indto.getInsKana().isEmpty()) {
        	// 必須項目にデータを入力してください。（施設カナ名）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "施設カナ名") + "\n";
			errFlg = true;
        }
        if(indto.getInsFormalName() == null || indto.getInsFormalName().isEmpty()) {
        	// 必須項目にデータを入力してください。（施設正式漢字名）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "施設正式漢字名") + "\n";
			errFlg = true;
        }
        if(indto.getTradeType() == null || indto.getTradeType().isEmpty()) {
        	// 必須項目にデータを入力してください。（取引区分）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "取引区分") + "\n";
			errFlg = true;
        }
        if(!((indto.getInsOpenYear() == null || indto.getInsOpenYear().isEmpty())
        		&& (indto.getInsOpenMonth() == null || indto.getInsOpenMonth().isEmpty())
        		&& (indto.getInsOpenDay() == null || indto.getInsOpenDay().isEmpty()))
        		&& ((indto.getInsOpenYear() == null || indto.getInsOpenYear().isEmpty())
        		|| (indto.getInsOpenMonth() == null || indto.getInsOpenMonth().isEmpty()))) {
        	// 年月日、または年月を入力してください。（開業年月日）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W025).replace("項目名", "開業年月日") + "\n";
			errFlg = true;
        }
        if(indto.getInsPcode() == null || indto.getInsPcode().isEmpty()) {
        	// 必須項目にデータを入力してください。（郵便番号）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "郵便番号") + "\n";
			errFlg = true;
        }
        if(indto.getAddrCodePrefName() == null || indto.getAddrCodePrefName().isEmpty()) {
        	// 必須項目にデータを入力してください。（JIS県名）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "JIS県名") + "\n";
			errFlg = true;
        }
        if(indto.getAddrCodeCityName() == null || indto.getAddrCodeCityName().isEmpty()) {
        	// 必須項目にデータを入力してください。（JIS市区町村名）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "JIS市区町村名") + "\n";
			errFlg = true;
        }
        if(indto.getInsAddrDt() == null || indto.getInsAddrDt().isEmpty()) {
        	// 必須項目にデータを入力してください。（町名地番）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "町名地番") + "\n";
			errFlg = true;
        }
        if(indto.getTkCityName() == null || indto.getTkCityName().isEmpty()) {
        	// 必須項目にデータを入力してください。（武田市区郡名）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "武田市区郡名") + "\n";
			errFlg = true;
        }
        if(indto.getInsPhone1() == null || indto.getInsPhone1().isEmpty()) {
        	// 必須項目にデータを入力してください。（電話番号(代表)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "電話番号(代表)") + "\n";
			errFlg = true;
        }
        if(indto.getInsType() != null && !"04".equals(indto.getInsType())
        		&& !"05".equals(indto.getInsType()) && !"07".equals(indto.getInsType())) {
	        if(indto.getPharmType() == null || indto.getPharmType().isEmpty()) {
	        	// 必須項目にデータを入力してください。（施設区分）
				errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "施設区分") + "\n";
				errFlg = true;
	        }
	        if(indto.getInsRank() == null || indto.getInsRank().isEmpty()) {
	        	// 必須項目にデータを入力してください。（階級区分）
	        	errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "階級区分") + "\n";
	        	errFlg = true;
	        }
	        if(indto.getRegVisType() == null || indto.getRegVisType().isEmpty()) {
	        	// 必須項目にデータを入力してください。（定訪先区分）
	        	errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "定訪先区分") + "\n";
	        	errFlg = true;
	        }
	        if(indto.getImpHosType() == null || indto.getImpHosType().isEmpty()) {
	        	// 必須項目にデータを入力してください。（重点病院区分）
	        	errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "重点病院区分") + "\n";
	        	errFlg = true;
	        }
	        if(indto.getManageCd() == null || indto.getManageCd().isEmpty()) {
	        	// 必須項目にデータを入力してください。（経営主体）
	        	errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "経営主体") + "\n";
	        	errFlg = true;
	        }
        }

        if(indto.getInsType() != null && ("01".equals(indto.getInsType())
        		 || "02".equals(indto.getInsType()))) {
        	if(indto.getBedCntBase() == null || indto.getBedCntBase().isEmpty()) {
            	// 必須項目にデータを入力してください。（基準）
    			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "基準") + "\n";
    			errFlg = true;
            }
        	if(indto.getBedCnt04() == null || indto.getBedCnt04().isEmpty()) {
            	// 必須項目にデータを入力してください。（結核）
    			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "結核") + "\n";
    			errFlg = true;
            }
        	if(indto.getBedCnt01() == null || indto.getBedCnt01().isEmpty()) {
            	// 必須項目にデータを入力してください。（一般）
    			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "一般") + "\n";
    			errFlg = true;
            }
        	if(indto.getBedCnt05() == null || indto.getBedCnt05().isEmpty()) {
            	// 必須項目にデータを入力してください。（感染症）
    			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "感染症") + "\n";
    			errFlg = true;
            }
        	if(indto.getBedCnt03() == null || indto.getBedCnt03().isEmpty()) {
            	// 必須項目にデータを入力してください。（精神）
    			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "精神") + "\n";
    			errFlg = true;
            }
        	if(indto.getBedCnt07() == null || indto.getBedCnt07().isEmpty()) {
            	// 必須項目にデータを入力してください。（療養）
    			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "療養") + "\n";
    			errFlg = true;
            }
        	if(indto.getBedCnt02() == null || indto.getBedCnt02().isEmpty()) {
            	// 必須項目にデータを入力してください。（医療療養）
    			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "医療療養") + "\n";
    			errFlg = true;
            }
        	if(indto.getBedCnt06() == null || indto.getBedCnt06().isEmpty()) {
            	// 必須項目にデータを入力してください。（介護療養）
    			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "介護療養") + "\n";
    			errFlg = true;
            }
        }

        // レングスチェック
        if(indto.getInsAbbrName() != null && indto.getInsAbbrName().length() > 10) {
        	// 最大文字数を超えています。（施設略式漢字名）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "施設略式漢字名") + "\n";
			errFlg = true;
        }
        if(indto.getInsKana() != null && indto.getInsKana().length() > 15) {
        	// 最大文字数を超えています。（施設カナ名）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "施設カナ名") + "\n";
			errFlg = true;
        }
        if(indto.getInsFormalName() != null && indto.getInsFormalName().length() > 40) {
        	// 最大文字数を超えています。（施設正式漢字名）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "施設正式漢字名") + "\n";
			errFlg = true;
        }
        if(indto.getEntcapaNum() != null && indto.getEntcapaNum().length() > 4) {
        	// 最大文字数を超えています。（入所定員情報）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "入所定員情報") + "\n";
			errFlg = true;
        }
        if(indto.getInsPcode() != null && indto.getInsPcode().length() > 8) {
        	// 最大文字数を超えています。（郵便番号）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "郵便番号") + "\n";
			errFlg = true;
        }
        if(indto.getInsPhone1() != null && indto.getInsPhone1().length() > 13) {
        	// 最大文字数を超えています。（電話番号(代表)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "電話番号(代表)") + "\n";
			errFlg = true;
        }
        if(indto.getInsFax1() != null && indto.getInsFax1().length() > 13) {
        	// 最大文字数を超えています。（FAX番号(代表)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "FAX番号(代表)") + "\n";
			errFlg = true;
        }
        if(indto.getInsPhone2() != null && indto.getInsPhone2().length() > 13) {
        	// 最大文字数を超えています。（電話番号(薬局/DI室)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "電話番号(薬局/DI室)") + "\n";
			errFlg = true;
        }
        if(indto.getInsFax2() != null && indto.getInsFax2().length() > 13) {
        	// 最大文字数を超えています。（FAX番号(薬局/DI室)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "FAX番号(薬局/DI室)") + "\n";
			errFlg = true;
        }
        if(indto.getBedCntBase() != null && indto.getBedCntBase().length() > 4) {
        	// 最大文字数を超えています。（基準）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "基準") + "\n";
			errFlg = true;
        }
        if(indto.getBedCnt04() != null && indto.getBedCnt04().length() > 4) {
        	// 最大文字数を超えています。（結核）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "結核") + "\n";
			errFlg = true;
        }
        if(indto.getBedCnt01() != null && indto.getBedCnt01().length() > 4) {
        	// 最大文字数を超えています。（一般）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "一般") + "\n";
			errFlg = true;
        }
        if(indto.getBedCnt05() != null && indto.getBedCnt05().length() > 4) {
        	// 最大文字数を超えています。（感染症）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "感染症") + "\n";
			errFlg = true;
        }
        if(indto.getBedCnt03() != null && indto.getBedCnt03().length() > 4) {
        	// 最大文字数を超えています。（精神）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "精神") + "\n";
			errFlg = true;
        }
        if(indto.getBedCnt07() != null && indto.getBedCnt07().length() > 4) {
        	// 最大文字数を超えています。（療養）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "療養") + "\n";
			errFlg = true;
        }
        if(indto.getBedCnt02() != null && indto.getBedCnt02().length() > 4) {
        	// 最大文字数を超えています。（医療療養）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "医療療養") + "\n";
			errFlg = true;
        }
        if(indto.getBedCnt06() != null && indto.getBedCnt06().length() > 4) {
        	// 最大文字数を超えています。（基準）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "介護療養") + "\n";
			errFlg = true;
        }
        if(indto.getReqComment() != null && StringUtils.getByteLength(indto.getReqComment()) > 300) {
        	// 最大文字数を超えています。（申請コメント）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "申請コメント") + "\n";
			errFlg = true;
        }

        // 文字種チェック
        if(!isNumHyph(indto.getInsPcode())) {
        	// 入力文字種が不正です。（郵便番号）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "郵便番号") + "\n";
			errFlg = true;
        }
        if(!isNumHyph(indto.getInsPhone1())) {
        	// 入力文字種が不正です。（電話番号(代表)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "電話番号(代表)") + "\n";
			errFlg = true;
        }
        if(!isNumHyph(indto.getInsFax1())) {
        	// 入力文字種が不正です。（FAX番号(代表)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "FAX番号(代表)") + "\n";
			errFlg = true;
        }
        if(!isNumHyph(indto.getInsPhone2())) {
        	// 入力文字種が不正です。（電話番号(薬局/DI室)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "電話番号(薬局/DI室)") + "\n";
			errFlg = true;
        }
        if(!isNumHyph(indto.getInsFax2())) {
        	// 入力文字種が不正です。（FAX番号(薬局/DI室)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "FAX番号(薬局/DI室)") + "\n";
			errFlg = true;
        }
        if(!StringUtils.isNumeric(indto.getBedCntBase())) {
        	// 入力文字種が不正です。（基準）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "基準") + "\n";
			errFlg = true;
        }
        if(!StringUtils.isNumeric(indto.getBedCnt04())) {
        	// 入力文字種が不正です。（基準）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "基準") + "\n";
			errFlg = true;
        }
        if(!StringUtils.isNumeric(indto.getBedCnt01())) {
        	// 入力文字種が不正です。（一般）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "一般") + "\n";
			errFlg = true;
        }
        if(!StringUtils.isNumeric(indto.getBedCnt05())) {
        	// 入力文字種が不正です。（感染症）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "感染症") + "\n";
			errFlg = true;
        }
        if(!StringUtils.isNumeric(indto.getBedCnt03())) {
        	// 入力文字種が不正です。（精神）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "精神") + "\n";
			errFlg = true;
        }
        if(!StringUtils.isNumeric(indto.getBedCnt07())) {
        	// 入力文字種が不正です。（療養）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "療養") + "\n";
			errFlg = true;
        }
        if(!StringUtils.isNumeric(indto.getBedCnt02())) {
        	// 入力文字種が不正です。（医療療養）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "医療療養") + "\n";
			errFlg = true;
        }
        if(!StringUtils.isNumeric(indto.getBedCnt06())) {
        	// 入力文字種が不正です。（介護療養）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "介護療養") + "\n";
			errFlg = true;
        }
        if(!StringUtils.isNumeric(indto.getBedsTot())) {
        	// 入力文字種が不正です。（ベッド数計）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "ベッド数計") + "\n";
			errFlg = true;
        }
        if(!StringUtils.isNumeric(indto.getMedBedsTot())) {
        	// 入力文字種が不正です。（医療ベッド数計）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "医療ベッド数計") + "\n";
			errFlg = true;
        }

        // 半角全角チェック
        if(StringUtils.checkMultiByte(indto.getInsPcode())) {
        	// 半角で入力してください。（郵便番号）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "郵便番号") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getInsPhone1())) {
        	// 半角で入力してください。（電話番号(代表)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "電話番号(代表)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getInsFax1())) {
        	// 半角で入力してください。（FAX番号(代表)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "FAX番号(代表)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getInsPhone2())) {
        	// 半角で入力してください。（電話番号(薬局/DI室)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "電話番号(薬局/DI室)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getInsFax2())) {
        	// 半角で入力してください。（FAX番号(薬局/DI室)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "FAX番号(薬局/DI室)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkSingleByte(indto.getInsAbbrName())) {
        	// 全角で入力してください。（施設略式漢字名）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W015).replace("項目名", "施設略式漢字名") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getInsKana())) {
        	// 半角で入力してください。（施設カナ名）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "施設カナ名") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkSingleByte(indto.getInsFormalName())) {
        	// 全角で入力してください。（施設正式漢字名）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W015).replace("項目名", "施設正式漢字名") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkSingleByte(indto.getInsAddrDt())) {
        	// 全角で入力してください。（町名地番）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W015).replace("項目名", "町名地番") + "\n";
			errFlg = true;
        }

        // 書式チェック
        if(indto.getInsPcode() != null
        		&& ((indto.getInsPcode().length() != 0 && indto.getInsPcode().length() != 7 && indto.getInsPcode().length() != 8)
        		|| (indto.getInsPcode().length() == 8 && !chkPostcode(indto.getInsPcode())
        		|| (indto.getInsPcode().length() == 7 && !StringUtils.isNumeric(indto.getInsPcode()))))) {
        	// 正しい書式で入力してください。（郵便番号）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W016).replace("項目名", "郵便番号") + "\n";
			errFlg = true;
        }

        if("10".equals(indto.getInsType()) && !"00-0000-0000".equals(indto.getInsPhone1())) {
        	// 医療モールを新規作成する場合は「00-0000-0000」と入力してください。電話番号(代表)
			errMsg += loginInfo.getMsgData(RdmConstantsData.W017) + "\n";
			errFlg = true;
        }

        // 範囲チェック
        if(!chkNumRange(indto.getBedCntBase(), 0, 9999)) {
        	// 入力可能範囲外です。（基準）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W018).replace("項目名", "基準") + "\n";
			errFlg = true;
        }
        if(!chkNumRange(indto.getBedCnt04(), 0, 9999)) {
        	// 入力可能範囲外です。（結核）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W018).replace("項目名", "結核") + "\n";
			errFlg = true;
        }
        if(!chkNumRange(indto.getBedCnt01(), 0, 9999)) {
        	// 入力可能範囲外です。（一般）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W018).replace("項目名", "一般") + "\n";
			errFlg = true;
        }
        if(!chkNumRange(indto.getBedCnt05(), 0, 9999)) {
        	// 入力可能範囲外です。（感染症）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W018).replace("項目名", "感染症") + "\n";
			errFlg = true;
        }
        if(!chkNumRange(indto.getBedCnt03(), 0, 9999)) {
        	// 入力可能範囲外です。（精神）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W018).replace("項目名", "精神") + "\n";
			errFlg = true;
        }
        if(!chkNumRange(indto.getBedCnt07(), 0, 9999)) {
        	// 入力可能範囲外です。（療養）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W018).replace("項目名", "療養") + "\n";
			errFlg = true;
        }
        if(!chkNumRange(indto.getBedCnt02(), 0, 9999)) {
        	// 入力可能範囲外です。（医療療養）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W018).replace("項目名", "医療療養") + "\n";
			errFlg = true;
        }
        if(!chkNumRange(indto.getBedCnt06(), 0, 9999)) {
        	// 入力可能範囲外です。（介護療養）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W018).replace("項目名", "介護療養") + "\n";
			errFlg = true;
        }
        if(!chkNumRange(indto.getEntcapaNum(), 0, 9999)) {
        	// 入力可能範囲外です。（入所定員情報）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W018).replace("項目名", "入所定員情報") + "\n";
			errFlg = true;
        }

        // 整合性チェック

        // 病床数チェック
		if((!"01".equals(indto.getInsType()) && !"02".equals(indto.getInsType())) || indto.getInsRank() == null) {

		} else if(("01".equals(indto.getInsRank()) || "02".equals(indto.getInsRank()) || "03".equals(indto.getInsRank())
				 || "04".equals(indto.getInsRank()) || "05".equals(indto.getInsRank()) || "06".equals(indto.getInsRank()))
				 && !chkNumRange(indto.getBedsTot(), 0, 9999)){
			// 階級区分の範囲とベッド数計が一致するよう入力して下さい。
			errMsg += loginInfo.getMsgData(RdmConstantsData.W023) + "\n";
			errFlg = true;
		} else if(("12".equals(indto.getInsRank()) || "13".equals(indto.getInsRank()) || "15".equals(indto.getInsRank()))
				 && !"0".equals(indto.getBedsTot())){
			// 階級区分の範囲とベッド数計が一致するよう入力して下さい。
			errMsg += loginInfo.getMsgData(RdmConstantsData.W023) + "\n";
			errFlg = true;
		} else if(("11".equals(indto.getInsRank()) || "14".equals(indto.getInsRank()))
				 && !chkNumRange(indto.getBedsTot(), 1, 19)){
			// 階級区分の範囲とベッド数計が一致するよう入力して下さい。
			errMsg += loginInfo.getMsgData(RdmConstantsData.W023) + "\n";
			errFlg = true;
		} else if("07".equals(indto.getInsRank()) && !chkNumRange(indto.getBedsTot(), 100, 9999)){
			// 階級区分の範囲とベッド数計が一致するよう入力して下さい。
			errMsg += loginInfo.getMsgData(RdmConstantsData.W023) + "\n";
			errFlg = true;
		} else if("08".equals(indto.getInsRank()) && !chkNumRange(indto.getBedsTot(), 200, 9999)){
			// 階級区分の範囲とベッド数計が一致するよう入力して下さい。
			errMsg += loginInfo.getMsgData(RdmConstantsData.W023) + "\n";
			errFlg = true;
		} else if("09".equals(indto.getInsRank()) && !chkNumRange(indto.getBedsTot(), 20, 99)){
			// 階級区分の範囲とベッド数計が一致するよう入力して下さい。
			errMsg += loginInfo.getMsgData(RdmConstantsData.W023) + "\n";
			errFlg = true;
		} else if("10".equals(indto.getInsRank()) && !chkNumRange(indto.getBedsTot(), 20, 199)){
			// 階級区分の範囲とベッド数計が一致するよう入力して下さい。
			errMsg += loginInfo.getMsgData(RdmConstantsData.W023) + "\n";
			errFlg = true;
		} else if("16".equals(indto.getInsRank()) && !chkNumRange(indto.getBedsTot(), 20, 199)
					&& !("0".equals(indto.getBedCnt01()) && "0".equals(indto.getBedCnt07()) && "0".equals(indto.getBedCnt04())
							&& "0".equals(indto.getBedCnt05()) &&chkNumRange(indto.getBedCnt03(), 1, 9999))){
			// 階級区分の範囲とベッド数計が一致するよう入力して下さい。
			errMsg += loginInfo.getMsgData(RdmConstantsData.W023) + "\n";
			errFlg = true;
		}

        // 同じULTコードに紐づく施設新規作成申請がすでに存在している場合
        if(indto.getUltInsCd() != null && !indto.getUltInsCd().equals("")) {
	        TRdmHcoReqEntity tRdmHcoReqchkEntity = new TRdmHcoReqEntity("selectNF011UltChkData");
	        tRdmHcoReqchkEntity.setUltInsNo(indto.getUltInsCd());
	        if(indto.getReqId() != null && !indto.getReqId().isEmpty()) {
	        	tRdmHcoReqchkEntity.setReqId(indto.getReqId());
	        }
	        List<TRdmHcoReqEntity> tRdmHcoReqchkEntityList = dao.select(tRdmHcoReqchkEntity);

	        if(tRdmHcoReqchkEntityList.size() > 0) {
	        	// 重複する申請が行われています。（ULT施設コード）
	        	errMsg += loginInfo.getMsgData(RdmConstantsData.W008).replace("項目名", "ULT施設コード") + "\n";
	        	errFlg = true;
	        }
        }

        // 指定した親施設が、削除申請中、または削除済みだった場合
        if(indto.getMainInsCd() != null && !indto.getMainInsCd().equals("")) {
        	TRdmHcoReqEntity tRdmHcoReqchkEntity = new TRdmHcoReqEntity("selectNF011MainInsChkData");
	        tRdmHcoReqchkEntity.setInsNo(indto.getMainInsCd());
	        List<TRdmHcoReqEntity> tRdmHcoReqchkEntityList = dao.select(tRdmHcoReqchkEntity);

	        if(tRdmHcoReqchkEntityList.size() > 0) {
	        	// 既に削除済み、または削除申請されている施設です。（親施設）
	        	errMsg += loginInfo.getMsgData(RdmConstantsData.W019).replace("項目名", "親施設") + "\n";
	        	errFlg = true;
	        }
        }

        // 紐づいているULT施設が削除済みだった場合
        if(indto.getUltInsCd() != null && !indto.getUltInsCd().equals("")) {
	        TRdmMMdbHcoMstEntity tRdmMMdbHcoMstchkEntity = new TRdmMMdbHcoMstEntity("selectNF011InsDelChkData");
	        tRdmMMdbHcoMstchkEntity.setDcfShisetsuCd(indto.getUltInsCd());
	        List<TRdmHcoReqEntity> tRdmMMdbHcoMstchkEntityList = dao.select(tRdmMMdbHcoMstchkEntity);

	        if(tRdmMMdbHcoMstchkEntityList.size() > 0) {
	        	// 接続対象のULT施設が削除されています。
	        	errMsg += loginInfo.getMsgData(RdmConstantsData.W020) + "\n";
	        	errFlg = true;
	        }
        }

        // 開業年月日：年月日の値が存在しない日付だった場合
        if(indto.getInsOpenDay() != null && !indto.getInsOpenDay().equals("")) {
	        StringBuilder sbDate = new StringBuilder();
	        sbDate.append(indto.getInsOpenYear());
	        sbDate.append(indto.getInsOpenMonth());
	        sbDate.append(indto.getInsOpenDay());
	        String date = sbDate.toString();
	        if(!DateUtils.isDate(date)) {
	        	// 有効な年月日を入力してください。（開業年月日）
	        	errMsg = loginInfo.getMsgData(RdmConstantsData.W022).replace("項目名", "開業年月日") + "\n";
	        	errFlg = true;
	        }
        }

     // 施設種別が02:医療モール内診療所、　で指定された親施設が10:医療モール以外の場合
        if("02".equals(indto.getInsType()) && indto.getMainInsCd() != null && !indto.getMainInsCd().equals("")) {
        	MRdmHcoMstEntity mRdmHcoMstChkEntity = new MRdmHcoMstEntity();
        	mRdmHcoMstChkEntity.setInsNo(indto.getMainInsCd());

        	MRdmHcoMstEntity mRdmHcoMstChkEntityData = dao.selectByPK(mRdmHcoMstChkEntity);
        	if(mRdmHcoMstChkEntityData == null || !"10".equals(mRdmHcoMstChkEntityData.getInsSbt())) {
        		// 親施設に医療モールを選択してください。
        		errMsg += loginInfo.getMsgData(RdmConstantsData.W024) + "\n";
        		errFlg = true;
        	}
        }

        // MR権限の場合、ログインユーザ情報．組織コードが施設のJIS府県＋武田市区郡を担当可能か判定する
        if(RdmConstantsData.RDM_JKN_MR.equals(indto.getLoginJokenSetCd())) {
        	SRdmJkrSosAddrEntity sRdmJkrSosAddrChkEntity = new SRdmJkrSosAddrEntity("selectNF011sosAddrChkData");
        	sRdmJkrSosAddrChkEntity.setSosCd(loginInfo.getSosCd());
        	sRdmJkrSosAddrChkEntity.setAddrCodePref(indto.getAddrCodePref());
        	sRdmJkrSosAddrChkEntity.setTkCityCd(indto.getTkCityCd());

        	List<SRdmJkrSosAddrEntity> sRdmJkrSosAddrChkEntityList = dao.select(sRdmJkrSosAddrChkEntity);

        	if(sRdmJkrSosAddrChkEntityList.size() == 0) {
	        	// 担当可能な地域の郵便番号を選択してください。
        		errMsg += loginInfo.getMsgData(RdmConstantsData.W033) + "\n";
	        	errFlg = true;
	        }
        }

        // 主担当重複チェック
        indto.setHcoJkrDataList(delDeleteFlgRow(indto.getHcoJkrDataList()));

        List<HcoJkrData> hcoJkrDataChkList = indto.getHcoJkrDataList();
        HashSet<String> trtSet = new HashSet<>();

        for(int i=0; i<hcoJkrDataChkList.size(); i++) {
        	HcoJkrData hcoJkrData = hcoJkrDataChkList.get(i);
    		if(!trtSet.add(hcoJkrData.getTrtCd())) {
    			// 領域に対して担当者は1名のみ設定してください。
    			errMsg += loginInfo.getMsgData(RdmConstantsData.W034) + "\n";
    			errFlg = true;
    			break;
    		}
        }

        // 最終更新日時が、画面OPEN時とボタン押下時で異なっていた場合
        if(indto.getUpdShaYmd() != null && !indto.getUpdShaYmd().equals("")) {
        	TRdmReqKnrEntity tRdmReqKnrChkEntity = new TRdmReqKnrEntity("selectNF011DateChkData");
        	tRdmReqKnrChkEntity.setReqId(reqId);

        	List<TRdmReqKnrEntity> tRdmReqKnrEntityList = dao.select(tRdmReqKnrChkEntity);

        	if(tRdmReqKnrEntityList.size() > 0) {
        		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        		Date updDate = null;
                try {
					updDate = sdFormat.parse(indto.getUpdShaYmd());
				} catch (ParseException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
        		if(!tRdmReqKnrEntityList.get(0).getUpdShaYmd().equals(updDate)) {
        			// 既に他のユーザーによってデータが処理されています。
        			errMsg += loginInfo.getMsgData(RdmConstantsData.E003) + "\n";
    	        	errFlg = true;

        		}
        	}
        }

        // エラー時処理
        if(errFlg) {
        	String title = "NF011_施設新規作成";
            indto.setTitle(title);
        	indto.setMsgStr(errMsg);
			outdto.setForward("NF011");
        	return outdto;
        }

        // ホームページアドレス更新日書式設定
        indto.setInsUrlYmd(indto.getInsUrlYmd().replace("-", "/"));

		// 申請ボタン活性フラグ取得
		indto.setBtnEnableFlg("0");
		MRdmParamMstEntity mRdmParamMstEntity = new MRdmParamMstEntity();
		mRdmParamMstEntity.setParamName("MN_FAC");
		mRdmParamMstEntity.setDelFlg("0");

		List<MRdmParamMstEntity> mRdmParamMstEntityList = dao.selectByValue(mRdmParamMstEntity);
		if(mRdmParamMstEntityList.size() > 0) {
			// valueの左一桁
			String value = mRdmParamMstEntityList.get(0).getValue().substring(0,1);
			if("1".equals(value)) {
				// 申請ボタン活性
				indto.setBtnEnableFlg("1");
			}
		}

        // END UOC
		outdto.setForward("NF301");
        return outdto;
    }

    /**
     * 領域担当者リストセット
     * @param sEntity
     * @param sData
     */
    private void setHcoJkrData(SelectHcoJkrDataEntity sEntity, HcoJkrData sData) {

    	sData.setTrtCd(StringUtils.nvl(sEntity.getTrtCd(), ""));
    	sData.setTrtNm(StringUtils.nvl(sEntity.getTrtNm(), ""));
    	sData.setJgiNo(StringUtils.nvl(sEntity.getJgiNo(), ""));
    	sData.setJgiNm(StringUtils.nvl(sEntity.getJgiNm(), ""));
    	sData.setTrtGrpCd(StringUtils.nvl(sEntity.getTrtGrpCd(), ""));
    	sData.setMrCat(StringUtils.nvl(sEntity.getMrCat(), ""));
    	sData.setAddFlg("0");
    	sData.setDeleteFlg("0");
	}

    /**
     * コンボ作成
     * @param indto NF301DTO
     * @return なし
     * @customizable
     */
    private void createCombo(NF301DTO indto){

    	//1-2-1			施設種別
		//		コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
		//		コード名＝INS_TYPE（施設種別）
		//		削除フラグ=0
    	SelectComboListEntity inEntityCmb = new SelectComboListEntity();
    	inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_INS_TYPE);
        List<SelectComboListEntity> outMainList = dao.select(inEntityCmb);
        LinkedHashMap<String, String> mapInsType = new LinkedHashMap<String, String>();
        mapInsType.put("", "--選択してください--");
        for (SelectComboListEntity outEntity : outMainList) {
        	mapInsType.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
        }
        indto.setInsTypeCombo(mapInsType);

        //1-2-2			取引区分
		//		コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
		//		コード名＝TRADE_TYPE（取引区分）
		//		削除フラグ=0
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_TRADE_TYPE);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapTradeType = new LinkedHashMap<String, String>();
		mapTradeType.put("", "--選択してください--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapTradeType.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setTradeTypeCombo(mapTradeType);

		//1-2-7			大学細分類
		//コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
		//		コード名＝UNIV_SUBDIV（大学細分類）
		//		削除フラグ=0
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_UNIV_SUBDIV);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUnivSubdiv = new LinkedHashMap<String, String>();
		mapUnivSubdiv.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUnivSubdiv.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUnivSubdivCombo(mapUnivSubdiv);

		//1-2-8			対象区分
		//コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
		//		コード名＝HO_INS_TYPE（対象区分）
		//		削除フラグ=0
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_HO_INS_TYPE);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapHoInsType = new LinkedHashMap<String, String>();
		mapHoInsType.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapHoInsType.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setHoInsTypeCombo(mapHoInsType);

		//1-2-10			ワクチン対象区分
		//コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
		//		コード名＝VAC_INS_TYPE（ワクチン対象区分）
		//		削除フラグ=0
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_VAC_INS_TYPE);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapVacInsType = new LinkedHashMap<String, String>();
		mapVacInsType.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapVacInsType.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setVacInsTypeCombo(mapVacInsType);

		//1-2-11			ワクチン定訪先区分
		//コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
		//		コード名＝VAC_VISIT_TYPE（ワクチン定訪先区分）
		//		削除フラグ=0
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_VAC_VISIT_TYPE);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapVacVisitType = new LinkedHashMap<String, String>();
		mapVacVisitType.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapVacVisitType.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setVacVisitTypeCombo(mapVacVisitType);

		//開業年月日
        MRdmComCalUsrEntity inEntityYearCmb = new MRdmComCalUsrEntity();
        inEntityYearCmb.setToday("1");
        MRdmComCalUsrEntity outCalUsr = dao.selectByValue(inEntityYearCmb).get(0);
        int yearInt = Integer.parseInt(outCalUsr.getCalYear());
        LinkedHashMap<String, String> mapYear = new LinkedHashMap<String, String>();
        mapYear.put("", "");
        for (int i = 0; i < 101; i++) {
        	String yearStr = Integer.toString(yearInt + 1 - i);
        	mapYear.put(yearStr, yearStr);
        }
        indto.setInsOpenYearCombo(mapYear);

        LinkedHashMap<String, String> mapMonth = new LinkedHashMap<String, String>();
        mapMonth.put("", "");
        for (int i = 0; i < 12; i++) {
        	String monthStr = String.format("%02d", (i+1));
        	mapMonth.put(monthStr, monthStr);
        }
        indto.setInsOpenMonthCombo(mapMonth);

        LinkedHashMap<String, String> mapDay = new LinkedHashMap<String, String>();
        mapDay.put("", "");
        for (int i = 0; i < 31; i++) {
        	String dayStr = String.format("%02d", (i+1));
        	mapDay.put(dayStr, dayStr);
        }
        indto.setInsOpenDayCombo(mapDay);

        // 領域
        SelectRdmComTrtgrpDataEntity inTrtEntityCmb = new SelectRdmComTrtgrpDataEntity();
        List<SelectRdmComTrtgrpDataEntity> outTrtList = dao.select(inTrtEntityCmb);
        LinkedHashMap<String, String> mapTrt = new LinkedHashMap<String, String>();
        mapTrt.put("", "--なし--");
        for (SelectRdmComTrtgrpDataEntity outEntity : outTrtList) {
        	mapTrt.put(outEntity.getTrtCd(), outEntity.getTrtCd()+":"+outEntity.getTrtNm());
        }
        indto.setTrtCdCombo(mapTrt);
    }

    /**
     * イベント処理
     * @param indto NF301DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO register(NF301DTO indto) {
        BaseDTO outdto = indto;
        // START UOC
        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
        outdto.setForward("NF301");

        // 現在日付を取得
        Date systemDate = DateUtils.getNowDate();
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
        String sysDate = fmtDate.format(systemDate);
        SimpleDateFormat fmtDateTime = new SimpleDateFormat("yyyyMMddHHmmss");
        String sysDateTime = fmtDateTime.format(systemDate);

        boolean errFlg = false;
        String errMsg = "";

        if(indto.getAprComment() != null && StringUtils.getByteLength(indto.getAprComment()) > 300) {
        	// 最大文字数を超えています。（承認・却下コメント）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "承認・却下コメント") + "\n";
			errFlg = true;
        }

        // 同じULTコードに紐づく施設新規作成申請がすでに存在している場合
        if(indto.getUltInsCd() != null && !indto.getUltInsCd().equals("")) {
	        TRdmHcoReqEntity tRdmHcoReqchkEntity = new TRdmHcoReqEntity("selectNF011UltChkData");
	        tRdmHcoReqchkEntity.setUltInsNo(indto.getUltInsCd());
	        if(indto.getReqId() != null && !indto.getReqId().isEmpty()) {
	        	tRdmHcoReqchkEntity.setReqId(indto.getReqId());
	        }
	        List<TRdmHcoReqEntity> tRdmHcoReqchkEntityList = dao.select(tRdmHcoReqchkEntity);

	        if(tRdmHcoReqchkEntityList.size() > 0) {
	        	// 重複する申請が行われています。（ULT施設コード）
	        	errMsg += loginInfo.getMsgData(RdmConstantsData.W008).replace("項目名", "ULT施設コード") + "\n";
				errFlg = true;
	        }
        }

        if("3".equals(indto.getFuncId())) {
			if(indto.getAprComment() != null && indto.getAprComment().isEmpty()) {
	        	// 却下の場合はコメントを入力してください。
				errMsg += loginInfo.getMsgData(RdmConstantsData.W026) + "\n";
				errFlg = true;
	        }
        }

        // 最終更新日時が、画面OPEN時とボタン押下時で異なっていた場合
		if(indto.getUpdShaYmd() != null && !indto.getUpdShaYmd().equals("")) {
			TRdmReqKnrEntity tRdmReqKnrChkEntity = new TRdmReqKnrEntity("selectNF011DateChkData");
			tRdmReqKnrChkEntity.setReqId(indto.getReqId());

			List<TRdmReqKnrEntity> tRdmReqKnrEntityList = dao.select(tRdmReqKnrChkEntity);

			if(tRdmReqKnrEntityList.size() > 0) {
        		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        		Date updDate = null;
                try {
					updDate = sdFormat.parse(indto.getUpdShaYmd());
				} catch (ParseException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
        		if(!tRdmReqKnrEntityList.get(0).getUpdShaYmd().equals(updDate)) {
        			// 既に他のユーザーによってデータが処理されています。
        			errMsg += loginInfo.getMsgData(RdmConstantsData.E003) + "\n";
    	        	errFlg = true;

        		}
        	}
		}

        // エラー時処理
        if(errFlg) {
        	indto.setMsgStr(errMsg);
        	return outdto;
        }

        // 申請管理
        TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity();
        tRdmReqKnrEntity.setReqId(indto.getReqId());
        TRdmReqKnrEntity tRdmReqKnrData = dao.selectByPK(tRdmReqKnrEntity);

        String reqId = indto.getReqId();

        if(tRdmReqKnrData == null) {
        	// 新規登録
        	// 新規にIDを取得
        	SeqRdmReqIdEntity seqRdmReqIdEntity = new SeqRdmReqIdEntity();
        	List<SeqRdmReqIdEntity> seqRdmReqIdDate = dao.select(seqRdmReqIdEntity);
        	reqId = seqRdmReqIdDate.get(0).getReqId();

        	// レコードを登録
        	TRdmReqKnrEntity tRdmReqKnrInsData = new TRdmReqKnrEntity();
        	tRdmReqKnrInsData.setReqId(reqId);
        	if(RdmConstantsData.RDM_JKN_ADMIN.equals(indto.getLoginJokenSetCd())) {
        		// 承認者（管理者権限）が申請の場合、'2'(DSG起因)
        		tRdmReqKnrInsData.setReqChl("2");
        		tRdmReqKnrInsData.setReqKngKbn("2");
        	} else {
        		// "MRが申請の場合、'1'(MR起因)
        		tRdmReqKnrInsData.setReqChl("1");
        		tRdmReqKnrInsData.setReqKngKbn("1");
        	}
        	tRdmReqKnrInsData.setReqType("01");
    		// 申請
    		tRdmReqKnrInsData.setReqStsCd("03");
    		tRdmReqKnrInsData.setReqBrCd(indto.getLoginBrCd());
        	tRdmReqKnrInsData.setReqDistCd(indto.getLoginDistCd());
        	tRdmReqKnrInsData.setReqShzNm(indto.getLoginShzNm());
        	tRdmReqKnrInsData.setReqJgiNo(Integer.parseInt(indto.getLoginJgiNo()));
        	tRdmReqKnrInsData.setReqJgiName(indto.getLoginNm());
        	tRdmReqKnrInsData.setReqYmdhms(sysDateTime);
        	tRdmReqKnrInsData.setReqComment(indto.getReqComment());
        	tRdmReqKnrInsData.setInsShaYmd(systemDate);
        	tRdmReqKnrInsData.setInsShaId(indto.getLoginJgiNo());
        	tRdmReqKnrInsData.setUpdShaYmd(systemDate);
        	tRdmReqKnrInsData.setUpdShaId(indto.getLoginJgiNo());

        	dao.insertByValue(tRdmReqKnrInsData);

        } else {
        	// 更新
        	TRdmReqKnrEntity tRdmReqKnrUpdData = new TRdmReqKnrEntity("updateNF301Data");
        	tRdmReqKnrUpdData.setReqId(reqId);

        	if("1".equals(indto.getFuncId())) {
    			// 申請
        		if("1".equals(indto.getReqChl()) || "2".equals(indto.getReqChl())) {
    				tRdmReqKnrUpdData.setReqStsCd("03");
    			} else if("3".equals(indto.getReqChl())) {
    				tRdmReqKnrUpdData.setReqStsCd("13");
    			}
        		tRdmReqKnrUpdData.setReqBrCd(indto.getLoginBrCd());
            	tRdmReqKnrUpdData.setReqDistCd(indto.getLoginDistCd());
            	tRdmReqKnrUpdData.setReqShzNm(indto.getLoginShzNm());
            	tRdmReqKnrUpdData.setReqJgiNo(Integer.parseInt(indto.getLoginJgiNo()));
            	tRdmReqKnrUpdData.setReqJgiName(indto.getLoginNm());
            	tRdmReqKnrUpdData.setReqYmdhms(sysDateTime);

            	if(RdmConstantsData.RDM_JKN_ADMIN.equals(indto.getLoginJokenSetCd())) {
            		tRdmReqKnrUpdData.setReqKngKbn("2");
            	} else {
            		tRdmReqKnrUpdData.setReqKngKbn("1");
            	}

        	} else if("2".equals(indto.getFuncId())) {
        		// 承認
        		if("1".equals(indto.getReqChl()) || "2".equals(indto.getReqChl())) {
    				tRdmReqKnrUpdData.setReqStsCd("04");
    			} else if("3".equals(indto.getReqChl())) {
    				tRdmReqKnrUpdData.setReqStsCd("14");
    			}
        		tRdmReqKnrUpdData.setAprBrCode(indto.getLoginBrCd());
            	tRdmReqKnrUpdData.setAprDistCode(indto.getLoginDistCd());
            	tRdmReqKnrUpdData.setAprShz(indto.getLoginShzNm());
            	tRdmReqKnrUpdData.setAprJgiNo(Integer.parseInt(indto.getLoginJgiNo()));
            	tRdmReqKnrUpdData.setAprShaName(indto.getLoginNm());
            	tRdmReqKnrUpdData.setAprYmdhms(sysDateTime);
            	tRdmReqKnrUpdData.setAprComment(indto.getAprComment());
            	if("on".equals(indto.getFbReqFlg())) {
            		tRdmReqKnrUpdData.setFbReqFlg("1");
            	} else {
            		tRdmReqKnrUpdData.setFbReqFlg("0");
            	}

        	} else if("3".equals(indto.getFuncId())) {
    			// 却下
        		if("1".equals(indto.getReqChl()) || "2".equals(indto.getReqChl())) {
    				tRdmReqKnrUpdData.setReqStsCd("02");
    			} else if("3".equals(indto.getReqChl())) {
    				tRdmReqKnrUpdData.setReqStsCd("12");
    			}
        		tRdmReqKnrUpdData.setAprBrCode(indto.getLoginBrCd());
            	tRdmReqKnrUpdData.setAprDistCode(indto.getLoginDistCd());
            	tRdmReqKnrUpdData.setAprShz(indto.getLoginShzNm());
            	tRdmReqKnrUpdData.setAprJgiNo(Integer.parseInt(indto.getLoginJgiNo()));
            	tRdmReqKnrUpdData.setAprShaName(indto.getLoginNm());
            	tRdmReqKnrUpdData.setAprYmdhms(sysDateTime);
            	tRdmReqKnrUpdData.setAprComment(indto.getAprComment());

        	}

        	tRdmReqKnrUpdData.setReqComment(indto.getReqComment());
        	tRdmReqKnrUpdData.setUpdShaYmd(systemDate);
        	tRdmReqKnrUpdData.setUpdShaId(indto.getLoginJgiNo());

        	dao.update(tRdmReqKnrUpdData);
        }

        // 施設_申請管理
        TRdmHcoReqEntity tRdmHcoReqEntity = new TRdmHcoReqEntity();
        tRdmHcoReqEntity.setReqId(reqId);
        TRdmHcoReqEntity tRdmHcoReqData = dao.selectByPK(tRdmHcoReqEntity);

        // 施設分類取得
        String insClass = null;
        MRdmCodeMstEntity mRdmCodeMstEntity = new MRdmCodeMstEntity();
        mRdmCodeMstEntity.setCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_INS_TYPE);
        mRdmCodeMstEntity.setValue1(indto.getInsType());
        List<MRdmCodeMstEntity> mRdmCodeMstDate = dao.selectByValue(mRdmCodeMstEntity);
        if(mRdmCodeMstDate.size() > 0) {
        	insClass = mRdmCodeMstDate.get(0).getValue2();
        }

        if(tRdmHcoReqData == null) {
        	// 新規登録
        	TRdmHcoReqEntity tRdmHcoReqInsData = new TRdmHcoReqEntity();
        	tRdmHcoReqInsData.setReqId(reqId);
        	tRdmHcoReqInsData.setInsClass(insClass);
        	tRdmHcoReqInsData.setInsSbt(indto.getInsType());
        	tRdmHcoReqInsData.setInsKana(indto.getInsKana());
        	tRdmHcoReqInsData.setInsAbbrName(indto.getInsAbbrName());
        	tRdmHcoReqInsData.setInsFormalName(indto.getInsFormalName());
        	tRdmHcoReqInsData.setInsContName(indto.getInsContName());
        	tRdmHcoReqInsData.setInsPcode(indto.getInsPcode().replace("-", ""));
        	tRdmHcoReqInsData.setAddrCodePref(indto.getAddrCodePref());
        	tRdmHcoReqInsData.setAddrCodeCity(indto.getAddrCodeCity());
        	tRdmHcoReqInsData.setTkCityCd(indto.getTkCityCd());
        	tRdmHcoReqInsData.setInsAddrDt(indto.getInsAddrDt());
        	tRdmHcoReqInsData.setInsAddr(StringUtils.nvl(indto.getInsAddr(),""));
        	tRdmHcoReqInsData.setInsAddrKana(StringUtils.nvl(indto.getInsAddrKana(),""));
        	tRdmHcoReqInsData.setInsPhone1(indto.getInsPhone1());
        	tRdmHcoReqInsData.setInsFax1(indto.getInsFax1());
        	tRdmHcoReqInsData.setInsPhone2(indto.getInsPhone2());
        	tRdmHcoReqInsData.setInsFax2(indto.getInsFax2());
        	tRdmHcoReqInsData.setInsUrl(indto.getInsUrl());
        	tRdmHcoReqInsData.setInsUrlYmd(indto.getInsUrlYmd().replace("/", ""));
        	tRdmHcoReqInsData.setTradeType(indto.getTradeType());
        	tRdmHcoReqInsData.setHoInsType(indto.getHoInsType());
        	tRdmHcoReqInsData.setPharmType(indto.getPharmType());
        	tRdmHcoReqInsData.setInsRank(indto.getInsRank());
        	tRdmHcoReqInsData.setManageCd(indto.getManageCd());
        	tRdmHcoReqInsData.setRegVisType(indto.getRegVisType());
        	tRdmHcoReqInsData.setImpHosType(indto.getImpHosType());
        	tRdmHcoReqInsData.setUnivSubdiv(indto.getUnivSubdiv());
        	tRdmHcoReqInsData.setInsOpenYear(indto.getInsOpenYear());
        	tRdmHcoReqInsData.setInsOpenMonth(indto.getInsOpenMonth());
        	tRdmHcoReqInsData.setInsOpenDay(indto.getInsOpenDay());

        	// 診療科目セットする
        	if(indto.getUltInsCd() != null) {
	        	// T_RDM_M_MDB_HCO_MSTから取得、セミコロン区切りで登録
	        	List<String> shinryoList = new ArrayList<String>();
	        	TRdmMMdbHcoMstEntity tRdmMMdbHcoMstEntity = new TRdmMMdbHcoMstEntity();
	        	tRdmMMdbHcoMstEntity.setMdbKbn("DCF");
	        	tRdmMMdbHcoMstEntity.setDcfShisetsuCd(indto.getUltInsCd());

	        	List<TRdmMMdbHcoMstEntity> tRdmMMdbHcoMstData = dao.selectByValue(tRdmMMdbHcoMstEntity);

	        	if(tRdmMMdbHcoMstData.size() > 0){
	        		TRdmMMdbHcoMstEntity tRdmMMdbHcoMstSinryoData = tRdmMMdbHcoMstData.get(0);
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd1() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd1());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd2() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd2());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd3() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd3());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd4() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd4());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd5() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd5());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd6() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd6());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd7() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd7());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd8() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd8());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd9() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd9());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd10() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd10());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd11() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd11());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd12() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd12());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd13() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd13());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd14() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd14());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd15() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd15());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd16() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd16());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd17() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd17());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd18() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd18());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd19() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd19());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd20() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd20());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd21() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd21());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd22() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd22());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd23() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd23());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd24() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd24());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd25() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd25());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd26() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd26());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd27() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd27());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd28() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd28());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd29() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd29());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd30() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd30());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd31() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd31());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd32() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd32());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd33() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd33());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd34() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd34());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd35() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd35());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd36() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd36());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd37() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd37());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd38() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd38());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd39() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd39());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd40() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd40());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd41() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd41());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd42() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd42());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd43() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd43());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd44() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd44());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd45() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd45());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd46() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd46());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd47() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd47());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd48() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd48());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd49() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd49());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd50() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd50());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd51() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd51());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd52() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd52());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd53() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd53());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd54() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd54());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd55() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd55());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd56() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd56());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd57() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd57());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd58() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd58());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd59() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd59());
	        		}
	        		if(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd60() != null) {
	        			shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd60());
	        		}
	        	}

	        	tRdmHcoReqInsData.setClitemList(String.join(";",shinryoList));
        	}

        	tRdmHcoReqInsData.setVacInsType(indto.getVacInsType());
        	tRdmHcoReqInsData.setVacVisitType(indto.getVacVisitType());
        	tRdmHcoReqInsData.setBedcntBase(indto.getBedCntBase());
        	tRdmHcoReqInsData.setBedsTot(indto.getBedsTot());
        	tRdmHcoReqInsData.setMedBedsTot(indto.getMedBedsTot());
        	tRdmHcoReqInsData.setEntcapaNum(indto.getEntcapaNum());
        	tRdmHcoReqInsData.setMainInsNo(indto.getMainInsCd());
        	tRdmHcoReqInsData.setUltInsNo(indto.getUltInsCd());
        	tRdmHcoReqInsData.setBedcnt01(indto.getBedCnt01());
        	tRdmHcoReqInsData.setBedcnt02(indto.getBedCnt02());
        	tRdmHcoReqInsData.setBedcnt03(indto.getBedCnt03());
        	tRdmHcoReqInsData.setBedcnt04(indto.getBedCnt04());
        	tRdmHcoReqInsData.setBedcnt05(indto.getBedCnt05());
        	tRdmHcoReqInsData.setBedcnt06(indto.getBedCnt06());
        	tRdmHcoReqInsData.setBedcnt07(indto.getBedCnt07());
        	tRdmHcoReqInsData.setInsShaYmd(sysDate);
        	tRdmHcoReqInsData.setInsShaId(indto.getLoginJgiNo());
        	tRdmHcoReqInsData.setUpdShaYmd(sysDate);
        	tRdmHcoReqInsData.setUpdShaId(indto.getLoginJgiNo());

        	dao.insertByValue(tRdmHcoReqInsData);

        } else {
        	// 更新
        	TRdmHcoReqEntity tRdmHcoReqUpdData = new TRdmHcoReqEntity("updateNF011Data");
        	tRdmHcoReqUpdData.setReqId(reqId);
        	tRdmHcoReqUpdData.setInsClass(insClass);
        	tRdmHcoReqUpdData.setInsSbt(indto.getInsType());
        	tRdmHcoReqUpdData.setInsKana(indto.getInsKana());
        	tRdmHcoReqUpdData.setInsAbbrName(indto.getInsAbbrName());
        	tRdmHcoReqUpdData.setInsFormalName(indto.getInsFormalName());
        	tRdmHcoReqUpdData.setInsContName(indto.getInsContName());
        	tRdmHcoReqUpdData.setInsPcode(indto.getInsPcode().replace("-", ""));
        	tRdmHcoReqUpdData.setAddrCodePref(indto.getAddrCodePref());
        	tRdmHcoReqUpdData.setAddrCodeCity(indto.getAddrCodeCity());
        	tRdmHcoReqUpdData.setTkCityCd(indto.getTkCityCd());
        	tRdmHcoReqUpdData.setInsAddrDt(indto.getInsAddrDt());
        	tRdmHcoReqUpdData.setInsAddr(StringUtils.nvl(indto.getInsAddr(),""));
        	tRdmHcoReqUpdData.setInsAddrKana(StringUtils.nvl(indto.getInsAddrKana(),""));
        	tRdmHcoReqUpdData.setInsPhone1(indto.getInsPhone1());
        	tRdmHcoReqUpdData.setInsFax1(indto.getInsFax1());
        	tRdmHcoReqUpdData.setInsPhone2(indto.getInsPhone2());
        	tRdmHcoReqUpdData.setInsFax2(indto.getInsFax2());
        	tRdmHcoReqUpdData.setInsUrl(indto.getInsUrl());
        	tRdmHcoReqUpdData.setInsUrlYmd(indto.getInsUrlYmd().replace("/", ""));
        	tRdmHcoReqUpdData.setTradeType(indto.getTradeType());
        	tRdmHcoReqUpdData.setHoInsType(indto.getHoInsType());
        	tRdmHcoReqUpdData.setPharmType(indto.getPharmType());
        	tRdmHcoReqUpdData.setInsRank(indto.getInsRank());
        	tRdmHcoReqUpdData.setManageCd(indto.getManageCd());
        	tRdmHcoReqUpdData.setRegVisType(indto.getRegVisType());
        	tRdmHcoReqUpdData.setImpHosType(indto.getImpHosType());
        	tRdmHcoReqUpdData.setUnivSubdiv(indto.getUnivSubdiv());
        	tRdmHcoReqUpdData.setInsOpenYear(indto.getInsOpenYear());
        	tRdmHcoReqUpdData.setInsOpenMonth(indto.getInsOpenMonth());
        	tRdmHcoReqUpdData.setInsOpenDay(indto.getInsOpenDay());
        	tRdmHcoReqUpdData.setVacInsType(indto.getVacInsType());
        	tRdmHcoReqUpdData.setVacVisitType(indto.getVacVisitType());
        	tRdmHcoReqUpdData.setBedcntBase(indto.getBedCntBase());
        	tRdmHcoReqUpdData.setBedsTot(indto.getBedsTot());
        	tRdmHcoReqUpdData.setMedBedsTot(indto.getMedBedsTot());
        	tRdmHcoReqUpdData.setEntcapaNum(indto.getEntcapaNum());
        	tRdmHcoReqUpdData.setMainInsNo(indto.getMainInsCd());
        	tRdmHcoReqUpdData.setBedcnt01(indto.getBedCnt01());
        	tRdmHcoReqUpdData.setBedcnt02(indto.getBedCnt02());
        	tRdmHcoReqUpdData.setBedcnt03(indto.getBedCnt03());
        	tRdmHcoReqUpdData.setBedcnt04(indto.getBedCnt04());
        	tRdmHcoReqUpdData.setBedcnt05(indto.getBedCnt05());
        	tRdmHcoReqUpdData.setBedcnt06(indto.getBedCnt06());
        	tRdmHcoReqUpdData.setBedcnt07(indto.getBedCnt07());
        	tRdmHcoReqUpdData.setUpdShaYmd(sysDate);
        	tRdmHcoReqUpdData.setUpdShaId(indto.getLoginJgiNo());

        	dao.update(tRdmHcoReqUpdData);
        }

        // 施設_領域担当者ワーク
        List<HcoJkrData> hcoJkrDataEntity = indto.getHcoJkrDataList();

    	// 削除処理
		MRdmHcoJkrWkEntity mRdmHcoJkrWkdata = new MRdmHcoJkrWkEntity();
		mRdmHcoJkrWkdata.setReqId(reqId);

		dao.deleteByPK(mRdmHcoJkrWkdata);

        for(int i=0; i<hcoJkrDataEntity.size(); i++) {
        	// 登録処理
        	HcoJkrData hcoJkrData = hcoJkrDataEntity.get(i);

        	if(!"1".equals(hcoJkrData.getDeleteFlg())) {
	        	MRdmHcoJkrWkEntity mRdmHcoJkrWkData = new MRdmHcoJkrWkEntity();
	    		mRdmHcoJkrWkData.setReqId(reqId);
	    		mRdmHcoJkrWkData.setTrtCd(hcoJkrData.getTrtCd());
	    		mRdmHcoJkrWkData.setJgiNo(hcoJkrData.getJgiNo());
	    		mRdmHcoJkrWkData.setMrCat(hcoJkrData.getMrCat());
	    		mRdmHcoJkrWkData.setMainMr("0");
	    		mRdmHcoJkrWkData.setRkiFlg("0");
	    		mRdmHcoJkrWkData.setInsShaYmd(sysDate);
	    		mRdmHcoJkrWkData.setInsShaId(indto.getLoginJgiNo());
	    		mRdmHcoJkrWkData.setUpdShaYmd(sysDate);
	    		mRdmHcoJkrWkData.setUpdShaId(indto.getLoginJgiNo());

	    		dao.insertByValue(mRdmHcoJkrWkData);
        	}
        }

        // 初期表示検索
        indto.setReqId(reqId);
        List<HcoJkrData> hcoJkrDataList = new ArrayList<HcoJkrData>();
        List<HcoJkrData> beforeHcoJkrDataList = new ArrayList<HcoJkrData>();

		// 申請データを参照
		SelectNF301MainDataEntity paramEntity = new SelectNF301MainDataEntity();
		paramEntity.setInReqId(indto.getReqId());
		List<SelectNF301MainDataEntity> mainDataEntityList = dao.select(paramEntity);
		SelectNF301MainDataEntity mainDataEntity = mainDataEntityList.get(0);

		// 申請情報
		indto.setReqShzNm(StringUtils.nvl(mainDataEntity.getReqShzNm(), ""));
		indto.setReqStsNm(StringUtils.nvl(mainDataEntity.getReqStsNm(), ""));
		indto.setReqJgiName(StringUtils.nvl(mainDataEntity.getReqJgiName(), ""));
		indto.setShnShaName(StringUtils.nvl(mainDataEntity.getShnShaName(), ""));
		indto.setAprShaName(StringUtils.nvl(mainDataEntity.getAprShaName(), ""));

		SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat sdfDateTime2 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		if(mainDataEntity.getReqYmdhms() != null && mainDataEntity.getReqYmdhms().length() == 14) {
			try {
				Date reqYmd = sdfDateTime.parse(mainDataEntity.getReqYmdhms());
				String strReqYmd = sdfDateTime2.format(reqYmd);
				indto.setReqYmdhms(strReqYmd);
			} catch (ParseException e) {
				e.printStackTrace();
				indto.setReqYmdhms(StringUtils.nvl(mainDataEntity.getReqYmdhms(), ""));
			}
		} else {
			indto.setReqYmdhms(StringUtils.nvl(mainDataEntity.getReqYmdhms(), ""));
		}

		if(mainDataEntity.getShnYmdhms() != null && mainDataEntity.getShnYmdhms().length() == 14) {
			try {
				Date shnYmd = sdfDateTime.parse(mainDataEntity.getShnYmdhms());
				String strShnYmd = sdfDateTime2.format(shnYmd);
				indto.setShnYmdhms(strShnYmd);
			} catch (ParseException e) {
				e.printStackTrace();
				indto.setShnYmdhms(StringUtils.nvl(mainDataEntity.getShnYmdhms(), ""));
			}
		} else {
			indto.setShnYmdhms(StringUtils.nvl(mainDataEntity.getShnYmdhms(), ""));
		}

		if(mainDataEntity.getAprYmdhms() != null && mainDataEntity.getAprYmdhms().length() == 14) {
			try {
				Date aprYmd = sdfDateTime.parse(mainDataEntity.getAprYmdhms());
				String strAprYmd = sdfDateTime2.format(aprYmd);
				indto.setAprYmdhms(strAprYmd);
			} catch (ParseException e) {
				e.printStackTrace();
				indto.setAprYmdhms(StringUtils.nvl(mainDataEntity.getAprYmdhms(), ""));
			}
		} else {
			indto.setAprYmdhms(StringUtils.nvl(mainDataEntity.getAprYmdhms(), ""));
		}

		indto.setReqJgiNo(mainDataEntity.getReqJgiNo());
		indto.setReqBrCd(StringUtils.nvl(mainDataEntity.getReqBrCd(), ""));
		indto.setReqDistCd(StringUtils.nvl(mainDataEntity.getReqDistCd(), ""));
		indto.setReqStsCd(StringUtils.nvl(mainDataEntity.getReqStsCd(), ""));
		indto.setReqChl(StringUtils.nvl(mainDataEntity.getReqChl(), ""));
		indto.setShnJgiNo(mainDataEntity.getShnJgiNo());
		indto.setAprJgiNo(mainDataEntity.getAprJgiNo());
		indto.setUpdShaYmd(StringUtils.nvl(mainDataEntity.getUpdShaYmd(), ""));

		// 基本情報
		indto.setUltInsCd(StringUtils.nvl(mainDataEntity.getDcfShisetsuCd(), ""));
		indto.setUltInsNm(StringUtils.nvl(mainDataEntity.getShisetsuNm(), ""));
		indto.setInsType(StringUtils.nvl(mainDataEntity.getInsType(), ""));
		indto.setInsTypeNm(StringUtils.nvl(mainDataEntity.getInsTypeNm(), ""));
		indto.setMainInsCd(StringUtils.nvl(mainDataEntity.getMainInsCd(), ""));
		indto.setMainInsNm(StringUtils.nvl(mainDataEntity.getMainInsNm(), ""));
		indto.setInsAbbrName(StringUtils.nvl(mainDataEntity.getShisetsuNmRyaku(), ""));
		indto.setInsKana(StringUtils.nvl(mainDataEntity.getShisetsuNmKana(), ""));
		indto.setInsFormalName(StringUtils.nvl(mainDataEntity.getInsFormalName(), ""));
		indto.setInsContName(StringUtils.nvl(mainDataEntity.getInsContName(), ""));
		indto.setTradeType(StringUtils.nvl(mainDataEntity.getTradeType(), ""));
		indto.setTradeTypeNm(StringUtils.nvl(mainDataEntity.getTradeTypeNm(), ""));
		indto.setInsOpenYear(StringUtils.nvl(mainDataEntity.getInsOpenYear(), ""));
		indto.setInsOpenMonth(StringUtils.nvl(mainDataEntity.getInsOpenMonth(), ""));
		indto.setInsOpenDay(StringUtils.nvl(mainDataEntity.getInsOpenDay(), ""));

		// 住所詳細
		if(StringUtils.nvl(mainDataEntity.getYubinNo(), "").length() == 7) {
			String yubin = mainDataEntity.getYubinNo().substring(0, 3) + "-" + mainDataEntity.getYubinNo().substring(3);
			indto.setInsPcode(yubin);
		} else {
			indto.setInsPcode(StringUtils.nvl(mainDataEntity.getYubinNo(), ""));

		}
		indto.setAddrCodePref(StringUtils.nvl(mainDataEntity.getTodofukenCd(), ""));
		indto.setAddrCodePrefName(StringUtils.nvl(mainDataEntity.getTodofukenNm(), ""));
		indto.setAddrCodeCity(StringUtils.nvl(mainDataEntity.getShikuchosonCd(), ""));
		indto.setAddrCodeCityName(StringUtils.nvl(mainDataEntity.getShikuchosonNm(), ""));
		indto.setInsAddrDt(StringUtils.nvl(mainDataEntity.getInsAddrDt(), ""));
		indto.setTkCityCd(StringUtils.nvl(mainDataEntity.getTkCityCd(), ""));
		indto.setTkCityName(StringUtils.nvl(mainDataEntity.getTkCityNm(), ""));
		indto.setInsPhone1(StringUtils.nvl(mainDataEntity.getInsPhone1(), ""));
		indto.setInsPhone2(StringUtils.nvl(mainDataEntity.getInsPhone2(), ""));
		indto.setInsFax1(StringUtils.nvl(mainDataEntity.getInsFax1(), ""));
		indto.setInsFax2(StringUtils.nvl(mainDataEntity.getInsFax2(), ""));
		indto.setInsUrl(StringUtils.nvl(mainDataEntity.getInsUrl(), ""));

		// ホームページアドレス更新日を"yyyy/MM/dd"に変換
		if(!"".equals(StringUtils.nvl(mainDataEntity.getInsUrlYmd(), ""))) {
			StringBuilder sbUrlYmd = new StringBuilder();
			sbUrlYmd.append(mainDataEntity.getInsUrlYmd().substring(0,4));
			sbUrlYmd.append("/");
			sbUrlYmd.append(mainDataEntity.getInsUrlYmd().substring(4,6));
			sbUrlYmd.append("/");
			sbUrlYmd.append(mainDataEntity.getInsUrlYmd().substring(6,8));
			indto.setInsUrlYmd(sbUrlYmd.toString());
		}

		indto.setInsAddrKana(StringUtils.nvl(mainDataEntity.getAddressKana(), ""));

		// 区分情報
		indto.setPharmType(StringUtils.nvl(mainDataEntity.getPharmType(), ""));
		indto.setInsRank(StringUtils.nvl(mainDataEntity.getInsRank(), ""));
		indto.setRegVisType(StringUtils.nvl(mainDataEntity.getRegVisType(), ""));
		indto.setImpHosType(StringUtils.nvl(mainDataEntity.getImpHosType(), ""));
		indto.setUnivSubdiv(StringUtils.nvl(mainDataEntity.getUnivSubdiv(), ""));
		indto.setHoInsType(StringUtils.nvl(mainDataEntity.getHoInsType(), ""));
		indto.setPharmTypeNm(StringUtils.nvl(mainDataEntity.getPharmTypeNm(), ""));
		indto.setInsRankNm(StringUtils.nvl(mainDataEntity.getInsRankNm(), ""));
		indto.setRegVisTypeNm(StringUtils.nvl(mainDataEntity.getRegVisTypeNm(), ""));
		indto.setImpHosTypeNm(StringUtils.nvl(mainDataEntity.getImpHosTypeNm(), ""));
		indto.setUnivSubdivNm(StringUtils.nvl(mainDataEntity.getUnivSubdivNm(), ""));
		indto.setHoInsTypeNm(StringUtils.nvl(mainDataEntity.getHoInsTypeNm(), ""));

		// 経営主体
		// TODO M_RDM_HCO_KEIEITAIから取得か保留中
		indto.setManageCd(StringUtils.nvl(mainDataEntity.getManageCd(), ""));
		indto.setManageNm(StringUtils.nvl(mainDataEntity.getManageNm(), ""));

		// 病床数
		indto.setBedCntBase(StringUtils.nvl(mainDataEntity.getBedCntBase(), ""));
		indto.setBedCnt01(StringUtils.nvl(mainDataEntity.getKyokabyoshosuIppan(), ""));
		indto.setBedCnt02(StringUtils.nvl(mainDataEntity.getBedCnt02(), ""));
		indto.setBedCnt03(StringUtils.nvl(mainDataEntity.getKyokabyoshosuSeishin(), ""));
		indto.setBedCnt04(StringUtils.nvl(mainDataEntity.getKyokabyoshosuKekkaku(), ""));
		indto.setBedCnt05(StringUtils.nvl(mainDataEntity.getKyokabyoshosuKansen(), ""));
		indto.setBedCnt06(StringUtils.nvl(mainDataEntity.getBedCnt06(), ""));
		indto.setBedCnt07(StringUtils.nvl(mainDataEntity.getKyokabyoshosuRyoyo(), ""));
		indto.setBedsTot(StringUtils.nvl(mainDataEntity.getKyokabyoshosuSum(), ""));
		indto.setMedBedsTot(StringUtils.nvl(mainDataEntity.getMedBedsTot(), ""));
		indto.setEntcapaNum(StringUtils.nvl(mainDataEntity.getEntcapaNum(), ""));

		// ワクチン情報
		indto.setVacInsType(StringUtils.nvl(mainDataEntity.getVacInsType(), ""));
		indto.setVacVisitType(StringUtils.nvl(mainDataEntity.getVacVisitType(), ""));
		indto.setVacInsTypeNm(StringUtils.nvl(mainDataEntity.getVacInsTypeNm(), ""));
		indto.setVacVisitTypeNm(StringUtils.nvl(mainDataEntity.getVacVisitTypeNm(), ""));
		indto.setReqComment(StringUtils.nvl(mainDataEntity.getReqComment(), ""));
		indto.setAprComment(StringUtils.nvl(mainDataEntity.getAprComment(), ""));
		indto.setShnFlg(StringUtils.nvl(mainDataEntity.getShnFlg(), "0"));

		// 領域担当者リスト
		SelectHcoJkrDataEntity jkrParamEntity = new SelectHcoJkrDataEntity();
		jkrParamEntity.setInReqId(indto.getReqId());
		List<SelectHcoJkrDataEntity> jkrDataEntityList = dao.select(jkrParamEntity);
		for (SelectHcoJkrDataEntity sEntity : jkrDataEntityList) {
			if(sEntity != null) {
				HcoJkrData sData = new HcoJkrData();
				HcoJkrData sbData = new HcoJkrData();
				setHcoJkrData(sEntity,sData);
				setHcoJkrData(sEntity,sbData);
				hcoJkrDataList.add(sData);
				beforeHcoJkrDataList.add(sbData);
			}
		}
		indto.setHcoJkrDataList(hcoJkrDataList);
		indto.setBeforeHcoJkrDataList(beforeHcoJkrDataList);

		outdto.setForward("NC101");

		// END UOC
		return outdto;
    }

    /**
     * 数字ハイフンチェック
     */
    public static boolean isNumHyph(String s) {
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (!Character.isDigit(c) && !(c == '-')) {
                // 数字ハイフンでなければfalse
                return false;
            }
        }
        return true;
    }

    /**
     * 郵便番号形式チェック
     * @param pcode
     * @return
     */
    public static boolean chkPostcode(String pcode){
    	char Letter;

    	for(int i = 0; i < pcode.length(); i++ ){
    		Letter = pcode.charAt(i);
    		if(i == 3) {
    			if(Letter != '-'){
    			return false;
    			}
    		} else {
    			if(Letter < '0' || Letter > '9'){
    				return false;
    			}
    		}
    	}

    	return true;
	}

    /**
     * 数値範囲チェック
     * @return n = "", min <= n <= max ならtrue
     */
	public static boolean chkNumRange(String n, int min, int max){
		if(n == null || "".equals(n)){
			return true;
		} else if(!StringUtils.isNumeric(n)){
			return false;
		} else if(Integer.parseInt(n) >= min && Integer.parseInt(n) <= max){
			return true;
		}
		return false;
	}

	/**
	 * hcoJkrDataからDeleteFlg=1のデータを削除
	 */
	public static List<HcoJkrData> delDeleteFlgRow(List<HcoJkrData> hcoJkrDataList){
		int i = 0;
		int j = hcoJkrDataList.size();

		while(i < j) {
			if("1".equals(hcoJkrDataList.get(i).getDeleteFlg())) {
				hcoJkrDataList.remove(i);
				j--;
			} else {
				i++;
			}
		}

		return hcoJkrDataList;
	}
}
