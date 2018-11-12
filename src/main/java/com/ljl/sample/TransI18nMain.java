package com.ljl.sample;

import org.wltea.analyzer.cfg.Configuration;
import org.wltea.analyzer.cfg.MyDefaultConfig;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 转化的执行方法
 */
public class TransI18nMain {


    /**
     * 中文分词
     * @param s
     * @return
     */
    public static List<String> segment(String s) {
        List<String> result = new ArrayList<String>();
        //构建IK分词器，使用smart分词模式
        Configuration conf  = MyDefaultConfig.getInstance();
        conf.setUseSmart(true);
        StringReader re = new StringReader(s);
        IKSegmenter ik = new IKSegmenter(re,conf);
        Lexeme lex = null;
        try {
            while((lex=ik.next())!=null){
                //System.out.print(lex.getLexemeText()+"|");
                result.add(lex.getLexemeText());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 开始翻译
     * @return
     */
    public static List<Pair>  trans(){
        List<Pair> result = new ArrayList<Pair>();
        String[] zw = MyStrs.MYSTR.split("\n");
        for(int i=0;i<zw.length;i++){
            String zwStr = zw[i];
            String[] prefAndZw = parseZw(zwStr);
            //查询现有的中心是否定义了该词组，如果定义了，直接拿来主义
            String ts = ExistPairDic.getInstance().getEnglish(zwStr,MyConfig.getInstance().getCenterName());
        /*    if(ts!=null){
                Pair pair = new Pair(prefAndZw[1],ts);
                result.add(pair);
                continue;
            }*/

           List<String>words = segment(prefAndZw[1]);
           List<Token>tokens =new ArrayList<Token>();
           for(int j=0;j<words.size();j++){
              Token token =  Dic.getInstance().getDicMap().get(words.get(j));
              if(token==null){
                  System.out.println("<<"+words.get(j)+">>没有对应的词库");
                  continue;
              }
               tokens.add(token);
           }
            String yw ="";
            yw = toEnglish(tokens);
            yw = prefAndZw[0]+yw;
            Pair pair = new Pair(prefAndZw[1],yw);
            result.add(pair);
        }
        return result;
    }

    /**
     * 解析出中文和 前缀，加前缀是为了区分btn，ti，tips和业务字段重名，转化为英文也需加前缀的问题
     * @param zwstr
     * @return
     */
    private static String[] parseZw(String zwstr){
        String[] result={"",""};
        String[] ss = zwstr.split("_");
        if(ss.length>1){
            result[0]=ss[0]+"_";
            result[1]=ss[1];
        }else{
            result[1]=ss[0];
        }
        return result;
    }

    /**
     * 把切分的词组组合成最终的英文单词
     * @param tokens
     * @return
     */
    public static String toEnglish(List<Token> tokens){
        while(tokens.size()>5){//大于5个单词减
            removeOneToken(tokens);
        }
        //1.先用英文全称
        StringBuilder buff = new StringBuilder();
        for(int i=0;i<tokens.size();i++){
            buff.append(tokens.get(i).getEnName()).append("_");
        }
        //2.用简称全称权重去拼接英文
        String r =buff.toString();
        if(r.replaceAll("_","").length()>20){
            buff.delete(0,buff.length());
            for(int i=0;i<tokens.size();i++) {
                Token token = tokens.get(i);
                if(token.getEnWeight()>token.getAbWeight()){
                    buff.append(token.getEnName()).append("_");
                }else{
                    buff.append(token.getAbName()).append("_");
                }
            }
        }
        //3.用最终方案去完成最终的拼接
         r =buff.toString();
        if(r.replaceAll("_","").length()>20){
            List<String> selectYws = new ArrayList<>(tokens.size());
            for(int i=0;i<tokens.size();i++) {
                Token token = tokens.get(i);
                selectYws.add(token.getEnName());
            }
            //从后面逐个单词选择简写，如果长度<20结束，如果长度继续超过20那么，继续变简写；如果全部都变为简写后仍超长，那么再去掉权重最低的
            int adCount=0;//简写的数量
            while(lenStr(selectYws)>20){
                if(adCount<selectYws.size()){
                    int index = selectYws.size()-1-adCount;
                    selectYws.set(index,tokens.get(index).getAbName());
                    adCount++;
                }else{
                   int index =removeOneToken(tokens);
                    selectYws.clear();
                    for(int i=0;i<tokens.size();i++) {
                        Token token = tokens.get(i);
                        selectYws.add(token.getEnName());
                    }
                    adCount=0;
                }
            }
            buff.delete(0,buff.length());
            for (int i = 0; i < selectYws.size(); i++) {
                buff.append(selectYws.get(i)).append("_");
            }
            r =buff.toString();
        }
        r= r.replaceAll("_$","");
        r=r.replaceAll("__","_");
        return r;
    }

    /**
     * 计算集合内字符串的长度
     * @param list
     * @return
     */
    private static int lenStr(List<String> list){
        int r=0;
        for (int i = 0; i < list.size(); i++) {
            r+=list.get(i).length();
        }
        return r;
    }

    /**
     * 移除权重值最低的词组
     * @param tokens
     * @return
     */
    public static int removeOneToken(List<Token> tokens){
        int minIndex=0;
        int minWeight=tokens.get(0).getWeight();
        for (int i = 1; i < tokens.size(); i++) {
            Token token = tokens.get(i);
            if(token.getWeight()<minWeight){
                minIndex=i;
                minWeight = token.getWeight();
            }
        }
        tokens.remove(minIndex);
        return minIndex;

    }


    public static void main(String[] args) {
           List<Pair> list = trans();
        for (int i = 0; i < list.size(); i++) {
            Pair pair = list.get(i);
            System.out.println(pair.getKey()+"\t"+pair.getValue());
        }



    }

}
