package com.suresh.backendserver.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.suresh.backendserver.dao.BlogCommentDAO;
import com.suresh.backendserver.model.BlogComment;
@Repository
@EnableTransactionManagement
@EnableWebMvc
@Transactional
public class BlogCommentDAOImpl implements BlogCommentDAO {
	@Autowired
SessionFactory sessionFactory;

	@Override
	public boolean registerBlogComment(BlogComment blogComment) {
		blogComment.setCommentDate();
		// TODO Auto-generated method stub
		
		try {
			System.out.println(blogComment.getCommentText());
			sessionFactory.getCurrentSession().save(blogComment);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}


	@Override
	public List<BlogComment> allBlogComment() {
		// TODO Auto-generated method stub
		List<BlogComment> allBlogComment = null;
		try {
			allBlogComment = sessionFactory.getCurrentSession().createQuery("From BlogComment").list();
			return allBlogComment;
		} catch (Exception e) {
			// TODO: handle exception
			return allBlogComment;
		}
	
	}

	@Override
	public BlogComment singleBlogComment(int commentId) {
		// TODO Auto-generated method stub
		BlogComment blogComment = null;
		try {
			blogComment = sessionFactory.getCurrentSession().get(BlogComment.class, commentId);
			return blogComment;
		} catch (Exception e) {
			// TODO: handle exception
			return blogComment;
		}

		
	}

	@Override
	public boolean deleteBlogComment(BlogComment blogComment) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(blogComment);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

	@Override
	public boolean updateBlogComment(BlogComment blogComment) {
		// TODO Auto-generated method stub
		
		try {

			sessionFactory.getCurrentSession().saveOrUpdate(blogComment);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	}


