package com.szss.mongodb.test.connection;

import com.szss.mongodb.test.crud.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * Created by zcg on 15/9/17.
 */
public class MongoApp {

    public static final void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MongoTemplate mongoTemplate=context.getBean(MongoTemplate.class);
        Person person=new Person("Tom",1);
        mongoTemplate.insert(person);
        Person p=mongoTemplate.findOne(new Query(Criteria.where("name").is("Tom")),Person.class);
        System.out.println(p);
        mongoTemplate.dropCollection("person");
    }
}
