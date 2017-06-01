package com.taotao.portal.service;

import com.taotao.pojo.TbUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description：
 *
 * @author: ChenXiangzhen
 * create 2017-05-31-18:40
 */
public interface UserService {

    TbUser getUserByToken(HttpServletRequest request, HttpServletResponse response);

}
