package com.classroom.evaluation.dummy.domain.order;

import com.classroom.evaluation.dummy.domain.Amount;
import com.classroom.evaluation.dummy.domain.BeerId;
import com.classroom.evaluation.shared.error.domain.Assert;

public record OrderedBeer(BeerId beer, Amount unitPrice) {
  public OrderedBeer {
    Assert.notNull("beer", beer);
    Assert.notNull("unitPrice", unitPrice);
  }
}
