package ru.croc.task15.department;

import java.util.ArrayList;
import java.util.List;

public class OrganizationDepartment {
    private final String parent;
    private final int time;
    private final String departamentName;
    List<OrganizationDepartment> childrens = new ArrayList<>();


    public String getParent() {
        return parent;
    }

    public int getTime() {
        return time;
    }

    public OrganizationDepartment(String departamentName, String parent, int time) {
        this.parent = parent;
        this.departamentName = departamentName;
        this.time = time;
    }

    public List<OrganizationDepartment> getChildrens() {
        return childrens;
    }

    public String getDepartamentName() {
        return departamentName;
    }

    public void addChildren(OrganizationDepartment organizationDepartment) {
        childrens.add(organizationDepartment);
    }
}
