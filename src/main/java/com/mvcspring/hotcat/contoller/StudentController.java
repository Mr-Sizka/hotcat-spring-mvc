package com.mvcspring.hotcat.contoller;

import com.mvcspring.hotcat.dao.StudentDao;
import com.mvcspring.hotcat.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentDao dao;

    @PostMapping("/save")
    public Student saveStudent(
            @RequestParam String id,
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam int marks
    ){
        return dao.saveStudent(new Student(id,name,address,marks));
    }

    @PutMapping("/update")
    public Student updateStudent(
            @RequestParam String id,
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam int marks
    ){
        return dao.updateStudent(new Student(id,name,address,marks));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id){
        return dao.deleteStudent(id);
    }

    @GetMapping("/get/{id}")
    public Student getStudent(@PathVariable String id){
        return  dao.getStudent(id);
    }

    @GetMapping("/list/{page}/{size}")
    public Page getAllstudent(@PathVariable int page,
                              @PathVariable int size){
        return dao.getAllStudents(page,size);
    }
}
