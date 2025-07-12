Feature: Validate Window Title

    Scenario: User sees correct window title after navigating to url
        When the user is on the home page, then the window title should be Demo Web Shop
        Then the user is able to click on login url