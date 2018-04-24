package com.suresh.backendserver.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class BlogComment {
	@Id
	@GeneratedValue
	private int commentId;
	private String commentText;
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public int getBlogId() {
		return BlogId;
	}
	public void setBlogId(int blogId) {
		BlogId = blogId;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate() {
		this.commentDate = new Date();
	}
	private String loginName;
	private int BlogId;
	private Date commentDate; 
	

}
