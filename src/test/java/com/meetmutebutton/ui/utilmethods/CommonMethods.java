package test.java.com.meetmutebutton.ui.utilmethods;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.com.meetmutebutton.ui.pageobjects.PageObjects;

public class CommonMethods {

    PageObjects pageObjects = new PageObjects();
    ActionsOnPage actionsOnPage = new ActionsOnPage();

    public void openGoogleAppSignInURL(WebDriver driver, String url) {
        actionsOnPage.openURL(driver, url);
        driver.manage().window().maximize();
    }

    public void enterEmailAddress(WebDriver driver, String email) {
        actionsOnPage.sendKeys(driver, By.id(pageObjects.UserName_TextBox), email);
    }

    public void clickNextAfterEnteringEmail(WebDriver driver) {
        actionsOnPage.click(driver, By.id(pageObjects.UserName_Next));
    }

    public void enterPassword(WebDriver driver, String password) {
        actionsOnPage.sendKeys(driver, By.name(pageObjects.Password_TextBox), password);
    }

    public void enterMeetingLink(WebDriver driver, String meetingLink) {
        actionsOnPage.sendKeys(driver, By.name(pageObjects.Meeting_Link_TextBox), meetingLink);
    }

    public void clickNextAfterEnteringMeetingLink(WebDriver driver) {
        actionsOnPage.click(driver, By.id(pageObjects.Click_After_Entering_Meeting_Link));
    }

    public void clickOnMute(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        WebElement muteElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-tooltip='Turn off microphone (⌘ + d)']//div")));
        muteElement.click();
    }

    public void clickOnSignIn(WebDriver driver) {
        actionsOnPage.click(driver, By.linkText(pageObjects.App_Sign_In));
    }

    public void clickNextAfterEnteringPassword(WebDriver driver) {
        actionsOnPage.click(driver, By.id(pageObjects.Password_Next));
    }

    public void clickOnJoinNow(WebDriver driver) {
        actionsOnPage.click(driver, By.xpath(pageObjects.Join_Now));
    }
    public void assertMuteButtonIsClicked(WebDriver driver) {
        String color = driver.findElement(By.xpath("//div[@class='I5fjHe wb61gb']")).getCssValue("color");
        String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");
        int hexValue1 = Integer.parseInt(hexValue[0]);
        hexValue[1] = hexValue[1].trim();
        int hexValue2 = Integer.parseInt(hexValue[1]);
        hexValue[2] = hexValue[2].trim();
        int hexValue3 = Integer.parseInt(hexValue[2]);
        String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
        Assert.assertEquals("#5f6368", actualColor);
    }
}