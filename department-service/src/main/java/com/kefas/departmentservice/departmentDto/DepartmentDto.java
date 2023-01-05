package com.kefas.departmentservice.departmentDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {

    private Long departmentId;

    @NotNull(message = "Department name cannot be Empty")
    private String departmentName;

    @NotNull(message = "Department Address cannot be Empty")
    private String departmentAddress;

    @NotNull(message = "Department Code code should not be Empty")
    private String departmentCode;
}
