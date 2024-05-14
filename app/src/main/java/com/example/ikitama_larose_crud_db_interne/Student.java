package com.example.ikitama_larose_crud_db_interne;

public class Student {
    private String name;
    private String firstname;
    private String classroom;
    private String year;

    public Student(String name, String firstname, String classroom, String year) {
        this.name = name;
        this.firstname = firstname;
        this.classroom = classroom;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
