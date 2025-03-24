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
import jp.co.takeda.rdm.dto.NF101DTO;
import jp.co.takeda.rdm.entity.MRdmHcoKeieitaiEntiry;
import jp.co.takeda.rdm.entity.join.SelectComboListEntity;
import jp.co.takeda.rdm.entity.join.SelectNF101MainDataEntity;
import jp.co.takeda.rdm.entity.join.SeqRdmReqIdEntity;
import jp.co.takeda.rdm.entity.join.TRdmHcoNxtReqEntity;
import jp.co.takeda.rdm.entity.join.TRdmReqKnrEntity;
import jp.co.takeda.rdm.util.DateUtils;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;

/**
 * Serviceクラス（NF101)
 * @generated
 */
@Named
public class NF101Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(NF101Service.class);

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
     * @param indto NF101DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(NF101DTO indto) {
        BaseDTO outdto = indto;
        // START UOC
        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

        if ("1".equals(indto.getDisplayKbn())) {
    		// 施設固定コードで初期データ作成
    		SelectNF101MainDataEntity paramEntity = new SelectNF101MainDataEntity("selectNF101INSData");
    		paramEntity.setInInsNo(indto.getInsNo());
    		List<SelectNF101MainDataEntity> mainDataEntityList = dao.select(paramEntity);
    		SelectNF101MainDataEntity mainDataEntity = mainDataEntityList.get(0);

    		// 申請情報
    		indto.setReqShzNm(loginInfo.getBumonRyakuName());
			indto.setReqJgiName(loginInfo.getJgiName());
			indto.setReqJgiNo(loginInfo.getJgiNo());
    		indto.setReqBrCd(loginInfo.getBrCode());
    		indto.setReqDistCd(loginInfo.getDistCode());
    		indto.setReqYmdhms("");
    		indto.setReqStsNm("");
    		indto.setReqId("");

    		// 施設情報
    		indto.setInsType(StringUtils.nvl(mainDataEntity.getInsType(), ""));
    		indto.setInsAbbrName(StringUtils.nvl(mainDataEntity.getInsAbbrName(), ""));
    		indto.setUltInsNo(StringUtils.nvl(mainDataEntity.getUltInsNo(), ""));
    		indto.setShisetsuNmRyaku(StringUtils.nvl(mainDataEntity.getShisetsuNmRyaku(), ""));

    		// 基本情報(当期)
    		indto.setPharmType(StringUtils.nvl(mainDataEntity.getPharmType(), ""));
    		indto.setInsRank(StringUtils.nvl(mainDataEntity.getInsRank(), ""));
    		indto.setRegVisType(StringUtils.nvl(mainDataEntity.getRegVisType(), ""));
    		indto.setImpHosType(StringUtils.nvl(mainDataEntity.getImpHosType(), ""));
    		indto.setHoInsType(StringUtils.nvl(mainDataEntity.getHoInsType(), ""));
    		indto.setManageCd(StringUtils.nvl(mainDataEntity.getManageCd(), ""));
    		indto.setVacInsType(StringUtils.nvl(mainDataEntity.getVacInsType(), ""));
    		indto.setVacVisitType(StringUtils.nvl(mainDataEntity.getVacVisitType(), ""));
    		indto.setPharmTypeNm(StringUtils.nvl(mainDataEntity.getPharmTypeNm(), ""));
    		indto.setInsRankNm(StringUtils.nvl(mainDataEntity.getInsRankNm(), ""));
    		indto.setRegVisTypeNm(StringUtils.nvl(mainDataEntity.getRegVisTypeNm(), ""));
    		indto.setImpHosTypeNm(StringUtils.nvl(mainDataEntity.getImpHosTypeNm(), ""));
    		indto.setHoInsTypeNm(StringUtils.nvl(mainDataEntity.getHoInsTypeNm(), ""));
    		indto.setManageNm(StringUtils.nvl(mainDataEntity.getManageNm(), ""));
    		indto.setVacInsTypeNm(StringUtils.nvl(mainDataEntity.getVacInsTypeNm(), ""));
    		indto.setVacVisitTypeNm(StringUtils.nvl(mainDataEntity.getVacVisitTypeNm(), ""));

    		// 基本情報(ULT)
    		indto.setShisetsuKbn(StringUtils.nvl(mainDataEntity.getShisetsuKbn(), ""));
    		indto.setKeieitaiNm(StringUtils.nvl(mainDataEntity.getKeieitaiNm(), ""));

    		// 基本情報(来期)
    		indto.setNextPharmType(StringUtils.nvl(mainDataEntity.getNextPharmType(), mainDataEntity.getPharmType()));
    		indto.setNextInsRank(StringUtils.nvl(mainDataEntity.getNextInsRank(), mainDataEntity.getInsRank()));
    		indto.setNextRegVisType(StringUtils.nvl(mainDataEntity.getNextRegVisType(), mainDataEntity.getRegVisType()));
    		indto.setNextImpHosType(StringUtils.nvl(mainDataEntity.getNextImpHosType(), mainDataEntity.getImpHosType()));
    		indto.setNextHoInsType(StringUtils.nvl(mainDataEntity.getNextHoInsType(), mainDataEntity.getHoInsType()));
    		indto.setNextManageCd(StringUtils.nvl(mainDataEntity.getNextManageCd(), mainDataEntity.getManageCd()));
    		indto.setNextVacInsType(StringUtils.nvl(mainDataEntity.getNextVacInsType(), mainDataEntity.getVacInsType()));
    		indto.setNextVacVisitType(StringUtils.nvl(mainDataEntity.getNextVacVisitType(), mainDataEntity.getVacVisitType()));

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

    		indto.setUltBedCntBase(StringUtils.nvl(mainDataEntity.getUltBedCntBase(), ""));
    		indto.setUltBedCnt01(StringUtils.nvl(mainDataEntity.getUltBedCnt01(), ""));
    		indto.setUltBedCnt03(StringUtils.nvl(mainDataEntity.getUltBedCnt03(), ""));
    		indto.setUltBedCnt04(StringUtils.nvl(mainDataEntity.getUltBedCnt04(), ""));
    		indto.setUltBedCnt05(StringUtils.nvl(mainDataEntity.getUltBedCnt05(), ""));
    		indto.setUltBedCnt07(StringUtils.nvl(mainDataEntity.getUltBedCnt07(), ""));
    		indto.setUltBedCnt02("");
    		indto.setUltBedCnt06("");

    		Integer bedcntIppan = Integer.parseInt(StringUtils.nvl(mainDataEntity.getUltBedCnt01(), "0"));
    		Integer bedcntSeshin = Integer.parseInt(StringUtils.nvl(mainDataEntity.getUltBedCnt03(), "0"));
    		Integer bedcntKekkaku = Integer.parseInt(StringUtils.nvl(mainDataEntity.getUltBedCnt04(), "0"));
    		Integer bedcntKansen = Integer.parseInt(StringUtils.nvl(mainDataEntity.getUltBedCnt05(), "0"));
    		Integer bedcntRyoyo = Integer.parseInt(StringUtils.nvl(mainDataEntity.getUltBedCnt07(), "0"));
    		Integer bedcntIryo = Integer.parseInt(StringUtils.nvl(mainDataEntity.getUltBedCnt02(), "0"));
    		Integer bedsTot = bedcntIppan + bedcntSeshin + bedcntKekkaku + bedcntKansen + bedcntRyoyo;
    		Integer medBedsTot = bedcntIppan + bedcntSeshin + bedcntKekkaku + bedcntKansen + bedcntIryo;
    		indto.setUltBedsTot(Integer.toString(bedsTot));
    		indto.setUltMedBedsTot(Integer.toString(medBedsTot));

    		indto.setNextBedCntBase(StringUtils.nvl(mainDataEntity.getNextBedCntBase(), mainDataEntity.getBedCntBase()));
    		indto.setNextBedCnt01(StringUtils.nvl(mainDataEntity.getNextBedCnt01(), mainDataEntity.getBedCnt01()));
    		indto.setNextBedCnt02(StringUtils.nvl(mainDataEntity.getNextBedCnt02(), mainDataEntity.getBedCnt02()));
    		indto.setNextBedCnt03(StringUtils.nvl(mainDataEntity.getNextBedCnt03(), mainDataEntity.getBedCnt03()));
    		indto.setNextBedCnt04(StringUtils.nvl(mainDataEntity.getNextBedCnt04(), mainDataEntity.getBedCnt04()));
    		indto.setNextBedCnt05(StringUtils.nvl(mainDataEntity.getNextBedCnt05(), mainDataEntity.getBedCnt05()));
    		indto.setNextBedCnt06(StringUtils.nvl(mainDataEntity.getNextBedCnt06(), mainDataEntity.getBedCnt06()));
    		indto.setNextBedCnt07(StringUtils.nvl(mainDataEntity.getNextBedCnt07(), mainDataEntity.getBedCnt07()));
    		indto.setNextBedsTot(StringUtils.nvl(mainDataEntity.getNextBedsTot(), StringUtils.nvl(mainDataEntity.getBedsTot(), "0")));
    		indto.setNextMedBedsTot(StringUtils.nvl(mainDataEntity.getNextMedBedsTot(), StringUtils.nvl(mainDataEntity.getMedBedsTot(), "0")));

    		// カラーフラグ
    		indto.setPharmTypeFlg(StringUtils.nvl(mainDataEntity.getPharmTypeFlg(), "0"));
    		indto.setInsRankFlg(StringUtils.nvl(mainDataEntity.getInsRankFlg(), "0"));
    		indto.setRegVisTypeFlg(StringUtils.nvl(mainDataEntity.getRegVisTypeFlg(), "0"));
    		indto.setImpHosTypeFlg(StringUtils.nvl(mainDataEntity.getImpHosTypeFlg(), "0"));
    		indto.setManageCdFlg(StringUtils.nvl(mainDataEntity.getManageCdFlg(), "0"));
    		indto.setVacInsTypeFlg(StringUtils.nvl(mainDataEntity.getVacInsTypeFlg(), "0"));
    		indto.setVacVisitTypeFlg(StringUtils.nvl(mainDataEntity.getVacVisitTypeFlg(), "0"));
    		indto.setBedCntBaseFlg(StringUtils.nvl(mainDataEntity.getBedCntBaseFlg(), "0"));
    		indto.setBedCnt04Flg(StringUtils.nvl(mainDataEntity.getBedCnt04Flg(), "0"));
    		indto.setBedCnt01Flg(StringUtils.nvl(mainDataEntity.getBedCnt01Flg(), "0"));
    		indto.setBedCnt05Flg(StringUtils.nvl(mainDataEntity.getBedCnt05Flg(), "0"));
    		indto.setBedCnt03Flg(StringUtils.nvl(mainDataEntity.getBedCnt03Flg(), "0"));
    		indto.setBedCnt07Flg(StringUtils.nvl(mainDataEntity.getBedCnt07Flg(), "0"));
    		indto.setBedCnt02Flg(StringUtils.nvl(mainDataEntity.getBedCnt02Flg(), "0"));
    		indto.setBedCnt06Flg(StringUtils.nvl(mainDataEntity.getBedCnt06Flg(), "0"));
    		indto.setBedsTotFlg(StringUtils.nvl(mainDataEntity.getBedsTotFlg(), "0"));
    		indto.setMedBedsTotFlg(StringUtils.nvl(mainDataEntity.getMedBedsTotFlg(), "0"));

    		// 申請日時降順で最初の申請管理データの申請コメントを申請コメントの初期値として設定する
    		TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity("selectNF101CommentData");
    		tRdmReqKnrEntity.setInsNo(indto.getInsNo());
    		List<TRdmReqKnrEntity> tRdmReqKnrEntityList = dao.select(tRdmReqKnrEntity);

    		if(tRdmReqKnrEntityList.size() > 0) {
    			indto.setReqComment(tRdmReqKnrEntityList.get(0).getReqComment());
    		}

        } else if ("2".equals(indto.getDisplayKbn())) {
    		// 申請IDから施設固定コードを取得
        	TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity();
        	tRdmReqKnrEntity.setReqId(indto.getReqId());
        	TRdmReqKnrEntity tRdmReqKnrData = dao.selectByPK(tRdmReqKnrEntity);

    		SelectNF101MainDataEntity paramEntity = new SelectNF101MainDataEntity();
    		paramEntity.setInReqId(indto.getReqId());
    		paramEntity.setInInsNo(tRdmReqKnrData.getInsNo());
    		indto.setInsNo(tRdmReqKnrData.getInsNo());
    		List<SelectNF101MainDataEntity> mainDataEntityList = dao.select(paramEntity);
    		SelectNF101MainDataEntity mainDataEntity = mainDataEntityList.get(0);

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

    		indto.setReqChl(mainDataEntity.getReqChl());
    		indto.setReqJgiNo(mainDataEntity.getReqJgiNo());
    		indto.setReqBrCd(StringUtils.nvl(mainDataEntity.getReqBrCd(), ""));
    		indto.setReqDistCd(StringUtils.nvl(mainDataEntity.getReqDistCd(), ""));
    		indto.setReqStsCd(StringUtils.nvl(mainDataEntity.getReqStsCd(), ""));
    		indto.setShnJgiNo(mainDataEntity.getShnJgiNo());
    		indto.setAprJgiNo(mainDataEntity.getAprJgiNo());
    		indto.setUpdShaYmd(StringUtils.nvl(mainDataEntity.getUpdShaYmd(), ""));

    		// 施設情報
    		indto.setInsType(StringUtils.nvl(mainDataEntity.getInsType(), ""));
    		indto.setInsAbbrName(StringUtils.nvl(mainDataEntity.getInsAbbrName(), ""));
    		indto.setUltInsNo(StringUtils.nvl(mainDataEntity.getUltInsNo(), ""));
    		indto.setShisetsuNmRyaku(StringUtils.nvl(mainDataEntity.getShisetsuNmRyaku(), ""));

    		// 基本情報(当期)
    		indto.setPharmType(StringUtils.nvl(mainDataEntity.getPharmType(), ""));
    		indto.setInsRank(StringUtils.nvl(mainDataEntity.getInsRank(), ""));
    		indto.setRegVisType(StringUtils.nvl(mainDataEntity.getRegVisType(), ""));
    		indto.setImpHosType(StringUtils.nvl(mainDataEntity.getImpHosType(), ""));
    		indto.setHoInsType(StringUtils.nvl(mainDataEntity.getHoInsType(), ""));
    		indto.setManageCd(StringUtils.nvl(mainDataEntity.getManageCd(), ""));
    		indto.setVacInsType(StringUtils.nvl(mainDataEntity.getVacInsType(), ""));
    		indto.setVacVisitType(StringUtils.nvl(mainDataEntity.getVacVisitType(), ""));
    		indto.setPharmTypeNm(StringUtils.nvl(mainDataEntity.getPharmTypeNm(), ""));
    		indto.setInsRankNm(StringUtils.nvl(mainDataEntity.getInsRankNm(), ""));
    		indto.setRegVisTypeNm(StringUtils.nvl(mainDataEntity.getRegVisTypeNm(), ""));
    		indto.setImpHosTypeNm(StringUtils.nvl(mainDataEntity.getImpHosTypeNm(), ""));
    		indto.setHoInsTypeNm(StringUtils.nvl(mainDataEntity.getHoInsTypeNm(), ""));
    		indto.setManageNm(StringUtils.nvl(mainDataEntity.getManageNm(), ""));
    		indto.setVacInsTypeNm(StringUtils.nvl(mainDataEntity.getVacInsTypeNm(), ""));
    		indto.setVacVisitTypeNm(StringUtils.nvl(mainDataEntity.getVacVisitTypeNm(), ""));

    		// 基本情報(ULT)
    		indto.setShisetsuKbn(StringUtils.nvl(mainDataEntity.getShisetsuKbn(), ""));
    		indto.setKeieitaiNm(StringUtils.nvl(mainDataEntity.getKeieitaiNm(), ""));

    		if("01".equals(mainDataEntity.getReqStsCd())) {
				// 一時保存データ
	    		// 基本情報(来期)
	    		indto.setNextPharmType(getViewValue(mainDataEntity.getPharmType(), mainDataEntity.getNextPharmType()));
	    		indto.setNextInsRank(getViewValue(mainDataEntity.getInsRank(), mainDataEntity.getNextInsRank()));
	    		indto.setNextRegVisType(getViewValue(mainDataEntity.getRegVisType(), mainDataEntity.getNextRegVisType()));
	    		indto.setNextImpHosType(getViewValue(mainDataEntity.getImpHosType(), mainDataEntity.getNextImpHosType()));
	    		indto.setNextHoInsType(getViewValue(mainDataEntity.getHoInsType(), mainDataEntity.getNextHoInsType()));
	    		indto.setNextManageCd(getViewValue(mainDataEntity.getManageCd(), mainDataEntity.getNextManageCd()));
	    		indto.setNextVacInsType(getViewValue(mainDataEntity.getVacInsType(), mainDataEntity.getNextVacInsType()));
	    		indto.setNextVacVisitType(getViewValue(mainDataEntity.getVacVisitType(), mainDataEntity.getNextVacVisitType()));
    		} else {
    			indto.setNextPharmType(getReqViewValue(mainDataEntity.getPharmType(), mainDataEntity.getNextPharmType()));
	    		indto.setNextInsRank(getReqViewValue(mainDataEntity.getInsRank(), mainDataEntity.getNextInsRank()));
	    		indto.setNextRegVisType(getReqViewValue(mainDataEntity.getRegVisType(), mainDataEntity.getNextRegVisType()));
	    		indto.setNextImpHosType(getReqViewValue(mainDataEntity.getImpHosType(), mainDataEntity.getNextImpHosType()));
	    		indto.setNextHoInsType(getReqViewValue(mainDataEntity.getHoInsType(), mainDataEntity.getNextHoInsType()));
	    		indto.setNextManageCd(getReqViewValue(mainDataEntity.getManageCd(), mainDataEntity.getNextManageCd()));
	    		indto.setNextVacInsType(getReqViewValue(mainDataEntity.getVacInsType(), mainDataEntity.getNextVacInsType()));
	    		indto.setNextVacVisitType(getReqViewValue(mainDataEntity.getVacVisitType(), mainDataEntity.getNextVacVisitType()));
    		}

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

    		indto.setUltBedCntBase(StringUtils.nvl(mainDataEntity.getUltBedCntBase(), ""));
    		indto.setUltBedCnt01(StringUtils.nvl(mainDataEntity.getUltBedCnt01(), ""));
    		indto.setUltBedCnt03(StringUtils.nvl(mainDataEntity.getUltBedCnt03(), ""));
    		indto.setUltBedCnt04(StringUtils.nvl(mainDataEntity.getUltBedCnt04(), ""));
    		indto.setUltBedCnt05(StringUtils.nvl(mainDataEntity.getUltBedCnt05(), ""));
    		indto.setUltBedCnt07(StringUtils.nvl(mainDataEntity.getUltBedCnt07(), ""));
    		indto.setUltBedCnt02("");
    		indto.setUltBedCnt06("");

    		Integer bedcntIppan = Integer.parseInt(StringUtils.nvl(mainDataEntity.getUltBedCnt01(), "0"));
    		Integer bedcntSeshin = Integer.parseInt(StringUtils.nvl(mainDataEntity.getUltBedCnt03(), "0"));
    		Integer bedcntKekkaku = Integer.parseInt(StringUtils.nvl(mainDataEntity.getUltBedCnt04(), "0"));
    		Integer bedcntKansen = Integer.parseInt(StringUtils.nvl(mainDataEntity.getUltBedCnt05(), "0"));
    		Integer bedcntRyoyo = Integer.parseInt(StringUtils.nvl(mainDataEntity.getUltBedCnt07(), "0"));
    		Integer bedcntIryo = Integer.parseInt(StringUtils.nvl(mainDataEntity.getUltBedCnt02(), "0"));
    		Integer bedsTot = bedcntIppan + bedcntSeshin + bedcntKekkaku + bedcntKansen + bedcntRyoyo;
    		Integer medBedsTot = bedcntIppan + bedcntSeshin + bedcntKekkaku + bedcntKansen + bedcntIryo;
    		indto.setUltBedsTot(Integer.toString(bedsTot));
    		indto.setUltMedBedsTot(Integer.toString(medBedsTot));

    		if("01".equals(mainDataEntity.getReqStsCd())) {
				// 一時保存データ
    			indto.setNextBedCntBase(getViewValue(StringUtils.nvl(mainDataEntity.getBedCntBase(), ""),StringUtils.nvl(mainDataEntity.getNextBedCntBase(), "")));
    			indto.setNextBedCnt01(getViewValue(StringUtils.nvl(mainDataEntity.getBedCnt01(), ""),StringUtils.nvl(mainDataEntity.getNextBedCnt01(), "")));
    			indto.setNextBedCnt02(getViewValue(StringUtils.nvl(mainDataEntity.getBedCnt02(), ""),StringUtils.nvl(mainDataEntity.getNextBedCnt02(), "")));
    			indto.setNextBedCnt03(getViewValue(StringUtils.nvl(mainDataEntity.getBedCnt03(), ""),StringUtils.nvl(mainDataEntity.getNextBedCnt03(), "")));
    			indto.setNextBedCnt04(getViewValue(StringUtils.nvl(mainDataEntity.getBedCnt04(), ""),StringUtils.nvl(mainDataEntity.getNextBedCnt04(), "")));
    			indto.setNextBedCnt05(getViewValue(StringUtils.nvl(mainDataEntity.getBedCnt05(), ""),StringUtils.nvl(mainDataEntity.getNextBedCnt05(), "")));
    			indto.setNextBedCnt06(getViewValue(StringUtils.nvl(mainDataEntity.getBedCnt06(), ""),StringUtils.nvl(mainDataEntity.getNextBedCnt06(), "")));
    			indto.setNextBedCnt07(getViewValue(StringUtils.nvl(mainDataEntity.getBedCnt07(), ""),StringUtils.nvl(mainDataEntity.getNextBedCnt07(), "")));
    			indto.setNextBedsTot(getViewValue(StringUtils.nvl(mainDataEntity.getBedsTot(), "0"),StringUtils.nvl(mainDataEntity.getNextBedsTot(), "0")));
    			indto.setNextMedBedsTot(getViewValue(StringUtils.nvl(mainDataEntity.getMedBedsTot(), "0"),StringUtils.nvl(mainDataEntity.getNextMedBedsTot(), "0")));
    		} else {
    			indto.setNextBedCntBase(getReqViewValue(StringUtils.nvl(mainDataEntity.getBedCntBase(), ""),StringUtils.nvl(mainDataEntity.getNextBedCntBase(), "")));
    			indto.setNextBedCnt01(getReqViewValue(StringUtils.nvl(mainDataEntity.getBedCnt01(), ""),StringUtils.nvl(mainDataEntity.getNextBedCnt01(), "")));
    			indto.setNextBedCnt02(getReqViewValue(StringUtils.nvl(mainDataEntity.getBedCnt02(), ""),StringUtils.nvl(mainDataEntity.getNextBedCnt02(), "")));
    			indto.setNextBedCnt03(getReqViewValue(StringUtils.nvl(mainDataEntity.getBedCnt03(), ""),StringUtils.nvl(mainDataEntity.getNextBedCnt03(), "")));
    			indto.setNextBedCnt04(getReqViewValue(StringUtils.nvl(mainDataEntity.getBedCnt04(), ""),StringUtils.nvl(mainDataEntity.getNextBedCnt04(), "")));
    			indto.setNextBedCnt05(getReqViewValue(StringUtils.nvl(mainDataEntity.getBedCnt05(), ""),StringUtils.nvl(mainDataEntity.getNextBedCnt05(), "")));
    			indto.setNextBedCnt06(getReqViewValue(StringUtils.nvl(mainDataEntity.getBedCnt06(), ""),StringUtils.nvl(mainDataEntity.getNextBedCnt06(), "")));
    			indto.setNextBedCnt07(getReqViewValue(StringUtils.nvl(mainDataEntity.getBedCnt07(), ""),StringUtils.nvl(mainDataEntity.getNextBedCnt07(), "")));
    			indto.setNextBedsTot(getReqViewValue(StringUtils.nvl(mainDataEntity.getBedsTot(), "0"),StringUtils.nvl(mainDataEntity.getNextBedsTot(), "")));
    			indto.setNextMedBedsTot(getReqViewValue(StringUtils.nvl(mainDataEntity.getMedBedsTot(), "0"),StringUtils.nvl(mainDataEntity.getNextMedBedsTot(), "")));
    		}

    		// コメント
    		indto.setReqComment(StringUtils.nvl(mainDataEntity.getReqComment(), ""));
    		indto.setAprMemo(StringUtils.nvl(mainDataEntity.getAprMemo(), ""));
    		indto.setShnFlg(StringUtils.nvl(mainDataEntity.getShnFlg(), ""));

    		// カラーフラグ
    		indto.setPharmTypeFlg(StringUtils.nvl(mainDataEntity.getPharmTypeFlg(), "0"));
    		indto.setInsRankFlg(StringUtils.nvl(mainDataEntity.getInsRankFlg(), "0"));
    		indto.setRegVisTypeFlg(StringUtils.nvl(mainDataEntity.getRegVisTypeFlg(), "0"));
    		indto.setImpHosTypeFlg(StringUtils.nvl(mainDataEntity.getImpHosTypeFlg(), "0"));
    		indto.setManageCdFlg(StringUtils.nvl(mainDataEntity.getManageCdFlg(), "0"));
    		indto.setVacInsTypeFlg(StringUtils.nvl(mainDataEntity.getVacInsTypeFlg(), "0"));
    		indto.setVacVisitTypeFlg(StringUtils.nvl(mainDataEntity.getVacVisitTypeFlg(), "0"));
    		indto.setBedCntBaseFlg(StringUtils.nvl(mainDataEntity.getBedCntBaseFlg(), "0"));
    		indto.setBedCnt04Flg(StringUtils.nvl(mainDataEntity.getBedCnt04Flg(), "0"));
    		indto.setBedCnt01Flg(StringUtils.nvl(mainDataEntity.getBedCnt01Flg(), "0"));
    		indto.setBedCnt05Flg(StringUtils.nvl(mainDataEntity.getBedCnt05Flg(), "0"));
    		indto.setBedCnt03Flg(StringUtils.nvl(mainDataEntity.getBedCnt03Flg(), "0"));
    		indto.setBedCnt07Flg(StringUtils.nvl(mainDataEntity.getBedCnt07Flg(), "0"));
    		indto.setBedCnt02Flg(StringUtils.nvl(mainDataEntity.getBedCnt02Flg(), "0"));
    		indto.setBedCnt06Flg(StringUtils.nvl(mainDataEntity.getBedCnt06Flg(), "0"));
    		indto.setBedsTotFlg(StringUtils.nvl(mainDataEntity.getBedsTotFlg(), "0"));
    		indto.setMedBedsTotFlg(StringUtils.nvl(mainDataEntity.getMedBedsTotFlg(), "0"));
        }

        // DropDownList作成
        createCombo(indto);

        // 編集可能判定
        if("".equals(indto.getReqStsCd()) || indto.getReqStsCd() == null) {
        	// 完全新規(申請管理．申請ステータスが取得できない)の場合は活性
        	indto.setEditApprFlg("1");
        } else if(!RdmConstantsData.RDM_JKN_ADMIN.equals(indto.getLoginJokenSetCd()) && !"01".equals(indto.getReqStsCd())) {
        	// MR権限の場合、取得した申請管理．申請ステータスが'01'(保存済み)以外の場合は、入力項目はすべて変更不可（非活性）とする
        	indto.setEditApprFlg("0");
        } else if(RdmConstantsData.RDM_JKN_ADMIN.equals(indto.getLoginJokenSetCd()) && !"01".equals(indto.getReqStsCd())
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
     * @param indto NF101DTO
     * @return なし
     * @customizable
     */
    private void createCombo(NF101DTO indto){
        // 対象区分
        SelectComboListEntity inEntityCmb = new SelectComboListEntity();
        inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_HO_INS_TYPE);
    	List<SelectComboListEntity> outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapHoInsType = new LinkedHashMap<String, String>();
		mapHoInsType.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapHoInsType.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setHoInsTypeCombo(mapHoInsType);

		// 経営主体
		MRdmHcoKeieitaiEntiry mRdmHcoKeieitaiCmb = new MRdmHcoKeieitaiEntiry("selectKeieitaiComboList");
		List<MRdmHcoKeieitaiEntiry> keieiList = dao.select(mRdmHcoKeieitaiCmb);
		LinkedHashMap<String, String> mapManageCd = new LinkedHashMap<String, String>();
		mapManageCd.put("", "--なし--");
		for (MRdmHcoKeieitaiEntiry outEntity : keieiList) {
			mapManageCd.put(outEntity.getSetDtCd(), outEntity.getSetDtCd()+":"+outEntity.getKeieitaiKj());
		}
		indto.setManageCdCombo(mapManageCd);

		// ワクチン対象区分
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_VAC_INS_TYPE);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapVacInsType = new LinkedHashMap<String, String>();
		mapVacInsType.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapVacInsType.put(outEntity.getValue(), outEntity.getValue() + ":" + outEntity.getValueKanji());
		}
		indto.setVacInsTypeCombo(mapVacInsType);

		// ワクチン定訪先区分
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_VAC_VISIT_TYPE);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapVacVisitType = new LinkedHashMap<String, String>();
		mapVacVisitType.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapVacVisitType.put(outEntity.getValue(), outEntity.getValue() + ":" + outEntity.getValueKanji());
		}
		indto.setVacVisitTypeCombo(mapVacVisitType);
    }

	/**
     * イベント処理
     * @param indto NF101DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO register(NF101DTO indto) {
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
        if("01".equals(indto.getInsType()) || "02".equals(indto.getInsType())) {
	        if(indto.getNextBedCntBase() != null && indto.getNextBedCntBase().length() > 4) {
	        	// 最大文字数を超えています。（病床（基準））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "病床（基準）") + "\n";
				errFlg = true;
	        }
	        if(indto.getNextBedCnt04() != null && indto.getNextBedCnt04().length() > 4) {
	        	// 最大文字数を超えています。（病床（結核））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "病床（結核）") + "\n";
				errFlg = true;
	        }
	        if (indto.getNextBedCnt01() != null && indto.getNextBedCnt01().length() > 4) {
				// 最大文字数を超えています。（病床（一般））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "病床（一般）") + "\n";
				errFlg = true;
			}
			if (indto.getNextBedCnt05() != null && indto.getNextBedCnt05().length() > 4) {
				// 最大文字数を超えています。（病床（感染症））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "病床（感染症）") + "\n";
				errFlg = true;
			}
			if (indto.getNextBedCnt03() != null && indto.getNextBedCnt03().length() > 4) {
				// 最大文字数を超えています。（病床（精神））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "病床（精神）") + "\n";
				errFlg = true;
			}
			if (indto.getNextBedCnt07() != null && indto.getNextBedCnt07().length() > 4) {
				// 最大文字数を超えています。（病床（療養））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "病床（療養）") + "\n";
				errFlg = true;
			}
			if (indto.getNextBedCnt02() != null && indto.getNextBedCnt02().length() > 4) {
				// 最大文字数を超えています。（病床（医療療養））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "病床（医療療養）") + "\n";
				errFlg = true;
			}
			if (indto.getNextBedCnt06() != null && indto.getNextBedCnt06().length() > 4) {
				// 最大文字数を超えています。（病床（介護療養））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "病床（介護療養）") + "\n";
				errFlg = true;
			}
			if (indto.getNextBedsTot() != null && indto.getNextBedsTot().length() > 5) {
				// 最大文字数を超えています。（病床（ベッド数計））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "病床（ベッド数計）") + "\n";
				errFlg = true;
			}
			if (indto.getMedBedsTot() != null && indto.getNextMedBedsTot().length() > 5) {
				// 最大文字数を超えています。（病床（医療ベッド数計））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "病床（医療ベッド数計）") + "\n";
				errFlg = true;
			}
        }
        if(indto.getReqComment() != null && StringUtils.getByteLength(indto.getReqComment()) > 300) {
        	// 最大文字数を超えています。（申請コメント）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "申請コメント") + "\n";
			errFlg = true;
        }
        if(indto.getAprMemo() != null && StringUtils.getByteLength(indto.getAprMemo()) > 300) {
        	// 最大文字数を超えています。（審査・承認メモ）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "審査・承認メモ") + "\n";
			errFlg = true;
        }

        // 文字種チェック
        if("01".equals(indto.getInsType()) || "02".equals(indto.getInsType())) {
		    if (!StringUtils.isNumeric(indto.getNextBedCntBase())) {
				// 入力文字種が不正です。（病床（基準））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "病床（基準）") + "\n";
				errFlg = true;
			}
			if (!StringUtils.isNumeric(indto.getNextBedCnt04())) {
				// 入力文字種が不正です。（病床（結核））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "病床（結核）") + "\n";
				errFlg = true;
			}
			if (!StringUtils.isNumeric(indto.getNextBedCnt01())) {
				// 入力文字種が不正です。（病床（一般））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "病床（一般）") + "\n";
				errFlg = true;
			}
			if (!StringUtils.isNumeric(indto.getNextBedCnt05())) {
				// 入力文字種が不正です。（病床（感染症））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "病床（感染症）") + "\n";
				errFlg = true;
			}
			if (!StringUtils.isNumeric(indto.getNextBedCnt03())) {
				// 入力文字種が不正です。（病床（精神））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "病床（精神）") + "\n";
				errFlg = true;
			}
			if (!StringUtils.isNumeric(indto.getNextBedCnt07())) {
				// 入力文字種が不正です。（病床（療養））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "病床（療養）") + "\n";
				errFlg = true;
			}
			if (!StringUtils.isNumeric(indto.getNextBedCnt02())) {
				// 入力文字種が不正です。（病床（医療療養））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "病床（医療療養）") + "\n";
				errFlg = true;
			}
			if (!StringUtils.isNumeric(indto.getNextBedCnt06())) {
				// 入力文字種が不正です。（病床（介護療養））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "病床（介護療養）") + "\n";
				errFlg = true;
			}
        }

        // エラー時処理
        if(errFlg) {
        	indto.setMsgStr(errMsg);
        	return outdto;
        }

        // 申請ステータスを「01：保存済」として各テーブルに画面の申請情報を登録
        // 管理者権限
        boolean knr = RdmConstantsData.RDM_JKN_ADMIN.equals(indto.getLoginJokenSetCd());

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
        	if(knr) {
        		// 承認者（管理者権限）が申請の場合、'2'(DSG起因)
        		tRdmReqKnrInsData.setReqChl("2");
        		tRdmReqKnrInsData.setReqKngKbn("2");
        	} else {
        		// "MRが申請の場合、'1'(MR起因)
        		tRdmReqKnrInsData.setReqChl("1");
        		tRdmReqKnrInsData.setReqKngKbn("1");
        	}
        	tRdmReqKnrInsData.setReqType("21");
        	tRdmReqKnrInsData.setReqStsCd("01");
        	tRdmReqKnrInsData.setReqBrCd(indto.getReqBrCd());
        	tRdmReqKnrInsData.setReqDistCd(indto.getReqDistCd());
        	tRdmReqKnrInsData.setReqShzNm(indto.getReqShzNm());
        	tRdmReqKnrInsData.setReqJgiNo(indto.getReqJgiNo());
        	tRdmReqKnrInsData.setReqJgiName(indto.getReqJgiName());
        	tRdmReqKnrInsData.setReqComment(indto.getReqComment());
        	tRdmReqKnrInsData.setInsNo(indto.getInsNo());
        	tRdmReqKnrInsData.setInsShaYmd(systemDate);
        	tRdmReqKnrInsData.setInsShaId(indto.getLoginJgiNo());
        	tRdmReqKnrInsData.setUpdShaYmd(systemDate);
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
        	tRdmReqKnrUpdData.setUpdShaYmd(systemDate);
        	tRdmReqKnrUpdData.setUpdShaId(indto.getLoginJgiNo());

        	dao.update(tRdmReqKnrUpdData);
        }

        // 施設_来期用_申請管理
        TRdmHcoNxtReqEntity tRdmHcoNxtReqEntity = new TRdmHcoNxtReqEntity();
        tRdmHcoNxtReqEntity.setReqId(reqId);
        TRdmHcoNxtReqEntity tRdmHcoNxtReqData = dao.selectByPK(tRdmHcoNxtReqEntity);

        if(tRdmHcoNxtReqData == null) {
        	// 新規登録
        	TRdmHcoNxtReqEntity tRdmHcoNxtReqInsData = new TRdmHcoNxtReqEntity();
        	tRdmHcoNxtReqInsData.setReqId(reqId);
        	tRdmHcoNxtReqInsData.setInsNo(indto.getInsNo());
        	tRdmHcoNxtReqInsData.setPharmType(StringUtils.nvl(indto.getNextPharmType(), ""));
        	tRdmHcoNxtReqInsData.setHoInsType(StringUtils.nvl(indto.getNextHoInsType(), ""));
        	tRdmHcoNxtReqInsData.setRegVisType(StringUtils.nvl(indto.getNextRegVisType(), ""));
        	tRdmHcoNxtReqInsData.setInsRank(StringUtils.nvl(indto.getNextInsRank(), ""));
        	tRdmHcoNxtReqInsData.setImpHosType(StringUtils.nvl(indto.getNextImpHosType(), ""));
        	tRdmHcoNxtReqInsData.setManageCd(StringUtils.nvl(indto.getNextManageCd(), ""));
        	tRdmHcoNxtReqInsData.setVacInsType(StringUtils.nvl(indto.getNextVacInsType(), ""));
        	tRdmHcoNxtReqInsData.setVacVisitType(StringUtils.nvl(indto.getNextVacVisitType(), ""));

        	if(!"01".equals(indto.getInsType()) && !"02".equals(indto.getInsType())) {
        		// 病床数非表示、0扱い
        		tRdmHcoNxtReqInsData.setBedcntBase("0");
	        	tRdmHcoNxtReqInsData.setBedcnt04("0");
	        	tRdmHcoNxtReqInsData.setBedcnt01("0");
	        	tRdmHcoNxtReqInsData.setBedcnt05("0");
	        	tRdmHcoNxtReqInsData.setBedcnt07("0");
	        	tRdmHcoNxtReqInsData.setBedcnt02("0");
	        	tRdmHcoNxtReqInsData.setBedcnt03("0");
	        	tRdmHcoNxtReqInsData.setBedcnt06("0");
	        	tRdmHcoNxtReqInsData.setBedsTot("0");
	        	tRdmHcoNxtReqInsData.setMedBedsTot("0");
        	} else {
	        	tRdmHcoNxtReqInsData.setBedcntBase(StringUtils.nvl(indto.getNextBedCntBase(), ""));
	        	tRdmHcoNxtReqInsData.setBedcnt04(StringUtils.nvl(indto.getNextBedCnt04(), ""));
	        	tRdmHcoNxtReqInsData.setBedcnt01(StringUtils.nvl(indto.getNextBedCnt01(), ""));
	        	tRdmHcoNxtReqInsData.setBedcnt05(StringUtils.nvl(indto.getNextBedCnt05(), ""));
	        	tRdmHcoNxtReqInsData.setBedcnt07(StringUtils.nvl(indto.getNextBedCnt07(), ""));
	        	tRdmHcoNxtReqInsData.setBedcnt02(StringUtils.nvl(indto.getNextBedCnt02(), ""));
	        	tRdmHcoNxtReqInsData.setBedcnt03(StringUtils.nvl(indto.getNextBedCnt03(), ""));
	        	tRdmHcoNxtReqInsData.setBedcnt06(StringUtils.nvl(indto.getNextBedCnt06(), ""));
	        	tRdmHcoNxtReqInsData.setBedsTot(StringUtils.nvl(indto.getNextBedsTot(), ""));
	        	tRdmHcoNxtReqInsData.setMedBedsTot(StringUtils.nvl(indto.getNextMedBedsTot(), ""));
        	}

        	tRdmHcoNxtReqInsData.setInsShaYmd(sysDate);
        	tRdmHcoNxtReqInsData.setInsShaId(indto.getLoginJgiNo());
        	tRdmHcoNxtReqInsData.setUpdShaYmd(sysDate);
        	tRdmHcoNxtReqInsData.setUpdShaId(indto.getLoginJgiNo());

        	dao.insertByValue(tRdmHcoNxtReqInsData);

        } else {
        	// 更新
        	TRdmHcoNxtReqEntity tRdmHcoNxtReqUpdData = new TRdmHcoNxtReqEntity("updateNF101Data");
        	tRdmHcoNxtReqUpdData.setReqId(reqId);

        	tRdmHcoNxtReqUpdData.setPharmType(StringUtils.nvl(indto.getNextPharmType(), ""));
        	tRdmHcoNxtReqUpdData.setHoInsType(StringUtils.nvl(indto.getNextHoInsType(), ""));
        	tRdmHcoNxtReqUpdData.setRegVisType(StringUtils.nvl(indto.getNextRegVisType(), ""));
        	tRdmHcoNxtReqUpdData.setInsRank(StringUtils.nvl(indto.getNextInsRank(), ""));
        	tRdmHcoNxtReqUpdData.setImpHosType(StringUtils.nvl(indto.getNextImpHosType(), ""));
        	tRdmHcoNxtReqUpdData.setManageCd(StringUtils.nvl(indto.getNextManageCd(), ""));
        	tRdmHcoNxtReqUpdData.setVacInsType(StringUtils.nvl(indto.getNextVacInsType(), ""));
        	tRdmHcoNxtReqUpdData.setVacVisitType(StringUtils.nvl(indto.getNextVacVisitType(), ""));

        	if(!"01".equals(indto.getInsType()) && !"02".equals(indto.getInsType())) {
        		// 病床数非表示、0扱い
        		tRdmHcoNxtReqUpdData.setBedcntBase("0");
	        	tRdmHcoNxtReqUpdData.setBedcnt04("0");
	        	tRdmHcoNxtReqUpdData.setBedcnt01("0");
	        	tRdmHcoNxtReqUpdData.setBedcnt05("0");
	        	tRdmHcoNxtReqUpdData.setBedcnt07("0");
	        	tRdmHcoNxtReqUpdData.setBedcnt02("0");
	        	tRdmHcoNxtReqUpdData.setBedcnt03("0");
	        	tRdmHcoNxtReqUpdData.setBedcnt06("0");
	        	tRdmHcoNxtReqUpdData.setBedsTot("0");
	        	tRdmHcoNxtReqUpdData.setMedBedsTot("0");
        	} else {
	        	tRdmHcoNxtReqUpdData.setBedcntBase(StringUtils.nvl(indto.getNextBedCntBase(), ""));
	        	tRdmHcoNxtReqUpdData.setBedcnt04(StringUtils.nvl(indto.getNextBedCnt04(), ""));
	        	tRdmHcoNxtReqUpdData.setBedcnt01(StringUtils.nvl(indto.getNextBedCnt01(), ""));
	        	tRdmHcoNxtReqUpdData.setBedcnt05(StringUtils.nvl(indto.getNextBedCnt05(), ""));
	        	tRdmHcoNxtReqUpdData.setBedcnt07(StringUtils.nvl(indto.getNextBedCnt07(), ""));
	        	tRdmHcoNxtReqUpdData.setBedcnt02(StringUtils.nvl(indto.getNextBedCnt02(), ""));
	        	tRdmHcoNxtReqUpdData.setBedcnt03(StringUtils.nvl(indto.getNextBedCnt03(), ""));
	        	tRdmHcoNxtReqUpdData.setBedcnt06(StringUtils.nvl(indto.getNextBedCnt06(), ""));
	        	tRdmHcoNxtReqUpdData.setBedsTot(StringUtils.nvl(indto.getNextBedsTot(), ""));
	        	tRdmHcoNxtReqUpdData.setMedBedsTot(StringUtils.nvl(indto.getNextMedBedsTot(), ""));
        	}

        	tRdmHcoNxtReqUpdData.setUpdShaYmd(sysDate);
        	tRdmHcoNxtReqUpdData.setUpdShaId(indto.getLoginJgiNo());

        	dao.update(tRdmHcoNxtReqUpdData);
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

        // END UOC
        return outdto;
    }

	/**
     * イベント処理
     * @param indto NF101DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO shnComp(NF101DTO indto) {
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
    * 申請破棄
    * @param indto
    * @return
    */
   @Transactional
   public BaseDTO cancel(NF101DTO indto) {
       BaseDTO outdto = indto;
       // DropDownList作成
       createCombo(indto);

       // START UOC
       // 申請管理を物理削除
       TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity();
       tRdmReqKnrEntity.setReqId(indto.getReqId());
       dao.deleteByPK(tRdmReqKnrEntity);

       // 施設_来期用_申請管理を物理削除
       TRdmHcoNxtReqEntity tRdmHcoNxtReqEntity = new TRdmHcoNxtReqEntity();
       tRdmHcoNxtReqEntity.setReqId(indto.getReqId());
       dao.deleteByPK(tRdmHcoNxtReqEntity);

       // END UOC
       return outdto;
   }

   /**
    * 変更前と値が同一の場合は変更前、'Z'の場合はブランクを返却
    * @param preValue
    * @param value
    * @return
    */
   public String getViewValue(String preValue, String value){
   	String rtnValue = value;

   	if(value != null && value.equals(preValue)) {
   		rtnValue = preValue;
   	} else if("Z".equals(value)) {
   		rtnValue = "";
   	}

   	return rtnValue;
   }

   /**
    * NULLの場合変更前値、'Z'の場合はブランクを返却
    * @param preValue
    * @param value
    * @return
    */
   public String getReqViewValue(String preValue, String value){
   	String rtnValue = value;

   	if(StringUtils.isEmpty(value)) {
   		rtnValue = preValue;
   	} else if("Z".equals(value)) {
   		rtnValue = "";
   	}

   	return rtnValue;
   }
}
