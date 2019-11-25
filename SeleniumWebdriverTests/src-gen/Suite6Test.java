import java.util.List;
import java.util.concurrent.TimeUnit;
	
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
	
import org.junit.Assert;  
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
	
public class Suite6Test {

	public static void main(String[] args) { 
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		case6();
					
	}
	
		
	private static void case6() {
		boolean cookiesAlreadyChecked = false;
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://www.imt-atlantique.fr/fr/rechercher");
		if(!cookiesAlreadyChecked) {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='agree-button eu-cookie-compliance-default-button']"))).click(); //ACCEPT COOKIE
			cookiesAlreadyChecked = true;
		}
		
		WebElement field1 = driver.findElements(By.xpath("//input[@id='edit-search-api-fulltext']")).get(0);
		field1.sendKeys("2007");
		WebElement div2 = driver.findElements(By.xpath("//*[@id='recherche-date-range']")).get(0);
		div2.click();
		WebElement combobox3 = driver.findElements(By.xpath("//li[contains(text(),'Le mois dernier')]")).get(0);
		combobox3.click();
		WebElement field4 = driver.findElements(By.xpath("//input[@value='Appliquer les filtres']")).get(0);
		field4.click();
		WebElement div5 = driver.findElements(By.xpath("//*[contains(text(),'Aucun résultat ne correspond à votre recherche')]")).get(0);
		Assert.assertNotNull(div5);
		
		System.out.println("SUCESS !!!!!");
		driver.close();
	}
	
}
