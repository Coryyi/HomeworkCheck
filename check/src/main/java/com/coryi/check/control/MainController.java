package com.coryi.check.control;

import com.coryi.check.serve.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @Autowired
    FileService fileService;

    /*@GetMapping("./login")
    @ResponseBody
    public String testLogin(Module module){
        return "login";
    }*/
}