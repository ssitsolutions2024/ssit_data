package com.example.Student_Reg;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-generate rollno
    private Integer rollno;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private long mobile;
    private String branch;
}
