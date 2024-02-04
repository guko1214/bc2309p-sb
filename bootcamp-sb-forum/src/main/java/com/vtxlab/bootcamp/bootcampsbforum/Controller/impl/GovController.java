package com.vtxlab.bootcamp.bootcampsbforum.Controller.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbforum.Controller.GovOperation;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.PostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserCommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.mapper.GovMapper;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse1;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse2;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Comment;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtxlab.bootcamp.bootcampsbforum.service.CommentService;
import com.vtxlab.bootcamp.bootcampsbforum.service.PostService;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/gov/api/v1")

public class GovController implements GovOperation {
  

  @Autowired
  private UserService userservice;
  @Autowired
  private PostService postservice;
  @Autowired
  private CommentService commentservice;


  // method 1
  @Override
  public UserPostDTO getUserPostDTO1(int idx) {
    // Call post
    // Construct UserPostDTO
   return userservice.getUsers().stream()
    .filter(e -> e.getId() == idx)
    .map(e -> {
      List<PostDTO> postDTOs = postservice.getPosts().stream()
      .filter(p -> p.getUserId() == e.getId())
      .map( p -> {
        return PostDTO.builder()
              .id(e.getId())
              .title(p.getTitle())
              .build();
      }).collect(Collectors.toList());

      return UserPostDTO.builder()
      .id(e.getId())
      .name(e.getName())
      .email(e.getEmail())
      .phone(e.getPhone())
      .postDTOs(postDTOs)
      .build();
      })
      .findFirst()
      .orElse(null);
  }

  // method 2 // move the second stream to a static function (GovMapper.userPostDTOmap)
  @Override
  public UserPostDTO getUserPostDTO2(int idx) {
    // Call post
    // Construct UserPostDTO
    UserPostDTO userPostDTO = userservice.getUsers().stream()
    .filter(e -> e.getId() == idx)
    .map(e -> {
      List<Post> posts = postservice.getPosts();
      return GovMapper.userPostDTOmap(e, posts);
    })
    .findFirst()
    .orElse(null);
    return userPostDTO;
  }

  // method 3 // use Optional and ResponseEntity 
  @Override
  public ResponseEntity<UserPostDTO> getUserPostDTO3(int idx) {
    // Call post
    // Construct UserPostDTO
   Optional<UserPostDTO> userPostDTO = userservice.getUsers().stream()
    .filter(e -> e.getId() == idx)
    .map(e -> {
      List<Post> posts = postservice.getPosts();
        return GovMapper.userPostDTOmap(e, posts);
    }).findFirst();
    //.orElse(null); // not necessary to return null when using Optional

   if (userPostDTO.isPresent()) {
    return ResponseEntity.ok(userPostDTO.get());
   } 
   // instead return null, use ResponseEntity.noContent()
   return ResponseEntity.noContent().build(); // http status 204

  }

  // method 4 use a custome class ApiResonse1 to generate response code and message (by Syscode enum)
              //especially for null response
  @Override
  public ResponseEntity<ApiResponse1<UserPostDTO>> getUserPostDTO4(int idx) {
    // Call post
    // Construct UserPostDTO
    Optional<UserPostDTO> userPostDTO = userservice.getUsers().stream()
    .filter(e -> e.getId() == idx)
    .map(e -> {
      List<Post> posts = postservice.getPosts();
        return GovMapper.userPostDTOmap(e, posts);
    }).findFirst();
    ApiResponse1<UserPostDTO> apiResp;
    if (userPostDTO.isPresent()) {
      apiResp = ApiResponse1.<UserPostDTO>builder()
      .code(Syscode.OK.getCode())
      .message(Syscode.OK.getMessage())
      .data(userPostDTO.get())
      .build();
    } else {
      apiResp = ApiResponse1.<UserPostDTO>builder()
      .code(Syscode.NOTFOUND.getCode())
      .message(Syscode.NOTFOUND.getMessage())
      .data(null)
      .build();
    }
    return ResponseEntity.ok(apiResp);

  }

  // method 5 // use a custome class ApiResonse2 to encapsulate response code and message oringinally free in ApiRespone1
              // to status to avoid custom message by other programmer without modification of Syscode enum
  @Override
  public ResponseEntity<ApiResponse2<UserPostDTO>> getUserPostDTO5(int idx) {
    // Call post
    // Construct UserPostDTO
   Optional<UserPostDTO> userPostDTO = userservice.getUsers().stream()
    .filter(e -> e.getId() == idx)
    .map(e -> {
      List<Post> posts = postservice.getPosts();
        return GovMapper.userPostDTOmap(e, posts);
    }).findFirst();
   
   ApiResponse2<UserPostDTO> apiResp;
   if (userPostDTO.isPresent()) {
    apiResp = ApiResponse2.<UserPostDTO>builder()
    .status(Syscode.OK)
    .data(userPostDTO.get())
    .build();
    ;
   } else {
    apiResp = ApiResponse2.<UserPostDTO>builder()
    .status(Syscode.NOTFOUND)
    .data(null)
    .build();
   }
   return ResponseEntity.ok(apiResp);
  }


  public ResponseEntity<ApiResponse2<UserCommentDTO>> getUserCommentDTO(int idx) {
     Optional<UserCommentDTO> userCommentDTO = userservice.getUsers().stream()
    .filter(e -> e.getId() == idx)
    .map(e -> {
      List<Post> posts = postservice.getPosts();
      List<Comment> comments = commentservice.getComments();
        return GovMapper.userCommentDTOmap(e, posts,comments);
        //return GovMapper.userCommentDTOmap2(e, posts,comments);
      }).findFirst();
      
      ApiResponse2<UserCommentDTO> apiResp;
      if (userCommentDTO.isPresent()) {
        apiResp = ApiResponse2.<UserCommentDTO>builder()
                  .status(Syscode.OK)
                  .data(userCommentDTO.get())
                  .build();
      } else {
        apiResp = ApiResponse2.<UserCommentDTO>builder()
                  .status(Syscode.NOTFOUND)
                  .data(null)
                  .build();
      }
      return ResponseEntity.ok(apiResp);
  };
}
