/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jp.co.takeda.rdm.common.BaseEntity;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 結合Entityクラス
 * テーブル物理名 : M_RDM_HCP_MST
 * SQLID : selectCntHcp
 */
public class SelectCntSelectNtyListEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 医師検索表示件数
     */
    private Integer CntHcp;
    /**
     * 申請一覧検索表示件数
     */
    private Integer CntReq;


    /**
     * コンストラクタ
     */
    public SelectCntSelectNtyListEntity() {
        super("t-rdm-nty-knr" , "countNtyKnr");
    }

    /**
     * 親画面から受け取るMR/管理者のflag
     */
    private String mrAdminCd;

	/**
	 * 親画面から受け取るMR/管理者のflagを取得します。
	 * @return 親画面から受け取るMR/管理者のflag
	 */
	public String getMrAdminCd() {
		return mrAdminCd;
	}
	/**
	 * 親画面から受け取るMR/管理者のflagを設定します。
	 * @param mrAdminCd 親画面から受け取るMR/管理者のflag
	 */
	public void setMrAdminCd(String mrAdminCd) {
		this.mrAdminCd = mrAdminCd;
	}
	/**
     * 従業員番号
     */
    private String jgiNo;
    /**
     * 従業員名
     */
    private String jgiName;

    public String getJgiNo() {
		return jgiNo;
	}
	public void setJgiNo(String jgiNo) {
		this.jgiNo = jgiNo;
	}
	public String getJgiName() {
		return jgiName;
	}
	public void setJgiName(String jgiName) {
		this.jgiName = jgiName;
	}
	private String mrAdminFlg;

	/**
	 * mrAdminFlgを取得します。
	 * @return mrAdminFlg
	 */
	public String getMrAdminFlg() {
		return mrAdminFlg;
	}
	/**
	 * mrAdminFlgを設定します。
	 * @param mrAdminFlg mrAdminFlg
	 */
	public void setMrAdminFlg(String mrAdminFlg) {
		this.mrAdminFlg = mrAdminFlg;
	}

	/**
     * 検索-JIS都道府県
     * @generated
     */
    private String aDdrCodePref;
    /**
     * JIS府県-検索をセットする
     * @param JIS府県-検索
     * @generated
     */
    public void setADdrCodePref(String aDdrCodePref){
        this.aDdrCodePref = aDdrCodePref;
    }

    /**
     * JIS府県-検索を返す
     * @return JIS府県-検索
     * @generated
     */
    public String getADdrCodePref(){
        return aDdrCodePref;
    }
	/**
     * @generated
     */
    private LinkedHashMap jkrSosAddrMap;
    /**
	 * @generatedを取得します。
	 * @return @generated
	 */
	public LinkedHashMap getJkrSosAddrMap() {
	    return jkrSosAddrMap;
	}
	/**
	 * @generatedを設定します。
	 * @param jkrSosAddrMap @generated
	 */
	public void setJkrSosAddrMap(LinkedHashMap jkrSosAddrMap) {
	    this.jkrSosAddrMap = jkrSosAddrMap;
	}

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
     * rEQ_ID
     * @generated
     */

    private String reqId;

	/**
	 * 検索-申請日時
	 * inreqYmdhmsFrom
	 * @generated
	 */

    private String inreqYmdhmsFrom;

	/**
	 * 検索-申請日時
	 * inreqYmdhmsTo
	 * @generated
	 */

    private String inreqYmdhmsTo;
    /**
     * reqYmdhmsFrom
     * @generated
     */

    private String reqYmdhmsFrom;
    /**
     * reqYmdhmsTo
     * @generated
     */

    private String reqYmdhmsTo;

        /**
     * reqChl
     * @generated
     */

    private String reqChl;

	/**
     * 検索-種別
     * @generated
     */
    private String sbt;
    /**
     * 検索-連携種別
     * @generated
     */
    private String reqSbt;

        /**
     * reqType
     * @generated
     */
    private String reqType;

        /**
     * reqSts
     * @generated
     */

    private String reqSts;

        /**
     * insNo
     * @generated
     */

    private String insNo;

	    /**
	 * docNo
	 * @generated
	 */

	private String docNo;

	    /**
	 * insClass
	 * @generated
	 */

	private String insClass;

	    /**
	 * insSbt
	 * @generated
	 */

	private String insSbt;

	    /**
	 * docType
	 * @generated
	 */

	private String docType;

	    /**
	 * jobForm 勤務形態
	 * @generated
	 */

	private String jobForm;

		/**
	 * hoInsType
	 * @generated
	 */

	private String hoInsType;
        /**
     * insFormalName
     * @generated
     */

    private String insFormalName;

    /**
     * 施設名-検索用
     */
    private String insKanjiSrch;

	    public String getInsKanjiSrch() {
		return insKanjiSrch;
	}

	public void setInsKanjiSrch(String insKanjiSrch) {
		this.insKanjiSrch = insKanjiSrch;
	}

	    /**
	 * docKanj
	 * @generated
	 */

    private String docKanj;

		/**
     * reqJgiName
     * @generated
     */

    private String reqJgiName;

	/**
     * reqJgiNo
     * @generated
     */

    private String reqJgiNo;

    /**
     *部門ランク
     */
	private String bumonRank;

    public String getBumonRank() {
		return bumonRank;
	}
	public void setBumonRank(String bumonRank) {
		this.bumonRank = bumonRank;
	}

    /**
     *組織コード
     */
	private String sosCd;

	public String getSosCd() {
		return sosCd;
	}
	public void setSosCd(String sosCd) {
		this.sosCd = sosCd;
	}

    /**
     *組織名称
     */
	private String bumonRyakuName;

	public String getBumonRyakuName() {
		return bumonRyakuName;
	}
	public void setBumonRyakuName(String bumonRyakuName) {
		this.bumonRyakuName = bumonRyakuName;
	}
	/**
	 * 医薬支店Cとの比較
	 */
	private String brCode;


		/**
	 *  医薬営業所Cとの比較
	 */

	private String distCode;



        /**
     * reqShz
     * @generated
     */

    private String reqShz;
	    /**
	 * reqComment
	 * 申請コメント
	 * @generated
	 */

	private String reqComment;

        /**
     * aPR_YMDHMS
     * @generated
     */

    private String aPR_YMDHMS;

        /**
     * aPR_SHA_ID
     * @generated
     */

    private String aPR_SHA_ID;

        /**
     * aPR_MEMO
     * @generated
     */

    private String aPR_MEMO;

        /**
     * aPR_COMMNET
     * @generated
     */

    private String aprComment;

	public Integer getCntHcp() {
			return CntHcp;
		}
	/**
	 * Offset値を取得します。
	 * @return Offset値
	 */
	public Integer getInOffset
	() {
	    return this.inOffset;
	}
	/**
	 * Offset値を設定します。
	 * @param inOffset Offset値
	 */
	public void setInOffset(Integer inOffset) {
	    this.inOffset = inOffset;
	}
	/**
	 * Limit値を取得します。
	 * @return Limit値
	 */
	public Integer getInLimit
	() {
	    return this.inLimit;
	}
	/**
	 * Limit値を設定します。
	 * @param inLimit Limit値
	 */
	public void setInLimit(Integer inLimit) {
	    this.inLimit = inLimit;
	}
	/**
	 * rEQ_IDを取得します。
	 * @return rEQ_ID
	 */
	public String getReqId() {
	    return reqId;
	}
	/**
	 * rEQ_IDを設定します。
	 * @param reqId rEQ_ID
	 */
	public void setReqId(String reqId) {
	    this.reqId = reqId;
	}
	/**
	 * reqYmdhmsFromを取得します。
	 * @return reqYmdhmsFrom
	 */
	public String getReqYmdhmsFrom() {
	    return reqYmdhmsFrom;
	}
	/**
	 * reqYmdhmsFromを設定します。
	 * @param reqYmdhmsFrom reqYmdhmsFrom
	 */
	public void setReqYmdhmsFrom(String reqYmdhmsFrom) {
	   this.reqYmdhmsFrom = reqYmdhmsFrom;
	}
