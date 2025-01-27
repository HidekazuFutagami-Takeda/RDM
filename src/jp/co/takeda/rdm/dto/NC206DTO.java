/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.dto;

import java.io.Serializable;

import jp.co.takeda.rdm.common.BaseDTO;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * DTOクラス
 * @generated
 */
public class NC206DTO extends BaseDTO implements Serializable {

	/**
	 * シリアルバージョンUID
	 * @generated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * このDTOが関連付けられている画面ID
	 * @generated
	 */
	private String NC206 = "NC206";

	/**
	 * メッセージID
	 * @generated
	 */
	private String msgId;

	/**
	 * メッセージ中身
	 * @generated
	 */
	private String msgStr;

	/**
	 * ユーザ権限
	 * @generated
	 */
	private String loginJokenSetCd;

	/**
	 * ユーザ従業員番号
	 * @generated
	 */
	private Integer loginJgiNo;

	/**
	 * ユーザ氏名
	 * @generated
	 */
	private String loginNm;

	/**
	 * ユーザ医薬支店C
	 * @generated
	 */
	private String loginBrCd;

	/**
	 * ユーザ医薬営業所C
	 * @generated
	 */
	private String loginDistCd;

	/**
	 * ユーザ所属組織名
	 * @generated
	 */
	private String loginShzNm;

	/**
	 * ユーザ領域コード
	 * @generated
	 */
	private String loginTrtCd;

	/**
	 * 画面ＩＤ（共通部分判定用）
	 * @generated
	 */
	private String gamenId;

	/**
	 * 画面タイトル
	 * @generated
	 */
	private String title;

	/**
	 * 申請ID
	 * @generated
	 */
	private String reqId;

	/**
	 * 更新日時
	 * @generated
	 */
	private String updShaYmd;


	/**
	 * 所属学会名称
	 * @generated
	 */
	private String medicalSocietyNmPop;

	/**
	 * 入会年月日(年)
	 * @generated
	 */
	private String admissionYYYYPop;

	/**
	 * 入会年月日(月)
	 * @generated
	 */
	private String admissionMMPop;

	/**
	 * 入会年月日(日)
	 * @generated
	 */
	private String admissionDDPop;

	/**
	 * 脱会年月日(年)
	 * @generated
	 */
	private String quitYYYYPop;

	/**
	 * 脱会年月日(月)
	 * @generated
	 */
	private String quitMMPop;

	/**
	 * 脱会年月日(日)
	 * @generated
	 */
	private String quitDDPop;

	/**
	 * 所属役職コード
	 * @generated
	 */
	private String positionCodePop;

	/**
	 * 所属役職名称
	 * @generated
	 */
	private String positionNamePop;

	/**
	 * 役職開始年月日(年)
	 * @generated
	 */
	private String societyPosiStYYYYPop;

	/**
	 * 役職開始年月日(月)
	 * @generated
	 */
	private String societyPosiStMMPop;

	/**
	 * 役職開始年月日(日)
	 * @generated
	 */
	private String societyPosiStDDPop;

	/**
	 * 役職終了年月日(年)
	 * @generated
	 */
	private String societyPosiEdYYYYPop;

	/**
	 * 役職終了年月日(月)
	 * @generated
	 */
	private String societyPosiEdMMPop;

	/**
	 * 役職終了年月日(日)
	 * @generated
	 */
	private String societyPosiEdDDPop;

	/**
	 * 所属学会指導医区分コード
	 * @generated
	 */
	private String advisingDoctorCdPop;

	/**
	 * 所属学会指導医区分名称
	 * @generated
	 */
	private String advisingDoctorNmPop;

	/**
	 * 指導医取得年月日(年)
	 * @generated
	 */
	private String coachingAcquisiYYYYPop;

	/**
	 * 指導医取得年月日(月)
	 * @generated
	 */
	private String coachingAcquisiMMPop;

	/**
	 * 指導医取得年月日(日)
	 * @generated
	 */
	private String coachingAcquisiDDPop;

	/**
	 * 指導医開始年月日(年)
	 * @generated
	 */
	private String coachingStYYYYPop;

	/**
	 * 指導医開始年月日(月)
	 * @generated
	 */
	private String coachingStMMPop;

	/**
	 * 指導医開始年月日(日)
	 * @generated
	 */
	private String coachingStDDPop;

	/**
	 * 指導医終了年月日(年)
	 * @generated
	 */
	private String coachingEdYYYYPop;

	/**
	 * 指導医終了年月日(月)
	 * @generated
	 */
	private String coachingEdMMPop;

	/**
	 * 指導医終了年月日(日)
	 * @generated
	 */
	private String coachingEdDDPop;

	/**
	 * 所属学会認定医区分コード
	 * @generated
	 */
	private String certifyingPhysicianCdPop;

	/**
	 * 所属学会認定医区分名称
	 * @generated
	 */
	private String certifyingPhysicianNmPop;

	/**
	 * 認定医開始年月日(年)
	 * @generated
	 */
	private String certifyStYYYYPop;

	/**
	 * 認定医開始年月日(月)
	 * @generated
	 */
	private String certifyStMMPop;

	/**
	 * 認定医開始年月日(日)
	 * @generated
	 */
	private String certifyStDDPop;

	/**
	 * 認定医終了年月日(年)
	 * @generated
	 */
	private String certifyEdYYYYPop;

	/**
	 * 認定医終了年月日(月)
	 * @generated
	 */
	private String certifyEdMMPop;

	/**
	 * 認定医終了年月日(日)
	 * @generated
	 */
	private String certifyEdDDPop;

