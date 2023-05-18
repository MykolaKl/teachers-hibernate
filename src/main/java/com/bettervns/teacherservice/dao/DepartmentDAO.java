package com.bettervns.teacherservice.dao;


import com.bettervns.teacherservice.models.Department;
import com.bettervns.teacherservice.models.Teacher;
import com.bettervns.teacherservice.repository.DepartmentRepository;
import com.bettervns.teacherservice.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Component
public class DepartmentDAO {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentDAO(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }


    public Department getDepartmentById(int id) {
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) {
            return department.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
        }
    }

    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }


    public void update(int id, Department updatedDepartment) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (optionalDepartment.isPresent()) {
            Department dep = optionalDepartment.get();
            dep.setName(updatedDepartment.getName());
            dep.setPhone(updatedDepartment.getPhone());
            dep.setEmail(updatedDepartment.getEmail());
            departmentRepository.save(dep);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
        }
    }


    public void deleteDepartment(int id) {
        departmentRepository.deleteById(id);
    }



//    public void addDepartment(Department department) {
//        coreJdbcTemplate.update("INSERT INTO department(name, phone, email) VALUES(?, ?, ?)",
//                department.getName(), department.getPhone(), department.getEmail());
//    }
//
//    public void update(int id, Department department) {
//        coreJdbcTemplate.update("UPDATE department SET name = ?, phone = ?, email = ? WHERE id=?",
//                department.getName(), department.getPhone(), department.getEmail(), id);
//    }
//
//    public void delete(int id) {
//        coreJdbcTemplate.update("DELETE FROM department WHERE id = ?", id);
//    }
}