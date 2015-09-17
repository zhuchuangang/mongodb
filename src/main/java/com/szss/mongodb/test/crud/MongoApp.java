package com.szss.mongodb.test.crud;

import com.mongodb.Mongo;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * Created by zcg on 15/9/17.
 */
public class MongoApp {

    public static final void main(String[] args) throws Exception{
        MongoTemplate mongoTemplate=new MongoTemplate(new Mongo(),"database");
        Person person=new Person("Chuangang Zhu",28);
        mongoTemplate.insert(person);
        Person p=mongoTemplate.findOne(new Query(Criteria.where("name").is("Chuangang Zhu")), Person.class);
        System.out.println(p);
        mongoTemplate.dropCollection("person");
    }

}
