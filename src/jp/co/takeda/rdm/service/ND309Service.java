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
import jp.co.takeda.rdm.dto.ND102DTO;
import jp.co.takeda.rdm.dto.ND309DTO;
import jp.co.takeda.rdm.entity.join.TRdmReqKnrEntity;
import jp.co.takeda.rdm.entity.join.SelectDocReqKnrInsChangeCheckEntity;
import jp.co.takeda.rdm.entity.join.SelectDocReqKnrInsChangeEntity;
import jp.co.takeda.rdm.entity.join.SelectHenkanListEntity;
import jp.co.takeda.rdm.entity.join.SelectNd101ComboListEntity;
import jp.co.takeda.rdm.entity.join.SelectNd101MainDataEntity;
import jp.co.takeda.rdm.entity.join.SelectNd101YakushokuComboListEntity;
import jp.co.takeda.rdm.entity.join.SelectNd102ClosedCheckEntity;
import jp.co.takeda.rdm.entity.join.SelectNd102MrDummyCheckEntity;
import jp.co.takeda.rdm.entity.join.SelectNd102MultipleWorkCheckEntity;
import jp.co.takeda.rdm.entity.join.SelectNd102TrnListEntity;
import jp.co.takeda.rdm.entity.join.SelectNd307ParamSwitchEntity;
import jp.co.takeda.rdm.entity.join.SelectParamSwitchEntity;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.DateUtils;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * Serviceクラス（ND309)
 * @generated
 */
