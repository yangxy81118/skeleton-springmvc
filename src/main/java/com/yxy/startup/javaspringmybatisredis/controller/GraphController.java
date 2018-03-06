package com.yxy.startup.javaspringmybatisredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yxy.startup.javaspringmybatisredis.service.GraphBaseService;

import graphql.ExecutionResult;

@RequestMapping("/zheshiyigeshenqide_request")
@RestController
public class GraphController {

	@Autowired
	private GraphBaseService graphBaseService;
	
	@PostMapping
	public ResponseEntity<Object> requestHandler(@RequestBody String query){
		System.out.println("Body:"+query);
		ExecutionResult result = graphBaseService.getGraphQL().execute(query);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
