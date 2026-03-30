package com.sarbo.example.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    // which service we want to test
    @InjectMocks
    private StudentService studentService;

    // declare the dependencies
    @Mock
    private StudentRepository repository;
    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

    }

    @Test
    public void should_successfully_save_a_student(){
        // Given
        StudentDTO dto = new StudentDTO(
                "John",
                "Doe",
                "John@mail.com",
                1
        );

        Student student = new Student(
                "John",
                "Doe",
                "John@mail.com",
                20
        );

        Student savedStudent = new Student(
                "John",
                "Doe",
                "John@mail.com",
                20
        );
        savedStudent.setId(1);

        // Mock the calls
        when(studentMapper.toStudent(dto)).thenReturn(student);
        when(repository.save(student)).thenReturn(savedStudent);
        when(studentMapper.toStudentResponseDTO(savedStudent))
                .thenReturn(new StudentResponseDTO(
                        "John",
                        "Doe",
                        "John@mail.com")
                );


        // When
        StudentResponseDTO responseDTO = studentService.saveStudent(dto);

        // Then
        assertEquals(dto.firstname(), responseDTO.firstname());
        assertEquals(dto.lastname(), responseDTO.lastname());
        assertEquals(dto.email(), responseDTO.email());

        verify(studentMapper, times(1)).toStudent(dto);
        verify(repository, times(1)).save(student);
        verify(studentMapper, times(1)).toStudentResponseDTO(savedStudent);
    }

    @Test
    public void should_return_all_students(){
        // Given
        List<Student> students = new ArrayList<>();
        students.add( new Student(
                "John",
                "Doe",
                "John@mail.com",
                20
        ));


        // Mock the calls
        when(repository.findAll()).thenReturn(students);
        when(studentMapper.toStudentResponseDTO(any(Student.class)))
                .thenReturn(new StudentResponseDTO(
                        "John",
                        "Doe",
                        "John@mail.com")
                );


        // When
        List<StudentResponseDTO> responseDtos = studentService.findAllStudent();


        // Then
        assertEquals(students.size(), responseDtos.size());

        verify(repository, times(1)).findAll();
    }

    @Test
    public void should_return_a_student_by_id(){
        // Given
        Student student = new Student(
                "John",
                "Doe",
                "John@mail.com",
                20
        );

        int id = 1;
        student.setId(id);

        // Mock the calls
        when(repository.findById(id)).thenReturn(Optional.of(student));
        when(studentMapper.toStudentResponseDTO(any(Student.class)))
                .thenReturn(new StudentResponseDTO(
                        "John",
                        "Doe",
                        "John@mail.com")
                );


        // When
        StudentResponseDTO responseDto = studentService.findStudentById(id);


        // Then
        assertEquals(student.getFirstname(), responseDto.firstname());
        assertEquals(student.getLastname(), responseDto.lastname());
        assertEquals(student.getEmail(), responseDto.email());

        verify(repository, times(1)).findById(id);
    }

    @Test
    public void should_return_student_by_name(){
        // Given
        List<Student> students = new ArrayList<>();
        students.add( new Student(
                "John",
                "Doe",
                "John@mail.com",
                20
        ));

        String studentName = "John";


        // Mock the calls
        when(repository.findAllByFirstnameContaining(studentName)).thenReturn(students);
        when(studentMapper.toStudentResponseDTO(any(Student.class)))
                .thenReturn(new StudentResponseDTO(
                        "John",
                        "Doe",
                        "John@mail.com")
                );


        // When
        List<StudentResponseDTO> responseDtos = studentService.FindStudentsByName(studentName);


        // Then
        assertEquals(students.size(), responseDtos.size());

        verify(repository, times(1)).findAllByFirstnameContaining(studentName);
    }



}