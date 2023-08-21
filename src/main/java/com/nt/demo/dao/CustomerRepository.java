package com.nt.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nt.demo.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer> {


}
