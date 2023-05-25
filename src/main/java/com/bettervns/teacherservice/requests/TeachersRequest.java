package com.bettervns.teacherservice.requests;

public record TeachersRequest(String name,
                              String surname,
                              String father,
                              String email,
                              int chair_id
) {
}
