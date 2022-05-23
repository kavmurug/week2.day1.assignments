package week2.day1.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BondWithButtons {

	public static void main(String[] args) {
		// setup WebDriver
		WebDriverManager.chromedriver().setup();

		//open Browser
		ChromeDriver driver=new ChromeDriver();

		//load URL
		driver.get("http://www.leafground.com/pages/Button.html");

		//maximizing window
		driver.manage().window().maximize();
		
		//Click button to travelhome page
		driver.findElement(By.id("home")).click();
		driver.findElement(By.xpath("//a[@class='wp-categories-link maxheight']/following::a/img")).click();
		
		//Find Position of Button(x,y)
		Point location = driver.findElement(By.xpath("//button[@id='position']")).getLocation();
		System.out.println(location);
		
		//Find Button colour
		String colour = driver.findElement(By.xpath("//label[text()='Find button color']/following-sibling::button")).getCssValue("background-color");
        System.out.println(colour);
        
        //Find Height and Width
        Dimension size = driver.findElement(By.id("size")).getSize();
        System.out.println(size);
	}

}
