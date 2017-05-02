package com.taotao.search.dao;

import com.taotao.search.pojo.SearchResult;
import org.apache.solr.client.solrj.SolrQuery;

/**
 * Description：
 *
 * @author: ChenXiangzhen
 * create 2017-05-02-20:28
 */
public interface SearchDao {

    SearchResult search(SolrQuery query) throws Exception;
}
