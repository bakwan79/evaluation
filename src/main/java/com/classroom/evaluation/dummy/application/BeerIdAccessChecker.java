package com.classroom.evaluation.dummy.application;

import com.classroom.evaluation.dummy.domain.BeerId;
import com.classroom.evaluation.shared.kipe.application.AccessChecker;
import com.classroom.evaluation.shared.kipe.application.AccessContext;
import com.classroom.evaluation.shared.kipe.application.EvaluationAuthorizations;
import org.springframework.stereotype.Component;

@Component
class BeerIdAccessChecker implements AccessChecker<BeerId> {

  private final EvaluationAuthorizations authorizations;

  public BeerIdAccessChecker(EvaluationAuthorizations authorizations) {
    this.authorizations = authorizations;
  }

  @Override
  public boolean can(AccessContext<BeerId> access) {
    return authorizations.allAuthorized(access.authentication(), access.action(), BeerResource.BEERS);
  }
}
