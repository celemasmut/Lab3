package videoStore;

public class Main {

    public static void main(String[] args) {

        Movie wwzMovie = new Movie("World war Z","EE.UU",123,Audience.NC17,Genre.HORROR,4);
        System.out.println(wwzMovie.getTitle());

        VideoStore myVideoStore = new VideoStore();
        myVideoStore.setMovies(wwzMovie);

        Customer celeCustomer = new Customer("Celeste","226738537","casa 535");
        myVideoStore.setCustomers(celeCustomer);

        Rental celeRental = new Rental(wwzMovie);

        celeCustomer.setCustomerRentals(celeRental);

        System.out.println(myVideoStore.currentRents());
        System.out.println("The movies that need to be regained today are: "+myVideoStore.regainOnDate());
        System.out.println(celeCustomer.toString());
    }
}
