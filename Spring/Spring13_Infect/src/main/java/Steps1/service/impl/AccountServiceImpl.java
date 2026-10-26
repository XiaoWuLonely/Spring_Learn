package Steps1.service.impl;

import Steps1.dao.AccountDao;
import Steps1.pojo.Account;
import Steps1.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
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

//        String s  =null;
//        s.toString();
        //保存
        int updated = accountDao.update(fromAct);
        updated += accountDao.update(toAct);
        if (updated != 2) {
            throw new RuntimeException("失败了");
        }
    }

    @Resource(name = "accountServiceImpl2")
    private AccountService accountService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(String actno, double money) {
        try {
            accountService.save(actno, money);
        } catch (Exception e) {
            System.out.println("捕获到 Impl2 的异常: " + e.getMessage());
        }
        int inserted = accountDao.insert(actno, money);
        if (inserted != 1) {
            throw new RuntimeException("添加失败");
        }
    }
}

