package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class protractor_promise {
	
	@Test
	public void testBasic() {
	
		// Initialize browser
		WebDriver driver=new ChromeDriver();
		 
		// Open facebook
		driver.get("http://juliemr.github.io/protractor-demo/");
		 
		// Maximize browser
		 
		driver.manage().window().maximize();
		System.out.println("Title of page --"+driver.getTitle());
	}
}
