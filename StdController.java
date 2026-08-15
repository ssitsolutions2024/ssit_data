package com.example.Student_Reg;

import com.example.Student_Reg.Student;
import com.example.Student_Reg.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/students")
public class StdController {


    @Autowired
    private StudentService service;

    @PostMapping
    public Student add(@RequestBody Student s) {
        return service.saveStudent(s);   // ✅ must match service method name
    }

    @GetMapping
    public List<Student> all() {
        return service.getAllStudents(); // ✅ must match service method name
    }

    @GetMapping("/{id}")
    public Student one(@PathVariable int id) {
        return service.getStudentById(id); // ✅ must match service method name
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable int id, @RequestBody Student s) {
        s.setRollno(id);
        return service.saveStudent(s);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.deleteStudent(id); // ✅ must match service method name
    }
}
