package com.bettervns.teacherservice.controllers;


import com.bettervns.teacherservice.dao.DepartmentDAO;
import com.bettervns.teacherservice.models.Department;
import com.bettervns.teacherservice.models.Teacher;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("")
public class DepartmentsController {
    private final DepartmentDAO departmentDAO;

    @Autowired
    public DepartmentsController(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }


    @GetMapping("/departments")
    public ResponseEntity<?> getAllTeachers() {
        return ResponseEntity.ok(new Gson().toJson(departmentDAO.getAllDepartments()));
    }


    @GetMapping("/department/{id}")
    public ResponseEntity<?> getTeacherById(@PathVariable("id") int id) {
        System.out.println(departmentDAO.getDepartmentById(id));
        return ResponseEntity.ok(new Gson().toJson(departmentDAO.getDepartmentById(id)));
    }

    @PostMapping("/department")
    public Department createDepartment(@RequestBody Department department) {
        return departmentDAO.addDepartment(department);
    }

    @PatchMapping("/department/{id}")
    public void update(@RequestBody Department department, @PathVariable("id") int id) {
        departmentDAO.update(id, department);
    }


    @DeleteMapping("/department/{id}")
    public RedirectView delete(@PathVariable("id") int id) {
        departmentDAO.deleteDepartment(id);
        return new RedirectView("http://localhost:8080/teachers");
    }

}