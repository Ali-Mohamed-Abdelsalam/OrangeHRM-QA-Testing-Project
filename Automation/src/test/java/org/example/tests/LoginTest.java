package org.example.tests;

import org.example.base.BaseTest;
import org.example.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    //Declaration and private to make only LoginTest can access to it
    private LoginPage loginPage;

    //before starting the testcases this will be happened
    @BeforeEach
    // Create LoginPage object and pass the Page object from BaseTest.
    public void initializePages() {
        loginPage = new LoginPage(page);
    }

    @Test
    public void loginWithValidCredentials(){

        createTest("TC_001 - Login With Valid Credentials");
        System.out.println("CREATE TEST 001");

        description("Verify that the user can login using a valid username and password.");

        testSteps(
                "1. Open the browser.\n" +
                        "2. Navigate to OrangeHRM website.\n" +
                        "3. Enter a valid username.\n" +
                        "4. Enter a valid password.\n" +
                        "5. Click the Login button."
        );

        expected("User should be redirected to the dashboard.");

        loginPage.login("Admin" , "admin123");

        //using this function cause we had a Race Condition "Timing Issue"
        page.waitForURL("**/dashboard/**");

        actual("User redirected to: " + loginPage.getCurrentUrl());

        assertTrue(loginPage.getCurrentUrl().contains("/dashboard"));

        pass("Test Passed");
    }

    @Test
    public void loginWithInvalidCredentials() {

        createTest("TC_002 - Login With Invalid Credentials");

        description("Verify that the system displays an error message when both username and password are invalid.");

        testSteps(
                "1. Open the browser.\n" +
                        "2. Navigate to OrangeHRM website.\n" +
                        "3. Enter an invalid username.\n" +
                        "4. Enter an invalid password.\n" +
                        "5. Click the Login button."
        );

        expected("Invalid credentials message should be displayed.");

        loginPage.login("Ali" , "Ali123");

        actual(loginPage.getErrorMessage());

        assertEquals("Invalid credentials", loginPage.getErrorMessage());

        pass("Test Passed");
    }

    @Test
    public void loginWithValidUsernameAndInvalidPassword(){

        createTest("TC_003 - Valid Username And Invalid Password");

        description("Verify that the user cannot login with a valid username and invalid password.");

        testSteps(
                "1. Open the browser.\n" +
                        "2. Navigate to OrangeHRM website.\n" +
                        "3. Enter a valid username.\n" +
                        "4. Enter an invalid password.\n" +
                        "5. Click the Login button."
        );

        expected("Invalid credentials message should be displayed.");

        loginPage.login("Admin" , "1234");

        actual(loginPage.getErrorMessage());

        assertEquals("Invalid credentials", loginPage.getErrorMessage());

        pass("Test Passed");
    }

    @Test
    public void loginWithInvalidUsernameAndValidPassword(){

        createTest("TC_004 - Invalid Username And Valid Password");

        description("Verify that the user cannot login with an invalid username and valid password.");

        testSteps(
                "1. Open the browser.\n" +
                        "2. Navigate to OrangeHRM website.\n" +
                        "3. Enter an invalid username.\n" +
                        "4. Enter a valid password.\n" +
                        "5. Click the Login button."
        );

        expected("Invalid credentials message should be displayed.");

        loginPage.login("Ali" , "admin123");

        actual(loginPage.getErrorMessage());

        assertEquals("Invalid credentials", loginPage.getErrorMessage());

        pass("Test Passed");
    }

    @Test
    public void loginWithEmptyUsernameBlock(){

        createTest("TC_005 - Empty Username");

        description("Verify that username is required.");

        testSteps(
                "1. Open the browser.\n" +
                        "2. Navigate to OrangeHRM website.\n" +
                        "3. Leave the username field empty.\n" +
                        "4. Enter any password.\n" +
                        "5. Click the Login button."
        );

        expected("Required message should appear under username field.");

        loginPage.login("" , "admin123");

        actual(loginPage.getUsernameRequiredMessage());

        assertEquals("Required", loginPage.getUsernameRequiredMessage());

        pass("Test Passed");
    }

    @Test
    public void loginWithEmptyPasswordBlock(){

        createTest("TC_006 - Empty Password");

        description("Verify that password is required.");

        testSteps(
                "1. Open the browser.\n" +
                        "2. Navigate to OrangeHRM website.\n" +
                        "3. Enter a valid username.\n" +
                        "4. Leave the password field empty.\n" +
                        "5. Click the Login button."
        );

        expected("Required message should appear under password field.");

        loginPage.login("Admin" , "");

        actual(loginPage.getPasswordRequiredMessage());

        assertEquals("Required", loginPage.getPasswordRequiredMessage());

        pass("Test Passed");
    }

    @Test
    public void loginWithEmptyUsernameAndPasswordBlocks(){

        createTest("TC_007 - Empty Username And Password");

        description("Verify that both username and password are mandatory.");

        testSteps(
                "1. Open the browser.\n" +
                        "2. Navigate to OrangeHRM website.\n" +
                        "3. Leave both username and password fields empty.\n" +
                        "4. Click the Login button."
        );

        expected("Required message should appear for both fields.");

        loginPage.login("" , "");

        actual("Username: "
                + loginPage.getUsernameRequiredMessage()
                + " | Password: "
                + loginPage.getPasswordRequiredMessage());

        assertEquals("Required", loginPage.getUsernameRequiredMessage());
        assertEquals("Required", loginPage.getPasswordRequiredMessage());

        pass("Test Passed");
    }

    @Test
    public void navigateToForgotYourPasswordPage() {

        createTest("TC_008 - Navigate To Forgot Password");

        description("Verify that clicking on Forgot Your Password navigates to the reset password page.");

        testSteps(
                "1. Open the browser.\n" +
                        "2. Navigate to OrangeHRM website.\n" +
                        "3. Click on the 'Forgot your password?' link."
        );

        expected("User should be redirected to Forgot Password page.");

        loginPage.clickOnForgotYourPassword();

        actual(loginPage.getCurrentUrl());

        assertTrue(loginPage.getCurrentUrl().contains("/requestPasswordResetCode"));

        pass("Test Passed");
    }

}