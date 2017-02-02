import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


public class Excel{
	public static void main(String[] args){
		FileInputStream in = null;
		Workbook wb = null;
		String xlsxFileAddress = "è§ïiñº.xlsx";
		ArrayList _data = new ArrayList();
		try{
			in = new FileInputStream(xlsxFileAddress);
			wb =WorkbookFactory.create(in);
			Sheet sheet = wb.getSheetAt(1);
			for(int index = 1;index<=144;index++){//144Ç‹Ç≈
			TableBean a = new TableBean();
				for(int rownum = 5;rownum<=10;rownum++){
					Row row = sheet.getRow(rownum);
					Cell cell = row.getCell(index);
					switch(rownum){
						case 5:a.setCategory(getCell(cell));break;
						case 6:a.setSubcategory(getCell(cell));break;
						case 7:a.setName(getCell(cell));break;
						case 8:String str = getCell(cell);
							str = getDateFormatStr(str);
							a.setDate(str);
						break;
						case 9:a.setPrice(getCell(cell));break;
						case 10:a.setColor(getCell(cell));break;
					}
					
				}
				_data.add(a);
			}
			
			Iterator it = _data.iterator();
			while(it.hasNext()){
				TableBean a =(TableBean) it.next();
				System.out.println(a.getCategory());
				System.out.println(a.getSubcategory());
				System.out.println(a.getName());
				System.out.println(a.getDate());
				System.out.println(a.getPrice());
				System.out.println(a.getColor());
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				in.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	protected static Object getCellValue(Cell cell){
		switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				return cell.getRichStringCellValue().getString();
				
			 case Cell.CELL_TYPE_NUMERIC:
				if(DateUtil.isCellDateFormatted(cell)) {
					return cell.getDateCellValue();
				} else {
					return cell.getNumericCellValue();
				}

			case Cell.CELL_TYPE_BOOLEAN:
				return cell.getBooleanCellValue();
				
			case Cell.CELL_TYPE_FORMULA:
				Workbook wb = cell.getSheet().getWorkbook();
				CreationHelper crateHelper = wb.getCreationHelper();
				FormulaEvaluator evaluator = crateHelper.createFormulaEvaluator();
				return getCellValue(evaluator.evaluateInCell(cell));
				
			case Cell.CELL_TYPE_BLANK:
				return new String(" ");
				
			default:
				return null;
		}
	}
	
	protected static String getCell(Cell cell){
		String cellStr="";
		if(cell!=null){
			cellStr = (getCellValue(cell)).toString();
			if(cellStr.endsWith(".0")){
				cellStr = cellStr.substring(0,cellStr.length()-2);
			}
		}
		return cellStr;
		
	}
	
	protected static String getDateFormatStr(String str){
		String yearStr = str.substring(24,28);
		String monthStr = str.substring(4,7);
		
		switch(monthStr){
			case "Jan": monthStr = "1";break;
			case "Feb": monthStr = "2";break;
			case "Mar": monthStr = "3";break;
			case "Apr": monthStr = "4";break;
			case "May": monthStr = "5";break;
			case "Jun": monthStr = "6";break;
			case "Jul": monthStr = "7";break;
			case "Aug": monthStr = "8";break;
			case "Sep": monthStr = "9";break;
			case "Oct": monthStr = "10";break;
			case "Nov": monthStr = "11";break;
			case "Dec": monthStr = "12";break;
		}
		
		
		String dayStr = str.substring(8,10);
		String newStr = yearStr +"/"+ monthStr +"/"+ dayStr;
		
		return newStr;
	}
}
