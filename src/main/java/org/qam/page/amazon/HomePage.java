package org.qam.page.amazon;

import org.qam.conf.TestContext;

public class HomePage extends AbstractAmazonPage {

    public HomePage(TestContext testContext) {
        super(testContext);
    }

    @Override
    public HomePage setBaseAPI(String baseAPI) {
        return (HomePage) setBaseAPIInternal(baseAPI);
    }
}
