package com.example.Student1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Student1.Entity.Student;

public interface StudentsRepo extends JpaRepository<Student ,Long> {

}
