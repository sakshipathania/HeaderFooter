package SetupClass.StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;


import SetupClass.Setup;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.lexer.Th;

public class Footer2 extends Setup {
	
	WebDriverWait wait = new WebDriverWait(driver,60);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public void clear_cache() throws InterruptedException
	{
		driver.manage().deleteAllCookies();
		Thread.sleep(4200);
		log.info("DELETE COOKIES");
	}
	
	public void err_page() throws InterruptedException
	{
		
		pagetitle=driver.getTitle().toUpperCase();
		System.out.println("Title of the Page is:-"+""+pagetitle);
		Thread.sleep(3500);
		
		try
		{
			driver.getPageSource().contains("404 Not Found");
		}
	    catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void chat_pop_up() throws InterruptedException
	{
		try {
			WebElement iframe = driver.findElement(By.id("livechat-full-view"));
			if(iframe.isDisplayed()) {
				driver.switchTo().frame(iframe);   
				 Actions act = new Actions(driver);
				 act.moveToElement(driver.findElement(By.cssSelector("#title .icon-minimize"))).build().perform();
				 Thread.sleep(2000);
					WebElement chat1=driver.findElement(By.cssSelector("#title .icon-minimize"));
					 Thread.sleep(1000);
						chat1.click();
						 Thread.sleep(1000);
						 driver.switchTo().defaultContent();
						 Thread.sleep(1000);
						 driver.switchTo().parentFrame();
					 Thread.sleep(1000);
			}
			else {
					System.out.println("chat window does not open");
			     }
		}
				catch(NoSuchElementException NCP) {
					
				}
	}
  
  
  @Given("^Open the Website URL2\\.$")
	public void open_the_Website_URL2() throws InterruptedException {
		
		driver.get(AppURL);
	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	log.info("It's opening the website URL");
	Thread.sleep(1000);
	driver.get("https://www.slideteam.net");
	Thread.sleep(2000);
	driver.get("https://www.slideteam.net");
	Thread.sleep(2000);
         driver.manage().deleteAllCookies();
         Thread.sleep(2000);
	try {
		driver.findElement(By.cssSelector(".authorization-link > a:nth-child(1)")).click();
		Thread.sleep(2000);
		log.info("It's opening the website URL");
	} 
	catch (NoSuchElementException popup) {
	}
	}
	
	@Then("^user enter email and password1$")
       public void user_enter_email_and_password1() throws InterruptedException  {
    
	       WebElement old_paid_email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[2]/div[2]/form/fieldset/div[2]/div/input")));
               old_paid_email.sendKeys("sakshi.pathania@slidetech.in");
    
               WebElement old_paid_pass = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[2]/div[2]/form/fieldset/div[3]/div/input")));
               old_paid_pass.sendKeys("Qwerty@1");
	       
	       Thread.sleep(3000);
	       WebElement old_paid_login_btn=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.login > span:nth-child(1)")));
	       old_paid_login_btn.click();
        }
           @Then("^Company Powerpoint\\.$")
	public void Company_Powerpoint() throws Throwable {
		
		try {
		  WebElement footer_16= driver.findElement(By.xpath("//a[@href='/company-overview-powerpoint-presentation-slides.html'][contains(.,'Company PowerPoint"));
		  Thread.sleep(3000); 
		js.executeScript("arguments[0].scrollIntoView();",footer_16);
		  footer_16.click();
		  log.info("FOOTER --> 18 || POPULAR PPT || COMPANY POWERPOINT"); 
		  chat_pop_up();
		  Thread.sleep(1500); 
		  err_page();
		} catch(NoSuchElementException cp) { }
	}
	
	@Then("^Competitor landscape\\.$")
	public void Competitor_landscape() throws Throwable {
		
		try {
		  WebElement footer_17=driver.findElement(By.xpath("//a[@href='/powerpoint-presentation-slides/competitive-landscape.html'][contains(.,'Competitor Landscape"));
		  Thread.sleep(3000); 
		js.executeScript("arguments[0].scrollIntoView();",footer_17);
		  footer_17.click();
		  log.info("FOOTER --> 19 || POPULAR PPT || COMPETITOR LANDSCAPE"); 
		  chat_pop_up();
		  Thread.sleep(1500); 
		  err_page();
		} catch (NoSuchElementException cl) { }
	   
	}
	
	@Then("^Current State PPT\\.$")
	public void Current_State_PPT() throws Throwable {
		
		try {
		  WebElement footer_18= driver.findElement(By.xpath("//a[@href='/powerpoint-presentation-slides/current-state-future-state.html'][contains(.,'Current State ppt"));
		  Thread.sleep(3000); 
		js.executeScript("arguments[0].scrollIntoView();",footer_18);
		  footer_18.click();
		  log.info("FOOTER --> 20 || POPULAR PPT || CURRENT STATE PPT"); 
		  chat_pop_up();
		  Thread.sleep(1500); 
		  err_page();
		} catch(NoSuchElementException csp) { }
	   
	}
	
	@Then("^Cybersecurity PPT\\.$")
	public void Cybersecurity_PPT() throws Throwable {
		
		try {
		  WebElement footer_19= driver.findElement(By.xpath("//a[@href='/cybersecurity-powerpoint-presentation-slides.html'][contains(.,'Cybersecurity PPT"));
		  Thread.sleep(3000); 
		js.executeScript("arguments[0].scrollIntoView();",footer_19);
		  footer_19.click();
		  log.info("FOOTER --> 21 || POPULAR PPT || CYBERSECURITY PPT"); 
		  chat_pop_up();
		  Thread.sleep(1500); 
		  err_page();
		} catch (NoSuchElementException ccp) { }
	}
	
	@Then("^Disaster Mgmt ppt\\.$")
	public void Disaster_Mgmt_ppt() throws Throwable {
		
		try {
		  WebElement footer_20= driver.findElement(By.xpath("//a[@href='/disaster-management-powerpoint-presentation-slides.html'][contains(.,'Disaster Mgmt ppt"));
		  Thread.sleep(3000); 
		js.executeScript("arguments[0].scrollIntoView();",footer_20);
		  footer_20.click();
		  log.info("FOOTER --> 22 || POPULAR PPT || DISASTER MGMT PPT"); 
		  chat_pop_up();
		  Thread.sleep(1500); 
		  err_page();
		} catch (NoSuchElementException dm) { }
	   
	}
	
	
	@Then("Food Powerpoint\\.$")
	public void Food_Powerpoint() throws InterruptedException {
		try {
		 WebElement footer_21= driver.findElement(By.xpath("//a[@href='/powerpoint-templates/food.html'][contains(.,'Food PowerPoint"));
		  Thread.sleep(3000); 
		js.executeScript("arguments[0].scrollIntoView();",footer_21);
		  footer_21.click();
		  log.info("FOOTER --> 23 || POPULAR PPT || FOOD POWERPOINT"); 
		  chat_pop_up();
		  Thread.sleep(1500); 
		  err_page();
		} catch (NoSuchElementException fp) { }
	   
	}
	
	@Then("Happy Birthday PPT\\.$")
	public void Happy_Birthday_PPT() throws InterruptedException {
		
		try {
		 WebElement footer_22= driver.findElement(By.xpath("//a[@href='/happy-birthday-powerpoint-presentation-slides.html'][contains(.,'Happy Birthday PPT"));
		  Thread.sleep(3000); 
		js.executeScript("arguments[0].scrollIntoView();",footer_22);
		  footer_22.click();
		  log.info("FOOTER --> 24 || POPULAR PPT || HAPPY BIRTHDAY PPT"); 
		  chat_pop_up();
		  Thread.sleep(1500); 
		  err_page();
		} catch(NoSuchElementException Hbp) { }
	   
	}
	
	@Then("HR Management PPT\\.$")
	public void HR_Management_PPT() throws InterruptedException {
		
		try {
		 WebElement footer_23= driver.findElement(By.xpath("//a[@href='/powerpoint-presentation-essentials/human-resource-management-slides.html'][contains(.,'HR Management PPT"));
		  Thread.sleep(3000); 
		js.executeScript("arguments[0].scrollIntoView();",footer_23);
		  footer_23.click();
		  log.info("FOOTER --> 25 || POPULAR PPT || HR MANAGEMENT PPT"); 
		  chat_pop_up();
		  Thread.sleep(1500); 
		  err_page();
		} catch(NoSuchElementException hMp) { }
	}
	
	@Then("Introduce Yourself\\.$")
	public void Introduce_Yourself() throws InterruptedException {
		try {
		 WebElement footer_24= driver.findElement(By.xpath("//a[@href='/introduce-yourself-powerpoint-presentation-slides.html'][contains(.,'Introduce Yourself"));
		  Thread.sleep(3000); 
		js.executeScript("arguments[0].scrollIntoView();",footer_24);
		  footer_24.click();
		  log.info("FOOTER --> 26 || POPULAR PPT || INTRODUCE YOURSELF"); 
		  chat_pop_up();
		  Thread.sleep(1500); 
		  err_page();
		} catch(NoSuchElementException Iy) { }
	   
	}
	
	
	@Then("View All 1\\.$")
	public void View_All_1() throws InterruptedException {
		
		try {
		 WebElement footer_25= driver.findElement(By.xpath("//a[@href='/professional-powerpoint-templates'][contains(.,'View All"));
		  Thread.sleep(3000); 
		js.executeScript("arguments[0].scrollIntoView();",footer_25);
		  footer_25.click();
		  log.info("FOOTER --> 27 || POPULAR PPT || VIEW ALL"); 
		  chat_pop_up();
		  Thread.sleep(1500); 
		  err_page();
		} catch(NoSuchElementException va) { }
	}
	
	// Popular Template 3
	
	@Then("Master Thesis PPT\\.$")
	public void Master_Thesis_PPT() throws InterruptedException {
		
		try {
		 WebElement footer_26= driver.findElement(By.xpath("//a[@href='/master-thesis-defense-structure-powerpoint-presentation-slides.html'][contains(.,'Master Thesis PPT"));
		  Thread.sleep(3000); 
		js.executeScript("arguments[0].scrollIntoView();",footer_26);
		  footer_26.click();
		  log.info("FOOTER --> 28 || POPULAR PPT || Master Thesis PPT"); 
		  chat_pop_up();
		  Thread.sleep(1500); 
		  err_page();
		} catch(NoSuchElementException mtp) { }
	}
	
	@Then("Org Structure PPT\\.$")
	public void Org_Structure_PPT() throws InterruptedException {
		
		try {
		 WebElement footer_27= driver.findElement(By.xpath("//a[@href='/powerpoint-presentation-essentials/organizational-structure-slides.html'][contains(.,'Org Structure PPT"));
		  Thread.sleep(3000); 
		js.executeScript("arguments[0].scrollIntoView();",footer_27);
		  footer_27.click();
		  log.info("FOOTER --> 29 || POPULAR PPT || Org Structure PPT"); 
		  chat_pop_up();
		  Thread.sleep(1500); 
		  err_page();
		} catch(NoSuchElementException osp) { }
	}
	
	@Then("PPT Table Design\\.$")
	public void PPT_Table_Design() throws InterruptedException {
		
		try {
		 WebElement footer_28= driver.findElement(By.xpath("//a[@href='/flat-design-diagrams/tables-matrix-flat-designs.html'][contains(.,'PPT Table Design"));
		  Thread.sleep(3000); 
		js.executeScript("arguments[0].scrollIntoView();",footer_28);
		  footer_28.click();
		  log.info("FOOTER --> 30 || POPULAR PPT || PPT Table Design"); 
		  chat_pop_up();
		  Thread.sleep(1500); 
		  err_page();
		} catch(NoSuchElementException ptd) { }
	}
	
	@Then("Sample PPT\\.$")
	public void Sample_PPT() throws InterruptedException {
		
		try {
		 WebElement footer_29= driver.findElement(By.xpath("//a[@href='/sample-powerpoint-career-portfolio-powerpoint-presentation-slides.html'][contains(.,'Sample PPT"));
		  Thread.sleep(3000); 
		js.executeScript("arguments[0].scrollIntoView();",footer_29);
		  footer_29.click();
		  log.info("FOOTER --> 31 || POPULAR PPT || Sample PPT"); 
		  chat_pop_up();
		  Thread.sleep(1500); 
		  err_page();
		} catch(NoSuchElementException spp) { }
	}
	
	@Then("Swimlane Templates\\.$")
	public void Swimlane_Templates() throws InterruptedException {
		
		try {
		 WebElement footer_30= driver.findElement(By.xpath("//a[@href='/powerpoint-presentation-essentials/swimlanes-ppt-templates.html'][contains(.,'Swimlane Templates"));
		  Thread.sleep(3000); 
		js.executeScript("arguments[0].scrollIntoView();",footer_30);
		  footer_30.click();
		  log.info("FOOTER --> 32 || POPULAR PPT || Swimlane Templates"); 
		  chat_pop_up();
		  Thread.sleep(1500); 
		  err_page();
		} catch(NoSuchElementException stp) { }
	}
	
	@Then("PPT Backgrounds\\.$")
	public void PPT_Backgrounds() throws InterruptedException {
		
		try {
		 WebElement footer_31= driver.findElement(By.xpath("//a[@href='/powerpoint-templates/background.html'][contains(.,'PPT Backgrounds"));
		  Thread.sleep(3000); 
		js.executeScript("arguments[0].scrollIntoView();",footer_31);
		  footer_31.click();
		  log.info("FOOTER --> 33 || POPULAR PPT || PPT Backgrounds"); 
		  chat_pop_up();
		  Thread.sleep(1500); 
		  err_page();
		} catch(NoSuchElementException pbp) { }
	}
	
	@Then("View All 3\\.$")
	public void View_All_3() throws InterruptedException {
		
		try {
		 WebElement footer_32= driver.findElement(By.xpath("//a[@href='/professional-powerpoint-templates'][contains(.,'View All"));
		  Thread.sleep(3000); 
		js.executeScript("arguments[0].scrollIntoView();",footer_32);
		  footer_32.click();
		  log.info("FOOTER --> 34 || POPULAR PPT || VIEW ALL"); 
		  chat_pop_up();
		  Thread.sleep(1500); 
		  err_page();
		} catch(NoSuchElementException vw) { }
		
	}
}
