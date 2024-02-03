package com.vtxlab.bootcamp.bootcampsbforum.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;

public interface PostOperation {
  
  @GetMapping(value = "/posts")
  List<Post> getPosts();

  @GetMapping(value = "/post/{idx}")
  Post getPost(@PathVariable(name = "idx") int idx);

  @GetMapping(value = "/post")
  Post getPost2(@RequestParam(value = "id") int idx);

  
}
