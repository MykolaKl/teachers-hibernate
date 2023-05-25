package com.bettervns.teacherservice.repository;

import com.bettervns.teacherservice.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
