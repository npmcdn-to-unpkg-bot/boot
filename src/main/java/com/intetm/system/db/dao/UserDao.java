package com.intetm.system.db.dao;

import com.intetm.system.db.entity.User;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("userDao")
public class UserDao extends AbstractDao<User, UUID> {

    public UserDao() {
        super(User.class);
    }

    @Override
    public void persist(User user) {
        if (user.getId() == null) {
            user.setId(UUID.randomUUID());
        }
        super.persist(user);
    }

    public boolean isUserExsist(String userName) {
        return count(User.COLUMN_USER_NAME, userName) != 0;
    }
}
