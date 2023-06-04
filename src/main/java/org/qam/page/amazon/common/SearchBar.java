package org.qam.page.amazon.common;

import org.openqa.selenium.By;
import org.qam.conf.TestContext;
import org.qam.page.amazon.AbstractAmazonPage;

public class SearchBar extends AbstractAmazonPage {

    public SearchBar(TestContext testContext) {
        super(testContext);
    }

    public SearchBar setPhrase(String phrase) {
        setTextInputField(By.cssSelector("#nav-bb-search"), phrase);
        return this;
    }

    public SearchBar clickSearch() {
        click(By.className("nav-bb-button"));
        return this;
    }

    @Override
    protected SearchBar setBaseAPI(String baseAPI) {
        return (SearchBar) setBaseAPIInternal(baseAPI);
    }
}
