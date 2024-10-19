package pages;

import aquality.selenium.forms.Form;
import constants.LocatorConstants;
import org.openqa.selenium.By;

public class BasicAuthPage extends Form {
    private static final String NAME = "Basic Auth";

    public BasicAuthPage() {
        super(By.xpath(String.format(LocatorConstants.PRECISE_TEXT_XPATH, NAME)), NAME);
    }

    public boolean isSuccessMsgDisplayed() {
        // todo: implement
        return false;
    }

    public String getMessageText() {
        return null;
    }
}
