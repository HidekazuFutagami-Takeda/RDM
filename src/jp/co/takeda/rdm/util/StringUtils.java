package jp.co.takeda.rdm.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Hashtable;
import java.util.StringTokenizer;

/**
 * <pre>
 * 文字列操作関数 - 文字列に関する共通関数です。
 * 取り敢えずはecpoのソースのまま、後々不要なものは消し、必要なものは付け足す
 *
 * 補足：このクラスは全てスタティックなメソッドでありクラスをインスタンスして使用する必要はない。
 * </pre>
 *
 * @author
 * @version 0
 */
public class StringUtils {

    /**
     * <pre>
     * 入力用の文字コード － システム入力時の文字コードです。
     * </pre>
     *
     * @since 0.0.0
     */
    public static final String STRING_INPUT_CODE = "MS932";

    /**
     * <pre>
     * 出力用の文字コード － システム出力時の文字コードです。
     * </pre>
     *
     * @since 0.0.0
     */
    public static final String STRING_OUTPUT_CODE = "MS932";

    /**
     * <pre>
     * 内部用文字コード － 内部用文字コードです。
     * </pre>
     *
     * @since 0.0.2
     */
    public static final String STRING_DEFAULT_CODE = "ISO8859_1";

    /**
     * 半角カナチェック用文字列
     */
    private static final String SINGLEBYTE_KANA = "ｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜｦﾝｧｨｩｪｫｯ､｡･ﾞﾟ";
    private static final String MULTIBYTE_KANA = "アイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワヲンァィゥェォッ、。・゛゜";
    //private static final String MULTIEBYTE_KANA_V = "ガギグゲゴザジズゼゾダヂヅデドバビブベボパピプペポ";

    private static final String SINGLEBYTE_KANA_D = "ｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾊﾋﾌﾍﾎ";
    private static final String MULTIBYTE_KANA_D = "ガギグゲゴザジズゼゾダヂヅデドバビブベボ";
    private static final String SINGLEBYTE_KANA_H = "ﾊﾋﾌﾍﾎ";
    private static final String MULTIBYTE_KANA_H = "パピプペポ";
    private static final char SINGLEBYTE_KANA_DAKUTEN = 'ﾞ';
    private static final char MULTIBYTE_KANA_DAKUTEN = '゛';
    private static final char SINGLEBYTE_KANA_HANDAKUTEN = 'ﾟ';
    private static final char MULTIBYTE_KANA_HANDAKUTEN = '゜';
    private static final String SINGLEBYTE_SYMBOLS = " !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
    private static final String MULTIBYTE_SYMBOLS = "　！”＃＄％＆’（）＊＋，－．／：；＜＝＞？＠［￥］＾＿‘｛｜｝～";

    private static final int offsetA = 'Ａ' - 'A';
    private static final int offseta = 'ａ' - 'a';
    private static final int offset0 = '０' - '0';
    /**
     * 1byte文字チェック用文字列
     */
    //2019.04.22 ログインID有効文字不具合対応_START
    //private static final String SINGLEBYTE_CHAR = "!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUZWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
    private static final String SINGLEBYTE_CHAR = "!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
    //2019.04.22 ログインID有効文字不具合対応_END
    /**
     * 1byte文字チェック用文字列(半角カナ含む)
     */
    private static final String SINGLEBYTE_CHAR_KANA = SINGLEBYTE_CHAR
            + SINGLEBYTE_KANA;

    /**
     * <pre>
     *  文字列検索 － 指定の文字列から指定の文字列を検索します。
     * </pre>
     *
     * @since 0.0.4
     * @param source
     *            :String 検索を行う文字列
     * @param sTarget
     *            :String 検索の対象となる文字列
     * @return boolean 検索結果(true=検索対象文字列あり、false=検索対象文字列なし)
     */
    public static boolean findStringbyTarget(String source, String sTarget) {
        if (source.indexOf(sTarget) != -1) { // 見つかったとき
            return true;
        }
        return false;
    }

    /**
     * <pre>
     *  文字列を置換する。
     * </pre>
     *
     * @since 0.0.0
     * @param String
     *            :sOrgStr 置換する前の文字列
     * @param String
     *            :sTargetStr 置換対象文字列
     * @param String
     *            :sReplaceStr 置換文字列
     * @return String 置換した後の文字列
     */
    public static String replaceString(String source, String sTarget,
            String sReplace) {

        int nIndex;
        int nFrom = 0;
        StringBuffer sbTemp = new StringBuffer(source);

        while ((nIndex = sbTemp.toString().indexOf(sTarget, nFrom)) != -1) {
            sbTemp.replace(nIndex, nIndex + sTarget.length(), sReplace);
            nFrom = nIndex + sReplace.length();
        }

        return sbTemp.toString();
    }

    /**
     * <pre>
     *  文字列を置換する。
     * </pre>
     *
     * @param StringBuffer
     *            :source 置換する前の文字列
     * @param String
     *            :sTarget 置換対象文字列
     * @param String
     *            :sReplace 置換文字列
     * @return StringBuffer 置換した後の文字列
     * @since 1.0
     */
    public static StringBuffer replaceString(StringBuffer source,
            String sTarget, String sReplace) {

        int nIndex;
        int nFrom = 0;
        // StringBuffer sbTemp = new StringBuffer(source);

        while ((nIndex = source.toString().indexOf(sTarget, nFrom)) != -1) {
            source.replace(nIndex, nIndex + sTarget.length(), sReplace);
            nFrom = nIndex + sReplace.length();
        }

        return source;
    }

    /**
     * <pre>
     * Unicodeチェック - Unicodeで扱えない文字列がないかをチェック
     * 制御文字が存在する場合に処理結果をfalseにする(改行文字は制御文字)
     * </pre>
     *
     * @since 0.0.3
     * @param String
     *            s: チェックする文字列
     * @return boolean 処理結果(trueなら問題なし)
     */
    public static boolean isUnicode(String s) {
        return isUnicode(s, true);
    }

