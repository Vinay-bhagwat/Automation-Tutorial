package envsetup;

import pages.GoogleSearchPage;
import pages.HuffingtonPostWebPage;
import basepath.BasePath;
import testdata.TestDataController;
import elementcontroller.ElementController;

import java.awt.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public abstract  class BaseScript extends BasePath {
	protected static ElementController elementController=new ElementController();
	protected static TestDataController testDataController=new TestDataController();
	protected static GoogleSearchPage googleSearchPage=new GoogleSearchPage(); 
	protected static HuffingtonPostWebPage huffingtonPostWebPage=new HuffingtonPostWebPage();
	protected static Logger Log = Logger.getLogger(BaseScript.class.getName());
	
}