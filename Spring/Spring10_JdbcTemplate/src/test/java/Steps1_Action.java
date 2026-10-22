import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

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
}
