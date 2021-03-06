package cn.ubibi.nettyweb.framework.commons;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesUtils {

    private static final Map<String, Properties> propertiesMap = new HashMap<>();

    public static Properties loadProperties(String fileName) throws IOException {
        Properties properties = new Properties();
        InputStream inStream = PropertiesUtils.class.getClassLoader().getResourceAsStream(fileName);
        properties.load(inStream);

        //放入缓存
        propertiesMap.put(fileName, properties);

        return properties;
    }


    public static Properties getProperties(String fileName) throws IOException {
        Properties p = propertiesMap.get(fileName);
        if (p == null) {
            p = loadProperties(fileName);
        }
        return p;
    }



    public static Map<String, String> toMap(Properties p) {
        Map<String, String> map = new HashMap<>();
        if (p == null) {
            return map;
        }

        Set<Map.Entry<Object, Object>> entrySet = p.entrySet();
        for (Map.Entry<Object, Object> entry : entrySet) {
            Object x = entry.getValue();
            Object k = entry.getKey();
            if (x != null && k != null) {
                String xs = x.toString();
                String keyString = k.toString();
                map.put(keyString, xs);
            }
        }

        return map;
    }



}
