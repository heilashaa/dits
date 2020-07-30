package com.dev_incubator.dits.persistence.repository;

import com.dev_incubator.dits.persistence.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
