import bean.Steps1_User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Steps2_Action {
    @Test
    //查询多条数据
    public void Steps2_SelectAll() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps2.xml");
        JdbcTemplate jdbcTemeplate = applicationContext.getBean("jdbcTemeplate", JdbcTemplate.class);
        String InsertSQL = "select  id,real_name,age from Steps1_User";
        List<Steps1_User> steps1User = jdbcTemeplate.query(InsertSQL, new BeanPropertyRowMapper<>(Steps1_User.class));
        System.out.println(steps1User);
    }
}