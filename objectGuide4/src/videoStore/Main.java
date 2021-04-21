package videoStore;

public class Main {

    public static void main(String[] args) {

        VideoStore myVideoStore = new VideoStore();
        myVideoStore.addMovieList("World war Z","EE.UU",123,Audience.NC17,Genre.HORROR,2);

        Customer celeCustomer = new Customer("Celeste","226738537","casa 535");
        myVideoStore.setCustomers(celeCustomer);
        System.out.println("Exist movie :"+myVideoStore.movieExist("World war Z").getTitle());
        if(myVideoStore.movieStock(myVideoStore.movieExist("World war Z"))) myVideoStore.addCustomerRental(celeCustomer.getId(),myVideoStore.movieExist("World war Z"));


        System.out.println("The rentals are: "+myVideoStore.currentRentals());
        System.out.println(celeCustomer.toString());

        System.out.println("The movies that need to be regained today are: "+myVideoStore.regainOnDate());
        celeCustomer.getCustomerRentals().get(0).getTicket().changeRegainedDate();
        System.out.println("The movies that need to be regained today are: "+myVideoStore.regainOnDate());


    }
}
