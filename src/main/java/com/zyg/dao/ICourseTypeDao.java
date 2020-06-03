package com.zyg.dao;

import com.zyg.domain.Course;
import com.zyg.domain.CourseType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LZY
 * @version 1.0
 * @date 2020/5/25 21:23
 */
@Repository
public interface ICourseTypeDao {
    /**
     * 查询所有类型
     * @return
     */
    @Select("select * from course_type")
    public List<CourseType> findAllCourseType();
    /**
     * 增加类型
     * @return
     */
    @Insert("INSERT INTO course_type (type_name) VALUES (#{typeName})")
    public int addCourseType(@Param("typeName") String typeName);

    @Delete("delete from course_type where type_id = #{id}")
    public int deleteCourseType(int id);
}
