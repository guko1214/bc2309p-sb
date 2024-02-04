package com.vtxlab.bootcamp.bootcampsbforum.Controller;

import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserCommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import jakarta.websocket.server.PathParam;

public interface GovOperation {

  @GetMapping(value = "/user1")
  ResponseEntity<ApiResponse<UserPostDTO>> getUserPostDTO1(@RequestParam(value = "id") int idx);

  @GetMapping(value = "/user2")
  UserPostDTO getUserPostDTO2(@RequestParam(value = "id") int idx);

  @GetMapping(value = "/user3")
  ResponseEntity<UserPostDTO> getUserPostDTO3(@RequestParam(value = "id") int idx);

  @GetMapping(value = "/user4")
  ResponseEntity<ApiResponse<UserPostDTO>> getUserPostDTO4(@RequestParam(value = "id") int idx);

  @GetMapping(value = "/comments")
  ResponseEntity<ApiResponse<UserCommentDTO>> getUserCommentDTO(@RequestParam(value = "id") int idx);
}