/**
 * reqYmdhmsToを取得します。
 * @return reqYmdhmsTo
 */
public String getReqYmdhmsTo() {
return reqYmdhmsTo;
}
/**
 * reqYmdhmsToを設定します。
 * @param reqYmdhmsTo reqYmdhmsTo
 */
public void setReqYmdhmsTo(String reqYmdhmsTo) {
this.reqYmdhmsTo = reqYmdhmsTo;
}
/**
 * 検索-申請日時を取得します。
 * @return 検索-申請日時
 */
public String getInreqYmdhmsFrom() {
return inreqYmdhmsFrom;
}
/**
 * 検索-申請日時を設定します。
 * @param inreqYmdhmsFrom 検索-申請日時
 */
public void setInreqYmdhmsFrom(String inreqYmdhmsFrom) {
this.inreqYmdhmsFrom = inreqYmdhmsFrom;
}
	/**
	 * 検索-申請日時を取得します。
	 * @return 検索-申請日時
	 */
	public String getInreqYmdhmsTo() {
	   return inreqYmdhmsTo;
	}
	/**
	 * 検索-申請日時を設定します。
	 * @param inreqYmdhmsTo 検索-申請日時
	 */
	public void setInreqYmdhmsTo(String inreqYmdhmsTo) {
	   this.inreqYmdhmsTo = inreqYmdhmsTo;
	}
	/**
	 * reqChlを取得します。
	 * @return reqChl
	 */
	public String getReqChl() {
	    return reqChl;
	}
	/**
	 * reqChlを設定します。
	 * @param reqChl reqChl
	 */
	public void setReqChl(String reqChl) {
	    this.reqChl = reqChl;
	}
	/**
	 * 検索-種別を設定します。
	 * @param sbt 検索-種別
	 */
	public void setSbt(String sbt){
	    this.sbt = sbt;
	}
	/**
	 * 検索-種別を取得します。
	 * @return 検索-種別
	 */
	public String getSbt(){
	    return sbt;
	}
	/**
	 * 検索-連携種別を設定します。
	 * @param reqSbt 検索-連携種別
	 */
	public void setReqSbt(String reqSbt){
	    this.reqSbt = reqSbt;
	}
	/**
	 * 検索-連携種別を取得します。
	 * @return 検索-連携種別
	 */
	public String getReqSbt(){
	    return reqSbt;
	}
	/**
	 * reqTypeを取得します。
	 * @return reqType
	 */
	public String getReqType() {
	    return reqType;
	}
	/**
	 * reqTypeを設定します。
	 * @param reqType reqType
	 */
	public void setReqType(String reqType) {
	   this.reqType = reqType;
	}
	/**
	 * reqStsを取得します。
	 * @return reqSts
	 */
	public String getReqSts() {
	    return reqSts;
	}
	/**
	 * reqStsを設定します。
	 * @param reqSts reqSts
	 */
	public void setReqSts(String reqSts) {
	   this.reqSts = reqSts;
	}
	/**
	 * insNoを取得します。
	 * @return insNo
	 */
	public String getInsNo() {
	    return insNo;
	}
	/**
	 * insNoを設定します。
	 * @param insNo insNo
	 */
	public void setInsNo(String insNo) {
	   this.insNo = insNo;
	}
