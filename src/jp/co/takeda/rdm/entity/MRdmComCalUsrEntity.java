package jp.co.takeda.rdm.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jp.co.takeda.rdm.common.BaseEntity;

/**
 * Entityクラス
 * テーブル物理名 : M_RDM_COM_CAL_USR
 * テーブル論理名 : RDM用カレンダー(オンライン用)
 * @generated
 */
public class MRdmComCalUsrEntity  extends BaseEntity implements Serializable{

	/**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 年 (PK)
     * @generated
     */
    private String calYear;
    private boolean calYearNullFlag;

    /**
     * 月 (PK)
     * @generated
     */
    private String calMonth;
    private boolean calMonthNullFlag;

    /**
     * 日 (PK)
     * @generated
     */
    private String calDay;
    private boolean calDayNullFlag;

    /**
     * 年度
     * @generated
     */
    private String fiscalYear;
    private boolean fiscalYearNullFlag;

    /**
     * 曜日
     * @generated
     */
    private String dayKb;
    private boolean dayKbNullFlag;

    /**
     * 年月日
     * @generated
     */
    private Date calDate;
    private boolean calDateNullFlag;

    /**
     * 期
     * @generated
     */
    private Date calTerm;
    private boolean calTermNullFlag;

    /**
     * 祝日フラグ
     * @generated
     */
    private String pubHoliday;
    private boolean pubHolidayNullFlag;

    /**
     * 営業日フラグ
     * @generated
     */
    private String businessDay;
    private boolean businessDayNullFlag;

    /**
     * 本日フラグ
     * @generated
     */
    private String today;
    private boolean todayNullFlag;

    /**
     * 摘要
     * @generated
     */
    private String summary;
    private boolean summaryNullFlag;

    /**
     * 月内営業日順位
     * @generated
     */
    private Integer bizDays;
    private boolean bizDaysNullFlag;

    /**
     * 作成日
     * @generated
     */
    private Date isShaYmd;
    private boolean isShaYmdNullFlag;

    /**
     * 作成者
     * @generated
     */
    private String insShaId;
    private boolean insShaIdNullFlag;

    /**
     * 更新日
     * @generated
     */
    private Date updShaYmd;
    private boolean updShaYmdNullFlag;

    /**
     * 更新者
     * @generated
     */
    private String updShaId;
    private boolean updShaIdNullFlag;

    /**
     * コンストラクタ
     * @param  本日
     * @generated
     */
    public MRdmComCalUsrEntity(String today) {
        super("m_rdm_com_cal_usr", "selectTodaySRdmJkrSosAddrEntiry");
        this.today = today;
    }

    /**
     * コンストラクタ
     * @param 過去
     * @generated
     */
    public MRdmComCalUsrEntity() {
        super("m_rdm_com_cal_usr", "selectAgoSRdmJkrSosAddrEntiry");
    }

    /**
     * コンストラクタ
     * @param calYear 年
     * @param calMonth 月
     * @param calDay 日
     * @generated
     */
    public MRdmComCalUsrEntity(String calYear, String calMonth, String calDay) {
        super("m_rdm_com_cal_usr");
        this.calYear = calYear;
        this.calMonth = calMonth;
        this.calDay = calDay;
    }


	public String getCalYear() {
		return calYear;
	}

	public void setCalYear(String calYear) {
		this.calYear = calYear;
	}

	public boolean isCalYearNullFlag() {
		return calYearNullFlag;
	}

	public void setCalYearNullFlag(boolean calYearNullFlag) {
		this.calYearNullFlag = calYearNullFlag;
	}

	public String getCalMonth() {
		return calMonth;
	}

	public void setCalMonth(String calMonth) {
		this.calMonth = calMonth;
	}

	public boolean isCalMonthNullFlag() {
		return calMonthNullFlag;
	}

	public void setCalMonthNullFlag(boolean calMonthNullFlag) {
		this.calMonthNullFlag = calMonthNullFlag;
	}

	public String getCalDay() {
		return calDay;
	}

	public void setCalDay(String calDay) {
		this.calDay = calDay;
	}

	public boolean isCalDayNullFlag() {
		return calDayNullFlag;
	}

	public void setCalDayNullFlag(boolean calDayNullFlag) {
		this.calDayNullFlag = calDayNullFlag;
	}

