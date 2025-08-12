package pages;

import static base.Base.getDr;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Base_Page {

    public static enum LocatorType {
        id, name, xpath, css, cssSelector, className, tag, tagName, linkText, partialLinkText
    }

    public static WebElement findBy(LocatorType byType, String locator) {
        try {
            By by;
            switch (byType) {
                case id:
                    by = By.id(locator);
                    break;
                case name:
                    by = By.name(locator);
                    break;
                case xpath:
                    by = By.xpath(locator);
                    break;
                case css:
                case cssSelector:
                    by = By.cssSelector(locator);
                    break;
                case className:
                    by = By.className(locator);
                    break;
                case tag:
                case tagName:
                    by = By.tagName(locator);
                    break;
                case linkText:
                    by = By.linkText(locator);
                    break;
                case partialLinkText:
                    by = By.partialLinkText(locator);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid locator type: " + byType);
            }
            return getDr().findElement(by);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return null;
        }
    }

    public static List <WebElement> findAll(LocatorType byType, String locator){

        By by;

        switch (byType) {
            case id:
                by = By.id(locator);
                break;

            case name:
                by = By.name(locator);
                break;
            case xpath:
                by = By.xpath(locator);
                break;
            case css:
            case cssSelector:
                by = By.cssSelector(locator);
                break;
            case className:
                by = By.className(locator);
                break;
            case tag:
            case tagName:
                by = By.tagName(locator);
                break;
            case linkText:
                by = By.linkText(locator);
                break;
            case partialLinkText:
                by = By.partialLinkText(locator);
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + byType);

            
            
        }

        return getDr().findElements(by);


    }

    public static WebElement find1st(LocatorType byType, String locator){

        By by;

        switch (byType) {
            case id:
                by = By.id(locator);
                break;

            case name:
                by = By.name(locator);
                break;
            case xpath:
                by = By.xpath(locator);
                break;
            case css:
            case cssSelector:
                by = By.cssSelector(locator);
                break;
            case className:
                by = By.className(locator);
                break;
            case tag:
            case tagName:
                by = By.tagName(locator);
                break;
            case linkText:
                by = By.linkText(locator);
                break;
            case partialLinkText:
                by = By.partialLinkText(locator);
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + byType);

            
            
        }

        return getDr().findElements(by).stream().findFirst().orElse(null);


    }
    
}
