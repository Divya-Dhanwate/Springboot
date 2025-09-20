package com.example.Student1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Student1.Entity.Student;
import com.example.Student1.Repository.StudentsRepo;

@Service
public class StudentService {

    @Autowired
    private StudentsRepo repo;

    public List<Student> saveUser(List<Student> student) {
        return repo.saveAll(student);

    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student getById(Long ID){
    return repo.findById(ID)
               .orElseThrow(() -> new RuntimeException("Student not found with id: " + ID));
}

public Student deleteById(Long ID){
  Student student = repo.findById(ID)
        .orElseThrow(() -> new RuntimeException("Student not found with id: " + ID));

    repo.deleteById(ID);
    return student;
}
}
