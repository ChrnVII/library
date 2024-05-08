package com.book.service;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;

import com.book.entity.User;
import com.book.mapper.UserMapper;
import com.book.utils.MybatisUtil;

public class LoginService {

    public boolean auth(String username, String password, HttpServletRequest req) throws IOException {
        UserMapper mapper = MybatisUtil.getSession(true).getMapper(UserMapper.class);
        User user = (User) mapper.getUser(username, password);
        if (user != null) {
            req.getSession().setAttribute("user", user);
            return true;
        }
        return false;
    }
}
