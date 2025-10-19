package pages;

import org.openqa.selenium.*;
import java.util.List;

import static pages.Base_Page.*;
import static pages.Base_Page.LocatorType.*;
import static base.Base.*;

public class HomePage {

    // ==== HEADER LOCATORS ====
    private final String logoLocator = ".header-logo img";
    private final String registerLinkLocator = "a.ico-register";
    private final String loginURLLocator = "a.ico-login";
    private final String shoppingCartLinkLocator = "a.ico-cart";
    private final String wishlistLinkLocator = "a.ico-wishlist";
    private final String cartQuantityLocator = ".cart-qty";
    private final String wishlistQuantityLocator = ".wishlist-qty";

    // ==== SEARCH LOCATORS ====
    private final String searchBoxLocator = "small-searchterms"; // id
    private final String searchButtonLocator = "input.button-1.search-box-button";
    private final String searchSubmitButtonLocator = "input[type='submit'][value='Search']";

    // ==== NAVIGATION MENU ====
    private final String topMenuLocator = ".top-menu";

    // ==== SIDEBAR LOCATORS ====
    private final String categoriesTitleLocator = ".block-category-navigation .title strong";
    private final String categoriesListLocator = ".block-category-navigation .list";
    private final String manufacturersTitleLocator = ".block-manufacturer-navigation .title strong";
    private final String tricentisLinkLocator = "Tricentis"; // linkText
    private final String newsletterTitleLocator = ".block-newsletter .title strong";
    private final String newsletterEmailInputLocator = "newsletter-email"; // id
    private final String newsletterSubscribeButtonLocator = "newsletter-subscribe-button"; // id
    private final String newsletterSubscribeButtonAltLocator = ".button-1.newsletter-subscribe-button";

    // ==== FOOTER LOCATORS ====
    private final String informationFooterTitleLocator = ".footer .column.information h3";
    private final String customerServiceFooterTitleLocator = ".footer .column.customer-service h3";
    private final String myAccountFooterTitleLocator = ".footer .column.my-account h3";
    private final String followUsFooterTitleLocator = ".footer .column.follow-us h3";
    private final String sitemapLinkLocator = "Sitemap"; // linkText
    private final String shippingReturnsLinkLocator = "Shipping & Returns"; // linkText
    private final String privacyNoticeLinkLocator = "Privacy Notice"; // linkText
    private final String conditionsOfUseLinkLocator = "Conditions of Use"; // linkText
    private final String aboutUsLinkLocator = "About us"; // linkText
    private final String contactUsLinkLocator = "Contact us"; // linkText
    private final String facebookLinkLocator = ".facebook a";
    private final String twitterLinkLocator = ".twitter a";
    private final String youtubeLinkLocator = ".youtube a";
    private final String googlePlusLinkLocator = ".google-plus a";

    // ==== NOTIFICATION LOCATORS ====
    private final String successNotificationLocator = "dialog-notifications-success"; // id
    private final String errorNotificationLocator = "dialog-notifications-error"; // id
    private final String barNotificationLocator = "bar-notification"; // id

    // ==== MOBILE LOCATORS ====
    private final String mobileMenuButtonLocator = "mob-menu-button"; // id
    private final String mobileTopMenuLocator = ".mob-top-menu";

    // ==== LISTS FOR BULK OPERATIONS ====
    public List<WebElement> allTopMenuLinks() {
        return getDr().findElements(By.cssSelector(".top-menu > li > a"));
    }

    public List<WebElement> allHeaderLinks() {
        return getDr().findElements(By.cssSelector(".header-links ul li a"));
    }

    public List<WebElement> allFooterLinks() {
        return getDr().findElements(By.cssSelector(".footer a"));
    }

    public WebElement logo() { return findBy(css, logoLocator); }
    public WebElement registerLink() { return findBy(css, registerLinkLocator); }
    public WebElement loginURL() { return findBy(css, loginURLLocator); }
    public WebElement shoppingCartLink() { return findBy(css, shoppingCartLinkLocator); }
    public WebElement wishlistLink() { return findBy(css, wishlistLinkLocator); }
    public WebElement cartQuantity() { return findBy(css, cartQuantityLocator); }
    public WebElement wishlistQuantity() { return findBy(css, wishlistQuantityLocator); }

    public WebElement searchBox() { return findBy(id, searchBoxLocator); }
    public WebElement searchButton() { return findBy(css, searchButtonLocator); }
    public WebElement searchSubmitButton() { return findBy(css, searchSubmitButtonLocator); }

    public WebElement topMenu() { return findBy(css, topMenuLocator); }
    public WebElement getTopMenuCategories(String category_name) { return findBy(linkText, category_name); }
    public WebElement getComputerSub_Categories(String category_name) { return findBy(linkText, category_name); }

    public WebElement categoriesTitle() { return findBy(css, categoriesTitleLocator); }
    public WebElement categoriesList() { return findBy(css, categoriesListLocator); }
    public WebElement manufacturersTitle() { return findBy(css, manufacturersTitleLocator); }
    public WebElement tricentisLink() { return findBy(linkText, tricentisLinkLocator); }
    public WebElement newsletterTitle() { return findBy(css, newsletterTitleLocator); }
    public WebElement newsletterEmailInput() { return findBy(id, newsletterEmailInputLocator); }
    public WebElement newsletterSubscribeButton() { return findBy(id, newsletterSubscribeButtonLocator); }
    public WebElement newsletterSubscribeButtonAlt() { return findBy(css, newsletterSubscribeButtonAltLocator); }

    public WebElement informationFooterTitle() { return findBy(css, informationFooterTitleLocator); }
    public WebElement customerServiceFooterTitle() { return findBy(css, customerServiceFooterTitleLocator); }
    public WebElement myAccountFooterTitle() { return findBy(css, myAccountFooterTitleLocator); }
    public WebElement followUsFooterTitle() { return findBy(css, followUsFooterTitleLocator); }
    public WebElement sitemapLink() { return findBy(linkText, sitemapLinkLocator); }
    public WebElement shippingReturnsLink() { return findBy(linkText, shippingReturnsLinkLocator); }
    public WebElement privacyNoticeLink() { return findBy(linkText, privacyNoticeLinkLocator); }
    public WebElement conditionsOfUseLink() { return findBy(linkText, conditionsOfUseLinkLocator); }
    public WebElement aboutUsLink() { return findBy(linkText, aboutUsLinkLocator); }
    public WebElement contactUsLink() { return findBy(linkText, contactUsLinkLocator); }
    public WebElement facebookLink() { return findBy(css, facebookLinkLocator); }
    public WebElement twitterLink() { return findBy(css, twitterLinkLocator); }
    public WebElement youtubeLink() { return findBy(css, youtubeLinkLocator); }
    public WebElement googlePlusLink() { return findBy(css, googlePlusLinkLocator); }

    public WebElement successNotification() { return findBy(id, successNotificationLocator); }
    public WebElement errorNotification() { return findBy(id, errorNotificationLocator); }
    public WebElement barNotification() { return findBy(id, barNotificationLocator); }

    public WebElement mobileMenuButton() { return findBy(id, mobileMenuButtonLocator); }
    public WebElement mobileTopMenu() { return findBy(css, mobileTopMenuLocator); }

}