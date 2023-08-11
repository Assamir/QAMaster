package org.qam.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class TestFlow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flowName;
    private LocalDateTime executionTime;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "testFlow")
    private List<TestStep> steps;

    public Long getId() {
        return id;
    }

    public TestFlow setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFlowName() {
        return flowName;
    }

    public TestFlow setFlowName(String flowName) {
        this.flowName = flowName;
        return this;
    }

    public LocalDateTime getExecutionTime() {
        return executionTime;
    }

    public TestFlow setExecutionTime(LocalDateTime executionTime) {
        this.executionTime = executionTime;
        return this;
    }

    public List<TestStep> getSteps() {
        return steps;
    }

    public TestFlow setSteps(List<TestStep> steps) {
        this.steps = steps;
        return this;
    }
}