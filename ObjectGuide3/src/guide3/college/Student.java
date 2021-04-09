package guide3.college;

public class Student extends Person{
    private String yearOfEntry;
    private float monthlyFee;
    private String collegeCareer;

    public Student(){
        super();
    }
    public Student(String dni, String name,String surname, String email, String address,String yearOfEntry,float monthlyFee,String collegeCareer){
        super(dni, name, surname, email, address);
        this.yearOfEntry=yearOfEntry;
        this.monthlyFee=monthlyFee;
        this.collegeCareer=collegeCareer;
    }

    public void setYearOfEntry(String yearOfEntry){
        this.yearOfEntry=yearOfEntry;
    }
    public void setMonthlyFee(float monthlyFee){
        this.monthlyFee=monthlyFee;
    }
    public void setCollegeCareer(String collegeCareer){
        this.collegeCareer= collegeCareer;
    }
    public String getYearOfEntry(){
        return this.yearOfEntry;
    }

    public float getMonthlyFee() {
        return this.monthlyFee;
    }

    public String getCollegeCareer() {
        return this.collegeCareer;
    }
}
