package videoStore;

import java.util.UUID;

public class Rental {
    private UUID id;
    private Customer myCustomer;
    private Movie movieRented;
    private LoanTicket ticket;

    public Rental(Customer myCustomer,Movie movieRented,LoanTicket ticket){
        this.myCustomer=myCustomer;
        this.movieRented=movieRented;
        this.ticket=ticket;
        setId();
    }

    public UUID getId() {
        return id;
    }

    public void setId() {
        this.id = UUID.randomUUID();
    }

    public Customer getMyCustomer() {
        return myCustomer;
    }

    public void setMyCustomer(Customer myCustomer) {
        this.myCustomer = myCustomer;
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

    public void setTicket(LoanTicket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", myCustomer=" + myCustomer +
                ", movieRented=" + movieRented +
                ", ticket=" + ticket +
                '}';
    }
}
