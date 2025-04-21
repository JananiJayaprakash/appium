package RaaOnlineProject01.Raaonline;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class VideoPage extends HomePage {

	@Test(priority = 3)
	public void VideoPage01() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
// Free video..
// video page...
		System.out.println("Waiting for Video Page...");
		Thread.sleep(3000);
		WebElement Videopage = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Videos")));
		Videopage.click();
		System.out.println("Video successfully loaded...");
		Thread.sleep(3000);

// subspeciality page...
		System.out.println("Waiting for Subspeciality...");
		Thread.sleep(3000);
		WebElement Subspeciality = wait
				.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("MD/DNB Anesthesia")));
		Subspeciality.click();
		System.out.println("Subspeciality successfully loaded...");
		Thread.sleep(3000);

// course page...
		System.out.println("Waiting for courses...");
		Thread.sleep(3000);
		WebElement coursepage = wait.until(ExpectedConditions.presenceOfElementLocated(
				AppiumBy.accessibilityId("How to be a complete anesthesiologist? \n1 Topics")));
		coursepage.click();
		System.out.println("Courses successfully loaded...");
		Thread.sleep(3000);

// topics...
		System.out.println("Waiting for Topic...");
		Thread.sleep(3000);
		WebElement topicPage = wait.until(ExpectedConditions.presenceOfElementLocated(
				AppiumBy.accessibilityId("1. \nHow to be a complete anesthesiologist? \n1 Video lecture \nFree")));
		topicPage.click();
		System.out.println("Topic successfully loaded...");
		Thread.sleep(3000);

// Video Lecture Page...
		System.out.println("Verify the Video Title.. ");
		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(AppiumBy.accessibilityId("How to be a complete anesthesiologist?")));
		System.out.println("Video Title is displayed correctly..");
		Thread.sleep(3000);

// Video pass and continue...
		System.out.println("Checking Video pass and continue... ");
		Thread.sleep(3000);
		WebElement passandcontinue = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.view.View[contains(@content-desc, '/')]/android.view.View[3]")));
		System.out.println("Video pass and continue is working correctly..");
		passandcontinue.click();
		Thread.sleep(5000);

// Video continue watching...
//		System.out.println("Checking continue watching... ");
//		WebElement Continuewatching = wait
//				.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("00:13 / 11:48")));
//		Continuewatching.isDisplayed();
//		System.out.println("continue watching is working correctly..");
//		Thread.sleep(3000);

// DownLoad Videos..
		System.out.println("Clicking Download icon.. ");
		Thread.sleep(3000);
		WebElement Clickdownload = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView")));
		System.out.println("Download icon clicked and the video get download now..");
		Clickdownload.click();
		Thread.sleep(4000);

// go back to videopage to topic page
		System.out.println("back to videopage to topic page");
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(6)"))
				.click();
		Thread.sleep(1000);

// go back to topic page to course page
		System.out.println("back to topic page to course page");
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(6)"))
				.click();
		Thread.sleep(3000);
//unpurchased users
// subspeciality page...
		System.out.println("Waiting for Subspeciality...");
		Thread.sleep(1000);
		WebElement Subspeciality01 = wait
				.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("MD/DNB Anesthesia")));
		Subspeciality01.click();
		Thread.sleep(3000);
		WebElement Subspeciality02 = wait
				.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("MD/DNB Anesthesia")));
		Subspeciality02.click();
		System.out.println("Subspeciality successfully loaded...");
		Thread.sleep(3000);

// course page...
		System.out.println("Waiting for courses...");
		Thread.sleep(3000);
		WebElement coursepage01 = wait.until(
				ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Anesthesia machine\n14 Topics")));
		coursepage01.click();
		System.out.println("Courses successfully loaded...");
		Thread.sleep(3000);

// topics...
		System.out.println("Waiting for Topic...");
		Thread.sleep(3000);
		WebElement topicPage01 = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId(
				"2. \nAnesthesia Machine Demonstration\n1 Video lecture | 1 Test | 4 eBooks | 1 Slide")));
		topicPage01.click();
		System.out.println("Topic successfully loaded...");
		Thread.sleep(3000);

// Video Lecture Page...
		System.out.println("Verify the Video Title.. ");
		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(AppiumBy.accessibilityId("Anesthesia Machine Demonstration")));
		System.out.println("Video Title is displayed correctly..");
		Thread.sleep(3000);

		try {
			WebDriverWait wait01 = new WebDriverWait(driver, Duration.ofSeconds(8));
			// Check if primum user is displayed
			WebElement premiumuser = wait01.until(ExpectedConditions.presenceOfElementLocated(
					AppiumBy.accessibilityId("This content is only accessible to \nPremium users.")));
			if (premiumuser.isDisplayed()) {
				System.out.println("This content is only accessible to Premium users.");
				tearDown(); // Close the app
				return;
			}
		} catch (TimeoutException e) {
			System.out.println("Check Video pass and continue...");
		}
//Video pass and continue...
		System.out.println("Checking Video pass and continue... ");
		Thread.sleep(3000);
		WebElement passandcontinue01 = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.view.View[contains(@content-desc, '/')]/android.view.View[3]")));
		System.out.println("Video pass and continue is working correctly..");
		passandcontinue01.click();
		Thread.sleep(5000);

//DownLoad Videos..
		System.out.println("Clicking Download icon.. ");
		Thread.sleep(3000);
		WebElement Clickdownload01 = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView")));
		System.out.println("Download icon clicked and the video get download now..");
		Clickdownload01.click();
		Thread.sleep(5000);

//Navigate MCQ...
		System.out.println("Click to MCQ ");
		Thread.sleep(3000);
		WebElement Clickmcq = wait
				.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("MCQ's\nTab 2 of 5")));
		System.out.println("Navigate to MCQ...");
		Clickmcq.click();
		Thread.sleep(5000);
//Navigate E-book...
		System.out.println("Click to e-book ");
		Thread.sleep(3000);
		WebElement Clickebook = wait
				.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("eBook\nTab 3 of 5")));
		System.out.println("Navigate to E-Book...");
		Clickebook.click();
		Thread.sleep(5000);

		// Quit driver
		tearDown();
	}
}
