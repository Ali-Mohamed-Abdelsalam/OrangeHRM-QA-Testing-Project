package org.example.pages;

import com.microsoft.playwright.Page;

public class PIMPage {

    private Page page;

    public PIMPage(Page page) {
        this.page = page;
    }

    public void clickOnAddEmployee() {
        page.locator("a:has-text('Add Employee')").click();
    }

}