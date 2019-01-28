package com.entity;
import java.util.List;
import java.util.ArrayList;

public class Rseponse {


    private String username;
    private String apiVersion;
    private String rechargeReqId;
    private int channelId;
    private int subChannelId;
    private int userId;
    private Double money;
    private int timestamp;
    private int status;
    private String signature;


    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getapiVersion() {
        return apiVersion;
    }
    public void setapiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }
    public int getChannelId() {
        return channelId;
    }
    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }
    public int getSubChannelId() {
        return subChannelId;
    }
    public void setSubChannelId(int subChannelId) {
        this.subChannelId = subChannelId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public Double getMoney() {
        return money;
    }
    public void setMoney(Double money) {
        this.money = money;
    }
    public int getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getSignature() {
        return signature;
    }
    public void setSignature(String signature) {
        this.signature = signature;
    }


    private List wallet;

    public List getwallet(){
        return this.wallet;
    }

    public void setwallet(List platforms){
        this.wallet = platforms;
    }

    public String getuserinfoLog() {
        return "userinfo [ username=" + username + ", channelId=" + channelId
                + ", subChannelId=" + subChannelId + ", userId=" + userId
                +", money=" + money +", wallet=" + wallet +
                ", timestamp=" + timestamp +", status=" + status+ "]";
    }
    public String getsyncuserLog() {
        return "syncuser [ status=" + status+ "]";
    }

}
