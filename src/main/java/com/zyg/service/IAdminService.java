package com.zyg.service;

import com.zyg.domain.Admin;

import java.util.List;

/**
 * @author LZY
 * @version 1.0
 * @date 2020/5/29 19:00
 */
public interface IAdminService {
    /**
     * 登录
     *
     * @return
     */
    public String login(String username, String password);

    /**
     * 根据token获取信息
     *
     * @return
     */
    public Admin info(String token);

    /**
     * 查找所有admin
     *
     * @return
     */
    List<Admin> findAllAdmin();

    Admin findAdminById(String username);

    int updateAdmin(Admin admin);

    int deleteAdmin(String username);

    int addAdmin(Admin admin);

    int logout(String token);

    int addToken(String username,String token);
}
