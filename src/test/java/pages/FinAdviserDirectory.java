package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FinAdviserDirectory {
    private SelenideElement filterServiceInput = $("[data-id='filter-service'] .v-input__control");
    private SelenideElement filterAreasInput = $("[data-id='filter-areas'] .v-input__control");
    private SelenideElement filterValueInput = $("[data-id='filter-value'] .v-input__control");
    private SelenideElement filterPostcodeInput = $("#filter-select-postcode");
    private SelenideElement listbox = $(".menuable__content__active");
    private SelenideElement submitBtn = $("#filter-submit-button");

    /**
     *Check there is content on the page
     */
    public FinAdviserDirectory shouldHaveContent() {
        $("#filter-title").shouldHave(text("Find an Independent Financial Adviser"));
        $("#directory-search-results").shouldBe(visible);
        return this;
    }

    /**
     * Choose a financial service
     * @param  service financial service
     */
    public FinAdviserDirectory selectService(String service) {
        filterServiceInput.click();
        listbox.$(byText(service)).click();
        return this;
    }

    /**
     * Choose a financial area
     * @param  area financial area
     */
    public FinAdviserDirectory selectArea(String area) {
        filterAreasInput.click();
        listbox.$(byText(area)).scrollIntoView(false).click();
        return this;
    }

    /**
     * Choose Income/Asset value
     * @param  value Income/Asset value
     */
    public FinAdviserDirectory selectValue(String value) {
        filterValueInput.click();
        listbox.$x(".//div[contains(text(), '"+value+"')]").scrollIntoView(false).click();
        return this;
    }

    /**
     * Choose postcode/city
     * @param  postcode postcode/city
     */
    public FinAdviserDirectory enterPostcode(String postcode) {
        filterPostcodeInput.setValue(postcode).pressEnter();
        return this;
    }

    /**
     * Click Submit button
     */
    public FinAdviserDirectory clickSubmit() {
        submitBtn.click();
        return this;
    }

    /**
     * Check the number {advisersCount} of found advisers and among them there is an adviser named {adviserName}
     * @param advisersCount the right number of consultants
     * @param adviserName consultant name
     */
    public FinAdviserDirectory checkAdviser (int advisersCount, String adviserName) {
        $$("[data-id='profile-name']").shouldHaveSize(advisersCount).shouldHave(itemWithText(adviserName));
        return this;
    }
}
