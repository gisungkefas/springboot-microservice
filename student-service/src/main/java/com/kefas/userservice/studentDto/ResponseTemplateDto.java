package com.kefas.userservice.studentDto;

import com.kefas.userservice.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateDto {

    private Student student;

    private Department department;
}
