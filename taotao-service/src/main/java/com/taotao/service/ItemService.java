package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

/**
 * Description：ItemService
 *
 * @author: ChenXiangzhen
 * create 2017-04-12-14:48
 */
public interface ItemService {

    public TbItem getItemById(Long itemId);

    EasyUIDataGridResult getItemList(int page, int rows);

    TaotaoResult creatItem(TbItem item, String desc);

}
