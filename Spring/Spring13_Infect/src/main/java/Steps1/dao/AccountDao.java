package Steps1.dao;

import Steps1.pojo.Account;

public interface AccountDao {

    //查询账户信息
    Account selectByActno(String actno);

    //更新账户
    int update(Account account);
}
