package com.szss.mongodb.test.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by zcg on 15/9/17.
 */
public interface PersonQueryRepository extends PagingAndSortingRepository<Person, Long>{

    public Person findByFirstname(String name);

}
