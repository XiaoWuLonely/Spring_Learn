package Steps2.dao;

import Steps2.pojo.Steps2_Account;

public interface Steps2_AccountDao {

    //查询账户信息
    Steps2_Account selectByActno(String actno);

    //更新账户
    int update(Steps2_Account steps2Account);

    //保存
    int insert(Steps2_Account steps2Account);
}
