package com.sweet.web.controller;

import com.sweet.domain.model.Student;
import com.sweet.mapper.StudentMapper;
import com.sweet.service.school.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/moto")
public class MotoController {
    @Autowired
    private StudentService selectStudent;

    // restful
    // http://127.0.0.1:8080/moto/gogo/1
    @GetMapping(value = "/gogo/{km}")
    String gogoing(@PathVariable("km") int km) {
        Student student = selectStudent.getStudent(km);
        return "I will gogoing" + student + "Km";
    }

    @RequestMapping(value = "/gogo1")
    String gogoing1() {
        return "I will gogoing1" + 666 + "Km";
    }
}
