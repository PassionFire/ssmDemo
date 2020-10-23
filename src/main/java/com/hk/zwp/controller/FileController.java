package com.hk.zwp.controller;

import com.hk.zwp.bean.Student;
import com.hk.zwp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 上传处理器
 */
@Controller
public class FileController {

    @Autowired
    private StudentService studentService;

    /**
     * 上传
     * @param file
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String fileUpload(MultipartFile file, Student student, ModelMap modelMap) throws IllegalStateException, IOException {
        /**
         * 上传图片
         */
        //图片上传成功后，将图片的地址写到数据库
        String filePath = "E:\\upFile";//保存图片的路径,tomcat中有配置
        //获取原始图片的拓展名
        String originalFilename = file.getOriginalFilename();
        //新的文件名字，使用uuid随机生成数+原始图片名字，这样不会重复
        String newFileName = UUID.randomUUID()+originalFilename;
        //封装上传文件位置的全路径，就是硬盘路径+文件名
        File targetFile = new File(filePath,newFileName);
        //把本地文件上传到已经封装好的文件位置的全路径就是上面的targetFile
        file.transferTo(targetFile);
        student.setHead(newFileName);//文件名保存到实体类对应属性
        return "jsp/success";
    }
}

