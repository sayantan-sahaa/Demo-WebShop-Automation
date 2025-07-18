package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class HomePage {

    // ==== HEADER ELEMENTS ====
    
    // Logo
    @FindBy(css = ".header-logo img")
    public static WebElement logo;
    
    // Header links
    @FindBy(css = "a.ico-register")
    public static WebElement registerLink;
    
    @FindBy(css = "a.ico-login")
    public static WebElement loginURL;
    
    @FindBy(css = "a.ico-cart")
    public static WebElement shoppingCartLink;
    
    @FindBy(css = "a.ico-wishlist")
    public static WebElement wishlistLink;
    
    // Cart quantity
    @FindBy(css = ".cart-qty")
    public static WebElement cartQuantity;
    
    // Wishlist quantity
    @FindBy(css = ".wishlist-qty")
    public static WebElement wishlistQuantity;
    
    // ==== SEARCH ELEMENTS ====
    
    @FindBy(id = "small-searchterms")
    public static WebElement searchBox;
    
    @FindBy(css = "input.button-1.search-box-button")
    public static WebElement searchButton;
    
    @FindBy(css = "input[type='submit'][value='Search']")
    public static WebElement searchSubmitButton;
    
    // ==== NAVIGATION MENU ====
    
    // Top menu items
    @FindBy(css = ".top-menu")
    public static WebElement topMenu;
    
    @FindBy(linkText = "Books")
    public static WebElement booksLink;
    
    @FindBy(linkText = "Computers")
    public static WebElement computersLink;
    
    @FindBy(linkText = "Electronics")
    public static WebElement electronicsLink;
    
    @FindBy(linkText = "Apparel & Shoes")
    public static WebElement apparelShoesLink;
    
    @FindBy(linkText = "Digital downloads")
    public static WebElement digitalDownloadsLink;
    
    @FindBy(linkText = "Jewelry")
    public static WebElement jewelryLink;
    
    @FindBy(linkText = "Gift Cards")
    public static WebElement giftCardsLink;
    
    // Sub-menu items for Computers
    @FindBy(linkText = "Desktops")
    public static WebElement desktopsLink;
    
    @FindBy(linkText = "Notebooks")
    public static WebElement notebooksLink;
    
    @FindBy(linkText = "Accessories")
    public static WebElement accessoriesLink;
    
    // Sub-menu items for Electronics
    @FindBy(linkText = "Camera, photo")
    public static WebElement cameraPhotoLink;
    
    @FindBy(linkText = "Cell phones")
    public static WebElement cellPhonesLink;
    
    // ==== SIDEBAR ELEMENTS ====
    
    // Categories block
    @FindBy(css = ".block-category-navigation .title strong")
    public static WebElement categoriesTitle;
    
    @FindBy(css = ".block-category-navigation .list")
    public static WebElement categoriesList;
    
    // Manufacturers block
    @FindBy(css = ".block-manufacturer-navigation .title strong")
    public static WebElement manufacturersTitle;
    
    @FindBy(linkText = "Tricentis")
    public static WebElement tricentisLink;
    
    // Newsletter block
    @FindBy(css = ".block-newsletter .title strong")
    public static WebElement newsletterTitle;
    
    @FindBy(id = "newsletter-email")
    public static WebElement newsletterEmailInput;
    
    @FindBy(id = "newsletter-subscribe-button")
    public static WebElement newsletterSubscribeButton;
    
    @FindBy(css = ".button-1.newsletter-subscribe-button")
    public static WebElement newsletterSubscribeButtonAlt;
    
    // ==== FOOTER ELEMENTS ====
    
    // Footer sections
    @FindBy(css = ".footer .column.information h3")
    public static WebElement informationFooterTitle;
    
    @FindBy(css = ".footer .column.customer-service h3")
    public static WebElement customerServiceFooterTitle;
    
    @FindBy(css = ".footer .column.my-account h3")
    public static WebElement myAccountFooterTitle;
    
    @FindBy(css = ".footer .column.follow-us h3")
    public static WebElement followUsFooterTitle;
    
    // Footer links
    @FindBy(linkText = "Sitemap")
    public static WebElement sitemapLink;
    
    @FindBy(linkText = "Shipping & Returns")
    public static WebElement shippingReturnsLink;
    
    @FindBy(linkText = "Privacy Notice")
    public static WebElement privacyNoticeLink;
    
    @FindBy(linkText = "Conditions of Use")
    public static WebElement conditionsOfUseLink;
    
    @FindBy(linkText = "About us")
    public static WebElement aboutUsLink;
    
    @FindBy(linkText = "Contact us")
    public static WebElement contactUsLink;
    
    // Social media links
    @FindBy(css = ".facebook a")
    public static WebElement facebookLink;
    
    @FindBy(css = ".twitter a")
    public static WebElement twitterLink;
    
    @FindBy(css = ".youtube a")
    public static WebElement youtubeLink;
    
    @FindBy(css = ".google-plus a")
    public static WebElement googlePlusLink;
    
    // ==== NOTIFICATION ELEMENTS ====
    
    @FindBy(id = "dialog-notifications-success")
    public static WebElement successNotification;
    
    @FindBy(id = "dialog-notifications-error")
    public static WebElement errorNotification;
    
    @FindBy(id = "bar-notification")
    public static WebElement barNotification;
    
    // ==== MOBILE ELEMENTS ====
    
    @FindBy(id = "mob-menu-button")
    public static WebElement mobileMenuButton;
    
    @FindBy(css = ".mob-top-menu")
    public static WebElement mobileTopMenu;
    
    // ==== LISTS FOR BULK OPERATIONS ====
    
    @FindBy(css = ".top-menu > li > a")
    public static List<WebElement> allTopMenuLinks;
    
    @FindBy(css = ".header-links ul li a")
    public static List<WebElement> allHeaderLinks;
    
    @FindBy(css = ".footer a")
    public static List<WebElement> allFooterLinks;
}