@Named
public class ND309Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(ND309Service.class);

    /**
     * イベント処理
     * @param indto ND309DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(ND309DTO indto) {
		BaseDTO outdto = indto;
		// 1-1 権限判定
		LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

		String reqId = indto.getReqId();
		boolean errFlg = false;
		String errMsg = "";
		String alertErrMsg = "";
		String alertErrMsg2 = "";

		setCombo(indto);
		indto.setPostTrnKbn(indto.getTrnKbnCombo().get(indto.getTrnKbnCd()));
		indto.setPostInsNo(indto.getTrnKbnInsNoCombo().get(indto.getTrnKbnCd()));
		if(!StringUtils.isEmpty(indto.getSelectDay())) {
			indto.setDispTekiyoYmd(indto.getSelectDay());
		}
		if(loginInfo.getJokenSetCd().equals(RdmConstantsData.RDM_JKN_ADMIN)) {
			if(StringUtils.isEmpty(indto.getUltDocNo())) {
				indto.setFbReqFlg(false);//ULTと紐付けが無い場合は初期値OFF
			} else {
				indto.setFbReqFlg(true);//ULTありは初期値ON
			}
		}
//		// 必須入力チェック
//
//		if (indto.getTrnKbnCd() == null || indto.getTrnKbnCd().isEmpty()) {
//			// 必須項目にデータを入力してください。（異動区分）
//			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "異動区分") + "\n";
//			errFlg = true;
//		}
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
//		// 整合性チェック
//		// 申請時に既に医師削除申請がされている場合（承認待ち）
//		if(!indto.getAlertIgnore().equals("1")) {
//			SelectNd101MainDataEntity paramEntity2 = new SelectNd101MainDataEntity();
//			paramEntity2.setSqlId("selectNd101DelData");
//			paramEntity2.setInDocNo(indto.getDocNo());
//			List<SelectNd101MainDataEntity> mainDataEntityList2 = dao.select(paramEntity2);
//			if (mainDataEntityList2.size() > 0) {
//				// 医師免許返納・死亡の申請がされています。よろしいですか？
//				alertErrMsg2 += loginInfo.getMsgData(RdmConstantsData.I010) + "\n";
//				errFlg = true;
//			}
//		}
//
//		// 整合性チェック
//		// 申請時に既に医師削除申請がされている場合（承認済）
//
//		SelectNd101MainDataEntity paramEntity4 = new SelectNd101MainDataEntity();
//		paramEntity4.setSqlId("selectNd101DelAppdData");
//		paramEntity4.setInDocNo(indto.getDocNo());
//		List<SelectNd101MainDataEntity> mainDataEntityList4 = dao.select(paramEntity4);
//		if (mainDataEntityList4.size() > 0) {
//			// 医師免許返納・死亡状態で、申請できません。
//			errMsg += loginInfo.getMsgData(RdmConstantsData.W040) + "\n";
//			errFlg = true;
//		}
//
//		// 整合性チェック
//		//
//		SelectNd102MultipleWorkCheckEntity multipleWorkCheckEntity = new SelectNd102MultipleWorkCheckEntity();
//		multipleWorkCheckEntity.setInDocNo(indto.getDocNo());
//		List<SelectNd102MultipleWorkCheckEntity> multipleWorkCheckList = dao.select(multipleWorkCheckEntity);
//		if(multipleWorkCheckList.size() >= 2) {
//			// 通常勤務先施設数が2以上のため申請できません。
//			errMsg += loginInfo.getMsgData(RdmConstantsData.W037) + "\n";
//			errFlg = true;
//		}
//
//		// 整合性チェック
//		//
//		SelectNd102ClosedCheckEntity closedCheckEntity = new SelectNd102ClosedCheckEntity();
//		closedCheckEntity.setInDocNo(indto.getDocNo());
//		List<SelectNd102ClosedCheckEntity> closedCheckList = dao.select(closedCheckEntity);
//		if(!(closedCheckList.isEmpty())) {
//			// 医師免許返納・死亡の申請されているため申請できません。
//			errMsg += loginInfo.getMsgData(RdmConstantsData.W038) + "\n";
//			errFlg = true;
//		}
//
//		// 整合性チェック
//		//
//		if(indto.getMrAdminFlg().equals("1")) {
//			SelectNd102MrDummyCheckEntity mrDummyCheckEntity = new SelectNd102MrDummyCheckEntity();
//			mrDummyCheckEntity.setInInsNo(indto.getPreInsNo());
//			List<SelectNd102MrDummyCheckEntity> MrDummyCheckList = dao.select(mrDummyCheckEntity);
//			if(!(MrDummyCheckList.isEmpty())) {
//				// 医療機関以外の施設から医療機関以外の施設への申請はできません。
//				errMsg += loginInfo.getMsgData(RdmConstantsData.W039) + "\n";
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
//        	indto.setTitle("ND102_医療機関以外への異動");
//        	outdto.setForward("ND102");
//        	return outdto;
//        }



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
//        	tRdmReqKnrInsData.setReqType("43");
//
//        	tRdmReqKnrInsData.setReqStsCd("01");
//
//			if (!(StringUtils.isEmpty(indto.getSelectDay()))) {
//				SelectHenkanListEntity haifunHenkan = new SelectHenkanListEntity("ハイフン除去");
//				haifunHenkan.setSearchHenkan(indto.getSelectDay());
//				List<SelectHenkanListEntity> selectHaifun = dao.select(haifunHenkan);
//				indto.setSelectDay(selectHaifun.get(0).getSearchHenkan());
//			}
//
//        	tRdmReqKnrInsData.setTekiyoYmd(indto.getSelectDay());
//        	tRdmReqKnrInsData.setReqBrCd(loginInfo.getBrCode());
//        	tRdmReqKnrInsData.setReqDistCd(loginInfo.getDistCode());
//        	tRdmReqKnrInsData.setReqShzNm(loginInfo.getBumonRyakuName());
//
//        	tRdmReqKnrInsData.setReqJgiNo(loginInfo.getJgiNo());
//        	tRdmReqKnrInsData.setReqJgiName(loginInfo.getJgiName());
//        	tRdmReqKnrInsData.setReqComment(indto.getReqComment());
//        	tRdmReqKnrInsData.setDocNo(indto.getDocNo());
//        	tRdmReqKnrInsData.setInsNo(StringUtils.nvl(indto.getTrnKbnInsNo(), ""));
//        	tRdmReqKnrInsData.setInsShaYmd(systemDate);
//        	tRdmReqKnrInsData.setInsShaId(Integer.toString(loginInfo.getJgiNo()));
//        	tRdmReqKnrInsData.setUpdShaYmd(systemDate);
//        	tRdmReqKnrInsData.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));
//
//        	dao.insertByValue(tRdmReqKnrInsData);
//
//        }else {
//        	TRdmReqKnrEntity tRdmReqKnrUpdData = new TRdmReqKnrEntity("updateND102Data");
//        	tRdmReqKnrUpdData.setReqId(reqId);
//
//        	if("13".equals(indto.getReqSts())) {
//        		tRdmReqKnrUpdData.setReqStsCd("13");
//        	} else {
//        		tRdmReqKnrUpdData.setReqStsCd("01");
//        	}
//
//        	tRdmReqKnrUpdData.setInsNo(StringUtils.nvl(indto.getTrnKbnInsNo(), ""));
//
//			if (!(StringUtils.isEmpty(indto.getSelectDay()))) {
//				SelectHenkanListEntity haifunHenkan = new SelectHenkanListEntity("ハイフン除去");
//				haifunHenkan.setSearchHenkan(indto.getSelectDay());
//				List<SelectHenkanListEntity> selectHaifun = dao.select(haifunHenkan);
//				indto.setSelectDay(selectHaifun.get(0).getSearchHenkan());
//			}
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
//        	tRdmHcpKmuReqInsData.setInsNoMt(StringUtils.nvl(indto.getPreInsNo(),"Z"));
//        	tRdmHcpKmuReqInsData.setTrnKbn(StringUtils.nvl(indto.getTrnKbnCd(), "Z"));
//        	tRdmHcpKmuReqInsData.setInsNoSk(StringUtils.nvl(indto.getTrnKbnInsNo(), "Z"));
//        	tRdmHcpKmuReqInsData.setJobFormBf(StringUtils.nvl(indto.getPreJobForm(), "Z"));
//        	tRdmHcpKmuReqInsData.setDeptCodeBf(StringUtils.nvl(indto.getPreDeptCode(), "Z"));
//        	tRdmHcpKmuReqInsData.setDeptKanjiBf(StringUtils.nvl(indto.getPreDeptKj(), "Z"));
//        	tRdmHcpKmuReqInsData.setDeptKanaBf(StringUtils.nvl(indto.getPreDeptKn(), "Z"));
//        	tRdmHcpKmuReqInsData.setUnivPosCodeBf(indto.getPreUnivPosCode());
//        	tRdmHcpKmuReqInsData.setTitleCodeBf(indto.getPreTitleCode());
//        	tRdmHcpKmuReqInsData.setDccTypeBf(indto.getPreDcc());
//        	tRdmHcpKmuReqInsData.setJobFormAf("Z");
//        	tRdmHcpKmuReqInsData.setDeptCodeAf("9999");
//        	tRdmHcpKmuReqInsData.setDeptKanjiAf("Z");
//        	tRdmHcpKmuReqInsData.setDeptKanaAf("Z");
//        	tRdmHcpKmuReqInsData.setUltDocNo(indto.getUltDocNo());
//        	tRdmHcpKmuReqInsData.setInsShaYmd(systemDate);
//        	tRdmHcpKmuReqInsData.setInsShaId(Integer.toString(loginInfo.getJgiNo()));
//        	tRdmHcpKmuReqInsData.setUpdShaYmd(systemDate);
//        	tRdmHcpKmuReqInsData.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));
//        	dao.insertByValue(tRdmHcpKmuReqInsData);
//        }else {
//        	TRdmHcpKmuReqEntity tRdmHcpKmuReqUpdData = new TRdmHcpKmuReqEntity("updateND102Data");
//        	tRdmHcpKmuReqUpdData.setReqId(reqId);
//        	tRdmHcpKmuReqUpdData.setTrnKbn(StringUtils.nvl(indto.getTrnKbnCd(), "Z"));
//        	tRdmHcpKmuReqUpdData.setInsNoSk(StringUtils.nvl(indto.getPostInsNo(), "Z"));
//        	//ult医師コード最新化
//        	SelectDocReqKnrInsChangeEntity selectDocReqKnrInsChangeEntity = new SelectDocReqKnrInsChangeEntity();
//        	selectDocReqKnrInsChangeEntity.setInReqFlg(0);
//        	selectDocReqKnrInsChangeEntity.setInDocNo(indto.getDocNo());
//        	selectDocReqKnrInsChangeEntity.setInInsNo(indto.getPreInsNo());
//        	String tempUltDocNo;
//        	List<SelectDocReqKnrInsChangeEntity> selectDocReqKnrInsChangeList = dao.select(selectDocReqKnrInsChangeEntity);
//        	if(selectDocReqKnrInsChangeList == null) {
//        		tempUltDocNo = "Z";
//        	}else {
//        		tempUltDocNo = selectDocReqKnrInsChangeList.get(0).getUltDocNo();
//        	}
//        	tRdmHcpKmuReqUpdData.setUltDocNo(tempUltDocNo);
//            //異動でない（異動元と異動先の施設コードが同じ、異動先のULT施設コードがnull）場合、現在の所属施設をセット
//        	if(indto.getPreUltInsNo().equals(indto.getPostUltInsNo()) || StringUtils.isEmpty(indto.getPostUltInsNo())) {
//        		tRdmHcpKmuReqUpdData.setUltInsNo(indto.getPreUltInsNo());
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
//		//隠し項目（変更後） TODO
////		indto.setPostInsNo(selectDocReqKnrInsChangeCheckList.get(0).getPostInsNo());
////		indto.setPostUltInsNo(selectDocReqKnrInsChangeCheckList.get(0).getPostUltInsNo());
////		indto.setPostDeptCode(selectDocReqKnrInsChangeCheckList.get(0).getPostDeptCode());
////		indto.setPostDeptKn(selectDocReqKnrInsChangeCheckList.get(0).getPostDeptKn());
////		indto.setPostTitleCode(selectDocReqKnrInsChangeCheckList.get(0).getPostTitleCode());
////		indto.setPostJobForm(selectDocReqKnrInsChangeCheckList.get(0).getPostJobForm());
////		indto.setPostDcc(selectDocReqKnrInsChangeCheckList.get(0).getPostDcc());
////		indto.setPostUnivPosCode(selectDocReqKnrInsChangeCheckList.get(0).getPostUnivPosCode());
//
//
//
//		//基本情報
//    	indto.setDocKanj(StringUtils.nvl(selectDocReqKnrInsChangeCheckList.get(0).getDocKanj(), "-"));
//
//    	//基本情報隠し項目
//        indto.setDocNo(selectDocReqKnrInsChangeCheckList.get(0).getDocNo());
//        indto.setUltDocNo(selectDocReqKnrInsChangeCheckList.get(0).getUltDocNo());
//
////        nd102ではいらない TODO
////        indto.setPreHoInsType(StringUtils.nvl(selectDocReqKnrInsChangeCheckList.get(0).getPreHoInsType(),""));
////        indto.setPostHoInsType(StringUtils.nvl(selectDocReqKnrInsChangeCheckList.get(0).getPostHoInsType(),""));
////        indto.setPreInsClass(StringUtils.nvl(selectDocReqKnrInsChangeCheckList.get(0).getPreInsClass(),""));
////        indto.setPostInsClass(StringUtils.nvl(selectDocReqKnrInsChangeCheckList.get(0).getPostInsClass(),""));
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
////		//異動区分　画面表示の切替に使用  nd102ではいらない TODO
////		indto.setTrnKbn(selectDocReqKnrInsChangeCheckList.get(0).getTrnKbn());
//
//		//勤務情報（変更後） nd102ではいらない TODO
////		indto.setPostInsAbbrName(StringUtils.nvl(selectDocReqKnrInsChangeCheckList.get(0).getPostInsAbbrName(),"-"));
////		indto.setPostDeptKj(StringUtils.nvl(selectDocReqKnrInsChangeCheckList.get(0).getPostDeptKj(), "-"));
////		indto.setTitlePostTitleKj(StringUtils.nvl(selectDocReqKnrInsChangeCheckList.get(0).getTitlePostTitleKj(),"-"));
////		indto.setKmuPostCodeKanj(StringUtils.nvl(selectDocReqKnrInsChangeCheckList.get(0).getKmuPostCodeKanj(),"-"));
////		indto.setYakushinPostCodeKanj(StringUtils.nvl(selectDocReqKnrInsChangeCheckList.get(0).getYakushinPostCodeKanj(),"-"));
////		indto.setUnivPostTitleKj(StringUtils.nvl(selectDocReqKnrInsChangeCheckList.get(0).getUnivPostTitleKj(),"-"));
//
//		//
//        //異動区分
//        SelectNd102TrnListEntity selectNd102TrnListEntity = new SelectNd102TrnListEntity();
//        List<SelectNd102TrnListEntity> selectNd102TrnList;
//        selectNd102TrnList = dao.select(selectNd102TrnListEntity);
//        //表示用
//        LinkedHashMap<String, String> mapTrnKbn = new LinkedHashMap<String, String>();
//        mapTrnKbn.put(null, "--選択してください--");
//        for (SelectNd102TrnListEntity outEntity : selectNd102TrnList) {
//        	mapTrnKbn.put(outEntity.getTrnValue1(),outEntity.getValue1Kanj());
//        }
//
//		indto.setPostTrnKbn(mapTrnKbn.get(indto.getTrnKbnCd()));
//
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

		SelectNd307ParamSwitchEntity paramEntity3 = new SelectNd307ParamSwitchEntity();
		List<SelectNd307ParamSwitchEntity> selectParamSwitchIshiList3;
		selectParamSwitchIshiList3 = dao.select(paramEntity3);
		SelectNd307ParamSwitchEntity paramSwitch = selectParamSwitchIshiList3.get(0);
		//承認ボタン
		if (indto.getMrAdminFlg().equals("0")) {
			if (StringUtils.isEmpty(indto.getReqSts()) || indto.getReqSts().equals("01")) {
				indto.setNd309AppdFlg("1");
				if (paramSwitch.getKmuFlg().equals("1") && paramSwitch.getDocFlg().equals("1")) {
					indto.setNd309AppdActiveFlg("1");
				} else {
					indto.setNd309AppdActiveFlg("0");
				}
			} else {
				indto.setNd309AppdFlg("0");
				indto.setNd309AppdActiveFlg("0");
			}
		} else {
			if (StringUtils.isEmpty(indto.getReqSts()) || indto.getReqSts().equals("01") || indto.getReqSts().equals("11") ) {
				indto.setNd309AppdFlg("1");
				if (paramSwitch.getKmuFlg().equals("1") && paramSwitch.getDocFlg().equals("1")) {
					indto.setNd309AppdActiveFlg("1");
				} else {
					indto.setNd309AppdActiveFlg("0");
				}
			} else {
				indto.setNd309AppdFlg("0");
				indto.setNd309AppdActiveFlg("0");
			}
		}

		//却下ボタン
		if(indto.getMrAdminFlg().equals("1")) {
			if(indto.getReqSts().equals("03") || indto.getReqSts().equals("13")) {
				indto.setNd309RejectFlg("1");
				if(paramSwitch.getKmuFlg().equals("1") && paramSwitch.getDocFlg().equals("1")) {
					indto.setNd309RejectActiveFlg("1");
				}else {
					indto.setNd309RejectActiveFlg("0");
				}
			}
		}else {
			indto.setNd309RejectFlg("0");
			indto.setNd309RejectActiveFlg("0");
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
    public BaseDTO register(ND309DTO indto) {
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

        // 申請処理
        if("0".equals(indto.getFuncId())) {
			// 登録か更新か申請IDで判定
			if(indto.getReqId() == null || StringUtils.isEmpty(indto.getReqId()) || "-".equals(indto.getReqId())) {
	        	// 新規登録
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

        		tRdmReqKnrInsData.setReqType("43");

				if("1".equals(tRdmReqKnrInsData.getReqChl()) || "2".equals(tRdmReqKnrInsData.getReqChl())) {
					tRdmReqKnrInsData.setReqStsCd("03");
				} else if("3".equals(indto.getReqChl())) {//ここに来ることはない
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
        		tRdmReqKnrInsData.setInsNo(StringUtils.nvl(indto.getPostInsNo(), ""));
        		tRdmReqKnrInsData.setInsShaYmd(systemDate);
        		tRdmReqKnrInsData.setInsShaId(Integer.toString(loginInfo.getJgiNo()));
        		tRdmReqKnrInsData.setUpdShaYmd(systemDate);
        		tRdmReqKnrInsData.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));
				if(StringUtils.isEmpty(indto.getUltDocNo())) {
					tRdmReqKnrInsData.setFbReqFlg("0");//FB申請要否フラグ
				}else {
					tRdmReqKnrInsData.setFbReqFlg("1");//FB申請要否フラグ
				}

        		dao.insertByValue(tRdmReqKnrInsData);

			} else {
				// 申請（一時保存あり）
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
				tRdmReqKnrEntity.setInsNo(StringUtils.nvl(indto.getPostInsNo(), ""));

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
        		tRdmReqKnrEntity.setTekiyoYmd(tekiyoYmd);

				if(RdmConstantsData.RDM_JKN_ADMIN.equals(loginInfo.getJokenSetCd())) {
					tRdmReqKnrEntity.setReqKngKbn("2");
				} else {
					tRdmReqKnrEntity.setReqKngKbn("1");
				}

				tRdmReqKnrEntity.setUpdShaYmd(systemDate);
				tRdmReqKnrEntity.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));
				if(StringUtils.isEmpty(indto.getUltDocNo())) {
					tRdmReqKnrEntity.setFbReqFlg("0");//FB申請要否フラグ
				}else {
					tRdmReqKnrEntity.setFbReqFlg("1");//FB申請要否フラグ
				}

				dao.update(tRdmReqKnrEntity);
			}

        	// 勤務先_申請管理
        	TRdmHcpKmuReqEntity tRdmHcpKmuReqEntity = new TRdmHcpKmuReqEntity();
        	tRdmHcpKmuReqEntity.setReqId(indto.getReqId());
        	TRdmHcpKmuReqEntity tRdmHcpKmuReqData = dao.selectByPK(tRdmHcpKmuReqEntity);


        	if(tRdmHcpKmuReqData == null) {
        		TRdmHcpKmuReqEntity tRdmHcpKmuReqInsData = new TRdmHcpKmuReqEntity();
        		tRdmHcpKmuReqInsData.setReqId(reqId);
        		tRdmHcpKmuReqInsData.setDocNo(indto.getDocNo());
        		tRdmHcpKmuReqInsData.setInsNoMt(indto.getPreInsNo());
        		tRdmHcpKmuReqInsData.setTrnKbn(StringUtils.nvl(indto.getTrnKbnCd(), ""));
        		tRdmHcpKmuReqInsData.setInsNoSk(StringUtils.nvl(indto.getPostInsNo(), ""));
        		tRdmHcpKmuReqInsData.setJobFormBf(StringUtils.nvl(indto.getPreJobForm(), ""));
        		tRdmHcpKmuReqInsData.setDeptCodeBf(StringUtils.nvl(indto.getPreDeptCode(), ""));
        		tRdmHcpKmuReqInsData.setDeptKanjiBf(StringUtils.nvl(indto.getPreDeptKj(), ""));
        		tRdmHcpKmuReqInsData.setDeptKanaBf(StringUtils.nvl(indto.getPreDeptKn(), ""));
        		tRdmHcpKmuReqInsData.setUnivPosCodeBf(indto.getPreUnivPosCode());
        		tRdmHcpKmuReqInsData.setTitleCodeBf(indto.getPreTitleCode());
        		tRdmHcpKmuReqInsData.setDccTypeBf(indto.getPreDcc());
        		tRdmHcpKmuReqInsData.setJobFormAf("Z");
        		tRdmHcpKmuReqInsData.setDeptCodeAf("9999");
        		tRdmHcpKmuReqInsData.setDeptKanjiAf("Z");
        		tRdmHcpKmuReqInsData.setDeptKanaAf("Z");
        		//tRdmHcpKmuReqInsData.setUltDocNo(indto.getUltDocNo());
        		tRdmHcpKmuReqInsData.setInsShaYmd(systemDate);
        		tRdmHcpKmuReqInsData.setInsShaId(Integer.toString(loginInfo.getJgiNo()));
        		tRdmHcpKmuReqInsData.setUpdShaYmd(systemDate);
        		tRdmHcpKmuReqInsData.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));

        		dao.insertByValue(tRdmHcpKmuReqInsData);
        	}else {
        		TRdmHcpKmuReqEntity tRdmHcpKmuReqUpdData = new TRdmHcpKmuReqEntity("updateND102Data");
        		tRdmHcpKmuReqUpdData.setReqId(reqId);
        		tRdmHcpKmuReqUpdData.setTrnKbn(StringUtils.nvl(indto.getTrnKbnCd(), ""));
        		tRdmHcpKmuReqUpdData.setInsNoSk(StringUtils.nvl(indto.getPostInsNo(), ""));
        		//ult医師コード最新化
        		SelectDocReqKnrInsChangeEntity selectDocReqKnrInsChangeEntity = new SelectDocReqKnrInsChangeEntity();
        		selectDocReqKnrInsChangeEntity.setInReqFlg(0);
        		selectDocReqKnrInsChangeEntity.setInDocNo(indto.getDocNo());
        		selectDocReqKnrInsChangeEntity.setInInsNo(indto.getPreInsNo());
//        		String tempUltDocNo;
//        		List<SelectDocReqKnrInsChangeEntity> selectDocReqKnrInsChangeList = dao.select(selectDocReqKnrInsChangeEntity);
//        		if(selectDocReqKnrInsChangeList == null) {
//        			tempUltDocNo = "";
//        		}else {
//        			tempUltDocNo = StringUtils.nvl(selectDocReqKnrInsChangeList.get(0).getUltDocNo(),"");
//        		}
//        		tRdmHcpKmuReqUpdData.setUltDocNo(tempUltDocNo);
        		//            //異動でない（異動元と異動先の施設コードが同じ、異動先のULT施設コードがnull）場合、現在の所属施設をセット
        		//        	if(indto.getPreUltInsNo().equals(indto.getPostUltInsNo()) || StringUtils.isEmpty(indto.getPostUltInsNo())) {
        		//        		tRdmHcpKmuReqUpdData.setUltInsNo(indto.getPreUltInsNo());
        		//        	}
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

//        	outdto.setForward("NC102");
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
    public void setCombo(ND309DTO indto, Boolean errFlg) {
    	//1-2 ドロップダウンリストの生成

        //異動区分
        SelectNd102TrnListEntity selectNd102TrnListEntity = new SelectNd102TrnListEntity();
        List<SelectNd102TrnListEntity> selectNd102TrnList;
        selectNd102TrnList = dao.select(selectNd102TrnListEntity);
        //表示用
        LinkedHashMap<String, String> mapTrnKbn = new LinkedHashMap<String, String>();
        //異動先施設コード保管用
        LinkedHashMap<String, String> mapTrnKbnInsNo = new LinkedHashMap<String, String>();
        mapTrnKbn.put(null, "--選択してください--");
        for (SelectNd102TrnListEntity outEntity : selectNd102TrnList) {
        	mapTrnKbn.put(outEntity.getTrnValue1(),outEntity.getValue1Kanj());
        }

        for (SelectNd102TrnListEntity outEntity : selectNd102TrnList) {
        	mapTrnKbnInsNo.put(outEntity.getTrnValue1(),outEntity.getDummyValue1());
        }

        indto.setTrnKbnInsNoCombo(mapTrnKbnInsNo);
        indto.setTrnKbnCombo(mapTrnKbn);
//        if(!(StringUtils.isEmpty(indto.getReqSts()))) {
//        	indto.setTrnKbnInsNo(indto.getPostUnivPosCode());
//        }

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

    public void setCombo(ND309DTO indto) {
    	//1-2 ドロップダウンリストの生成

        //異動区分
        SelectNd102TrnListEntity selectNd102TrnListEntity = new SelectNd102TrnListEntity();
        List<SelectNd102TrnListEntity> selectNd102TrnList;
        selectNd102TrnList = dao.select(selectNd102TrnListEntity);
        //表示用
        LinkedHashMap<String, String> mapTrnKbn = new LinkedHashMap<String, String>();
        //異動先施設コード保管用
        LinkedHashMap<String, String> mapTrnKbnInsNo = new LinkedHashMap<String, String>();
        mapTrnKbn.put(null, "--選択してください--");
        for (SelectNd102TrnListEntity outEntity : selectNd102TrnList) {
        	mapTrnKbn.put(outEntity.getTrnValue1(),outEntity.getValue1Kanj());
        }

        for (SelectNd102TrnListEntity outEntity : selectNd102TrnList) {
        	mapTrnKbnInsNo.put(outEntity.getTrnValue1(),outEntity.getDummyValue1());
        }

        indto.setTrnKbnInsNoCombo(mapTrnKbnInsNo);
        indto.setTrnKbnCombo(mapTrnKbn);
        if(!(StringUtils.isEmpty(indto.getReqSts()))) {
        	indto.setTrnKbnInsNo(indto.getPostTrnKbn());
        }

    }

	/*
	 * エラーありならtrueとし、エラーメッセージをmsgStrにセットする
	 */
	private boolean checkInput(LoginInfo loginInfo, ND309DTO indto, boolean fullchkFlg) {
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
		//      承認コメント                                ３００文字を超えている場合
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

		if(!fullchkFlg) {

			// 整合性チェック
			// 同じ医師で同じ施設に対しての申請がすでに存在している場合

			SelectNd101MainDataEntity paramEntity = new SelectNd101MainDataEntity();
			paramEntity.setSqlId("selectNd101DupData");
			paramEntity.setInDocNo(indto.getDocNo());
			paramEntity.setInInsNo(indto.getPreInsNo());
			paramEntity.setInReqId(StringUtils.setEmptyToNull(indto.getReqId()));
			List<SelectNd101MainDataEntity> mainDataEntityList = dao.select(paramEntity);
			if (mainDataEntityList.size() > 0) {
				// 重複する申請が行われています。（医師コード）
				tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.W008).replace("項目名", "医師コード") + "\n";
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
					tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.W007) + "\n";
					errChk = true;
				}
			}

			//			// 整合性チェック
			//			// 申請時に既に医師削除申請がされている場合
