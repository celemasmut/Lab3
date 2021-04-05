package guide2.book;

public class Author {

    //Private properties
    private String name;
    private String surname;
    private String email;
    private char genre;

    public Author(){}

    public Author(String name, String surname, String email, char genre){
        setName(name);
        setSurname(surname);
        setEmail(email);
        setGenre(genre);
    }

    //Public Property Access
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGenre() {
        return genre;
    }

    public void setGenre(char genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", genre=" + getGenre() +
                '}';
    }
}