	/**
	 * コンボボックス_入会年月日(年)
	 * @generated
	 */
	private LinkedHashMap<String,String> admissionYYYYCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_入会年月日(月)
	 * @generated
	 */
	private LinkedHashMap<String,String> admissionMMCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_入会年月日(日)
	 * @generated
	 */
	private LinkedHashMap<String,String> admissionDDCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_脱会年月日(年)
	 * @generated
	 */
	private LinkedHashMap<String,String> quitYYYYCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_脱会年月日(月)
	 * @generated
	 */
	private LinkedHashMap<String,String> quitMMCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_脱会年月日(日)
	 * @generated
	 */
	private LinkedHashMap<String,String> quitDDCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_所属役職コード
	 * @generated
	 */
	private LinkedHashMap<String,String> positionCodeCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_役職開始年月日(年)
	 * @generated
	 */
	private LinkedHashMap<String,String> societyPosiStYYYYCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_役職開始年月日(月)
	 * @generated
	 */
	private LinkedHashMap<String,String> societyPosiStMMCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_役職開始年月日(日)
	 * @generated
	 */
	private LinkedHashMap<String,String> societyPosiStDDCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_役職終了年月日(年)
	 * @generated
	 */
	private LinkedHashMap<String,String> societyPosiEdYYYYCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_役職終了年月日(月)
	 * @generated
	 */
	private LinkedHashMap<String,String> societyPosiEdMMCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_役職終了年月日(日)
	 * @generated
	 */
	private LinkedHashMap<String,String> societyPosiEdDDCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_所属学会指導医区分コード
	 * @generated
	 */
	private LinkedHashMap<String,String> advisingDoctorCdCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_指導医取得年月日(年)
	 * @generated
	 */
	private LinkedHashMap<String,String> coachingAcquisiYYYYCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_指導医取得年月日(月)
	 * @generated
	 */
	private LinkedHashMap<String,String> coachingAcquisiMMCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_指導医取得年月日(日)
	 * @generated
	 */
	private LinkedHashMap<String,String> coachingAcquisiDDCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_指導医開始年月日(年)
	 * @generated
	 */
	private LinkedHashMap<String,String> coachingStYYYYCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_指導医開始年月日(月)
	 * @generated
	 */
	private LinkedHashMap<String,String> coachingStMMCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_指導医開始年月日(日)
	 * @generated
	 */
	private LinkedHashMap<String,String> coachingStDDCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_指導医終了年月日(年)
	 * @generated
	 */
	private LinkedHashMap<String,String> coachingEdYYYYCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_指導医終了年月日(月)
	 * @generated
	 */
	private LinkedHashMap<String,String> coachingEdMMCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_指導医終了年月日(日)
	 * @generated
	 */
	private LinkedHashMap<String,String> coachingEdDDCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_所属学会認定医区分コード
	 * @generated
	 */
	private LinkedHashMap<String,String> certifyingPhysicianCdCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_認定医開始年月日(年)
	 * @generated
	 */
	private LinkedHashMap<String,String> certifyStYYYYCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_認定医開始年月日(月)
	 * @generated
	 */
	private LinkedHashMap<String,String> certifyStMMCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_認定医開始年月日(日)
	 * @generated
	 */
	private LinkedHashMap<String,String> certifyStDDCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_認定医終了年月日(年)
	 * @generated
	 */
	private LinkedHashMap<String,String> certifyEdYYYYCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_認定医終了年月日(月)
	 * @generated
	 */
	private LinkedHashMap<String,String> certifyEdMMCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_認定医終了年月日(日)
	 * @generated
	 */
	private LinkedHashMap<String,String> certifyEdDDCombo = new LinkedHashMap<String,String>();


	/**
	 * 所属学会リスト
	 * @generated
	 */
	private List<HcpSocietyData> hcpSocietyDataList = new ArrayList<HcpSocietyData>();

	/**
	 * 所属学会リストインデックス
	 * @generated
	 */
	private Integer slistIndex;

	/**
	 * 所属学会リスト更新フラグ
	 * @generated
	 */
	private String hcpSocietyDataChgFlg;


	/**
	 * デフォルトのコンストラクタ。
	 * @generated
	 */
	public NC206DTO() {
		setForward(NC206);
	}

	// START UOC

	// END UOC

	/**
	 * この画面の画面IDをセットする
	 * @param screenID 画面ID
	 * @generated
	 */
	public void setNC206(String screenID){
		this.NC206 = screenID;
	}

	/**
	 * この画面の画面IDを返す
	 * @return 画面ID名
	 * @generated
	 */
	public String getNC206(){
		return NC206;
	}



	/**
	 * NC206DTO.javamsgIdを設定
	 * @return msgId
	 */
	public String getMsgId() {
		return msgId;
	}

	/**
	 * @param msgId セットする msgId
	 */
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	/**
	 * NC206DTO.javamsgStrを設定
	 * @return msgStr
	 */
	public String getMsgStr() {
		return msgStr;
	}

	/**
	 * @param msgStr セットする msgStr
	 */
	public void setMsgStr(String msgStr) {
		this.msgStr = msgStr;
	}

	/**
	 * NC206DTO.javaloginJokenSetCdを設定
	 * @return loginJokenSetCd
	 */
	public String getLoginJokenSetCd() {
		return loginJokenSetCd;
	}

	/**
	 * @param loginJokenSetCd セットする loginJokenSetCd
	 */
	public void setLoginJokenSetCd(String loginJokenSetCd) {
		this.loginJokenSetCd = loginJokenSetCd;
	}

	/**
	 * NC206DTO.javaloginJgiNoを設定
	 * @return loginJgiNo
	 */
	public Integer getLoginJgiNo() {
		return loginJgiNo;
	}

	/**
	 * @param loginJgiNo セットする loginJgiNo
	 */
	public void setLoginJgiNo(Integer loginJgiNo) {
		this.loginJgiNo = loginJgiNo;
	}

	/**
	 * NC206DTO.javaloginNmを設定
	 * @return loginNm
	 */
	public String getLoginNm() {
		return loginNm;
	}

