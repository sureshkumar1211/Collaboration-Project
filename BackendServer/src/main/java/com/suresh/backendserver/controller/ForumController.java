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

import com.suresh.backendserver.dao.ForumDAO;
import com.suresh.backendserver.model.Blog;
import com.suresh.backendserver.model.Forum;
@RestController
public class ForumController {
	@Autowired
	ForumDAO forumDAO;

	@PostMapping(value= {"/forum"})
	public ResponseEntity<String> registerUser(@RequestBody Forum forum) {
		if (forumDAO.addForumDetails(forum)) {
			System.out.println("forum created");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			System.out.println("forum not created");
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
@GetMapping(value= {"/forum"})
public ResponseEntity<List<Forum>> allForumDetails()
{
List<Forum> forum=forumDAO.allForumDetails();
if(forum!=null) 
{
	return new ResponseEntity<List<Forum>>(forum,HttpStatus.OK);
}
else {
	return new ResponseEntity<List<Forum>>(forum,HttpStatus.CONFLICT);
}
}
@GetMapping(value = { "/forum/{id}/" })
public ResponseEntity<Forum> singleForum(@PathVariable("id") int forumId) {
	Forum forum =forumDAO.singleForum(forumId);
	if (forum != null) {
		return new ResponseEntity<Forum>(forum, HttpStatus.OK);
	} else {
		return new ResponseEntity<Forum>(HttpStatus.CONFLICT);
	}
}
@DeleteMapping(value= {"/forum/{id}/"})
public ResponseEntity<String> deleteForum(@PathVariable("id")int forumId){
	Forum forum = forumDAO.singleForum(forumId);
	if (forumDAO.deleteForum(forum)){
		System.out.println("forum deleted");
		return new ResponseEntity<>(HttpStatus.OK);
	} else {
		System.out.println("forum not deleted");
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
}
	@PutMapping(value = { "/forum" })
	public ResponseEntity<String> updateForum(@RequestBody Forum forum) {
		if (forumDAO.updateForum(forum)) {
			System.out.println("forum updated");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			System.out.println("forum not updated");
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
}

