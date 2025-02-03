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
import jp.co.takeda.rdm.dto.LnkTrtData;
import jp.co.takeda.rdm.dto.NF211DTO;
import jp.co.takeda.rdm.entity.join.MRdmHcoMstEntity;
import jp.co.takeda.rdm.entity.join.RdmCommonEntity;
import jp.co.takeda.rdm.entity.join.SelectLnkTrtDataEntity;
import jp.co.takeda.rdm.entity.join.SelectNF211MainDataEntity;
import jp.co.takeda.rdm.entity.join.SeqRdmReqIdEntity;
import jp.co.takeda.rdm.entity.join.TRdmHcoLnkNxtReqEntity;
import jp.co.takeda.rdm.entity.join.TRdmHcoLnkReqEntity;
import jp.co.takeda.rdm.entity.join.TRdmReqKnrEntity;
import jp.co.takeda.rdm.util.DateUtils;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;

/**
 * Serviceクラス（NF211)
 * @generated
 */
@Named
public class NF211Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(NF211Service.class);

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
     * @param indto NF211DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(NF211DTO indto) {
        BaseDTO outdto = indto;
        // START UOC
        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
        List<LnkTrtData> lnkTrtDataList = new ArrayList<LnkTrtData>();

        if ("0".equals(indto.getDisplayKbn())) {
    		// 施設固定コードで初期データ作成
        	// 武田紐領域別区分が'0'（来期用紐付け(武田紐)）
    		MRdmHcoMstEntity paramEntity = new MRdmHcoMstEntity();
    		paramEntity.setInsNo(indto.getInsNo());
    		MRdmHcoMstEntity mainDataEntity = dao.selectByPK(paramEntity);

    		indto.setReqStsNm("");
    		indto.setReqYmdhms("");
    		// 施設
        	indto.setInsAbbrName(StringUtils.nvl(mainDataEntity.getInsAbbrName(), ""));
        	indto.setInsAddr(StringUtils.nvl(mainDataEntity.getInsAddr(), ""));
        	indto.setInsSbt(StringUtils.nvl(mainDataEntity.getInsSbt(), ""));

        	// 領域・品目グループ
        	indto.setTrtPrdGrp("00Z");

        	// 適用日
        	// 翌期月初をRDM_COMMON.GET_NEXT_TERM_FIRSTDAYから取得する
        	// 現在日付を取得
            Date systemDate = DateUtils.getNowDate();
            SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMdd");
            String sysDate = fmtDate.format(systemDate);

        	RdmCommonEntity rdmCommonEntity = new RdmCommonEntity("getNextTermFirstday");
        	rdmCommonEntity.setInVBatDate(sysDate);
        	List<RdmCommonEntity> rdmCommonEntityList = dao.select(rdmCommonEntity);

        	if(rdmCommonEntityList.size() > 0) {
		    	// "yyyyMMdd"から"yyyy-MM-dd"に変換
		    	String tekiyoYmd = rdmCommonEntityList.get(0).getNextTermFirstday();
				if(tekiyoYmd != null && tekiyoYmd.length() == 8) {
					StringBuilder sbUrlYmd = new StringBuilder();
					sbUrlYmd.append(tekiyoYmd.substring(0,4));
					sbUrlYmd.append("-");
					sbUrlYmd.append(tekiyoYmd.substring(4,6));
					sbUrlYmd.append("-");
					sbUrlYmd.append(tekiyoYmd.substring(6,8));
					tekiyoYmd = sbUrlYmd.toString();
				}

		    	indto.setTekiyoYmd(tekiyoYmd);
        	}

    		// TODO ログイン関連できてから確認
//        		indto.setReqShzNm(loginInfo.getShzNm());
    		indto.setReqJgiName(loginInfo.getJgiName());
    		indto.setReqJgiNo(loginInfo.getJgiNo());
//        		indto.setReqBrCd(loginInfo.getBrCd());
//        		indto.setReqDistCd(loginInfo.getDistCd());

        } else if ("1".equals(indto.getDisplayKbn())) {
        	// 施設固定コードで初期データ作成
        	// 武田紐領域別区分が'1'（領域別紐付け）
        	MRdmHcoMstEntity paramEntity = new MRdmHcoMstEntity();
    		paramEntity.setInsNo(indto.getInsNo());
    		MRdmHcoMstEntity mainDataEntity = dao.selectByPK(paramEntity);

    		indto.setReqStsNm("");
    		indto.setReqYmdhms("");
    		// 施設
        	indto.setInsAbbrName(StringUtils.nvl(mainDataEntity.getInsAbbrName(), ""));
        	indto.setInsAddr(StringUtils.nvl(mainDataEntity.getInsAddr(), ""));
        	indto.setInsSbt(StringUtils.nvl(mainDataEntity.getInsSbt(), ""));

        	// 領域・品目グループ
        	indto.setTrtPrdGrp("");

        	// 適用日
        	// 翌営業日をRDM_COMMON.GET_NEXT_BIZDAYから取得する
        	// 現在日付を取得
            Date systemDate = DateUtils.getNowDate();
            SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMdd");
            String sysDate = fmtDate.format(systemDate);

        	RdmCommonEntity rdmCommonEntity = new RdmCommonEntity("getNextBizday");
        	rdmCommonEntity.setInVBatDate(sysDate);
        	List<RdmCommonEntity> rdmCommonEntityList = dao.select(rdmCommonEntity);

        	if(rdmCommonEntityList.size() > 0) {
	        	// "yyyyMMdd"から"yyyy-MM-dd"に変換
	        	String tekiyoYmd = rdmCommonEntityList.get(0).getNextBizday();
	    		if(tekiyoYmd != null && tekiyoYmd.length() == 8) {
	    			StringBuilder sbUrlYmd = new StringBuilder();
	    			sbUrlYmd.append(tekiyoYmd.substring(0,4));
	    			sbUrlYmd.append("-");
	    			sbUrlYmd.append(tekiyoYmd.substring(4,6));
	    			sbUrlYmd.append("-");
	    			sbUrlYmd.append(tekiyoYmd.substring(6,8));
	    			tekiyoYmd = sbUrlYmd.toString();
	    		}

	        	indto.setTekiyoYmd(tekiyoYmd);
        	}

    		// TODO ログイン関連できてから確認
//        		indto.setReqShzNm(loginInfo.getShzNm());
    		indto.setReqJgiName(loginInfo.getJgiName());
    		indto.setReqJgiNo(loginInfo.getJgiNo());
//        		indto.setReqBrCd(loginInfo.getBrCd());
//        		indto.setReqDistCd(loginInfo.getDistCd());

        	// 親施設リスト
    		SelectLnkTrtDataEntity trtParamEntity = new SelectLnkTrtDataEntity();
    		trtParamEntity.setInInsNo(indto.getInsNo());
    		List<SelectLnkTrtDataEntity> trtDataEntityList = dao.select(trtParamEntity);
    		for (SelectLnkTrtDataEntity sEntity : trtDataEntityList) {
    			if(sEntity != null) {
        			LnkTrtData sData = new LnkTrtData();
        			setLnkTrtData(sEntity,sData);
        			lnkTrtDataList.add(sData);
    			}
    		}
    		indto.setLnkTrtDataList(lnkTrtDataList);

        } else if ("2".equals(indto.getDisplayKbn())) {
        	// 申請データ（一時保存含む）を参照
        	// 武田紐領域別区分が'0'（来期用紐付け(武田紐)）
        	SelectNF211MainDataEntity paramEntity = new SelectNF211MainDataEntity();
    		paramEntity.setInReqId(indto.getReqId());
    		List<SelectNF211MainDataEntity> mainDataEntityList = dao.select(paramEntity);
    		SelectNF211MainDataEntity mainDataEntity = mainDataEntityList.get(0);

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

    		// 施設情報
    		indto.setInsNo(StringUtils.nvl(mainDataEntity.getInsNo(), ""));
        	indto.setInsAbbrName(StringUtils.nvl(mainDataEntity.getInsAbbrName(), ""));
        	indto.setInsAddr(StringUtils.nvl(mainDataEntity.getInsAddr(), ""));
        	indto.setInsSbt(StringUtils.nvl(mainDataEntity.getInsSbt(), ""));

        	// 施設紐付け情報
        	indto.setTrtPrdGrp("00Z");

        	// 適用日を"yyyy-MM-dd"に変換
    		if(mainDataEntity.getTekiyoYmd() != null && mainDataEntity.getTekiyoYmd().length() == 8) {
    			StringBuilder sbTekiyoYmd = new StringBuilder();
    			sbTekiyoYmd.append(mainDataEntity.getTekiyoYmd().substring(0,4));
    			sbTekiyoYmd.append("-");
    			sbTekiyoYmd.append(mainDataEntity.getTekiyoYmd().substring(4,6));
    			sbTekiyoYmd.append("-");
    			sbTekiyoYmd.append(mainDataEntity.getTekiyoYmd().substring(6,8));
    			indto.setTekiyoYmd(sbTekiyoYmd.toString());
    		}

    		indto.setMainInsCd(StringUtils.nvl(mainDataEntity.getMainInsCd(), ""));
    		indto.setMainInsNm(StringUtils.nvl(mainDataEntity.getMainInsNm(), ""));
        	indto.setMainInsAddr(StringUtils.nvl(mainDataEntity.getMainInsAddr(), ""));
        	indto.setMainInsSbt(StringUtils.nvl(mainDataEntity.getMainInsSbt(), ""));
        	indto.setInsSbtAf(StringUtils.nvl(mainDataEntity.getInsSbtAf(), ""));

        	indto.setReqComment(StringUtils.nvl(mainDataEntity.getReqComment(), ""));
        	indto.setAprMemo(StringUtils.nvl(mainDataEntity.getAprMemo(), ""));
        	indto.setShnFlg(StringUtils.nvl(mainDataEntity.getShnFlg(), ""));

        } else if ("3".equals(indto.getDisplayKbn())) {
    		// 申請データ（一時保存含む）を参照
        	// 武田紐領域別区分が'1'（領域別紐付け）
    		SelectNF211MainDataEntity paramEntity = new SelectNF211MainDataEntity("selectNF211ReqTrtData");
    		paramEntity.setInReqId(indto.getReqId());
    		List<SelectNF211MainDataEntity> mainDataEntityList = dao.select(paramEntity);
    		SelectNF211MainDataEntity mainDataEntity = mainDataEntityList.get(0);

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

    		// 施設情報
    		indto.setInsNo(StringUtils.nvl(mainDataEntity.getInsNo(), ""));
        	indto.setInsAbbrName(StringUtils.nvl(mainDataEntity.getInsAbbrName(), ""));
        	indto.setInsAddr(StringUtils.nvl(mainDataEntity.getInsAddr(), ""));
        	indto.setInsSbt(StringUtils.nvl(mainDataEntity.getInsSbt(), ""));

        	// 施設紐付け情報
        	indto.setTrtPrdGrp(mainDataEntity.getTrtCd() + mainDataEntity.getHinGCd());

        	// 適用日を"yyyy-MM-dd"に変換
    		if(mainDataEntity.getTekiyoYmd() != null && mainDataEntity.getTekiyoYmd().length() == 8) {
    			StringBuilder sbTekiyoYmd = new StringBuilder();
    			sbTekiyoYmd.append(mainDataEntity.getTekiyoYmd().substring(0,4));
    			sbTekiyoYmd.append("-");
    			sbTekiyoYmd.append(mainDataEntity.getTekiyoYmd().substring(4,6));
    			sbTekiyoYmd.append("-");
    			sbTekiyoYmd.append(mainDataEntity.getTekiyoYmd().substring(6,8));
    			indto.setTekiyoYmd(sbTekiyoYmd.toString());
    		}

    		indto.setMainInsCd(StringUtils.nvl(mainDataEntity.getMainInsCd(), ""));
    		indto.setMainInsNm(StringUtils.nvl(mainDataEntity.getMainInsNm(), ""));
        	indto.setMainInsAddr(StringUtils.nvl(mainDataEntity.getMainInsAddr(), ""));
        	indto.setInsTanto(StringUtils.nvl(mainDataEntity.getJgiName(), ""));
        	indto.setMainInsSbt(StringUtils.nvl(mainDataEntity.getMainInsSbt(), ""));
        	indto.setInsSbtAf(StringUtils.nvl(mainDataEntity.getInsSbtAf(), ""));

        	indto.setReqComment(StringUtils.nvl(mainDataEntity.getReqComment(), ""));
        	indto.setAprMemo(StringUtils.nvl(mainDataEntity.getAprMemo(), ""));
        	indto.setShnFlg(StringUtils.nvl(mainDataEntity.getShnFlg(), ""));

    		// 親施設リスト
    		SelectLnkTrtDataEntity trtParamEntity = new SelectLnkTrtDataEntity();
    		trtParamEntity.setInInsNo(indto.getInsNo());
    		List<SelectLnkTrtDataEntity> trtDataEntityList = dao.select(trtParamEntity);
    		for (SelectLnkTrtDataEntity sEntity : trtDataEntityList) {
    			if(sEntity != null) {
        			LnkTrtData sData = new LnkTrtData();
        			setLnkTrtData(sEntity,sData);
        			lnkTrtDataList.add(sData);
    			}
    		}

    		indto.setLnkTrtDataList(lnkTrtDataList);
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
     * 親施設リストセット
     * @param sEntity
     * @param sData
     */
    private void setLnkTrtData(SelectLnkTrtDataEntity sEntity, LnkTrtData sData) {

    	sData.setTrtGrpCd(StringUtils.nvl(sEntity.getTrtGrpCd(), ""));
    	sData.setTrtCd(StringUtils.nvl(sEntity.getTrtCd(), ""));
    	sData.setTrtNm(StringUtils.nvl(sEntity.getTrtNm(), ""));
    	sData.setHinGCd(StringUtils.nvl(sEntity.getHinGCd(), ""));
    	sData.setHinGName(StringUtils.nvl(sEntity.getHinGName(), ""));
    	sData.setInsAbbrName(StringUtils.nvl(sEntity.getInsAbbrName(), ""));
    	sData.setHoInsType(StringUtils.nvl(sEntity.getHoInsType(), ""));
    	sData.setInsAddr(StringUtils.nvl(sEntity.getInsAddr(), ""));
    	sData.setJgiName(StringUtils.nvl(sEntity.getJgiName(), ""));
	}

    /**
     * コンボ作成
     * @param indto NF211DTO
     * @return なし
     * @customizable
     */
    private void createCombo(NF211DTO indto){
    	LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
    	// 領域・品目グループ
    	SelectLnkTrtDataEntity inEntityCmb = new SelectLnkTrtDataEntity("selectTrtPrdComboData");
    	inEntityCmb.setInInsNo(indto.getInsNo());
    	if("JKN0023".equals(indto.getLoginJokenSetCd())) {
    		// ※MR権限の場合のみ ログインユーザ情報.領域コード
    		inEntityCmb.setInTrtCd(indto.getLoginTrtCd());
    	}
    	// TODO sqlでデータ取得のためコメントアウトした箇所を解除する
        List<SelectLnkTrtDataEntity> outMainList = dao.select(inEntityCmb);
        LinkedHashMap<String, String> mapTrtPrdGrp = new LinkedHashMap<String, String>();
        mapTrtPrdGrp.put("", "--選択してください--");
        for (SelectLnkTrtDataEntity outEntity : outMainList) {
        	if(outEntity != null) {
	        	mapTrtPrdGrp.put(outEntity.getTrtCd() + outEntity.getHinGCd(),
	        				outEntity.getTrtNm()+"・"+outEntity.getHinGName());
        	}
        }
        indto.setTrtPrdGrpCombo(mapTrtPrdGrp);
    }

    /**
     *
     * @param indto
     * @return
     */
    @Transactional
    public BaseDTO cancel(NF211DTO indto) {
        BaseDTO outdto = indto;
        // DropDownList作成
        createCombo(indto);

        // START UOC
        // 申請管理を物理削除
        TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity();
        tRdmReqKnrEntity.setReqId(indto.getReqId());
        dao.deleteByPK(tRdmReqKnrEntity);

        // 武田紐親子_来期用_申請管理を物理削除
        TRdmHcoLnkNxtReqEntity tRdmHcoLnkNxtReqEntity = new TRdmHcoLnkNxtReqEntity();
        tRdmHcoLnkNxtReqEntity.setReqId(indto.getReqId());
        dao.deleteByPK(tRdmHcoLnkNxtReqEntity);

        // 領域品目グループ別親子_申請管理を物理削除
        TRdmHcoLnkReqEntity tRdmHcoLnkReqEntity = new TRdmHcoLnkReqEntity();
        tRdmHcoLnkReqEntity.setReqId(indto.getReqId());
        dao.deleteByPK(tRdmHcoLnkReqEntity);

        // END UOC
        return outdto;
    }

	/**
     * イベント処理
     * @param indto NF211DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO register(NF211DTO indto) {
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

        // エラーチェック
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
        	tRdmReqKnrInsData.setReqType("11");
        	tRdmReqKnrInsData.setReqStsCd("01");

        	String tekiyoYmd = indto.getTekiyoYmd();
        	if(tekiyoYmd != null) {
        		tekiyoYmd = tekiyoYmd.replace("-", "");
        	}
        	tRdmReqKnrInsData.setTekiyoYmd(tekiyoYmd);

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
        	TRdmReqKnrEntity tRdmReqKnrUpdData = new TRdmReqKnrEntity("updateNF211Data");
        	tRdmReqKnrUpdData.setReqId(reqId);

        	if("13".equals(indto.getReqStsCd())) {
        		tRdmReqKnrUpdData.setReqStsCd("11");
        	} else {
        		tRdmReqKnrUpdData.setReqStsCd("01");
        	}
        	String tekiyoYmd = indto.getTekiyoYmd();
        	if(tekiyoYmd != null) {
        		tekiyoYmd = tekiyoYmd.replace("-", "");
        	}
        	tRdmReqKnrUpdData.setTekiyoYmd(tekiyoYmd);
        	tRdmReqKnrUpdData.setReqComment(indto.getReqComment());
        	tRdmReqKnrUpdData.setUpdShaYmd(sysDate);
        	tRdmReqKnrUpdData.setUpdShaId(indto.getLoginJgiNo());

        	dao.update(tRdmReqKnrUpdData);
        }

        // 武田紐親子_来期用_申請管理
        TRdmHcoLnkNxtReqEntity tRdmHcoLnkNxtReqEntity = new TRdmHcoLnkNxtReqEntity();
        tRdmHcoLnkNxtReqEntity.setReqId(reqId);
        TRdmHcoLnkNxtReqEntity tRdmHcoLnkNxtReqData = dao.selectByPK(tRdmHcoLnkNxtReqEntity);

        if(tRdmHcoLnkNxtReqData == null) {
        	// 新規登録
        	TRdmHcoLnkNxtReqEntity tRdmHcoLnkNxtReqInsData = new TRdmHcoLnkNxtReqEntity();
        	tRdmHcoLnkNxtReqInsData.setReqId(reqId);
        	tRdmHcoLnkNxtReqInsData.setTrtCd("00");
        	tRdmHcoLnkNxtReqInsData.setInsNo(indto.getInsNo());
        	tRdmHcoLnkNxtReqInsData.setMainInsFlgBf("1");
        	tRdmHcoLnkNxtReqInsData.setMainInsNoAf(indto.getMainInsCd());
        	tRdmHcoLnkNxtReqInsData.setMainInsFlgAf("0");
        	tRdmHcoLnkNxtReqInsData.setInsSbtAf(indto.getMainInsSbt());
        	tRdmHcoLnkNxtReqInsData.setInsShaYmd(sysDate);
        	tRdmHcoLnkNxtReqInsData.setInsShaId(indto.getLoginJgiNo());
        	tRdmHcoLnkNxtReqInsData.setUpdShaYmd(sysDate);
        	tRdmHcoLnkNxtReqInsData.setUpdShaId(indto.getLoginJgiNo());

        	dao.insertByValue(tRdmHcoLnkNxtReqInsData);

        } else {
        	// 更新
        	TRdmHcoLnkNxtReqEntity tRdmHcoLnkNxtReqUpdData = new TRdmHcoLnkNxtReqEntity("updateNF211Data");
        	tRdmHcoLnkNxtReqUpdData.setReqId(reqId);
        	tRdmHcoLnkNxtReqUpdData.setMainInsNoAf(indto.getMainInsCd());
        	tRdmHcoLnkNxtReqUpdData.setInsSbtAf(indto.getMainInsSbt());
        	tRdmHcoLnkNxtReqUpdData.setUpdShaYmd(sysDate);
        	tRdmHcoLnkNxtReqUpdData.setUpdShaId(indto.getLoginJgiNo());

        	dao.update(tRdmHcoLnkNxtReqUpdData);
        }

        // 領域品目グループ別親子_申請管理
        TRdmHcoLnkReqEntity tRdmHcoLnkReqEntity = new TRdmHcoLnkReqEntity();
        tRdmHcoLnkReqEntity.setReqId(reqId);
        TRdmHcoLnkReqEntity tRdmHcoLnkReqData = dao.selectByPK(tRdmHcoLnkReqEntity);

        if(tRdmHcoLnkReqData == null) {
        	// 新規登録
        	TRdmHcoLnkReqEntity tRdmHcoLnkReqInsData = new TRdmHcoLnkReqEntity();
        	tRdmHcoLnkReqInsData.setReqId(reqId);

        	String trtPrdCd = indto.getTrtPrdGrp();
        	if(trtPrdCd != null && trtPrdCd.length() > 1) {
        		tRdmHcoLnkReqInsData.setTrtCd(trtPrdCd.substring(0,2));
        	}
        	if(trtPrdCd != null && trtPrdCd.length() > 2) {
        		tRdmHcoLnkReqInsData.setHinGCd(trtPrdCd.substring(2));
        	}

        	tRdmHcoLnkReqInsData.setInsNo(indto.getInsNo());
        	tRdmHcoLnkReqInsData.setMainInsFlgBf("1");
        	tRdmHcoLnkReqInsData.setMainInsNoAf(indto.getMainInsCd());
        	tRdmHcoLnkReqInsData.setMainInsFlgAf("0");
        	tRdmHcoLnkReqInsData.setInsSbtAf(indto.getMainInsSbt());
        	tRdmHcoLnkReqInsData.setInsShaYmd(sysDate);
        	tRdmHcoLnkReqInsData.setInsShaId(indto.getLoginJgiNo());
        	tRdmHcoLnkReqInsData.setUpdShaYmd(sysDate);
        	tRdmHcoLnkReqInsData.setUpdShaId(indto.getLoginJgiNo());

        	dao.insertByValue(tRdmHcoLnkReqInsData);

        } else {
        	// 更新
        	TRdmHcoLnkReqEntity tRdmHcoLnkReqUpdData = new TRdmHcoLnkReqEntity("updateNF211Data");
        	tRdmHcoLnkReqUpdData.setReqId(reqId);

        	String trtPrdCd = indto.getTrtPrdGrp();
        	if(trtPrdCd != null && trtPrdCd.length() > 1) {
        		tRdmHcoLnkReqUpdData.setTrtCd(trtPrdCd.substring(0,2));
        	}
        	if(trtPrdCd != null && trtPrdCd.length() > 2) {
        		tRdmHcoLnkReqUpdData.setHinGCd(trtPrdCd.substring(2));
        	}

        	tRdmHcoLnkReqUpdData.setMainInsNoAf(indto.getMainInsCd());
        	tRdmHcoLnkReqUpdData.setInsSbtAf(indto.getMainInsSbt());
        	tRdmHcoLnkReqUpdData.setUpdShaYmd(sysDate);
        	tRdmHcoLnkReqUpdData.setUpdShaId(indto.getLoginJgiNo());

        	dao.update(tRdmHcoLnkReqUpdData);
        }

    	indto.setReqId(reqId);
    	if("13".equals(indto.getReqStsCd())) {
    		indto.setReqStsCd("11");
    	} else {
    		indto.setReqStsCd("01");
    	}
    	if("0".equals(indto.getTkdTrtKbn())) {
			indto.setDisplayKbn("2");
		} else {
			indto.setDisplayKbn("3");
		}

    	outdto = init(indto);

		// エラーメッセージ表示エリアに（I005）「保存が完了しました。」完了メッセージを表示
		String infoMsg = loginInfo.getMsgData(RdmConstantsData.I005) + "\n";
		indto.setMsgStr(infoMsg);

        // END UOC
        return outdto;
    }

	/**
     * イベント処理
     * @param indto NF211DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO shnComp(NF211DTO indto) {
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
}
