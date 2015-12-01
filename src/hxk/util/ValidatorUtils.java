package hxk.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author HXK
 * @description
 *2014-1-24  下午12:26:35
 */
public class ValidatorUtils {
    public static boolean isEmail(String input)
    {
        String regex = "^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        return match(regex, input);
    }

    public static boolean isIP(String input)
    {
        String num = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";
        String regex = (new StringBuilder()).append("^").append(num).append("\\.").append(num).append("\\.").append(num).append("\\.").append(num).append("$").toString();
        return match(regex, input);
    }

    public static boolean isUrl(String input)
    {
        String regex = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
        return match(regex, input);
    }

    public static boolean isTelephone(String input)
    {
        String regex = "^(\\d{3,4}-)?\\d{6,8}$";
        return match(regex, input);
    }

    public static boolean isPassword(String input)
    {
        String regex = "[A-Za-z]+[0-9]";
        return match(regex, input);
    }

    public static boolean isPostalcode(String input)
    {
        String regex = "^\\d{6}$";
        return match(regex, input);
    }

    public static boolean isHandset(String input)
    {
        String regex = "^[1]+[3,5]+\\d{9}$";
        return match(regex, input);
    }

    public static boolean isIdNumber(String input)
    {
        String regex = "(^\\d{18}$)|(^\\d{15}$)";
        return match(regex, input);
    }

    public static boolean isDecimal(String input)
    {
        String regex = "^[0-9]+(.[0-9]{2})?$";
        return match(regex, input);
    }

    public static boolean isMonth(String input)
    {
        String regex = "^(0?[[1-9]|1[0-2])$";
        return match(regex, input);
    }

    public static boolean isDay(String input)
    {
        String regex = "^((0?[1-9])|((1|2)[0-9])|30|31)$";
        return match(regex, input);
    }

    public static boolean isDate(String input)
    {
        String regex = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-)) (20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$";
        return match(regex, input);
    }

    public static boolean isNumber(String input)
    {
        String regex = "^[0-9]*$";
        return match(regex, input);
    }

    public static boolean isIntNumber(String input)
    {
        String regex = "^\\+?[1-9][0-9]*$";
        return match(regex, input);
    }

    public static boolean isUpChar(String input)
    {
        String regex = "^[A-Z]+$";
        return match(regex, input);
    }

    public static boolean isLowChar(String input)
    {
        String regex = "^[a-z]+$";
        return match(regex, input);
    }

    public static boolean isLetter(String input)
    {
        String regex = "^[A-Za-z]+$";
        return match(regex, input);
    }

    public static boolean isChinese(String input)
    {
        String regex = "^[\u4E00-\u9FA5],{0,}$";
        return match(regex, input);
    }

    public static boolean isLength(String input)
    {
        String regex = "^.{8,}$";
        return match(regex, input);
    }

    private static boolean match(String regex, String input)
    {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
