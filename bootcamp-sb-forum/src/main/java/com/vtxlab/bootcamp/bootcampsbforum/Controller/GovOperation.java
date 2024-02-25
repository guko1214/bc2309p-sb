package com.vtxlab.bootcamp.bootcampsbforum.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.bootcamp.bootcampsbforum.annotation.UserIdCheck;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.request.UserIdDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.response.UserCommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.response.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse1;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse2;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.websocket.server.PathParam;

// SOAP API -> XML (Spring)
// REST / RESTFUL -> JSON (Spring)


@Validated
public interface GovOperation {


  @Operation(summary = "Get User by Id using method 1",
    description = "This method return user UserPostDTO by method 1",
    tags = "gov-controller",
    parameters = {@Parameter(name = "id",
          description = "User ID", required = true)})
  @GetMapping(value = "/user1")
  @ResponseStatus(value = HttpStatus.OK) // 200
  UserPostDTO getUserPostDTO1(@RequestParam(value = "id") int idx);

  @GetMapping(value = "/user2")
  UserPostDTO getUserPostDTO2(@RequestParam(value = "id") int idx);

  @GetMapping(value = "/user3")
  ResponseEntity<UserPostDTO> getUserPostDTO3(@RequestParam(value = "id") int idx);

  @GetMapping(value = "/user4")
  ResponseEntity<ApiResponse1<UserPostDTO>> getUserPostDTO4(@RequestParam(value = "id") int idx);

  @GetMapping(value = "/user5")
  ResponseEntity<ApiResponse2<UserPostDTO>> getUserPostDTO5(@RequestParam(value = "id") int idx); 
  
  @GetMapping(value = "/user6")
  ApiResponse2<UserPostDTO> getUserPostDTO6(@RequestParam(value = "id") int idx);   
                      
  @GetMapping(value = "/user7")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse2<UserPostDTO> getUserPostDTO7(
                      @UserIdCheck @RequestParam(value = "id") UserIdDTO userIdDTO); 

  @GetMapping(value = "/users")
  @ResponseStatus(value = HttpStatus.OK) // 200
  ApiResponse2<List<UserPostDTO>> getUsers();

  @GetMapping(value = "/comment")
  ResponseEntity<ApiResponse2<UserCommentDTO>> getUserCommentDTO(@RequestParam(value = "id") int idx);

  @GetMapping(value = "/comments")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse2<List<UserCommentDTO>> getComments();

  @GetMapping(value = "/users/email/{e}/phone/{p}")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse2<List<com.vtxlab.bootcamp.bootcampsbforum.entity.User>>  //
      getUsersByEmailAndPhoneOrderByEmailDesc( //
        @PathVariable(name = "e") String email, @PathVariable(name = "p") String phone);

  @GetMapping(value = "/users/latitude/{lat}/longitude/{lng}")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse2<List<com.vtxlab.bootcamp.bootcampsbforum.entity.User>>  //
  getUsersByLatitudeAndLogitude( //
  @PathVariable(name = "lat") String latitude, @PathVariable(name = "lng") String longitude);     
  


  @GetMapping(value = "/users/zipcode2/{zc}")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse2<List<com.vtxlab.bootcamp.bootcampsbforum.entity.User>>  //
  getUsersByZipcode2(@PathVariable(name = "zc") String zipcode);




}
