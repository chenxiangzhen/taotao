package com.taotao.order.service.impl;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbOrderItemMapper;
import com.taotao.mapper.TbOrderMapper;
import com.taotao.mapper.TbOrderShippingMapper;
import com.taotao.order.component.JedisClient;
import com.taotao.order.pojo.OrderInfo;
import com.taotao.order.service.OrderService;
import com.taotao.pojo.TbOrderItem;
import com.taotao.pojo.TbOrderShipping;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Description：
 *
 * @author: ChenXiangzhen
 * create 2017-06-03-16:48
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private TbOrderMapper orderMapper;
    @Autowired
    private TbOrderItemMapper orderItemMapper;
    @Autowired
    private TbOrderShippingMapper orderShippingMapper;
    @Autowired
    private JedisClient jedisClient;
    @Value("${REDIS_ORDER_GEN_KEY}")
    private String REDIS_ORDER_GEN_KEY;
    @Value("${ORDER_ID_BEGIN}")
    private String ORDER_ID_BEGIN;
    @Value("${REDIS_ORDER_DETAIL_GEN_KEY}")
    private String REDIS_ORDER_DETAIL_GEN_KEY;

    @Override
    public TaotaoResult createOrder(OrderInfo orderInfo) {
        // 一、插入订单表
        // 1、接收数据OrderInfo
        // 2、生成订单号
        //取订单号
        String id = jedisClient.get(REDIS_ORDER_GEN_KEY);
        if (StringUtils.isBlank(id)) {
            //如果订单号生成key不存在设置初始值
            jedisClient.set(REDIS_ORDER_GEN_KEY, ORDER_ID_BEGIN);
        }
        Long orderId = jedisClient.incr(REDIS_ORDER_GEN_KEY);
        // 3、补全字段
        orderInfo.setOrderId(orderId.toString());
        //状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭
        orderInfo.setStatus(1);
        Date date = new Date();
        orderInfo.setCreateTime(date);
        orderInfo.setUpdateTime(date);
        // 4、插入订单表
        orderMapper.insert(orderInfo);
        // 二、插入订单明细
        // 2、补全字段
        List<TbOrderItem> orderItems = orderInfo.getOrderItems();
        for (TbOrderItem orderItem : orderItems) {
            // 1、生成订单明细id，使用redis的incr命令生成。
            Long detailId = jedisClient.incr(REDIS_ORDER_DETAIL_GEN_KEY);
            orderItem.setId(detailId.toString());
            //订单号
            orderItem.setOrderId(orderId.toString());
            // 3、插入数据
            orderItemMapper.insert(orderItem);
        }
        // 三、插入物流表
        TbOrderShipping orderShipping = orderInfo.getOrderShipping();
        // 1、补全字段
        orderShipping.setOrderId(orderId.toString());
        orderShipping.setCreated(date);
        orderShipping.setUpdated(date);
        // 2、插入数据
        orderShippingMapper.insert(orderShipping);
        // 返回TaotaoResult包装订单号。
        return TaotaoResult.ok(orderId);

    }
}
