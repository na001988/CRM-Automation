package app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ProcessWithExcel {
	
	//it is required a maven dependency > Apache POI 3.9
	
	Constants c = new Constants();
	
	public void run(String d1, String d2, String d3) throws InvalidFormatException, IOException {
		
		String currentPath = new java.io.File(".").getCanonicalPath();
        String excelFilePath = currentPath+Constants.excelFile;
        
        try {
          
			 FileInputStream myxls = new FileInputStream(excelFilePath);
			 XSSFWorkbook studentsSheet = new XSSFWorkbook(myxls);
			 XSSFSheet worksheet = studentsSheet.getSheetAt(0);
		       int lastRow=worksheet.getLastRowNum();
		       
		       Row row = worksheet.createRow(++lastRow);
		       row.createCell(0).setCellValue(d1);
		       row.createCell(1).setCellValue(d2);
		       row.createCell(2).setCellValue(d3);
		       myxls.close();
		       
		       FileOutputStream output_file =new FileOutputStream(new File(excelFilePath));  
		       //write changes
		       studentsSheet.write(output_file);
		       output_file.close();
		       System.out.println(" File successfully written");

		}catch(FileNotFoundException e) {
			System.out.println("Error on ProcessWithExcel.run()" + e.getMessage());
			}
		
		
	}
	

	
}
