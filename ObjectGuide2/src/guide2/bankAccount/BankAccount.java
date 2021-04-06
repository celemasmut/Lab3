package guide2.bankAccount;

public class BankAccount {
    private String id;
    private BankClient client;
    private float balance;
    private float negDebitBalance;

   private int MAX_OPS=10;
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
        setNegDebitBalance(2000);
    }

    public String[] getBankingTransactions() {
        return this.bankingTransactions;
    }

    public void setBankingTransactions(String[] bankingTransactions) {
        this.bankingTransactions = bankingTransactions;
    }

    private void setId(){
        this.id = java.util.UUID.randomUUID().toString();

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
            depositRegisterOper(deposit);
            setBalance(getBalance()+deposit);
        }
    }
    public String ToExtract(float extract){
        String message="";
        if(extract<=getBalance()){
            setBalance(getBalance()-extract);
            extractRegisterOper(extract);
            message="OK, you have extracted the sum of $"+extract+", your balance is now: $"+getBalance();
        }else if (extract <= (getBalance()+getNegDebitBalance())) {
                float newNegBal = (getBalance() + getNegDebitBalance())-extract;
                setBalance(0);
                setNegDebitBalance(newNegBal);
                extractRegisterOper(extract);
                message = "OK,you have extracted the sum of $"+extract+", your negative balance is now: $" + getNegDebitBalance() +" you are in debt with $"+(2000-getNegDebitBalance());
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
