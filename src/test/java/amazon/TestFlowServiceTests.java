package amazon;

import org.junit.jupiter.api.Test;
import org.qam.Main;
import org.qam.entity.TestFlow;
import org.qam.entity.TestStep;
import org.qam.repository.TestFlowRepository;
import org.qam.service.TestFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;

//@SpringBootTest
@SpringBootTest(classes = Main.class)
class TestFlowServiceTests {

    @Autowired
    private TestFlowService testFlowService;

    @Autowired
    private TestFlowRepository testFlowRepository;

    @Test
    void testCreateTestFlow() {
        TestFlow flow = new TestFlow();
        flow.setFlowName("Sample Flow");
        flow.setExecutionTime(LocalDateTime.now());

        TestStep step1 = new TestStep();
        step1.setStepDescription("Step 1");
        step1.setStepSuccessful(true);

        TestStep step2 = new TestStep();
        step2.setStepDescription("Step 2");
        step2.setStepSuccessful(false);

        TestFlow savedFlow = testFlowService.createTestFlow(flow, Arrays.asList(step1, step2));
        assertNotNull(savedFlow.getId());
    }
}
