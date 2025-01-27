package jp.co.takeda.rdm.util;

import java.util.Date;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.sql.Timestamp;

/**
 * タイトル:  武田薬品工業株式会社 新MR支援システム MAPS
 * 説明:    説明を記載
 * 会社名:   日立
 * @author
 * @version 0.0.1
 *
 */
public class DateUtils {

    /**
     * <pre>
     *  リビジョンの取得
     * 自クラスのリビジョンを返却する。
     * </pre>
     * @return String - リビジョン
     * @since 1.x
     */
    public static String getRevision(){
        return "$Revision: 1.1 $";
    }

    private static final SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy/MM/dd",Locale.getDefault());
    private static final SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss",Locale.getDefault());
    private static final SimpleDateFormat sdfDate2 = new SimpleDateFormat("MM/dd");
    private static final SimpleDateFormat sdfDateTime2 = new SimpleDateFormat("MM/dd HH:mm");

    public DateUtils() {
    }
    /**
     * <pre>
     * yyyy/MM/dd HH:mm:ssにフォーマットされた文字列を取得する。
     * </pre>
     * @return 日付文字列
     */
    public static String longToDateTimeString(long dt){
        Date date = new Date(dt);
        return sdfDateTime.format(date);
    }
    /**
     * <pre>
     * yyyy/MM/dd HH:mm:ssにフォーマットされた文字列を取得する。
     * </pre>
     * @return 日付文字列
     */
    public static String longToDateString(long dt){
        Date date = new Date(dt);
        return sdfDate.format(date);
    }
  /**
   * <pre>
   * 年を取得する。
   * </pre>
   * @return 年の値 1900～
   */
    public static int getYear(Date dt){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
        //return( calendar.get(Calendar.YEAR) - 1900 );
        //1900を引くと 2002年が102年になってしまうので引かない
        return( calendar.get(Calendar.YEAR) );
    }
    /**
     * <pre>
     * 月を取得する。
     * </pre>
     * @return 月の値 0～11
     */
    public static int getMonth(Date dt){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
        return( calendar.get(Calendar.MONTH) );
    }
    /**
     * <pre>
     * 日を取得する。
     * </pre>
     * @return 日の値 1～31
     */
    public static int getDate(Date dt){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
        return( calendar.get(Calendar.DATE) );
    }
    /**
     * <pre>
     * 時を取得する。
     * </pre>
     * @return 時の値 0～23
     */
    public static int getHours(Date dt){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
        return( calendar.get(Calendar.HOUR_OF_DAY) );
    }
    /**
     * <pre>
     * 分を取得する。
     * </pre>
     * @return 時の値 0～59
     */
    public static int getMinutes(Date dt){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
        return( calendar.get(Calendar.MINUTE) );
    }
    /**
     * <pre>
     * 秒を取得する。
     * </pre>
     * @return 時の値 0～59 (60,61)
     */
    public static int getSeconds(Date dt){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
        return( calendar.get(Calendar.SECOND) );
    }
    /**
     * <pre>
     * 秒を取得する。
     * </pre>
     * @return 時の値 0～59 (60,61)
     */
    public static int getDay(Date dt){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
        return( calendar.get(Calendar.DAY_OF_WEEK) );
    }

    /**
     * <pre>
     *  システム日付を取得します。
     *<b>使用例:</b>
     *      [使用例を記述する]
     * </pre>
     * @return String - [コメント]
     * @exception [例外名] [コメント]
     * @since 1.0
     * @see [関連クラス名]#[関連メソッド名]
     */
    public static String getSysdate(){
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime().toString();
    }

    /**
     * <pre>
     *  システム日付を取得します。
     *<b>使用例:</b>
     *      [使用例を記述する]
     * </pre>
     * @return String - [コメント]
     * @exception [例外名] [コメント]
     * @since 1.0
     * @see [関連クラス名]#[関連メソッド名]
     */
    public static Date getNowDate(){
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }


    //外部、内部メソッドから呼ばれる共通メソッド
    public static String getSysDate(String format){
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date currentTime = new Date();
        return formatter.format(currentTime);
    }
    //String 時刻
    public static String getSysDate(){
        return getSysDate("yyyy/MM/dd");
    }
    public static String getSysYear(){
        return getSysDate("yyyy");
    }
    public static String getSysMonth(){
        return getSysDate("MM");
    }
    public static String getSysDay(){
        return getSysDate("dd");
    }
    public static String getSysDayOfWeek(){
        return getSysDate("EEE");
    }

