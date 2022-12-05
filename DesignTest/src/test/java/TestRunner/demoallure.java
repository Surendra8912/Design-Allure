package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = ("src/main/java/DemopetShop"),glue={"Step"},
        tags="",
        plugin={"pretty","json:target/cucumber-report/report.json",
                "html:target/cucumber-report/report.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})

public class demoallure {
}