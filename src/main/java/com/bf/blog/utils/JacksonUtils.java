/*
 * Copyright 2015 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package com.bf.blog.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Throwables;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Title: JacksonUtils.java
 * @author zhangxiaolong
 */
public class JacksonUtils {

    private final static ObjectMapper objMapper = new ObjectMapper();

    /**
     * 调用get方法生成json字符串 <br>
     * 2015年1月27日:下午12:26:55<br>
     * <br>
     * 
     * @param obj
     * @return
     * @throws IOException
     */
    public static String toJson(Object obj) {
        try {
            return objMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw Throwables.propagate(e);
        }
    }

    /**
     * 对obj对象进行序列话，序列化是依据jsonViewClazz的配置
     * 
     * @param obj
     * @param jsonViewClazz
     * @return
     */
    public static <T> String toJson(Object obj, Class<T> jsonViewClazz) {
        try {
            return objMapper.writerWithView(jsonViewClazz).writeValueAsString(
                obj);
        } catch (Exception e) {
            throw Throwables.propagate(e);
        }
    }

    /**
     * 转换成jsonnode
     * 
     * @param jsonText
     * @return
     */
    public static JsonNode toJsonNode(String jsonText) {
        JsonNode jsonNode = null;
        try {
            jsonNode = objMapper.readTree(jsonText);
        } catch (Exception e) {
            throw Throwables.propagate(e);
        }
        return jsonNode;
    }

    /**
     * 转换json为clazz. <br>
     * <strong>依赖get和set方法</strong> <br>
     * 2015年1月27日:下午12:26:18<br>
     * <br>
     * 
     * @param jsonText
     * @param clazz
     * @return
     * @throws IOException
     */
    public static <T> T fromJson(String jsonText, Class<T> clazz)
        throws IOException {
        if (jsonText == null || "".equals(jsonText)) {
            return null;
        }
//        objMapper.adapter(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false);
        return objMapper.readValue(jsonText, clazz);
    }

    /**
     * 转换为集合类型的对象集合 <strong>依赖get和set方法</strong> <br>
     * 2015年3月10日:上午11:19:14<br>
     * <br>
     * <strong>example:</strong>
     *
     * <pre>
     * JacksonUtils.fromJson(jsonText, new TypeReference&lt;List&lt;FeedImage&gt;&gt;() {
     * });
     * </pre>
     *
     * @param jsonText
     * @param valueTypeRef org.codehaus.jackson.type.TypeReference
     * @return
     * @throws Exception
     */
    public static <T> T fromJson(String jsonText, TypeReference<T> valueTypeRef)
        throws IOException {
        if (jsonText == null || "".equals(jsonText)) {
            return null;
        }
        objMapper.enableDefaultTyping();
        return objMapper.readValue(jsonText, valueTypeRef);
    }

    public static <T> List<T> getList(String jsonText, Class<T> clazz) throws IOException {

        JavaType javaType = objMapper.getTypeFactory().constructParametrizedType(List.class, List.class,clazz);

        return objMapper.readValue(jsonText,javaType);
    }


    /**
     * 从json字符串中读取出指定的节点 <br>
     * 2015年1月27日:下午12:26:04<br>
     * <br>
     * 
     * @param json
     * @param key
     * @return
     * @throws JsonProcessingException
     * @throws IOException
     */
    public static JsonNode getValueFromJson(String json, String key)
        throws JsonProcessingException, IOException {
        JsonNode node = objMapper.readTree(json);
        return node.get(key);
    }

    /**
     * 从json字符串中读取数组节点所包含的JsonNode List<br>
     * 2015年1月28日:下午18:26:04<br>
     * <br>
     * 
     * @param json
     * @param key
     * @return
     * @throws JsonProcessingException
     * @throws IOException
     */
    public static List<JsonNode> getListFromJson(String json, String key)
        throws JsonProcessingException, IOException {
        List<JsonNode> jsonNodes = null;
        JsonNode node = objMapper.readTree(json);
        JsonNode arrayNode = node.get(key);
        if (arrayNode.isArray()) {
            jsonNodes = new ArrayList<JsonNode>();
            for (JsonNode jsonNode : arrayNode) {
                jsonNodes.add(jsonNode);
            }
        }
        return jsonNodes;
    }
}
