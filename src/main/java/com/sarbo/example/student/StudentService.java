package com.sarbo.example.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository repository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDTO saveStudent(StudentDTO dto)
    {
        var student = studentMapper.toStudent(dto);
        var savedStudent = repository.save(student);
        return studentMapper.toStudentResponseDTO(savedStudent);
    }

    public List<StudentResponseDTO> findAllStudent(){
        return repository.findAll().stream().map(studentMapper::toStudentResponseDTO).collect(Collectors.toList());
    }

    public StudentResponseDTO findStudentById(Integer studentId)
    {
//        var student = repository.findById(studentId).orElse(new Student());
//        var studentDTO = studentMapper.toStudentResponseDTO(student);
        return repository.findById(studentId).map(studentMapper::toStudentResponseDTO).orElse(null);
    }

    public List<StudentResponseDTO> FindStudentsByName(String studentName)
    {
        return repository.findAllByFirstnameContaining(studentName).stream().map(studentMapper::toStudentResponseDTO).collect(Collectors.toList());
    }

    public void delete(Integer studentId)
    {
        repository.deleteById(studentId);
    }
}
