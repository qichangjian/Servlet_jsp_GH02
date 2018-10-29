package com.qcj.dao.impl;

import com.qcj.dao.UserDao;
import com.qcj.entity.Users;
import com.qcj.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public List<Users> loginUser(Users users) {
        List<Users> list = new LinkedList<>();
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from users where username=? and pwd = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,users.getUsername());
            ps.setString(2,users.getPwd());
            rs = ps.executeQuery();
            while(rs.next()){
                Users user = new Users();
                user.setPwd(rs.getString("pwd"));
                user.setUsername(rs.getString("username"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
