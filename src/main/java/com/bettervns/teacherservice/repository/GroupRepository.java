package com.bettervns.teacherservice.repository;

import com.bettervns.teacherservice.models.Group;
import com.bettervns.teacherservice.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Integer> {
}
