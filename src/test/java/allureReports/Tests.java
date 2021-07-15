package allureReports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class Tests {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://iengage.coforgetech.com/");
		driver.manage().window().maximize();
				
	}
	
    
	@Test(priority=1)
//	@Description("Verify Coforge logo is displayed")
//	@Epic("EP001")
//	@Feature("Feature1: Implement Login page")
//	@Story("Story: User able to login successfully")
//	@Step("Test: Verify COFORGE logo is present")
//	@Severity(SeverityLevel.TRIVIAL)
	//RTE
	public void logoPresence() {
		boolean logoDisplayed = driver.findElement(By.id("img_ntllogo")).isDisplayed();
		Assert.assertEquals(logoDisplayed, true);
	}
	
	@Test(priority=2)
//	@Description("Verify valid text is displayed")
//	@Epic("EP001")
//	@Feature("Feature1: Implement Login page")
//	@Story("Story: User able to login successfully")
//	@Step("Test: Verify Name of the user is displayed")
//	@Severity(SeverityLevel.NORMAL)
	public void loginTest() {
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.xpath("//label[@class='text-light' and contains(text(),'Login Id')]/following-sibling::input")).sendKeys("91667");
		driver.findElement(By.xpath("//label[@class='text-light' and contains(text(),'Password')]/following-sibling::input")).sendKeys("Global@1234");
		driver.findElement(By.id("imgBtnOK")).click();
		String text = driver.findElement(By.xpath("//div[@class='blue2']//b")).getText();
		Assert.assertEquals(text, "Shaik Wasim");
	}
	
	@Test(priority=3)
	//@Description("Test skipped: Functionality not ready/known bug")
	public void registrationTest() {
		throw new SkipException("Skipping without test");		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
