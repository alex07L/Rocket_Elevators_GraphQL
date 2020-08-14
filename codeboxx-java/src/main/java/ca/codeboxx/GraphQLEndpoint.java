package ca.codeboxx;

import com.coxautodev.graphql.tools.SchemaParser;

import javax.servlet.annotation.WebServlet;

import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;


@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

    public GraphQLEndpoint() {
        super(buildSchema());
    }
    
    private static GraphQLSchema buildSchema() {
        return SchemaParser.newParser()
    	.file("schema.graphqls")
    	.resolvers(new Query(), new Mutation())
    	.build()
    	.makeExecutableSchema();
    }
    
	
}
