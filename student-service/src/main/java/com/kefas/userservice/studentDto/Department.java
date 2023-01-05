package com.kefas.userservice.studentDto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    private Long departmentId;

    private String departmentName;

    private String departmentAddress;

    private String departmentCode;
}
