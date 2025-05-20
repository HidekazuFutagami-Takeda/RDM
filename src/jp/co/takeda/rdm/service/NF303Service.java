/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import jp.co.takeda.rdm.dto.NF303DTO;
import jp.co.takeda.rdm.entity.join.MRdmComCalUsrEntity;
import jp.co.takeda.rdm.entity.join.MRdmParamMstEntity;
import jp.co.takeda.rdm.entity.join.SelectComboListEntity;
import jp.co.takeda.rdm.entity.join.SelectNF303MainDataEntity;
import jp.co.takeda.rdm.entity.join.SeqRdmReqIdEntity;
import jp.co.takeda.rdm.entity.join.TRdmHcoReqEntity;
import jp.co.takeda.rdm.entity.join.TRdmMMdbHcoMstEntity;
import jp.co.takeda.rdm.entity.join.TRdmReqKnrEntity;
import jp.co.takeda.rdm.util.DateUtils;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;

/**
 * Serviceクラス（NF303)
 * @generated
 */
@Named
public class NF303Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(NF303Service.class);

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
     * @param indto NF303DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(NF303DTO indto) {
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

        // 一時保存処理
        // レングスチェック
        if(indto.getInsAbbrName() != null && indto.getInsAbbrName().length() > 10) {
        	// 最大文字数を超えています。（施設略式漢字名）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "施設略式漢字名") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkSingleByte(indto.getInsAbbrName())) {
        	// 全角で入力してください。（施設略式漢字名）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W015).replace("項目名", "施設略式漢字名") + "\n";
			errFlg = true;
        }
        if(indto.getInsKana() != null && indto.getInsKana().length() > 15) {
        	// 最大文字数を超えています。（施設カナ名）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "施設カナ名") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getInsKana())) {
        	// 半角で入力してください。（施設カナ名）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "施設カナ名") + "\n";
			errFlg = true;
        }
        if(indto.getInsFormalName() != null && indto.getInsFormalName().length() > 40) {
        	// 最大文字数を超えています。（施設正式漢字名）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "施設正式漢字名") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkSingleByte(indto.getInsFormalName())) {
        	// 全角で入力してください。（施設正式漢字名）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W015).replace("項目名", "施設正式漢字名") + "\n";
			errFlg = true;
        }
        if(indto.getInsPcode() != null && indto.getInsPcode().length() > 8) {
        	// 最大文字数を超えています。（郵便番号）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "郵便番号") + "\n";
			errFlg = true;
        }
        if(!isNumHyph(indto.getInsPcode())) {
        	// 入力文字種が不正です。（郵便番号）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "郵便番号") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getInsPcode())) {
        	// 半角で入力してください。（郵便番号）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "郵便番号") + "\n";
			errFlg = true;
        }
        if(indto.getInsPcode() != null
        		&& ((indto.getInsPcode().length() != 0 && indto.getInsPcode().length() != 7 && indto.getInsPcode().length() != 8)
        		|| (indto.getInsPcode().length() == 8 && !chkPostcode(indto.getInsPcode())
        		|| (indto.getInsPcode().length() == 7 && !StringUtils.isNumeric(indto.getInsPcode()))))) {
        	// 正しい書式で入力してください。（郵便番号）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W016).replace("項目名", "郵便番号") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkSingleByte(indto.getInsAddrDt())) {
        	// 全角で入力してください。（町名地番）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W015).replace("項目名", "町名地番") + "\n";
			errFlg = true;
        }
        if(indto.getInsPhone1() != null && indto.getInsPhone1().length() > 13) {
        	// 最大文字数を超えています。（電話番号(代表)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "電話番号(代表)") + "\n";
			errFlg = true;
        }
        if(!isNumHyph(indto.getInsPhone1())) {
        	// 入力文字種が不正です。（電話番号(代表)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "電話番号(代表)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getInsPhone1())) {
        	// 半角で入力してください。（電話番号(代表)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "電話番号(代表)") + "\n";
			errFlg = true;
        }
        if("10".equals(indto.getInsSbt()) && !"00-0000-0000".equals(indto.getInsPhone1())) {
        	// 医療モールを新規作成する場合は「00-0000-0000」と入力してください。電話番号(代表)
			errMsg += loginInfo.getMsgData(RdmConstantsData.W017) + "\n";
			errFlg = true;
        }
        if(indto.getInsPhone2() != null && indto.getInsPhone2().length() > 13) {
        	// 最大文字数を超えています。（電話番号(薬局/DI室)）
        	errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "電話番号(薬局/DI室)") + "\n";
        	errFlg = true;
        }
        if(!isNumHyph(indto.getInsPhone2())) {
        	// 入力文字種が不正です。（電話番号(薬局/DI室)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "電話番号(薬局/DI室)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getInsPhone2())) {
        	// 半角で入力してください。（電話番号(薬局/DI室)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "電話番号(薬局/DI室)") + "\n";
			errFlg = true;
        }
        if(indto.getInsFax1() != null && indto.getInsFax1().length() > 13) {
        	// 最大文字数を超えています。（FAX番号(代表)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "FAX番号(代表)") + "\n";
			errFlg = true;
        }
        if(!isNumHyph(indto.getInsFax1())) {
        	// 入力文字種が不正です。（FAX番号(代表)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "FAX番号(代表)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getInsFax1())) {
        	// 半角で入力してください。（FAX番号(代表)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "FAX番号(代表)") + "\n";
			errFlg = true;
        }
        if(indto.getInsFax2() != null && indto.getInsFax2().length() > 13) {
        	// 最大文字数を超えています。（FAX番号(薬局/DI室)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "FAX番号(薬局/DI室)") + "\n";
			errFlg = true;
        }
        if(!isNumHyph(indto.getInsFax2())) {
        	// 入力文字種が不正です。（FAX番号(薬局/DI室)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "FAX番号(薬局/DI室)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getInsFax2())) {
        	// 半角で入力してください。（FAX番号(薬局/DI室)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "FAX番号(薬局/DI室)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getFree0001())) {
        	// 半角で入力してください。（DM先(TKP-LDA)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "DM先(TKP-LDA)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getFree0002())) {
        	// 半角で入力してください。（LEUあすか）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "LEUあすか") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getFree0003())) {
        	// 半角で入力してください。（DM先(TKP-NSAID)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "DM先(TKP-NSAID)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getFree0015())) {
        	// 半角で入力してください。（(O:未使用)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "(O:未使用)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getFree0008())) {
        	// 半角で入力してください。（TRIアロ登録(当期)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "TRIアロ登録(当期)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getFree0009())) {
        	// 半角で入力してください。（TRIアロ登録(来期)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "TRIアロ登録(来期)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getFree0004())) {
        	// 半角で入力してください。（REMアロ登録(当期)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "REMアロ登録(当期)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getFree0005())) {
        	// 半角で入力してください。（REMアロ登録(来期)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "REMアロ登録(来期)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getFree0006())) {
        	// 半角で入力してください。（ENBアロ登録(当期)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "ENBアロ登録(当期)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getFree0007())) {
        	// 半角で入力してください。（ENBアロ登録(来期)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "ENBアロ登録(来期)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getFree0010())) {
        	// 半角で入力してください。（XELアロ登録(当期)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "XELアロ登録(当期)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getFree0011())) {
        	// 半角で入力してください。（XELアロ登録(来期)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "XELアロ登録(来期)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getFree0013())) {
        	// 半角で入力してください。（ROZアロ登録(当期)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "ROZアロ登録(当期)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getFree0014())) {
        	// 半角で入力してください。（ROZアロ登録(来期)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "ROZアロ登録(来期)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getFree0012())) {
        	// 半角で入力してください。（振替先1310）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "振替先1310") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getUsercd0101())) {
        	// 半角で入力してください。（A(支店)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "A(支店)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getUsercd0102())) {
        	// 半角で入力してください。（B(支店)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "B(支店)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getUsercd0103())) {
        	// 半角で入力してください。（C(支店)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "C(支店)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getUsercd0104())) {
        	// 半角で入力してください。（D(支店)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "D(支店)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getUsercd0105())) {
        	// 半角で入力してください。（E(支店)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "E(支店)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getUsercd0106())) {
        	// 半角で入力してください。（F(支店)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "F(支店)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getUsercd0107())) {
        	// 半角で入力してください。（G(支店)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "G(支店)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getUsercd0108())) {
        	// 半角で入力してください。（H(支店)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "H(支店)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getUsercd0109())) {
        	// 半角で入力してください。（I(支店)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "I(支店)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getUsercd0201())) {
        	// 半角で入力してください。（A(営業所)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "A(営業所)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getUsercd0202())) {
        	// 半角で入力してください。（LEUターゲット先）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "LEUターゲット先") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getUsercd0203())) {
        	// 半角で入力してください。（C(営業所)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "C(営業所)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getUsercd0204())) {
        	// 半角で入力してください。（次期院長ターゲット先）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "次期院長ターゲット先") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getUsercd0205())) {
        	// 半角で入力してください。（E(営業所)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "E(営業所)") + "\n";
			errFlg = true;
        }
        if(StringUtils.checkMultiByte(indto.getUsercd0206())) {
        	// 半角で入力してください。（F:なんでもフォロー表）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "F:なんでもフォロー表") + "\n";
			errFlg = true;
        }
        if(indto.getReqComment() != null && StringUtils.getByteLength(indto.getReqComment()) > 300) {
        	// 最大文字数を超えています。（申請コメント）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "申請コメント") + "\n";
			errFlg = true;
        }

        // 内容が一か所も変更されていない場合
        if(chkEquals(indto.getInsAbbrName(),indto.getPreInsAbbrName()) &&
        		chkEquals(indto.getInsKana(),indto.getPreInsKana()) &&
        		chkEquals(indto.getInsFormalName(),indto.getPreInsFormalName()) &&
        		chkEquals(indto.getTradeType(),indto.getPreTradeType()) &&
        		chkEquals(indto.getInsOpenYear(),indto.getPreInsOpenYear()) &&
        		chkEquals(indto.getInsOpenMonth(),indto.getPreInsOpenMonth()) &&
        		chkEquals(indto.getInsOpenDay(),indto.getPreInsOpenDay()) &&
        		chkEquals(indto.getWsType(),indto.getPreWsType()) &&
        		chkEquals(indto.getBasketPurchase(),indto.getPreBasketPurchase()) &&
        		chkEquals(indto.getUnivSubdiv(),indto.getPreUnivSubdiv()) &&
        		chkEquals(indto.getCapaType(),indto.getPreCapaType()) &&
        		chkEquals(indto.getWsType(),indto.getPreWsType()) &&
        		chkEquals(indto.getUltInsCd(),indto.getPreUltInsCd()) &&
        		chkEquals(indto.getInsPcode(),indto.getPreInsPcode()) &&
        		chkEquals(indto.getAddrCodePref(),indto.getPreAddrCodePref()) &&
        		chkEquals(indto.getAddrCodeCity(),indto.getPreAddrCodeCity()) &&
        		chkEquals(indto.getInsAddrDt(),indto.getPreInsAddrDt()) &&
        		chkEquals(indto.getTkCityCd(),indto.getPreTkCityCd()) &&
        		chkEquals(indto.getInsPhone1(),indto.getPreInsPhone1()) &&
        		chkEquals(indto.getInsPhone2(),indto.getPreInsPhone2()) &&
        		chkEquals(indto.getInsFax1(),indto.getPreInsFax1()) &&
        		chkEquals(indto.getInsFax2(),indto.getPreInsFax2()) &&
        		chkEquals(indto.getInsUrl(),indto.getPreInsUrl()) &&
        		chkEquals(indto.getInsUrlYmd(),indto.getPreInsUrlYmd()) &&
        		chkEquals(indto.getFree0001(),indto.getPreFree0001()) &&
        		chkEquals(indto.getFree0002(),indto.getPreFree0002()) &&
        		chkEquals(indto.getFree0003(),indto.getPreFree0003()) &&
        		chkEquals(indto.getFree0015(),indto.getPreFree0015()) &&
        		chkEquals(indto.getFree0008(),indto.getPreFree0008()) &&
        		chkEquals(indto.getFree0009(),indto.getPreFree0009()) &&
        		chkEquals(indto.getFree0004(),indto.getPreFree0004()) &&
        		chkEquals(indto.getFree0005(),indto.getPreFree0005()) &&
        		chkEquals(indto.getFree0006(),indto.getPreFree0006()) &&
        		chkEquals(indto.getFree0007(),indto.getPreFree0007()) &&
        		chkEquals(indto.getFree0010(),indto.getPreFree0010()) &&
        		chkEquals(indto.getFree0011(),indto.getPreFree0011()) &&
        		chkEquals(indto.getFree0013(),indto.getPreFree0013()) &&
        		chkEquals(indto.getFree0014(),indto.getPreFree0014()) &&
        		chkEquals(indto.getFree0012(),indto.getPreFree0012()) &&
        		chkEquals(indto.getWelfare02(),indto.getPreWelfare02()) &&
        		chkEquals(indto.getWelfare08(),indto.getPreWelfare08()) &&
        		chkEquals(indto.getResult01(),indto.getPreResult01()) &&
        		chkEquals(indto.getResult02(),indto.getPreResult02()) &&
        		chkEquals(indto.getResult03(),indto.getPreResult03()) &&
        		chkEquals(indto.getResult04(),indto.getPreResult04()) &&
        		chkEquals(indto.getResult05(),indto.getPreResult05()) &&
        		chkEquals(indto.getResult06(),indto.getPreResult06()) &&
        		chkEquals(indto.getResult07(),indto.getPreResult07()) &&
        		chkEquals(indto.getResult08(),indto.getPreResult08()) &&
        		chkEquals(indto.getResult09(),indto.getPreResult09()) &&
        		chkEquals(indto.getResult10(),indto.getPreResult10()) &&
        		chkEquals(indto.getResult11(),indto.getPreResult11()) &&
        		chkEquals(indto.getResult12(),indto.getPreResult12()) &&
        		chkEquals(indto.getResult13(),indto.getPreResult13()) &&
        		chkEquals(indto.getResult14(),indto.getPreResult14()) &&
        		chkEquals(indto.getResult15(),indto.getPreResult15()) &&
        		chkEquals(indto.getResult16(),indto.getPreResult16()) &&
        		chkEquals(indto.getResult17(),indto.getPreResult17()) &&
        		chkEquals(indto.getResult18(),indto.getPreResult18()) &&
        		chkEquals(indto.getResult19(),indto.getPreResult19()) &&
        		chkEquals(indto.getResult20(),indto.getPreResult20()) &&
        		chkEquals(indto.getResult21(),indto.getPreResult21()) &&
        		chkEquals(indto.getResult22(),indto.getPreResult22()) &&
        		chkEquals(indto.getResult23(),indto.getPreResult23()) &&
        		chkEquals(indto.getResult24(),indto.getPreResult24()) &&
        		chkEquals(indto.getResult25(),indto.getPreResult25()) &&
        		chkEquals(indto.getResult26(),indto.getPreResult26()) &&
        		chkEquals(indto.getResult27(),indto.getPreResult27()) &&
        		chkEquals(indto.getResult28(),indto.getPreResult28()) &&
        		chkEquals(indto.getResult29(),indto.getPreResult29()) &&
        		chkEquals(indto.getResult30(),indto.getPreResult30()) &&
        		chkEquals(indto.getResult31(),indto.getPreResult31()) &&
        		chkEquals(indto.getResult32(),indto.getPreResult32()) &&
        		chkEquals(indto.getResult33(),indto.getPreResult33()) &&
        		chkEquals(indto.getResult34(),indto.getPreResult34()) &&
        		chkEquals(indto.getResult35(),indto.getPreResult35()) &&
        		chkEquals(indto.getResult36(),indto.getPreResult36()) &&
        		chkEquals(indto.getEquip01(),indto.getPreEquip01()) &&
        		chkEquals(indto.getEquip02(),indto.getPreEquip02()) &&
        		chkEquals(indto.getEquip03(),indto.getPreEquip03()) &&
        		chkEquals(indto.getEquip07(),indto.getPreEquip07()) &&
        		chkEquals(indto.getEquip09(),indto.getPreEquip09()) &&
        		chkEquals(indto.getMarket01(),indto.getPreMarket01()) &&
        		chkEquals(indto.getMarket02(),indto.getPreMarket02()) &&
        		chkEquals(indto.getMarket03(),indto.getPreMarket03()) &&
        		chkEquals(indto.getMarket04(),indto.getPreMarket04()) &&
        		chkEquals(indto.getMarket06(),indto.getPreMarket06()) &&
        		chkEquals(indto.getMarket07(),indto.getPreMarket07()) &&
        		chkEquals(indto.getMarket09(),indto.getPreMarket09()) &&
        		chkEquals(indto.getMedical12(),indto.getPreMedical12()) &&
        		chkEquals(indto.getSpfunc01(),indto.getPreSpfunc01()) &&
        		chkEquals(indto.getSpfunc03(),indto.getPreSpfunc03()) &&
        		chkEquals(indto.getSpfunc04(),indto.getPreSpfunc04()) &&
        		chkEquals(indto.getTieup10(),indto.getPreTieup10()) &&
        		chkEquals(indto.getTieup11(),indto.getPreTieup11()) &&
        		chkEquals(indto.getTieup12(),indto.getPreTieup12()) &&
        		chkEquals(indto.getUsercd0001(),indto.getPreUsercd0001()) &&
        		chkEquals(indto.getUsercd0002(),indto.getPreUsercd0002()) &&
        		chkEquals(indto.getUsercd0003(),indto.getPreUsercd0003()) &&
        		chkEquals(indto.getUsercd0004(),indto.getPreUsercd0004()) &&
        		chkEquals(indto.getUsercd0005(),indto.getPreUsercd0005()) &&
        		chkEquals(indto.getUsercd0006(),indto.getPreUsercd0006()) &&
        		chkEquals(indto.getUsercd0007(),indto.getPreUsercd0007()) &&
        		chkEquals(indto.getUsercd0008(),indto.getPreUsercd0008()) &&
        		chkEquals(indto.getUsercd0009(),indto.getPreUsercd0009()) &&
        		chkEquals(indto.getUsercd0010(),indto.getPreUsercd0010()) &&
        		chkEquals(indto.getUsercd0011(),indto.getPreUsercd0011()) &&
        		chkEquals(indto.getUsercd0012(),indto.getPreUsercd0012()) &&
        		chkEquals(indto.getUsercd0013(),indto.getPreUsercd0013()) &&
        		chkEquals(indto.getUsercd0014(),indto.getPreUsercd0014()) &&
        		chkEquals(indto.getUsercd0015(),indto.getPreUsercd0015()) &&
        		chkEquals(indto.getUsercd0016(),indto.getPreUsercd0016()) &&
        		chkEquals(indto.getUsercd0017(),indto.getPreUsercd0017()) &&
        		chkEquals(indto.getUsercd0018(),indto.getPreUsercd0018()) &&
        		chkEquals(indto.getUsercd0019(),indto.getPreUsercd0019()) &&
        		chkEquals(indto.getUsercd0020(),indto.getPreUsercd0020()) &&
        		chkEquals(indto.getUsercd0021(),indto.getPreUsercd0021()) &&
        		chkEquals(indto.getUsercd0022(),indto.getPreUsercd0022()) &&
        		chkEquals(indto.getUsercd0023(),indto.getPreUsercd0023()) &&
        		chkEquals(indto.getUsercd0024(),indto.getPreUsercd0024()) &&
        		chkEquals(indto.getUsercd0025(),indto.getPreUsercd0025()) &&
        		chkEquals(indto.getUsercd0026(),indto.getPreUsercd0026()) &&
        		chkEquals(indto.getUsercd0027(),indto.getPreUsercd0027()) &&
        		chkEquals(indto.getUsercd0028(),indto.getPreUsercd0028()) &&
        		chkEquals(indto.getUsercd0029(),indto.getPreUsercd0029()) &&
        		chkEquals(indto.getUsercd0030(),indto.getPreUsercd0030()) &&
        		chkEquals(indto.getUsercd0031(),indto.getPreUsercd0031()) &&
        		chkEquals(indto.getUsercd0032(),indto.getPreUsercd0032()) &&
        		chkEquals(indto.getUsercd0033(),indto.getPreUsercd0033()) &&
        		chkEquals(indto.getUsercd0034(),indto.getPreUsercd0034()) &&
        		chkEquals(indto.getUsercd0035(),indto.getPreUsercd0035()) &&
        		chkEquals(indto.getUsercd0036(),indto.getPreUsercd0036()) &&
        		chkEquals(indto.getUsercd0101(),indto.getPreUsercd0101()) &&
        		chkEquals(indto.getUsercd0102(),indto.getPreUsercd0102()) &&
        		chkEquals(indto.getUsercd0103(),indto.getPreUsercd0103()) &&
        		chkEquals(indto.getUsercd0104(),indto.getPreUsercd0104()) &&
        		chkEquals(indto.getUsercd0105(),indto.getPreUsercd0105()) &&
        		chkEquals(indto.getUsercd0106(),indto.getPreUsercd0106()) &&
        		chkEquals(indto.getUsercd0107(),indto.getPreUsercd0107()) &&
        		chkEquals(indto.getUsercd0108(),indto.getPreUsercd0108()) &&
        		chkEquals(indto.getUsercd0109(),indto.getPreUsercd0109()) &&
        		chkEquals(indto.getUsercd0201(),indto.getPreUsercd0201()) &&
        		chkEquals(indto.getUsercd0202(),indto.getPreUsercd0202()) &&
        		chkEquals(indto.getUsercd0203(),indto.getPreUsercd0203()) &&
        		chkEquals(indto.getUsercd0204(),indto.getPreUsercd0204()) &&
        		chkEquals(indto.getUsercd0205(),indto.getPreUsercd0205()) &&
        		chkEquals(indto.getUsercd0206(),indto.getPreUsercd0206()) &&
        		chkEquals(indto.getReward04(),indto.getPreReward04()) &&
        		chkEquals(indto.getReward05(),indto.getPreReward05()) &&
        		chkEquals(indto.getReward08(),indto.getPreReward08()) &&
        		chkEquals(indto.getReward09(),indto.getPreReward09()) &&
        		chkEquals(indto.getReward18(),indto.getPreReward18()) &&
        		chkEquals(indto.getReward21(),indto.getPreReward21()) &&
        		chkEquals(indto.getReward23(),indto.getPreReward23()) &&
        		chkEquals(indto.getReward25(),indto.getPreReward25()) &&
        		chkEquals(indto.getReward26(),indto.getPreReward26()) &&
        		chkEquals(indto.getReward27(),indto.getPreReward27()) &&
        		chkEquals(indto.getReward29(),indto.getPreReward29()) &&
        		chkEquals(indto.getReward35(),indto.getPreReward35()) &&
        		chkEquals(indto.getReward36(),indto.getPreReward36()) &&
        		chkEquals(indto.getReward37(),indto.getPreReward37()) &&
        		chkEquals(indto.getReward44(),indto.getPreReward44()) &&
        		chkEquals(indto.getReward16(),indto.getPreReward16()) &&
        		chkEquals(indto.getReward17(),indto.getPreReward17())) {
        	// 施設情報が変更されていません。
			errMsg += loginInfo.getMsgData(RdmConstantsData.W066) + "\n";
        	errFlg = true;
        }

        // 最終更新日時が、画面OPEN時とボタン押下時で異なっていた場合
        if(indto.getUpdShaYmd() != null && !indto.getUpdShaYmd().equals("")) {
        	TRdmReqKnrEntity tRdmReqKnrChkEntity = new TRdmReqKnrEntity("selectNF011DateChkData");
        	tRdmReqKnrChkEntity.setReqId(reqId);

        	List<TRdmReqKnrEntity> tRdmReqKnrEntityList = dao.select(tRdmReqKnrChkEntity);

        	if(tRdmReqKnrEntityList.size() > 0) {
        		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMddHHmmss");
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

        // 整合性チェック
        // 紐づいているULT施設が削除済みだった場合
        TRdmMMdbHcoMstEntity tRdmMMdbHcoMstchkEntity = new TRdmMMdbHcoMstEntity("selectNF012InsDelChkData");
        tRdmMMdbHcoMstchkEntity.setInsNo(indto.getInsNo());
        List<TRdmHcoReqEntity> tRdmMMdbHcoMstchkEntityList = dao.select(tRdmMMdbHcoMstchkEntity);

        if(tRdmMMdbHcoMstchkEntityList.size() > 0) {
        	// 接続対象のULT施設が削除されています。
        	errMsg += loginInfo.getMsgData(RdmConstantsData.W020) + "\n";
        	errFlg = true;

        }

        // 開業年月日：年月日の値が存在しない日付だった場合
        if(indto.getInsOpenYear() != null && !indto.getInsOpenYear().equals("")
        		&& indto.getInsOpenMonth() != null && !indto.getInsOpenMonth().equals("")
        		&& indto.getInsOpenDay() != null && !indto.getInsOpenDay().equals("")) {
	        StringBuilder sbDate = new StringBuilder();
	        sbDate.append(indto.getInsOpenYear());
	        sbDate.append(indto.getInsOpenMonth());
	        sbDate.append(indto.getInsOpenDay());
	        String date = sbDate.toString();
	        if(!DateUtils.isDate(date)) {
	        	// 有効な年月日を入力してください。（開業年月日）
	        	errMsg += loginInfo.getMsgData(RdmConstantsData.W022).replace("項目名", "開業年月日") + "\n";
	        	errFlg = true;
	        }
        }

        // エラー時処理
        if(errFlg) {
        	String title = "NF012_施設情報更新";
            indto.setTitle(title);
        	indto.setMsgStr(errMsg);
        	outdto.setForward("NF012");
        	return outdto;
        }

        // 開業年月日表示設定
        StringBuilder sbYmd = new StringBuilder();
		if(!StringUtils.isEmpty(indto.getInsOpenYear())) {
			sbYmd.append(indto.getInsOpenYear());
			sbYmd.append("年");
		}
		if(!StringUtils.isEmpty(indto.getInsOpenMonth())) {
			sbYmd.append(indto.getInsOpenMonth());
			sbYmd.append("月");
		}
		if(!StringUtils.isEmpty(indto.getInsOpenDay())) {
			sbYmd.append(indto.getInsOpenDay());
			sbYmd.append("日");
		}

		String insOpenYmd = sbYmd.toString();

		indto.setInsOpenYmd(insOpenYmd);

		// ホームページアドレス更新日表示設定
		indto.setInsUrlYmd(indto.getInsUrlYmd().replace("-","/"));

		// 郵便番号表示設定
		String insPcode = indto.getInsPcode();
		if(insPcode.length() == 7) {
			insPcode = insPcode.substring(0,3) + "-"
								+ insPcode.substring(3);
		}
		indto.setInsPcode(insPcode);

		if(indto.getUnivSubdiv() == null) {
			indto.setUnivSubdiv("");
		}

		// 申請ボタン活性フラグ取得
		indto.setBtnEnableFlg("0");
		MRdmParamMstEntity mRdmParamMstEntity = new MRdmParamMstEntity();
		mRdmParamMstEntity.setParamName("MN_FAC");
		mRdmParamMstEntity.setDelFlg("0");

		List<MRdmParamMstEntity> mRdmParamMstEntityList = dao.selectByValue(mRdmParamMstEntity);
		if(mRdmParamMstEntityList.size() > 0) {
			// valueの左から二桁目
			String value = mRdmParamMstEntityList.get(0).getValue().substring(1,2);
			if("1".equals(value)) {
				// 申請ボタン活性
				indto.setBtnEnableFlg("1");
			}
		}

        // END UOC
		outdto.setForward("NF303");
        return outdto;
    }

    /**
     * コンボ作成
     * @param indto NF303DTO
     * @return なし
     * @customizable
     */
    private void createCombo(NF303DTO indto){
        // 取引区分
        SelectComboListEntity inEntityCmb = new SelectComboListEntity();
    	inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_TRADE_TYPE);
    	List<SelectComboListEntity> outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapTradeType = new LinkedHashMap<String, String>();
		mapTradeType.put("", "--選択してください--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapTradeType.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setTradeTypeCombo(mapTradeType);

		// 卸色区分
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_WS_TYPE);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapWsType = new LinkedHashMap<String, String>();
		mapWsType.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapWsType.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setWsTypeCombo(mapWsType);

		// 本部一括購入
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_BASKET_PURCHASE);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapBasketPurchase = new LinkedHashMap<String, String>();
		mapBasketPurchase.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapBasketPurchase.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setBasketPurchaseCombo(mapBasketPurchase);

		// 大学細分類
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_UNIV_SUBDIV);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUnivSubdiv = new LinkedHashMap<String, String>();
		mapUnivSubdiv.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUnivSubdiv.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUnivSubdivCombo(mapUnivSubdiv);

		// 容量別実績把握病院区分
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_CAPA_TYPE);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapCapaType = new LinkedHashMap<String, String>();
		mapCapaType.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapCapaType.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setCapaTypeCombo(mapCapaType);

		// 老人福祉法関連分類情報
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_WELFARE_LIST);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapWelfareList = new LinkedHashMap<String, String>();
		mapWelfareList.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapWelfareList.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setWelfare02Combo(mapWelfareList);
		indto.setWelfare08Combo(mapWelfareList);

		// 実績把握区分情報
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT_LIST);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResultList = new LinkedHashMap<String, String>();
		mapResultList.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResultList.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult01Combo(mapResultList);
		indto.setResult02Combo(mapResultList);
		indto.setResult03Combo(mapResultList);
		indto.setResult04Combo(mapResultList);
		indto.setResult05Combo(mapResultList);
		indto.setResult06Combo(mapResultList);
		indto.setResult07Combo(mapResultList);
		indto.setResult08Combo(mapResultList);
		indto.setResult09Combo(mapResultList);
		indto.setResult10Combo(mapResultList);
		indto.setResult11Combo(mapResultList);
		indto.setResult12Combo(mapResultList);
		indto.setResult13Combo(mapResultList);
		indto.setResult14Combo(mapResultList);
		indto.setResult15Combo(mapResultList);
		indto.setResult16Combo(mapResultList);
		indto.setResult17Combo(mapResultList);
		indto.setResult18Combo(mapResultList);
		indto.setResult19Combo(mapResultList);
		indto.setResult20Combo(mapResultList);
		indto.setResult21Combo(mapResultList);
		indto.setResult22Combo(mapResultList);
		indto.setResult23Combo(mapResultList);
		indto.setResult24Combo(mapResultList);
		indto.setResult25Combo(mapResultList);
		indto.setResult26Combo(mapResultList);
		indto.setResult27Combo(mapResultList);
		indto.setResult28Combo(mapResultList);
		indto.setResult29Combo(mapResultList);
		indto.setResult30Combo(mapResultList);
		indto.setResult31Combo(mapResultList);
		indto.setResult32Combo(mapResultList);
		indto.setResult33Combo(mapResultList);
		indto.setResult34Combo(mapResultList);
		indto.setResult35Combo(mapResultList);
		indto.setResult36Combo(mapResultList);

		// 病院設備情報
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_EQUIP_LIST);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapEquipList = new LinkedHashMap<String, String>();
		mapEquipList.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapEquipList.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setEquip01Combo(mapEquipList);
		indto.setEquip02Combo(mapEquipList);
		indto.setEquip03Combo(mapEquipList);
		indto.setEquip07Combo(mapEquipList);
		indto.setEquip09Combo(mapEquipList);

		// Ｔ先
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_MARKET01);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapMarket01 = new LinkedHashMap<String, String>();
		mapMarket01.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapMarket01.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setMarket01Combo(mapMarket01);

		// 市場規模情報
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_MARKET_LIST);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapMarketList = new LinkedHashMap<String, String>();
		mapMarketList.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapMarketList.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setMarket02Combo(mapMarketList);
		indto.setMarket03Combo(mapMarketList);
		indto.setMarket04Combo(mapMarketList);
		indto.setMarket06Combo(mapMarketList);
		indto.setMarket07Combo(mapMarketList);
		indto.setMarket09Combo(mapMarketList);

		// 社会医療法人
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_MEDICAL_LIST);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapMedicalList = new LinkedHashMap<String, String>();
		mapMedicalList.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapMedicalList.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setMedical12Combo(mapMedicalList);

		// 特別な機能情報
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_SPFUNC_LIST);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapSpFuncList = new LinkedHashMap<String, String>();
		mapSpFuncList.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapSpFuncList.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setSpfunc01Combo(mapSpFuncList);
		indto.setSpfunc04Combo(mapSpFuncList);

		// 救命救急センター
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_SPFUNC03);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapSpFunc03 = new LinkedHashMap<String, String>();
		mapSpFunc03.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapSpFunc03.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setSpfunc03Combo(mapSpFunc03);

		// 医療連携関係情報
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_TIEUP_LIST);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapTieupList = new LinkedHashMap<String, String>();
		mapTieupList.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapTieupList.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setTieup10Combo(mapTieupList);
		indto.setTieup11Combo(mapTieupList);
		indto.setTieup12Combo(mapTieupList);

		// ユーザーコード情報
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD_LIST);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercdList = new LinkedHashMap<String, String>();
		mapUsercdList.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercdList.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0001Combo(mapUsercdList);
		indto.setUsercd0002Combo(mapUsercdList);
		indto.setUsercd0003Combo(mapUsercdList);
		indto.setUsercd0004Combo(mapUsercdList);
		indto.setUsercd0005Combo(mapUsercdList);
		indto.setUsercd0006Combo(mapUsercdList);
		indto.setUsercd0007Combo(mapUsercdList);
		indto.setUsercd0008Combo(mapUsercdList);
		indto.setUsercd0009Combo(mapUsercdList);
		indto.setUsercd0010Combo(mapUsercdList);
		indto.setUsercd0011Combo(mapUsercdList);
		indto.setUsercd0012Combo(mapUsercdList);
		indto.setUsercd0013Combo(mapUsercdList);
		indto.setUsercd0014Combo(mapUsercdList);
		indto.setUsercd0015Combo(mapUsercdList);
		indto.setUsercd0016Combo(mapUsercdList);
		indto.setUsercd0017Combo(mapUsercdList);
		indto.setUsercd0018Combo(mapUsercdList);
		indto.setUsercd0019Combo(mapUsercdList);
		indto.setUsercd0020Combo(mapUsercdList);
		indto.setUsercd0021Combo(mapUsercdList);
		indto.setUsercd0022Combo(mapUsercdList);
		indto.setUsercd0023Combo(mapUsercdList);
		indto.setUsercd0024Combo(mapUsercdList);
		indto.setUsercd0025Combo(mapUsercdList);
		indto.setUsercd0026Combo(mapUsercdList);
		indto.setUsercd0027Combo(mapUsercdList);
		indto.setUsercd0028Combo(mapUsercdList);
		indto.setUsercd0029Combo(mapUsercdList);
		indto.setUsercd0030Combo(mapUsercdList);
		indto.setUsercd0031Combo(mapUsercdList);
		indto.setUsercd0032Combo(mapUsercdList);
		indto.setUsercd0033Combo(mapUsercdList);
		indto.setUsercd0034Combo(mapUsercdList);
		indto.setUsercd0035Combo(mapUsercdList);
		indto.setUsercd0036Combo(mapUsercdList);

		// 診療報酬情報
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_REWARD_LIST);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapRewardList = new LinkedHashMap<String, String>();
		mapRewardList.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapRewardList.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setReward04Combo(mapRewardList);
		indto.setReward05Combo(mapRewardList);
		indto.setReward08Combo(mapRewardList);
		indto.setReward09Combo(mapRewardList);
		indto.setReward18Combo(mapRewardList);
		indto.setReward23Combo(mapRewardList);
		indto.setReward25Combo(mapRewardList);
		indto.setReward26Combo(mapRewardList);
		indto.setReward35Combo(mapRewardList);
		indto.setReward36Combo(mapRewardList);
		indto.setReward37Combo(mapRewardList);
		indto.setReward44Combo(mapRewardList);
		indto.setReward16Combo(mapRewardList);
		indto.setReward17Combo(mapRewardList);

		// 短期滞在手術基本料
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_REWARD21);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapReward21 = new LinkedHashMap<String, String>();
		mapReward21.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapReward21.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setReward21Combo(mapReward21);

		// 看護配置（有床診療所）
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_REWARD27);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapReward27 = new LinkedHashMap<String, String>();
		mapReward27.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapReward27.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setReward27Combo(mapReward27);

		// 老人入院基本料
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_REWARD29);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapReward29 = new LinkedHashMap<String, String>();
		mapReward29.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapReward29.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setReward29Combo(mapReward29);

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
    }

    /**
     * イベント処理
     * @param indto NF303DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO register(NF303DTO indto) {
        BaseDTO outdto = indto;
        // START UOC
        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
        outdto.setForward("NF303");

        // 現在日付を取得
        Date systemDate = DateUtils.getNowDate();
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
        String sysDate = fmtDate.format(systemDate);
        SimpleDateFormat fmtDateTime = new SimpleDateFormat("yyyyMMddHHmmss");
        String sysDateTime = fmtDateTime.format(systemDate);

        boolean errFlg = false;
        String errMsg = "";

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
        		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMddHHmmss");
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
        boolean knr = RdmConstantsData.RDM_JKN_ADMIN.equals(indto.getLoginJokenSetCd());

        if(tRdmReqKnrData == null) {
        	// 新規登録
        	// 新規にIDを取得
        	SeqRdmReqIdEntity seqRdmReqIdEntity = new SeqRdmReqIdEntity();
        	List<SeqRdmReqIdEntity> seqRdmReqIdDate = dao.select(seqRdmReqIdEntity);
        	reqId = seqRdmReqIdDate.get(0).getReqId();

        	// レコードを登録
        	TRdmReqKnrEntity tRdmReqKnrInsData = new TRdmReqKnrEntity();
        	tRdmReqKnrInsData.setReqId(reqId);
        	if(knr) {
        		// 承認者（管理者権限）が申請の場合、'2'(DSG起因)
        		tRdmReqKnrInsData.setReqChl("2");
        		tRdmReqKnrInsData.setReqKngKbn("2");
        	} else {
        		// "MRが申請の場合、'1'(MR起因)
        		tRdmReqKnrInsData.setReqChl("1");
        		tRdmReqKnrInsData.setReqKngKbn("1");
        	}
        	tRdmReqKnrInsData.setReqType("02");

        	if("1".equals(indto.getFuncId())) {
        		// 申請
        		tRdmReqKnrInsData.setReqStsCd("03");
        		tRdmReqKnrInsData.setReqBrCd(indto.getReqBrCd());
            	tRdmReqKnrInsData.setReqDistCd(indto.getReqDistCd());
            	tRdmReqKnrInsData.setReqShzNm(indto.getReqShzNm());
            	tRdmReqKnrInsData.setReqJgiNo(indto.getReqJgiNo());
            	tRdmReqKnrInsData.setReqJgiName(indto.getReqJgiName());
            	tRdmReqKnrInsData.setReqYmdhms(sysDateTime);
            	tRdmReqKnrInsData.setReqComment(indto.getReqComment());
        	} else if("2".equals(indto.getFuncId())) {
        		// 承認
        		tRdmReqKnrInsData.setReqStsCd("04");
        		tRdmReqKnrInsData.setAprBrCode(indto.getLoginBrCd());
            	tRdmReqKnrInsData.setAprDistCode(indto.getLoginDistCd());
            	tRdmReqKnrInsData.setAprShz(indto.getLoginShzNm());
            	tRdmReqKnrInsData.setAprJgiNo(Integer.parseInt(indto.getLoginJgiNo()));
            	tRdmReqKnrInsData.setAprShaName(indto.getLoginNm());
            	tRdmReqKnrInsData.setAprYmdhms(sysDateTime);
            	tRdmReqKnrInsData.setAprComment(indto.getAprComment());
            	if("on".equals(indto.getFbReqFlg())) {
            		tRdmReqKnrInsData.setFbReqFlg("1");
            	} else {
            		tRdmReqKnrInsData.setFbReqFlg("0");
            	}

        	} else {
        		// 却下
        		tRdmReqKnrInsData.setReqStsCd("02");
        		tRdmReqKnrInsData.setAprBrCode(indto.getLoginBrCd());
            	tRdmReqKnrInsData.setAprDistCode(indto.getLoginDistCd());
            	tRdmReqKnrInsData.setAprShz(indto.getLoginShzNm());
            	tRdmReqKnrInsData.setAprJgiNo(Integer.parseInt(indto.getLoginJgiNo()));
            	tRdmReqKnrInsData.setAprShaName(indto.getLoginNm());
            	tRdmReqKnrInsData.setAprYmdhms(sysDateTime);
            	tRdmReqKnrInsData.setAprComment(indto.getAprComment());
            	tRdmReqKnrInsData.setFbReqFlg("0");
        	}

        	tRdmReqKnrInsData.setInsNo(indto.getInsNo());
        	tRdmReqKnrInsData.setInsShaYmd(systemDate);
        	tRdmReqKnrInsData.setInsShaId(indto.getLoginJgiNo());
        	tRdmReqKnrInsData.setUpdShaYmd(systemDate);
        	tRdmReqKnrInsData.setUpdShaId(indto.getLoginJgiNo());

        	dao.insertByValue(tRdmReqKnrInsData);

        } else {
        	// 更新
        	TRdmReqKnrEntity tRdmReqKnrUpdData = new TRdmReqKnrEntity("updateNF303Data");
        	tRdmReqKnrUpdData.setReqId(reqId);

        	if("1".equals(indto.getFuncId())) {
        		// 申請
            	if("1".equals(indto.getReqChl()) || "2".equals(indto.getReqChl())) {
    				tRdmReqKnrUpdData.setReqStsCd("03");
    			} else if("3".equals(indto.getReqChl())) {
    				tRdmReqKnrUpdData.setReqStsCd("13");
    			}
        		tRdmReqKnrUpdData.setReqBrCd(indto.getReqBrCd());
            	tRdmReqKnrUpdData.setReqDistCd(indto.getReqDistCd());
            	tRdmReqKnrUpdData.setReqShzNm(indto.getReqShzNm());
            	tRdmReqKnrUpdData.setReqJgiNo(indto.getReqJgiNo());
            	tRdmReqKnrUpdData.setReqJgiName(indto.getReqJgiName());
            	tRdmReqKnrUpdData.setReqYmdhms(sysDateTime);
            	tRdmReqKnrUpdData.setReqComment(indto.getReqComment());

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

        	} else {
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
            	tRdmReqKnrUpdData.setFbReqFlg("0");
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

        if(tRdmHcoReqData == null) {
        	// 新規登録
        	TRdmHcoReqEntity tRdmHcoReqInsData = new TRdmHcoReqEntity();
        	tRdmHcoReqInsData.setReqId(reqId);
        	tRdmHcoReqInsData.setInsNo(indto.getInsNo());

        	tRdmHcoReqInsData.setInsKana(getUpdValue(indto.getPreInsKana(), indto.getInsKana()));
        	tRdmHcoReqInsData.setInsAbbrName(getUpdValue(indto.getPreInsAbbrName(), indto.getInsAbbrName()));
        	tRdmHcoReqInsData.setInsFormalName(getUpdValue(indto.getPreInsFormalName(), indto.getInsFormalName()));

        	String insPcode = getUpdValue(indto.getInsPcode());
        	if(insPcode != null) {
        		insPcode = insPcode.replace("-", "");
        	}
        	String preInsPcode = getUpdValue(indto.getPreInsPcode());
        	if(preInsPcode != null) {
        		preInsPcode = preInsPcode.replace("-", "");
        	}
        	tRdmHcoReqInsData.setInsPcode(getUpdValue(preInsPcode, insPcode));
        	tRdmHcoReqInsData.setAddrCodePref(getUpdValue(indto.getPreAddrCodePref(), indto.getAddrCodePref()));
        	tRdmHcoReqInsData.setAddrCodeCity(getUpdValue(indto.getPreAddrCodeCity(), indto.getAddrCodeCity()));
        	tRdmHcoReqInsData.setTkCityCd(getUpdValue(indto.getPreTkCityCd(), indto.getTkCityCd()));
        	tRdmHcoReqInsData.setInsAddrDt(getUpdValue(indto.getPreInsAddrDt(), indto.getInsAddrDt()));
        	tRdmHcoReqInsData.setInsAddr(getUpdValue(indto.getPreInsAddr(), indto.getInsAddr()));
        	tRdmHcoReqInsData.setInsAddrKana(getUpdValue(indto.getPreInsAddrKana(), indto.getInsAddrKana()));
        	tRdmHcoReqInsData.setInsPhone1(getUpdValue(indto.getPreInsPhone1(), indto.getInsPhone1()));
        	tRdmHcoReqInsData.setInsFax1(getUpdValue(indto.getPreInsFax1(), indto.getInsFax1()));
        	tRdmHcoReqInsData.setInsPhone2(getUpdValue(indto.getPreInsPhone2(), indto.getInsPhone2()));
        	tRdmHcoReqInsData.setInsFax2(getUpdValue(indto.getPreInsFax2(), indto.getInsFax2()));
        	tRdmHcoReqInsData.setInsUrl(getUpdValue(indto.getPreInsUrl(), indto.getInsUrl()));

        	String preUrlYmd = indto.getPreInsUrlYmd();
        	String urlYmd = indto.getInsUrlYmd();
        	if(preUrlYmd != null) {
        		preUrlYmd = preUrlYmd.replace("/", "");
        	}
        	if(urlYmd != null) {
        		urlYmd = urlYmd.replace("/", "");
        	}
        	tRdmHcoReqInsData.setInsUrlYmd(getUpdValue(preUrlYmd, urlYmd));

        	tRdmHcoReqInsData.setWsType(getUpdValue(indto.getPreWsType(), indto.getWsType()));
        	tRdmHcoReqInsData.setTradeType(getUpdValue(indto.getPreTradeType(), indto.getTradeType()));
        	tRdmHcoReqInsData.setBasketPurchase(getUpdValue(indto.getPreBasketPurchase(), indto.getBasketPurchase()));
        	tRdmHcoReqInsData.setUnivSubdiv(getUpdValue(indto.getPreUnivSubdiv(), indto.getUnivSubdiv()));
        	tRdmHcoReqInsData.setInsOpenYear(getUpdValue(indto.getPreInsOpenYear(), indto.getInsOpenYear()));
        	tRdmHcoReqInsData.setInsOpenMonth(getUpdValue(indto.getPreInsOpenMonth(), indto.getInsOpenMonth()));
        	tRdmHcoReqInsData.setInsOpenDay(getUpdValue(indto.getPreInsOpenDay(), indto.getInsOpenDay()));
        	tRdmHcoReqInsData.setCapaType(getUpdValue(indto.getPreCapaType(), indto.getCapaType()));

        	if(knr) {
        		tRdmHcoReqInsData.setUltInsNo(getUpdValue(indto.getPreUltInsCd(), indto.getUltInsCd()));

        		tRdmHcoReqInsData.setFree0001(getUpdValue(indto.getPreFree0001(), indto.getFree0001()));
	        	tRdmHcoReqInsData.setFree0002(getUpdValue(indto.getPreFree0002(), indto.getFree0002()));
	        	tRdmHcoReqInsData.setFree0003(getUpdValue(indto.getPreFree0003(), indto.getFree0003()));
	        	tRdmHcoReqInsData.setFree0004(getUpdValue(indto.getPreFree0004(), indto.getFree0004()));
	        	tRdmHcoReqInsData.setFree0005(getUpdValue(indto.getPreFree0005(), indto.getFree0005()));
	        	tRdmHcoReqInsData.setFree0006(getUpdValue(indto.getPreFree0006(), indto.getFree0006()));
	        	tRdmHcoReqInsData.setFree0007(getUpdValue(indto.getPreFree0007(), indto.getFree0007()));
	        	tRdmHcoReqInsData.setFree0008(getUpdValue(indto.getPreFree0008(), indto.getFree0008()));
	        	tRdmHcoReqInsData.setFree0009(getUpdValue(indto.getPreFree0009(), indto.getFree0009()));
	        	tRdmHcoReqInsData.setFree0010(getUpdValue(indto.getPreFree0010(), indto.getFree0010()));
	        	tRdmHcoReqInsData.setFree0011(getUpdValue(indto.getPreFree0011(), indto.getFree0011()));
	        	tRdmHcoReqInsData.setFree0012(getUpdValue(indto.getPreFree0012(), indto.getFree0012()));
	        	tRdmHcoReqInsData.setFree0013(getUpdValue(indto.getPreFree0013(), indto.getFree0013()));
	        	tRdmHcoReqInsData.setFree0014(getUpdValue(indto.getPreFree0014(), indto.getFree0014()));
	        	tRdmHcoReqInsData.setFree0015(getUpdValue(indto.getPreFree0015(), indto.getFree0015()));

	        	tRdmHcoReqInsData.setWelfare02(getUpdValue(indto.getPreWelfare02(), indto.getWelfare02()));
	        	tRdmHcoReqInsData.setWelfare08(getUpdValue(indto.getPreWelfare08(), indto.getWelfare08()));

	        	tRdmHcoReqInsData.setResult01(getUpdValue(indto.getPreResult01(), indto.getResult01()));
	        	tRdmHcoReqInsData.setResult02(getUpdValue(indto.getPreResult02(), indto.getResult02()));
	        	tRdmHcoReqInsData.setResult03(getUpdValue(indto.getPreResult03(), indto.getResult03()));
	        	tRdmHcoReqInsData.setResult04(getUpdValue(indto.getPreResult04(), indto.getResult04()));
	        	tRdmHcoReqInsData.setResult05(getUpdValue(indto.getPreResult05(), indto.getResult05()));
	        	tRdmHcoReqInsData.setResult06(getUpdValue(indto.getPreResult06(), indto.getResult06()));
	        	tRdmHcoReqInsData.setResult07(getUpdValue(indto.getPreResult07(), indto.getResult07()));
	        	tRdmHcoReqInsData.setResult08(getUpdValue(indto.getPreResult08(), indto.getResult08()));
	        	tRdmHcoReqInsData.setResult09(getUpdValue(indto.getPreResult09(), indto.getResult09()));
	        	tRdmHcoReqInsData.setResult10(getUpdValue(indto.getPreResult10(), indto.getResult10()));
	        	tRdmHcoReqInsData.setResult11(getUpdValue(indto.getPreResult11(), indto.getResult11()));
	        	tRdmHcoReqInsData.setResult12(getUpdValue(indto.getPreResult12(), indto.getResult12()));
	        	tRdmHcoReqInsData.setResult13(getUpdValue(indto.getPreResult13(), indto.getResult13()));
	        	tRdmHcoReqInsData.setResult14(getUpdValue(indto.getPreResult14(), indto.getResult14()));
	        	tRdmHcoReqInsData.setResult15(getUpdValue(indto.getPreResult15(), indto.getResult15()));
	        	tRdmHcoReqInsData.setResult16(getUpdValue(indto.getPreResult16(), indto.getResult16()));
	        	tRdmHcoReqInsData.setResult17(getUpdValue(indto.getPreResult17(), indto.getResult17()));
	        	tRdmHcoReqInsData.setResult18(getUpdValue(indto.getPreResult18(), indto.getResult18()));
	        	tRdmHcoReqInsData.setResult19(getUpdValue(indto.getPreResult19(), indto.getResult19()));
	        	tRdmHcoReqInsData.setResult20(getUpdValue(indto.getPreResult20(), indto.getResult20()));
	        	tRdmHcoReqInsData.setResult21(getUpdValue(indto.getPreResult21(), indto.getResult21()));
	        	tRdmHcoReqInsData.setResult22(getUpdValue(indto.getPreResult22(), indto.getResult22()));
	        	tRdmHcoReqInsData.setResult23(getUpdValue(indto.getPreResult23(), indto.getResult23()));
	        	tRdmHcoReqInsData.setResult24(getUpdValue(indto.getPreResult24(), indto.getResult24()));
	        	tRdmHcoReqInsData.setResult25(getUpdValue(indto.getPreResult25(), indto.getResult25()));
	        	tRdmHcoReqInsData.setResult26(getUpdValue(indto.getPreResult26(), indto.getResult26()));
	        	tRdmHcoReqInsData.setResult27(getUpdValue(indto.getPreResult27(), indto.getResult27()));
	        	tRdmHcoReqInsData.setResult28(getUpdValue(indto.getPreResult28(), indto.getResult28()));
	        	tRdmHcoReqInsData.setResult29(getUpdValue(indto.getPreResult29(), indto.getResult29()));
	        	tRdmHcoReqInsData.setResult30(getUpdValue(indto.getPreResult30(), indto.getResult30()));
	        	tRdmHcoReqInsData.setResult31(getUpdValue(indto.getPreResult31(), indto.getResult31()));
	        	tRdmHcoReqInsData.setResult32(getUpdValue(indto.getPreResult32(), indto.getResult32()));
	        	tRdmHcoReqInsData.setResult33(getUpdValue(indto.getPreResult33(), indto.getResult33()));
	        	tRdmHcoReqInsData.setResult34(getUpdValue(indto.getPreResult34(), indto.getResult34()));
	        	tRdmHcoReqInsData.setResult35(getUpdValue(indto.getPreResult35(), indto.getResult35()));
	        	tRdmHcoReqInsData.setResult36(getUpdValue(indto.getPreResult36(), indto.getResult36()));
        	}

        	tRdmHcoReqInsData.setEquip01(getUpdValue(indto.getPreEquip01(), indto.getEquip01()));
        	tRdmHcoReqInsData.setEquip02(getUpdValue(indto.getPreEquip02(), indto.getEquip02()));
        	tRdmHcoReqInsData.setEquip03(getUpdValue(indto.getPreEquip03(), indto.getEquip03()));
        	tRdmHcoReqInsData.setEquip07(getUpdValue(indto.getPreEquip07(), indto.getEquip07()));
        	tRdmHcoReqInsData.setEquip09(getUpdValue(indto.getPreEquip09(), indto.getEquip09()));

        	if(knr) {
	        	tRdmHcoReqInsData.setMarket01(getUpdValue(indto.getPreMarket01(), indto.getMarket01()));
	        	tRdmHcoReqInsData.setMarket02(getUpdValue(indto.getPreMarket02(), indto.getMarket02()));
	        	tRdmHcoReqInsData.setMarket03(getUpdValue(indto.getPreMarket03(), indto.getMarket03()));
	        	tRdmHcoReqInsData.setMarket04(getUpdValue(indto.getPreMarket04(), indto.getMarket04()));
	        	tRdmHcoReqInsData.setMarket06(getUpdValue(indto.getPreMarket06(), indto.getMarket06()));
	        	tRdmHcoReqInsData.setMarket07(getUpdValue(indto.getPreMarket07(), indto.getMarket07()));
	        	tRdmHcoReqInsData.setMarket09(getUpdValue(indto.getPreMarket09(), indto.getMarket09()));

	        	tRdmHcoReqInsData.setMedical12(getUpdValue(indto.getPreMedical12(), indto.getMedical12()));
        	}

        	tRdmHcoReqInsData.setSpfunc01(getUpdValue(indto.getPreSpfunc01(), indto.getSpfunc01()));
        	tRdmHcoReqInsData.setSpfunc03(getUpdValue(indto.getPreSpfunc03(), indto.getSpfunc03()));
        	tRdmHcoReqInsData.setSpfunc04(getUpdValue(indto.getPreSpfunc04(), indto.getSpfunc04()));

        	tRdmHcoReqInsData.setTieup10(getUpdValue(indto.getPreTieup10(), indto.getTieup10()));
        	tRdmHcoReqInsData.setTieup11(getUpdValue(indto.getPreTieup11(), indto.getTieup11()));
        	tRdmHcoReqInsData.setTieup12(getUpdValue(indto.getPreTieup12(), indto.getTieup12()));

        	if(knr) {
	        	tRdmHcoReqInsData.setUsercd0001(getUpdValue(indto.getPreUsercd0001(), indto.getUsercd0001()));
	        	tRdmHcoReqInsData.setUsercd0002(getUpdValue(indto.getPreUsercd0002(), indto.getUsercd0002()));
	        	tRdmHcoReqInsData.setUsercd0003(getUpdValue(indto.getPreUsercd0003(), indto.getUsercd0003()));
	        	tRdmHcoReqInsData.setUsercd0004(getUpdValue(indto.getPreUsercd0004(), indto.getUsercd0004()));
	        	tRdmHcoReqInsData.setUsercd0005(getUpdValue(indto.getPreUsercd0005(), indto.getUsercd0005()));
	        	tRdmHcoReqInsData.setUsercd0006(getUpdValue(indto.getPreUsercd0006(), indto.getUsercd0006()));
	        	tRdmHcoReqInsData.setUsercd0007(getUpdValue(indto.getPreUsercd0007(), indto.getUsercd0007()));
	        	tRdmHcoReqInsData.setUsercd0008(getUpdValue(indto.getPreUsercd0008(), indto.getUsercd0008()));
	        	tRdmHcoReqInsData.setUsercd0009(getUpdValue(indto.getPreUsercd0009(), indto.getUsercd0009()));
	        	tRdmHcoReqInsData.setUsercd0010(getUpdValue(indto.getPreUsercd0010(), indto.getUsercd0010()));
	        	tRdmHcoReqInsData.setUsercd0011(getUpdValue(indto.getPreUsercd0011(), indto.getUsercd0011()));
	        	tRdmHcoReqInsData.setUsercd0012(getUpdValue(indto.getPreUsercd0012(), indto.getUsercd0012()));
	        	tRdmHcoReqInsData.setUsercd0013(getUpdValue(indto.getPreUsercd0013(), indto.getUsercd0013()));
	        	tRdmHcoReqInsData.setUsercd0014(getUpdValue(indto.getPreUsercd0014(), indto.getUsercd0014()));
	        	tRdmHcoReqInsData.setUsercd0015(getUpdValue(indto.getPreUsercd0015(), indto.getUsercd0015()));
	        	tRdmHcoReqInsData.setUsercd0016(getUpdValue(indto.getPreUsercd0016(), indto.getUsercd0016()));
	        	tRdmHcoReqInsData.setUsercd0017(getUpdValue(indto.getPreUsercd0017(), indto.getUsercd0017()));
	        	tRdmHcoReqInsData.setUsercd0018(getUpdValue(indto.getPreUsercd0018(), indto.getUsercd0018()));
	        	tRdmHcoReqInsData.setUsercd0019(getUpdValue(indto.getPreUsercd0019(), indto.getUsercd0019()));
	        	tRdmHcoReqInsData.setUsercd0020(getUpdValue(indto.getPreUsercd0020(), indto.getUsercd0020()));
	        	tRdmHcoReqInsData.setUsercd0021(getUpdValue(indto.getPreUsercd0021(), indto.getUsercd0021()));
	        	tRdmHcoReqInsData.setUsercd0022(getUpdValue(indto.getPreUsercd0022(), indto.getUsercd0022()));
	        	tRdmHcoReqInsData.setUsercd0023(getUpdValue(indto.getPreUsercd0023(), indto.getUsercd0023()));
	        	tRdmHcoReqInsData.setUsercd0024(getUpdValue(indto.getPreUsercd0024(), indto.getUsercd0024()));
	        	tRdmHcoReqInsData.setUsercd0025(getUpdValue(indto.getPreUsercd0025(), indto.getUsercd0025()));
	        	tRdmHcoReqInsData.setUsercd0026(getUpdValue(indto.getPreUsercd0026(), indto.getUsercd0026()));
	        	tRdmHcoReqInsData.setUsercd0027(getUpdValue(indto.getPreUsercd0027(), indto.getUsercd0027()));
	        	tRdmHcoReqInsData.setUsercd0028(getUpdValue(indto.getPreUsercd0028(), indto.getUsercd0028()));
	        	tRdmHcoReqInsData.setUsercd0029(getUpdValue(indto.getPreUsercd0029(), indto.getUsercd0029()));
	        	tRdmHcoReqInsData.setUsercd0030(getUpdValue(indto.getPreUsercd0030(), indto.getUsercd0030()));
	        	tRdmHcoReqInsData.setUsercd0031(getUpdValue(indto.getPreUsercd0031(), indto.getUsercd0031()));
	        	tRdmHcoReqInsData.setUsercd0032(getUpdValue(indto.getPreUsercd0032(), indto.getUsercd0032()));
	        	tRdmHcoReqInsData.setUsercd0033(getUpdValue(indto.getPreUsercd0033(), indto.getUsercd0033()));
	        	tRdmHcoReqInsData.setUsercd0034(getUpdValue(indto.getPreUsercd0034(), indto.getUsercd0034()));
	        	tRdmHcoReqInsData.setUsercd0035(getUpdValue(indto.getPreUsercd0035(), indto.getUsercd0035()));
	        	tRdmHcoReqInsData.setUsercd0036(getUpdValue(indto.getPreUsercd0036(), indto.getUsercd0036()));
	        	tRdmHcoReqInsData.setUsercd0101(getUpdValue(indto.getPreUsercd0101(), indto.getUsercd0101()));
	        	tRdmHcoReqInsData.setUsercd0102(getUpdValue(indto.getPreUsercd0102(), indto.getUsercd0102()));
	        	tRdmHcoReqInsData.setUsercd0103(getUpdValue(indto.getPreUsercd0103(), indto.getUsercd0103()));
	        	tRdmHcoReqInsData.setUsercd0104(getUpdValue(indto.getPreUsercd0104(), indto.getUsercd0104()));
	        	tRdmHcoReqInsData.setUsercd0105(getUpdValue(indto.getPreUsercd0105(), indto.getUsercd0105()));
	        	tRdmHcoReqInsData.setUsercd0106(getUpdValue(indto.getPreUsercd0106(), indto.getUsercd0106()));
	        	tRdmHcoReqInsData.setUsercd0107(getUpdValue(indto.getPreUsercd0107(), indto.getUsercd0107()));
	        	tRdmHcoReqInsData.setUsercd0108(getUpdValue(indto.getPreUsercd0108(), indto.getUsercd0108()));
	        	tRdmHcoReqInsData.setUsercd0109(getUpdValue(indto.getPreUsercd0109(), indto.getUsercd0109()));
	        	tRdmHcoReqInsData.setUsercd0201(getUpdValue(indto.getPreUsercd0201(), indto.getUsercd0201()));
	        	tRdmHcoReqInsData.setUsercd0202(getUpdValue(indto.getPreUsercd0202(), indto.getUsercd0202()));
	        	tRdmHcoReqInsData.setUsercd0203(getUpdValue(indto.getPreUsercd0203(), indto.getUsercd0203()));
	        	tRdmHcoReqInsData.setUsercd0204(getUpdValue(indto.getPreUsercd0204(), indto.getUsercd0204()));
	        	tRdmHcoReqInsData.setUsercd0205(getUpdValue(indto.getPreUsercd0205(), indto.getUsercd0205()));
	        	tRdmHcoReqInsData.setUsercd0206(getUpdValue(indto.getPreUsercd0206(), indto.getUsercd0206()));

	        	tRdmHcoReqInsData.setReward04(getUpdValue(indto.getPreReward04(), indto.getReward04()));
	        	tRdmHcoReqInsData.setReward05(getUpdValue(indto.getPreReward05(), indto.getReward05()));
	        	tRdmHcoReqInsData.setReward08(getUpdValue(indto.getPreReward08(), indto.getReward08()));
	        	tRdmHcoReqInsData.setReward09(getUpdValue(indto.getPreReward09(), indto.getReward09()));
	        	tRdmHcoReqInsData.setReward16(getUpdValue(indto.getPreReward16(), indto.getReward16()));
	        	tRdmHcoReqInsData.setReward17(getUpdValue(indto.getPreReward17(), indto.getReward17()));
	        	tRdmHcoReqInsData.setReward18(getUpdValue(indto.getPreReward18(), indto.getReward18()));
	        	tRdmHcoReqInsData.setReward21(getUpdValue(indto.getPreReward21(), indto.getReward21()));
	        	tRdmHcoReqInsData.setReward23(getUpdValue(indto.getPreReward23(), indto.getReward23()));
	        	tRdmHcoReqInsData.setReward25(getUpdValue(indto.getPreReward25(), indto.getReward25()));
	        	tRdmHcoReqInsData.setReward26(getUpdValue(indto.getPreReward26(), indto.getReward26()));
	        	tRdmHcoReqInsData.setReward27(getUpdValue(indto.getPreReward27(), indto.getReward27()));
	        	tRdmHcoReqInsData.setReward29(getUpdValue(indto.getPreReward29(), indto.getReward29()));
	        	tRdmHcoReqInsData.setReward35(getUpdValue(indto.getPreReward35(), indto.getReward35()));
	        	tRdmHcoReqInsData.setReward36(getUpdValue(indto.getPreReward36(), indto.getReward36()));
	        	tRdmHcoReqInsData.setReward37(getUpdValue(indto.getPreReward37(), indto.getReward37()));
	        	tRdmHcoReqInsData.setReward44(getUpdValue(indto.getPreReward44(), indto.getReward44()));
        	}

        	tRdmHcoReqInsData.setInsShaYmd(systemDate);
        	tRdmHcoReqInsData.setInsShaId(indto.getLoginJgiNo());
        	tRdmHcoReqInsData.setUpdShaYmd(systemDate);
        	tRdmHcoReqInsData.setUpdShaId(indto.getLoginJgiNo());

        	dao.insertByValue(tRdmHcoReqInsData);

        } else {
        	// 更新
        	TRdmHcoReqEntity tRdmHcoReqUpdData = new TRdmHcoReqEntity("updateNF012Data");
        	tRdmHcoReqUpdData.setReqId(reqId);

        	tRdmHcoReqUpdData.setInsKana(getUpdValue(indto.getPreInsKana(), indto.getInsKana()));
        	tRdmHcoReqUpdData.setInsAbbrName(getUpdValue(indto.getPreInsAbbrName(), indto.getInsAbbrName()));
        	tRdmHcoReqUpdData.setInsFormalName(getUpdValue(indto.getPreInsFormalName(), indto.getInsFormalName()));

        	String insPcode = getUpdValue(indto.getInsPcode());
        	if(insPcode != null) {
        		insPcode = insPcode.replace("-", "");
        	}
        	String preInsPcode = getUpdValue(indto.getPreInsPcode());
        	if(preInsPcode != null) {
        		preInsPcode = preInsPcode.replace("-", "");
        	}
        	tRdmHcoReqUpdData.setInsPcode(getUpdValue(preInsPcode, insPcode));
        	tRdmHcoReqUpdData.setAddrCodePref(getUpdValue(indto.getPreAddrCodePref(), indto.getAddrCodePref()));
        	tRdmHcoReqUpdData.setAddrCodeCity(getUpdValue(indto.getPreAddrCodeCity(), indto.getAddrCodeCity()));
        	tRdmHcoReqUpdData.setTkCityCd(getUpdValue(indto.getPreTkCityCd(), indto.getTkCityCd()));
        	tRdmHcoReqUpdData.setInsAddrDt(getUpdValue(indto.getPreInsAddrDt(), indto.getInsAddrDt()));
        	tRdmHcoReqUpdData.setInsAddr(getUpdValue(indto.getPreInsAddr(), indto.getInsAddr()));
        	tRdmHcoReqUpdData.setInsAddrKana(getUpdValue(indto.getPreInsAddrKana(), indto.getInsAddrKana()));
        	tRdmHcoReqUpdData.setInsPhone1(getUpdValue(indto.getPreInsPhone1(), indto.getInsPhone1()));
        	tRdmHcoReqUpdData.setInsFax1(getUpdValue(indto.getPreInsFax1(), indto.getInsFax1()));
        	tRdmHcoReqUpdData.setInsPhone2(getUpdValue(indto.getPreInsPhone2(), indto.getInsPhone2()));
        	tRdmHcoReqUpdData.setInsFax2(getUpdValue(indto.getPreInsFax2(), indto.getInsFax2()));
        	tRdmHcoReqUpdData.setInsUrl(getUpdValue(indto.getPreInsUrl(), indto.getInsUrl()));

        	String preUrlYmd = indto.getPreInsUrlYmd();
        	String urlYmd = indto.getInsUrlYmd();
        	if(preUrlYmd != null) {
        		preUrlYmd = preUrlYmd.replace("/", "");
        	}
        	if(urlYmd != null) {
        		urlYmd = urlYmd.replace("/", "");
        	}
        	tRdmHcoReqUpdData.setInsUrlYmd(getUpdValue(preUrlYmd, urlYmd));

        	tRdmHcoReqUpdData.setWsType(getUpdValue(indto.getPreWsType(), indto.getWsType()));
        	tRdmHcoReqUpdData.setTradeType(getUpdValue(indto.getPreTradeType(), indto.getTradeType()));
        	tRdmHcoReqUpdData.setBasketPurchase(getUpdValue(indto.getPreBasketPurchase(), indto.getBasketPurchase()));
        	tRdmHcoReqUpdData.setUnivSubdiv(getUpdValue(indto.getPreUnivSubdiv(), indto.getUnivSubdiv()));
        	tRdmHcoReqUpdData.setInsOpenYear(getUpdValue(indto.getPreInsOpenYear(), indto.getInsOpenYear()));
        	tRdmHcoReqUpdData.setInsOpenMonth(getUpdValue(indto.getPreInsOpenMonth(), indto.getInsOpenMonth()));
        	tRdmHcoReqUpdData.setInsOpenDay(getUpdValue(indto.getPreInsOpenDay(), indto.getInsOpenDay()));
        	tRdmHcoReqUpdData.setCapaType(getUpdValue(indto.getPreCapaType(), indto.getCapaType()));

        	if(knr) {
        		tRdmHcoReqUpdData.setUltInsNo(getUpdValue(indto.getPreUltInsCd(), indto.getUltInsCd()));

        		tRdmHcoReqUpdData.setFree0001(getUpdValue(indto.getPreFree0001(), indto.getFree0001()));
	        	tRdmHcoReqUpdData.setFree0002(getUpdValue(indto.getPreFree0002(), indto.getFree0002()));
	        	tRdmHcoReqUpdData.setFree0003(getUpdValue(indto.getPreFree0003(), indto.getFree0003()));
	        	tRdmHcoReqUpdData.setFree0004(getUpdValue(indto.getPreFree0004(), indto.getFree0004()));
	        	tRdmHcoReqUpdData.setFree0005(getUpdValue(indto.getPreFree0005(), indto.getFree0005()));
	        	tRdmHcoReqUpdData.setFree0006(getUpdValue(indto.getPreFree0006(), indto.getFree0006()));
	        	tRdmHcoReqUpdData.setFree0007(getUpdValue(indto.getPreFree0007(), indto.getFree0007()));
	        	tRdmHcoReqUpdData.setFree0008(getUpdValue(indto.getPreFree0008(), indto.getFree0008()));
	        	tRdmHcoReqUpdData.setFree0009(getUpdValue(indto.getPreFree0009(), indto.getFree0009()));
	        	tRdmHcoReqUpdData.setFree0010(getUpdValue(indto.getPreFree0010(), indto.getFree0010()));
	        	tRdmHcoReqUpdData.setFree0011(getUpdValue(indto.getPreFree0011(), indto.getFree0011()));
	        	tRdmHcoReqUpdData.setFree0012(getUpdValue(indto.getPreFree0012(), indto.getFree0012()));
	        	tRdmHcoReqUpdData.setFree0013(getUpdValue(indto.getPreFree0013(), indto.getFree0013()));
	        	tRdmHcoReqUpdData.setFree0014(getUpdValue(indto.getPreFree0014(), indto.getFree0014()));
	        	tRdmHcoReqUpdData.setFree0015(getUpdValue(indto.getPreFree0015(), indto.getFree0015()));

	        	tRdmHcoReqUpdData.setWelfare02(getUpdValue(indto.getPreWelfare02(), indto.getWelfare02()));
	        	tRdmHcoReqUpdData.setWelfare08(getUpdValue(indto.getPreWelfare08(), indto.getWelfare08()));

	        	tRdmHcoReqUpdData.setResult01(getUpdValue(indto.getPreResult01(), indto.getResult01()));
	        	tRdmHcoReqUpdData.setResult02(getUpdValue(indto.getPreResult02(), indto.getResult02()));
	        	tRdmHcoReqUpdData.setResult03(getUpdValue(indto.getPreResult03(), indto.getResult03()));
	        	tRdmHcoReqUpdData.setResult04(getUpdValue(indto.getPreResult04(), indto.getResult04()));
	        	tRdmHcoReqUpdData.setResult05(getUpdValue(indto.getPreResult05(), indto.getResult05()));
	        	tRdmHcoReqUpdData.setResult06(getUpdValue(indto.getPreResult06(), indto.getResult06()));
	        	tRdmHcoReqUpdData.setResult07(getUpdValue(indto.getPreResult07(), indto.getResult07()));
	        	tRdmHcoReqUpdData.setResult08(getUpdValue(indto.getPreResult08(), indto.getResult08()));
	        	tRdmHcoReqUpdData.setResult09(getUpdValue(indto.getPreResult09(), indto.getResult09()));
	        	tRdmHcoReqUpdData.setResult10(getUpdValue(indto.getPreResult10(), indto.getResult10()));
	        	tRdmHcoReqUpdData.setResult11(getUpdValue(indto.getPreResult11(), indto.getResult11()));
	        	tRdmHcoReqUpdData.setResult12(getUpdValue(indto.getPreResult12(), indto.getResult12()));
	        	tRdmHcoReqUpdData.setResult13(getUpdValue(indto.getPreResult13(), indto.getResult13()));
	        	tRdmHcoReqUpdData.setResult14(getUpdValue(indto.getPreResult14(), indto.getResult14()));
	        	tRdmHcoReqUpdData.setResult15(getUpdValue(indto.getPreResult15(), indto.getResult15()));
	        	tRdmHcoReqUpdData.setResult16(getUpdValue(indto.getPreResult16(), indto.getResult16()));
	        	tRdmHcoReqUpdData.setResult17(getUpdValue(indto.getPreResult17(), indto.getResult17()));
	        	tRdmHcoReqUpdData.setResult18(getUpdValue(indto.getPreResult18(), indto.getResult18()));
	        	tRdmHcoReqUpdData.setResult19(getUpdValue(indto.getPreResult19(), indto.getResult19()));
	        	tRdmHcoReqUpdData.setResult20(getUpdValue(indto.getPreResult20(), indto.getResult20()));
	        	tRdmHcoReqUpdData.setResult21(getUpdValue(indto.getPreResult21(), indto.getResult21()));
	        	tRdmHcoReqUpdData.setResult22(getUpdValue(indto.getPreResult22(), indto.getResult22()));
	        	tRdmHcoReqUpdData.setResult23(getUpdValue(indto.getPreResult23(), indto.getResult23()));
	        	tRdmHcoReqUpdData.setResult24(getUpdValue(indto.getPreResult24(), indto.getResult24()));
	        	tRdmHcoReqUpdData.setResult25(getUpdValue(indto.getPreResult25(), indto.getResult25()));
	        	tRdmHcoReqUpdData.setResult26(getUpdValue(indto.getPreResult26(), indto.getResult26()));
	        	tRdmHcoReqUpdData.setResult27(getUpdValue(indto.getPreResult27(), indto.getResult27()));
	        	tRdmHcoReqUpdData.setResult28(getUpdValue(indto.getPreResult28(), indto.getResult28()));
	        	tRdmHcoReqUpdData.setResult29(getUpdValue(indto.getPreResult29(), indto.getResult29()));
	        	tRdmHcoReqUpdData.setResult30(getUpdValue(indto.getPreResult30(), indto.getResult30()));
	        	tRdmHcoReqUpdData.setResult31(getUpdValue(indto.getPreResult31(), indto.getResult31()));
	        	tRdmHcoReqUpdData.setResult32(getUpdValue(indto.getPreResult32(), indto.getResult32()));
	        	tRdmHcoReqUpdData.setResult33(getUpdValue(indto.getPreResult33(), indto.getResult33()));
	        	tRdmHcoReqUpdData.setResult34(getUpdValue(indto.getPreResult34(), indto.getResult34()));
	        	tRdmHcoReqUpdData.setResult35(getUpdValue(indto.getPreResult35(), indto.getResult35()));
	        	tRdmHcoReqUpdData.setResult36(getUpdValue(indto.getPreResult36(), indto.getResult36()));
        	}

        	tRdmHcoReqUpdData.setEquip01(getUpdValue(indto.getPreEquip01(), indto.getEquip01()));
        	tRdmHcoReqUpdData.setEquip02(getUpdValue(indto.getPreEquip02(), indto.getEquip02()));
        	tRdmHcoReqUpdData.setEquip03(getUpdValue(indto.getPreEquip03(), indto.getEquip03()));
        	tRdmHcoReqUpdData.setEquip07(getUpdValue(indto.getPreEquip07(), indto.getEquip07()));
        	tRdmHcoReqUpdData.setEquip09(getUpdValue(indto.getPreEquip09(), indto.getEquip09()));

        	if(knr) {
	        	tRdmHcoReqUpdData.setMarket01(getUpdValue(indto.getPreMarket01(), indto.getMarket01()));
	        	tRdmHcoReqUpdData.setMarket02(getUpdValue(indto.getPreMarket02(), indto.getMarket02()));
	        	tRdmHcoReqUpdData.setMarket03(getUpdValue(indto.getPreMarket03(), indto.getMarket03()));
	        	tRdmHcoReqUpdData.setMarket04(getUpdValue(indto.getPreMarket04(), indto.getMarket04()));
	        	tRdmHcoReqUpdData.setMarket06(getUpdValue(indto.getPreMarket06(), indto.getMarket06()));
	        	tRdmHcoReqUpdData.setMarket07(getUpdValue(indto.getPreMarket07(), indto.getMarket07()));
	        	tRdmHcoReqUpdData.setMarket09(getUpdValue(indto.getPreMarket09(), indto.getMarket09()));

	        	tRdmHcoReqUpdData.setMedical12(getUpdValue(indto.getPreMedical12(), indto.getMedical12()));
        	}

        	tRdmHcoReqUpdData.setSpfunc01(getUpdValue(indto.getPreSpfunc01(), indto.getSpfunc01()));
        	tRdmHcoReqUpdData.setSpfunc03(getUpdValue(indto.getPreSpfunc03(), indto.getSpfunc03()));
        	tRdmHcoReqUpdData.setSpfunc04(getUpdValue(indto.getPreSpfunc04(), indto.getSpfunc04()));

        	tRdmHcoReqUpdData.setTieup10(getUpdValue(indto.getPreTieup10(), indto.getTieup10()));
        	tRdmHcoReqUpdData.setTieup11(getUpdValue(indto.getPreTieup11(), indto.getTieup11()));
        	tRdmHcoReqUpdData.setTieup12(getUpdValue(indto.getPreTieup12(), indto.getTieup12()));

        	if(knr) {
	        	tRdmHcoReqUpdData.setUsercd0001(getUpdValue(indto.getPreUsercd0001(), indto.getUsercd0001()));
	        	tRdmHcoReqUpdData.setUsercd0002(getUpdValue(indto.getPreUsercd0002(), indto.getUsercd0002()));
	        	tRdmHcoReqUpdData.setUsercd0003(getUpdValue(indto.getPreUsercd0003(), indto.getUsercd0003()));
	        	tRdmHcoReqUpdData.setUsercd0004(getUpdValue(indto.getPreUsercd0004(), indto.getUsercd0004()));
	        	tRdmHcoReqUpdData.setUsercd0005(getUpdValue(indto.getPreUsercd0005(), indto.getUsercd0005()));
	        	tRdmHcoReqUpdData.setUsercd0006(getUpdValue(indto.getPreUsercd0006(), indto.getUsercd0006()));
	        	tRdmHcoReqUpdData.setUsercd0007(getUpdValue(indto.getPreUsercd0007(), indto.getUsercd0007()));
	        	tRdmHcoReqUpdData.setUsercd0008(getUpdValue(indto.getPreUsercd0008(), indto.getUsercd0008()));
	        	tRdmHcoReqUpdData.setUsercd0009(getUpdValue(indto.getPreUsercd0009(), indto.getUsercd0009()));
	        	tRdmHcoReqUpdData.setUsercd0010(getUpdValue(indto.getPreUsercd0010(), indto.getUsercd0010()));
	        	tRdmHcoReqUpdData.setUsercd0011(getUpdValue(indto.getPreUsercd0011(), indto.getUsercd0011()));
	        	tRdmHcoReqUpdData.setUsercd0012(getUpdValue(indto.getPreUsercd0012(), indto.getUsercd0012()));
	        	tRdmHcoReqUpdData.setUsercd0013(getUpdValue(indto.getPreUsercd0013(), indto.getUsercd0013()));
	        	tRdmHcoReqUpdData.setUsercd0014(getUpdValue(indto.getPreUsercd0014(), indto.getUsercd0014()));
	        	tRdmHcoReqUpdData.setUsercd0015(getUpdValue(indto.getPreUsercd0015(), indto.getUsercd0015()));
	        	tRdmHcoReqUpdData.setUsercd0016(getUpdValue(indto.getPreUsercd0016(), indto.getUsercd0016()));
	        	tRdmHcoReqUpdData.setUsercd0017(getUpdValue(indto.getPreUsercd0017(), indto.getUsercd0017()));
	        	tRdmHcoReqUpdData.setUsercd0018(getUpdValue(indto.getPreUsercd0018(), indto.getUsercd0018()));
	        	tRdmHcoReqUpdData.setUsercd0019(getUpdValue(indto.getPreUsercd0019(), indto.getUsercd0019()));
	        	tRdmHcoReqUpdData.setUsercd0020(getUpdValue(indto.getPreUsercd0020(), indto.getUsercd0020()));
	        	tRdmHcoReqUpdData.setUsercd0021(getUpdValue(indto.getPreUsercd0021(), indto.getUsercd0021()));
	        	tRdmHcoReqUpdData.setUsercd0022(getUpdValue(indto.getPreUsercd0022(), indto.getUsercd0022()));
	        	tRdmHcoReqUpdData.setUsercd0023(getUpdValue(indto.getPreUsercd0023(), indto.getUsercd0023()));
	        	tRdmHcoReqUpdData.setUsercd0024(getUpdValue(indto.getPreUsercd0024(), indto.getUsercd0024()));
	        	tRdmHcoReqUpdData.setUsercd0025(getUpdValue(indto.getPreUsercd0025(), indto.getUsercd0025()));
	        	tRdmHcoReqUpdData.setUsercd0026(getUpdValue(indto.getPreUsercd0026(), indto.getUsercd0026()));
	        	tRdmHcoReqUpdData.setUsercd0027(getUpdValue(indto.getPreUsercd0027(), indto.getUsercd0027()));
	        	tRdmHcoReqUpdData.setUsercd0028(getUpdValue(indto.getPreUsercd0028(), indto.getUsercd0028()));
	        	tRdmHcoReqUpdData.setUsercd0029(getUpdValue(indto.getPreUsercd0029(), indto.getUsercd0029()));
	        	tRdmHcoReqUpdData.setUsercd0030(getUpdValue(indto.getPreUsercd0030(), indto.getUsercd0030()));
	        	tRdmHcoReqUpdData.setUsercd0031(getUpdValue(indto.getPreUsercd0031(), indto.getUsercd0031()));
	        	tRdmHcoReqUpdData.setUsercd0032(getUpdValue(indto.getPreUsercd0032(), indto.getUsercd0032()));
	        	tRdmHcoReqUpdData.setUsercd0033(getUpdValue(indto.getPreUsercd0033(), indto.getUsercd0033()));
	        	tRdmHcoReqUpdData.setUsercd0034(getUpdValue(indto.getPreUsercd0034(), indto.getUsercd0034()));
	        	tRdmHcoReqUpdData.setUsercd0035(getUpdValue(indto.getPreUsercd0035(), indto.getUsercd0035()));
	        	tRdmHcoReqUpdData.setUsercd0036(getUpdValue(indto.getPreUsercd0036(), indto.getUsercd0036()));
	        	tRdmHcoReqUpdData.setUsercd0101(getUpdValue(indto.getPreUsercd0101(), indto.getUsercd0101()));
	        	tRdmHcoReqUpdData.setUsercd0102(getUpdValue(indto.getPreUsercd0102(), indto.getUsercd0102()));
	        	tRdmHcoReqUpdData.setUsercd0103(getUpdValue(indto.getPreUsercd0103(), indto.getUsercd0103()));
	        	tRdmHcoReqUpdData.setUsercd0104(getUpdValue(indto.getPreUsercd0104(), indto.getUsercd0104()));
	        	tRdmHcoReqUpdData.setUsercd0105(getUpdValue(indto.getPreUsercd0105(), indto.getUsercd0105()));
	        	tRdmHcoReqUpdData.setUsercd0106(getUpdValue(indto.getPreUsercd0106(), indto.getUsercd0106()));
	        	tRdmHcoReqUpdData.setUsercd0107(getUpdValue(indto.getPreUsercd0107(), indto.getUsercd0107()));
	        	tRdmHcoReqUpdData.setUsercd0108(getUpdValue(indto.getPreUsercd0108(), indto.getUsercd0108()));
	        	tRdmHcoReqUpdData.setUsercd0109(getUpdValue(indto.getPreUsercd0109(), indto.getUsercd0109()));
	        	tRdmHcoReqUpdData.setUsercd0201(getUpdValue(indto.getPreUsercd0201(), indto.getUsercd0201()));
	        	tRdmHcoReqUpdData.setUsercd0202(getUpdValue(indto.getPreUsercd0202(), indto.getUsercd0202()));
	        	tRdmHcoReqUpdData.setUsercd0203(getUpdValue(indto.getPreUsercd0203(), indto.getUsercd0203()));
	        	tRdmHcoReqUpdData.setUsercd0204(getUpdValue(indto.getPreUsercd0204(), indto.getUsercd0204()));
	        	tRdmHcoReqUpdData.setUsercd0205(getUpdValue(indto.getPreUsercd0205(), indto.getUsercd0205()));
	        	tRdmHcoReqUpdData.setUsercd0206(getUpdValue(indto.getPreUsercd0206(), indto.getUsercd0206()));

	        	tRdmHcoReqUpdData.setReward04(getUpdValue(indto.getPreReward04(), indto.getReward04()));
	        	tRdmHcoReqUpdData.setReward05(getUpdValue(indto.getPreReward05(), indto.getReward05()));
	        	tRdmHcoReqUpdData.setReward08(getUpdValue(indto.getPreReward08(), indto.getReward08()));
	        	tRdmHcoReqUpdData.setReward09(getUpdValue(indto.getPreReward09(), indto.getReward09()));
	        	tRdmHcoReqUpdData.setReward16(getUpdValue(indto.getPreReward16(), indto.getReward16()));
	        	tRdmHcoReqUpdData.setReward17(getUpdValue(indto.getPreReward17(), indto.getReward17()));
	        	tRdmHcoReqUpdData.setReward18(getUpdValue(indto.getPreReward18(), indto.getReward18()));
	        	tRdmHcoReqUpdData.setReward21(getUpdValue(indto.getPreReward21(), indto.getReward21()));
	        	tRdmHcoReqUpdData.setReward23(getUpdValue(indto.getPreReward23(), indto.getReward23()));
	        	tRdmHcoReqUpdData.setReward25(getUpdValue(indto.getPreReward25(), indto.getReward25()));
	        	tRdmHcoReqUpdData.setReward26(getUpdValue(indto.getPreReward26(), indto.getReward26()));
	        	tRdmHcoReqUpdData.setReward27(getUpdValue(indto.getPreReward27(), indto.getReward27()));
	        	tRdmHcoReqUpdData.setReward29(getUpdValue(indto.getPreReward29(), indto.getReward29()));
	        	tRdmHcoReqUpdData.setReward35(getUpdValue(indto.getPreReward35(), indto.getReward35()));
	        	tRdmHcoReqUpdData.setReward36(getUpdValue(indto.getPreReward36(), indto.getReward36()));
	        	tRdmHcoReqUpdData.setReward37(getUpdValue(indto.getPreReward37(), indto.getReward37()));
	        	tRdmHcoReqUpdData.setReward44(getUpdValue(indto.getPreReward44(), indto.getReward44()));
        	}

        	tRdmHcoReqUpdData.setUpdShaYmd(systemDate);
        	tRdmHcoReqUpdData.setUpdShaId(indto.getLoginJgiNo());

        	if(knr) {
        		tRdmHcoReqUpdData.setKnrFlg("1");
        	}

        	dao.update(tRdmHcoReqUpdData);
        }

    	outdto.setForward("NC101");

		// END UOC
		return outdto;
    }

    /**
     * valueがpreValueと同一の場合は空白、同一でなくvalueが空白の場合は'--なし--'を返却
     * @param preValue
     * @param value
     * @return
     */
    public String getViewValue(String preValue, String value){
    	String rtnValue = value;

    	if(value != null && value.equals(preValue)
    			|| (value == null && StringUtils.isEmpty(preValue))) {
    		rtnValue = "";
    	} else if(StringUtils.isEmpty(value)) {
    		rtnValue = "--なし--";
    	}
    	return rtnValue;
    }

    /**
     * cd値がpreCd値と同一の場合は空白、同一でなくcdが空白の場合は'--なし--'、それ以外の場合はnmを返却
     * @param preValue
     * @param value
     * @return
     */
    public String getViewNmValue(String cdValue, String preCdValue, String nmValue){
    	String rtnValue = nmValue;

    	if(cdValue != null && cdValue.equals(preCdValue)
    			|| (cdValue == null && StringUtils.isEmpty(preCdValue))) {
    		rtnValue = "";
    	} else if(StringUtils.isEmpty(cdValue)) {
    		rtnValue = "--なし--";
    	}

    	return rtnValue;
    }

    /**
     * cd値がpreCd値と同一の場合は空白、同一でなくcdが空白の場合は'--なし--'、それ以外の場合はcd:nmを返却
     * @param preValue
     * @param value
     * @return
     */
    public String getViewValue(String cdValue, String preCdValue, String nmValue){
    	String rtnValue = "";

    	if(cdValue != null && cdValue.equals(preCdValue)
    			|| (cdValue == null && StringUtils.isEmpty(preCdValue))) {
    		rtnValue = "";
    	} else if(StringUtils.isEmpty(cdValue)) {
    		rtnValue = "--なし--";
    	} else {
    		rtnValue = cdValue + ":" + nmValue;
    	}

    	return rtnValue;
    }

    /**
     * 値が--なし--の場合はZ、値無の場合は''を返却
     * @param preValue
     * @param value
     * @return
     */
    public String getUpdValue(String value){
    	String rtnValue = value;

    	if("--なし--".equals(value)) {
    		rtnValue = "Z";
    	} else if(StringUtils.isEmpty(value)) {
    		rtnValue = null;
    	}

    	return rtnValue;
    }

    /**
     * 変更前と値が同一の場合はNULL、値無の場合は'Z'を返却
     * @param preValue
     * @param value
     * @return
     */
    public String getUpdValue(String preValue, String value){
    	String rtnValue = value;

    	if(value != null && value.equals(preValue)
    			|| (value == null && (preValue == null || preValue.isEmpty()))) {
    		rtnValue = null;
    	} else if(value == null || value.equals("")) {
    		rtnValue = "Z";
    	}

    	return rtnValue;
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
     * 変更無チェック
     * @param pcode
     * @return
     */
    public static boolean chkEquals(String value1, String value2){
    	if(StringUtils.isEmpty(value1)) {
    		if(StringUtils.isEmpty(value2)) {
    			return true;
    		}
    	} else if (value1.equals(value2)) {
    		return true;
    	}
    	return false;
	}
}
