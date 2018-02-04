package com.hjj.framework.beetl;

import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by Administrator on 2018/1/28.
 */
public class ReadConfigProperties {

    private static final Log log = LogFactory.getCurrentLogFactory().getLog(ReadConfigProperties.class);

    private String path;
    private Map<String, Object> propertyMap;

    public Map<String, Object> getProperties(){
        if (propertyMap != null)
            return propertyMap;
        Map<String, Object> map = new HashMap<>();
        Properties prop = null;
        try {
            prop = new Properties();
            ClassLoader classLoader = getClass().getClassLoader();
            prop.load(new InputStreamReader(classLoader.getResourceAsStream(path), "GBK"));
        } catch (Exception e) {
            log.error("读取自定义配置文件失败");
            e.printStackTrace();
        }
        assert prop != null;
        Set<Map.Entry<Object, Object>> entries = prop.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            map.put((String) entry.getKey(), entry.getValue());
        }
        propertyMap = map;
        return map;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
