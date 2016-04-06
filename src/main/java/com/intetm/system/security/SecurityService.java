package com.intetm.system.security;

import com.intetm.system.db.dao.UserDao;
import com.intetm.system.db.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service

public class SecurityService  implements UserDetailsService {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails loadedUser;

        try {
            User user = userDao.findByUserName(username).get(0);
            loadedUser = new org.springframework.security.core.userdetails.User(
                    user.getUserName(), user.getPassword(),
                    DummyAuthority.getAuth());
        } catch (Exception repositoryProblem) {
            throw new InternalAuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
        }
        return loadedUser;
    }

    static class DummyAuthority implements GrantedAuthority
    {
        static Collection<GrantedAuthority> getAuth()
        {
            List<GrantedAuthority> res = new ArrayList<>(1);
            res.add(new DummyAuthority());
            return res;
        }
        @Override
        public String getAuthority() {
            return "USER";
        }
    }
}