package Steps1.service.impl;

import Steps1.dao.AccountDao;
import Steps1.pojo.Account;
import Steps1.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Resource(name = "accountDaoImpl")
    private AccountDao accountDao;

    @Override
    public void transfer(String fromActno, String toActno, double money) {
        Account fromAct = accountDao.selectByActno(fromActno);
        if (fromAct.getBalance() < money) {
            throw new RuntimeException("余额不足");
        }
        //余额够
        Account toAct = accountDao.selectByActno(toActno);
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);

        String s  =null;
        s.toString();
        //保存
        int updated = accountDao.update(fromAct);
        System.out.println(updated);
        updated += accountDao.update(toAct);
        if (updated != 2) {
            throw new RuntimeException("失败了");
        }
    }
}

