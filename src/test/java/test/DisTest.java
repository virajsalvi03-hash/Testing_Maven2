package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseLogin.BaseClass;
import pages.DateAndCinema;
import pages.Filters;
import pages.HomePage;
import pages.SearchPage;
import pages.SeatsPage;
import utils.LoggerUtils;

public class DisTest extends BaseClass {

	private static HomePage home;
	private static SearchPage search;
	private static DateAndCinema datetime;
	private static SeatsPage chair;
	private static LoggerUtils Log;
	private static Filters filt;

	@BeforeMethod(alwaysRun = true)
	public static void intiialize() {
		home = new HomePage(driver);
		search = new SearchPage(driver);
		datetime = new DateAndCinema(driver);
		chair = new SeatsPage(driver);
		Log = new LoggerUtils();
		filt = new Filters(driver);
		
	}

	@Test
	public void searchMovies() {
		
		LoggerUtils.info("Test case  - bookMovie execution started");
//		home.clickLocation();
//		home.Entersearch("Mumbai");
//		home.selectloc();
		home.clicksearch();
		search.clickMovies();
		search.Entersearch("Dhurandhar");
		Assert.assertTrue(search.getSearchresult().trim().contains("Dhurandhar"));
		LoggerUtils.pass("Enter movie name correctly");
		search.selectMovie();
		LoggerUtils.pass("Selected movie correctly");
		datetime.selectdate();
		filt.selectFilters();
		filt.selectFormat();
		filt.selectMovieFormat();
		filt.selectShowTime();
		filt.selectWhenWatch();
		filt.viewResult();;
		LoggerUtils.info("Filter selected successful");
		datetime.clickcinema();
		datetime.view();	
		datetime.selectTime();
//		datetime.continuebooking();
//		datetime.confrim();
//		chair.selectSeat();
//		chair.proceedbtn();
//		LoggerUtils.info("Test case -bookMovie complete");

	}

}
