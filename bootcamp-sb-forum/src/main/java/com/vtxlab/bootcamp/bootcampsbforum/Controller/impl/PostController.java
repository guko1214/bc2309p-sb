package com.vtxlab.bootcamp.bootcampsbforum.Controller.impl;

import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbforum.Controller.PostOperation;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.service.PostService;
import com.vtxlab.bootcamp.bootcampsbforum.service.impl.PostJPHServiceHolder;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1")

public class PostController implements PostOperation {
  
  @Autowired
  private PostService  postservice;

  public List<Post> getPosts() {
    return postservice.getPosts();
  }

  public Post getPost(int idx) {
    return postservice.getPost(idx);
  }

  public Post getPost2(int idx) {
    return postservice.getPost(idx);
  }

}
