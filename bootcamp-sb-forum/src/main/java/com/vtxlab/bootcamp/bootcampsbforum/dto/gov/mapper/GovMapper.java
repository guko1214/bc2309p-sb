package com.vtxlab.bootcamp.bootcampsbforum.dto.gov.mapper;

import java.util.List;
import java.util.stream.Collectors;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.CommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.PostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserCommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Comment;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;

public class GovMapper {
  

  public static UserPostDTO userPostDTOmap(User e, List<Post> posts) {
    List<PostDTO> postDTOs = posts.stream()
    .filter(p -> p.getUserId() == e.getId())
    .map( p -> {
      return PostDTO.builder()
            .id(p.getId())
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

  public static UserCommentDTO userCommentDTOmap(User e,List<Post> posts ,List<Comment> comments) {
    List<PostDTO> postDTOs = posts.stream()
    .filter(p -> p.getUserId() == e.getId())
    .map( p -> {
      return PostDTO.builder()
      .id(p.getId())
      .title(p.getTitle())
      .build();
    })
    .collect(Collectors.toList());

    List<CommentDTO> commentDTOs = comments.stream()
    .filter(c -> {
        for (PostDTO postDTO : postDTOs) {
          if (c.getPostId() == postDTO.getId()) {
            return true;
          }
        }
        return false;
      })
    .map( c2 -> {
      for (PostDTO postDTO : postDTOs) {
        if (c2.getPostId() == postDTO.getId()) {
          return CommentDTO.builder()
               .postId(c2.getPostId())
             .id(c2.getId())
             .body(c2.getBody())
             .build();
        }
      }
      return null;
    })
    .collect(Collectors.toList());

    return UserCommentDTO.builder()
    .id(e.getId())
    .username(e.getName())
    .email(e.getEmail())
    .phone(e.getPhone())
    .commentDTOs(commentDTOs)
    .build();
 }
      
}
