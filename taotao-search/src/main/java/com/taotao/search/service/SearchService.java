package com.taotao.search.service;

import com.taotao.search.pojo.SearchResult;

/**
 * Description：
 *
 * @author: ChenXiangzhen
 * create 2017-05-02-20:37
 */
public interface SearchService {

    SearchResult search(String queryString, int page, int rows) throws Exception;
}
