/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.HcoBlkReqDataList;
import jp.co.takeda.rdm.dto.NF405DTO;
import jp.co.takeda.rdm.entity.join.MRdmParamMstEntity;
import jp.co.takeda.rdm.entity.join.SeqRdmReqIdEntity;
import jp.co.takeda.rdm.entity.join.TRdmHcoNxtReqEntity;
import jp.co.takeda.rdm.entity.join.TRdmReqKnrEntity;
import jp.co.takeda.rdm.util.DateUtils;
import jp.co.takeda.rdm.util.RdmConstantsData;

/**
 * Serviceクラス（NF405)
 * @generated
 */
@Named
public class NF405Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(NF405Service.class);

    /**
     * イベント処理
     * @param indto RDMNF405DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(NF405DTO indto) {
        BaseDTO outdto = indto;
        // START UOC
        // MR権限の場合、権限エラーでエラー画面に遷移する
        if(RdmConstantsData.RDM_JKN_MR.equals(indto.getLoginJokenSetCd())) {
        	indto.setForward("NC109");
        	return outdto;
        }

     	// 申請ボタンの活性設定
        String mnFac = "0";
    	String mnNt = "0";

    	MRdmParamMstEntity mRdmParamMstEntity = new MRdmParamMstEntity();
    	mRdmParamMstEntity.setParamName("MN_FAC");
    	mRdmParamMstEntity.setDelFlg("0");

    	List<MRdmParamMstEntity> mRdmParamMstEntityList = dao.selectByValue(mRdmParamMstEntity);
    	if(mRdmParamMstEntityList.size() > 0) {
    		// valueの左から2桁目
    		mnFac = mRdmParamMstEntityList.get(0).getValue().substring(1,2);
    	}

    	MRdmParamMstEntity mRdmParamMstNtEntity = new MRdmParamMstEntity();
		mRdmParamMstNtEntity.setParamName("MN_NT_FAC");
    	mRdmParamMstNtEntity.setDelFlg("0");

    	List<MRdmParamMstEntity> mRdmParamMstOyaEntityList = dao.selectByValue(mRdmParamMstNtEntity);
    	if(mRdmParamMstOyaEntityList.size() > 0) {
    		// value
    		mnNt = mRdmParamMstOyaEntityList.get(0).getValue();
    	}

    	if(mnFac.equals("1") && mnNt.equals("1")) {
			indto.setBtnEnableFlg("1");
		} else {
			indto.setBtnEnableFlg("0");
		}

        List<HcoBlkReqDataList> hcoBlkReqDataList = new ArrayList<HcoBlkReqDataList>();

		for(HcoBlkReqDataList entity : indto.getHcoBlkReqDataList()) {
			// 対象区分再設定
			entity.setNextHoInsType(entity.getNextHoInsTypeValue());

			if(entity.getNextPharmType() == null) {
				entity.setNextPharmType("");
			}
			if(entity.getNextInsRank() == null) {
				entity.setNextInsRank("");
			}
			if(entity.getNextRegVisType() == null) {
				entity.setNextRegVisType("");
			}
			if(entity.getNextImpHosType() == null) {
				entity.setNextImpHosType("");
			}
			if(entity.getNextManageCd() == null) {
				entity.setNextManageCd("");
			}
			if(entity.getNextVacInsType() == null) {
				entity.setNextVacInsType("");
			}
			if(entity.getNextVacVisitType() == null) {
				entity.setNextVacVisitType("");
			}

			if("--選択してください--".equals(entity.getNextPharmTypeNm()) || "".equals(entity.getNextPharmTypeNm())) {
				entity.setNextPharmTypeNm("--なし--");
			}
			if("--選択してください--".equals(entity.getNextInsRankNm()) || StringUtils.isEmpty(entity.getNextInsRankNm())) {
				entity.setNextInsRankNm("--なし--");
			}
			if("--選択してください--".equals(entity.getNextRegVisTypeNm()) || StringUtils.isEmpty(entity.getNextRegVisTypeNm())) {
				entity.setNextRegVisTypeNm("--なし--");
			}
			if("--選択してください--".equals(entity.getNextImpHosTypeNm()) || StringUtils.isEmpty(entity.getNextImpHosTypeNm())) {
				entity.setNextImpHosTypeNm("--なし--");
			}
			if("--選択してください--".equals(entity.getNextHoInsTypeNm()) || StringUtils.isEmpty(entity.getNextHoInsTypeNm())) {
				entity.setNextHoInsTypeNm("--なし--");
			}
			if("--選択してください--".equals(entity.getNextManageNm()) || StringUtils.isEmpty(entity.getNextManageNm())) {
				entity.setNextManageNm("--なし--");
			}
			if("--選択してください--".equals(entity.getNextVacInsTypeNm()) || StringUtils.isEmpty(entity.getNextVacInsTypeNm())) {
				entity.setNextVacInsTypeNm("--なし--");
			}
			if("--選択してください--".equals(entity.getNextVacVisitTypeNm()) || StringUtils.isEmpty(entity.getNextVacVisitTypeNm())) {
				entity.setNextVacVisitTypeNm("--なし--");
			}

			// 申請チェック有のもののみ取得
			if("1".equals(entity.getReqChk())) {
				hcoBlkReqDataList.add(entity);
			}
		}

        for(HcoBlkReqDataList entity : hcoBlkReqDataList) {
        	if(StringUtils.isEmpty(entity.getReqComment())) {
        		entity.setReqComment(" ");
        	}
        }

        indto.setHcoBlkReqDataList(hcoBlkReqDataList);

    	// END UOC
        return outdto;

    }

	public BaseDTO register(NF405DTO indto) {
		BaseDTO outdto = indto;
		LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

		boolean errFlg = false;
		String errMsg = "";

        // エラーチェック
		for(HcoBlkReqDataList entity : indto.getHcoBlkReqDataList()) {

			// 「施設コード_施設略式漢字名：」を各エラーメッセージの先頭に追加
			StringBuilder nmSb = new StringBuilder();
			nmSb.append(entity.getInsNo());
			nmSb.append("_");
			nmSb.append(entity.getInsAbbrName());
			nmSb.append(":");
			String msgNm = nmSb.toString();

			// 排他チェック
			TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity("selectNF401DateChkData");
			tRdmReqKnrEntity.setInsNo(entity.getInsNo());
			List<TRdmReqKnrEntity> tRdmReqKnrChkData = dao.select(tRdmReqKnrEntity);

			if(tRdmReqKnrChkData.size() > 0 && tRdmReqKnrChkData.get(0) != null && tRdmReqKnrChkData.get(0).getUpdShaYmd() != null) {
				// 更新日を取得
				SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
				String updShaYmd = fmtDate.format(tRdmReqKnrChkData.get(0).getUpdShaYmd());

				if(!updShaYmd.equals(entity.getUpdShaYmd())) {
					// 既に他のユーザーによってデータが処理されています。
					errMsg += msgNm + loginInfo.getMsgData(RdmConstantsData.E003) + "\n";
					errFlg = true;
				}
			}

			// エラー時処理
			if (errFlg) {
				indto.setMsgStr(errMsg);
				indto.setForward("NF405");

				return outdto;
			}
		}

		// 現在日付を取得
        Date systemDate = DateUtils.getNowDate();
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
        String sysDate = fmtDate.format(systemDate);
        SimpleDateFormat fmtDateTime = new SimpleDateFormat("yyyyMMddHHmmss");
        String sysDateTime = fmtDateTime.format(systemDate);

		// 登録処理
		for(HcoBlkReqDataList entity : indto.getHcoBlkReqDataList()) {
			// 申請管理
			// 新規にIDを取得
        	SeqRdmReqIdEntity seqRdmReqIdEntity = new SeqRdmReqIdEntity();
        	List<SeqRdmReqIdEntity> seqRdmReqIdDate = dao.select(seqRdmReqIdEntity);
        	String reqId = seqRdmReqIdDate.get(0).getReqId();

        	// レコードを登録
        	TRdmReqKnrEntity tRdmReqKnrInsData = new TRdmReqKnrEntity();
        	tRdmReqKnrInsData.setReqId(reqId);

        	// 承認者（管理者権限）が申請の場合、'2'(DSG起因)
    		tRdmReqKnrInsData.setReqChl("2");
    		tRdmReqKnrInsData.setReqKngKbn("2");

    		tRdmReqKnrInsData.setReqType("21");

    		// 申請
    		tRdmReqKnrInsData.setReqStsCd("03");
    		tRdmReqKnrInsData.setReqBrCd(loginInfo.getBrCode());
        	tRdmReqKnrInsData.setReqDistCd(loginInfo.getDistCode());
        	tRdmReqKnrInsData.setReqShzNm(loginInfo.getBumonRyakuName());
        	tRdmReqKnrInsData.setReqJgiNo(loginInfo.getJgiNo());
        	tRdmReqKnrInsData.setReqJgiName(loginInfo.getJgiName());
        	tRdmReqKnrInsData.setReqYmdhms(sysDateTime);
        	tRdmReqKnrInsData.setReqComment(entity.getReqComment());
        	tRdmReqKnrInsData.setInsNo(entity.getInsNo());
        	tRdmReqKnrInsData.setFbReqFlg("1");
        	tRdmReqKnrInsData.setInsShaYmd(systemDate);
        	tRdmReqKnrInsData.setInsShaId(indto.getLoginJgiNo());
        	tRdmReqKnrInsData.setUpdShaYmd(systemDate);
        	tRdmReqKnrInsData.setUpdShaId(indto.getLoginJgiNo());

        	dao.insertByValue(tRdmReqKnrInsData);

			// 施設_来期用_申請管理
        	TRdmHcoNxtReqEntity tRdmHcoNxtReqInsData = new TRdmHcoNxtReqEntity();
        	tRdmHcoNxtReqInsData.setReqId(reqId);
        	tRdmHcoNxtReqInsData.setInsNo(entity.getInsNo());
        	tRdmHcoNxtReqInsData.setPharmType(getUpdValue(entity.getPharmType(), entity.getNextPharmType()));
        	tRdmHcoNxtReqInsData.setHoInsType(getUpdValue(entity.getHoInsType(), entity.getNextHoInsType()));
        	tRdmHcoNxtReqInsData.setRegVisType(getUpdValue(entity.getRegVisType(), entity.getNextRegVisType()));
        	tRdmHcoNxtReqInsData.setInsRank(getUpdValue(entity.getInsRank(), entity.getNextInsRank()));
        	tRdmHcoNxtReqInsData.setImpHosType(getUpdValue(entity.getImpHosType(), entity.getNextImpHosType()));
        	tRdmHcoNxtReqInsData.setManageCd(getUpdValue(entity.getManageCd(), entity.getNextManageCd()));
        	tRdmHcoNxtReqInsData.setVacInsType(getUpdValue(entity.getVacInsType(), entity.getNextVacInsType()));
        	tRdmHcoNxtReqInsData.setVacVisitType(getUpdValue(entity.getVacVisitType(), entity.getNextVacVisitType()));

        	tRdmHcoNxtReqInsData.setBedcntBase(getUpdValue(entity.getBedCntBase(), entity.getNextBedCntBase()));
        	tRdmHcoNxtReqInsData.setBedcnt04(getUpdValue(entity.getBedCnt04(), entity.getNextBedCnt04()));
        	tRdmHcoNxtReqInsData.setBedcnt01(getUpdValue(entity.getBedCnt01(), entity.getNextBedCnt01()));
        	tRdmHcoNxtReqInsData.setBedcnt05(getUpdValue(entity.getBedCnt05(), entity.getNextBedCnt05()));
        	tRdmHcoNxtReqInsData.setBedcnt07(getUpdValue(entity.getBedCnt07(), entity.getNextBedCnt07()));
        	tRdmHcoNxtReqInsData.setBedcnt02(getUpdValue(entity.getBedCnt02(), entity.getNextBedCnt02()));
        	tRdmHcoNxtReqInsData.setBedcnt03(getUpdValue(entity.getBedCnt03(), entity.getNextBedCnt03()));
        	tRdmHcoNxtReqInsData.setBedcnt06(getUpdValue(entity.getBedCnt06(), entity.getNextBedCnt06()));
        	tRdmHcoNxtReqInsData.setBedsTot(getUpdValue(entity.getBedsTot(), entity.getNextBedsTot()));
        	tRdmHcoNxtReqInsData.setMedBedsTot(getUpdValue(entity.getMedBedsTot(), entity.getNextMedBedsTot()));

        	tRdmHcoNxtReqInsData.setInsShaYmd(sysDate);
        	tRdmHcoNxtReqInsData.setInsShaId(indto.getLoginJgiNo());
        	tRdmHcoNxtReqInsData.setUpdShaYmd(sysDate);
        	tRdmHcoNxtReqInsData.setUpdShaId(indto.getLoginJgiNo());

        	dao.insertByValue(tRdmHcoNxtReqInsData);
		}

		indto.setForward("NC101");
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

    	if(value != null && value.equals(preValue)
    			|| (value == null && (preValue == null || preValue.isEmpty()))) {
    		rtnValue = null;
    	} else if(value == null || value.equals("")) {
    		rtnValue = "Z";
    	}

    	return rtnValue;
    }
}