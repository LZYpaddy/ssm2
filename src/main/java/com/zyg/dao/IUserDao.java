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
         * 查询所有
         * @return
         * */
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
    @Insert("INSERT INTO user (username,password,nick_name,email,telephone) VALUES (#{username},#{password},#{nickName},#{email},#{telephone})")
    int addUser(User user);
}
