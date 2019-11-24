import seleniumDriver.TestSuite;

public class testokTest {

	public static void main(String[] args) { 
		
		case1();
		case2();
		case3();
		case7();
		case8();
					
	}
	
		
	private static void  case1() {
		boolean cookiesAlreadyChecked = false;
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://www.imt-atlantique.fr/fr");
		if(!cookiesAlreadyChecked) {
				new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='agree-button eu-cookie-compliance-default-button']"))).click(); //ACCEPT COOKIE
				cookiesAlreadyChecked = true;
		}
		
		WebElement link1 = driver.findElements(By.partialLinkText(new String("Toutes les actualités").toUpperCase())).get(0);
		Assert.assertNotNull(link1);
		
		driver.close();
	}
		
	private static void  case2() {
		boolean cookiesAlreadyChecked = false;
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://www.imt-atlantique.fr/fr");
		if(!cookiesAlreadyChecked) {
				new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='agree-button eu-cookie-compliance-default-button']"))).click(); //ACCEPT COOKIE
				cookiesAlreadyChecked = true;
		}
		
		WebElement link1 = driver.findElements(By.partialLinkText(new String("Toutes les actualités").toUpperCase())).get(0);
		link1.click();
		WebElement link2 = driver.findElements(By.partialLinkText(new String("Accueil").toUpperCase())).get(0);
		Assert.assertNotNull(link2);
		
		driver.close();
	}
		
	private static void  case3() {
		boolean cookiesAlreadyChecked = false;
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://www.imt-atlantique.fr/fr");
		if(!cookiesAlreadyChecked) {
				new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='agree-button eu-cookie-compliance-default-button']"))).click(); //ACCEPT COOKIE
				cookiesAlreadyChecked = true;
		}
		
		WebElement link1 = driver.findElements(By.partialLinkText(new String("Toutes les actualités").toUpperCase())).get(0);
		link1.click();
		WebElement image2 = driver.findElements(By.xpath("//*[@alt='Accueil']")).get(0);
		image2.click();
		WebElement link3 = driver.findElements(By.partialLinkText(new String("Toutes les actualités").toUpperCase())).get(0);
		Assert.assertNotNull(link3);
		
		driver.close();
	}
		
	private static void  case7() {
		boolean cookiesAlreadyChecked = false;
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://www.imt-atlantique.fr/fr");
		if(!cookiesAlreadyChecked) {
				new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='agree-button eu-cookie-compliance-default-button']"))).click(); //ACCEPT COOKIE
				cookiesAlreadyChecked = true;
		}
		
		String myTitle = driver.findElements(By.className("actu_home_ctner_inner_cell1_titre")).get(0).getText();
		WebElement div1 = driver.findElements(By.className("actu_home_ctner_inner_cell1_titre")).get(0);
		div1.click();
		WebElement title2 = driver.findElement(By.xpath("//title"));
		Assert.assertTrue(title2.getText().equals(myTitle));
		
		driver.close();
	}
		
	private static void  case8() {
		boolean cookiesAlreadyChecked = false;
		WebDriver driver = new ChromeDriver();
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
		
		WebElement field1 = driver.findElements(By.xpath("//input[id()='edit-search-api-fulltext']")).get(0);
		field1.sendKeys(myTitle);
		WebElement button2 = driver.findElements(By.xpath("//button[text()='Appliquer les filtres']")).get(0);
		button2.click();
		WebElement link3 = driver.findElements(By.partialLinkText(new String("" + myUrl+" ").toUpperCase())).get(0);
		Assert.assertNotNull(link3);
		
		driver.close();
	}
	
}
