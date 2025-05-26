/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jp.co.takeda.rdm.common.BaseEntity;


/**
 * 結合Entityクラス
 * テーブル物理名 : T_RDM_HCP_UPD_HST
 * SQLID : selectHcoUpdHstList
 * @generated
 */
public class MRdmHcpUpdHstListEntity extends BaseEntity implements Serializable {

	/**
     * 権限_条件セット
     * @generated
     */
    private String jokenSetCd;

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 入力_SELECT区分 (パラメータ1)
     * @generated
     */
    private Integer inSelectKbn;

    /**
     * Offset値
     * @generated
     */
    private Integer inOffset;

    /**
     * Limit値
     * @generated
     */
    private Integer inLimit;

    /**
     * ソートID
     * @generated
     */
    private int sortId;

    /**
     * 変換系_結果
     * @generated
     */
    private String searchHenkan;

    /**
     * 変換系_区分
     * @generated
     */
    private String henkanType;

    /**
     * 検索条件_従業員番号(管理者)
     * @generated
     */
    private int kensakuJgiNo;

    /**
     * 検索条件_医薬支店C_申請者所属リージョン(管理者)
     * @generated
     */
    private String kensakuShinseiBrCode;

    /**
     * 検索条件_医薬営業所C_申請者所属エリア(管理者)
     * @generated
     */
    private String kensakuShinseiDistCode;

    /**
     * 検索条件_医薬支店C_担当者所属リージョン(管理者)
     * @generated
     */
    private String kensakuSTantouBrCode;

    /**
     * 検索条件_医薬営業所C_担当者所属エリア(管理者)
     * @generated
     */
    private String kensakuTantouDistCode;

    /**
     * 検索条件_申請者(管理者)
     * @generated
     */
    private String kensakuReqJgiName;

    /**
     * 従業員番号(MR)
     * @generated
     */
    private int mrJgiNo;

    /**
     * 医薬支店C_申請者所属リージョン(MR)
     * @generated
     */
    private String mrBrCode;

    /**
     * 医薬営業所C_申請者所属エリア(MR)
     * @generated
     */
    private String mrDistCode;

    /**
     * 領域コード(MR)
     * @generated
     */
    private String mrTrtCd;

    /**
     * 検索条件_施設固定C
     * @generated
     */
    private String kensakuInsNo;

    /**
     * 検索条件_領域コード
     * @generated
     */
    private String kensakuTrtCd;

    /**
     * 検索条件_氏名漢字(全角)
     * @generated
     */
    private String kensakuDocKanj;

    /**
     * 検索条件_氏名カナ(半角カナ)
     * @generated
     */
    private String kensakuDocKana;

    /**
     * 検索条件_医師／薬剤師区分
     * @generated
     */
    private String kensakuDocType;

    /**
     * 検索条件_医師固定C
     * @generated
     */
    private String kensakuDocNo;

    /**
     * 検索条件_ULT医師コード
     * @generated
     */
    private String kensakuUltDocNo;

    /**
     * 検索条件_医師属性
     * @generated
     */
    private String kensakuDocAttribute;

    /**
     * 検索条件_出身校
     * @generated
     */
    private String kensakuMedSch;

    /**
     * 検索条件_卒年(西暦)
     * @generated
     */
    private String kensakuGradYear;

    /**
     * 検索条件_出身医局校
     * @generated
     */
    private String kensakuHuniv;

    /**
     * 検索条件_施設名
     * @generated
     */
    private String kensakuInsKanj;

    /**
     * 検索条件_更新日(開始日)
     * @generated
     */
    private String kensakuUpdMstFrom;

    /**
     * 検索条件_更新日(終了日)
     * @generated
     */
    private String kensakuUpdMstTo;

    /**
     * 検索_施設固定C
     * @generated
     */
    private String insNo;
    /**
     * 検索_施設名
     * @generated
     */
    private String insAbbrName;
    /**
     * 変換_施設固定C
     * @generated　
     */
    private String henkanInsNo;

    /**
     * 検索_武田所属部科コード
     * @generated
     */
    private String kensakuDeptCode;

    /**
     * 武田所属部科コード
     * @generated
     */
    private String deptCode;

    /**
     * 武田所属部科漢字名
     * @generated
     */
    private String deptKj;

    /**
     * マスタ更新日
     * @generated
     */
    private String updMstYmd;

    /**
     * 医師固定コード
     * @generated
     */
    private String docNo;

    /**
     * 医師／薬剤師区分
     * @generated
     */
    private String docType;

    /**
     * 医師／薬剤師区分更新フラグ
     * @generated
     */
    private String docTypeUpdFlg;

    /**
     * 氏名（漢字
     * @generated
     */
    private String docKanj;

    /**
     * 氏名（漢字）更新フラグ
     * @generated
     */
    private String docKanjUpdFlg;

    /**
     * 氏名（カナ）
     * @generated
     */
    private String docKana;

    /**
     * 氏名（カナ）更新フラグ
     * @generated
     */
    private String docKanaUpdFlg;

    /**
     * 氏名（漢字）姓
     * @generated
     */
    private String docKanjSei;

    /**
     * 氏名（漢字）姓更新フラグ
     * @generated
     */
    private String docKanjSeiUpdFlg;

    /**
     * 氏名（漢字）名
     * @generated
     */
    private String docKanjMei;

    /**
     * 氏名（漢字）名 更新フラグ
     * @generated
     */
    private String docKanjMeiUpdFlg;

    /**
     * 氏名（カナ）姓
     * @generated
     */
    private String docKanaSei;

    /**
     * 氏名（カナ）姓 更新フラグ
     * @generated
     */
    private String docKanaSeiUpdFlg;

    /**
     * 氏名（カナ）名
     * @generated
     */
    private String docKanaMei;

    /**
     * --氏名（カナ）名更新フラグ
     * @generated
     */
    private String docKanaMeiUpdFlg;

    /**
     * 氏名（漢字）旧姓
     * @generated
     */
    private String oldKanjSei;

    /**
     * 氏名（漢字）旧姓更新フラグ
     * @generated
     */
    private String oldKanjSeiUpdFlg;

    /**
     * 氏名（カナ）旧姓
     * @generated
     */
    private String oldKanaSei;

    /**
     * 氏名（カナ）旧姓更新フラグ
     * @generated
     */
    private String oldKanaSeiUpdFlg;

    /**
     * 改姓日
     * @generated
     */
    private String newNameStYmd;

    /**
     * 改姓日更新フラグ
     * @generated
     */
    private String newNameStYmdUpdFlg;

    /**
     * 生年月日
     * @generated
     */
    private String dobYmd;

    /**
     * 生年月日更新フラグ
     * @generated
     */
    private String dobYmdUpdFlg;

    /**
     * 性別区分
     * @generated
     */
    private String sex;

    /**
     * 性別区分更新フラグ
     * @generated
     */
    private String sexUpdFlg;

    /**
     * 出身地コード
     * @generated
     */
    private String homeTown;

    /**
     * 出身地コード更新フラグ
     * @generated
     */
    private String homeTownUpdFlg;

    /**
     * 出身校コード
     * @generated
     */
    private String medSch;

    /**
     * 出身校コード更新フラグ
     * @generated
     */
    private String medSchUpdFlg;

    /**
     * 卒年
     * @generated
     */
    private String gradYear;

    /**
     * 卒年更新フラグ
     * @generated
     */
    private String gradYearUpdFlg;

    /**
     * 出身所属コード
     * @generated
     */
    private String ssnDeptCode;

    /**
     * 出身所属コード更新フラグ
     * @generated
     */
    private String ssnDeptCodeUpdFlg;

    /**
     * 出身医局校コード
     * @generated
     */
    private String huniv;

    /**
     * 出身医局校コード更新フラグ
     * @generated
     */
    private String hunivUpdFlg;

    /**
     * 臨床研修年
     * @generated
     */
    private String emplYear;

    /**
     * 臨床研修年更新フラグ
     * @generated
     */
    private String emplYearUpdFlg;

    /**
     * 専門臓器コード
     * @generated
     */
    private String spLiver;

    /**
     * 専門臓器コード更新フラグ
     * @generated
     */
    private String spLiverUpdFlg;

    /**
     * 専門詳細コード
     * @generated
     */
    private String spDisease;

    /**
     * 専門詳細コード更新フラグ
     * @generated
     */
    private String spDiseaseUpdFlg;

    /**
     * 専門追加情報
     * @generated
     */
    private String spCom;

    /**
     * 専門追加情報更新フラグ
     * @generated
     */
    private String spComUpdFlg;

    /**
     * 申請者所属
     * @generated
     */
    private String reqShz;

