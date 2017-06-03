package com.taotao.order.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.order.pojo.OrderInfo;

/**
 * Description：
 *
 * @author: ChenXiangzhen
 * create 2017-06-03-16:48
 */
public interface OrderService {

    TaotaoResult createOrder(OrderInfo orderInfo);
}
