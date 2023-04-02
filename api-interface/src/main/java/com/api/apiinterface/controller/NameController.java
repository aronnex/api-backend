package com.api.apiinterface.controller;
import com.api.apiclientsdk.model.User;
import com.api.apiclientsdk.utils.SignUtils;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

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
        String accessKey = request.getHeader("accessKey");
        String nonce = request.getHeader("nonce");
        String timestamp = request.getHeader("timestamp");
        String sign = request.getHeader("sign");
        String body = request.getHeader("body");
        //todo 实际情况应该是去数据库中查是否已分配给用户
        if(!accessKey.equals("test")){
            throw new RuntimeException("无权限");
        }
        if (Long.parseLong(nonce) > 10000){
            throw new RuntimeException("无权限");
        }
        //时间和当前时间不能超过5分钟
        if(!isWithinFiveMinutes(timestamp)){
            throw new RuntimeException("无权限");
        }
        //todo 实际情况是中是从数据库中查出
        String serverSign = SignUtils.genSign(body,"123456789");
        if (!sign.equals(serverSign)){
            throw new RuntimeException("无权限");
        }

        return "POST 用户的名字是" + user.getUsername();
    }


    //校验时间戳
    public static boolean isWithinFiveMinutes(String timeStamp) {
        long timeStampSeconds = Long.parseLong(timeStamp);
        Instant now = Instant.now();
        Instant timeStampInstant = Instant.ofEpochSecond(timeStampSeconds);
        long secondsBetween = ChronoUnit.SECONDS.between(timeStampInstant, now);
        return secondsBetween <= 300;
    }
}

