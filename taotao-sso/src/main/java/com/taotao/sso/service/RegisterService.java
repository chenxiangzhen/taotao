package com.taotao.sso.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbUser;

/**
 * Description：
 *
 * @author: ChenXiangzhen
 * create 2017-05-30-18:54
 */
public interface RegisterService {

    TaotaoResult checkData(String param, int type);

    TaotaoResult register(TbUser user);
}
