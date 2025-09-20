package com.example.Pravara1.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name ="pravara")
public class Product {
   
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String name;
  
    private String RollColl;

}

