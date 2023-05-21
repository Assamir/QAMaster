package org.qam.conf;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
  private boolean headless;

  private Browser browser;
  private Map<String, TestContext> testContexts = new HashMap<>();

  public ScenarioContext(boolean headless, Browser browser) {
    this.headless = headless;
    this.browser = browser;
  }

  public Map<String, TestContext> getTestContexts() {
    return testContexts;
  }

  public ScenarioContext addTestContext(TestContext testContexts) {
    this.testContexts.computeIfAbsent(testContexts.getId(), (k) -> testContexts);

    return this;
  }

  public boolean isHeadless() {
    return headless;
  }

  public TestContext createTestContext() {
    var testContext = new TestContext(this);
    addTestContext(testContext);
    return testContext;
  }

  public Browser getBrowser() {
    return browser;
  }
}
