package videoStore;

import java.time.LocalDateTime;

public class LoanTicket {
    private LocalDateTime onLoan;
    private LocalDateTime regained;

    public LoanTicket(){
        setOnLoan();
        setRegained();
    }

    public LocalDateTime getOnLoan() {
        return onLoan;
    }

    private void setOnLoan() {
        this.onLoan = LocalDateTime.now();
    }

    public LocalDateTime getRegained() {
        return regained;
    }

    public void setRegained() {
        this.regained = onLoan;
    }

    @Override
    public String toString() {
        return "The movie loaned on date: "+getOnLoan()+" needs to be regained on date: "+getRegained();
    }



}
