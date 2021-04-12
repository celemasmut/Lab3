package guide2.utilities;

import guide2.bankAccount.BankAccount;
import guide2.bankAccount.BankClient;
import guide2.book.Author;
import guide2.book.Book;
import guide2.salesControl.Bill;
import guide2.salesControl.Client;
import guide2.salesControl.SaleItem;

public class Utilities {

    public static void  exerciseMenu() {
        System.out.println("[1] Books");
        System.out.println("[2] Sales Control");
        System.out.println("[3] Bank Account");
    }

    public static void bookClass(){
        Author joshuaAuthor = new Author("Joshua","Bloch","joshua@email.com",'M');
        System.out.println(joshuaAuthor.toString());

        Book effJavaBook = new Book("Effective Java",450,150,joshuaAuthor);
        System.out.println(effJavaBook.toString());

        effJavaBook.setPrice(500);
        effJavaBook.modifyStock(50);
        System.out.println(effJavaBook.toString());

        System.out.println(effJavaBook.showAuthors());

        Author nealG= new Author("Neal","Gafter","neal@email.com",'M');
        effJavaBook.setAuthor(nealG);
        System.out.println(effJavaBook.showAuthors());
        System.out.println(effJavaBook.showBookData());
    }

    public static void salesControl(){
        Client ayeBulacio=new Client("Ayelen Bulacio","ayebulacio@mail.com",17);
        System.out.println(ayeBulacio.toString());
        Bill ayeBill=new Bill(ayeBulacio);
       // System.out.println(ayeBill.totalAmountWithClientDiscount());
        System.out.println(ayeBill.totalAmountWithClientDiscount());
        System.out.println(ayeBill.toString());
        SaleItem sportShoes = new SaleItem("Run Falcon","Black and White 2.0 for women",12575);
        SaleItem sportShort = new SaleItem("Falcon","Black and White ",5800);
        SaleItem sportTshirt = new SaleItem("T-Shirt Falcon","Black ",3500);
        ayeBill.setItems(sportTshirt);
        ayeBill.setItems(sportShort);
        ayeBill.setItems(sportShoes);
        System.out.println(ayeBill.toString());
    }

    public static void bankAccount(){
        BankClient valeMedina = new BankClient("Valeria Medina",'M');
        System.out.println(valeMedina.toString());
        BankAccount valeAccount=new BankAccount(valeMedina,10000);
        System.out.println(valeAccount.toString());
        valeAccount.ToDeposit(1567);
        System.out.println("with your deposit of 1567 the balance remains: $ "+valeAccount.getBalance());
        System.out.println(valeAccount.ToExtract(14500));
        System.out.println(valeAccount.ToExtract(3500));
        System.out.println(valeAccount.ToExtract(9500));
        System.out.println("\n Your transactions");
        System.out.println(valeAccount.showTransactions());
    }
}
