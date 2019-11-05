import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class TestSelenium {

	public static void main(String[] args) {
		
		//setting the driver executable
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mer\\Documents\\Selenium\\chromedriver.exe");
		
		//test1();
		//test2();
		test7();
	}
	
	private static void test1() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		driver.get("https://www.imt-atlantique.fr");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='Toutes les actualités']"));
		
		System.out.println(link.getAttribute("href"));
		
		driver.close();
	}
	
	private static void test2() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		driver.get("https://www.imt-atlantique.fr");
		
		driver.findElement(By.xpath("//a[text()='Toutes les actualités']")).click();
		
		WebElement link = driver.findElement(By.xpath("//a[text()='Accueil']"));
		
		System.out.println(link.getAttribute("href"));
		
		driver.close();
	}
	
	private static void test7() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		driver.get("https://www.imt-atlantique.fr");
		
		List<WebElement> elems = driver.findElements(By.xpath("//*[@class='actu_home_ctner_inner_cell1_titre']"));
		
		System.out.println(elems);
		
		driver.close();
	}

}