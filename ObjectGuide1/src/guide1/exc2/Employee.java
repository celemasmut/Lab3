package guide1.exc2;

public class Employee {
    private int dni;
    private String nameAndSurname;
    private float salary;

    public Employee(){}

    public Employee(int dni, String nameAndSurname, float salary)
    {
        this.dni=dni;
        this.nameAndSurname=nameAndSurname;
        this.salary=salary;
    }


    public void setDni(int dni)
    {
        this.dni=dni;
    }
    public void setNameAndSurname(String nameAndSurname)
    {
        this.nameAndSurname=nameAndSurname;
    }
    public void setSalary(float salary)
    {
        this.salary=salary;
    }
    public int getDNI()
    {
        return this.dni;
    }
    public String getNandS()
    {
        return this.nameAndSurname;
    }
    public float getSalary()
    {
        return this.salary;
    }
    public float annualSalary()
    {
        return 12 * this.salary;
    }
    public void increaseSalary(float percentage)
    {
        this.salary+=(this.salary*percentage)/100;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "dni=" + getDNI() +
                ", nameAndSurname='" + getNandS() + '\'' +
                ", salary=" + getSalary() +
                '}';
    }
}
