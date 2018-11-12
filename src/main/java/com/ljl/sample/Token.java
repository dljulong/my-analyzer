package com.ljl.sample;

class Token {
    private String zhName;
    private String enName;
    private String abName;
    /**
     * 词的权重，该词被包含的中文词组选中做为后选择+1，对包换的词组未选中则-1
     */
    private int weight=0;
    /**
     * 英文全称的权重，英文全称被选择使用则+1
     */
    private int enWeight=0;
    /**
     * 英文简称的权重，英文简称被选择使用则+1
     */
    private int abWeight=0;

    public Token(String zhName, String enName, String abName) {
        this.zhName = zhName;
        this.enName = enName;
        this.abName = abName;
    }

    public String getZhName() {
        return zhName;
    }

    public void setZhName(String zhName) {
        this.zhName = zhName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getAbName() {
        return abName;
    }

    public void setAbName(String abName) {
        this.abName = abName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getEnWeight() {
        return enWeight;
    }

    public void setEnWeight(int enWeight) {
        this.enWeight = enWeight;
    }

    public int getAbWeight() {
        return abWeight;
    }

    public void setAbWeight(int abWeight) {
        this.abWeight = abWeight;
    }

    @Override
    public String toString() {
        return "Token{" +
                "zhName='" + zhName + '\'' +
                ", enName='" + enName + '\'' +
                ", abName='" + abName + '\'' +
                ", weight=" + weight +
                ", enWeight=" + enWeight +
                ", abWeight=" + abWeight +
                '}';
    }
}