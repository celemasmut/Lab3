package videoStore;

import java.time.LocalDate;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        //create Video Store
        VideoStore myVideoStore = new VideoStore();
        //Add some movies to the movie list
        myVideoStore.addMovieList("World war Z","EE.UU",LocalDate.of(2013,6,21),123,Audience.NC17,Genre.HORROR,2);
        myVideoStore.addMovieList("Iron Man 1","EE.UU",LocalDate.of(2008,4,30),126,Audience.PG13,Genre.ACTION,3);
        myVideoStore.addMovieList("The Avengers","EE.UU",LocalDate.of(2012,4,11),144,Audience.PG13,Genre.ACTION,1);
        myVideoStore.addMovieList("Guardians of the Galaxy","EE.UU", LocalDate.of(2014,7,21),125,Audience.PG13,Genre.ACTION,2);

        //adding some customers and verifying if they already exist
        System.out.println(myVideoStore.addCustomerList("Celeste","226738537","casa 535"));
        System.out.println(myVideoStore.addCustomerList("Joa","2274857366","casa 353"));
        System.out.println(myVideoStore.addCustomerList("Ale","2237669988","casa 754"));

        //verifying if a movie exist and its stock
        System.out.println("Exist movie :"+myVideoStore.movieExist("Guardians of the Galaxy").getTitle() + " Stock : "+ myVideoStore.movieStock(myVideoStore.movieExist("Guardians of the Galaxy")));

        //trying to add someone that already exist
        System.out.println(myVideoStore.addCustomerList("Celeste","226738537","casa 535"));

        // create a customer rental.
        myVideoStore.addCustomerRental(myVideoStore.searchingForCustomer("226738537"),myVideoStore.movieExist("Guardians of the Galaxy"));

        //check stock
        System.out.println(myVideoStore.getMovies().get(3).getStock());


        //List current rentals
        System.out.println("The rentals are: "+myVideoStore.currentRentals());
        //listing customers
        System.out.println(myVideoStore.getCustomers().toString());

        //verifying if there is any movie that needs to be returned today
        System.out.println("The movies that need to be regained today are: "+myVideoStore.listRegainOnDate());
       myVideoStore.getCustomers().get(0).getCustomerRentals().get(0).getTicket().changeRegainedDate();
        System.out.println("The movies that need to be regained today are: "+myVideoStore.listRegainOnDate());

        //return movie
        UUID idRental=myVideoStore.getCustomers().get(0).getCustomerRentals().get(0).getId();
        myVideoStore.returnMovie(idRental);
        //check stock
        System.out.println(myVideoStore.getMovies().get(3).getStock());

        //showing last customer rentals
        System.out.println(myVideoStore.showingLastCustomerRentals(myVideoStore.searchingForCustomer("226738537")));

    }
}
