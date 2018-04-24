package com.suresh.backendserver.dao;

import java.util.List;

import com.suresh.backendserver.model.BlogComment;

public interface BlogCommentDAO {
	public boolean registerBlogComment(BlogComment blogComment);

	public List<BlogComment> allBlogComment();

	public BlogComment singleBlogComment(int commentId);

	public boolean deleteBlogComment(BlogComment blogComment);

	public boolean updateBlogComment(BlogComment blogComment);
}
