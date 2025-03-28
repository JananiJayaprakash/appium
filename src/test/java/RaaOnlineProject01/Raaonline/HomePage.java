package RaaOnlineProject01.Raaonline;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

//public class HomePage extends CreateAccountPage {
public class HomePage extends Login {
	@Test(priority = 2)
	public void HomePage001() throws MalformedURLException, InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
///Home page..
		try {
			// Check if Home Page is displayed
			WebElement homePage = wait
					.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Home")));
			if (homePage.isDisplayed()) {
				System.out.println("Home Page is displayed successfully.");
			}
		} catch (TimeoutException e) {
			System.out.println("Home Page not found. Checking for pop-up...");
		}

//Pop Up message..
		try {
			// Check for pop-up
			WebElement popup = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView")));
			System.out.println("Toast message checking for popup: " + popup.isDisplayed());
			if (popup.isDisplayed()) {
				System.out.println("Pop-up detected.");
				WebElement closePopup = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//android.widget.ImageView//android.view.View")));
				closePopup.click();
				System.out.println("Pop-up closed.");
			}
		} catch (TimeoutException e) {
			System.out.println("No pop-up found.");
		}
	}
}

	