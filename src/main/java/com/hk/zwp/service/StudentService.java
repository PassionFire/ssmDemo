package com.hk.zwp.service;

import com.hk.zwp.bean.Student;
import java.util.List;

public interface StudentService {

    List<Student> getAll();

    void insert(String name,Integer score,String className,String head);

    void update(Integer id,String name,Integer score,String className,String head);

    Student queryById(Integer id);

    void deleteById(Integer id);

    List<Student> selectByClassNameOrName(String className,String name);
}
