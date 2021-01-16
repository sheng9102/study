package com.sweet.mapper;

import com.sweet.domain.model.Student;
import org.apache.ibatis.annotations.Mapper;
public interface StudentMapper {

    public Student selectStudent(Integer id);

}
