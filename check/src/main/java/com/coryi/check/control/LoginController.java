package com.coryi.check.control;

import com.coryi.check.model.User;
import com.coryi.check.result.Result;
import com.coryi.check.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;
import java.util.Objects;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    /*@CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody*/
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

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username, requestUser.getPassword());
        if (null == user) {
            return new Result(400);
        } else {
            return new Result(200);
        }
    }

    @CrossOrigin
    @PostMapping(value = "api/register")
    @ResponseBody
    public Result register(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        String password = requestUser.getPassword();
        boolean ifAdd = userService.add(username,password);
        if(ifAdd){
            return new Result(200);
        }else {
            return new Result(400);
        }
    }
}
