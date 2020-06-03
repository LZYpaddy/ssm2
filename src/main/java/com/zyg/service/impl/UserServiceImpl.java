package com.zyg.service.impl;

import com.zyg.dao.IUserDao;
import com.zyg.domain.User;
import com.zyg.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LZY
 * @version 1.0
 * @date 2020/5/30 22:25
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao iUserDao;
    @Override
    public List<User> findAllUser() {
        System.out.println("业务层查询所有用户");

        return iUserDao.findAllUser();
    }

    @Override
    public User findUserById(int id) {
        System.out.println("业务层查询所有用户");

        return iUserDao.findUserById(id);
    }

    @Override
    public int updateUser(User user) {
        System.out.println("业务层更改用户信息");
        System.out.println(user.toString());
        return iUserDao.updateUser(user);
    }

    @Override
    public int deleteUser(int id) {
        System.out.println("业务层删除用户");

        return iUserDao.deleteUser(id);
    }

    @Override
    public int addUser(User user) {
        System.out.println("业务层增加用户");

        return iUserDao.addUser(user);
    }
}
