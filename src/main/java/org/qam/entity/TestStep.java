package org.qam.entity;

import jakarta.persistence.*;

@Entity
public class TestStep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    String stepDescription;
    boolean stepSuccessful;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "testFlow_id")
    private TestFlow testFlow;

    public TestStep() {
    }

    public TestStep(String stepDescription, boolean stepSuccessful) {
        this.stepDescription = stepDescription;
        this.stepSuccessful = stepSuccessful;
    }

    public Long getId() {
        return id;
    }

    public TestStep setId(Long id) {
        this.id = id;
        return this;
    }

    public TestFlow getTestFlow() {
        return testFlow;
    }

    public TestStep setTestFlow(TestFlow testFlow) {
        this.testFlow = testFlow;
        return this;
    }

    public String getStepDescription() {
        return stepDescription;
    }

    public TestStep setStepDescription(String stepDescription) {
        this.stepDescription = stepDescription;
        return this;
    }

    public boolean isStepSuccessful() {
        return stepSuccessful;
    }

    public TestStep setStepSuccessful(boolean stepSuccessful) {
        this.stepSuccessful = stepSuccessful;
        return this;
    }
}

