package com.classroom.evaluation.dummy.domain.beer;

import com.classroom.evaluation.dummy.domain.Amount;
import com.classroom.evaluation.dummy.domain.BeerId;
import com.classroom.evaluation.shared.error.domain.Assert;

public record BeerToCreate(BeerName name, Amount unitPrice) {
  public BeerToCreate {
    Assert.notNull("name", name);
    Assert.notNull("unitPrice", unitPrice);
  }

  public Beer create() {
    return Beer.builder().id(BeerId.newId()).name(name()).unitPrice(unitPrice()).sellingState(BeerSellingState.SOLD).build();
  }
}
