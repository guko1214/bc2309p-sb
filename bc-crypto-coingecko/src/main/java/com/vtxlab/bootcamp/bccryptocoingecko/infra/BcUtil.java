package com.vtxlab.bootcamp.bccryptocoingecko.infra;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.logging.log4j.util.Strings;
import org.springframework.web.util.UriComponentsBuilder;

public class BcUtil {
  
  public static String getUrl(Scheme scheme, String domain,String endpoint ,HashMap<String,String> uris) {
    //String uriString = "";
    // for (Map.Entry<String,String> s :uris.entrySet()) {
    //   uriString  += s.getValue();
    // }
    String uriString = endpoint + BcUtil.concatParms(uris);
    return UriComponentsBuilder.newInstance()
      .scheme(scheme.toLowercase())
      .host(domain)
      .path(uriString)
      .toUriString(); // handle special character, \ : //
  }

  public static String concatParms(HashMap<String, String> urls) {
    StringBuilder strs = new StringBuilder();
    for (Map.Entry<String,String> s: urls.entrySet()) {
      strs.append(s.getKey());
      strs.append("=");
      strs.append(s.getValue());
      strs.append("&");
    }
    return strs.substring(0, strs.length() - 2).toString();
  }

}
