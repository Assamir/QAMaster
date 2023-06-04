package org.qam.conf;

import com.microsoft.playwright.Playwright;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
  private boolean headless;
  private Playwright playwright = Playwright.create();
  private BrowserToRun BrowserToRun;
  private Map<String, TestContext> testContexts = new HashMap<>();

  public ScenarioContext(boolean headless, BrowserToRun BrowserToRun) {
    this.headless = headless;
    this.BrowserToRun = BrowserToRun;
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

  public BrowserToRun getBrowser() {
    return BrowserToRun;
  }

  public Playwright getPlaywright() {
    return playwright;
  }
}
