package org.qam.page.amazon.common;

import com.microsoft.playwright.options.AriaRole;
import org.qam.conf.TestContext;
import org.qam.page.amazon.AbstractAmazonPage;

public class SearchBar extends AbstractAmazonPage {

    public SearchBar(TestContext testContext) {
        super(testContext);
    }

    public SearchBar setPhrase(String phrase) {
        setTextInputField(AriaRole.SEARCH, "#twotabsearchtextbox", phrase);
        return this;
    }

    public SearchBar clickSearch() {
        click(AriaRole.BUTTON, "#nav-search-submit-button");
        return this;
    }

    @Override
    protected SearchBar setBaseAPI(String baseAPI) {
        return (SearchBar) setBaseAPIInternal(baseAPI);
    }
}
