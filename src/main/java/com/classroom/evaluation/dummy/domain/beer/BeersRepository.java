package com.classroom.evaluation.dummy.domain.beer;

import com.classroom.evaluation.dummy.domain.BeerId;
import java.util.Optional;

public interface BeersRepository {
  void save(Beer beer);

  Beers catalog();

  Optional<Beer> get(BeerId beer);
}