    /**
     * 申請者氏名
     * @generated
     */
    private String reqJgiName;

    /**
     * 承認者所属
     * @generated
     */
    private String aprShz;

    /**
     * 承認者氏名
     * @generated
     */
    private String aprShaId;

    /**
     * 申請チャネル
     * @generated
     */
    private String reqChl;

    /**
     * 申請ID
     * @generated
     */
    private String reqId;

    //医師基本情報ここまで

    //所属学会ここから
    /**
     * 所属学会名称
     * @generated
     */
    private String medicalSocietyNm;

    /**
     * 所属学会名称更新フラグ
     * @generated
     */
    private String medicalSocietyNmUpdFlg;

    /**
     * 入会日
     * @generated
     */
    private String admissionYmd;

    /**
     * 入会年月日更新フラグ
     * @generated
     */
    private String admissionYmdUpdFlg;

    /**
     * 脱会日
     * @generated
     */
    private String quitYmd;

    /**
     * 脱会年月日更新フラグ
     * @generated
     */
    private String quitYmdUpdFlg;

    /**
     * 所属役職
     * @generated
     */
    private String positionCode;

    /**
     * 所属役職更新フラグ
     * @generated
     */
    private String positionCodeUpdFlg;

    /**
     * 役職開始年月日
     * @generated
     */
    private String societyPosiStYmd;

    /**
     * 役職開始年月日更新フラグ
     * @generated
     */
    private String societyPosiStYmdUpdFlg;

    /**
     * 役職終了年月日
     * @generated
     */
    private String societyPosiEdYmd;

    /**
     * 役職終了年月日更新フラグ
     * @generated
     */
    private String societyPosiEdYmdUpdFlg;

    /**
     * 指導医取得年月日
     * @generated
     */
    private String coachingAcquisiYmd;

    /**
     * 指導医取得年月日更新フラグ
     * @generated
     */
    private String coachingAcquisiYmdUpdFlg;

    /**
     * 指導医開始年月日
     * @generated
     */
    private String coachinStYmd;

    /**
     * 指導医開始年月日更新フラグ
     * @generated
     */
    private String coachinStYmdUpdFlg;

    /**
     * 指導医終了年月日
     */
    private String coachinEdYmd;

    /**
     * 指導医終了年月日更新フラグ
     * @generated
     */
    private String coachingEdYmdUpdFlg;

    /**
     * 認定医開始年月日
     * @generated
     */
    private String certifyStYmd;

    /**
     * 認定医開始年月日更新フラグ
     * @generated
     */
    private String certifyStYmdUpdFlg;

    /**
     * 認定医終了年月日
     * @generated
     */
    private String certifyEdYmd;

    /**
     * 認定医終了年月日更新フラグ
     * @generated
     */
    private String certifyEdYmdUpdFlg;

    /**
     * 所属学会指導医区分
     * @generated
     */
    private String advisingDoctor;

    /**
     * 所属学会指導医区分更新フラグ
     * @generated
     */
    private String advisingDoctorUpdFlg;

    /**
     * 所属学会認定医区分
     * @generated
     */
    private String certifyingPhysician;

    /**
     * 所属学会認定医区分
     * @generated
     */
    private String certifyingPhysicianUpdFlg;
    //所属学会ここまで

    //勤務先情報ここから
    /**
     * 申請区分
     * @generated
     */
    private String reqType;

    /**
     * 施設固定コード(異動先)
     * @generated
     */
    private String insNoSk;

    /**
     * 勤務形態(異動先)
     * @generated
     */
    private String jobFormAf;

    /**
     * 所属部科名（漢字）(異動先)
     * @generated
     */
    private String deptKanjiAf;

    /**
     * 役職コード(異動先)
     * @generated
     */
    private String titleCodeAf;

    /**
     * 大学職位コード(異動先)
     * @generated
     */
    private String univPosCodeAf;

    /**
     * 薬審メンバー区分(異動先)
     * @generated
     */
    private String dccTypeAf;

    /**
     * 施設固定コード(異動先) 更新フラグ
     * @generated
     */
    private String insNoSkUpdFlg;

    /**
     * 勤務形態(異動先)更新フラグ
     * @generated
     */
    private String jobFormAfUpdFlg;

    /**
     * 所属部科名（漢字）(異動先)更新フラグ
     * @generated
     */
    private String deptKanjiAfUpdFlg;

    /**
     * 役職コード(異動先)更新フラグ
     * @generated
     */
    private String titleCodeAfUpdFlg;

    /**
     * 大学職位コード(異動先)更新フラグ
     * @generated
     */
    private String univPosCodeAfUpdFlg;

    /**
     * 薬審メンバー区分(異動先)更新フラグ
     * @generated
     */
    private String dccTypeAfUpdFlg;

    /**
     * 施設固定コード(異動元)
     * @generated
     */
    private String insNoMt;

    /**
     * 勤務形態(異動元)
     * @generated
     */
    private String jobFormBf;

    /**
     * 所属部科名（漢字）(異動元)
     * @generated
     */
    private String deptKanjiBf;

    /**
     * 役職コード(異動元)
     * @generated
     */
    private String titleCodeBf;

    /**
     * 大学職位コード(異動元)
     * @generated
     */
    private String univPosCodeBf;

    /**
     * 薬審メンバー区分(異動元)
     * @generated
     */
    private String dccTypeBf;
    //勤務先情報ここまで

    //公的機関ここから
    /**
     * 分類区分
     * @generated
     */
    private String classCateGory;

    /**
     * 分類区分更新フラグ
     * @generated
     */
    private String classCateGoryUpdFlg;

    /**
     * 公的機関
     * @generated
     */
    private String pubInstitution;

    /**
     * 公的機関更新フラグ
     * @generated
     */
    private String pubInstitutionUpdFlg;

    /**
     * 公的機関開始年月日
     * @generated
     */
    private String pubInstStYmd;

    /**
     * 公的機関開始年月日更新フラグ
     * @generated
     */
    private String pubInstStYmdUpdFlg;

    /**
     * 公的機関終了年月日
     * @generated
     */
    private String pubInstEdYmd;

    /**
     * 公的機関終了年月日更新フラグ
     * @generated
     */
    private String pubInstEdYmdUpdFlg;

    /**
     * 公的機関役職コード
     * @generated
     */
    private String pubInstPosition;

    /**
     * 公的機関役職コード更新フラグ
     * @generated
     */
    private String pubInstPositionUpdFlg;

    /**
     * 公的機関役職開始年月日
     * @generated
     */
    private String pubInstposStYmd;

    /**
     * 公的機関役職開始年月日更新フラグ
     * @generated
     */
    private String pubInstposStYmdUpdFlg;

    /**
     * 公的機関役職終了年月日
     * @generated
     */
    private String pubInstposEdYmd;

    /**
     * 公的機関役職終了年月日更新フラグ
     * @generated
     */
    private String pubInstposEdYmdUpdFlg;
    //公的機関ここまで

    /**
     * 削除フラグ更新フラグ
     * @generated
     */
    private String delFlgUpdFlg;

    /**
     * レコード件数
     * @generated
     */
    private Integer recCnt;


    /**
     * コンストラクタ
     * @generated
     */
    public MRdmHcpUpdHstListEntity() {
        super("m_rdm_hco_hcp_upd_hst");
    }

    /**
     * コンストラクタ_変換系
     * @generated
     */
    public MRdmHcpUpdHstListEntity(String henkanType) {
        super("m_rdm_hco_upd_hst_mst" , "searchHenkanHcoUpd");
        this.henkanType = henkanType;
    }

    public String getHenkanType() {
		return henkanType;
	}

	public void setHenkanType(String henkanType) {
		this.henkanType = henkanType;
	}

	public String getSearchHenkan() {
		return searchHenkan;
	}

	public int getSortId() {
		return sortId;
	}

	public void setSortId(int sortId) {
		this.sortId = sortId;
	}

	public void setSearchHenkan(String searchHenkan) {
		this.searchHenkan = searchHenkan;
	}


	/**
     * このEntityの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

	/**
	 * SelectHcoUpdHstListEntity.javainOffsetを設定
	 * @return inOffset
	 */
	public Integer getInOffset() {
		return inOffset;
	}
	/**
	 * SelectHcoUpdHstListEntity.javakensakuReqJgiNameを設定
	 * @return kensakuReqJgiName
	 */
	public String getKensakuReqJgiName() {
		return kensakuReqJgiName;
	}

	/**
	 * @param kensakuReqJgiName セットする kensakuReqJgiName
	 */
	public void setKensakuReqJgiName(String kensakuReqJgiName) {
		this.kensakuReqJgiName = kensakuReqJgiName;
	}


