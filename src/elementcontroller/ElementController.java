package elementcontroller;


import java.awt.Robot;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import envsetup.BaseScript;
import basepath.BasePath;

public class ElementController extends BaseScript {
	public DesiredCapabilities capabilities=null;
	public WebDriver driver=null;
	public Robot robot=null;
	public WebElement webElement=null;
	public Actions actions=null;
	public List<WebElement>webElements=null;
	public ElementController elementController=null;
	public WebDriverWait wait=null;
	public Select dropdown=null;
	public ElementController() {
		DOMConfigurator.configure("log4j.xml");
		envStrtSetUp();
	}


	/*@Override
	protected
	void finalize() throws Throwable {
		driver.quit();
		System.out.println("Destructor called");
	}
*/

	public void envStrtSetUp() {
		DOMConfigurator.configure("log4j.xml");
		//Chrome Driver path set to System properties
		
		System.setProperty("webdriver.chrome.driver",driverPath);
		//Code for Browser cache and cookie cleanup

		capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		ChromeOptions opts = new ChromeOptions();
		opts.addArguments("start-maximized");
		capabilities.setCapability(ChromeOptions.CAPABILITY, opts);

		driver=new ChromeDriver();
		

		driver.manage().deleteAllCookies();
		//Browser window set to fullscreen
		driver.manage().window().maximize();	
	}

	public void envEndSetUp()
	{
		driver.quit();
		Log.info("Browser closed successfully");
	}
	public void goToURL(String url){
		driver.get(url);
	}


	public WebElement waitForElementToAppear(final String xpath,int timeout){
		wait = new WebDriverWait(driver, timeout);
		webElement=wait.until(new ExpectedCondition<WebElement>(){
			//@Override
			public WebElement apply(WebDriver d) {
				// TODO Auto-generated method stub
				return d.findElement(By.xpath(xpath));
			}
		});
		return webElement;
	}
	public WebElement findElementByXpath(String xpath,int timeout){

		return waitForElementToAppear(xpath,timeout);

	}
	public List<WebElement> findElementsByXpath(final String xpath,int timeout){
		wait = new WebDriverWait(driver, timeout);;
		webElements=wait.until(new ExpectedCondition<List<WebElement>>(){

			//@Override
			public List<WebElement> apply(WebDriver d) {
				// TODO Auto-generated method stub
				return d.findElements(By.xpath(xpath));

			}

		});
		return webElements;
	}

	public void findElementByXpathAndClick(String xpath,int timeout){
		waitForElementToAppear(xpath,timeout).click();

	}

	public void findElementByXpathClickAndSndKeys(String xpath,int timeout,String data){
		webElement= waitForElementToAppear(xpath,timeout);
		webElement.click();
		webElement.sendKeys(data);

	}

	public void navigateToMenuOptions(String mainMenu,final String subMenu,int timeout){
		wait = new WebDriverWait(driver, timeout);
		actions=new Actions(driver);

		actions.moveToElement(waitForElementToAppear(mainMenu,timeout)).build().perform();
		
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		waitForElementToAppear(subMenu,timeout).click();



	}

	public void selectDropdownOption(String xpath,int optionIndex,int timeout){
		dropdown = new Select(waitForElementToAppear(xpath,timeout));
		
		dropdown.selectByIndex(optionIndex);
		
		
	}
}
