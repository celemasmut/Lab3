package guide2.salesControl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class Bill {
    private UUID id;
    private LocalDateTime date;
    private Client client;
    private ArrayList <SaleItem> items= new ArrayList<>();

    public Bill(){}

    public Bill(Client client){
        setId();
        setClient(client);
        setDate();
    }

    public Bill(Client client, SaleItem items){
        setId();
        setItems(items);
        setClient(client);
        setDate();
    }


    public void setItems(SaleItem item) {
        this.items.add(item);
    }

    public ArrayList<SaleItem> getItems() {
        return this.items;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return this.client;
    }

    public void setDate() {
        this.date = LocalDateTime.now();
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public void setId(){
        this.id = java.util.UUID.randomUUID();
    }
    public UUID getId(){
        return this.id;
    }

    public float totalAmountWithClientDiscount(){
        float total=0;
        for(SaleItem itemSold : items){
            if(itemSold != null){
                total+=itemSold.getUnitPrice();
            }
        }
        return total-(total*(client.getPercentDiscount()/100)) ;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id='" + getId() + '\'' +
                ", date=" + getDate() +
                ", client=" + getClient() +
                ", Items=" +getItems() +
             //   ", total="  +
                ", total with discount=" + totalAmountWithClientDiscount() +
                '}';
    }
}
