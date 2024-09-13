package com.example.application.views.main;

import java.util.*;

class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

public class Model {
    // all the employees stored by their id and name
    private List<Employee> emps = new ArrayList<Employee>();

    // manager id, and all the ids of the employees reporting to the manager
    private HashMap<Integer, List<Integer>> subordinates = new HashMap<Integer, List<Integer>>();

    public void addSubordinate(int id, int subId) {
        if (subordinates.containsKey(id)) {
            subordinates.get(id).add(subId);
        } else {
            List<Integer> list = new ArrayList<Integer>();
            list.add(subId);
            subordinates.put(id, list);
        }
    }

    public HashMap<Integer, List<Integer>> getSubordinates() {
        return subordinates;
    }

    public void addEmployee(int id, String name) {
        emps.add(new Employee(id, name));
    }

    public List<Employee> getEmployees() {
        return emps;
    }

    public List<Employee> getSubordinates(int id) {
        List<Employee> list = new ArrayList<Employee>();
        if (subordinates.containsKey(id)) {
            for (int subId : subordinates.get(id)) {
                for (Employee emp : emps) {
                    if (emp.getId() == subId) {
                        list.add(emp);
                    }
                }
            }
        }
        if(list.isEmpty()) {
            list.add(new Employee(-1, "No subordinates"));
        }
        return list;
    }
}