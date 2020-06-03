package com.zyg.controller;

import com.zyg.core.AjaxResult;
import com.zyg.domain.Course;
import com.zyg.service.ICourseServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.zyg.core.AjaxResult.*;

/**
 * @author LZY
 * @version 1.0
 * @date 2020/5/5 23:54
 */
@RestController
@CrossOrigin

public class CourseController {
    @Autowired
    private ICourseServise courseServise;

    @GetMapping("/findAllCourse")
    public AjaxResult findAll() {
        System.out.println("表现层查询信息");
        List<Course> list = courseServise.findAllCourse();
        return success("成功", list);

    }

    @PostMapping("/findCourseById")
    @ResponseBody
    public AjaxResult findCourseById(long id) {
        System.out.println("表现层根据ID查询课程信息" + id);
        Course course = courseServise.findCourseById(id);
        return success("成功", course);

    }

    @PostMapping("/updateCourseDeliveryStatus")
    @ResponseBody
    public AjaxResult updateCourseDeliveryStatus(long id, int deliveryStatus) {
        System.out.println("表现层更改课程发布状态");
        //改变状态
        if (deliveryStatus == 1) {
            deliveryStatus = 0;
        } else if (deliveryStatus == 0) {
            deliveryStatus = 1;
        }
        int updateReply = courseServise.updateCourseDeliveryStatus(id, deliveryStatus);
        if (updateReply == 1) {
            return success("成功", updateReply);
        } else {
            return warn("警告，影响行数不为1", updateReply);
        }
    }

    @PostMapping("/updateCourse")
    @ResponseBody
    public AjaxResult updateCourse(@RequestBody Course course) {
        System.out.println("表现层更改课程信息");

        int updateReply = courseServise.updateCourse(course);
        if (updateReply == 1) {
            return success("成功", updateReply);
        } else if (updateReply == 0) {
            return warn("警告，影响行数为0,可能未修改", updateReply);
        } else {
            return warn("警告，影响行数不为0和1,可能多修改了几行", updateReply);
        }
    }

    @PostMapping("/deleteCourse")
    @ResponseBody
    public AjaxResult deleteCourse(Long id) {
        System.out.println("表现层删除课程");

        int updateReply = courseServise.deleteCourse(id);
        if (updateReply == 1) {
            return success("成功", updateReply);
        } else if (updateReply == 0) {
            return warn("警告，影响行数为0,可能未删除课程", updateReply);
        } else {
            return warn("警告，影响行数不为0和1,可能多删除几行课程", updateReply);
        }
    }

    @PostMapping("/addCourse")
    @ResponseBody
    public AjaxResult addCourse(@RequestBody Course course) {
        System.out.println("表现层增加课程信息");
        System.out.println(course.toString());
        int insertReply = courseServise.addCourse(course);
        if (insertReply == 1) {
            return success("成功", insertReply);
        } else if (insertReply == 0) {
            return warn("警告，影响行数为0,可能未修改", insertReply);
        } else {
            return warn("警告，影响行数不为0和1,可能多修改了几行", insertReply);
        }
    }

    @RestController
    @CrossOrigin
    public class UploadDownController {

        /**
         * 文件上传
         * @param file
         * @param request
         * @return
         */
        @PostMapping("/uploadCourseImg")
        public AjaxResult upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

            System.out.println(file.toString());
            //获取文件在服务器的储存位置
//            String path =  ClassUtils.getDefaultClassLoader().getResource("").getPath()+
//                    "resources"+File.separator+"uploadCourseImg";
            String path = request.getSession().getServletContext().getRealPath("resources/uploadCourseImg");
            File filePath = new File(path);
            System.out.println("文件的保存路径：" + path);
            if (!filePath.exists() && !filePath.isDirectory()) {
                System.out.println("目录不存在，创建目录:" + filePath);
                filePath.mkdirs();
            }

            //获取原始文件名称(包含格式)
            String originalFileName = file.getOriginalFilename();
            System.out.println("原始文件名称：" + originalFileName);

            //获取文件类型，以最后一个`.`为标识
            String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
            System.out.println("文件类型：" + type);
            //获取文件名称（不包含格式）
            String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));

            //设置文件新名称: 当前时间+文件名称（不包含格式）
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String date = sdf.format(d);
            String fileName = date + name + "." + type;
            System.out.println("新文件名称：" + fileName);

            //在指定路径下创建一个文件
            File targetFile = new File(path, fileName);

            //将文件保存到服务器指定位置
            try {
                file.transferTo(targetFile);
                System.out.println("上传成功");
                //将文件在服务器的存储路径返回

                return success("上传","resources/uploadCourseImg/" + fileName);
            } catch (IOException e) {
                System.out.println("上传失败");
                e.printStackTrace();
                return error("上传失败");
            }
        }
    }


    @PostMapping("/findCourseByType")
    @ResponseBody
    public AjaxResult findCourseByType(String typeName) {
        System.out.println("表现层根据typeName查询课程" + typeName);
        List<Course> list = courseServise.findCourseByType(typeName);
        return success("成功", list);

    }

    @RestController
    @CrossOrigin
    public class UploadVideoController {

        /**
         * 视频上传
         * @param file
         * @param request
         * @return
         */
        @PostMapping("/uploadCourseVideo")
        public AjaxResult upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

            System.out.println(file.toString());
            //获取文件在服务器的储存位置
//            String path =  ClassUtils.getDefaultClassLoader().getResource("").getPath()+
//                    "resources"+File.separator+"uploadCourseImg";
            String path = request.getSession().getServletContext().getRealPath("resources/uploadCourseVideo");
            File filePath = new File(path);
            System.out.println("文件的保存路径：" + path);
            if (!filePath.exists() && !filePath.isDirectory()) {
                System.out.println("目录不存在，创建目录:" + filePath);
                filePath.mkdirs();
            }

            //获取原始文件名称(包含格式)
            String originalFileName = file.getOriginalFilename();
            System.out.println("原始文件名称：" + originalFileName);

            //获取文件类型，以最后一个`.`为标识
            String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
            System.out.println("文件类型：" + type);
            //获取文件名称（不包含格式）
            String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));

            //设置文件新名称: 当前时间+文件名称（不包含格式）
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String date = sdf.format(d);
            String fileName = date + name + "." + type;
            System.out.println("新文件名称：" + fileName);

            //在指定路径下创建一个文件
            File targetFile = new File(path, fileName);

            //将文件保存到服务器指定位置
            try {
                file.transferTo(targetFile);
                System.out.println("上传成功");
                //将文件在服务器的存储路径返回

                return success("上传","resources/uploadCourseVideo/" + fileName);
            } catch (IOException e) {
                System.out.println("上传失败");
                e.printStackTrace();
                return error("上传失败");
            }
        }
    }
}