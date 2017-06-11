package webpagedemo;


import java.awt.AWTException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import envsetup.BaseScript;
public class WebPageDemo  extends BaseScript {
	/**
	 * @param args
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String baseURL=testDataController.getData("TestData.properties","baseURL");
		testDataController.putData("TestData.properties","textToSearch","Vinay Bhagwat github");
		elementController.goToURL(baseURL);	
//		elementController.findElementByXpathClickAndSndKeys(testDataController.getXpathFromRepository("GoogleInputBox"),10,testDataController.getData("TestData.properties","textToSearch"));
//		elementController.findElementByXpathAndClick(testDataController.getXpathFromRepository("GoogleSearchIcon"), 10);
		elementController.envEndSetUp();
		
	}

}
