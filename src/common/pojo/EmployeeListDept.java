package common.pojo;

import java.util.List;

public class EmployeeListDept {

    private int id;
    private String name;
    private List<String> departments;


    public EmployeeListDept(int id, String name, List<String> departments) {
        super();
        this.id = id;
        this.name = name;
        this.departments = departments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDepartments() {
        return departments;
    }

    public void setDepartments(List<String> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", departments=" + departments + "]";
    }


}
