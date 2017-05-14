package com.taotao.portal.service;


import com.taotao.portal.pojo.SearchResult;

/**
 * Description：
 *
 * @author: ChenXiangzhen
 * create 2017-05-14-13:14
 */
public interface SearchService {

    SearchResult search(String keyword, int page, int rows);
}
