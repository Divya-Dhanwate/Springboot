package com.example.Student1.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="students")
public class Student{
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
  private String name;
    private String contact;
    private String address;
    private String gmail;
    private String admission;
    private String branch;
    private String date;
    private String admissionType;
    private String category;
    private String studentClass;
    private String parentsContact;
    private String occupation;
    private String parentname;

}
