package com.vtxlab.bootcamp.bootcampsbforum.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.bootcampsbforum.entity.Comment;
import com.vtxlab.bootcamp.bootcampsbforum.entity.Post;
import com.vtxlab.bootcamp.bootcampsbforum.entity.User;
import com.vtxlab.bootcamp.bootcampsbforum.repository.CommentRepository;
import com.vtxlab.bootcamp.bootcampsbforum.repository.PostRepository;
import com.vtxlab.bootcamp.bootcampsbforum.repository.UserRepository;
import com.vtxlab.bootcamp.bootcampsbforum.service.ForumDatabaseService;


@Service
public class ForumDatabaseHolder implements ForumDatabaseService{
  
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PostRepository postRepository;
  @Autowired
  private CommentRepository commentRepository;

  @Override
  public List<User> saveAllUsers(List<User> users) {
    return userRepository.saveAll(users);
  };

  @Override
  public List<Post> saveAllPosts(List<Post> posts) {
    return postRepository.saveAll(posts);
  }

  @Override
  public List<Comment> saveAllComments(List<Comment> comments) {
    return commentRepository.saveAll(comments);
  };

  

}
