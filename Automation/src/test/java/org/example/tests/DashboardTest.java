package org.example.tests;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;
import org.example.base.BaseTest;
import org.example.pages.DashboardPage;
import org.example.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DashboardTest extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @BeforeEach
    public void initializePages() {
        loginPage = new LoginPage(page);
        dashboardPage = new DashboardPage(page);
    }

    @Test
    public void verifyAllDashboardWidgetsAreVisible() {

        createTest("TC_011 - Verify All Dashboard Widgets Are Visible");

        description("Verify that all dashboard widgets are displayed successfully after the user logs in.");

        testSteps(
                "1. Open the browser.\n" +
                        "2. Navigate to OrangeHRM website.\n" +
                        "3. Enter a valid username.\n" +
                        "4. Enter a valid password.\n" +
                        "5. Click the Login button.\n" +
                        "6. Verify that all dashboard widgets are displayed."
        );

        expected("All dashboard widgets should be visible.");

        loginPage.login("Admin", "admin123");

        actual("Dashboard loaded successfully and all widgets are displayed.");

        assertTrue(dashboardPage.isTimeAtWorkVisible());

        assertTrue(dashboardPage.isMyActionsVisible());

        assertTrue(dashboardPage.isQuickLaunchVisible());

        assertTrue(dashboardPage.isBuzzVisible());

        assertTrue(dashboardPage.isEmployeeDistributionByLocationVisible());

        assertTrue(dashboardPage.isEmployeeDistributionBySubUnitVisible());

        assertTrue(dashboardPage.isEmployeeOnLeaveTodayVisible());

        pass("Test Passed");
    }

    @Test
    public void verifyAllSidebarItemsAreVisible() {

        loginPage.login("Admin", "admin123");

        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        page.waitForLoadState(LoadState.NETWORKIDLE);

        assertTrue(dashboardPage.isAdminButtonVisible());

        assertTrue(dashboardPage.isPimVisible());

        assertTrue(dashboardPage.isLeaveVisible());

        assertTrue(dashboardPage.isTimeVisible());

        assertTrue(dashboardPage.isRecruitmentVisible());

        assertTrue(dashboardPage.isMyInfoVisible());

        assertTrue(dashboardPage.isPerformanceVisible());

        assertTrue(dashboardPage.isDashboardVisible());

        assertTrue(dashboardPage.isDirectoryVisible());

        assertTrue(dashboardPage.isMaintenanceVisible());

        assertTrue(dashboardPage.isClaimVisible());

        assertTrue(dashboardPage.isBuzzMenuVisible());

    }

    @Test
    public void verifyPageRefreshDoesNotLogOutUser() {

        createTest("TC_022 - Verify Page Refresh Does Not Log Out User");

        description("Verify that refreshing the page after a successful login does not log out the user.");

        expected("The user should remain logged in and stay on the Dashboard page after refreshing the page.");

        testSteps(
                "1. Open OrangeHRM login page.<br>" +
                        "2. Enter a valid username and password.<br>" +
                        "3. Click Login.<br>" +
                        "4. Wait until Dashboard page is loaded.<br>" +
                        "5. Refresh the page.<br>" +
                        "6. Verify that the user is still on the Dashboard page."
        );

        loginPage.login("Admin", "admin123");

        page.reload();

        actual("Current URL: " + page.url());

        assertTrue(page.url().contains("/dashboard"));

        pass("Test Passed");
    }



}
