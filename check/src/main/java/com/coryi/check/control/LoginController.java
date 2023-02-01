package com.coryi.check.control;

import com.coryi.check.model.User;
import com.coryi.check.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.Map;
import java.util.Objects;

@Controller
public class LoginController {
    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result loginCheck(@RequestBody User requestUser){
        // 对 html 标签进行转义，防止 XSS 攻击

        String username = requestUser.getUsername();
        System.out.println("username:"+username);
        username = HtmlUtils.htmlEscape(username);

        if (!Objects.equals("coryi", username) || !Objects.equals("123456", requestUser.getPassword())) {
            String message = "账号密码错误";
            System.out.println("test");
            return new Result(400);
        } else {
            System.out.println("true");
            return new Result(200);
        }

    }
}