//			if(!indto.getAlertIgnore().equals("1")) {
				SelectNd101MainDataEntity paramEntity2 = new SelectNd101MainDataEntity();
				paramEntity2.setSqlId("selectNd101DelData");
				paramEntity2.setInDocNo(indto.getDocNo());
				List<SelectNd101MainDataEntity> mainDataEntityList2 = dao.select(paramEntity2);
				if (mainDataEntityList2.size() > 0) {
					// 廃業・死亡の申請がされています。よろしいですか？
//					alertErrMsg2 += loginInfo.getMsgData(RdmConstantsData.I010) + "\n";
					tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.W038) + "\n";
					errChk = true;
				}
//			}

			// 整合性チェック
			// 申請時に既に医師削除申請がされている場合（承認済）

			SelectNd101MainDataEntity paramEntity4 = new SelectNd101MainDataEntity();
			paramEntity4.setSqlId("selectNd101DelAppdData");
			paramEntity4.setInDocNo(indto.getDocNo());
			List<SelectNd101MainDataEntity> mainDataEntityList4 = dao.select(paramEntity4);
			if (mainDataEntityList4.size() > 0) {
				// 医師免許返納・死亡状態で、申請できません。
				tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.W040) + "\n";
				errChk = true;
			}

			// 整合性チェック
			//
			SelectNd102MultipleWorkCheckEntity multipleWorkCheckEntity = new SelectNd102MultipleWorkCheckEntity();
			multipleWorkCheckEntity.setInDocNo(indto.getDocNo());
			List<SelectNd102MultipleWorkCheckEntity> multipleWorkCheckList = dao.select(multipleWorkCheckEntity);
			if(multipleWorkCheckList.size() >= 2) {
				// 通常勤務先施設数が2以上のため申請できません。
				tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.W037) + "\n";
				errChk = true;
			}

			// 整合性チェック
			//
			SelectNd102ClosedCheckEntity closedCheckEntity = new SelectNd102ClosedCheckEntity();
			closedCheckEntity.setInDocNo(indto.getDocNo());
			List<SelectNd102ClosedCheckEntity> closedCheckList = dao.select(closedCheckEntity);
			if(!(closedCheckList.isEmpty())) {
				// 医師免許返納・死亡の申請されているため申請できません。
				tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.W038) + "\n";
				errChk = true;
			}

			// 整合性チェック
			//
			if(indto.getMrAdminFlg().equals("1")) {
				SelectNd102MrDummyCheckEntity mrDummyCheckEntity = new SelectNd102MrDummyCheckEntity();
				mrDummyCheckEntity.setInInsNo(indto.getPreInsNo());
				List<SelectNd102MrDummyCheckEntity> MrDummyCheckList = dao.select(mrDummyCheckEntity);
				if(!(MrDummyCheckList.isEmpty())) {
					// 医療機関以外の施設から医療機関以外の施設への申請はできません。
					tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.W039) + "\n";
					errChk = true;
				}
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
					tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.E003) + "\n";
					errChk = true;

				}
			}
		}

		if(errChk) {//エラーありなのでメッセージをセットする
			indto.setMsgStr(tmpMsgStr);
			indto.setAlertMsgStr(alertErrMsg);
        	indto.setAlertMsgStr2(alertErrMsg2);
        	indto.setAlertIgnore("0");
		}
		return errChk;
	}
}
