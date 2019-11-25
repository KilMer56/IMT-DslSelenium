import seleniumDriver.TestSuite;

public class suite2Test {

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
		
		WebElement link1 = driver.findElements(By.partialLinkText(new String("TOUTES LES ACTUALIT�S").toUpperCase())).get(0);
		link1.click();
		WebElement link2 = driver.findElements(By.partialLinkText(new String("Accueil").toUpperCase())).get(0);
		Assert.assertNotNull(link2);
		
		
		driver.close();
	}
	
}
