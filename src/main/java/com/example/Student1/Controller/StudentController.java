package com.example.Student1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Student1.Entity.Student;
import com.example.Student1.Service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
    StudentService service;
@Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = service.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @PostMapping
    public ResponseEntity<List<Student>> createStudent(@RequestBody List<Student> stud) {
        List<Student> Savedstudents = service.saveUser(stud);
        return ResponseEntity.ok(Savedstudents);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long ID) {
        Student student = service.getById(ID);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(ID);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{ID}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Long ID,
            @RequestBody Student updatedStudent) {

        Student student = service.getById(ID);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedStudent);
    }
}
