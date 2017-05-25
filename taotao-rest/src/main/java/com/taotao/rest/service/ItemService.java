package com.taotao.rest.service;

import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamItem;

/**
 * Description：
 *
 * @author: ChenXiangzhen
 * create 2017-05-25-18:47
 */
public interface ItemService {

    TbItem getItemById(Long itemId);

    TbItemDesc getItemDescById(Long itemId);

    TbItemParamItem getItemParamById(Long itemId);
}
