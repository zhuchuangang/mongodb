package com.szss.mongodb.test.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by zcg on 15/9/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config-repositories.xml")
public class MongoAppTests {

    @Autowired
    private PersonQueryRepository personQueryRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void insert() {
        Address address = new Address("旧金山", "加利福利亚", "苹果");
        Person person = new Person("史蒂夫", "乔布斯", address);
        mongoTemplate.insert(person);
        Person p = mongoTemplate.findOne(new Query(Criteria.where("firstname").is("史蒂夫")), Person.class);
        System.out.println(p);
    }

    @Test
    public void findAll() {
        Page<Person> persons = personRepository.findAll(new PageRequest(0, 10));
        assertThat(persons.isFirst(), is(true));
    }

    @Test
    public void findByFirstname() {
        Person person = personQueryRepository.findByFirstname("史蒂夫");
        assertThat(person.getFirstname(), is("史蒂夫"));
    }

    @Test
    public void deleteByFirstname() {
        List<Person> person = personRepository.deleteByFirstname("史蒂夫");
        assertThat(person.size(), is(1));
    }

    @Test
    public void deleteById() {
        personRepository.delete("55fa619a3004c393192421a6");
    }

}
