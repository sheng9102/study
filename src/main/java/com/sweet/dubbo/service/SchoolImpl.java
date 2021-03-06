package com.sweet.dubbo.service;

import com.school.school.SchoolInterface;
import com.sweet.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.dubbo.config.annotation.Service;

@Service
public class SchoolImpl implements SchoolInterface {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public String getClassMateName(int id) {
        return studentMapper.selectStudent(id).getName();
    }
}
