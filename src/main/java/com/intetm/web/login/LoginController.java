package com.intetm.web.login;

import com.intetm.db.entity.User;
import com.intetm.login.LoginService;
import com.intetm.login.UserExistsException;
import com.intetm.web.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.intetm.db.entity.Authority.ROLE_USER;

@RestController
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;


    @RequestMapping(value = "/createUser", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @ResponseBody
    public UserDetails createUser(@RequestParam String username, @RequestParam String password) throws ServiceException {
        try {
            User user = loginService.createUser(username, password, ROLE_USER);
            return new UserDetails(user);
        } catch (UserExistsException exception) {
            throw new ServiceException(exception.getMessage());
        }
    }

    @RequestMapping(value = "/getUsers", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<User> getUsers(){
        return loginService.getUsers();
    }
}
