package com.suresh.backendserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.suresh.backendserver.dao.BlogCommentDAO;
import com.suresh.backendserver.model.BlogComment;
@RestController
public class BlogCommentController {

	@Autowired
	BlogCommentDAO blogCommentDAO;

	@PostMapping(value = { "/blogComment" })
	public ResponseEntity<String> createBlogComment
	(@RequestBody BlogComment  blogComment) {
		if (blogCommentDAO.registerBlogComment(blogComment)) {
			System.out.println("blogComment created");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			System.out.println("blogComment not created");
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	@GetMapping(value = { "/blogComment" })
	public ResponseEntity<List<BlogComment>> allBlogComment() {
		List<BlogComment> allBlogComment = blogCommentDAO.allBlogComment();
		if (allBlogComment != null) {
			return new ResponseEntity<List<BlogComment>>(allBlogComment, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<BlogComment>>(HttpStatus.CONFLICT);
		}
	}

	@GetMapping(value = { "/blogComment/{id}/" })
	public ResponseEntity<BlogComment> singleBlog(@PathVariable("id") int blogCommentId) {
		BlogComment blogComment = blogCommentDAO.singleBlogComment(blogCommentId);
		if (blogComment != null) {
			return new ResponseEntity<BlogComment>(blogComment, HttpStatus.OK);
		} else {
			return new ResponseEntity<BlogComment>(HttpStatus.CONFLICT);
		}
	}

	@DeleteMapping(value = { "/blogComment/{id}/" })
	public ResponseEntity<String> deleteBlogComment(@PathVariable("id") int blogCommentId) {
		BlogComment blogComment = blogCommentDAO.singleBlogComment(blogCommentId);
		if (blogCommentDAO.deleteBlogComment(blogComment)) {
			System.out.println("blogComment deleted");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			System.out.println("blogComment not deleted");
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping(value = { "/blogComment" })
	public ResponseEntity<String> updateBlogComment(@RequestBody BlogComment blogComment) {
		if (blogCommentDAO.updateBlogComment(blogComment)) {
			System.out.println("blogComment updated");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			System.out.println("blogComment not updated");
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
}

