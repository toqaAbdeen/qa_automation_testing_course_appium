package mainTesting;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MathematicalCalculations extends Parameters {

	Actions operation = new Actions();

	@BeforeTest
	public void setup() {
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 9 API 28");
		caps.setCapability(MobileCapabilityType.APP,
				System.getProperty("user.dir") + File.separator + "APP" + File.separator + "calculator.apk");
	}

	@Test()
	public void Opterations() throws MalformedURLException {

		var appiumServerUrl = URI.create("http://127.0.0.1:4723/wd/hub").toURL();
		driver = new AndroidDriver(appiumServerUrl, caps);
		operation.calculateForTwoNumbers("sub", "8", "1");
		operation.takeScreenShot();
		
		operation.calculateForTwoNumbers("mul", "8", "1");
		operation.takeScreenShot();
		
		operation.calculateForOneNumbers("sqrt", "9");
		operation.takeScreenShot();

		operation.calculateForTwoNumbers("pow", "8", "2");
		operation.takeScreenShot();

		operation.calculateForOneNumbers("fact", "5");
		operation.takeScreenShot();
	}

	@AfterTest
	public void afterTest() {

	}

}
