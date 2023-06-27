package org.qam.page.amazon;

import com.microsoft.playwright.options.AriaRole;
import org.qam.conf.TestContext;
import org.qam.page.AbstractPage;

public abstract class AbstractAmazonPage extends AbstractPage {
    protected AbstractAmazonPage(TestContext testContext) {
        super("https://www.amazon.pl", "https://swapi.dev/api/", testContext);
    }

    @Override
    public void navigateToStartPage() {
        super.navigateToStartPage();
        var selector = "#sp-cc-accept";
        if (page.locator(selector).isVisible()) click(AriaRole.BUTTON, selector);
    }
}
