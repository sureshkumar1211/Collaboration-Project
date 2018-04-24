package com.suresh.backendserver.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.suresh.backendserver.dao.ForumDAO;
import com.suresh.backendserver.model.Forum;
@Repository
@Transactional
@EnableTransactionManagement
public class ForumDAOImpl implements ForumDAO {
	@Autowired
SessionFactory sessionFactory;
	@Override
	public boolean addForumDetails(Forum forum) {
		// TODO Auto-generated method stub
		forum.setCreateDate();
		try {
			System.out.println(forum.getForumName());
			sessionFactory.getCurrentSession().save(forum);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	
	}
	@Override
	public List<Forum> allForumDetails() {
		// TODO Auto-generated method stub
		List<Forum> forum=null;
		try {
			
			forum=sessionFactory.getCurrentSession().createQuery("From Forum").list();
			return forum;
		} catch (Exception e) {
			// TODO: handle exception
			return forum;
		}
		
		
		
	}
	@Override
	public Forum singleForum(int forumId) {
		// TODO Auto-generated method stub
		Forum forum=null;
		try {
			forum=sessionFactory.getCurrentSession().get(Forum.class, forumId);
			return forum;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return forum;
	}
	@Override
	public boolean deleteForum(Forum forum) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(forum);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return false;
	}
	@Override
	public boolean updateForum(Forum forum) {
		// TODO Auto-generated method stub
		try {
			System.out.println(forum.getForumName());
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
		
}
