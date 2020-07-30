package com.dev_incubator.dits.persistence.repository;

import com.dev_incubator.dits.persistence.entity.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticRepository extends JpaRepository<Statistic, Long> {
}
