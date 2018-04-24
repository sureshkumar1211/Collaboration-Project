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

import com.suresh.backendserver.dao.BlogDAO;
import com.suresh.backendserver.model.Blog;

@RestController
public class BlogController {
	@Autowired
	BlogDAO blogDAO;

	@PostMapping(value = { "/blog" })
	public ResponseEntity<String> createBlog
	(@RequestBody Blog blog) {
		if (blogDAO.registerUser(blog)) {
			System.out.println("blog created");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			System.out.println("blog not created");
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	@GetMapping(value = { "/blog" })
	public ResponseEntity<List<Blog>> allBlogs() {
		List<Blog> allBlog = blogDAO.allBlogs();
		if (allBlog != null) {
			return new ResponseEntity<List<Blog>>(allBlog, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Blog>>(HttpStatus.CONFLICT);
		}
	}

	@GetMapping(value = { "/blog/{id}/" })
	public ResponseEntity<Blog> singleBlog(@PathVariable("id") int blogId) {
		Blog blog = blogDAO.singleBlog(blogId);
		if (blog != null) {
			return new ResponseEntity<Blog>(blog, HttpStatus.OK);
		} else {
			return new ResponseEntity<Blog>(HttpStatus.CONFLICT);
		}
	}

	@DeleteMapping(value = { "/blog/{id}/" })
	public ResponseEntity<String> deleteBlog(@PathVariable("id") int blogId) {
		Blog blog = blogDAO.singleBlog(blogId);
		if (blogDAO.deleteBlog(blog)) {
			System.out.println("blog deleted");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			System.out.println("blog not deleted");
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping(value = { "/blog" })
	public ResponseEntity<String> updateBlog(@RequestBody Blog blog) {
		if (blogDAO.updateBlog(blog)) {
			System.out.println("blog updated");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			System.out.println("blog not updated");
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
}
