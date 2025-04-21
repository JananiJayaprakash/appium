package RaaOnlineProject01.Raaonline;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import RaaOnlineProject01.PageObject.android.factory;
import io.appium.java_client.AppiumBy;

public class MyCourseViewPlan extends HomePage {
	@Test(priority = 3)
	public void ViewPlans() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
//MyCourse Page 		
		System.out.println("Click MyCourse in bottom bar..");
//		driver.findElement(AppiumBy.accessibilityId("My Courses")).click();
		WebElement ClickMycourse = wait
				.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("My Courses")));
		ClickMycourse.click();
		Thread.sleep(3000);

//View plan button

		System.out.println("Click ViewPlan in MyCourse page..");
		factory ViewPlanPage = new factory(driver);

		boolean isPlanAvailable = ViewPlanPage.isPlanVisible(); // assume this checks if plan is displayed

		if (isPlanAvailable) {
			ViewPlanPage.ClickViewPlans();
			Thread.sleep(1000);
			ViewPlanPage.ChooseBasicPlan();
			Thread.sleep(1000);
			ViewPlanPage.ClickProceedTopay();
			Thread.sleep(1000);
			ViewPlanPage.ClickContinueToPay();
			// ViewPlanPage.ClickPaymentProcess();
			// ViewPlanPage.ClickSuccess();
			Thread.sleep(10000);
		} else {
			PurchasedUserInMyCourse();
		}
	}

	public void PurchasedUserInMyCourse() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		System.out.println("Plan not available. Skipping payment steps.");

//MyCourse Click Index
		WebElement ClickIndex = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Index")));
		ClickIndex.click();
		Thread.sleep(1000);

//change or verify subspeciality
		System.out.println("Click SubSpeciality MD/DNB Anesthesia in MyCourse");
		WebElement VerifySubsp = wait.until(
				ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("MD/DNB Anesthesia\n32 Courses")));
		VerifySubsp.click();
		Thread.sleep(1000);

//Click Anesthesia Machine
		System.out.println("Click course Anesthesia machine in MyCourse");
		WebElement ClickCourse1 = wait.until(ExpectedConditions.elementToBeClickable(
				AppiumBy.accessibilityId("Anesthesia machine\n12 Topics\n11 months and 30 days")));
		ClickCourse1.click();
		Thread.sleep(1000);

//Click Anesthesia Machine Demonstration
		System.out.println("Click Topic AnesthesiaMachineDemonstration");
		WebElement ClickTopic1 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId(
				"2. \nAnesthesia Machine Demonstration\n1 Video lecture | 1 Test | 4 eBooks | 1 Slide")));
		ClickTopic1.click();
		Thread.sleep(3000);

//Navigate into Verify Title of the video
		System.out.println("Verifying Video Title");
		WebElement VerifyVideo1 = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//android.view.View[@content-desc=\"Anesthesia Machine Demonstration\"])[1]")));
		VerifyVideo1.click();
		Thread.sleep(1000);

//Click Topic Anesthesia Machine - High, Intermediate and Low Pressure System
		System.out.println("Click Topic Anesthesia Machine - High, Intermediate and Low Pressure System ");
		WebElement ClickTopic2 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId(
				"3. \nAnesthesia Machine - High, Intermediate and Low Pressure System\n3 Video lectures | 1 Test | 2 eBooks | 3 Slides")));
		ClickTopic2.click();
		Thread.sleep(3000);

//Change the video
		System.out.println("Change the video into Anesthesia Machine - Intermediate Pressure System ");
		WebElement ChangeVideoLecture1 = wait.until(ExpectedConditions
				.elementToBeClickable(AppiumBy.accessibilityId("Anesthesia Machine - Intermediate Pressure System")));
		ChangeVideoLecture1.click();
		Thread.sleep(3000);

// Change the video
		System.out.println("Change the video into Anesthesia Machine High Pressure System");
		WebElement ChangeVideoLecture2 = wait.until(ExpectedConditions
				.elementToBeClickable(AppiumBy.accessibilityId("Anesthesia Machine High Pressure System")));
		ChangeVideoLecture2.click();
		Thread.sleep(3000);

//Navigate into VerifyTitle of the video
		System.out.println("Verifying Video Title");
		WebElement VerifyVideo2 = wait.until(ExpectedConditions.elementToBeClickable(
				AppiumBy.accessibilityId("Anesthesia Machine - High, Intermediate and Low Pressure System")));
		VerifyVideo2.click();
		Thread.sleep(1000);

// Click Topic Gas Laws And Their Clinical Application
		System.out.println("Click Topic Gas Laws And Their Clinical Application");
		WebElement ClickTopic3 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId(
				"4. \nGas Laws And Their Clinical Application\n1 Video lecture | 1 Test | 4 eBooks | 1 Slide")));
		ClickTopic3.click();
		Thread.sleep(3000);

// Navigate into VerifyTitle of the video
		System.out.println("Verifying Video Title");
		WebElement VerifyVideo3 = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//android.view.View[@content-desc=\"Gas Laws And Their Clinical Application\"])[1]")));
		VerifyVideo3.click();
		Thread.sleep(1000);

