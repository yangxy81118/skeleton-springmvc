package com.yxy.startup.javaspringmybatisredis.service.fetcher;

import java.util.List;

import org.springframework.util.ObjectUtils;

import graphql.language.Field;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

/**
 * Graphql数据获取类基类，公用一些常用操作
 * @author yangxy
 *
 * @param <T>
 */
public abstract class GraphqlDataFetcherAdapter<T> implements DataFetcher<T> {

	/**
	 * 检查fieldName对应的属性是否是在本次的查询请求中
	 * 
	 * @param context 上下文
	 * @param fieldName 
	 * @return
	 */
	protected boolean fieldIsSelected(DataFetchingEnvironment context, String fieldName) {
		List<Field> selectionField = context.getSelectionSet().get().get(fieldName);
		return ObjectUtils.isEmpty(selectionField);
	}
	
}
