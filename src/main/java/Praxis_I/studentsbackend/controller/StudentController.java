package Praxis_I.studentsbackend.controller;

import Praxis_I.studentsbackend.model.Student;
import Praxis_I.studentsbackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/student")
@RestController
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PutMapping("")
    public void insertStudent(@RequestBody Student student) {
        studentService.insertStudent(student);
    }

    @GetMapping("")
    public List<Student> getStudentList() {
        return studentService.getStudentList();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable UUID id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/{id}")
    public boolean updateStudent(@RequestBody Student student, @PathVariable UUID id) {
        return studentService.updateStudent(student, id);
    }
}
