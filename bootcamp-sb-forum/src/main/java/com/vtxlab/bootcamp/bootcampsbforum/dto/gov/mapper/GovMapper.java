package com.vtxlab.bootcamp.bootcampsbforum.dto.gov.mapper;

import java.util.List;
import java.util.stream.Collectors;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.CommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.PostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserCommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;

public class GovMapper {
  

  public static UserPostDTO map(User e, List<Post> posts) {
    List<PostDTO> postDTOs = posts.stream()
    .filter(p -> p.getUserId() == e.getId())
    .map( p -> {
      return PostDTO.builder()
            .id(e.getId())
            .title(p.getTitle())
            .build();
    })
    .collect(Collectors.toList());

    return UserPostDTO.builder()
    .id(e.getId())
    .name(e.getName())
    .email(e.getEmail())
    .phone(e.getPhone())
    .postDTOs(postDTOs)
    .build();
  }

//   public static UserCommentDTO map(User e, List<Post> comments) {
//     List<CommentDTO> commentDTOs = comments.stream()
//     .filter(p -> p.getUserId() == e.getId())
//     .map( p -> {
//       return CommentDTO.builder()
//             .id(e.getId())
//             .title(p.getTitle())
//             .build();
//     })
//     .collect(Collectors.toList());

//     return UserCommentDTO.builder()
//     .id(e.getId())
//     .username(e.getName())
//     .email(e.getEmail())
//     .phone(e.getPhone())
//     .commentDTOs(commentDTOs)
//     .build();
//  }
      
}
