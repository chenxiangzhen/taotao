package com.taotao.service;

import com.taotao.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * Description：ItemCatService
 *
 * @author: ChenXiangzhen
 * create 2017-04-12-16:40
 */
public interface ItemCatService {

    List<EasyUITreeNode> getItemCatList(long parentId);
}
