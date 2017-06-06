package elementController;


import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePath.BasePath;

public class ElementController extends BasePath {
	public WebDriver driver=null;
	public Robot robot=null;
	public WebElement webElement=null;
	public Actions actions=null;
	public List<WebElement>webElements=null;
	public ElementController elementController=null;
	public WebDriverWait wait=null;
	
	public void envSetUp() {
		System.setProperty("webdriver.chrome.driver",driverPath);
		 try {
			robot=new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 driver=new ChromeDriver();
		driver.manage().window().maximize();	
		}
	
	public void goToURL(String url){
		driver.get(url);
	}

	public WebElement findElementByXpath(final String xpath,int timeout){
		wait = new WebDriverWait(driver, timeout);

		webElement=wait.until(new ExpectedCondition<WebElement>(){

		//	@Override
			public WebElement apply(WebDriver d) {
				// TODO Auto-generated method stub
				return d.findElement(By.xpath(xpath));

			}
		});
		return webElement;

	}
	public List<WebElement> findElementsByXpath(final String xpath,int timeout){
		wait = new WebDriverWait(driver, timeout);
		webElements=wait.until(new ExpectedCondition<List<WebElement>>(){

			//@Override
			public List<WebElement> apply(WebDriver d) {
				// TODO Auto-generated method stub
				return d.findElements(By.xpath(xpath));

			}

		});
		return webElements;
	}

	public void findElementByXpathAndClick( final String xpath,int timeout){
		wait = new WebDriverWait(driver, timeout);

		webElement=wait.until(new ExpectedCondition<WebElement>(){
			//@Override
			public WebElement apply(WebDriver d) {
				// TODO Auto-generated method stub
				return d.findElement(By.xpath(xpath));
			}
		});
		 webElement.click();

	}
	
	public void findElementByXpathClickAndSndKeys( final String xpath,int timeout,String data){
		wait = new WebDriverWait(driver, timeout);

		webElement=wait.until(new ExpectedCondition<WebElement>(){
		//	@Override
			public WebElement apply(WebDriver d) {
				// TODO Auto-generated method stub
				return d.findElement(By.xpath(""+xpath+""));
			}
		});
		 webElement.click();
		 webElement.sendKeys(data);

	}
}
