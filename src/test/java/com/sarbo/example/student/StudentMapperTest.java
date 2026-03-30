package com.sarbo.example.student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    public  void shouldMapStudentDtoToStudent(){
        StudentDTO dto = new StudentDTO("John", "Doe", "John@mail.com", 1);

        Student student = mapper.toStudent(dto);

        assertEquals(dto.firstname(), student.getFirstname());
        assertEquals(dto.lastname(), student.getLastname());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(), student.getSchool().getId());
    }

    @Test
    public void should_throw_null_pointer_exception_when_studentDto_is_null(){
        var exp = assertThrows(NullPointerException.class, () -> mapper.toStudent(null));
        assertEquals("The Student DTO should not be null", exp.getMessage());

    }

    @Test
    public  void shouldMapStudentToStudentResponseDto(){
        // Given
        Student student = new Student("Jane", "Doe", "Jane@mail.com", 20);

        // When
        StudentResponseDTO dto = mapper.toStudentResponseDTO(student);

        // Then
        assertEquals(student.getFirstname(), dto.firstname());
        assertEquals(student.getLastname(), dto.lastname());
        assertEquals(student.getEmail(), dto.email());
    }

}
//    @BeforeAll
//    static void beforeAll() {
//        System.out.println("Inside the before all method");
//    }
//
//    @AfterAll
//    static void afterAll() {
//        System.out.println("Inside the after all method");
//    }
//
//    @BeforeEach
//    void setUp() {
//        System.out.println("Inside the before each method");
//    }
//
//    @AfterEach
//    void tearDown() {
//        System.out.println("Inside the after each method");
//    }
//
//    @Test
//    public void testMethod1(){
//        System.out.println("My first test method");
//    }
//
//    @Test
//    public void testMethod2(){
//        System.out.println("My second test method");
//    }