/**
 * docNoを取得します。
 * @return docNo
 */
public String getDocNo() {
return docNo;
}
	/**
	 * docNoを設定します。
	 * @param docNo docNo
	 */
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
/**
 * insClassを取得します。
 * @return insClass
 */
public String getInsClass() {
return insClass;
}
/**
 * insClassを設定します。
 * @param insClass insClass
 */
public void setInsClass(String insClass) {
this.insClass = insClass;
}
	/**
	 * insSbtを取得します。
	 * @return insSbt
	 */
	public String getInsSbt() {
	   return insSbt;
	}
	/**
	 * insSbtを設定します。
	 * @param insSbt insSbt
	 */
	public void setInsSbt(String insSbt) {
	  this.insSbt = insSbt;
	}
	/**
	 * docTypeを取得します。
	 * @return docType
	 */
	public String getDocType() {
		return docType;
	}
	/**
	 * docTypeを設定します。
	 * @param docType docType
	 */
	public void setDocType(String docType) {
		this.docType = docType;
	}
/**
 * jobForm 勤務形態を取得します。
 * @return jobForm 勤務形態
 */
public String getJobForm() {
return jobForm;
}
	/**
	 * jobForm 勤務形態を設定します。
	 * @param jobForm jobForm 勤務形態
	 */
	public void setJobForm(String jobForm) {
		this.jobForm = jobForm;
	}
	/**
	 * hoInsTypeを取得します。
	 * @return hoInsType
	 */
	public String getHoInsType() {
	    return hoInsType;
	}
	/**
	 * hoInsTypeを設定します。
	 * @param hoInsType hoInsType
	 */
	public void setHoInsType(String hoInsType) {
	   this.hoInsType = hoInsType;
	}
	/**
	 * insFormalNameを取得します。
	 * @return insFormalName
	 */
	public String getInsFormalName() {
	    return insFormalName;
	}
	/**
	 * insFormalNameを設定します。
	 * @param insFormalName insFormalName
	 */
	public void setInsFormalName(String insFormalName) {
	   this.insFormalName = insFormalName;
	}
