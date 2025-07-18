package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    // ==== LOGIN FORM ELEMENTS ====
    
    // Email input field
    @FindBy(id = "Email")
    public static WebElement emailField;
    
    // Alternative locator for email
    @FindBy(css = "input.email")
    public static WebElement email;
    
    // Password input field
    @FindBy(id = "Password")
    public static WebElement passwordField;
    
    // Alternative locator for password
    @FindBy(css = "input.password")
    public static WebElement password;
    
    // Remember me checkbox
    @FindBy(id = "RememberMe")
    public static WebElement rememberMeCheckbox;
    
    // Login button
    @FindBy(css = "input.button-1.login-button")
    public static WebElement loginButton;
    
    // Alternative login button locator
    @FindBy(css = "input[type='submit'][value='Log in']")
    public static WebElement submitLoginButton;
    
    // Forgot password link
    @FindBy(linkText = "Forgot password?")
    public static WebElement forgotPasswordLink;
    
    // Alternative forgot password locator
    @FindBy(css = "a[href='/passwordrecovery']")
    public static WebElement forgotPasswordLinkAlt;
    
    // ==== PAGE ELEMENTS ====
    
    // Page title
    @FindBy(css = ".page-title h1")
    public static WebElement pageTitle;
    
    // Login page heading
    @FindBy(xpath = "//h1[text()='Welcome, Please Sign In!']")
    public static WebElement welcomeHeading;
    
    // Error message container
    @FindBy(css = ".message-error")
    public static WebElement errorMessageContainer;
    
    // Validation messages
    @FindBy(css = "span[data-valmsg-for='Email']")
    public static WebElement emailValidationMessage;
    
    @FindBy(css = "span[data-valmsg-for='Password']")
    public static WebElement passwordValidationMessage;
    
    // ==== REGISTRATION SECTION ====
    
    // New Customer section
    @FindBy(css = ".new-wrapper.register-block .title strong")
    public static WebElement newCustomerTitle;
    
    // Register button
    @FindBy(css = "input.button-1.register-button")
    public static WebElement registerButton;
    
    // Alternative register button
    @FindBy(css = "input[onclick=\"location.href='/register'\"]")
    public static WebElement registerButtonAlt;
    
    // Returning Customer section
    @FindBy(css = ".returning-wrapper .title strong")
    public static WebElement returningCustomerTitle;
    
    // ==== FORM LABELS ====
    
    @FindBy(css = "label[for='Email']")
    public static WebElement emailLabel;
    
    @FindBy(css = "label[for='Password']")
    public static WebElement passwordLabel;
    
    @FindBy(css = "label[for='RememberMe']")
    public static WebElement rememberMeLabel;
    
    // ==== ADDITIONAL CONTENT ====
    
    // About login/registration section
    @FindBy(css = ".topic-html-content-title h2")
    public static WebElement aboutLoginHeader;
    
    @FindBy(css = ".topic-html-content-body p")
    public static WebElement aboutLoginContent;
}