package com.sweet.web.controller;

import com.sweet.domain.model.Student;
import com.sweet.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/moto")
public class MotoController {
    @Autowired
    private StudentMapper studentMapper;

    //restful
    @GetMapping(value = "/gogo/{km}")
    String gogoing(@PathVariable("km") int km) {
        Student student = studentMapper.selectStudent(km);
        return "I will gogoing" + student + "Km";
    }

    @RequestMapping(value = "/gogo1")
    String gogoing1() {
        return "I will gogoing1" + 666 + "Km";
    }
}