	/**
	 * @param loginNm セットする loginNm
	 */
	public void setLoginNm(String loginNm) {
		this.loginNm = loginNm;
	}

	/**
	 * NC206DTO.javaloginBrCdを設定
	 * @return loginBrCd
	 */
	public String getLoginBrCd() {
		return loginBrCd;
	}

	/**
	 * @param loginBrCd セットする loginBrCd
	 */
	public void setLoginBrCd(String loginBrCd) {
		this.loginBrCd = loginBrCd;
	}

	/**
	 * NC206DTO.javaloginDistCdを設定
	 * @return loginDistCd
	 */
	public String getLoginDistCd() {
		return loginDistCd;
	}

	/**
	 * @param loginDistCd セットする loginDistCd
	 */
	public void setLoginDistCd(String loginDistCd) {
		this.loginDistCd = loginDistCd;
	}

	/**
	 * NC206DTO.javaloginShzNmを設定
	 * @return loginShzNm
	 */
	public String getLoginShzNm() {
		return loginShzNm;
	}

	/**
	 * @param loginShzNm セットする loginShzNm
	 */
	public void setLoginShzNm(String loginShzNm) {
		this.loginShzNm = loginShzNm;
	}

	/**
	 * NC206DTO.javaloginTrtCdを設定
	 * @return loginTrtCd
	 */
	public String getLoginTrtCd() {
		return loginTrtCd;
	}

	/**
	 * @param loginTrtCd セットする loginTrtCd
	 */
	public void setLoginTrtCd(String loginTrtCd) {
		this.loginTrtCd = loginTrtCd;
	}

	/**
	 * NC206DTO.javagamenIdを設定
	 * @return gamenId
	 */
	public String getGamenId() {
		return gamenId;
	}

	/**
	 * @param gamenId セットする gamenId
	 */
	public void setGamenId(String gamenId) {
		this.gamenId = gamenId;
	}

	/**
	 * NC206DTO.javatitleを設定
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title セットする title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * NC206DTO.javareqIdを設定
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
	 * NC206DTO.javaupdShaYmdを設定
	 * @return updShaYmd
	 */
	public String getUpdShaYmd() {
		return updShaYmd;
	}

	/**
	 * @param updShaYmd セットする updShaYmd
	 */
	public void setUpdShaYmd(String updShaYmd) {
		this.updShaYmd = updShaYmd;
	}

	/**
	 * NC206DTO.javamedicalSocietyNmを設定
	 * @return medicalSocietyNm
	 */
	public String getMedicalSocietyNmPop() {
		return medicalSocietyNmPop;
	}

	/**
	 * @param medicalSocietyNm セットする medicalSocietyNm
	 */
	public void setMedicalSocietyNmPop(String medicalSocietyNmPop) {
		this.medicalSocietyNmPop = medicalSocietyNmPop;
	}

	/**
	 * NC206DTO.javaadmissionYYYYを設定
	 * @return admissionYYYY
	 */
	public String getAdmissionYYYYPop() {
		return admissionYYYYPop;
	}

	/**
	 * @param admissionYYYY セットする admissionYYYY
	 */
	public void setAdmissionYYYYPop(String admissionYYYYPop) {
		this.admissionYYYYPop = admissionYYYYPop;
	}

	/**
	 * NC206DTO.javaadmissionMMを設定
	 * @return admissionMM
	 */
	public String getAdmissionMMPop() {
		return admissionMMPop;
	}

	/**
	 * @param admissionMM セットする admissionMM
	 */
	public void setAdmissionMMPop(String admissionMMPop) {
		this.admissionMMPop = admissionMMPop;
	}

	/**
	 * NC206DTO.javaadmissionDDを設定
	 * @return admissionDD
	 */
	public String getAdmissionDDPop() {
		return admissionDDPop;
	}

	/**
	 * @param admissionDD セットする admissionDD
	 */
	public void setAdmissionDDPop(String admissionDDPop) {
		this.admissionDDPop = admissionDDPop;
	}

	/**
	 * NC206DTO.javaquitYYYYを設定
	 * @return quitYYYY
	 */
	public String getQuitYYYYPop() {
		return quitYYYYPop;
	}

	/**
	 * @param quitYYYY セットする quitYYYY
	 */
	public void setQuitYYYYPop(String quitYYYYPop) {
		this.quitYYYYPop = quitYYYYPop;
	}

	/**
	 * NC206DTO.javaquitMMを設定
	 * @return quitMM
	 */
	public String getQuitMMPop() {
		return quitMMPop;
	}

	/**
	 * @param quitMM セットする quitMM
	 */
	public void setQuitMMPop(String quitMMPop) {
		this.quitMMPop = quitMMPop;
	}

	/**
	 * NC206DTO.javaquitDDを設定
	 * @return quitDD
	 */
	public String getQuitDDPop() {
		return quitDDPop;
	}

	/**
	 * @param quitDD セットする quitDD
	 */
	public void setQuitDDPop(String quitDDPop) {
		this.quitDDPop = quitDDPop;
	}

	/**
	 * NC206DTO.javapositionCodeを設定
	 * @return positionCode
	 */
	public String getPositionCodePop() {
		return positionCodePop;
	}

	/**
	 * @param positionCode セットする positionCode
	 */
	public void setPositionCode(String positionCodePop) {
		this.positionCodePop = positionCodePop;
	}

	/**
	 * NC206DTO.javapositionNameを設定
	 * @return positionName
	 */
	public String getPositionNamePop() {
		return positionNamePop;
	}

	/**
	 * @param positionName セットする positionName
	 */
	public void setPositionNamePop(String positionNamePop) {
		this.positionNamePop = positionNamePop;
	}



	/**
	 * NC206DTO.javasocietyPosiStYYYYPopを設定
	 * @return societyPosiStYYYYPop
	 */
	public String getSocietyPosiStYYYYPop() {
		return societyPosiStYYYYPop;
	}

