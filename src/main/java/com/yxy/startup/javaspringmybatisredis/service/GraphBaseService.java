package com.yxy.startup.javaspringmybatisredis.service;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.yxy.startup.javaspringmybatisredis.dao.AuthorDataFetcher;
import com.yxy.startup.javaspringmybatisredis.service.fetcher.BookDataFetcher;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import graphql.schema.idl.errors.SchemaProblem;

@Service
public class GraphBaseService {
	
	@Value("classpath:root.graphql")
	Resource resource;
	
	private GraphQL graphQL;
	
	@Autowired
	private BookDataFetcher bookFetcher;
	
	@Autowired
	private AuthorDataFetcher authorFetcher;
	
	@PostConstruct
	public void loalSchema() throws SchemaProblem, IOException {
		
		long s1 = System.currentTimeMillis();
		
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(resource.getFile());
		RuntimeWiring typeContent = bulidWritingContent();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, typeContent);
		graphQL = GraphQL.newGraphQL(schema).build();
		
		System.out.println("Load schema Cost : " + (System.currentTimeMillis() - s1));
		
	}

	private RuntimeWiring bulidWritingContent() {
		
		//这里最好能够熟悉一下lamada，变成spring 注解模式的方式自动装配dataFetcher
		return RuntimeWiring.newRuntimeWiring()
				.type("Query", typeW -> typeW
						.dataFetcher("book", bookFetcher)
						.dataFetcher("author", authorFetcher)
						)
				.build();
	}

	public GraphQL getGraphQL() {
		return graphQL;
	}
}
