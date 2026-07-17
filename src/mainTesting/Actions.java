package mainTesting;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Actions extends Parameters {
	public void addTwoNumbers(String num1, String num2) {

		driver.findElement(By.id("com.google.android.calculator:id/digit_" + num1)).click();
		driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_" + num2)).click();
		driver.findElement(By.id("com.google.android.calculator:id/eq")).click();

	}

	public void takeScreenShot() {
		Random randomNumber = new Random();
		int number = randomNumber.nextInt(1000);
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationpath = System.getProperty("user.dir") + File.separator + "screenShots" + File.separator
				+ number + ".png";

		File finalDestination = new File(destinationpath);

		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}
}
