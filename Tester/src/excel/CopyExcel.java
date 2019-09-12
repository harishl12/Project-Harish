package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.model.Workbook;

public class CopyExcel {

	void copyToExcel(String filePath, String src, String tgt, String sheetName) throws FileNotFoundException {
		String ext = src.substring(src.indexOf("."));
		File srcFile = new File(filePath+"\\src");
		File tgtFile = new File(filePath+"\\tgt");
		
		FileInputStream sfis = new FileInputStream(srcFile);
//		FileOutputStream tfos = new FileOutputStream(tgtFile);
		
		Workbook swb = new Workbook();
		
		if(ext.contains(".xlsx")) {
			
		}
		
		
	}

	public static void main(String[] args) throws FileNotFoundException {
		String filePath = System.getProperty("user.dir") + "\\Files";
		CopyExcel copy = new CopyExcel();
		copy.copyToExcel(filePath, "OPTS.xlsx", "copiedOPTS.xlsx", "Sizer");
	}

}
