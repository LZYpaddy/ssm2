package com.zyg.service;

import com.zyg.domain.Course;

import java.util.List;

/**
 * @author LZY
 * @version 1.0
 * @date 2020/5/5 23:48
 */
public interface ICourseServise {
    /**
     * 查询所有
     *
     * @return
     */
    public List<Course> findAllCourse();

    /**
     * 查询相关课程
     *
     * @return
     */
    public List<Course> findCourseByType(String typeName);

    /**
     * 根据ID查询课程
     *
     * @return
     */
    public Course findCourseById(long id);

    /**
     * 更改课程发布状态
     *
     * @return
     */
    public int updateCourseDeliveryStatus(long id,int deliveryStatus);

    /**
     * 更改课程信息
     *
     * @return
     */
    public int updateCourse(Course course);

    /**
     * 根据ID删除课程
     *
     * @return
     */
    public int deleteCourse(long id);

    /**
     * 增加课程
     *
     * @return
     */
    public int addCourse(Course course);


}
