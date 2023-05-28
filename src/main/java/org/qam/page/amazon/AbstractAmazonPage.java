package org.qam.page.amazon;

import org.qam.conf.TestContext;
import org.qam.page.AbstractPage;

public abstract class AbstractAmazonPage extends AbstractPage {
    protected AbstractAmazonPage(TestContext testContext) {
        super("https://www.amazon.pl", testContext);
    }


}
