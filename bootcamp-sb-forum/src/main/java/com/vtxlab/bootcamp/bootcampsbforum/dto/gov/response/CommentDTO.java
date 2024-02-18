package com.vtxlab.bootcamp.bootcampsbforum.dto.gov.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDTO {
  private int postId;
  private int id;
  private String body;
}
