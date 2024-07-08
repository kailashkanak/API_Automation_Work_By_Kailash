package collectNewExcelData;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadAPIUrlsFromExcel
{
    public List<ApiData> readApi()
    {
        String filepath ="ExcelInputSheet/MobileApiUrls.xlsx";

        try(FileInputStream fis = new FileInputStream(new File(filepath)); Workbook workbook = new XSSFWorkbook(fis))
        {
            Sheet sheet = workbook.getSheetAt(0);
            int lastRowNum=sheet.getLastRowNum();
            List<ApiData> apiDataList = new ArrayList<>();

            for(int i=1;i<=lastRowNum;i++)
            {
                String apiModule="";
                String apiName="";
                String apiLink="";
                String apiRequest="";
                String requestBody="";
                String testCaseType="";
                String expected_code="";
                String remark="";
                String token_key="";

                Cell cell = sheet.getRow(i).getCell(1);
                if(cell!=null)
                {
                    apiModule=getCellValueAsString(cell);
                }

                cell=sheet.getRow(i).getCell(2);
                if(cell!=null)
                {
                    apiName=getCellValueAsString(cell);
                }

                cell=sheet.getRow(i).getCell(3);
                if(cell!=null)
                {
                    apiLink=getCellValueAsString(cell);
                }

                cell=sheet.getRow(i).getCell(4);
                if(cell!=null)
                {
                    apiRequest = getCellValueAsString(cell);
                }

                cell=sheet.getRow(i).getCell(5);
                if(cell!=null)
                {
                    requestBody = getCellValueAsString(cell);
                }

                cell=sheet.getRow(i).getCell(6);
                if(cell!=null)
                {
                    testCaseType = getCellValueAsString(cell);
                }

                cell=sheet.getRow(i).getCell(7);
                if(cell!=null)
                {
                    expected_code = getCellValueAsString(cell);
                }

                cell=sheet.getRow(i).getCell(8);
                if(cell!=null)
                {
                    remark = getCellValueAsString(cell);
                }

                cell=sheet.getRow(i).getCell(9);
                if(cell!=null)
                {
                    token_key = getCellValueAsString(cell);
                }

                ApiData apiData = new ApiData(apiModule,apiName,apiLink,apiRequest,requestBody,testCaseType,expected_code,remark,token_key);
                apiDataList.add(apiData);
            }
            return apiDataList;
        }
        catch(IOException ie)
        {
            throw new RuntimeException(ie);
        }
    }

    public static String getCellValueAsString(Cell cell)
    {
        switch(cell.getCellType())
        {
            case STRING: return cell.getStringCellValue();

            case NUMERIC: return String.valueOf(cell.getNumericCellValue());

            default:return "unknown cell type";
        }
    }

}
