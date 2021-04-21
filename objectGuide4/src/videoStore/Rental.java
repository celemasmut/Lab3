package videoStore;

import java.util.UUID;

public class Rental {
    private UUID id;
 //   private Customer myCustomer;
    private Movie movieRented;
    private LoanTicket ticket;

    public Rental(/*Customer myCustomer,*/Movie movieRented){
      //  this.myCustomer=myCustomer;
        this.movieRented=movieRented;
        setTicket();
        setId();
    }

    public UUID getId() {
        return id;
    }

    public void setId() {
        this.id = UUID.randomUUID();
    }

   /* public Customer getMyCustomer() {
        return myCustomer;
    }

    public void setMyCustomer(Customer myCustomer) {
        this.myCustomer = myCustomer;
    }*/

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


    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
               // ", Customer=" + getMyCustomer().getName() +
                ", movie Rented =" + getMovieRented().getTitle() +
                ", ticket=" + ticket +
                '}';
    }
}
