package pages;

import org.openqa.selenium.*;
import java.util.List;

import static pages.Base_Page.*;
import static pages.Base_Page.LocatorType.*;

import static base.Base.*;

public class HomePage {

    private static WebDriver driver = getDr();

    // ==== HEADER ELEMENTS ====
    public static WebElement logo = findBy(css, ".header-logo img");
    public static WebElement registerLink = findBy(css, "a.ico-register");
    public static WebElement loginURL = findBy(css, "a.ico-login");
    public static WebElement shoppingCartLink = findBy(css, "a.ico-cart");
    public static WebElement wishlistLink = findBy(css, "a.ico-wishlist");
    public static WebElement cartQuantity = findBy(css, ".cart-qty");
    public static WebElement wishlistQuantity = findBy(css, ".wishlist-qty");

    // ==== SEARCH ELEMENTS ====
    public static WebElement searchBox = findBy(id, "small-searchterms");
    public static WebElement searchButton = findBy(css, "input.button-1.search-box-button");
    public static WebElement searchSubmitButton = findBy(css, "input[type='submit'][value='Search']");

    // ==== NAVIGATION MENU ====
    public static WebElement topMenu = findBy(css, ".top-menu");
    // For dynamic category links, keep as method
    public static WebElement getTopMenuCategories(String category_name) {
        return findBy(linkText, category_name);
    }
    public static WebElement getComputerSub_Categories(String category_name) {
        return findBy(linkText, category_name);
    }

    // ==== SIDEBAR ELEMENTS ====
    public static WebElement categoriesTitle = findBy(css, ".block-category-navigation .title strong");
    public static WebElement categoriesList = findBy(css, ".block-category-navigation .list");
    public static WebElement manufacturersTitle = findBy(css, ".block-manufacturer-navigation .title strong");
    public static WebElement tricentisLink = findBy(linkText, "Tricentis");
    public static WebElement newsletterTitle = findBy(css, ".block-newsletter .title strong");
    public static WebElement newsletterEmailInput = findBy(id, "newsletter-email");
    public static WebElement newsletterSubscribeButton = findBy(id, "newsletter-subscribe-button");
    public static WebElement newsletterSubscribeButtonAlt = findBy(css, ".button-1.newsletter-subscribe-button");

    // ==== FOOTER ELEMENTS ====
    public static WebElement informationFooterTitle = findBy(css, ".footer .column.information h3");
    public static WebElement customerServiceFooterTitle = findBy(css, ".footer .column.customer-service h3");
    public static WebElement myAccountFooterTitle = findBy(css, ".footer .column.my-account h3");
    public static WebElement followUsFooterTitle = findBy(css, ".footer .column.follow-us h3");
    public static WebElement sitemapLink = findBy(linkText, "Sitemap");
    public static WebElement shippingReturnsLink = findBy(linkText, "Shipping & Returns");
    public static WebElement privacyNoticeLink = findBy(linkText, "Privacy Notice");
    public static WebElement conditionsOfUseLink = findBy(linkText, "Conditions of Use");
    public static WebElement aboutUsLink = findBy(linkText, "About us");
    public static WebElement contactUsLink = findBy(linkText, "Contact us");
    public static WebElement facebookLink = findBy(css, ".facebook a");
    public static WebElement twitterLink = findBy(css, ".twitter a");
    public static WebElement youtubeLink = findBy(css, ".youtube a");
    public static WebElement googlePlusLink = findBy(css, ".google-plus a");

    // ==== NOTIFICATION ELEMENTS ====
    public static WebElement successNotification = findBy(id, "dialog-notifications-success");
    public static WebElement errorNotification = findBy(id, "dialog-notifications-error");
    public static WebElement barNotification = findBy(id, "bar-notification");

    // ==== MOBILE ELEMENTS ====
    public static WebElement mobileMenuButton = findBy(id, "mob-menu-button");
    public static WebElement mobileTopMenu = findBy(css, ".mob-top-menu");

    // ==== LISTS FOR BULK OPERATIONS ====
    public List<WebElement> allTopMenuLinks() {
        return driver.findElements(By.cssSelector(".top-menu > li > a"));
    }

    public List<WebElement> allHeaderLinks() {
        return driver.findElements(By.cssSelector(".header-links ul li a"));
    }

    public List<WebElement> allFooterLinks() {
        return driver.findElements(By.cssSelector(".footer a"));
    }
}