package com.suresh.backendserver.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.suresh.backendserver.dao.BlogDAO;
import com.suresh.backendserver.model.Blog;

@Repository
@Transactional
@EnableTransactionManagement
public class BlogDAOImpl implements BlogDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean registerUser(Blog blog) {
		// TODO Auto-generated method stub
		blog.setCreateDate();
		try {
			System.out.println(blog.getBlogName());
			sessionFactory.getCurrentSession().save(blog);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public List<Blog> allBlogs() {
		// TODO Auto-generated method stub
		List<Blog> allBlogs = null;
		try {
			allBlogs = sessionFactory.getCurrentSession().createQuery("From Blog").list();
			return allBlogs;
		} catch (Exception e) {
			// TODO: handle exception
			return allBlogs;
		}
	}

	@Override
	public Blog singleBlog(int bloigId) {
		// TODO Auto-generated method stub
		Blog blog = null;
		try {
			blog = sessionFactory.getCurrentSession().get(Blog.class, bloigId);
			return blog;
		} catch (Exception e) {
			// TODO: handle exception
			return blog;
		}

	}

	@Override
	public boolean deleteBlog(Blog blog) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		try {

			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
