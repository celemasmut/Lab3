package videoStore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

public class VideoStore {
    private ArrayList<Customer> customersList = new ArrayList<>();
    private ArrayList<Movie> moviesList = new ArrayList<>();
    // private ArrayList <Rental> rentals = new ArrayList<>();
    // I decided not to use an arraylist of Rental as I already have an arrayList of Rental in Customer

    public VideoStore() {
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

// The method adds a rental to a customer and discounts 1 to the movie's stock. it is needed the customer's id and the movie
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
// the method looks for the most rented movie in the arraylist and returns the movie
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
// the method looks for movies by their genre. it is needed the genre and returns an arraylist with those movies
    public ArrayList<Movie> lookingByGenre(Genre x){
        ArrayList<Movie> byGenre= new ArrayList<>();
        for(Movie movies: moviesList){
            if(movies.getMovieGenre().equals(x)){
                byGenre.add(movies);
            }
        }
        return byGenre;
    }
// the method looks for the movie's description. it is needed the name of the movie and returns the description or null
    public String showMovieDescription(String movie){
        for(Movie theMovie : moviesList){
            if(theMovie.getTitle().equals(movie)){
                return theMovie.getDescription();
            }
        }
        return null;
    }


// the method search a customer, it is needed customer's phone and return the id or null
    public UUID searchingForCustomer(String phone){
        for (Customer searched : customersList){
            if(searched.getPhone().equals(phone)) return searched.getId();
        }
        return null;
    }

    //the method looks for the customer's last rentals, it is needed the customer's id and returns the rentals as string
    public String showingCustomerLastRentals(UUID idCustomer){
        String message="";
        for (Customer theCustomer : customersList){
            if(theCustomer.getId().equals(idCustomer)){
                message= "Customer: "+ theCustomer.getName() + theCustomer.getCustomerRentals().toString();
            }
        }
        return message;
    }


    //the method search if a customer exist, it is needed the customer's phone, return a true if it does or false if it does not
    public boolean existCustomer(String phone){// I choose phone as I don't have a dna
        for(Customer searching: customersList){
            if(searching.getPhone().equals(phone)) return true;
        }
        return false;
    }

    //the method looks for if a certain movie exist in the list, it is needed the movie's name and returns the movie or null
    public Movie movieExist(String title){
        for(Movie theMovie : moviesList) {
            if (theMovie.getTitle().equals(title)) return theMovie;
        }
        return null;
    }

    //the method returns a movie's stock
    public int movieStock(Movie selected){
        return selected.getStock();
    }

    //the method looks for the current rentals and returns them as a string
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

    //the method looks for a customer ans then search for a certain rental with s certain movie. it is needed the customer's id and the name of movie, it returns the rental
    public Rental lookingForIdRental(UUID customerId,String nameMovie){
       for(Customer customer : customersList){
           if(customer.getId().equals(customerId)){
               for (Rental customRental : customer.getCustomerRentals()){
                   if(customRental.getMovieRented().getTitle().equals(nameMovie)) return customRental;
               }
           }
       }
       return null;
    }


    //The method enlists those rentals that have to be regained today to the videoStore , returns an arraylist with those rentals
    public ArrayList<Rental> listRegainOnDate() { // such a headache the equals but it works only if I have a rental created! it works only if the regain date is set for today
        ArrayList<Rental> todayRentals = new ArrayList<>();
        for (int i = 0; i < customersList.size(); i++) {
            LocalDateTime today = LocalDateTime.now();
            if(!customersList.get(i).getCustomerRentals().isEmpty()) {
                if (customersList.get(i).getCustomerRentals().get(i).getTicket().getRegained().getDayOfWeek().equals(today.getDayOfWeek())) {
                    todayRentals.add(customersList.get(i).getCustomerRentals().get(i));
                }
            }
        }
        return todayRentals;

    }

    //the method search for a certain rental when a movie is returned and fix the movie's stock
    public void returnMovie(Rental loanTicket){
        for(Customer searchCustom : customersList){
                for (Rental searchLoanT : searchCustom.getCustomerRentals()){
                    if(searchLoanT.equals(loanTicket)){
                        searchLoanT.getMovieRented().setStock(searchLoanT.getMovieRented().getStock() +1);
                    }
                }
            }
        }

// the method sort the movie list by popularity. it used and override method compareTo() that is in movie class.
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