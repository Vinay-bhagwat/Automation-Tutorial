package envSetup;

import testData.TestDataController;
import elementController.ElementController;

public abstract  class BaseScript {
	protected static ElementController elementController=new ElementController();
	protected static TestDataController testDataController=new TestDataController();
}
