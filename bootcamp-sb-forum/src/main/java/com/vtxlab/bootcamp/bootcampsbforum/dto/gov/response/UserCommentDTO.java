package com.vtxlab.bootcamp.bootcampsbforum.dto.gov.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCommentDTO {
  
  private int id;
  private String username;
  private String email;
  private String phone;
  @JsonProperty(value = "cts") // customize the export json field name
  private List<CommentDTO> commentDTOs;
}
