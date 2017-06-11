package pages;

import java.util.List;



import org.openqa.selenium.WebElement;

import envsetup.BaseScript;

public class GoogleSearchPage extends BaseScript {

	//XML and Properties File path
	String xpathFileRepo=getXpathFileRepo(this.getClass().getSimpleName());
	String dataFilePath=getDataFileRepo(this.getClass().getSimpleName());

	public List<WebElement> googleSearch(String searchQuery){
		String assertionInfo="Failed to search "+searchQuery+" on Google";
		boolean isSearched=true;
		elementController.goToURL(testDataController.getData(dataFilePath,"baseURL"));
		
		elementController.findElementByXpathClickAndSndKeys(testDataController.getXpathFromRepository(xpathFileRepo,"GoogleInputBox"),10,searchQuery);
		
		elementController.findElementByXpathAndClick(testDataController.getXpathFromRepository(xpathFileRepo,"GoogleSearchIcon"), 10);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return elementController.findElementsByXpath(testDataController.dynamicXpathFromRepository(xpathFileRepo, "GoogleSearchLinks", searchQuery), 10);
		

	} 


}
