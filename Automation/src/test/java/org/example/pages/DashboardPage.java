package org.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DashboardPage {

    private Page page;

    public DashboardPage(Page page) {
        this.page = page;
    }

    public boolean isTimeAtWorkVisible() {
        Locator timeAtWork = page.locator("p:has-text('Time at Work')");
        timeAtWork.waitFor();
        return timeAtWork.isVisible();
    }

    public boolean isMyActionsVisible() {
        Locator myActions = page.locator("p:has-text('My Actions')");
        myActions.waitFor();
        return myActions.isVisible();
    }

    public boolean isQuickLaunchVisible() {
        Locator quickLaunch = page.locator("p:has-text('Quick Launch')");
        quickLaunch.waitFor();
        return quickLaunch.isVisible();
    }

    public boolean isBuzzVisible() {
        Locator buzz = page.locator("p:has-text('Buzz Latest Posts')");
        buzz.waitFor();
        return buzz.isVisible();
    }

    public boolean isEmployeeOnLeaveTodayVisible() {
        Locator employeesOnLeaveToday = page.locator("p:has-text('Employees on Leave Today')");
        employeesOnLeaveToday.waitFor();
        return employeesOnLeaveToday.isVisible();
    }

    public boolean isEmployeeDistributionBySubUnitVisible() {
        Locator employeeDistributionBySubUnit = page.locator("p:has-text('Employee Distribution by Sub Unit')");
        employeeDistributionBySubUnit.waitFor();
        return employeeDistributionBySubUnit.isVisible();
    }

    public boolean isEmployeeDistributionByLocationVisible() {
        Locator employeeDistributionByLocation = page.locator("p:has-text('Employee Distribution by Location')");
        employeeDistributionByLocation.waitFor();
        return employeeDistributionByLocation.isVisible();
    }

    public boolean isAdminButtonVisible() {
        return page.locator(".oxd-main-menu-item")
                .filter(new Locator.FilterOptions().setHasText("Admin"))
                .isVisible();
    }

    public boolean isPimVisible() {
        return page.locator(".oxd-main-menu-item")
                .filter(new Locator.FilterOptions().setHasText("PIM"))
                .isVisible();
    }

    public boolean isLeaveVisible() {
        Locator leave = page.locator(".oxd-main-menu-item")
                .filter(new Locator.FilterOptions().setHasText("Leave"));
        leave.waitFor();
        return leave.isVisible();
    }

    public boolean isTimeVisible() {
        Locator time = page.locator(".oxd-main-menu-item")
                .filter(new Locator.FilterOptions().setHasText("Time"));
        time.waitFor();
        return time.isVisible();
    }

    public boolean isRecruitmentVisible() {
        Locator recruitment = page.locator(".oxd-main-menu-item")
                .filter(new Locator.FilterOptions().setHasText("Recruitment"));
        recruitment.waitFor();
        return recruitment.isVisible();
    }

    public boolean isMyInfoVisible() {
        Locator myInfo = page.locator(".oxd-main-menu-item")
                .filter(new Locator.FilterOptions().setHasText("My Info"));
        myInfo.waitFor();
        return myInfo.isVisible();
    }

    public boolean isPerformanceVisible() {
        Locator performance = page.locator(".oxd-main-menu-item")
                .filter(new Locator.FilterOptions().setHasText("Performance"));
        performance.waitFor();
        return performance.isVisible();
    }

    public boolean isDashboardVisible() {
        Locator dashboard = page.locator(".oxd-main-menu-item")
                .filter(new Locator.FilterOptions().setHasText("Dashboard"));
        dashboard.waitFor();
        return dashboard.isVisible();
    }

    public boolean isDirectoryVisible() {
        Locator directory = page.locator(".oxd-main-menu-item")
                .filter(new Locator.FilterOptions().setHasText("Directory"));
        directory.waitFor();
        return directory.isVisible();
    }

    public boolean isMaintenanceVisible() {
        Locator maintenance = page.locator(".oxd-main-menu-item")
                .filter(new Locator.FilterOptions().setHasText("Maintenance"));
        maintenance.waitFor();
        return maintenance.isVisible();
    }

    public boolean isClaimVisible() {
        Locator claim = page.locator(".oxd-main-menu-item")
                .filter(new Locator.FilterOptions().setHasText("Claim"));
        claim.waitFor();
        return claim.isVisible();
    }

    public boolean isBuzzMenuVisible() {
        Locator buzz = page.locator(".oxd-main-menu-item")
                .filter(new Locator.FilterOptions().setHasText("Buzz"));
        buzz.waitFor();
        return buzz.isVisible();
    }

    public void clickOnPIM() {
        page.locator(".oxd-main-menu-item")
                .filter(new Locator.FilterOptions().setHasText("PIM"))
                .click();
    }

}
