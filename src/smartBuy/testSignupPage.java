package smartBuy;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testSignupPage {
	WebDriver driver = new ChromeDriver();
	Random rand = new Random();

	@BeforeTest
	public void mySetup() {
		driver.get("https://smartbuy-me.com/smartbuystore/ar");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));// even if the problem solve the implicitly
		driver.manage().window().maximize();

	};

	@Test(invocationCount = 3, priority = 1)
	public void myTest() throws InterruptedException {
		Thread.sleep(2000);

		WebElement container = driver.findElement(By.className("navigation__overflow"));

		List<WebElement> listItems = container.findElements(By.tagName("li"));

		int randomIndex = new Random().nextInt(listItems.size());

		Actions actions = new Actions(driver);
		actions.moveToElement(listItems.get(randomIndex)).perform();

		// Now you can interact with any sub-menu or child elements that appear
		// after the hover action

		// Add your test logic here

		// Close the browser (if needed)
		// driver.quit();

//		WebElement contenierTow = driver.findElement(By.className("sub-navigation-section"));
//
//		List<WebElement> listIcons = contenierTow.findElements(By.tagName("a"));
//
//		int randommIndex = rand.nextInt(listIcons.size());
//		listIcons.get(randommIndex).click();

//		System.out.println(listItems.get(randomIndex).getText());
	};

	@Test(priority = 2, enabled = false)
	public void myTestTow() throws InterruptedException {
		WebElement enabelBtn = driver.findElement(By.cssSelector(".btn.btnicon.js-enable-btn"));

		enabelBtn.click();
		Thread.sleep(3000);
		driver.findElement(By.id("cboxOverlay")).click();
		enabelBtn.click();
		Thread.sleep(2000);

		WebElement buyBtn = driver.findElement(By.cssSelector(".btn.btn-primary.btn-block.add-to-cart-button"));

		buyBtn.click();
		Thread.sleep(2000);
		driver.findElement(
				By.cssSelector(".btn.btn-default.btn-block.btn--continue-shopping.js-continue-shopping-button"))
				.click();
	}

}
