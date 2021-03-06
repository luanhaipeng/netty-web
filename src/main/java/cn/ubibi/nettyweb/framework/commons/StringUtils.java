package cn.ubibi.nettyweb.framework.commons;


import java.net.URL;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static boolean isEmpty(String str){
        return str == null || str.isEmpty();
    }

    public static String join(Collection collection, String flag) {
        if (collection == null || collection.isEmpty()) {
            return "";
        }

        Object[] objArray = collection.toArray(new Object[collection.size()]);
        return join(objArray, flag);
    }


    public static String join(Object[] o, String flag) {

        if (o == null || o.length == 0) {
            return "";
        }

        StringBuilder str_buff = new StringBuilder();

        for (int i = 0, len = o.length; i < len; i++) {
            str_buff.append(String.valueOf(o[i]));
            if (i < len - 1) str_buff.append(flag);
        }

        return str_buff.toString();
    }

    public static String replaceAll(String str, Map<String, String> map) {
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            str = str.replaceAll(entry.getKey(), entry.getValue());
        }
        return str;
    }


    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    /**
     * 驼峰法转下划线
     *
     * @param str 源字符串
     * @return 转换后的字符串
     */
    public static String camel2Underline(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static String appendIfNotEnd(String path, String s) {
        if (path.endsWith(s)){
            return path;
        }
        return path + s;
    }


    public static String getRootPath(URL url) {

        /*
         * "file:/home/whf/cn/fh" ==》 "/home/whf/cn/fh"
         * "jar:file:/home/whf/foo.jar!cn/fh" ==》 "/home/whf/foo.jar"
         */
        String fileUrl = url.getFile();
        int pos = fileUrl.indexOf('!');

        if (-1 == pos) {
            return fileUrl;
        }

        return fileUrl.substring(5, pos);
    }

    public static String dotToSplash(String name) {

        /*
         * "cn.fh.lightning" ==》 "cn/fh/lightning"
         */
        return name.replaceAll("\\.", "/");
    }

    public static String splashToDot(String name) {
        return name.replaceAll("/", ".");
    }

    public static String trimExtension(String name) {

        /*
         * "Apple.class" -> "Apple"
         */
        int pos = name.lastIndexOf('.');
        if (-1 != pos) {
            return name.substring(0, pos);
        }

        return name;
    }

}
