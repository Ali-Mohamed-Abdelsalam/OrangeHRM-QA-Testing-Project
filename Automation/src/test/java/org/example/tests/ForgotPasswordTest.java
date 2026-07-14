package org.example.tests;

import org.example.base.BaseTest;
import org.example.pages.ForgotPasswordPage;
import org.example.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ForgotPasswordTest extends BaseTest {

    private LoginPage loginPage;
    private ForgotPasswordPage forgotPasswordPage;

    @BeforeEach
    public void initializePages() {
        loginPage = new LoginPage(page);
        forgotPasswordPage = new ForgotPasswordPage(page);
    }

//    @Test
//    // "Flaky_Test" This test is blocked due to a known issue in the OrangeHRM demo environment (HTTP 504 Gateway Timeout).
//    public void userCanResetPasswordWithValidUsername() {
//        loginPage.clickOnForgotYourPassword();
//        forgotPasswordPage.enterUsername("Admin");
//        forgotPasswordPage.clickOnResetPassword();
//    }

    @Test
    public void resetPasswordWithEmptyUsername(){

        createTest("TC_009 - Reset Password With Empty Username");

        description("Verify that the system displays a required message when the username field is left empty.");

        testSteps(
                "1. Open the browser.\n" +
                        "2. Navigate to OrangeHRM website.\n" +
                        "3. Click on the 'Forgot your password?' link.\n" +
                        "4. Leave the username field empty.\n" +
                        "5. Click the Reset Password button."
        );

        expected("The system should display 'Required' below the username field.");

        loginPage.clickOnForgotYourPassword();
        forgotPasswordPage.enterUsername("");
        forgotPasswordPage.clickOnResetPassword();

        actual(forgotPasswordPage.usernameRequiredMessage());

        assertEquals("Required", forgotPasswordPage.usernameRequiredMessage());

        pass("Test Passed");
    }

//    @Test
    //Blocked cause there is no error message so there's no Locator for it
//    public void resetPasswordWithInvalidUsername(){
//
//        loginPage.clickOnForgotYourPassword();
//        forgotPasswordPage.enterUsername("Ali");
//        forgotPasswordPage.clickOnResetPassword();
//
//        assertEquals("Required", forgotPasswordPage.getErrorMessage());
//    }

    @Test
    public void userCanCancelResetPasswordOperation(){

        createTest("TC_010 - Cancel Reset Password");

        description("Verify that the user can cancel the reset password operation and return to the login page.");

        testSteps(
                "1. Open the browser.\n" +
                        "2. Navigate to OrangeHRM website.\n" +
                        "3. Click on the 'Forgot your password?' link.\n" +
                        "4. Click the Cancel button."
        );

        expected("The user should be redirected to the Login page.");

        loginPage.clickOnForgotYourPassword();
        forgotPasswordPage.clickOnCancelButton();

        actual(forgotPasswordPage.getCurrentUrl());

        assertTrue(forgotPasswordPage.getCurrentUrl().contains("/auth/login"));

        pass("Test Passed");
    }

}