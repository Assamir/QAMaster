package org.qam.page.amazon;

import org.qam.conf.TestContext;
import org.qam.page.AbstractPage;

public class Navigator extends AbstractAmazonPage {
    public Navigator(TestContext testContext) {
        super(testContext);
    }

    @Override
    protected Navigator setBaseAPI(String baseAPI) {
        return (Navigator) setBaseAPIInternal(baseAPI);
    }
}
