package pages;

import org.openqa.selenium.*;

import static pages.Base_Page.*;
import static pages.Base_Page.LocatorType.*;

public class LoginPage {

    // ==== LOGIN FORM LOCATORS ====
    private final String emailFieldLocator = "Email"; // id
    private final String emailLocator = "input.email"; // css
    private final String passwordFieldLocator = "Password"; // id
    private final String passwordLocator = "input.password"; // css
    private final String rememberMeCheckboxLocator = "RememberMe"; // id
    private final String loginButtonLocator = "input.button-1.login-button"; // css
    private final String submitLoginButtonLocator = "input[type='submit'][value='Log in']";
    private final String forgotPasswordLinkLocator = "Forgot password?"; // linkText
    private final String forgotPasswordLinkAltLocator = "a[href='/passwordrecovery']"; // css

    // ==== PAGE LOCATORS ====
    private final String pageTitleLocator = ".page-title h1"; // css
    private final String welcomeHeadingLocator = "//h1[text()='Welcome, Please Sign In!']"; // xpath
    private final String errorMessageContainerLocator = ".message-error"; // css
    private final String emailValidationMessageLocator = "span[data-valmsg-for='Email']"; // css
    private final String passwordValidationMessageLocator = "span[data-valmsg-for='Password']"; // css

    // ==== REGISTRATION SECTION ====
    private final String newCustomerTitleLocator = ".new-wrapper.register-block .title strong";
    private final String registerButtonLocator = "input.button-1.register-button";
    private final String registerButtonAltLocator = "input[onclick=\"location.href='/register'\"]";
    private final String returningCustomerTitleLocator = ".returning-wrapper .title strong";

    // ==== FORM LABELS ====
    private final String emailLabelLocator = "label[for='Email']";
    private final String passwordLabelLocator = "label[for='Password']";
    private final String rememberMeLabelLocator = "label[for='RememberMe']";

    // ==== ADDITIONAL CONTENT ====
    private final String aboutLoginHeaderLocator = ".topic-html-content-title h2";
    private final String aboutLoginContentLocator = ".topic-html-content-body p";

    public WebElement emailField() { return findBy(id, emailFieldLocator); }
    public WebElement email() { return findBy(css, emailLocator); }
    public WebElement passwordField() { return findBy(id, passwordFieldLocator); }
    public WebElement password() { return findBy(css, passwordLocator); }
    public WebElement rememberMeCheckbox() { return findBy(id, rememberMeCheckboxLocator); }
    public WebElement loginButton() { return findBy(css, loginButtonLocator); }
    public WebElement submitLoginButton() { return findBy(css, submitLoginButtonLocator); }
    public WebElement forgotPasswordLink() { return findBy(linkText, forgotPasswordLinkLocator); }
    public WebElement forgotPasswordLinkAlt() { return findBy(css, forgotPasswordLinkAltLocator); }

    public WebElement pageTitle() { return findBy(css, pageTitleLocator); }
    public WebElement welcomeHeading() { return findBy(xpath, welcomeHeadingLocator); }
    public WebElement errorMessageContainer() { return findBy(css, errorMessageContainerLocator); }
    public WebElement emailValidationMessage() { return findBy(css, emailValidationMessageLocator); }
    public WebElement passwordValidationMessage() { return findBy(css, passwordValidationMessageLocator); }

    public WebElement newCustomerTitle() { return findBy(css, newCustomerTitleLocator); }
    public WebElement registerButton() { return findBy(css, registerButtonLocator); }
    public WebElement registerButtonAlt() { return findBy(css, registerButtonAltLocator); }
    public WebElement returningCustomerTitle() { return findBy(css, returningCustomerTitleLocator); }

    public WebElement emailLabel() { return findBy(css, emailLabelLocator); }
    public WebElement passwordLabel() { return findBy(css, passwordLabelLocator); }
    public WebElement rememberMeLabel() { return findBy(css, rememberMeLabelLocator); }

    public WebElement aboutLoginHeader() { return findBy(css, aboutLoginHeaderLocator); }
    public WebElement aboutLoginContent() { return findBy(css, aboutLoginContentLocator); }

}