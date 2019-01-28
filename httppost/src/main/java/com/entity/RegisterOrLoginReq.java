package com.entity;
/**
 * Account/password login request entity
 * @author
 *
 */
public class RegisterOrLoginReq {
    //value is RegisterOrLoginReq
    private String cmd;

    private int eventType;

    private int channelId;
    //User login name (all lowercase)
    private String username;

    private String password;
    //RSA: username+timestamp
    private String signature;
    //Unix time
    private int timestamp;
    //The player IP
    private String ip;
    //token （Hand Gestures or Thumbprint）
    private String accessToken;



    public String getCmd() {
        return cmd;
    }
    public void setCmd(String cmd) {
        this.cmd = cmd;
    }
    public int getEventType() {
        return eventType;
    }
    public void setEventType(int eventType) {
        this.eventType = eventType;
    }
    public int getChannelId() {
        return channelId;
    }
    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getSignature() {
        return signature;
    }
    public void setSignature(String signature) {
        this.signature = signature;
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
    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public String toString() {
        return "RegisterOrLoginReq [cmd=" + cmd + ", eventType=" + eventType
                + ", channelId=" + channelId + ", username=" + username
                + ", password=" + password + ", signature=" + signature
                + ", timestamp=" + timestamp + ", ip=" + ip + ", accessToken="
                + accessToken + "]";
    }
}
