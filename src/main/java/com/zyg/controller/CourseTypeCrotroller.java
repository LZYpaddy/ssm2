package com.zyg.controller;

import com.zyg.core.AjaxResult;
import com.zyg.domain.Course;
import com.zyg.domain.CourseType;
import com.zyg.service.ICourseTypeServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.zyg.core.AjaxResult.success;
import static com.zyg.core.AjaxResult.warn;

/**
 * @author LZY
 * @version 1.0
 * @date 2020/5/25 21:30
 */
@RestController
@CrossOrigin

public class CourseTypeCrotroller {
    @Autowired
    private ICourseTypeServie courseTypeServie;
    @GetMapping("/findAllCourseType")
    public AjaxResult findAll() {
        System.out.println("表现层查询类别");
    List<CourseType> list = courseTypeServie.findAllCourseType();
        System.out.println(list.toString());
        return success( "成功", list);

}

    @GetMapping("/addCourseType")
    public AjaxResult addCourseType(String typeName) {
        System.out.println("表现层增加类别");
        System.out.println(typeName);
        int insertReply =  courseTypeServie.addCourseType(typeName);

        return success( "成功", insertReply);

    }
    @PostMapping("/deleteCourseType")
    @ResponseBody
    public AjaxResult deleteCourse(int id) {
        System.out.println("表现层删除课程类型");

        int updateReply = courseTypeServie.deleteCourseType(id);
        if (updateReply == 1) {
            return success("成功", updateReply);
        } else if (updateReply == 0) {
            return warn("警告，影响行数为0,可能未删除课程", updateReply);
        } else {
            return warn("警告，影响行数不为0和1,可能多删除几行课程", updateReply);
        }
    }

}