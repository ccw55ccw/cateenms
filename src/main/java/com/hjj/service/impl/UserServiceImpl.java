package com.hjj.service.impl;

import com.hjj.dao.UserDao;
import com.hjj.entity.User;
import com.hjj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/12/17.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    public boolean checkLogin(User user) {
        if (userDao.get(user).isPresent())
            return true;
        return false;
    }
}
