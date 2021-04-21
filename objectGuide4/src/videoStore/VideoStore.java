package videoStore;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class VideoStore {
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Movie> movies = new ArrayList<>();
    // private ArrayList <Rental> rentals = new ArrayList<>();

    public VideoStore() {
    }

    public void addMovieList(String title,String country,int movieLength,Audience classification, Genre movieGenre,int stock){
        Movie newMovie =new Movie(title,country,movieLength,classification,movieGenre,stock);
        setMovies(newMovie);
    }

    public void addCustomerRental(UUID idCustomer, Movie theMovie){
        Rental customerRental = new Rental(theMovie);
        for (Customer theCustomer : customers){
            if(theCustomer.getId().equals(idCustomer)){
                theCustomer.setCustomerRentals(customerRental);
                customerRental.getMovieRented().discountStock();
            }
        }
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

    public Movie movieExist(String title){
        for(Movie theMovie : movies) {
            if (theMovie.getTitle().equals(title)) return theMovie;
        }
        return null;
    }

    public boolean movieStock(Movie selected){
        return (selected.getStock() > 0) ? true : false;
    }
    public String currentRentals(){
        String message="";
        for (Customer custrent : customers){
            message+= custrent.getCustomerRentals().toString();
        }
        if (message.isEmpty()) message = "empty";
        return message;
    }


    //enlist those movies that have to be regained today to the videoStore
    public String regainOnDate() { // such a headache the equals but it works! it works only if the regain date is set for today
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

    


