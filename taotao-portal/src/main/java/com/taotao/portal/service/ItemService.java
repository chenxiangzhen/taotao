package com.taotao.portal.service;

import com.taotao.pojo.TbItem;

/**
 * Description：
 *
 * @author: ChenXiangzhen
 * create 2017-05-30-16:59
 */
public interface ItemService {

    TbItem getItemById(Long itemId);

    String getItemDescById(Long itemId);

    String getItemParamById(Long itemId);
}
