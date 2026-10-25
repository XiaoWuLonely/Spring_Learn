package Steps1.pojo;

public class Account {
    private String actno;
    private double balance;

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" + "actno='" + actno + '\'' + ", balance=" + balance + '}';
    }
}
