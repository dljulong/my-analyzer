package com.ljl.sample;

/**
 * 配置接口
 */
public interface Config {
    /**
     * I18N中文国际化文件目录
     * @return
     */
    public String getI18nDir();

    /**
     * 需要转化的字段所在中心，用在查询该中心下是否定义了该词，如果有直接拿来用
     * @return
     */
    public String getCenterName();
}
