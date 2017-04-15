package com.taotao.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

/**
 * Description：后台商品内容管理
 *
 * @author: ChenXiangzhen
 * create 2017-04-15-14:26
 */
public interface ContentService {

    TaotaoResult insertContent(TbContent content);
}
