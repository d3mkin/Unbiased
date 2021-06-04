package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.FinAdviserDirectory;
import pages.HomePage;

public class TestTask extends BaseTest {
    HomePage homePage;
    FinAdviserDirectory finAdviserDirectory;

    @BeforeEach
    public void setupPages() {
        homePage = new HomePage();
        finAdviserDirectory = new FinAdviserDirectory();
    }

    @Test
    public void finAdviserTest() {
        homePage
                .open()
                .shouldHaveContent()
                .clickOnFinancialAdviser()
                .clickOnShowDirectory();
        finAdviserDirectory
                .shouldHaveContent()
                .selectService("Financial adviser")
                .selectArea("Financial planning")
                .selectValue("10,000,000+")
                .enterPostcode("SE207AA")
                .clickSubmit();
        finAdviserDirectory.checkAdviser(20, "The Private Office");
    }
}
