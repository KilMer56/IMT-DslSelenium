import java.util.List;
import java.util.concurrent.TimeUnit;
	
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
	
import org.junit.Assert;  
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
	
public class Suite8Test {

	public static void main(String[] args) { 
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		case8();
					
	}
	
		
	private static void case8() {
		boolean cookiesAlreadyChecked = false;
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://www.imt-atlantique.fr/fr");
		if(!cookiesAlreadyChecked) {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='agree-button eu-cookie-compliance-default-button']"))).click(); //ACCEPT COOKIE
			cookiesAlreadyChecked = true;
		}
		
		String myTitle = driver.findElements(By.className("actu_home_ctner_inner_cell1_titre")).get(2).getText();
		WebElement myUrl = driver.findElements(By.className("actu_home_ctner_inner_cell1_titre")).get(2);
		driver.get("http://www.imt-atlantique.fr/fr/rechercher");
		if(!cookiesAlreadyChecked) {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='agree-button eu-cookie-compliance-default-button']"))).click(); //ACCEPT COOKIE
			cookiesAlreadyChecked = true;
		}
		
		WebElement field1 = driver.findElements(By.xpath("//input[@id='edit-search-api-fulltext']")).get(0);
		field1.sendKeys(myTitle);
		WebElement button2 = driver.findElements(By.xpath("//button[@value='Appliquer les filtres']")).get(0);
		button2.click();
		WebElement link3 = driver.findElements(By.partialLinkText("" + myUrl+" ")).get(0);
		Assert.assertNotNull(link3);
		
		
		driver.close();
	}
	
}
