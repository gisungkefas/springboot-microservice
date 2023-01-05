package com.kefas.departmentservice.service;

import com.kefas.departmentservice.departmentDto.DepartmentDto;
import com.kefas.departmentservice.entities.Department;

public interface DepartmentService {

    DepartmentDto createDepartment(DepartmentDto departmentDto);

    DepartmentDto editDepartment(DepartmentDto departmentDto, Long departmentId);

    Department getDepartmentByName(Long departmentId);

}
