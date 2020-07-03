package com.zyg.controller;

import com.zyg.core.AjaxResult;
import com.zyg.domain.Course;
import com.zyg.domain.Order;
import com.zyg.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.zyg.core.AjaxResult.success;
import static com.zyg.core.AjaxResult.warn;

/**
 * @author LZY
 * @version 1.0
 * @date 2020/5/31 12:07
 */
@RestController
@CrossOrigin
public class OrderController {
    @Autowired
    private IOrderService iOrderService;

    @GetMapping("/findAllOrder")
    public AjaxResult findAll() {
        System.out.println("表现层查询信息");
        List<Order> list = iOrderService.findAllOrder();
        return success("成功", list);

    }
    @PostMapping("/findOrderById")
    @ResponseBody
    public AjaxResult findCourseById(Integer orderId) {
        System.out.println("表现层根据ID查询订单信息" + orderId);
        Order order = iOrderService.findOrderById(orderId);
        return success("成功", order);

    }
    @PostMapping("/updateOrder")
    @ResponseBody
    public AjaxResult updateCourse(@RequestBody Order order) {
        System.out.println("表现层更改订单信息");

        int updateReply = iOrderService.updateOrder(order);
        if (updateReply == 1) {
            return success("成功", updateReply);
        } else if (updateReply == 0) {
            return warn("警告，影响行数为0,可能未修改", updateReply);
        } else {
            return warn("警告，影响行数不为0和1,可能多修改了几行", updateReply);
        }
    }
    @PostMapping("/deleteOrder")
    @ResponseBody
    public AjaxResult deleteCourse(Integer orderId) {
        System.out.println("表现层删除订单");

        int updateReply = iOrderService.deleteOrder(orderId);
        if (updateReply == 1) {
            return success("成功", updateReply);
        } else if (updateReply == 0) {
            return warn("警告，影响行数为0,可能未删除订单", updateReply);
        } else {
            return warn("警告，影响行数不为0和1,可能多删除几行订单", updateReply);
        }
    }

    @PostMapping("/addOrder")
    @ResponseBody
    public AjaxResult addCourse(@RequestBody Order order) {
        System.out.println("表现层增加订单信息");
        System.out.println(order.toString());
        int insertReply = iOrderService.addOrder(order);
        if (insertReply == 1) {
            return success("成功", insertReply);
        } else if (insertReply == 0) {
            return warn("警告，影响行数为0,可能未修改", insertReply);
        } else {
            return warn("警告，影响行数不为0和1,可能多修改了几行", insertReply);
        }
    }

    @PostMapping("/findUserCourses")
    public AjaxResult findUserCourses(int userId) {
        System.out.println("表现层查询我的所买课程");
        List<Course> list = iOrderService.findUserCourses(userId);
        System.out.println(list);
        return success("成功", list);

    }
}
