package com.szss.mongodb.test.connection;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.net.UnknownHostException;

/**
 * Created by zcg on 15/9/17.
 */
@Configuration
public class AppConfig {

    @Bean
    public Mongo mongo() throws UnknownHostException {
        return new Mongo();
    }

    @Bean
    public MongoDbFactory mongoDbFactory()  throws UnknownHostException{
        MongoClient client=new MongoClient("127.0.0.1",27017);
        SimpleMongoDbFactory factoryBean = new SimpleMongoDbFactory(client,"database");
        return factoryBean;
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory){
        return new MongoTemplate(mongoDbFactory);
    }
}
