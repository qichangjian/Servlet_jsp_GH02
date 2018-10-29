package com.qcj.test;

import com.qcj.dao.UserDao;
import com.qcj.dao.impl.UserDaoImpl;
import com.qcj.entity.Users;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Users u = new Users("aa","111");
        UserDao userDao = new UserDaoImpl();
        List<Users> list = userDao.loginUser(u);
        list.forEach(System.out::println);
    }
}
