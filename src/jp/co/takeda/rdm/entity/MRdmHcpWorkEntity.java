package jp.co.takeda.rdm.entity;

import java.io.Serializable;

import jp.co.takeda.rdm.common.BaseEntity;

/**
 * @generated
 */
public class MRdmHcpWorkEntity extends BaseEntity implements Serializable {

	/**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    //ヘッダー部ここから
    /**
    * 親画面医師固定コード
    * @generated
    */
   private String paramDocNo;

   /**
    * 検索区分
    * 0:ヘッダー部
    * 1:データ部
    * @generated
    */
   private String searchType;

   /**
    * エラーチェックフラグ
    * 0:チェックなし
     * 1:「勤務先追加」ボタン押下
     * 2:「医師の廃業・死亡」ボタン押下
     * 3:「勤務先削除」リンククリック
     * 4:「勤務先情報更新」リンククリック
     * 5:「医療機関への異動」リンククリック
     * 6:「医療機関以外への異動」リンククリック
    * @generated
    */
   private String errorCheckFlg;

   /**
    * 武田医師名（漢字）
    * @generated
    */
   private String docKanj;

   /**
    * 武田医師名（ｶﾅ）
    * @generated
    */
   private String docKana;

   /**
    * 医師固定C
    * @generated
    */
   private String docNo;

   /**
    * 医師薬剤師区分
    * @generated
    */
   private String docType;

   /**
    * ULT医師名（漢字）
    * @generated
    */
   private String ultKanj;

   /**
    * ULT医師名（ｶﾅ）
    * @generated
    */
   private String ultKana;

   /**
    * 削除フラグ
    * @generated
    */
   private String delFlg;

   //検索部　ここから
   /**
    * 医師勤務先メニュースイッチ
    * @generated
    */
   private String ishiKinmu;

   /**
    * 医師メニュースイッチ
    * @generated
    */
   private String ishiMenu;

   /**
    * アクション申請A
    * @generated
    */
   private String reqA;

   /**
    * アクション申請B
    * @generated
    */
   private String reqB;

   /**
    * 施設略式漢字名
    * @generated
    */
   private String insAbbrName;

   /**
    * 対象区分
    * @generated
    */
   private String hoInsType;

   /**
    * 施設住所
    * @generated
    */
   private String insAddr;

   /**
    * 所属部科
    * @generated
    */
   private String deptKj;

   /**
    * 役職
    * @generated
    */
   private String TitleKj;

   /**
    * 勤務形態
    * @generated
    */
   private String jobForm;

   /**
    * 大学職位
    * @generated
    */
   private String univTitle;

   /**
    * 施設固定コード
    * @generated
    */
   private String insNo;

   /**
    * 施設固定コード (隠し項目)
    * @generated
    */
   private String insNoKakusi;

   /**
    * 実勤務先判定(ダミー施設コード)
    * @generated
    */
   private String dummyHco;

    /**
     * コンストラクタ
     * @generated
     */
    public MRdmHcpWorkEntity() {
    	super("m_rdm_hcp_work" , "selectHcpWorkDate");
    }

    /**
     * コンストラクタ エラーチェック
     * @generated
     */
    public MRdmHcpWorkEntity(String errorCheckFlg) {
    	super("m_rdm_hcp_work" , "selectHcpWorkErrorCheck");
    	this.errorCheckFlg = errorCheckFlg;
    }



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * MRdmHcpWorkEntity.javaparamDocNoを設定
	 * @return paramDocNo
	 */
	public String getParamDocNo() {
		return paramDocNo;
	}

	/**
	 * @param paramDocNo セットする paramDocNo
	 */
	public void setParamDocNo(String paramDocNo) {
		this.paramDocNo = paramDocNo;
	}

	/**
	 * MRdmHcpWorkEntity.javasearchTypeを設定
	 * @return searchType
	 */
	public String getSearchType() {
		return searchType;
	}

	/**
	 * @param searchType セットする searchType
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	/**
	 * MRdmHcpWorkEntity.javadocKanjを設定
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
	 * MRdmHcpWorkEntity.javadocKanaを設定
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
	 * MRdmHcpWorkEntity.javadocNoを設定
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
	 * MRdmHcpWorkEntity.javadocTypeを設定
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
	 * MRdmHcpWorkEntity.javaultKanjを設定
	 * @return ultKanj
	 */
	public String getUltKanj() {
		return ultKanj;
	}

	/**
	 * @param ultKanj セットする ultKanj
	 */
	public void setUltKanj(String ultKanj) {
		this.ultKanj = ultKanj;
	}

	/**
	 * MRdmHcpWorkEntity.javaultKanaを設定
	 * @return ultKana
	 */
	public String getUltKana() {
		return ultKana;
	}

