package com.entity;
/**
 * User Info (Post back)
 * Input Parameter
 * @author Monaco
 *
 */
public class UserInfoReq {
    //value is UserInfo
    private String cmd;
    //User login name (all lowercase)
    private String username;
    private int channelId;
    private int subChannelId;
    private int userId;
    private Double money;
    private int timestamp;
    private String ip;
    //RSA: username+timestamp
    private String signature;



    public String getCmd() {
        return cmd;
    }
    public void setCmd(String cmd) {
        this.cmd = cmd;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
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
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getSignature() {
        return signature;
    }
    public void setSignature(String signature) {
        this.signature = signature;
    }
}
