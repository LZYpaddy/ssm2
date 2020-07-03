package com.zyg.service.impl;

import com.zyg.dao.ICourseDao;
import com.zyg.domain.Course;
import com.zyg.service.ICourseServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LZY
 * @version 1.0
 * @date 2020/5/5 23:51
 */
@Service("courseService")
public class CourseServiseImpl implements ICourseServise {
    @Autowired
    private ICourseDao iCourseDao;
    @Override
    public List<Course> findAllCourse() {
        System.out.println("业务层查询所有课程");

        return iCourseDao.findAllCourse();
    }

    @Override
    public List<Course> findCourseByType(String typeName) {
        System.out.println("业务层根据课程类型查询课程");

        return iCourseDao.findCourseByType(typeName);
    }

    @Override
    public Course findCourseById(long id) {
        System.out.println("业务层根据id查课程");

        return iCourseDao.findCourseById(id);
    }

    @Override
    public int updateCourseDeliveryStatus(long id,int deliveryStatus) {
        System.out.println("业务层更改课程发布状态");

        return iCourseDao.updateCourseDeliveryStatus(id,deliveryStatus);
    }

    @Override
    public int updateCourse(Course course) {
        System.out.println("业务层更改课程信息");
        System.out.println(course.toString());
        return iCourseDao.updateCourse(course);
    }

    @Override
    public int deleteCourse(long id) {
        System.out.println("业务层删除课程");

        return iCourseDao.deleteCourse(id);
    }

    @Override
    public int addCourse(Course course) {
        System.out.println("业务层增加课程");

        return iCourseDao.addCourse(course);
    }

    @Override
    public List<Course> findTopCourse(int topNumber) {
        System.out.println("业务层查询前"+topNumber+"的课程信息");

        return iCourseDao.findTopCourse(topNumber);
    }

    @Override
    public int upCourseHits(long id) {
        return iCourseDao.upCourseHits(id);
    }

    @Override
    public String fetchCourseByUidAndCid(int userId, int courseId) {
        System.out.println("fetchCourseByUidAndCid-------impl");
        System.out.println(userId);
        System.out.println(courseId);
        return iCourseDao.fetchCourseByUidAndCid(userId,courseId);
    }

    @Override
    public List<Course> findCourseByTypeAndDelivery(String typeName) {
        System.out.println("业务层根据课程类型查询课程");

        return iCourseDao.findCourseByTypeAndDelivery(typeName);
    }


}
