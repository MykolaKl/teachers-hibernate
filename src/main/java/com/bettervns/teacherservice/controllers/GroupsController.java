package com.bettervns.teacherservice.controllers;

import com.bettervns.teacherservice.dao.DepartmentDAO;
import com.bettervns.teacherservice.dao.GroupDAO;
import com.bettervns.teacherservice.models.Department;
import com.bettervns.teacherservice.models.Group;
import com.bettervns.teacherservice.requests.DepartmentRequest;
import com.bettervns.teacherservice.requests.NewGroupRequest;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class GroupsController {

    private final GroupDAO groupDAO;
    private final DepartmentDAO departmentDAO;

    @Autowired
    public GroupsController(GroupDAO groupDAO, DepartmentDAO departmentDAO) {
        this.groupDAO = groupDAO;
        this.departmentDAO = departmentDAO;
    }

    @GetMapping("/groups")
    public ResponseEntity<?> index(){
        return ResponseEntity.ok(new Gson().toJson(groupDAO.getAllGroups()));
    }

    @GetMapping("/group/{id}")
    public ResponseEntity<?> show(@PathVariable("id") int id){
        return ResponseEntity.ok(new Gson().toJson(groupDAO.getGroupById(id)));
    }

    @PostMapping("/group")
    public String createGroup(@RequestBody NewGroupRequest requestObject) {
        return groupDAO.addGroup(
            new Group(requestObject.name(), Integer.parseInt(requestObject.studyingYear()),
                    departmentDAO.getDepartmentById(Integer.parseInt(requestObject.departmentId())))
            ).toString();
    }

    @PatchMapping("/group/{id}")
    public ResponseEntity<?> editGroup(@RequestBody NewGroupRequest requestObject, @PathVariable("id") int id){
        groupDAO.update(id, new Group(requestObject.name(), Integer.parseInt(requestObject.studyingYear()),
                departmentDAO.getDepartmentById(Integer.parseInt(requestObject.departmentId()))));
        return ResponseEntity.ok("added");
    }
}