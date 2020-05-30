package com.example.androiddummyapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Employee {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("employee_name")
    @Expose
    private String employee_name;
    @SerializedName("employee_salary")
    @Expose
    private String employee_salary;
    @SerializedName("employee_age")
    @Expose
    private String employee_age;
    @SerializedName("profie_image")
    @Expose
    private String profie_image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(String employee_salary) {
        this.employee_salary = employee_salary;
    }

    public String getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(String employee_age) {
        this.employee_age = employee_age;
    }

    public String getProfie_image() {
        return profie_image;
    }

    public void setProfie_image(String profie_image) {
        this.profie_image = profie_image;
    }
}
