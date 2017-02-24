package com.restapi.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions( features = "src/test/resources/features/Sample.feature",plugin={"json:target/cucumber-report/cucumber.json",
"html:target/cucumber-report/cucumber-reports"})
public class RunnerTest {
}
