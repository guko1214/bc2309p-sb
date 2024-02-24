package com.vtxlab.bootcamp.bootcampsbforum.infra;

import org.springframework.web.util.UriComponentsBuilder;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Scheme;

public class BcUtil {
  
  public static String getUrl(Scheme scheme, String domain, String uri) {
    return UriComponentsBuilder.newInstance()
      .scheme(scheme.toLowercase())
      .host(domain)
      .path(uri)
      .toUriString(); // handle special character, \ : //
  }

}
