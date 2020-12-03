package org.example.companyHumanResourcesAPI.domain;

import java.util.List;

public class Company {
    private String id;
    private String name;
    private String location;
    private List<HumanResource> humanResources;

    public Company(String id, String name, String location, List<HumanResource> humanResources) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.humanResources = humanResources;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<HumanResource> getHumanResources() {
        return humanResources;
    }

    public void setHumanResources(List<HumanResource> humanResources) {
        this.humanResources = humanResources;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", humanResources=" + humanResources +
                '}';
    }
}
