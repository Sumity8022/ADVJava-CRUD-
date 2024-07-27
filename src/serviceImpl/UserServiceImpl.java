package serviceImpl;

import connection.DBConnection;
import daos.LoginDao;
import daos.RegisterDao;
import daos.UserDao;
import models.User;
import service.UserService;

public class UserServiceImpl implements UserService{

	
	//method for save/register feature
	@Override
	public boolean saveUser(User user) {
		
		RegisterDao dao=new RegisterDao(DBConnection.getConn());
		
		boolean isSaved = dao.saveMyUser(user);

		
		return isSaved;
	}//method end

	
	
	//method for get user by email used in logged in
	@Override
	public User getUserByEmail(String email, String pass) {
		
		LoginDao ldao=new LoginDao(DBConnection.getConn());
		User user = ldao.getUserByEmail(email, pass);
		
		
		return user;
		
		
	}//end



//method for get user based on userid
	@Override
	public String getUserByID(int id) {
		
		UserDao udao=new UserDao(DBConnection.getConn());
		String fname = udao.getUSerByID(id);
		return fname;
	
	}
	
	
	
	
	
	
	
	

}//class end