package cla;

class BankAccount {
     private String accountNumber;
     private double balance; //余额

    public String getAccountNumber(){
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber){
        this.accountNumber=accountNumber;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        if(balance<0) {
            System.out.println("没钱了");
        }else{
            this.balance = balance;
        }
    }

    public void broadcast(String accountNumber, double balance) {
        System.out.println("账号" + accountNumber + "的余额为" + balance + "元");
    }
}

public class St251103FengZhuang {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.setAccountNumber("445566");
        account.setBalance(500);
        account.broadcast(account.getAccountNumber(), account.getBalance());
    }
}



