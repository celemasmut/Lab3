package guide2.bankAccount;

public class BankClient {
    private String id;
    private String name;
    private char genre;

    public BankClient(){
        setId();
    }
    public BankClient(String name, char genre){
        setId();
        setName(name);
        setGenre(genre);
    }

    public void setId() {
        this.id = java.util.UUID.randomUUID().toString();
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGenre() {
        return this.genre;
    }

    public void setGenre(char genre) {
        if((genre == 'M' || genre == 'F' ) || (genre == 'm' || genre == 'f' ))
            this.genre = genre;
    }

    @Override
    public String toString() {
        return "Client{" +
                ", name='" + getName() + '\'' +
                ", genre=" + getGenre() +
                '}';
    }
}
