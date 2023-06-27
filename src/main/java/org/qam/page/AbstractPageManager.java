package org.qam.page;

import org.qam.conf.TestContext;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractPageManager {
    protected static Map<IPage, AbstractPage> pageMap = new HashMap<>();
    protected TestContext testContext;

    public AbstractPageManager(TestContext testContext) {
        this.testContext = testContext;
        navigateToStartPage();
    }

    protected abstract void navigateToStartPage();

}
