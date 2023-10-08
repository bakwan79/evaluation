package com.classroom.evaluation.dummy.application;

import com.classroom.evaluation.dummy.domain.beer.BeerToCreate;
import com.classroom.evaluation.shared.kipe.application.AccessChecker;
import com.classroom.evaluation.shared.kipe.application.AccessContext;
import com.classroom.evaluation.shared.kipe.application.EvaluationAuthorizations;
import org.springframework.stereotype.Component;

@Component
class BeerToCreateAccessChecker implements AccessChecker<BeerToCreate> {

  private final EvaluationAuthorizations authorizations;

  public BeerToCreateAccessChecker(EvaluationAuthorizations authorizations) {
    this.authorizations = authorizations;
  }

  @Override
  public boolean can(AccessContext<BeerToCreate> access) {
    return authorizations.allAuthorized(access.authentication(), access.action(), BeerResource.BEERS);
  }
}
