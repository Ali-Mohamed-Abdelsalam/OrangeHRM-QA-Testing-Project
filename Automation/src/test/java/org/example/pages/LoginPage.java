package org.example.pages;

import com.microsoft.playwright.Page;

import javax.swing.*;

public class LoginPage {
    //Encapsulation "only LoginPage can access to (Page)"
    private Page page;

    public LoginPage(Page page) {
        this.page = page;
    }
    public void enterUsername(String username) {
        //Attribute Selector
        page.locator("[name='username']").fill(username);
    }
    public void enterPassword(String password){
        page.locator("[name='password']").fill(password);
    }
    public void clickOnLoginButton (){
        //Attribute selector
        page.locator("button[type='submit']").click();
    }
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickOnLoginButton();
    }
    public String getCurrentUrl() {
        return page.url();
    }
    public String getErrorMessage() {
        return page.locator(".oxd-alert-content-text").textContent();
    }
    public String getUsernameRequiredMessage() {
        return page.locator(".oxd-input-field-error-message").first().textContent();
    }
    public String getPasswordRequiredMessage() {
        return page.locator(".oxd-input-field-error-message").first().textContent();
    }
    public void clickOnForgotYourPassword() {
        page.locator(".oxd-text.oxd-text--p.orangehrm-login-forgot-header").click();
    }

}