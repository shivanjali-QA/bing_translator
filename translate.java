package bing_translator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class translate {
	
	WebDriver webdriver;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\shivanjalisingh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		webdriver = new ChromeDriver();
		webdriver.get("https://www.bing.com/translator");
	}
	
	 @Test(priority=0)

	 public void englishToFrench() throws InterruptedException 
	   
	 {
	  Select select = new Select(webdriver.findElement(By.id("t_sl")));
	  select.selectByValue("en");
	 
	  webdriver.findElement(By.id("t_sv")).sendKeys("hello, this is shivanjali");
	  Select o = new Select(webdriver.findElement(By.id("t_tl")));
	  o.selectByValue("fr");
	  Thread.sleep(5000);
	  
	  JavascriptExecutor t=(JavascriptExecutor)webdriver;
      String p=(String) t.executeScript("return document.querySelector('textArea#t_tv').value");
      System.out.println(p);
	Assert.assertEquals("Bonjour, c'est shivanjali", p);
	
}
	 @Test(priority=1)
		public void reverseButton() {
			
			Select o = new Select(webdriver.findElement(By.id("t_tl")));
			o.selectByValue("fr");
			
			webdriver.findElement(By.id("t_revIcon")).click();
			
			JavascriptExecutor q=(JavascriptExecutor)webdriver;
			 String v=(String) q.executeScript("return document.querySelector('select#t_sl').value");
			System.out.println(v);
			
			Assert.assertEquals("fr",v);
			
		}
		@AfterTest
		public void closeBrowser() throws InterruptedException {
			Thread.sleep(10000);
			webdriver.quit();
		}

}