package com.intetm.system.db.dao;

import com.intetm.system.db.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface UserDao extends CrudRepository<User, UUID> {

    List<User> findByUserName(String userName);
}