import seleniumDriver.TestSuite;

public class suite6Test {

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
		
		WebElement field1 = driver.findElements(By.xpath("//input[label()='Rechercher']")).get(0);
		field1.sendKeys("2007");
		WebElement combobox2 = driver.findElements(By.xpath("//*[label()='Période de publication']")).get(0);
		combobox2.click();
		WebElement button3 = driver.findElements(By.xpath("//button[text()='Appliquer les filtres']")).get(0);
		button3.click();
		WebElement div4 = driver.findElements(By.xpath("//*[text()='Aucun résultat ne correspond à votre recherche.']")).get(0);
		Assert.assertNotNull(div4);
		
		
		driver.close();
	}
	
}