/**
 * docKanjを取得します。
 * @return docKanj
 */
public String getDocKanj() {
	return docKanj;
}
		/**
		 * docKanjを設定します。
		 * @param docKanj docKanj
		 */
		public void setDocKanj(String docKanj) {
					this.docKanj = docKanj;
				}
	/**
	 * reqJgiNameを取得します。
	 * @return reqJgiName
	 */
	public String getReqJgiName() {
	    return reqJgiName;
	}
	/**
	 * reqJgiNameを設定します。
	 * @param reqJgiName reqJgiName
	 */
	public void setReqJgiName(String reqJgiName) {
	   this.reqJgiName = reqJgiName;
	}
	/**
	 * reqJgiNoを取得します。
	 * @return reqJgiName
	 */
    public String getReqJgiNo() {
		return reqJgiNo;
	}
	public void setReqJgiNo(String reqJgiNo) {
		this.reqJgiNo = reqJgiNo;
	}
	/**
	 * 医薬支店Cとの比較
	 */
    public String getBrCode() {
		return brCode;
	}
	public void setBrCode(String reqBrCode) {
		this.brCode = reqBrCode;
	}
	/**
	 * 医薬営業所Cとの比較
	 */
	public String getDistCode() {
		return distCode;
	}
	public void setDistCode(String distCode) {
		this.distCode = distCode;
	}

	/**
	 * reqShzを取得します。
	 * @return reqShz
	 */
	public String getReqShz() {
	    return reqShz;
	}
	/**
	 * reqShzを設定します。
	 * @param reqShz reqShz
	 */
	public void setReqShz(String reqShz) {
	   this.reqShz = reqShz;
	}
/**
 * reqCommentを設定します。
 * @param reqComment reqComment
 */
public void setReqComment(String reqComment) {
this.reqComment = reqComment;
}
/**
 * reqCommentを取得します。
 * @return reqComment
 */
