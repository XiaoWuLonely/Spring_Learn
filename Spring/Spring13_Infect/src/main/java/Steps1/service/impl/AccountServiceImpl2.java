package Steps1.service.impl;

import Steps1.dao.AccountDao;
import Steps1.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl2 implements AccountService {
    @Resource(name = "accountDaoImpl")
    private AccountDao accountDao;

    @Override
    public void transfer(String fromActno, String toActno, double money) {

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(String actno, double money) {
        accountDao.insert(actno, money);
        throw new RuntimeException("Impl2 故意抛异常");
    }
}
