package com.classroom.evaluation.dummy.application;

import com.classroom.evaluation.shared.authentication.domain.Role;
import com.classroom.evaluation.shared.kipe.domain.RolesAccesses;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class BeersAccessesConfiguration {

  @Bean
  RolesAccesses beersAccesses() {
    return RolesAccesses
      .builder()
      .role(Role.ADMIN)
      .allAuthorized("create", BeerResource.BEERS)
      .allAuthorized("remove", BeerResource.BEERS)
      .and()
      .build();
  }
}
