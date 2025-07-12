package utils;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.Keys;

import static base.Hooks.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CommonUtils {

    public static void deleteText(WebElement textBox){
        textBox.clear();
        new Actions(getDr()).
        moveToElement(textBox).
        keyDown(Keys.CONTROL).sendKeys("a").
        sendKeys(Keys.DELETE).
        keyUp(Keys.CONTROL).
        build().
        perform();
    }

    public static void doubleClick(WebElement element){
        new Actions(getDr()).
        contextClick(element);
    }

    public static void scrollToElement(WebElement target){
        new Actions(getDr()).
        moveToElement(target);
    }

    public static void getConfig(String filePath, String key){
        try {
            FileInputStream fis = new FileInputStream(filePath);
            Properties prop = new Properties();
            prop.load(fis);
            prop.getProperty(key);
        }
        catch(Exception e){
            System.out.println();
        }

    }
    
}
