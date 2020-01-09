package com.register.dao;

import com.register.entity.Student;
import com.register.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


@Component
@Mapper
public interface RegisterDao {

    public int qryStudent(String stuNo);
    public int registerStudent(Student student);

    public int qryTeacher(String teachNo);
    public int registerTeacher(Teacher teacher);
}
