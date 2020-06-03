package com.zyg.service.impl;

import com.zyg.dao.ICourseTypeDao;
import com.zyg.domain.CourseType;
import com.zyg.service.ICourseTypeServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LZY
 * @version 1.0
 * @date 2020/5/25 21:21
 */
@Service("courseTypeService")
public class CourseTypeServieImpl implements ICourseTypeServie {
    @Autowired
    private ICourseTypeDao iCourseTypeDao;
    @Override
    public List<CourseType> findAllCourseType() {
        System.out.println("业务层查询所有类别");
        return iCourseTypeDao.findAllCourseType();
    }

    @Override
    public int addCourseType(String typeName) {
        System.out.println("业务层增加类别");
        return iCourseTypeDao.addCourseType(typeName);
    }

    @Override
    public int deleteCourseType(int id) {
        System.out.println("业务层删除类别");
        return iCourseTypeDao.deleteCourseType(id);
    }

}
