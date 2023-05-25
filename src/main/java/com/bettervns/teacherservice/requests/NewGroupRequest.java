package com.bettervns.teacherservice.requests;

public record NewGroupRequest(
        String name,
        String studyingYear,
        String departmentId
) {
}