package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {
	
	public static WebDriver driver;
	
	@BeforeSuite
	@Parameters ({"browser"})
	public void startDriver (@Optional("firefox") String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver = new ChromeDriver();	
		}
		
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			driver = new FirefoxDriver();	
		}
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(1120,TimeUnit.SECONDS);
		driver.navigate().to("http://demo.nopcommerce.com/");
		
	}
	
	@AfterSuite
	public void stopDriver () {
		
		driver.quit();
	}
}
