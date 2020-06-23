package com.biblio;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
//@ComponentScan({ "com.biblio", "com.biblio.repository" })
//@ComponentScan(basePackages  = { "com.biblio", "com.biblio.repository" })
//@EnableMongoRepositories("com.biblio.repository.Mongo")
//@EnableElasticsearchRepositories("com.biblio.repository.Es")


public class BiblioApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiblioApplication.class, args);
	}

}
