package com.taotao.service;

import com.taotao.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * Description：
 *
 * @author: ChenXiangzhen
 * create 2017-04-15-13:54
 */
public interface ContentCategoryService {

    List<EasyUITreeNode> getContentCatList(Long parentId);
}
