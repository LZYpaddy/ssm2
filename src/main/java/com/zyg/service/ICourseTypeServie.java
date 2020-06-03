package com.zyg.service;

import com.zyg.domain.CourseType;

import java.util.List;

/**
 * @author LZY
 * @version 1.0
 * @date 2020/5/25 21:20
 */
public interface ICourseTypeServie {
    /**
    * 查询所有课程类型
    * @return
     */
public List<CourseType> findAllCourseType();
    /**
     * 增加课程类型
     * @return
     */
    public int addCourseType(String typeName);
    /**
     * 根据ID删除课程类型
     *
     * @return
     */
    public int deleteCourseType(int id);

}