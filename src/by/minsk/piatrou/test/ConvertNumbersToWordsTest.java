package by.minsk.piatrou.test;

import static org.junit.Assert.*;
import java.io.*;
import java.math.BigInteger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import by.minsk.piatrou.ConvertNumbersToWords;

public class ConvertNumbersToWordsTest {

	@Test
	public void testConvertNumbersToWordsFromExl() throws IOException {
		ConvertNumbersToWords converter = new ConvertNumbersToWords();
		FileInputStream fis = new FileInputStream("DataTest/TestConvertNumberToWords.xls");
		Workbook workbook = new HSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(0);
      
        for(int i = 0; i < sheet.getLastRowNum()+1; i++) {
        	Integer number = (int) sheet.getRow(i).getCell(0).getNumericCellValue();
        	String word = sheet.getRow(i).getCell(1).getStringCellValue();
        	
        	assertEquals("Error in number: " + number, word,
        			converter.converter(new BigInteger(String.valueOf(number))));
        }
        
        fis.close();
        workbook.close();
	}

}
