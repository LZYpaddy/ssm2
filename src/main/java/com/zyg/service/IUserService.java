package com.zyg.service;

import com.zyg.domain.User;

import java.util.List;

/**
 * @author LZY
 * @version 1.0
 * @date 2020/5/30 22:23
 */
public interface IUserService {
    /**
     * 查询所有
     *
     * @return
     */
    public List<User> findAllUser();
    /**
     * 根据ID查询用户
     *
     * @return
     */
    public User findUserById(int id);
    /**
     * 更改用户信息
     *
     * @return
     */
    public int updateUser(User user);

    /**
     * 根据ID删除用户
     *
     * @return
     */
    public int deleteUser(int id);

    /**
     * 增加用户
     *
     * @return
     */
    public int addUser(User user);

}
