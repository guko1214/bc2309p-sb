package com.vtxlab.bootcamp.bootcampsbforum.dto.gov;

import java.util.List;
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
  private List<PostDTO> postDTOs;

}
