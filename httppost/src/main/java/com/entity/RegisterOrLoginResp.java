package com.entity;


public class RegisterOrLoginResp {
    /**
     * Status Code：
     200 : Success
     401 : Wrong username and password
     505 : Channel system under maintenance
     4026 : Wrong Signature
     4027 : IP is not authorized
     */
    private int status;
    //Subchannel ID that was created by channel maintenance and if not have return 0.
    private int subChannelId;
    //After login user can automatically get a new accesstoken for next token login
    private String accessToken;

    private String username;

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public int getSubChannelId() {
        return subChannelId;
    }
    public void setSubChannelId(int subChannelId) {
        this.subChannelId = subChannelId;
    }
    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
