package com.taotao.service.impl;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Description：
 *
 * @author: ChenXiangzhen
 * create 2017-04-15-14:28
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private TbContentMapper tbContentMapper;

    @Override
    public TaotaoResult insertContent(TbContent content) {
        content.setCreated(new Date());
        content.setUpdated(new Date());
        tbContentMapper.insert(content);
        return TaotaoResult.ok();
    }
}
