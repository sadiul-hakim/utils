package blogging.java;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.*;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
/**
 *
 * @author Hakim
 */
public class HakariExample {
    private static final String DB_URL="";
    private static final String DB_USER="";
    private static final String PASSWORD="";
    
    private static HikariDataSource dataSource;
    
    static{
        HikariConfig config=new HikariConfig();
        config.setJdbcUrl(DB_URL);
        config.setUsername(DB_USER);
        config.setPassword(PASSWORD);
        
        dataSource=new HikariDataSource(config);
        dataSource.setMaximumPoolSize(20);
    }
    
    public static Connection getConnection() throws SQLException{
        return dataSource.getConnection();
    }
    
    public static void main(String[] args) {
        var executorService=Executors.newFixedThreadPool(25);
        
        IntStream.range(0, 200).forEach(ite->{
            executorService.submit(()->{
                try {
                    executeCountQuery(ite);
                } catch (SQLException ex) {
                    Logger.getLogger(HakariExample.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
                    
                    
        });
    }
    
    private static void executeCountQuery(int iteration) throws SQLException{
        Connection connection=null;
        try{
            connection=getConnection();
            connection.setAutoCommit(false);
            //sql queries
            //..
            //..
            
            
            connection.commit();
            
        }catch(SQLException e){
            e.printStackTrace();
            connection.rollback();
        }finally{
         if(connection!=null){
             connection.close();
         }   
        }
    }
}
