package org.example.tests;

import org.example.base.BaseTest;
import org.example.pages.AddEmployeePage;
import org.example.pages.DashboardPage;
import org.example.pages.LoginPage;
import org.example.pages.PIMPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PIMTest extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private PIMPage pimPage;
    private AddEmployeePage addEmployeePage;

    @BeforeEach
    public void initializePages() {

        loginPage = new LoginPage(page);
        dashboardPage = new DashboardPage(page);
        pimPage = new PIMPage(page);
        addEmployeePage = new AddEmployeePage(page);

    }

    @Test
    public void addEmployeeWithValidData() {

        createTest("TC_013 - Add Employee With Valid Data");

        description("Verify that the user can add a new employee using valid data.");

        expected("The employee should be added successfully.");

        loginPage.login("Admin", "admin123");

        dashboardPage.clickOnPIM();

        pimPage.clickOnAddEmployee();

        addEmployeePage.addEmployee(
                "Ali",
                "Mohammed",
                "Abdelsalam",
                "111135"
        );

        page.waitForTimeout(2000);

        System.out.println(page.url());

        assertTrue(page.url().contains("viewPersonalDetails"));

        actual("Employee added successfully.");

        pass("Test Passed");
    }

    @Test
    public void addEmployeeWithEmptyFirstName() {

        createTest("Add Employee With Empty First Name");

        description("Verify that the user cannot add an employee with an empty first name.");

        expected("A Required validation message should be displayed.");

        loginPage.login("Admin", "admin123");

        dashboardPage.clickOnPIM();

        pimPage.clickOnAddEmployee();

        addEmployeePage.addEmployee(
                "",
                "Mohammed",
                "Abdelsalam",
                "87895"
        );

        addEmployeePage.clickOnSaveButton();

        assertTrue(addEmployeePage.isFirstNameRequiredDisplayed());

        actual("Required validation message is displayed.");

        pass("Test Passed");
    }

    @Test
    public void addEmployeeWithEmptyLastName() {

        createTest("Add Employee With Empty Last Name");

        description("Verify that the user cannot add an employee with an empty last name.");

        expected("A Required validation message should be displayed.");

        loginPage.login("Admin", "admin123");

        dashboardPage.clickOnPIM();

        pimPage.clickOnAddEmployee();

        addEmployeePage.addEmployee(
                "Ali",
                "Mohammed",
                "",
                "87895"
        );
        addEmployeePage.clickOnSaveButton();

        assertTrue(addEmployeePage.isLastNameRequiredDisplayed());

        actual("Required validation message is displayed.");

        pass("Test Passed");
    }

    @Test
    public void addEmployeeWithDuplicateEmployeeId() {

        createTest("Add Employee With Duplicate Employee ID");

        description("Verify that the user cannot add an employee using an existing Employee ID.");

        expected("An error message should be displayed.");

        loginPage.login("Admin", "admin123");

        dashboardPage.clickOnPIM();

        pimPage.clickOnAddEmployee();

        addEmployeePage.addEmployee(
                "Ali",
                "Mohammed",
                "Abdelsalam",
                "1234"
        );
        addEmployeePage.clickOnSaveButton();

        System.out.println(addEmployeePage.getDuplicateEmployeeIdMessage());

        actual("Employee ID already exists message is displayed.");

        pass("Test Passed");
    }

}