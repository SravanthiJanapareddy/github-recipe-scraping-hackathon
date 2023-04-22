package recipeHackathon;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HyperTension {

	WebDriver driver;

	@BeforeTest
	public void setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.tarladalal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test
	public void getRecipeID() {

		List<WebElement> allRecipes;
		List<String> allRecipeNames = new ArrayList<String>();

		String recipeLinks;
		String recipeName;
		String recipeURL;
		String recipeID;
		String extractRecipeID;

		driver.findElement(By.id("ctl00_txtsearch")).sendKeys("High Blood Pressure");
		driver.findElement(By.id("ctl00_imgsearch")).click();
		driver.findElement(By.xpath("//a[text()='Healthy Indian Recipes > High Blood Pressure > ']")).click();

//		recipeID = driver.findElement(By.xpath("(//div[@class='rcc_rcpno']/span)[1]")).getText();

		for (int i = 1; i <= 5; i++) {

			recipeLinks = "//div[@id='pagination']/a[text()='" + i + "']";
			driver.findElement(By.xpath(recipeLinks)).click();
			allRecipes = driver.findElements(By.xpath("//span[@class='rcc_recipename']//a"));

			recipeID = driver.findElement(By.xpath("(//div[@class='rcc_rcpno']/span)['" + i + "']")).getText();

			for (WebElement recipeLink : allRecipes) {
				allRecipeNames.add(recipeLink.getText());
				allRecipeNames.add(recipeLink.getAttribute("href"));
				allRecipeNames.add(recipeID);
			}

		}
		for (String eachrecipe : allRecipeNames) {
			System.out.println(eachrecipe);

		}
		for ( int i = 0; i < 10; i++ ) {
			System.out.println(i);
		}
	}

}