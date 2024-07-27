package service;

import models.User;

public interface UserService {
	public boolean saveUser(User user);// to save user

	public User getUserByEmail(String email, String pass);

	public String getUserByID(int id);
}
