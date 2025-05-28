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
import java.util.LinkedHashMap;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.common.BeanUtil;
import jp.co.takeda.rdm.util.StringUtils;
import jp.co.takeda.rdm.entity.join.SelectTmrEntity;
import jp.co.takeda.rdm.entity.join.SeqRdmReqIdEntity;
import jp.co.takeda.rdm.entity.join.TRdmHcpKmuReqEntity;
import jp.co.takeda.rdm.dto.ND101DTO;
import jp.co.takeda.rdm.dto.ND307DTO;
import jp.co.takeda.rdm.entity.join.TRdmReqKnrEntity;
import jp.co.takeda.rdm.entity.join.SelectDocReqKnrInsChangeCheckEntity;
import jp.co.takeda.rdm.entity.join.SelectDocReqKnrInsChangeEntity;
import jp.co.takeda.rdm.entity.join.SelectHenkanListEntity;
import jp.co.takeda.rdm.entity.join.SelectNd101ComboListEntity;
import jp.co.takeda.rdm.entity.join.SelectNd101MainDataEntity;
import jp.co.takeda.rdm.entity.join.SelectNd101YakushokuComboListEntity;
import jp.co.takeda.rdm.entity.join.SelectNd307ParamSwitchEntity;
import jp.co.takeda.rdm.entity.join.SelectParamSwitchEntity;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.DateUtils;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * Serviceクラス（ND307)
 * @generated
 */
