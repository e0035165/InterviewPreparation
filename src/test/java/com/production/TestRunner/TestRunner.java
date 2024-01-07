package com.production.TestRunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/WhatsappMobile",glue= {"com.stepdefinitions"},
monochrome=true, plugin= {"pretty","html:target/HtmlReports"},
tags="@Registration_test_process")
//html:target/HtmlReports
//junit:target/JUnitReports/report.xml
//json:target/reports/cucmber.json
public class TestRunner {
	@AfterClass
	public static void writeExtentReport() {
		
	}

}
