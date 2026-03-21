package com.sarbo.example.student;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student")
    public StudentResponseDTO saveStudent(
            @RequestBody StudentDTO dto
    ) {
        return this.studentService.saveStudent(dto);
    }


    @GetMapping("/students")
    public List<StudentResponseDTO> findAllStudent() {
        return this.studentService.findAllStudent();
    }

    @GetMapping("/students/{student-id}")
    public StudentResponseDTO findStudentById(
            @PathVariable("student-id") Integer id
    ) {
        return this.studentService.findStudentById(id);
    }

    @GetMapping("/students/search/{student-name}")
    public List<StudentResponseDTO> FindStudentsByName(
            @PathVariable("student-name") String name
    ) {
        return this.studentService.FindStudentsByName(name);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("student-id") Integer id
    ) {
        this.studentService.delete(id);
    }

}
