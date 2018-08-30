package util;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;


public class ConnectionUtil {
	
	 private static ConnectionUtil pool = null;
	    private static DataSource dataSource = null;

	    private ConnectionUtil() {
	        try {
	            InitialContext ic = new InitialContext();
	            dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/inclass");
	        } catch (NamingException e) {
	            System.out.println(e);
	        }
	    }

	    public static synchronized ConnectionUtil getInstance() {
	        if (pool == null) {
	            pool = new ConnectionUtil();
	        }
	        return pool;
	    }

	    public Connection getConnection() {
	        try {
	            return dataSource.getConnection();
	        } catch (SQLException e) {
	            System.out.println(e);
	            return null;
	        }
	    }

	    public void freeConnection(Connection c) {
	        try {
	            c.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }

}
}