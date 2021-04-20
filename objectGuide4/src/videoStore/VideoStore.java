package videoStore;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class VideoStore {
    private ArrayList <Customer> customers = new ArrayList<>();
    private ArrayList <Movie> movies = new ArrayList<>();
    private ArrayList <Rental> rentals = new ArrayList<>();

    public VideoStore(){ }

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

    public ArrayList<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(Rental rental) {
        this.rentals.add(rental);
    }

    public String currentRents(){
        String message="";
        for(Rental currentRents: rentals){
            message+=currentRents.toString()+" .\n";
        }
        return message;
    }

    public String regainOnDate(){
        String message="";
        for (Rental regainToday : rentals){
            if(regainToday.getTicket().getRegained().equals(LocalDateTime.now())){
                message+= regainToday.toString()+" .\n ";
            }
        }
        return message;
    }


}
