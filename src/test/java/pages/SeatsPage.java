package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLogin.BaseClass;
import utils.LoggerUtils;

public class SeatsPage extends BaseClass {
	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"available-seat\"]/label")
	WebElement seat;
	@FindBy(xpath = "//button[@aria-label='Proceed']")
	WebElement prdbtn;

	public void selectSeat() {
		elementclick(seat);
		LoggerUtils.info("Able to select a seat successfully");
	}

	public void proceedbtn() {
		elementclick(prdbtn);
	}

	public SeatsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}
