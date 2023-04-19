package com.mvcspring.hotcat.repo;

import com.mvcspring.hotcat.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface StudentRepo extends JpaRepository<Student, String> {
}
