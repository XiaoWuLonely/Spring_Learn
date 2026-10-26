package Steps2.service;


public interface Steps2_AccountService {

    //转账
    void transfer(String fromActno,String toActno,double money);

    void save(String actno,double money);
}
