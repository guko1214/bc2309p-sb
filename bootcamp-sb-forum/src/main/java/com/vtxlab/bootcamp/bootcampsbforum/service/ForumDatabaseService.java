package com.vtxlab.bootcamp.bootcampsbforum.service;

import java.util.List;
import com.vtxlab.bootcamp.bootcampsbforum.entity.Comment;
import com.vtxlab.bootcamp.bootcampsbforum.entity.Post;
import com.vtxlab.bootcamp.bootcampsbforum.entity.User;

public interface ForumDatabaseService {
  
  List<User> saveAllUsers(List<User> users);

  List<Post> saveAllPosts(List<Post> posts);

  List<Comment> saveAllComments(List<Comment> comments);

  List<User> findAllUsersByEmailAndPhoneOrderByEmailDesc(String email, String phone);

  List<User> findAllUsersByLatitudeAndLongitude(String latitude, String longitude);

  List<User> findAllUsersByEmailOrPhone(String email, String phone);


  List<User> findAllUsersByZipcode2(String zipcode);
}
