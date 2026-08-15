package com.example.Student_Reg;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message)
    {
        super(message);
    }
}
