package com.ljl.sample;

import com.alibaba.fastjson.JSONObject;

import java.io.*;

/**
 * 直接读取i18n文件夹，把所有中心的数据读出来
 */
public class ExistPairDic {
    private  static JSONObject dic = new JSONObject();
    private ExistPairDic(){
        initDic();
    }
    private static ExistPairDic instance;

    private static synchronized void syncInit() {
        if (instance == null) {
            instance = new ExistPairDic();
        }
    }
    public static ExistPairDic getInstance(){
        if(instance==null){
            syncInit();
        }
        return instance;
    }

    public  void initDic(){
        try {
            String i18nDir = MyConfig.getInstance().getI18nDir();
            File zhDir = new File(i18nDir);
           File[] files = zhDir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    if(name.split("\\.")[1].equals("json")){
                        return true;
                    }
                    return false;
                }
            });
            for (int i = 0; i <files.length ; i++) {
                File f = files[i];
                String centerName = f.getName().replaceAll("_zh.json","");
                JSONObject centerJson = JSONObject.parseObject(new FileInputStream(f), null,JSONObject.class);
                dic.put(centerName,centerJson);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getEnglish(String chinese){
        return getEnglish(chinese,null);
    }
    public String getEnglish(String chinese,String cen){
        for(String cenName:dic.keySet()){
            if(cen!=null){
                if(!cenName.equals(cen))continue;
            }
            JSONObject cenObject = dic.getJSONObject(cenName);
            String[] ss = chinese.split("_");
            String prefix = "";
            String actualChinese ="";
            if(ss.length>1){
                prefix=ss[0];
                actualChinese=ss[1];
            }else{
                prefix = "";
                actualChinese=ss[0];
            }
            for (String key: cenObject.keySet()) {
                JSONObject partJson = cenObject.getJSONObject(key);
                for(String en :partJson.keySet()){
                    String zw = partJson.getString(en);
                    if(zw.equals(actualChinese)){
                        if( en.startsWith(prefix)){
                            return en;
                        }
                    }
                }
            }
        }
          return null;
    }

    public static JSONObject getDic() {
        return dic;
    }
}
