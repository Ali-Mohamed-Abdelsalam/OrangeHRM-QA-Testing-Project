package org.example.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report {

    private static ExtentReports extentReports;

    public static ExtentReports createReport() {

        if (extentReports == null) {

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter("test-output/ExtentReport.html");

            sparkReporter.config().setDocumentTitle("OrangeHRM Automation Report");
            sparkReporter.config().setReportName("OrangeHRM Test Execution Report");
            sparkReporter.config().setTheme(Theme.STANDARD);

            extentReports = new ExtentReports();

            extentReports.attachReporter(sparkReporter);

            extentReports.setSystemInfo("Tester", "Ali Mohammed");
            extentReports.setSystemInfo("Framework", "Playwright");
            extentReports.setSystemInfo("Language", "Java");
            extentReports.setSystemInfo("Testing Framework", "JUnit 5");
            extentReports.setSystemInfo("Browser", "Chromium");
            extentReports.setSystemInfo("Application", "OrangeHRM");
            extentReports.setSystemInfo("Environment", "Demo");
        }

        return extentReports;
    }
}