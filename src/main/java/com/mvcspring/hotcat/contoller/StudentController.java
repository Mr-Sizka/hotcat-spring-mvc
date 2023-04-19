package com.mvcspring.hotcat.contoller;

import com.mvcspring.hotcat.dao.StudentDao;
import com.mvcspring.hotcat.exception.StandardResponse;
import com.mvcspring.hotcat.exception.NotFoundException;
import com.mvcspring.hotcat.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentDao dao;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveStudent(
            @RequestParam String id,
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam int marks
    ){
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Success!",
                        dao.saveStudent(new Student(id,name,address,marks))
                ), HttpStatus.CREATED
        );
    }

    @PutMapping("/update")
    public ResponseEntity<StandardResponse> updateStudent(
            @RequestParam String id,
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam int marks
    ) throws NotFoundException {
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Updated!",
                        dao.updateStudent(new Student(id,name,address,marks))
                ), HttpStatus.OK
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<StandardResponse> deleteStudent(@PathVariable String id) throws NotFoundException {
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Deleted!",
                        dao.deleteStudent(id)
                ), HttpStatus.OK
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<StandardResponse> getStudent(@PathVariable String id) throws NotFoundException {
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Found!",
                        dao.getStudent(id)
                ), HttpStatus.OK
        );
    }

    @GetMapping("/list/{page}/{size}")
    public ResponseEntity<StandardResponse> getAllstudent(@PathVariable int page,
                              @PathVariable int size){
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Customer List!",
                        dao.getAllStudents(page,size)
                ), HttpStatus.OK
        );
    }
}
