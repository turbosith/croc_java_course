package ru.croc.task15.department;

import java.util.ArrayList;
import java.util.List;

public class OrganizationDepartment {
private OrganizationDepartment parent = null;
private int time;
List<OrganizationDepartment> childrens = new ArrayList<>();

    public void setParent(OrganizationDepartment parent) {
        this.parent = parent;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public OrganizationDepartment getParent() {
        return parent;
    }

    public int getTime() {
        return time;
    }

    public OrganizationDepartment(OrganizationDepartment parent, int time){
    if (parent!=null){
        this.parent=parent;
    }
    this.time=time;
}

    public List<OrganizationDepartment> getChildrens() {
        return childrens;
    }
    public void addChildren(OrganizationDepartment organizationDepartment){
        childrens.add(organizationDepartment);
    }
}
