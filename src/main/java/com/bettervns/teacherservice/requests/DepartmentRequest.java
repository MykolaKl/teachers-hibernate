package com.bettervns.teacherservice.requests;

public record DepartmentRequest(
        String name,
        String phone,
        String email
) {
}