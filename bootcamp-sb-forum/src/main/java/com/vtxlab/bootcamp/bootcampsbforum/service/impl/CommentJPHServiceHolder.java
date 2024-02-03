package com.vtxlab.bootcamp.bootcampsbforum.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.bootcampsbforum.infra.BcUtil;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Scheme;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Comment;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.service.CommentService;

public class CommentJPHServiceHolder implements CommentService {
  
  @Value("${api.jsonPlaceHolder.domain}")
  private String domain;

  @Value("${api.jsonPlaceHolder.endpoints.comments}")
  private String commentUri;

  public List<Comment> getComments() {
    RestTemplate restTemplate = new RestTemplate();
    String url = BcUtil.getUrl(Scheme.HTTPS, domain, commentUri);

    Comment[] comments = restTemplate.getForObject(url, Comment[].class);

    return Arrays.stream(comments).collect(Collectors.toList());
  };
}
