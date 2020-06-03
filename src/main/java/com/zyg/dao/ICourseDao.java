package com.zyg.dao;

import com.zyg.domain.Course;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LZY
 * @version 1.0
 * @date 2020/5/5 23:50
 */
@Repository
public interface ICourseDao {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from course")
    public List<Course> findAllCourse();
    /**
     * 根据ID查询课程
     * @return
     */
    @Select("select * from course where id=(${id})")
    Course findCourseById(@Param("id") long id);
    /**
     * 更改课程发布状态
     * @return
     */
    @Update("UPDATE course SET delivery_status=(${deliveryStatus}) where id=(${id})")
    int updateCourseDeliveryStatus(@Param("id") long id,@Param("deliveryStatus")int deliveryStatus);
    /**
     * 更改课程信息
     * @return
     * //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////↓↓↓↓↓↓↓后期此处改成video_address
     */
    @Update("UPDATE course SET name=#{name},image=#{image},price=#{price},teacher=#{teacher},summary=#{summary},introduction=#{introduction},type_name=#{typeName},type_id=#{typeId},create_time=#{createTime},video_address=#{videoAddress} where id=#{id}")
    int updateCourse(Course course);

    /**
     * 删除课程
     * @return
     */
    @Delete("delete from course where id = #{id}")
    int deleteCourse(long id);

    /**
     * 增加课程
     * @return
     */
    @Insert("INSERT INTO course (name,image,price,teacher,summary,introduction,type_name,type_id,create_time,video_address) VALUES (#{name},#{image},#{price},#{teacher},#{summary},#{introduction},#{typeName},#{typeId},#{createTime},#{videoAddress})")
    int addCourse(Course course);
    /**
     * 根据类型（实际上是根据ID）查询课程
     * @return
     */
    @Select("SELECT * FROM course WHERE type_name =(SELECT type_name FROM `course_type` WHERE type_id=(${typeName}))")
    List<Course> findCourseByType(@Param("typeName") String typeName);
}
