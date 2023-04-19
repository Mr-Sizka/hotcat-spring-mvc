package com.mvcspring.hotcat.dao;

import com.mvcspring.hotcat.exception.NotFoundException;
import com.mvcspring.hotcat.model.Student;
import com.mvcspring.hotcat.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentDao {

    @Autowired
    private StudentRepo repo;

    public Student saveStudent(Student student){

        return repo.save(student);

    }

    public Student updateStudent(Student student) throws NotFoundException {
        Optional<Student> tempStudent = repo.findById(student.getId());
        if (tempStudent.isPresent()){
            tempStudent.get().setName(student.getName());
            tempStudent.get().setAddress(student.getAddress());
            tempStudent.get().setMarks(student.getMarks());
            return repo.save(student);
        }
        throw new NotFoundException("User Not Found!");
    }

    public Student deleteStudent(String id) throws NotFoundException {
        Optional<Student> student = repo.findById(id);
        if (student.isPresent()){
            repo.deleteById(id);
            return student.get();
        }
        throw new NotFoundException("User Not Found!");
    }

    public Student getStudent(String id) throws NotFoundException {
        Optional<Student> student = repo.findById(id);
        if (student.isPresent()){
            return student.get();
        }
        throw new NotFoundException("User Not Found!");
    }

    public Page<Student> getAllStudents(int page , int size){
        return repo.findAll(PageRequest.of(page, size));
    }
}
