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
import java.util.List;

import javax.inject.Named;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.dto.HcoNxtReqDataList;
import jp.co.takeda.rdm.dto.NF102DTO;
import jp.co.takeda.rdm.entity.join.RdmCommonEntity;
import jp.co.takeda.rdm.entity.join.SelectNF102MainDataEntity;
import jp.co.takeda.rdm.entity.join.SelectNF102MainDataListEntity;
import jp.co.takeda.rdm.util.DateUtils;
import jp.co.takeda.rdm.util.StringUtils;

/**
 * Serviceクラス（NF102)
 * @generated
 */
@Named
public class NF102Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(NF102Service.class);

	public BaseDTO init(NF102DTO indto) {
		BaseDTO outdto = indto;

		// ヘッダ部を取得
		SelectNF102MainDataEntity selectNF102MainDataEntity = new SelectNF102MainDataEntity();
		selectNF102MainDataEntity.setInInsNo(indto.getInsNo());
		List<SelectNF102MainDataEntity> selectNF102MainDataEntityList = dao.select(selectNF102MainDataEntity);

		if(selectNF102MainDataEntityList.size() > 0) {
			indto.setInsAbbrName(StringUtils.nvl(selectNF102MainDataEntityList.get(0).getInsAbbrName()," "));
			indto.setUltInsNo(StringUtils.nvl(selectNF102MainDataEntityList.get(0).getUltInsNo()," "));
			indto.setShisetsuNmRyaku(StringUtils.nvl(selectNF102MainDataEntityList.get(0).getShisetsuNmRyaku()," "));
		} else {
			indto.setInsAbbrName(" ");
			indto.setUltInsNo(" ");
			indto.setShisetsuNmRyaku(" ");
		}

    	// 現在日付を取得
        Date systemDate = DateUtils.getNowDate();
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMdd");
        String sysDate = fmtDate.format(systemDate);

        // 当期月初をRDM_COMMON.GET_CURR_TERM_FIRSTDAYから取得する
        RdmCommonEntity rdmCommonEntity = new RdmCommonEntity("getCurrTermFirstday");
    	rdmCommonEntity.setInVBatDate(sysDate);
    	List<RdmCommonEntity> rdmCommonEntityList = dao.select(rdmCommonEntity);
    	String currTermFirstDay = null;
    	if(rdmCommonEntityList.size() > 0) {
    		currTermFirstDay = rdmCommonEntityList.get(0).getCurrTermFirstday() + "000000";
    	}

		// 翌期月初をRDM_COMMON.GET_NEXT_TERM_FIRSTDAYから取得する
    	RdmCommonEntity rdmCommonNextEntity = new RdmCommonEntity("getNextTermFirstday");
    	rdmCommonNextEntity.setInVBatDate(sysDate);
    	List<RdmCommonEntity> rdmCommonNextEntityList = dao.select(rdmCommonNextEntity);
    	String nextTermFirstDay = null;
    	if(rdmCommonNextEntityList.size() > 0) {
    		nextTermFirstDay = rdmCommonNextEntityList.get(0).getNextTermFirstday() + "000000";
    	}

        // 一覧表示データ
        List<HcoNxtReqDataList> hcoNxtReqDataList = new ArrayList<HcoNxtReqDataList>();

  		// 表示データ取得
        SelectNF102MainDataListEntity selectNF102MainDataListEntity = new SelectNF102MainDataListEntity();

  		// 施設固定コード
  		selectNF102MainDataListEntity.setInInsNo(indto.getInsNo());

  		// 取得範囲
  		selectNF102MainDataListEntity.setInCurrTermFirstDay(currTermFirstDay);
  		selectNF102MainDataListEntity.setInNextTermFirstDay(nextTermFirstDay);

        //ソートIDのセット
  		if(indto.getSortCondition() == null || indto.getSortCondition().isEmpty()) {
  			selectNF102MainDataListEntity.setInSortId("0");
  			indto.setSortCondition("0");
  		} else {
  			selectNF102MainDataListEntity.setInSortId(indto.getSortCondition());
  		}

        // 一覧を取得する
        List<SelectNF102MainDataListEntity> selectNF102DataListEntity = dao.select(selectNF102MainDataListEntity);

        for (SelectNF102MainDataListEntity entity : selectNF102DataListEntity) {
        	HcoNxtReqDataList dataRecord = new HcoNxtReqDataList();

    		dataRecord.setReqStsNm(getSetValue(entity.getReqStsNm()));

    		SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyyMMddHHmmss");
    		SimpleDateFormat sdfDateTime2 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			if (entity.getReqYmdhms() != null && entity.getReqYmdhms().length() == 14) {
				try {
					Date reqYmd = sdfDateTime.parse(entity.getReqYmdhms());
					String strReqYmd = sdfDateTime2.format(reqYmd);
					dataRecord.setReqYmdhms(strReqYmd);
				} catch (ParseException e) {
					e.printStackTrace();
					dataRecord.setReqYmdhms(" ");
				}
			} else {
				dataRecord.setReqYmdhms(" ");
			}

    		dataRecord.setPharmType(getSetValue(entity.getPharmType()));
    		dataRecord.setInsRank(getSetValue(entity.getInsRank()));
    		dataRecord.setRegVisType(getSetValue(entity.getRegVisType()));
    		dataRecord.setImpHosType(getSetValue(entity.getImpHosType()));
    		dataRecord.setHoInsType(getSetValue(entity.getHoInsType()));
    		dataRecord.setManageNm(getSetValue(entity.getManageNm()));
    		dataRecord.setVacInsType(getSetValue(entity.getVacInsType()));
    		dataRecord.setVacVisitType(getSetValue(entity.getVacVisitType()));

    		dataRecord.setBedCntBase(getSetValue(entity.getBedCntBase()));
    		dataRecord.setBedCnt04(getSetValue(entity.getBedCnt04()));
    		dataRecord.setBedCnt01(getSetValue(entity.getBedCnt01()));
    		dataRecord.setBedCnt05(getSetValue(entity.getBedCnt05()));
    		dataRecord.setBedCnt03(getSetValue(entity.getBedCnt03()));
    		dataRecord.setBedCnt07(getSetValue(entity.getBedCnt07()));
    		dataRecord.setBedCnt02(getSetValue(entity.getBedCnt02()));
    		dataRecord.setBedCnt06(getSetValue(entity.getBedCnt06()));
    		dataRecord.setBedsTot(getSetValue(entity.getBedsTot()));
    		dataRecord.setMedBedsTot(getSetValue(entity.getMedBedsTot()));

    		dataRecord.setReqComment(getSetValue(entity.getReqComment()));
    		dataRecord.setReqId(getSetValue(entity.getReqId()));
    		dataRecord.setReqJgiName(getSetValue(entity.getReqJgiName()));
    		dataRecord.setReqShzNm(getSetValue(entity.getReqShzNm()));
    		dataRecord.setReqJgiNo(getSetValue(entity.getReqJgiNo()));

        	hcoNxtReqDataList.add(dataRecord);
        }

        indto.setHcoNxtReqDataList(hcoNxtReqDataList);

        // END UOC
       	return outdto;
	}

	public String getSetValue(String value) {
		String rtnValue = " ";

		if(!StringUtils.isEmpty(value)) {
    		rtnValue = value;
    	}

		return rtnValue;
	}
}