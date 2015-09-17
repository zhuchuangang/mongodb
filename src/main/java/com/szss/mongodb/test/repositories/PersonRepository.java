package com.szss.mongodb.test.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by zcg on 15/9/17.
 */
public interface PersonRepository extends MongoRepository<Person, String> {

    public List<Person> deleteByFirstname(String firstname);

}
