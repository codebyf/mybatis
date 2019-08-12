package com.byf.dao;

import com.byf.domain.QueryVO;
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

    /**
     * 保存用户
     * @param user
     */
    int saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户
     * @param userId
     */
    void deleteUser(Integer userId);

    User findById(Integer userId);

    List<User> findByName(String userName);

    int findTotal();

    /**
     * 根据queryVO中的条件查询
     * @return
     */
    List<User> findByQueryVo(QueryVO queryVO);
}
