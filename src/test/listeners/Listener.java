package listeners;

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverListener;
import static listeners.ScreenShotUtil.takeScreenShot;
import static utils.Asserts.*;
import static utils.Waits.*;


public class Listener implements WebDriverListener {

    @Override
    public void beforeClick(WebElement element) {
        System.out.println("Clicking on element: " + element);
        String stepName = "Clicked on element: " + element;
        waitClickable(element);
        softAssertTrue(element.isEnabled());
        takeScreenShot(stepName);
    }

    @Override
    public void afterClick(WebElement element) {
        System.out.println("Clicked on element: " + element);
        String stepName = "Clicked on element: " + element;
        takeScreenShot(stepName);
    }

    @Override
    public void beforeIsSelected(WebElement element) {
        System.out.println("Checking if element is selected: " + element);
        String stepName = "Clicked on element: " + element;
        waitVisibility(element);
        softAssertTrue(element.isEnabled());
        takeScreenShot(stepName);
        
    }

    @Override
    public void afterIsSelected(WebElement element, boolean selected) {
        System.out.println("Element is selected: " + element + " - " + selected);
        String stepName = "Clicked on element: " + element;
        takeScreenShot(stepName);
    }

    @Override
    public void beforeGet(WebDriver driver, String url) {
        System.out.println("Navigating to URL: " + url);
        String stepName = "Clicked on element: " + url;
        takeScreenShot(stepName);
    }

    @Override
    public void afterGet(WebDriver driver, String url) {
        System.out.println("Navigated to URL: " + url);
        String stepName = "Clicked on element: " + url;
        takeScreenShot(stepName);
    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        String stepName = "SendKeys to element: " + element + " - Keys: " + String.join(", ", keysToSend); 
        System.out.println("Sending keys to element: " + element + " - Keys: " + String.join(", ", keysToSend));
        waitClickable(element);
        softAssertTrue(element.isEnabled());
        takeScreenShot(stepName);
        
    }

    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        String stepName = "SendKeys to element: " + element;
        System.out.println("Sent keys to element: " + element + " - Keys: " + String.join(", ", keysToSend));
        takeScreenShot(stepName);
    }

    @Override
    public void beforeGetText(WebElement element) {
        System.out.println("Getting text from element: " + element);
        String stepName = "Getting text from element: " + element;
        waitVisibility(element);
        takeScreenShot(stepName);
    }

    @Override
    public void beforeIsEnabled(WebElement element) {
        System.out.println("Checking if element is enabled: " + element);
        String stepName = "Checking if element is enabled: " + element;
        waitVisibility(element);
        softAssertTrue(element.isDisplayed());
        takeScreenShot(stepName);
    }

    @Override
    public void afterIsEnabled(WebElement element, boolean result) {
        System.out.println("Element is enabled: " + element + " - " + result);
        String stepName = "Checking if element is enabled: " + element;
        takeScreenShot(stepName);
    }

    @Override
    public void beforeIsDisplayed(WebElement element) {
        System.out.println("Checking if element is displayed: " + element);
        String stepName = "Checking if element is displayed: " + element;
        takeScreenShot(stepName);
    }

    @Override
    public void afterIsDisplayed(WebElement element, boolean result) {
        System.out.println("Element is enabled: " + element + " - " + result);
        String stepName = "Checking if element is enabled: " + element;
        takeScreenShot(stepName);
    }

}