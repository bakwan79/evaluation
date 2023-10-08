package com.classroom.evaluation.dummy.application;

import com.classroom.evaluation.shared.kipe.domain.Resource;

enum BeerResource implements Resource {
  BEERS("beers");

  private final String key;

  BeerResource(String key) {
    this.key = key;
  }

  @Override
  public String key() {
    return key;
  }
}
