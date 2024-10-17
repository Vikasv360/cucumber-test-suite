package stepDefinitions;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import utils.ResusableTestComponents;

public class Hooks {
	ResusableTestComponents testdriver;

	public Hooks(ResusableTestComponents testdriver) {
		this.testdriver = testdriver;
	}

	@After
	public void afterScenarioExecution() {

		testdriver.testBase.webDriverManager().quit();

	}

	public void takeScreenshot(Scenario scenario) throws IOException {

		WebDriver driver = testdriver.testBase.webDriverManager();

		if (scenario.isFailed()) {

			File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "image");

		}

	}

}
