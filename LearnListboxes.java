package week2.day1.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnListboxes {

	public static void main(String[] args) {
		// setup Webdriver
		WebDriverManager.chromedriver().setup();

		//open Browser
		ChromeDriver driver=new ChromeDriver();

		//load URL
		driver.get("http://www.leafground.com/pages/Dropdown.html");

		//maximizing window
		driver.manage().window().maximize();

		//Select training Program using Index
		WebElement index = driver.findElement(By.id("dropdown1"));
		Select obj=new Select(index);
		obj.selectByIndex(2);

		//Select training Program using visible text
		WebElement text = driver.findElement(By.name("dropdown2"));
		Select obj1=new Select(text);
		obj1.selectByVisibleText("UFT/QTP");

		//Select training Program using value
		WebElement value = driver.findElement(By.name("dropdown3"));
		Select obj2=new Select(value);
		obj2.selectByValue("4");

		//Get the number of dropdown options
		WebElement options = driver.findElement(By.className("dropdown"));
		Select obj3=new Select(options);
		List<WebElement> options2 = obj3.getOptions();
		int size = options2.size();
		System.out.println(size);

		//Sendkeys to select options
		WebElement keys = driver.findElement(By.xpath("//select[@class='dropdown']/following::select"));
		keys.sendKeys("Selenium");

		//Selecting multiple programs
		WebElement multiple = driver.findElement(By.xpath("//select[@class='dropdown']/following::select/following::select"));
		Select obj4=new Select(multiple);
		if(obj4.isMultiple())
		{
			obj4.selectByIndex(1);
			obj4.selectByValue("2");	
		}
	}
}
