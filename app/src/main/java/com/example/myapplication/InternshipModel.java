package com.example.myapplication;

public class InternshipModel {

    public String internship_name;
    public String internship_company_name;
    public String internship_city;
    public String internship_stipend;
    public int internship_company_image;

    public InternshipModel(String s1, String s2, String s3, String s4, int img) {
        this.internship_name=s1;
        this.internship_company_name=s2;
        this.internship_city=s3;
        this.internship_stipend=s4;
        this.internship_company_image=img;

    }

    public String getInternship_name() {
        return internship_name;
    }

    public void setInternship_name(String internship_name) {
        this.internship_name = internship_name;
    }

    public String getInternship_company_name() {
        return internship_company_name;
    }

    public void setInternship_company_name(String internship_company_name) {
        this.internship_company_name = internship_company_name;
    }

    public String getInternship_city() {
        return internship_city;
    }

    public void setInternship_city(String internship_city) {
        this.internship_city = internship_city;
    }

    public String getInternship_stipend() {
        return internship_stipend;
    }

    public void setInternship_stipend(String internship_stipend) {
        this.internship_stipend = internship_stipend;
    }

    public int getInternship_company_image() {
        return internship_company_image;
    }

    public void setInternship_company_image(int internship_company_image) {
        this.internship_company_image = internship_company_image;
    }
}