	/**
	 * @param ultKana セットする ultKana
	 */
	public void setUltKana(String ultKana) {
		this.ultKana = ultKana;
	}

	/**
	 * MRdmHcpWorkEntity.javadelFlgを設定
	 * @return delFlg
	 */
	public String getDelFlg() {
		return delFlg;
	}

	/**
	 * @param delFlg セットする delFlg
	 */
	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	/**
	 * MRdmHcpWorkEntity.javaishiKinmuを設定
	 * @return ishiKinmu
	 */
	public String getIshiKinmu() {
		return ishiKinmu;
	}

	/**
	 * @param ishiKinmu セットする ishiKinmu
	 */
	public void setIshiKinmu(String ishiKinmu) {
		this.ishiKinmu = ishiKinmu;
	}

	/**
	 * MRdmHcpWorkEntity.javareqAを設定
	 * @return reqA
	 */
	public String getReqA() {
		return reqA;
	}

	/**
	 * @param reqA セットする reqA
	 */
	public void setReqA(String reqA) {
		this.reqA = reqA;
	}

	/**
	 * MRdmHcpWorkEntity.javareqBを設定
	 * @return reqB
	 */
	public String getReqB() {
		return reqB;
	}

	/**
	 * @param reqB セットする reqB
	 */
	public void setReqB(String reqB) {
		this.reqB = reqB;
	}

	/**
	 * MRdmHcpWorkEntity.javainsAbbrNameを設定
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
	 * MRdmHcpWorkEntity.javahoInsTypeを設定
	 * @return hoInsType
	 */
	public String getHoInsType() {
		return hoInsType;
	}

	/**
	 * @param hoInsType セットする hoInsType
	 */
	public void setHoInsType(String hoInsType) {
		this.hoInsType = hoInsType;
	}

	/**
	 * MRdmHcpWorkEntity.javainsAddrを設定
	 * @return insAddr
	 */
	public String getInsAddr() {
		return insAddr;
	}

	/**
	 * @param insAddr セットする insAddr
	 */
	public void setInsAddr(String insAddr) {
		this.insAddr = insAddr;
	}

	/**
	 * MRdmHcpWorkEntity.javadeptKjを設定
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
	 * MRdmHcpWorkEntity.javaTitleKjを設定
	 * @return titleKj
	 */
	public String getTitleKj() {
		return TitleKj;
	}

	/**
	 * @param titleKj セットする titleKj
	 */
	public void setTitleKj(String titleKj) {
		TitleKj = titleKj;
	}

	/**
	 * MRdmHcpWorkEntity.javajobFormを設定
	 * @return jobForm
	 */
	public String getJobForm() {
		return jobForm;
	}

	/**
	 * @param jobForm セットする jobForm
	 */
	public void setJobForm(String jobForm) {
		this.jobForm = jobForm;
	}

	/**
	 * MRdmHcpWorkEntity.javaunivTitleを設定
	 * @return univTitle
	 */
	public String getUnivTitle() {
		return univTitle;
	}

	/**
	 * @param univTitle セットする univTitle
	 */
	public void setUnivTitle(String univTitle) {
		this.univTitle = univTitle;
	}



	/**
	 * MRdmHcpWorkEntity.javadummyHcoを設定
	 * @return dummyHco
	 */
	public String getDummyHco() {
		return dummyHco;
	}

	/**
	 * @param dummyHco セットする dummyHco
	 */
	public void setDummyHco(String dummyHco) {
		this.dummyHco = dummyHco;
	}

	/**
	 * MRdmHcpWorkEntity.javaishiMenuを設定
	 * @return ishiMenu
	 */
	public String getIshiMenu() {
		return ishiMenu;
	}

	/**
	 * @param ishiMenu セットする ishiMenu
	 */
	public void setIshiMenu(String ishiMenu) {
		this.ishiMenu = ishiMenu;
	}

	/**
	 * MRdmHcpWorkEntity.javaerrorCheckFlgを設定
	 * @return errorCheckFlg
	 */
	public String getErrorCheckFlg() {
		return errorCheckFlg;
	}

	/**
	 * @param errorCheckFlg セットする errorCheckFlg
	 */
	public void setErrorCheckFlg(String errorCheckFlg) {
		this.errorCheckFlg = errorCheckFlg;
	}

	/**
	 * MRdmHcpWorkEntity.javainsNoKkusiを設定
	 * @return insNoKkusi
	 */
	public String getInsNoKakusi() {
		return insNoKakusi;
	}

	/**
	 * @param insNoKkusi セットする insNoKkusi
	 */
	public void setInsNoKakusi(String insNoKakusi) {
		this.insNoKakusi = insNoKakusi;
	}

	/**
	 * MRdmHcpWorkEntity.javainsNoを設定
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



}