public String getReqComment() {
return reqComment;
}
	/**
     * 検索条件_承認日時
     */
    public String getAPR_YMDHMS() {
        return aPR_YMDHMS;
    }
    /**
    * 承認日時の設定
    * @param sysCd 承認日時
    */
   public void setAPR_YMDHMS(String aPR_YMDHMS) {
       this.aPR_YMDHMS = aPR_YMDHMS;
   }
    /**
     * 検索条件_承認者
     */
    public String getAPR_SHA_ID() {
        return aPR_SHA_ID;
    }
    /**
    * 承認者の設定
    * @param sysCd 承認者
    */
   public void setAPR_SHA_ID(String aPR_SHA_ID) {
       this.aPR_SHA_ID = aPR_SHA_ID;
   }
    /**
     * 検索条件_審査・承認メモ
     */
    public String getAPR_MEMO() {
        return aPR_MEMO;
    }
    /**
    * 審査・承認メモの設定
    * @param sysCd 審査・承認メモ
    */
   public void setAPR_MEMO(String aPR_MEMO) {
       this.aPR_MEMO = aPR_MEMO;
   }
    /**
	 * aPR_COMMNETを取得します。
	 * @return aPR_COMMNET
	 */
	public String getAprComment() {
	    return aprComment;
	}
	/**
	 * aPR_COMMNETを設定します。
	 * @param aprComment aPR_COMMNET
	 */
	public void setAprComment(String aprComment) {
	   this.aprComment = aprComment;
	}

	/**
	 * 審査flag
	 */
	private String shnFlg;

	/**
	 * 審査flagを取得します。
	 * @return 審査flag
	 */
	public String getShnFlg() {
		return shnFlg;
	}
	/**
	 * 審査flagを設定します。
	 * @param shnFlg 審査flag
	 */
	public void setShnFlg(String shnFlg) {
		this.shnFlg = shnFlg;
	}

	/**
	 * 審査日時
	 */
	private String shnYmdhms;


	/**
	 * 審査日時を取得します。
	 * @return 審査日時
	 */
	public String getShnYmdhms() {
		return shnYmdhms;
	}
	/**
	 * 審査日時を設定します。
	 * @param shnYmdhms 審査日時
	 */
	public void setShnYmdhms(String shnYmdhms) {
		this.shnYmdhms = shnYmdhms;
	}

	/**
	 * 審査者名
	 */
	private String shnShaId;

	/**
	 * 審査者名を取得します。
	 * @return 審査者名
	 */
	public String getShnShaId() {
		return shnShaId;
	}
	/**
	 * 審査者名を設定します。
	 * @param shnShaId 審査者名
	 */
	public void setShnShaId(String shnShaId) {
		this.shnShaId = shnShaId;
	}

	/**
	 * FB申請要否
	 */
	private String fbReqFlg;

	/**
	 * FB申請要否を取得します。
	 * @return FB申請要否
	 */
	public String getFbReqFlg() {
		return fbReqFlg;
	}
	/**
	 * FB申請要否を設定します。
	 * @param fbReqFlg FB申請要否
	 */
	public void setFbReqFlg(String fbReqFlg) {
		this.fbReqFlg = fbReqFlg;
	}

	/**
	 * FB回答ID
	 *
	 */
	private String fbAnsId;

	/**
	 * FB回答IDを取得します。
	 * @return FB回答ID
	 */
	public String getFbAnsId() {
		return fbAnsId;
	}
	/**
	 * FB回答IDを設定します。
	 * @param fbAnsId FB回答ID
	 */
	public void setFbAnsId(String fbAnsId) {
		this.fbAnsId = fbAnsId;
	}

	/**
	 * FB処理区分
	 */
	private String fbPrcType;

	/**
	 * FB処理区分を取得します。
	 * @return FB処理区分
	 */
	public String getFbPrcType() {
		return fbPrcType;
	}
	/**
	 * FB処理区分を設定します。
	 * @param fbPrcType FB処理区分
	 */
	public void setFbPrcType(String fbPrcType) {
		this.fbPrcType = fbPrcType;
	}
	/**
     * このEntityの値を返す
     * @return DTOの値
     * @generated
     */


	public void setCntHcp(Integer cntHcp) {
		CntHcp = cntHcp;
	}
	/**
	 * SelectParamSelectHcpEntity.javaCntHcpを設定
	 * @return cntHcp
	 */
	public Integer getCntReq() {
		return CntReq;
	}

	/**
	 * @param cntHcp セットする cntHcp
	 */
	public void setCntReq(Integer cntReq) {
		CntHcp = cntReq;
	}

	/**
     * このEntityの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
