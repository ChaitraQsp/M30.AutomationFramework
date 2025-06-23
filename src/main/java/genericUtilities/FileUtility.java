package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to files.
 * @author Chaitra M
 *
 */
public class FileUtility {
	
	/**
	 * This method will read data from property file and return the value to caller
	 * @param Key
	 * @return value
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String Key) throws IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(Key);
		return value;
		
	}
	
	
	/**
	 * This method will read data from excel file and return the value to caller
	 * @param sheetName
	 * @param rowNo
	 * @param celNo
	 * @return value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelFile(String sheetName, int rowNo, int celNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
	    String value = wb.getSheet(sheetName).getRow(rowNo).getCell(celNo).getStringCellValue();
	    return value;
	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
