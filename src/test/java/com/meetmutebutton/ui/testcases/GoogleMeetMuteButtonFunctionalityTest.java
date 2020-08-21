package test.java.com.meetmutebutton.ui.testcases;

import junit.framework.TestCase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.java.com.meetmutebutton.ui.utilmethods.CommonMethods;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class GoogleMeetMuteButtonFunctionalityTest extends TestCase {
    private WebDriver driver;
    private Properties properties = new Properties();
    CommonMethods commonMethods = new CommonMethods();

    /*
    This method will setup the webdriver and Chrome options to be used in  every subsequent test.
     */
    @BeforeTest
    public void setUp() throws Exception {

        properties.load(new FileReader(new File("src/test/resources/testData.properties")));
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("use-fake-ui-for-media-stream");
        driver = new ChromeDriver(chromeOptions);
    }
    /*
    This method will close all the windows , popUps , tabs etc. which will be opened in every test
     */
    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    /*
    This test case will verify the functionality of Google Meet Mute Button.
    Steps to be performed :
        1.Open https://apps.google.com/meet to login on Google Account.
        2.Enter UserName and password and login into the account.
        3.Enter the google Meet link to join the meeting.
        4.Once joined , click on mute button.
        5.Verify that once button is clicked , its colour is changed.
     */
    @Test
    public void testGoogleMeetMuteButtonFunctionality() throws Exception {
        String googleAppUrl="https://apps.google.com/meet/";
        String googleMeetUrl = properties.getProperty("googleMeetLink");
        commonMethods.openGoogleAppSignInURL(driver,googleAppUrl);
        commonMethods.clickOnSignIn(driver);
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        commonMethods.enterEmailAddress(driver, username);
        commonMethods.clickNextAfterEnteringEmail(driver);
        commonMethods.enterPassword(driver, password);
        commonMethods.clickNextAfterEnteringPassword(driver);
        commonMethods.enterMeetingLink(driver,googleMeetUrl);
        commonMethods.clickNextAfterEnteringMeetingLink(driver);
        commonMethods.clickOnJoinNow(driver);
        commonMethods.clickOnMute(driver);
        commonMethods.assertMuteButtonIsClicked(driver);
    }
}
