package com.classroom.evaluation.shared.pagination.infrastructure.secondary;

import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.classroom.evaluation.shared.error.domain.Assert;
import com.classroom.evaluation.shared.pagination.domain.EvaluationPage;
import com.classroom.evaluation.shared.pagination.domain.EvaluationPageable;

public final class EvaluationPages {

  private EvaluationPages() {}

  public static Pageable from(EvaluationPageable pagination) {
    return from(pagination, Sort.unsorted());
  }

  public static Pageable from(EvaluationPageable pagination, Sort sort) {
    Assert.notNull("pagination", pagination);
    Assert.notNull("sort", sort);

    return PageRequest.of(pagination.page(), pagination.pageSize(), sort);
  }

  public static <S, T> EvaluationPage<T> from(Page<S> springPage, Function<S, T> mapper) {
    Assert.notNull("springPage", springPage);
    Assert.notNull("mapper", mapper);

    return EvaluationPage
      .builder(springPage.getContent().stream().map(mapper).toList())
      .currentPage(springPage.getNumber())
      .pageSize(springPage.getSize())
      .totalElementsCount(springPage.getTotalElements())
      .build();
  }
}