    /**
     * <pre>
     * Unicodeチェック - Unicodeで扱えない文字列がないかをチェック
     * </pre>
     *
     * @since 0.0.3
     * @param source
     *            :String チェックする文字列
     * @param bISOControl
     *            :boolean 制御文字のチェックを行うかどうかのフラグ true :制御文字が存在する場合に処理結果をfalseにする
     *            false:制御文字が存在する場合でも処理結果をtrueにする
     * @return boolean 処理結果(trueなら問題なし)
     */
    public static boolean isUnicode(String source, boolean bISOControl) {

        for (int i = 0; i < source.length(); i++) {
            // 無効な文字列チェック
            if (!Character.isDefined(source.charAt(i))) {
                return false;
            }

            // 制御文字チェック
            if (Character.isISOControl(source.charAt(i))) {
                if (bISOControl) {
                    return false;
                }
            }
        }

        // 無効な文字列が見つからなかったのでtrue
        return true;
    }

    /**
     * <pre>
     * Unicodeチェック - Unicodeで扱えない文字列がないかをチェック
     * 推奨されないメソッド isUnicodeを使用する
     * </pre>
     */
    public static boolean checkUnicode(String source, boolean bISOControl) {
        return isUnicode(source, bISOControl);
    }

    /**
     * <pre>
     * マルチバイトチェック - SJISやEUCでのマルチバイト文字をチェック
     *
     * 機能：主な目的としては半角だけのところでマルチバイトが含まれないかをチェック用
     * </pre>
     *
     * @since 0.0.1
     * @param source
     *            :String チェックする文字列
     * @return boolean 処理結果(trueならマルチバイトあり)
     */
    public static boolean checkMultiByte(String source) {
        // return (source.getBytes().length != source.length());
        // シングルバイト(半角カナ含まず:半角カナがあっても処理結果はtrue)かどうかをチェック
        return !isSingleByte(source, true);
    }

    /**
     * <pre>
     * マルチバイトチェック - SJISやEUCでのマルチバイト文字のみ含まれるかどうかのチェック
     *
     * 機能：引数で指定された文字列がマルチバイト文字のみを含むことをチェックする。
     * </pre>
     *
     * @since 0.0.1
     * @param String
     *            source:チェックする文字列
     * @return boolean 処理結果 true:有効 false:無効
     */
    public static boolean isMultiByte(String source) {
        // シングルバイト文字(半角カナ含む)が含まれないかをチェックし
        // 含まれていればfalseとする。
        return !checkSingleByte(source, true);
    }

    /**
     * <pre>
     * 実際の文字数取得 - SJISやEUCでの文字数を返す。
     * 推奨されないメソッド getByteLengthを使用する
     */
    public static int lengthMultiByte(String source) {
        return getByteLength(source);
    }

    /**
     * <pre>
     * 実際の文字数取得 - SJISやEUCでの文字数を返す。
     *
     * 機能：データベースでの文字数をチェックするのに使用
     * </pre>
     *
     * @since 0.0.1
     * @param source
     *            :String 取得する文字列
     * @return int 処理結果
     */
    public static int getByteLength(String source) {
        return source.getBytes().length;
    }

    /**
     * <pre>
     * 数字の桁数取得
     * 機能：整数部と小数部を足し合わせた桁数取得する
     * </pre>
     *
     * @param number
     *            取得する文字列
     * @return int - 整数部と小数部を足し合わせた桁数
     * @since 1.0
     */
    public static int getDigit(String number) {
        // if(log.isDebugEnabled())log.write("D0000000","number = " + number);
        int numberLength = number.length();
        // if(log.isDebugEnabled())log.write("D0000000","numberLength = " +
        // numberLength);
        if (number.indexOf(".") != -1) {
            numberLength--;
        }
        if (number.indexOf("-") != -1) {
            numberLength--;
        }
        return numberLength;
    }

    /**
     * <pre>
     * シングルバイトチェック - シングルバイト文字をチェック
     *
     * 機能：主な目的としては全角だけのところでシングルバイトが含まれないかをチェック用
     *      但し、半角カナをシングルバイト文字としてチェックする
     * </pre>
     *
     * @since 0.0.1
     * @param String
     *            source:チェックする文字列
     * @return boolean 処理結果 true:シングルバイトあり false:シングルバイトなし
     */
    public static boolean checkSingleByte(String source) {
        return checkSingleByte(source, true);
    }

    /**
     * <pre>
     * シングルバイトチェック - シングルバイト文字をチェック
     *
     * 機能：主な目的としては全角だけのところでシングルバイトが含まれないかをチェック用
     * </pre>
     *
     * @since 0.0.1
     * @param String
     *            source:チェックする文字列
     * @param boolean kana:半角カナを有効とするかどうか true:半角カナをシングルバイト文字としてチェックする
     * @return boolean 処理結果 true:シングルバイトあり false:シングルバイトなし
     */
    public static boolean checkSingleByte(String source, boolean kana) {
        String check = (kana ? SINGLEBYTE_CHAR_KANA : SINGLEBYTE_CHAR);
        for (int i = 0; i < source.length(); i++) {
            if (check.indexOf(source.charAt(i)) != -1) {
                // シングルバイト文字が存在すればtrue
                return true;
            }
        }
        return false;
    }

    /**
     * <pre>
     * シングルバイトチェック - シングルバイト文字のみ含まれるかどうかのチェック
     *
     * 機能：引数で指定された文字列がシングルバイト文字のみを含むことをチェックする。
     *      但し、半角カナ文字を除く
     * </pre>
     *
     * @since 0.0.1
     * @param String
     *            s:チェックする文字列
     * @return boolean 処理結果 true:有効 false:無効
     */
    public static boolean isSingleByte(String s) {
        // 半角カナは含まない
        return isSingleByte(s, false);
    }

    /**
     * <pre>
     * シングルバイトチェック - シングルバイト文字のみ含まれるかどうかのチェック
     *
     * 機能：引数で指定された文字列がシングルバイト文字のみを含むことをチェックする。
     *      半角カナ文字を有効とする場合は、引数にtrueを設定する
     * </pre>
     *
     * @since 0.0.2
     * @param String
     *            s:チェックする文字列
     * @param boolean kana:半角カナを有効とするかどうか true:有効とする false:無効とする
     * @return boolean 処理結果 true:有効 false:無効
     */
    public static boolean isSingleByte(String s, boolean kana) {
        return (isValidString(s,
                (kana ? SINGLEBYTE_CHAR_KANA : SINGLEBYTE_CHAR)));
    }

