package Steps3;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan("Steps3")
@EnableTransactionManagement
public class Steps3_Config {
    // Spring框架,看到这个@Bean注解后,会调用这个被标注的方法,这个方法的返回值是一个java对象,这个java对象会自动纳入IoC容器管理。
    //返回的对象就是Spring容器当中的一个Bean了。
    // 并且这个bean的名字是:dataSource
    @Bean("dataSource")
    public DruidDataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_learn");
        dataSource.setUsername("root");
        dataSource.setPassword("mysql");
        return dataSource;
    }

    //Spring在调用这个方法的时候会自动给我们传递过来一个dataSource对象。
    @Bean("jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean("transactionManager")
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}
