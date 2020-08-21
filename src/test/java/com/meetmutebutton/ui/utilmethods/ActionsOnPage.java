package test.java.com.meetmutebutton.ui.utilmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsOnPage {
    private static int waitInSeconds = 10;

    public void sendKeys(WebDriver driver, By by, String text) {
        waitForElementToLoad(driver, by);
        driver.findElement(by).sendKeys(text);
    }

    public void click(WebDriver driver, By by) {
        waitForElementToLoad(driver, by);
        driver.findElement(by).click();
        waitForPageLoad(driver);
    }



    public void openURL(WebDriver driver, String url) {
        driver.get(url);
    }

    public void waitForElementToLoad(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, waitInSeconds);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForPageLoad(WebDriver driver) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                        .equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(driver, waitInSeconds);
            wait.until(expectation);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

}
