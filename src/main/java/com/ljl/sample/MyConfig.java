package com.ljl.sample;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 配置
 */
public class MyConfig implements  Config{
    private final static String CONFIG_FILE_NAME = "config.properties";

    /**
     * 返回单例
     * @return Configuration单例
     */
    public static MyConfig getInstance(){
        return new MyConfig();
    }
    private Properties props;
    /*
     * 初始化配置文件
     */
    private MyConfig(){
        props = new Properties();
        InputStream input = this.getClass().getClassLoader().getResourceAsStream(CONFIG_FILE_NAME);
        if(input != null){
            try {
                props.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public String getI18nDir() {
        return props.getProperty("i18ndir");
    }

    @Override
    public String getCenterName() {
        return props.getProperty("centerName");
    }
}
