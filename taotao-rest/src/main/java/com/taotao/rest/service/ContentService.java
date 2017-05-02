package com.taotao.rest.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

import java.util.List;

/**
 * Description：
 *
 * @author: ChenXiangzhen
 * create 2017-04-15-14:54
 */
public interface ContentService {

    List<TbContent> getContentList(Long cid);

    TaotaoResult syncContent(Long cid);
}
