package com.zyg.controller;

import com.zyg.core.AjaxResult;
import com.zyg.domain.Admin;
import com.zyg.domain.Admin;
import com.zyg.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.zyg.core.AjaxResult.success;
import static com.zyg.core.AjaxResult.warn;

/**
 * @author LZY
 * @version 1.0
 * @date 2020/5/29 23:56
 */

@RestController
@CrossOrigin
public class AdminController {
@Autowired
private IAdminService adminService;
    @PostMapping("/login")
        public AjaxResult login(@RequestBody Admin admin) {

        System.out.println("表现层登录" + admin.getUsername()+admin.getPassword());
        String reply  = adminService.login(admin.getUsername(),admin.getPassword());
        if (reply!=null){
            System.out.println(reply+"success");

            return success("成功", reply);
        }
       else {
            System.out.println(reply+"error");
           return warn("警告，没有这个用户", reply);
        }

    }

    @GetMapping("/info")
    public AjaxResult info(String token) {

        System.out.println("表现层info" + token);
        Admin replyAdmin = adminService.info(token);
        return success("成功", replyAdmin);

    }

    @GetMapping("/findAllAdmin")
    public AjaxResult findAllAdmin() {
        System.out.println("表现层查询信息");
        List<Admin> list = adminService.findAllAdmin();

        return success("成功", list);

    }



    @PostMapping("/findAdminById")
    @ResponseBody
    public AjaxResult findAdminById(String username) {
        System.out.println("表现层根据username查询Admin信息" + username);
        Admin Admin = adminService.findAdminById(username);
        return success("成功", Admin);

    }

    @PostMapping("/updateAdmin")
    @ResponseBody
    public AjaxResult updateAdmin(@RequestBody Admin admin) {
        System.out.println("表现层更改Admin信息");

        int updateReply = adminService.updateAdmin(admin);
        if (updateReply == 1) {
            return success("成功", updateReply);
        } else if (updateReply == 0) {
            return warn("警告，影响行数为0,可能未修改", updateReply);
        } else {
            return warn("警告，影响行数不为0和1,可能多修改了几行", updateReply);
        }
    }

    @PostMapping("/deleteAdmin")
    @ResponseBody
    public AjaxResult deleteAdmin(String username) {
        System.out.println("表现层删除Admin");

        int updateReply = adminService.deleteAdmin(username);
        if (updateReply == 1) {
            return success("成功", updateReply);
        } else if (updateReply == 0) {
            return warn("警告，影响行数为0,可能未删除Admin", updateReply);
        } else {
            return warn("警告，影响行数不为0和1,可能多删除几行Admin", updateReply);
        }
    }

    @PostMapping("/addAdmin")
    @ResponseBody
    public AjaxResult addAdmin(@RequestBody Admin admin) {
        System.out.println("表现层增加Admin信息");
        System.out.println(admin.toString());
        int insertReply = adminService.addAdmin(admin);
        if (insertReply == 1) {
            return success("成功", insertReply);
        } else if (insertReply == 0) {
            return warn("警告，影响行数为0,可能未修改", insertReply);
        } else {
            return warn("警告，影响行数不为0和1,可能多修改了几行", insertReply);
        }
    }
    @PostMapping("/logout")
    @ResponseBody
    public AjaxResult logout(String token) {
        System.out.println("表现层更改Admin信息");

        int logoutReply = adminService.logout(token);
        if (logoutReply == 1) {
            return success("成功", "success");
        } else if (logoutReply == 0) {
            return warn("警告，登出错误", "error");
        } else {
            return warn("警告，错误", "error");
        }
    }


}
