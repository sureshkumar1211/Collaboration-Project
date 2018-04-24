package com.suresh.backendserver.dao;

import java.util.List;

import com.suresh.backendserver.model.Blog;

public interface BlogDAO {
	public boolean registerUser(Blog blog);
	
	public List<Blog> allBlogs();
	
	public Blog singleBlog(int bloigId);
	
	public boolean deleteBlog(Blog blog);
	
	public boolean updateBlog(Blog blog);
	
	

}
