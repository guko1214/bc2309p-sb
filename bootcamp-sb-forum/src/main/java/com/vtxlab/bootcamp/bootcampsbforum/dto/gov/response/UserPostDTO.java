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
public class UserPostDTO {
  
  private int id;
  private String name;
  private String email;
  private String phone;
  @JsonProperty(value = "posts")
  private List<PostDTO> postDTOs;

}
