package tests;

import org.openqa.selenium.Alert;
import pages.BasicAuthPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.SettingsTestData;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class BasicAuthTest extends BaseTest {
    private final BasicAuthPage basicAuthPage = new BasicAuthPage();

    @BeforeMethod
    public void auth() {
        // Navigate to the main page
        getBrowser().goTo(SettingsTestData.getEnvData().getHost());

        // Click on "Basic Auth" link
        mainPage.clickBasicAuthLink();

        // Wait for the alert to appear
        ExpectedConditions.alertIsPresent().apply(getBrowser().getDriver());

        // Handle the basic authentication alert
        Alert alert = getBrowser().getDriver().switchTo().alert();
        alert.sendKeys("admin"); // Username
        alert.sendKeys("\t" + "admin"); // Password (using tab to separate)
        alert.accept();
    }

    @Test
    public void basicAuthTest() {
        // Your test logic for verifying the content of the Basic Auth page after successful login
        // You can use assertions from aquality.selenium.core.elements.actions or org.testng.asserts
        String expectedText = "Congratulations! You successfully logged in.";
        String actualText = basicAuthPage.getMessageText();
        org.testng.asserts.SoftAssert softAssert = new org.testng.asserts.SoftAssert();
        softAssert.assertEquals(actualText, expectedText, "The expected message after login was not found.");
        softAssert.assertAll();
    }
}