@Named
public class ND307Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(ND307Service.class);

    /**
     * イベント処理
     * @param indto ND307DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(ND307DTO indto) {
		BaseDTO outdto = indto;
		// 1-1 権限判定
		LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

		String reqId = indto.getReqId();
		boolean errFlg = false;
		String errMsg = "";
		String alertErrMsg = "";
		String alertErrMsg2 = "";
		setCombo(indto);
		indto.setTitlePostTitleKj(StringUtils.nvl(indto.getYakushokuCombo().get(indto.getPostTitleCode()), ""));
		indto.setKmuPostCodeKanj(StringUtils.nvl(indto.getJobFormCombo().get(indto.getPostJobForm()), ""));
		indto.setYakushinPostCodeKanj(StringUtils.nvl(indto.getDccCombo().get(indto.getPostDcc()), ""));
		if(indto.getPostUnivPosCode() != null) {
			indto.setUnivPostTitleKj(StringUtils.nvl(indto.getDigakuShokuiCombo().get(indto.getPostUnivPosCode()), ""));
		} else {
			indto.setUnivPostTitleKj("");
		}
		if(!StringUtils.isEmpty(indto.getSelectDay())) {
			indto.setDispTekiyoYmd(indto.getSelectDay());
		}
		if(loginInfo.getJokenSetCd().equals(RdmConstantsData.RDM_JKN_ADMIN)) {
			indto.setFbReqFlg(true);//初期値はチェックON
		}
////		// 必須入力チェック
////		if (indto.getReqType().equals("42") || indto.getMovemedEditFlg().equals("0")) {
////			if (indto.getPostInsNo() == null || indto.getPostInsNo().isEmpty()) {
////				// 必須項目にデータを入力してください。（異動先施設）
////				errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "異動先施設") + "\n";
////				errFlg = true;
////			}
////		}
////		if (indto.getPostDeptCode() == null || indto.getPostDeptCode().isEmpty()) {
////			// 必須項目にデータを入力してください。（異動先所属部科）
////			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "異動先所属部科") + "\n";
////			errFlg = true;
////		}
////		if (indto.getYakushoku() == null || indto.getYakushoku().isEmpty()) {
////			// 必須項目にデータを入力してください。（役職）
////			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "役職") + "\n";
////			errFlg = true;
////		}
////
////		// 医療機関への異動の場合
////		if (StringUtils.isEmpty(indto.getPreHoInsType())) {
////			if (indto.getPostHoInsType().equals("1") && indto.getPostInsClass().equals("01")) {
////				if (indto.getPostUnivPosCode() == null || indto.getPostUnivPosCode().isEmpty()) {
////					// 勤務先が大学附属病院の場合、大学職位を入力してください。
////					errMsg += loginInfo.getMsgData(RdmConstantsData.W031) + "\n";
////					errFlg = true;
////				}
////			}
////			// 勤務先情報更新の場合
////		} else {
////			if (indto.getPreHoInsType().equals("1") && indto.getPreInsClass().equals("01")) {
////				if (indto.getPostUnivPosCode() == null || indto.getPostUnivPosCode().isEmpty()) {
////					// 勤務先が大学附属病院の場合、大学職位を入力してください。
////					errMsg += loginInfo.getMsgData(RdmConstantsData.W031) + "\n";
////					errFlg = true;
////				}
////			}
////		}
//
//		// レングスチェック
//        if(indto.getReqComment() != null && indto.getReqComment().length() > 300) {
//        	// 最大文字数を超えています。（申請コメント）
//			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "申請コメント") + "\n";
//			errFlg = true;
//        }
//
//		// 整合性チェック
//		// 同じ医師で同じ施設に対しての申請がすでに存在している場合
//
//		SelectNd101MainDataEntity paramEntity = new SelectNd101MainDataEntity();
//		paramEntity.setSqlId("selectNd101DupData");
//		paramEntity.setInDocNo(indto.getDocNo());
//		paramEntity.setInInsNo(indto.getPreInsNo());
//		List<SelectNd101MainDataEntity> mainDataEntityList = dao.select(paramEntity);
//		if (mainDataEntityList.size() > 0) {
//			// 重複する申請が行われています。（医師コード）
//			errMsg += loginInfo.getMsgData(RdmConstantsData.W008).replace("項目名", "医師コード") + "\n";
//			errFlg = true;
//		}
//
//		// 適用日が翌営業日以降ではない場合
//		if (indto.getSelectDay() != null && !indto.getSelectDay().isEmpty()) {
//			// 翌日日付_RDM用カレンダー(オンライン用)_生成用エンティティ
//			SelectTmrEntity selectTmrEntity = new SelectTmrEntity();
//
//			// 翌日日付_RDM用カレンダー(オンライン用)の帳票一覧を取得する
//			List<SelectTmrEntity> selectTmrList = dao.select(selectTmrEntity);
//
//			// SimpleDateFormatで日付フォーマット設定
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			// 翌日日付データ_取り出す（リストの[0]を取得)
//			for (SelectTmrEntity entity : selectTmrList) {
//				// 検索結果_翌日日付
//				indto.setTekiyoInitDay(sdf.format(entity.getCalDate()));
//			}
//			String tempNextBizDay = indto.getTekiyoInitDay().replace("-", "");
//			String tempTekiyoYmd = indto.getSelectDay().replace("-", "");
//
//			Integer nextBizDay = Integer.parseInt(tempNextBizDay);
//			Integer tekiyoYmd = Integer.parseInt(tempTekiyoYmd);
//
//			if (tekiyoYmd < nextBizDay) {
//				// 適用日は翌営業日以降を指定してください。
//				errMsg += loginInfo.getMsgData(RdmConstantsData.W007) + "\n";
//				errFlg = true;
//			}
//		}
//
////		// 所属部科を指定する場合に施設を指定しているか
////		if (indto.getReqType().equals("42") || indto.getMovemedEditFlg().equals("0")) {
////			if (!(StringUtils.isEmpty(indto.getPostDeptCode()))) {
////				if (StringUtils.isEmpty(indto.getPostInsNo())) {
////					// 所属部科を選択する場合は施設も選択してください。
////					errMsg += loginInfo.getMsgData(RdmConstantsData.W027) + "\n";
////					errFlg = true;
////				}
////			}
////		}
//
//		// 整合性チェック
//		// 申請時に既に医師削除申請がされている場合
//		if(!indto.getAlertIgnore().equals("1")) {
//			SelectNd101MainDataEntity paramEntity2 = new SelectNd101MainDataEntity();
//			paramEntity2.setSqlId("selectNd101DelData");
//			paramEntity2.setInDocNo(indto.getDocNo());
//			List<SelectNd101MainDataEntity> mainDataEntityList2 = dao.select(paramEntity2);
//			if (mainDataEntityList2.size() > 0) {
//				// 廃業・死亡の申請がされています。よろしいですか？
//				alertErrMsg2 += loginInfo.getMsgData(RdmConstantsData.I010) + "\n";
//				errFlg = true;
//			}
//		}
//
//		// 排他チェック
//		// 最終更新日時が、画面OPEN時とボタン押下時で異なっていた場合
//		if (indto.getUpdShaYmd() != null && !indto.getUpdShaYmd().equals("")) {
//			TRdmReqKnrEntity tRdmReqKnrChkEntity = new TRdmReqKnrEntity("selectNd101DateChkData");
//			tRdmReqKnrChkEntity.setReqId(reqId);
//
//			List<TRdmReqKnrEntity> tRdmReqKnrEntityList = dao.select(tRdmReqKnrChkEntity);
//
//			if (tRdmReqKnrEntityList.size() > 0) {
//				SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//				Date updDate = null;
//				try {
//					updDate = sdFormat.parse(indto.getUpdShaYmd());
//				} catch (ParseException e) {
//					// TODO 自動生成された catch ブロック
//					e.printStackTrace();
//				}
//				if (!tRdmReqKnrEntityList.get(0).getUpdShaYmd().equals(updDate)) {
//					// 既に他のユーザーによってデータが処理されています。
//					errMsg += loginInfo.getMsgData(RdmConstantsData.E003) + "\n";
//					errFlg = true;
//
//				}
//			}
//		}
//
//
//        // エラー時処理
//        if(errFlg) {
//        	indto.setAlertMsgStr(alertErrMsg);
//        	indto.setAlertMsgStr2(alertErrMsg2);
//        	indto.setAlertIgnore("0");
//        	indto.setMsgStr(errMsg);
//        	setCombo(indto, errFlg);
//
//			if (!(StringUtils.isEmpty(indto.getSelectDay()))) {
//				SelectHenkanListEntity haifunHenkan = new SelectHenkanListEntity("ハイフン除去");
//				haifunHenkan.setSearchHenkan(indto.getSelectDay());
//				List<SelectHenkanListEntity> selectHaifun = dao.select(haifunHenkan);
//				indto.setSelectDay(selectHaifun.get(0).getSearchHenkan());
//			}
//			String tempDispTekiyoYmd = indto.getSelectDay();
//
//			indto.setDispTekiyoYmd(tempDispTekiyoYmd.substring(0,4) + "-" + tempDispTekiyoYmd.substring(4,6) + "-" +  tempDispTekiyoYmd.substring(6,8));
//        	indto.setTempReqBtnFlg("1");
//        	indto.setTitle("ND101_医療機関への異動");
//        	outdto.setForward("ND101");
//        	return outdto;
//        }
//
//
//
//     // 現在日付を取得
//        Date systemDate = DateUtils.getNowDate();
//        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
//        String sysDate = fmtDate.format(systemDate);
//
//        // 申請ステータスを「01：保存済」として各テーブルに画面の申請情報を登録
//        // 申請管理
//        TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity();
//        tRdmReqKnrEntity.setReqId(StringUtils.nvl(indto.getReqId(), ""));
//        TRdmReqKnrEntity tRdmReqKnrData = dao.selectByPK(tRdmReqKnrEntity);
//
//        if(tRdmReqKnrData == null) {
//        	// 新規登録
//        	SeqRdmReqIdEntity seqRdmReqIdEntity = new SeqRdmReqIdEntity();
//        	List<SeqRdmReqIdEntity> seqRdmReqIdDate = dao.select(seqRdmReqIdEntity);
//        	reqId = seqRdmReqIdDate.get(0).getReqId();
//
//        	// レコードを登録
//        	TRdmReqKnrEntity tRdmReqKnrInsData = new TRdmReqKnrEntity();
//        	tRdmReqKnrInsData.setReqId(reqId);
//        	if("1".equals(indto.getMrAdminFlg())) {
//        		// 承認者（管理者権限）が申請の場合、'2'(DSG起因)
//        		tRdmReqKnrInsData.setReqChl("2");
//        		tRdmReqKnrInsData.setReqKngKbn("2");
//        	} else {
//        		// "MRが申請の場合、'1'(MR起因)
//        		tRdmReqKnrInsData.setReqChl("1");
//        		tRdmReqKnrInsData.setReqKngKbn("1");
//        	}
//
//        	if("0".equals(indto.getMovemedEditFlg())) {
//        		tRdmReqKnrInsData.setReqType("42");
//        	}else {
//        		tRdmReqKnrInsData.setReqType("51");
//        	}
//
//        	tRdmReqKnrInsData.setReqStsCd("01");
//
//	        String tekiyoYmd = indto.getSelectDay().replace("-", "");
//        	indto.setSelectDay(tekiyoYmd);
//
//
//        	tRdmReqKnrInsData.setTekiyoYmd(indto.getSelectDay());
//        	//医薬支店C     brCode
//        	tRdmReqKnrInsData.setReqBrCd(loginInfo.getBrCode());
//        	//医薬営業所C   distCode
//        	tRdmReqKnrInsData.setReqDistCd(loginInfo.getDistCode());
//        	//組織名称      bumonRyakuName
//        	tRdmReqKnrInsData.setReqShzNm(loginInfo.getBumonRyakuName());
//
//        	tRdmReqKnrInsData.setReqJgiNo(loginInfo.getJgiNo());
//        	tRdmReqKnrInsData.setReqJgiName(loginInfo.getJgiName());
//        	tRdmReqKnrInsData.setReqComment(indto.getReqComment());
//        	tRdmReqKnrInsData.setDocNo(indto.getDocNo());
//        	tRdmReqKnrInsData.setInsNo(indto.getInsNo());
//        	tRdmReqKnrInsData.setInsShaYmd(systemDate);
//        	tRdmReqKnrInsData.setInsShaYmd(systemDate);
//        	tRdmReqKnrInsData.setInsShaId(Integer.toString(loginInfo.getJgiNo()));
//        	tRdmReqKnrInsData.setUpdShaYmd(systemDate);
//        	tRdmReqKnrInsData.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));
//
//        	dao.insertByValue(tRdmReqKnrInsData);
//
//        }else {
//        	TRdmReqKnrEntity tRdmReqKnrUpdData = new TRdmReqKnrEntity("updateND101Data");
//        	tRdmReqKnrUpdData.setReqId(reqId);
//
//
//        	tRdmReqKnrUpdData.setReqStsCd(tRdmReqKnrData.getReqStsCd());
//        	SelectHenkanListEntity haifunHenkan = new SelectHenkanListEntity("ハイフン除去");
//        	haifunHenkan.setSearchHenkan(indto.getSelectDay());
//        	List<SelectHenkanListEntity> selectHaifun = dao.select(haifunHenkan);
//        	indto.setSelectDay(selectHaifun.get(0).getSearchHenkan());
//
//        	String tekiyoYmd = indto.getSelectDay();
//        	tRdmReqKnrUpdData.setTekiyoYmd(tekiyoYmd);
//        	tRdmReqKnrUpdData.setReqComment(indto.getReqComment());
//        	tRdmReqKnrUpdData.setUpdShaYmd(systemDate);
//        	tRdmReqKnrUpdData.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));
//
//        	dao.update(tRdmReqKnrUpdData);
//        }
//
//        // 勤務先_申請管理
//        TRdmHcpKmuReqEntity tRdmHcpKmuReqEntity = new TRdmHcpKmuReqEntity();
//        tRdmHcpKmuReqEntity.setReqId(indto.getReqId());
//        TRdmHcpKmuReqEntity tRdmHcpKmuReqData = dao.selectByPK(tRdmHcpKmuReqEntity);
//
//
//        if(tRdmHcpKmuReqData == null) {
//        	TRdmHcpKmuReqEntity tRdmHcpKmuReqInsData = new TRdmHcpKmuReqEntity();
//        	tRdmHcpKmuReqInsData.setReqId(reqId);
//        	tRdmHcpKmuReqInsData.setDocNo(indto.getDocNo());
//        	tRdmHcpKmuReqInsData.setInsNoMt(indto.getPreInsNo());
//
//        	if(indto.getReqType().equals("42") || indto.getMovemedEditFlg().equals("0")  ) {
//        		//異動申請の場合のみ異動先施設を登録
//        		tRdmHcpKmuReqInsData.setInsNoSk(StringUtils.nvl(indto.getPostInsNo(), "Z"));
//        	}else {
//        		//勤務先情報更新の場合は所属している勤務先を登録
//        		tRdmHcpKmuReqInsData.setInsNoSk(indto.getPreInsNo());
//        	}
//        	tRdmHcpKmuReqInsData.setJobFormBf(StringUtils.nvl(indto.getPreJobForm(), "Z"));
//        	tRdmHcpKmuReqInsData.setDeptCodeBf(StringUtils.nvl(indto.getPreDeptCode(), "Z"));
//        	tRdmHcpKmuReqInsData.setDeptKanjiBf(StringUtils.nvl(indto.getPreDeptKj(), "Z"));
//        	tRdmHcpKmuReqInsData.setDeptKanaBf(StringUtils.nvl(indto.getPreDeptKn(), "Z"));
//        	tRdmHcpKmuReqInsData.setUnivPosCodeBf(indto.getPreUnivPosCode());
//        	tRdmHcpKmuReqInsData.setTitleCodeBf(indto.getPreTitleCode());
//        	tRdmHcpKmuReqInsData.setDccTypeBf(indto.getPreDcc());
//        	tRdmHcpKmuReqInsData.setJobFormAf(StringUtils.nvl(indto.getJobForm(), "Z"));
//        	tRdmHcpKmuReqInsData.setDeptCodeAf(StringUtils.nvl(indto.getPostDeptCode(), "Z"));
//        	tRdmHcpKmuReqInsData.setDeptKanjiAf(StringUtils.nvl(indto.getPostDeptKj(), "Z"));
//        	tRdmHcpKmuReqInsData.setDeptKanaAf(StringUtils.nvl(indto.getPostDeptKn(), "Z"));
//        	tRdmHcpKmuReqInsData.setUnivPosCodeAf(indto.getDigakuShokui());
//        	tRdmHcpKmuReqInsData.setTitleCodeAf(indto.getYakushoku());
//        	tRdmHcpKmuReqInsData.setDccTypeAf(indto.getDcc());
//        	tRdmHcpKmuReqInsData.setUltDocNo(indto.getUltDocNo());
//        	if(indto.getPreUltInsNo().equals(indto.getPostUltInsNo())) {
//        		tRdmHcpKmuReqInsData.setUltInsNo(null);
//        	}else if(indto.getPostUltInsNo() == null){
//        		tRdmHcpKmuReqInsData.setUltInsNo("Z");
//        	}else {
//        		tRdmHcpKmuReqInsData.setUltInsNo(indto.getPostUltInsNo());
//        	}
//        	tRdmHcpKmuReqInsData.setInsShaYmd(systemDate);
//        	tRdmHcpKmuReqInsData.setInsShaId(Integer.toString(loginInfo.getJgiNo()));
//        	tRdmHcpKmuReqInsData.setUpdShaYmd(systemDate);
//        	tRdmHcpKmuReqInsData.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));
//
//        	dao.insertByValue(tRdmHcpKmuReqInsData);
//        }else {
//        	SelectDocReqKnrInsChangeEntity selectDocReqKnrInsChangeEntity = new SelectDocReqKnrInsChangeEntity();
//        	selectDocReqKnrInsChangeEntity.setInReqFlg(0);
//        	selectDocReqKnrInsChangeEntity.setInDocNo(indto.getDocNo());
//        	selectDocReqKnrInsChangeEntity.setInInsNo(indto.getInsNo());
//        	List<SelectDocReqKnrInsChangeEntity> selectDocReqKnrInsChangeList = dao.select(selectDocReqKnrInsChangeEntity);
//        	String tempUltDocNo;
//        	if (CollectionUtils.isEmpty(selectDocReqKnrInsChangeList)) {
//        		tempUltDocNo = "Z";
//        	}else {
//        		tempUltDocNo = selectDocReqKnrInsChangeList.get(0).getUltDocNo();
//        	}
//
//
//
//        	TRdmHcpKmuReqEntity tRdmHcpKmuReqUpdData = new TRdmHcpKmuReqEntity("updateND101Data");
//        	tRdmHcpKmuReqUpdData.setReqId(reqId);
//        	tRdmHcpKmuReqUpdData.setInsNoSk(StringUtils.nvl(indto.getPostInsNo(), "Z"));
//        	tRdmHcpKmuReqUpdData.setJobFormAf(StringUtils.nvl(indto.getJobForm(), "Z"));
//        	tRdmHcpKmuReqUpdData.setDeptCodeAf(StringUtils.nvl(indto.getPostDeptCode(), "Z"));
//        	tRdmHcpKmuReqUpdData.setDeptKanjiAf(StringUtils.nvl(indto.getPostDeptKj(), "Z"));
//        	tRdmHcpKmuReqUpdData.setDeptKanaAf(StringUtils.nvl(indto.getPostDeptKn(), "Z"));
//        	tRdmHcpKmuReqUpdData.setUnivPosCodeAf(StringUtils.nvl(indto.getDigakuShokui(),""));
//        	tRdmHcpKmuReqUpdData.setTitleCodeAf(StringUtils.nvl(indto.getYakushoku(),""));
//        	tRdmHcpKmuReqUpdData.setDccTypeAf(StringUtils.nvl(indto.getDcc(),""));
//        	tRdmHcpKmuReqUpdData.setUltDocNo(tempUltDocNo);
//        	if(indto.getPreUltInsNo().equals(indto.getPostUltInsNo()) || indto.getPostUltInsNo() == null) {
//        		tRdmHcpKmuReqUpdData.setUltInsNo(indto.getPreUltInsNo());
//        	}else {
//        		tRdmHcpKmuReqUpdData.setUltInsNo("Z");
//        	}
//        	tRdmHcpKmuReqUpdData.setUpdShaYmd(systemDate);
//        	tRdmHcpKmuReqUpdData.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));
//
//
//        	dao.update(tRdmHcpKmuReqUpdData);
//        }
//
//        SelectDocReqKnrInsChangeCheckEntity selectDocReqKnrInsChangeCheckEntity = new SelectDocReqKnrInsChangeCheckEntity();
//
//        selectDocReqKnrInsChangeCheckEntity.setInReqId(reqId);
//        List<SelectDocReqKnrInsChangeCheckEntity> selectDocReqKnrInsChangeCheckList = dao.select(selectDocReqKnrInsChangeCheckEntity);
//
//		//ヘッダ部
//		indto.setReqId(StringUtils.nvl(selectDocReqKnrInsChangeCheckList.get(0).getReqId(), "-"));
//		indto.setReqShz(selectDocReqKnrInsChangeCheckList.get(0).getReqShz());
//		indto.setReqStsNm(StringUtils.nvl(selectDocReqKnrInsChangeCheckList.get(0).getReqStsNm(), "-"));
//		indto.setReqSts(selectDocReqKnrInsChangeCheckList.get(0).getReqSts());
//		indto.setReqJgiName(selectDocReqKnrInsChangeCheckList.get(0).getReqJgiName());
//		indto.setReqYmdhms(StringUtils.nvl(selectDocReqKnrInsChangeCheckList.get(0).getReqYmdhms(), "-"));
//		//ヘッダ部隠し項目
//		indto.setReqJgiNo(selectDocReqKnrInsChangeCheckList.get(0).getReqJgiNo());
//		indto.setReqBrCode(selectDocReqKnrInsChangeCheckList.get(0).getReqBrCode());
//		indto.setReqDistCode(selectDocReqKnrInsChangeCheckList.get(0).getReqDistCode());
//		indto.setUpdShaYmd(selectDocReqKnrInsChangeCheckList.get(0).getUpdShaYmd());
//
//		//隠し項目（変更後）
//		indto.setPostInsNo(selectDocReqKnrInsChangeCheckList.get(0).getPostInsNo());
//		indto.setPostUltInsNo(selectDocReqKnrInsChangeCheckList.get(0).getPostUltInsNo());
//		indto.setPostDeptCode(selectDocReqKnrInsChangeCheckList.get(0).getPostDeptCode());
//		indto.setPostDeptKn(selectDocReqKnrInsChangeCheckList.get(0).getPostDeptKn());
//		indto.setPostTitleCode(selectDocReqKnrInsChangeCheckList.get(0).getPostTitleCode());
//		indto.setPostJobForm(selectDocReqKnrInsChangeCheckList.get(0).getPostJobForm());
//		indto.setPostDcc(selectDocReqKnrInsChangeCheckList.get(0).getPostDcc());
//		indto.setPostUnivPosCode(selectDocReqKnrInsChangeCheckList.get(0).getPostUnivPosCode());
//
//		//基本情報
//    	indto.setDocKanj(StringUtils.nvl(selectDocReqKnrInsChangeCheckList.get(0).getDocKanj(), "-"));
//
//    	//基本情報隠し項目
//        indto.setDocNo(selectDocReqKnrInsChangeCheckList.get(0).getDocNo());
//        indto.setUltDocNo(selectDocReqKnrInsChangeCheckList.get(0).getUltDocNo());
//        indto.setPreHoInsType(StringUtils.nvl(selectDocReqKnrInsChangeCheckList.get(0).getPreHoInsType(),""));
//        indto.setPostHoInsType(StringUtils.nvl(selectDocReqKnrInsChangeCheckList.get(0).getPostHoInsType(),""));
//
//
//    	//勤務情報（変更前）
//    	indto.setPreInsAbbrName(StringUtils.nvl(selectDocReqKnrInsChangeCheckList.get(0).getPreInsAbbrName(), "-"));
//		indto.setPreDeptKj(StringUtils.nvl(selectDocReqKnrInsChangeCheckList.get(0).getPreDeptKj(), "-"));
//		indto.setTitlePreTitleKj(StringUtils.nvl(selectDocReqKnrInsChangeCheckList.get(0).getTitlePreTitleKj(), "-"));
//		indto.setKmuPreCodeKanj(StringUtils.nvl(selectDocReqKnrInsChangeCheckList.get(0).getKmuPreCodeKanj(), "-"));
//		indto.setYakushinPreCodeKanj(StringUtils.nvl(selectDocReqKnrInsChangeCheckList.get(0).getYakushinPreCodeKanj(), "-"));
//		indto.setUnivPreTitleKj(StringUtils.nvl(selectDocReqKnrInsChangeCheckList.get(0).getUnivPreTitleKj(), "-"));
//
//		//隠し項目（変更前）
//		indto.setPreInsNo(selectDocReqKnrInsChangeCheckList.get(0).getPreInsNo());
//		indto.setPreUltInsNo(selectDocReqKnrInsChangeCheckList.get(0).getPreUltInsNo());
//		indto.setPreDeptCode(selectDocReqKnrInsChangeCheckList.get(0).getPreDeptCode());
//		indto.setPreDeptKn(selectDocReqKnrInsChangeCheckList.get(0).getPreDeptKn());
//		indto.setPreTitleCode(selectDocReqKnrInsChangeCheckList.get(0).getPreTitleCode());
//		indto.setPreJobForm(selectDocReqKnrInsChangeCheckList.get(0).getPreJobForm());
//		indto.setPreDcc(selectDocReqKnrInsChangeCheckList.get(0).getPreDcc());
//		indto.setPreUnivPosCode(selectDocReqKnrInsChangeCheckList.get(0).getPreUnivPosCode());
//
//		//異動区分　画面表示の切替に使用
//		indto.setTrnKbn(selectDocReqKnrInsChangeCheckList.get(0).getTrnKbn());
//
//		//勤務情報（変更後）
//		indto.setPostInsAbbrName(StringUtils.nvl(selectDocReqKnrInsChangeCheckList.get(0).getPostInsAbbrName(),"-"));
//		indto.setPostDeptKj(StringUtils.nvl(selectDocReqKnrInsChangeCheckList.get(0).getPostDeptKj(), "-"));
//		indto.setTitlePostTitleKj(StringUtils.nvl(selectDocReqKnrInsChangeCheckList.get(0).getTitlePostTitleKj(),"-"));
//		indto.setKmuPostCodeKanj(StringUtils.nvl(selectDocReqKnrInsChangeCheckList.get(0).getKmuPostCodeKanj(),"-"));
//		indto.setYakushinPostCodeKanj(StringUtils.nvl(selectDocReqKnrInsChangeCheckList.get(0).getYakushinPostCodeKanj(),"-"));
//		indto.setUnivPostTitleKj(StringUtils.nvl(selectDocReqKnrInsChangeCheckList.get(0).getUnivPostTitleKj(),"-"));
//		String tempTekiyoDay = selectDocReqKnrInsChangeCheckList.get(0).getTekiyoYmd();
//		tempTekiyoDay = tempTekiyoDay.substring(0,4) + "/" +  tempTekiyoDay.substring(4,6) + "/" + tempTekiyoDay.substring(6,8);
//		indto.setDispTekiyoYmd(StringUtils.nvl(tempTekiyoDay,indto.getTekiyoInitDay()));
//
//		//コメント
//		indto.setReqComment(StringUtils.nvl(selectDocReqKnrInsChangeCheckList.get(0).getReqComment(), ""));
//		indto.setAprComment(StringUtils.nvl(selectDocReqKnrInsChangeCheckList.get(0).getAprComment(), ""));
//
//		//追加隠し項目
//		indto.setReqChl(selectDocReqKnrInsChangeCheckList.get(0).getReqChl());
//
		SelectNd307ParamSwitchEntity paramEntity3 = new SelectNd307ParamSwitchEntity();
		List<SelectNd307ParamSwitchEntity> selectParamSwitchIshiList3;
		selectParamSwitchIshiList3 = dao.select(paramEntity3);
		SelectNd307ParamSwitchEntity paramSwitch = selectParamSwitchIshiList3.get(0);
		//承認ボタン
		if (indto.getMrAdminFlg().equals("0")) {
			if (StringUtils.isEmpty(indto.getReqSts()) || indto.getReqSts().equals("01")) {
				indto.setNd307AppdFlg("1");
				if (paramSwitch.getKmuFlg().equals("1") && paramSwitch.getDocFlg().equals("1")) {
					indto.setNd307AppdActiveFlg("1");
				} else {
					indto.setNd307AppdActiveFlg("0");
				}
			} else {
				indto.setNd307AppdFlg("0");
				indto.setNd307AppdActiveFlg("0");
			}
		} else {
			if (StringUtils.isEmpty(indto.getReqSts()) || indto.getReqSts().equals("01") || indto.getReqSts().equals("11") ) {
				indto.setNd307AppdFlg("1");
				if (paramSwitch.getKmuFlg().equals("1") && paramSwitch.getDocFlg().equals("1")) {
					indto.setNd307AppdActiveFlg("1");
				} else {
					indto.setNd307AppdActiveFlg("0");
				}
			} else {
				indto.setNd307AppdFlg("0");
				indto.setNd307AppdActiveFlg("0");
			}
		}

		//却下/承認ボタン
		if(indto.getMrAdminFlg().equals("1")) {
			if(indto.getReqSts().equals("03") || indto.getReqSts().equals("13")) {
				indto.setNd307RejectFlg("1");
				if(paramSwitch.getKmuFlg().equals("1") && paramSwitch.getDocFlg().equals("1")) {
					indto.setNd307RejectActiveFlg("1");
				}else {
					indto.setNd307RejectActiveFlg("0");
				}
			}
		}else {
			indto.setNd307RejectFlg("0");
			indto.setNd307RejectActiveFlg("0");
		}

		indto.setDispTekiyoYmd(indto.getDispTekiyoYmd().replace("-", "/"));

        return outdto;
    }

    /**
     * イベント処理
     * @param indto NF311DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO register(ND307DTO indto) {
    	BaseDTO outdto = indto;

    	LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

        // 現在日付を取得
        Date systemDate = DateUtils.getNowDate();
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
        String sysDate = fmtDate.format(systemDate);
        SimpleDateFormat fmtDateTime = new SimpleDateFormat("yyyyMMddHHmmss");
        String sysDateTime = fmtDateTime.format(systemDate);

        boolean errFlg = false;
        String errMsg = "";
        String reqId = indto.getReqId();
//		// 整合性チェック
//		//同じ医師で同じ施設に対しての申請がすでに存在している場合
//
//		SelectNd101MainDataEntity paramEntity =new SelectNd101MainDataEntity();
//		paramEntity.setSqlId("selectNd101DupData");
//		paramEntity.setInDocNo(indto.getDocNo());
//		paramEntity.setInInsNo(indto.getPreInsNo());
//		List<SelectNd101MainDataEntity> mainDataEntityList = dao.select(paramEntity);
//		if(mainDataEntityList.size() > 0) {
//			//重複する申請が行われています。（医師コード）
//			errMsg += loginInfo.getMsgData(RdmConstantsData.W008).replace("項目名", "医師コード") + "\n";
//			errFlg = true;
//		}
//
//		// 整合性チェック
//		// 既に勤務先が異動申請されている場合
//
//		SelectNd101MainDataEntity paramEntity2 =new SelectNd101MainDataEntity();
//		paramEntity2.setSqlId("selectNd101DupKmuData");
//		paramEntity2.setInDocNo(indto.getDocNo());
//		paramEntity2.setInInsNo(indto.getPreInsNo());
//		List<SelectNd101MainDataEntity> mainDataEntityList2 = dao.select(paramEntity2);
//		if(mainDataEntityList2.size() > 0) {
//			//既に勤務先が異動申請されているため申請できません。
//			errMsg += loginInfo.getMsgData(RdmConstantsData.W032) + "\n";
//			errFlg = true;
//		}
//
//
//		// 排他チェック
//        // 最終更新日時が、画面OPEN時とボタン押下時で異なっていた場合
//        if(indto.getUpdShaYmd() != null && !indto.getUpdShaYmd().equals("")) {
//        	TRdmReqKnrEntity tRdmReqKnrChkEntity = new TRdmReqKnrEntity("selectNd101DateChkData");
//        	tRdmReqKnrChkEntity.setReqId(indto.getReqId());
//
//        	List<TRdmReqKnrEntity> tRdmReqKnrEntityList = dao.select(tRdmReqKnrChkEntity);
//
//        	if(tRdmReqKnrEntityList.size() > 0) {
//        		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        		Date updDate = null;
//                try {
//					updDate = sdFormat.parse(indto.getUpdShaYmd());
//				} catch (ParseException e) {
//					// TODO 自動生成された catch ブロック
//					e.printStackTrace();
//				}
//        		if(!tRdmReqKnrEntityList.get(0).getUpdShaYmd().equals(updDate)) {
//        			// 既に他のユーザーによってデータが処理されています。
//        			errMsg += loginInfo.getMsgData(RdmConstantsData.E003) + "\n";
//    	        	errFlg = true;
//
//        		}
//        	}
//        }
//
//		// エラー時処理
//		if (errFlg) {
//			indto.setMsgStr(errMsg);
//			indto.setTempReqBtnFlg("1");
//			return outdto;
//		}
//
//
//        //翌日日付を取得
//        int tempNextDay;
//      	SelectTmrEntity selectTmrEntity = new SelectTmrEntity();
//        List<SelectTmrEntity> selectTmrList = dao.select(selectTmrEntity);
//        // SimpleDateFormatで日付フォーマット設定
//     	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//        //翌日日付データ_取り出す（リストの[0]を取得)
//        for (SelectTmrEntity entity : selectTmrList) {
//            //検索結果_翌日日付
//      	  tempNextDay = Integer.parseInt(sdf.format(entity.getCalDate()));
//        }

		//却下ボタン押下の場合
		if ("1".equals(indto.getFuncId())) {
			// チェック処理（FULL）
			if(checkInput(loginInfo,indto,true)) {
				indto.setReturnFlg("0");
				return outdto;
			}
		}
		//申請ボタン押下の場合または承認ボタン押下の場合
		if ("0".equals(indto.getFuncId()) || "2".equals(indto.getFuncId())) {
			// チェック処理（簡易）
			if(checkInput(loginInfo,indto,false)) {
				indto.setReturnFlg("0");
				return outdto;
			}
		}

        // 更新処理
        if("0".equals(indto.getFuncId())) {//
			// 登録か更新か申請IDで判定
			if(indto.getReqId() == null || StringUtils.isEmpty(indto.getReqId()) || "-".equals(indto.getReqId())) {
	        	// 新規登録
	        	SeqRdmReqIdEntity seqRdmReqIdEntity = new SeqRdmReqIdEntity();
	        	List<SeqRdmReqIdEntity> seqRdmReqIdDate = dao.select(seqRdmReqIdEntity);
	        	reqId = seqRdmReqIdDate.get(0).getReqId();
	        	indto.setReqId(reqId);
	        	// レコードを登録
	        	TRdmReqKnrEntity tRdmReqKnrInsData = new TRdmReqKnrEntity();
	        	tRdmReqKnrInsData.setReqId(reqId);
	        	if("1".equals(indto.getMrAdminFlg())) {
	        		// 承認者（管理者権限）が申請の場合、'2'(DSG起因)
	        		tRdmReqKnrInsData.setReqChl("2");
	        		tRdmReqKnrInsData.setReqKngKbn("2");
	        	} else {
	        		// "MRが申請の場合、'1'(MR起因)
	        		tRdmReqKnrInsData.setReqChl("1");
	        		tRdmReqKnrInsData.setReqKngKbn("1");
	        	}

	        	if("0".equals(indto.getMovemedEditFlg())) {
	        		tRdmReqKnrInsData.setReqType("42");
	        	}else {
	        		tRdmReqKnrInsData.setReqType("51");
	        	}

				if("1".equals(tRdmReqKnrInsData.getReqChl()) || "2".equals(tRdmReqKnrInsData.getReqChl())) {
					tRdmReqKnrInsData.setReqStsCd("03");
				} else if("3".equals(indto.getReqChl())) {
					tRdmReqKnrInsData.setReqStsCd("13");
				}

				if (!(StringUtils.isEmpty(indto.getSelectDay()))) {
					SelectHenkanListEntity haifunHenkan = new SelectHenkanListEntity("ハイフン除去");
					haifunHenkan.setSearchHenkan(indto.getSelectDay());
					List<SelectHenkanListEntity> selectHaifun = dao.select(haifunHenkan);
					indto.setSelectDay(selectHaifun.get(0).getSearchHenkan());
				}
	        	String tekiyoYmd = indto.getSelectDay();
				if(!StringUtils.isEmpty(tekiyoYmd)) {
					tekiyoYmd = tekiyoYmd.replace("-", "");
				}
	        	tRdmReqKnrInsData.setTekiyoYmd(tekiyoYmd);
	        	tRdmReqKnrInsData.setReqBrCd(loginInfo.getBrCode());
	        	tRdmReqKnrInsData.setReqDistCd(loginInfo.getDistCode());
	        	tRdmReqKnrInsData.setReqShzNm(loginInfo.getBumonRyakuName());
	        	tRdmReqKnrInsData.setReqYmdhms(sysDateTime);
	        	tRdmReqKnrInsData.setReqJgiNo(loginInfo.getJgiNo());
	        	tRdmReqKnrInsData.setReqJgiName(loginInfo.getJgiName());
	        	tRdmReqKnrInsData.setReqComment(indto.getReqComment());
	        	tRdmReqKnrInsData.setDocNo(indto.getDocNo());
	        	tRdmReqKnrInsData.setInsNo(indto.getInsNo());
	        	tRdmReqKnrInsData.setInsShaYmd(systemDate);
	        	tRdmReqKnrInsData.setInsShaId(Integer.toString(loginInfo.getJgiNo()));
	        	tRdmReqKnrInsData.setUpdShaYmd(systemDate);
	        	tRdmReqKnrInsData.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));

	        	dao.insertByValue(tRdmReqKnrInsData);
			}else {
				// 申請
				TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity("updateTRdmReqKnrData");

				tRdmReqKnrEntity.setReqId(indto.getReqId());
				if("1".equals(indto.getReqChl()) || "2".equals(indto.getReqChl())) {
					tRdmReqKnrEntity.setReqStsCd("03");
				} else if("3".equals(indto.getReqChl())) {
					tRdmReqKnrEntity.setReqStsCd("13");
				}
				tRdmReqKnrEntity.setReqBrCd(loginInfo.getBrCode());
				tRdmReqKnrEntity.setReqDistCd(loginInfo.getDistCode());
				tRdmReqKnrEntity.setReqShzNm(loginInfo.getBumonRyakuName());
				tRdmReqKnrEntity.setReqJgiNo(loginInfo.getJgiNo());
				tRdmReqKnrEntity.setReqJgiName(loginInfo.getJgiName());
				tRdmReqKnrEntity.setReqYmdhms(sysDateTime);
				tRdmReqKnrEntity.setReqComment(indto.getReqComment());
	        	String tekiyoYmd = indto.getSelectDay();
				if(!StringUtils.isEmpty(tekiyoYmd)) {
					tekiyoYmd = tekiyoYmd.replace("-", "");
				}
				tRdmReqKnrEntity.setTekiyoYmd(tekiyoYmd);
				if(loginInfo.getJokenSetCd().equals(RdmConstantsData.RDM_JKN_ADMIN)) {
					tRdmReqKnrEntity.setReqKngKbn("2");
				} else {
					tRdmReqKnrEntity.setReqKngKbn("1");
				}

				tRdmReqKnrEntity.setUpdShaYmd(systemDate);
				tRdmReqKnrEntity.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));

				dao.update(tRdmReqKnrEntity);

			}
	        // 勤務先_申請管理
	        TRdmHcpKmuReqEntity tRdmHcpKmuReqEntity = new TRdmHcpKmuReqEntity();
	        tRdmHcpKmuReqEntity.setReqId(indto.getReqId());
	        TRdmHcpKmuReqEntity tRdmHcpKmuReqData = dao.selectByPK(tRdmHcpKmuReqEntity);

	        if(tRdmHcpKmuReqData == null) {//新規
	        	TRdmHcpKmuReqEntity tRdmHcpKmuReqInsData = new TRdmHcpKmuReqEntity();
	        	tRdmHcpKmuReqInsData.setReqId(reqId);
	        	tRdmHcpKmuReqInsData.setDocNo(indto.getDocNo());
	        	tRdmHcpKmuReqInsData.setInsNoMt(indto.getPreInsNo());
	        	if ("0".equals(indto.getMovemedEditFlg())) {
	        		tRdmHcpKmuReqInsData.setInsNoSk(StringUtils.nvl(indto.getPostInsNo(), ""));
	        	} else {
	        		tRdmHcpKmuReqInsData.setInsNoSk(indto.getPreInsNo());
	        	}
	        	tRdmHcpKmuReqInsData.setJobFormBf(StringUtils.nvl(indto.getPreJobForm(), ""));
	        	tRdmHcpKmuReqInsData.setDeptCodeBf(StringUtils.nvl(indto.getPreDeptCode(), ""));
	        	tRdmHcpKmuReqInsData.setDeptKanjiBf(StringUtils.nvl(indto.getPreDeptKj(), ""));
	        	tRdmHcpKmuReqInsData.setDeptKanaBf(StringUtils.nvl(indto.getPreDeptKn(), ""));
	        	tRdmHcpKmuReqInsData.setUnivPosCodeBf(indto.getPreUnivPosCode());
	        	tRdmHcpKmuReqInsData.setTitleCodeBf(indto.getPreTitleCode());
	        	tRdmHcpKmuReqInsData.setDccTypeBf(indto.getPreDcc());
	        	tRdmHcpKmuReqInsData.setJobFormAf(StringUtils.nvl(indto.getPostJobForm(), ""));
	        	tRdmHcpKmuReqInsData.setDeptCodeAf(StringUtils.nvl(indto.getPostDeptCode(), ""));
	        	tRdmHcpKmuReqInsData.setDeptKanjiAf(StringUtils.nvl(indto.getPostDeptKj(), ""));
	        	tRdmHcpKmuReqInsData.setDeptKanaAf(StringUtils.nvl(indto.getPostDeptKn(), ""));
	        	tRdmHcpKmuReqInsData.setUnivPosCodeAf(indto.getPostUnivPosCode());
	        	tRdmHcpKmuReqInsData.setTitleCodeAf(indto.getPostTitleCode());
	        	tRdmHcpKmuReqInsData.setDccTypeAf(indto.getPostDcc());
	        	tRdmHcpKmuReqInsData.setUltDocNo(indto.getUltDocNo());
	            //異動でない（異動元と異動先の施設コードが同じ、異動先のULT施設コードがnull）場合、現在の所属施設をセット
//	        	if(!(indto.getPreUltInsNo().equals(indto.getPostUltInsNo()) || StringUtils.isEmpty(indto.getPostUltInsNo()))) {
//	        		tRdmHcpKmuReqInsData.setUltInsNo(indto.getPostUltInsNo());
//	        	}
	        	tRdmHcpKmuReqInsData.setInsShaYmd(systemDate);
	        	tRdmHcpKmuReqInsData.setInsShaId(Integer.toString(loginInfo.getJgiNo()));
	        	tRdmHcpKmuReqInsData.setUpdShaYmd(systemDate);
	        	tRdmHcpKmuReqInsData.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));

	        	dao.insertByValue(tRdmHcpKmuReqInsData);
	        }else {//更新
	        	TRdmHcpKmuReqEntity tRdmHcpKmuReqUpdData = new TRdmHcpKmuReqEntity("updateND101Data");
	        	tRdmHcpKmuReqUpdData.setReqId(reqId);
	        	if ("0".equals(indto.getMovemedEditFlg())) {
	        		tRdmHcpKmuReqUpdData.setInsNoSk(StringUtils.nvl(indto.getPostInsNo(), ""));
	        	} else {
					tRdmHcpKmuReqUpdData.setInsNoSk(indto.getPreInsNo());
				}
	        	tRdmHcpKmuReqUpdData.setJobFormAf(StringUtils.nvl(indto.getPostJobForm(), ""));
	        	tRdmHcpKmuReqUpdData.setDeptCodeAf(StringUtils.nvl(indto.getPostDeptCode(), ""));
	        	tRdmHcpKmuReqUpdData.setDeptKanjiAf(StringUtils.nvl(indto.getPostDeptKj(), ""));
	        	tRdmHcpKmuReqUpdData.setDeptKanaAf(StringUtils.nvl(indto.getPostDeptKn(), ""));
	        	tRdmHcpKmuReqUpdData.setUnivPosCodeAf(StringUtils.nvl(indto.getPostUnivPosCode(),""));
	        	tRdmHcpKmuReqUpdData.setTitleCodeAf(StringUtils.nvl(indto.getPostTitleCode(),""));
	        	tRdmHcpKmuReqUpdData.setDccTypeAf(StringUtils.nvl(indto.getPostDcc(),""));
	        	//ult医師コード最新化
	        	SelectDocReqKnrInsChangeEntity selectDocReqKnrInsChangeEntity = new SelectDocReqKnrInsChangeEntity();
	        	selectDocReqKnrInsChangeEntity.setInReqFlg(0);
	        	selectDocReqKnrInsChangeEntity.setInDocNo(indto.getDocNo());
	        	selectDocReqKnrInsChangeEntity.setInInsNo(indto.getPreInsNo());
	            //異動でない（異動元と異動先の施設コードが同じ、異動先のULT施設コードがnull）場合、現在の所属施設をセット
//	        	if(!(indto.getPreUltInsNo().equals(indto.getPostUltInsNo()) || StringUtils.isEmpty(indto.getPostUltInsNo()))) {
//	        		tRdmHcpKmuReqUpdData.setUltInsNo(indto.getPostUltInsNo());
//	        	}
	        	tRdmHcpKmuReqUpdData.setUpdShaYmd(systemDate);
	        	tRdmHcpKmuReqUpdData.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));


	        	dao.update(tRdmHcpKmuReqUpdData);
	        }
			//outdto.setForward("NC101");

        } else if("1".equals(indto.getFuncId())) {
			// 却下
			TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity("updateTRdmReqKnrData");

			tRdmReqKnrEntity.setReqId(indto.getReqId());
			if("1".equals(indto.getReqChl()) || "2".equals(indto.getReqChl())) {
				tRdmReqKnrEntity.setReqStsCd("02");
			} else if("3".equals(indto.getReqChl())) {
				tRdmReqKnrEntity.setReqStsCd("12");
			}
			tRdmReqKnrEntity.setAprBrCode(loginInfo.getBrCode());
        	tRdmReqKnrEntity.setAprDistCode(loginInfo.getDistCode());
        	tRdmReqKnrEntity.setAprShz(loginInfo.getBumonRyakuName());
        	tRdmReqKnrEntity.setAprJgiNo(loginInfo.getJgiNo());
        	tRdmReqKnrEntity.setAprShaName(loginInfo.getJgiName());
        	tRdmReqKnrEntity.setAprYmdhms(sysDateTime);
        	tRdmReqKnrEntity.setAprComment(indto.getAprComment());

        	tRdmReqKnrEntity.setUpdShaYmd(systemDate);
        	tRdmReqKnrEntity.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));

//        	if(RdmConstantsData.RDM_JKN_ADMIN.equals(loginInfo.getJokenSetCd())) {
//        		tRdmReqKnrEntity.setReqKngKbn("2");
//        	} else {
//        		tRdmReqKnrEntity.setReqKngKbn("1");
//        	}

        	tRdmReqKnrEntity.setUpdShaYmd(systemDate);
        	tRdmReqKnrEntity.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));

        	dao.update(tRdmReqKnrEntity);

        	//outdto.setForward("NC101");
		} else if("2".equals(indto.getFuncId())) {
			// 承認
			TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity("updateTRdmReqKnrData");

			tRdmReqKnrEntity.setReqId(indto.getReqId());
			if("1".equals(indto.getReqChl()) || "2".equals(indto.getReqChl())) {
				tRdmReqKnrEntity.setReqStsCd("04");
			} else if("3".equals(indto.getReqChl())) {
				tRdmReqKnrEntity.setReqStsCd("14");
			}
			tRdmReqKnrEntity.setAprBrCode(loginInfo.getBrCode());
        	tRdmReqKnrEntity.setAprDistCode(loginInfo.getDistCode());
        	tRdmReqKnrEntity.setAprShz(loginInfo.getBumonRyakuName());
        	tRdmReqKnrEntity.setAprJgiNo(loginInfo.getJgiNo());
        	tRdmReqKnrEntity.setAprShaName(loginInfo.getJgiName());
        	tRdmReqKnrEntity.setAprYmdhms(sysDateTime);
//        	tRdmReqKnrEntity.setAprComment(indto.getReqComment());
			if(indto.getFbReqFlg()) {
				tRdmReqKnrEntity.setFbReqFlg("1");//FB申請要否フラグ
			}else {
				tRdmReqKnrEntity.setFbReqFlg("0");//FB申請要否フラグ
			}
        	String tekiyoYmd = indto.getSelectDay();
			if(!StringUtils.isEmpty(tekiyoYmd)) {
				tekiyoYmd = tekiyoYmd.replace("-", "");
			}
			tRdmReqKnrEntity.setTekiyoYmd(tekiyoYmd);
			tRdmReqKnrEntity.setAprComment(indto.getAprComment());//承認者コメント
//			tRdmReqKnrEntity.setAprMemo(indto.getAprMemo());//承認者メモ
        	tRdmReqKnrEntity.setUpdShaYmd(systemDate);
        	tRdmReqKnrEntity.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));

//        	if(RdmConstantsData.RDM_JKN_ADMIN.equals(loginInfo.getJokenSetCd())) {
//        		tRdmReqKnrEntity.setReqKngKbn("2");
//        	} else {
//        		tRdmReqKnrEntity.setReqKngKbn("1");
//        	}

        	tRdmReqKnrEntity.setUpdShaYmd(systemDate);
        	tRdmReqKnrEntity.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));

        	dao.update(tRdmReqKnrEntity);

        	//outdto.setForward("NC101");
		}
        indto.setReturnFlg("9");

    	return outdto;
    }


    //ND101　医療機関への異動画面用
    public void setCombo(ND307DTO indto, Boolean errFlg) {
    	//1-2 ドロップダウンリストの生成
        //役職
    	SelectNd101YakushokuComboListEntity selectNd101YakushokuComboListEntity = new SelectNd101YakushokuComboListEntity();
    	List<SelectNd101YakushokuComboListEntity> selectNd101YakushokuComboList;
    	selectNd101YakushokuComboListEntity.setInDataKbn("0");
    	selectNd101YakushokuComboList = dao.select(selectNd101YakushokuComboListEntity);
    	LinkedHashMap<String, String> mapYakushoku = new LinkedHashMap<String, String>();
    	mapYakushoku.put(null, "--選択してください--");
        for (SelectNd101YakushokuComboListEntity outEntity : selectNd101YakushokuComboList) {
        	mapYakushoku.put(outEntity.getTitleCode(),outEntity.getTitleKj());
        }
        indto.setYakushokuCombo(mapYakushoku);
        if(!(indto.getReqSts() == null) && !(errFlg)) {
        	indto.setYakushoku(indto.getPostTitleCode());
        }

        //勤務形態
        SelectNd101ComboListEntity selectNd101ComboListEntity = new SelectNd101ComboListEntity();
        List<SelectNd101ComboListEntity> selectNd101ComboList;
        selectNd101ComboListEntity.setInDataKbn("JOB_FORM");
        selectNd101ComboList = dao.select(selectNd101ComboListEntity);
        LinkedHashMap<String, String> mapJobForm = new LinkedHashMap<String, String>();
        mapJobForm.put(null, "--なし--");
        for (SelectNd101ComboListEntity outEntity : selectNd101ComboList) {
        	mapJobForm.put(outEntity.getValue1(),outEntity.getValue1Kanj());
        }
        indto.setJobFormCombo(mapJobForm);
        if(!(indto.getReqSts() == null) && !(errFlg)) {
        	indto.setJobForm(indto.getPostJobForm());
        }

        //薬審メンバー区分
        SelectNd101ComboListEntity selectNd101ComboListEntity2 = new SelectNd101ComboListEntity();
        List<SelectNd101ComboListEntity> selectNd101ComboList2;
        selectNd101ComboListEntity2.setInDataKbn("DCC");
        selectNd101ComboList2 = dao.select(selectNd101ComboListEntity2);
        LinkedHashMap<String, String> mapDcc = new LinkedHashMap<String, String>();
        mapDcc.put(null, "--なし--");
        for (SelectNd101ComboListEntity outEntity : selectNd101ComboList2) {
        	mapDcc.put(outEntity.getValue1(),outEntity.getValue1Kanj());
        }
        indto.setDccCombo(mapDcc);
        if(!(indto.getReqSts() == null)&& !(errFlg)) {
        	indto.setDcc(indto.getPostDcc());
        }

        //大学職位
    	SelectNd101YakushokuComboListEntity selectNd101YakushokuComboListEntity2 = new SelectNd101YakushokuComboListEntity();
    	List<SelectNd101YakushokuComboListEntity> selectNd101YakushokuComboList2;
    	selectNd101YakushokuComboListEntity2.setInDataKbn("1");
    	selectNd101YakushokuComboList2 = dao.select(selectNd101YakushokuComboListEntity2);
    	LinkedHashMap<String, String> mapDigakuShokui = new LinkedHashMap<String, String>();
    	mapDigakuShokui.put(null, "--選択してください--");
        for (SelectNd101YakushokuComboListEntity outEntity : selectNd101YakushokuComboList2) {
        	mapDigakuShokui.put(outEntity.getTitleCode(),outEntity.getTitleKj());
        }
        indto.setDigakuShokuiCombo(mapDigakuShokui);
        if(!(indto.getReqSts() == null) && !(errFlg) ) {
        	indto.setDigakuShokui(indto.getPostUnivPosCode());
        }

        //翌日日付_RDM用カレンダー(オンライン用)_生成用エンティティ
      	SelectTmrEntity selectTmrEntity = new SelectTmrEntity();
          //翌日日付_RDM用カレンダー(オンライン用)の帳票一覧を取得する
          List<SelectTmrEntity> selectTmrList = dao.select(selectTmrEntity);

          // SimpleDateFormatで日付フォーマット設定
       	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
          //翌日日付データ_取り出す（リストの[0]を取得)
          for (SelectTmrEntity entity : selectTmrList) {
              //検索結果_翌日日付
              indto.setTekiyoInitDay(sdf.format(entity.getCalDate()));
          }
    }

    public void setCombo(ND307DTO indto) {
    	//1-2 ドロップダウンリストの生成
        //役職
    	SelectNd101YakushokuComboListEntity selectNd101YakushokuComboListEntity = new SelectNd101YakushokuComboListEntity();
    	List<SelectNd101YakushokuComboListEntity> selectNd101YakushokuComboList;
    	selectNd101YakushokuComboListEntity.setInDataKbn("0");
    	selectNd101YakushokuComboList = dao.select(selectNd101YakushokuComboListEntity);
    	LinkedHashMap<String, String> mapYakushoku = new LinkedHashMap<String, String>();
    	mapYakushoku.put(null, "--選択してください--");
        for (SelectNd101YakushokuComboListEntity outEntity : selectNd101YakushokuComboList) {
        	mapYakushoku.put(outEntity.getTitleCode(),outEntity.getTitleKj());
        }
        indto.setYakushokuCombo(mapYakushoku);

        //勤務形態
        SelectNd101ComboListEntity selectNd101ComboListEntity = new SelectNd101ComboListEntity();
        List<SelectNd101ComboListEntity> selectNd101ComboList;
        selectNd101ComboListEntity.setInDataKbn("JOB_FORM");
        selectNd101ComboList = dao.select(selectNd101ComboListEntity);
        LinkedHashMap<String, String> mapJobForm = new LinkedHashMap<String, String>();
        mapJobForm.put(null, "--なし--");
        for (SelectNd101ComboListEntity outEntity : selectNd101ComboList) {
        	mapJobForm.put(outEntity.getValue1(),outEntity.getValue1Kanj());
        }
        indto.setJobFormCombo(mapJobForm);

        //薬審メンバー区分
        SelectNd101ComboListEntity selectNd101ComboListEntity2 = new SelectNd101ComboListEntity();
        List<SelectNd101ComboListEntity> selectNd101ComboList2;
        selectNd101ComboListEntity2.setInDataKbn("DCC");
        selectNd101ComboList2 = dao.select(selectNd101ComboListEntity2);
        LinkedHashMap<String, String> mapDcc = new LinkedHashMap<String, String>();
        mapDcc.put(null, "--なし--");
        for (SelectNd101ComboListEntity outEntity : selectNd101ComboList2) {
        	mapDcc.put(outEntity.getValue1(),outEntity.getValue1Kanj());
        }
        indto.setDccCombo(mapDcc);

        //大学職位
    	SelectNd101YakushokuComboListEntity selectNd101YakushokuComboListEntity2 = new SelectNd101YakushokuComboListEntity();
    	List<SelectNd101YakushokuComboListEntity> selectNd101YakushokuComboList2;
    	selectNd101YakushokuComboListEntity2.setInDataKbn("1");
    	selectNd101YakushokuComboList2 = dao.select(selectNd101YakushokuComboListEntity2);
    	LinkedHashMap<String, String> mapDigakuShokui = new LinkedHashMap<String, String>();
    	mapDigakuShokui.put(null, "--選択してください--");
        for (SelectNd101YakushokuComboListEntity outEntity : selectNd101YakushokuComboList2) {
        	mapDigakuShokui.put(outEntity.getTitleCode(),outEntity.getTitleKj());
        }
        indto.setDigakuShokuiCombo(mapDigakuShokui);

      //翌日日付_RDM用カレンダー(オンライン用)_生成用エンティティ
    	SelectTmrEntity selectTmrEntity = new SelectTmrEntity();
        //翌日日付_RDM用カレンダー(オンライン用)の帳票一覧を取得する
        List<SelectTmrEntity> selectTmrList = dao.select(selectTmrEntity);

        // SimpleDateFormatで日付フォーマット設定
     	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        //翌日日付データ_取り出す（リストの[0]を取得)
        for (SelectTmrEntity entity : selectTmrList) {
            //検索結果_翌日日付
            indto.setTekiyoInitDay(sdf.format(entity.getCalDate()));
        }
    }

	/*
	 * エラーありならtrueとし、エラーメッセージをmsgStrにセットする
	 */
	private boolean checkInput(LoginInfo loginInfo, ND307DTO indto, boolean fullchkFlg) {
		boolean errChk = false;
		String msgStr = "";
		String tmpMsgStr = "";
		String alertErrMsg = "";
		String alertErrMsg2 = "";
		if(fullchkFlg) {
			//	１：必須入力チェック
			//	項目
			//	却下コメント
			if(StringUtils.isEmpty(indto.getAprComment())) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W026);//却下の場合はコメントを入力してください。
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//      ２：レングスチェック
		//      項目                                チェック内容
		int len = 0;

		//      申請コメント                                ３００文字を超えている場合
		if(!StringUtils.isEmpty(indto.getReqComment())) {
			//len = StringUtils.getByteLength(indto.getReqComment());
			len = indto.getReqComment().length();
			if(len > 100) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W009);//最大文字数を超えています。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "申請コメント");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//      申請コメント                                ３００文字を超えている場合
		if(!StringUtils.isEmpty(indto.getAprComment())) {
			//len = StringUtils.getByteLength(indto.getAprComment());
			len = indto.getAprComment().length();
			if(len > 100) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W009);//最大文字数を超えています。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "承認・却下コメント");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}

		//		整合性チェック                              廃院を勤務先施設に選択して申請している場合
		SelectNd101MainDataEntity paramEntity = new SelectNd101MainDataEntity();
		paramEntity.setSqlId("selectNd101DelInsData");
		if(indto.getMovemedEditFlg().equals("0")) {// 医療機関への異動の場合
			paramEntity.setInInsNo(indto.getPostInsNo());
		} else {//勤務先情報更新の場合
			paramEntity.setInInsNo(indto.getPreInsNo());
		}
		List<SelectNd101MainDataEntity> mainDataChkList = dao.select(paramEntity);
		if(!mainDataChkList.isEmpty()) {
			// 勤務先に廃院が選択されています。
			msgStr += loginInfo.getMsgData(RdmConstantsData.W062) + "\n";
			errChk = true;
		}

		// 整合性チェック
		// 医師がマスタ上で削除済
		paramEntity.setSqlId("selectNd101DelMaster");
		paramEntity.setInDocNo(indto.getDocNo());
		List<SelectNd101MainDataEntity> mainDataEntityListM = dao.select(paramEntity);
		if (mainDataEntityListM.size() > 0) {
			// 医師免許返納・死亡状態で、申請できません。
			tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.W040) + "\n";
			errChk = true;
		}

		//MRの場合、異動先か異動元のいずれかが管轄ではないとエラー
		// 医療機関への異動の場合
		if (indto.getMovemedEditFlg().equals("0") && loginInfo.getJokenFlg().equals("0")) {
			if (indto.getPreInsNo() != null) {
				paramEntity.setSqlId("selectNd101MRSosCheck");
				paramEntity.setInPreInsNo(indto.getPreInsNo());
				paramEntity.setInPostInsNo(indto.getPostInsNo());
				paramEntity.setInSosCd(loginInfo.getSosCd());
				List<SelectNd101MainDataEntity> mainDataEntityListMR = dao.select(paramEntity);
				if (mainDataEntityListMR.size() == 0) {
					// 異動元施設、異動先施設の両方が管轄外のため申請できません。
					tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.W070) + "\n";
					errChk = true;
				}
			}
		}

		// 同じ医師で同じ施設に対しての申請がすでに存在している場合
		paramEntity.setSqlId("selectNd101DupData");
		paramEntity.setInDocNo(indto.getDocNo());
		paramEntity.setInInsNo(indto.getPreInsNo());
		paramEntity.setInReqId(StringUtils.setEmptyToNull(indto.getReqId()));
		List<SelectNd101MainDataEntity> mainDataEntityList = dao.select(paramEntity);
		if (mainDataEntityList.size() > 0) {
			// 重複する申請が行われています。（医師コード）
			msgStr += loginInfo.getMsgData(RdmConstantsData.W008).replace("項目名", "医師コード") + "\n";
			errChk = true;
		}

		// 適用日が翌営業日以降ではない場合
		if (indto.getSelectDay() != null && !indto.getSelectDay().isEmpty()) {
			// 翌日日付_RDM用カレンダー(オンライン用)_生成用エンティティ
			SelectTmrEntity selectTmrEntity = new SelectTmrEntity();

			// 翌日日付_RDM用カレンダー(オンライン用)の帳票一覧を取得する
			List<SelectTmrEntity> selectTmrList = dao.select(selectTmrEntity);

			// SimpleDateFormatで日付フォーマット設定
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// 翌日日付データ_取り出す（リストの[0]を取得)
			for (SelectTmrEntity entity : selectTmrList) {
				// 検索結果_翌日日付
				indto.setTekiyoInitDay(sdf.format(entity.getCalDate()));
			}
			String tempNextBizDay = indto.getTekiyoInitDay().replace("-", "");
			String tempTekiyoYmd = indto.getSelectDay().replace("-", "");

			Integer nextBizDay = Integer.parseInt(tempNextBizDay);
			Integer tekiyoYmd = Integer.parseInt(tempTekiyoYmd);

			if (tekiyoYmd < nextBizDay) {
				// 適用日は翌営業日以降を指定してください。
				msgStr += loginInfo.getMsgData(RdmConstantsData.W007) + "\n";
				errChk = true;
			}
		}
