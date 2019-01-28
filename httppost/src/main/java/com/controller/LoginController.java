package com.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.entity.RegisterOrLoginResp;
import com.entity.RegisterOrLoginReq;


@RestController
public class LoginController<T> {
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String ValidateLoginInfo (HttpServletRequest request, HttpServletResponse response) {
        try {

            //HTTP input stream
            InputStream reader = request.getInputStream();

            BufferedReader br =new BufferedReader(new InputStreamReader(reader));
            //Receive json String
            StringBuilder strbur= new StringBuilder();

            String jsonString = new String();
            while((jsonString = br.readLine()) != null) {
                strbur.append(jsonString);
            }

            RegisterOrLoginReq req = new RegisterOrLoginReq();
            RegisterOrLoginResp resp = new RegisterOrLoginResp();


            JSONObject jsonObj = JSON.parseObject(strbur.toString());
            String cmd = jsonObj.get("cmd").toString();

            System.out.println("Login : "+jsonObj.toString());

            if(cmd.equals("RegisterOrLoginReq")){
                req = JSON.parseObject(strbur.toString(),RegisterOrLoginReq.class);
            }

            switch(req.getEventType()){
                case 1:{
                    resp.setStatus(200);
                    resp.setSubChannelId(0);
                    resp.setAccessToken(req.getAccessToken());
                    resp.setUsername(req.getUsername());

                    return JSON.toJSONString(resp).toString();
                }
                case 3:{
                    resp.setStatus(200);
                    resp.setSubChannelId(0);
                    resp.setAccessToken(req.getAccessToken());
                    resp.setUsername(req.getUsername());

                    return JSON.toJSONString(resp).toString();
                }
                case 4:{
                    if(req.getAccessToken() != null && !req.getAccessToken().equals("")){
                        resp.setStatus(200);
                        resp.setSubChannelId(0);
                        resp.setAccessToken(req.getAccessToken());
                        resp.setUsername(req.getUsername());
                    }

                    return JSON.toJSONString(resp).toString();
                }
                default:{

                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
