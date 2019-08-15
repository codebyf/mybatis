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
        SqlSession session = factory.openSession(true);
        // 2.调用SqlSession中的方法，实现查询列表
        List<User> users = session.selectList("com.byf.dao.IUserDao.findAll");
        session.close();
        return users;
    }

    public User findById(Integer userId) {
        // 1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        // 2.调用SqlSession中的方法，实现查询列表
        User user = session.selectOne("com.byf.dao.IUserDao.findById",userId);
        session.close();
        return user;
    }

    public List<User> findByName(String userName) {
        return null;
    }

    public int findTotal() {
        // 1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        // 2.调用SqlSession中的方法，实现查询列表
        Integer count = session.selectOne("com.byf.dao.IUserDao.findTotal");
        session.close();
        return count;
    }

    public void updateUser(User user) {
        // 1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        // 2.调用SqlSession中的方法，实现查询列表
        session.update("com.byf.dao.IUserDao.updateUser", user);
        session.commit();
        session.close();
    }

    public void deleteUser(int i) {
        // 1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        // 2.调用SqlSession中的方法，实现查询列表
        session.delete("com.byf.dao.IUserDao.deleteUser",i);
        session.commit();
        session.close();
    }

    public void saveUser(User user) {
        // 1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession(true);
        // 2.调用SqlSession中的方法，实现查询列表
        session.insert("com.byf.dao.IUserDao.saveUser", user);
        // session.commit();
        session.close();
    }
}
