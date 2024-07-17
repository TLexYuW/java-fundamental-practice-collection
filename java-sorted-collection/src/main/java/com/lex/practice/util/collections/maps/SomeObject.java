package com.lex.practice.util.collections.maps;

/**
 * @author : Lex Yu
 */
public class SomeObject {
    private String masterKey;
    private String parentKey;
    private String latestKey;

    public SomeObject(String masterKey, String parentKey, String latestKey) {
        this.masterKey = masterKey;
        this.parentKey = parentKey;
        this.latestKey = latestKey;
    }

    public String getMasterKey() {
        return masterKey;
    }

    public void setMasterKey(String masterKey) {
        this.masterKey = masterKey;
    }

    public String getParentKey() {
        return parentKey;
    }

    public void setParentKey(String parentKey) {
        this.parentKey = parentKey;
    }

    public String getLatestKey() {
        return latestKey;
    }

    public void setLatestKey(String latestKey) {
        this.latestKey = latestKey;
    }

    @Override
    public String toString() {
        return "SomeObject{" +
                "masterKey='" + masterKey + '\'' +
                ", parentKey='" + parentKey + '\'' +
                ", latestKey='" + latestKey + '\'' +
                '}';
    }
}
