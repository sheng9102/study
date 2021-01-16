package com.sweet.service.school.impl;

import com.sweet.domain.model.Student;
import com.sweet.mapper.StudentMapper;
import com.sweet.service.school.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public Student getStudent(int id) {
        return studentMapper.selectStudent(id);
    }
}
