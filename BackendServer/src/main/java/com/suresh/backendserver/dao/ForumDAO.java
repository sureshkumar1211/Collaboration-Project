package com.suresh.backendserver.dao;

import java.util.List;

import com.suresh.backendserver.model.Forum;

public interface ForumDAO {
public  boolean addForumDetails(Forum forum);
public List<Forum> allForumDetails();

public Forum singleForum(int forumId);

public boolean deleteForum(Forum forum);

public boolean updateForum(Forum forum);
}
