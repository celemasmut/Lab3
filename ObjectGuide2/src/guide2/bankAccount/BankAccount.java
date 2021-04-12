package guide2.bankAccount;

import java.util.UUID;

public class BankAccount {
    private UUID id;
    private BankClient client;
    private float balance;
    private float negDebitBalance;

   private static final int MAX_OPS=10;
   private int index=0;
    private String bankingTransactions[] = new String[MAX_OPS];

    public BankAccount() {
        setBalance(0);
        setId();
    }

    public BankAccount(BankClient client,float balance) {
        setClient(client);
        setBalance(balance);
        setId();
        setNegDebitBalance(-2000);
    }

    public String[] getBankingTransactions() {
        return this.bankingTransactions;
    }

    public void setBankingTransactions(String[] bankingTransactions) {
        this.bankingTransactions = bankingTransactions;
    }

    private void setId(){
        this.id = java.util.UUID.randomUUID();

    }

    private void setIndex(int index) {
        this.index = index;
    }

    private int getIndex(){
        return this.index;
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
        if(balance < 0){
            this.balance=0;
        }else {
            this.balance = balance;
        }
    }


    private  UUID getId(){
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
            depositRegisterOper(deposit);
            setBalance(getBalance()+deposit);
        }
    }
    public String ToExtract(float extract){
        String message="";
        float newBalance=this.balance - extract;
        if(newBalance>= this.negDebitBalance){
            setBalance(getBalance()-extract);
            float newNegBal = (getBalance() + getNegDebitBalance())-extract;
            setNegDebitBalance(newNegBal);
            extractRegisterOper(extract);
            message="OK, you have extracted the sum of $"+extract+", your balance is now: $"+getBalance()+", Negative balance $"+getNegDebitBalance();;
        }else{
                message="No credit, your balance is not enough to extract $"+extract + " Balance: $"+getBalance()+", Negative balance $"+getNegDebitBalance();
            }
        return message;

    }

    private void indexRegisterOper(){
        if(getIndex() == MAX_OPS)
            setIndex(0);
    }
    private void incrementIndex(){
        setIndex(this.index+1);
    }

    private void depositRegisterOper(float depos){
        indexRegisterOper();
        this.bankingTransactions[getIndex()]="The Client"+ this.client.getName()+ " deposited $"+ depos;
        incrementIndex();
    }

    private void extractRegisterOper(float extr){
        indexRegisterOper();
        this.bankingTransactions[getIndex()]="The Client"+client.getName()+" withdrew $"+extr;
        incrementIndex();
    }
    public String showTransactions(){
        String showTrans="";
        for (String transaction: bankingTransactions){
            if(transaction != null) showTrans += transaction + "\n";
        }
        return showTrans;
    }


    @Override
    public String toString() {
        return "BankAccount{" +
                ", Client='" + getClient() + '\'' +
                ", balance=" + getBalance() +
                '}';
    }
}
