package com.intetm.db.dao;

import com.intetm.db.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;


import java.util.List;
import java.util.UUID;

@RepositoryDefinition(domainClass = User.class, idClass = UUID.class)
public interface UserDao extends CrudRepository<User, UUID> {

    List<User> findByUserName(String userName);
    
    @Query("SELECT CASE WHEN COUNT(1) > 0 THEN true ELSE false END FROM User where userName = ?1")
    boolean isUserExist(String userName);
}