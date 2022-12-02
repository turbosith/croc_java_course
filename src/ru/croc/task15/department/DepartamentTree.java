package ru.croc.task15.department;


import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.HashMap;
import java.util.Scanner;

public class DepartamentTree {
    private final HashMap<String, OrganizationDepartment> tree = new HashMap<>();
    private OrganizationDepartment rootParent;

    /**
     * Читает конфигурацию и заполняет дерево департаменентов, учавствующих в работе
     *
     * @param fileName - имя файла с конфигурацией
     * @throws FileNotFoundException - не найден файл
     */
    public void readConfiguration(String fileName) throws FileNotFoundException {
        try (Scanner s = new Scanner(new FileReader(fileName))) {
            while (s.hasNextLine()) {
                String scan = s.nextLine();
                String[] departmentParts = scan.split(",");
                OrganizationDepartment organizationDepartment =
                        new OrganizationDepartment(departmentParts[0], departmentParts[1], Integer.parseInt(departmentParts[2]));
                tree.put(organizationDepartment.getDepartamentName(), organizationDepartment);
                if (organizationDepartment.getParent().equals("-")) {
                    rootParent = organizationDepartment;
                } else {
                    tree.get(organizationDepartment.getParent()).addChildren(organizationDepartment);
                }

            }
        }

    }


    public int departamentTreeWorkTime() {
        return rootParent.departementWorkTime();
    }


}


//C:\Users\79165\Desktop\croc\java-school-2022-croc\src\ru\croc\task15