package Steps1.service;


public interface AccountService {

    //转账
    void transfer(String fromActno,String toActno,double money);
}
