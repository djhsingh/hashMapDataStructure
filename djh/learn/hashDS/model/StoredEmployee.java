package djh.learn.hashDS.model;

public class StoredEmployee {
    public String key;
    public Employee emp;

    public StoredEmployee(String key, Employee emp) {
        this.key = key;
        this.emp = emp;
    }
}
