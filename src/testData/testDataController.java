package testData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class testDataController {
	File file=null;
	FileInputStream fileInput = null;
	FileOutputStream fileOutput=null;
	Properties prop = new Properties();

	public String getData(String filePath,String key)
	{
		String data=null;

		file = new File(filePath);


		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		//load properties file
		try {
			prop.load(fileInput);
			data=prop.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data; 

	}
	public boolean putData(String filePath,String key,String value)
	{
		boolean isSucceed=false;

		file = new File(filePath);


		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		//load properties file
		try {
			prop.load(fileInput);
			Object object=	prop.put(key, value);
			if(!object.equals(null)){
				isSucceed=true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return isSucceed; 

	}
}
