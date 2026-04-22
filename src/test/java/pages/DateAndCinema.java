package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseLogin.BaseClass;
import utils.ConfigReader;
import utils.LoggerUtils;

public class DateAndCinema extends BaseClass {
	 WebDriver driver;
	String daydate;
	 
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public WebElement getElement(String day, String date) {
	    String xpath = "//div[@aria-label='"+day+date+"']";
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	@FindBy(xpath = "//a[text()='PVR C&B Square Chakala  (Formerly Sangam Cinema), Andheri East, Mumbai']")
	WebElement cinema;
	@FindBy(xpath = "//span[text()='View all movies playing here']")
	WebElement viewclk;
	@FindBy(xpath = "//*[@id='mdpContainerWrap']/div[2]/div/div[3]/div/ul/li[1]/ul/li[10]/div/text()") WebElement time;
	@FindBy(xpath = "//button[@aria-label='Confirm and proceed']")
	WebElement confrm;
	@FindBy(xpath = "//button[@aria-label='Continue booking']") WebElement cntbk;

	public DateAndCinema(WebDriver driver) {
		this.driver = driver;
		 this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}

	public void selectdate() {
//		driver.findElement(By.xpath(xpath)).click();
		getElement(ConfigReader.get("day"), ConfigReader.get("date")).click();;
		LoggerUtils.info("Date and Day select correctly");
	}

	public void clickcinema() {
		cinema.click();

	}

	public void view() {
		elementclick(viewclk);
		LoggerUtils.info("Entered cinema and now selecting time");
	}

	public void confrim() {
		elementclick(confrm);
//		elementclick(cntbk);s
	}

	public void selectTime() {
		 this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		time.click();
		LoggerUtils.info("Time is selected");
	}
	
	public void continuebooking() {
		elementclick(cntbk);
	}
	
	

}
