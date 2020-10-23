package com.hk.zwp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hk.zwp.bean.Student;

public interface StudentMapper {

	List<Student> queryAll();

	void insert(@Param("name") String name,@Param("score") Integer score,@Param("className") String className,@Param("head") String head);
	
	void update(@Param("id") Integer id,@Param("name") String name,@Param("score") Integer score,@Param("className") String className,@Param("head") String head);

	Student queryById(Integer id);

	void deleteById(Integer id);
	
	// 如果接口方法中有多个参数，就需要使用@param来指定参数名称
//	Student selectByCondition(@Param("name") String name,@Param("score") int score);
//

	List<Student> selectByClassNameOrName(@Param("className") String className,@Param("name") String name);

//
//	List<Student> selectPostIn(List<Integer> ids);
}
