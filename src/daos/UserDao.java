package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.User;

public class UserDao {
	
	private Connection conn;
	
	
	public UserDao(Connection conn) {
		this.conn=conn;
	}
	
	
	
	public String getUSerByID(int id)
	{
		String userName="";
		
		try
		{
			
			String query="select * from user where userid=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				userName = rs.getString("userFname");
			}
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		return userName;
		
	}
	
	
}