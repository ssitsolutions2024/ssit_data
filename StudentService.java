package com.example.Student_Reg;

import com.example.Student_Reg.Student;
import com.example.Student_Reg.StudentNotFoundException;
import com.example.Student_Reg.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public Student saveStudent(Student s) {
        return repo.save(s);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student getStudentById(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
    }

    public void deleteStudent(int id) {
        repo.deleteById(id);
    }
}
