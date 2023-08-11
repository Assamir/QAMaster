package org.qam.repository;

import org.qam.entity.TestStep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestStepRepository extends JpaRepository<TestStep, Long> {
}