	public String getFiscalYear() {
		return fiscalYear;
	}

	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}

	public boolean isFiscalYearNullFlag() {
		return fiscalYearNullFlag;
	}

	public void setFiscalYearNullFlag(boolean fiscalYearNullFlag) {
		this.fiscalYearNullFlag = fiscalYearNullFlag;
	}

	public String getDayKb() {
		return dayKb;
	}

	public void setDayKb(String dayKb) {
		this.dayKb = dayKb;
	}

	public boolean isDayKbNullFlag() {
		return dayKbNullFlag;
	}

	public void setDayKbNullFlag(boolean dayKbNullFlag) {
		this.dayKbNullFlag = dayKbNullFlag;
	}

	public Date getCalDate() {
		return calDate;
	}

	public void setCalDate(Date calDate) {
		this.calDate = calDate;
	}

	public boolean isCalDateNullFlag() {
		return calDateNullFlag;
	}

	public void setCalDateNullFlag(boolean calDateNullFlag) {
		this.calDateNullFlag = calDateNullFlag;
	}

	public Date getCalTerm() {
		return calTerm;
	}

	public void setCalTerm(Date calTerm) {
		this.calTerm = calTerm;
	}

	public boolean isCalTermNullFlag() {
		return calTermNullFlag;
	}

	public void setCalTermNullFlag(boolean calTermNullFlag) {
		this.calTermNullFlag = calTermNullFlag;
	}

	public String getPubHoliday() {
		return pubHoliday;
	}

	public void setPubHoliday(String pubHoliday) {
		this.pubHoliday = pubHoliday;
	}

	public boolean isPubHolidayNullFlag() {
		return pubHolidayNullFlag;
	}

	public void setPubHolidayNullFlag(boolean pubHolidayNullFlag) {
		this.pubHolidayNullFlag = pubHolidayNullFlag;
	}

	public String getBusinessDay() {
		return businessDay;
	}

	public void setBusinessDay(String businessDay) {
		this.businessDay = businessDay;
	}

	public boolean isBusinessDayNullFlag() {
		return businessDayNullFlag;
	}

	public void setBusinessDayNullFlag(boolean businessDayNullFlag) {
		this.businessDayNullFlag = businessDayNullFlag;
	}

	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}

	public boolean isTodayNullFlag() {
		return todayNullFlag;
	}

	public void setTodayNullFlag(boolean todayNullFlag) {
		this.todayNullFlag = todayNullFlag;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public boolean isSummaryNullFlag() {
		return summaryNullFlag;
	}

	public void setSummaryNullFlag(boolean summaryNullFlag) {
		this.summaryNullFlag = summaryNullFlag;
	}

	public Integer getBizDays() {
		return bizDays;
	}

	public void setBizDays(Integer bizDays) {
		this.bizDays = bizDays;
	}

	public boolean isBizDaysNullFlag() {
		return bizDaysNullFlag;
	}

	public void setBizDaysNullFlag(boolean bizDaysNullFlag) {
		this.bizDaysNullFlag = bizDaysNullFlag;
	}

	public Date getIsShaYmd() {
		return isShaYmd;
	}

	public void setIsShaYmd(Date isShaYmd) {
		this.isShaYmd = isShaYmd;
	}

	public boolean isShaYmdNullFlag() {
		return isShaYmdNullFlag;
	}

	public void setShaYmdNullFlag(boolean isShaYmdNullFlag) {
		this.isShaYmdNullFlag = isShaYmdNullFlag;
	}

	public String getInsShaId() {
		return insShaId;
	}

	public void setInsShaId(String insShaId) {
		this.insShaId = insShaId;
	}

	public boolean isInsShaIdNullFlag() {
		return insShaIdNullFlag;
	}

	public void setInsShaIdNullFlag(boolean insShaIdNullFlag) {
		this.insShaIdNullFlag = insShaIdNullFlag;
	}

	public Date getUpdShaYmd() {
		return updShaYmd;
	}

	public void setUpdShaYmd(Date updShaYmd) {
		this.updShaYmd = updShaYmd;
	}

	public boolean isUpdShaYmdNullFlag() {
		return updShaYmdNullFlag;
	}

	public void setUpdShaYmdNullFlag(boolean updShaYmdNullFlag) {
		this.updShaYmdNullFlag = updShaYmdNullFlag;
	}

	public String getUpdShaId() {
		return updShaId;
	}

	public void setUpdShaId(String updShaId) {
		this.updShaId = updShaId;
	}

	public boolean isUpdShaIdNullFlag() {
		return updShaIdNullFlag;
	}

	public void setUpdShaIdNullFlag(boolean updShaIdNullFlag) {
		this.updShaIdNullFlag = updShaIdNullFlag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
