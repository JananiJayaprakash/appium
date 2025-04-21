package RaaOnlineProject01.PageObject.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class factory {
	AppiumDriver driver;

	public factory(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
//	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"View All Plans\"]")
//	private WebElement ViewAllPlans;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"View Plans\"]")
	private WebElement ViewPlan;
	
//	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Choose Plan\"]")
//	private WebElement ChoosePlan;
	
	public void ClickViewPlans() {
	//	ViewAllPlans.click();
		ViewPlan.click();
	}

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Choose Plan\"]")
	private WebElement ChoosePlan;
	
	public void ChooseBasicPlan() {
	//	ViewAllPlans.click();
		ChoosePlan.click();
	}
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Proceed to payment\"]")
	private WebElement ProceedToPay;
	
	public void ClickProceedTopay() {
		//	ViewAllPlans.click();
		ProceedToPay.click();
	}
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Continue to payment\"]")
	private WebElement ContinueToPay;
	public void ClickContinueToPay() {
		ContinueToPay.click();
	}

//	@AndroidFindBy(xpath = "//android.webkit.WebView[@content-desc=\"primary_webview\"]")
//	private WebElement PaymentProcess;
//	
//	public void ClickPaymentProcess() {
//		PaymentProcess.click();
//	}
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Success\"]")
	private WebElement Success;
	
	public void ClickSuccess() {
		Success.click();
	}
	
	public boolean isPlanVisible() {
		try {
			return ChoosePlan.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}