	/**
	 * @param societyPosiStYYYYPop セットする societyPosiStYYYYPop
	 */
	public void setSocietyPosiStYYYYPop(String societyPosiStYYYYPop) {
		this.societyPosiStYYYYPop = societyPosiStYYYYPop;
	}

	/**
	 * NC206DTO.javasocietyPosiStMMPopを設定
	 * @return societyPosiStMMPop
	 */
	public String getSocietyPosiStMMPop() {
		return societyPosiStMMPop;
	}

	/**
	 * @param societyPosiStMMPop セットする societyPosiStMMPop
	 */
	public void setSocietyPosiStMMPop(String societyPosiStMMPop) {
		this.societyPosiStMMPop = societyPosiStMMPop;
	}

	/**
	 * NC206DTO.javasocietyPosiStDDPopを設定
	 * @return societyPosiStDDPop
	 */
	public String getSocietyPosiStDDPop() {
		return societyPosiStDDPop;
	}

	/**
	 * @param societyPosiStDDPop セットする societyPosiStDDPop
	 */
	public void setSocietyPosiStDDPop(String societyPosiStDDPop) {
		this.societyPosiStDDPop = societyPosiStDDPop;
	}

	/**
	 * NC206DTO.javasocietyPosiEdYYYYPopを設定
	 * @return societyPosiEdYYYYPop
	 */
	public String getSocietyPosiEdYYYYPop() {
		return societyPosiEdYYYYPop;
	}

	/**
	 * @param societyPosiEdYYYYPop セットする societyPosiEdYYYYPop
	 */
	public void setSocietyPosiEdYYYYPop(String societyPosiEdYYYYPop) {
		this.societyPosiEdYYYYPop = societyPosiEdYYYYPop;
	}

	/**
	 * NC206DTO.javasocietyPosiEdMMPopを設定
	 * @return societyPosiEdMMPop
	 */
	public String getSocietyPosiEdMMPop() {
		return societyPosiEdMMPop;
	}

	/**
	 * @param societyPosiEdMMPop セットする societyPosiEdMMPop
	 */
	public void setSocietyPosiEdMMPop(String societyPosiEdMMPop) {
		this.societyPosiEdMMPop = societyPosiEdMMPop;
	}

	/**
	 * NC206DTO.javasocietyPosiEdDDPopを設定
	 * @return societyPosiEdDDPop
	 */
	public String getSocietyPosiEdDDPop() {
		return societyPosiEdDDPop;
	}

	/**
	 * @param societyPosiEdDDPop セットする societyPosiEdDDPop
	 */
	public void setSocietyPosiEdDDPop(String societyPosiEdDDPop) {
		this.societyPosiEdDDPop = societyPosiEdDDPop;
	}

	/**
	 * NC206DTO.javaadvisingDoctorCdPopを設定
	 * @return advisingDoctorCdPop
	 */
	public String getAdvisingDoctorCdPop() {
		return advisingDoctorCdPop;
	}

	/**
	 * @param advisingDoctorCdPop セットする advisingDoctorCdPop
	 */
	public void setAdvisingDoctorCdPop(String advisingDoctorCdPop) {
		this.advisingDoctorCdPop = advisingDoctorCdPop;
	}

	/**
	 * NC206DTO.javaadvisingDoctorNmPopを設定
	 * @return advisingDoctorNmPop
	 */
	public String getAdvisingDoctorNmPop() {
		return advisingDoctorNmPop;
	}

	/**
	 * @param advisingDoctorNmPop セットする advisingDoctorNmPop
	 */
	public void setAdvisingDoctorNmPop(String advisingDoctorNmPop) {
		this.advisingDoctorNmPop = advisingDoctorNmPop;
	}

	/**
	 * NC206DTO.javacoachingAcquisiYYYYPopを設定
	 * @return coachingAcquisiYYYYPop
	 */
	public String getCoachingAcquisiYYYYPop() {
		return coachingAcquisiYYYYPop;
	}

	/**
	 * @param coachingAcquisiYYYYPop セットする coachingAcquisiYYYYPop
	 */
	public void setCoachingAcquisiYYYYPop(String coachingAcquisiYYYYPop) {
		this.coachingAcquisiYYYYPop = coachingAcquisiYYYYPop;
	}

	/**
	 * NC206DTO.javacoachingAcquisiMMPopを設定
	 * @return coachingAcquisiMMPop
	 */
	public String getCoachingAcquisiMMPop() {
		return coachingAcquisiMMPop;
	}

	/**
	 * @param coachingAcquisiMMPop セットする coachingAcquisiMMPop
	 */
	public void setCoachingAcquisiMMPop(String coachingAcquisiMMPop) {
		this.coachingAcquisiMMPop = coachingAcquisiMMPop;
	}

	/**
	 * NC206DTO.javacoachingAcquisiDDPopを設定
	 * @return coachingAcquisiDDPop
	 */
	public String getCoachingAcquisiDDPop() {
		return coachingAcquisiDDPop;
	}

	/**
	 * @param coachingAcquisiDDPop セットする coachingAcquisiDDPop
	 */
	public void setCoachingAcquisiDDPop(String coachingAcquisiDDPop) {
		this.coachingAcquisiDDPop = coachingAcquisiDDPop;
	}

	/**
	 * NC206DTO.javacoachingStYYYYPopを設定
	 * @return coachingStYYYYPop
	 */
	public String getCoachingStYYYYPop() {
		return coachingStYYYYPop;
	}

	/**
	 * @param coachingStYYYYPop セットする coachingStYYYYPop
	 */
	public void setCoachingStYYYYPop(String coachingStYYYYPop) {
		this.coachingStYYYYPop = coachingStYYYYPop;
	}

