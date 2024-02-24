package com.vtxlab.bootcamp.bootcampsbforum.dto.gov.mapper;

import java.util.List;
import java.util.stream.Collectors;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.request.UserPostRequestDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.response.CommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.response.PostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.response.UserCommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.response.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.entity.PostEntity;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;
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
      //for (PostDTO postDTO : postDTOs) {
      //  if (c2.getPostId() == postDTO.getId()) {
          return CommentDTO.builder()
               .postId(c2.getPostId())
             .id(c2.getId())
             .body(c2.getBody())
             .build();
      //  }
     // }
     // return null;
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

  public static UserCommentDTO userCommentDTOmap2(User e,List<Post> posts ,List<Comment> comments) {
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
    .filter(c -> c.getEmail().equals(e.getEmail()))
    .map( c2 -> {
          return CommentDTO.builder()
                .postId(c2.getPostId())
              .id(c2.getId())
              .body(c2.getBody())
              .build();
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

  public static UserEntity map(UserPostRequestDTO dto) {
    UserEntity userEntity = UserEntity.builder() //
      .name(dto.getName())
      .username(dto.getUsername())
      .email(dto.getEmail())
      .phone(dto.getPhone())
      .website(dto.getWebsite())
      .street(dto.getStreet())
      .suite(dto.getSuite())
      .city(dto.getCity())
      .zipcode(dto.getZipcode())
      .addrLat(dto.getAddrLat())
      .addrLng(dto.getAddrLong())
      .cName(dto.getCompanyName())
      .catchPhrase(dto.getCompanyCatchPhrase())
      .cBusinessService(dto.getCompanyBusService())
      .build();
      
      List<PostEntity> postEntities =  dto.getPosts().stream() //
        .map(e -> {
          PostEntity postEntity = PostEntity.builder()
            .title(e.getTitle())
            .body(e.getBody())
            .build();

          postEntity.setUser2(userEntity); // ManyToOne relationship
          return postEntity;
        }).collect(Collectors.toList());

      userEntity.setPosts(postEntities);
      return userEntity;
  }


}
