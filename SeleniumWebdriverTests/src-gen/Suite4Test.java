import seleniumDriver.TestSuite;

public class suite4Test {

	public static void main(String[] args) { 
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		case4();
					
	}
	
		
	private static void case4() {
		boolean cookiesAlreadyChecked = false;
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://www.imt-atlantique.fr/fr/rechercher");
		if(!cookiesAlreadyChecked) {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='agree-button eu-cookie-compliance-default-button']"))).click(); //ACCEPT COOKIE
			cookiesAlreadyChecked = true;
		}
		
		WebElement field1 = driver.findElements(By.xpath("//input[id()='edit-rechercher']")).get(0);
		field1.sendKeys("Donald Trump");
		WebElement button2 = driver.findElements(By.xpath("//button[text()='Appliquer les filtres']")).get(0);
		button2.click();
		WebElement div3 = driver.findElements(By.xpath("//*[text()='Toutes les actualités']")).get(0);
		Assert.assertNotNull(div3);
		
		
		driver.close();
	}
	
}
