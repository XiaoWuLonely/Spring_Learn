import bean.Steps1_User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Steps1_Action {
    @Test
    //添加
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
    //修改
    public void Steps1_Alter() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps1.xml");
        JdbcTemplate jdbcTemeplate = applicationContext.getBean("jdbcTemeplate", JdbcTemplate.class);
        String InsertSQL = "update Steps1_User set real_name = ?,age= ? where  id  = ?";
        int count = jdbcTemeplate.update(InsertSQL, "WuLong", 10086, 8);
        System.out.println(count);
    }

    @Test
    //删除
    public void Steps1_Delete() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps1.xml");
        JdbcTemplate jdbcTemeplate = applicationContext.getBean("jdbcTemeplate", JdbcTemplate.class);
        String InsertSQL = "delete from Steps1_User where  id  = ?";
        int count = jdbcTemeplate.update(InsertSQL, 7);
        System.out.println(count);
    }

    @Test
    //查询单个数据
    public void Steps1_Select() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps1.xml");
        JdbcTemplate jdbcTemeplate = applicationContext.getBean("jdbcTemeplate", JdbcTemplate.class);
        String InsertSQL = "select  id,real_name,age from Steps1_User where id = ?";
        Steps1_User steps1User = jdbcTemeplate.queryForObject(InsertSQL, new BeanPropertyRowMapper<>(Steps1_User.class), 3);
        System.out.println(steps1User);
    }

    @Test
    //查询多条数据
    public void Steps1_SelectAll() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps1.xml");
        JdbcTemplate jdbcTemeplate = applicationContext.getBean("jdbcTemeplate", JdbcTemplate.class);
        String InsertSQL = "select  id,real_name,age from Steps1_User";
        List<Steps1_User> steps1User = jdbcTemeplate.query(InsertSQL, new BeanPropertyRowMapper<>(Steps1_User.class));
        System.out.println(steps1User);
    }

    @Test
    //查询某个值
    public void Steps1_SelectValue() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps1.xml");
        JdbcTemplate jdbcTemeplate = applicationContext.getBean("jdbcTemeplate", JdbcTemplate.class);
        String InsertSQL = "select count(1) from Steps1_User";
        Integer steps1User = jdbcTemeplate.queryForObject(InsertSQL, int.class);
        System.out.println(steps1User);
    }

    @Test
    //批量添加
    public void Steps1_BatchInsert() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps1.xml");
        JdbcTemplate jdbcTemeplate = applicationContext.getBean("jdbcTemeplate", JdbcTemplate.class);
        String InsertSQL = "insert  into Steps1_User(real_name,age) values(?,?) ";

        // 创建一个 List 来装所有的 Object 数组
        List<Object[]> batchArgs = new ArrayList<>();
        // 依次添加名字和年龄
        batchArgs.add(new Object[]{"张三", 22});
        batchArgs.add(new Object[]{"李四", 25});
        batchArgs.add(new Object[]{"王五", 28});
        batchArgs.add(new Object[]{"赵六", 30});
        batchArgs.add(new Object[]{"Alice", 18});
        batchArgs.add(new Object[]{"Bob", 35});

        int[] ints = jdbcTemeplate.batchUpdate(InsertSQL, batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    //批量修改
    public void Steps1_BatchUpdate() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps1.xml");
        JdbcTemplate jdbcTemeplate = applicationContext.getBean("jdbcTemeplate", JdbcTemplate.class);
        String InsertSQL = "update Steps1_User set real_name=?,age=? where id =? ";

        // 创建一个 List 来装所有的 Object 数组
        List<Object[]> batchArgs = new ArrayList<>();
        // 依次修改名字和年龄
        batchArgs.add(new Object[]{"新李四", 26, 10});
        batchArgs.add(new Object[]{"新王五", 29, 11});
        batchArgs.add(new Object[]{"新赵六", 31, 12});
        batchArgs.add(new Object[]{"新Alice", 19, 13});
        batchArgs.add(new Object[]{"新Bob", 36, 14});
        batchArgs.add(new Object[]{"张三", 22, 15});
        batchArgs.add(new Object[]{"李四", 25, 16});
        batchArgs.add(new Object[]{"王五", 28, 17});
        batchArgs.add(new Object[]{"赵六", 30, 18});
        batchArgs.add(new Object[]{"Alice", 18, 19});
        batchArgs.add(new Object[]{"Bob", 35, 20});

        int[] ints = jdbcTemeplate.batchUpdate(InsertSQL, batchArgs);
        System.out.println(Arrays.toString(ints));
    }


    @Test
    //批量删除
    public void Steps1_BatchDelete() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps1.xml");
        JdbcTemplate jdbcTemeplate = applicationContext.getBean("jdbcTemeplate", JdbcTemplate.class);
        String InsertSQL = "delete from Steps1_User where id =? ";
        // 创建一个 List 来装所有的 Object 数组
        List<Object[]> batchArgs = new ArrayList<>();
        // 依次修改名字和年龄
        for (int i = 1; i <= 10; i++) {
            // 注意：这里只有一个元素了！
            batchArgs.add(new Object[]{i});
        }
        int[] ints = jdbcTemeplate.batchUpdate(InsertSQL, batchArgs);
        System.out.println(Arrays.toString(ints));
    }
}