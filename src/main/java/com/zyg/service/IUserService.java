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
    public int registerUser(User user);

    /**
     * 根据username查询用户
     *
     * @return
     */
    public User findUserByName(String username);

    /**
     *
     * @return
     */
    public  String userLogin(String username, String password);
    /**
     * 根据token获取信息
     *
     * @return
     */
    public User info(String token);

    int userLogout(String token);

    int editUser(User user);
    int buyCourse(int id,double amount);
}
