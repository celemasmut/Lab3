package guide2.bankAccount;

public class BankAccount {
    private String id;
    private BankClient client;
    private float balance;
    private float negDebitBalance;

    public BankAccount() {
        setBalance(0);
        setId();
    }

    public BankAccount(BankClient client,float balance) {
        setClient(client);
        setBalance(balance);
        setId();
        setNegDebitBalance(2000);
    }

    private void setId(){
        this.id = java.util.UUID.randomUUID().toString();

    }

    public float getNegDebitBalance() {
        return negDebitBalance;
    }

    public void setNegDebitBalance(float negDebitBalance) {
        this.negDebitBalance = negDebitBalance;
    }

    public void setClient(BankClient client) {
        this.client = client;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }


    private  String getId(){
        return this.id;
    }

    public float getBalance() {
        return this.balance;
    }

    public BankClient getClient() {
        return this.client;
    }

    public void ToDeposit(float deposit){
        if (deposit > 0){
            setBalance(getBalance()+deposit);
        }
    }
    public String ToExtract(float extract){
        String message="";
        if(extract<=getBalance()){
            setBalance(getBalance()-extract);
            message="OK, you have extracted the sum of $"+extract+", your balance is now: $"+getBalance();
        }else if (extract <= (getBalance()+getNegDebitBalance())) {
                float newNegBal = (getBalance() + getNegDebitBalance())-extract;
                setBalance(0);
                setNegDebitBalance(newNegBal);
                message = "OK,you have extracted the sum of $"+extract+", your negative balance is now: $" + getNegDebitBalance() +" you are in debt with $"+(2000-getNegDebitBalance());
        }else{
                message="No credit, your balance is not enough to extract $"+extract + " Balance: $"+getBalance()+", Negative balance $"+getNegDebitBalance();
            }
        return message;

    }


    @Override
    public String toString() {
        return "BankAccount{" +
                ", Client='" + getClient() + '\'' +
                ", balance=" + getBalance() +
                '}';
    }
}
