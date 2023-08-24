package org.qam.repository;

import org.qam.entity.TestFlow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface TestFlowRepository extends JpaRepository<TestFlow, Long> {
}