	/**
	 * NC206DTO.javacoachingStMMPopを設定
	 * @return coachingStMMPop
	 */
	public String getCoachingStMMPop() {
		return coachingStMMPop;
	}

	/**
	 * @param coachingStMMPop セットする coachingStMMPop
	 */
	public void setCoachingStMMPop(String coachingStMMPop) {
		this.coachingStMMPop = coachingStMMPop;
	}

	/**
	 * NC206DTO.javacoachingStDDPopを設定
	 * @return coachingStDDPop
	 */
	public String getCoachingStDDPop() {
		return coachingStDDPop;
	}

	/**
	 * @param coachingStDDPop セットする coachingStDDPop
	 */
	public void setCoachingStDDPop(String coachingStDDPop) {
		this.coachingStDDPop = coachingStDDPop;
	}

	/**
	 * NC206DTO.javacoachingEdYYYYPopを設定
	 * @return coachingEdYYYYPop
	 */
	public String getCoachingEdYYYYPop() {
		return coachingEdYYYYPop;
	}

	/**
	 * @param coachingEdYYYYPop セットする coachingEdYYYYPop
	 */
	public void setCoachingEdYYYYPop(String coachingEdYYYYPop) {
		this.coachingEdYYYYPop = coachingEdYYYYPop;
	}

	/**
	 * NC206DTO.javacoachingEdMMPopを設定
	 * @return coachingEdMMPop
	 */
	public String getCoachingEdMMPop() {
		return coachingEdMMPop;
	}

	/**
	 * @param coachingEdMMPop セットする coachingEdMMPop
	 */
	public void setCoachingEdMMPop(String coachingEdMMPop) {
		this.coachingEdMMPop = coachingEdMMPop;
	}

	/**
	 * NC206DTO.javacoachingEdDDPopを設定
	 * @return coachingEdDDPop
	 */
	public String getCoachingEdDDPop() {
		return coachingEdDDPop;
	}

	/**
	 * @param coachingEdDDPop セットする coachingEdDDPop
	 */
	public void setCoachingEdDDPop(String coachingEdDDPop) {
		this.coachingEdDDPop = coachingEdDDPop;
	}

	/**
	 * NC206DTO.javacertifyingPhysicianCdPopを設定
	 * @return certifyingPhysicianCdPop
	 */
	public String getCertifyingPhysicianCdPop() {
		return certifyingPhysicianCdPop;
	}

	/**
	 * @param certifyingPhysicianCdPop セットする certifyingPhysicianCdPop
	 */
	public void setCertifyingPhysicianCdPop(String certifyingPhysicianCdPop) {
		this.certifyingPhysicianCdPop = certifyingPhysicianCdPop;
	}

	/**
	 * NC206DTO.javacertifyingPhysicianNmPopを設定
	 * @return certifyingPhysicianNmPop
	 */
	public String getCertifyingPhysicianNmPop() {
		return certifyingPhysicianNmPop;
	}

	/**
	 * @param certifyingPhysicianNmPop セットする certifyingPhysicianNmPop
	 */
	public void setCertifyingPhysicianNmPop(String certifyingPhysicianNmPop) {
		this.certifyingPhysicianNmPop = certifyingPhysicianNmPop;
	}

	/**
	 * NC206DTO.javacertifyStYYYYPopを設定
	 * @return certifyStYYYYPop
	 */
	public String getCertifyStYYYYPop() {
		return certifyStYYYYPop;
	}

	/**
	 * @param certifyStYYYYPop セットする certifyStYYYYPop
	 */
	public void setCertifyStYYYYPop(String certifyStYYYYPop) {
		this.certifyStYYYYPop = certifyStYYYYPop;
	}

	/**
	 * NC206DTO.javacertifyStMMPopを設定
	 * @return certifyStMMPop
	 */
	public String getCertifyStMMPop() {
		return certifyStMMPop;
	}

	/**
	 * @param certifyStMMPop セットする certifyStMMPop
	 */
	public void setCertifyStMMPop(String certifyStMMPop) {
		this.certifyStMMPop = certifyStMMPop;
	}

	/**
	 * NC206DTO.javacertifyStDDPopを設定
	 * @return certifyStDDPop
	 */
	public String getCertifyStDDPop() {
		return certifyStDDPop;
	}

	/**
	 * @param certifyStDDPop セットする certifyStDDPop
	 */
	public void setCertifyStDDPop(String certifyStDDPop) {
		this.certifyStDDPop = certifyStDDPop;
	}

	/**
	 * NC206DTO.javacertifyEdYYYYPopを設定
	 * @return certifyEdYYYYPop
	 */
	public String getCertifyEdYYYYPop() {
		return certifyEdYYYYPop;
	}

	/**
	 * @param certifyEdYYYYPop セットする certifyEdYYYYPop
	 */
	public void setCertifyEdYYYYPop(String certifyEdYYYYPop) {
		this.certifyEdYYYYPop = certifyEdYYYYPop;
	}

	/**
	 * NC206DTO.javacertifyEdMMPopを設定
	 * @return certifyEdMMPop
	 */
	public String getCertifyEdMMPop() {
		return certifyEdMMPop;
	}

	/**
	 * @param certifyEdMMPop セットする certifyEdMMPop
	 */
	public void setCertifyEdMMPop(String certifyEdMMPop) {
		this.certifyEdMMPop = certifyEdMMPop;
	}

	/**
	 * NC206DTO.javacertifyEdDDPopを設定
	 * @return certifyEdDDPop
	 */
	public String getCertifyEdDDPop() {
		return certifyEdDDPop;
	}

	/**
	 * @param certifyEdDDPop セットする certifyEdDDPop
	 */
	public void setCertifyEdDDPop(String certifyEdDDPop) {
		this.certifyEdDDPop = certifyEdDDPop;
	}

