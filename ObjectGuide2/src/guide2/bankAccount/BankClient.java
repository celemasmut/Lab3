package guide2.bankAccount;

import java.util.UUID;

public class BankClient {
    private UUID id;
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
        this.id = java.util.UUID.randomUUID();
    }

    public UUID getId() {
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