//		// 申請時に既に医師削除申請がされている場合
		if(!indto.getAlertIgnore().equals("1")) {
			SelectNd101MainDataEntity paramEntity2 = new SelectNd101MainDataEntity();
			paramEntity2.setSqlId("selectNd101DelData");
			paramEntity2.setInDocNo(indto.getDocNo());
			List<SelectNd101MainDataEntity> mainDataEntityList2 = dao.select(paramEntity2);
			if (mainDataEntityList2.size() > 0) {
				// 廃業・死亡の申請がされています。よろしいですか？
				alertErrMsg2 += loginInfo.getMsgData(RdmConstantsData.I010) + "\n";
				errChk = true;
			}
		}

		// 排他チェック
		// 最終更新日時が、画面OPEN時とボタン押下時で異なっていた場合
		if (indto.getUpdShaYmd() != null && !indto.getUpdShaYmd().equals("")) {
			TRdmReqKnrEntity tRdmReqKnrChkEntity = new TRdmReqKnrEntity("selectNd101DateChkData");
			tRdmReqKnrChkEntity.setReqId(indto.getReqId());

			List<TRdmReqKnrEntity> tRdmReqKnrEntityList = dao.select(tRdmReqKnrChkEntity);

			if (tRdmReqKnrEntityList.size() > 0) {
				SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date updDate = null;
				try {
					updDate = sdFormat.parse(indto.getUpdShaYmd());
				} catch (ParseException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				if (!tRdmReqKnrEntityList.get(0).getUpdShaYmd().equals(updDate)) {
					// 既に他のユーザーによってデータが処理されています。
					msgStr += loginInfo.getMsgData(RdmConstantsData.E003) + "\n";
					errChk = true;

				}
			}
		}

	if(errChk) {//エラーありなのでメッセージをセットする
		indto.setMsgStr(msgStr);
		indto.setAlertMsgStr(alertErrMsg);
    	indto.setAlertMsgStr2(alertErrMsg2);
    	indto.setAlertIgnore("0");
	}

		return errChk;
	}
}
