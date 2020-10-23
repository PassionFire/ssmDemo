package com.hk.zwp.controller;

import com.hk.zwp.bean.Student;
import com.hk.zwp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/show")
    public String show(ModelMap modelMap) {
        List<Student> stu = studentService.getAll();
        modelMap.put("students",stu);
        return "show";
    }

    @PostMapping("/add")
    public String add(MultipartFile file,String name,Integer score,String className,String head) throws IOException {
        if(file.getSize() == 0) {
            studentService.insert(name, score, className,null);
        }
        //获取上传的文件名
        String realFileName = file.getOriginalFilename();
        //String fileTyle=realFileName.substring(realFileName.lastIndexOf("."),realFileName.length());
        //String newFileName = UUID.randomUUID()+realFileName;
        //保存到数据库的路径
        String imageDir = "image";
        String savePath = imageDir+"/"+realFileName;
        //文件上传的目标路径
        String realPath = "D:\\网上商城\\ssmDemo\\src\\main\\webapp\\"+savePath;
        System.out.println(realFileName+"---"+savePath+"---"+realPath);
        File realImage = new File(realPath);
        file.transferTo(realImage);
        studentService.insert(name, score, className,savePath);
        return "redirect:show";
    }

    @GetMapping("/queryById")
    public String queryById(Integer id, ModelMap modelMap) {
        Student stu = studentService.queryById(id);
        modelMap.put("student", stu);
        System.out.println(stu);
        return "update";
    }

    @PostMapping("/edit")
    public String edit(MultipartFile file, Integer id, String name, Integer score, String className, String head) throws IOException {
        if(file.getSize() == 0) {
            studentService.update(id, name, score, className, null);
        }
        //获取上传的文件名
        String realFileName = file.getOriginalFilename();
        //String fileTyle=realFileName.substring(realFileName.lastIndexOf("."),realFileName.length());
        //String newFileName = UUID.randomUUID()+realFileName;
        //保存到数据库的路径
        String imageDir = "image";
        String savePath = imageDir+"/"+realFileName;
        //文件上传的目标路径
        String realPath = "D:\\网上商城\\ssmDemo\\src\\main\\webapp\\"+savePath;
        System.out.println(realFileName+"---"+savePath+"---"+realPath);
        File realImage = new File(realPath);
        file.transferTo(realImage);
        studentService.update(id,name,score,className,savePath);
        return "redirect:show";
    }

    @GetMapping("/deleteById")
    public String deleteById(Integer id){
        studentService.deleteById(id);
        return "redirect:show";
    }

    @PostMapping("/selectByClassNameOrName")
    public String selectByClassNameOrName(String className, String name, ModelMap modelMap){
        if (className.equals("全部")){
            className = null;
        }
        List<Student> stu = studentService.selectByClassNameOrName(className,name);
        modelMap.put("students",stu);
        System.out.println(stu);
        return "show";
    }

    @GetMapping("/login")
    public String login(){
        return "show";
    }
}
