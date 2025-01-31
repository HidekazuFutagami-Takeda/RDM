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
import jp.co.takeda.rdm.dto.NF011DTO;
import jp.co.takeda.rdm.dto.NF012DTO;
import jp.co.takeda.rdm.entity.join.MRdmComCalUsrEntity;
import jp.co.takeda.rdm.entity.join.MRdmHcoJkrWkEntity;
import jp.co.takeda.rdm.entity.join.SelectComboListEntity;
import jp.co.takeda.rdm.entity.join.SelectNF012MainDataEntity;
import jp.co.takeda.rdm.entity.join.SeqRdmReqIdEntity;
import jp.co.takeda.rdm.entity.join.TRdmHcoReqEntity;
import jp.co.takeda.rdm.entity.join.TRdmMMdbHcoMstEntity;
import jp.co.takeda.rdm.entity.join.TRdmReqKnrEntity;
import jp.co.takeda.rdm.util.DateUtils;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;

/**
 * Serviceクラス（NF012)
 * @generated
 */
@Named
public class NF012Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(NF012Service.class);

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
     * @param indto NF012DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(NF012DTO indto) {
        BaseDTO outdto = indto;
        // START UOC
        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

        if ("1".equals(indto.getDisplayKbn())) {
    		// 施設固定コードで初期データ作成
    		SelectNF012MainDataEntity paramEntity = new SelectNF012MainDataEntity("selectNF012InsData");
    		paramEntity.setInInsNo(indto.getInsNo());
    		List<SelectNF012MainDataEntity> mainDataEntityList = dao.select(paramEntity);
    		SelectNF012MainDataEntity mainDataEntity = mainDataEntityList.get(0);

    		// 申請情報
    		// TODO ログイン関連できてから確認
//    		indto.setReqShzNm(loginInfo.getShzNm());
    		indto.setReqJgiName(loginInfo.getJgiName());
    		indto.setReqJgiNo(loginInfo.getJgiNo());
//    		indto.setReqBrCd(loginInfo.getBrCd());
//    		indto.setReqDistCd(loginInfo.getDistCd());
    		indto.setReqYmdhms("");
    		indto.setReqStsNm("");

    		// 基本情報
    		indto.setInsNo(indto.getInsNo());
    		indto.setInsClass(StringUtils.nvl(mainDataEntity.getInsClass(), ""));
    		indto.setInsSbt(StringUtils.nvl(mainDataEntity.getInsSbt(), ""));
    		indto.setPreInsAbbrName(StringUtils.nvl(mainDataEntity.getPreInsAbbrName(), ""));
    		indto.setPreInsKana(StringUtils.nvl(mainDataEntity.getPreInsKana(), ""));
    		indto.setPreInsFormalName(StringUtils.nvl(mainDataEntity.getPreInsFormalName(), ""));
    		indto.setPreTradeType(StringUtils.nvl(mainDataEntity.getPreTradeType(), ""));
    		indto.setPreTradeTypeNm(StringUtils.nvl(mainDataEntity.getPreTradeTypeNm(), ""));
    		indto.setPreInsOpenYear(StringUtils.nvl(mainDataEntity.getPreInsOpenYear(), ""));
    		indto.setPreInsOpenMonth(StringUtils.nvl(mainDataEntity.getPreInsOpenMonth(), ""));
    		indto.setPreInsOpenDay(StringUtils.nvl(mainDataEntity.getPreInsOpenDay(), ""));
    		indto.setPrePharmType(StringUtils.nvl(mainDataEntity.getPrePharmType(), ""));
    		indto.setPrePharmTypeNm(StringUtils.nvl(mainDataEntity.getPrePharmTypeNm(), ""));
    		indto.setPreInsRank(StringUtils.nvl(mainDataEntity.getPreInsRank(), ""));
    		indto.setPreInsRankNm(StringUtils.nvl(mainDataEntity.getPreInsRankNm(), ""));
    		indto.setPreRegVisType(StringUtils.nvl(mainDataEntity.getPreRegVisType(), ""));
    		indto.setPreRegVisTypeNm(StringUtils.nvl(mainDataEntity.getPreRegVisTypeNm(), ""));
    		indto.setPreManageCd(StringUtils.nvl(mainDataEntity.getPreManageCd(), ""));
    		indto.setPreManageNm(StringUtils.nvl(mainDataEntity.getPreManageNm(), ""));
    		indto.setPreWsType(StringUtils.nvl(mainDataEntity.getPreWsType(), ""));

    		if(mainDataEntity.getPreWsType() != null && !mainDataEntity.getPreWsType().isEmpty()) {
    			indto.setPreWsTypeNm(StringUtils.nvl(mainDataEntity.getPreWsTypeNm(), ""));
    		} else {
    			indto.setPreWsTypeNm("--なし--");
    		}

    		indto.setPreBasketPurchase(StringUtils.nvl(mainDataEntity.getPreBasketPurchase(), ""));
    		indto.setPreBasketPurchaseNm(StringUtils.nvl(mainDataEntity.getPreBasketPurchaseNm(), ""));

    		if(mainDataEntity.getPreBasketPurchase() != null && !mainDataEntity.getPreBasketPurchase().isEmpty()) {
    			indto.setPreBasketPurchaseNm(mainDataEntity.getPreBasketPurchase() + "：" + StringUtils.nvl(mainDataEntity.getPreBasketPurchaseNm(), ""));
    		} else {
    			indto.setPreBasketPurchaseNm("--なし--");
    		}

    		indto.setPreUnivSubdiv(StringUtils.nvl(mainDataEntity.getPreUnivSubdiv(), ""));
    		indto.setPreUnivSubdivNm(StringUtils.nvl(mainDataEntity.getPreUnivSubdivNm(), ""));

    		if(mainDataEntity.getPreUnivSubdiv() != null && !mainDataEntity.getPreUnivSubdiv().isEmpty()) {
    			indto.setPreUnivSubdivNm(mainDataEntity.getPreUnivSubdiv() + "：" + StringUtils.nvl(mainDataEntity.getPreUnivSubdivNm(), ""));
    		} else {
    			indto.setPreUnivSubdivNm("--なし--");
    		}

    		indto.setPreCapaType(StringUtils.nvl(mainDataEntity.getPreCapaType(), ""));

    		if(mainDataEntity.getPreCapaType() != null && !mainDataEntity.getPreCapaType().isEmpty()) {
    			indto.setPreCapaTypeNm(StringUtils.nvl(mainDataEntity.getPreCapaTypeNm(), ""));
    		} else {
    			indto.setPreCapaTypeNm("--なし--");
    		}

    		indto.setInsAbbrName(StringUtils.nvl(mainDataEntity.getPreInsAbbrName(), ""));
    		indto.setInsKana(StringUtils.nvl(mainDataEntity.getPreInsKana(), ""));
    		indto.setInsFormalName(StringUtils.nvl(mainDataEntity.getPreInsFormalName(), ""));
    		indto.setTradeType(StringUtils.nvl(mainDataEntity.getPreTradeType(), ""));
    		indto.setInsOpenYear(StringUtils.nvl(mainDataEntity.getPreInsOpenYear(), ""));
    		indto.setInsOpenMonth(StringUtils.nvl(mainDataEntity.getPreInsOpenMonth(), ""));
    		indto.setInsOpenDay(StringUtils.nvl(mainDataEntity.getPreInsOpenDay(), ""));
    		indto.setPharmType(StringUtils.nvl(mainDataEntity.getPharmType(), ""));
    		indto.setPharmTypeNm(StringUtils.nvl(mainDataEntity.getPharmTypeNm(), ""));
    		indto.setInsRank(StringUtils.nvl(mainDataEntity.getInsRank(), ""));
    		indto.setInsRankNm(StringUtils.nvl(mainDataEntity.getInsRankNm(), ""));
    		indto.setRegVisType(StringUtils.nvl(mainDataEntity.getRegVisType(), ""));
    		indto.setRegVisTypeNm(StringUtils.nvl(mainDataEntity.getRegVisTypeNm(), ""));
    		indto.setManageCd(StringUtils.nvl(mainDataEntity.getManageCd(), ""));
    		indto.setManageNm(StringUtils.nvl(mainDataEntity.getManageNm(), ""));
    		indto.setWsType(StringUtils.nvl(mainDataEntity.getPreWsType(), ""));
    		indto.setBasketPurchase(StringUtils.nvl(mainDataEntity.getPreBasketPurchase(), ""));
    		indto.setUnivSubdiv(StringUtils.nvl(mainDataEntity.getPreUnivSubdiv(), ""));
    		indto.setCapaType(StringUtils.nvl(mainDataEntity.getPreCapaType(), ""));

    		// ULT施設情報
    		indto.setUltInsCd(StringUtils.nvl(mainDataEntity.getUltInsCd(), ""));
    		indto.setPreUltInsCd(StringUtils.nvl(mainDataEntity.getUltInsCd(), ""));
    		indto.setShisetsuNmRyaku(StringUtils.nvl(mainDataEntity.getShisetsuNmRyaku(), ""));
    		indto.setShisetsuNm(StringUtils.nvl(mainDataEntity.getShisetsuNm(), ""));

    		// 病床数
    		indto.setBedCntBase(StringUtils.nvl(mainDataEntity.getBedCntBase(), ""));
    		indto.setBedCnt01(StringUtils.nvl(mainDataEntity.getBedCnt01(), ""));
    		indto.setBedCnt02(StringUtils.nvl(mainDataEntity.getBedCnt02(), ""));
    		indto.setBedCnt03(StringUtils.nvl(mainDataEntity.getBedCnt03(), ""));
    		indto.setBedCnt04(StringUtils.nvl(mainDataEntity.getBedCnt04(), ""));
    		indto.setBedCnt05(StringUtils.nvl(mainDataEntity.getBedCnt05(), ""));
    		indto.setBedCnt06(StringUtils.nvl(mainDataEntity.getBedCnt06(), ""));
    		indto.setBedCnt07(StringUtils.nvl(mainDataEntity.getBedCnt07(), ""));
    		indto.setBedsTot(StringUtils.nvl(mainDataEntity.getBedsTot(), ""));
    		indto.setMedBedsTot(StringUtils.nvl(mainDataEntity.getMedBedsTot(), ""));
    		indto.setUltBedCnt01(StringUtils.nvl(mainDataEntity.getUltBedCnt01(), ""));
    		indto.setUltBedCnt03(StringUtils.nvl(mainDataEntity.getUltBedCnt03(), ""));
    		indto.setUltBedCnt04(StringUtils.nvl(mainDataEntity.getUltBedCnt04(), ""));
    		indto.setUltBedCnt05(StringUtils.nvl(mainDataEntity.getUltBedCnt05(), ""));
    		indto.setUltBedCnt07(StringUtils.nvl(mainDataEntity.getUltBedCnt07(), ""));
    		indto.setUltBedsTot(StringUtils.nvl(mainDataEntity.getUltBedsTot(), ""));
    		indto.setNextBedCntBase(StringUtils.nvl(mainDataEntity.getNextBedCntBase(), ""));
    		indto.setNextBedCnt01(StringUtils.nvl(mainDataEntity.getNextBedCnt01(), ""));
    		indto.setNextBedCnt02(StringUtils.nvl(mainDataEntity.getNextBedCnt02(), ""));
    		indto.setNextBedCnt03(StringUtils.nvl(mainDataEntity.getNextBedCnt03(), ""));
    		indto.setNextBedCnt04(StringUtils.nvl(mainDataEntity.getNextBedCnt04(), ""));
    		indto.setNextBedCnt05(StringUtils.nvl(mainDataEntity.getNextBedCnt05(), ""));
    		indto.setNextBedCnt06(StringUtils.nvl(mainDataEntity.getNextBedCnt06(), ""));
    		indto.setNextBedCnt07(StringUtils.nvl(mainDataEntity.getNextBedCnt07(), ""));
    		indto.setNextBedsTot(StringUtils.nvl(mainDataEntity.getNextBedsTot(), ""));
    		indto.setNextMedBedsTot(StringUtils.nvl(mainDataEntity.getNextMedBedsTot(), ""));

    		// 住所詳細
    		indto.setPreInsPcode(StringUtils.nvl(mainDataEntity.getPreInsPcode(), ""));
    		indto.setPreAddrCodePref(StringUtils.nvl(mainDataEntity.getPreAddrCodePref(), ""));
    		indto.setPreAddrCodePrefName(StringUtils.nvl(mainDataEntity.getPreAddrCodePrefName(), ""));
    		indto.setPreAddrCodeCity(StringUtils.nvl(mainDataEntity.getPreAddrCodeCity(), ""));
    		indto.setPreAddrCodeCityName(StringUtils.nvl(mainDataEntity.getPreAddrCodeCityName(), ""));
    		indto.setPreInsAddrDt(StringUtils.nvl(mainDataEntity.getPreInsAddrDt(), ""));
    		indto.setPreTkCityCd(StringUtils.nvl(mainDataEntity.getPreTkCityCd(), ""));
    		indto.setPreTkCityName(StringUtils.nvl(mainDataEntity.getPreTkCityName(), ""));
    		indto.setPreInsPhone1(StringUtils.nvl(mainDataEntity.getPreInsPhone1(), ""));
    		indto.setPreInsPhone2(StringUtils.nvl(mainDataEntity.getPreInsPhone2(), ""));
    		indto.setPreInsFax1(StringUtils.nvl(mainDataEntity.getPreInsFax1(), ""));
    		indto.setPreInsFax2(StringUtils.nvl(mainDataEntity.getPreInsFax2(), ""));
    		indto.setPreInsUrl(StringUtils.nvl(mainDataEntity.getPreInsUrl(), ""));

    		// ホームページアドレス更新日を"yyyy/MM/dd"に変換
    		if(!"".equals(StringUtils.nvl(mainDataEntity.getPreInsUrlYmd(), "")) && mainDataEntity.getPreInsUrlYmd().length() == 8) {
    			StringBuilder sbUrlYmd = new StringBuilder();
    			sbUrlYmd.append(mainDataEntity.getPreInsUrlYmd().substring(0,4));
    			sbUrlYmd.append("/");
    			sbUrlYmd.append(mainDataEntity.getPreInsUrlYmd().substring(4,6));
    			sbUrlYmd.append("/");
    			sbUrlYmd.append(mainDataEntity.getPreInsUrlYmd().substring(6,8));
    			indto.setPreInsUrlYmd(sbUrlYmd.toString());
    		} else {
    			indto.setPreInsUrlYmd("");
    		}

    		indto.setInsPcode(StringUtils.nvl(mainDataEntity.getPreInsPcode(), ""));
    		indto.setAddrCodePref(StringUtils.nvl(mainDataEntity.getPreAddrCodePref(), ""));
    		indto.setAddrCodePrefName(StringUtils.nvl(mainDataEntity.getPreAddrCodePrefName(), ""));
    		indto.setAddrCodeCity(StringUtils.nvl(mainDataEntity.getPreAddrCodeCity(), ""));
    		indto.setAddrCodeCityName(StringUtils.nvl(mainDataEntity.getPreAddrCodeCityName(), ""));
    		indto.setInsAddrDt(StringUtils.nvl(mainDataEntity.getPreInsAddrDt(), ""));
    		indto.setTkCityCd(StringUtils.nvl(mainDataEntity.getPreTkCityCd(), ""));
    		indto.setTkCityName(StringUtils.nvl(mainDataEntity.getPreTkCityName(), ""));
    		indto.setInsPhone1(StringUtils.nvl(mainDataEntity.getPreInsPhone1(), ""));
    		indto.setInsPhone2(StringUtils.nvl(mainDataEntity.getPreInsPhone2(), ""));
    		indto.setInsFax1(StringUtils.nvl(mainDataEntity.getPreInsFax1(), ""));
    		indto.setInsFax2(StringUtils.nvl(mainDataEntity.getPreInsFax2(), ""));
    		indto.setInsUrl(StringUtils.nvl(mainDataEntity.getPreInsUrl(), ""));

    		// ホームページアドレス更新日を"yyyy-MM-dd"に変換
    		if(!"".equals(StringUtils.nvl(mainDataEntity.getPreInsUrlYmd(), "")) && mainDataEntity.getPreInsUrlYmd().length() == 8) {
    			StringBuilder sbUrlYmd = new StringBuilder();
    			sbUrlYmd.append(mainDataEntity.getPreInsUrlYmd().substring(0,4));
    			sbUrlYmd.append("-");
    			sbUrlYmd.append(mainDataEntity.getPreInsUrlYmd().substring(4,6));
    			sbUrlYmd.append("-");
    			sbUrlYmd.append(mainDataEntity.getPreInsUrlYmd().substring(6,8));
    			indto.setInsUrlYmd(sbUrlYmd.toString());
    		}

    		indto.setPreInsAddrKana(StringUtils.nvl(mainDataEntity.getInsAddrKana(), ""));
    		indto.setInsAddrKana(StringUtils.nvl(mainDataEntity.getInsAddrKana(), ""));

    		// フリー項目区分情報
    		indto.setPreFree0001(StringUtils.nvl(mainDataEntity.getPreFree0001(), ""));
    		indto.setPreFree0002(StringUtils.nvl(mainDataEntity.getPreFree0002(), ""));
    		indto.setPreFree0003(StringUtils.nvl(mainDataEntity.getPreFree0003(), ""));
    		indto.setPreFree0004(StringUtils.nvl(mainDataEntity.getPreFree0004(), ""));
    		indto.setPreFree0005(StringUtils.nvl(mainDataEntity.getPreFree0005(), ""));
    		indto.setPreFree0006(StringUtils.nvl(mainDataEntity.getPreFree0006(), ""));
    		indto.setPreFree0007(StringUtils.nvl(mainDataEntity.getPreFree0007(), ""));
    		indto.setPreFree0008(StringUtils.nvl(mainDataEntity.getPreFree0008(), ""));
    		indto.setPreFree0009(StringUtils.nvl(mainDataEntity.getPreFree0009(), ""));
    		indto.setPreFree0010(StringUtils.nvl(mainDataEntity.getPreFree0010(), ""));
    		indto.setPreFree0011(StringUtils.nvl(mainDataEntity.getPreFree0011(), ""));
    		indto.setPreFree0012(StringUtils.nvl(mainDataEntity.getPreFree0012(), ""));
    		indto.setPreFree0013(StringUtils.nvl(mainDataEntity.getPreFree0013(), ""));
    		indto.setPreFree0014(StringUtils.nvl(mainDataEntity.getPreFree0014(), ""));
    		indto.setPreFree0015(StringUtils.nvl(mainDataEntity.getPreFree0015(), ""));
    		indto.setFree0001(StringUtils.nvl(mainDataEntity.getPreFree0001(), ""));
    		indto.setFree0002(StringUtils.nvl(mainDataEntity.getPreFree0002(), ""));
    		indto.setFree0003(StringUtils.nvl(mainDataEntity.getPreFree0003(), ""));
    		indto.setFree0004(StringUtils.nvl(mainDataEntity.getPreFree0004(), ""));
    		indto.setFree0005(StringUtils.nvl(mainDataEntity.getPreFree0005(), ""));
    		indto.setFree0006(StringUtils.nvl(mainDataEntity.getPreFree0006(), ""));
    		indto.setFree0007(StringUtils.nvl(mainDataEntity.getPreFree0007(), ""));
    		indto.setFree0008(StringUtils.nvl(mainDataEntity.getPreFree0008(), ""));
    		indto.setFree0009(StringUtils.nvl(mainDataEntity.getPreFree0009(), ""));
    		indto.setFree0010(StringUtils.nvl(mainDataEntity.getPreFree0010(), ""));
    		indto.setFree0011(StringUtils.nvl(mainDataEntity.getPreFree0011(), ""));
    		indto.setFree0012(StringUtils.nvl(mainDataEntity.getPreFree0012(), ""));
    		indto.setFree0013(StringUtils.nvl(mainDataEntity.getPreFree0013(), ""));
    		indto.setFree0014(StringUtils.nvl(mainDataEntity.getPreFree0014(), ""));
    		indto.setFree0015(StringUtils.nvl(mainDataEntity.getPreFree0015(), ""));

    		// 老人福祉法関連分類情報
    		indto.setPreWelfare02(StringUtils.nvl(mainDataEntity.getPreWelfare02(), ""));
    		indto.setPreWelfare08(StringUtils.nvl(mainDataEntity.getPreWelfare08(), ""));

    		if(mainDataEntity.getPreWelfare02() != null && !mainDataEntity.getPreWelfare02().isEmpty()) {
    			indto.setPreWelfare02Nm(StringUtils.nvl(mainDataEntity.getPreWelfare02Nm(), ""));
    		} else {
    			indto.setPreWelfare02Nm("--なし--");
    		}
    		if(mainDataEntity.getPreWelfare08() != null && !mainDataEntity.getPreWelfare08().isEmpty()) {
    			indto.setPreWelfare08Nm(StringUtils.nvl(mainDataEntity.getPreWelfare08Nm(), ""));
    		} else {
    			indto.setPreWelfare08Nm("--なし--");
    		}

    		indto.setWelfare02(StringUtils.nvl(mainDataEntity.getPreWelfare02(), ""));
    		indto.setWelfare08(StringUtils.nvl(mainDataEntity.getPreWelfare08(), ""));

    		// 実績把握区分情報
    		indto.setPreResult01(StringUtils.nvl(mainDataEntity.getPreResult01(), ""));
    		indto.setPreResult02(StringUtils.nvl(mainDataEntity.getPreResult02(), ""));
    		indto.setPreResult03(StringUtils.nvl(mainDataEntity.getPreResult03(), ""));
    		indto.setPreResult04(StringUtils.nvl(mainDataEntity.getPreResult04(), ""));
    		indto.setPreResult05(StringUtils.nvl(mainDataEntity.getPreResult05(), ""));
    		indto.setPreResult06(StringUtils.nvl(mainDataEntity.getPreResult06(), ""));
    		indto.setPreResult07(StringUtils.nvl(mainDataEntity.getPreResult07(), ""));
    		indto.setPreResult08(StringUtils.nvl(mainDataEntity.getPreResult08(), ""));
    		indto.setPreResult09(StringUtils.nvl(mainDataEntity.getPreResult09(), ""));
    		indto.setPreResult10(StringUtils.nvl(mainDataEntity.getPreResult10(), ""));
    		indto.setPreResult11(StringUtils.nvl(mainDataEntity.getPreResult11(), ""));
    		indto.setPreResult12(StringUtils.nvl(mainDataEntity.getPreResult12(), ""));
    		indto.setPreResult13(StringUtils.nvl(mainDataEntity.getPreResult13(), ""));
    		indto.setPreResult14(StringUtils.nvl(mainDataEntity.getPreResult14(), ""));
    		indto.setPreResult15(StringUtils.nvl(mainDataEntity.getPreResult15(), ""));
    		indto.setPreResult16(StringUtils.nvl(mainDataEntity.getPreResult16(), ""));
    		indto.setPreResult17(StringUtils.nvl(mainDataEntity.getPreResult17(), ""));
    		indto.setPreResult18(StringUtils.nvl(mainDataEntity.getPreResult18(), ""));
    		indto.setPreResult19(StringUtils.nvl(mainDataEntity.getPreResult19(), ""));
    		indto.setPreResult20(StringUtils.nvl(mainDataEntity.getPreResult20(), ""));
    		indto.setPreResult21(StringUtils.nvl(mainDataEntity.getPreResult21(), ""));
    		indto.setPreResult22(StringUtils.nvl(mainDataEntity.getPreResult22(), ""));
    		indto.setPreResult23(StringUtils.nvl(mainDataEntity.getPreResult23(), ""));
    		indto.setPreResult24(StringUtils.nvl(mainDataEntity.getPreResult24(), ""));
    		indto.setPreResult25(StringUtils.nvl(mainDataEntity.getPreResult25(), ""));
    		indto.setPreResult26(StringUtils.nvl(mainDataEntity.getPreResult26(), ""));
    		indto.setPreResult27(StringUtils.nvl(mainDataEntity.getPreResult27(), ""));
    		indto.setPreResult28(StringUtils.nvl(mainDataEntity.getPreResult28(), ""));
    		indto.setPreResult29(StringUtils.nvl(mainDataEntity.getPreResult29(), ""));
    		indto.setPreResult30(StringUtils.nvl(mainDataEntity.getPreResult30(), ""));
    		indto.setPreResult31(StringUtils.nvl(mainDataEntity.getPreResult31(), ""));
    		indto.setPreResult32(StringUtils.nvl(mainDataEntity.getPreResult32(), ""));
    		indto.setPreResult33(StringUtils.nvl(mainDataEntity.getPreResult33(), ""));
    		indto.setPreResult34(StringUtils.nvl(mainDataEntity.getPreResult34(), ""));
    		indto.setPreResult35(StringUtils.nvl(mainDataEntity.getPreResult35(), ""));
    		indto.setPreResult36(StringUtils.nvl(mainDataEntity.getPreResult36(), ""));

    		if(mainDataEntity.getPreResult01() != null && !mainDataEntity.getPreResult01().isEmpty()) {
    			indto.setPreResult01Nm(StringUtils.nvl(mainDataEntity.getPreResult01Nm(), ""));
    		} else {
    			indto.setPreResult01Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult02() != null && !mainDataEntity.getPreResult02().isEmpty()) {
    			indto.setPreResult02Nm(StringUtils.nvl(mainDataEntity.getPreResult02Nm(), ""));
    		} else {
    			indto.setPreResult02Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult03() != null && !mainDataEntity.getPreResult03().isEmpty()) {
    			indto.setPreResult03Nm(StringUtils.nvl(mainDataEntity.getPreResult03Nm(), ""));
    		} else {
    			indto.setPreResult03Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult04() != null && !mainDataEntity.getPreResult04().isEmpty()) {
    			indto.setPreResult04Nm(StringUtils.nvl(mainDataEntity.getPreResult04Nm(), ""));
    		} else {
    			indto.setPreResult04Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult05() != null && !mainDataEntity.getPreResult05().isEmpty()) {
    			indto.setPreResult05Nm(StringUtils.nvl(mainDataEntity.getPreResult05Nm(), ""));
    		} else {
    			indto.setPreResult05Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult06() != null && !mainDataEntity.getPreResult06().isEmpty()) {
    			indto.setPreResult06Nm(StringUtils.nvl(mainDataEntity.getPreResult06Nm(), ""));
    		} else {
    			indto.setPreResult06Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult07() != null && !mainDataEntity.getPreResult07().isEmpty()) {
    			indto.setPreResult07Nm(StringUtils.nvl(mainDataEntity.getPreResult07Nm(), ""));
    		} else {
    			indto.setPreResult07Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult08() != null && !mainDataEntity.getPreResult08().isEmpty()) {
    			indto.setPreResult08Nm(StringUtils.nvl(mainDataEntity.getPreResult08Nm(), ""));
    		} else {
    			indto.setPreResult08Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult09() != null && !mainDataEntity.getPreResult09().isEmpty()) {
    			indto.setPreResult09Nm(StringUtils.nvl(mainDataEntity.getPreResult09Nm(), ""));
    		} else {
    			indto.setPreResult09Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult10() != null && !mainDataEntity.getPreResult10().isEmpty()) {
    			indto.setPreResult10Nm(StringUtils.nvl(mainDataEntity.getPreResult10Nm(), ""));
    		} else {
    			indto.setPreResult10Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult11() != null && !mainDataEntity.getPreResult11().isEmpty()) {
    			indto.setPreResult11Nm(StringUtils.nvl(mainDataEntity.getPreResult11Nm(), ""));
    		} else {
    			indto.setPreResult11Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult12() != null && !mainDataEntity.getPreResult12().isEmpty()) {
    			indto.setPreResult12Nm(StringUtils.nvl(mainDataEntity.getPreResult12Nm(), ""));
    		} else {
    			indto.setPreResult12Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult13() != null && !mainDataEntity.getPreResult13().isEmpty()) {
    			indto.setPreResult13Nm(StringUtils.nvl(mainDataEntity.getPreResult13Nm(), ""));
    		} else {
    			indto.setPreResult13Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult14() != null && !mainDataEntity.getPreResult14().isEmpty()) {
    			indto.setPreResult14Nm(StringUtils.nvl(mainDataEntity.getPreResult14Nm(), ""));
    		} else {
    			indto.setPreResult14Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult15() != null && !mainDataEntity.getPreResult15().isEmpty()) {
    			indto.setPreResult15Nm(StringUtils.nvl(mainDataEntity.getPreResult15Nm(), ""));
    		} else {
    			indto.setPreResult15Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult16() != null && !mainDataEntity.getPreResult16().isEmpty()) {
    			indto.setPreResult16Nm(StringUtils.nvl(mainDataEntity.getPreResult16Nm(), ""));
    		} else {
    			indto.setPreResult16Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult17() != null && !mainDataEntity.getPreResult17().isEmpty()) {
    			indto.setPreResult17Nm(StringUtils.nvl(mainDataEntity.getPreResult17Nm(), ""));
    		} else {
    			indto.setPreResult17Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult18() != null && !mainDataEntity.getPreResult18().isEmpty()) {
    			indto.setPreResult18Nm(StringUtils.nvl(mainDataEntity.getPreResult18Nm(), ""));
    		} else {
    			indto.setPreResult18Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult19() != null && !mainDataEntity.getPreResult19().isEmpty()) {
    			indto.setPreResult19Nm(StringUtils.nvl(mainDataEntity.getPreResult19Nm(), ""));
    		} else {
    			indto.setPreResult19Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult20() != null && !mainDataEntity.getPreResult20().isEmpty()) {
    			indto.setPreResult20Nm(StringUtils.nvl(mainDataEntity.getPreResult20Nm(), ""));
    		} else {
    			indto.setPreResult20Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult21() != null && !mainDataEntity.getPreResult21().isEmpty()) {
    			indto.setPreResult21Nm(StringUtils.nvl(mainDataEntity.getPreResult21Nm(), ""));
    		} else {
    			indto.setPreResult21Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult22() != null && !mainDataEntity.getPreResult22().isEmpty()) {
    			indto.setPreResult22Nm(StringUtils.nvl(mainDataEntity.getPreResult22Nm(), ""));
    		} else {
    			indto.setPreResult22Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult23() != null && !mainDataEntity.getPreResult23().isEmpty()) {
    			indto.setPreResult23Nm(StringUtils.nvl(mainDataEntity.getPreResult23Nm(), ""));
    		} else {
    			indto.setPreResult23Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult24() != null && !mainDataEntity.getPreResult24().isEmpty()) {
    			indto.setPreResult24Nm(StringUtils.nvl(mainDataEntity.getPreResult24Nm(), ""));
    		} else {
    			indto.setPreResult24Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult25() != null && !mainDataEntity.getPreResult25().isEmpty()) {
    			indto.setPreResult25Nm(StringUtils.nvl(mainDataEntity.getPreResult25Nm(), ""));
    		} else {
    			indto.setPreResult25Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult26() != null && !mainDataEntity.getPreResult26().isEmpty()) {
    			indto.setPreResult26Nm(StringUtils.nvl(mainDataEntity.getPreResult26Nm(), ""));
    		} else {
    			indto.setPreResult26Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult27() != null && !mainDataEntity.getPreResult27().isEmpty()) {
    			indto.setPreResult27Nm(StringUtils.nvl(mainDataEntity.getPreResult27Nm(), ""));
    		} else {
    			indto.setPreResult27Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult28() != null && !mainDataEntity.getPreResult28().isEmpty()) {
    			indto.setPreResult28Nm(StringUtils.nvl(mainDataEntity.getPreResult28Nm(), ""));
    		} else {
    			indto.setPreResult28Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult29() != null && !mainDataEntity.getPreResult29().isEmpty()) {
    			indto.setPreResult29Nm(StringUtils.nvl(mainDataEntity.getPreResult29Nm(), ""));
    		} else {
    			indto.setPreResult29Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult30() != null && !mainDataEntity.getPreResult30().isEmpty()) {
    			indto.setPreResult30Nm(StringUtils.nvl(mainDataEntity.getPreResult30Nm(), ""));
    		} else {
    			indto.setPreResult30Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult31() != null && !mainDataEntity.getPreResult31().isEmpty()) {
    			indto.setPreResult31Nm(StringUtils.nvl(mainDataEntity.getPreResult31Nm(), ""));
    		} else {
    			indto.setPreResult31Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult32() != null && !mainDataEntity.getPreResult32().isEmpty()) {
    			indto.setPreResult32Nm(StringUtils.nvl(mainDataEntity.getPreResult32Nm(), ""));
    		} else {
    			indto.setPreResult32Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult33() != null && !mainDataEntity.getPreResult33().isEmpty()) {
    			indto.setPreResult33Nm(StringUtils.nvl(mainDataEntity.getPreResult33Nm(), ""));
    		} else {
    			indto.setPreResult33Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult34() != null && !mainDataEntity.getPreResult34().isEmpty()) {
    			indto.setPreResult34Nm(StringUtils.nvl(mainDataEntity.getPreResult34Nm(), ""));
    		} else {
    			indto.setPreResult34Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult35() != null && !mainDataEntity.getPreResult35().isEmpty()) {
    			indto.setPreResult35Nm(StringUtils.nvl(mainDataEntity.getPreResult35Nm(), ""));
    		} else {
    			indto.setPreResult35Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult36() != null && !mainDataEntity.getPreResult36().isEmpty()) {
    			indto.setPreResult36Nm(StringUtils.nvl(mainDataEntity.getPreResult36Nm(), ""));
    		} else {
    			indto.setPreResult36Nm("--なし--");
    		}

    		indto.setResult01(StringUtils.nvl(mainDataEntity.getPreResult01(), ""));
    		indto.setResult02(StringUtils.nvl(mainDataEntity.getPreResult02(), ""));
    		indto.setResult03(StringUtils.nvl(mainDataEntity.getPreResult03(), ""));
    		indto.setResult04(StringUtils.nvl(mainDataEntity.getPreResult04(), ""));
    		indto.setResult05(StringUtils.nvl(mainDataEntity.getPreResult05(), ""));
    		indto.setResult06(StringUtils.nvl(mainDataEntity.getPreResult06(), ""));
    		indto.setResult07(StringUtils.nvl(mainDataEntity.getPreResult07(), ""));
    		indto.setResult08(StringUtils.nvl(mainDataEntity.getPreResult08(), ""));
    		indto.setResult09(StringUtils.nvl(mainDataEntity.getPreResult09(), ""));
    		indto.setResult10(StringUtils.nvl(mainDataEntity.getPreResult10(), ""));
    		indto.setResult11(StringUtils.nvl(mainDataEntity.getPreResult11(), ""));
    		indto.setResult12(StringUtils.nvl(mainDataEntity.getPreResult12(), ""));
    		indto.setResult13(StringUtils.nvl(mainDataEntity.getPreResult13(), ""));
    		indto.setResult14(StringUtils.nvl(mainDataEntity.getPreResult14(), ""));
    		indto.setResult15(StringUtils.nvl(mainDataEntity.getPreResult15(), ""));
    		indto.setResult16(StringUtils.nvl(mainDataEntity.getPreResult16(), ""));
    		indto.setResult17(StringUtils.nvl(mainDataEntity.getPreResult17(), ""));
    		indto.setResult18(StringUtils.nvl(mainDataEntity.getPreResult18(), ""));
    		indto.setResult19(StringUtils.nvl(mainDataEntity.getPreResult19(), ""));
    		indto.setResult20(StringUtils.nvl(mainDataEntity.getPreResult20(), ""));
    		indto.setResult21(StringUtils.nvl(mainDataEntity.getPreResult21(), ""));
    		indto.setResult22(StringUtils.nvl(mainDataEntity.getPreResult22(), ""));
    		indto.setResult23(StringUtils.nvl(mainDataEntity.getPreResult23(), ""));
    		indto.setResult24(StringUtils.nvl(mainDataEntity.getPreResult24(), ""));
    		indto.setResult25(StringUtils.nvl(mainDataEntity.getPreResult25(), ""));
    		indto.setResult26(StringUtils.nvl(mainDataEntity.getPreResult26(), ""));
    		indto.setResult27(StringUtils.nvl(mainDataEntity.getPreResult27(), ""));
    		indto.setResult28(StringUtils.nvl(mainDataEntity.getPreResult28(), ""));
    		indto.setResult29(StringUtils.nvl(mainDataEntity.getPreResult29(), ""));
    		indto.setResult30(StringUtils.nvl(mainDataEntity.getPreResult30(), ""));
    		indto.setResult31(StringUtils.nvl(mainDataEntity.getPreResult31(), ""));
    		indto.setResult32(StringUtils.nvl(mainDataEntity.getPreResult32(), ""));
    		indto.setResult33(StringUtils.nvl(mainDataEntity.getPreResult33(), ""));
    		indto.setResult34(StringUtils.nvl(mainDataEntity.getPreResult34(), ""));
    		indto.setResult35(StringUtils.nvl(mainDataEntity.getPreResult35(), ""));
    		indto.setResult36(StringUtils.nvl(mainDataEntity.getPreResult36(), ""));

    		// 病院設備情報
    		indto.setPreEquip01(StringUtils.nvl(mainDataEntity.getPreEquip01(), ""));
    		indto.setPreEquip02(StringUtils.nvl(mainDataEntity.getPreEquip02(), ""));
    		indto.setPreEquip03(StringUtils.nvl(mainDataEntity.getPreEquip03(), ""));
    		indto.setPreEquip07(StringUtils.nvl(mainDataEntity.getPreEquip07(), ""));
    		indto.setPreEquip09(StringUtils.nvl(mainDataEntity.getPreEquip09(), ""));

    		if(mainDataEntity.getPreEquip01() != null && !mainDataEntity.getPreEquip01().isEmpty()) {
    			indto.setPreEquip01Nm(StringUtils.nvl(mainDataEntity.getPreEquip01Nm(), ""));
    		} else {
    			indto.setPreEquip01Nm("--なし--");
    		}
    		if(mainDataEntity.getPreEquip02() != null && !mainDataEntity.getPreEquip02().isEmpty()) {
    			indto.setPreEquip02Nm(StringUtils.nvl(mainDataEntity.getPreEquip02Nm(), ""));
    		} else {
    			indto.setPreEquip02Nm("--なし--");
    		}
    		if(mainDataEntity.getPreEquip03() != null && !mainDataEntity.getPreEquip03().isEmpty()) {
    			indto.setPreEquip03Nm(StringUtils.nvl(mainDataEntity.getPreEquip03Nm(), ""));
    		} else {
    			indto.setPreEquip03Nm("--なし--");
    		}
    		if(mainDataEntity.getPreEquip07() != null && !mainDataEntity.getPreEquip07().isEmpty()) {
    			indto.setPreEquip07Nm(StringUtils.nvl(mainDataEntity.getPreEquip07Nm(), ""));
    		} else {
    			indto.setPreEquip07Nm("--なし--");
    		}
    		if(mainDataEntity.getPreEquip09() != null && !mainDataEntity.getPreEquip09().isEmpty()) {
    			indto.setPreEquip09Nm(StringUtils.nvl(mainDataEntity.getPreEquip09Nm(), ""));
    		} else {
    			indto.setPreEquip09Nm("--なし--");
    		}

    		indto.setEquip01(StringUtils.nvl(mainDataEntity.getPreEquip01(), ""));
    		indto.setEquip02(StringUtils.nvl(mainDataEntity.getPreEquip02(), ""));
    		indto.setEquip03(StringUtils.nvl(mainDataEntity.getPreEquip03(), ""));
    		indto.setEquip07(StringUtils.nvl(mainDataEntity.getPreEquip07(), ""));
    		indto.setEquip09(StringUtils.nvl(mainDataEntity.getPreEquip09(), ""));

    		// 市場規模情報
    		indto.setPreMarket01(StringUtils.nvl(mainDataEntity.getPreMarket01(), ""));
    		indto.setPreMarket02(StringUtils.nvl(mainDataEntity.getPreMarket02(), ""));
    		indto.setPreMarket03(StringUtils.nvl(mainDataEntity.getPreMarket03(), ""));
    		indto.setPreMarket04(StringUtils.nvl(mainDataEntity.getPreMarket04(), ""));
    		indto.setPreMarket06(StringUtils.nvl(mainDataEntity.getPreMarket06(), ""));
    		indto.setPreMarket07(StringUtils.nvl(mainDataEntity.getPreMarket07(), ""));
    		indto.setPreMarket09(StringUtils.nvl(mainDataEntity.getPreMarket09(), ""));

    		if(mainDataEntity.getPreMarket01() != null && !mainDataEntity.getPreMarket01().isEmpty()) {
    			indto.setPreMarket01Nm(mainDataEntity.getPreMarket01() + "：" + StringUtils.nvl(mainDataEntity.getPreMarket01Nm(), ""));
    		} else {
    			indto.setPreMarket01Nm("--なし--");
    		}
    		if(mainDataEntity.getPreMarket02() != null && !mainDataEntity.getPreMarket02().isEmpty()) {
    			indto.setPreMarket02Nm(mainDataEntity.getPreMarket02() + "：" + StringUtils.nvl(mainDataEntity.getPreMarket02Nm(), ""));
    		} else {
    			indto.setPreMarket02Nm("--なし--");
    		}
    		if(mainDataEntity.getPreMarket03() != null && !mainDataEntity.getPreMarket03().isEmpty()) {
    			indto.setPreMarket03Nm(mainDataEntity.getPreMarket03() + "：" + StringUtils.nvl(mainDataEntity.getPreMarket03Nm(), ""));
    		} else {
    			indto.setPreMarket03Nm("--なし--");
    		}
    		if(mainDataEntity.getPreMarket04() != null && !mainDataEntity.getPreMarket04().isEmpty()) {
    			indto.setPreMarket04Nm(mainDataEntity.getPreMarket04() + "：" + StringUtils.nvl(mainDataEntity.getPreMarket04Nm(), ""));
    		} else {
    			indto.setPreMarket04Nm("--なし--");
    		}
    		if(mainDataEntity.getPreMarket06() != null && !mainDataEntity.getPreMarket06().isEmpty()) {
    			indto.setPreMarket06Nm(mainDataEntity.getPreMarket06() + "：" + StringUtils.nvl(mainDataEntity.getPreMarket06Nm(), ""));
    		} else {
    			indto.setPreMarket06Nm("--なし--");
    		}
    		if(mainDataEntity.getPreMarket07() != null && !mainDataEntity.getPreMarket07().isEmpty()) {
    			indto.setPreMarket07Nm(mainDataEntity.getPreMarket07() + "：" + StringUtils.nvl(mainDataEntity.getPreMarket07Nm(), ""));
    		} else {
    			indto.setPreMarket07Nm("--なし--");
    		}
    		if(mainDataEntity.getPreMarket09() != null && !mainDataEntity.getPreMarket09().isEmpty()) {
    			indto.setPreMarket09Nm(mainDataEntity.getPreMarket09() + "：" + StringUtils.nvl(mainDataEntity.getPreMarket09Nm(), ""));
    		} else {
    			indto.setPreMarket09Nm("--なし--");
    		}

    		indto.setMarket01(StringUtils.nvl(mainDataEntity.getPreMarket01(), ""));
    		indto.setMarket02(StringUtils.nvl(mainDataEntity.getPreMarket02(), ""));
    		indto.setMarket03(StringUtils.nvl(mainDataEntity.getPreMarket03(), ""));
    		indto.setMarket04(StringUtils.nvl(mainDataEntity.getPreMarket04(), ""));
    		indto.setMarket06(StringUtils.nvl(mainDataEntity.getPreMarket06(), ""));
    		indto.setMarket07(StringUtils.nvl(mainDataEntity.getPreMarket07(), ""));
    		indto.setMarket09(StringUtils.nvl(mainDataEntity.getPreMarket09(), ""));

    		// 医療法関連分類情報
    		indto.setPreMedical12(StringUtils.nvl(mainDataEntity.getPreMedical12(), ""));

    		if(mainDataEntity.getPreMedical12() != null && !mainDataEntity.getPreMedical12().isEmpty()) {
    			indto.setPreMedical12Nm(StringUtils.nvl(mainDataEntity.getPreMedical12Nm(), ""));
    		} else {
    			indto.setPreMedical12Nm("--なし--");
    		}

    		indto.setMedical12(StringUtils.nvl(mainDataEntity.getPreMedical12(), ""));

    		// 特別な機能情報
    		indto.setPreSpfunc01(StringUtils.nvl(mainDataEntity.getPreSpfunc01(), ""));
    		indto.setPreSpfunc03(StringUtils.nvl(mainDataEntity.getPreSpfunc03(), ""));
    		indto.setPreSpfunc04(StringUtils.nvl(mainDataEntity.getPreSpfunc04(), ""));

    		if(mainDataEntity.getPreSpfunc01() != null && !mainDataEntity.getPreSpfunc01().isEmpty()) {
    			indto.setPreSpfunc01Nm(mainDataEntity.getPreSpfunc01() + "：" + StringUtils.nvl(mainDataEntity.getPreSpfunc01Nm(), ""));
    		} else {
    			indto.setPreSpfunc01Nm("--なし--");
    		}
    		if(mainDataEntity.getPreSpfunc03() != null && !mainDataEntity.getPreSpfunc03().isEmpty()) {
    			indto.setPreSpfunc03Nm(mainDataEntity.getPreSpfunc03() + "：" + StringUtils.nvl(mainDataEntity.getPreSpfunc03Nm(), ""));
    		} else {
    			indto.setPreSpfunc03Nm("--なし--");
    		}
    		if(mainDataEntity.getPreSpfunc04() != null && !mainDataEntity.getPreSpfunc04().isEmpty()) {
    			indto.setPreSpfunc04Nm(mainDataEntity.getPreSpfunc04() + "：" + StringUtils.nvl(mainDataEntity.getPreSpfunc04Nm(), ""));
    		} else {
    			indto.setPreSpfunc04Nm("--なし--");
    		}

    		indto.setSpfunc01(StringUtils.nvl(mainDataEntity.getPreSpfunc01(), ""));
    		indto.setSpfunc03(StringUtils.nvl(mainDataEntity.getPreSpfunc03(), ""));
    		indto.setSpfunc04(StringUtils.nvl(mainDataEntity.getPreSpfunc04(), ""));

    		// 医療連携関連情報
    		indto.setPreTieup10(StringUtils.nvl(mainDataEntity.getPreTieup10(), ""));
    		indto.setPreTieup11(StringUtils.nvl(mainDataEntity.getPreTieup11(), ""));
    		indto.setPreTieup12(StringUtils.nvl(mainDataEntity.getPreTieup12(), ""));

    		if(mainDataEntity.getPreTieup10() != null && !mainDataEntity.getPreTieup10().isEmpty()) {
    			indto.setPreTieup10Nm(mainDataEntity.getPreTieup10() + "：" + StringUtils.nvl(mainDataEntity.getPreTieup10Nm(), ""));
    		} else {
    			indto.setPreTieup10Nm("--なし--");
    		}
    		if(mainDataEntity.getPreTieup11() != null && !mainDataEntity.getPreTieup11().isEmpty()) {
    			indto.setPreTieup11Nm(mainDataEntity.getPreTieup11() + "：" + StringUtils.nvl(mainDataEntity.getPreTieup11Nm(), ""));
    		} else {
    			indto.setPreTieup11Nm("--なし--");
    		}
    		if(mainDataEntity.getPreTieup12() != null && !mainDataEntity.getPreTieup12().isEmpty()) {
    			indto.setPreTieup12Nm(mainDataEntity.getPreTieup12() + "：" + StringUtils.nvl(mainDataEntity.getPreTieup12Nm(), ""));
    		} else {
    			indto.setPreTieup12Nm("--なし--");
    		}

    		indto.setTieup10(StringUtils.nvl(mainDataEntity.getPreTieup10(), ""));
    		indto.setTieup11(StringUtils.nvl(mainDataEntity.getPreTieup11(), ""));
    		indto.setTieup12(StringUtils.nvl(mainDataEntity.getPreTieup12(), ""));

    		// ユーザーコード情報
    		indto.setPreUsercd0001(StringUtils.nvl(mainDataEntity.getPreUsercd0001(), ""));
    		indto.setPreUsercd0002(StringUtils.nvl(mainDataEntity.getPreUsercd0002(), ""));
    		indto.setPreUsercd0003(StringUtils.nvl(mainDataEntity.getPreUsercd0003(), ""));
    		indto.setPreUsercd0004(StringUtils.nvl(mainDataEntity.getPreUsercd0004(), ""));
    		indto.setPreUsercd0005(StringUtils.nvl(mainDataEntity.getPreUsercd0005(), ""));
    		indto.setPreUsercd0006(StringUtils.nvl(mainDataEntity.getPreUsercd0006(), ""));
    		indto.setPreUsercd0007(StringUtils.nvl(mainDataEntity.getPreUsercd0007(), ""));
    		indto.setPreUsercd0008(StringUtils.nvl(mainDataEntity.getPreUsercd0008(), ""));
    		indto.setPreUsercd0009(StringUtils.nvl(mainDataEntity.getPreUsercd0009(), ""));
    		indto.setPreUsercd0010(StringUtils.nvl(mainDataEntity.getPreUsercd0010(), ""));
    		indto.setPreUsercd0011(StringUtils.nvl(mainDataEntity.getPreUsercd0011(), ""));
    		indto.setPreUsercd0012(StringUtils.nvl(mainDataEntity.getPreUsercd0012(), ""));
    		indto.setPreUsercd0013(StringUtils.nvl(mainDataEntity.getPreUsercd0013(), ""));
    		indto.setPreUsercd0014(StringUtils.nvl(mainDataEntity.getPreUsercd0014(), ""));
    		indto.setPreUsercd0015(StringUtils.nvl(mainDataEntity.getPreUsercd0015(), ""));
    		indto.setPreUsercd0016(StringUtils.nvl(mainDataEntity.getPreUsercd0016(), ""));
    		indto.setPreUsercd0017(StringUtils.nvl(mainDataEntity.getPreUsercd0017(), ""));
    		indto.setPreUsercd0018(StringUtils.nvl(mainDataEntity.getPreUsercd0018(), ""));
    		indto.setPreUsercd0019(StringUtils.nvl(mainDataEntity.getPreUsercd0019(), ""));
    		indto.setPreUsercd0020(StringUtils.nvl(mainDataEntity.getPreUsercd0020(), ""));
    		indto.setPreUsercd0021(StringUtils.nvl(mainDataEntity.getPreUsercd0021(), ""));
    		indto.setPreUsercd0022(StringUtils.nvl(mainDataEntity.getPreUsercd0022(), ""));
    		indto.setPreUsercd0023(StringUtils.nvl(mainDataEntity.getPreUsercd0023(), ""));
    		indto.setPreUsercd0024(StringUtils.nvl(mainDataEntity.getPreUsercd0024(), ""));
    		indto.setPreUsercd0025(StringUtils.nvl(mainDataEntity.getPreUsercd0025(), ""));
    		indto.setPreUsercd0026(StringUtils.nvl(mainDataEntity.getPreUsercd0026(), ""));
    		indto.setPreUsercd0027(StringUtils.nvl(mainDataEntity.getPreUsercd0027(), ""));
    		indto.setPreUsercd0028(StringUtils.nvl(mainDataEntity.getPreUsercd0028(), ""));
    		indto.setPreUsercd0029(StringUtils.nvl(mainDataEntity.getPreUsercd0029(), ""));
    		indto.setPreUsercd0030(StringUtils.nvl(mainDataEntity.getPreUsercd0030(), ""));
    		indto.setPreUsercd0031(StringUtils.nvl(mainDataEntity.getPreUsercd0031(), ""));
    		indto.setPreUsercd0032(StringUtils.nvl(mainDataEntity.getPreUsercd0032(), ""));
    		indto.setPreUsercd0033(StringUtils.nvl(mainDataEntity.getPreUsercd0033(), ""));
    		indto.setPreUsercd0034(StringUtils.nvl(mainDataEntity.getPreUsercd0034(), ""));
    		indto.setPreUsercd0035(StringUtils.nvl(mainDataEntity.getPreUsercd0035(), ""));
    		indto.setPreUsercd0036(StringUtils.nvl(mainDataEntity.getPreUsercd0036(), ""));
    		indto.setPreUsercd0101(StringUtils.nvl(mainDataEntity.getPreUsercd0101(), ""));
    		indto.setPreUsercd0102(StringUtils.nvl(mainDataEntity.getPreUsercd0102(), ""));
    		indto.setPreUsercd0103(StringUtils.nvl(mainDataEntity.getPreUsercd0103(), ""));
    		indto.setPreUsercd0104(StringUtils.nvl(mainDataEntity.getPreUsercd0104(), ""));
    		indto.setPreUsercd0105(StringUtils.nvl(mainDataEntity.getPreUsercd0105(), ""));
    		indto.setPreUsercd0106(StringUtils.nvl(mainDataEntity.getPreUsercd0106(), ""));
    		indto.setPreUsercd0107(StringUtils.nvl(mainDataEntity.getPreUsercd0107(), ""));
    		indto.setPreUsercd0108(StringUtils.nvl(mainDataEntity.getPreUsercd0108(), ""));
    		indto.setPreUsercd0109(StringUtils.nvl(mainDataEntity.getPreUsercd0109(), ""));
    		indto.setPreUsercd0201(StringUtils.nvl(mainDataEntity.getPreUsercd0201(), ""));
    		indto.setPreUsercd0202(StringUtils.nvl(mainDataEntity.getPreUsercd0202(), ""));
    		indto.setPreUsercd0203(StringUtils.nvl(mainDataEntity.getPreUsercd0203(), ""));
    		indto.setPreUsercd0204(StringUtils.nvl(mainDataEntity.getPreUsercd0204(), ""));
    		indto.setPreUsercd0205(StringUtils.nvl(mainDataEntity.getPreUsercd0205(), ""));
    		indto.setPreUsercd0206(StringUtils.nvl(mainDataEntity.getPreUsercd0206(), ""));

    		if(mainDataEntity.getPreUsercd0001() != null && !mainDataEntity.getPreUsercd0001().isEmpty()) {
    			indto.setPreUsercd0001Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0001Nm(), ""));
    		} else {
    			indto.setPreUsercd0001Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0002() != null && !mainDataEntity.getPreUsercd0002().isEmpty()) {
    			indto.setPreUsercd0002Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0002Nm(), ""));
    		} else {
    			indto.setPreUsercd0002Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0003() != null && !mainDataEntity.getPreUsercd0003().isEmpty()) {
    			indto.setPreUsercd0003Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0003Nm(), ""));
    		} else {
    			indto.setPreUsercd0003Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0004() != null && !mainDataEntity.getPreUsercd0004().isEmpty()) {
    			indto.setPreUsercd0004Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0004Nm(), ""));
    		} else {
    			indto.setPreUsercd0004Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0005() != null && !mainDataEntity.getPreUsercd0005().isEmpty()) {
    			indto.setPreUsercd0005Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0005Nm(), ""));
    		} else {
    			indto.setPreUsercd0005Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0006() != null && !mainDataEntity.getPreUsercd0006().isEmpty()) {
    			indto.setPreUsercd0006Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0006Nm(), ""));
    		} else {
    			indto.setPreUsercd0006Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0007() != null && !mainDataEntity.getPreUsercd0007().isEmpty()) {
    			indto.setPreUsercd0007Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0007Nm(), ""));
    		} else {
    			indto.setPreUsercd0007Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0008() != null && !mainDataEntity.getPreUsercd0008().isEmpty()) {
    			indto.setPreUsercd0008Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0008Nm(), ""));
    		} else {
    			indto.setPreUsercd0008Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0009() != null && !mainDataEntity.getPreUsercd0009().isEmpty()) {
    			indto.setPreUsercd0009Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0009Nm(), ""));
    		} else {
    			indto.setPreUsercd0009Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0010() != null && !mainDataEntity.getPreUsercd0010().isEmpty()) {
    			indto.setPreUsercd0010Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0010Nm(), ""));
    		} else {
    			indto.setPreUsercd0010Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0011() != null && !mainDataEntity.getPreUsercd0011().isEmpty()) {
    			indto.setPreUsercd0011Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0011Nm(), ""));
    		} else {
    			indto.setPreUsercd0011Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0012() != null && !mainDataEntity.getPreUsercd0012().isEmpty()) {
    			indto.setPreUsercd0012Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0012Nm(), ""));
    		} else {
    			indto.setPreUsercd0012Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0013() != null && !mainDataEntity.getPreUsercd0013().isEmpty()) {
    			indto.setPreUsercd0013Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0013Nm(), ""));
    		} else {
    			indto.setPreUsercd0013Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0014() != null && !mainDataEntity.getPreUsercd0014().isEmpty()) {
    			indto.setPreUsercd0014Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0014Nm(), ""));
    		} else {
    			indto.setPreUsercd0014Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0015() != null && !mainDataEntity.getPreUsercd0015().isEmpty()) {
    			indto.setPreUsercd0015Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0015Nm(), ""));
    		} else {
    			indto.setPreUsercd0015Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0016() != null && !mainDataEntity.getPreUsercd0016().isEmpty()) {
    			indto.setPreUsercd0016Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0016Nm(), ""));
    		} else {
    			indto.setPreUsercd0016Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0017() != null && !mainDataEntity.getPreUsercd0017().isEmpty()) {
    			indto.setPreUsercd0017Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0017Nm(), ""));
    		} else {
    			indto.setPreUsercd0017Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0018() != null && !mainDataEntity.getPreUsercd0018().isEmpty()) {
    			indto.setPreUsercd0018Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0018Nm(), ""));
    		} else {
    			indto.setPreUsercd0018Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0019() != null && !mainDataEntity.getPreUsercd0019().isEmpty()) {
    			indto.setPreUsercd0019Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0019Nm(), ""));
    		} else {
    			indto.setPreUsercd0019Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0020() != null && !mainDataEntity.getPreUsercd0020().isEmpty()) {
    			indto.setPreUsercd0020Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0020Nm(), ""));
    		} else {
    			indto.setPreUsercd0020Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0021() != null && !mainDataEntity.getPreUsercd0021().isEmpty()) {
    			indto.setPreUsercd0021Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0021Nm(), ""));
    		} else {
    			indto.setPreUsercd0021Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0022() != null && !mainDataEntity.getPreUsercd0022().isEmpty()) {
    			indto.setPreUsercd0022Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0022Nm(), ""));
    		} else {
    			indto.setPreUsercd0022Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0023() != null && !mainDataEntity.getPreUsercd0023().isEmpty()) {
    			indto.setPreUsercd0023Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0023Nm(), ""));
    		} else {
    			indto.setPreUsercd0023Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0024() != null && !mainDataEntity.getPreUsercd0024().isEmpty()) {
    			indto.setPreUsercd0024Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0024Nm(), ""));
    		} else {
    			indto.setPreUsercd0024Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0025() != null && !mainDataEntity.getPreUsercd0025().isEmpty()) {
    			indto.setPreUsercd0025Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0025Nm(), ""));
    		} else {
    			indto.setPreUsercd0025Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0026() != null && !mainDataEntity.getPreUsercd0026().isEmpty()) {
    			indto.setPreUsercd0026Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0026Nm(), ""));
    		} else {
    			indto.setPreUsercd0026Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0027() != null && !mainDataEntity.getPreUsercd0027().isEmpty()) {
    			indto.setPreUsercd0027Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0027Nm(), ""));
    		} else {
    			indto.setPreUsercd0027Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0028() != null && !mainDataEntity.getPreUsercd0028().isEmpty()) {
    			indto.setPreUsercd0028Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0028Nm(), ""));
    		} else {
    			indto.setPreUsercd0028Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0029() != null && !mainDataEntity.getPreUsercd0029().isEmpty()) {
    			indto.setPreUsercd0029Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0029Nm(), ""));
    		} else {
    			indto.setPreUsercd0029Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0030() != null && !mainDataEntity.getPreUsercd0030().isEmpty()) {
    			indto.setPreUsercd0030Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0030Nm(), ""));
    		} else {
    			indto.setPreUsercd0030Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0031() != null && !mainDataEntity.getPreUsercd0031().isEmpty()) {
    			indto.setPreUsercd0031Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0031Nm(), ""));
    		} else {
    			indto.setPreUsercd0031Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0032() != null && !mainDataEntity.getPreUsercd0032().isEmpty()) {
    			indto.setPreUsercd0032Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0032Nm(), ""));
    		} else {
    			indto.setPreUsercd0032Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0033() != null && !mainDataEntity.getPreUsercd0033().isEmpty()) {
    			indto.setPreUsercd0033Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0033Nm(), ""));
    		} else {
    			indto.setPreUsercd0033Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0034() != null && !mainDataEntity.getPreUsercd0034().isEmpty()) {
    			indto.setPreUsercd0034Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0034Nm(), ""));
    		} else {
    			indto.setPreUsercd0034Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0035() != null && !mainDataEntity.getPreUsercd0035().isEmpty()) {
    			indto.setPreUsercd0035Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0035Nm(), ""));
    		} else {
    			indto.setPreUsercd0035Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0036() != null && !mainDataEntity.getPreUsercd0036().isEmpty()) {
    			indto.setPreUsercd0036Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0036Nm(), ""));
    		} else {
    			indto.setPreUsercd0036Nm("--なし--");
    		}

    		indto.setUsercd0001(StringUtils.nvl(mainDataEntity.getPreUsercd0001(), ""));
    		indto.setUsercd0002(StringUtils.nvl(mainDataEntity.getPreUsercd0002(), ""));
    		indto.setUsercd0003(StringUtils.nvl(mainDataEntity.getPreUsercd0003(), ""));
    		indto.setUsercd0004(StringUtils.nvl(mainDataEntity.getPreUsercd0004(), ""));
    		indto.setUsercd0005(StringUtils.nvl(mainDataEntity.getPreUsercd0005(), ""));
    		indto.setUsercd0006(StringUtils.nvl(mainDataEntity.getPreUsercd0006(), ""));
    		indto.setUsercd0007(StringUtils.nvl(mainDataEntity.getPreUsercd0007(), ""));
    		indto.setUsercd0008(StringUtils.nvl(mainDataEntity.getPreUsercd0008(), ""));
    		indto.setUsercd0009(StringUtils.nvl(mainDataEntity.getPreUsercd0009(), ""));
    		indto.setUsercd0010(StringUtils.nvl(mainDataEntity.getPreUsercd0010(), ""));
    		indto.setUsercd0011(StringUtils.nvl(mainDataEntity.getPreUsercd0011(), ""));
    		indto.setUsercd0012(StringUtils.nvl(mainDataEntity.getPreUsercd0012(), ""));
    		indto.setUsercd0013(StringUtils.nvl(mainDataEntity.getPreUsercd0013(), ""));
    		indto.setUsercd0014(StringUtils.nvl(mainDataEntity.getPreUsercd0014(), ""));
    		indto.setUsercd0015(StringUtils.nvl(mainDataEntity.getPreUsercd0015(), ""));
    		indto.setUsercd0016(StringUtils.nvl(mainDataEntity.getPreUsercd0016(), ""));
    		indto.setUsercd0017(StringUtils.nvl(mainDataEntity.getPreUsercd0017(), ""));
    		indto.setUsercd0018(StringUtils.nvl(mainDataEntity.getPreUsercd0018(), ""));
    		indto.setUsercd0019(StringUtils.nvl(mainDataEntity.getPreUsercd0019(), ""));
    		indto.setUsercd0020(StringUtils.nvl(mainDataEntity.getPreUsercd0020(), ""));
    		indto.setUsercd0021(StringUtils.nvl(mainDataEntity.getPreUsercd0021(), ""));
    		indto.setUsercd0022(StringUtils.nvl(mainDataEntity.getPreUsercd0022(), ""));
    		indto.setUsercd0023(StringUtils.nvl(mainDataEntity.getPreUsercd0023(), ""));
    		indto.setUsercd0024(StringUtils.nvl(mainDataEntity.getPreUsercd0024(), ""));
    		indto.setUsercd0025(StringUtils.nvl(mainDataEntity.getPreUsercd0025(), ""));
    		indto.setUsercd0026(StringUtils.nvl(mainDataEntity.getPreUsercd0026(), ""));
    		indto.setUsercd0027(StringUtils.nvl(mainDataEntity.getPreUsercd0027(), ""));
    		indto.setUsercd0028(StringUtils.nvl(mainDataEntity.getPreUsercd0028(), ""));
    		indto.setUsercd0029(StringUtils.nvl(mainDataEntity.getPreUsercd0029(), ""));
    		indto.setUsercd0030(StringUtils.nvl(mainDataEntity.getPreUsercd0030(), ""));
    		indto.setUsercd0031(StringUtils.nvl(mainDataEntity.getPreUsercd0031(), ""));
    		indto.setUsercd0032(StringUtils.nvl(mainDataEntity.getPreUsercd0032(), ""));
    		indto.setUsercd0033(StringUtils.nvl(mainDataEntity.getPreUsercd0033(), ""));
    		indto.setUsercd0034(StringUtils.nvl(mainDataEntity.getPreUsercd0034(), ""));
    		indto.setUsercd0035(StringUtils.nvl(mainDataEntity.getPreUsercd0035(), ""));
    		indto.setUsercd0036(StringUtils.nvl(mainDataEntity.getPreUsercd0036(), ""));
    		indto.setUsercd0101(StringUtils.nvl(mainDataEntity.getPreUsercd0101(), ""));
    		indto.setUsercd0102(StringUtils.nvl(mainDataEntity.getPreUsercd0102(), ""));
    		indto.setUsercd0103(StringUtils.nvl(mainDataEntity.getPreUsercd0103(), ""));
    		indto.setUsercd0104(StringUtils.nvl(mainDataEntity.getPreUsercd0104(), ""));
    		indto.setUsercd0105(StringUtils.nvl(mainDataEntity.getPreUsercd0105(), ""));
    		indto.setUsercd0106(StringUtils.nvl(mainDataEntity.getPreUsercd0106(), ""));
    		indto.setUsercd0107(StringUtils.nvl(mainDataEntity.getPreUsercd0107(), ""));
    		indto.setUsercd0108(StringUtils.nvl(mainDataEntity.getPreUsercd0108(), ""));
    		indto.setUsercd0109(StringUtils.nvl(mainDataEntity.getPreUsercd0109(), ""));
    		indto.setUsercd0201(StringUtils.nvl(mainDataEntity.getPreUsercd0201(), ""));
    		indto.setUsercd0202(StringUtils.nvl(mainDataEntity.getPreUsercd0202(), ""));
    		indto.setUsercd0203(StringUtils.nvl(mainDataEntity.getPreUsercd0203(), ""));
    		indto.setUsercd0204(StringUtils.nvl(mainDataEntity.getPreUsercd0204(), ""));
    		indto.setUsercd0205(StringUtils.nvl(mainDataEntity.getPreUsercd0205(), ""));
    		indto.setUsercd0206(StringUtils.nvl(mainDataEntity.getPreUsercd0206(), ""));

    		// 診療報酬情報
    		indto.setPreReward04(StringUtils.nvl(mainDataEntity.getPreReward04(), ""));
    		indto.setPreReward05(StringUtils.nvl(mainDataEntity.getPreReward05(), ""));
    		indto.setPreReward08(StringUtils.nvl(mainDataEntity.getPreReward08(), ""));
    		indto.setPreReward09(StringUtils.nvl(mainDataEntity.getPreReward09(), ""));
    		indto.setPreReward16(StringUtils.nvl(mainDataEntity.getPreReward16(), ""));
    		indto.setPreReward17(StringUtils.nvl(mainDataEntity.getPreReward17(), ""));
    		indto.setPreReward18(StringUtils.nvl(mainDataEntity.getPreReward18(), ""));
    		indto.setPreReward21(StringUtils.nvl(mainDataEntity.getPreReward21(), ""));
    		indto.setPreReward23(StringUtils.nvl(mainDataEntity.getPreReward23(), ""));
    		indto.setPreReward25(StringUtils.nvl(mainDataEntity.getPreReward25(), ""));
    		indto.setPreReward26(StringUtils.nvl(mainDataEntity.getPreReward26(), ""));
    		indto.setPreReward27(StringUtils.nvl(mainDataEntity.getPreReward27(), ""));
    		indto.setPreReward29(StringUtils.nvl(mainDataEntity.getPreReward29(), ""));
    		indto.setPreReward35(StringUtils.nvl(mainDataEntity.getPreReward35(), ""));
    		indto.setPreReward36(StringUtils.nvl(mainDataEntity.getPreReward36(), ""));
    		indto.setPreReward37(StringUtils.nvl(mainDataEntity.getPreReward37(), ""));
    		indto.setPreReward44(StringUtils.nvl(mainDataEntity.getPreReward44(), ""));

    		if(mainDataEntity.getPreReward04() != null && !mainDataEntity.getPreReward04().isEmpty()) {
    			indto.setPreReward04Nm(mainDataEntity.getPreReward04() + "：" + StringUtils.nvl(mainDataEntity.getPreReward04Nm(), ""));
    		} else {
    			indto.setPreReward04Nm("--なし--");
    		}
    		if(mainDataEntity.getPreReward05() != null && !mainDataEntity.getPreReward05().isEmpty()) {
    			indto.setPreReward05Nm(mainDataEntity.getPreReward05() + "：" + StringUtils.nvl(mainDataEntity.getPreReward05Nm(), ""));
    		} else {
    			indto.setPreReward05Nm("--なし--");
    		}
    		if(mainDataEntity.getPreReward08() != null && !mainDataEntity.getPreReward08().isEmpty()) {
    			indto.setPreReward08Nm(mainDataEntity.getPreReward08() + "：" + StringUtils.nvl(mainDataEntity.getPreReward08Nm(), ""));
    		} else {
    			indto.setPreReward08Nm("--なし--");
    		}
    		if(mainDataEntity.getPreReward09() != null && !mainDataEntity.getPreReward09().isEmpty()) {
    			indto.setPreReward09Nm(mainDataEntity.getPreReward09() + "：" + StringUtils.nvl(mainDataEntity.getPreReward09Nm(), ""));
    		} else {
    			indto.setPreReward09Nm("--なし--");
    		}
    		if(mainDataEntity.getPreReward16() != null && !mainDataEntity.getPreReward16().isEmpty()) {
    			indto.setPreReward16Nm(mainDataEntity.getPreReward16() + "：" + StringUtils.nvl(mainDataEntity.getPreReward16Nm(), ""));
    		} else {
    			indto.setPreReward16Nm("--なし--");
    		}
    		if(mainDataEntity.getPreReward17() != null && !mainDataEntity.getPreReward17().isEmpty()) {
    			indto.setPreReward17Nm(mainDataEntity.getPreReward17() + "：" + StringUtils.nvl(mainDataEntity.getPreReward17Nm(), ""));
    		} else {
    			indto.setPreReward17Nm("--なし--");
    		}
    		if(mainDataEntity.getPreReward18() != null && !mainDataEntity.getPreReward18().isEmpty()) {
    			indto.setPreReward18Nm(mainDataEntity.getPreReward18() + "：" + StringUtils.nvl(mainDataEntity.getPreReward18Nm(), ""));
    		} else {
    			indto.setPreReward18Nm("--なし--");
    		}
    		if(mainDataEntity.getPreReward21() != null && !mainDataEntity.getPreReward21().isEmpty()) {
    			indto.setPreReward21Nm(mainDataEntity.getPreReward21() + "：" + StringUtils.nvl(mainDataEntity.getPreReward21Nm(), ""));
    		} else {
    			indto.setPreReward21Nm("--なし--");
    		}
    		if(mainDataEntity.getPreReward23() != null && !mainDataEntity.getPreReward23().isEmpty()) {
    			indto.setPreReward23Nm(mainDataEntity.getPreReward23() + "：" + StringUtils.nvl(mainDataEntity.getPreReward23Nm(), ""));
    		} else {
    			indto.setPreReward23Nm("--なし--");
    		}
    		if(mainDataEntity.getPreReward25() != null && !mainDataEntity.getPreReward25().isEmpty()) {
    			indto.setPreReward25Nm(mainDataEntity.getPreReward25() + "：" + StringUtils.nvl(mainDataEntity.getPreReward25Nm(), ""));
    		} else {
    			indto.setPreReward25Nm("--なし--");
    		}
    		if(mainDataEntity.getPreReward26() != null && !mainDataEntity.getPreReward26().isEmpty()) {
    			indto.setPreReward26Nm(mainDataEntity.getPreReward26() + "：" + StringUtils.nvl(mainDataEntity.getPreReward26Nm(), ""));
    		} else {
    			indto.setPreReward26Nm("--なし--");
    		}
    		if(mainDataEntity.getPreReward27() != null && !mainDataEntity.getPreReward27().isEmpty()) {
    			indto.setPreReward27Nm(mainDataEntity.getPreReward27() + "：" + StringUtils.nvl(mainDataEntity.getPreReward27Nm(), ""));
    		} else {
    			indto.setPreReward27Nm("--なし--");
    		}
    		if(mainDataEntity.getPreReward29() != null && !mainDataEntity.getPreReward29().isEmpty()) {
    			indto.setPreReward29Nm(mainDataEntity.getPreReward29() + "：" + StringUtils.nvl(mainDataEntity.getPreReward29Nm(), ""));
    		} else {
    			indto.setPreReward29Nm("--なし--");
    		}
    		if(mainDataEntity.getPreReward35() != null && !mainDataEntity.getPreReward35().isEmpty()) {
    			indto.setPreReward35Nm(mainDataEntity.getPreReward35() + "：" + StringUtils.nvl(mainDataEntity.getPreReward35Nm(), ""));
    		} else {
    			indto.setPreReward35Nm("--なし--");
    		}
    		if(mainDataEntity.getPreReward36() != null && !mainDataEntity.getPreReward36().isEmpty()) {
    			indto.setPreReward36Nm(mainDataEntity.getPreReward36() + "：" + StringUtils.nvl(mainDataEntity.getPreReward36Nm(), ""));
    		} else {
    			indto.setPreReward36Nm("--なし--");
    		}
    		if(mainDataEntity.getPreReward37() != null && !mainDataEntity.getPreReward37().isEmpty()) {
    			indto.setPreReward37Nm(mainDataEntity.getPreReward37() + "：" + StringUtils.nvl(mainDataEntity.getPreReward37Nm(), ""));
    		} else {
    			indto.setPreReward37Nm("--なし--");
    		}
    		if(mainDataEntity.getPreReward44() != null && !mainDataEntity.getPreReward44().isEmpty()) {
    			indto.setPreReward44Nm(mainDataEntity.getPreReward44() + "：" + StringUtils.nvl(mainDataEntity.getPreReward44Nm(), ""));
    		} else {
    			indto.setPreReward44Nm("--なし--");
    		}

    		indto.setReward04(StringUtils.nvl(mainDataEntity.getPreReward04(), ""));
    		indto.setReward05(StringUtils.nvl(mainDataEntity.getPreReward05(), ""));
    		indto.setReward08(StringUtils.nvl(mainDataEntity.getPreReward08(), ""));
    		indto.setReward09(StringUtils.nvl(mainDataEntity.getPreReward09(), ""));
    		indto.setReward16(StringUtils.nvl(mainDataEntity.getPreReward16(), ""));
    		indto.setReward17(StringUtils.nvl(mainDataEntity.getPreReward17(), ""));
    		indto.setReward18(StringUtils.nvl(mainDataEntity.getPreReward18(), ""));
    		indto.setReward21(StringUtils.nvl(mainDataEntity.getPreReward21(), ""));
    		indto.setReward23(StringUtils.nvl(mainDataEntity.getPreReward23(), ""));
    		indto.setReward25(StringUtils.nvl(mainDataEntity.getPreReward25(), ""));
    		indto.setReward26(StringUtils.nvl(mainDataEntity.getPreReward26(), ""));
    		indto.setReward27(StringUtils.nvl(mainDataEntity.getPreReward27(), ""));
    		indto.setReward29(StringUtils.nvl(mainDataEntity.getPreReward29(), ""));
    		indto.setReward35(StringUtils.nvl(mainDataEntity.getPreReward35(), ""));
    		indto.setReward36(StringUtils.nvl(mainDataEntity.getPreReward36(), ""));
    		indto.setReward37(StringUtils.nvl(mainDataEntity.getPreReward37(), ""));
    		indto.setReward44(StringUtils.nvl(mainDataEntity.getPreReward44(), ""));

        } else if ("2".equals(indto.getDisplayKbn())) {
    		// 申請データを参照
    		SelectNF012MainDataEntity paramEntity = new SelectNF012MainDataEntity();
    		paramEntity.setInReqId(indto.getReqId());
    		List<SelectNF012MainDataEntity> mainDataEntityList = dao.select(paramEntity);
    		SelectNF012MainDataEntity mainDataEntity = mainDataEntityList.get(0);

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
    		indto.setShnJgiNo(mainDataEntity.getShnJgiNo());
    		indto.setAprJgiNo(mainDataEntity.getAprJgiNo());
    		indto.setUpdShaYmd(StringUtils.nvl(mainDataEntity.getUpdShaYmd(), ""));

    		// 基本情報
    		indto.setInsNo(StringUtils.nvl(mainDataEntity.getInsNo(), ""));
    		indto.setInsClass(StringUtils.nvl(mainDataEntity.getInsClass(), ""));
    		indto.setPreInsAbbrName(StringUtils.nvl(mainDataEntity.getPreInsAbbrName(), ""));
    		indto.setPreInsKana(StringUtils.nvl(mainDataEntity.getPreInsKana(), ""));
    		indto.setPreInsFormalName(StringUtils.nvl(mainDataEntity.getPreInsFormalName(), ""));
    		indto.setPreTradeType(StringUtils.nvl(mainDataEntity.getPreTradeType(), ""));
    		indto.setPreTradeTypeNm(StringUtils.nvl(mainDataEntity.getPreTradeTypeNm(), ""));
    		indto.setPreInsOpenYear(StringUtils.nvl(mainDataEntity.getPreInsOpenYear(), ""));
    		indto.setPreInsOpenMonth(StringUtils.nvl(mainDataEntity.getPreInsOpenMonth(), ""));
    		indto.setPreInsOpenDay(StringUtils.nvl(mainDataEntity.getPreInsOpenDay(), ""));
    		indto.setPrePharmType(StringUtils.nvl(mainDataEntity.getPrePharmType(), ""));
    		indto.setPrePharmTypeNm(StringUtils.nvl(mainDataEntity.getPrePharmTypeNm(), ""));
    		indto.setPreInsRank(StringUtils.nvl(mainDataEntity.getPreInsRank(), ""));
    		indto.setPreInsRankNm(StringUtils.nvl(mainDataEntity.getPreInsRankNm(), ""));
    		indto.setPreRegVisType(StringUtils.nvl(mainDataEntity.getPreRegVisType(), ""));
    		indto.setPreRegVisTypeNm(StringUtils.nvl(mainDataEntity.getPreRegVisTypeNm(), ""));
    		indto.setPreManageCd(StringUtils.nvl(mainDataEntity.getPreManageCd(), ""));
    		indto.setPreManageNm(StringUtils.nvl(mainDataEntity.getPreManageNm(), ""));
    		indto.setPreWsType(StringUtils.nvl(mainDataEntity.getPreWsType(), ""));

    		if(mainDataEntity.getPreWsType() != null && !mainDataEntity.getPreWsType().isEmpty()) {
    			indto.setPreWsTypeNm(StringUtils.nvl(mainDataEntity.getPreWsTypeNm(), ""));
    		} else {
    			indto.setPreWsTypeNm("--なし--");
    		}

    		indto.setPreBasketPurchase(StringUtils.nvl(mainDataEntity.getPreBasketPurchase(), ""));

    		if(mainDataEntity.getPreBasketPurchase() != null && !mainDataEntity.getPreBasketPurchase().isEmpty()) {
    			indto.setPreBasketPurchaseNm(mainDataEntity.getPreBasketPurchase() + "：" + StringUtils.nvl(mainDataEntity.getPreBasketPurchaseNm(), ""));
    		} else {
    			indto.setPreBasketPurchaseNm("--なし--");
    		}

    		indto.setPreUnivSubdiv(StringUtils.nvl(mainDataEntity.getPreUnivSubdiv(), ""));

    		if(mainDataEntity.getPreUnivSubdiv() != null && !mainDataEntity.getPreUnivSubdiv().isEmpty()) {
    			indto.setPreUnivSubdivNm(mainDataEntity.getPreUnivSubdiv() + "：" + StringUtils.nvl(mainDataEntity.getPreUnivSubdivNm(), ""));
    		} else {
    			indto.setPreUnivSubdivNm("--なし--");
    		}

    		indto.setPreCapaType(StringUtils.nvl(mainDataEntity.getPreCapaType(), ""));

    		if(mainDataEntity.getPreCapaType() != null && !mainDataEntity.getPreCapaType().isEmpty()) {
    			indto.setPreCapaTypeNm(StringUtils.nvl(mainDataEntity.getPreCapaTypeNm(), ""));
    		} else {
    			indto.setPreCapaTypeNm("--なし--");
    		}

    		indto.setInsAbbrName(StringUtils.nvl(mainDataEntity.getInsAbbrName(), ""));
    		indto.setInsKana(StringUtils.nvl(mainDataEntity.getInsKana(), ""));
    		indto.setInsFormalName(StringUtils.nvl(mainDataEntity.getInsFormalName(), ""));
    		indto.setTradeType(StringUtils.nvl(mainDataEntity.getTradeType(), ""));
    		indto.setInsOpenYear(StringUtils.nvl(mainDataEntity.getInsOpenYear(), ""));
    		indto.setInsOpenMonth(StringUtils.nvl(mainDataEntity.getInsOpenMonth(), ""));
    		indto.setInsOpenDay(StringUtils.nvl(mainDataEntity.getInsOpenDay(), ""));
    		indto.setPharmType(StringUtils.nvl(mainDataEntity.getPharmType(), ""));
    		indto.setPharmTypeNm(StringUtils.nvl(mainDataEntity.getPharmTypeNm(), ""));
    		indto.setInsRank(StringUtils.nvl(mainDataEntity.getInsRank(), ""));
    		indto.setInsRankNm(StringUtils.nvl(mainDataEntity.getInsRankNm(), ""));
    		indto.setRegVisType(StringUtils.nvl(mainDataEntity.getRegVisType(), ""));
    		indto.setRegVisTypeNm(StringUtils.nvl(mainDataEntity.getRegVisTypeNm(), ""));
    		indto.setManageCd(StringUtils.nvl(mainDataEntity.getManageCd(), ""));
    		indto.setManageNm(StringUtils.nvl(mainDataEntity.getManageNm(), ""));
    		indto.setWsType(StringUtils.nvl(mainDataEntity.getWsType(), ""));
    		indto.setBasketPurchase(StringUtils.nvl(mainDataEntity.getBasketPurchase(), ""));
    		indto.setUnivSubdiv(StringUtils.nvl(mainDataEntity.getUnivSubdiv(), ""));
    		indto.setCapaType(StringUtils.nvl(mainDataEntity.getCapaType(), ""));

    		// ULT施設情報
    		indto.setUltInsCd(StringUtils.nvl(mainDataEntity.getUltInsCd(), ""));
    		indto.setPreUltInsCd(StringUtils.nvl(mainDataEntity.getUltInsCd(), ""));
    		indto.setShisetsuNmRyaku(StringUtils.nvl(mainDataEntity.getShisetsuNmRyaku(), ""));
    		indto.setShisetsuNm(StringUtils.nvl(mainDataEntity.getShisetsuNm(), ""));

    		// 病床数
    		indto.setBedCntBase(StringUtils.nvl(mainDataEntity.getBedCntBase(), ""));
    		indto.setBedCnt01(StringUtils.nvl(mainDataEntity.getBedCnt01(), ""));
    		indto.setBedCnt02(StringUtils.nvl(mainDataEntity.getBedCnt02(), ""));
    		indto.setBedCnt03(StringUtils.nvl(mainDataEntity.getBedCnt03(), ""));
    		indto.setBedCnt04(StringUtils.nvl(mainDataEntity.getBedCnt04(), ""));
    		indto.setBedCnt05(StringUtils.nvl(mainDataEntity.getBedCnt05(), ""));
    		indto.setBedCnt06(StringUtils.nvl(mainDataEntity.getBedCnt06(), ""));
    		indto.setBedCnt07(StringUtils.nvl(mainDataEntity.getBedCnt07(), ""));
    		indto.setBedsTot(StringUtils.nvl(mainDataEntity.getBedsTot(), ""));
    		indto.setMedBedsTot(StringUtils.nvl(mainDataEntity.getMedBedsTot(), ""));
    		indto.setUltBedCnt01(StringUtils.nvl(mainDataEntity.getUltBedCnt01(), ""));
    		indto.setUltBedCnt03(StringUtils.nvl(mainDataEntity.getUltBedCnt03(), ""));
    		indto.setUltBedCnt04(StringUtils.nvl(mainDataEntity.getUltBedCnt04(), ""));
    		indto.setUltBedCnt05(StringUtils.nvl(mainDataEntity.getUltBedCnt05(), ""));
    		indto.setUltBedCnt07(StringUtils.nvl(mainDataEntity.getUltBedCnt07(), ""));
    		indto.setUltBedsTot(StringUtils.nvl(mainDataEntity.getUltBedsTot(), ""));
    		indto.setNextBedCntBase(StringUtils.nvl(mainDataEntity.getNextBedCntBase(), ""));
    		indto.setNextBedCnt01(StringUtils.nvl(mainDataEntity.getNextBedCnt01(), ""));
    		indto.setNextBedCnt02(StringUtils.nvl(mainDataEntity.getNextBedCnt02(), ""));
    		indto.setNextBedCnt03(StringUtils.nvl(mainDataEntity.getNextBedCnt03(), ""));
    		indto.setNextBedCnt04(StringUtils.nvl(mainDataEntity.getNextBedCnt04(), ""));
    		indto.setNextBedCnt05(StringUtils.nvl(mainDataEntity.getNextBedCnt05(), ""));
    		indto.setNextBedCnt06(StringUtils.nvl(mainDataEntity.getNextBedCnt06(), ""));
    		indto.setNextBedCnt07(StringUtils.nvl(mainDataEntity.getNextBedCnt07(), ""));
    		indto.setNextBedsTot(StringUtils.nvl(mainDataEntity.getNextBedsTot(), ""));
    		indto.setNextMedBedsTot(StringUtils.nvl(mainDataEntity.getNextMedBedsTot(), ""));

    		// 住所詳細
    		indto.setPreInsPcode(StringUtils.nvl(mainDataEntity.getPreInsPcode(), ""));
    		indto.setPreAddrCodePref(StringUtils.nvl(mainDataEntity.getPreAddrCodePref(), ""));
    		indto.setPreAddrCodePrefName(StringUtils.nvl(mainDataEntity.getPreAddrCodePrefName(), ""));
    		indto.setPreAddrCodeCity(StringUtils.nvl(mainDataEntity.getPreAddrCodeCity(), ""));
    		indto.setPreAddrCodeCityName(StringUtils.nvl(mainDataEntity.getPreAddrCodeCityName(), ""));
    		indto.setPreInsAddrDt(StringUtils.nvl(mainDataEntity.getPreInsAddrDt(), ""));
    		indto.setPreTkCityCd(StringUtils.nvl(mainDataEntity.getPreTkCityCd(), ""));
    		indto.setPreTkCityName(StringUtils.nvl(mainDataEntity.getPreTkCityName(), ""));
    		indto.setPreInsPhone1(StringUtils.nvl(mainDataEntity.getPreInsPhone1(), ""));
    		indto.setPreInsPhone2(StringUtils.nvl(mainDataEntity.getPreInsPhone2(), ""));
    		indto.setPreInsFax1(StringUtils.nvl(mainDataEntity.getPreInsFax1(), ""));
    		indto.setPreInsFax2(StringUtils.nvl(mainDataEntity.getPreInsFax2(), ""));
    		indto.setPreInsUrl(StringUtils.nvl(mainDataEntity.getPreInsUrl(), ""));

    		// ホームページアドレス更新日を"yyyy/MM/dd"に変換
    		if(!"".equals(StringUtils.nvl(mainDataEntity.getPreInsUrlYmd(), "")) && mainDataEntity.getPreInsUrlYmd().length() == 8) {
    			StringBuilder sbUrlYmd = new StringBuilder();
    			sbUrlYmd.append(mainDataEntity.getPreInsUrlYmd().substring(0,4));
    			sbUrlYmd.append("/");
    			sbUrlYmd.append(mainDataEntity.getPreInsUrlYmd().substring(4,6));
    			sbUrlYmd.append("/");
    			sbUrlYmd.append(mainDataEntity.getPreInsUrlYmd().substring(6,8));
    			indto.setPreInsUrlYmd(sbUrlYmd.toString());
    		} else {
    			indto.setPreInsUrlYmd("");
    		}

    		indto.setInsPcode(StringUtils.nvl(mainDataEntity.getInsPcode(), ""));
    		indto.setAddrCodePref(StringUtils.nvl(mainDataEntity.getAddrCodePref(), ""));
    		indto.setAddrCodePrefName(StringUtils.nvl(mainDataEntity.getAddrCodePrefName(), ""));
    		indto.setAddrCodeCity(StringUtils.nvl(mainDataEntity.getAddrCodeCity(), ""));
    		indto.setAddrCodeCityName(StringUtils.nvl(mainDataEntity.getAddrCodeCityName(), ""));
    		indto.setInsAddrDt(StringUtils.nvl(mainDataEntity.getInsAddrDt(), ""));
    		indto.setTkCityCd(StringUtils.nvl(mainDataEntity.getTkCityCd(), ""));
    		indto.setTkCityName(StringUtils.nvl(mainDataEntity.getTkCityName(), ""));
    		indto.setInsPhone1(StringUtils.nvl(mainDataEntity.getInsPhone1(), ""));
    		indto.setInsPhone2(StringUtils.nvl(mainDataEntity.getInsPhone2(), ""));
    		indto.setInsFax1(StringUtils.nvl(mainDataEntity.getInsFax1(), ""));
    		indto.setInsFax2(StringUtils.nvl(mainDataEntity.getInsFax2(), ""));
    		indto.setInsUrl(StringUtils.nvl(mainDataEntity.getInsUrl(), ""));

    		// ホームページアドレス更新日を"yyyy-MM-dd"に変換
    		if(!"".equals(StringUtils.nvl(mainDataEntity.getInsUrlYmd(), "")) && mainDataEntity.getInsUrlYmd().length() == 8) {
    			StringBuilder sbUrlYmd = new StringBuilder();
    			sbUrlYmd.append(mainDataEntity.getInsUrlYmd().substring(0,4));
    			sbUrlYmd.append("-");
    			sbUrlYmd.append(mainDataEntity.getInsUrlYmd().substring(4,6));
    			sbUrlYmd.append("-");
    			sbUrlYmd.append(mainDataEntity.getInsUrlYmd().substring(6,8));
    			indto.setInsUrlYmd(sbUrlYmd.toString());
    		}

    		indto.setPreInsAddrKana(StringUtils.nvl(mainDataEntity.getInsAddrKana(), ""));
    		indto.setInsAddrKana(StringUtils.nvl(mainDataEntity.getInsAddrKana(), ""));

    		// フリー項目区分情報
    		indto.setPreFree0001(StringUtils.nvl(mainDataEntity.getPreFree0001(), ""));
    		indto.setPreFree0002(StringUtils.nvl(mainDataEntity.getPreFree0002(), ""));
    		indto.setPreFree0003(StringUtils.nvl(mainDataEntity.getPreFree0003(), ""));
    		indto.setPreFree0004(StringUtils.nvl(mainDataEntity.getPreFree0004(), ""));
    		indto.setPreFree0005(StringUtils.nvl(mainDataEntity.getPreFree0005(), ""));
    		indto.setPreFree0006(StringUtils.nvl(mainDataEntity.getPreFree0006(), ""));
    		indto.setPreFree0007(StringUtils.nvl(mainDataEntity.getPreFree0007(), ""));
    		indto.setPreFree0008(StringUtils.nvl(mainDataEntity.getPreFree0008(), ""));
    		indto.setPreFree0009(StringUtils.nvl(mainDataEntity.getPreFree0009(), ""));
    		indto.setPreFree0010(StringUtils.nvl(mainDataEntity.getPreFree0010(), ""));
    		indto.setPreFree0011(StringUtils.nvl(mainDataEntity.getPreFree0011(), ""));
    		indto.setPreFree0012(StringUtils.nvl(mainDataEntity.getPreFree0012(), ""));
    		indto.setPreFree0013(StringUtils.nvl(mainDataEntity.getPreFree0013(), ""));
    		indto.setPreFree0014(StringUtils.nvl(mainDataEntity.getPreFree0014(), ""));
    		indto.setPreFree0015(StringUtils.nvl(mainDataEntity.getPreFree0015(), ""));
    		indto.setFree0001(StringUtils.nvl(mainDataEntity.getFree0001(), ""));
    		indto.setFree0002(StringUtils.nvl(mainDataEntity.getFree0002(), ""));
    		indto.setFree0003(StringUtils.nvl(mainDataEntity.getFree0003(), ""));
    		indto.setFree0004(StringUtils.nvl(mainDataEntity.getFree0004(), ""));
    		indto.setFree0005(StringUtils.nvl(mainDataEntity.getFree0005(), ""));
    		indto.setFree0006(StringUtils.nvl(mainDataEntity.getFree0006(), ""));
    		indto.setFree0007(StringUtils.nvl(mainDataEntity.getFree0007(), ""));
    		indto.setFree0008(StringUtils.nvl(mainDataEntity.getFree0008(), ""));
    		indto.setFree0009(StringUtils.nvl(mainDataEntity.getFree0009(), ""));
    		indto.setFree0010(StringUtils.nvl(mainDataEntity.getFree0010(), ""));
    		indto.setFree0011(StringUtils.nvl(mainDataEntity.getFree0011(), ""));
    		indto.setFree0012(StringUtils.nvl(mainDataEntity.getFree0012(), ""));
    		indto.setFree0013(StringUtils.nvl(mainDataEntity.getFree0013(), ""));
    		indto.setFree0014(StringUtils.nvl(mainDataEntity.getFree0014(), ""));
    		indto.setFree0015(StringUtils.nvl(mainDataEntity.getFree0015(), ""));

    		// 老人福祉法関連分類情報
    		indto.setPreWelfare02(StringUtils.nvl(mainDataEntity.getPreWelfare02(), ""));
    		indto.setPreWelfare08(StringUtils.nvl(mainDataEntity.getPreWelfare08(), ""));

    		if(mainDataEntity.getPreWelfare02() != null && !mainDataEntity.getPreWelfare02().isEmpty()) {
    			indto.setPreWelfare02Nm(StringUtils.nvl(mainDataEntity.getPreWelfare02Nm(), ""));
    		} else {
    			indto.setPreWelfare02Nm("--なし--");
    		}
    		if(mainDataEntity.getPreWelfare08() != null && !mainDataEntity.getPreWelfare08().isEmpty()) {
    			indto.setPreWelfare08Nm(StringUtils.nvl(mainDataEntity.getPreWelfare08Nm(), ""));
    		} else {
    			indto.setPreWelfare08Nm("--なし--");
    		}

    		indto.setWelfare02(StringUtils.nvl(mainDataEntity.getWelfare02(), ""));
    		indto.setWelfare08(StringUtils.nvl(mainDataEntity.getWelfare08(), ""));

    		// 実績把握区分情報
    		indto.setPreResult01(StringUtils.nvl(mainDataEntity.getPreResult01(), ""));
    		indto.setPreResult02(StringUtils.nvl(mainDataEntity.getPreResult02(), ""));
    		indto.setPreResult03(StringUtils.nvl(mainDataEntity.getPreResult03(), ""));
    		indto.setPreResult04(StringUtils.nvl(mainDataEntity.getPreResult04(), ""));
    		indto.setPreResult05(StringUtils.nvl(mainDataEntity.getPreResult05(), ""));
    		indto.setPreResult06(StringUtils.nvl(mainDataEntity.getPreResult06(), ""));
    		indto.setPreResult07(StringUtils.nvl(mainDataEntity.getPreResult07(), ""));
    		indto.setPreResult08(StringUtils.nvl(mainDataEntity.getPreResult08(), ""));
    		indto.setPreResult09(StringUtils.nvl(mainDataEntity.getPreResult09(), ""));
    		indto.setPreResult10(StringUtils.nvl(mainDataEntity.getPreResult10(), ""));
    		indto.setPreResult11(StringUtils.nvl(mainDataEntity.getPreResult11(), ""));
    		indto.setPreResult12(StringUtils.nvl(mainDataEntity.getPreResult12(), ""));
    		indto.setPreResult13(StringUtils.nvl(mainDataEntity.getPreResult13(), ""));
    		indto.setPreResult14(StringUtils.nvl(mainDataEntity.getPreResult14(), ""));
    		indto.setPreResult15(StringUtils.nvl(mainDataEntity.getPreResult15(), ""));
    		indto.setPreResult16(StringUtils.nvl(mainDataEntity.getPreResult16(), ""));
    		indto.setPreResult17(StringUtils.nvl(mainDataEntity.getPreResult17(), ""));
    		indto.setPreResult18(StringUtils.nvl(mainDataEntity.getPreResult18(), ""));
    		indto.setPreResult19(StringUtils.nvl(mainDataEntity.getPreResult19(), ""));
    		indto.setPreResult20(StringUtils.nvl(mainDataEntity.getPreResult20(), ""));
    		indto.setPreResult21(StringUtils.nvl(mainDataEntity.getPreResult21(), ""));
    		indto.setPreResult22(StringUtils.nvl(mainDataEntity.getPreResult22(), ""));
    		indto.setPreResult23(StringUtils.nvl(mainDataEntity.getPreResult23(), ""));
    		indto.setPreResult24(StringUtils.nvl(mainDataEntity.getPreResult24(), ""));
    		indto.setPreResult25(StringUtils.nvl(mainDataEntity.getPreResult25(), ""));
    		indto.setPreResult26(StringUtils.nvl(mainDataEntity.getPreResult26(), ""));
    		indto.setPreResult27(StringUtils.nvl(mainDataEntity.getPreResult27(), ""));
    		indto.setPreResult28(StringUtils.nvl(mainDataEntity.getPreResult28(), ""));
    		indto.setPreResult29(StringUtils.nvl(mainDataEntity.getPreResult29(), ""));
    		indto.setPreResult30(StringUtils.nvl(mainDataEntity.getPreResult30(), ""));
    		indto.setPreResult31(StringUtils.nvl(mainDataEntity.getPreResult31(), ""));
    		indto.setPreResult32(StringUtils.nvl(mainDataEntity.getPreResult32(), ""));
    		indto.setPreResult33(StringUtils.nvl(mainDataEntity.getPreResult33(), ""));
    		indto.setPreResult34(StringUtils.nvl(mainDataEntity.getPreResult34(), ""));
    		indto.setPreResult35(StringUtils.nvl(mainDataEntity.getPreResult35(), ""));
    		indto.setPreResult36(StringUtils.nvl(mainDataEntity.getPreResult36(), ""));

    		if(mainDataEntity.getPreResult01() != null && !mainDataEntity.getPreResult01().isEmpty()) {
    			indto.setPreResult01Nm(StringUtils.nvl(mainDataEntity.getPreResult01Nm(), ""));
    		} else {
    			indto.setPreResult01Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult02() != null && !mainDataEntity.getPreResult02().isEmpty()) {
    			indto.setPreResult02Nm(StringUtils.nvl(mainDataEntity.getPreResult02Nm(), ""));
    		} else {
    			indto.setPreResult02Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult03() != null && !mainDataEntity.getPreResult03().isEmpty()) {
    			indto.setPreResult03Nm(StringUtils.nvl(mainDataEntity.getPreResult03Nm(), ""));
    		} else {
    			indto.setPreResult03Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult04() != null && !mainDataEntity.getPreResult04().isEmpty()) {
    			indto.setPreResult04Nm(StringUtils.nvl(mainDataEntity.getPreResult04Nm(), ""));
    		} else {
    			indto.setPreResult04Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult05() != null && !mainDataEntity.getPreResult05().isEmpty()) {
    			indto.setPreResult05Nm(StringUtils.nvl(mainDataEntity.getPreResult05Nm(), ""));
    		} else {
    			indto.setPreResult05Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult06() != null && !mainDataEntity.getPreResult06().isEmpty()) {
    			indto.setPreResult06Nm(StringUtils.nvl(mainDataEntity.getPreResult06Nm(), ""));
    		} else {
    			indto.setPreResult06Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult07() != null && !mainDataEntity.getPreResult07().isEmpty()) {
    			indto.setPreResult07Nm(StringUtils.nvl(mainDataEntity.getPreResult07Nm(), ""));
    		} else {
    			indto.setPreResult07Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult08() != null && !mainDataEntity.getPreResult08().isEmpty()) {
    			indto.setPreResult08Nm(StringUtils.nvl(mainDataEntity.getPreResult08Nm(), ""));
    		} else {
    			indto.setPreResult08Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult09() != null && !mainDataEntity.getPreResult09().isEmpty()) {
    			indto.setPreResult09Nm(StringUtils.nvl(mainDataEntity.getPreResult09Nm(), ""));
    		} else {
    			indto.setPreResult09Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult10() != null && !mainDataEntity.getPreResult10().isEmpty()) {
    			indto.setPreResult10Nm(StringUtils.nvl(mainDataEntity.getPreResult10Nm(), ""));
    		} else {
    			indto.setPreResult10Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult11() != null && !mainDataEntity.getPreResult11().isEmpty()) {
    			indto.setPreResult11Nm(StringUtils.nvl(mainDataEntity.getPreResult11Nm(), ""));
    		} else {
    			indto.setPreResult11Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult12() != null && !mainDataEntity.getPreResult12().isEmpty()) {
    			indto.setPreResult12Nm(StringUtils.nvl(mainDataEntity.getPreResult12Nm(), ""));
    		} else {
    			indto.setPreResult12Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult13() != null && !mainDataEntity.getPreResult13().isEmpty()) {
    			indto.setPreResult13Nm(StringUtils.nvl(mainDataEntity.getPreResult13Nm(), ""));
    		} else {
    			indto.setPreResult13Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult14() != null && !mainDataEntity.getPreResult14().isEmpty()) {
    			indto.setPreResult14Nm(StringUtils.nvl(mainDataEntity.getPreResult14Nm(), ""));
    		} else {
    			indto.setPreResult14Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult15() != null && !mainDataEntity.getPreResult15().isEmpty()) {
    			indto.setPreResult15Nm(StringUtils.nvl(mainDataEntity.getPreResult15Nm(), ""));
    		} else {
    			indto.setPreResult15Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult16() != null && !mainDataEntity.getPreResult16().isEmpty()) {
    			indto.setPreResult16Nm(StringUtils.nvl(mainDataEntity.getPreResult16Nm(), ""));
    		} else {
    			indto.setPreResult16Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult17() != null && !mainDataEntity.getPreResult17().isEmpty()) {
    			indto.setPreResult17Nm(StringUtils.nvl(mainDataEntity.getPreResult17Nm(), ""));
    		} else {
    			indto.setPreResult17Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult18() != null && !mainDataEntity.getPreResult18().isEmpty()) {
    			indto.setPreResult18Nm(StringUtils.nvl(mainDataEntity.getPreResult18Nm(), ""));
    		} else {
    			indto.setPreResult18Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult19() != null && !mainDataEntity.getPreResult19().isEmpty()) {
    			indto.setPreResult19Nm(StringUtils.nvl(mainDataEntity.getPreResult19Nm(), ""));
    		} else {
    			indto.setPreResult19Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult20() != null && !mainDataEntity.getPreResult20().isEmpty()) {
    			indto.setPreResult20Nm(StringUtils.nvl(mainDataEntity.getPreResult20Nm(), ""));
    		} else {
    			indto.setPreResult20Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult21() != null && !mainDataEntity.getPreResult21().isEmpty()) {
    			indto.setPreResult21Nm(StringUtils.nvl(mainDataEntity.getPreResult21Nm(), ""));
    		} else {
    			indto.setPreResult21Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult22() != null && !mainDataEntity.getPreResult22().isEmpty()) {
    			indto.setPreResult22Nm(StringUtils.nvl(mainDataEntity.getPreResult22Nm(), ""));
    		} else {
    			indto.setPreResult22Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult23() != null && !mainDataEntity.getPreResult23().isEmpty()) {
    			indto.setPreResult23Nm(StringUtils.nvl(mainDataEntity.getPreResult23Nm(), ""));
    		} else {
    			indto.setPreResult23Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult24() != null && !mainDataEntity.getPreResult24().isEmpty()) {
    			indto.setPreResult24Nm(StringUtils.nvl(mainDataEntity.getPreResult24Nm(), ""));
    		} else {
    			indto.setPreResult24Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult25() != null && !mainDataEntity.getPreResult25().isEmpty()) {
    			indto.setPreResult25Nm(StringUtils.nvl(mainDataEntity.getPreResult25Nm(), ""));
    		} else {
    			indto.setPreResult25Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult26() != null && !mainDataEntity.getPreResult26().isEmpty()) {
    			indto.setPreResult26Nm(StringUtils.nvl(mainDataEntity.getPreResult26Nm(), ""));
    		} else {
    			indto.setPreResult26Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult27() != null && !mainDataEntity.getPreResult27().isEmpty()) {
    			indto.setPreResult27Nm(StringUtils.nvl(mainDataEntity.getPreResult27Nm(), ""));
    		} else {
    			indto.setPreResult27Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult28() != null && !mainDataEntity.getPreResult28().isEmpty()) {
    			indto.setPreResult28Nm(StringUtils.nvl(mainDataEntity.getPreResult28Nm(), ""));
    		} else {
    			indto.setPreResult28Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult29() != null && !mainDataEntity.getPreResult29().isEmpty()) {
    			indto.setPreResult29Nm(StringUtils.nvl(mainDataEntity.getPreResult29Nm(), ""));
    		} else {
    			indto.setPreResult29Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult30() != null && !mainDataEntity.getPreResult30().isEmpty()) {
    			indto.setPreResult30Nm(StringUtils.nvl(mainDataEntity.getPreResult30Nm(), ""));
    		} else {
    			indto.setPreResult30Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult31() != null && !mainDataEntity.getPreResult31().isEmpty()) {
    			indto.setPreResult31Nm(StringUtils.nvl(mainDataEntity.getPreResult31Nm(), ""));
    		} else {
    			indto.setPreResult31Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult32() != null && !mainDataEntity.getPreResult32().isEmpty()) {
    			indto.setPreResult32Nm(StringUtils.nvl(mainDataEntity.getPreResult32Nm(), ""));
    		} else {
    			indto.setPreResult32Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult33() != null && !mainDataEntity.getPreResult33().isEmpty()) {
    			indto.setPreResult33Nm(StringUtils.nvl(mainDataEntity.getPreResult33Nm(), ""));
    		} else {
    			indto.setPreResult33Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult34() != null && !mainDataEntity.getPreResult34().isEmpty()) {
    			indto.setPreResult34Nm(StringUtils.nvl(mainDataEntity.getPreResult34Nm(), ""));
    		} else {
    			indto.setPreResult34Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult35() != null && !mainDataEntity.getPreResult35().isEmpty()) {
    			indto.setPreResult35Nm(StringUtils.nvl(mainDataEntity.getPreResult35Nm(), ""));
    		} else {
    			indto.setPreResult35Nm("--なし--");
    		}
    		if(mainDataEntity.getPreResult36() != null && !mainDataEntity.getPreResult36().isEmpty()) {
    			indto.setPreResult36Nm(StringUtils.nvl(mainDataEntity.getPreResult36Nm(), ""));
    		} else {
    			indto.setPreResult36Nm("--なし--");
    		}

    		indto.setResult01(StringUtils.nvl(mainDataEntity.getResult01(), ""));
    		indto.setResult02(StringUtils.nvl(mainDataEntity.getResult02(), ""));
    		indto.setResult03(StringUtils.nvl(mainDataEntity.getResult03(), ""));
    		indto.setResult04(StringUtils.nvl(mainDataEntity.getResult04(), ""));
    		indto.setResult05(StringUtils.nvl(mainDataEntity.getResult05(), ""));
    		indto.setResult06(StringUtils.nvl(mainDataEntity.getResult06(), ""));
    		indto.setResult07(StringUtils.nvl(mainDataEntity.getResult07(), ""));
    		indto.setResult08(StringUtils.nvl(mainDataEntity.getResult08(), ""));
    		indto.setResult09(StringUtils.nvl(mainDataEntity.getResult09(), ""));
    		indto.setResult10(StringUtils.nvl(mainDataEntity.getResult10(), ""));
    		indto.setResult11(StringUtils.nvl(mainDataEntity.getResult11(), ""));
    		indto.setResult12(StringUtils.nvl(mainDataEntity.getResult12(), ""));
    		indto.setResult13(StringUtils.nvl(mainDataEntity.getResult13(), ""));
    		indto.setResult14(StringUtils.nvl(mainDataEntity.getResult14(), ""));
    		indto.setResult15(StringUtils.nvl(mainDataEntity.getResult15(), ""));
    		indto.setResult16(StringUtils.nvl(mainDataEntity.getResult16(), ""));
    		indto.setResult17(StringUtils.nvl(mainDataEntity.getResult17(), ""));
    		indto.setResult18(StringUtils.nvl(mainDataEntity.getResult18(), ""));
    		indto.setResult19(StringUtils.nvl(mainDataEntity.getResult19(), ""));
    		indto.setResult20(StringUtils.nvl(mainDataEntity.getResult20(), ""));
    		indto.setResult21(StringUtils.nvl(mainDataEntity.getResult21(), ""));
    		indto.setResult22(StringUtils.nvl(mainDataEntity.getResult22(), ""));
    		indto.setResult23(StringUtils.nvl(mainDataEntity.getResult23(), ""));
    		indto.setResult24(StringUtils.nvl(mainDataEntity.getResult24(), ""));
    		indto.setResult25(StringUtils.nvl(mainDataEntity.getResult25(), ""));
    		indto.setResult26(StringUtils.nvl(mainDataEntity.getResult26(), ""));
    		indto.setResult27(StringUtils.nvl(mainDataEntity.getResult27(), ""));
    		indto.setResult28(StringUtils.nvl(mainDataEntity.getResult28(), ""));
    		indto.setResult29(StringUtils.nvl(mainDataEntity.getResult29(), ""));
    		indto.setResult30(StringUtils.nvl(mainDataEntity.getResult30(), ""));
    		indto.setResult31(StringUtils.nvl(mainDataEntity.getResult31(), ""));
    		indto.setResult32(StringUtils.nvl(mainDataEntity.getResult32(), ""));
    		indto.setResult33(StringUtils.nvl(mainDataEntity.getResult33(), ""));
    		indto.setResult34(StringUtils.nvl(mainDataEntity.getResult34(), ""));
    		indto.setResult35(StringUtils.nvl(mainDataEntity.getResult35(), ""));
    		indto.setResult36(StringUtils.nvl(mainDataEntity.getResult36(), ""));

    		// 病院設備情報
    		indto.setPreEquip01(StringUtils.nvl(mainDataEntity.getPreEquip01(), ""));
    		indto.setPreEquip02(StringUtils.nvl(mainDataEntity.getPreEquip02(), ""));
    		indto.setPreEquip03(StringUtils.nvl(mainDataEntity.getPreEquip03(), ""));
    		indto.setPreEquip07(StringUtils.nvl(mainDataEntity.getPreEquip07(), ""));
    		indto.setPreEquip09(StringUtils.nvl(mainDataEntity.getPreEquip09(), ""));

    		if(mainDataEntity.getPreEquip01() != null && !mainDataEntity.getPreEquip01().isEmpty()) {
    			indto.setPreEquip01Nm(StringUtils.nvl(mainDataEntity.getPreEquip01Nm(), ""));
    		} else {
    			indto.setPreEquip01Nm("--なし--");
    		}
    		if(mainDataEntity.getPreEquip02() != null && !mainDataEntity.getPreEquip02().isEmpty()) {
    			indto.setPreEquip02Nm(StringUtils.nvl(mainDataEntity.getPreEquip02Nm(), ""));
    		} else {
    			indto.setPreEquip02Nm("--なし--");
    		}
    		if(mainDataEntity.getPreEquip03() != null && !mainDataEntity.getPreEquip03().isEmpty()) {
    			indto.setPreEquip03Nm(StringUtils.nvl(mainDataEntity.getPreEquip03Nm(), ""));
    		} else {
    			indto.setPreEquip03Nm("--なし--");
    		}
    		if(mainDataEntity.getPreEquip07() != null && !mainDataEntity.getPreEquip07().isEmpty()) {
    			indto.setPreEquip07Nm(StringUtils.nvl(mainDataEntity.getPreEquip07Nm(), ""));
    		} else {
    			indto.setPreEquip07Nm("--なし--");
    		}
    		if(mainDataEntity.getPreEquip09() != null && !mainDataEntity.getPreEquip09().isEmpty()) {
    			indto.setPreEquip09Nm(StringUtils.nvl(mainDataEntity.getPreEquip09Nm(), ""));
    		} else {
    			indto.setPreEquip09Nm("--なし--");
    		}

    		indto.setEquip01(StringUtils.nvl(mainDataEntity.getEquip01(), ""));
    		indto.setEquip02(StringUtils.nvl(mainDataEntity.getEquip02(), ""));
    		indto.setEquip03(StringUtils.nvl(mainDataEntity.getEquip03(), ""));
    		indto.setEquip07(StringUtils.nvl(mainDataEntity.getEquip07(), ""));
    		indto.setEquip09(StringUtils.nvl(mainDataEntity.getEquip09(), ""));

    		// 市場規模情報
    		indto.setPreMarket01(StringUtils.nvl(mainDataEntity.getPreMarket01(), ""));
    		indto.setPreMarket02(StringUtils.nvl(mainDataEntity.getPreMarket02(), ""));
    		indto.setPreMarket03(StringUtils.nvl(mainDataEntity.getPreMarket03(), ""));
    		indto.setPreMarket04(StringUtils.nvl(mainDataEntity.getPreMarket04(), ""));
    		indto.setPreMarket06(StringUtils.nvl(mainDataEntity.getPreMarket06(), ""));
    		indto.setPreMarket07(StringUtils.nvl(mainDataEntity.getPreMarket07(), ""));
    		indto.setPreMarket09(StringUtils.nvl(mainDataEntity.getPreMarket09(), ""));

    		if(mainDataEntity.getPreMarket01() != null && !mainDataEntity.getPreMarket01().isEmpty()) {
    			indto.setPreMarket01Nm(mainDataEntity.getPreMarket01() + "：" + StringUtils.nvl(mainDataEntity.getPreMarket01Nm(), ""));
    		} else {
    			indto.setPreMarket01Nm("--なし--");
    		}
    		if(mainDataEntity.getPreMarket02() != null && !mainDataEntity.getPreMarket02().isEmpty()) {
    			indto.setPreMarket02Nm(mainDataEntity.getPreMarket02() + "：" + StringUtils.nvl(mainDataEntity.getPreMarket02Nm(), ""));
    		} else {
    			indto.setPreMarket02Nm("--なし--");
    		}
    		if(mainDataEntity.getPreMarket03() != null && !mainDataEntity.getPreMarket03().isEmpty()) {
    			indto.setPreMarket03Nm(mainDataEntity.getPreMarket03() + "：" + StringUtils.nvl(mainDataEntity.getPreMarket03Nm(), ""));
    		} else {
    			indto.setPreMarket03Nm("--なし--");
    		}
    		if(mainDataEntity.getPreMarket04() != null && !mainDataEntity.getPreMarket04().isEmpty()) {
    			indto.setPreMarket04Nm(mainDataEntity.getPreMarket04() + "：" + StringUtils.nvl(mainDataEntity.getPreMarket04Nm(), ""));
    		} else {
    			indto.setPreMarket04Nm("--なし--");
    		}
    		if(mainDataEntity.getPreMarket06() != null && !mainDataEntity.getPreMarket06().isEmpty()) {
    			indto.setPreMarket06Nm(mainDataEntity.getPreMarket06() + "：" + StringUtils.nvl(mainDataEntity.getPreMarket06Nm(), ""));
    		} else {
    			indto.setPreMarket06Nm("--なし--");
    		}
    		if(mainDataEntity.getPreMarket07() != null && !mainDataEntity.getPreMarket07().isEmpty()) {
    			indto.setPreMarket07Nm(mainDataEntity.getPreMarket07() + "：" + StringUtils.nvl(mainDataEntity.getPreMarket07Nm(), ""));
    		} else {
    			indto.setPreMarket07Nm("--なし--");
    		}
    		if(mainDataEntity.getPreMarket09() != null && !mainDataEntity.getPreMarket09().isEmpty()) {
    			indto.setPreMarket09Nm(mainDataEntity.getPreMarket09() + "：" + StringUtils.nvl(mainDataEntity.getPreMarket09Nm(), ""));
    		} else {
    			indto.setPreMarket09Nm("--なし--");
    		}

    		indto.setMarket01(StringUtils.nvl(mainDataEntity.getMarket01(), ""));
    		indto.setMarket02(StringUtils.nvl(mainDataEntity.getMarket02(), ""));
    		indto.setMarket03(StringUtils.nvl(mainDataEntity.getMarket03(), ""));
    		indto.setMarket04(StringUtils.nvl(mainDataEntity.getMarket04(), ""));
    		indto.setMarket06(StringUtils.nvl(mainDataEntity.getMarket06(), ""));
    		indto.setMarket07(StringUtils.nvl(mainDataEntity.getMarket07(), ""));
    		indto.setMarket09(StringUtils.nvl(mainDataEntity.getMarket09(), ""));

    		// 医療法関連分類情報
    		indto.setPreMedical12(StringUtils.nvl(mainDataEntity.getPreMedical12(), ""));

    		if(mainDataEntity.getPreMedical12() != null && !mainDataEntity.getPreMedical12().isEmpty()) {
    			indto.setPreMedical12Nm(StringUtils.nvl(mainDataEntity.getPreMedical12Nm(), ""));
    		} else {
    			indto.setPreMedical12Nm("--なし--");
    		}

    		indto.setMedical12(StringUtils.nvl(mainDataEntity.getMedical12(), ""));

    		// 特別な機能情報
    		indto.setPreSpfunc01(StringUtils.nvl(mainDataEntity.getPreSpfunc01(), ""));
    		indto.setPreSpfunc03(StringUtils.nvl(mainDataEntity.getPreSpfunc03(), ""));
    		indto.setPreSpfunc04(StringUtils.nvl(mainDataEntity.getPreSpfunc04(), ""));

    		if(mainDataEntity.getPreSpfunc01() != null && !mainDataEntity.getPreSpfunc01().isEmpty()) {
    			indto.setPreSpfunc01Nm(mainDataEntity.getPreSpfunc01() + "：" + StringUtils.nvl(mainDataEntity.getPreSpfunc01Nm(), ""));
    		} else {
    			indto.setPreSpfunc01Nm("--なし--");
    		}
    		if(mainDataEntity.getPreSpfunc03() != null && !mainDataEntity.getPreSpfunc03().isEmpty()) {
    			indto.setPreSpfunc03Nm(mainDataEntity.getPreSpfunc03() + "：" + StringUtils.nvl(mainDataEntity.getPreSpfunc03Nm(), ""));
    		} else {
    			indto.setPreSpfunc03Nm("--なし--");
    		}
    		if(mainDataEntity.getPreSpfunc04() != null && !mainDataEntity.getPreSpfunc04().isEmpty()) {
    			indto.setPreSpfunc04Nm(mainDataEntity.getPreSpfunc04() + "：" + StringUtils.nvl(mainDataEntity.getPreSpfunc04Nm(), ""));
    		} else {
    			indto.setPreSpfunc04Nm("--なし--");
    		}

    		indto.setSpfunc01(StringUtils.nvl(mainDataEntity.getSpfunc01(), ""));
    		indto.setSpfunc03(StringUtils.nvl(mainDataEntity.getSpfunc03(), ""));
    		indto.setSpfunc04(StringUtils.nvl(mainDataEntity.getSpfunc04(), ""));

    		// 医療連携関連情報
    		indto.setPreTieup10(StringUtils.nvl(mainDataEntity.getPreTieup10(), ""));
    		indto.setPreTieup11(StringUtils.nvl(mainDataEntity.getPreTieup11(), ""));
    		indto.setPreTieup12(StringUtils.nvl(mainDataEntity.getPreTieup12(), ""));

    		if(mainDataEntity.getPreTieup10() != null && !mainDataEntity.getPreTieup10().isEmpty()) {
    			indto.setPreTieup10Nm(mainDataEntity.getPreTieup10() + "：" + StringUtils.nvl(mainDataEntity.getPreTieup10Nm(), ""));
    		} else {
    			indto.setPreTieup10Nm("--なし--");
    		}
    		if(mainDataEntity.getPreTieup11() != null && !mainDataEntity.getPreTieup11().isEmpty()) {
    			indto.setPreTieup11Nm(mainDataEntity.getPreTieup11() + "：" + StringUtils.nvl(mainDataEntity.getPreTieup11Nm(), ""));
    		} else {
    			indto.setPreTieup11Nm("--なし--");
    		}
    		if(mainDataEntity.getPreTieup12() != null && !mainDataEntity.getPreTieup12().isEmpty()) {
    			indto.setPreTieup12Nm(mainDataEntity.getPreTieup12() + "：" + StringUtils.nvl(mainDataEntity.getPreTieup12Nm(), ""));
    		} else {
    			indto.setPreTieup12Nm("--なし--");
    		}

    		indto.setTieup10(StringUtils.nvl(mainDataEntity.getTieup10(), ""));
    		indto.setTieup11(StringUtils.nvl(mainDataEntity.getTieup11(), ""));
    		indto.setTieup12(StringUtils.nvl(mainDataEntity.getTieup12(), ""));

    		// ユーザーコード情報
    		indto.setPreUsercd0001(StringUtils.nvl(mainDataEntity.getPreUsercd0001(), ""));
    		indto.setPreUsercd0002(StringUtils.nvl(mainDataEntity.getPreUsercd0002(), ""));
    		indto.setPreUsercd0003(StringUtils.nvl(mainDataEntity.getPreUsercd0003(), ""));
    		indto.setPreUsercd0004(StringUtils.nvl(mainDataEntity.getPreUsercd0004(), ""));
    		indto.setPreUsercd0005(StringUtils.nvl(mainDataEntity.getPreUsercd0005(), ""));
    		indto.setPreUsercd0006(StringUtils.nvl(mainDataEntity.getPreUsercd0006(), ""));
    		indto.setPreUsercd0007(StringUtils.nvl(mainDataEntity.getPreUsercd0007(), ""));
    		indto.setPreUsercd0008(StringUtils.nvl(mainDataEntity.getPreUsercd0008(), ""));
    		indto.setPreUsercd0009(StringUtils.nvl(mainDataEntity.getPreUsercd0009(), ""));
    		indto.setPreUsercd0010(StringUtils.nvl(mainDataEntity.getPreUsercd0010(), ""));
    		indto.setPreUsercd0011(StringUtils.nvl(mainDataEntity.getPreUsercd0011(), ""));
    		indto.setPreUsercd0012(StringUtils.nvl(mainDataEntity.getPreUsercd0012(), ""));
    		indto.setPreUsercd0013(StringUtils.nvl(mainDataEntity.getPreUsercd0013(), ""));
    		indto.setPreUsercd0014(StringUtils.nvl(mainDataEntity.getPreUsercd0014(), ""));
    		indto.setPreUsercd0015(StringUtils.nvl(mainDataEntity.getPreUsercd0015(), ""));
    		indto.setPreUsercd0016(StringUtils.nvl(mainDataEntity.getPreUsercd0016(), ""));
    		indto.setPreUsercd0017(StringUtils.nvl(mainDataEntity.getPreUsercd0017(), ""));
    		indto.setPreUsercd0018(StringUtils.nvl(mainDataEntity.getPreUsercd0018(), ""));
    		indto.setPreUsercd0019(StringUtils.nvl(mainDataEntity.getPreUsercd0019(), ""));
    		indto.setPreUsercd0020(StringUtils.nvl(mainDataEntity.getPreUsercd0020(), ""));
    		indto.setPreUsercd0021(StringUtils.nvl(mainDataEntity.getPreUsercd0021(), ""));
    		indto.setPreUsercd0022(StringUtils.nvl(mainDataEntity.getPreUsercd0022(), ""));
    		indto.setPreUsercd0023(StringUtils.nvl(mainDataEntity.getPreUsercd0023(), ""));
    		indto.setPreUsercd0024(StringUtils.nvl(mainDataEntity.getPreUsercd0024(), ""));
    		indto.setPreUsercd0025(StringUtils.nvl(mainDataEntity.getPreUsercd0025(), ""));
    		indto.setPreUsercd0026(StringUtils.nvl(mainDataEntity.getPreUsercd0026(), ""));
    		indto.setPreUsercd0027(StringUtils.nvl(mainDataEntity.getPreUsercd0027(), ""));
    		indto.setPreUsercd0028(StringUtils.nvl(mainDataEntity.getPreUsercd0028(), ""));
    		indto.setPreUsercd0029(StringUtils.nvl(mainDataEntity.getPreUsercd0029(), ""));
    		indto.setPreUsercd0030(StringUtils.nvl(mainDataEntity.getPreUsercd0030(), ""));
    		indto.setPreUsercd0031(StringUtils.nvl(mainDataEntity.getPreUsercd0031(), ""));
    		indto.setPreUsercd0032(StringUtils.nvl(mainDataEntity.getPreUsercd0032(), ""));
    		indto.setPreUsercd0033(StringUtils.nvl(mainDataEntity.getPreUsercd0033(), ""));
    		indto.setPreUsercd0034(StringUtils.nvl(mainDataEntity.getPreUsercd0034(), ""));
    		indto.setPreUsercd0035(StringUtils.nvl(mainDataEntity.getPreUsercd0035(), ""));
    		indto.setPreUsercd0036(StringUtils.nvl(mainDataEntity.getPreUsercd0036(), ""));
    		indto.setPreUsercd0101(StringUtils.nvl(mainDataEntity.getPreUsercd0101(), ""));
    		indto.setPreUsercd0102(StringUtils.nvl(mainDataEntity.getPreUsercd0102(), ""));
    		indto.setPreUsercd0103(StringUtils.nvl(mainDataEntity.getPreUsercd0103(), ""));
    		indto.setPreUsercd0104(StringUtils.nvl(mainDataEntity.getPreUsercd0104(), ""));
    		indto.setPreUsercd0105(StringUtils.nvl(mainDataEntity.getPreUsercd0105(), ""));
    		indto.setPreUsercd0106(StringUtils.nvl(mainDataEntity.getPreUsercd0106(), ""));
    		indto.setPreUsercd0107(StringUtils.nvl(mainDataEntity.getPreUsercd0107(), ""));
    		indto.setPreUsercd0108(StringUtils.nvl(mainDataEntity.getPreUsercd0108(), ""));
    		indto.setPreUsercd0109(StringUtils.nvl(mainDataEntity.getPreUsercd0109(), ""));
    		indto.setPreUsercd0201(StringUtils.nvl(mainDataEntity.getPreUsercd0201(), ""));
    		indto.setPreUsercd0202(StringUtils.nvl(mainDataEntity.getPreUsercd0202(), ""));
    		indto.setPreUsercd0203(StringUtils.nvl(mainDataEntity.getPreUsercd0203(), ""));
    		indto.setPreUsercd0204(StringUtils.nvl(mainDataEntity.getPreUsercd0204(), ""));
    		indto.setPreUsercd0205(StringUtils.nvl(mainDataEntity.getPreUsercd0205(), ""));
    		indto.setPreUsercd0206(StringUtils.nvl(mainDataEntity.getPreUsercd0206(), ""));

    		if(mainDataEntity.getPreUsercd0001() != null && !mainDataEntity.getPreUsercd0001().isEmpty()) {
    			indto.setPreUsercd0001Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0001Nm(), ""));
    		} else {
    			indto.setPreUsercd0001Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0002() != null && !mainDataEntity.getPreUsercd0002().isEmpty()) {
    			indto.setPreUsercd0002Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0002Nm(), ""));
    		} else {
    			indto.setPreUsercd0002Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0003() != null && !mainDataEntity.getPreUsercd0003().isEmpty()) {
    			indto.setPreUsercd0003Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0003Nm(), ""));
    		} else {
    			indto.setPreUsercd0003Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0004() != null && !mainDataEntity.getPreUsercd0004().isEmpty()) {
    			indto.setPreUsercd0004Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0004Nm(), ""));
    		} else {
    			indto.setPreUsercd0004Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0005() != null && !mainDataEntity.getPreUsercd0005().isEmpty()) {
    			indto.setPreUsercd0005Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0005Nm(), ""));
    		} else {
    			indto.setPreUsercd0005Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0006() != null && !mainDataEntity.getPreUsercd0006().isEmpty()) {
    			indto.setPreUsercd0006Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0006Nm(), ""));
    		} else {
    			indto.setPreUsercd0006Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0007() != null && !mainDataEntity.getPreUsercd0007().isEmpty()) {
    			indto.setPreUsercd0007Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0007Nm(), ""));
    		} else {
    			indto.setPreUsercd0007Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0008() != null && !mainDataEntity.getPreUsercd0008().isEmpty()) {
    			indto.setPreUsercd0008Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0008Nm(), ""));
    		} else {
    			indto.setPreUsercd0008Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0009() != null && !mainDataEntity.getPreUsercd0009().isEmpty()) {
    			indto.setPreUsercd0009Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0009Nm(), ""));
    		} else {
    			indto.setPreUsercd0009Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0010() != null && !mainDataEntity.getPreUsercd0010().isEmpty()) {
    			indto.setPreUsercd0010Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0010Nm(), ""));
    		} else {
    			indto.setPreUsercd0010Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0011() != null && !mainDataEntity.getPreUsercd0011().isEmpty()) {
    			indto.setPreUsercd0011Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0011Nm(), ""));
    		} else {
    			indto.setPreUsercd0011Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0012() != null && !mainDataEntity.getPreUsercd0012().isEmpty()) {
    			indto.setPreUsercd0012Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0012Nm(), ""));
    		} else {
    			indto.setPreUsercd0012Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0013() != null && !mainDataEntity.getPreUsercd0013().isEmpty()) {
    			indto.setPreUsercd0013Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0013Nm(), ""));
    		} else {
    			indto.setPreUsercd0013Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0014() != null && !mainDataEntity.getPreUsercd0014().isEmpty()) {
    			indto.setPreUsercd0014Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0014Nm(), ""));
    		} else {
    			indto.setPreUsercd0014Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0015() != null && !mainDataEntity.getPreUsercd0015().isEmpty()) {
    			indto.setPreUsercd0015Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0015Nm(), ""));
    		} else {
    			indto.setPreUsercd0015Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0016() != null && !mainDataEntity.getPreUsercd0016().isEmpty()) {
    			indto.setPreUsercd0016Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0016Nm(), ""));
    		} else {
    			indto.setPreUsercd0016Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0017() != null && !mainDataEntity.getPreUsercd0017().isEmpty()) {
    			indto.setPreUsercd0017Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0017Nm(), ""));
    		} else {
    			indto.setPreUsercd0017Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0018() != null && !mainDataEntity.getPreUsercd0018().isEmpty()) {
    			indto.setPreUsercd0018Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0018Nm(), ""));
    		} else {
    			indto.setPreUsercd0018Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0019() != null && !mainDataEntity.getPreUsercd0019().isEmpty()) {
    			indto.setPreUsercd0019Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0019Nm(), ""));
    		} else {
    			indto.setPreUsercd0019Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0020() != null && !mainDataEntity.getPreUsercd0020().isEmpty()) {
    			indto.setPreUsercd0020Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0020Nm(), ""));
    		} else {
    			indto.setPreUsercd0020Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0021() != null && !mainDataEntity.getPreUsercd0021().isEmpty()) {
    			indto.setPreUsercd0021Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0021Nm(), ""));
    		} else {
    			indto.setPreUsercd0021Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0022() != null && !mainDataEntity.getPreUsercd0022().isEmpty()) {
    			indto.setPreUsercd0022Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0022Nm(), ""));
    		} else {
    			indto.setPreUsercd0022Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0023() != null && !mainDataEntity.getPreUsercd0023().isEmpty()) {
    			indto.setPreUsercd0023Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0023Nm(), ""));
    		} else {
    			indto.setPreUsercd0023Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0024() != null && !mainDataEntity.getPreUsercd0024().isEmpty()) {
    			indto.setPreUsercd0024Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0024Nm(), ""));
    		} else {
    			indto.setPreUsercd0024Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0025() != null && !mainDataEntity.getPreUsercd0025().isEmpty()) {
    			indto.setPreUsercd0025Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0025Nm(), ""));
    		} else {
    			indto.setPreUsercd0025Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0026() != null && !mainDataEntity.getPreUsercd0026().isEmpty()) {
    			indto.setPreUsercd0026Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0026Nm(), ""));
    		} else {
    			indto.setPreUsercd0026Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0027() != null && !mainDataEntity.getPreUsercd0027().isEmpty()) {
    			indto.setPreUsercd0027Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0027Nm(), ""));
    		} else {
    			indto.setPreUsercd0027Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0028() != null && !mainDataEntity.getPreUsercd0028().isEmpty()) {
    			indto.setPreUsercd0028Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0028Nm(), ""));
    		} else {
    			indto.setPreUsercd0028Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0029() != null && !mainDataEntity.getPreUsercd0029().isEmpty()) {
    			indto.setPreUsercd0029Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0029Nm(), ""));
    		} else {
    			indto.setPreUsercd0029Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0030() != null && !mainDataEntity.getPreUsercd0030().isEmpty()) {
    			indto.setPreUsercd0030Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0030Nm(), ""));
    		} else {
    			indto.setPreUsercd0030Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0031() != null && !mainDataEntity.getPreUsercd0031().isEmpty()) {
    			indto.setPreUsercd0031Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0031Nm(), ""));
    		} else {
    			indto.setPreUsercd0031Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0032() != null && !mainDataEntity.getPreUsercd0032().isEmpty()) {
    			indto.setPreUsercd0032Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0032Nm(), ""));
    		} else {
    			indto.setPreUsercd0032Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0033() != null && !mainDataEntity.getPreUsercd0033().isEmpty()) {
    			indto.setPreUsercd0033Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0033Nm(), ""));
    		} else {
    			indto.setPreUsercd0033Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0034() != null && !mainDataEntity.getPreUsercd0034().isEmpty()) {
    			indto.setPreUsercd0034Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0034Nm(), ""));
    		} else {
    			indto.setPreUsercd0034Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0035() != null && !mainDataEntity.getPreUsercd0035().isEmpty()) {
    			indto.setPreUsercd0035Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0035Nm(), ""));
    		} else {
    			indto.setPreUsercd0035Nm("--なし--");
    		}
    		if(mainDataEntity.getPreUsercd0036() != null && !mainDataEntity.getPreUsercd0036().isEmpty()) {
    			indto.setPreUsercd0036Nm(StringUtils.nvl(mainDataEntity.getPreUsercd0036Nm(), ""));
    		} else {
    			indto.setPreUsercd0036Nm("--なし--");
    		}

    		indto.setUsercd0001(StringUtils.nvl(mainDataEntity.getUsercd0001(), ""));
    		indto.setUsercd0002(StringUtils.nvl(mainDataEntity.getUsercd0002(), ""));
    		indto.setUsercd0003(StringUtils.nvl(mainDataEntity.getUsercd0003(), ""));
    		indto.setUsercd0004(StringUtils.nvl(mainDataEntity.getUsercd0004(), ""));
    		indto.setUsercd0005(StringUtils.nvl(mainDataEntity.getUsercd0005(), ""));
    		indto.setUsercd0006(StringUtils.nvl(mainDataEntity.getUsercd0006(), ""));
    		indto.setUsercd0007(StringUtils.nvl(mainDataEntity.getUsercd0007(), ""));
    		indto.setUsercd0008(StringUtils.nvl(mainDataEntity.getUsercd0008(), ""));
    		indto.setUsercd0009(StringUtils.nvl(mainDataEntity.getUsercd0009(), ""));
    		indto.setUsercd0010(StringUtils.nvl(mainDataEntity.getUsercd0010(), ""));
    		indto.setUsercd0011(StringUtils.nvl(mainDataEntity.getUsercd0011(), ""));
    		indto.setUsercd0012(StringUtils.nvl(mainDataEntity.getUsercd0012(), ""));
    		indto.setUsercd0013(StringUtils.nvl(mainDataEntity.getUsercd0013(), ""));
    		indto.setUsercd0014(StringUtils.nvl(mainDataEntity.getUsercd0014(), ""));
    		indto.setUsercd0015(StringUtils.nvl(mainDataEntity.getUsercd0015(), ""));
    		indto.setUsercd0016(StringUtils.nvl(mainDataEntity.getUsercd0016(), ""));
    		indto.setUsercd0017(StringUtils.nvl(mainDataEntity.getUsercd0017(), ""));
    		indto.setUsercd0018(StringUtils.nvl(mainDataEntity.getUsercd0018(), ""));
    		indto.setUsercd0019(StringUtils.nvl(mainDataEntity.getUsercd0019(), ""));
    		indto.setUsercd0020(StringUtils.nvl(mainDataEntity.getUsercd0020(), ""));
    		indto.setUsercd0021(StringUtils.nvl(mainDataEntity.getUsercd0021(), ""));
    		indto.setUsercd0022(StringUtils.nvl(mainDataEntity.getUsercd0022(), ""));
    		indto.setUsercd0023(StringUtils.nvl(mainDataEntity.getUsercd0023(), ""));
    		indto.setUsercd0024(StringUtils.nvl(mainDataEntity.getUsercd0024(), ""));
    		indto.setUsercd0025(StringUtils.nvl(mainDataEntity.getUsercd0025(), ""));
    		indto.setUsercd0026(StringUtils.nvl(mainDataEntity.getUsercd0026(), ""));
    		indto.setUsercd0027(StringUtils.nvl(mainDataEntity.getUsercd0027(), ""));
    		indto.setUsercd0028(StringUtils.nvl(mainDataEntity.getUsercd0028(), ""));
    		indto.setUsercd0029(StringUtils.nvl(mainDataEntity.getUsercd0029(), ""));
    		indto.setUsercd0030(StringUtils.nvl(mainDataEntity.getUsercd0030(), ""));
    		indto.setUsercd0031(StringUtils.nvl(mainDataEntity.getUsercd0031(), ""));
    		indto.setUsercd0032(StringUtils.nvl(mainDataEntity.getUsercd0032(), ""));
    		indto.setUsercd0033(StringUtils.nvl(mainDataEntity.getUsercd0033(), ""));
    		indto.setUsercd0034(StringUtils.nvl(mainDataEntity.getUsercd0034(), ""));
    		indto.setUsercd0035(StringUtils.nvl(mainDataEntity.getUsercd0035(), ""));
    		indto.setUsercd0036(StringUtils.nvl(mainDataEntity.getUsercd0036(), ""));
    		indto.setUsercd0101(StringUtils.nvl(mainDataEntity.getUsercd0101(), ""));
    		indto.setUsercd0102(StringUtils.nvl(mainDataEntity.getUsercd0102(), ""));
    		indto.setUsercd0103(StringUtils.nvl(mainDataEntity.getUsercd0103(), ""));
    		indto.setUsercd0104(StringUtils.nvl(mainDataEntity.getUsercd0104(), ""));
    		indto.setUsercd0105(StringUtils.nvl(mainDataEntity.getUsercd0105(), ""));
    		indto.setUsercd0106(StringUtils.nvl(mainDataEntity.getUsercd0106(), ""));
    		indto.setUsercd0107(StringUtils.nvl(mainDataEntity.getUsercd0107(), ""));
    		indto.setUsercd0108(StringUtils.nvl(mainDataEntity.getUsercd0108(), ""));
    		indto.setUsercd0109(StringUtils.nvl(mainDataEntity.getUsercd0109(), ""));
    		indto.setUsercd0201(StringUtils.nvl(mainDataEntity.getUsercd0201(), ""));
    		indto.setUsercd0202(StringUtils.nvl(mainDataEntity.getUsercd0202(), ""));
    		indto.setUsercd0203(StringUtils.nvl(mainDataEntity.getUsercd0203(), ""));
    		indto.setUsercd0204(StringUtils.nvl(mainDataEntity.getUsercd0204(), ""));
    		indto.setUsercd0205(StringUtils.nvl(mainDataEntity.getUsercd0205(), ""));
    		indto.setUsercd0206(StringUtils.nvl(mainDataEntity.getUsercd0206(), ""));

    		// 診療報酬情報
    		indto.setPreReward04(StringUtils.nvl(mainDataEntity.getPreReward04(), ""));
    		indto.setPreReward05(StringUtils.nvl(mainDataEntity.getPreReward05(), ""));
    		indto.setPreReward08(StringUtils.nvl(mainDataEntity.getPreReward08(), ""));
    		indto.setPreReward09(StringUtils.nvl(mainDataEntity.getPreReward09(), ""));
    		indto.setPreReward16(StringUtils.nvl(mainDataEntity.getPreReward16(), ""));
    		indto.setPreReward17(StringUtils.nvl(mainDataEntity.getPreReward17(), ""));
    		indto.setPreReward18(StringUtils.nvl(mainDataEntity.getPreReward18(), ""));
    		indto.setPreReward21(StringUtils.nvl(mainDataEntity.getPreReward21(), ""));
    		indto.setPreReward23(StringUtils.nvl(mainDataEntity.getPreReward23(), ""));
    		indto.setPreReward25(StringUtils.nvl(mainDataEntity.getPreReward25(), ""));
    		indto.setPreReward26(StringUtils.nvl(mainDataEntity.getPreReward26(), ""));
    		indto.setPreReward27(StringUtils.nvl(mainDataEntity.getPreReward27(), ""));
    		indto.setPreReward29(StringUtils.nvl(mainDataEntity.getPreReward29(), ""));
    		indto.setPreReward35(StringUtils.nvl(mainDataEntity.getPreReward35(), ""));
    		indto.setPreReward36(StringUtils.nvl(mainDataEntity.getPreReward36(), ""));
    		indto.setPreReward37(StringUtils.nvl(mainDataEntity.getPreReward37(), ""));
    		indto.setPreReward44(StringUtils.nvl(mainDataEntity.getPreReward44(), ""));

    		if(mainDataEntity.getPreReward04() != null && !mainDataEntity.getPreReward04().isEmpty()) {
    			indto.setPreReward04Nm(mainDataEntity.getPreReward04() + "：" + StringUtils.nvl(mainDataEntity.getPreReward04Nm(), ""));
    		} else {
    			indto.setPreReward04Nm("--なし--");
    		}
    		if(mainDataEntity.getPreReward05() != null && !mainDataEntity.getPreReward05().isEmpty()) {
    			indto.setPreReward05Nm(mainDataEntity.getPreReward05() + "：" + StringUtils.nvl(mainDataEntity.getPreReward05Nm(), ""));
    		} else {
    			indto.setPreReward05Nm("--なし--");
    		}
    		if(mainDataEntity.getPreReward08() != null && !mainDataEntity.getPreReward08().isEmpty()) {
    			indto.setPreReward08Nm(mainDataEntity.getPreReward08() + "：" + StringUtils.nvl(mainDataEntity.getPreReward08Nm(), ""));
    		} else {
    			indto.setPreReward08Nm("--なし--");
    		}
    		if(mainDataEntity.getPreReward09() != null && !mainDataEntity.getPreReward09().isEmpty()) {
    			indto.setPreReward09Nm(mainDataEntity.getPreReward09() + "：" + StringUtils.nvl(mainDataEntity.getPreReward09Nm(), ""));
    		} else {
    			indto.setPreReward09Nm("--なし--");
    		}
    		if(mainDataEntity.getPreReward16() != null && !mainDataEntity.getPreReward16().isEmpty()) {
    			indto.setPreReward16Nm(mainDataEntity.getPreReward16() + "：" + StringUtils.nvl(mainDataEntity.getPreReward16Nm(), ""));
    		} else {
    			indto.setPreReward16Nm("--なし--");
    		}
    		if(mainDataEntity.getPreReward17() != null && !mainDataEntity.getPreReward17().isEmpty()) {
    			indto.setPreReward17Nm(mainDataEntity.getPreReward17() + "：" + StringUtils.nvl(mainDataEntity.getPreReward17Nm(), ""));
    		} else {
    			indto.setPreReward17Nm("--なし--");
    		}
    		if(mainDataEntity.getPreReward18() != null && !mainDataEntity.getPreReward18().isEmpty()) {
    			indto.setPreReward18Nm(mainDataEntity.getPreReward18() + "：" + StringUtils.nvl(mainDataEntity.getPreReward18Nm(), ""));
    		} else {
    			indto.setPreReward18Nm("--なし--");
    		}
    		if(mainDataEntity.getPreReward21() != null && !mainDataEntity.getPreReward21().isEmpty()) {
    			indto.setPreReward21Nm(mainDataEntity.getPreReward21() + "：" + StringUtils.nvl(mainDataEntity.getPreReward21Nm(), ""));
    		} else {
    			indto.setPreReward21Nm("--なし--");
    		}
    		if(mainDataEntity.getPreReward23() != null && !mainDataEntity.getPreReward23().isEmpty()) {
    			indto.setPreReward23Nm(mainDataEntity.getPreReward23() + "：" + StringUtils.nvl(mainDataEntity.getPreReward23Nm(), ""));
    		} else {
    			indto.setPreReward23Nm("--なし--");
    		}
    		if(mainDataEntity.getPreReward25() != null && !mainDataEntity.getPreReward25().isEmpty()) {
    			indto.setPreReward25Nm(mainDataEntity.getPreReward25() + "：" + StringUtils.nvl(mainDataEntity.getPreReward25Nm(), ""));
    		} else {
    			indto.setPreReward25Nm("--なし--");
    		}
    		if(mainDataEntity.getPreReward26() != null && !mainDataEntity.getPreReward26().isEmpty()) {
    			indto.setPreReward26Nm(mainDataEntity.getPreReward26() + "：" + StringUtils.nvl(mainDataEntity.getPreReward26Nm(), ""));
    		} else {
    			indto.setPreReward26Nm("--なし--");
    		}
    		if(mainDataEntity.getPreReward27() != null && !mainDataEntity.getPreReward27().isEmpty()) {
    			indto.setPreReward27Nm(mainDataEntity.getPreReward27() + "：" + StringUtils.nvl(mainDataEntity.getPreReward27Nm(), ""));
    		} else {
    			indto.setPreReward27Nm("--なし--");
    		}
    		if(mainDataEntity.getPreReward29() != null && !mainDataEntity.getPreReward29().isEmpty()) {
    			indto.setPreReward29Nm(mainDataEntity.getPreReward29() + "：" + StringUtils.nvl(mainDataEntity.getPreReward29Nm(), ""));
    		} else {
    			indto.setPreReward29Nm("--なし--");
    		}
    		if(mainDataEntity.getPreReward35() != null && !mainDataEntity.getPreReward35().isEmpty()) {
    			indto.setPreReward35Nm(mainDataEntity.getPreReward35() + "：" + StringUtils.nvl(mainDataEntity.getPreReward35Nm(), ""));
    		} else {
    			indto.setPreReward35Nm("--なし--");
    		}
    		if(mainDataEntity.getPreReward36() != null && !mainDataEntity.getPreReward36().isEmpty()) {
    			indto.setPreReward36Nm(mainDataEntity.getPreReward36() + "：" + StringUtils.nvl(mainDataEntity.getPreReward36Nm(), ""));
    		} else {
    			indto.setPreReward36Nm("--なし--");
    		}
    		if(mainDataEntity.getPreReward37() != null && !mainDataEntity.getPreReward37().isEmpty()) {
    			indto.setPreReward37Nm(mainDataEntity.getPreReward37() + "：" + StringUtils.nvl(mainDataEntity.getPreReward37Nm(), ""));
    		} else {
    			indto.setPreReward37Nm("--なし--");
    		}
    		if(mainDataEntity.getPreReward44() != null && !mainDataEntity.getPreReward44().isEmpty()) {
    			indto.setPreReward44Nm(mainDataEntity.getPreReward44() + "：" + StringUtils.nvl(mainDataEntity.getPreReward44Nm(), ""));
    		} else {
    			indto.setPreReward44Nm("--なし--");
    		}

    		indto.setReward04(StringUtils.nvl(mainDataEntity.getReward04(), ""));
    		indto.setReward05(StringUtils.nvl(mainDataEntity.getReward05(), ""));
    		indto.setReward08(StringUtils.nvl(mainDataEntity.getReward08(), ""));
    		indto.setReward09(StringUtils.nvl(mainDataEntity.getReward09(), ""));
    		indto.setReward16(StringUtils.nvl(mainDataEntity.getReward16(), ""));
    		indto.setReward17(StringUtils.nvl(mainDataEntity.getReward17(), ""));
    		indto.setReward18(StringUtils.nvl(mainDataEntity.getReward18(), ""));
    		indto.setReward21(StringUtils.nvl(mainDataEntity.getReward21(), ""));
    		indto.setReward23(StringUtils.nvl(mainDataEntity.getReward23(), ""));
    		indto.setReward25(StringUtils.nvl(mainDataEntity.getReward25(), ""));
    		indto.setReward26(StringUtils.nvl(mainDataEntity.getReward26(), ""));
    		indto.setReward27(StringUtils.nvl(mainDataEntity.getReward27(), ""));
    		indto.setReward29(StringUtils.nvl(mainDataEntity.getReward29(), ""));
    		indto.setReward35(StringUtils.nvl(mainDataEntity.getReward35(), ""));
    		indto.setReward36(StringUtils.nvl(mainDataEntity.getReward36(), ""));
    		indto.setReward37(StringUtils.nvl(mainDataEntity.getReward37(), ""));
    		indto.setReward44(StringUtils.nvl(mainDataEntity.getReward44(), ""));

    		// コメント
    		indto.setReqComment(StringUtils.nvl(mainDataEntity.getReqComment(), ""));
    		indto.setAprMemo(StringUtils.nvl(mainDataEntity.getAprMemo(), ""));
    		indto.setShnFlg(StringUtils.nvl(mainDataEntity.getShnFlg(), ""));
        }

        // DropDownList作成
        createCombo(indto);

        // 編集可能判定
        if("".equals(indto.getReqStsCd()) || indto.getReqStsCd() == null) {
        	// 完全新規(申請管理．申請ステータスが取得できない)の場合は活性
        	indto.setEditApprFlg("1");
        } else if(!"JKN0813".equals(indto.getLoginJokenSetCd()) && !"01".equals(indto.getReqStsCd())) {
        	// MR権限の場合、取得した申請管理．申請ステータスが'01'(保存済み)以外の場合は、入力項目はすべて変更不可（非活性）とする
        	indto.setEditApprFlg("0");
        } else if("JKN0813".equals(indto.getLoginJokenSetCd()) && !"01".equals(indto.getReqStsCd())
        			&& !"03".equals(indto.getReqStsCd()) && !"13".equals(indto.getReqStsCd())) {
        	// 管理者権限の場合、取得した申請管理．申請ステータスが'01'(保存済み)、'03'(承認待ち)、'13'(ULT承認待ち)以外の場合は、入力項目はすべて変更不可（非活性）とする
        	indto.setEditApprFlg("0");
        } else {
        	indto.setEditApprFlg("1");
        }

        // END UOC
        return outdto;
    }

    /**
     * コンボ作成
     * @param indto NF012DTO
     * @return なし
     * @customizable
     */
    private void createCombo(NF012DTO indto){
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

		// TODO FREE系もコンボボックス？

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

		// 老人短期入所施設
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_WELFARE02);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapWelfare02 = new LinkedHashMap<String, String>();
		mapWelfare02.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapWelfare02.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setWelfare02Combo(mapWelfare02);

		// その他(老人福祉法関連分類情報)
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_WELFARE08);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapWelfare08 = new LinkedHashMap<String, String>();
		mapWelfare08.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapWelfare08.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setWelfare08Combo(mapWelfare08);

		// En-T ARB ('18.11)
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT01);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult01 = new LinkedHashMap<String, String>();
		mapResult01.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult01.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult01Combo(mapResult01);

		// En-T DPP4 ('18.11)
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT02);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult02 = new LinkedHashMap<String, String>();
		mapResult02.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult02.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult02Combo(mapResult02);

		// En-T ω3 ('18.11)
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT03);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult03 = new LinkedHashMap<String, String>();
		mapResult03.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult03.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult03Combo(mapResult03);

		// En-T PPI ('18.11)
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT04);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult04 = new LinkedHashMap<String, String>();
		mapResult04.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult04.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult04Combo(mapResult04);

		// En-T 睡眠 ('18.11)
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT05);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult05 = new LinkedHashMap<String, String>();
		mapResult05.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult05.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult05Combo(mapResult05);

		// En-T アルツハイマー ('18.11)
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT06);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult06 = new LinkedHashMap<String, String>();
		mapResult06.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult06.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult06Combo(mapResult06);

		// En-T 骨粗鬆症 ('18.11)
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT07);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult07 = new LinkedHashMap<String, String>();
		mapResult07.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult07.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult07Combo(mapResult07);

		// REMターゲット
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT08);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult08 = new LinkedHashMap<String, String>();
		mapResult08.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult08.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult08Combo(mapResult08);

		// BLP未獲得市場区分
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT09);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult09 = new LinkedHashMap<String, String>();
		mapResult09.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult09.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult09Combo(mapResult09);

		// 整形育成先
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT10);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult10 = new LinkedHashMap<String, String>();
		mapResult10.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult10.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult10Combo(mapResult10);

		// TKP・MSコールUP
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT11);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult11 = new LinkedHashMap<String, String>();
		mapResult11.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult11.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult11Combo(mapResult11);

		// ALC Core1・2('19.10)
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT12);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult12 = new LinkedHashMap<String, String>();
		mapResult12.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult12.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult12Combo(mapResult12);

		// ENT Tier1-4('19.4)
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT13);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult13 = new LinkedHashMap<String, String>();
		mapResult13.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult13.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult13Combo(mapResult13);

		// JIA厚労省施設
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT14);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult14 = new LinkedHashMap<String, String>();
		mapResult14.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult14.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult14Combo(mapResult14);

		// 注力先('18.12)
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT15);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult15 = new LinkedHashMap<String, String>();
		mapResult15.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult15.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult15Combo(mapResult15);

		// ENBターゲット先('19.4)
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT16);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult16 = new LinkedHashMap<String, String>();
		mapResult16.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult16.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult16Combo(mapResult16);

		// 骨G
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT17);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult17 = new LinkedHashMap<String, String>();
		mapResult17.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult17.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult17Combo(mapResult17);

		// ナテグリニド繁用先
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT18);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult18 = new LinkedHashMap<String, String>();
		mapResult18.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult18.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult18Combo(mapResult18);

		// GLUターゲット先
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT19);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult19 = new LinkedHashMap<String, String>();
		mapResult19.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult19.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult19Combo(mapResult19);

		// 骨G2
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT20);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult20 = new LinkedHashMap<String, String>();
		mapResult20.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult20.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult20Combo(mapResult20);

		// （Ｕ：未使用）
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT21);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult21 = new LinkedHashMap<String, String>();
		mapResult21.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult21.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult21Combo(mapResult21);

		// ＤＯＩＴ３
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT22);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult22 = new LinkedHashMap<String, String>();
		mapResult22.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult22.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult22Combo(mapResult22);

		// ＰＣＩ３００
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT23);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult23 = new LinkedHashMap<String, String>();
		mapResult23.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult23.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult23Combo(mapResult23);

		// ＪＤＥｓＡＲＴ
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT24);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult24 = new LinkedHashMap<String, String>();
		mapResult24.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult24.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult24Combo(mapResult24);

		// （Ｙ：未使用）
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT25);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult25 = new LinkedHashMap<String, String>();
		mapResult25.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult25.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult25Combo(mapResult25);

		// ＴＡＰ先
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT26);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult26 = new LinkedHashMap<String, String>();
		mapResult26.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult26.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult26Combo(mapResult26);

		// ＱＯＬ２００５ＴＫＰ
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT27);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult27 = new LinkedHashMap<String, String>();
		mapResult27.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult27.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult27Combo(mapResult27);

		// ＴＫＰ未獲得市場区分
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT28);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult28 = new LinkedHashMap<String, String>();
		mapResult28.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult28.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult28Combo(mapResult28);

		// ＡＣＴ未獲得市場区分
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT29);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult29 = new LinkedHashMap<String, String>();
		mapResult29.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult29.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult29Combo(mapResult29);

		// （４：未使用）
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT30);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult30 = new LinkedHashMap<String, String>();
		mapResult30.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult30.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult30Combo(mapResult30);

		// 旧ＬＭＲ
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT31);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult31 = new LinkedHashMap<String, String>();
		mapResult31.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult31.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult31Combo(mapResult31);

		// （６：未使用）
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT32);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult32 = new LinkedHashMap<String, String>();
		mapResult32.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult32.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult32Combo(mapResult32);

		// ＬＥＵ乳癌
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT33);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult33 = new LinkedHashMap<String, String>();
		mapResult33.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult33.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult33Combo(mapResult33);

		// ＯＮＣ担当区分
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT34);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult34 = new LinkedHashMap<String, String>();
		mapResult34.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult34.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult34Combo(mapResult34);

		// ＲＰＬ（ＣＶＭ）担当区分
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT35);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult35 = new LinkedHashMap<String, String>();
		mapResult35.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult35.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult35Combo(mapResult35);

		// （１０：未使用）
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_RESULT36);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapResult36 = new LinkedHashMap<String, String>();
		mapResult36.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapResult36.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setResult36Combo(mapResult36);

		// 内視鏡
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_EQUIP01);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapEquip01 = new LinkedHashMap<String, String>();
		mapEquip01.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapEquip01.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setEquip01Combo(mapEquip01);

		// 骨量測定器
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_EQUIP02);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapEquip02 = new LinkedHashMap<String, String>();
		mapEquip02.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapEquip02.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setEquip02Combo(mapEquip02);

		// ICD
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_EQUIP03);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapEquip03 = new LinkedHashMap<String, String>();
		mapEquip03.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapEquip03.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setEquip03Combo(mapEquip03);

		// CCU
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_EQUIP07);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapEquip07 = new LinkedHashMap<String, String>();
		mapEquip07.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapEquip07.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setEquip07Combo(mapEquip07);

		// NCU
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_EQUIP09);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapEquip09 = new LinkedHashMap<String, String>();
		mapEquip09.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapEquip09.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setEquip09Combo(mapEquip09);

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

		// 酸抑制剤
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_MARKET02);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapMarket02 = new LinkedHashMap<String, String>();
		mapMarket02.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapMarket02.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setMarket02Combo(mapMarket02);

		// 高脂血症
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_MARKET03);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapMarket03 = new LinkedHashMap<String, String>();
		mapMarket03.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapMarket03.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setMarket03Combo(mapMarket03);

		// 高血圧
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_MARKET04);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapMarket04 = new LinkedHashMap<String, String>();
		mapMarket04.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapMarket04.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setMarket04Combo(mapMarket04);

		// 糖尿病
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_MARKET06);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapMarket06 = new LinkedHashMap<String, String>();
		mapMarket06.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapMarket06.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setMarket06Combo(mapMarket06);

		// 骨粗鬆症
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_MARKET07);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapMarket07 = new LinkedHashMap<String, String>();
		mapMarket07.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapMarket07.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setMarket07Combo(mapMarket07);

		// CVMターゲット
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_MARKET09);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapMarket09 = new LinkedHashMap<String, String>();
		mapMarket09.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapMarket09.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setMarket09Combo(mapMarket09);

		// 社会医療法人
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_MEDICAL12);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapMedical12 = new LinkedHashMap<String, String>();
		mapMedical12.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapMedical12.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setMedical12Combo(mapMedical12);

		// 入院包括化実施病院
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_SPFUNC01);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapSpFunc01 = new LinkedHashMap<String, String>();
		mapSpFunc01.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapSpFunc01.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setSpfunc01Combo(mapSpFunc01);

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

		// 大学院大学
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_SPFUNC04);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapSpFunc04 = new LinkedHashMap<String, String>();
		mapSpFunc04.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapSpFunc04.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setSpfunc04Combo(mapSpFunc04);

		// がん連携パス
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_TIEUP10);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapTieup10 = new LinkedHashMap<String, String>();
		mapTieup10.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapTieup10.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setTieup10Combo(mapTieup10);

		// 心疾患連携パス
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_TIEUP11);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapTieup11 = new LinkedHashMap<String, String>();
		mapTieup11.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapTieup11.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setTieup11Combo(mapTieup11);

		// 糖尿病連携パス
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_TIEUP12);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapTieup12 = new LinkedHashMap<String, String>();
		mapTieup12.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapTieup12.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setTieup12Combo(mapTieup12);

		// （Ａ：未使用）
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0001);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0001 = new LinkedHashMap<String, String>();
		mapUsercd0001.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0001.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0001Combo(mapUsercd0001);

		// ＶＣＴ・Ｖ先
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0002);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0002 = new LinkedHashMap<String, String>();
		mapUsercd0002.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0002.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0002Combo(mapUsercd0002);

		// （Ｃ：未使用）
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0003);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0003 = new LinkedHashMap<String, String>();
		mapUsercd0003.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0003.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0003Combo(mapUsercd0003);

		// NEXアーリーアダプタ
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0004);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0004 = new LinkedHashMap<String, String>();
		mapUsercd0004.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0004.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0004Combo(mapUsercd0004);

		// （Ｅ：未使用）
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0005);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0005 = new LinkedHashMap<String, String>();
		mapUsercd0005.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0005.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0005Combo(mapUsercd0005);

		// テルモ・コプロ
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0006);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0006 = new LinkedHashMap<String, String>();
		mapUsercd0006.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0006.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0006Combo(mapUsercd0006);

		// （Ｇ：未使用）
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0007);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0007 = new LinkedHashMap<String, String>();
		mapUsercd0007.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0007.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0007Combo(mapUsercd0007);

		// リュープリン・コプロ１２／１０
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0008);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0008 = new LinkedHashMap<String, String>();
		mapUsercd0008.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0008.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0008Combo(mapUsercd0008);

		// アクトス・コプロ
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0009);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0009 = new LinkedHashMap<String, String>();
		mapUsercd0009.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0009.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0009Combo(mapUsercd0009);

		// ベネット・コプロ
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0010);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0010 = new LinkedHashMap<String, String>();
		mapUsercd0010.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0010.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0010Combo(mapUsercd0010);

		// グルファスト
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0011);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0011 = new LinkedHashMap<String, String>();
		mapUsercd0011.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0011.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0011Combo(mapUsercd0011);

		// リュープリンコプロ０８／１０
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0012);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0012 = new LinkedHashMap<String, String>();
		mapUsercd0012.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0012.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0012Combo(mapUsercd0012);

		// （Ｍ：未使用）
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0013);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0013 = new LinkedHashMap<String, String>();
		mapUsercd0013.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0013.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0013Combo(mapUsercd0013);

		// COP活動先
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0014);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0014 = new LinkedHashMap<String, String>();
		mapUsercd0014.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0014.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0014Combo(mapUsercd0014);

		// ω3製剤市場
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0015);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0015 = new LinkedHashMap<String, String>();
		mapUsercd0015.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0015.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0015Combo(mapUsercd0015);

		// TCB RW在籍施設
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0016);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0016 = new LinkedHashMap<String, String>();
		mapUsercd0016.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0016.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0016Combo(mapUsercd0016);

		// DPP4アーリーアダプタ
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0017);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0017 = new LinkedHashMap<String, String>();
		mapUsercd0017.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0017.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0017Combo(mapUsercd0017);

		// DPP4阻害薬('16.2)
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0018);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0018 = new LinkedHashMap<String, String>();
		mapUsercd0018.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0018.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0018Combo(mapUsercd0018);

		// DPP4阻害薬市場
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0019);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0019 = new LinkedHashMap<String, String>();
		mapUsercd0019.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0019.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0019Combo(mapUsercd0019);

		// ARB/CCB配合剤市場
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0020);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0020 = new LinkedHashMap<String, String>();
		mapUsercd0020.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0020.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0020Combo(mapUsercd0020);

		// 抗潰瘍(ＰＰＩ)市場
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0021);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0021 = new LinkedHashMap<String, String>();
		mapUsercd0021.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0021.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0021Combo(mapUsercd0021);

		// 骨粗鬆症市場
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0022);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0022 = new LinkedHashMap<String, String>();
		mapUsercd0022.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0022.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0022Combo(mapUsercd0022);

		// 睡眠市場
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0023);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0023 = new LinkedHashMap<String, String>();
		mapUsercd0023.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0023.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0023Combo(mapUsercd0023);

		// Ｘ雑・災害
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0024);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0024 = new LinkedHashMap<String, String>();
		mapUsercd0024.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0024.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0024Combo(mapUsercd0024);

		// アルツハイマー市場
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0025);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0025 = new LinkedHashMap<String, String>();
		mapUsercd0025.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0025.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0025Combo(mapUsercd0025);

		// ARB総市場
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0026);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0026 = new LinkedHashMap<String, String>();
		mapUsercd0026.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0026.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0026Combo(mapUsercd0026);

		// 施設責任者
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0027);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0027 = new LinkedHashMap<String, String>();
		mapUsercd0027.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0027.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0027Combo(mapUsercd0027);

		// タケプロン・コプロ
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0028);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0028 = new LinkedHashMap<String, String>();
		mapUsercd0028.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0028.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0028Combo(mapUsercd0028);

		// 抗潰瘍(PPI)市場('16.6)
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0029);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0029 = new LinkedHashMap<String, String>();
		mapUsercd0029.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0029.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0029Combo(mapUsercd0029);

		// （４：未使用）
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0030);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0030 = new LinkedHashMap<String, String>();
		mapUsercd0030.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0030.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0030Combo(mapUsercd0030);

		// インフル・セオリア
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0031);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0031 = new LinkedHashMap<String, String>();
		mapUsercd0031.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0031.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0031Combo(mapUsercd0031);

		// インフル・あすか
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0032);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0032 = new LinkedHashMap<String, String>();
		mapUsercd0032.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0032.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0032Combo(mapUsercd0032);

		// マーケティングＧ・Ｔ
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0033);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0033 = new LinkedHashMap<String, String>();
		mapUsercd0033.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0033.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0033Combo(mapUsercd0033);

		// （８：未使用）
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0034);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0034 = new LinkedHashMap<String, String>();
		mapUsercd0034.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0034.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0034Combo(mapUsercd0034);

		// セルタッチ・ベネット
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0035);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0035 = new LinkedHashMap<String, String>();
		mapUsercd0035.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0035.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0035Combo(mapUsercd0035);

		// （１０：未使用）
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_USERCD0036);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUsercd0036 = new LinkedHashMap<String, String>();
		mapUsercd0036.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUsercd0036.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setUsercd0036Combo(mapUsercd0036);

		// TODO USERCD0101～ コンボボックス？

		// 入院診療計画
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_REWARD04);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapReward04 = new LinkedHashMap<String, String>();
		mapReward04.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapReward04.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setReward04Combo(mapReward04);

		// 院内感染防止対策
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_REWARD05);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapReward05 = new LinkedHashMap<String, String>();
		mapReward05.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapReward05.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setReward05Combo(mapReward05);

		// 地域連携小児夜間・休日診療料1
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_REWARD08);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapReward08 = new LinkedHashMap<String, String>();
		mapReward08.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapReward08.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setReward08Combo(mapReward08);

		// 小児入院医療管理料
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_REWARD09);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapReward09 = new LinkedHashMap<String, String>();
		mapReward09.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapReward09.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setReward09Combo(mapReward09);

		// 緩和ケア診療加算
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_REWARD18);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapReward18 = new LinkedHashMap<String, String>();
		mapReward18.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapReward18.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setReward18Combo(mapReward18);

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

		// 在宅患者訪問診療料又は在総診
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_REWARD23);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapReward23 = new LinkedHashMap<String, String>();
		mapReward23.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapReward23.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setReward23Combo(mapReward23);

		// 生活習慣病指導管理料
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_REWARD25);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapReward25 = new LinkedHashMap<String, String>();
		mapReward25.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapReward25.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setReward25Combo(mapReward25);

		// 慢性疼痛疾患管理料
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_REWARD26);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapReward26 = new LinkedHashMap<String, String>();
		mapReward26.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapReward26.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setReward26Combo(mapReward26);

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

		// 地域連携時間外診療(有無)
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_REWARD35);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapReward35 = new LinkedHashMap<String, String>();
		mapReward35.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapReward35.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setReward35Combo(mapReward35);

		// 地域連携診療計画管理料
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_REWARD36);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapReward36 = new LinkedHashMap<String, String>();
		mapReward36.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapReward36.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setReward36Combo(mapReward36);

		// 地域連携診療計画退院時指導料
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_REWARD37);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapReward37 = new LinkedHashMap<String, String>();
		mapReward37.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapReward37.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setReward37Combo(mapReward37);

		// 病理診断料
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_REWARD44);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapReward44 = new LinkedHashMap<String, String>();
		mapReward44.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapReward44.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setReward44Combo(mapReward44);

		// 急性期入院加算
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_REWARD16);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapReward16 = new LinkedHashMap<String, String>();
		mapReward16.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapReward16.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setReward16Combo(mapReward16);

		// 急性期特定入院加算
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_REWARD17);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapReward17 = new LinkedHashMap<String, String>();
		mapReward17.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapReward17.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setReward17Combo(mapReward17);

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
     * @param indto NF012DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO register(NF012DTO indto) {
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

        if("0".equals(indto.getFuncId())) {
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
	        if(indto.getReqComment() != null && indto.getReqComment().length() > 300) {
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
	        if(!chkPostcode(indto.getInsPcode())) {
	        	// 正しい書式で入力してください。（郵便番号）
				errMsg += loginInfo.getMsgData(RdmConstantsData.W016).replace("項目名", "郵便番号") + "\n";
				errFlg = true;
	        }
	        if("10".equals(indto.getInsSbt()) && "00-0000-0000".equals(indto.getInsPhone1())) {
	        	// 医療モールを新規作成する場合は「00-0000-0000」と入力してください。電話番号(代表)
				errMsg += loginInfo.getMsgData(RdmConstantsData.W017) + "\n";
				errFlg = true;
	        }

	        // 最終更新日時が、画面OPEN時とボタン押下時で異なっていた場合
	        if(indto.getUpdShaYmd() != null && !indto.getUpdShaYmd().equals("")) {
	        	TRdmReqKnrEntity tRdmReqKnrChkEntity = new TRdmReqKnrEntity("selectNF011DateChkData");
	        	tRdmReqKnrChkEntity.setReqId(reqId);

	        	List<TRdmReqKnrEntity> tRdmReqKnrEntityList = dao.select(tRdmReqKnrChkEntity);

	        	if(tRdmReqKnrEntityList.size() > 0) {
	        		if(!tRdmReqKnrEntityList.get(0).getUpdShaYmd().equals(indto.getUpdShaYmd())) {
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

	        // 申請ステータスを「01：保存済」として各テーブルに画面の申請情報を登録
	        // 申請管理
	        TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity();
	        tRdmReqKnrEntity.setReqId(indto.getReqId());
	        TRdmReqKnrEntity tRdmReqKnrData = dao.selectByPK(tRdmReqKnrEntity);

	        if(tRdmReqKnrData == null) {
	        	// 新規登録
	        	// 新規にIDを取得
	        	SeqRdmReqIdEntity seqRdmReqIdEntity = new SeqRdmReqIdEntity();
	        	List<SeqRdmReqIdEntity> seqRdmReqIdDate = dao.select(seqRdmReqIdEntity);
	        	reqId = seqRdmReqIdDate.get(0).getReqId();

	        	// レコードを登録
	        	TRdmReqKnrEntity tRdmReqKnrInsData = new TRdmReqKnrEntity();
	        	tRdmReqKnrInsData.setReqId(reqId);
	        	if("JKN0813".equals(indto.getLoginJokenSetCd())) {
	        		// 承認者（管理者権限）が申請の場合、'2'(DSG起因)
	        		tRdmReqKnrInsData.setReqChl("2");
	        		tRdmReqKnrInsData.setReqKngKbn("2");
	        	} else {
	        		// "MRが申請の場合、'1'(MR起因)
	        		tRdmReqKnrInsData.setReqChl("1");
	        		tRdmReqKnrInsData.setReqKngKbn("1");
	        	}
	        	tRdmReqKnrInsData.setReqType("02");
	        	tRdmReqKnrInsData.setReqStsCd("01");
	        	tRdmReqKnrInsData.setReqBrCd(indto.getReqBrCd());
	        	tRdmReqKnrInsData.setReqDistCd(indto.getReqDistCd());
	        	tRdmReqKnrInsData.setReqShzNm(indto.getReqShzNm());
	        	tRdmReqKnrInsData.setReqJgiNo(indto.getReqJgiNo());
	        	tRdmReqKnrInsData.setReqJgiName(indto.getReqJgiName());
	        	tRdmReqKnrInsData.setReqComment(indto.getReqComment());
	        	tRdmReqKnrInsData.setInsNo(indto.getInsNo());
	        	tRdmReqKnrInsData.setInsShaYmd(sysDate);
	        	tRdmReqKnrInsData.setInsShaId(indto.getLoginJgiNo());
	        	tRdmReqKnrInsData.setUpdShaYmd(sysDate);
	        	tRdmReqKnrInsData.setUpdShaId(indto.getLoginJgiNo());

	        	dao.insertByValue(tRdmReqKnrInsData);

	        } else {
	        	// 更新
	        	TRdmReqKnrEntity tRdmReqKnrUpdData = new TRdmReqKnrEntity("updateNF011Data");
	        	tRdmReqKnrUpdData.setReqId(reqId);

	        	if("13".equals(indto.getReqStsCd())) {
	        		tRdmReqKnrUpdData.setReqStsCd("11");
	        	} else {
	        		tRdmReqKnrUpdData.setReqStsCd("01");
	        	}

	        	tRdmReqKnrUpdData.setReqComment(indto.getReqComment());
	        	tRdmReqKnrUpdData.setUpdShaYmd(sysDate);
	        	tRdmReqKnrUpdData.setUpdShaId(indto.getLoginJgiNo());

	        	dao.update(tRdmReqKnrUpdData);
	        }

	        // 施設_申請管理
	        TRdmHcoReqEntity tRdmHcoReqEntity = new TRdmHcoReqEntity();
	        tRdmHcoReqEntity.setReqId(reqId);
	        TRdmHcoReqEntity tRdmHcoReqData = dao.selectByPK(tRdmHcoReqEntity);

	        // 管理者権限
	        boolean knr = "JKN0813".equals(indto.getLoginJokenSetCd());

	        if(tRdmHcoReqData == null) {
	        	// 新規登録
	        	TRdmHcoReqEntity tRdmHcoReqInsData = new TRdmHcoReqEntity();
	        	tRdmHcoReqInsData.setReqId(reqId);
	        	tRdmHcoReqInsData.setInsNo(indto.getInsNo());

	        	tRdmHcoReqInsData.setInsKana(getUpdValue(indto.getPreInsKana(), indto.getInsKana()));
	        	tRdmHcoReqInsData.setInsAbbrName(getUpdValue(indto.getPreInsAbbrName(), indto.getInsAbbrName()));
	        	tRdmHcoReqInsData.setInsFormalName(getUpdValue(indto.getPreInsFormalName(), indto.getInsFormalName()));
	        	tRdmHcoReqInsData.setInsPcode(getUpdValue(indto.getPreInsPcode(), indto.getInsPcode()));
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
	        		urlYmd = urlYmd.replace("-", "");
	        	}
	        	tRdmHcoReqInsData.setInsUrlYmd(getUpdValue(preUrlYmd, urlYmd));

	        	tRdmHcoReqInsData.setTradeType(getUpdValue(indto.getPreTradeType(), indto.getTradeType()));
	        	tRdmHcoReqInsData.setWsType(getUpdValue(indto.getPreWsType(), indto.getWsType()));
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
		        	tRdmHcoReqInsData.setFree0011(getUpdValue(indto.getPreFree0001(), indto.getFree0011()));
		        	tRdmHcoReqInsData.setFree0012(getUpdValue(indto.getPreFree0002(), indto.getFree0012()));
		        	tRdmHcoReqInsData.setFree0013(getUpdValue(indto.getPreFree0003(), indto.getFree0013()));
		        	tRdmHcoReqInsData.setFree0014(getUpdValue(indto.getPreFree0004(), indto.getFree0014()));
		        	tRdmHcoReqInsData.setFree0015(getUpdValue(indto.getPreFree0005(), indto.getFree0015()));

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

	        	tRdmHcoReqInsData.setInsShaYmd(sysDate);
	        	tRdmHcoReqInsData.setInsShaId(indto.getLoginJgiNo());
	        	tRdmHcoReqInsData.setUpdShaYmd(sysDate);
	        	tRdmHcoReqInsData.setUpdShaId(indto.getLoginJgiNo());

	        	dao.insertByValue(tRdmHcoReqInsData);

	        } else {
	        	// 更新
	        	TRdmHcoReqEntity tRdmHcoReqUpdData = new TRdmHcoReqEntity("updateNF012Data");
	        	tRdmHcoReqUpdData.setReqId(reqId);

	        	tRdmHcoReqUpdData.setInsKana(getUpdValue(indto.getPreInsKana(), indto.getInsKana()));
	        	tRdmHcoReqUpdData.setInsAbbrName(getUpdValue(indto.getPreInsAbbrName(), indto.getInsAbbrName()));
	        	tRdmHcoReqUpdData.setInsFormalName(getUpdValue(indto.getPreInsFormalName(), indto.getInsFormalName()));
	        	tRdmHcoReqUpdData.setInsPcode(getUpdValue(indto.getPreInsPcode(), indto.getInsPcode()));
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

	        	String preInsUrlYmd = indto.getPreInsUrlYmd();
	        	String insUrlYmd = indto.getInsUrlYmd();
	        	if(preInsUrlYmd != null) {
	        		preInsUrlYmd = preInsUrlYmd.replace("/", "");
	        	}
	        	if(insUrlYmd != null) {
	        		insUrlYmd = insUrlYmd.replace("-", "");
	        	}

	        	tRdmHcoReqUpdData.setInsUrlYmd(getUpdValue(preInsUrlYmd,insUrlYmd));

	        	tRdmHcoReqUpdData.setTradeType(getUpdValue(indto.getPreTradeType(), indto.getTradeType()));
	        	tRdmHcoReqUpdData.setWsType(getUpdValue(indto.getPreWsType(), indto.getWsType()));
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

	        	tRdmHcoReqUpdData.setInsShaYmd(sysDate);
	        	tRdmHcoReqUpdData.setInsShaId(indto.getLoginJgiNo());

	        	tRdmHcoReqUpdData.setUpdShaYmd(sysDate);
	        	tRdmHcoReqUpdData.setUpdShaId(indto.getLoginJgiNo());

	        	if(knr) {
	        		tRdmHcoReqUpdData.setKnrFlg("1");
	        	}

	        	dao.update(tRdmHcoReqUpdData);
	        }

	    	indto.setReqId(reqId);
	    	if("13".equals(indto.getReqStsCd())) {
	    		indto.setReqStsCd("11");
	    	} else {
	    		indto.setReqStsCd("01");
	    	}
	    	indto.setDisplayKbn("2");

	    	outdto = init(indto);

			// エラーメッセージ表示エリアに（I005）「保存が完了しました。」完了メッセージを表示
			String infoMsg = loginInfo.getMsgData(RdmConstantsData.I005) + "\n";
			indto.setMsgStr(infoMsg);

        } else {
        	// 申請画面へ

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
            if(indto.getReqComment() != null && indto.getReqComment().length() > 300) {
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
            if(!chkPostcode(indto.getInsPcode())) {
            	// 正しい書式で入力してください。（郵便番号）
    			errMsg += loginInfo.getMsgData(RdmConstantsData.W016).replace("項目名", "郵便番号") + "\n";
    			errFlg = true;
            }
            if("10".equals(indto.getInsSbt()) && "00-0000-0000".equals(indto.getInsPhone1())) {
            	// 医療モールを新規作成する場合は「00-0000-0000」と入力してください。電話番号(代表)
    			errMsg += loginInfo.getMsgData(RdmConstantsData.W017) + "\n";
    			errFlg = true;
            }

            // 最終更新日時が、画面OPEN時とボタン押下時で異なっていた場合
            if(indto.getUpdShaYmd() != null && !indto.getUpdShaYmd().equals("")) {
            	TRdmReqKnrEntity tRdmReqKnrChkEntity = new TRdmReqKnrEntity("selectNF011DateChkData");
            	tRdmReqKnrChkEntity.setReqId(reqId);

            	List<TRdmReqKnrEntity> tRdmReqKnrEntityList = dao.select(tRdmReqKnrChkEntity);

            	if(tRdmReqKnrEntityList.size() > 0) {
            		if(!tRdmReqKnrEntityList.get(0).getUpdShaYmd().equals(indto.getUpdShaYmd())) {
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
            	indto.setMsgStr(errMsg);
            	outdto.setForward("NF012");
            	return outdto;
            }

            // 申請ステータスを「01：保存済」として各テーブルに画面の申請情報を登録
            // 申請管理
            TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity();
            tRdmReqKnrEntity.setReqId(indto.getReqId());
            TRdmReqKnrEntity tRdmReqKnrData = dao.selectByPK(tRdmReqKnrEntity);

            if(tRdmReqKnrData == null) {
            	// 新規登録
            	// 新規にIDを取得
            	SeqRdmReqIdEntity seqRdmReqIdEntity = new SeqRdmReqIdEntity();
            	List<SeqRdmReqIdEntity> seqRdmReqIdDate = dao.select(seqRdmReqIdEntity);
            	reqId = seqRdmReqIdDate.get(0).getReqId();

            	// レコードを登録
            	TRdmReqKnrEntity tRdmReqKnrInsData = new TRdmReqKnrEntity();
            	tRdmReqKnrInsData.setReqId(reqId);
            	if("JKN0813".equals(indto.getLoginJokenSetCd())) {
            		// 承認者（管理者権限）が申請の場合、'2'(DSG起因)
            		tRdmReqKnrInsData.setReqChl("2");
            		tRdmReqKnrInsData.setReqKngKbn("2");
            	} else {
            		// "MRが申請の場合、'1'(MR起因)
            		tRdmReqKnrInsData.setReqChl("1");
            		tRdmReqKnrInsData.setReqKngKbn("1");
            	}
            	tRdmReqKnrInsData.setReqType("02");
            	tRdmReqKnrInsData.setReqStsCd("01");
            	tRdmReqKnrInsData.setReqBrCd(indto.getReqBrCd());
            	tRdmReqKnrInsData.setReqDistCd(indto.getReqDistCd());
            	tRdmReqKnrInsData.setReqShzNm(indto.getReqShzNm());
            	tRdmReqKnrInsData.setReqJgiNo(indto.getReqJgiNo());
            	tRdmReqKnrInsData.setReqJgiName(indto.getReqJgiName());
            	tRdmReqKnrInsData.setReqComment(indto.getReqComment());
            	tRdmReqKnrInsData.setInsNo(indto.getInsNo());
            	tRdmReqKnrInsData.setInsShaYmd(sysDate);
            	tRdmReqKnrInsData.setInsShaId(indto.getLoginJgiNo());
            	tRdmReqKnrInsData.setUpdShaYmd(sysDate);
            	tRdmReqKnrInsData.setUpdShaId(indto.getLoginJgiNo());

            	dao.insertByValue(tRdmReqKnrInsData);

            } else {
            	// 更新
            	TRdmReqKnrEntity tRdmReqKnrUpdData = new TRdmReqKnrEntity("updateNF011Data");
            	tRdmReqKnrUpdData.setReqId(reqId);

            	if("13".equals(indto.getReqStsCd())) {
            		tRdmReqKnrUpdData.setReqStsCd("11");
            	} else {
            		tRdmReqKnrUpdData.setReqStsCd("01");
            	}

            	tRdmReqKnrUpdData.setReqComment(indto.getReqComment());
            	tRdmReqKnrUpdData.setUpdShaYmd(sysDate);
            	tRdmReqKnrUpdData.setUpdShaId(indto.getLoginJgiNo());

            	dao.update(tRdmReqKnrUpdData);
            }

            // 施設_申請管理
            TRdmHcoReqEntity tRdmHcoReqEntity = new TRdmHcoReqEntity();
            tRdmHcoReqEntity.setReqId(reqId);
            TRdmHcoReqEntity tRdmHcoReqData = dao.selectByPK(tRdmHcoReqEntity);

            // 管理者権限
            boolean knr = "JKN0813".equals(indto.getLoginJokenSetCd());

            if(tRdmHcoReqData == null) {
            	// 新規登録
            	TRdmHcoReqEntity tRdmHcoReqInsData = new TRdmHcoReqEntity();
            	tRdmHcoReqInsData.setReqId(reqId);
            	tRdmHcoReqInsData.setInsNo(indto.getInsNo());

            	tRdmHcoReqInsData.setInsKana(getUpdValue(indto.getPreInsKana(), indto.getInsKana()));
            	tRdmHcoReqInsData.setInsAbbrName(getUpdValue(indto.getPreInsAbbrName(), indto.getInsAbbrName()));
            	tRdmHcoReqInsData.setInsFormalName(getUpdValue(indto.getPreInsFormalName(), indto.getInsFormalName()));
            	tRdmHcoReqInsData.setInsPcode(getUpdValue(indto.getPreInsPcode(), indto.getInsPcode()));
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
    	        	tRdmHcoReqInsData.setFree0011(getUpdValue(indto.getPreFree0001(), indto.getFree0011()));
    	        	tRdmHcoReqInsData.setFree0012(getUpdValue(indto.getPreFree0002(), indto.getFree0012()));
    	        	tRdmHcoReqInsData.setFree0013(getUpdValue(indto.getPreFree0003(), indto.getFree0013()));
    	        	tRdmHcoReqInsData.setFree0014(getUpdValue(indto.getPreFree0004(), indto.getFree0014()));
    	        	tRdmHcoReqInsData.setFree0015(getUpdValue(indto.getPreFree0005(), indto.getFree0015()));

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

            	tRdmHcoReqInsData.setInsShaYmd(sysDate);
            	tRdmHcoReqInsData.setInsShaId(indto.getLoginJgiNo());
            	tRdmHcoReqInsData.setUpdShaYmd(sysDate);
            	tRdmHcoReqInsData.setUpdShaId(indto.getLoginJgiNo());

            	dao.insertByValue(tRdmHcoReqInsData);

            } else {
            	// 更新
            	TRdmHcoReqEntity tRdmHcoReqUpdData = new TRdmHcoReqEntity("updateNF012Data");
            	tRdmHcoReqUpdData.setReqId(reqId);

            	tRdmHcoReqUpdData.setInsKana(getUpdValue(indto.getPreInsKana(), indto.getInsKana()));
            	tRdmHcoReqUpdData.setInsAbbrName(getUpdValue(indto.getPreInsAbbrName(), indto.getInsAbbrName()));
            	tRdmHcoReqUpdData.setInsFormalName(getUpdValue(indto.getPreInsFormalName(), indto.getInsFormalName()));
            	tRdmHcoReqUpdData.setInsPcode(getUpdValue(indto.getPreInsPcode(), indto.getInsPcode()));
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

            	String preInsUrlYmd = indto.getPreInsUrlYmd();
            	String insUrlYmd = indto.getInsUrlYmd();
            	if(preInsUrlYmd != null) {
            		preInsUrlYmd = preInsUrlYmd.replace("/", "");
            	}
            	if(insUrlYmd != null) {
            		insUrlYmd = insUrlYmd.replace("-", "");
            	}

            	tRdmHcoReqUpdData.setInsUrlYmd(getUpdValue(preInsUrlYmd,insUrlYmd));

            	tRdmHcoReqUpdData.setTradeType(getUpdValue(indto.getPreTradeType(), indto.getTradeType()));
            	tRdmHcoReqUpdData.setWsType(getUpdValue(indto.getPreWsType(), indto.getWsType()));
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

            	tRdmHcoReqUpdData.setInsShaYmd(sysDate);
            	tRdmHcoReqUpdData.setInsShaId(indto.getLoginJgiNo());

            	tRdmHcoReqUpdData.setUpdShaYmd(sysDate);
            	tRdmHcoReqUpdData.setUpdShaId(indto.getLoginJgiNo());

            	if(knr) {
            		tRdmHcoReqUpdData.setKnrFlg("1");
            	}

            	dao.update(tRdmHcoReqUpdData);
            }

        	indto.setReqId(reqId);

    		outdto.setForward("NF303");
        }

        // END UOC
        return outdto;
    }

	/**
     * イベント処理
     * @param indto NF012DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO shnComp(NF012DTO indto) {
        BaseDTO outdto = indto;
        // START UOC
        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
        // DropDownList作成
        createCombo(indto);
        // 現在日付を取得
        Date systemDate = DateUtils.getNowDate();
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
        String sysDate = fmtDate.format(systemDate);

        // 申請管理の更新を行う
        TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity("updateTRdmReqKnrData");
        tRdmReqKnrEntity.setReqId(indto.getReqId());
        tRdmReqKnrEntity.setShnFlg("1");
        tRdmReqKnrEntity.setShnBrCode(indto.getLoginBrCd());
        tRdmReqKnrEntity.setShnDistCode(indto.getLoginDistCd());
        tRdmReqKnrEntity.setShnShz(indto.getLoginShzNm());
        tRdmReqKnrEntity.setShnJgiNo(Integer.parseInt(indto.getLoginJgiNo()));
        tRdmReqKnrEntity.setShnShaName(indto.getLoginNm());
        tRdmReqKnrEntity.setAprMemo(indto.getAprMemo());
        tRdmReqKnrEntity.setShnYmdhms(sysDate);

        dao.update(tRdmReqKnrEntity);

        indto.setShnFlg("1");

        outdto = init(indto);

    	// エラーメッセージ表示エリアに（I008）「ステータスを審査済みに変更しました。」完了メッセージを表示
    	String infoMsg = loginInfo.getMsgData(RdmConstantsData.I008) + "\n";
		indto.setMsgStr(infoMsg);

        // END UOC
        return outdto;
    }

    /**
    * 承認・却下ボタン
    * @param indto
    * @return
    */
   @Transactional
   public BaseDTO apprRej(NF012DTO indto) {
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
        if(indto.getReqComment() != null && indto.getReqComment().length() > 300) {
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
        if(!chkPostcode(indto.getInsPcode())) {
        	// 正しい書式で入力してください。（郵便番号）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W016).replace("項目名", "郵便番号") + "\n";
			errFlg = true;
        }
        if("10".equals(indto.getInsSbt()) && "00-0000-0000".equals(indto.getInsPhone1())) {
        	// 医療モールを新規作成する場合は「00-0000-0000」と入力してください。電話番号(代表)
			errMsg += loginInfo.getMsgData(RdmConstantsData.W017) + "\n";
			errFlg = true;
        }

        // 最終更新日時が、画面OPEN時とボタン押下時で異なっていた場合
        if(indto.getUpdShaYmd() != null && !indto.getUpdShaYmd().equals("")) {
        	TRdmReqKnrEntity tRdmReqKnrChkEntity = new TRdmReqKnrEntity("selectNF011DateChkData");
        	tRdmReqKnrChkEntity.setReqId(reqId);

        	List<TRdmReqKnrEntity> tRdmReqKnrEntityList = dao.select(tRdmReqKnrChkEntity);

        	if(tRdmReqKnrEntityList.size() > 0) {
        		if(!tRdmReqKnrEntityList.get(0).getUpdShaYmd().equals(indto.getUpdShaYmd())) {
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
        	indto.setMsgStr(errMsg);
        	outdto.setForward("NF012");
        	return outdto;
        }

        // 申請ステータスを「01：保存済」として各テーブルに画面の申請情報を登録
        // 申請管理
        TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity();
        tRdmReqKnrEntity.setReqId(indto.getReqId());
        TRdmReqKnrEntity tRdmReqKnrData = dao.selectByPK(tRdmReqKnrEntity);

        if(tRdmReqKnrData == null) {
        	// 新規登録
        	// 新規にIDを取得
        	SeqRdmReqIdEntity seqRdmReqIdEntity = new SeqRdmReqIdEntity();
        	List<SeqRdmReqIdEntity> seqRdmReqIdDate = dao.select(seqRdmReqIdEntity);
        	reqId = seqRdmReqIdDate.get(0).getReqId();

        	// レコードを登録
        	TRdmReqKnrEntity tRdmReqKnrInsData = new TRdmReqKnrEntity();
        	tRdmReqKnrInsData.setReqId(reqId);
        	if("JKN0813".equals(indto.getLoginJokenSetCd())) {
        		// 承認者（管理者権限）が申請の場合、'2'(DSG起因)
        		tRdmReqKnrInsData.setReqChl("2");
        		tRdmReqKnrInsData.setReqKngKbn("2");
        	} else {
        		// "MRが申請の場合、'1'(MR起因)
        		tRdmReqKnrInsData.setReqChl("1");
        		tRdmReqKnrInsData.setReqKngKbn("1");
        	}
        	tRdmReqKnrInsData.setReqType("02");
        	tRdmReqKnrInsData.setReqStsCd("01");
        	tRdmReqKnrInsData.setReqBrCd(indto.getReqBrCd());
        	tRdmReqKnrInsData.setReqDistCd(indto.getReqDistCd());
        	tRdmReqKnrInsData.setReqShzNm(indto.getReqShzNm());
        	tRdmReqKnrInsData.setReqJgiNo(indto.getReqJgiNo());
        	tRdmReqKnrInsData.setReqJgiName(indto.getReqJgiName());
        	tRdmReqKnrInsData.setReqComment(indto.getReqComment());
        	tRdmReqKnrInsData.setAprMemo(indto.getAprMemo());
        	tRdmReqKnrInsData.setInsNo(indto.getInsNo());
        	tRdmReqKnrInsData.setInsShaYmd(sysDate);
        	tRdmReqKnrInsData.setInsShaId(indto.getLoginJgiNo());
        	tRdmReqKnrInsData.setUpdShaYmd(sysDate);
        	tRdmReqKnrInsData.setUpdShaId(indto.getLoginJgiNo());

        	dao.insertByValue(tRdmReqKnrInsData);

        } else {
        	// 更新
        	TRdmReqKnrEntity tRdmReqKnrUpdData = new TRdmReqKnrEntity("updateTRdmReqKnrData");
        	tRdmReqKnrUpdData.setReqId(reqId);

        	if("13".equals(indto.getReqStsCd())) {
        		tRdmReqKnrUpdData.setReqStsCd("11");
        	} else {
        		tRdmReqKnrUpdData.setReqStsCd("01");
        	}

        	tRdmReqKnrUpdData.setReqComment(indto.getReqComment());
        	tRdmReqKnrUpdData.setAprMemo(indto.getAprMemo());
        	tRdmReqKnrUpdData.setUpdShaYmd(sysDate);
        	tRdmReqKnrUpdData.setUpdShaId(indto.getLoginJgiNo());

        	dao.update(tRdmReqKnrUpdData);
        }

        // 施設_申請管理
        TRdmHcoReqEntity tRdmHcoReqEntity = new TRdmHcoReqEntity();
        tRdmHcoReqEntity.setReqId(reqId);
        TRdmHcoReqEntity tRdmHcoReqData = dao.selectByPK(tRdmHcoReqEntity);

        // 管理者権限
        boolean knr = "JKN0813".equals(indto.getLoginJokenSetCd());

        if(tRdmHcoReqData == null) {
        	// 新規登録
        	TRdmHcoReqEntity tRdmHcoReqInsData = new TRdmHcoReqEntity();
        	tRdmHcoReqInsData.setReqId(reqId);
        	tRdmHcoReqInsData.setInsNo(indto.getInsNo());

        	tRdmHcoReqInsData.setInsKana(getUpdValue(indto.getPreInsKana(), indto.getInsKana()));
        	tRdmHcoReqInsData.setInsAbbrName(getUpdValue(indto.getPreInsAbbrName(), indto.getInsAbbrName()));
        	tRdmHcoReqInsData.setInsFormalName(getUpdValue(indto.getPreInsFormalName(), indto.getInsFormalName()));
        	tRdmHcoReqInsData.setInsPcode(getUpdValue(indto.getPreInsPcode(), indto.getInsPcode()));
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
	        	tRdmHcoReqInsData.setFree0011(getUpdValue(indto.getPreFree0001(), indto.getFree0011()));
	        	tRdmHcoReqInsData.setFree0012(getUpdValue(indto.getPreFree0002(), indto.getFree0012()));
	        	tRdmHcoReqInsData.setFree0013(getUpdValue(indto.getPreFree0003(), indto.getFree0013()));
	        	tRdmHcoReqInsData.setFree0014(getUpdValue(indto.getPreFree0004(), indto.getFree0014()));
	        	tRdmHcoReqInsData.setFree0015(getUpdValue(indto.getPreFree0005(), indto.getFree0015()));

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

        	tRdmHcoReqInsData.setInsShaYmd(sysDate);
        	tRdmHcoReqInsData.setInsShaId(indto.getLoginJgiNo());
        	tRdmHcoReqInsData.setUpdShaYmd(sysDate);
        	tRdmHcoReqInsData.setUpdShaId(indto.getLoginJgiNo());

        	dao.insertByValue(tRdmHcoReqInsData);

        } else {
        	// 更新
        	TRdmHcoReqEntity tRdmHcoReqUpdData = new TRdmHcoReqEntity("updateNF012Data");
        	tRdmHcoReqUpdData.setReqId(reqId);

        	tRdmHcoReqUpdData.setInsKana(getUpdValue(indto.getPreInsKana(), indto.getInsKana()));
        	tRdmHcoReqUpdData.setInsAbbrName(getUpdValue(indto.getPreInsAbbrName(), indto.getInsAbbrName()));
        	tRdmHcoReqUpdData.setInsFormalName(getUpdValue(indto.getPreInsFormalName(), indto.getInsFormalName()));
        	tRdmHcoReqUpdData.setInsPcode(getUpdValue(indto.getPreInsPcode(), indto.getInsPcode()));
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

        	String preInsUrlYmd = indto.getPreInsUrlYmd();
        	String insUrlYmd = indto.getInsUrlYmd();
        	if(preInsUrlYmd != null) {
        		preInsUrlYmd = preInsUrlYmd.replace("/", "");
        	}
        	if(insUrlYmd != null) {
        		insUrlYmd = insUrlYmd.replace("-", "");
        	}

        	tRdmHcoReqUpdData.setInsUrlYmd(getUpdValue(preInsUrlYmd,insUrlYmd));

        	tRdmHcoReqUpdData.setTradeType(getUpdValue(indto.getPreTradeType(), indto.getTradeType()));
        	tRdmHcoReqUpdData.setWsType(getUpdValue(indto.getPreWsType(), indto.getWsType()));
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

        	tRdmHcoReqUpdData.setInsShaYmd(sysDate);
        	tRdmHcoReqUpdData.setInsShaId(indto.getLoginJgiNo());

        	tRdmHcoReqUpdData.setUpdShaYmd(sysDate);
        	tRdmHcoReqUpdData.setUpdShaId(indto.getLoginJgiNo());

        	if(knr) {
        		tRdmHcoReqUpdData.setKnrFlg("1");
        	}

        	dao.update(tRdmHcoReqUpdData);
        }

    	indto.setReqId(reqId);

		outdto.setForward("NF303");

		// END UOC
        return outdto;
   }

    /**
    * 申請破棄
    * @param indto
    * @return
    */
   @Transactional
   public BaseDTO cancel(NF012DTO indto) {
       BaseDTO outdto = indto;
       // DropDownList作成
       createCombo(indto);

       // START UOC
       // 申請管理を物理削除
       TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity();
       tRdmReqKnrEntity.setReqId(indto.getReqId());
       dao.deleteByPK(tRdmReqKnrEntity);

       // 施設_申請管理を物理削除
       TRdmHcoReqEntity tRdmHcoReqEntity = new TRdmHcoReqEntity();
       tRdmHcoReqEntity.setReqId(indto.getReqId());
       dao.deleteByPK(tRdmHcoReqEntity);

       // END UOC
       return outdto;
   }

    /**
     * 変更前と値が同一の場合はNULL、値無の場合は'Z'を返却
     * @param preValue
     * @param value
     * @return
     */
    public String getUpdValue(String preValue, String value){
    	String rtnValue = value;

    	if(value != null && value.equals(preValue)) {
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
}
