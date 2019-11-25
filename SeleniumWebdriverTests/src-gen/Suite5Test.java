import java.util.List;
import java.util.concurrent.TimeUnit;
	
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
	
import org.junit.Assert;  
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
	
public class Suite5Test {

	public static void main(String[] args) { 
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		case5();
					
	}
	
		
	private static void case5() {
		boolean cookiesAlreadyChecked = false;
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://www.imt-atlantique.fr/fr/formation/trouver-ma-formation");
		if(!cookiesAlreadyChecked) {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='agree-button eu-cookie-compliance-default-button']"))).click(); //ACCEPT COOKIE
			cookiesAlreadyChecked = true;
		}
		
		WebElement checkbox1 = driver.findElements(By.tagName("*")).get(0);
		if ( checkbox1.isSelected() ){checkbox1.click();}
		WebElement checkbox2 = driver.findElements(By.xpath("//*[label()='Anglais']")).get(0);
		if ( !checkbox2.isSelected() ){checkbox2.click();}
		WebElement checkbox3 = driver.findElements(By.xpath("//*[label()='A domicile']")).get(0);
		if ( !checkbox3.isSelected() ){checkbox3.click();}
		WebElement checkbox4 = driver.findElements(By.xpath("//*[label()='Temps plein']")).get(0);
		if ( !checkbox4.isSelected() ){checkbox4.click();}
		WebElement button5 = driver.findElements(By.xpath("//button[text()='Appliquer les critéres']")).get(0);
		button5.click();
		WebElement div6 = driver.findElements(By.xpath("//*[text()='No found course matching your criteria.']")).get(0);
		Assert.assertNotNull(div6);
		
		
		driver.close();
	}
	
}
