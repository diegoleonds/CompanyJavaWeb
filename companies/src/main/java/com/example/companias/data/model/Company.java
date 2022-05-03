package com.example.companias.data.model;

public class Company extends Entity {
    private String name;
    private String domain;
    private String year;
    private String industry;
    private String size;
    private String locality;
    private String country;
    private String linkedin;
    private int currentEmployeeEstimate;
    private int totalEmployeeEstimate;

    public Company(String id, String name, String domain, String year, String industry, String size, String locality,
                   String country, String linkedin, int currentEmployeeEstimate, int totalEmployeeEstimate) {
        this.setId(id);
        this.name = name;
        this.domain = domain;
        this.year = year;
        this.industry = industry;
        this.size = size;
        this.locality = locality;
        this.country = country;
        this.linkedin = linkedin;
        this.currentEmployeeEstimate = currentEmployeeEstimate;
        this.totalEmployeeEstimate = totalEmployeeEstimate;
    }

    public Company() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public int getCurrentEmployeeEstimate() {
        return currentEmployeeEstimate;
    }

    public void setCurrentEmployeeEstimate(int currentEmployeeEstimate) {
        this.currentEmployeeEstimate = currentEmployeeEstimate;
    }

    public int getTotalEmployeeEstimate() {
        return totalEmployeeEstimate;
    }

    public void setTotalEmployeeEstimate(int totalEmployeeEstimate) {
        this.totalEmployeeEstimate = totalEmployeeEstimate;
    }
}
