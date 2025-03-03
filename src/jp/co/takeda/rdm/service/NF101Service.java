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
import jp.co.takeda.rdm.entity.join.SelectComboListEntity;
import jp.co.takeda.rdm.entity.join.SelectNF012MainDataEntity;
import jp.co.takeda.rdm.entity.join.SelectNF101MainDataEntity;
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

    		// 基本情報(ULT)
    		indto.setShisetsuKbn(StringUtils.nvl(mainDataEntity.getShisetsuKbn(), ""));
    		indto.setKeieitaiNm(StringUtils.nvl(mainDataEntity.getKeieitaiNm(), ""));

    		// 基本情報(来期)
    		indto.setNextPharmType(StringUtils.nvl(mainDataEntity.getNextPharmType(), ""));
    		indto.setNextInsRank(StringUtils.nvl(mainDataEntity.getNextInsRank(), ""));
    		indto.setNextRegVisType(StringUtils.nvl(mainDataEntity.getNextRegVisType(), ""));
    		indto.setNextImpHosType(StringUtils.nvl(mainDataEntity.getNextImpHosType(), ""));
    		indto.setNextHoInsType(StringUtils.nvl(mainDataEntity.getNextHoInsType(), ""));
    		indto.setNextManageCd(StringUtils.nvl(mainDataEntity.getNextManageCd(), ""));
    		indto.setNextVacInsType(StringUtils.nvl(mainDataEntity.getNextVacInsType(), ""));
    		indto.setNextVacVisitType(StringUtils.nvl(mainDataEntity.getNextVacVisitType(), ""));

    		// 病床数
    		indto.setBedCntBase(StringUtils.nvl(mainDataEntity.getBedCntBase(), "0"));
    		indto.setBedCnt01(StringUtils.nvl(mainDataEntity.getBedCnt01(), "0"));
    		indto.setBedCnt02(StringUtils.nvl(mainDataEntity.getBedCnt02(), "0"));
    		indto.setBedCnt03(StringUtils.nvl(mainDataEntity.getBedCnt03(), "0"));
    		indto.setBedCnt04(StringUtils.nvl(mainDataEntity.getBedCnt04(), "0"));
    		indto.setBedCnt05(StringUtils.nvl(mainDataEntity.getBedCnt05(), "0"));
    		indto.setBedCnt06(StringUtils.nvl(mainDataEntity.getBedCnt06(), "0"));
    		indto.setBedCnt07(StringUtils.nvl(mainDataEntity.getBedCnt07(), "0"));
    		indto.setBedsTot(StringUtils.nvl(mainDataEntity.getBedsTot(), "0"));
    		indto.setMedBedsTot(StringUtils.nvl(mainDataEntity.getMedBedsTot(), "0"));

    		indto.setUltBedCntBase(StringUtils.nvl(mainDataEntity.getUltBedCntBase(), "0"));
    		indto.setUltBedCnt01(StringUtils.nvl(mainDataEntity.getUltBedCnt01(), "0"));
    		indto.setUltBedCnt03(StringUtils.nvl(mainDataEntity.getUltBedCnt03(), "0"));
    		indto.setUltBedCnt04(StringUtils.nvl(mainDataEntity.getUltBedCnt04(), "0"));
    		indto.setUltBedCnt05(StringUtils.nvl(mainDataEntity.getUltBedCnt05(), "0"));
    		indto.setUltBedCnt07(StringUtils.nvl(mainDataEntity.getUltBedCnt07(), "0"));
    		indto.setUltBedCnt02("0");
    		indto.setUltBedCnt06("0");

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

    		indto.setNextBedCntBase(StringUtils.nvl(mainDataEntity.getNextBedCntBase(), "0"));
    		indto.setNextBedCnt01(StringUtils.nvl(mainDataEntity.getNextBedCnt01(), "0"));
    		indto.setNextBedCnt02(StringUtils.nvl(mainDataEntity.getNextBedCnt02(), "0"));
    		indto.setNextBedCnt03(StringUtils.nvl(mainDataEntity.getNextBedCnt03(), "0"));
    		indto.setNextBedCnt04(StringUtils.nvl(mainDataEntity.getNextBedCnt04(), "0"));
    		indto.setNextBedCnt05(StringUtils.nvl(mainDataEntity.getNextBedCnt05(), "0"));
    		indto.setNextBedCnt06(StringUtils.nvl(mainDataEntity.getNextBedCnt06(), "0"));
    		indto.setNextBedCnt07(StringUtils.nvl(mainDataEntity.getNextBedCnt07(), "0"));
    		indto.setNextBedsTot(StringUtils.nvl(mainDataEntity.getNextBedsTot(), "0"));
    		indto.setNextMedBedsTot(StringUtils.nvl(mainDataEntity.getNextMedBedsTot(), "0"));

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

    		// 基本情報(ULT)
    		indto.setShisetsuKbn(StringUtils.nvl(mainDataEntity.getShisetsuKbn(), ""));
    		indto.setKeieitaiNm(StringUtils.nvl(mainDataEntity.getKeieitaiNm(), ""));

    		// 基本情報(来期)
    		indto.setNextPharmType(StringUtils.nvl(mainDataEntity.getNextPharmType(), ""));
    		indto.setNextInsRank(StringUtils.nvl(mainDataEntity.getNextInsRank(), ""));
    		indto.setNextRegVisType(StringUtils.nvl(mainDataEntity.getNextRegVisType(), ""));
    		indto.setNextImpHosType(StringUtils.nvl(mainDataEntity.getNextImpHosType(), ""));
    		indto.setNextHoInsType(StringUtils.nvl(mainDataEntity.getNextHoInsType(), ""));
    		indto.setNextManageCd(StringUtils.nvl(mainDataEntity.getNextManageCd(), ""));
    		indto.setNextVacInsType(StringUtils.nvl(mainDataEntity.getNextVacInsType(), ""));
    		indto.setNextVacVisitType(StringUtils.nvl(mainDataEntity.getNextVacVisitType(), ""));

    		// 病床数
    		indto.setBedCntBase(StringUtils.nvl(mainDataEntity.getBedCntBase(), "0"));
    		indto.setBedCnt01(StringUtils.nvl(mainDataEntity.getBedCnt01(), "0"));
    		indto.setBedCnt02(StringUtils.nvl(mainDataEntity.getBedCnt02(), "0"));
    		indto.setBedCnt03(StringUtils.nvl(mainDataEntity.getBedCnt03(), "0"));
    		indto.setBedCnt04(StringUtils.nvl(mainDataEntity.getBedCnt04(), "0"));
    		indto.setBedCnt05(StringUtils.nvl(mainDataEntity.getBedCnt05(), "0"));
    		indto.setBedCnt06(StringUtils.nvl(mainDataEntity.getBedCnt06(), "0"));
    		indto.setBedCnt07(StringUtils.nvl(mainDataEntity.getBedCnt07(), "0"));
    		indto.setBedsTot(StringUtils.nvl(mainDataEntity.getBedsTot(), "0"));
    		indto.setMedBedsTot(StringUtils.nvl(mainDataEntity.getMedBedsTot(), "0"));

    		indto.setUltBedCntBase(StringUtils.nvl(mainDataEntity.getUltBedCntBase(), "0"));
    		indto.setUltBedCnt01(StringUtils.nvl(mainDataEntity.getUltBedCnt01(), "0"));
    		indto.setUltBedCnt03(StringUtils.nvl(mainDataEntity.getUltBedCnt03(), "0"));
    		indto.setUltBedCnt04(StringUtils.nvl(mainDataEntity.getUltBedCnt04(), "0"));
    		indto.setUltBedCnt05(StringUtils.nvl(mainDataEntity.getUltBedCnt05(), "0"));
    		indto.setUltBedCnt07(StringUtils.nvl(mainDataEntity.getUltBedCnt07(), "0"));
    		indto.setUltBedCnt02("0");
    		indto.setUltBedCnt06("0");

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

    		indto.setNextBedCntBase(StringUtils.nvl(mainDataEntity.getNextBedCntBase(), "0"));
    		indto.setNextBedCnt01(StringUtils.nvl(mainDataEntity.getNextBedCnt01(), "0"));
    		indto.setNextBedCnt02(StringUtils.nvl(mainDataEntity.getNextBedCnt02(), "0"));
    		indto.setNextBedCnt03(StringUtils.nvl(mainDataEntity.getNextBedCnt03(), "0"));
    		indto.setNextBedCnt04(StringUtils.nvl(mainDataEntity.getNextBedCnt04(), "0"));
    		indto.setNextBedCnt05(StringUtils.nvl(mainDataEntity.getNextBedCnt05(), "0"));
    		indto.setNextBedCnt06(StringUtils.nvl(mainDataEntity.getNextBedCnt06(), "0"));
    		indto.setNextBedCnt07(StringUtils.nvl(mainDataEntity.getNextBedCnt07(), "0"));
    		indto.setNextBedsTot(StringUtils.nvl(mainDataEntity.getNextBedsTot(), "0"));
    		indto.setNextMedBedsTot(StringUtils.nvl(mainDataEntity.getNextMedBedsTot(), "0"));

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
/*
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
        if(indto.getInsPcode() != null
        		&& ((indto.getInsPcode().length() != 0 && indto.getInsPcode().length() != 7 && indto.getInsPcode().length() != 8)
        		|| (indto.getInsPcode().length() == 8 && !chkPostcode(indto.getInsPcode())
        		|| (indto.getInsPcode().length() == 7 && !StringUtils.isNumeric(indto.getInsPcode()))))) {
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
        	tRdmReqKnrInsData.setReqType("02");
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

        // 施設_申請管理
        TRdmHcoReqEntity tRdmHcoReqEntity = new TRdmHcoReqEntity();
        tRdmHcoReqEntity.setReqId(reqId);
        TRdmHcoReqEntity tRdmHcoReqData = dao.selectByPK(tRdmHcoReqEntity);

        // 管理者権限
        boolean knr = RdmConstantsData.RDM_JKN_ADMIN.equals(indto.getLoginJokenSetCd());

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
*/
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
/*
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
*/
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
/*
       // START UOC
       // 申請管理を物理削除
       TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity();
       tRdmReqKnrEntity.setReqId(indto.getReqId());
       dao.deleteByPK(tRdmReqKnrEntity);

       // 施設_申請管理を物理削除
       TRdmHcoReqEntity tRdmHcoReqEntity = new TRdmHcoReqEntity();
       tRdmHcoReqEntity.setReqId(indto.getReqId());
       dao.deleteByPK(tRdmHcoReqEntity);
*/
       // END UOC
       return outdto;
   }
}
