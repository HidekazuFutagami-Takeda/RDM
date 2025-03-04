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
import jp.co.takeda.rdm.dto.NF309DTO;
import jp.co.takeda.rdm.entity.join.MRdmParamMstEntity;
import jp.co.takeda.rdm.entity.join.SelectComboListEntity;
import jp.co.takeda.rdm.entity.join.TRdmReqKnrEntity;
import jp.co.takeda.rdm.util.DateUtils;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;

/**
 * Serviceクラス（NF309)
 * @generated
 */
@Named
public class NF309Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(NF309Service.class);

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
     * @param indto NF309DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(NF309DTO indto) {
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
        if(indto.getNextPharmType() == null || indto.getNextPharmType().isEmpty()) {
        	// 必須項目にデータを入力してください。（施設区分）
        	errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "施設区分") + "\n";
        	errFlg = true;
        }
        if(indto.getNextInsRank() == null || indto.getNextInsRank().isEmpty()) {
        	// 必須項目にデータを入力してください。（階級区分）
        	errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "階級区分") + "\n";
        	errFlg = true;
        }
        if(indto.getNextRegVisType() == null || indto.getNextRegVisType().isEmpty()) {
        	// 必須項目にデータを入力してください。（定訪先区分）
        	errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "定訪先区分") + "\n";
        	errFlg = true;
        }
        if(indto.getNextImpHosType() == null || indto.getNextImpHosType().isEmpty()) {
        	// 必須項目にデータを入力してください。（重点病院区分）
        	errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "重点病院区分") + "\n";
        	errFlg = true;
        }
        if(indto.getNextManageCd() == null || indto.getNextManageCd().isEmpty()) {
        	// 必須項目にデータを入力してください。（経営主体）
        	errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "経営主体") + "\n";
        	errFlg = true;
        }

        if("01".equals(indto.getNextInsRank()) || "02".equals(indto.getNextInsRank()) ||
        		"04".equals(indto.getNextInsRank()) || "05".equals(indto.getNextInsRank()) || "07".equals(indto.getNextInsRank())) {
        	if(indto.getNextBedCntBase() == null || indto.getNextBedCntBase().isEmpty()) {
            	// 必須項目にデータを入力してください。（基準）
            	errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "基準") + "\n";
            	errFlg = true;
            }
        	if(indto.getNextBedCnt04() == null || indto.getNextBedCnt04().isEmpty()) {
            	// 必須項目にデータを入力してください。（結核）
            	errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "結核") + "\n";
            	errFlg = true;
            }
        	if(indto.getNextBedCnt01() == null || indto.getNextBedCnt01().isEmpty()) {
            	// 必須項目にデータを入力してください。（一般）
            	errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "一般") + "\n";
            	errFlg = true;
            }
        	if(indto.getNextBedCnt05() == null || indto.getNextBedCnt05().isEmpty()) {
            	// 必須項目にデータを入力してください。（感染症）
            	errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "感染症") + "\n";
            	errFlg = true;
            }
        	if(indto.getNextBedCnt03() == null || indto.getNextBedCnt03().isEmpty()) {
            	// 必須項目にデータを入力してください。（精神）
            	errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "精神") + "\n";
            	errFlg = true;
            }
        	if(indto.getNextBedCnt07() == null || indto.getNextBedCnt07().isEmpty()) {
            	// 必須項目にデータを入力してください。（療養）
            	errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "療養") + "\n";
            	errFlg = true;
            }
        	if(indto.getNextBedCnt02() == null || indto.getNextBedCnt02().isEmpty()) {
            	// 必須項目にデータを入力してください。（医療療養）
            	errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "医療療養") + "\n";
            	errFlg = true;
            }
        	if(indto.getNextBedCnt06() == null || indto.getNextBedCnt06().isEmpty()) {
            	// 必須項目にデータを入力してください。（介護療養）
            	errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "介護療養") + "\n";
            	errFlg = true;
            }
        }

        // レングスチェック
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
		if(indto.getReqComment() != null && indto.getReqComment().length() > 300) {
        	// 最大文字数を超えています。（申請コメント）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "申請コメント") + "\n";
			errFlg = true;
        }
        if(indto.getAprMemo() != null && indto.getAprMemo().length() > 300) {
        	// 最大文字数を超えています。（審査・承認メモ）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "審査・承認メモ") + "\n";
			errFlg = true;
        }

        // 文字種チェック
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

		// 整合性チェック
		if("01".equals(indto.getNextInsRank()) || "02".equals(indto.getNextInsRank()) || "03".equals(indto.getNextInsRank())
				 || "04".equals(indto.getNextInsRank()) || "05".equals(indto.getNextInsRank()) || "06".equals(indto.getNextInsRank())
				 && !chkNumRange(indto.getNextBedsTot(), 0, 9999)){
			// 階級区分の範囲とベッド数計が一致するよう入力して下さい。
			errMsg += loginInfo.getMsgData(RdmConstantsData.W023) + "\n";
			errFlg = true;
		} else if("12".equals(indto.getNextInsRank()) || "13".equals(indto.getNextInsRank()) || "15".equals(indto.getNextInsRank())
				 && !"0".equals(indto.getNextBedsTot())){
			// 階級区分の範囲とベッド数計が一致するよう入力して下さい。
			errMsg += loginInfo.getMsgData(RdmConstantsData.W023) + "\n";
			errFlg = true;
		} else if("11".equals(indto.getNextInsRank()) || "14".equals(indto.getNextInsRank())
				 && !chkNumRange(indto.getNextBedsTot(), 1, 19)){
			// 階級区分の範囲とベッド数計が一致するよう入力して下さい。
			errMsg += loginInfo.getMsgData(RdmConstantsData.W023) + "\n";
			errFlg = true;
		} else if("07".equals(indto.getNextInsRank()) && !chkNumRange(indto.getNextBedsTot(), 100, 9999)){
			// 階級区分の範囲とベッド数計が一致するよう入力して下さい。
			errMsg += loginInfo.getMsgData(RdmConstantsData.W023) + "\n";
			errFlg = true;
		} else if("08".equals(indto.getNextInsRank()) && !chkNumRange(indto.getNextBedsTot(), 200, 9999)){
			// 階級区分の範囲とベッド数計が一致するよう入力して下さい。
			errMsg += loginInfo.getMsgData(RdmConstantsData.W023) + "\n";
			errFlg = true;
		} else if("09".equals(indto.getNextInsRank()) && !chkNumRange(indto.getNextBedsTot(), 20, 99)){
			// 階級区分の範囲とベッド数計が一致するよう入力して下さい。
			errMsg += loginInfo.getMsgData(RdmConstantsData.W023) + "\n";
			errFlg = true;
		} else if("10".equals(indto.getNextInsRank()) && !chkNumRange(indto.getNextBedsTot(), 20, 199)){
			// 階級区分の範囲とベッド数計が一致するよう入力して下さい。
			errMsg += loginInfo.getMsgData(RdmConstantsData.W023) + "\n";
			errFlg = true;
		} else if("16".equals(indto.getNextInsRank()) && !chkNumRange(indto.getNextBedsTot(), 20, 199)
					&& !("0".equals(indto.getNextBedCnt01()) && "0".equals(indto.getNextBedCnt07()) && "0".equals(indto.getNextBedCnt04())
							&& "0".equals(indto.getNextBedCnt05()) &&chkNumRange(indto.getNextBedCnt03(), 1, 9999))){
			// 階級区分の範囲とベッド数計が一致するよう入力して下さい。
			errMsg += loginInfo.getMsgData(RdmConstantsData.W023) + "\n";
			errFlg = true;
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
        	String title = "NF101_施設来期情報更新";
            indto.setTitle(title);
        	indto.setMsgStr(errMsg);
			outdto.setForward("NF101");
        	return outdto;
        }

