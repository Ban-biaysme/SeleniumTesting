/**
 * 
 */
package utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Biyas-Anirban
 *
 */
public class WritingExcel {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException{
		
		@SuppressWarnings("resource")
		XSSFWorkbook workbook= new XSSFWorkbook();
		XSSFSheet sheet0= workbook.createSheet("firstsheet");
		
//		Row row0= sheet0.createRow(0);
//		
//		Cell cellA= row0.createCell(0);
//		Cell cellB= row0.createCell(1);
//		
//		cellA.setCellValue("First cell");
//		cellB.setCellValue("Second cell");
		
		for(int rows=0; rows<=10; rows++) {
			Row row = sheet0.createRow(rows);
			
			for(int cols=0; cols<=10; cols++) {
				Cell cell= row.createCell(cols);
				cell.setCellValue((int)(Math.random()*100));
			}
		}
		
		File file= new File("D:\\BIYAS-TUTORIALS\\Selenium\\myExcelFile.xlsx");
		FileOutputStream fo= new FileOutputStream(file);
				
		workbook.write(fo);
		
		fo.close();
		System.out.println("Excel file created...");
	}

}
