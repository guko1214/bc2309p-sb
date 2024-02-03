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
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
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


  @Override
  public ResponseEntity<ApiResponse<UserPostDTO>> getUserPostDTO(int idx) {

    // Call post
    // Construct UserPostDTO

   /// return userservice.getUsers().stream()
   Optional<UserPostDTO> userPostDTO = userservice.getUsers().stream()
    .filter(e -> e.getId() == idx)
    .map(e -> {
      List<Post> posts = postservice.getPosts();
        return GovMapper.map(e, posts);
      // List<PostDTO> postDTOs = posts.stream()
      // .filter(p -> p.getUserId() == e.getId())
      // .map( p -> {
      //   return PostDTO.builder()
      //         .id(e.getId())
      //         .title(p.getTitle())
      //         .build();
      // }).collect(Collectors.toList());

      // return UserPostDTO.builder()
      // .id(e.getId())
      // .name(e.getName())
      // .email(e.getEmail())
      // .phone(e.getPhone())
      // .postDTOs(postDTOs)
      // .build();
    }).findFirst();
   // .orElse(null);
   ApiResponse<UserPostDTO> apiResp;
   if (userPostDTO.isPresent()) {
    apiResp = ApiResponse.<UserPostDTO>builder()
    // .code(Syscode.OK.getCode())
    // .message(Syscode.OK.getMessage())
    .status(Syscode.OK)
    .data(userPostDTO.get())
    .build();
    //return ResponseEntity.ok(userPostDTO.get());
    ;
   //} return ResponseEntity.noContent().build(); // http status 204
   } else {
    apiResp = ApiResponse.<UserPostDTO>builder()
    .status(Syscode.NOTFOUND)
    .data(null)
    .build();
   }
   
   return ResponseEntity.ok(apiResp);
  }


  // public UserCommentDTO getUserCommentDTO(int idx) {
  //   return userservice.getUsers().stream()
  //   .filter(e -> e.getId() == idx)
  //   .map(e -> {
  //     List<Post> posts = postservice.getPosts();
  //       return GovMapper.map(e, posts);
  //     }).findFirst()
  //     .orElse(null);
  // };
}
