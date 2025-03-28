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

public class CreateAccountPage extends BaseClass {
	@Test(priority = 1)
	public void RegisterPage() throws MalformedURLException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		try {
			// Click "Create Account" Button..
			System.out.println("Click Create Account Button..");
			clickElement(wait, AppiumBy.accessibilityId("Create Account"),
					By.xpath("//android.view.View[@content-desc='Create Account']"));

			// Fill the details of register..
			System.out.println("Fill the details of register..");
			System.out.println("Enter first Name, Last Name, E-mail, Mobile Number");
			String[] inputValues = { "janani", "Jaya prakash", "jananiprakash233@gmail.com", "6383317837" };
			for (int i = 1; i <= inputValues.length; i++) {
				enterText(wait, "(//android.widget.EditText)[" + i + "]", inputValues[i - 1]);
			}
			// Click "Next" Button..
			System.out.println("Click the Next page... ");
			clickElement(wait, AppiumBy.accessibilityId("Next"),
					By.xpath("//android.widget.Button[@content-desc='Next']"));
			try {
				// Check for toast message (Dublicate mailID and already registered account..)
				System.out.println("Duplicate Email..");
				WebElement toastMessage01 = wait
						.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId(
								"Duplicate Email, Try another one., Account already Exists. Reset your password in Login Page.")));
				System.out.println("Toast message checking: " + toastMessage01.isDisplayed());

				if (toastMessage01.isDisplayed()) {
					System.out.println("Registration failed: Duplicate Email.");
					WebElement closeToast = wait
							.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("OK")));
					closeToast.click();
					System.out.println("Toast message closed.");
					tearDown(); // Close the app
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				System.out.println("No toast message found. Checking Home Page...");
			}

			try {
				// Check for toast message (Already registered account..)
				System.out.println("Account already Exists..");
				WebElement toastMessage02 = wait.until(ExpectedConditions.presenceOfElementLocated(
						AppiumBy.accessibilityId("Account already Exists. Reset your password in Login Page.")));
				System.out.println("Toast message checking: " + toastMessage02.isDisplayed());
				if (toastMessage02.isDisplayed()) {
					System.out.println("Registration failed:Account already Exists ");
					WebElement closeToast = wait
							.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("OK")));
					closeToast.click();
					System.out.println("Toast message closed.");
					tearDown(); // Close the app
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				System.out.println("No toast message found. Checking Home Page...");
			}

			System.out.println("Successfully navigated to the Education details page..");

			// Education details page..
			System.out.println("Select the Education Level...");
			WebElement educationDropdown = wait
					.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Current Education")));
			educationDropdown.click();

			// Scroll to MBBS
//            String scrollToMBBS = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"MBBS\"))";
//            driver.findElement(AppiumBy.androidUIAutomator(scrollToMBBS));
			System.out.println("Select MBBS...");
			driver.findElement(By.xpath("//android.view.View[@content-desc=\'MD/MS/DNB\']")).click();

			// Country...
			System.out.println("Select country ....");
			WebElement CountrySclection = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//android.view.View[@content-desc=\"Year of Admission\"]/android.view.View[1]")));
			CountrySclection.click();
//            // Scroll to Country
//            String SelectCountry = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"India\"))";
//            driver.findElement(AppiumBy.androidUIAutomator(SelectCountry));
			// Click India
			System.out.println("Select India...");
			WebElement SelectIndia = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc='India']")));
			SelectIndia.click();

			// Select state..
			System.out.println("Select state ....");
			WebElement StateSclection = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//android.view.View[@content-desc=\"Year of Admission\"]/android.view.View[2]")));
			StateSclection.click();
			// Scroll to Tamil Nadu
			System.out.println("Select Tamil Nadu ....");
			for (int i = 0; i < 5; i++) { // Adjust scroll attempts
				try {
					driver.findElement(By.xpath("//android.view.View[@content-desc='Tamil Nadu']")).click();
					break; // Stop loop if clicked successfully
				} catch (Exception e) {
					driver.findElement(AppiumBy.androidUIAutomator(
							"new UiScrollable(new UiSelector().scrollable(true))" + ".scrollForward()"));
				}
			}
			// Enter college Name..
			System.out.println("Enter college Name...");
			driver.findElement(By.xpath("//android.widget.EditText")).click();
			driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("ABC College");

			// start Date..
			System.out.println("Enter start Date...");
			driver.findElement(AppiumBy.accessibilityId("Start Date")).click();
			driver.findElement(AppiumBy.accessibilityId("2021")).click();

			// End Date..
			System.out.println("Enter End Date...");
