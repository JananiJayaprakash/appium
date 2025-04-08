package RaaOnlineProject01.Raaonline;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class performance extends BaseClass {

    @Test
    public void testPerformanceMetrics() {
        try {
            System.out.println("🚀 Starting Performance Test...");

            // 1. Measure page load time after tapping a button
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.raaonlinedev.app:id/btn_navigate")));

            long pageStart = System.currentTimeMillis();
            driver.findElement(By.id("com.raaonlinedev.app:id/btn_navigate")).click();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.raaonlinedev.app:id/target_element")));
            long pageEnd = System.currentTimeMillis();

            System.out.println("✅ Page Load Time: " + (pageEnd - pageStart) + " ms");

            // 2. Fetch CPU Info
            System.out.println("\n📊 CPU Info:");
            
            List<List<Object>> battery = (driver).getPerformance("com.raaonlinedev.app", "batteryinfo", 5);
            System.out.println(battery);

            cpuInfo.forEach(System.out::println);

            // 3. Fetch Memory Info
            System.out.println("\n📊 Memory Info:");
            List<List<Object>> memoryInfo = driver.getPerformanceData("com.raaonlinedev.app", "memoryinfo", 5);
            memoryInfo.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
