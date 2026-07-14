package org.example.pages;

import com.microsoft.playwright.Page;

public class AddEmployeePage {

    private Page page;

    public AddEmployeePage(Page page) {
        this.page = page;
    }

    public void enterFirstName(String firstName) {
        page.locator("[name='firstName']").fill(firstName);
    }

    public void enterMiddleName(String middleName) {
        page.locator("[name='middleName']").fill(middleName);
    }

    public void enterLastName(String lastName) {
        page.locator("[name='lastName']").fill(lastName);
    }

    public void clickOnSaveButton() {
        page.getByRole(
                com.microsoft.playwright.options.AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Save")
        ).click();

    }
    public void enterEmployeeId(String employeeId) {
        page.locator("(//input[@class='oxd-input oxd-input--active'])[2]").fill(employeeId);
    }

    public void addEmployee(String firstName,
                            String middleName,
                            String lastName,
                            String employeeId) {

        enterFirstName(firstName);
        enterMiddleName(middleName);
        enterLastName(lastName);
        enterEmployeeId(employeeId);
        clickOnSaveButton();
    }

    public boolean isFirstNameRequiredDisplayed() {
        return page.locator("text=Required").first().isVisible();
    }

    public boolean isLastNameRequiredDisplayed() {
        return page.locator("text=Required").last().isVisible();
    }

    public String getDuplicateEmployeeIdMessage() {
        return page.locator(".oxd-input-field-error-message").textContent();
    }



}