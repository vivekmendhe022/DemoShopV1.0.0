package com.generic.utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class WebDriverUtility {

	public void maximiseWindow(WebDriver d) {
		d.manage().window().maximize();
	}

	public void waitForPageLoad(WebDriver d) {
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public String takeScreenShot(WebDriver d, String scrname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) d;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshots\\" + scrname + ".png");
		Files.copy(src, dst);
		return dst.getAbsolutePath();
	}

}
