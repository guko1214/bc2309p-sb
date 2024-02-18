package com.vtxlab.bootcamp.bootcampsbforum.annotation;

import java.util.Objects;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.request.UserIdDTO;
import com.vtxlab.bootcamp.bootcampsbforum.annotation.UserIdCheck;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserIdValidatior implements ConstraintValidator<UserIdCheck, UserIdDTO> {

  @Override
  public boolean isValid(UserIdDTO dto, ConstraintValidatorContext context) {
    try {
      return Objects.nonNull(dto) && Integer.valueOf(dto.getUserId()) > 0;  
    } catch (NumberFormatException e) {
      return false;
    }
    
  }

}
