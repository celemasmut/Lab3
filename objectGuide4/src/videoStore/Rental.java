package videoStore;

import java.util.UUID;

public class Rental {
    private UUID id;
    private Movie movieRented;
    private LoanTicket ticket; // as in the tp says "boleta de préstamo definiendo la fecha de retiro y la fecha de devolución"
    // I decided to make an extra class. so the rental will be the register of the rental in the video store.
    private String status = "on";

    public Rental(Movie movieRented){
        this.movieRented=movieRented;
        movieRented.setRent();
        setTicket();
        setId();
    }

    public String getStatus(){
        return this.status;
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

    public LoanTicket getTicket() {
        return ticket;
    }

    public void setTicket() {
        this.ticket = new LoanTicket();
    }


    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", movie Rented =" + getMovieRented().getTitle() +
                ", ticket=" + ticket +
                '}'+
                "\n";
    }
}
