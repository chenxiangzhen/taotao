package com.taotao.portal.controller;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.portal.pojo.CartItem;
import com.taotao.portal.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Description：
 *
 * @author: ChenXiangzhen
 * create 2017-06-03-11:20
 */
@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("/cart/add/{itemId}")
    public String addCart(@PathVariable long itemId, int num, HttpServletRequest request, HttpServletResponse response) {
        TaotaoResult result = cartService.addCart(itemId, num, request, response);
        return "cartSuccess";
    }

    @RequestMapping("/cart/cart")
    public String showCartList(HttpServletRequest request, Model model) {
        List<CartItem> list = cartService.getCartItems(request);
        model.addAttribute("cartList", list);
        return "cart";
    }

    @RequestMapping("/cart/update/num/{itemId}/{num}")
    public TaotaoResult updateCartItemNum(@PathVariable Long itemId, @PathVariable Integer num,
                                          HttpServletRequest request, HttpServletResponse response) {
        TaotaoResult result = cartService.updateCartItem(itemId,num, request, response);
        return result;
    }

    @RequestMapping("/cart/delete/{itemId}")
    public String deleteCartItem(@PathVariable Long itemId, HttpServletRequest request, HttpServletResponse response) {
        TaotaoResult result = cartService.deleteCartItem(itemId, request, response);
        return "redirect:/cart/cart.html";
    }
}
