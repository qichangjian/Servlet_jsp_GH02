package com.qcj.dao;

import com.qcj.entity.Users;

import java.util.List;

public interface UserDao {
    List<Users> loginUser(Users users);
}
