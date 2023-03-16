package section26;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataDriven {
    //identify test cases column

    public void getData(String testCaseName) throws IOException {
        ArrayList a = new ArrayList<>();
        //fileInputStream argument
        FileInputStream fis = new FileInputStream("C:\\Users\\xuanx\\IdeaProjects\\TestMavenPrograms\\test.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        int sheets = workbook.getNumberOfSheets();
        for (int i = 0; i < sheets; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                Iterator<Row> rows = sheet.iterator();
                Row firstRow = rows.next(); //first row

                Iterator<Cell> cells = firstRow.cellIterator();

                int k = 0;
                int column = 0;
                while (cells.hasNext()) {
                    Cell value = cells.next();
                    if (value.getStringCellValue().equalsIgnoreCase("testcases")) {
                        //disired column
                        column = k;

                    }
                    k++;
                }
                System.out.println(column);

                while (rows.hasNext()) {
                    Row r = rows.next();
                    if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {
                        Iterator<Cell> cr = r.cellIterator();

                        while (cr.hasNext()) {
                            a.add(cr.next().getStringCellValue());
                        }
                        System.out.println(a);
                    }
                }
            }
        }
    }

}
