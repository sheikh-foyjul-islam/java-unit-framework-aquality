package tests;

import pages.FileDownloadPage;
import utils.SettingsTestData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import java.io.File;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class FileDownloadTest extends BaseTest {
    private final FileDownloadPage fileDownloadPage = new FileDownloadPage();
    private final String fileName = SettingsTestData.getFileData().getDownloadFile();
    private final String filePath = SettingsTestData.RESOURCES_PATH + fileName;
    private final File downloadedFile = new File(filePath);

    @Test
    public void fileDownloadTest() {
        // Navigate to the main page
        getBrowser().goTo("https://the-internet.herokuapp.com/");

        // Click on "File Download" link
        fileDownloadPage.clickFileDownloadLink();

        // Verify "File Downloader" text is displayed
        fileDownloadPage.verifyFileDownloaderTextIsDisplayed();

        // Click on "some-file.txt" link (replace with actual filename)
        fileDownloadPage.isFileDownloadLinkDisplayed(LambdaTest.txt);

        // Wait for some time to allow download (adjust as needed)
        try {
            Thread.sleep(5000); // Replace with explicit wait for download completion (recommended)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void deleteFile() {
        if (downloadedFile.exists()) {
            try {
                downloadedFile.delete();
            } catch (SecurityException e) {
                System.out.println("Failed to delete downloaded file: " + e.getMessage());
            }
        }
    }
}
