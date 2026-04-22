package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLogin.BaseClass;
import utils.LoggerUtils;

public class HomePage extends BaseClass {
	 WebDriver driver;

//	By search = By.xpath("//div[@class='dds-w-7 dds-h-7 dds-flex dds-items-center dds-cursor-pointer']//*[name()='svg']");
//	By imglocation = By.xpath("//div[@class='dds-w-8 dds-h-8 dds-flex dds-items-center dds-justify-center']//*[name()='svg']");
	@FindBy(xpath = "//div[@class='dds-w-7 dds-h-7 dds-flex dds-items-center dds-cursor-pointer']//*[name()='svg']")
	WebElement search;
	@FindBy(xpath = "//div[@class='dds-w-8 dds-h-8 dds-flex dds-items-center dds-justify-center']//*[name()='svg']")
	WebElement imglocation;
	@FindBy(xpath = "//input[@placeholder='Search city, area or locality']")
	WebElement srcloc;
	@FindBy(xpath = "//div[contains(@class,'dds-flex dds-flex-col dds-gap-4')]//span[contains(@class,'dds-text-primary dds-text-lg dds-font-semibold dds-overflow-hidden dds-whitespace-normal dds-line-clamp-1 dds-leading-relaxed')][normalize-space()='Mumbai']")
	WebElement clkloc;

	public void clicksearch() {
		elementclick(search);
		LoggerUtils.info("Clicked on Search info");

	}

	public void clickLocation() {
		elementclick(imglocation);
		LoggerUtils.info("Clicked on Location icon");
	}

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectloc() {
		elementclick(clkloc);
	}

	public void Entersearch(String text) {

		elementText(srcloc, text);
	}

}
