package com.kefas.userservice.service;

import com.kefas.userservice.entities.Student;
import com.kefas.userservice.studentDto.ResponseTemplateDto;
import com.kefas.userservice.studentDto.StudentDto;
import java.util.List;

public interface StudentService {

    StudentDto createStudent(StudentDto studentDto);

    StudentDto editStudent(StudentDto studentDto, Long studentId);

    String deleteStudent(Long studentId);

    Student getStudentById(Long studentId);

    List<Student> getAllStudent();

    ResponseTemplateDto getStudentWithDepartment(Long studentId);
}