	/**
	 * @param positionCodePop セットする positionCodePop
	 */
	public void setPositionCodePop(String positionCodePop) {
		this.positionCodePop = positionCodePop;
	}

	/**
	 * NC206DTO.javaadmissionYYYYComboを設定
	 * @return admissionYYYYCombo
	 */
	public LinkedHashMap<String, String> getAdmissionYYYYCombo() {
		return admissionYYYYCombo;
	}

	/**
	 * @param admissionYYYYCombo セットする admissionYYYYCombo
	 */
	public void setAdmissionYYYYCombo(LinkedHashMap<String, String> admissionYYYYCombo) {
		this.admissionYYYYCombo = admissionYYYYCombo;
	}

	/**
	 * NC206DTO.javaadmissionMMComboを設定
	 * @return admissionMMCombo
	 */
	public LinkedHashMap<String, String> getAdmissionMMCombo() {
		return admissionMMCombo;
	}

	/**
	 * @param admissionMMCombo セットする admissionMMCombo
	 */
	public void setAdmissionMMCombo(LinkedHashMap<String, String> admissionMMCombo) {
		this.admissionMMCombo = admissionMMCombo;
	}

	/**
	 * NC206DTO.javaadmissionDDComboを設定
	 * @return admissionDDCombo
	 */
	public LinkedHashMap<String, String> getAdmissionDDCombo() {
		return admissionDDCombo;
	}

	/**
	 * @param admissionDDCombo セットする admissionDDCombo
	 */
	public void setAdmissionDDCombo(LinkedHashMap<String, String> admissionDDCombo) {
		this.admissionDDCombo = admissionDDCombo;
	}

	/**
	 * NC206DTO.javaquitYYYYComboを設定
	 * @return quitYYYYCombo
	 */
	public LinkedHashMap<String, String> getQuitYYYYCombo() {
		return quitYYYYCombo;
	}

	/**
	 * @param quitYYYYCombo セットする quitYYYYCombo
	 */
	public void setQuitYYYYCombo(LinkedHashMap<String, String> quitYYYYCombo) {
		this.quitYYYYCombo = quitYYYYCombo;
	}

	/**
	 * NC206DTO.javaquitMMComboを設定
	 * @return quitMMCombo
	 */
	public LinkedHashMap<String, String> getQuitMMCombo() {
		return quitMMCombo;
	}

	/**
	 * @param quitMMCombo セットする quitMMCombo
	 */
	public void setQuitMMCombo(LinkedHashMap<String, String> quitMMCombo) {
		this.quitMMCombo = quitMMCombo;
	}

	/**
	 * NC206DTO.javaquitDDComboを設定
	 * @return quitDDCombo
	 */
	public LinkedHashMap<String, String> getQuitDDCombo() {
		return quitDDCombo;
	}

	/**
	 * @param quitDDCombo セットする quitDDCombo
	 */
	public void setQuitDDCombo(LinkedHashMap<String, String> quitDDCombo) {
		this.quitDDCombo = quitDDCombo;
	}

	/**
	 * NC206DTO.javapositionCodeComboを設定
	 * @return positionCodeCombo
	 */
	public LinkedHashMap<String, String> getPositionCodeCombo() {
		return positionCodeCombo;
	}

	/**
	 * @param positionCodeCombo セットする positionCodeCombo
	 */
	public void setPositionCodeCombo(LinkedHashMap<String, String> positionCodeCombo) {
		this.positionCodeCombo = positionCodeCombo;
	}

	/**
	 * NC206DTO.javasocietyPosiStYYYYComboを設定
	 * @return societyPosiStYYYYCombo
	 */
	public LinkedHashMap<String, String> getSocietyPosiStYYYYCombo() {
		return societyPosiStYYYYCombo;
	}

	/**
	 * @param societyPosiStYYYYCombo セットする societyPosiStYYYYCombo
	 */
	public void setSocietyPosiStYYYYCombo(LinkedHashMap<String, String> societyPosiStYYYYCombo) {
		this.societyPosiStYYYYCombo = societyPosiStYYYYCombo;
	}

	/**
	 * NC206DTO.javasocietyPosiStMMComboを設定
	 * @return societyPosiStMMCombo
	 */
	public LinkedHashMap<String, String> getSocietyPosiStMMCombo() {
		return societyPosiStMMCombo;
	}

	/**
	 * @param societyPosiStMMCombo セットする societyPosiStMMCombo
	 */
	public void setSocietyPosiStMMCombo(LinkedHashMap<String, String> societyPosiStMMCombo) {
		this.societyPosiStMMCombo = societyPosiStMMCombo;
	}

	/**
	 * NC206DTO.javasocietyPosiStDDComboを設定
	 * @return societyPosiStDDCombo
	 */
	public LinkedHashMap<String, String> getSocietyPosiStDDCombo() {
		return societyPosiStDDCombo;
	}

	/**
	 * @param societyPosiStDDCombo セットする societyPosiStDDCombo
	 */
	public void setSocietyPosiStDDCombo(LinkedHashMap<String, String> societyPosiStDDCombo) {
		this.societyPosiStDDCombo = societyPosiStDDCombo;
	}

	/**
	 * NC206DTO.javasocietyPosiEdYYYYComboを設定
	 * @return societyPosiEdYYYYCombo
	 */
	public LinkedHashMap<String, String> getSocietyPosiEdYYYYCombo() {
		return societyPosiEdYYYYCombo;
	}

	/**
	 * @param societyPosiEdYYYYCombo セットする societyPosiEdYYYYCombo
	 */
	public void setSocietyPosiEdYYYYCombo(LinkedHashMap<String, String> societyPosiEdYYYYCombo) {
		this.societyPosiEdYYYYCombo = societyPosiEdYYYYCombo;
	}

	/**
	 * NC206DTO.javasocietyPosiEdMMComboを設定
	 * @return societyPosiEdMMCombo
	 */
	public LinkedHashMap<String, String> getSocietyPosiEdMMCombo() {
		return societyPosiEdMMCombo;
	}

