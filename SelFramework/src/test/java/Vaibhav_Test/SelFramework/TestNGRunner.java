package Vaibhav_Test.SelFramework;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="D:\\eclipse-java-2023-03-R-win32-x86_64 (1)\\eclipse\\SelFramework\\PurshaseOrder.feature",glue="Vaibhav_Test.SelFramework.TestNGRunner.java",
monochrome=true,plugin= {"html:target/cucumber.html"})
public class TestNGRunner extends AbstractTestNGCucumberTests{

}
