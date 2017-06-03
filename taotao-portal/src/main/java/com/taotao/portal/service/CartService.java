package com.taotao.portal.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.portal.pojo.CartItem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Description：
 *
 * @author: ChenXiangzhen
 * create 2017-06-03-9:56
 */
public interface CartService {

    TaotaoResult addCart(Long itemId, Integer num, HttpServletRequest request, HttpServletResponse response);

    List<CartItem> getCartItems(HttpServletRequest request);

    TaotaoResult updateCartItem(Long itemId, Integer num, HttpServletRequest request, HttpServletResponse response);
}
