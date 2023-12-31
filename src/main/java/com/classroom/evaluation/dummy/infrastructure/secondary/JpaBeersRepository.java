package com.classroom.evaluation.dummy.infrastructure.secondary;

import java.util.Collection;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.classroom.evaluation.dummy.domain.beer.BeerSellingState;

interface JpaBeersRepository extends JpaRepository<BeerEntity, UUID> {
  Collection<BeerEntity> findBySellingState(BeerSellingState sellingState);
}
