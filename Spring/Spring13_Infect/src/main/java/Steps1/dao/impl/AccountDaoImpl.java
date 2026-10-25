package Steps1.dao.impl;

import Steps1.dao.AccountDao;
import Steps1.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account selectByActno(String actno) {
        String sql = "select actno,balance from t_act where actno=?";
        Account queryForObject = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), actno);
        return queryForObject;
    }

    @Override
    public int update(Account account) {
        String sql = "update t_act set balance=? where actno=?";
        int i = jdbcTemplate.update(sql, account.getBalance(), account.getActno());
        return i;
    }
}
