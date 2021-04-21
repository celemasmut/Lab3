package videoStore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class VideoStore {
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Movie> movies = new ArrayList<>();
    // private ArrayList <Rental> rentals = new ArrayList<>();

    public VideoStore() {
    }

    public void addMovieList(String title, String country, LocalDate releaseDate, int movieLength, Audience classification, Genre movieGenre, int stock){
        Movie newMovie =new Movie(title,country,releaseDate,movieLength,classification,movieGenre,stock);
        setMovies(newMovie);
    }


    public String addCustomerList(String name,String phone,String address){
        Customer newCustomer = new Customer(name,phone,address);
        for (Customer theCustomer: customers){
            if(theCustomer.getName().equals(newCustomer.getName()) && theCustomer.getPhone().equals(newCustomer.getPhone()) && theCustomer.getAddress().equals(newCustomer.getAddress())) return "Customer already exist";
        }
        setCustomers(newCustomer);
        return "Customer added";
    }


    public void addCustomerRental(UUID idCustomer, Movie theMovie){
        Rental customerRental = new Rental(theMovie);
        theMovie.setRent();
        for (Customer theCustomer : customers){
            if(theCustomer.getId().equals(idCustomer)){
                theCustomer.setCustomerRentals(customerRental);
                customerRental.getMovieRented().discountStock();
            }
        }
    }




    public UUID searchingForCustomer(String phone){
        for (Customer searched : customers){
            if(searched.getPhone().equals(phone)) return searched.getId();
        }
        return null;
    }

    public String showingLastCustomerRentals(UUID idCustomer){
        String message="";
        for (Customer theCustomer : customers){
            if(theCustomer.getId().equals(idCustomer)){
                message+= theCustomer.toString();
            }
        }
        return message;
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
    public boolean existCustomer(String name, String address, String phone){// I choose phone as I don't have a dna
        for(Customer searching: customers){
            if(searching.getPhone().equals(phone) && searching.getName().equals(name)  &&  searching.getAddress().equals(address) ) return true;
        }
        return false;
    }

    public Movie movieExist(String title){
        for(Movie theMovie : movies) {
            if (theMovie.getTitle().equals(title)) return theMovie;
        }
        return null;
    }

    public int movieStock(Movie selected){
        return (selected.getStock() > 0) ? selected.getStock() : 0;
    }
    public String currentRentals(){
        String message="";
        for (Customer custrent : customers){
            for(Rental rentals : custrent.getCustomerRentals()){
                if (rentals.getStatus().equals("on")) message+= custrent.getCustomerRentals().toString();
            }
        }
        if (message.isEmpty()) message = "empty";
        return message;
    }


    //enlist those movies that have to be regained today to the videoStore
    public String listRegainOnDate() { // such a headache the equals but it works! it works only if the regain date is set for today
        String message = "";
        for (int i = 0; i < customers.size(); i++) {
            LocalDateTime today = LocalDateTime.now();
            if(!customers.get(i).getCustomerRentals().isEmpty()) {
                if (customers.get(i).getCustomerRentals().get(i).getTicket().getRegained().getDayOfWeek().equals(today.getDayOfWeek())) {
                    message += customers.get(i).getCustomerRentals().get(i).toString() + " .\n ";
                }
            }
        }
        if (message.isEmpty()) message = "empty";

        return message;

    }

    public void returnMovie(UUID idLoanTicket){
        for(Customer searchCustom : customers){
                for (Rental searchLoanT : searchCustom.getCustomerRentals()){
                    if(searchLoanT.getId().equals(idLoanTicket)){
                        searchLoanT.getMovieRented().setStock(1);
                        searchLoanT.setStatusOff();
                    }
                }
            }
        }


}

    


