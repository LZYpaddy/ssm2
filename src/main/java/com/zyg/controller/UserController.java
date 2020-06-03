package com.zyg.controller;

import com.zyg.core.AjaxResult;
import com.zyg.domain.User;
import com.zyg.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.zyg.core.AjaxResult.success;
import static com.zyg.core.AjaxResult.warn;

/**
 * @author LZY
 * @version 1.0
 * @date 2020/4/18 18:09
 */
@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("/findAllUser")
    public AjaxResult findAll() {
        System.out.println("表现层查询信息");
        List<User> list = iUserService.findAllUser();
        return success("成功", list);

    }
    @PostMapping("/findUserById")
    @ResponseBody
    public AjaxResult findCourseById(int id) {
        System.out.println("表现层根据ID查询用户信息" + id);
        User user = iUserService.findUserById(id);
        return success("成功", user);

    }
    @PostMapping("/updateUser")
    @ResponseBody
    public AjaxResult updateCourse(@RequestBody User user) {
        System.out.println("表现层更改用户信息");

        int updateReply = iUserService.updateUser(user);
        if (updateReply == 1) {
            return success("成功", updateReply);
        } else if (updateReply == 0) {
            return warn("警告，影响行数为0,可能未修改", updateReply);
        } else {
            return warn("警告，影响行数不为0和1,可能多修改了几行", updateReply);
        }
    }
    @PostMapping("/deleteUser")
    @ResponseBody
    public AjaxResult deleteCourse(int id) {
        System.out.println("表现层删除用户");

        int updateReply = iUserService.deleteUser(id);
        if (updateReply == 1) {
            return success("成功", updateReply);
        } else if (updateReply == 0) {
            return warn("警告，影响行数为0,可能未删除用户", updateReply);
        } else {
            return warn("警告，影响行数不为0和1,可能多删除几行用户", updateReply);
        }
    }

    @PostMapping("/addUser")
    @ResponseBody
    public AjaxResult addCourse(@RequestBody User user) {
        System.out.println("表现层增加用户信息");
        System.out.println(user.toString());
        int insertReply = iUserService.addUser(user);
        if (insertReply == 1) {
            return success("成功", insertReply);
        } else if (insertReply == 0) {
            return warn("警告，影响行数为0,可能未修改", insertReply);
        } else {
            return warn("警告，影响行数不为0和1,可能多修改了几行", insertReply);
        }
    }
}
