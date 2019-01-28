package com.controller;

import com.entity.Rseponse;
import com.utils.ToRSA;
import com.utils.ToSig;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.codehaus.jackson.map.ObjectMapper;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.ArrayList;

public class ebetAPI {

    public static void userinfo() throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        ToSig properties = new ToSig();

        //設置請求地址
        HttpPost httpPost = new HttpPost(properties.getProValue("APIurl")+"userinfo");


        //生成timetimestamp
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long timestring = timestamp.getTime();
        String mytimestamp = Long.toString(timestring);

        //產生signature
        String sign = String.valueOf("benji"+ mytimestamp); // username + timestamp

        byte[] data;
        data = sign.getBytes("UTF-8");
        String privateKey = properties.getProValue("privateKey"); // 獲取資源

        System.out.println(ToRSA.sign(data, privateKey));
        System.out.println("------------------------------");

        //參數
        ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("channelId", properties.getProValue("channelId")));
        params.add(new BasicNameValuePair("username", "benji"));
        params.add(new BasicNameValuePair("timestamp", mytimestamp));
        params.add(new BasicNameValuePair("signature", ToRSA.sign(data, privateKey)));

        httpPost.setEntity(new UrlEncodedFormEntity(params)); // url encode
        CloseableHttpResponse response = client.execute(httpPost); // 發送請求


        // 獲取 response
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder builder = new StringBuilder();
        String line = "";

        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }

        ObjectMapper mapper = new ObjectMapper();
        Rseponse resp = mapper.readValue(builder.toString(),Rseponse.class);
        System.out.println(resp.getuserinfoLog());
    }

    public static void syncuser() throws Exception {

        CloseableHttpClient client = HttpClients.createDefault();
        ToSig properties = new ToSig();

        //設置請求地址
        HttpPost httpPost = new HttpPost(properties.getProValue("APIurl")+"syncuser");

        //生成timetimestamp
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long timestring = timestamp.getTime();
        String mytimestamp = Long.toString(timestring);

        //產生signature
        String sign = String.valueOf("benji"); // username + timestamp

        byte[] data;
        data = sign.getBytes("UTF-8");
        String privateKey = properties.getProValue("privateKey"); // 獲取資源

        System.out.println(ToRSA.sign(data, privateKey));
        System.out.println("------------------------------");

        //參數
        ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("channelId", properties.getProValue("channelId")));
        params.add(new BasicNameValuePair("subChannelId", "0"));
        params.add(new BasicNameValuePair("username", "benji"));
        params.add(new BasicNameValuePair("lang", "2"));
        params.add(new BasicNameValuePair("signature", ToRSA.sign(data, privateKey)));

        httpPost.setEntity(new UrlEncodedFormEntity(params)); // url encode
        CloseableHttpResponse response = client.execute(httpPost); // 發送請求


        // 獲取 response
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder builder = new StringBuilder();
        String line = "";

        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }

        ObjectMapper mapper = new ObjectMapper();
        Rseponse resp = mapper.readValue(builder.toString(),Rseponse.class);
        System.out.println(resp.getsyncuserLog());
    }
}
