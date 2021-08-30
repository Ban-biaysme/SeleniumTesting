/**
 * 
 */
package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author Biyas-Anirban
 *
 */
public class ReadingExcelData {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		File file= new File("D:\\BIYAS-TUTORIALS\\Selenium\\myExcelFile.xlsx");
		FileInputStream fo= new FileInputStream(file);
		
		Workbook workbook= WorkbookFactory.create(fo);
		Sheet sheet0= workbook.getSheetAt(0);
		
		for(Row row: sheet0) {
			for(Cell cell: row) {
				switch(cell.getCellType()) {
					case STRING:
						System.out.print(cell.getStringCellValue()+ "\t");
						break;
					case NUMERIC:
						System.out.print(cell.getNumericCellValue()+ "\t");
						break;
					case BLANK:
						System.out.print("Blank Cell" + "\t");
						break;
					default:
						break;
				}
			}
			System.out.println();
		}
		
		fo.close();
		System.out.println("Reading data from excel file completed");
	}

}
