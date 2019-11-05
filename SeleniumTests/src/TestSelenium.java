import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Assert;  
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class TestSelenium {

	public static void main(String[] args) {
		
		//setting the driver executable
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mer\\Documents\\Selenium\\chromedriver.exe");
		
		test1();
		test2();
		test7();
	}
	
	private static void test1() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://www.imt-atlantique.fr");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='Toutes les actualités']"));
		
		Assert.assertNotNull(link);
		
		driver.close();
	}
	
	private static void test2() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		
		driver.get("https://www.imt-atlantique.fr");
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Toutes les actualités']"))).click();
		
		WebElement click = driver.findElement(By.xpath("//a[text()='Toutes les actualités']"));
		click.click();
		
		WebElement link = driver.findElement(By.xpath("//a[text()='Accueil']"));
		
		Assert.assertNotNull(link);
		
		driver.close();
	}
	
	private static void test7() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://www.imt-atlantique.fr");
		
		String text = driver.findElements(By.xpath("//*[@class='actu_home_ctner_inner_cell1_titre']")).get(0).getText();
		driver.findElements(By.xpath("//*[@class='actu_home_ctner_inner_cell1_titre']/parent::a")).get(0).click();
		
		WebElement find = driver.findElement(By.xpath("//title"));
		
		Assert.assertNotNull(find);
		Assert.assertTrue(find.getText().contains(text));
		
		driver.close();
	}

}