    /**
     * <pre>
     * 有効文字チェック - 文字列が指定された有効文字かをチェック
     *
     * 機能：引数で指定された文字以外が含まれないかをチェックする。
     * </pre>
     *
     * @since 0.0.1
     * @param s
     *            :String チェックする文字列
     * @param v
     *            :String 有効文字列
     * @return boolean 処理結果 true:有効 false:無効
     */
    public static boolean isValidString(String s, String v) {
        for (int i = 0; i < s.length(); i++) {
            if (v.indexOf(s.charAt(i)) == -1) {
                // 有効文字でなければfalse
                return false;
            }
        }
        return true;
    }

    /**
     * <pre>
     * 有効文字チェック - 文字列が指定された有効文字かをチェック
     *
     * 機能：引数で指定された文字が含まれないかをチェックします。
     *      HTMLの禁止タグのチェックを行います。
     * </pre>
     *
     * @since 1.0
     * @param s
     *            :String チェックする文字列
     * @param v
     *            :String[] 無効文字列
     * @return boolean 処理結果 true:有効 false:無効
     */
    public static boolean isValidString(String s, String[] v) {
        for (int i = 0; i < v.length; i++) {
            if (s.indexOf(v[i]) != -1) {
                // 無効文字列が存在すればfalse
                return false;
            }
        }
        return true;
    }

