package com.taotao.solrj;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

/**
 * Description：
 *
 * @author: ChenXiangzhen
 * create 2017-05-02-19:06
 */
public class SolrJTest {

    @Test
    public void testSolrJ() throws Exception {
        // 创建连接
        SolrServer solrServer = new HttpSolrServer("http://192.168.204.132:8080/solr");
        // 创建一个文档对象
        SolrInputDocument document = new SolrInputDocument();
        document.addField("id", "solrtest01");
        document.addField("item_title", "测试商品");
        document.addField("item_sell_point", "卖点");
        // 添加到索引库
        solrServer.add(document);
        // 提交
        solrServer.commit();
    }

    @Test
    public void testQuery() throws Exception {
        // 创建连接
        SolrServer solrServer = new HttpSolrServer("http://192.168.204.132:8080/solr");
        // 创建一个查询对象
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery("*:*");
        // 执行查询
        QueryResponse queryResponse = solrServer.query(solrQuery);
        // 取查询结果
        SolrDocumentList solrDocumentList = queryResponse.getResults();
        for (SolrDocument solrDocument : solrDocumentList) {
            System.out.println(solrDocument.get("id"));
            System.out.println(solrDocument.get("item_title"));
            System.out.println(solrDocument.get("item_sell_point"));
        }
    }
}
