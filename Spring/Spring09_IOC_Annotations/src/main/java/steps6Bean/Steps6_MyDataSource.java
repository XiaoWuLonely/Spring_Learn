package steps6Bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.ShardingKeyBuilder;
import java.util.logging.Logger;

@Component
public class Steps6_MyDataSource implements DataSource {
    //使用Value可以不写Setter
    @Value("com.mysql.cj.jdbc.Driver")
    private String driver;
    @Value("jdbc:mysql://localhost:3306/mytest")
    private String url;
    @Value("root")
    private String username;
    @Value("mysql")
    private String password;

    @Override
    public String toString() {
        return "Steps6_MyDataSource{" + "driver='" + driver + '\'' + ", url='" + url + '\'' + ", username='" + username + '\'' + ", password='" + password + '\'' + '}';
    }

//    public void setDriver(String driver) {
//        this.driver = driver;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

    @Override
    public Connection getConnection() throws SQLException {
        return null;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public ShardingKeyBuilder createShardingKeyBuilder() throws SQLException {
        return DataSource.super.createShardingKeyBuilder();
    }
}
