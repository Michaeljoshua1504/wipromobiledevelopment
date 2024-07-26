package collections.EMS;

public class emp {
    String id; // unique
    String name;
    String position;
    double salary;
    int age;

    public emp(String id, String name, String position, double salary, int age) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.age = age;
    }

    public emp() {
        
    }

    @Override
    public String toString() {
        return "emp [id=" + id + ", name=" + name + ", position=" + position + ", salary=" + salary + ", age=" + age
                + "]";
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }   
    
    
}