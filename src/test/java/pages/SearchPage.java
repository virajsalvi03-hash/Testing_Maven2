package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLogin.BaseClass;
import utils.LoggerUtils;

public class SearchPage extends BaseClass {
	WebDriver driver;
	// page specific locators
//	By edtBox = By.xpath("(//input[contains(@class,'placeholder')])[2]");
//	By lnkmovies = By.xpath("//span[text()='Movies']");
//	By searchresult = By.xpath("//h5[@class='dds-tracking-tight dds-text-lg dds-font-semibold dds-overflow-hidden dds-whitespace-normal dds-line-clamp-2 dds-text-primary dds-leading-normal dds-my-0']");
	@FindBy(xpath = "(//input[contains(@class,'placeholder')])[2]")
	WebElement edtBox;
	@FindBy(xpath = "//span[text()='Movies']")
	WebElement lnkmovies;
	@FindBy(xpath = "//h5[@class='dds-tracking-tight dds-text-lg dds-font-semibold dds-overflow-hidden dds-whitespace-normal dds-line-clamp-2 dds-text-primary dds-leading-normal dds-my-0']")
	WebElement searchresult;
	@FindBy(xpath = "//a[@href='https://www.district.in/movies/dhurandhar-the-revenge-movie-tickets-in-mumbai-MV211577']")
	WebElement clkmovie;

	public void clickMovies() {
//		lnkmovies.click();
		elementclick(lnkmovies);
		LoggerUtils.info("Clicked on movie link");
	}

	public void Entersearch(String text) {
		elementText(edtBox, text);
		LoggerUtils.info("Searched movie");
	}

	public String getSearchresult() {
		return searchresult.getText();
	}

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectMovie() {
		elementclick(clkmovie);
		LoggerUtils.info("clicked on movie link");
//		clkmovie.click();
	}

}
