package com.whitecircleschool.POMWithCucumber2;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "Feature", 
			glue = "com.whitecircleschool.POMWithCucumber2"
			
			
)

public class TestRunner extends AbstractTestNGCucumberTests {

}

