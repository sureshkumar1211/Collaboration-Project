package com.suresh.backendserver.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.suresh.backendserver.dao.UserDAO;
import com.suresh.backendserver.model.UserCredentials;

@Repository
@EnableTransactionManagement
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean registerUser(UserCredentials userCredentials) {
		// TODO Auto-generated method stub
		userCredentials.setUserJoinedOn();
		try {
			System.out.println(userCredentials.getUserName());
			sessionFactory.getCurrentSession().save(userCredentials);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
