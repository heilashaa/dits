package com.dev_incubator.dits.persistence.repository;

import com.dev_incubator.dits.persistence.entity.TestStatistic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestStatisticRepository extends JpaRepository<TestStatistic, Long> {
}
