package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection { 
	 
private static Connection conn = null;// 
 
public static Connection getConn() { 
 
try { 
 
if (conn == null) { 
 
Class.forName("com.mysql.cj.jdbc.Driver"); 
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mycourse?useSSL=false", "root", "123456789"); 
 
} 
 
} catch (Exception e) { 
System.out.println("some thing wrong in db connection !!!"); 
e.printStackTrace(); 
} 
 
return conn; 
} 
 
} 