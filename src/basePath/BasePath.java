package basepath;

public class BasePath {

	
	protected static final String basePath = System.getProperty("user.dir");
	protected static String elementRepositoryPath= basePath+"\\ElementRepository\\";
	protected static String testDataPath= basePath+"\\TestData\\";
	protected static String driverPath= basePath+"\\lib\\chromedriver.exe";
	
	public String getXpathFileRepo(String xmlFileName){
		return elementRepositoryPath+xmlFileName+".xml";
	}
	
	public String getDataFileRepo(String dataFileName){
		return testDataPath+dataFileName+".properties";
	}

}
