package WebPageLogin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class webLogin extends Exception{

	/**
	 * @param args
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\VINAY\\Desktop\\Project\\chromedriver_win32\\chromedriver.exe");
		Robot robot=new Robot();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();		
		String BASEURL="http://toolsqa.com/";
		driver.get(BASEURL);
		List<WebElement>webElemnts= driver.findElements(By.xpath("//*[@id='trigger-overlay']"));
		webElemnts.get(0).click();
		webElemnts=driver.findElements(By.xpath("//input[@class='field searchform-s' and @name='s']"));
		webElemnts.get(0).sendKeys("TestNg tutorial");
		robot.keyPress(KeyEvent.VK_ENTER);
		Actions MOUSEMOVE=new Actions(driver);
		webElemnts=driver.findElements(By.xpath("//ul[@id='primary-menu']//span[contains(text(),'Tools')]"));
		MOUSEMOVE.moveToElement(webElemnts.get(2)).build().perform();
		
		webElemnts=driver.findElements(By.xpath("//span[contains(text(),'BDD Frameworks')]"))
				;
		MOUSEMOVE.moveToElement(webElemnts.get(0)).build().perform();
		driver.findElement(By.xpath("//*[@id='primary-menu']/li[3]/ul/li[3]/ul/li[1]/a/span[2]")).click();
		driver.wait(10000);
		driver.close();

	}

}
