package Steps2.service.impl;

import Steps2.dao.Steps2_AccountDao;
import Steps2.dao.impl.Steps2_AccountDaoImpl;
import Steps2.pojo.Steps2_Account;
import Steps2.service.Steps2_AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Steps2_AccountServiceImpl implements Steps2_AccountService {
    @Resource(name = "steps2_AccountDaoImpl")
    private Steps2_AccountDaoImpl steps2AccountDao;

    @Override
    public void transfer(String fromActno, String toActno, double money) {
    }

    @Override
    public void save(String actno, double money) {
        Steps2_Account steps2Account = new Steps2_Account(actno, money);
        int inserted = steps2AccountDao.insert(steps2Account);
        if (inserted != 1) {
            throw new RuntimeException("添加失败");
        }
    }
}

