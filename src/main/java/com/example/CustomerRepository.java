package com.example;
import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<User, UUID> {

    List<User> findByName(String name);
}