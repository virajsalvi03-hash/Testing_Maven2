package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLogin.BaseClass;
import utils.LoggerUtils;

public class Filters extends BaseClass{
	WebDriver driver;
	
	@FindBy(xpath="//li[@aria-label='filter']") WebElement filters;
	@FindBy(xpath = "//div[@class='CreateFilters_label__YdKYz CreateFilters_active___TgLB']") WebElement format;
	@FindBy(xpath = "//span[text()='2D']") WebElement clkFormat;
	@FindBy(xpath = "//div[text()='Show Time']") WebElement showtime;
	@FindBy(xpath = "//*[@id=\"drawer\"]/div/div/div[2]/div/div[1]/div[2]/div[1]/div/div/label/input") WebElement clkdaytime;
	@FindBy(xpath = "//i[@data-testid='close-icon']") WebElement close;
	@FindBy(xpath = "//*[@id=\"drawer\"]/div/div/div[2]/div/div[2]/button[2]/div/span") WebElement result;
	
	public Filters(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void selectFilters() {
		elementclick(filters);
		LoggerUtils.info("Filters Selected");
	}
	
	public void selectFormat() {
		elementclick(format);
		LoggerUtils.info("Select Format section");
	}
	
	public void selectMovieFormat() {
		elementclick(clkFormat);
		LoggerUtils.info("Select format movie to watch");
	}
	
	public void selectShowTime() {
		elementclick(showtime);
		LoggerUtils.info("Select show time section");
	}
	
	public void selectWhenWatch() {
		elementclick(clkdaytime);
		LoggerUtils.info("selected  day time to watch");

	}
	
	public void closeFilt() {
		elementclick(close);
		LoggerUtils.info("Closed filter");
	}
	
	public void viewResult() {
		elementclick(result);
	}

}
