package com.example.Student_Reg;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository repo;

    @InjectMocks
    private StudentService service;

    @Test
    void testGetStudentById_found() {
        Student student = new Student(1, "Virat", "virat@gmail.com", 9876543210L, "CS");
        when(repo.findById(1)).thenReturn(Optional.of(student));

        Student result = service.getStudentById(1);

        assertNotNull(result);
        assertEquals("Virat", result.getName());
        verify(repo, times(1)).findById(1);
    }

    @Test
    void testGetStudentById_notFound() {
        when(repo.findById(99)).thenReturn(Optional.empty());

        assertThrows(StudentNotFoundException.class, () -> service.getStudentById(99));
    }

    @Test
    void testGetAllStudents() {
        List<Student> students = Arrays.asList(
                new Student(1, "Virat", "virat@gmail.com", 9876543210L, "CS"),
                new Student(2, "Rohit", "rohit@gmail.com", 9876543211L, "IT")
        );
        when(repo.findAll()).thenReturn(students);

        List<Student> result = service.getAllStudents();

        assertEquals(2, result.size());
        verify(repo, times(1)).findAll();
    }

    @Test
    void testDeleteStudent_success() {
        when(repo.existsById(1)).thenReturn(true);

        service.deleteStudent(1);

        verify(repo, times(1)).deleteById(1);
    }

    @Test
    void testDeleteStudent_notFound() {
        when(repo.existsById(99)).thenReturn(false);

        assertThrows(StudentNotFoundException.class, () -> service.deleteStudent(99));
    }
}
