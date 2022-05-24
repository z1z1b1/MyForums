package com.example.demo.controller;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserByUser;
import com.example.demo.service.UserService;
//import com.example.demo.util.TokenUtil;

/**
 * @ClassName: LoginCONTROLLER
 * @Description:
 * @Author
 * @Date 2022/1/20
 * @Version 1.0
 */
@RestController
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping("login")
    @CrossOrigin(origins = "*")
    public String login(UserByUser user) throws JSONException {

       return "111";

    }

}
