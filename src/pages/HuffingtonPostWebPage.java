package pages;

import envsetup.BaseScript;

public class HuffingtonPostWebPage extends BaseScript{
	//XML and Properties File path
		String xpathFileRepo=getXpathFileRepo(this.getClass().getSimpleName());
		String dataFilePath=getDataFileRepo(this.getClass().getSimpleName());

	public void navBarMenu(String menu,String subMenu){
		elementController.navigateToMenuOptions(testDataController.dynamicXpathFromRepository(xpathFileRepo, "HuffingtonMenu",menu ),testDataController.dynamicXpathFromRepository(xpathFileRepo, "HuffingtonSubMenu",subMenu ) ,10);
		
	}

}
