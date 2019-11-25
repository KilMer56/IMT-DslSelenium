import java.util.List;
import java.util.concurrent.TimeUnit;
	
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
	
import org.junit.Assert;  
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
	
public class Suite2Test {

	public static void main(String[] args) { 
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		case2();
					
	}
	
		
	private static void case2() {
		boolean cookiesAlreadyChecked = false;
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://www.imt-atlantique.fr/fr");
		if(!cookiesAlreadyChecked) {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='agree-button eu-cookie-compliance-default-button']"))).click(); //ACCEPT COOKIE
			cookiesAlreadyChecked = true;
		}
		
		WebElement link1 = driver.findElements(By.partialLinkText("TOUTES LES ACTUALITÉS")).get(0);
		link1.click();
		WebElement link2 = driver.findElements(By.partialLinkText("Accueil")).get(0);
		Assert.assertNotNull(link2);
		
		
		driver.close();
	}
	
}
