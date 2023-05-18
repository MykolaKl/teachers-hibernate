package com.bettervns.teacherservice.controllers;


import com.bettervns.teacherservice.dao.GroupDAO;
import com.bettervns.teacherservice.models.Department;
import com.bettervns.teacherservice.models.Group;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class GroupsController {

    private final GroupDAO groupDAO;

    @Autowired
    public GroupsController(GroupDAO groupDAO) {
        this.groupDAO = groupDAO;
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
    public Group createGroup(@RequestBody Group group) {
        return groupDAO.addGroup(group);
    }
}