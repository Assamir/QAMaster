package org.qam.service;

import org.qam.entity.TestFlow;
import org.qam.entity.TestStep;
import org.qam.repository.TestFlowRepository;
import org.qam.repository.TestStepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestFlowService {

    private final TestFlowRepository testFlowRepository;
    private final TestStepRepository testStepRepository;

    @Autowired
    public TestFlowService(TestFlowRepository testFlowRepository, TestStepRepository testStepRepository) {
        this.testFlowRepository = testFlowRepository;
        this.testStepRepository = testStepRepository;
    }

    @Transactional
    public TestFlow createTestFlow(TestFlow testFlow, List<TestStep> steps) {
        TestFlow savedFlow = testFlowRepository.save(testFlow);
        for (TestStep step : steps) {
            step.setTestFlow(savedFlow);
            testStepRepository.save(step);
        }
        return savedFlow;
    }

    public TestFlow getTestFlow(Long id) {
        return testFlowRepository.findById(id).orElse(null);
    }

    public void save(TestFlow testFlow) {
        testFlowRepository.save(testFlow);
    }

    // Add more methods as needed...
}
