package com.register.service;

import com.register.entity.Student;
import com.register.entity.Teacher;

public interface RegisterService {
    public int registerStudent(Student student);
    public int registerTeacher(Teacher teacher);
}
