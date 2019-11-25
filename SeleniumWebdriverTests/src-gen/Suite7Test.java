import seleniumDriver.TestSuite;

public class suite7Test {

	public static void main(String[] args) { 
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		case7();
					
	}
	
		
	private static void case7() {
		boolean cookiesAlreadyChecked = false;
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://www.imt-atlantique.fr/fr");
		if(!cookiesAlreadyChecked) {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='agree-button eu-cookie-compliance-default-button']"))).click(); //ACCEPT COOKIE
			cookiesAlreadyChecked = true;
		}
		
		String myTitle = driver.findElements(By.className("actu_home_ctner_inner_cell1_titre")).get(0).getText();
		WebElement div1 = driver.findElements(By.className("actu_home_ctner_inner_cell1_titre")).get(0);
		div1.click();
		String title2 = driver.getTitle()
		Assert.assertTrue(title2.contains(myTitle));
		
		
		driver.close();
	}
	
}
