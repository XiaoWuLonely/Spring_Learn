package Steps2.service.impl;

import Steps2.dao.Steps2_AccountDao;
import Steps2.dao.impl.Steps2_AccountDaoImpl;
import Steps2.pojo.Steps2_Account;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Steps2_IsolationService1 {
    @Resource(name = "steps2_AccountDaoImpl")
    private Steps2_AccountDaoImpl steps2AccountDao;

    //1号
    // 负责查询
    // 当前事务可以读取到别的事务没有提交的数据。
    //@Transactional(isolation = Isolation. READ_UNCOMMITTED)
    // 对方事务提交之后的数据我才能读取到。
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void getByActno(String actno) {
        Steps2_Account steps2Account = steps2AccountDao.selectByActno(actno);
        System.out.println("信息：" + steps2Account);
    }
}
