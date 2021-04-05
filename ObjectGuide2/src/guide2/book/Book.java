package guide2.book;

import java.util.Arrays;

public class Book {
    private String title;
    private float price;
    private int stock;
    private Author[] authors=new Author[2];

    public Book(String title, float price, int stock, Author authors)
    {
        setTitle(title);
        setPrice(price);
        setStock(stock);
        setAuthor(authors);
    }
    public Author[] getAuthors()
    {
        return authors;
    }
    public String getTitle()
    {
        return title;
    }
    public float getPrice()
    {
        return price;
    }
    public int getStock()
    {
        return stock;
    }

   public void setAuthor(Author author) {
       int index=0;
       while(authors[index]!= null && index<2){
           index++;
       }
       this.authors[index]=author;
   }

    public void setTitle(String title)
    {
        this.title = title;
    }
    public void setPrice(float price)
    {
        this.price = price;
    }
    public void setStock (int stock)
    {
        this.stock=stock;
    }

    public void modifyStock(int addStock)
    {
        if(this.stock > 0)
        {
            this.stock+=addStock;
        }
        else
        {
            setStock(addStock);
        }
    }
    public String showAuthors(){
        return Arrays.toString(authors);
    }
    public String showBookData()
    {
        return "The book "+ getTitle()+" of "+ showAuthors()+".It's price is "+ getPrice()+" $";
    }

    @Override
    public String toString() {
        return "Book{" +
                "Title='" + getTitle() + '\'' +
                ", Authors=" + showAuthors() +
                ", Price=" + getPrice() +
                ", Stock=" + getStock() +
                '}';
    }
}
