package com.taotao.service;

import com.taotao.common.pojo.TaotaoResult;

/**
 * Description：
 *
 * @author: ChenXiangzhen
 * create 2017-04-13-15:11
 */
public interface ItemParamService {

    /**
     * 根据分类id获取规格参数
     * @param cid
     * @return
     */
    TaotaoResult getItemParamByCid(Long cid);

    /**
     * 插入规格参数
     * @param cid
     * @param paramData
     * @return
     */
    TaotaoResult insertItemParam(Long cid, String paramData);
}
