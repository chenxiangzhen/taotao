package com.taotao.search.service.impl;

import com.taotao.search.dao.SearchDao;
import com.taotao.search.pojo.SearchResult;
import com.taotao.search.service.SearchService;
import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description：
 *
 * @author: ChenXiangzhen
 * create 2017-05-02-20:37
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchDao searchDao;

    @Override
    public SearchResult search(String queryString, int page, int rows) throws Exception {
        //创建查询条件
        SolrQuery query = new SolrQuery();
        //设置查询条件
        query.setQuery(queryString);
        //设置分页条件
        query.setStart((page-1)*rows);
        query.setRows(rows);
        //设置默认搜索域
        query.set("df", "item_title");
        //设置高亮
        query.setHighlight(true);
        query.addHighlightField("item_title");
        query.setHighlightSimplePre("<font class=\"skcolor_ljg\">");
        query.setHighlightSimplePost("</font>");
        //执行查询
        SearchResult searchResult = searchDao.search(query);
        //计算总页数
        Long recordCount = searchResult.getRecordCount();
        int pageCount = (int) (recordCount / rows);
        if (recordCount % rows > 0) {
            pageCount++;
        }
        searchResult.setPageCount(pageCount);
        searchResult.setCurPage(page);
        return searchResult;
    }
}
