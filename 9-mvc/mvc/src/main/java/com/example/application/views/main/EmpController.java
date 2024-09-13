package com.example.application.views.main;

import java.util.*;

public class EmpController {
    private Model model;

    public EmpController() {
        model = new Model();

        // add few hard-coded employees and reportees. write the UI in such a way that you can add more

        model.addEmployee(1, "Alice");
        model.addEmployee(2, "Bob");
        model.addEmployee(3, "Charlie");
        model.addEmployee(4, "David");
        model.addEmployee(5, "Eve");
        model.addEmployee(6, "Frank");
        
        model.addSubordinate(1, 2);
        model.addSubordinate(1, 3);
        model.addSubordinate(2, 4);
        model.addSubordinate(3, 5);
        model.addSubordinate(3, 6);
    }

    public List<String> getSubordinatesNames(int id) {
        List<String> names = new ArrayList<String>();
        List<Employee> subordinates = model.getSubordinates(id);
        for (Employee emp : subordinates) {
            names.add(emp.getName());
        }
        return names;
    }

    public List<Employee> getEmployees() {
        return model.getEmployees();
    }

    public void addEmployee(int id, String name) {
        model.addEmployee(id, name);
    }

    public void addSubordinate(int id, int subId) {
        model.addSubordinate(id, subId);
    }
}