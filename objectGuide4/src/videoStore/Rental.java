package videoStore;

import java.util.UUID;

public class Rental {
    private UUID id;
    private Movie movieRented;
    private LoanTicket ticket;
    private String status="on";

    public Rental(Movie movieRented){
        this.movieRented=movieRented;
        movieRented.setRent();
        setTicket();
        setId();
    }

    public UUID getId() {
        return id;
    }

    public void setId() {
        this.id = UUID.randomUUID();
    }

    public Movie getMovieRented() {
        return movieRented;
    }

    public void setMovieRented(Movie movieRented) {
        this.movieRented = movieRented;
    }

    public LoanTicket getTicket() {
        return ticket;
    }

    public void setTicket() {
        this.ticket = new LoanTicket();
    }

    public void setStatusOff(){
        this.status="off";
    }

    public String getStatus(){
        return this.status;
    }


    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", movie Rented =" + getMovieRented().getTitle() +
                ", ticket=" + ticket +
                '}';
    }
}
