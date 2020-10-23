package com.hk.zwp.service.impl;

import com.hk.zwp.bean.Student;
import com.hk.zwp.dao.StudentMapper;
import com.hk.zwp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public List<Student> getAll() {
        return studentMapper.queryAll();
    }

    @Override
    public void insert(String name, Integer score, String className, String head) {
        studentMapper.insert(name,score,className,head);
    }

    @Override
    public void update(Integer id,String name, Integer score, String className, String head) {
        studentMapper.update(id,name,score,className,head);
    }

    @Override
    public Student queryById(Integer id) {
        return studentMapper.queryById(id);
    }

    @Override
    public void deleteById(Integer id) {
        studentMapper.deleteById(id);
    }

    @Override
    public List<Student> selectByClassNameOrName(String className, String name) {
        System.out.println(className + "  ------------  " + name);
        return studentMapper.selectByClassNameOrName(className,name);
    }
}
