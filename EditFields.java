package week2.day1.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditFields {

	public static void main(String[] args) {
		// setup WebDriver
		WebDriverManager.chromedriver().setup();

		//open Browser
		ChromeDriver driver=new ChromeDriver();

		//load URL
		driver.get("http://www.leafground.com/pages/Edit.html");

		//maximizing window
		driver.manage().window().maximize();

		//Enter your Email Address
		driver.findElement(By.id("email")).sendKeys("kaviya@domain.com");

		//Append a text
		driver.findElement(By.xpath("(//div[@class='row']//input)[2]")).sendKeys(" Text");

		//Get default text entered
		String value = driver.findElement(By.name("username")).getAttribute("value");
		System.out.println(value);

		//Clear the text
		driver.findElement(By.xpath("//label[text()='Clear the text']/following-sibling::input")).clear();

		//Confirm that edit field is disabled
		boolean displayed = driver.findElement(By.xpath("//label[text()='Confirm that edit field is disabled']/following-sibling::input")).isDisplayed();
		System.out.println(displayed);

	}

}
