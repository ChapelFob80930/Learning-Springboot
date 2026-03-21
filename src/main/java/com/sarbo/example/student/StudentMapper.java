package com.sarbo.example.student;

import com.sarbo.example.school.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student toStudent(StudentDTO dto){
        var student = new Student();
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());

        var school = new School();
        school.setId(dto.schoolId());
        student.setSchool(school);
        return student;
    }

    public StudentResponseDTO toStudentResponseDTO(Student student){
        return new StudentResponseDTO(
                student.getFirstname(),
                student.getLastname(),
                student.getEmail());
    }
}
