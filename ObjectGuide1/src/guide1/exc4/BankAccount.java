package guide1.exc4;

public class BankAccount {
    private  int ID=0;
    private String name;
    private float balance;

    //Constructores
    public BankAccount() {
        setName("");
        setBalance(0);
        setID(0);
    }

    public BankAccount(int id,String name,float balance) {
        this.name =name;
        this.balance =balance;
        setID(id);
    }

    //setters
    private void setID(int ID){
         this.ID=ID;
    }

    public void setName(String name) {
        this.name =name;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }


//getters

    private  int getID(){
        return ID;
    }

    public float getBalance() {
        return balance;
    }
    public String getName() {
        return name;
    }

    //Metodos

    public float ToDeposit(float deposit){
        if (deposit > 0){
            setBalance(getBalance()+deposit);
        }
        return this.balance;
    }
    public String ToExtract(float extract){
        String message="";
        if(extract<=getBalance()){
            setBalance(getBalance()-extract);
            message="OK, your balance is now: $"+getBalance();
        }else {
            message="No credit, your balance is not enough\nBalance: $"+getBalance();
        }
        return message;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "ID=" + getID() +
                ", name='" + getName() + '\'' +
                ", balance=" + getBalance() +
                '}';
    }
}
