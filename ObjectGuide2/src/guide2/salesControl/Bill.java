package guide2.salesControl;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Bill {
    private String id="";
    private float total=0;
    private LocalDateTime date;
    private Client client;
    private ArrayList <SaleItem> items= new ArrayList<SaleItem>();


    public Bill(){}

    public Bill(Client client,float total){
        setId();
        setClient(client);
        setDate();
        setTotal(total);
    }

    public Bill(Client client,float total, SaleItem items){
        setId();
        setItems(items);
        setClient(client);
        setDate();
        setTotal(total);
    }

    public void setTotal(float total) {
        this.total =+ total;
    }

    public float getTotal() {
        return this.total;
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
        this.id = java.util.UUID.randomUUID().toString();
    }
    public String getId(){
        return this.id;
    }

    public float totalAmountWithClientDiscount(){
        return this.total-((this.total*client.getPercentDiscount())/100) ;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id='" + getId() + '\'' +
                ", date=" + getDate() +
                ", client=" + getClient() +
                ", Items=" +getItems() +
                ", total=" + getTotal() +
                ", total with discount=" + totalAmountWithClientDiscount() +
                '}';
    }
}
