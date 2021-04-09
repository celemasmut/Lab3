package guide3.college;

public class Person {
    private String dni;
    private String name;
    private String surname;
    private String email;
    private String address;

    public Person(){}

    public Person(String dni, String name,String surname, String email, String address){
        this.dni=dni;
        this.name=name;
        this.surname=surname;
        this.email=email;
        this.address=address;
    }

    public String getName() {
        return this.name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return this.dni;
    }
}
