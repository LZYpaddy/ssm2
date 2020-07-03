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
        System.out.println("业务层根据id查用户");

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
    public int registerUser(User user) {
        System.out.println("业务层注册用户");

        return iUserDao.registerUser(user);
    }

    @Override
    public User findUserByName(String username) {
        System.out.println("业务层根据username查user");
        return iUserDao.findUserByName(username);

    }

    @Override
    public String userLogin(String username, String password) {
        System.out.println("业务层Login");
        System.out.println(username);
        Integer replyAdminId =iUserDao.userLogin(username,password);
        if (replyAdminId!=null){
            //      后期要改为JWT生成token！！！！！！！！！
            //      后期要改为JWT生成token！！！！！！！！！
            //      后期要改为JWT生成token！！！！！！！！！
            ;
            if ( iUserDao.addToken(username,Math.random()+"")!=1){
                return null;
            }
            User user= iUserDao.findUserByName(username);

            return user.getToken();
        }
        return null;
    }

    @Override
    public User info(String token) {
        System.out.println("业务层info");
        System.out.println(token);

        return iUserDao.info(token);
    }

    @Override
    public int userLogout(String token) {

            return iUserDao.userLogout(token);
    }

    @Override
    public int editUser(User user) {
        System.out.println("业务层更改用户信息");
        System.out.println(user.toString());
        return iUserDao.editUser(user);
    }

    @Override
    public int buyCourse(int id,double amount) {
        System.out.println("业务层买课程");

        return iUserDao.buyCourse(id,amount);
    }
}
