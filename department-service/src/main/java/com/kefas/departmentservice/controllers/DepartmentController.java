package com.kefas.departmentservice.controllers;

import com.kefas.departmentservice.departmentDto.DepartmentDto;
import com.kefas.departmentservice.entities.Department;
import com.kefas.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/departments")
@CrossOrigin
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/create-department")
    public ResponseEntity<DepartmentDto> createDepartment(@Valid @RequestBody DepartmentDto departmentDto){

        return new ResponseEntity<>(departmentService.createDepartment(departmentDto), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{departmentId}/edit-student")
    public ResponseEntity<DepartmentDto> editDepartment(@RequestBody DepartmentDto departmentDto, @PathVariable Long departmentId) {
        DepartmentDto editDepartment = departmentService.editDepartment(departmentDto, departmentId);

        return new ResponseEntity<>(editDepartment, HttpStatus.OK);
    }

    @GetMapping("/get-department/{departmentId}")
    public ResponseEntity<Department> getStudentById(@PathVariable Long departmentId){
        Department department = departmentService.getDepartmentByName(departmentId);

        return new ResponseEntity<>(department, HttpStatus.OK);
    }
}
