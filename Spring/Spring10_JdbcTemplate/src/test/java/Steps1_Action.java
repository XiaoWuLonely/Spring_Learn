import bean.Steps1_User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Steps1_Action {
    @Test
    public void Steps1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps1.xml");
        JdbcTemplate jdbcTemeplate = applicationContext.getBean("jdbcTemeplate", JdbcTemplate.class);
        System.out.println(jdbcTemeplate);

        //凡是增删改查都使用Update方法，而不是execute
        String InsertSQL = "insert into Steps1_User(real_name,age) values(?,?)";
        int count = jdbcTemeplate.update(InsertSQL, "WuLong", 22);
        System.out.println(count);
    }

    @Test
    public void Steps1_Alter() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps1.xml");
        JdbcTemplate jdbcTemeplate = applicationContext.getBean("jdbcTemeplate", JdbcTemplate.class);
        String InsertSQL = "update Steps1_User set real_name = ?,age= ? where  id  = ?";
        int count = jdbcTemeplate.update(InsertSQL, "WuLong", 10086, 8);
        System.out.println(count);
    }

    @Test
    public void Steps1_Delete() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps1.xml");
        JdbcTemplate jdbcTemeplate = applicationContext.getBean("jdbcTemeplate", JdbcTemplate.class);
        String InsertSQL = "delete from Steps1_User where  id  = ?";
        int count = jdbcTemeplate.update(InsertSQL, 7);
        System.out.println(count);
    }

    @Test
    public void Steps1_Select() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps1.xml");
        JdbcTemplate jdbcTemeplate = applicationContext.getBean("jdbcTemeplate", JdbcTemplate.class);
        String InsertSQL = "select  id,real_name,age from Steps1_User where id = ?";
        Steps1_User steps1User = jdbcTemeplate.queryForObject(InsertSQL, new BeanPropertyRowMapper<>(Steps1_User.class), 3);
        System.out.println(steps1User);
    }

    @Test
    public void Steps1_SelectAll() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps1.xml");
        JdbcTemplate jdbcTemeplate = applicationContext.getBean("jdbcTemeplate", JdbcTemplate.class);
        String InsertSQL = "select  id,real_name,age from Steps1_User";
        List<Steps1_User> steps1User = jdbcTemeplate.query(InsertSQL, new BeanPropertyRowMapper<>(Steps1_User.class));
        System.out.println(steps1User);
    }
}
