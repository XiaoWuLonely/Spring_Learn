package Steps2.service.impl;

import Steps2.dao.impl.Steps2_AccountDaoImpl;
import Steps2.pojo.Steps2_Account;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Steps2_IsolationService2 {
    @Resource(name = "steps2_AccountDaoImpl")
    private Steps2_AccountDaoImpl steps2AccountDao;

    @Transactional
    public void save(Steps2_Account act) {
        steps2AccountDao.insert(act);
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
