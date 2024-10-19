package tests;

import utils.SettingsTestData;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest {
    private final String fileName = SettingsTestData.getFileData().getUploadFile();
    private final String filePath = SettingsTestData.TEST_DATA_PATH + fileName;

    @Test
    public void fileUploadTest() {
        // todo: add test
    }
}
