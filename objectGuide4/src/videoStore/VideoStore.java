package videoStore;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class VideoStore {
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Movie> movies = new ArrayList<>();
    // private ArrayList <Rental> rentals = new ArrayList<>();

    public VideoStore() {
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customer) {
        this.customers.add(customer);
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Movie movie) {
        this.movies.add(movie);
    }

  /*  public ArrayList<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(Rental rental) {
        this.rentals.add(rental);
    }*/

    public String currentRents() {
        String message = "";
        for (int i = 0; i < customers.size(); i++) {
            message += customers.get(i).getCustomerRentals().get(i).getTicket().toString() + " .\n";
        }
        if (message.isEmpty()) message = "empty";
        return message;
    }

    public String regainOnDate() { // such a headache but it works!
        String message = "";
        for (int i = 0; i < customers.size(); i++) {
            LocalDateTime today = LocalDateTime.now();
            if ( customers.get(i).getCustomerRentals().get(i).getTicket().getRegained().getDayOfWeek().equals(today.getDayOfWeek())) {
                message += customers.get(i).getCustomerRentals().get(i).toString() + " .\n ";
            }
        }
        if (message.isEmpty()) message = "empty";

        return message;

    }


}

    


