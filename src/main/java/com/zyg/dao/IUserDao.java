package com.zyg.dao;

import com.zyg.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LZY
 * @version 1.0
 * @date 2020/5/30 22:26
 */
@Repository
public interface IUserDao {

    /**
     * 查询所有User
     * @return
     */
    @Select("select * from user")
    List<User> findAllUser();

    /**
     * 根据ID查询用户
     * @return
     */
    @Select("select * from user where id=#{id}")
    User findUserById(int id);

    /**
     * 更改用户信息
     * @return
     */
    @Update("UPDATE user SET username=#{username},password=#{password},nick_name=#{nickName},email=#{email},telephone=#{telephone} where id=#{id}")
    int updateUser(User user);

    /**
     * 删除用户
     * @return
     */
    @Delete("delete from user where id = #{id}")
    int deleteUser(int id);

    /**
     * 增加用户
     * @return
     */
    @Insert("INSERT INTO user (username,password,nick_name,email,avatar,roles) VALUES (#{username},#{password},#{nickName},#{email},#{avatar},#{roles})")
    int registerUser(User user);




    //    前台↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    /**
     * 根据ID查询用户
     * @return
     */
    @Select("select * from user where username=#{username}")
    User findUserByName(String username);




    @Select("select id from user where username=#{username} and password=#{password} ")
    Integer userLogin(@Param("username")String username,@Param("password")String password);

    /**
     * @param username
     * @return
     */
    @Update("UPDATE user SET token=#{token} where username=#{username}")
    int addToken(@Param("username")String username,@Param("token")String token);

    @Select("select * from user where token=#{token}")
    User info(@Param("token")String token);

    @Update("UPDATE user SET token=null where token=#{token}")
    int userLogout(String token);

    /**
     * 更改User信息
     * @return
     */
    @Update("UPDATE user SET password=#{password},nick_name=#{nickName},email=#{email},telephone=#{telephone} where id=#{id}")
    int editUser(User user);

    @Update("UPDATE user SET balance=balance-#{amount} where id=#{id}")
    int buyCourse(@Param("id")int id,@Param("amount")double amount);
}
