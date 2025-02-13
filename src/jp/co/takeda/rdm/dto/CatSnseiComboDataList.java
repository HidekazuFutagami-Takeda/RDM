/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.dto;

import java.io.Serializable;


/**
 * DTOクラス
 * @generated
 */
public class CatSnseiComboDataList implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 選択
     * @generated
     */
    private boolean checkers;

    /**
     * 種別
     */

    private String sbt;


	/**
     * reqId 申請ID
     * @generated
     */

    private String reqId;

	/**
	 * 検索-申請日時
	 * inreqYmdhms
	 * @generated
	 */

    private String inreqYmdhmsFrom;
	/**
	 * 検索-申請日時
	 * inreqYmdhms
	 * @generated
	 */

    private String inreqYmdhmsTo;
    /**
     * reqYmdhms
     * @generated
     */

    private String reqYmdhmsFrom;
    /**
     * reqYmdhms
     * @generated
     */

    private String reqYmdhmsTo;

        /**
     * reqChl
     * @generated
     */

    private String reqChl;

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
	 * reqSts
	 * @generated
	 */

	private String reqSbt;


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
	 *insClass
	 * @generated
	 */

	private String insClass;


	    /**
	 * reqSts
	 * @generated
	 */

    private String insSbt;

	    /**
	 * reqSts
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
	 * brCode
	 * @generated
	 */

	private String brCode;


		/**
	 * distCode
	 * @generated
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

    /**
     * 遷移元画面ID
     */
	private String preScreenId;
	public String getPreScreenId() {
		return preScreenId;
	}

	public void setPreScreenId(String preScreenId) {
		this.preScreenId = preScreenId;
	}

    /**
     * コンストラクタ
     * @customizable
     */
    public CatSnseiComboDataList() {
        // START UOC

        // END UOC
    }

    // START UOC

    // END UOC

     /**
     * 選択の取得
     * @return 選択
     * @generated
     */
    public boolean getCheckers() {
        return checkers;
    }

    /**
     * 選択の設定
     * @param checkers 選択
     * @generated
     */
    public void setCheckers(boolean checkers) {
        this.checkers = checkers;
    }

    /**
     * 種別
     */
    public String getSbt() {
		return sbt;
	}

	public void setSbt(String sbt) {
		this.sbt = sbt;
	}


	 /**
     * 検索条件_申請ID
     */
    public String getReqId() {
        return reqId;
    }

     /**
     * 申請IDの設定
     * @param sysCd 申請ID
     */
    public void setReqId(String reqId) {
        this.reqId = reqId;
    }
    /**
    * 検索条件_申請年月日
    */
   public String getInreqYmdhmsFrom() {
       return inreqYmdhmsFrom;
   }
    /**
    * 申請年月日の設定
    * @param sysCd 申請年月日
    */
   public void setInreqYmdhmsFrom(String inreqYmdhmsFrom) {
       this.inreqYmdhmsFrom = inreqYmdhmsFrom;
   }
   /**
   * 検索条件_申請年月日
   */
  public String getInreqYmdhmsTo() {
      return inreqYmdhmsTo;
  }
   /**
   * 申請年月日の設定
   * @param sysCd 申請年月日
   */
  public void setInreqYmdhmsTo(String inreqYmdhmsTo) {
      this.inreqYmdhmsTo = inreqYmdhmsTo;
  }
    /**
    * 検索条件_申請年月日
    */
   public String getReqYmdhmsFrom() {
       return reqYmdhmsFrom;
   }
    /**
    * 申請年月日の設定
    * @param sysCd 申請年月日
    */
   public void setReqYmdhmsFrom(String reqYmdhmsFrom) {
       this.reqYmdhmsFrom = reqYmdhmsFrom;
   }
     /**
     * 検索条件_申請年月日
     */
    public String getReqYmdhmsTo() {
        return reqYmdhmsTo;
    }
     /**
     * 申請年月日の設定
     * @param sysCd 申請年月日
     */
    public void setReqYmdhmsTo(String reqYmdhmsTo) {
        this.reqYmdhmsTo = reqYmdhmsTo;
    }
     /**
     * 検索条件_申請チャネル
     */
    public String getReqChl() {
        return reqChl;
    }
     /**
     * 申請チャネルの設定
     * @param sysCd 申請チャネル
     */
    public void setReqChl(String reqChl) {
        this.reqChl = reqChl;
    }
    /**
     * 検索条件_申請タイプ
     */
    public String getReqType() {
        return reqType;
    }
    /**
    * 申請タイプの設定
    * @param sysCd 申請タイプ
    */
   public void setReqType(String reqType) {
       this.reqType = reqType;
   }
     /**
     * 検索条件_申請ステータス
     */
    public String getReqSts() {
        return reqSts;
    }
    /**
    * 申請ステータスの設定
    * @param sysCd 申請ステータス
    */
   public void setReqSts(String reqSts) {
       this.reqSts = reqSts;
   }
   /**
   * 検索条件_連携種別
   */
   public String getReqSbt() {
		return reqSbt;
	}

	public void setReqSbt(String reqSbt) {
		this.reqSbt = reqSbt;
	}
    /**
     * 検索条件_施設固定コード
     */
    public String getInsNo() {
        return insNo;
    }
    /**
    * 施設固定コードの設定
    * @param sysCd 施設固定コード
    */
   public void setInsNo(String insNo) {
       this.insNo = insNo;
   }
   /**
   * 医師固定コードの設定
   * @param sysCd 施設固定コード
   */
   public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
   /**
   * 検索条件_施設種別
   */
  public String getInsClass() {
      return insClass;
  }
  /**
  * 施設種別の設定
  * @param sysCd 施設種別
  */
 public void setInsClass(String insClass) {
     this.insClass = insClass;
 }
	   /**
	   * 検索条件_施設種別
	   */
	  public String getInsSbt() {
	      return insSbt;
	  }
	  /**
	  * 施設種別の設定
	  * @param sysCd 施設種別
	  */
	 public void setInsSbt(String insSbt) {
	     this.insSbt = insSbt;
	 }
		/**
		* 検索条件_医師種別
		*/
	    public String getDocType() {
			return docType;
		}

		public void setDocType(String docType) {
			this.docType = docType;
		}
		   /**
		    * 検索条件_勤務形態
		    */
		public String getJobForm() {
			return jobForm;
		}
		public void setJobForm(String jobForm) {
			this.jobForm = jobForm;
		}
	 /**
	 * 検索条件_対象区分
	 */
	public String getHoInsType() {
	    return hoInsType;
	}
	/**
	* 対象区分の設定
	* @param sysCd 対象区分
	*/
	public void setHoInsType(String hoInsType) {
	   this.hoInsType = hoInsType;
	}
    /**
     * 検索条件_施設名
     */
    public String getInsFormalName() {
        return insFormalName;
    }
    /**
    * 施設名の設定
    * @param sysCd 施設名
    */
   public void setInsFormalName(String insFormalName) {
       this.insFormalName = insFormalName;
   }
   /**
    * 検索条件_医師名
    */
       public String getDocKanj() {
			return docKanj;
		}

		public void setDocKanj(String docKanj) {
			this.docKanj = docKanj;
		}

    /**
     * 検索条件_申請者名
     */
    public String getReqJgiName() {
        return reqJgiName;
    }
    /**
    * 申請者名の設定
    * @param sysCd 申請者名
    */
   public void setReqJgiName(String reqJgiName) {
       this.reqJgiName = reqJgiName;
   }

	/**
	 * 申請者従業員番号を取得します。
	 * @return reqJgiName
	 */
   public String getReqJgiNo() {
		return reqJgiNo;
	}
	public void setReqJgiNo(String reqJgiNo) {
		this.reqJgiNo = reqJgiNo;
	}


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
    public String getBrCode() {
		return brCode;
	}
	public void setBrCode(String brCode) {
		this.brCode = brCode;
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
     * 検索条件_申請者所属
     */
    public String getReqShz() {
        return reqShz;
    }
    /**
     * 申請者所属
     * @param sysCd
     */
    public void setReqShz(String reqShz) {
        this.reqShz = reqShz;
    }
    /**
    * 申請コメント
    * @param sysCd 申請コメント
    */
   public void setReqComment(String reqComment) {
       this.reqComment = reqComment;
   }
   /**
    * 検索条件_申請コメント
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
     * 検索条件_承認・却下コメント
     */
    public String getAprComment() {
        return aprComment;
    }
    /**
    * 承認・却下コメントの設定
    * @param sysCd 承認・却下コメント
    */
   public void setAprComment(String aprComment) {
       this.aprComment = aprComment;
   }

	/**
	 * 審査flag
	 */
	private String shnFlg;

	public String getShnFlg() {
		return shnFlg;
	}
	public void setShnFlg(String shnFlg) {
		this.shnFlg = shnFlg;
	}
	/**
	 * 審査日時
	 */
	private String shnYmdhms;


	public String getShnYmdhms() {
		return shnYmdhms;
	}
	public void setShnYmdhms(String shnYmdhms) {
		this.shnYmdhms = shnYmdhms;
	}
	/**
	 * 審査者名
	 */
	private String shnShaId;

	public String getShnShaId() {
		return shnShaId;
	}
	public void setShnShaId(String shnShaId) {
		this.shnShaId = shnShaId;
	}

	/**
	 * FB申請要否
	 */
	private String fbReqFlg;

	public String getFbReqFlg() {
		return fbReqFlg;
	}
	public void setFbReqFlg(String fbReqFlg) {
		this.fbReqFlg = fbReqFlg;
	}
	/**
	 * FB回答ID
	 *
	 */
	private String fbAnsId;

	public String getFbAnsId() {
		return fbAnsId;
	}
	public void setFbAnsId(String fbAnsId) {
		this.fbAnsId = fbAnsId;
	}
	/**
	 * FB処理区分
	 */
	private String fbPrcType;

	public String getFbPrcType() {
		return fbPrcType;
	}
	public void setFbPrcType(String fbPrcType) {
		this.fbPrcType = fbPrcType;
	}



}