	public String getKensakuInsKanj() {
		return kensakuInsKanj;
	}

	public void setKensakuInsKanj(String kensakuInsKanj) {
		this.kensakuInsKanj = kensakuInsKanj;
	}
	public String getKensakuInsNo() {
		return kensakuInsNo;
	}

	public void setKensakuInsNo(String kensakuInsNo) {
		this.kensakuInsNo = kensakuInsNo;
	}

	public Integer getInSelectKbn() {
		return inSelectKbn;
	}

	public void setInSelectKbn(Integer inSelectKbn) {
		this.inSelectKbn = inSelectKbn;
	}


	public Integer getRecCnt() {
		return recCnt;
	}


	public void setRecCnt(Integer recCnt) {
		this.recCnt = recCnt;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javakensakuJgiNoを設定
	 * @return kensakuJgiNo
	 */
	public int getKensakuJgiNo() {
		return kensakuJgiNo;
	}

	/**
	 * @param kensakuJgiNo セットする kensakuJgiNo
	 */
	public void setKensakuJgiNo(int kensakuJgiNo) {
		this.kensakuJgiNo = kensakuJgiNo;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javakensakuDocKanjを設定
	 * @return kensakuDocKanj
	 */
	public String getKensakuDocKanj() {
		return kensakuDocKanj;
	}

	/**
	 * @param kensakuDocKanj セットする kensakuDocKanj
	 */
	public void setKensakuDocKanj(String kensakuDocKanj) {
		this.kensakuDocKanj = kensakuDocKanj;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javakensakuDocKanaを設定
	 * @return kensakuDocKana
	 */
	public String getKensakuDocKana() {
		return kensakuDocKana;
	}

	/**
	 * @param kensakuDocKana セットする kensakuDocKana
	 */
	public void setKensakuDocKana(String kensakuDocKana) {
		this.kensakuDocKana = kensakuDocKana;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javakensakuDocTypeを設定
	 * @return kensakuDocType
	 */
	public String getKensakuDocType() {
		return kensakuDocType;
	}

	/**
	 * @param kensakuDocType セットする kensakuDocType
	 */
	public void setKensakuDocType(String kensakuDocType) {
		this.kensakuDocType = kensakuDocType;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javakensakuDocNoを設定
	 * @return kensakuDocNo
	 */
	public String getKensakuDocNo() {
		return kensakuDocNo;
	}

	/**
	 * @param kensakuDocNo セットする kensakuDocNo
	 */
	public void setKensakuDocNo(String kensakuDocNo) {
		this.kensakuDocNo = kensakuDocNo;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javakensakuUltDocNoを設定
	 * @return kensakuUltDocNo
	 */
	public String getKensakuUltDocNo() {
		return kensakuUltDocNo;
	}

	/**
	 * @param kensakuUltDocNo セットする kensakuUltDocNo
	 */
	public void setKensakuUltDocNo(String kensakuUltDocNo) {
		this.kensakuUltDocNo = kensakuUltDocNo;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javakensakuDocAttributeを設定
	 * @return kensakuDocAttribute
	 */
	public String getKensakuDocAttribute() {
		return kensakuDocAttribute;
	}

	/**
	 * @param kensakuDocAttribute セットする kensakuDocAttribute
	 */
	public void setKensakuDocAttribute(String kensakuDocAttribute) {
		this.kensakuDocAttribute = kensakuDocAttribute;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javakensakuMedSchを設定
	 * @return kensakuMedSch
	 */
	public String getKensakuMedSch() {
		return kensakuMedSch;
	}

	/**
	 * @param kensakuMedSch セットする kensakuMedSch
	 */
	public void setKensakuMedSch(String kensakuMedSch) {
		this.kensakuMedSch = kensakuMedSch;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javakensakuGradYearを設定
	 * @return kensakuGradYear
	 */
	public String getKensakuGradYear() {
		return kensakuGradYear;
	}

	/**
	 * @param kensakuGradYear セットする kensakuGradYear
	 */
	public void setKensakuGradYear(String kensakuGradYear) {
		this.kensakuGradYear = kensakuGradYear;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javainLimitを設定
	 * @return inLimit
	 */
	public Integer getInLimit() {
		return inLimit;
	}

	/**
	 * @param inLimit セットする inLimit
	 */
	public void setInLimit(Integer inLimit) {
		this.inLimit = inLimit;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javakensakuTrtCdを設定
	 * @return kensakuTrtCd
	 */
	public String getKensakuTrtCd() {
		return kensakuTrtCd;
	}

	/**
	 * @param kensakuTrtCd セットする kensakuTrtCd
	 */
	public void setKensakuTrtCd(String kensakuTrtCd) {
		this.kensakuTrtCd = kensakuTrtCd;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javaupdMstYmdを設定
	 * @return updMstYmd
	 */
	public String getUpdMstYmd() {
		return updMstYmd;
	}

	/**
	 * @param updMstYmd セットする updMstYmd
	 */
	public void setUpdMstYmd(String updMstYmd) {
		this.updMstYmd = updMstYmd;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javadocNoを設定
	 * @return docNo
	 */
	public String getDocNo() {
		return docNo;
	}

	/**
	 * @param docNo セットする docNo
	 */
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javadocTypeを設定
	 * @return docType
	 */
	public String getDocType() {
		return docType;
	}

	/**
	 * @param docType セットする docType
	 */
	public void setDocType(String docType) {
		this.docType = docType;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javadocTypeUpdFlgを設定
	 * @return docTypeUpdFlg
	 */
	public String getDocTypeUpdFlg() {
		return docTypeUpdFlg;
	}

	/**
	 * @param docTypeUpdFlg セットする docTypeUpdFlg
	 */
	public void setDocTypeUpdFlg(String docTypeUpdFlg) {
		this.docTypeUpdFlg = docTypeUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javadocKanjを設定
	 * @return docKanj
	 */
	public String getDocKanj() {
		return docKanj;
	}

	/**
	 * @param docKanj セットする docKanj
	 */
	public void setDocKanj(String docKanj) {
		this.docKanj = docKanj;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javadocKanjUpdFlgを設定
	 * @return docKanjUpdFlg
	 */
	public String getDocKanjUpdFlg() {
		return docKanjUpdFlg;
	}

	/**
	 * @param docKanjUpdFlg セットする docKanjUpdFlg
	 */
	public void setDocKanjUpdFlg(String docKanjUpdFlg) {
		this.docKanjUpdFlg = docKanjUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javadocKanaを設定
	 * @return docKana
	 */
	public String getDocKana() {
		return docKana;
	}

	/**
	 * @param docKana セットする docKana
	 */
	public void setDocKana(String docKana) {
		this.docKana = docKana;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javadocKanaUpdFlgを設定
	 * @return docKanaUpdFlg
	 */
	public String getDocKanaUpdFlg() {
		return docKanaUpdFlg;
	}

	/**
	 * @param docKanaUpdFlg セットする docKanaUpdFlg
	 */
	public void setDocKanaUpdFlg(String docKanaUpdFlg) {
		this.docKanaUpdFlg = docKanaUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javadocKanjSeiを設定
	 * @return docKanjSei
	 */
	public String getDocKanjSei() {
		return docKanjSei;
	}

	/**
	 * @param docKanjSei セットする docKanjSei
	 */
	public void setDocKanjSei(String docKanjSei) {
		this.docKanjSei = docKanjSei;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javadocKanjSeiUpdFlgを設定
	 * @return docKanjSeiUpdFlg
	 */
	public String getDocKanjSeiUpdFlg() {
		return docKanjSeiUpdFlg;
	}

	/**
	 * @param docKanjSeiUpdFlg セットする docKanjSeiUpdFlg
	 */
	public void setDocKanjSeiUpdFlg(String docKanjSeiUpdFlg) {
		this.docKanjSeiUpdFlg = docKanjSeiUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javadocKanjMeiを設定
	 * @return docKanjMei
	 */
	public String getDocKanjMei() {
		return docKanjMei;
	}

	/**
	 * @param docKanjMei セットする docKanjMei
	 */
	public void setDocKanjMei(String docKanjMei) {
		this.docKanjMei = docKanjMei;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javadocKanjMeiUpdFlgを設定
	 * @return docKanjMeiUpdFlg
	 */
	public String getDocKanjMeiUpdFlg() {
		return docKanjMeiUpdFlg;
	}

	/**
	 * @param docKanjMeiUpdFlg セットする docKanjMeiUpdFlg
	 */
	public void setDocKanjMeiUpdFlg(String docKanjMeiUpdFlg) {
		this.docKanjMeiUpdFlg = docKanjMeiUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javadocKanaSeiを設定
	 * @return docKanaSei
	 */
	public String getDocKanaSei() {
		return docKanaSei;
	}

	/**
	 * @param docKanaSei セットする docKanaSei
	 */
	public void setDocKanaSei(String docKanaSei) {
		this.docKanaSei = docKanaSei;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javadocKanaSeiUpdFlgを設定
	 * @return docKanaSeiUpdFlg
	 */
	public String getDocKanaSeiUpdFlg() {
		return docKanaSeiUpdFlg;
	}

	/**
	 * @param docKanaSeiUpdFlg セットする docKanaSeiUpdFlg
	 */
	public void setDocKanaSeiUpdFlg(String docKanaSeiUpdFlg) {
		this.docKanaSeiUpdFlg = docKanaSeiUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javadocKanaMeiを設定
	 * @return docKanaMei
	 */
	public String getDocKanaMei() {
		return docKanaMei;
	}

	/**
	 * @param docKanaMei セットする docKanaMei
	 */
	public void setDocKanaMei(String docKanaMei) {
		this.docKanaMei = docKanaMei;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javadocKanaMeiUpdFlgを設定
	 * @return docKanaMeiUpdFlg
	 */
	public String getDocKanaMeiUpdFlg() {
		return docKanaMeiUpdFlg;
	}

	/**
	 * @param docKanaMeiUpdFlg セットする docKanaMeiUpdFlg
	 */
	public void setDocKanaMeiUpdFlg(String docKanaMeiUpdFlg) {
		this.docKanaMeiUpdFlg = docKanaMeiUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javaoldKanjSeiを設定
	 * @return oldKanjSei
	 */
	public String getOldKanjSei() {
		return oldKanjSei;
	}

	/**
	 * @param oldKanjSei セットする oldKanjSei
	 */
	public void setOldKanjSei(String oldKanjSei) {
		this.oldKanjSei = oldKanjSei;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javaoldKanjSeiUpdFlgを設定
	 * @return oldKanjSeiUpdFlg
	 */
	public String getOldKanjSeiUpdFlg() {
		return oldKanjSeiUpdFlg;
	}

	/**
	 * @param oldKanjSeiUpdFlg セットする oldKanjSeiUpdFlg
	 */
	public void setOldKanjSeiUpdFlg(String oldKanjSeiUpdFlg) {
		this.oldKanjSeiUpdFlg = oldKanjSeiUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javaoldKanaSeiを設定
	 * @return oldKanaSei
	 */
	public String getOldKanaSei() {
		return oldKanaSei;
	}

	/**
	 * @param oldKanaSei セットする oldKanaSei
	 */
	public void setOldKanaSei(String oldKanaSei) {
		this.oldKanaSei = oldKanaSei;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javaoldKanaSeiUpdFlgを設定
	 * @return oldKanaSeiUpdFlg
	 */
	public String getOldKanaSeiUpdFlg() {
		return oldKanaSeiUpdFlg;
	}

	/**
	 * @param oldKanaSeiUpdFlg セットする oldKanaSeiUpdFlg
	 */
	public void setOldKanaSeiUpdFlg(String oldKanaSeiUpdFlg) {
		this.oldKanaSeiUpdFlg = oldKanaSeiUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javanewNameStYmdを設定
	 * @return newNameStYmd
	 */
	public String getNewNameStYmd() {
		return newNameStYmd;
	}

	/**
	 * @param newNameStYmd セットする newNameStYmd
	 */
	public void setNewNameStYmd(String newNameStYmd) {
		this.newNameStYmd = newNameStYmd;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javanewNameStYmdUpdFlgを設定
	 * @return newNameStYmdUpdFlg
	 */
	public String getNewNameStYmdUpdFlg() {
		return newNameStYmdUpdFlg;
	}

	/**
	 * @param newNameStYmdUpdFlg セットする newNameStYmdUpdFlg
	 */
	public void setNewNameStYmdUpdFlg(String newNameStYmdUpdFlg) {
		this.newNameStYmdUpdFlg = newNameStYmdUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javadobYmdを設定
	 * @return dobYmd
	 */
	public String getDobYmd() {
		return dobYmd;
	}

	/**
	 * @param dobYmd セットする dobYmd
	 */
	public void setDobYmd(String dobYmd) {
		this.dobYmd = dobYmd;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javadobYmdUpdFlgを設定
	 * @return dobYmdUpdFlg
	 */
	public String getDobYmdUpdFlg() {
		return dobYmdUpdFlg;
	}

	/**
	 * @param dobYmdUpdFlg セットする dobYmdUpdFlg
	 */
	public void setDobYmdUpdFlg(String dobYmdUpdFlg) {
		this.dobYmdUpdFlg = dobYmdUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javasexを設定
	 * @return sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex セットする sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javasexUpdFlgを設定
	 * @return sexUpdFlg
	 */
	public String getSexUpdFlg() {
		return sexUpdFlg;
	}

	/**
	 * @param sexUpdFlg セットする sexUpdFlg
	 */
	public void setSexUpdFlg(String sexUpdFlg) {
		this.sexUpdFlg = sexUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javahomeTownを設定
	 * @return homeTown
	 */
	public String getHomeTown() {
		return homeTown;
	}

	/**
	 * @param homeTown セットする homeTown
	 */
	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javahomeTownUpdFlgを設定
	 * @return homeTownUpdFlg
	 */
	public String getHomeTownUpdFlg() {
		return homeTownUpdFlg;
	}

	/**
	 * @param homeTownUpdFlg セットする homeTownUpdFlg
	 */
	public void setHomeTownUpdFlg(String homeTownUpdFlg) {
		this.homeTownUpdFlg = homeTownUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javamedSchを設定
	 * @return medSch
	 */
	public String getMedSch() {
		return medSch;
	}

	/**
	 * @param medSch セットする medSch
	 */
	public void setMedSch(String medSch) {
		this.medSch = medSch;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javamedSchUpdFlgを設定
	 * @return medSchUpdFlg
	 */
	public String getMedSchUpdFlg() {
		return medSchUpdFlg;
	}

	/**
	 * @param medSchUpdFlg セットする medSchUpdFlg
	 */
	public void setMedSchUpdFlg(String medSchUpdFlg) {
		this.medSchUpdFlg = medSchUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javagradYearを設定
	 * @return gradYear
	 */
	public String getGradYear() {
		return gradYear;
	}

	/**
	 * @param gradYear セットする gradYear
	 */
	public void setGradYear(String gradYear) {
		this.gradYear = gradYear;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javagradYearUpdFlgを設定
	 * @return gradYearUpdFlg
	 */
	public String getGradYearUpdFlg() {
		return gradYearUpdFlg;
	}

	/**
	 * @param gradYearUpdFlg セットする gradYearUpdFlg
	 */
	public void setGradYearUpdFlg(String gradYearUpdFlg) {
		this.gradYearUpdFlg = gradYearUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javassnDeptCodeを設定
	 * @return ssnDeptCode
	 */
	public String getSsnDeptCode() {
		return ssnDeptCode;
	}

	/**
	 * @param ssnDeptCode セットする ssnDeptCode
	 */
	public void setSsnDeptCode(String ssnDeptCode) {
		this.ssnDeptCode = ssnDeptCode;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javassnDeptCodeUpdFlgを設定
	 * @return ssnDeptCodeUpdFlg
	 */
	public String getSsnDeptCodeUpdFlg() {
		return ssnDeptCodeUpdFlg;
	}

	/**
	 * @param ssnDeptCodeUpdFlg セットする ssnDeptCodeUpdFlg
	 */
	public void setSsnDeptCodeUpdFlg(String ssnDeptCodeUpdFlg) {
		this.ssnDeptCodeUpdFlg = ssnDeptCodeUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javaemplYearを設定
	 * @return emplYear
	 */
	public String getEmplYear() {
		return emplYear;
	}

	/**
	 * @param emplYear セットする emplYear
	 */
	public void setEmplYear(String emplYear) {
		this.emplYear = emplYear;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javaemplYearUpdFlgを設定
	 * @return emplYearUpdFlg
	 */
	public String getEmplYearUpdFlg() {
		return emplYearUpdFlg;
	}

	/**
	 * @param emplYearUpdFlg セットする emplYearUpdFlg
	 */
	public void setEmplYearUpdFlg(String emplYearUpdFlg) {
		this.emplYearUpdFlg = emplYearUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javaspLiverを設定
	 * @return spLiver
	 */
	public String getSpLiver() {
		return spLiver;
	}

	/**
	 * @param spLiver セットする spLiver
	 */
	public void setSpLiver(String spLiver) {
		this.spLiver = spLiver;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javaspLiverUpdFlgを設定
	 * @return spLiverUpdFlg
	 */
	public String getSpLiverUpdFlg() {
		return spLiverUpdFlg;
	}

	/**
	 * @param spLiverUpdFlg セットする spLiverUpdFlg
	 */
	public void setSpLiverUpdFlg(String spLiverUpdFlg) {
		this.spLiverUpdFlg = spLiverUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javaspDiseaseを設定
	 * @return spDisease
	 */
	public String getSpDisease() {
		return spDisease;
	}

	/**
	 * @param spDisease セットする spDisease
	 */
	public void setSpDisease(String spDisease) {
		this.spDisease = spDisease;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javaspDiseaseUpdFlgを設定
	 * @return spDiseaseUpdFlg
	 */
	public String getSpDiseaseUpdFlg() {
		return spDiseaseUpdFlg;
	}

	/**
	 * @param spDiseaseUpdFlg セットする spDiseaseUpdFlg
	 */
	public void setSpDiseaseUpdFlg(String spDiseaseUpdFlg) {
		this.spDiseaseUpdFlg = spDiseaseUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javaspComを設定
	 * @return spCom
	 */
	public String getSpCom() {
		return spCom;
	}

	/**
	 * @param spCom セットする spCom
	 */
	public void setSpCom(String spCom) {
		this.spCom = spCom;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javaspComUpdFlgを設定
	 * @return spComUpdFlg
	 */
	public String getSpComUpdFlg() {
		return spComUpdFlg;
	}

	/**
	 * @param spComUpdFlg セットする spComUpdFlg
	 */
	public void setSpComUpdFlg(String spComUpdFlg) {
		this.spComUpdFlg = spComUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javareqShzを設定
	 * @return reqShz
	 */
	public String getReqShz() {
		return reqShz;
	}

	/**
	 * @param reqShz セットする reqShz
	 */
	public void setReqShz(String reqShz) {
		this.reqShz = reqShz;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javareqJgiNameを設定
	 * @return reqJgiName
	 */
	public String getReqJgiName() {
		return reqJgiName;
	}

	/**
	 * @param reqJgiName セットする reqJgiName
	 */
	public void setReqJgiName(String reqJgiName) {
		this.reqJgiName = reqJgiName;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javaaprShzを設定
	 * @return aprShz
	 */
	public String getAprShz() {
		return aprShz;
	}

	/**
	 * @param aprShz セットする aprShz
	 */
	public void setAprShz(String aprShz) {
		this.aprShz = aprShz;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javaaprShaIdを設定
	 * @return aprShaId
	 */
	public String getAprShaId() {
		return aprShaId;
	}

	/**
	 * @param aprShaId セットする aprShaId
	 */
	public void setAprShaId(String aprShaId) {
		this.aprShaId = aprShaId;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javareqChlを設定
	 * @return reqChl
	 */
	public String getReqChl() {
		return reqChl;
	}

	/**
	 * @param reqChl セットする reqChl
	 */
	public void setReqChl(String reqChl) {
		this.reqChl = reqChl;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javareqIdを設定
	 * @return reqId
	 */
	public String getReqId() {
		return reqId;
	}

	/**
	 * @param reqId セットする reqId
	 */
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javamedicalSocietyNmを設定
	 * @return medicalSocietyNm
	 */
	public String getMedicalSocietyNm() {
		return medicalSocietyNm;
	}

	/**
	 * @param medicalSocietyNm セットする medicalSocietyNm
	 */
	public void setMedicalSocietyNm(String medicalSocietyNm) {
		this.medicalSocietyNm = medicalSocietyNm;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javamedicalSocietyNmUpdFlgを設定
	 * @return medicalSocietyNmUpdFlg
	 */
	public String getMedicalSocietyNmUpdFlg() {
		return medicalSocietyNmUpdFlg;
	}

	/**
	 * @param medicalSocietyNmUpdFlg セットする medicalSocietyNmUpdFlg
	 */
	public void setMedicalSocietyNmUpdFlg(String medicalSocietyNmUpdFlg) {
		this.medicalSocietyNmUpdFlg = medicalSocietyNmUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javaadmissionYmdを設定
	 * @return admissionYmd
	 */
	public String getAdmissionYmd() {
		return admissionYmd;
	}

	/**
	 * @param admissionYmd セットする admissionYmd
	 */
	public void setAdmissionYmd(String admissionYmd) {
		this.admissionYmd = admissionYmd;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javaadmissionYmdUpdFlgを設定
	 * @return admissionYmdUpdFlg
	 */
	public String getAdmissionYmdUpdFlg() {
		return admissionYmdUpdFlg;
	}

	/**
	 * @param admissionYmdUpdFlg セットする admissionYmdUpdFlg
	 */
	public void setAdmissionYmdUpdFlg(String admissionYmdUpdFlg) {
		this.admissionYmdUpdFlg = admissionYmdUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javaquitYmdを設定
	 * @return quitYmd
	 */
	public String getQuitYmd() {
		return quitYmd;
	}

	/**
	 * @param quitYmd セットする quitYmd
	 */
	public void setQuitYmd(String quitYmd) {
		this.quitYmd = quitYmd;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javaquitYmdUpdFlgを設定
	 * @return quitYmdUpdFlg
	 */
	public String getQuitYmdUpdFlg() {
		return quitYmdUpdFlg;
	}

	/**
	 * @param quitYmdUpdFlg セットする quitYmdUpdFlg
	 */
	public void setQuitYmdUpdFlg(String quitYmdUpdFlg) {
		this.quitYmdUpdFlg = quitYmdUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javapositionCodeを設定
	 * @return positionCode
	 */
	public String getPositionCode() {
		return positionCode;
	}

	/**
	 * @param positionCode セットする positionCode
	 */
	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javapositionCodeUpdFlgを設定
	 * @return positionCodeUpdFlg
	 */
	public String getPositionCodeUpdFlg() {
		return positionCodeUpdFlg;
	}

	/**
	 * @param positionCodeUpdFlg セットする positionCodeUpdFlg
	 */
	public void setPositionCodeUpdFlg(String positionCodeUpdFlg) {
		this.positionCodeUpdFlg = positionCodeUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javasocietyPosiStYmdを設定
	 * @return societyPosiStYmd
	 */
	public String getSocietyPosiStYmd() {
		return societyPosiStYmd;
	}

	/**
	 * @param societyPosiStYmd セットする societyPosiStYmd
	 */
	public void setSocietyPosiStYmd(String societyPosiStYmd) {
		this.societyPosiStYmd = societyPosiStYmd;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javasocietyPosiStYmdUpdFlgを設定
	 * @return societyPosiStYmdUpdFlg
	 */
	public String getSocietyPosiStYmdUpdFlg() {
		return societyPosiStYmdUpdFlg;
	}

	/**
	 * @param societyPosiStYmdUpdFlg セットする societyPosiStYmdUpdFlg
	 */
	public void setSocietyPosiStYmdUpdFlg(String societyPosiStYmdUpdFlg) {
		this.societyPosiStYmdUpdFlg = societyPosiStYmdUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javasocietyPosiEdYmdを設定
	 * @return societyPosiEdYmd
	 */
	public String getSocietyPosiEdYmd() {
		return societyPosiEdYmd;
	}

	/**
	 * @param societyPosiEdYmd セットする societyPosiEdYmd
	 */
	public void setSocietyPosiEdYmd(String societyPosiEdYmd) {
		this.societyPosiEdYmd = societyPosiEdYmd;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javasocietyPosiEdYmdUpdFlgを設定
	 * @return societyPosiEdYmdUpdFlg
	 */
	public String getSocietyPosiEdYmdUpdFlg() {
		return societyPosiEdYmdUpdFlg;
	}

	/**
	 * @param societyPosiEdYmdUpdFlg セットする societyPosiEdYmdUpdFlg
	 */
	public void setSocietyPosiEdYmdUpdFlg(String societyPosiEdYmdUpdFlg) {
		this.societyPosiEdYmdUpdFlg = societyPosiEdYmdUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javacoachingAcquisiYmdを設定
	 * @return coachingAcquisiYmd
	 */
	public String getCoachingAcquisiYmd() {
		return coachingAcquisiYmd;
	}

	/**
	 * @param coachingAcquisiYmd セットする coachingAcquisiYmd
	 */
	public void setCoachingAcquisiYmd(String coachingAcquisiYmd) {
		this.coachingAcquisiYmd = coachingAcquisiYmd;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javacoachingAcquisiYmdUpdFlgを設定
	 * @return coachingAcquisiYmdUpdFlg
	 */
	public String getCoachingAcquisiYmdUpdFlg() {
		return coachingAcquisiYmdUpdFlg;
	}

	/**
	 * @param coachingAcquisiYmdUpdFlg セットする coachingAcquisiYmdUpdFlg
	 */
	public void setCoachingAcquisiYmdUpdFlg(String coachingAcquisiYmdUpdFlg) {
		this.coachingAcquisiYmdUpdFlg = coachingAcquisiYmdUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javacoachinStYmdを設定
	 * @return coachinStYmd
	 */
	public String getCoachinStYmd() {
		return coachinStYmd;
	}

	/**
	 * @param coachinStYmd セットする coachinStYmd
	 */
	public void setCoachinStYmd(String coachinStYmd) {
		this.coachinStYmd = coachinStYmd;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javacoachinStYmdUpdFlgを設定
	 * @return coachinStYmdUpdFlg
	 */
	public String getCoachinStYmdUpdFlg() {
		return coachinStYmdUpdFlg;
	}

	/**
	 * @param coachinStYmdUpdFlg セットする coachinStYmdUpdFlg
	 */
	public void setCoachinStYmdUpdFlg(String coachinStYmdUpdFlg) {
		this.coachinStYmdUpdFlg = coachinStYmdUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javacoachinEdYmdを設定
	 * @return coachinEdYmd
	 */
	public String getCoachinEdYmd() {
		return coachinEdYmd;
	}

	/**
	 * @param coachinEdYmd セットする coachinEdYmd
	 */
	public void setCoachinEdYmd(String coachinEdYmd) {
		this.coachinEdYmd = coachinEdYmd;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javacoachingEdYmdUpdFlgを設定
	 * @return coachingEdYmdUpdFlg
	 */
	public String getCoachingEdYmdUpdFlg() {
		return coachingEdYmdUpdFlg;
	}

	/**
	 * @param coachingEdYmdUpdFlg セットする coachingEdYmdUpdFlg
	 */
	public void setCoachingEdYmdUpdFlg(String coachingEdYmdUpdFlg) {
		this.coachingEdYmdUpdFlg = coachingEdYmdUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javacertifyStYmdを設定
	 * @return certifyStYmd
	 */
	public String getCertifyStYmd() {
		return certifyStYmd;
	}

	/**
	 * @param certifyStYmd セットする certifyStYmd
	 */
	public void setCertifyStYmd(String certifyStYmd) {
		this.certifyStYmd = certifyStYmd;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javacertifyStYmdUpdFlgを設定
	 * @return certifyStYmdUpdFlg
	 */
	public String getCertifyStYmdUpdFlg() {
		return certifyStYmdUpdFlg;
	}

	/**
	 * @param certifyStYmdUpdFlg セットする certifyStYmdUpdFlg
	 */
	public void setCertifyStYmdUpdFlg(String certifyStYmdUpdFlg) {
		this.certifyStYmdUpdFlg = certifyStYmdUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javacertifyEdYmdを設定
	 * @return certifyEdYmd
	 */
	public String getCertifyEdYmd() {
		return certifyEdYmd;
	}

	/**
	 * @param certifyEdYmd セットする certifyEdYmd
	 */
	public void setCertifyEdYmd(String certifyEdYmd) {
		this.certifyEdYmd = certifyEdYmd;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javacertifyEdYmdUpdFlgを設定
	 * @return certifyEdYmdUpdFlg
	 */
	public String getCertifyEdYmdUpdFlg() {
		return certifyEdYmdUpdFlg;
	}

	/**
	 * @param certifyEdYmdUpdFlg セットする certifyEdYmdUpdFlg
	 */
	public void setCertifyEdYmdUpdFlg(String certifyEdYmdUpdFlg) {
		this.certifyEdYmdUpdFlg = certifyEdYmdUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javaadvisingDoctorを設定
	 * @return advisingDoctor
	 */
	public String getAdvisingDoctor() {
		return advisingDoctor;
	}

	/**
	 * @param advisingDoctor セットする advisingDoctor
	 */
	public void setAdvisingDoctor(String advisingDoctor) {
		this.advisingDoctor = advisingDoctor;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javaadvisingDoctorUpdFlgを設定
	 * @return advisingDoctorUpdFlg
	 */
	public String getAdvisingDoctorUpdFlg() {
		return advisingDoctorUpdFlg;
	}

	/**
	 * @param advisingDoctorUpdFlg セットする advisingDoctorUpdFlg
	 */
	public void setAdvisingDoctorUpdFlg(String advisingDoctorUpdFlg) {
		this.advisingDoctorUpdFlg = advisingDoctorUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javacertifyingPhysicianを設定
	 * @return certifyingPhysician
	 */
	public String getCertifyingPhysician() {
		return certifyingPhysician;
	}

	/**
	 * @param certifyingPhysician セットする certifyingPhysician
	 */
	public void setCertifyingPhysician(String certifyingPhysician) {
		this.certifyingPhysician = certifyingPhysician;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javacertifyingPhysicianUpdFlgを設定
	 * @return certifyingPhysicianUpdFlg
	 */
	public String getCertifyingPhysicianUpdFlg() {
		return certifyingPhysicianUpdFlg;
	}

	/**
	 * @param certifyingPhysicianUpdFlg セットする certifyingPhysicianUpdFlg
	 */
	public void setCertifyingPhysicianUpdFlg(String certifyingPhysicianUpdFlg) {
		this.certifyingPhysicianUpdFlg = certifyingPhysicianUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javareqTypeを設定
	 * @return reqType
	 */
	public String getReqType() {
		return reqType;
	}

	/**
	 * @param reqType セットする reqType
	 */
	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javainsNoSkを設定
	 * @return insNoSk
	 */
	public String getInsNoSk() {
		return insNoSk;
	}

	/**
	 * @param insNoSk セットする insNoSk
	 */
	public void setInsNoSk(String insNoSk) {
		this.insNoSk = insNoSk;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javajobFormAfを設定
	 * @return jobFormAf
	 */
	public String getJobFormAf() {
		return jobFormAf;
	}

	/**
	 * @param jobFormAf セットする jobFormAf
	 */
	public void setJobFormAf(String jobFormAf) {
		this.jobFormAf = jobFormAf;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javadeptKanjiAfを設定
	 * @return deptKanjiAf
	 */
	public String getDeptKanjiAf() {
		return deptKanjiAf;
	}

	/**
	 * @param deptKanjiAf セットする deptKanjiAf
	 */
	public void setDeptKanjiAf(String deptKanjiAf) {
		this.deptKanjiAf = deptKanjiAf;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javatitleCodeAfを設定
	 * @return titleCodeAf
	 */
	public String getTitleCodeAf() {
		return titleCodeAf;
	}

	/**
	 * @param titleCodeAf セットする titleCodeAf
	 */
	public void setTitleCodeAf(String titleCodeAf) {
		this.titleCodeAf = titleCodeAf;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javaunivPosCodeAfを設定
	 * @return univPosCodeAf
	 */
	public String getUnivPosCodeAf() {
		return univPosCodeAf;
	}

	/**
	 * @param univPosCodeAf セットする univPosCodeAf
	 */
	public void setUnivPosCodeAf(String univPosCodeAf) {
		this.univPosCodeAf = univPosCodeAf;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javadccTypeAfを設定
	 * @return dccTypeAf
	 */
	public String getDccTypeAf() {
		return dccTypeAf;
	}

	/**
	 * @param dccTypeAf セットする dccTypeAf
	 */
	public void setDccTypeAf(String dccTypeAf) {
		this.dccTypeAf = dccTypeAf;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javainsNoSkUpdFlgを設定
	 * @return insNoSkUpdFlg
	 */
	public String getInsNoSkUpdFlg() {
		return insNoSkUpdFlg;
	}

	/**
	 * @param insNoSkUpdFlg セットする insNoSkUpdFlg
	 */
	public void setInsNoSkUpdFlg(String insNoSkUpdFlg) {
		this.insNoSkUpdFlg = insNoSkUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javajobFormAfUpdFlgを設定
	 * @return jobFormAfUpdFlg
	 */
	public String getJobFormAfUpdFlg() {
		return jobFormAfUpdFlg;
	}

	/**
	 * @param jobFormAfUpdFlg セットする jobFormAfUpdFlg
	 */
	public void setJobFormAfUpdFlg(String jobFormAfUpdFlg) {
		this.jobFormAfUpdFlg = jobFormAfUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javadeptKanjiAfUpdFlgを設定
	 * @return deptKanjiAfUpdFlg
	 */
	public String getDeptKanjiAfUpdFlg() {
		return deptKanjiAfUpdFlg;
	}

	/**
	 * @param deptKanjiAfUpdFlg セットする deptKanjiAfUpdFlg
	 */
	public void setDeptKanjiAfUpdFlg(String deptKanjiAfUpdFlg) {
		this.deptKanjiAfUpdFlg = deptKanjiAfUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javatitleCodeAfUpdFlgを設定
	 * @return titleCodeAfUpdFlg
	 */
	public String getTitleCodeAfUpdFlg() {
		return titleCodeAfUpdFlg;
	}

	/**
	 * @param titleCodeAfUpdFlg セットする titleCodeAfUpdFlg
	 */
	public void setTitleCodeAfUpdFlg(String titleCodeAfUpdFlg) {
		this.titleCodeAfUpdFlg = titleCodeAfUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javainsNoMtを設定
	 * @return insNoMt
	 */
	public String getInsNoMt() {
		return insNoMt;
	}

	/**
	 * @param insNoMt セットする insNoMt
	 */
	public void setInsNoMt(String insNoMt) {
		this.insNoMt = insNoMt;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javajobFormBfを設定
	 * @return jobFormBf
	 */
	public String getJobFormBf() {
		return jobFormBf;
	}

	/**
	 * @param jobFormBf セットする jobFormBf
	 */
	public void setJobFormBf(String jobFormBf) {
		this.jobFormBf = jobFormBf;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javadeptKanjiBfを設定
	 * @return deptKanjiBf
	 */
	public String getDeptKanjiBf() {
		return deptKanjiBf;
	}

	/**
	 * @param deptKanjiBf セットする deptKanjiBf
	 */
	public void setDeptKanjiBf(String deptKanjiBf) {
		this.deptKanjiBf = deptKanjiBf;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javatitleCodeBfを設定
	 * @return titleCodeBf
	 */
	public String getTitleCodeBf() {
		return titleCodeBf;
	}

	/**
	 * @param titleCodeBf セットする titleCodeBf
	 */
	public void setTitleCodeBf(String titleCodeBf) {
		this.titleCodeBf = titleCodeBf;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javaunivPosCodeBfを設定
	 * @return univPosCodeBf
	 */
	public String getUnivPosCodeBf() {
		return univPosCodeBf;
	}

	/**
	 * @param univPosCodeBf セットする univPosCodeBf
	 */
	public void setUnivPosCodeBf(String univPosCodeBf) {
		this.univPosCodeBf = univPosCodeBf;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javadccTypeBfを設定
	 * @return dccTypeBf
	 */
	public String getDccTypeBf() {
		return dccTypeBf;
	}

	/**
	 * @param dccTypeBf セットする dccTypeBf
	 */
	public void setDccTypeBf(String dccTypeBf) {
		this.dccTypeBf = dccTypeBf;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javaclassCateGoryを設定
	 * @return classCateGory
	 */
	public String getClassCateGory() {
		return classCateGory;
	}

	/**
	 * @param classCateGory セットする classCateGory
	 */
	public void setClassCateGory(String classCateGory) {
		this.classCateGory = classCateGory;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javaclassCateGoryUpdFlgを設定
	 * @return classCateGoryUpdFlg
	 */
	public String getClassCateGoryUpdFlg() {
		return classCateGoryUpdFlg;
	}

	/**
	 * @param classCateGoryUpdFlg セットする classCateGoryUpdFlg
	 */
	public void setClassCateGoryUpdFlg(String classCateGoryUpdFlg) {
		this.classCateGoryUpdFlg = classCateGoryUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javapubInstitutionを設定
	 * @return pubInstitution
	 */
	public String getPubInstitution() {
		return pubInstitution;
	}

	/**
	 * @param pubInstitution セットする pubInstitution
	 */
	public void setPubInstitution(String pubInstitution) {
		this.pubInstitution = pubInstitution;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javapubInstitutionUpdFlgを設定
	 * @return pubInstitutionUpdFlg
	 */
	public String getPubInstitutionUpdFlg() {
		return pubInstitutionUpdFlg;
	}

	/**
	 * @param pubInstitutionUpdFlg セットする pubInstitutionUpdFlg
	 */
	public void setPubInstitutionUpdFlg(String pubInstitutionUpdFlg) {
		this.pubInstitutionUpdFlg = pubInstitutionUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javapubInstStYmdを設定
	 * @return pubInstStYmd
	 */
	public String getPubInstStYmd() {
		return pubInstStYmd;
	}

	/**
	 * @param pubInstStYmd セットする pubInstStYmd
	 */
	public void setPubInstStYmd(String pubInstStYmd) {
		this.pubInstStYmd = pubInstStYmd;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javapubInstStYmdUpdFlgを設定
	 * @return pubInstStYmdUpdFlg
	 */
	public String getPubInstStYmdUpdFlg() {
		return pubInstStYmdUpdFlg;
	}

	/**
	 * @param pubInstStYmdUpdFlg セットする pubInstStYmdUpdFlg
	 */
	public void setPubInstStYmdUpdFlg(String pubInstStYmdUpdFlg) {
		this.pubInstStYmdUpdFlg = pubInstStYmdUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javapubInstEdYmdを設定
	 * @return pubInstEdYmd
	 */
	public String getPubInstEdYmd() {
		return pubInstEdYmd;
	}

	/**
	 * @param pubInstEdYmd セットする pubInstEdYmd
	 */
	public void setPubInstEdYmd(String pubInstEdYmd) {
		this.pubInstEdYmd = pubInstEdYmd;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javapubInstEdYmdUpdFlgを設定
	 * @return pubInstEdYmdUpdFlg
	 */
	public String getPubInstEdYmdUpdFlg() {
		return pubInstEdYmdUpdFlg;
	}

	/**
	 * @param pubInstEdYmdUpdFlg セットする pubInstEdYmdUpdFlg
	 */
	public void setPubInstEdYmdUpdFlg(String pubInstEdYmdUpdFlg) {
		this.pubInstEdYmdUpdFlg = pubInstEdYmdUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javapubInstPositionを設定
	 * @return pubInstPosition
	 */
	public String getPubInstPosition() {
		return pubInstPosition;
	}

	/**
	 * @param pubInstPosition セットする pubInstPosition
	 */
	public void setPubInstPosition(String pubInstPosition) {
		this.pubInstPosition = pubInstPosition;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javapubInstPositionUpdFlgを設定
	 * @return pubInstPositionUpdFlg
	 */
	public String getPubInstPositionUpdFlg() {
		return pubInstPositionUpdFlg;
	}

	/**
	 * @param pubInstPositionUpdFlg セットする pubInstPositionUpdFlg
	 */
	public void setPubInstPositionUpdFlg(String pubInstPositionUpdFlg) {
		this.pubInstPositionUpdFlg = pubInstPositionUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javapubInstposStYmdを設定
	 * @return pubInstposStYmd
	 */
	public String getPubInstposStYmd() {
		return pubInstposStYmd;
	}

	/**
	 * @param pubInstposStYmd セットする pubInstposStYmd
	 */
	public void setPubInstposStYmd(String pubInstposStYmd) {
		this.pubInstposStYmd = pubInstposStYmd;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javapubInstposStYmdUpdFlgを設定
	 * @return pubInstposStYmdUpdFlg
	 */
	public String getPubInstposStYmdUpdFlg() {
		return pubInstposStYmdUpdFlg;
	}

	/**
	 * @param pubInstposStYmdUpdFlg セットする pubInstposStYmdUpdFlg
	 */
	public void setPubInstposStYmdUpdFlg(String pubInstposStYmdUpdFlg) {
		this.pubInstposStYmdUpdFlg = pubInstposStYmdUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javapubInstposEdYmdを設定
	 * @return pubInstposEdYmd
	 */
	public String getPubInstposEdYmd() {
		return pubInstposEdYmd;
	}

	/**
	 * @param pubInstposEdYmd セットする pubInstposEdYmd
	 */
	public void setPubInstposEdYmd(String pubInstposEdYmd) {
		this.pubInstposEdYmd = pubInstposEdYmd;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javapubInstposEdYmdUpdFlgを設定
	 * @return pubInstposEdYmdUpdFlg
	 */
	public String getPubInstposEdYmdUpdFlg() {
		return pubInstposEdYmdUpdFlg;
	}

	/**
	 * @param pubInstposEdYmdUpdFlg セットする pubInstposEdYmdUpdFlg
	 */
	public void setPubInstposEdYmdUpdFlg(String pubInstposEdYmdUpdFlg) {
		this.pubInstposEdYmdUpdFlg = pubInstposEdYmdUpdFlg;
	}

	/**
	 * @param inOffset セットする inOffset
	 */
	public void setInOffset(Integer inOffset) {
		this.inOffset = inOffset;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javahunivを設定
	 * @return huniv
	 */
	public String getHuniv() {
		return huniv;
	}

	/**
	 * @param huniv セットする huniv
	 */
	public void setHuniv(String huniv) {
		this.huniv = huniv;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javahunivUpdFlgを設定
	 * @return hunivUpdFlg
	 */
	public String getHunivUpdFlg() {
		return hunivUpdFlg;
	}

	/**
	 * @param hunivUpdFlg セットする hunivUpdFlg
	 */
	public void setHunivUpdFlg(String hunivUpdFlg) {
		this.hunivUpdFlg = hunivUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javadeptCodeを設定
	 * @return deptCode
	 */
	public String getDeptCode() {
		return deptCode;
	}

	/**
	 * @param deptCode セットする deptCode
	 */
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javadeptKjを設定
	 * @return deptKj
	 */
	public String getDeptKj() {
		return deptKj;
	}

	/**
	 * @param deptKj セットする deptKj
	 */
	public void setDeptKj(String deptKj) {
		this.deptKj = deptKj;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javakensakuDeptCodeを設定
	 * @return kensakuDeptCode
	 */
	public String getKensakuDeptCode() {
		return kensakuDeptCode;
	}

	/**
	 * @param kensakuDeptCode セットする kensakuDeptCode
	 */
	public void setKensakuDeptCode(String kensakuDeptCode) {
		this.kensakuDeptCode = kensakuDeptCode;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javakensakuHunivを設定
	 * @return kensakuHuniv
	 */
	public String getKensakuHuniv() {
		return kensakuHuniv;
	}

	/**
	 * @param kensakuHuniv セットする kensakuHuniv
	 */
	public void setKensakuHuniv(String kensakuHuniv) {
		this.kensakuHuniv = kensakuHuniv;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javaunivPosCodeAfUpdFlgを設定
	 * @return univPosCodeAfUpdFlg
	 */
	public String getUnivPosCodeAfUpdFlg() {
		return univPosCodeAfUpdFlg;
	}

	/**
	 * @param univPosCodeAfUpdFlg セットする univPosCodeAfUpdFlg
	 */
	public void setUnivPosCodeAfUpdFlg(String univPosCodeAfUpdFlg) {
		this.univPosCodeAfUpdFlg = univPosCodeAfUpdFlg;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javadccTypeAfUpdFlgを設定
	 * @return dccTypeAfUpdFlg
	 */
	public String getDccTypeAfUpdFlg() {
		return dccTypeAfUpdFlg;
	}

	/**
	 * @param dccTypeAfUpdFlg セットする dccTypeAfUpdFlg
	 */
	public void setDccTypeAfUpdFlg(String dccTypeAfUpdFlg) {
		this.dccTypeAfUpdFlg = dccTypeAfUpdFlg;
	}

	/**
	 * @param kensakuUpdMstFrom セットする kensakuUpdMstFrom
	 */
	public void setKensakuUpdMstFrom(String kensakuUpdMstFrom) {
		this.kensakuUpdMstFrom = kensakuUpdMstFrom;
	}

	/**
	 * @param kensakuUpdMstTo セットする kensakuUpdMstTo
	 */
	public void setKensakuUpdMstTo(String kensakuUpdMstTo) {
		this.kensakuUpdMstTo = kensakuUpdMstTo;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javainsNoを設定
	 * @return insNo
	 */
	public String getInsNo() {
		return insNo;
	}

	/**
	 * @param insNo セットする insNo
	 */
	public void setInsNo(String insNo) {
		this.insNo = insNo;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javainsAbbrNameを設定
	 * @return insAbbrName
	 */
	public String getInsAbbrName() {
		return insAbbrName;
	}

	/**
	 * @param insAbbrName セットする insAbbrName
	 */
	public void setInsAbbrName(String insAbbrName) {
		this.insAbbrName = insAbbrName;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javahenkanInsNoを設定
	 * @return henkanInsNo
	 */
	public String getHenkanInsNo() {
		return henkanInsNo;
	}

	/**
	 * @param henkanInsNo セットする henkanInsNo
	 */
	public void setHenkanInsNo(String henkanInsNo) {
		this.henkanInsNo = henkanInsNo;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javakensakuUpdMstFromを設定
	 * @return kensakuUpdMstFrom
	 */
	public String getKensakuUpdMstFrom() {
		return kensakuUpdMstFrom;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javakensakuUpdMstToを設定
	 * @return kensakuUpdMstTo
	 */
	public String getKensakuUpdMstTo() {
		return kensakuUpdMstTo;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javakensakuShinseiBrCodeを設定
	 * @return kensakuShinseiBrCode
	 */
	public String getKensakuShinseiBrCode() {
		return kensakuShinseiBrCode;
	}

	/**
	 * @param kensakuShinseiBrCode セットする kensakuShinseiBrCode
	 */
	public void setKensakuShinseiBrCode(String kensakuShinseiBrCode) {
		this.kensakuShinseiBrCode = kensakuShinseiBrCode;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javakensakuShinseiDistCodeを設定
	 * @return kensakuShinseiDistCode
	 */
	public String getKensakuShinseiDistCode() {
		return kensakuShinseiDistCode;
	}

	/**
	 * @param kensakuShinseiDistCode セットする kensakuShinseiDistCode
	 */
	public void setKensakuShinseiDistCode(String kensakuShinseiDistCode) {
		this.kensakuShinseiDistCode = kensakuShinseiDistCode;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javakensakuSTantouBrCodeを設定
	 * @return kensakuSTantouBrCode
	 */
	public String getKensakuSTantouBrCode() {
		return kensakuSTantouBrCode;
	}

	/**
	 * @param kensakuSTantouBrCode セットする kensakuSTantouBrCode
	 */
	public void setKensakuSTantouBrCode(String kensakuSTantouBrCode) {
		this.kensakuSTantouBrCode = kensakuSTantouBrCode;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javakensakuTantouDistCodeを設定
	 * @return kensakuTantouDistCode
	 */
	public String getKensakuTantouDistCode() {
		return kensakuTantouDistCode;
	}

	/**
	 * @param kensakuTantouDistCode セットする kensakuTantouDistCode
	 */
	public void setKensakuTantouDistCode(String kensakuTantouDistCode) {
		this.kensakuTantouDistCode = kensakuTantouDistCode;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javamrJgiNoを設定
	 * @return mrJgiNo
	 */
	public int getMrJgiNo() {
		return mrJgiNo;
	}

	/**
	 * @param mrJgiNo セットする mrJgiNo
	 */
	public void setMrJgiNo(int mrJgiNo) {
		this.mrJgiNo = mrJgiNo;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javamrBrCodeを設定
	 * @return mrBrCode
	 */
	public String getMrBrCode() {
		return mrBrCode;
	}

	/**
	 * @param mrBrCode セットする mrBrCode
	 */
	public void setMrBrCode(String mrBrCode) {
		this.mrBrCode = mrBrCode;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javamrDistCodeを設定
	 * @return mrDistCode
	 */
	public String getMrDistCode() {
		return mrDistCode;
	}

	/**
	 * @param mrDistCode セットする mrDistCode
	 */
	public void setMrDistCode(String mrDistCode) {
		this.mrDistCode = mrDistCode;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javamrTrtCdを設定
	 * @return mrTrtCd
	 */
	public String getMrTrtCd() {
		return mrTrtCd;
	}

	/**
	 * @param mrTrtCd セットする mrTrtCd
	 */
	public void setMrTrtCd(String mrTrtCd) {
		this.mrTrtCd = mrTrtCd;
	}

	/**
	 * MRdmHcpUpdHstListEntity.javajokenSetCdを設定
	 * @return jokenSetCd
	 */
	public String getJokenSetCd() {
		return jokenSetCd;
	}

	/**
	 * @param jokenSetCd セットする jokenSetCd
	 */
	public void setJokenSetCd(String jokenSetCd) {
		this.jokenSetCd = jokenSetCd;
	}

	/**
	 * MRdmHcpUpdHstListEntity.delFlgUpdFlgを設定
	 * @return delFlgUpdFlg
	 */
	public String getDelFlgUpdFlg() {
		return delFlgUpdFlg;
	}

	/**
	 * @param delFlgUpdFlg セットする delFlgUpdFlg
	 */
	public void setDelFlgUpdFlg(String delFlgUpdFlg) {
		this.delFlgUpdFlg = delFlgUpdFlg;
	}


}
