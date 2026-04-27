package baseLogin;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import net.bytebuddy.agent.builder.AgentBuilder.CircularityLock.Default;
import pages.HomePage;
import pages.SearchPage;
import utils.ConfigReader;
import utils.LoggerUtils;

public class BaseClass {
	protected static WebDriver driver;
//	private static SearchPage search;
//	private static HomePage home;
	static int time = Integer.parseInt(ConfigReader.get("timeout"));

	@BeforeMethod(alwaysRun = true)
	public static void setup() {

			//read the browser value from Jenkins
			String browser = System.getProperty("browser");

			//if value not received from Jenkins, read from config file
			if(browser == null || browser.isEmpty()) {
				browser = ConfigReader.get("browser");
			}
			
			switch (browser) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				driver = new InternetExplorerDriver();
				break;
			}
			

		driver.manage().window().maximize();
		String env = System.getProperty("env");
		if(env==null ||env.isEmpty()) {
			env=ConfigReader.get(env);
		}
		
		String url = System.getProperty(env+"_url");
		driver.get(url);
		if(url==null||url.isEmpty()) {
			driver.get(ConfigReader.get("url"));	
		}
		
		LoggerUtils.info("Browser started");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
//		home = new HomePage(driver);
//		search = new SearchPage(driver);

	}

	@AfterMethod(alwaysRun = true)
	public static void tearDown() {
//		driver.quit();
//		LoggerUtils.info("Browser closed");
	}

	public void elementclick(WebElement elm) {
		if (elm.isDisplayed()) {
			if (elm.isEnabled()) {
				elm.click();
			} else {
				LoggerUtils.fail("Elemant not enabled");
				System.out.println("Not enabled");
			}
		} else {
			System.out.println("Not displayed");
		}
	}

	public void elementText(WebElement elm, String text) {
		if (elm.isDisplayed()) {
			if (elm.isEnabled()) {
				elm.sendKeys(text);
				;
			} else {
				System.out.println("Text Not enabled");
			}
		} else {
			System.out.println("Text Not displayed");
		}
	}

}
