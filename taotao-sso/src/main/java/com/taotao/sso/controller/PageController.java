package com.taotao.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description：展示注册和登录页面
 *
 * @author: ChenXiangzhen
 * create 2017-05-31-17:32
 */
@Controller
public class PageController {

    @RequestMapping("/page/login")
    public String showLogin(String redirectURL, Model model) {
        // 把参数传递给jsp
        model.addAttribute("redirect", redirectURL);
        return "login";
    }

    @RequestMapping("/page/register")
    public String showRegister() {
        return "register";
    }

}
