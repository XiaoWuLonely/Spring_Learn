package Steps1.service;


import Steps1.pojo.Account;

public interface AccountService {

    //转账
    void transfer(String fromActno,String toActno,double money);

    void save(String actno,double money);
}
