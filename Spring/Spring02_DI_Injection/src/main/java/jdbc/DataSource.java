package jdbc;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

//把容器交给spring来处理
public class DataSource implements javax.sql.DataSource {
    private String driver;
    private String ulr;
    private String username;
    private String password;


    //Setter methods!
    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setUlr(String ulr) {
        this.ulr = ulr;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //toString methods!
    @Override
    public String toString() {
        return "DataSource{" +
                "driver='" + driver + '\'' +
                ", ulr='" + ulr + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    // DataSource methods!
    @Override
    public Connection getConnection() throws SQLException {
        //数据库连接需要 driver,url,username,password
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
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
