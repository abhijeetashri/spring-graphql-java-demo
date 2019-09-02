package com.graphql.demo.service;

import java.io.IOException;

import org.springframework.core.io.Resource;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

public abstract class AbstractService {

	protected GraphQL graphQL;

	public GraphQL graphQL() {
		return graphQL;
	}

	protected void buildSchema(Resource resourceFile) throws IOException {
		TypeDefinitionRegistry tdr = new SchemaParser().parse(resourceFile.getFile());
		RuntimeWiring wiring = buildWiring();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(tdr, wiring);
		graphQL = GraphQL.newGraphQL(schema).build();
	}

	protected abstract RuntimeWiring buildWiring();
}
