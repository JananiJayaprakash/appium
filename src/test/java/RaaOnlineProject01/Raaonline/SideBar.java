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

public class SideBar extends Login {
	@Test(priority = 2)
	public void SidebarPage() throws MalformedURLException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(9));

//Home page..
		try {
			// Check if Home Page is displayed
			WebElement homePage = wait
					.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Home")));
			if (homePage.isDisplayed()) {
				System.out.println("Home Page is successfully displayed .");
			}
		} catch (TimeoutException e) {
			System.out.println("Home Page not found. Checking for pop-up...");
		}

// Check for pop-up
		try {
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
// Open the sidebar
		WebElement sidebar = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[1]")));
		sidebar.click();
		System.out.println("Sidebar opened.");
		Thread.sleep(3000);

// Choose speciality...
		// Increase wait time
		WebDriverWait wait01 = new WebDriverWait(driver, Duration.ofSeconds(15));

		try {
			// Wait for the element using XPath (Alternative locator)
			WebElement ChooseSpeciality = wait01.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//android.view.View[contains(@content-desc, 'Choose your Speciality')]")));
			ChooseSpeciality.click();
			System.out.println("Speciality selection successful.");
		} catch (TimeoutException e) {
			System.out.println("Element not found. Printing page source for debugging:");
			System.out.println(driver.getPageSource()); // Debugging step
		}

		System.out.println("Speciality Successfully navigated to Speciality selection page..");
		Thread.sleep(3000);

//Change speciality...
		System.out.println("Click interested speciality");
		WebElement ClickSpeciality = wait
				.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("General Medicine")));
		ClickSpeciality.click();
		System.out.println("Speciality changed successfully");
		Thread.sleep(3000);

//Click Change button...
		System.out.println("After selected interested speciality now click change button");
		WebElement ClickChangeButton = wait
				.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Change")));
		ClickChangeButton.click();
		Thread.sleep(5000);
		System.out.println("Navigate to home page");

// Open the sidebar
		WebElement sidebar01 = wait
				.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)")));
		sidebar01.click();
		System.out.println("Sidebar opened.");
		Thread.sleep(3000);

// Choose Your plan...
		// Increase wait time
		try {
			// Wait for the element using XPath (Alternative locator)
			WebElement ChoosePlan = wait01
					.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Choose your Plan")));
			ChoosePlan.isDisplayed();
			System.out.println("Choose plan successful.");
			WebElement ViewAllPlan = wait01
					.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("View All Plans")));
			ViewAllPlan.click();
			System.out.println("View plan successful loaded.");
			
		} catch (TimeoutException e) {
			System.out.println("Element not found. Printing page source for debugging:");
			System.out.println(driver.getPageSource()); // Debugging step
		}
		System.out.println("Plan Successfully navigated to subscription plan page");
		Thread.sleep(3000);
		
//Go back from Subscription plan page
		System.out.println("Go back from subscription plan page");
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(6)")).click();
		Thread.sleep(5000);
		System.out.println("Navigate to side bar");
		
//Profile
		WebElement ProfilePage = wait
				.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Profile\nKYC Update")));
		ProfilePage.click();
		System.out.println("profile page opened.");
		Thread.sleep(3000);
		

// Quit driver
//		tearDown();
	}
}
