package Steps2.dao.impl;

import Steps2.dao.Steps2_AccountDao;
import Steps2.pojo.Steps2_Account;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Steps2_AccountDaoImpl implements Steps2_AccountDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public Steps2_Account selectByActno(String actno) {
        String sql = "select actno,balance from t_act where actno=?";
        Steps2_Account queryForObject = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Steps2_Account.class), actno);
        return queryForObject;
    }

    @Override
    public int update(Steps2_Account steps2Account) {
        String sql = "update t_act set balance=? where actno=?";
        int i = jdbcTemplate.update(sql, steps2Account.getBalance(), steps2Account.getActno());
        return i;
    }

    @Override
    public int insert(Steps2_Account steps2Account) {
        String sql = "insert into t_act (actno,balance) values (?,?)";
        int updated = jdbcTemplate.update(sql, steps2Account.getActno(), steps2Account.getBalance());
        return updated;
    }
}