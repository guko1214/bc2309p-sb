package com.vtxlab.bootcamp.bootcampsbforum.controller.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbforum.controller.GovOperation;
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
import com.vtxlab.bootcamp.bootcampsbforum.service.ForumDatabaseService;
import com.vtxlab.bootcamp.bootcampsbforum.service.PostService;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/gov/api/v1")

public class GovController implements GovOperation {
  

  @Autowired
  private UserService userService;
  @Autowired
  private PostService postService;
  @Autowired
  private CommentService commentService;
  @Autowired
  private ForumDatabaseService forumDatabaseService;


  // method 1
  @Override
  public UserPostDTO getUserPostDTO1(int idx) {
    // Call post
    // Construct UserPostDTO
   return userService.getUsers().stream()
    .filter(e -> e.getId() == idx)
    .map(e -> {
      List<PostDTO> postDTOs = postService.getPosts().stream()
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
    UserPostDTO userPostDTO = userService.getUsers().stream()
    .filter(e -> e.getId() == idx)
    .map(e -> {
      List<Post> posts = postService.getPosts();
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
   Optional<UserPostDTO> userPostDTO = userService.getUsers().stream()
    .filter(e -> e.getId() == idx)
    .map(e -> {
      List<Post> posts = postService.getPosts();
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
    Optional<UserPostDTO> userPostDTO = userService.getUsers().stream()
    .filter(e -> e.getId() == idx)
    .map(e -> {
      List<Post> posts = postService.getPosts();
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
   Optional<UserPostDTO> userPostDTO = userService.getUsers().stream()
    .filter(e -> e.getId() == idx)
    .map(e -> {
      List<Post> posts = postService.getPosts();
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

  // method 6 // use orElseThrow() in stream to throws to globalExceptionHandler 
              // to handle error
  @Override
  public ApiResponse2<UserPostDTO> getUserPostDTO6(int idx) {
    // Call post
    // Construct UserPostDTO
    List<User> users = userService.getUsers();
    UserPostDTO userPostDTO = users.stream()
    .filter(e -> e.getId() == idx)
    .map(e -> {
      List<Post> posts = postService.getPosts();
        return GovMapper.userPostDTOmap(e, posts);
    }).findFirst().orElseThrow(() -> new RuntimeException());
    
     return ApiResponse2.<UserPostDTO>builder()
    .status(Syscode.OK)
    .data(userPostDTO)
    .build();
    
  }

  public ApiResponse2<List<UserPostDTO>> getUsers() {
    List<User> users = userService.getUsers();
    List<com.vtxlab.bootcamp.bootcampsbforum.entity.User> userEntities = users.stream()
      .map(e -> {
        return com.vtxlab.bootcamp.bootcampsbforum.entity.User.builder() //
          .jphId(e.getId()) //
          .name(e.getName()) //
          .username(e.getUsername()) //
          .email(e.getEmail()) //
          .phone(e.getPhone()) //
          .website(e.getWebsite()) //
          .addrLat(e.getAddress().getGeo().getLat())
          .addrLng(e.getAddress().getGeo().getLng())
          .street(e.getAddress().getStreet())
          .suite(e.getAddress().getSuite())
          .city(e.getAddress().getCity())
          .zipcode(e.getAddress().getZipcode())
          .cName(e.getCompany().getName())
          .catchPhrase(e.getCompany().getCatchPhrase())
          .cBusinessService(e.getCompany().getBs())
          .build();
      })
      .collect(Collectors.toList());      

      // Save to DB
      forumDatabaseService.saveAllUsers(userEntities);

      List<Post> posts = postService.getPosts();

      List<com.vtxlab.bootcamp.bootcampsbforum.entity.Post> postEntities = posts.stream()
        .map(e -> {
          return com.vtxlab.bootcamp.bootcampsbforum.entity.Post.builder()
            .userId(e.getUserId())
            .postId(e.getId())
            .title(e.getTitle())
            .body(e.getBody())
            .build();
        })
        .collect(Collectors.toList());

      forumDatabaseService.saveAllPosts(postEntities);

      List<UserPostDTO> userPostDTOs = users.stream()
    //.filter(e -> e.getId() == idx)
    .map(e -> {
      //List<Post> posts = postService.getPosts();
        return GovMapper.userPostDTOmap(e, posts);
    })
    .collect(Collectors.toList());   
    ;
    //.findFirst()
    //.orElseThrow(() -> new RuntimeException());
    
     return ApiResponse2.<List<UserPostDTO>>builder()
    .status(Syscode.OK)
    .data(userPostDTOs)
    .build();
  };

  // method 5
  public ResponseEntity<ApiResponse2<UserCommentDTO>> getUserCommentDTO(int idx) {
     Optional<UserCommentDTO> userCommentDTO = userService.getUsers().stream()
    .filter(e -> e.getId() == idx)
    .map(e -> {
      List<Post> posts = postService.getPosts();
      List<Comment> comments = commentService.getComments();
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

  public ApiResponse2<List<UserCommentDTO>> getComments() {

    List<Comment> comments = commentService.getComments();
    List<com.vtxlab.bootcamp.bootcampsbforum.entity.Comment> commentEntities = comments.stream() //
    .map(e -> {
      return com.vtxlab.bootcamp.bootcampsbforum.entity.Comment.builder()
        .postId(e.getPostId())
        .commentId(e.getId())
        .name(e.getName())
        .email(e.getEmail())
        .body(e.getBody())
        .build();
      })
      .collect(Collectors.toList());

      forumDatabaseService.saveAllComments(commentEntities);
    
    List<UserCommentDTO> userCommentDTOs = userService.getUsers().stream()
   .map(e -> {
     List<Post> posts = postService.getPosts();
     //List<Comment> comments = commentService.getComments();
       return GovMapper.userCommentDTOmap(e, posts,comments);
     })
    .collect(Collectors.toList());


      return ApiResponse2.<List<UserCommentDTO>>builder()
                 .status(Syscode.OK)
                 .data(userCommentDTOs)
                 .build();
 };


  public ApiResponse2<List<com.vtxlab.bootcamp.bootcampsbforum.entity.User>> getUsersByEmailAndPhoneOrderByEmailDesc( //
          String email, String phone) {
    List<com.vtxlab.bootcamp.bootcampsbforum.entity.User> users = forumDatabaseService
          .findAllUsersByEmailAndPhoneOrderByEmailDesc(email, phone);

    return ApiResponse2.<List<com.vtxlab.bootcamp.bootcampsbforum.entity.User>>builder()
    .status(Syscode.OK)
    .data(users)
    .build();
  }

  public ApiResponse2<List<com.vtxlab.bootcamp.bootcampsbforum.entity.User>> getUsersByLatitudeAndLogitude( //
    String latitude, String longitude) {
    List<com.vtxlab.bootcamp.bootcampsbforum.entity.User> users = forumDatabaseService
    .findAllUsersByLatitudeAndLongitude(latitude, longitude);

    return ApiResponse2.<List<com.vtxlab.bootcamp.bootcampsbforum.entity.User>>builder()
    .status(Syscode.OK)
    .data(users)
    .build();
    };  



  public ApiResponse2<List<com.vtxlab.bootcamp.bootcampsbforum.entity.User>>  //
  getUsersByZipcode2(String zipcode) {
    List<com.vtxlab.bootcamp.bootcampsbforum.entity.User> users = forumDatabaseService
    .findAllUsersByZipcode2(zipcode);

    return ApiResponse2.<List<com.vtxlab.bootcamp.bootcampsbforum.entity.User>>builder()
    .status(Syscode.OK)
    .data(users)
    .build();
  };  

}
