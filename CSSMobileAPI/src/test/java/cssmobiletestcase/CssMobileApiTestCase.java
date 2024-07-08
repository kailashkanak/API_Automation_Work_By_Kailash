package cssmobiletestcase;

import collectNewExcelData.ApiData;
import collectNewExcelData.ReadAPIUrlsFromExcel;
import collectNewExcelData.WriteDataToCSV;
import org.testng.annotations.Test;

import java.util.List;

public class CssMobileApiTestCase
{
    @Test
    public void testCase1()
    {
        ReadAPIUrlsFromExcel readUrlsFromExcel = new ReadAPIUrlsFromExcel();

        WriteDataToCSV writeDataToCsv = new WriteDataToCSV();

        List<ApiData> testData = readUrlsFromExcel.readApi();
        System.out.println("Total Records: "+testData.size());

        writeDataToCsv.writeDataToCSVFile(testData);

    }
}
