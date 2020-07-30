package com.dev_incubator.dits.persistence.repository;

import com.dev_incubator.dits.persistence.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {
}
