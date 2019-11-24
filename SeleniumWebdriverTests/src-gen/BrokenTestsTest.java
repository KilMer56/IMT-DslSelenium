import seleniumDriver.TestSuite;

public class brokenTestsTest {

	public static void main(String[] args) { 
		
		case4();
		case5();
		case6();
					
	}
	
	private static void  case4() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://www.imt-atlantique.fr/fr/rechercher");
		      		
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//button[@class='agree-button eu-cookie-compliance-default-button']"))).click();
			
		WebElement field1 = driver.findElements(By.xpath("//*[id()='edit-rechercher']")).get(0);
		field1.sendKeys("Donald Trump");
		WebElement button2 = driver.findElements(By.xpath("//*[text()='Appliquer les filtres']")).get(0);
		button2.click();
		WebElement div3 = driver.findElements(By.xpath("//*[text()='Toutes les actualités']")).get(0);
		Assert.assertNotNull(div3);
		
		driver.close();
	}
	private static void  case5() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://www.imt-atlantique.fr/fr/formation/trouver-ma-formation");
		      		
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//button[@class='agree-button eu-cookie-compliance-default-button']"))).click();
			
		WebElement checkbox1 = driver.findElements(By.tagName("*")).get(0);
		if ( checkbox1.isSelected() ){checkbox1.click();}
		WebElement checkbox2 = driver.findElements(By.xpath("//*[label()='Anglais']")).get(0);
		if ( !checkbox2.isSelected() ){checkbox2.click();}
		WebElement checkbox3 = driver.findElements(By.xpath("//*[label()='A domicile']")).get(0);
		if ( !checkbox3.isSelected() ){checkbox3.click();}
		WebElement checkbox4 = driver.findElements(By.xpath("//*[label()='Temps plein']")).get(0);
		if ( !checkbox4.isSelected() ){checkbox4.click();}
		WebElement button5 = driver.findElements(By.xpath("//*[text()='Appliquer les critéres']")).get(0);
		button5.click();
		WebElement div6 = driver.findElements(By.xpath("//*[text()='No found course matching your criteria.']")).get(0);
		Assert.assertNotNull(div6);
		
		driver.close();
	}
	private static void  case6() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://www.imt-atlantique.fr/fr/rechercher");
		      		
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//button[@class='agree-button eu-cookie-compliance-default-button']"))).click();
			
		WebElement field1 = driver.findElements(By.xpath("//*[label()='Rechercher']")).get(0);
		field1.sendKeys("2007");
		WebElement combobox2 = driver.findElements(By.xpath("//*[label()='Période de publication']")).get(0);
		combobox2.click();
		WebElement button3 = driver.findElements(By.xpath("//*[text()='Appliquer les filtres']")).get(0);
		button3.click();
		WebElement div4 = driver.findElements(By.xpath("//*[text()='Aucun résultat ne correspond à votre recherche.']")).get(0);
		Assert.assertNotNull(div4);
		
		driver.close();
	}
	
}