	/**
	 * @param societyPosiEdMMCombo セットする societyPosiEdMMCombo
	 */
	public void setSocietyPosiEdMMCombo(LinkedHashMap<String, String> societyPosiEdMMCombo) {
		this.societyPosiEdMMCombo = societyPosiEdMMCombo;
	}

	/**
	 * NC206DTO.javasocietyPosiEdDDComboを設定
	 * @return societyPosiEdDDCombo
	 */
	public LinkedHashMap<String, String> getSocietyPosiEdDDCombo() {
		return societyPosiEdDDCombo;
	}

	/**
	 * @param societyPosiEdDDCombo セットする societyPosiEdDDCombo
	 */
	public void setSocietyPosiEdDDCombo(LinkedHashMap<String, String> societyPosiEdDDCombo) {
		this.societyPosiEdDDCombo = societyPosiEdDDCombo;
	}

	/**
	 * NC206DTO.javaadvisingDoctorCdComboを設定
	 * @return advisingDoctorCdCombo
	 */
	public LinkedHashMap<String, String> getAdvisingDoctorCdCombo() {
		return advisingDoctorCdCombo;
	}

	/**
	 * @param advisingDoctorCdCombo セットする advisingDoctorCdCombo
	 */
	public void setAdvisingDoctorCdCombo(LinkedHashMap<String, String> advisingDoctorCdCombo) {
		this.advisingDoctorCdCombo = advisingDoctorCdCombo;
	}

	/**
	 * NC206DTO.javacoachingAcquisiYYYYComboを設定
	 * @return coachingAcquisiYYYYCombo
	 */
	public LinkedHashMap<String, String> getCoachingAcquisiYYYYCombo() {
		return coachingAcquisiYYYYCombo;
	}

	/**
	 * @param coachingAcquisiYYYYCombo セットする coachingAcquisiYYYYCombo
	 */
	public void setCoachingAcquisiYYYYCombo(LinkedHashMap<String, String> coachingAcquisiYYYYCombo) {
		this.coachingAcquisiYYYYCombo = coachingAcquisiYYYYCombo;
	}

	/**
	 * NC206DTO.javacoachingAcquisiMMComboを設定
	 * @return coachingAcquisiMMCombo
	 */
	public LinkedHashMap<String, String> getCoachingAcquisiMMCombo() {
		return coachingAcquisiMMCombo;
	}

	/**
	 * @param coachingAcquisiMMCombo セットする coachingAcquisiMMCombo
	 */
	public void setCoachingAcquisiMMCombo(LinkedHashMap<String, String> coachingAcquisiMMCombo) {
		this.coachingAcquisiMMCombo = coachingAcquisiMMCombo;
	}

	/**
	 * NC206DTO.javacoachingAcquisiDDComboを設定
	 * @return coachingAcquisiDDCombo
	 */
	public LinkedHashMap<String, String> getCoachingAcquisiDDCombo() {
		return coachingAcquisiDDCombo;
	}

	/**
	 * @param coachingAcquisiDDCombo セットする coachingAcquisiDDCombo
	 */
	public void setCoachingAcquisiDDCombo(LinkedHashMap<String, String> coachingAcquisiDDCombo) {
		this.coachingAcquisiDDCombo = coachingAcquisiDDCombo;
	}

	/**
	 * NC206DTO.javacoachingStYYYYComboを設定
	 * @return coachingStYYYYCombo
	 */
	public LinkedHashMap<String, String> getCoachingStYYYYCombo() {
		return coachingStYYYYCombo;
	}

	/**
	 * @param coachingStYYYYCombo セットする coachingStYYYYCombo
	 */
	public void setCoachingStYYYYCombo(LinkedHashMap<String, String> coachingStYYYYCombo) {
		this.coachingStYYYYCombo = coachingStYYYYCombo;
	}

	/**
	 * NC206DTO.javacoachingStMMComboを設定
	 * @return coachingStMMCombo
	 */
	public LinkedHashMap<String, String> getCoachingStMMCombo() {
		return coachingStMMCombo;
	}

	/**
	 * @param coachingStMMCombo セットする coachingStMMCombo
	 */
	public void setCoachingStMMCombo(LinkedHashMap<String, String> coachingStMMCombo) {
		this.coachingStMMCombo = coachingStMMCombo;
	}

	/**
	 * NC206DTO.javacoachingStDDComboを設定
	 * @return coachingStDDCombo
	 */
	public LinkedHashMap<String, String> getCoachingStDDCombo() {
		return coachingStDDCombo;
	}

	/**
	 * @param coachingStDDCombo セットする coachingStDDCombo
	 */
	public void setCoachingStDDCombo(LinkedHashMap<String, String> coachingStDDCombo) {
		this.coachingStDDCombo = coachingStDDCombo;
	}

	/**
	 * NC206DTO.javacoachingEdYYYYComboを設定
	 * @return coachingEdYYYYCombo
	 */
	public LinkedHashMap<String, String> getCoachingEdYYYYCombo() {
		return coachingEdYYYYCombo;
	}

	/**
	 * @param coachingEdYYYYCombo セットする coachingEdYYYYCombo
	 */
	public void setCoachingEdYYYYCombo(LinkedHashMap<String, String> coachingEdYYYYCombo) {
		this.coachingEdYYYYCombo = coachingEdYYYYCombo;
	}

	/**
	 * NC206DTO.javacoachingEdMMComboを設定
	 * @return coachingEdMMCombo
	 */
	public LinkedHashMap<String, String> getCoachingEdMMCombo() {
		return coachingEdMMCombo;
	}

	/**
	 * @param coachingEdMMCombo セットする coachingEdMMCombo
	 */
	public void setCoachingEdMMCombo(LinkedHashMap<String, String> coachingEdMMCombo) {
		this.coachingEdMMCombo = coachingEdMMCombo;
	}

