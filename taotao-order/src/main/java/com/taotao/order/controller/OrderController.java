package com.taotao.order.controller;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.ExceptionUtil;
import com.taotao.order.pojo.OrderInfo;
import com.taotao.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description：
 *
 * @author: ChenXiangzhen
 * create 2017-06-03-17:02
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order/create", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult createOrder(@RequestBody OrderInfo orderInfo) {
        try {
            TaotaoResult result = orderService.createOrder(orderInfo);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
        }
    }

}
