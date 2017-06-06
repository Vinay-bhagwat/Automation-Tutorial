package testData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TestDataController {
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

	public String getXpathFromRepository(String fileName,String titleAttrb) {
		String xpath=null;
		try {
			File fXmlFile = new File("C:\\Users\\afour\\Desktop\\Automation-Tutorial\\ElementRepository\\WebElementXpath.xml");
			if(fXmlFile.isFile()){

				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
				NodeList nodeList=doc.getElementsByTagName("Element");

				for (int node = 0; node < nodeList.getLength(); node++) {

					String childElements=null ;

					Element param = (Element) nodeList.item(node);
					Node childNode;
					if (param.getAttribute("title").toString().equals(titleAttrb)) {

						for (childNode = param.getFirstChild(); childNode != null; childNode = childNode.getNextSibling()) {
							if (childNode.getNodeType() == Node.ELEMENT_NODE) {
								childElements=childNode.getTextContent();
							}
						}
						xpath=childElements;
						break;
						
					}
				}

			}
return xpath;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xpath;

	}

}
