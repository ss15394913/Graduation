import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


public class Text{
	public static void main(String args[]){
		FileInputStream in = null;
		Workbook wb = null;
		String xlsxFileAddress = "対応表イメージ.xlsx";//ここ
		ArrayList _data = new ArrayList();
		try{
			File file = new File("data.txt");//ここ
			if (checkBeforeReadfile(file)){
				BufferedReader br = new BufferedReader(new FileReader(file));
				String str;
					while((str = br.readLine()) != null){
						_data.add(str);
					}
					System.out.println(_data.get(0));
				br.close();
				System.out.println("読み込み完了");
			
			}else{
				System.out.println("ファイルが見つからないか開けません");
			}
			//Excelの処理に移行//
			System.out.println("処理開始");
			in = new FileInputStream(xlsxFileAddress);
			wb =WorkbookFactory.create(in);
			Sheet sheet = wb.getSheetAt(0);
			Row row = sheet.getRow(13);
			Row showRow = sheet.getRow(0);
			Cell showCell = showRow.getCell(0);
			System.out.println(getCell(showCell));
			int txtIndex = 0;
			for(int i = 3;i<=299;i++){
				Cell cell = row.createCell(i);
				String filename = (_data.get(txtIndex)).toString();
				cell.setCellValue(filename);
				txtIndex++;
			}
			FileOutputStream out = new FileOutputStream("対応表イメージ.xlsx");
			wb.write(out);
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

	private static boolean checkBeforeReadfile(File file){
		if (file.exists()){
			if (file.isFile() && file.canRead()){
				return true;
			}
		}

		return false;
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
}