package com.bettervns.teacherservice.controllers;


import com.bettervns.teacherservice.dao.TeacherDAO;
import com.bettervns.teacherservice.models.Teacher;
import com.bettervns.teacherservice.requests.TeachersRequest;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;



@RestController
@RequestMapping("")
public class TeachersController {

    private final TeacherDAO teacherDAO;

    @Autowired
    public TeachersController(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @GetMapping("/teachers")
    public ResponseEntity<?> getAllTeachers() {
        return ResponseEntity.ok(new Gson().toJson(teacherDAO.getAllTeachers()));
    }

    @GetMapping("/teacher/id")
    public ResponseEntity<?> getTeacherById(@PathVariable("id") int employeeId){
        return new ResponseEntity<Teacher>(teacherDAO.getTeacherById(employeeId), HttpStatus.OK);
    }


    @PostMapping("/teacher")
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherDAO.addTeacher(teacher);
    }


    @PatchMapping("/teacher/{id}")
    public ResponseEntity<?> editGroup(@RequestBody TeachersRequest requestObject, @PathVariable("id") int id){
        teacherDAO.update(id, new Teacher(requestObject.name(), requestObject.surname(), requestObject.father(),
                requestObject.email(), requestObject.chair_id()));
        return ResponseEntity.ok("added");
    }


    @DeleteMapping("teacher/{id}")
    public RedirectView delete(@PathVariable("id") int id) {
        teacherDAO.deleteTeacher(id);
        return new RedirectView("http://localhost:8080/teachers");
    }
//
}
