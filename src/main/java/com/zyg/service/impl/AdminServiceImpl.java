package com.zyg.service.impl;

import com.zyg.dao.IAdminDao;
import com.zyg.domain.Admin;
import com.zyg.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LZY
 * @version 1.0
 * @date 2020/5/29 19:00
 */
@Service("adminService")
public class AdminServiceImpl implements IAdminService {
    @Autowired
    private IAdminDao iAdminDao;
    @Override
    public String login(String username,String password) {
        System.out.println("业务层Login");
        System.out.println(username);
        Integer replyAdminId =iAdminDao.login(username,password);
        if (replyAdminId!=null){
      //      后期要改为JWT生成token！！！！！！！！！
      //      后期要改为JWT生成token！！！！！！！！！
      //      后期要改为JWT生成token！！！！！！！！！
            ;
          if ( iAdminDao.addToken(username,Math.random()+"")!=1){
              return null;
          }
            Admin admin= iAdminDao.findAdminById(username);

            return admin.getToken();
        }
        return null;
    }

    @Override
    public Admin info(String token) {
        System.out.println("业务层info");
        System.out.println(token);

        return iAdminDao.info(token);
    }

    @Override
    public List<Admin> findAllAdmin() {
        return iAdminDao.findAllAdmin();
    }

    @Override
    public Admin findAdminById(String username) {
        return iAdminDao.findAdminById(username);
    }

    @Override
    public int updateAdmin(Admin admin) {

        System.out.println("业务层更改管理员信息");
        System.out.println(admin.toString());
        return iAdminDao.updateAdmin(admin);
    }

    @Override
    public int deleteAdmin(String username) {
        System.out.println("业务层删除管理员");

        return iAdminDao.deleteAdmin(username);
    }

    @Override
    public int addAdmin(Admin admin) {
        System.out.println("业务层增加管理员");

        return iAdminDao.addAdmin(admin);
    }

    @Override
    public int logout(String token) {
        return iAdminDao.logout(token);
    }

    @Override
    public int addToken(String username,String token) {
        return iAdminDao.addToken(username, token);
    }
}
