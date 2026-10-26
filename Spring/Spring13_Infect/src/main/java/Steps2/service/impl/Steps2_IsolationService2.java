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


    @Transactional(timeout = 5)
//    以上代码表示设置事务的超时时间为5秒。
//    表示超过5秒如果该事务中所有的DML语句还没有执行完毕的话,最终结果会选择回滚。
//    默认值-1,表示没有时间限制。
//    这里有个坑,事务的超时时间指的是哪段时间?
//    在当前事务当中,最后一条DML语句执行之前的时间。如果最后一条DML语句后面很有很多业务逻辑,这些业务代码执行的时间不被计入超时时间。
    public void save(Steps2_Account act) {
        steps2AccountDao.insert(act);
        try {
            Thread.sleep(1000 * 6);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        steps2AccountDao.insert(act);

    }
}
