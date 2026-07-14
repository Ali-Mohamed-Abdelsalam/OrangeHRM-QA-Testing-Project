package org.example.pages;

import com.microsoft.playwright.Page;

public class ForgotPasswordPage {

    private Page page;

    public ForgotPasswordPage(Page page) {
        this.page = page;
    }

    public void enterUsername(String username) {
        page.locator("[name='username']").fill(username);
    }

    public void clickOnResetPassword() {
        page.locator("button[type='submit']").click();
    }

    public void clickOnCancelButton() {
        page.locator("button[type='button']").click();
    }

    public String getCurrentUrl() {
        return page.url();
    }

    public String usernameRequiredMessage() {
        return page.locator(".oxd-text.oxd-text--span.oxd-input-field-error-message.oxd-input-group__message")
                .textContent();
    }
//    public String getErrorMessage(){
//
//    }

}

