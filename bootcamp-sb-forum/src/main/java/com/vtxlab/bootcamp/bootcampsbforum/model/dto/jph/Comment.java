package com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph;

import lombok.Getter;

@Getter
public class Comment {
  private int postId;
  private int id;
  private String name;
  private String email;
  private String body;
}
