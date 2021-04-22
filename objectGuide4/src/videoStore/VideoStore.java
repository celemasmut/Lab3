package videoStore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

public class VideoStore {
    private ArrayList<Customer> customersList = new ArrayList<>();
    private ArrayList<Movie> moviesList = new ArrayList<>();
    // private ArrayList <Rental> rentals = new ArrayList<>(); I decided to no use an arraylist of Rental as I already have an arrayList of Rental in Customer

    public VideoStore() {
    }

    public void addMovieList(String title, String country, LocalDate releaseDate, int movieLength, Audience classification, Genre movieGenre, int stock){
        Movie newMovie =new Movie(title,country,releaseDate,movieLength,classification,movieGenre,stock);
        setMoviesList(newMovie);
    }


    public String addCustomerList(String name,String phone,String address){
        Customer newCustomer = new Customer(name,phone,address);
        for (Customer theCustomer: customersList){
            if(theCustomer.getPhone().equals(newCustomer.getPhone())) return "Customer already exist";
        }
        setCustomersList(newCustomer);
        return "Customer added";
    }


    public void addCustomerRental(UUID idCustomer, Movie theMovie){
        Rental customerRental = new Rental(theMovie);
        theMovie.setRent();
        for (Customer theCustomer : customersList){
            if(theCustomer.getId().equals(idCustomer)){
                theCustomer.setCustomerRentals(customerRental);
                theMovie.setStock(theMovie.getStock() - 1);
            }
        }
    }

    public Movie mostRentedMovie(){
        Movie mostRentedMovie= null;
        int count=0;
        for(Movie movies: moviesList){
            if(movies.getRent() > count) {
                count = movies.getRent();
                mostRentedMovie=movies;
            }
        }
        return mostRentedMovie;
    }

    public ArrayList<Movie> lookingByGenre(Genre x){
        ArrayList<Movie> byGenre = null;
        for(Movie movies: moviesList){
            if(movies.getMovieGenre().equals(x)){
                byGenre.add(movies);
            }
        }
        return byGenre;
    }

    public String showMovieDescription(String movie){
        for(Movie theMovie : moviesList){
            if(theMovie.getTitle().equals(movie)){
                return theMovie.getDescription();
            }
        }
        return null;
    }



    public UUID searchingForCustomer(String phone){
        for (Customer searched : customersList){
            if(searched.getPhone().equals(phone)) return searched.getId();
        }
        return null;
    }

    public String showingLastCustomerRentals(UUID idCustomer){
        String message="";
        for (Customer theCustomer : customersList){
            if(theCustomer.getId().equals(idCustomer)){
                message+= theCustomer.toString();
            }
        }
        return message;
    }

    public ArrayList<Customer> getCustomersList() {
        return customersList;
    }

    public void setCustomersList(Customer customer) {
        this.customersList.add(customer);
    }

    public ArrayList<Movie> getMoviesList() {
        return moviesList;
    }

    public void setMoviesList(Movie movie) {
        this.moviesList.add(movie);
    }
    public boolean existCustomer(String phone){// I choose phone as I don't have a dna
        for(Customer searching: customersList){
            if(searching.getPhone().equals(phone)) return true;
        }
        return false;
    }

    public Movie movieExist(String title){
        for(Movie theMovie : moviesList) {
            if (theMovie.getTitle().equals(title)) return theMovie;
        }
        return null;
    }

    public int movieStock(Movie selected){
        return (selected.getStock() > 0) ? selected.getStock() : 0;
    }
    public String currentRentals(){
        String message="";
        for (Customer custrent : customersList){
            for(Rental rentals : custrent.getCustomerRentals()){
                if (rentals.getStatus().equals("on")) message+= custrent.getCustomerRentals().toString();
            }
        }
        if (message.isEmpty()) message = "empty";
        return message;
    }

    public UUID lookingForIdRental(String nameMovie){
        for(Customer customer : customersList){
            for (Rental rental : customer.getCustomerRentals()){
                if(rental.getMovieRented().getTitle().equals(nameMovie)){
                    return rental.getId();
                }
            }
        }
        return null;
    }


    //enlist those movies that have to be regained today to the videoStore
    public String listRegainOnDate() { // such a headache the equals but it works only if I have a rental created! it works only if the regain date is set for today
        String message = "";
        for (int i = 0; i < customersList.size(); i++) {
            LocalDateTime today = LocalDateTime.now();
            if(!customersList.get(i).getCustomerRentals().isEmpty()) {
                if (customersList.get(i).getCustomerRentals().get(i).getTicket().getRegained().getDayOfWeek().equals(today.getDayOfWeek())) {
                    message += customersList.get(i).getCustomerRentals().get(i).toString() + " .\n ";
                }
            }
        }
        if (message.isEmpty()) message = "empty";

        return message;

    }

    public void returnMovie(UUID idLoanTicket){
        for(Customer searchCustom : customersList){
                for (Rental searchLoanT : searchCustom.getCustomerRentals()){
                    if(searchLoanT.getId().equals(idLoanTicket)){
                        searchLoanT.getMovieRented().setStock(searchLoanT.getMovieRented().getStock() +1);
                        searchLoanT.setStatusOff();
                    }
                }
            }
        }


        public void sortMoviesByPopularity(){
            Collections.sort(moviesList);
        }

    @Override
    public String toString() {
        return "VideoStore{" +
                ", moviesList=" + moviesList +
                '}';
    }
}

    


