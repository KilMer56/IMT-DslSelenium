import seleniumDriver.TestSuite;

public class brokenTestsTest {

	public static void main(String[] args) { 
		
		case3();
		case4();
		case5();
		case6();
		case7();
		case8();
					
	} 
	
	private static void  case3() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.
		WebElement link1 = driver.findElement(By.xpath("//a[label()='Toutes les actualités']"))
		link1.click();
		WebElement image2 = driver.findElement(By.xpath("//*[alt()='Accueil']"))
		image2.click();
		WebElement link3 = driver.findElement(By.xpath("//a[text()='Toutes les actualités']"));
		Assert.assertNotNull(link);
		driver.close();
	}
	private static void  case4() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.
		WebElement field1 = driver.findElement(By.xpath("//*[id()='edit-rechercher']"))
		field1. write( "Donald Trump" );
		WebElement button2 = driver.findElement(By.xpath("//*[text()='Appliquer les filtres']"))
		button2.click();
		WebElement div3 = driver.findElement(By.xpath("//*[text()='Toutes les actualités']"));
		Assert.assertNotNull(div);
		driver.close();
	}
	private static void  case5() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.
		WebElement checkbox1 = driver.findElement(By.tagName("*"))
		It's some string.
		WebElement checkbox2 = driver.findElement(By.xpath("//*[label()='Anglais']"))
		It's some string.
		WebElement checkbox3 = driver.findElement(By.xpath("//*[label()='A domicile']"))
		It's some string.
		WebElement checkbox4 = driver.findElement(By.xpath("//*[label()='Temps plein']"))
		It's some string.
		WebElement button5 = driver.findElement(By.xpath("//*[text()='Appliquer les critéres']"))
		button5.click();
		WebElement div6 = driver.findElement(By.xpath("//*[text()='No found course matching your criteria.']"));
		Assert.assertNotNull(div);
		driver.close();
	}
	private static void  case6() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.
		WebElement field1 = driver.findElement(By.xpath("//*[label()='Rechercher']"))
		field1. write( "2007" );
		WebElement combobox2 = driver.findElement(By.xpath("//*[label()='Période de publication']"))
		It's some string.
		WebElement button3 = driver.findElement(By.xpath("//*[text()='Appliquer les filtres']"))
		button3.click();
		WebElement div4 = driver.findElement(By.xpath("//*[text()='Aucun résultat ne correspond à votre recherche.']"));
		Assert.assertNotNull(div);
		driver.close();
	}
	private static void  case7() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.
		div myTitle = WebElement div1 = driver.findElement(By.xpath("//*[@class()='actu_home_ctner_inner_cell1_titre']"));
		WebElement div2 = driver.findElement(By.xpath("//*[@class()='actu_home_ctner_inner_cell1_titre']"))
		div2.click();
		WebElement title3 = driver.findElement(By.xpath("//*[text()='null']"));
		Assert.assertNotNull(title);
		driver.close();
	}
	private static void  case8() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.
		div myTitle = WebElement div1 = driver.findElement(By.xpath("//*[@class()='actu_home_ctner_inner_cell1_titre']"));
		div myUrl = WebElement div2 = driver.findElement(By.xpath("//*[@class()='actu_home_ctner_inner_cell1_titre']"));
		driver.
		WebElement field3 = driver.findElement(By.xpath("//*[id()='edit-rechercher']"))
		field3. write(myTitle);
		WebElement button4 = driver.findElement(By.xpath("//*[text()='Appliquer les filtres']"))
		button4.click();
		WebElement link5 = driver.findElement(By.xpath("//a[href()='null']"));
		Assert.assertNotNull(link);
		driver.close();
	}
	
	
}
