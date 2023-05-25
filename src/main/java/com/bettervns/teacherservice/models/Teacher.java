package com.bettervns.teacherservice.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "teacher_name", nullable = false)
    private String name;
    @Column(name = "surname", nullable = false)
    private String surname;
    @Column(name = "father", nullable = false)
    private String father;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "chair_id", nullable = false)
    private int chair_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getChair_id() {
        return chair_id;
    }

    public void setChair_id(int chair_id) {
        this.chair_id = chair_id;
    }

    public Teacher(String name, String surname, String father, String email, int chair_id) {
        this.name = name;
        this.surname = surname;
        this.father = father;
        this.email = email;
        this.chair_id = chair_id;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", father_name='" + father + '\'' +
                ", email='" + email + '\'' +
                ", chair_id=" + chair_id +
                '}';
    }
}

