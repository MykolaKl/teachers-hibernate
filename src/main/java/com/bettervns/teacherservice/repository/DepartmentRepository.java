package com.bettervns.teacherservice.repository;

import com.bettervns.teacherservice.models.Department;
import com.bettervns.teacherservice.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
