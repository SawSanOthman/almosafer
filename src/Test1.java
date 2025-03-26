import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 extends OOP{

	
	@BeforeTest
	public void SetUp() {

		MySetUpToEnterTheWebsite();
	}

	@Test(priority = 1, enabled = true)

	public void TheLanguageEnglishIsDeafult() {

		String ActualLanguage = driver.findElement(By.tagName("html")).getDomAttribute("lang");
		Assert.assertEquals(ActualLanguage, ExpectedLanguage);

	}

	@Test(priority = 2, enabled = true)

	public void ThrCurrencyIsSAR() {
		String ActualCurrency = driver.findElement(By.cssSelector(".sc-hUfwpO.kAhsZG")).getText();
		Assert.assertEquals(ActualCurrency, ExpectedCurrency);
	}

	@Test(priority = 3, enabled = true)
	public void CheckContactNum() {

		String ActualNumber = driver.findElement(By.cssSelector(".sc-cjHlYL.gdvIKd")).getText();
		Assert.assertEquals(ActualNumber, ExpectedNumber);

	}

	@Test(priority = 4, enabled = true)
	public void QitafLogo() {

		boolean ActualLogo = driver.findElement(By.cssSelector(".sc-ekulBa.iOOTo")).isDisplayed();
		Assert.assertEquals(ActualLogo, ExpectedLogo);

	}

	@Test(priority = 5, enabled = true)
	public void HotelTabIsNotSelected() {
		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));

		String ActualHotel = HotelTab.getDomAttribute("aria-selected");
		Assert.assertEquals(ActualHotel, ExpectedHotel);

	}

	@Test(priority = 6, enabled = true)
	public void CheckFlightDepature() {


		String ActualDep = driver.findElement(By.cssSelector(".sc-dXfzlN.iPVuSG")).getText();
		Assert.assertEquals(ActualDep, ExpectedDep);

	}

	@Test(priority = 7, enabled = true)
	public void CheckReturnDepature() {

		String ActualDep1 = driver
				.findElement(By.cssSelector("div[class='sc-bYnzgO sc-hvvHee aiGEY'] span[class='sc-dXfzlN iPVuSG']"))
				.getText();
		Assert.assertEquals(ActualDep1, ExpectedDep1);

	}

	@Test(priority = 8,enabled=true)
	public void CheckTheLanguageIsEn() throws InterruptedException {
		
		driver.get(Websites[RandomOfIndex]);

		WebElement StaysButton = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		StaysButton.click();

		WebElement SearchInput = driver.findElement(By.cssSelector(".sc-phbroq-2.uQFRS.AutoComplete__Input "));
		selectthelanguagetofillthecities(SearchInput);

		EnterNumberOfVisitorsAfterSelectCities();
	}

	@Test(priority = 9,enabled=true)
	public void TheBageIsLoaded() throws InterruptedException {
		Thread.sleep(2000);
		
		WebElement SearchResult1 = driver.findElement(By.xpath("//span[@data-testid='srp_properties_found']"));	
		
		boolean ActualResult1 = SearchResult1.getText().contains("found")||SearchResult1.getText().contains("مكان");

		Assert.assertEquals(ActualResult1, ExpectedResult);
	
	}

	@Test(priority=10,enabled=true)
	public void LowisetPrice () throws InterruptedException {
		
		Thread.sleep(10000);
		WebElement SortOption = driver.findElement(By.xpath("//div[@data-testid='srp_sort_LOWEST_PRICE']"));
		SortOption.click();

		Thread.sleep(2000);

		
		CheckSortOption ();
		
	}
}
