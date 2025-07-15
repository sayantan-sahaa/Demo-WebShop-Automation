package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static hooks.Hooks.*;

public class CommonUtils {

    public static void deleteText(WebElement textBox){
        textBox.clear();
        new Actions(getDr())
            .moveToElement(textBox)
            .keyDown(Keys.CONTROL)
            .sendKeys("a")
            .keyUp(Keys.CONTROL)
            .sendKeys(Keys.DELETE)
            .build()
            .perform();
    }

    public static void doubleClick(WebElement element){
        new Actions(getDr()).
        contextClick(element);
    }

    public static void scrollToElement(WebElement target){
        new Actions(getDr()).
        moveToElement(target);
    }

    public static String getConfig(String fileName, String key) {
        try {
            FileInputStream fis = new FileInputStream(new File("src/"+fileName+".properties"));
            Properties prop = new Properties();
            prop.load(fis);
            return prop.getProperty(key);
        } catch (Exception e) {
            //logger.error("Error reading config file: {}", e.getMessage(), e);
            return null;
        }
    }

    public static void dragnDrop(WebElement source, WebElement target){
        new Actions(getDr()).
        dragAndDrop(source, target).
        build().perform();
    }
    
}
