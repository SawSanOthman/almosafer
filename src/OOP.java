import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class OOP {
	
	
	WebDriver driver = new ChromeDriver();

	String WebSite1 = "https://www.almosafer.com/en";
	String WebSite2 = "https://www.almosafer.com/ar";
	String ExpectedNumber = "+966554400000";
	boolean ExpectedLogo = true;
	String ExpectedHotel = "false";
	String ExpectedLanguage = "en";
	String ExpectedCurrency = "SAR";
	Random rand = new Random();

	int Today = LocalDate.now().getDayOfMonth();
	int Tomorrow = LocalDate.now().plusDays(1).getDayOfMonth();
	String ExpectedDep = Integer.toString(Tomorrow);
	int AfterDayTomorrow = LocalDate.now().plusDays(2).getDayOfMonth();
	String ExpectedDep1 = Integer.toString(AfterDayTomorrow);

	
	//String expectedDeparture = String.format("%02d", Tomorrow);
//	String ExpectedReturn = String.format("%02d",AfterDayTomorrow );

	String[] EnglishCities = { "Dubai", "Jeddah", "Riyadh" };
	String[] ArabicCities = { "دبي", "جده" };
	int RandomEnglish = rand.nextInt(EnglishCities.length);
	int RandomArabia = rand.nextInt(ArabicCities.length);

	String[] Websites = { WebSite1, WebSite2 };

	int RandomOfIndex = rand.nextInt(Websites.length);
	boolean ExpectedResult = true;

	
	
public void MySetUpToEnterTheWebsite()	{
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	driver.manage().window().maximize();
	driver.get(WebSite1);
	WebElement TheCurrencyButton = driver
			.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
	TheCurrencyButton.click();
	
	
}
	
	
public void selectthelanguagetofillthecities(WebElement SearchInput) throws InterruptedException {
	

	if (driver.getCurrentUrl().equals(WebSite1)) {

		String ActualLanguage = driver.findElement(By.tagName("html")).getDomAttribute("lang");
		String ExpectedLanguage = "en";
		Assert.assertEquals(ActualLanguage, ExpectedLanguage);
		SearchInput.sendKeys(EnglishCities[RandomEnglish]);
	} else {

		String ActualLanguage = driver.findElement(By.tagName("html")).getDomAttribute("lang");
		String ExpectedLanguage = "ar";
		Assert.assertEquals(ActualLanguage, ExpectedLanguage);
		SearchInput.sendKeys(ArabicCities[RandomArabia]);
	}
	Thread.sleep(2000);
}
	public void EnterNumberOfVisitorsAfterSelectCities() throws InterruptedException {
		
		
		
		WebElement CitiesList = driver.findElement(By.cssSelector(".sc-phbroq-4.gGwzVo.AutoComplete__List"));
		CitiesList.findElements(By.tagName("li")).get(1).click();

		WebElement MyRoomVisitor = driver.findElement(By.cssSelector(".sc-tln3e3-1.gvrkTi"));

		Select selector = new Select(MyRoomVisitor);
		int RandomRoom = rand.nextInt(2);
		selector.selectByIndex(RandomRoom);
		Thread.sleep(1000);

		WebElement SearchOfStays = driver.findElement(By.xpath("//button[@data-testid='HotelSearchBox__SearchButton']"));
		SearchOfStays.click();
Thread.sleep(30000);
	
	}
	
	
	
	public void CheckSortOption () {
		
	
WebElement Container = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[5]/div"));

		
		
		if (driver.getCurrentUrl().contains("en")) {
			
			List<WebElement> priceList = Container.findElements(
					By.cssSelector(".MuiTypography-root.MuiTypography-heading3SemBld.__ds__comp.undefined.muiltr-18vmb2l"));
			int lowestPrice = Integer.parseInt(priceList.get(0).getText().replace("SAR ", ""));
			int HighestPrice = Integer.parseInt(priceList.get(priceList.size() - 1).getText().replace("SAR ", ""));
			System.out.println(lowestPrice);
			System.out.println(HighestPrice);

			boolean ActualValue = lowestPrice < HighestPrice;
			boolean ExpectedValue = true;

			System.out.println(ActualValue);
			System.out.println(ExpectedValue);

			Assert.assertEquals(ActualValue, ExpectedValue);
			
		}else {
			List<WebElement> priceList = Container.findElements(
					By.cssSelector(".MuiTypography-root.MuiTypography-heading3SemBld.__ds__comp.undefined.muirtl-1l5b3qq"));
			int lowestPrice = Integer.parseInt(priceList.get(0).getText().replace("ر.س. ", ""));
			System.out.println();
			int HighestPrice = Integer.parseInt(priceList.get(priceList.size() - 1).getText().replace("ر.س. ", ""));
			System.out.println(lowestPrice);
			System.out.println(HighestPrice);

			boolean ActualValue = lowestPrice < HighestPrice;
			boolean ExpectedValue = true;

			System.out.println(ActualValue);
			System.out.println(ExpectedValue);

			Assert.assertEquals(ActualValue, ExpectedValue);
			
		}
	
	}

		
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


