package com.taotao.portal.controller;

import com.taotao.pojo.TbItem;
import com.taotao.portal.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description：展示商品详情页面
 *
 * @author: ChenXiangzhen
 * create 2017-05-30-17:08
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/{itemId}")
    public String showItemInfo(@PathVariable Long itemId, Model model) {
        TbItem item = itemService.getItemById(itemId);
        model.addAttribute("item", item);
        return "item";
    }

    @RequestMapping(value = "/item/desc/{itemId}", produces= MediaType.TEXT_HTML_VALUE+";charset=utf-8")
    @ResponseBody
    public String getItemDesc(@PathVariable Long itemId) {
        String desc = itemService.getItemDescById(itemId);
        return desc;
    }

    @RequestMapping(value = "/item/param/{itemId}", produces = MediaType.TEXT_HTML_VALUE+";charset=utf-8")
    @ResponseBody
    public String getItemParam(@PathVariable Long itemId) {
        String paramHtml = itemService.getItemParamById(itemId);
        return paramHtml;
    }
}
