package Steps1.pojo;

public class Account {
    private String actno;
    private double balancel;

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public double getBalancel() {
        return balancel;
    }

    public void setBalancel(double balancel) {
        this.balancel = balancel;
    }

    @Override
    public String toString() {
        return "Account{" + "actno='" + actno + '\'' + ", balancel=" + balancel + '}';
    }
}