/*
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
        	tRdmReqKnrInsData.setReqStsCd("01");
        	tRdmReqKnrInsData.setReqBrCd(indto.getReqBrCd());
        	tRdmReqKnrInsData.setReqDistCd(indto.getReqDistCd());
        	tRdmReqKnrInsData.setReqShzNm(indto.getReqShzNm());
        	tRdmReqKnrInsData.setReqJgiNo(indto.getReqJgiNo());
        	tRdmReqKnrInsData.setReqJgiName(indto.getReqJgiName());
        	tRdmReqKnrInsData.setReqComment(indto.getReqComment());
        	tRdmReqKnrInsData.setInsShaYmd(systemDate);
        	tRdmReqKnrInsData.setInsShaId(indto.getLoginJgiNo());
        	tRdmReqKnrInsData.setUpdShaYmd(systemDate);
        	tRdmReqKnrInsData.setUpdShaId(indto.getLoginJgiNo());

        	dao.insertByValue(tRdmReqKnrInsData);

        } else {
        	// 更新
        	TRdmReqKnrEntity tRdmReqKnrUpdData = new TRdmReqKnrEntity("updateNF011Data");
        	tRdmReqKnrUpdData.setReqId(reqId);
        	tRdmReqKnrUpdData.setReqStsCd("01");
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
        	tRdmHcoReqInsData.setInsPcode(indto.getInsPcode());
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
        	tRdmHcoReqInsData.setInsUrlYmd(indto.getInsUrlYmd().replace("-", ""));
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
        	tRdmHcoReqUpdData.setInsPcode(indto.getInsPcode());
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
        	tRdmHcoReqUpdData.setInsUrlYmd(indto.getInsUrlYmd().replace("-", ""));
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
*/

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
		outdto.setForward("NF309");
        return outdto;
    }

    /**
     * コンボ作成
     * @param indto NF309DTO
     * @return なし
     * @customizable
     */
    private void createCombo(NF309DTO indto){
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
     * @param indto NF309DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO register(NF309DTO indto) {
        BaseDTO outdto = indto;
        // START UOC
        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
        outdto.setForward("NF309");

        // 現在日付を取得
        Date systemDate = DateUtils.getNowDate();
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
        String sysDate = fmtDate.format(systemDate);
        SimpleDateFormat fmtDateTime = new SimpleDateFormat("yyyyMMddHHmmss");
        String sysDateTime = fmtDateTime.format(systemDate);

        boolean errFlg = false;
        String errMsg = "";

/*
        if(indto.getAprComment() != null && indto.getAprComment().length() > 300) {
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
*/

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

/*
		if("1".equals(indto.getFuncId())) {
			// 申請
			TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity("updateTRdmReqKnrData");

			tRdmReqKnrEntity.setReqId(indto.getReqId());
			if("1".equals(indto.getReqChl()) || "2".equals(indto.getReqChl())) {
				tRdmReqKnrEntity.setReqStsCd("03");
			} else if("3".equals(indto.getReqChl())) {
				tRdmReqKnrEntity.setReqStsCd("13");
			}

			tRdmReqKnrEntity.setReqBrCd(indto.getLoginBrCd());
        	tRdmReqKnrEntity.setReqDistCd(indto.getLoginDistCd());
        	tRdmReqKnrEntity.setReqShzNm(indto.getLoginShzNm());
        	tRdmReqKnrEntity.setReqJgiNo(Integer.parseInt(indto.getLoginJgiNo()));
        	tRdmReqKnrEntity.setReqJgiName(indto.getLoginNm());
        	tRdmReqKnrEntity.setReqYmdhms(sysDateTime);
        	tRdmReqKnrEntity.setReqComment(indto.getReqComment());

        	if(RdmConstantsData.RDM_JKN_ADMIN.equals(indto.getLoginJokenSetCd())) {
        		tRdmReqKnrEntity.setReqKngKbn("2");
        	} else {
        		tRdmReqKnrEntity.setReqKngKbn("1");
        	}

        	tRdmReqKnrEntity.setUpdShaYmd(systemDate);
        	tRdmReqKnrEntity.setUpdShaId(indto.getLoginJgiNo());

        	dao.update(tRdmReqKnrEntity);

		} else if("2".equals(indto.getFuncId())) {
			// 承認
			TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity("updateTRdmReqKnrData");

			tRdmReqKnrEntity.setReqId(indto.getReqId());
			if("1".equals(indto.getReqChl()) || "2".equals(indto.getReqChl())) {
				tRdmReqKnrEntity.setReqStsCd("04");
			} else if("3".equals(indto.getReqChl())) {
				tRdmReqKnrEntity.setReqStsCd("14");
			}

			tRdmReqKnrEntity.setAprBrCode(indto.getLoginBrCd());
        	tRdmReqKnrEntity.setAprDistCode(indto.getLoginDistCd());
        	tRdmReqKnrEntity.setAprShz(indto.getLoginShzNm());
        	tRdmReqKnrEntity.setAprJgiNo(Integer.parseInt(indto.getLoginJgiNo()));
        	tRdmReqKnrEntity.setAprShaName(indto.getLoginNm());
        	tRdmReqKnrEntity.setAprYmdhms(sysDateTime);
        	tRdmReqKnrEntity.setAprComment(indto.getAprComment());

        	if("on".equals(indto.getFbReqFlg())) {
        		tRdmReqKnrEntity.setFbReqFlg("1");
        	} else {
        		tRdmReqKnrEntity.setFbReqFlg("0");
        	}

        	tRdmReqKnrEntity.setUpdShaYmd(systemDate);
        	tRdmReqKnrEntity.setUpdShaId(indto.getLoginJgiNo());

        	dao.update(tRdmReqKnrEntity);

		} else if("3".equals(indto.getFuncId())) {
			// 却下
			TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity("updateTRdmReqKnrData");

			tRdmReqKnrEntity.setReqId(indto.getReqId());
			if("1".equals(indto.getReqChl()) || "2".equals(indto.getReqChl())) {
				tRdmReqKnrEntity.setReqStsCd("02");
			} else if("3".equals(indto.getReqChl())) {
				tRdmReqKnrEntity.setReqStsCd("12");
			}

			tRdmReqKnrEntity.setAprBrCode(indto.getLoginBrCd());
        	tRdmReqKnrEntity.setAprDistCode(indto.getLoginDistCd());
        	tRdmReqKnrEntity.setAprShz(indto.getLoginShzNm());
        	tRdmReqKnrEntity.setAprJgiNo(Integer.parseInt(indto.getLoginJgiNo()));
        	tRdmReqKnrEntity.setAprShaName(indto.getLoginNm());
        	tRdmReqKnrEntity.setAprYmdhms(sysDateTime);
        	tRdmReqKnrEntity.setAprComment(indto.getAprComment());

        	tRdmReqKnrEntity.setUpdShaYmd(systemDate);
        	tRdmReqKnrEntity.setUpdShaId(indto.getLoginJgiNo());

        	dao.update(tRdmReqKnrEntity);
		}

*/

    	outdto.setForward("NC101");

		// END UOC
		return outdto;
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
}
