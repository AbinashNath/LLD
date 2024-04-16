package com.example;

class EmployeeBuilder {
    private String empId;
    private String name;
    private String email;

    public EmployeeBuilder empId(String empId){
        this.empId = empId;
        return this;
    }

    public EmployeeBuilder name(String name){
        this.name = name;
        return this;
    }

    public EmployeeBuilder email(String email){
        this.email = email;
        return this;
    }

    public Employee build(){
        return new Employee(this);
    }

    public String getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

class Employee {
    private String empId;
    private String name;
    private String email;
    public Employee(EmployeeBuilder builder){
        this.email = builder.getEmail();
        this.empId = builder.getEmpId();
        this.name = builder.getName();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        EmployeeBuilder employeeBuilder = new EmployeeBuilder();
        employeeBuilder.email("A@gmail.com").empId("ABC");
        Employee employee = employeeBuilder.build();
        System.out.println(employee);
    }
}
