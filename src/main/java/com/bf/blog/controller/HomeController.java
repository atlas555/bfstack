package com.bf.blog.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title:
 * @Desc:
 * @Author zhangxiaolong
 * @Date 2015-10-27 14:05.
 */
@RestController
@RequestMapping("/home")
@Slf4j
public class HomeController {

    private static ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(method = RequestMethod.POST, path="/catalogue", produces = "application/json")
    public ResponseData getCatalogue() {

        ArrayNode arrayNode = mapper.createArrayNode();

        ObjectNode node1 = mapper.createObjectNode();
        node1.put("id", 6);
        node1.put("name", "html");
        node1.put("count", 30);

        ObjectNode node2 = mapper.createObjectNode();
        node2.put("id", 7);
        node2.put("name", "css");
        node2.put("count", 10);

        ObjectNode node3 = mapper.createObjectNode();
        node3.put("id", 3);
        node3.put("name", "js");
        node3.put("count", 20);
        arrayNode.add(node1);
        arrayNode.add(node2);
        arrayNode.add(node3);

        ArrayNode nodes2 = mapper.createArrayNode();

        ObjectNode node21 = mapper.createObjectNode();
        node21.put("id", 4);
        node21.put("name", "Java");
        node21.put("count", 30);

        ObjectNode node22 = mapper.createObjectNode();
        node22.put("id", 5);
        node22.put("name", "shell");
        node22.put("count", 10);

        ObjectNode node23 = mapper.createObjectNode();
        node23.put("id", 6);
        node23.put("name", "分布式系统");
        node23.put("count", 20);
        nodes2.add(node21);
        nodes2.add(node22);
        nodes2.add(node23);

        ObjectNode i = mapper.createObjectNode();
        i.put("id", 1);
        i.put("name", "web前端开发");
        i.set("sub", arrayNode);

        ObjectNode i2 = mapper.createObjectNode();
        i2.put("id", 2);
        i2.put("name", "服务端开发");
        i2.set("sub", nodes2);

        ArrayNode arrayNode1 = mapper.createArrayNode();

        arrayNode1.add(i);
        arrayNode1.add(i2);

        return ResponseData.getOKResult(arrayNode1);
    }

    @RequestMapping(method = RequestMethod.POST, path="/comment", produces = "application/json")
    public ResponseData getComment(@RequestParam(value = "num") Integer num) {

        ObjectNode i = mapper.createObjectNode();
        i.put("id", 3);
        i.put("content", "真好");
        i.put("writer", "atlas");

        ObjectNode j = mapper.createObjectNode();
        j.put("id", 4);
        j.put("content", "真好,史蒂夫玩儿水电费水电费水电费双打三大范围发生的发生的");
        j.put("writer", "atlas");

        ArrayNode arrayNode = mapper.createArrayNode();
        arrayNode.add(i);
        arrayNode.add(j);

        return ResponseData.getOKResult(arrayNode);
    }

    @RequestMapping(method = RequestMethod.POST, path="/recentOne", produces = "application/json")
    public ResponseData getRecent() {

        ObjectNode i = mapper.createObjectNode();
        i.put("id", 1123);
        i.put("title", "理解APACHE SOLR默认的评分机制");
        i.put("content", "Apache Solr是基于Apache Lucene的企业级开源平台。希望通过本文你能了解Solr/Lucene的默认评分机制，以及哪些因子会影响搜索结果的排序。\n" + "\n"
            + "首先看一下Lucene的评分公式，\n" + "\n" + "图像\n" + "\n" + "以下是对公式中各个因子的详细解释：\n" + "\n"
            + "1.       tf(t in d) 关联词出现的频率，词频率是指搜索词t 在文档d 中出现的次数。文档中搜索词出现次数越多总评分也就越高。tf(t in d)默认的实现是：图像");
        i.put("author", "atlas");
        i.put("catalogId", 5);
        i.put("catalogName", "服务端框架");
        i.put("createTime", System.currentTimeMillis());
        i.put("views", 1025);
        i.put("comments", 5);

        return ResponseData.getOKResult(i);
    }

    @RequestMapping(method = RequestMethod.POST, path="/recentList", produces = "application/json")
    public ResponseData getRecentList(@RequestParam(value = "num") Integer num) {

        ObjectNode i = mapper.createObjectNode();
        i.put("id", 1123);
        i.put("title", "理解APACHE SOLR默认的评分机制");
        i.put("author", "atlas");
        i.put("catalogId", 5);
        i.put("catalogName", "服务端框架");
        i.put("createTime", System.currentTimeMillis());
        i.put("views", 1025);
        i.put("comments", 5);

        ObjectNode j = mapper.createObjectNode();
        j.put("id", 1123);
        j.put("title", "理解APACHE SOLR默认的评分机制");
        j.put("author", "atlas");
        j.put("catalogId", 5);
        j.put("catalogName", "服务端框架");
        j.put("createTime", System.currentTimeMillis());
        j.put("views", 1025);
        j.put("comments", 5);

        ArrayNode arrayNode = mapper.createArrayNode();
        arrayNode.add(i);
        arrayNode.add(j);

        return ResponseData.getOKResult(arrayNode);
    }

    @RequestMapping(method = RequestMethod.POST, path="/recentMore", produces = "application/json")
    public ResponseData getRecentMore(@RequestParam(value = "page") Integer page, @RequestParam(value = "size") Integer size) {

        ObjectNode i = mapper.createObjectNode();
        i.put("id", 1123);
        i.put("title", "理解APACHE SOLR默认的评分机制");
        i.put("author", "atlas");
        i.put("catalogId", 5);
        i.put("catalogName", "服务端框架");
        i.put("createTime", System.currentTimeMillis());
        i.put("views", 1025);
        i.put("comments", 5);

        ObjectNode j = mapper.createObjectNode();
        j.put("id", 1123);
        j.put("title", "理解APACHE SOLR默认的评分机制");
        j.put("author", "atlas");
        j.put("catalogId", 5);
        j.put("catalogName", "服务端框架");
        j.put("createTime", System.currentTimeMillis());
        j.put("views", 1025);
        j.put("comments", 5);

        ArrayNode arrayNode = mapper.createArrayNode();
        arrayNode.add(i);
        arrayNode.add(j);

        return ResponseData.getOKResult(arrayNode);
    }
}
