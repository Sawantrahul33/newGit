package com.envision;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/",glue = {"classpath:stepDefinitions"},tags = "@regression")
public class BaseRunner extends AbstractTestNGCucumberTests {
}
