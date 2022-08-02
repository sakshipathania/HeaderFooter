package SetupClass.StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SetupClass.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Footer extends Setup {

	WebDriverWait wait = new WebDriverWait(driver, 50);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public void clear_cache() throws InterruptedException {
		driver.get(AppURL);
		driver.manage().deleteAllCookies();
		Thread.sleep(4000); // wait 4 seconds to clear cookies.
		driver.navigate().refresh();
		Thread.sleep(2000);
		log.info("DELETE COOKIES");
	}

	public void err_page() throws InterruptedException {

		pagetitle = driver.getTitle().toUpperCase();
		System.out.println("Title of the Page is:-" + "" + pagetitle);
		Thread.sleep(3500);

		try {
			driver.getPageSource().contains("404 Not Found");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void chat_pop_up() throws InterruptedException {
		try {
			WebElement iframe = driver.findElement(By.id("livechat-full-view"));
			if (iframe.isDisplayed()) {
				driver.switchTo().frame(iframe);
				Actions act = new Actions(driver);
				act.moveToElement(driver.findElement(By.cssSelector("#title .icon-minimize"))).build().perform();
				Thread.sleep(2000);
				WebElement chat1 = driver.findElement(By.cssSelector("#title .icon-minimize"));
				Thread.sleep(1000);
				chat1.click();
				Thread.sleep(1000);
				driver.switchTo().defaultContent();
				Thread.sleep(1000);
				driver.switchTo().parentFrame();
				Thread.sleep(1000);
			} else {
				System.out.println("chat window does not open");
			}
		} catch (NoSuchElementException NCP) {

		}
	}

	@Given("^Open the Website URL1\\.$")
	public void open_the_Website_URL1() throws InterruptedException {

		driver.get(AppURL);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		log.info("It's opening the website URL");
		driver.manage().deleteAllCookies();
		Thread.sleep(4000); // wait 4 seconds to clear cookies.
		driver.navigate().refresh();
		Thread.sleep(2000);
		try {
			driver.findElement(By.cssSelector(".authorization-link > a:nth-child(1)")).click();
			Thread.sleep(5000);
			log.info("It's opening the website URL");
		} catch (NoSuchElementException popup) {
		}
	}

	@Then("^user enter email and password$")
	public void user_enter_email_and_password() throws InterruptedException {

		WebElement old_paid_email = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
		old_paid_email.sendKeys("nishadhiman0027@gmail.com");

		WebElement old_paid_pass = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='pass']")));
		old_paid_pass.sendKeys("Qwerty@1");

		Thread.sleep(3000);
		WebElement old_paid_login_btn = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='send2']")));
		old_paid_login_btn.click();
		Thread.sleep(3000);
		if (!driver.findElements(By.xpath("//div[@class='login-attempt-popup']")).isEmpty()) {
			WebElement approve = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='confirm-approve']")));
			approve.click();
		}
	}

	@Then("^Free Business PPT\\.$")
	public void Free_Business_PPT() throws Throwable {
		Thread.sleep(5000);
		WebElement footer_1 = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//li[@class='first'][contains(.,'Free Business PPT')]")));
		Thread.sleep(3000);
		// clear_cache();
		js.executeScript("arguments[0].scrollIntoView();", footer_1);
		footer_1.click();
		log.info("FOOTER --> 1 || FREE STUFF || FREE BUSINESS PPT");
		chat_pop_up();
		Thread.sleep(1500);
		err_page();

	}

	@Then("^Free PPT template\\.$")
	public void Free_PPT_template() throws Throwable {

		WebElement footer_2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Free PPT']")));
		Thread.sleep(3000);
		// clear_cache();
		js.executeScript("arguments[0].scrollIntoView();", footer_2);
		footer_2.click();
		log.info("FOOTER --> 3 || FREE STUFF || FREE PPT Template");
		chat_pop_up();
		Thread.sleep(1500);
		err_page();

	}

	@Then("^Free Editable PPT\\.$")
	public void Free_Ediatble_PPT() throws Throwable {

		WebElement footer_3 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Free Editable PPT']")));
		Thread.sleep(3000);
		// clear_cache();
		js.executeScript("arguments[0].scrollIntoView();", footer_3);
		footer_3.click();
		log.info("FOOTER --> 4 || FREE STUFF || FREE EDITABLE PPT");
		chat_pop_up();
		Thread.sleep(1500);
		err_page();

	}

	@Then("^Free Google Slide\\.$")
	public void Free_Google_Slide() throws Throwable {
		Thread.sleep(3000);
		WebElement footer_4 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Free Google Slides']")));
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView(true);", footer_4);
		js.executeScript("arguments[0].click();", footer_4);
		log.info("FOOTER --> 5 || FEE STUFF || FREE GOOGLE SLIDE ");
		chat_pop_up();
		Thread.sleep(1500);
		err_page();

	}

	@Then("^Free Timeline\\.$")
	public void Free_Timeline() throws Throwable {

		WebElement footer_5 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Free Timelines']")));
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView();", footer_5);
		js.executeScript("arguments[0].click();", footer_5);
		log.info("FOOTER --> 7 || FREE STUFF || FREE TIMELINE");
		chat_pop_up();
		Thread.sleep(1500);
		err_page();

	}

	@Then("^Free Investor Pitch\\.$")
	public void Free_Investor_Pitch() throws Throwable {

		WebElement footer_6 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Free Investor Pitch']")));
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView();", footer_6);
		js.executeScript("arguments[0].click();", footer_6);
		log.info("FOOTER --> 8 || FREE STUFF || FREE INVESTOR PITCH");
		chat_pop_up();
		Thread.sleep(1500);
		err_page();

	}

	@Then("^Free Template\\.$")
	public void Free_Template() throws Throwable {

		WebElement footer_7 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Free Templates']")));
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView();", footer_7);
		js.executeScript("arguments[0].click();", footer_7);
		log.info("FOOTER --> 10 || FREE STUFF || FREE TEMPLATE");
		chat_pop_up();
		Thread.sleep(1500);
		err_page();

	}

	@Then("^Free Business Plan\\.$")
	public void Free_Business_Plan() throws Throwable {

		WebElement footer_8 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Free Business Plan']")));
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView();", footer_8);
		js.executeScript("arguments[0].click();", footer_8);
		log.info("FOOTER --> 11 || FREE STUFF || FREE BUSINESS PLAN");
		chat_pop_up();
		Thread.sleep(1500);
		err_page();

	}

	@Then("^View All\\.$")
	public void View_All() throws Throwable {

		WebElement footer_9 = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//a[@href='/free-business-powerpoint-templates'][normalize-space()='View All']")));
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView();", footer_9);
		js.executeScript("arguments[0].click();", footer_9);
		log.info("FOOTER --> 12 || FREE STUFF || View All");
		chat_pop_up();
		Thread.sleep(1500);
		err_page();

	}

	// Popular PPts

	@Then("^Action Plan Template\\.$")
	public void Action_Plan_Template() throws Throwable {

		WebElement footer_10 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Action Plan Template']")));
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView();", footer_10);
		js.executeScript("arguments[0].click();", footer_10);
		log.info("FOOTER --> 13 || POPULAR PPT || ACTION PLAN TEMPLATE");
		chat_pop_up();
		Thread.sleep(1500);
		err_page();

	}

	@Then("^Biz Model Canvas\\.$")
	public void Biz_Model_Canvas() throws Throwable {

		WebElement footer_11 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Biz Model Canvas']")));
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView();", footer_11);
		js.executeScript("arguments[0].click();", footer_11);
		log.info("FOOTER --> 14 || POPULAR PPT || BIZ MODEL CANVAS");
		chat_pop_up();
		Thread.sleep(1500);
		err_page();

	}

	@Then("^Business Case PPT\\.$")
	public void Business_Case_PPT() throws Throwable {

		try {
			WebElement footer_12 = driver.findElement(By.xpath("//a[@title='Business Case PPT']"));
			Thread.sleep(3000);
			js.executeScript("arguments[0].scrollIntoView();", footer_12);
			js.executeScript("arguments[0].click();", footer_12);
			log.info("FOOTER --> 15 || POPULAR PPT || BUSINESS CASE PPT");
			chat_pop_up();
			Thread.sleep(1500);
			err_page();
		} catch (NoSuchElementException bc) {
		}

	}

	@Then("^Challenges Slide\\.$")

	public void Challenges_Slide() throws Throwable {

		try {
			WebElement footer_14 = driver.findElement(By.xpath("//a[@title='Challenges Slide']"));
			Thread.sleep(3000);
			js.executeScript("arguments[0].scrollIntoView();", footer_14);
			js.executeScript("arguments[0].click();", footer_14);
			log.info("FOOTER --> 16 || POPULAR PPT || CHALLENGES SLIDE");
			chat_pop_up();
			Thread.sleep(1500);
			err_page();
		} catch (NoSuchElementException cs) {
		}

	}

	@Then("^Change Management\\.$")
	public void Change_Management() throws Throwable {

		try {
			WebElement footer_15 = driver.findElement(By.xpath("//a[@title='Change Management']"));
			Thread.sleep(3000);
			js.executeScript("arguments[0].scrollIntoView();", footer_15);
			js.executeScript("arguments[0].click();", footer_15);
			log.info("FOOTER --> 17 || POPULAR PPT || CHANAGE MANAGEMENT");
			chat_pop_up();
			Thread.sleep(1500);
			clear_cache();
			err_page();
		} catch (NoSuchElementException cm) {
		}

	}

}
