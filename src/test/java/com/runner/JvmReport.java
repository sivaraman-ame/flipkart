package com.runner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JvmReport {

	public static void generateJVMReport(String jsonLoc) {
		File jvmReport = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Reports");
		List<String> emp = new ArrayList<String>();
		emp.add(jsonLoc);
		Configuration con = new Configuration(jvmReport, "FlipKart mobile Purchase page");
		con.addClassifications("Browser", "Chrome");
		con.addClassifications("OS", "WIndows 10");
		con.addClassifications("BrowserVersion", "89 or later");
		con.addClassifications("Tester", "Sivaraman");

		ReportBuilder builder = new ReportBuilder(emp, con);
		builder.generateReports();
	}
}
