package tests;

import org.testng.annotations.Test;
import pages.DynamicControlsPage;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static aquality.selenium.browser.AqualityServices.getBrowser;



public class DynamicControlsTest extends BaseTest {
    private final DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();
    private final String randomText = UUID.randomUUID().toString();

    @Test
    public void dynamicControlsTest() {
        // Navigate to the Dynamic Controls page
        getBrowser().goTo("https://the-internet.herokuapp.com/dynamic_controls");
        getBrowser().getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Verify "Dynamic Controls" text is displayed
        dynamicControlsPage.verifyDynamicControlsTextIsDisplayed();
        getBrowser().getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        // Click the "Enable" button
        dynamicControlsPage.clickEnableButton();
        getBrowser().getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Wait for the input field to become enabled
        dynamicControlsPage.waitForInputFieldToBeEnabled();
        getBrowser().getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Send random text to the input field
        dynamicControlsPage.sendKeysToInputField(randomText);
        getBrowser().getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
