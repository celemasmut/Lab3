package guide1.exc3;

public class Item {
    private int id;
    private String description;
    private int amount;
    private double unitPrice;
    private double totalPrice;
    private static int idCount;//this is my id counter so it won't be repeated

    public Item(){
        this.id=getId();
    }


    public Item(String description, int amount, double unitPrice)
    {
        this.id=getId();
        setAmount(amount);
        setDescription(description);
        setUnitPrice(unitPrice);
    }

    private static int getId(){
        idCount++;
        return idCount;
    }
    public void setDescription(String description)
    {
        this.description=description;
    }
    public void setUnitPrice(double unitPrice)
    {
        this.unitPrice=unitPrice;
    }
    public void setAmount(int amount)
    {
        this.amount=amount;
    }
    public void setTotalPrice(int totalPrice){
        this.totalPrice=totalPrice;
    }
    public String getDescription()
    {
        return this.description;
    }
    public double getUnitPrice()
    {
        return this.unitPrice;
    }
    public int getAmount()
    {
        return this.amount;
    }
    public int getID()
    {
        return this.id;
    }
    public double getTotalPrice()
    {
        return this.unitPrice*this.amount;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + getID() +
                ", description='" + getDescription() + '\'' +
                ", amount=" + getAmount() +
                ", unitPrice=" + getUnitPrice() +
                ", totalPrice=" + getTotalPrice() +
                '}';
    }
}
