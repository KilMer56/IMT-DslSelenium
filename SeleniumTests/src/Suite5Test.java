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
		
		List<WebElement> checkbox1 = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(WebElement checkBox:checkbox1){
		if(checkBox.isSelected()) checkBox.click(); 
		}
		WebElement checkbox2 = driver.findElements(By.xpath("//*[text()='Anglais']")).get(0);
		if ( !checkbox2.isSelected() ){checkbox2.click();}
		WebElement checkbox3 = driver.findElements(By.xpath("//*[text()='A domicile']")).get(0);
		if ( !checkbox3.isSelected() ){checkbox3.click();}
		WebElement checkbox4 = driver.findElements(By.xpath("//*[text()='Temps plein']")).get(0);
		if ( !checkbox4.isSelected() ){checkbox4.click();}
		WebElement field5 = driver.findElements(By.xpath("//input[@value='Appliquer les critères']")).get(0);
		field5.click();
		WebElement div6 = driver.findElements(By.xpath("//*[contains(text(),'No found course matching your criteria.')]")).get(0);
		Assert.assertNotNull(div6);
		
		System.out.println("SUCESS !!!!!");
		driver.close();
	}
	
}
