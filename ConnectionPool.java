//Create a db.properties file

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.util.ResourceBundle;
import javax.sql.*;

/**
 *
 * @author Hakim
 */
public class ConnectionPool {
    private static final ConnectionPool INSTANCE=new ConnectionPool();

    public ConnectionPool() {
    }
    
    public static ConnectionPool getInctance(){
        return INSTANCE;
    }
    
    public DataSource getDataSource(){
        var dbProp=ResourceBundle.getBundle("db");
        
        var config=new HikariConfig();
        config.setJdbcUrl(dbProp.getString("db.url"));
        config.setUsername(dbProp.getString("db.user"));
        config.setPassword(dbProp.getString("db.password"));
        config.setDriverClassName(dbProp.getString("db.driver"));
        
        var maxPoolSize=dbProp.getString("db.max.Connections");
        config.setMaximumPoolSize(Integer.parseInt(maxPoolSize));
        
        return new HikariDataSource(config);
    }
    
    public static void main(String[] args) {
        var dataSource=ConnectionPool.getInctance().getDataSource();
        var connection=dataSource.getConnection();
    }
}
