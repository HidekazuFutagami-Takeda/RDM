package jp.co.takeda.jkr.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * <pre>
 * 開発支援を行うクラスです。
 * abstract class として宣言しているのでクラスのインスタンスを生成することはできません。
 * スタティック参照で使用してください。
 * </pre>
 */
abstract public class AppMethods {

    /**
     * <pre>
     * コンストラクタ
     * </pre>
     */
    public AppMethods(){
    }
// ******************************************************************
//                  JSP系
// ******************************************************************
    /**
     * <pre>
     * フレーム対応で発生したPOST用必要文字列を生成するメソッドです。
     * </pre>
     *
     * @param status  フレーム対応か否か(frame:フレーム対応)
     * @param valType オブジェクトタイプ
     * @return 必要文字列
     * @since 1.0
     */
    public static String getFramPostValue(String status,String valType){
        String retVal = "";
        status = (status==null)?"":status;
        valType = (valType==null)?"":valType;

        //フレーム対応アプリかつオブジェクトがtext,hiddenの時のみ値をセットして返します。
        if(status.equalsIgnoreCase("frame")&&(valType.equalsIgnoreCase("text") || valType.equalsIgnoreCase("hidden"))){
            retVal += "<input type='"+valType+"' name='comFrameKb' value='frame' />\r\n";
            retVal += "<input type='"+valType+"' name='comFrameRedirect' value='false' />\r\n";
            retVal += "<input type='"+valType+"' name='comFrameError' value='false' />\r\n";
        }
        return retVal;
    }

//    /**
//     * <pre>
//     * Taglibに無いカスタマイズ用&ltoption&gtタグを生成するメソッドです。
//     * </pre>
//     *
//     * @param value Option value
//     * @param txt 表示文字列
//     * @param selected セレクトフラグ
//     * @return &ltoption&gtタグ
//     * @since 1.0
//     */
//    public static String getOptionTag(String value,String txt,boolean selected){
//        return "<option value=\"" + value + "\" " + ((selected)? "selected":"") + ">" + txt + "</option>\n";
//    }
//    /**
//     * <pre>
//     * Taglibに無いカスタマイズ用&ltoption&gtタグを生成するメソッドです。
//     * getOptionTag(value,txt,boolean)のvalue値とtxt値が同じ値のときに使用する簡易メソッドです。
//     * </pre>
//     *
//     * @param valueTxt Option value and 表示文字列
//     * @param selected boolean
//     * @return &ltoption&gt
//     * @since 1.0
//     */
//    public static String getOptionTag(String valueTxt,boolean selected){
//        return getOptionTag(valueTxt,valueTxt,selected);
//    }
//    /**
//     * <pre>
//     * &ltselect&gtの&ltoption&gtタグを生成するメソッドです。
//     * </pre>
//     *
//     * @param from 最初の値
//     * @param to 最後の値
//     * @param selected セレクト文字列
//     * @param hasbrank Null文字列が必要な時に使用する
//     * @return &ltoption&gtタグ
//     */
//    public static String getCommbo(int from,int to,String selected) {
//        return getCommbo(from,to,selected,null,null);
//    }
//    /**
//     * <pre>
//     * &ltselect&gtの&ltoption&gtタグを生成するメソッドです。
//     * </pre>
//     *
//     * @param from 最初の値
//     * @param to 最後の値
//     * @param selected セレクト文字列
//     * @param blankTxt 初期表示用フィールドが必要な時に設定
//     * @param blankValue 初期表示用フィールドが必要な時に設定
//     * @return &ltoption&gtタグ
//     */
//    public static String getCommbo(int from,int to,String selected,String blankTxt,String blankValue) {
//        StringBuffer optionTag = new StringBuffer(100);
//
//        if(blankTxt != null && blankValue != null){
//            optionTag.append(getOptionTag(blankValue,blankTxt,false));
//        }
//
//        if(selected == null || selected.equals("")){
//            selected = "";
//        }else{
//            selected = "" + Integer.parseInt(selected,10);
//        }
//
//        for(int i = from;i < to + 1;i++){
//            optionTag.append(getOptionTag("" + i,(selected.equals("" + i))? true:false));
//        }
//
//        return optionTag.toString();
//    }
//    /**
//     * <pre>
//     * 文字列形式の&ltselect&gtタグを生成するメソッドです。
//     * ★使用例
//     *  getSelect("insCd",
//     *      "{A,B,C}",
//     *      "{1,2,3}",
//     *      data.getInsCd().toString(),"","");
//     *  結果
//     *      &ltselect name="insCd"&gt
//     *          &ltoption value=""&gt&lt/option&gt
//     *          &ltoption value="1"&gtA&lt/option&gt
//     *          &ltoption value="2" selected&gtB&lt/option&gt
//     *          &ltoption value="3"&gtC&lt/option&gt
//     *      &lt/select&gt
//     * </pre>
//     *
//     * @param name &ltselect&gtのname
//     * @param txtArray 表示文字列配列
//     * @param valueArray &ltoption&gtのvalue値
//     * @param selected
//     * @return &ltselect&gtタグ
//     */
//    public static String getSelect(String name,String[] txtArray,String[] valueArray,String selected) throws JspException {
//        StringBuffer select = new StringBuffer(100);
//
//        if(txtArray == null || valueArray == null) throw new JspException("txtArray or valueArray is Null");
//
//        select.append("<select name=\"" + name +"\">");
//
//        if(selected == null){
//            selected = "";
//        }
//
//        for(int i = 0;i < txtArray.length;i++){
//            select.append(getOptionTag(txtArray[i],valueArray[i],selected.equals(valueArray[i])));
//        }
//
//        select.append("</select>");
//
//        return select.toString();
//    }
//    /**
//     * <pre>
//     * チェックボックスの比較を行い文字列 checked を返すメソッドです。
//     * ★使用例
//     *  &ltinput type="checkbox" name="mrAtt" &lt% AppMethod.hasChecked(data.getMrAtt(),"1") %&gt&gt
//     *      結果１ data.getMrAtt() が "1" だった時
//     *          &ltinput type="checkbox" name="mrAtt" checked&gt
//     *      結果２ data.getMrAtt() が "2" だった時
//     *          &ltinput type="checkbox" name="mrAtt" &gt
//     *      結果３ data.getMrAtt() が null だった時
//     *          &ltinput type="checkbox" name="mrAtt" &gt
//     * </pre>
//     *
//     * @param istring DB内のデータ(Dataクラスオブジェクト内のプロパティ値)
//     * @param string 比較する文字列(java.lang.String)
//     * @return String checked
//     */
//    public static String hasChecked(IString istring,String string){
//        return equals(istring,string,"checked");
//    }
//    /**
//     * <pre>
//     * セレクトボックスの比較を行い文字列 selected を返すメソッドです。
//     * ★使用例
//     *  &ltselect&gt
//     *      &ltoption name="mrAtt" value="1" &lt% AppMethod.hasSelected(data.getMrAtt(),"1") %&gt&gt値は１&ltoption&gt
//     *      &ltoption name="mrAtt" value="2" &lt% AppMethod.hasSelected(data.getMrAtt(),"2") %&gt&gt値は２&ltoption&gt
//     *  &lt/select&gt
//     *      結果１ data.getMrAtt() が "1" だった時
//     *          &ltselect&gt
//     *              &ltoption name="mrAtt" value="1" selected&gt値は１&ltoption&gt
//     *              &ltoption name="mrAtt" value="2" &gt値は２&ltoption&gt
//     *          &lt/select&gt
//     *      結果２ data.getMrAtt() が "2" だった時
//     *          &ltselect&gt
//     *              &ltoption name="mrAtt" value="1" &gt値は１&ltoption&gt
//     *              &ltoption name="mrAtt" value="2" selected&gt値は２&ltoption&gt
//     *          &lt/select&gt
//     *      結果３ data.getMrAtt() が null だった時
//     *          &ltselect&gt
//     *              &ltoption name="mrAtt" value="1" &gt値は１&ltoption&gt
//     *              &ltoption name="mrAtt" value="2" &gt値は２&ltoption&gt
//     *          &lt/select&gt
//     * </pre>
//     *
//     * @param istring DB内のデータ(Dataクラスオブジェクト内のプロパティ値)
//     * @param string 比較する文字列(java.lang.String)
//     * @return String selected
//     */
//    public static String hasSelected(IString istring,String string){
//        return equals(istring,string,"selected");
//    }
//    /**
//     * <pre>
//     * セレクトボックスの比較を行い文字列 selected を返すメソッドです。
//     * </pre>
//     *
//     * @param string DB内のデータ(Dataクラスオブジェクト内のプロパティ値)
//     * @param string 比較する文字列(java.lang.String)
//     * @return String selected
//     */
//    public static String hasSelected(String dbString,String valString){
//        if(dbString == null) return "";
//        return (dbString.equals(valString))? "selected":"";
//    }
//
//    /**
//     * <pre>
//     * &ltselect&gtの&ltoption&gtタグを生成するメソッドです。
//     * 年用メソッド
//     * ★注意
//     *  文献検索のみ使用してください。
//     * </pre>
//     *
//     * @param value 年月日
//     * @param from 基準となる年
//     * @param String name &ltselect&gtのname
//     * @return &ltselect&gtタグ
//     */
//    public static String getYearCommbo(IString value,int from,String name){
//        String selected = ymdSubString(value,0,4);
//
//        Calendar cal = Calendar.getInstance();
//
//        // 現在の年月を取得します。
//        int nowYear = cal.get(Calendar.YEAR);
//
//        return getSelect(from,nowYear,selected,name,"----","");
//    }
//    /**
//     * <pre>
//     * &ltselect&gtの&ltoption&gtタグを生成するメソッドです。
//     * 月用メソッド
//     * ★注意
//     *  文献検索のみ使用してください。
//     * </pre>
//     *
//     * @param value 年月日
//     * @param name &ltselect&gtのname
//     * @return &ltselect&gtタグ
//     */
//    public static String getMonthCommbo(IString value,String name){
//        String selected = ymdSubString(value,4,6);
//        return getSelect(1,12,selected,name,"--","");
//    }
//    /**
//     * <pre>
//     * &ltselect&gtの&ltoption&gtタグを生成するメソッドです。
//     * 日用メソッド
//     * </pre>
//     *
//     * @param value 年月日
//     * @param name &ltselect&gtのname
//     * @return &ltselect&gtタグ
//     */
//    public static String getDayCommbo(IString value,String name){
//        String selected = ymdSubString(value,6,8);
//        return getSelect(1,31,selected,name,"--","");
//    }
//    /**
//     * <pre>
//     * プライベートメソッド
//     * 外部参照はできません。
//     * </pre>
//     *
//     * @param from 基準値
//     * @param to 末値
//     * @param name &ltselect&gtのname
//     * @param blankTxt 初期の文字列
//     * @param blankValue 初期の値
//     * @return &ltselect&gtタグ
//     */
//    private static String getSelect(int from,int to,String selected,String name,String blankTxt,String blankValue){
//        StringBuffer select = new StringBuffer(100);
//
//        select.append("<select name=\"" + name + "\">\n");
//        select.append(getCommbo(from,to,selected,blankTxt,blankValue));
//        select.append("</select>\n");
//
//        return select.toString();
//    }
//    /**
//     * <pre>
//     * プライベートメソッドです。
//     * 外部参照できません。
//     * </pre>
//     *
//     * @param value 年月日
//     * @param from java.lang.String.substring(from,to)
//     * @param to java.lang.String.substring(from,to)
//     * @return substring(from,to)で取得した文字列
//     */
//    private static String ymdSubString(IString value,int from,int to){
//        if(value == null) return "";
//        if(value.toString().length() == 8){
//            return value.toString().substring(from,to);
//        }else{
//            return "";
//        }
//    }
//    /**
//     * <pre>
//     * ボタンを生成するメソッドです。
//     * </pre>
//     *
//     * @param buttonName ボタンに表示する文字列
//     * @param onClick object.onClick時に実行するスクリプトを記述する
//     * @param attribute HTML Attirbutes style etc...
//     * @return &ltinput type="button"&gtタグ
//     */
//    public static String getButton(String buttonName,String onClick,String attribute) {
//        StringBuffer tags = new StringBuffer(100);
//
//        tags.append("<input type=\"button\" name=\"btnDraft\" value=\"" + buttonName + "\" " + attribute + " onClick=\"" + onClick + "\">\n");
//
//        return tags.toString();
//    }
//    /**
//     * <pre>
//     * ボタンにTableDetailを付加して生成するメソッドです。
//     * </pre>
//     *
//     * @param buttonName ボタンに表示する文字列
//     * @param onClick object.onClick時に実行するスクリプトを記述する
//     * @param attributes TableDetailのアトリビュートを記述する
//     * @param buttonAtri Buttonのアトリビュートを記述する
//     * @return &lttd&gt&ltinput type="button"&gt&lt/td&gtタグ
//     */
//    public static String getTdAndButton(String buttonName,String onClick,String attributes,String buttonAtri){
//        StringBuffer tags = new StringBuffer(100);
//
//        tags.append("<td " + attributes + ">\n");
//        tags.append(getButton(buttonName,onClick,buttonAtri));
//        tags.append("</td>\n");
//
//        return tags.toString();
//    }
//    /**
//     * <pre>
//     * ボタンにTableDetailを付加して生成するメソッドです。
//     * ボタンのサイズが固定のwidth=80に設定されたメソッドです。
//     * </pre>
//     *
//     * @param buttonName ボタンに表示する文字列
//     * @param onClick object.onClick時に実行するスクリプトを記述する
//     * @param attributes TableDetailのアトリビュートを記述する
//     * @return &lttd&gt&ltinput type="button"&gt&lt/td&gtタグ
//     */
//    public static String getTdAndButton(String buttonName,String onClick,String attributes){
//        StringBuffer tags = new StringBuffer(100);
//
//        tags.append("<td " + attributes + ">\n");
//        tags.append(getButton(buttonName,onClick,"style=\"{width:80}\""));
//        tags.append("</td>\n");
//
//        return tags.toString();
//    }
//    public static String monthToYears(IInteger years){
//        return monthToYears(years,null,false);
//    }
//    public static String monthToYears(IInteger years,boolean byForce){
//        return monthToYears(years,null,byForce);
//    }
//    /**
//     * <pre>
//     * 年を月持ちしている値を？年？ヶ月表示に返るメソッドです。
//     * </pre>
//     * @param years IInteger
//     * @param name タグName
//     * @param byForce Null値でも強制出力するフラグ
//     */
//    public static String monthToYears(IInteger years,String name,boolean byForce){
//        String tag = "";
//        int month = 0;
//
//        if(years != null){
//            month = years.intValue();
//        }else{
//            if(!byForce){
//                return "";
//            }
//        }
//
//        // 小数点以下を切り捨てる　2 / 12 = 0
//        String yearStr = "" + Integer.parseInt(("" + (month / 12)),10);
//        String monthStr = "" + (month % 12);
//
//        return getMonthToYearsTag(yearStr,monthStr,name);
//    }
//
//    private static String getMonthToYearsTag(String yearStr,String monthStr,String name){
//        String tag = "";
//        if(name == null){
//            tag = yearStr + " 年 " + monthStr + " ヶ月";
//        }else{
//            tag = "<input type=\"text\" size=\"2\" maxlength=\"2\" name=\"" + name + "Year\" value=\"" + yearStr + "\"> 年";
//            tag += "<input type=\"text\" size=\"2\" maxlength=\"2\" name=\"" + name + "Month\" value=\"" + monthStr + "\"> ヶ月";
//            tag += "<input type=\"hidden\" name=\"" + name + "\">";
//        }
//        return tag;
//    }
//    /**
//     * <pre>
//     * IString と java.lang.Stringとを比較するメソッドです。
//     * 引数 istring が null の時は false を返します。
//     * </pre>
//     *
//     * @param istring IStringオブジェクト
//     * @param string String オブジェクト
//     * @return boolean
//     */
//    public static boolean equals(IString istring,String string){
//        if(istring == null) return false;
//        return string.equals(istring.toString());
//    }
//    /**
//     * <pre>
//     * IInteger と プリミティブInt値とを比較するメソッドです。
//     * 引数 iinteger が null の時は false を返します。
//     * </pre>
//     *
//     * @param iinteger IInteger オブジェクト
//     * @param integer Int
//     * @return boolean
//     */
//    public static boolean equals(IInteger iinteger,int integer){
//        if(iinteger == null) return false;
//        return iinteger.intValue() == integer;
//    }
//    /**
//     * <pre>
//     * 比較を行い文字列 引数 returnString を返すメソッドです。
//     * </pre>
//     *
//     * @param istring IStringオブジェクト
//     * @param string java.lang.Stringオブジェクト
//     * @param reString istring == string の時に返す文字列
//     * @return reString
//     */
//    public static String equals(IString istring,String string,String reString){
//        return (equals(istring,string))? reString:"";
//    }
//
//    /**
//     * <pre>
//     * リストボックスを設定するメソッドです。(医師２次用)
//     * </pre>
//     *
//     * @param name オブジェクト名
//     * @param txtArray[] テキスト配列
//     * @param valueArray[] 値配列
//     * @param selected 判断値
//     * @return リストボックス
//     * @since 1.0
//     */
//    public static String getDmcSelect(String name,String[] txtArray,String[] valueArray,String selected) throws JspException {
//        StringBuffer select = new StringBuffer(txtArray.length + 100);
//
//        if(txtArray == null || valueArray == null) throw new JspException("txtArray or valueArray is Null");
//
//        select.append("<select name='" + name +"'>");
//
//        if(selected == null){
//            selected = "";
//        }
//
//        for(int i = 0;i < txtArray.length;i++){
//            select.append(getDmcOptionTag(txtArray[i],valueArray[i],selected.equalsIgnoreCase(valueArray[i])));
//        }
//
//        select.append("</select>");
//
//        return select.toString();
//    }
//
//    /**
//     * <pre>
//     * リストボックスをオプションを設定するメソッドです。(医師２次用)
//     * </pre>
//     *
//     * @param txt テキスト
//     * @param value 値
//     * @param selected 判断値
//     * @return リストボックスオプション
//     * @since 1.0
//     */
//    public static String getDmcOptionTag(String txt,String value,boolean selected){
//        return "<option value='" + value + "' " + ((selected)? "selected":"") + ">" + txt + "</option>\n";
////		return "<option value='" + ((value.equals("0")||value.equals("00"))?"":value) + "' " + ((selected)? "selected":"") + ">" + txt + "</option>\n";
//    }
//    /**
//     * <pre>
//     * 日付リストボックスを取得するメソッドです。(医師２次用)
//     * </pre>
//     *
//     * @param val 日付
//     * @param nameYY 年オブジェクト名
//     * @param nameMM 月オブジェクト名
//     * @param nameDD 日オブジェクト名
//     * @param comYY 年コメント
//     * @param comMM 月コメント
//     * @param comDD 日コメント
//     * @return 日付リストボックス
//     * @since 1.0
//     */
//    public static String getDmcDateListBox(IString val,
//                    String nameYY,String nameMM,String nameDD,
//                    String comYY,String comMM,String comDD
//                    ){
//        String	strDate = val.toString();
//        //--------------------------------------------------------
//        String	strList = new String();
//        strList = "";
//
//        String	strYY = "";
//        int	iMM = 0;
//        int	iDD = 0;
//
//        if(strDate != null && !strDate.equals("")){
//            strYY = (strDate.length() < 4)?"":strDate.substring(0,4);
//            String	sTmp;
//            sTmp = (strDate.length() < 6)? "0": strDate.substring(4,6);
//            iMM = (sTmp.equals("  "))?0:new Integer(sTmp).intValue();
//            sTmp = (strDate.length() < 8)? "0": strDate.substring(6,8);
//            iDD = (sTmp.equals("  "))?0:new Integer(sTmp).intValue();
//        }
//
//        strList = "<input type='text' name='" + nameYY +
//                "' size='4' maxlength='4' style='ime-mode:disabled;' value='" + strYY.trim() +
//                "'/>" + comYY + "</input>\n";
//
//        strList += "<select name='" + nameMM + "'>\n"
//                    + "<option value=''>  </option>\n";
//
//        for(int i=1; i<=12; i++){
//            String sSelect = (i == iMM)? "selected" : "";
//            String	sVal = (i<10)? "0":"";
//            sVal += i;
//            strList += "<option value='" + sVal + "' " + sSelect + ">" + i + "</option>\n";
//        }
//        strList += "</select>" + comMM + "\n";
//
//
//        strList += "<select name='" + nameDD + "'>\n"
//                    + "<option value=''>  </option>\n";
//
//        for(int i=1; i<=31; i++){
//            String sSelect = (i == iDD)? "selected" : "";
//            String	sVal = (i<10)? "0":"";
//            sVal += i;
//            strList += "<option value='" + sVal + "' " + sSelect + ">" + i + "</option>\n";
//        }
//        strList += "</select>" + comDD + "\n";
//
//        return strList;
//    }
//    /**
//     * <pre>
//     * 年月リストボックスを取得するメソッドです。(医師２次用)
//     * </pre>
//     *
//     * @param val 日付
//     * @param nameYY 年オブジェクト名
//     * @param nameMM 月オブジェクト名
//     * @param comYY 年コメント
//     * @param comMM 月コメント
//     * @return 日付リストボックス
//     * @since 1.0
//     */
//    public static String getDmcYMListBox(IString val,
//                    String nameYY,String nameMM,
//                    String comYY,String comMM
//                    ){
//        String	strDate = val.toString();
//        //--------------------------------------------------------
//        String	strList = new String();
//        strList = "";
//
//        String	strYY = "";
//        int	iMM = 0;
//        int	iDD = 0;
//
//        if(strDate != null && !strDate.equals("")){
//            strYY = (strDate.length() < 4)?"":strDate.substring(0,4);
//            String	sTmp;
//            sTmp = (strDate.length() < 6)? "0": strDate.substring(4,6);
//            iMM = (sTmp.equals("  "))?0:new Integer(sTmp).intValue();
//        }
//
//        strList = "<input type='text' name='" + nameYY +
//                "' size='4' maxlength='4' style='ime-mode:disabled;' value='" + strYY.trim() +
//                "'/>" + comYY + "</input>\n";
//
//        strList += "<select name='" + nameMM + "'>\n"
//                    + "<option value=''>  </option>\n";
//
//        for(int i=1; i<=12; i++){
//            String sSelect = (i == iMM)? "selected" : "";
//            String	sVal = (i<10)? "0":"";
//            sVal += i;
//            strList += "<option value='" + sVal + "' " + sSelect + ">" + i + "</option>\n";
//        }
//        strList += "</select>" + comMM + "\n";
//
//
//        return strList;
//    }
//
//    /**
//     * <pre>
//     * 日付フォーマット変換(医師２次用)をするメソッドです。
//     * ITimestampからStringへ（"20020101"のフォーマットで)
//     * </pre>
//     *
//     * @param val 日付
//     * @return ８桁の日付
//     * @since 1.0
//     */
//    public static String getDmcGmnUpDate(ITimestamp val){
//        String	tmpDate = val.toString();
//        return tmpDate.substring(0,4) + tmpDate.substring(5,7) + tmpDate.substring(8,10);
//    }
//
//    /**
//     * <pre>
//     * 日付フォーマット変換(医師２次用)をするメソッドです。 例）20010101 → '01/01/01
//     * </pre>
//     *
//     * @param val ８桁の日付
//     * @return シングルクォーテーション＋スラッシュ付き日付
//     * @since 1.0
//     */
//    public static String getDmcYyMmDd(IString val){
//        String retVal = getToYyMmDd(val);
//        return ( !retVal.equals("") )? "'" + retVal : "&nbsp;";
////		return ( !getToYyMmDd(val).equals("") )? "'" + getToYyMmDd(val) : "&nbsp;";
//    }
//
//    /**
//     * <pre>
//     * 日付フォーマット変換をするメソッドです。 例）20000101 → 2000/01/01
//     * </pre>
//     *
//     * @param val ８桁の日付
//     * @return スラッシュ付き日付
//     * @since 1.0
//     */
//    public static String getToYyyyMmDd(IString val){
//        if( val == null )
//            return "";
//
//        try{
//            // 引数は8バイトであることが前提
//            if(val.toString().length() == 8){
//
//                // フォーマット変換 20000101 → 2000/01/01
//                StringBuffer buf = new StringBuffer(val.toString());
//                buf = buf.insert(6 , '/');
//                buf = buf.insert(4 , '/');
//
//                // IStringに再変換
//                IString tmp = null;
//                tmp = new IString(buf.toString());
//                return chgHTMLEnableStr(tmp.toString());
//            }
//        }catch(Exception e){
//                // 再変換時に例外が発生しても無視
//        }
//        return chgHTMLEnableStr(val.toString());
//    }
//    /**
//     * <pre>
//     * 日付フォーマット変換をするメソッドです。 例）20000101 → 00/01/01
//     * </pre>
//     *
//     * @param val ８桁の日付
//     * @return スラッシュ付き日付
//     * @since 1.0
//     */
//    public static String getToYyMmDd(IString val){
//        if( val == null )
//            return "";
//
//        try{
//            // 引数は8バイトであることが前提
//            if(val.toString().length() == 8){
//
//                // フォーマット変換 20000101 → 2000/01/01
//                StringBuffer buf = new StringBuffer(val.toString());
//                buf = buf.insert(6 , '/');
//                buf = buf.insert(4 , '/');
//
//                // IStringに再変換
//                IString tmp = null;
//                tmp = new IString(buf.toString().substring(2,10)); // yy/mm/ddの場合
//                return chgHTMLEnableStr(tmp.toString());
//            }
//        }catch(Exception e){
//                // 再変換時に例外が発生しても無視
//        }
//        return chgHTMLEnableStr(val.toString());
//    }
//    /**
//     * <pre>
//     * プライベートメソッド
//     * 外部参照はできません。
//     * </pre>
//     * ＨＴＭＬで対応する文字に変換する。<BR>
//     * "<"→"&lt" ">"→"&gt" "&"→"&amp" " "→"&nbsp"に変換する。<BR>
//     * @param String str 変換文字列
//     * @return String 編集した変換文字列（ＨＴＭＬで使用可能）
//     */
//    private static String chgHTMLEnableStr(String str) {
//        String	tmp_str = new String();
//        int	i , j;
//        boolean flg = true;
//        String	str_table[][] = {
//                                    { "<" , "&lt;" },
//                                    { ">" , "&gt;" },
//                                    { "&" , "&amp;" },
//                                    { " " , "&nbsp;"}
//                                };
//        if( str == null ){
//            return null;
//        }
//        for( i = 0 , tmp_str = ""; i < str.length(); i++ ){
//            for( j = 0, flg = true; j < str_table.length; j++ ){
//                if( str.substring( i , (i + 1) ).equals(str_table[j][0]) ){
//                    tmp_str = tmp_str + str_table[j][1];
//                    flg = false;
//                    break;
//                }
//            }
//            if( flg ){
//                tmp_str = tmp_str + str.substring( i , (i + 1) );
//            }
//        }
//        return tmp_str;
//    }
//
//
////add start 2005/04/14 S.Nakamura
//    /**
//     * <pre>
//     * 曜日取得
//     * 年・月・日を指定して、「日・月・火・水・木・金・土」を返します。
//     * </pre>
//     * @param String y 年
//     * @param String m 月
//     * @param String d 日
//     * @return String 曜日
//     */
//    public static final String getYobi(String y, String m, String d)
//        throws JspException{
//
//        String yobi = null;
//        try{
//            ITimestamp day = new ITimestamp(y, m, d);
//            switch(day.getDay()){
//                case 1:
//                    yobi = "日";
//                    break;
//                case 2:
//                    yobi = "月";
//                    break;
//                case 3:
//                    yobi = "火";
//                    break;
//                case 4:
//                    yobi = "水";
//                    break;
//                case 5:
//                    yobi = "木";
//                    break;
//                case 6:
//                    yobi = "金";
//                    break;
//                case 7:
//                    yobi = "土";
//                    break;
//                default:
//                    yobi = "";
//            }
//        }catch(Exception e){
//            throw new JspException("args is not correct "
//                +"(year=" + y + ",month=" + m + ",day=" + d + ")");
//        }
//        return yobi;
//    }
////add end 2005/04/14 S.Nakamura
//
//
//// ******************************************************************
////                  Java系
//// ******************************************************************
//
//// modify start 2006/03/15 S.Nakamura
//// add start 2005/03/14 S.Nakamura
//    /**
//     * <pre>
//     * 半角カナ→全角カナ変換
//     * </pre>
//     * 存在しない濁音（半濁音）は全角カナと全角濁点に変換します。<BR>
//     * 濁音（半濁音）の重複は全角濁音カナと全角濁点に変換します。<BR>
//     * 例：「ｱﾞｶﾞﾞ」→「ア゛ガ゛」<BR>
//     * @param target 対象文字列
//     * @return 変換後文字列
//     * @since 1.29
//     */
//    public static String hKanaToZKana(String target){
//
//        // 変換パターン数
//        final int HKANA_ZKANA_SIZE = 99;
//        // 変換パターン
//        final String[][] HKANA_ZKANA = {
//            {"ｶﾞ","ガ"},
//            {"ｷﾞ","ギ"},
//            {"ｸﾞ","グ"},
//            {"ｹﾞ","ゲ"},
//            {"ｺﾞ","ゴ"},
//            {"ｻﾞ","ザ"},
//            {"ｼﾞ","ジ"},
//            {"ｽﾞ","ズ"},
//            {"ｾﾞ","ゼ"},
//            {"ｿﾞ","ゾ"},
//            {"ﾀﾞ","ダ"},
//            {"ﾁﾞ","ヂ"},
//            {"ﾂﾞ","ヅ"},
//            {"ﾃﾞ","デ"},
//            {"ﾄﾞ","ド"},
//            {"ﾊﾞ","バ"},
//            {"ﾋﾞ","ビ"},
//            {"ﾌﾞ","ブ"},
//            {"ﾍﾞ","ベ"},
//            {"ﾎﾞ","ボ"},
//            {"ｳﾞ","ヴ"},
//            {"ﾊﾟ","パ"},
//            {"ﾋﾟ","ピ"},
//            {"ﾌﾟ","プ"},
//            {"ﾍﾟ","ペ"},
//            {"ﾎﾟ","ポ"},
//            {"ﾞ","゛"},
//            {"ﾟ","゜"},
//            {"ｱ","ア"},
//            {"ｲ","イ"},
//            {"ｳ","ウ"},
//            {"ｴ","エ"},
//            {"ｵ","オ"},
//            {"ｶ","カ"},
//            {"ｷ","キ"},
//            {"ｸ","ク"},
//            {"ｹ","ケ"},
//            {"ｺ","コ"},
//            {"ｻ","サ"},
//            {"ｼ","シ"},
//            {"ｽ","ス"},
//            {"ｾ","セ"},
//            {"ｿ","ソ"},
//            {"ﾀ","タ"},
//            {"ﾁ","チ"},
//            {"ﾂ","ツ"},
//            {"ﾃ","テ"},
//            {"ﾄ","ト"},
//            {"ﾅ","ナ"},
//            {"ﾆ","ニ"},
//            {"ﾇ","ヌ"},
//            {"ﾈ","ネ"},
//            {"ﾉ","ノ"},
//            {"ﾊ","ハ"},
//            {"ﾋ","ヒ"},
//            {"ﾌ","フ"},
//            {"ﾍ","ヘ"},
//            {"ﾎ","ホ"},
//            {"ﾏ","マ"},
//            {"ﾐ","ミ"},
//            {"ﾑ","ム"},
//            {"ﾒ","メ"},
//            {"ﾓ","モ"},
//            {"ﾔ","ヤ"},
//            {"ﾕ","ユ"},
//            {"ﾖ","ヨ"},
//            {"ﾗ","ラ"},
//            {"ﾘ","リ"},
//            {"ﾙ","ル"},
//            {"ﾚ","レ"},
//            {"ﾛ","ロ"},
//            {"ﾜ","ワ"},
//            {"ｦ","ヲ"},
//            {"ﾝ","ン"},
//            {"ｧ","ァ"},
//            {"ｨ","ィ"},
//            {"ｩ","ゥ"},
//            {"ｪ","ェ"},
//            {"ｫ","ォ"},
//            {"ｯ","ッ"},
//            {"ｬ","ャ"},
//            {"ｭ","ュ"},
//            {"ｮ","ョ"},
//            {"0","０"},
//            {"1","１"},
//            {"2","２"},
//            {"3","３"},
//            {"4","４"},
//            {"5","５"},
//            {"6","６"},
//            {"7","７"},
//            {"8","８"},
//            {"9","９"},
//            {"ｰ","ー"},
//            {"･","・"},
//            {"｡","。"},
//            {"､","、"},
//            {"｢","「"},
//            {"｣","」"}
//        };
//
//        return cnvString(target, HKANA_ZKANA, HKANA_ZKANA_SIZE);
//    }
//
//// add start 2006/03/15 S.Nakamura
    /**
     * <pre>
     * 全角カナ→半角カナ変換
     * </pre>
     * @param target 対象文字列
     * @return 変換後文字列
     * @since 1.30
     */
    public static String zKanaToHKana(String target){

        // 変換パターン数
        final int ZKANA_HKANA_SIZE = 99;
        // 変換パターン
        final String[][] ZKANA_HKANA = {
            {"ガ","ｶﾞ"},
            {"ギ","ｷﾞ"},
            {"グ","ｸﾞ"},
            {"ゲ","ｹﾞ"},
            {"ゴ","ｺﾞ"},
            {"ザ","ｻﾞ"},
            {"ジ","ｼﾞ"},
            {"ズ","ｽﾞ"},
            {"ゼ","ｾﾞ"},
            {"ゾ","ｿﾞ"},
            {"ダ","ﾀﾞ"},
            {"ヂ","ﾁﾞ"},
            {"ヅ","ﾂﾞ"},
            {"デ","ﾃﾞ"},
            {"ド","ﾄﾞ"},
            {"バ","ﾊﾞ"},
            {"ビ","ﾋﾞ"},
            {"ブ","ﾌﾞ"},
            {"ベ","ﾍﾞ"},
            {"ボ","ﾎﾞ"},
            {"ヴ","ｳﾞ"},
            {"パ","ﾊﾟ"},
            {"ピ","ﾋﾟ"},
            {"プ","ﾌﾟ"},
            {"ペ","ﾍﾟ"},
            {"ポ","ﾎﾟ"},
            {"゛","ﾞ"},
            {"゜","ﾟ"},
            {"ア","ｱ"},
            {"イ","ｲ"},
            {"ウ","ｳ"},
            {"エ","ｴ"},
            {"オ","ｵ"},
            {"カ","ｶ"},
            {"キ","ｷ"},
            {"ク","ｸ"},
            {"ケ","ｹ"},
            {"コ","ｺ"},
            {"サ","ｻ"},
            {"シ","ｼ"},
            {"ス","ｽ"},
            {"セ","ｾ"},
            {"ソ","ｿ"},
            {"タ","ﾀ"},
            {"チ","ﾁ"},
            {"ツ","ﾂ"},
            {"テ","ﾃ"},
            {"ト","ﾄ"},
            {"ナ","ﾅ"},
            {"ニ","ﾆ"},
            {"ヌ","ﾇ"},
            {"ネ","ﾈ"},
            {"ノ","ﾉ"},
            {"ハ","ﾊ"},
            {"ヒ","ﾋ"},
            {"フ","ﾌ"},
            {"ヘ","ﾍ"},
            {"ホ","ﾎ"},
            {"マ","ﾏ"},
            {"ミ","ﾐ"},
            {"ム","ﾑ"},
            {"メ","ﾒ"},
            {"モ","ﾓ"},
            {"ヤ","ﾔ"},
            {"ユ","ﾕ"},
            {"ヨ","ﾖ"},
            {"ラ","ﾗ"},
            {"リ","ﾘ"},
            {"ル","ﾙ"},
            {"レ","ﾚ"},
            {"ロ","ﾛ"},
            {"ワ","ﾜ"},
            {"ヲ","ｦ"},
            {"ン","ﾝ"},
            {"ァ","ｧ"},
            {"ィ","ｨ"},
            {"ゥ","ｩ"},
            {"ェ","ｪ"},
            {"ォ","ｫ"},
            {"ッ","ｯ"},
            {"ャ","ｬ"},
            {"ュ","ｭ"},
            {"ョ","ｮ"},
            {"ー","ｰ"},
            {"０","0"},
            {"１","1"},
            {"２","2"},
            {"３","3"},
            {"４","4"},
            {"５","5"},
            {"６","6"},
            {"７","7"},
            {"８","8"},
            {"９","9"},
            {"・","･"},
            {"。","｡"},
            {"、","､"},
            {"「","｢"},
            {"」","｣"}
        };

        return cnvString(target, ZKANA_HKANA, ZKANA_HKANA_SIZE);
    }
//
//    /**
//     * 半角カナ→全角カナ変換（引数IStringのオーバーロード）
//     */
//    public static IString hKanaToZKana(IString target) {
//        IString result = null;
//        try {
//            result = new IString(hKanaToZKana(target.toString()));
//        } catch(Exception e) {
//            throw new RuntimeException();
//        }
//        return result;
//    }
//
//    /**
//     * 全角カナ→半角カナ変換（引数IStringのオーバーロード）
//     */
//    public static IString zKanaToHKana(IString target) {
//        IString result = null;
//        try {
//            result = new IString(zKanaToHKana(target.toString()));
//        } catch(Exception e) {
//            throw new RuntimeException();
//        }
//        return result;
//    }
//// add  end  2006/03/15 S.Nakamura
//
    /**
     * <pre>
     * 変換パターン処理
     * </pre>
     * 文字列変換のパターン数だけループします。<BR>
     * @param target 対象文字列
     * @param ptnStr 変換パターン
     * @param ptnStr 変換パターン数
     * @return 変換後文字列
     * @since 1.29
     */
    private static String cnvString(String target, String[][] ptnStr, int ptnSize){
        // 対象文字列の存在チェック
        if (target == null || target.equals("")) {
            return target;
        }
        // パターン数だけループする
        for (int i = 0; i < ptnSize; i++) {
            // 文字列変換処理の呼び出し
            target = StringUtils.replaceString(target, ptnStr[i][0], ptnStr[i][1]);
        }
        return target;
    }
//// add end 2005/03/14 S.Nakamura
//// modify  end  2006/03/15 S.Nakamura
//
//    /**
//     * <pre>
//     * 新規登録(INSERT)処理のタイプ
//     * </pre>
//     *
//     * @since 1.0
//     */
//    public static final int INSERT = 1;
//    /**
//     * <pre>
//     * 更新(UPDATE)処理のタイプ
//     * </pre>
//     *
//     * @since 1.0
//     */
//    public static final int UPDATE = 2;
//    /**
//     * <pre>
//     * 削除(DELETE)処理のタイプ
//     * </pre>
//     *
//     * @since 1.0
//     */
//    public static final int DELETE = 3;
//
//    /**
//     * 前後スペースを除去する。<BR>
//     * trim()で削除出来ない全角の前後スペースを除去する。
//     * @param String str 処理する文字列
//     * @return String 処理した文字列
//     */
//    public static String powerTrim(String str) throws Exception {
//
//        String sTemp = str;
//
//        //空白削除
//        if (sTemp.length() > 0) {
//            sTemp = sTemp.trim();
//
//            //前全角スペース削除
//            while (sTemp.length() > 0) {
//                if (sTemp.indexOf('　') == 0) {
//                    sTemp = sTemp.substring(1, sTemp.length());
//                } else {
//                    break;
//                }
//            }
//
//            //後全角スペース削除
//            while (sTemp.length() > 0) {
//                if (sTemp.lastIndexOf('　') == sTemp.length() - 1) {
//                    sTemp = sTemp.substring(0, sTemp.length() - 1);
//                } else {
//                    break;
//                }
//            }
//        }
//        return sTemp.trim();
//    }
//
//    /**
//     * <pre>
//     * 排他チェックを簡易に行うメソッドです。
//     * エラーが有る時はバケツにエラーコードをセットします。
//     * ★使用例
//     *  validate(data,update,AppMethods.INSERT)で新規登録時の排他チェックを行います。
//     *  validate(data,update,AppMethods.UPDATE)で更新時の排他チェックを行います。
//     *  validate(data,update,AppMethods.DELETE)で削除処理の排他チェックを行います。
//     * <font color="red" size="3">
//     * <b>
//     * ★注意
//     *  第一引数の data は必ず jp.co.takeda.maps.data.TableData を継承していなければいけません。
//     * </b>
//     * </font>
//     * </pre>
//     *
//     * @param data TableDataのサブクラス
//     * @param upDate ITimestampロック時に取得したタイムスタンプ
//     * @param this.properties INSERT or UPDATE or DELETE
//     * @thorws InternalException data が null の時発生
//     */
//    public static void validate(TableData data,ITimestamp update,Bucket bucket,int validateType) throws InternalException {
//        if(data == null) throw new InternalException("validate base data is null");
//
//        switch(validateType){
//            case 1:
//                if(update != null){
//                    // 一意制約に反しているためエラー
//                    bucket.add("M0001003");
//                }
//                break;
//            case 2:case 3:
//                // 更新,削除
//                if(update != null){
//                    ITimestamp dateUpDate = data.getUpDate();
//
//                    // ここの比較式要相談
//                    if(dateUpDate.longValue() != update.longValue()){
//                        // 更新日付が違うためエラー
//                        bucket.add("M0001102");//「他のユーザによって変更されています。」
//                    }
//                }else{
//                    // データが存在しないためエラー
//                    bucket.add("M0001103");//「他のユーザによって削除されています。」
//                }
//                break;
//            default:
//                throw new IllegalStateException("does not exists validateType : " + validateType);
//        }
//    }
//    /**
//     * <pre>
//     * 排他チェックを簡易に行うメソッドです。[配列版]
//     * エラーが有る時はバケツにエラーコードをセットします。
//     * ★使用例
//     *  validate(data,update,AppMethods.INSERT)で新規登録時の排他チェックを行います。
//     *  validate(data,update,AppMethods.UPDATE)で更新時の排他チェックを行います。
//     *  validate(data,update,AppMethods.DELETE)で削除処理の排他チェックを行います。
//     * <font color="red" size="3">
//     * <b>
//     * ★注意
//     *  第一引数の data は必ず jp.co.takeda.maps.data.TableData を継承していなければいけません。
//     * </b>
//     * </font>
//     * </pre>
//     *
//     * @param data[] TableDataのサブクラス配列
//     * @param upDate[] ITimestampロック時に取得したタイムスタンプ配列
//     * @param this.properties INSERT or UPDATE or DELETE
//     */
//    public static void validate(TableData[] data,ITimestamp[] update,Bucket bucket,int validateType) throws InternalException {
//        if(data == null) throw new InternalException("validate base data is null");
//
//        switch(validateType){
//            case INSERT:
//                if(update != null){
//                    // 一意制約に反しているためエラー
//                    bucket.add("M0001003");
//                }
//                break;
//            case UPDATE:case DELETE:
//                if(update != null){
//                    if(data.length == update.length){
//                        for(int i = 0;i < data.length;i++){
//                            validate(data[i],update[i],bucket,validateType);
//                            if(!bucket.isEmpty()){
//                                break;
//                            }
//                        }
//                    }else{
//                        // 配列の個数が一致しないためエラー
//                        bucket.add("M0001102");//「他のユーザによって削除されています。」
//                        break;
//                    }
//                }else{
//                    // データが存在しないためエラー
//                    bucket.add("M0001103");//「他のユーザによって削除されています。」
//                }
//                break;
//            default:
//                throw new IllegalStateException("does not exists validateType : " + validateType);
//        }
//    }
//    /**
//     * <pre>
//     * commandResultListからデータを取得する際に使用するメソッドです。
//     * ★注意
//     * 　[[data],[java.sql.connection]]の時のようにデータが一つしか存在しない場合のみ使用できるメソッドです。
//     * 　リスト内のデータが一つ以上のときエラーを返します。(RunntimeError)
//     * </pre>
//     *
//     * @param leo LEO
//     * @param commandResultList
//     * @param findClass 取得するクラス名
//     * @param remove リストから削除するかのフラグ
//     * @return Object - 探し出したオブジェクト
//     */
//    public static Object findOnlyObject(LogicExecuteObject leo,Collection commandResultList,Class findClass,boolean remove){
//        ArrayList dataList = (ArrayList)leo.findObject((ArrayList)commandResultList,ArrayList.class,remove);
//
//        if(dataList != null){
//            if(dataList.size() > 1){
//                throw new java.lang.IllegalArgumentException("list in objects is not only");
//            }
//        }
//
//        return leo.findObject(dataList,findClass,remove);
//    }
//    /**
//     * <pre>
//     * findOnlyObjectのラッパーメソッドです。
//     * リストからオブジェクトの削除は行いません。
//     * </pre>
//     *
//     * @param leo LEO
//     * @param commandResultList
//     * @param findClass 取得するクラス名
//     * @return Object - 探し出したオブジェクト
//     */
//    public static Object findOnlyObject(LogicExecuteObject leo,Collection commandResultList,Class findClass) {
//        return findOnlyObject(leo,commandResultList,findClass,false);
//    }
//    /**
//     * <pre>
//     * コネクションチェック
//     * </pre>
//     *
//     * @param conn java.sql.Connection
//     * @param Log private log
//     * @param loginData private loginData
//     * @throws InternalException
//     */
//    public static void existsConnection(java.sql.Connection conn,Log log,LoginData loginData) throws InternalException {
//        if(conn == null){
//            InternalException ie = new InternalException("database not connected");
//            log.write("E0070001",loginData.getUserId(),loginData.getScreenId(),loginData.getFunctionId(),ie);
//            throw ie;
//        }
//    }
//    /**
//     * <pre>
//     * Oracleからのエラーを取得し、そのエラーがレコードロックもしくはテーブルロックの時は
//     * Bucketに"M0001101"をセットする。
//     * それ以外の例外発生時はエラーをthrowする。
//     * </pre>
//     *
//     * @param LEO LogicExecuteObject
//     * @param commandResultList コマンドの結果
//     * @param log Log
//     * @param loginData LoginData
//     * @param process どういう処理中だったかの文字列 insert etc...
//     * @param commandName commandResultListを返したコマンド名
//     * @param bucket Bucket
//     * @return boolean - rock_error true : non_error false
//     * @throws Exception
//     */
//    public static boolean rockCheck(LogicExecuteObject LEO,Collection commandResultList,Log log,LoginData loginData,String process,String commandName,Bucket bucket) throws Exception {
//        Exception sqle = LEO.findException((ArrayList)commandResultList);
//
//        if(loginData == null){
//            loginData = new LoginData();
//        }
//
//        // ロックエラー時
//        if( sqle != null ){
//            int sqlCode = OracleUtils.checkOracleCode(sqle,log,loginData,process,commandName);
//
//            if(sqlCode == OracleUtils.ORA_ROWLOCK_ERROR){
//                bucket.add("M0001101");//「他のユーザによって使用されています。」
//                return true;
//            } else {
//                // 他のエラーの場合はエラーを起こす
//                throw sqle;
//            }
//        }
//
//        return false;
//    }
//    /**
//     * <pre>
//     * Exception の検索およびBucketにエラーのセットを行うメソッドです。
//     * </pre>
//     * @param commandResultList コマンド処理結果リスト
//     * @param bucket バケット
//     * @param commandName 実行コマンドクラス名
//     */
//    public static void throwException(LogicExecuteObject LEO,Collection commandResultList,Log log,Bucket bucket,String commandName) throws Exception{
//        Exception e = LEO.findException((ArrayList)commandResultList);
//
//        int sqlCode = 0;
//        if( e != null ){
//            sqlCode = OracleUtils.checkOracleCode(e,log,new LoginData(),"",commandName);
//            bucket.add("E0000000");
//            throw e;
//        }
//    }
//    /**
//     * <pre>
//     * システムエラー画面への遷移処理
//     * </pre>
//     *
//     * @param status ステータス
//     * @param MESSAGE_CREATER ApplicationMessageConcreteCreater
//     */
//    public static ArrayList setBucketError(ArrayList resultList,Status status,Creater MESSAGE_CREATER){
//        status.setCode("S0090000"); //バケツエラーとして処理を終了する。
//
//        //ホームへ戻るリンクの生成
//        HtmlLink htmlLink = (HtmlLink)MESSAGE_CREATER.create("HtmlLink");
//        htmlLink.setHomeLink(true);
//        resultList.add(htmlLink);
//
//        return resultList;
//    }
//// ******************************************************************
////                  HttpServletRequest 取得系
//// ******************************************************************
//    /**
//     * <pre>
//     * HttpServletRequestよりIInteger配列を取得する際に使用するメソッドです。
//     * </pre>
//     *
//     * @param request HttpServletRequest
//     * @param param 取得するHTMLオブジェクト配列
//     * @throws Exception
//     */
//    public static IInteger[] toIIntegers(HttpServletRequest request,String param) throws Exception {
//        String[] params = request.getParameterValues(param);
//        IInteger[] reParams = new IInteger[params.length - 1];
//
//        for(int i = 1;i < params.length;i++){
//            if(!params[i].equals("")){
//                reParams[i - 1] = new IInteger(params[i]);
//            }else{
//                reParams[i - 1] = null;
//            }
//        }
//
//        return reParams;
//    }
//    /**
//     * <pre>
//     * HttpServletRequestよりLong配列を取得する際に使用するメソッドです。
//     * </pre>
//     *
//     * @param request HttpServletRequest
//     * @param param 取得するHTMLオブジェクト配列
//     * @throws Exception
//     */
//    public static long[] toLongs(HttpServletRequest request,String param) throws Exception {
//        String[] params = request.getParameterValues(param);
//        long[] reParams = new long[params.length - 1];
//
//        for(int i = 1;i < params.length;i++){
//            if(!params[i].equals("")){
//                reParams[i - 1] = Long.parseLong(params[i],10);
//            }else{
//                reParams[i - 1] = 0;
//            }
//        }
//
//        return reParams;
//    }
//// ******************************************************************
////                  ResultSet 取得系
//// ******************************************************************
//    /**
//     * <pre>
//     * ItemResultSetのgetItem(int,Object)の簡易メソッド
//     * </pre>
//     *
//     * @param rs ItemResultSet
//     * @param index 指標
//     * @param Createre ITEM_CREATER
//     * @return IString
//     * @throws Exception
//     */
//    public IString getIString(ItemResultSet rs,int index,Creater creater) throws Exception {
//        return rs.getItem(index,(IString)creater.create("IString"));
//    }
//    /**
//     * <pre>
//     * ItemResultSetのgetItem(int,Object)の簡易メソッド
//     * </pre>
//     *
//     * @param rs ItemResultSet
//     * @param index 指標
//     * @param Createre ITEM_CREATER
//     * @return IInteger
//     * @throws Exception
//     */
//    public IInteger getIInteger(ItemResultSet rs,int index,Creater creater) throws Exception {
//        return rs.getItem(index,(IInteger)creater.create("IInteger"));
//    }
//    /**
//     * <pre>
//     * ItemResultSetのgetItem(int,Object)の簡易メソッド
//     * </pre>
//     *
//     * @param rs ItemResultSet
//     * @param index 指標
//     * @param Createre ITEM_CREATER
//     * @return ITimestamp
//     * @throws Exception
//     */
//    public ITimestamp getITimestamp(ItemResultSet rs,int index,Creater creater) throws Exception {
//        return rs.getItem(index,(ITimestamp)creater.create("ITimestamp"));
//    }
//    /**
//     * <pre>
//     * ItemResultSetのgetItem(int,Object)の簡易メソッド
//     * </pre>
//     *
//     * @param rs ItemResultSet
//     * @param index 指標
//     * @param Createre ITEM_CREATER
//     * @return IString
//     * @throws Exception
//     */
//    public IString getClob(ItemResultSet rs,int index,Creater creater) throws Exception {
//        IString clobStr = (IString)creater.create("IString");
//        clobStr.setClob(true);
//        return rs.getItem(index,clobStr);
//    }
//    /**
//     * <pre>
//     * Blob取得メソッド
//     * </pre>
//     *
//     * @param rs ItemResultSet
//     * @param index 指標
//     * @return BlobStorage
//     * @throws Exception
//     */
//    public BlobStorage getBlob(ItemResultSet rs,int index) throws Exception {
//        BlobStorage blob =  LobUtils.createBlobStorage();
///* 2013/04/24 modify start T.Yoshida J13-0005
//        LobUtils.getBlob(blob,(rs.getOracleResultSet()).getBLOB(index)); */
//        LobUtils.getBlob(blob,rs.getBlob(index));
///* 2013/04/24 modify end T.Yoshida J13-0005 */
//        return blob;
//    }
//
//// ******************************************************************
////                  ログ出力系
//// ******************************************************************
//    /**
//     * <pre>
//     * デバックログ出力簡易メソッドです。
//     * </pre>
//     *
//     * @param Log ログ
//     * @param logCode "D0000002"など
//     * @param debugMessage
//     */
//    public static void debug(Log log,String logCode,String message1,String message2,String paramMessage){
//        if(log.isDebugEnabled()){
//            if(message2 == null && paramMessage == null){
//                log.write(logCode,message1);
//            }else if(message2 != null && paramMessage == null){
//                log.write(logCode,message1,message2);
//            }else{
//                log.write(logCode,message1,message2,paramMessage);
//            }
//        }
//    }
//    /**
//     * <pre>
//     * デバックログ出力簡易メソッドのラッパーメソッドです。
//     * </pre>
//     *
//     * @param Log
//     */
//    public static void debug(Log log,String logCode,String debugMessage,LoginData loginData){
//        debug(log,logCode,debugMessage,loginData.getLogMessage(),null);
//    }
//
//    /**
//     * <pre>
//     * デバックコード "D0000002"
//     * </pre>
//     */
//    public static final String LOG_D2 = "D0000002";
//    /**
//     * <pre>
//     * デバックログ出力簡易メソッドのラッパーメソッドです。
//     * </pre>
//     *
//     * @param Log
//     */
//    public static void debugStart(Log log,String debugMessage,String message2,String paramMessage){
//        if(message2 != null){
//            if(message2.equals("")){
//                message2 = null;
//            }
//        }
//        debug(log,LOG_D2,debugMessage,message2,paramMessage);
//    }
//    /**
//     * <pre>
//     * デバックログ出力簡易メソッドのラッパーメソッドです。
//     * </pre>
//     *
//     * @param Log
//     */
//    public static void debugStart(Log log,String debugMessage,String message2){
//        debugStart(log,debugMessage,message2,null);
//    }
//    /**
//     * <pre>
//     * デバックログ出力簡易メソッドのラッパーメソッドです。
//     * </pre>
//     *
//     * @param Log
//     */
//    public static void debugStart(Log log,String debugMessage,LoginData loginData,String paramMessage){
//        debugStart(log,debugMessage,loginData.getLogMessage(),paramMessage);
//    }
//    /**
//     * <pre>
//     * デバックログ出力簡易メソッドのラッパーメソッドです。
//     * </pre>
//     *
//     * @param Log
//     */
//    public static void debugStart(Log log,String debugMessage,LoginData loginData){
//        debugStart(log,debugMessage,loginData.getLogMessage(),null);
//    }
//    /**
//     * <pre>
//     * デバックログ出力簡易メソッドのラッパーメソッドです。
//     * </pre>
//     *
//     * @param Log
//     */
//    public static void debugStart(Log log,String debugMessage){
//        debugStart(log,debugMessage,"",null);
//    }
//
//    /**
//     * <pre>
//     * デバックコード "D0000003"
//     * </pre>
//     */
//    public static final String LOG_D3 = "D0000003";
//    /**
//     * <pre>
//     * デバックログ出力簡易メソッドのラッパーメソッドです。
//     * </pre>
//     *
//     * @param Log
//     */
//    public static void debugEnd(Log log,String debugMessage,String message2,String paramMessage){
//        if(message2 != null){
//            if(message2.equals("")){
//                message2 = null;
//            }
//        }
//        debug(log,LOG_D3,debugMessage,message2,paramMessage);
//    }
//    /**
//     * <pre>
//     * デバックログ出力簡易メソッドのラッパーメソッドです。
//     * </pre>
//     *
//     * @param Log
//     */
//    public static void debugEnd(Log log,String debugMessage,String message2){
//        debugEnd(log,debugMessage,message2,null);
//    }
//    /**
//     * <pre>
//     * デバックログ出力簡易メソッドのラッパーメソッドです。
//     * </pre>
//     *
//     * @param Log
//     */
//    public static void debugEnd(Log log,String debugMessage,LoginData loginData,String paramMessage){
//        debugEnd(log,debugMessage,loginData.getLogMessage(),paramMessage);
//    }
//    /**
//     * <pre>
//     * デバックログ出力簡易メソッドのラッパーメソッドです。
//     * </pre>
//     *
//     * @param Log
//     */
//    public static void debugEnd(Log log,String debugMessage,LoginData loginData){
//        debugEnd(log,debugMessage,loginData.getLogMessage(),null);
//    }
//    /**
//     * <pre>
//     * デバックログ出力簡易メソッドのラッパーメソッドです。
//     * </pre>
//     *
//     * @param Log
//     */
//    public static void debugEnd(Log log,String debugMessage){
//        debugEnd(log,debugMessage,"",null);
//    }
    /**
    * <pre>
    * オブジェクトのフィールド値を取得する  
    * </pre>
    *
    * @param bean 取得する対象となるオブジェクト 
    * @param fieldName フィールド名
    */
    public static String reflectValue(Object bean, String fieldName) {
        String rtn = "";
        Class<?> temp = bean.getClass();
        try {
            String methodName = "get" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1, fieldName.length());
            Method method = temp.getMethod(methodName); 
            Object value = method.invoke(bean);
            if (value != null) {
                if (value instanceof java.util.Date) {
                    if (fieldName.startsWith("tekiyoYmd")) {
                        rtn = DateUtils.dateToString((java.util.Date) value);
                    } else if (fieldName.startsWith("upDate")) {
                        rtn = DateUtils.parseDateTime2((java.util.Date) value);
                    } else {
                        rtn = value.toString();
                    }
                } else {
                    rtn = value.toString();
                }
            }
            
        } catch (SecurityException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        
        return rtn;
    }

    /**
    * <pre>
    * オブジェクトのフィールド値を設定する （オブジェクトから）
    * </pre>
    *
    * @param setBean 対象となるオブジェクト 
    * @param fromBean 取得する対象となるオブジェクト 
    * @param fieldName フィールド名
    */
    public static void reflectSet(Object setBean, Object fromBean, String fieldName) {
        Class<?> temp = setBean.getClass();
        try {
            String methodName = "set" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1, fieldName.length());
            Method method = temp.getMethod(methodName, String.class); 
            String value = reflectValue(fromBean, fieldName);
            method.invoke(setBean, value);
        } catch (SecurityException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
    }

    /**
    * <pre>
    * オブジェクトのフィールド値を設定する(値設定）  
    * </pre>
    *
    * @param setBean 対象となるオブジェクト 
    * @param fromBean 取得する対象となるオブジェクト 
    * @param fieldName フィールド名
    */
    public static void reflectSetByValue(Object setBean, String fieldName, String value) {
        Class<?> temp = setBean.getClass();
        try {
            String methodName = "set" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1, fieldName.length());
            Method method = temp.getMethod(methodName, String.class); 
            method.invoke(setBean, value);
        } catch (SecurityException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
    }
}