//           driver.findElement(AppiumBy.accessibilityId("End Date")).click();
			driver.findElement(AppiumBy.accessibilityId("2025")).click();

			// Click "Next"
			System.out.println("Click Next Button...");
			clickElement(wait, AppiumBy.accessibilityId("Next"),
					By.xpath("//android.widget.Button[@content-desc='Next']"));

			// password page..
			System.out.println("Create Password...");
			driver.findElement(By.xpath("//android.widget.EditText[1]")).click();
			driver.findElement(By.xpath("//android.widget.EditText[1]")).sendKeys("123456");

			// confirm password ..
			System.out.println("confirm Password...");
			driver.findElement(By.xpath("//android.widget.EditText[2]")).click();
			driver.findElement(By.xpath("//android.widget.EditText[2]")).sendKeys("123456");

			driver.findElement(By.xpath("//android.widget.ImageView[2]")).click();

			// Click "Next"
			System.out.println("Click Next Button...");
			clickElement(wait, AppiumBy.accessibilityId("Next"),
					By.xpath("//android.widget.Button[@content-desc='Next']"));

			// OTP verification Page..
			System.out.println("Waiting for OTP...");
			Thread.sleep(4000); // Wait for OTP to arrive
			System.out.println("OTP could not be retrieved, please enter manually.");
			Thread.sleep(5000);

			// Click "Verify" Button
			System.out.println("Click Verify Button...");
			clickElement(wait, AppiumBy.accessibilityId("Verify and Continue"),
					By.xpath("//android.widget.Button[@content-desc='Verify']"));
			Thread.sleep(3000);
			System.out.println("OTP Verification Successful!");
			System.out.println("Navigate to edcation speciality selection page");
			Thread.sleep(5000);

			// Select educational speciality
			System.out.println("Select educational speciality...");
			try {
				WebDriverWait wait01 = new WebDriverWait(driver, Duration.ofSeconds(15));
				WebElement Speciality = wait01.until(ExpectedConditions
						.presenceOfElementLocated(AppiumBy.accessibilityId("Select your Specialities")));
				Speciality.isDisplayed();
				System.out.println("Educational speciality page displayed");
				WebElement ChooseSpeciality = wait.until(ExpectedConditions
						.presenceOfElementLocated(AppiumBy.accessibilityId("Anesthesia & Critical care")));
				ChooseSpeciality.click();
				if (ChooseSpeciality.isDisplayed()) {
					System.out.println("Educational speciality selected successfully.");
					WebElement SelectSpeciality = wait
							.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Continue")));
					SelectSpeciality.click();
					System.out.println("Toast message closed.");
					// Stop further execution
				}
			} catch (TimeoutException e) {
				System.out.println("No Speciality selection found. Checking Home Page...");
			}
		} catch (Exception e) {
			System.out.println("Test failed: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Helper method to click element with fallback locator
	private void clickElement(WebDriverWait wait, By primaryLocator, By fallbackLocator) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(primaryLocator)).click();
		} catch (Exception e) {
			System.out.println("Primary locator failed, trying fallback...");
			wait.until(ExpectedConditions.elementToBeClickable(fallbackLocator)).click();
		}
	}

	// Helper method to enter text into fields
	private void enterText(WebDriverWait wait, String xpath, String value) {
		WebElement field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		field.click();
		field.sendKeys(value);

	}
}
