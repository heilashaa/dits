package com.dev_incubator.dits.persistence.repository;

import com.dev_incubator.dits.persistence.entity.QuestionStatistic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionStatisticRepository extends JpaRepository<QuestionStatistic, Long> {
}