    /**
     * <pre>
     * 英字チェック - 英字(大文字小文字含む)のみ含まれるかどうかのチェック
     *
     * 機能：引数で指定された文字列が英字(大文字小文字含む)のみを含むことをチェックする。
     * </pre>
     *
     * @since 0.0.1
     * @param s
     *            :String チェックする文字列
     * @return boolean 処理結果 true:有効 false:無効
     */
    public static boolean isAlphabet(String s) {
        // 'A'～'Z' 'a'～'z'
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (!(('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z'))) {
                // 英字でなければfalse
                return false;
            }
        }
        return true;
    }

    /**
     * <pre>
     * 英字全角チェック - 英字全角(大文字小文字含む)のみ含まれるかどうかのチェック
     *
     * 機能：引数で指定された文字列が英字全角(大文字小文字含む)のみを含むことをチェックする。
     * </pre>
     *
     * @since 0.0.1
     * @param s
     *            :String チェックする文字列
     * @return boolean 処理結果 true:有効 false:無効
     */
    public static boolean isMultiByteAlphabet(String s) {
        // 'Ａ'～'Ｚ' 'ａ'～'ｚ'
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (!(('Ａ' <= c && c <= 'Ｚ') || ('ａ' <= c && c <= 'ｚ'))) {
                // 英字でなければfalse
                return false;
            }
        }
        return true;
    }

    /**
     * <pre>
     * 整数数値文字チェック - 数字及びプラス,マイナス,カンマのみ含まれるかどうかのチェック
     *
     * 機能：引数で指定された文字列が整数数値文字のみを含むことをチェックする。
     * 補足：String#trimで両端のスペースを取り除いてからチェックして下さい。
     * </pre>
     *
     * @since 0.0.1
     * @param s
     *            :String チェックする文字列
     * @return boolean 処理結果 true:有効 false:無効
     */
    public static boolean isInteger(String s) {
        // '0'～'9' ',' '+' '-'
        char c;
        int j = 0;
        // スペース取り除き
        // s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '+' || c == '-') {
                // +か-記号は頭のみ
                if (i > 0) {
                    return false;
                }
                ;
            } else if ('0' <= c && c <= '9') {
                j++;
            } else if (c == ',') {
                // カンマはどこにあっても取り敢えずOKとする。
            } else {
                // 妥当な文字でなければfalse
                return false;
            }
        }
        // 数字が一つもなければ無効
        if (j <= 0) {
            return false;
        }
        return true;
    }

    /**
     * <pre>
     * 実数数値文字チェック - 数字及びプラス,マイナス,カンマ,ピリオドのみ含まれるかどうかのチェック
     *
     * 機能：引数で指定された文字列が実数数値文字のみを含むことをチェックする。
     * 補足：String#trimで両端のスペースを取り除いてからチェックして下さい。
     * </pre>
     *
     * @since 0.0.1
     * @param s
     *            :String チェックする文字列
     * @return boolean 処理結果 true:有効 false:無効
     */
    public static boolean isDecimal(String s) {
        // '0'～'9' ',' '+' '-' '.'
        char c;
        int j = 0, k = 0;
        // スペース取り除き
        // s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '+' || c == '-') {
                // +か-記号は頭のみ
                if (i > 0) {
                    return false;
                }
                ;
            } else if ('0' <= c && c <= '9') {
                j++;
            } else if (c == ',') {
                // カンマはどこにあっても取り敢えずOKとする。
            } else if (c == '.') {
                // ピリオドは１つのみ
                if (k > 0) {
                    return false;
                }
                ;
                k++;
            } else {
                // 妥当な文字でなければfalse
                return false;
            }
        }
        // 数字が一つもなければ無効
        if (j <= 0) {
            return false;
        }
        return true;
    }

    /**
     * <pre>
     * 数字チェック - 数字のみ含まれるかどうかのチェック
     *
     * 機能：引数で指定された文字列が数字のみを含むことをチェックする。
     * </pre>
     *
     * @since 0.0.1
     * @param s
     *            :String チェックする文字列
     * @return boolean 処理結果 true:有効 false:無効
     */
    public static boolean isNumeric(String s) {
        // '0'～'9'
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (!('0' <= c && c <= '9')) {
                // 数字でなければfalse
                return false;
            }
        }
        return true;
    }

    /**
     * <pre>
     * 数字全角チェック - 数字全角のみ含まれるかどうかのチェック
     *
     * 機能：引数で指定された文字列が数字のみを含むことをチェックする。
     * </pre>
     *
     * @since 0.0.1
     * @param s
     *            :String チェックする文字列
     * @return boolean 処理結果 true:有効 false:無効
     */
    public static boolean isMultiByteNumeric(String s) {
        // '０'～'９'
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (!('０' <= c && c <= '９')) {
                // 数字でなければfalse
                return false;
            }
        }
        return true;
    }

    /**
     * <pre>
     * 英大文字チェック - 英大文字のみ含まれるかどうかのチェック
     *
     * 機能：引数で指定された文字列が英大文字のみを含むことをチェックする。
     * </pre>
     *
     * @since 0.0.1
     * @param s
     *            :String チェックする文字列
     * @return boolean 処理結果 true:有効 false:無効
     */
    public static boolean isUpperAlphabet(String s) {
        // &&なのでisAlphabetがfalseならisUppercaseは評価されない。
        // 両方評価したかったら&にするべし
        return (isAlphabet(s) && isUpperCase(s));
    }

    /**
     * <pre>
     * 英全角大文字チェック - 英全角大文字のみ含まれるかどうかのチェック
     *
     * 機能：引数で指定された文字列が英全角大文字のみを含むことをチェックする。
     * </pre>
     *
     * @since 0.0.1
     * @param s
     *            :String チェックする文字列
     * @return boolean 処理結果 true:有効 false:無効
     */
    public static boolean isUpperMultiByteAlphabet(String s) {
        // &&なのでisAlphabetがfalseならisUppercaseは評価されない。
        // 両方評価したかったら&にするべし
        return (isMultiByteAlphabet(s) && isUpperCase(s));
    }

    /**
     * <pre>
     * 英小文字チェック - 英小文字のみ含まれるかどうかのチェック
     *
     * 機能：引数で指定された文字列が英小文字のみを含むことをチェックする。
     * </pre>
     *
     * @since 0.0.1
     * @param s
     *            :String チェックする文字列
     * @return boolean 処理結果 true:有効 false:無効
     */
    public static boolean isLowerAlphabet(String s) {
        // &&なのでisAlphabetがfalseならisUppercaseは評価されない。
        // 両方評価したかったら&にするべし
        return (isAlphabet(s) && isLowerCase(s));
    }

    /**
     * <pre>
     * 英全角小文字チェック - 英全角小文字のみ含まれるかどうかのチェック
     *
     * 機能：引数で指定された文字列が英全角小文字のみを含むことをチェックする。
     * </pre>
     *
     * @since 0.0.1
     * @param s
     *            :String チェックする文字列
     * @return boolean 処理結果 true:有効 false:無効
     */
    public static boolean isLowerMultiByteAlphabet(String s) {
        // &&なのでisAlphabetがfalseならisUppercaseは評価されない。
        // 両方評価したかったら&にするべし
        return (isMultiByteAlphabet(s) && isLowerCase(s));
    }

    /**
     * <pre>
     * 英数大文字チェック - 英数大文字のみ含まれるかどうかのチェック
     *
     * 機能：引数で指定された文字列が英数大文字のみを含むことをチェックする。
     * </pre>
     *
     * @since 0.0.1
     * @param s
     *            :String チェックする文字列
     * @return boolean 処理結果 true:有効 false:無効
     */
    public static boolean isUpperAlphabetNumeric(String s) {
        // 'A'～'Z' '0'～'9'
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (!(('A' <= c && c <= 'Z') || ('0' <= c && c <= '9'))) {
                // 英数大文字でなければfalse
                return false;
            }
        }
        return true;
        // return (isUpperAlphabet(s) || isNumeric(s));
    }

    /**
     * <pre>
     * 英数全角大文字チェック - 英数全角大文字のみ含まれるかどうかのチェック
     *
     * 機能：引数で指定された文字列が英数全角大文字のみを含むことをチェックする。
     * </pre>
     *
     * @since 0.0.1
     * @param s
     *            :String チェックする文字列
     * @return boolean 処理結果 true:有効 false:無効
     */
    public static boolean isUpperMultiByteAlphabetNumeric(String s) {
        // 'Ａ'～'Ｚ' '０'～'９'
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (!(('Ａ' <= c && c <= 'Ｚ') || ('０' <= c && c <= '９'))) {
                // 英数全角大文字でなければfalse
                return false;
            }
        }
        return true;
        // return (isUpperMultiByteAlphabet(s) || isMultiByteNumeric(s));
    }

    /**
     * <pre>
     * 英数小文字チェック - 英数小文字のみ含まれるかどうかのチェック
     *
     * 機能：引数で指定された文字列が英数大文字のみを含むことをチェックする。
     * </pre>
     *
     * @since 0.0.1
     * @param s
     *            :String チェックする文字列
     * @return boolean 処理結果 true:有効 false:無効
     */
    public static boolean isLowerAlphabetNumeric(String s) {
        // 'a'～'z' '0'～'9'
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (!(('a' <= c && c <= 'z') || ('0' <= c && c <= '9'))) {
                // 英数小文字でなければfalse
                return false;
            }
        }
        return true;
        // return (isLowerAlphabet(s) || isNumeric(s));
    }

    /**
     * <pre>
     * 英数全角小文字チェック - 英数全角小文字のみ含まれるかどうかのチェック
     *
     * 機能：引数で指定された文字列が英数全角小文字のみを含むことをチェックする。
     * </pre>
     *
     * @since 0.0.1
     * @param s
     *            :String チェックする文字列
     * @return boolean 処理結果 true:有効 false:無効
     */
    public static boolean isLowerMultiByteAlphabetNumeric(String s) {
        // 'ａ'～'ｚ' '０'～'９'
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (!(('ａ' <= c && c <= 'ｚ') || ('０' <= c && c <= '９'))) {
                // 英数全角小文字でなければfalse
                return false;
            }
        }
        return true;
        // return (isLowerMultiByteAlphabet(s) || isMultiByteNumeric(s));
    }

    /**
     * <pre>
     * 英数字チェック - 英数字(大文字小文字)のみ含まれるかどうかのチェック
     *
     * 機能：引数で指定された文字列が英数字(大文字小文字)のみを含むことをチェックする。
     * </pre>
     *
     * @since 0.0.1
     * @param s
     *            :String チェックする文字列
     * @return boolean 処理結果 true:有効 false:無効
     */
    public static boolean isAlphabetNumeric(String s) {
        // 'A'～'Z' 'a'～'z' '0'～'9'
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (!(('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z') || ('0' <= c && c <= '9'))) {
                // 英数字でなければfalse
                return false;
            }
        }
        return true;
        // return (isAlphabet(s) || isNumeric(s));
    }

    /**
     * <pre>
     * 英数字全角チェック - 英数字全角(大文字小文字)のみ含まれるかどうかのチェック
     *
     * 機能：引数で指定された文字列が英数字全角(大文字小文字)のみを含むことをチェックする。
     * </pre>
     *
     * @since 0.0.1
     * @param s
     *            :String チェックする文字列
     * @return boolean 処理結果 true:有効 false:無効
     */
    public static boolean isMultiByteAlphabetNumeric(String s) {
        // 'Ａ'～'Ｚ' 'ａ'～'ｚ' '０'～'９'
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (!(('Ａ' <= c && c <= 'Ｚ') || ('ａ' <= c && c <= 'ｚ') || ('０' <= c && c <= '９'))) {
                // 英数字全角でなければfalse
                return false;
            }
        }
        return true;
        // return (isMultiByteAlphabet(s) || isMultiByteNumeric(s));
    }

    /**
     * <pre>
     * 大文字チェック - 大文字のみ含まれるかどうかのチェック
     *
     * 機能：引数で指定された文字列が大文字(半角全角含む)のみを含むことをチェックする。
     * </pre>
     *
     * @since 0.0.1
     * @param s
     *            :String チェックする文字列
     * @return boolean 処理結果 true:有効 false:無効
     */
    public static boolean isUpperCase(String s) {
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (!Character.isUpperCase(c)) {
                // 大文字でなければfalse
                return false;
            }
        }
        return true;
    }

    /**
     * <pre>
     * 小文字チェック - 小文字のみ含まれるかどうかのチェック
     *
     * 機能：引数で指定された文字列が小文字(半角全角含む)のみを含むことをチェックする。
     * </pre>
     *
     * @since 0.0.1
     * @param s
     *            :String チェックする文字列
     * @return boolean 処理結果 true:有効 false:無効
     */
    public static boolean isLowerCase(String s) {
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (!Character.isLowerCase(c)) {
                // 小文字でなければfalse
                return false;
            }
        }
        return true;
    }

    /**
     * <pre>
     * 数字チェック - 数字(半角全角含む)のみ含まれるかどうかのチェック
     *
     * 機能：引数で指定された文字列が数字(半角全角含む)のみを含むことをチェックする。
     * </pre>
     *
     * @since 0.0.1
     * @param s
     *            :String チェックする文字列
     * @return boolean 処理結果 true:有効 false:無効
     */
    public static boolean isDigit(String s) {
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (!Character.isDigit(c)) {
                // 数字でなければfalse
                return false;
            }
        }
        return true;
    }

    /**
     * <pre>
     * 汎用文字チェック - 汎用文字のみ含まれるかどうかのチェック
     *
     * 機能：引数で指定された文字列が汎用文字のみを含むことをチェックする。
     * </pre>
     *
     * @since 0.0.1
     * @param s
     *            :String チェックする文字列
     * @return boolean 処理結果 true:有効 false:無効
     */
    public static boolean isLetter(String s) {
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (!Character.isLetter(c)) {
                // 数字でなければfalse
                return false;
            }
        }
        return true;
    }

    /**
     * <pre>
     * 汎用文字または数字チェック - 汎用文字または数字のみ含まれるかどうかのチェック
     *
     * 機能：引数で指定された文字列が汎用文字または数字のみを含むことをチェックする。
     * </pre>
     *
     * @since 0.0.1
     * @param s
     *            :String チェックする文字列
     * @return boolean 処理結果 true:有効 false:無効
     */
    public static boolean isLetterOrDigit(String s) {
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                // 数字でなければfalse
                return false;
            }
        }
        return true;
    }

    /**
     * <pre>
     * 半角カナチェック - 半角カナ文字のみ含まれるかどうかのチェック
     *
     * 機能：引数で指定された文字列が半角カナのみを含むことをチェックする。
     * </pre>
     *
     * @since 0.0.1
     * @param s
     *            :String チェックする文字列
     * @return boolean 処理結果 true:有効 false:無効
     */
    public static boolean isSingleByteKana(String s) {
        return isValidString(s, SINGLEBYTE_KANA);
    }

    /**
     * <pre>
     * 半角カナチェック - 半角カナ文字が含まれるかどうかのチェック
     *
     * 機能：引数で指定された文字列に半角カナが含まれていないことをチェックする。
     * </pre>
     *
     * @since 0.0.1
     * @param s
     *            :String チェックする文字列
     * @return boolean 処理結果 true:半角カナが含まれる false:半角カナが含まれない
     */
    public static boolean checkSingleByteKana(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (SINGLEBYTE_KANA.indexOf(s.charAt(i)) != -1) {
                // 半角カナ文字が存在すればtrue
                return true;
            }
        }
        return false;
    }

    /**
     * <pre>
     * 大文字変換 - 大文字に変換する
     *
     * 機能：引数で指定された文字列を大文字に変換する
     * </pre>
     *
     * @since 0.0.1
     * @param s
     *            :String 変換する文字列
     * @return String 変換後文字列
     */
    public static String toUpperCase(String s) {
        StringBuffer sb = new StringBuffer(s.length());
        for (int i = 0; i < s.length(); i++) {
            sb.append(Character.toUpperCase(s.charAt(i)));
        }
        return sb.toString();
    }

    /**
     * <pre>
     * 小文字変換 - 小文字に変換する
     *
     * 機能：引数で指定された文字列を小文字に変換する
     * </pre>
     *
     * @since 0.0.1
     * @param s
     *            :String 変換する文字列
     * @return String 変換後文字列
     */
    public static String toLowerCase(String s) {
        StringBuffer sb = new StringBuffer(s.length());
        for (int i = 0; i < s.length(); i++) {
            sb.append(Character.toLowerCase(s.charAt(i)));
        }
        return sb.toString();
    }

    /**
     * <pre>
     * 全角->半角変換 - 半角文字に変換する
     *
     * 機能：引数で指定された文字列を半角文字に変換する
     * </pre>
     *
     * @since 0.0.1
     * @param s
     *            :String 変換する文字列
     * @return String 変換後文字列
     */
    public static String toSingleByte(String s) {
        StringBuffer sb = new StringBuffer(s.length());
        char c, k;
        int x;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            k = c;
            if ('Ａ' <= c && c <= 'Ｚ') {
                k = (char) ((int) c - offsetA);
            } else if ('ａ' <= c && c <= 'ｚ') {
                k = (char) ((int) c - offseta);
            } else if ('０' <= c && c <= '９') {
                k = (char) ((int) c - offset0);
            } else if ((x = MULTIBYTE_SYMBOLS.indexOf(c)) != -1) {
                // 本来はもっと多くの記号に対応しないと駄目だが、取り敢えず基本的なものは対応しよう
                k = SINGLEBYTE_SYMBOLS.charAt(x);
            } else if ((x = MULTIBYTE_KANA.indexOf(c)) != -1) {
                k = SINGLEBYTE_KANA.charAt(x);
            } else if ((x = MULTIBYTE_KANA_D.indexOf(c)) != -1) {
                // 濁点ありの場合は、濁点なしの半角カナ文字と濁点を追加する(StringBuffer要拡張)
                sb.append(SINGLEBYTE_KANA_D.charAt(x));
                k = SINGLEBYTE_KANA_DAKUTEN;
            } else if ((x = MULTIBYTE_KANA_H.indexOf(c)) != -1) {
                // 半濁点ありの場合は、半濁点なしの半角カナ文字と半濁点を追加する(StringBuffer要拡張)
                sb.append(SINGLEBYTE_KANA_H.charAt(x));
                k = SINGLEBYTE_KANA_HANDAKUTEN;
            } else {
                k = c;
            }
            sb.append(k);
        }
        return sb.toString();
    }

    /**
     * <pre>
     * 半角->全角変換 - 全角文字に変換する
     *
     * 機能：引数で指定された文字列を全角文字に変換する
     * </pre>
     *
     * @since 0.0.1
     * @param s
     *            :String 変換する文字列
     * @return String 変換後文字列
     */
    public static String toMultiByte(String s) {
        StringBuffer sb = new StringBuffer(s.length());
        char c, c2, k;
        int x, y;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            k = c;
            if ('A' <= c && c <= 'Z') {
                k = (char) ((int) c + offsetA);
            } else if ('a' <= c && c <= 'z') {
                k = (char) ((int) c + offseta);
            } else if ('0' <= c && c <= '9') {
                k = (char) ((int) c + offset0);
            } else if ((x = SINGLEBYTE_SYMBOLS.indexOf(c)) != -1) {
                // 本来はもっと多くの記号に対応しないと駄目だが、取り敢えず基本的なものは対応しよう
                k = MULTIBYTE_SYMBOLS.charAt(x);
            } else if ((x = SINGLEBYTE_KANA.indexOf(c)) != -1) {
                // 次の文字があれば濁点半濁点をチェックし合わせて変換する
                y = -1; // 濁点半濁点をつけた場合は0か正整数になる
                if (i + 1 < s.length()) {
                    c2 = s.charAt(i + 1);
                    if (c2 == 'ﾞ') { // 濁点があった
                        if ((y = SINGLEBYTE_KANA_D.indexOf(c)) != -1) { // 濁点をつけれる場合
                            k = MULTIBYTE_KANA_D.charAt(y);
                            i++; // 濁点分進める
                        }
                    } else if (c2 == 'ﾟ') { // 半濁点があった
                        if ((y = SINGLEBYTE_KANA_H.indexOf(c)) != -1) { // 半濁点をつけれる場合
                            k = MULTIBYTE_KANA_H.charAt(y);
                            i++; // 半濁点分進める
                        }
                    }
                }
                if (y < 0) { // 濁点半濁点処理をしていない(通常の文字の場合)
                    // 濁点半濁点が単独であらわれた場合 例:ｱﾞｲﾟ は全角の濁点半濁点に変換
                    if (c == 'ﾞ') {
                        k = MULTIBYTE_KANA_DAKUTEN;
                    } else if (c == 'ﾟ') {
                        k = MULTIBYTE_KANA_HANDAKUTEN;
                    } else { // 通常の文字の場合
                        k = MULTIBYTE_KANA.charAt(x);
                    }
                }
            } else {
                k = c;
            }
            sb.append(k);
        }
        return sb.toString();
    }

    /**
     * 文字列をスペースで右埋めします。
     *
     * @return java.lang.String
     * @param val
     *            java.lang.String
     * @param len
     *            int
     * @since 0.0.5
     */
    public static String strPad(String val, int len) {
        return strPad(val, " ", len);
    }

    /**
     * 文字列をスペースで右埋めします。
     *
     * @return java.lang.String
     * @param val
     *            java.lang.String
     * @param len
     *            int
     * @since 0.0.6
     */
    public static String strAdjustPad(String val, int len) {
        int length = len - val.getBytes().length;
        return strPad(val, " ", length);
    }

    /**
     * 文字列を右埋めします。
     *
     * @return java.lang.String
     * @param val
     *            java.lang.String
     * @param len
     *            int
     * @since 0.0.5
     */
    public static String strPad(String val, String pad, int len) {
        StringBuffer sb = new StringBuffer(val);
        for (int i = 0; i < len; i++) {
            sb.append(pad);
        }
        return sb.toString();
    }

    /**
     * 機能：Stringの文字列を改行で区切り=の前後を HashtbleのKeyとValueにsetして返す。 作成日 : (01/07/05 午前
     * 04:23:52)
     *
     * @since 0.0.0
     * @param sValue
     *            java.lang.String
     * @return Hashtable
     */
    public static Hashtable<String, String> paramCut(String sValue) {

        StringBuffer sbTemp = new StringBuffer(sValue);
        String sTarget = "\n";
        // 先頭の文字を取得
        int iIndex = sbTemp.toString().indexOf(sTarget);
        // 先頭に改行コードが有れば削除
        if (iIndex == 0) {
            sbTemp.replace(iIndex, iIndex + sTarget.length(), "");
        }

        // 分割クラスの初期化
        StringTokenizer tok = new StringTokenizer(sbTemp.toString(), sTarget);

        Hashtable<String, String> hash = new Hashtable<String, String>();

        // 改行コードで分割
        while (tok.hasMoreTokens()) {
            String sWK = tok.nextToken();
            // CSV分割クラスのセット
            if (sWK == null || sWK.equals("")) {
                continue;
            }
            StringTokenizer tok1 = new StringTokenizer(sWK, "=");
            int iCnt = 0;
            // 値の取り出し
            String sT = "";
            String sTT = "";
            while (tok1.hasMoreTokens()) {
                if (iCnt == 0) {
                    sT = tok1.nextToken();
                } else if (iCnt == 1) {
                    sTT = tok1.nextToken();
                    hash.put(sT, sTT);
                }
                iCnt++;
            }
        }

        return hash;
    }

    /**
     * <pre>
     * パスワード作成 - パスワードを作って返します。
     * 機能：
     *   １．パスワードの作成。（１～９）
     *   ２．パスワードを返す
     * </pre>
     *
     * @since 0.0.7
     * @param パスワードの桁数
     */
    public static String selectPasswordNo(int nLen) {
        // 変数宣言
        StringBuffer pswd = new StringBuffer();
        String strMoji = new String("0123456789"); // 1～9,A～Z
        int pi = 0;
        double pd = 0;

        for (int i = 0; i < nLen; i++) {
            pd = java.lang.Math.random() * strMoji.length();
            pi = new Double(pd).intValue();
            pswd.append(strMoji.substring(pi, pi + 1));
        }
        return pswd.toString();
    }

    /**
     * ・Stringの値をintの桁数でチェックし桁数を超えた 場合はintの桁数までの文字を返す。 作成日 : (01/07/03 午後
     * 06:32:22)
     *
     * @since 0.0.5
     * @return java.lang.String
     * @param str
     *            java.lang.String
     * @param size
     *            int
     */
    public static String substrb(String str, int size) {
        int len = str.getBytes().length;
        if (len <= size) {
            return str;
        }

        StringBuffer sb = new StringBuffer();
        int endPos = 0;
        int length = 0;

        // size以上の場合は文字数分長さをチェックします。
        while (endPos < str.length()) {
            // 1文字取り出す
            String sTarget = str.substring(endPos, endPos + 1);
            // 1文字のバイト数
            int n = sTarget.getBytes().length;
            // sizeバイトを越えた
            if (length + n > size) {
                break;
            } else {
                length += n;
                ++endPos;
                sb.append(sTarget);
            }
        }
        return sb.toString();
    }

    /**
     * <pre>
     * UnicodeをSJISに変換
     * </pre>
     *
     * @since 0.0.2
     * @param source
     *            :String 変換する文字列
     * @return String 処理結果の文字列
     * @exception Exception
     *                エラー例外
     */
    public static String convertUnicodetoSJIS(String source) throws Exception {
        return new String(source.getBytes(STRING_OUTPUT_CODE),
                STRING_DEFAULT_CODE);
    }

    /**
     * <pre>
     * SJISやJISをUnicodeに変換
     * </pre>
     *
     * @since 0.0.2
     * @param source
     *            :String 変換する文字列
     * @return String 処理結果の文字列
     * @exception Exception
     *                エラー例外
     */
    public static String convertSJIStoUnicode(String source) throws Exception {
        return new String(source.getBytes(STRING_DEFAULT_CODE),
                STRING_INPUT_CODE);
    }

    /**
     * <pre>
     * Unicodeのベンダ依存文字を対応します。
     * OC4Jの場合は、MS932を使用するにあたって～がおかしくなります。
     *
     * <pre>
     */
    public static String toMS932(String s) {
        // ～の対応 WAVE DASH(0x301c) -> FULLWIDTH TILDE(0xff5e)
        // 取り敢えず～のみ対応
        s = s.replace((char) 0x301c, (char) 0xff5e);
        return s;
    }

    /**
     * <pre>
     * ダウンロードファイルのバイト配列へ変換する。
     *
     * <pre>
     */
    public static byte[] toDownloadBytes(String csvData) {
        byte[] csvBytes = null;
        try {
          csvBytes = toMS932(csvData.toString()).getBytes(STRING_OUTPUT_CODE);
        } catch (UnsupportedEncodingException e1) {
        }
        return csvBytes;
    }

    /**
     * <pre>
     * MS932 Unicodeに変換
     * </pre>
     *
     * @since 0.0.2
     * @param s
     *            :String 変換する文字列
     * @return String 処理結果の文字列
     */
    public static String toCp932(String s) {
        if (s == null) {
            return s;
        }
        if (System.getProperty("os.name").toUpperCase().indexOf("WIN") == (-1)) {
            return s;
        }
        StringBuffer sb = new StringBuffer();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            switch (c) {
            case 0x005c: // REVERSE SOLIDUS ->
                c = 0xff3c; // FULLWIDTH REVERSE SOLIDUS
                break;
            case 0x301c: // WAVE DASH ->
                c = 0xff5e; // FULLWIDTH TILDE
                break;
            case 0x2016: // DOUBLE VERTICAL LINE ->
                c = 0x2225; // PARALLEL TO
                break;
            case 0x2212: // MINUS SIGN ->
                c = 0xff0d; // FULLWIDTH HYPHEN-MINUS
                break;
            case 0x00a2: // CENT SIGN ->
                c = 0xffe0; // FULLWIDTH CENT SIGN
                break;
            case 0x00a3: // POUND SIGN ->
                c = 0xffe1; // FULLWIDTH POUND SIGN
                break;
            case 0x00ac: // NOT SIGN ->
                c = 0xffe2; // FULLWIDTH NOT SIGN
                break;
            }
            sb.append(c);
        }
        return new String(sb);
    }

    /**
     * <pre>
     * パスワード作成 - パスワードを作って返します。
     * 機能：
     *   １．パスワードの作成。（１～９、Ａ～Ｚ）
     *   ２．パスワードを返す
     * </pre>
     *
     * @since 0.0.5
     * @param パスワードの桁数
     */
    public static String selectPassword(int nLen) {
        // 変数宣言
        StringBuffer pswd = new StringBuffer();
        String strMoji = new String("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"); // 1～9,A～Z
        int pi = 0;
        double pd = 0;

        for (int i = 0; i < nLen; i++) {
            pd = java.lang.Math.random() * strMoji.length();
            pi = new Double(pd).intValue();
            pswd.append(strMoji.substring(pi, pi + 1));
        }
        return pswd.toString();
    }

    /**
     * 指定バイトで抽出した文字列を返却する。
     *
     * @param argTarget
     *            抽出対象文字列
     * @param argBytes
     *            抽出バイト数
     * @return 指定バイトで抽出した文字列
     * @throws UnsupportedEncodingException
     *             サポート外の文字コード例外
     */
    public static String getBytesLengthStr(String argTarget, int argBytes)
            throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        if (0 < argBytes && (argTarget != null && !"".equals(argTarget))) {
            // 現在バイト数
            int curByteNum = 0;
            for (int i = 0; i < argTarget.length(); i++) {
                byte[] tmp = argTarget.substring(i, i + 1).getBytes();
                if (tmp != null) {
                    curByteNum += tmp.length;
                    if (argBytes < curByteNum) {
                        break;
                    } else {
                        sb.append(new String(tmp, STRING_OUTPUT_CODE));
                    }
                }
            }
        }
        return sb.toString();
    }

    /**
     * 空白チェック
     *
     * @param str
     *            文字列
     * @return 空白判断結果
     */
    public static boolean isEmpty(String str) {
        if (str == null || str.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * NVL処理
     *
     * @param str
     *            文字列
     * @param nvl
     * @return
     */
    public static String nvl(String str, String nvl) {
        if (isEmpty(str)) {
            return nvl;
        } else {
            return str;
        }
    }

    /**
     * 空白からNULLへ変換処理（SQL検索条件設定時使用）
     *
     * @param str
     * @return
     */
    public static String setEmptyToNull(String str) {
        if (isEmpty(str)) {
            return null;
        } else {
            return str;
        }
    }

    /**
     * ダウンロードファイル名のエンコード変換処理
     *
     * @param fileName ダウンロードファイル名
     * @return 変換後のファイル名
     * @throws UnsupportedEncodingException
     */
    public static String encodeFilename(String fileName, String encode) throws UnsupportedEncodingException {
        if (isEmpty(fileName)) {
            return "";
        } else {
            return URLEncoder.encode(fileName, encode).replaceAll("\\+", "%20");
        }
    }

    /**
     * CSV出力の項目値処理
     * @param str
     *            文字列
     * @param nvl
     * @return
     */
    public static String toCsvNumber(String str) {
        if (isEmpty(str)) {
            return "";
        }
        return "=\"" + str + "\"";
    }

    /**
     * CSV出力の項目値処理
     * @param str
     *            文字列
     * @return
     */
    public static String toCsv(String str) {
        return "\"" + str + "\"";
    }

    /**
     * 指定属性の値を取得する
     * @param object コピー元Bean
     * @param methodName メソッド名称
     * @return 指定属性の値
     */
    public static String getValue(Object object, String methodName) {
        String rtn = "";
        if (object == null || StringUtils.isEmpty(methodName)) {
            return rtn;
        }
        try {
            Method method = object.getClass().getMethod(methodName);
            rtn = (String)method.invoke(object);
        } catch (SecurityException e) {
            //e.printStackTrace();
        } catch (NoSuchMethodException e) {
            //e.printStackTrace();
        } catch (IllegalArgumentException e) {
            //e.printStackTrace();
        } catch (IllegalAccessException e) {
            //e.printStackTrace();
        } catch (InvocationTargetException e) {
            //e.printStackTrace();
        }
        return rtn;
    }

    /**
     * 指定属性の値をコピーする
     * @param object コピー元Bean
     * @param methodName メソッド名称
     * @return 指定属性の値
     */
    public static void copyValue(Object objectTo, Object objectFrom, String methodName) {
        if (objectTo == null || objectFrom == null || StringUtils.isEmpty(methodName) || methodName.length() <= 1) {
            return;
        }
        methodName = methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
        try {
            Method getMethod = objectFrom.getClass().getMethod("get" + methodName);
            Method toMethod = objectTo.getClass().getMethod("set" + methodName, String.class);
            Object value = getMethod.invoke(objectFrom);
            toMethod.invoke(objectTo, value);
        } catch (SecurityException e) {
            //e.printStackTrace();
        } catch (NoSuchMethodException e) {
            //e.printStackTrace();
        } catch (IllegalArgumentException e) {
            //e.printStackTrace();
        } catch (IllegalAccessException e) {
            //e.printStackTrace();
        } catch (InvocationTargetException e) {
            //e.printStackTrace();
        }
    }

    /**
     * NVL処理 str is NULL、then return nvl,str='Z' then return '' else return str
     *
     * @param str
     *            文字列
     * @param nvl
     * @return
     */
    public static String nvlUpd(String str, String nvl) {
        if (isEmpty(str)) {
            return nvl(nvl,"");
        } else {
        	if(str.equals("Z")) {
        		return "";
        	}else {
        		return str;
        	}
        }
    }

    /**
     * Zチェック
     *
     * @param str
     *            文字列
     * @return Z判断結果
     */
    public static boolean isZ(String str) {
    	if (str == null || str.length() == 0) {
    		return false;
    	} else {
    		if(str.equals("Z")) {
    			return true;
    		} else {
    			return false;
    		}
    	}
    }
}