	/**
	 * NC206DTO.javacoachingEdDDComboを設定
	 * @return coachingEdDDCombo
	 */
	public LinkedHashMap<String, String> getCoachingEdDDCombo() {
		return coachingEdDDCombo;
	}

	/**
	 * @param coachingEdDDCombo セットする coachingEdDDCombo
	 */
	public void setCoachingEdDDCombo(LinkedHashMap<String, String> coachingEdDDCombo) {
		this.coachingEdDDCombo = coachingEdDDCombo;
	}

	/**
	 * NC206DTO.javacertifyingPhysicianCdComboを設定
	 * @return certifyingPhysicianCdCombo
	 */
	public LinkedHashMap<String, String> getCertifyingPhysicianCdCombo() {
		return certifyingPhysicianCdCombo;
	}

	/**
	 * @param certifyingPhysicianCdCombo セットする certifyingPhysicianCdCombo
	 */
	public void setCertifyingPhysicianCdCombo(LinkedHashMap<String, String> certifyingPhysicianCdCombo) {
		this.certifyingPhysicianCdCombo = certifyingPhysicianCdCombo;
	}

	/**
	 * NC206DTO.javacertifyStYYYYComboを設定
	 * @return certifyStYYYYCombo
	 */
	public LinkedHashMap<String, String> getCertifyStYYYYCombo() {
		return certifyStYYYYCombo;
	}

	/**
	 * @param certifyStYYYYCombo セットする certifyStYYYYCombo
	 */
	public void setCertifyStYYYYCombo(LinkedHashMap<String, String> certifyStYYYYCombo) {
		this.certifyStYYYYCombo = certifyStYYYYCombo;
	}

	/**
	 * NC206DTO.javacertifyStMMComboを設定
	 * @return certifyStMMCombo
	 */
	public LinkedHashMap<String, String> getCertifyStMMCombo() {
		return certifyStMMCombo;
	}

	/**
	 * @param certifyStMMCombo セットする certifyStMMCombo
	 */
	public void setCertifyStMMCombo(LinkedHashMap<String, String> certifyStMMCombo) {
		this.certifyStMMCombo = certifyStMMCombo;
	}

	/**
	 * NC206DTO.javacertifyStDDComboを設定
	 * @return certifyStDDCombo
	 */
	public LinkedHashMap<String, String> getCertifyStDDCombo() {
		return certifyStDDCombo;
	}

	/**
	 * @param certifyStDDCombo セットする certifyStDDCombo
	 */
	public void setCertifyStDDCombo(LinkedHashMap<String, String> certifyStDDCombo) {
		this.certifyStDDCombo = certifyStDDCombo;
	}

	/**
	 * NC206DTO.javacertifyEdYYYYComboを設定
	 * @return certifyEdYYYYCombo
	 */
	public LinkedHashMap<String, String> getCertifyEdYYYYCombo() {
		return certifyEdYYYYCombo;
	}

	/**
	 * @param certifyEdYYYYCombo セットする certifyEdYYYYCombo
	 */
	public void setCertifyEdYYYYCombo(LinkedHashMap<String, String> certifyEdYYYYCombo) {
		this.certifyEdYYYYCombo = certifyEdYYYYCombo;
	}

	/**
	 * NC206DTO.javacertifyEdMMComboを設定
	 * @return certifyEdMMCombo
	 */
	public LinkedHashMap<String, String> getCertifyEdMMCombo() {
		return certifyEdMMCombo;
	}

	/**
	 * @param certifyEdMMCombo セットする certifyEdMMCombo
	 */
	public void setCertifyEdMMCombo(LinkedHashMap<String, String> certifyEdMMCombo) {
		this.certifyEdMMCombo = certifyEdMMCombo;
	}

	/**
	 * NC206DTO.javacertifyEdDDComboを設定
	 * @return certifyEdDDCombo
	 */
	public LinkedHashMap<String, String> getCertifyEdDDCombo() {
		return certifyEdDDCombo;
	}

	/**
	 * @param certifyEdDDCombo セットする certifyEdDDCombo
	 */
	public void setCertifyEdDDCombo(LinkedHashMap<String, String> certifyEdDDCombo) {
		this.certifyEdDDCombo = certifyEdDDCombo;
	}

	/**
	 * NC206DTO.javahcpSocietyDataListを設定
	 * @return hcpSocietyDataList
	 */
	public List<HcpSocietyData> getHcpSocietyDataList() {
		return hcpSocietyDataList;
	}

	/**
	 * @param hcpSocietyDataList セットする hcpSocietyDataList
	 */
	public void setHcpSocietyDataList(List<HcpSocietyData> hcpSocietyDataList) {
		this.hcpSocietyDataList = hcpSocietyDataList;
	}

	/**
	 * NC206DTO.javaslistIndexを設定
	 * @return listIndex
	 */
	public Integer getSlistIndex() {
		return slistIndex;
	}

	/**
	 * @param listIndex セットする listIndex
	 */
	public void setSlistIndex(Integer listIndex) {
		this.slistIndex = slistIndex;
	}

	/**
	 * NC206DTO.javahcpSocietyDataChgFlgを設定
	 * @return hcpSocietyDataChgFlg
	 */
	public String getHcpSocietyDataChgFlg() {
		return hcpSocietyDataChgFlg;
	}

	/**
	 * @param hcpSocietyDataChgFlg セットする hcpSocietyDataChgFlg
	 */
	public void setHcpSocietyDataChgFlg(String hcpSocietyDataChgFlg) {
		this.hcpSocietyDataChgFlg = hcpSocietyDataChgFlg;
	}

	/**
	 * このDTOの値を返す
	 * @return DTOの値
	 * @generated
	 */
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
