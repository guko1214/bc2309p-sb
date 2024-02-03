package com.vtxlab.bootcamp.bootcampsbforum.Controller;

import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserCommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;

public interface GovOperation {
  @GetMapping(value = "/user")
  ResponseEntity<ApiResponse<UserPostDTO>> getUserPostDTO(@RequestParam(value = "id") int idx);

  // @GetMapping(value = "/comments")
  // UserCommentDTO getUserCommentDTO(@RequestParam(value = "id") int idx);
}
