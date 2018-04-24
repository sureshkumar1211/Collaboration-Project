package com.suresh.backendserver.dao;

import com.suresh.backendserver.model.UserCredentials;

public interface UserDAO {
	
	public boolean registerUser(UserCredentials userCredentials);

}
