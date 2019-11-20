import seleniumDriver.TestSuite;

public class testokTest {

	public static void main(String[] args) { 
		
		case1();
		case2();
					
	} 
	
	private static void  case1() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get( "http://www.imt-atlantique.fr/fr" );
		WebElement link1 = driver.findElement(By.xpath("//a[text()='Toutes les actualités']"));;
		Assert.assertNotNull(link1);
		driver.close();
	}
	private static void  case2() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get( "http://www.imt-atlantique.fr/fr" );
		WebElement link1 = driver.findElement(By.xpath("//a[text()='Toutes les actualités']"));
		link1.click();
		WebElement link2 = driver.findElement(By.xpath("//a[text()='Accueil']"));;
		Assert.assertNotNull(link2);
		driver.close();
	}
	
	
}
