package automation.testcases;

import java.util.List;

import org.openqa.selenium.WebElement;

import envsetup.BaseScript;

public class TestScript_01 extends BaseScript {

	public static void main(String[] args) {
		try{

			List<WebElement> searchResult =googleSearchPage.googleSearch(testDataController.getData(testDataPath+"GoogleSearchPage.properties", "textToSearch"));
			for(WebElement searchList :searchResult){System.out.println("Google search result ->"+searchList.getText());}
			searchResult.get(0).click();
			huffingtonPostWebPage.navBarMenu("News", "World");
		}
		catch(Exception e){

		}


		finally{


			elementController.envEndSetUp();
		}
	}


}