// Click Topic Breathing Systems
		System.out.println("Click Topic Breathing Systems");
		WebElement ClickTopic4 = wait.until(ExpectedConditions.elementToBeClickable(
				AppiumBy.accessibilityId("5. \nBreathing Systems\n1 Video lecture | 1 Test | 4 eBooks | 1 Slide")));
		ClickTopic4.click();
		Thread.sleep(3000);

// Navigate into VerifyTitle of the video
		System.out.println("Verifying Video Title");
		WebElement VerifyVideo4 = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//android.view.View[@content-desc=\"Breathing Systems\"])[1]")));
		VerifyVideo4.click();
		Thread.sleep(1000);

// Click Topic Breathing Systems
		System.out.println("Click Topic Breathing Systems");
		WebElement ClickTopic5 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId(
				"6. \nFlow Sensor in Anesthesia Machines\n1 Video lecture | 1 Test | 2 eBooks | 1 Slide")));
		ClickTopic5.click();
		Thread.sleep(3000);

// Navigate into VerifyTitle of the video
		System.out.println("Verifying Video Title");
		WebElement VerifyVideo5 = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//android.view.View[@content-desc=\"Flow Sensor in Anesthesia Machines\"])[1]")));
		VerifyVideo5.click();
		Thread.sleep(1000);

// Go Back To Course Page
		System.out.println("Go Back To Course Page");
		WebElement GoBack = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Anesthesia machine\"]")));
		GoBack.click();
		Thread.sleep(1000);

// Click Basic and Advanced Airway
		System.out.println("Click course Basic and Advanced Airway in MyCourse");
		WebElement ClickCourse2 = wait.until(ExpectedConditions.elementToBeClickable(
				AppiumBy.accessibilityId("Basic and Advanced Airway\n40 Topics\n11 months and 30 days")));
		ClickCourse2.click();
		Thread.sleep(1000);

// Click Understanding and optimizing laryngoscopy
		System.out.println("Click Topic Understanding and optimizing laryngoscopy");
		WebElement ClickTopic21 = wait.until(ExpectedConditions.elementToBeClickable(
				AppiumBy.accessibilityId("2. \nUnderstanding and optimizing laryngoscopy\n1 Video lecture | 1 Slide")));
		ClickTopic21.click();
		Thread.sleep(3000);

// Navigate into Verify Title of the video
		System.out.println("Verifying Video Title");
		WebElement VerifyVideo21 = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//android.view.View[@content-desc=\"Understanding and optimizing laryngoscopy\"])[1]")));
		VerifyVideo21.click();
		Thread.sleep(1000);

// Click Supraglottic Airway Device - Basic and advanced application
		System.out.println("Click Topic Supraglottic Airway Device - Basic and advanced application");
		WebElement ClickTopic22 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId(
				"3. \nSupraglottic Airway Device - Basic and advanced application\n1 Video lecture | 1 Test | 1 Slide")));
		ClickTopic22.click();
		Thread.sleep(3000);

// Navigate into Verify Title of the video
		System.out.println("Verifying Video Title");
		WebElement VerifyVideo22 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//android.view.View[@content-desc=\"Supraglottic Airway Device - Basic and advanced application\"]")));
		VerifyVideo22.click();
		Thread.sleep(1000);

// Go Back To Course Page
		System.out.println("Go Back To Course Page");
		WebElement GoBack2 = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Basic and Advanced Airway\"]")));
		GoBack2.click();
		Thread.sleep(1000);

// MyCourse Click Index
		System.out.println("Click Index in MyCourse");
		WebElement ClickIndex2 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Index")));
		ClickIndex2.click();
		Thread.sleep(1000);

// change or verify subspeciality
		System.out.println("Change SubSpeciality Videos and animations");
		WebElement VerifySubsp2 = wait.until(ExpectedConditions.elementToBeClickable(
				AppiumBy.accessibilityId("Videos and animations (Anesthesia & Critical Care)\n40 Courses")));
		VerifySubsp2.click();
		Thread.sleep(1000);

// Click Airway - Baska Mask
		System.out.println("Airway - Baska Mask");
		WebElement ClickTopicSp2 = wait.until(ExpectedConditions.elementToBeClickable(
				AppiumBy.accessibilityId("Airway - Baska Mask\n19 Topics\n11 months and 30 days")));
		ClickTopicSp2.click();
		Thread.sleep(3000);

// Click Airway - Baska Mask
		System.out.println("Baska Mask in lap gynaecological surgery");
		WebElement ClickTopicSp21 = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//android.view.View[@content-desc=\"1. Baska mask during FESS 1 Video lecture | 2 Tests \"]")));
		ClickTopicSp21.click();
		Thread.sleep(3000);

// Navigate into Verify Title of the video
		System.out.println("Verifying Video Title");                                             
		WebElement VerifyVideoSp21 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@content-desc=\"Baska mask during FESS\"])[1]")));
		VerifyVideoSp21.click();
		Thread.sleep(1000);
	}

}
