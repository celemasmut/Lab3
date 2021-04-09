package guide3.college;

public class Staff extends Person{
    private float remuneration;
    private float salary;
    private String shifts;

    public Staff(){
        super();
    }
    public Staff(String dni, String name,String surname, String email, String address, float remuneration, float salary, String shifts){
        super(dni, name, surname, email, address);
        this.remuneration=remuneration;
        this.salary=salary;
        this.shifts=shifts;
    }

    public float getRemuneration() {
        return remuneration;
    }

    public void setRemuneration(float remuneration) {
        this.remuneration = remuneration;
    }

    public float getSalary() {
        return this.salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getShifts() {
        return this.shifts;
    }

    public void setShifts(String shifts) {
        this.shifts = shifts;
    }
}
