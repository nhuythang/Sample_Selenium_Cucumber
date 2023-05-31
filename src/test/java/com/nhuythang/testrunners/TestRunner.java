package com.nhuythang.testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={
				"src/test/resources/Features/"
		        },
		glue={"com.aduroplatform.stepsdefinition",
				"com.aduroplatform.base"
		        },
		monochrome=true,
		plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)
public class TestRunner {

}