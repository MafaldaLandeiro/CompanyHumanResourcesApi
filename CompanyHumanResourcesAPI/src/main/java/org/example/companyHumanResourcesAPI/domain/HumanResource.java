package org.example.companyHumanResourcesAPI.domain;

public class HumanResource {
    private String id;
    private String name;
    private int age;
    private String category;
    private Float salary;
    private String companyId;

    public HumanResource(String id, String name, int age, String category, Float salary, String companyId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.category = category;
        this.salary = salary;
        this.companyId = companyId;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "HumanResource{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", category='" + category + '\'' +
                ", salary=" + salary +
                ", companyId=" + companyId +
                '}';
    }
}
