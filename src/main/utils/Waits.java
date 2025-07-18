package utils;

import static base.Base.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Waits {

	private Waits() { } 

    //Fluent wait for page title
	public static void waitTitle(String title) {
		try {
			new FluentWait<>(getDr())
				.withTimeout(java.time.Duration.ofSeconds(10))
				.pollingEvery(java.time.Duration.ofMillis(500))
				.ignoring(Exception.class)
				.until(ExpectedConditions.titleIs(title));
		} catch (Exception e) {
			//logger(e);
		}
	}
	
	//Fluent wait for page title contains
	
	public static void waitTitleContains(String title) {
		try {
			new FluentWait<>(getDr())
				.withTimeout(java.time.Duration.ofSeconds(10))
				.pollingEvery(java.time.Duration.ofMillis(500))
				.ignoring(Exception.class)
				.until(ExpectedConditions.titleContains(title));
		} catch (Exception e) {
			//logger(e);
		}
	}

	public static void waitVisibility(WebElement element) {
		try {
			new FluentWait<>(getDr())
				.withTimeout(java.time.Duration.ofSeconds(30))
				.pollingEvery(java.time.Duration.ofMillis(500))
				.ignoring(Exception.class)
				.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			//logger(e);
		}
	}

	// Wait for elements to be clickable
	public static void waitClickable(WebElement element) {
		try {
			new FluentWait<>(getDr())
				.withTimeout(java.time.Duration.ofSeconds(30))
				.pollingEvery(java.time.Duration.ofMillis(500))
				.ignoring(Exception.class)
				.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			//logger(e);
		}
	}
    
}
