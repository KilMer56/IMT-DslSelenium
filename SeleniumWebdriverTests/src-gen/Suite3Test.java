import seleniumDriver.TestSuite;

public class suite3Test {

	public static void main(String[] args) { 
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		case3();
					
	}
	
		
	private static void case3() {
		boolean cookiesAlreadyChecked = false;
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://www.imt-atlantique.fr/fr");
		if(!cookiesAlreadyChecked) {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='agree-button eu-cookie-compliance-default-button']"))).click(); //ACCEPT COOKIE
			cookiesAlreadyChecked = true;
		}
		
		WebElement link1 = driver.findElements(By.partialLinkText(new String("TOUTES LES ACTUALITÉS").toUpperCase())).get(0);
		link1.click();
		WebElement image2 = driver.findElements(By.xpath("//img[@alt='Accueil']")).get(0);
		image2.click();
		WebElement link3 = driver.findElements(By.partialLinkText(new String("TOUTES LES ACTUALITÉS").toUpperCase())).get(0);
		Assert.assertNotNull(link3);
		
		
		driver.close();
	}
	
}
