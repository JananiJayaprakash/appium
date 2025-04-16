//package RaaOnlineProject01.Raaonline;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.TimeoutException;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.Test;
//
//import io.appium.java_client.AppiumBy;
//
//public class SubscriptionPlan extends MyCourseViewPlan {
//	@Test(priority = 4)
//    public void ChooseYourPlan() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
//
//        System.out.println("Choose your plan opened..");
//        Thread.sleep(3000);
//        WebElement BasicPlan = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId(
//                "₹ 37000\n₹ 45000\n1 year\nBasic Plan\nClick Coupon Code - Valid for 9 Days Only\nTo avail a 1 day trial\nPlan Includes")));
//        BasicPlan.isDisplayed();
//
//        // Try to get trial
//        try {
//            WebElement GetTrial = wait.until(ExpectedConditions
//                    .presenceOfElementLocated(By.xpath("(//android.view.View[@content-desc=\"Get Trial\"])[1]")));
//
//            if (GetTrial.isDisplayed()) {
//                System.out.println("Trial is available. Clicking 'Get Trial' to activate it.");
//                GetTrial.click();
//
//                WebElement BasicPlanTrial = wait.until(
//                        ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Try free for 1 day")));
//                BasicPlanTrial.click();
//
//                WebElement GoToMyCourse = wait.until(
//                        ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Go to My Courses")));
//                GoToMyCourse.click();
//            }
//        } catch (TimeoutException e) {
//            System.out.println("You already activated the trial or 'Get Trial' button is not visible.");
//        }
//    }
//}
