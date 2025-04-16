package RaaOnlineProject01.Raaonline;

import java.time.Duration;

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
		  WebElement ClickMycourse = wait.until(
			        ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("My Courses")));
		  ClickMycourse.click();
		Thread.sleep(3000);

//View plan button

		System.out.println("Click ViewPlan in MyCourse page..");

//        factory ViewPlanPage = new factory(driver);
//        ViewPlanPage.ClickViewPlans();
//        Thread.sleep(1000);
//        ViewPlanPage.ChooseBasicPlan();
//        Thread.sleep(1000);
//        ViewPlanPage.ClickProceedTopay();
//        Thread.sleep(1000);
//        ViewPlanPage.ClickContinueToPay();
// //       ViewPlanPage.ClickPaymentProcess();
//  //      ViewPlanPage.ClickSuccess();
//        Thread.sleep(8000);
		factory ViewPlanPage = new factory(driver);

		// Example condition — replace with your actual condition logic
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
		    Thread.sleep(8000);
		} else {
		    PurchasedUserInMyCourse();
		}	

	}
	public void  PurchasedUserInMyCourse() {
	    System.out.println("Plan not available. Skipping payment steps.");
	    // You can add more logic here, like logging, screenshots, etc.
	}
}
