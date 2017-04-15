package com.taotao.portal.controller;

import com.taotao.portal.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description：IndexController
 *
 * @author: ChenXiangzhen
 * create 2017-04-14-14:23
 */
@Controller
public class IndexController {

    @Autowired
    private ContentService contentService;

    @RequestMapping("/index")
    public String showIndex(Model model) {
        // 获取大广告位
        String json = contentService.getAd1List();
        model.addAttribute("ad1", json);
        return "index";
    }
}
