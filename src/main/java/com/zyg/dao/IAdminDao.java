package com.zyg.dao;

import com.zyg.domain.Admin;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LZY
 * @version 1.0
 * @date 2020/5/29 18:59
 */
@Repository
public interface IAdminDao {
    @Select("select admin_id from admin where username=#{username} and password=#{password} ")
    public Integer login(@Param("username")String username,@Param("password")String password);

    @Select("select * from admin where token=#{token}")
    Admin info(@Param("token")String token);

    @Select("select * from admin")
    List<Admin> findAllAdmin();
    /**
     * 根据username查询管理员
     * @return
     */
    @Select("select * from admin where username=#{username}")
    Admin findAdminById(String username);
    /**
     * 更改管理员信息
     * @return
     */
    @Update("UPDATE admin SET username=#{username},password=#{password} where username=#{username}")
    int updateAdmin(Admin admin);
    /**
     * 删除管理员
     * @return
     */
    @Delete("delete from admin where username = #{username}")
    int deleteAdmin(String username);


    /**
     * 增加管理员
     * @param admin
     * @return
     */
    @Insert("INSERT INTO admin (username,password,avatar,token,roles) VALUES (#{username},#{password},#{avatar},#{token},'admin')")
    int addAdmin(Admin admin);

    /**
     * @param token
     * @return
     */
    @Update("UPDATE admin SET token=null where token=#{token}")
    int logout(@Param("token")String token);

    /**
     * @param username
     * @return
     */
    @Update("UPDATE admin SET token=#{token} where username=#{username}")
    int addToken(@Param("username")String username,@Param("token")String token);
}
