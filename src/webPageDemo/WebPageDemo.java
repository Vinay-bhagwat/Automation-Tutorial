package webPageDemo;


import java.awt.AWTException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import EnvSetup.BaseScript;
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
		elementController.envSetUp();
		String baseURL="http://www.google.com";
	    elementController.goToURL(baseURL);	
	    String xpath=testDataController.getXpathFromRepository("WebElementXpath.xml", "GoogleInputBox");
	    elementController.findElementByXpathClickAndSndKeys(xpath,10,"Times of India");
	}

}
