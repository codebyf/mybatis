package com.byf.dao.impl;

import com.byf.dao.IUserDao;
import com.byf.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {
    private SqlSessionFactory factory;
    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }

    public List<User> findAll() {
        // 1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        // 2.调用SqlSession中的方法，实现查询列表
        List<User> users = session.selectList("com.byf.dao.IUserDao.findAll");
        session.close();
        return users;
    }

    public User findById(Integer userId) {
        return null;
    }

    public List<User> findByName(String userName) {
        return null;
    }

    public int findTotal() {
        return 0;
    }

    public void updateUser(User user) {

    }

    public void deleteUser(int i) {

    }

    public void saveUser(User user) {

    }
}
