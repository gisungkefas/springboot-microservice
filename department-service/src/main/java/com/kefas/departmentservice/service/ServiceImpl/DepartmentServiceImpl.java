package com.kefas.departmentservice.service.ServiceImpl;

import com.kefas.departmentservice.departmentDto.DepartmentDto;
import com.kefas.departmentservice.entities.Department;
import com.kefas.departmentservice.exception.DepartmentAlreadyExistException;
import com.kefas.departmentservice.exception.DepartmentNotFoundException;
import com.kefas.departmentservice.repository.DepartmentRepository;
import com.kefas.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = new Department();

        boolean existDepartment = departmentRepository.findByDepartmentId(departmentDto.getDepartmentId()).isPresent();
        if(existDepartment){
            throw new DepartmentAlreadyExistException("Department with "+departmentDto.getDepartmentName()+" Already Exist");
        }

        department.setDepartmentId(departmentDto.getDepartmentId());
        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDepartmentAddress(departmentDto.getDepartmentAddress());
        department.setDepartmentCode(departmentDto.getDepartmentCode());

        return departmentDto;
    }

    @Override
    public DepartmentDto editDepartment(DepartmentDto departmentDto, Long departmentId) {
        Department department = departmentRepository.findByDepartmentId(departmentId).
                orElseThrow(()-> new DepartmentNotFoundException("Department with name: "+ departmentId +" is not found"));

        if(departmentDto.getDepartmentName() != null && !departmentDto.getDepartmentName().equals(department.getDepartmentName())){
            department.setDepartmentName(departmentDto.getDepartmentName());
        }

        if(departmentDto.getDepartmentAddress() != null && !departmentDto.getDepartmentAddress().equals(department.getDepartmentAddress())){
            department.setDepartmentAddress(departmentDto.getDepartmentAddress());
        }

        if(departmentDto.getDepartmentCode() != null && !departmentDto.getDepartmentCode().equals(department.getDepartmentCode())){
            department.setDepartmentCode(departmentDto.getDepartmentCode());
        }

        departmentRepository.save(department);

        return departmentDto;
    }

    @Override
    public Department getDepartmentByName(Long departmentId) {
        return departmentRepository.findByDepartmentId(departmentId)
                .orElseThrow(() -> {
                    throw new DepartmentNotFoundException("Department with Name: " + departmentId + " Not Found");
                });
    }
}
