package week2.day1.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// setup WebDriver
		WebDriverManager.chromedriver().setup();

		//open Browser
		ChromeDriver driver=new ChromeDriver();

		//load URL
		driver.get("http://leaftaps.com/opentaps/control/login");

		//maximizing window
		driver.manage().window().maximize();

		//Enter username and password and click login button
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		//Click on the CRM/SFA link
		driver.findElementByLinkText("CRM/SFA").click();

		//Click on Leads & Create Lead button
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Create Lead").click();

		//Enter the details
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Capgemini");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Kaviya");
		WebElement element1 = driver.findElement(By.id("createLeadForm_lastName"));
		element1.sendKeys("Murugesan");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("KAVIYA");
		driver.findElement(By.name("departmentName")).sendKeys("QA/Analyst");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("3 years of experience");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("kaviya@domain.com");
		WebElement state = driver.findElement(By.name("generalStateProvinceGeoId"));
		Select obj=new Select(state);
		obj.selectByVisibleText("New York");
		Thread.sleep(2000);

		//Click on create button
		driver.findElement(By.name("submitButton")).click();
		
		//Click on Edit Button and make the changes
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_description")).clear();
		driver.findElement(By.name("importantNote")).sendKeys("Manual tester");
		Thread.sleep(2000);
		
		//Click on Update button
		driver.findElement(By.name("submitButton")).click();
		
		//Get the title of the resulting Page
		String title = driver.getTitle();
		System.out.println(title);
	}

}
