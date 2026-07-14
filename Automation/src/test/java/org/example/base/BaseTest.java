package org.example.base;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.example.reports.Report;
import org.junit.jupiter.api.extension.ExtendWith;

public class BaseTest {

    // Store the base URL as a constant so it can be changed in one place if needed.
    public static final String BASE_URL =
            "https://opensource-demo.orangehrmlive.com/";
    // Declare Playwright, Browser, and Page variables.
    // They are protected so only classes that inherit from BaseTest can access and use them.
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    protected static ExtentReports extentReports;
    protected ExtentTest test;
    protected BrowserContext context;

    @BeforeAll
    public static void startReport() {
        System.out.println("REPORT CREATED");
        extentReports = Report.createReport();
    }

    @BeforeEach
    public void setup() {

        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );

        page = browser.newPage();

        page.navigate(BASE_URL);
    }

    protected void createTest(String testName) {

        System.out.println("Creating: " + testName);

        test = extentReports.createTest(testName);

        System.out.println(test);
    }

    protected void description(String description) {
        test.info("<b>Description:</b> " + description);
    }

    protected void testSteps(String steps) {
        test.info("<b>Test Steps:</b> " + steps);
    }

    protected void expected(String expected) {
        test.info("<b>Expected Result:</b> " + expected);
    }

    protected void actual(String actual) {
        test.info("<b>Actual Result:</b> " + actual);
    }

    protected void pass(String message) {
        test.pass(message);
    }

    protected void fail(String message) {
        test.fail(message);
    }

    @AfterEach
    public void tearDown() {

        System.out.println("TEARDOWN START");

        try {
            if (browser != null) {
                browser.close();
            }
        } finally {
            if (playwright != null) {
                playwright.close();
            }
        }

        System.out.println("TEARDOWN END");
    }


    @AfterAll
    public static void endReport() {

        if (extentReports != null) {
            extentReports.flush();
        }
    }
}