package app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {
	
	//it is required a maven dependency > Apache POI 3.9
	
	public String run() throws InvalidFormatException, IOException {
		String val="";

		try {
			FileInputStream in = new FileInputStream("C:\\Users\\onlyb\\Downloads\\demo-grid\\data.xlsx");
			Workbook wb = WorkbookFactory.create(in);
			Sheet sh = wb.getSheet("Sheet1");
			Row r = sh.getRow(1); // 0 is header
			r.getCell(1);
			
			if(r.getCell(2)!=null) {
				Cell c = r.getCell(2);
				c.setCellType(Cell.CELL_TYPE_STRING);
				val = c.getStringCellValue();
			}else {
				val="no_value_set";

			}
			
			Cell celRes = r.createCell(3);
			celRes.setCellValue("PASS");
			
			

		}catch(FileNotFoundException e) {
				e.getMessage();
			}
		
		return val;
		
	}
	

	
}
