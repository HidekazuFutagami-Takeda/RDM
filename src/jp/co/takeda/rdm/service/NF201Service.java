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

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.dto.HcoOyakoDataList;
import jp.co.takeda.rdm.dto.HcoOyakoNextDataList;
import jp.co.takeda.rdm.dto.NF201DTO;
import jp.co.takeda.rdm.entity.join.MRdmHcoMstEntity;
import jp.co.takeda.rdm.entity.join.MRdmParamMstEntity;
import jp.co.takeda.rdm.entity.join.SelectNF201ChkDataEntity;
import jp.co.takeda.rdm.entity.join.SelectNF201OyakoDataListEntity;
import jp.co.takeda.rdm.entity.join.SelectNF201OyakoNextDataListEntity;
import jp.co.takeda.rdm.util.RdmConstantsData;

/**
 * Serviceクラス（NF201)
 * @generated
 */
@Named
public class NF201Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(NF201Service.class);

	public BaseDTO init(NF201DTO indto) {
		BaseDTO outdto = indto;

		// ヘッダ部を取得
		MRdmHcoMstEntity mRdmHcoMstEntity = new MRdmHcoMstEntity();
		mRdmHcoMstEntity.setInsNo(indto.getInsNo());
		MRdmHcoMstEntity mRdmHcoMstEntityData = dao.selectByPK(mRdmHcoMstEntity);

		indto.setInsNo(mRdmHcoMstEntityData.getInsNo());
		indto.setInsAbbrName(mRdmHcoMstEntityData.getInsAbbrName());
		indto.setInsAddr(mRdmHcoMstEntityData.getInsAddr());

        // 一覧表示  当期親施設データ
        List<HcoOyakoDataList> hcoOyakoDataList = new ArrayList<HcoOyakoDataList>();

  		// 当期親施設データ取得
        SelectNF201OyakoDataListEntity selectNF201OyakoDataListEntity = new SelectNF201OyakoDataListEntity();
        if("1".equals(indto.getTkdTrtKbn())) {
        	selectNF201OyakoDataListEntity.setSqlId("selectNF201TrtDataList");
        }

  		// 施設固定コード
  		selectNF201OyakoDataListEntity.setInInsNo(indto.getInsNo());

        // 一覧を取得する
        List<SelectNF201OyakoDataListEntity> selectNF201OyakoDataList = dao.select(selectNF201OyakoDataListEntity);

        String mainInsNo = "";
        for (SelectNF201OyakoDataListEntity entity : selectNF201OyakoDataList) {
        	HcoOyakoDataList dataRecord = new HcoOyakoDataList();

        	// 各データ行のアクションボタンの活性・非活性条件
        	String editFlg = "0";
        	String deleteFlg = "0";
        	if("1".equals(entity.getNtValue())) {
        		// パラメタ情報(施設メニュースイッチ)．値(左から2桁目）
        		if("1".equals(entity.getFacValue().substring(1,2))) {
        			editFlg = "1";
        		} else {
        			editFlg = "0";
        		}
        		// パラメタ情報(施設メニュースイッチ)．値(左から3桁目）
        		if("1".equals(entity.getFacValue().substring(2,3))) {
        			deleteFlg = "1";
        		} else {
        			deleteFlg = "0";
        		}
        	}

        	if("0".equals(indto.getTkdTrtKbn())) {
        		dataRecord.setEditFlg(editFlg);
        		dataRecord.setDeleteFlg(deleteFlg);
        	} else {
        		if("00".equals(entity.getTrtCd())) {
        			// 隠し項目．領域コードが'00'（武田紐）の場合、編集および削除のアクションボタンを表示しない
        			dataRecord.setEditFlg("0");
            		dataRecord.setDeleteFlg("0");
        		} else if(RdmConstantsData.RDM_JKN_ADMIN.equals(indto.getLoginJokenSetCd())) {
        			// ログインユーザが管理者権限の場合
        			dataRecord.setEditFlg(editFlg);
            		dataRecord.setDeleteFlg(deleteFlg);
        		} else if(entity.getTrtCd() != null && !entity.getTrtCd().equals(indto.getLoginTrtCd())){
        			// ログインユーザがMR権限、ログインユーザ情報．領域コードが隠し項目．領域コードと異なる場合
        			dataRecord.setEditFlg("0");
            		dataRecord.setDeleteFlg("0");
        		} else {
        			// ログインユーザがMR権限、ログインユーザ情報．領域コードが隠し項目．領域コードが一致する場合
        			dataRecord.setEditFlg(editFlg);
            		dataRecord.setDeleteFlg(deleteFlg);
        		}
        	}

        	dataRecord.setTrtCd(entity.getTrtCd());
    		dataRecord.setTrtNm(getSetValue(entity.getTrtNm()));
    		dataRecord.setHinGCd(entity.getHinGCd());
    		dataRecord.setHinGNm(getSetValue(entity.getHinGNm()));
    		dataRecord.setInsAbbrName(getSetValue(entity.getInsAbbrName()));
    		dataRecord.setHoInsType(getSetValue(entity.getHoInsType()));
    		dataRecord.setInsAddr(getSetValue(entity.getInsAddr()));
    		dataRecord.setJgiName(getSetValue(entity.getJgiName()));

    		mainInsNo = entity.getMainInsNo();

        	hcoOyakoDataList.add(dataRecord);
        }

        indto.setHcoOyakoDataList(hcoOyakoDataList);

        // 追加ボタン活性フラグ取得
        if("0".equals(indto.getTkdTrtKbn()) && StringUtils.isEmpty(mainInsNo)) {
        	// 親画面．武田紐領域別区分が'0'（武田紐）の場合かつ、1-3-1で取得した隠し項目．親施設コードがNULLではない場合
        	indto.setAddFlg("0");

        } else if("0".equals(indto.getTkdTrtKbn())) {
        	// 親画面．武田紐領域別区分が'0'（武田紐）の場合かつ、1-3-1で取得した隠し項目．親施設コードがNULLである場合
        	String mnFac = "0";
        	String mnOya = "0";

        	MRdmParamMstEntity mRdmParamMstEntity = new MRdmParamMstEntity();
        	mRdmParamMstEntity.setParamName("MN_FAC");
        	mRdmParamMstEntity.setDelFlg("0");

        	List<MRdmParamMstEntity> mRdmParamMstEntityList = dao.selectByValue(mRdmParamMstEntity);
        	if(mRdmParamMstEntityList.size() > 0) {
        		// valueの左一桁
        		mnFac = mRdmParamMstEntityList.get(0).getValue().substring(0,1);
        	}

        	MRdmParamMstEntity mRdmParamMstOyaEntity = new MRdmParamMstEntity();
    		mRdmParamMstOyaEntity.setParamName("MN_NT_OYA");
        	mRdmParamMstOyaEntity.setDelFlg("0");

        	List<MRdmParamMstEntity> mRdmParamMstOyaEntityList = dao.selectByValue(mRdmParamMstOyaEntity);
        	if(mRdmParamMstOyaEntityList.size() > 0) {
        		// value
        		mnOya = mRdmParamMstOyaEntityList.get(0).getValue();
        	}
        	if(mnFac.equals("1") && mnOya.equals("1")) {
    			indto.setAddFlg("1");
    		} else {
    			indto.setAddFlg("0");
    		}
        } else {
        	// 親画面．武田紐領域別区分が'1'（領域別紐付け）の場合
        	SelectNF201ChkDataEntity selectNF201ChkDataEntity = new SelectNF201ChkDataEntity();

        	selectNF201ChkDataEntity.setInInsNo(indto.getInsNo());
        	if(RdmConstantsData.RDM_JKN_MR.equals(indto.getLoginJokenSetCd())) {
        		selectNF201ChkDataEntity.setInTrtCd(indto.getLoginTrtCd());
        	}

        	List<SelectNF201ChkDataEntity> selectNF201ChkDataEntityList = dao.select(selectNF201ChkDataEntity);

        	if(selectNF201ChkDataEntityList.size()>0 && selectNF201ChkDataEntityList.get(0).getTrtPrdCnt() != null
        			&& selectNF201ChkDataEntityList.get(0).getTrtPrdCnt().equals(selectNF201ChkDataEntityList.get(0).getMainInsCnt())) {
        		// メインクエリ（領域・品目グループ件数）の件数＝メインクエリ（親施設設定件数）の件数の場合
        		indto.setAddFlg("0");
        	} else {
        		String mnFac = "0";
            	String mnOya = "0";

            	MRdmParamMstEntity mRdmParamMstEntity = new MRdmParamMstEntity();
            	mRdmParamMstEntity.setParamName("MN_FAC");
            	mRdmParamMstEntity.setDelFlg("0");

            	List<MRdmParamMstEntity> mRdmParamMstEntityList = dao.selectByValue(mRdmParamMstEntity);
            	if(mRdmParamMstEntityList.size() > 0) {
            		// valueの左一桁
            		mnFac = mRdmParamMstEntityList.get(0).getValue().substring(0,1);
            	}

            	MRdmParamMstEntity mRdmParamMstOyaEntity = new MRdmParamMstEntity();
        		mRdmParamMstOyaEntity.setParamName("MN_CT_OYA");
            	mRdmParamMstOyaEntity.setDelFlg("0");

            	List<MRdmParamMstEntity> mRdmParamMstOyaEntityList = dao.selectByValue(mRdmParamMstOyaEntity);
            	if(mRdmParamMstOyaEntityList.size() > 0) {
            		// value
            		mnOya = mRdmParamMstOyaEntityList.get(0).getValue();
            	}
            	if(mnFac.equals("1") && mnOya.equals("1")) {
        			indto.setAddFlg("1");
        		} else {
        			indto.setAddFlg("0");
        		}
        	}
        }

        // 一覧表示 申請状況一覧
        List<HcoOyakoNextDataList> hcoOyakoNextDataList = new ArrayList<HcoOyakoNextDataList>();

  		// 当期親施設データ取得
        SelectNF201OyakoNextDataListEntity selectNF201OyakoNextDataListEntity = new SelectNF201OyakoNextDataListEntity();
        if("1".equals(indto.getTkdTrtKbn())) {
        	selectNF201OyakoNextDataListEntity.setSqlId("selectNF201TrtDataList");
        }

  		// 施設固定コード
  		selectNF201OyakoNextDataListEntity.setInInsNo(indto.getInsNo());

        // 一覧を取得する
        List<SelectNF201OyakoNextDataListEntity> selectNF201OyakoNextDataList = dao.select(selectNF201OyakoNextDataListEntity);

        for (SelectNF201OyakoNextDataListEntity entity : selectNF201OyakoNextDataList) {
        	HcoOyakoNextDataList dataRecord = new HcoOyakoNextDataList();

        	if(entity.getTekiyoYmd() != null && entity.getTekiyoYmd().length() == 8) {
        		SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyyMMdd");
				SimpleDateFormat sdfDateTime2 = new SimpleDateFormat("yyyy/MM/dd");
				try {
					Date reqYmd = sdfDateTime.parse(entity.getTekiyoYmd());
					String strReqYmd = sdfDateTime2.format(reqYmd);
					dataRecord.setTekiyoYmd(strReqYmd);
				} catch (ParseException e) {
					e.printStackTrace();
					dataRecord.setTekiyoYmd(getSetValue(entity.getTekiyoYmd()));
				}
        	}

        	dataRecord.setAction(getSetValue(entity.getAction()));
        	dataRecord.setTrtNm(getSetValue(entity.getTrtNm()));
        	dataRecord.setHinGNm(getSetValue(entity.getHinGNm()));
        	dataRecord.setInsAbbrName(getSetValue(entity.getInsAbbrName()));
        	dataRecord.setInsAddr(getSetValue(entity.getInsAddr()));

        	hcoOyakoNextDataList.add(dataRecord);
        }

        indto.setHcoOyakoNextDataList(hcoOyakoNextDataList);

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