    //String 時刻
    public static String getSysTime(){
        return getSysDate("HH:mm:ss");
    }
    public static String getSysMilliTime(){
        return getSysDate("HH:mm:ss.SSS");
    }
    public static String getSysHour(){
        return getSysDate("HH");
    }
    public static String getSysMinute(){
        return getSysDate("mm");
    }
    public static String getSysSecond(){
        return getSysDate("ss");
    }
    public static String getSysMilliSecond(){
        return getSysDate("SSS");
    }

    //int 日付
    public static int getIntSysYear(){
        return Integer.parseInt(getSysDate("yyyy"));
    }
    public static int getIntSysMonth(){
        return Integer.parseInt(getSysDate("MM"));
    }
    public static int getIntSysDay(){
        return Integer.parseInt(getSysDate("dd"));
    }

    //int 日付
    public static int getIntSysHour(){
        return Integer.parseInt(getSysDate("HH"));
    }
    public static int getIntSysMinute(){
        return Integer.parseInt(getSysDate("mm"));
    }
    public static int getIntSysSecond(){
        return Integer.parseInt(getSysDate("ss"));
    }
    public static int getIntSysMilliSecond(){
        return Integer.parseInt(getSysDate("SSS"));
    }

    //Timestamp 現在日付 + 現在時刻
    public static Timestamp getTimestampSysDate(){
          return new Timestamp(Calendar.getInstance().getTime().getTime());
    }

    //Timestamp 現在日付 + 時刻(00：00：00：000)
    public static Timestamp getTimestampSysDateZero(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        return new Timestamp(calendar.getTime().getTime());
    }

    /**
     * 本日日付をlong値で戻します。
     */
    public static long getLongSysDate(){
        return getTimestampSysDate().getTime();
    }

    /**
     * 日付変換処理（日付→文字列MM/dd）
     * @param date 日付
     * @param format フォーマット
     * @return 文字列
     */
    public static String parseDate(Date date){
        if (date == null) {
            return "";
        }
        return sdfDate2.format(date);
    }

    /**
     * 日付変換処理（日付→文字列MM/dd HH:mm）
     * @param date 日付
     * @param format フォーマット
     * @return 文字列
     */
    public static String parseDateTime(Date date){
        if (date == null) {
            return "";
        }
        return sdfDateTime2.format(date);
    }

    /**
     * 日付変換処理（日付→文字列yyyy/MM/dd）
     * @param date 日付
     * @param format フォーマット
     * @return 文字列
     */
    public static String dateToString(Date date) {
        return sdfDate.format(date);
    }

    /**
     * 日付変換処理（年、月、日→日付yyyy/MM/dd）
     * @param String 年、月、日
     * @param format フォーマット
     * @return Date
     */
    public static Date stringYMDToDate(String strY, String strM, String strD){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Integer.valueOf(strY));
        cal.set(Calendar.MONDAY, Integer.valueOf(strM) - 1);
        cal.set(Calendar.DAY_OF_MONTH, Integer.valueOf(strD));
        Date date2 = new Date(cal.getTimeInMillis());
        return stringToDate(dateToString(date2));
    }

    /**
     * 日付変換処理（年月日→日付yyyy/MM/dd）
     * @param String 年月日
     * @param format フォーマット
     * @return Date
     */
    public static Date stringToDate(String ymd){
        Date date = null;
        try {
            date = DateFormat.getDateInstance().parse(ymd);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 日付変換処理（ｎ月後の日付が取得yyyy/MM/dd）
     * @param Date 年月日　ｎ：ｎ月後
     * @param format フォーマット
     * @return 文字列
     */
    public static String addMonth(Date date, int n){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, n);
        return sdfDate.format(calendar.getTime());
    }

    /**
     * 日付変換処理（日付→文字列yyyy/MM/dd HH:mm:ss）
     * @param date 日付
     * @param format フォーマット
     * @return 文字列
     */
    public static String parseDateTime2(Date date){
        if (date == null) {
            return "";
        }
        return sdfDateTime.format(date);
    }

    /**
     * 日付と期限について、新しい日付を算出する
     * @param date 日付
     * @param n 期限
     * @return
     * @throws Exception
     */
	public static String addDay(String date,int n) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	    Calendar cd = Calendar.getInstance();
	    try{
	        cd.setTime(sdf.parse(date));
	        cd.add(Calendar.DATE, n);
	    }catch(Exception e){}
	    return sdf.format(cd.getTime());
	}
}
