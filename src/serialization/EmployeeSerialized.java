package serialization;

import java.io.Serializable;

public class EmployeeSerialized implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;

    public EmployeeSerialized(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "EmployeeSerialized [id=" + id + ", name=" + name + "]";
    }


}
