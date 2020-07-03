package com.zyg.controller;

import com.zyg.core.AjaxResult;
import com.zyg.domain.Course;
import com.zyg.domain.Order;
import com.zyg.domain.User;
import com.zyg.service.ICourseServise;
import com.zyg.service.IOrderService;
import com.zyg.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static com.zyg.core.AjaxResult.*;

/**
 * @author LZY
 * @version 1.0
 * @date 2020/4/18 18:09
 */
@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IOrderService orderService;
    @Autowired
    private ICourseServise courseServise;

    @GetMapping("/findAllUser")
    public AjaxResult findAllUser() {
        System.out.println("表现层查询信息");
        List<User> list = userService.findAllUser();
        return success("成功", list);

    }
    @PostMapping("/findUserById")
    @ResponseBody
    public AjaxResult findUserById(int id) {
        System.out.println("表现层根据ID查询用户信息" + id);
        User user = userService.findUserById(id);
        return success("成功", user);

    }
    @PostMapping("/updateUser")
    @ResponseBody
    public AjaxResult updateUser(@RequestBody User user) {
        System.out.println("表现层更改用户信息");

        int updateReply = userService.updateUser(user);
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
    public AjaxResult deleteUser(int id) {
        System.out.println("表现层删除用户");

        int updateReply = userService.deleteUser(id);
        if (updateReply == 1) {
            return success("成功", updateReply);
        } else if (updateReply == 0) {
            return warn("警告，影响行数为0,可能未删除用户", updateReply);
        } else {
            return warn("警告，影响行数不为0和1,可能多删除几行用户", updateReply);
        }
    }


//    前台↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    @PostMapping("/registerUser")
    @ResponseBody
    public AjaxResult registerUser(@RequestBody User user) {
        System.out.println("表现层增加用户信息");
        System.out.println(user.toString());
        if (userService.findUserByName(user.getUsername())!=null) {
            return warn("抱歉，该用户名已存在，请重新修改用户名", "404");
        } else {
            int insertReply = userService.registerUser(user);
            if (insertReply == 1) {
                return success("成功", insertReply);
            } else if (insertReply == 0) {
                return warn("警告，注册失败0", insertReply);
            } else {
                return warn("警告，注册失败", insertReply);
            }
        }
    }
    @PostMapping("/userLogin")
    public AjaxResult login(@RequestBody User user) {

        System.out.println("表现层登录" + user.getUsername()+user.getPassword());
        String reply  = userService.userLogin(user.getUsername(),user.getPassword());

        if (reply!=null){
            System.out.println(reply+"success");

            return success("成功", reply);
        }
        else {
            System.out.println(reply+"error");
            return warn("警告，账号密码错误", reply);
        }

    }
    @GetMapping("/userInfo")
    public AjaxResult info(String token) {

        System.out.println("表现层info" + token);
        User replyUser = userService.info(token);
        System.out.println(replyUser.toString());
        return success("成功", replyUser);

    }

    @PostMapping("/userLogout")
    @ResponseBody
    public AjaxResult logout(@RequestHeader("X-Token")String token) {
        System.out.println("表现层登出");
        System.out.println(token);

        int logoutReply = userService.userLogout(token);
        System.out.println(logoutReply);
        if (logoutReply == 1) {
            System.out.println(success("成功", "success"));
            return success("成功", "success");
        } else if (logoutReply == 0) {
            return warn("警告，登出错误", "error");
        } else {
            return warn("警告，错误", "error");
        }
    }
    @PostMapping("/findUserByName")
    @ResponseBody
    public AjaxResult findUserByName(String username) {
        System.out.println("表现层根据username查询User信息" + username);
        User user = userService.findUserByName(username);
        return success("成功", user);

    }
    @PostMapping("/editUser")
    @ResponseBody
    public AjaxResult editUser(@RequestBody User user) {
        System.out.println("表现层更改用户信息");

        int updateReply = userService.editUser(user);
        if (updateReply == 1) {
            return success("成功", updateReply);
        } else if (updateReply == 0) {
            return warn("警告，影响行数为0,可能未修改", updateReply);
        } else {
            return warn("警告，影响行数不为0和1,可能多修改了几行", updateReply);
        }
    }

    @PostMapping("/buyCourse")
    @ResponseBody
    public AjaxResult buyCourse(String username,int courseId) {
        System.out.println("表现层买课程");
        System.out.println(username);
        System.out.println(courseId);

        User user = userService.findUserByName(username);

        System.out.println(user.toString());

        Course course = courseServise.findCourseById(courseId);
        System.out.println(course.toString());


        if (user.getBalance()<course.getPrice()){
            return error("抱歉，您的余额不足");
        }else {
            Date date=new Date();
            Order order=new Order(user.getId(),courseId,date,date,course.getPrice());
            if (orderService.addOrder(order)==1){
                int updateReply = userService.buyCourse(user.getId(), course.getPrice());
                if (updateReply == 1) {
                    return success("购买成功", updateReply);
                } else if (updateReply == 0) {
                    return warn("警告，购买失败", updateReply);
                } else {
                    return warn("警告，购买失败2", updateReply);
                }
            }else {
                return error("下单失败");
            }


        }
    }

}
