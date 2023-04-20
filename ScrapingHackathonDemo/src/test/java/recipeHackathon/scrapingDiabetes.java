package recipeHackathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Test
public class scrapingDiabetes {
	WebDriver driver;
	@BeforeTest
	public void beforeTest() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.navigate().to("https://www.tarladalal.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
    @Test
	public void searchRecipe() {
	driver.findElement(By.id("ctl00_txtsearch")).sendKeys("Vegan diabetic");
	driver.findElement(By.id("ctl00_imgsearch")).click();
	}
	
		
	
}
