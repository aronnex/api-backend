package com.aron.apiinterface.controller;
import com.api.apiclientsdk.model.User;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;


// 名称API
@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/")
    public  String getNameByGet(String name){

        return "GET 你的名字是" + name;
    }

    @PostMapping("/")
    public String getNameByPost(@RequestParam  String name) {

        return "POST 你的名字是" + name;
    }

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user, HttpServletRequest request){
//        String accessKey = request.getHeader("accessKey");
//        String nonce = request.getHeader("nonce");
//        String timestamp = request.getHeader("timestamp");
//        String sign = request.getHeader("sign");
//        String body = request.getHeader("body");
//        if(!accessKey.equals("test")){
//            throw new RuntimeException("无权限");
//        }
//        if (Long.parseLong(nonce) > 10000){
//            throw new RuntimeException("无权限");
//        }
//        String serverSign = SignUtils.genSign(body,"123456789");
//        if (!sign.equals(serverSign)){
//            throw new RuntimeException("无权限");
//        }
        String result = "POST 用户的名字是" + user.getUsername();
        return result;
    }


}

