package edu.srs.dao;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author ozlem
 */
public class Student {
    @NotNull
    @Min(1000)
    private Integer id;
    @NotNull
    @Size(min=2, max=30)
    private String name;
    @NotNull
    @Size(min=2, max=30)
    private String surname;
    @NotNull
    @Min(0)
    private Integer grade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}