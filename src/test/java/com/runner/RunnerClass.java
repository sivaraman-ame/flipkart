package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\USER\\sivaraman\\Flipkart\\src\\test\\resources\\feature", glue = "com.stepdef", monochrome = true, plugin = {
		"json:target\\JsonReports\\data.json" })

public class RunnerClass {

	@AfterClass
	public static void afterclass() {
		JvmReport.generateJVMReport(System.getProperty("user.dir") + "\\target\\JsonReports\\data.json");

	}

}
