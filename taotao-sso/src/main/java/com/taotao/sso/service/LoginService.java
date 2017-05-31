package com.taotao.sso.service;

import com.taotao.common.pojo.TaotaoResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description：
 *
 * @author: ChenXiangzhen
 * create 2017-05-30-20:01
 */
public interface LoginService {

    TaotaoResult login(String username, String password, HttpServletRequest request, HttpServletResponse response);
}
