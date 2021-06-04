package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    private SelenideElement mainContainer = $("#home-page-body");
    private SelenideElement modalContainer = $("#b-match-vs-browse-modal");
    private SelenideElement finAdviserBtn = $(".financial");
    private SelenideElement showDirectoryBtn = modalContainer.$("#b-browse-directory-link");

    /**
     * Open the main page
     */
    public HomePage open() {
        Selenide.open(baseUrl);
        return this;
    }

    /**
     * Check there is content on the page
     */
    public HomePage shouldHaveContent() {
        mainContainer.$("p.b-title__subtitle").shouldHave(text("Let's begin. Who are you looking for?"));
        mainContainer.$$(".b-hero__column a").shouldHave(size(3));
        return this;
    }

    /**
     * Click on button
     * @param  buttonName button
     */
    public HomePage clickOnButton (String buttonName) {
        $x("//a[contains(.,'"+buttonName+"')]").click();
        return  this;
    }

    /**
     * Click on button "Financial Adviser"
     */
    public HomePage clickOnFinancialAdviser() {
        finAdviserBtn.click();
        return this;
    }

    /**
     * Click on button "Show me a directory"
     */
    public HomePage clickOnShowDirectory() {
        showDirectoryBtn.click();
        return this;
    }
}
