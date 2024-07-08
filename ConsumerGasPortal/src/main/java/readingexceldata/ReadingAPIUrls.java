package readingexceldata;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadingAPIUrls {
    String timeStamp;
    String api_name;
    String apiLink;
    String apiRequest;
    String api_request_body;
    String test_case_type;
    String expected_status_code;
    String remark = "";
    String api_token;
    public  void readAPIUrls()
    {
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\KAILASH PRASAD KANAK\\Intellij-workspace\\ConsumerGasPortal\\apis_urls\\ExcelInputDataSheet\\consumer_gas_api_urls.xlsx");

            Workbook wb = WorkbookFactory.create(fis);
            Sheet s = wb.getSheetAt(0);
            int lastRowNum = s.getLastRowNum();
            timeStamp = new SimpleDateFormat("YYYY.MM.dd.HH.mm.ss").format(new Date());

            for (int i = 1; i <= lastRowNum; i++)
            {

                api_name = "";

                Cell cell = s.getRow(i).getCell(1);

                if (cell != null) {
                    api_name = cell.getStringCellValue();
                }
                apiLink = "";
                cell = s.getRow(i).getCell(2);
                if (cell != null) {
                    apiLink = cell.getStringCellValue();

                }
                apiRequest = "";
                cell = s.getRow(i).getCell(3);
                if (cell != null) {
                    apiRequest = cell.getStringCellValue();
                }

                api_request_body = "";
                cell = s.getRow(i).getCell(4);
                if (cell != null) {
                    api_request_body = cell.getStringCellValue();
                }

                test_case_type = "";
                cell = s.getRow(i).getCell(5);
                if (cell != null) {
                    test_case_type = cell.getStringCellValue();
                }

                expected_status_code = "";
                cell = s.getRow(i).getCell(6);
                int expectedStatusCode = 0;
                if (cell != null) {
                    expectedStatusCode = (int) cell.getNumericCellValue();
                }


                expected_status_code = Integer.toString(expectedStatusCode);

                remark = "";
                cell = s.getRow(i).getCell(7);
                if (cell != null) {
                    remark = cell.getStringCellValue();
                }

                api_token = "";
                cell = s.getRow(i).getCell(8);
                if (cell != null) {
                    api_token = cell.getStringCellValue();
                }


            }


        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

}
