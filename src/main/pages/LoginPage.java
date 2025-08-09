package pages;

import org.openqa.selenium.*;
import static pages.Base_Page.*;

import static pages.Base_Page.LocatorType.*;

public class LoginPage {

    // ==== LOGIN FORM ELEMENTS ====
    public static WebElement emailField = findBy(id, "Email");
    public static WebElement email = findBy(css, "input.email");
    public static WebElement passwordField = findBy(id, "Password");
    public static WebElement password = findBy(css, "input.password");
    public static WebElement rememberMeCheckbox = findBy(id, "RememberMe");
    public static WebElement loginButton = findBy(css, "input.button-1.login-button");
    public static WebElement submitLoginButton = findBy(css, "input[type='submit'][value='Log in']");
    public static WebElement forgotPasswordLink = findBy(linkText, "Forgot password?");
    public static WebElement forgotPasswordLinkAlt = findBy(css, "a[href='/passwordrecovery']");

    // ==== PAGE ELEMENTS ====
    public static WebElement pageTitle = findBy(css, ".page-title h1");
    public static WebElement welcomeHeading = findBy(xpath, "//h1[text()='Welcome, Please Sign In!']");
    public static WebElement errorMessageContainer = findBy(css, ".message-error");
    public static WebElement emailValidationMessage = findBy(css, "span[data-valmsg-for='Email']");
    public static WebElement passwordValidationMessage = findBy(css, "span[data-valmsg-for='Password']");

    // ==== REGISTRATION SECTION ====
    public static WebElement newCustomerTitle = findBy(css, ".new-wrapper.register-block .title strong");
    public static WebElement registerButton = findBy(css, "input.button-1.register-button");
    public static WebElement registerButtonAlt = findBy(css, "input[onclick=\"location.href='/register'\"]");
    public static WebElement returningCustomerTitle = findBy(css, ".returning-wrapper .title strong");

    // ==== FORM LABELS ====
    public static WebElement emailLabel = findBy(css, "label[for='Email']");
    public static WebElement passwordLabel = findBy(css, "label[for='Password']");
    public static WebElement rememberMeLabel = findBy(css, "label[for='RememberMe']");

    // ==== ADDITIONAL CONTENT ====
    public static WebElement aboutLoginHeader = findBy(css, ".topic-html-content-title h2");
    public static WebElement aboutLoginContent = findBy(css, ".topic-html-content-body p");
}