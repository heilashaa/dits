package com.dev_incubator.dits.persistence.repository;

import com.dev_incubator.dits.persistence.entity.Literature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LiteratureRepository extends JpaRepository<Literature, Long> {
}
