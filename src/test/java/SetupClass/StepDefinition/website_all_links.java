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

public class website_all_links extends Setup {
	
	WebDriverWait wait = new WebDriverWait(driver,50);
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
	
	@Given("^Open the Website URL\\.$")
	public void open_the_Website_URL() throws InterruptedException {
		
		driver.get(AppURL);
	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	log.info("It's opening the website URL");
	Thread.sleep(1000);
	//driver.get("https://www.slideteam.net");
	//Thread.sleep(2000);
	
         driver.manage().deleteAllCookies();
	Thread.sleep(4000); // wait 4 seconds to clear cookies.
	driver.navigate().refresh();
	Thread.sleep(2000);
	 driver.get("https://www.slideteam.net");
	//Thread.sleep(2000);
         Thread.sleep(2000);
	try {
		driver.findElement(By.cssSelector(".authorization-link > a:nth-child(1)")).click();
		Thread.sleep(2000);
		log.info("It's opening the website URL");
	} 
	catch (NoSuchElementException popup) {
	}
	}

	@Then("^user enter email and password epu$")
       public void user_enter_email_and_password_epu() throws InterruptedException  {
                Thread.sleep(2000);
	        WebElement old_paid_email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[2]/div[2]/form/fieldset/div[2]/div/input")));
               old_paid_email.sendKeys("sakshi.pathania@slidetech.in");
    
               WebElement old_paid_pass = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[2]/div[2]/form/fieldset/div[3]/div/input")));
               old_paid_pass.sendKeys("Qwerty@1");
	       
	       Thread.sleep(3000);
	       WebElement old_paid_login_btn=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.login > span:nth-child(1)")));
	       old_paid_login_btn.click();
	       if (!driver.findElements(By.xpath("//div[@class='login-attempt-popup']")).isEmpty()) {
				WebElement approve = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='confirm-approve']")));
				approve.click();
			}
	       
        } 
	
	@Then("^Pricing Page\\.$")
	public void Pricing_Page() throws Throwable {
	    
		WebElement price = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='menu-link'][contains(.,'Pricing')]")));
		///clear_cache();
		Thread.sleep(3000);
		price.click();
		log.info("PRICING");
		Thread.sleep(3000);
		chat_pop_up();
		err_page();
		
	}
        
	@Then("^Free PPTs Page\\.$")
	public void Free_PPTs_Page() throws Throwable {
	    
		/*WebElement free_ppt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='menu-link'][contains(.,'Free PPTs')]")));
		clear_cache();
		Thread.sleep(3000);
		free_ppt.click();
		log.info("FREE PPT");
		Thread.sleep(3000);
		chat_pop_up();
		err_page(); */
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		WebElement free_ppt_btn1=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Free Stuff")));
		actions.moveToElement(free_ppt_btn1).moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Free PPTs')]"))).click().build().perform();
		Thread.sleep(7000);

                WebElement free_ppt_btn2=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Free Stuff")));
		actions.moveToElement(free_ppt_btn2).moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Free Business PPTs')]"))).click().build().perform();
		Thread.sleep(7000);
		 
	}
	
	@Then("^Popular PPT Page\\.$")
	public void Popular_PPT_Page() throws Throwable {
		WebElement Popular_ppt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='menu-link'][contains(.,'Popular PPTs')]")));
		//clear_cache();
		Thread.sleep(3000);
		Popular_ppt.click();
		log.info("Popular PPTs");
		Thread.sleep(3000);
		chat_pop_up();
		err_page();
	}
	
	@Then("^Template Finder Page\\.$")
	public void Template_Finder_Page() throws Throwable {
		WebElement template_finder= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='menu-link'][contains(.,'Template Finder')]")));
		//clear_cache();
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView();",template_finder);
		template_finder.click();
		log.info("TEMPLATE FINDER");
		Thread.sleep(3000);
		chat_pop_up();
		err_page();
	}





	@Then("^Blog Page\\.$")
	public void Blog_Page() throws Throwable {
		WebElement blog_page = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='menu-link'][contains(.,'Blog')]")));
		//clear_cache();
		Thread.sleep(3000);
		blog_page.click();
		log.info("BLOG");
		Thread.sleep(3000);
		chat_pop_up();
		err_page();
		
		Thread.sleep(4000);
		WebElement eBooks = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='menu-link'][contains(.,'eBooks')]")));
		//clear_cache();
		Thread.sleep(3000);
		eBooks.click();
		log.info("EBOOKS");
		Thread.sleep(3000);
		chat_pop_up();
		err_page();
		/*Thread.sleep(5000);
		Actions actions = new Actions(driver);
		WebElement Learn_btn1=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Learn")));
		actions.moveToElement(Learn_btn1).moveToElement(driver.findElement(By.xpath("//a[contains(text(),'eBooks')]"))).click().build().perform();
		Thread.sleep(7000);
		
		Thread.sleep(5000);
		//Actions actions = new Actions(driver);
		WebElement Learn_btn2=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Learn")));
		actions.moveToElement(Learn_btn2).moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Blog')]"))).click().build().perform();
		Thread.sleep(7000);
		
		Thread.sleep(5000);
		//Actions actions = new Actions(driver);
		WebElement Our_Services_btn1=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Our Services")));
		actions.moveToElement(Our_Services_btn1).moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Design Services')]"))).click().build().perform();
		Thread.sleep(7000);
		
		Thread.sleep(5000);
		//Actions actions = new Actions(driver);
		WebElement Our_Services_btn2=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Our Services")));
		actions.moveToElement(Our_Services_btn2).moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Research Services')]"))).click().build().perform();
		Thread.sleep(7000);*/
	}
	
	

	/*@Then("^Free Business PPTs Page\\.$")
	public void free_Business_PPTs_Page() throws Throwable {
		WebElement free_business_ppt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='menu-link'][contains(.,'Free Business PPTs')]")));
		clear_cache();
		Thread.sleep(3000);
		free_business_ppt.click();
		log.info("FREE BUSINESS PPT");
		Thread.sleep(3000);
		chat_pop_up();
		err_page();
	} */

	@Then("^Presentation Services Page\\.$")
	public void Presentation_Services_Page() throws Throwable {
		WebElement Presentation_Services= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='menu-link'][contains(.,'Presentation Services')]")));
		//clear_cache();
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView();",Presentation_Services);
		Presentation_Services.click();
		log.info("PRESENTATION SERVICES");
		Thread.sleep(3000);
		chat_pop_up();
		err_page();
	}
	
	@Then("^Research Services\\.$")
	public void Research_Services() throws Throwable {
		WebElement Research_Services= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='menu-link'][contains(.,'Research Services')]")));
		//clear_cache();
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView();",Research_Services);
		Research_Services.click();
		log.info("RESEARCH SERVICES");
		Thread.sleep(3000);
		chat_pop_up();
		err_page();
	}


	@Then("^About Us Page\\.$")
	public void About_Us_Page() throws Throwable {
		try {
		WebElement about_us_footer= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title=' About Us'][contains(.,'About Us')]")));
		//clear_cache();
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView();",about_us_footer);
		about_us_footer.click();
		log.info("FOOTER --> ABOUT US");
		Thread.sleep(3000);
		chat_pop_up();
		err_page();
		}
	    catch (Exception e) {
		}
	}


	@Then("^Site Map Page\\.$")
	public void Site_Map_Page() throws Throwable {
		WebElement site_map_footer= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Site Map'][contains(.,'Site Map')]")));
		//clear_cache();
		js.executeScript("arguments[0].scrollIntoView();",site_map_footer);
		Thread.sleep(3000);
		site_map_footer.click();
		log.info("FOOTER --> SITE MAP");
		Thread.sleep(3000);
		chat_pop_up();
		err_page();
	}

	@Then("^Contact Us Page\\.$")
	public void Contact_Us_Page() throws Throwable {
		WebElement contact_us_footer= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title=' Contact Us'][contains(.,'Contact Us')]")));
		//clear_cache();
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView();",contact_us_footer);
		contact_us_footer.click();
		log.info("FOOTER --> CONTACT US");
		Thread.sleep(3000);
		chat_pop_up();
		err_page();
	}

	@Then("^FAQ Page\\.$")
	public void FAQ_Page() throws Throwable {
		WebElement faq_footer= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='FAQ'][contains(.,'FAQ')]")));
		//clear_cache();
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView();",faq_footer);
		faq_footer.click();
		log.info("FOOTER --> FAQ");
		Thread.sleep(3000);
		chat_pop_up();
		err_page();
	}

	@Then("^Terms of Use Page\\.$")
	public void Terms_of_Use_Page() throws Throwable {
		WebElement terms_footer= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title=' Terms of Use'][contains(.,'Terms of Use')]")));
		//clear_cache();
		js.executeScript("arguments[0].scrollIntoView();",terms_footer);
		Thread.sleep(3000);
		terms_footer.click();
		log.info("FOOTER --> TERMS OF USE");
		Thread.sleep(3000);
		chat_pop_up();
		err_page();
	}

	@Then("^Privacy Policy Page\\.$")
	public void Privacy_Policy_Page() throws Throwable {
		WebElement p_policy_footer= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Privacy Policy'][contains(.,'Privacy Policy')]")));
		//clear_cache();
		js.executeScript("arguments[0].scrollIntoView();",p_policy_footer);
		Thread.sleep(3000);
		p_policy_footer.click();
		log.info("FOOTER --> PRIVACY POLICY");
		Thread.sleep(3000);
		chat_pop_up();
		err_page();
	}

	@Then("^Popular Free Slides Page\\.$")
	public void Popular_Free_Slides_Page() throws Throwable {
		WebElement popular_free_footer= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/footer/div/div/div[2]/div/div[6]/ul/li[7]/a")));
		Thread.sleep(3000);
		//clear_cache();
		js.executeScript("arguments[0].scrollIntoView();",popular_free_footer);
		popular_free_footer.click();
		log.info("FOOTER --> POPULAR FREE SLIDES");
		Thread.sleep(3000);
		chat_pop_up();
		err_page();
	}
	
	@Then("^Custom Design Services Page\\.$")
	public void Custom_Design_Services_Page() throws Throwable {
		WebElement cds_footer= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Business Slides'][contains(.,'Custom Design Services')]")));
		Thread.sleep(3000);
		//clear_cache();
		js.executeScript("arguments[0].scrollIntoView();",cds_footer);
		cds_footer.click();
		log.info("FOOTER --> CUSTOM DESIGN SERVICES");
		Thread.sleep(3000);
		chat_pop_up();
		err_page();
	}

	
	@Then("^Resume Services Page\\.$")
	public void Resume_Services_Page() throws Throwable {
		WebElement Resume_footer= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Resume Services'][contains(.,'Resume Services')]")));
		Thread.sleep(3000);
		//clear_cache();
		js.executeScript("arguments[0].scrollIntoView();",Resume_footer);
		Resume_footer.click();
		log.info("FOOTER --> RESUME SERVICES");
		Thread.sleep(2000);
		driver.get("https://www.slideteam.net/");
		Thread.sleep(3000);
		chat_pop_up();
		err_page();
	}

	@Then("^Google Slides Page\\.$")
	public void Google_Slides_Page() throws Throwable {
		WebElement g_slide_footer= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Google Slides'][contains(.,'Google Slides')]")));
		Thread.sleep(3000);
		//clear_cache();
		js.executeScript("arguments[0].scrollIntoView();",g_slide_footer);
		g_slide_footer.click();
		log.info("FOOTER --> GOOGLE SLIDES");
		Thread.sleep(3000);
		chat_pop_up();
		err_page();
	}
	
		@Then("^Coupon Code\\.$")
	public void Coupon_Code() throws Throwable {
		WebElement CC_footer= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Coupon Code'][contains(.,'Coupon Code')]")));
		Thread.sleep(3000);
		//clear_cache();
		js.executeScript("arguments[0].scrollIntoView();",CC_footer);
		CC_footer.click();
		log.info("FOOTER --> COUPON CODE");
		Thread.sleep(3000);
		chat_pop_up();
		err_page();
	}
	
		@Then("^Newly Added\\.$")
	public void Newly_Added() throws Throwable {
		WebElement nd_footer= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Newly Added'][contains(.,'Newly Added')]")));
		Thread.sleep(3000);
		//clear_cache();
		js.executeScript("arguments[0].scrollIntoView();",nd_footer);
		nd_footer.click();
		log.info("FOOTER --> NEWLY ADDED");
		Thread.sleep(3000);
		chat_pop_up();
		err_page();
	}
	
               @Then("^Color PPT\\.$")
	public void Color_PPT() throws Throwable {
		WebElement color_footer= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/footer/div/div/div[2]/div/div[2]/ul/li[1]/a")));
		Thread.sleep(3000);
		//clear_cache();
		js.executeScript("arguments[0].scrollIntoView();",color_footer);
		color_footer.click();
		log.info("FOOTER --> COLOR PPT");
		Thread.sleep(3000);
		chat_pop_up();
		err_page();
	}
	
	       @Then("^Google Powerpoint\\.$")
	public void Google_Powerpoint() throws Throwable {
		WebElement Google_footer= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/footer/div/div/div[2]/div/div[2]/ul/li[4]/a")));
		Thread.sleep(3000);
	//	clear_cache();
		js.executeScript("arguments[0].scrollIntoView();",Google_footer);
		Google_footer.click();
		log.info("FOOTER --> GOOGLE POWERPOINT");
		Thread.sleep(3000);
		chat_pop_up();
		err_page();
		
	}
	
	      @Then("^Highlight Picture PPT\\.$")
	public void Highlight_Picture_PPT() throws Throwable {
		WebElement Highlight_footer= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/footer/div/div/div[2]/div/div[2]/ul/li[7]/a")));
		Thread.sleep(3000);
		//clear_cache();
		js.executeScript("arguments[0].scrollIntoView();",Highlight_footer);
		Highlight_footer.click();
		log.info("FOOTER --> HIGHLIGHT PICTURE PPT");
		Thread.sleep(3000);
		chat_pop_up();
		err_page();
		
	}
	
	@Then("^PPT Zoom Image\\.$")
	public void PPT_Zoom_Image() throws Throwable {
		WebElement Zoom_footer= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/footer/div/div/div[2]/div/div[2]/ul/li[11]/a")));
		Thread.sleep(3000);
		//clear_cache();
		js.executeScript("arguments[0].scrollIntoView();",Zoom_footer);
		Zoom_footer.click();
		log.info("FOOTER --> PPT ZOOM IMAGE");
		Thread.sleep(3000);
		chat_pop_up();
		err_page();
		
	}
        
	@Then("^PPT Puzzle Pieces\\.$")
	public void PPT_Puzzle_Pieces() throws Throwable {
		WebElement Puzzle_footer= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/footer/div/div/div[2]/div/div[2]/ul/li[14]/a")));
		Thread.sleep(3000);
		//clear_cache();
		js.executeScript("arguments[0].scrollIntoView();",Puzzle_footer);
		Puzzle_footer.click();
		log.info("FOOTER --> PPT PUZZLE PIECES");
		Thread.sleep(3000);
		chat_pop_up();
		err_page();
		clear_cache();
		
		
	}


}
