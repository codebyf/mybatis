package com.byf.dao;

import com.byf.domain.User;

import java.util.List;

/**
 * 用户的持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有操作
     * @return
     */
    List<User> findAll();

    User findById(Integer userId);

    List<User> findByName(String userName);

    int findTotal();

    void updateUser(User user);

    void deleteUser(int i);

    void saveUser(User user);
}
