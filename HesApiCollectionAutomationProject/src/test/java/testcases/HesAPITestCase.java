package testcases;


import com.qa.readAndwrite.ApiData;
import com.qa.readAndwrite.ReadApiUrlsFromExcel;
import com.qa.readAndwrite.WriteDataInCSV;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class HesAPITestCase {

    @Test
    public void testCase1()
    {
        ReadApiUrlsFromExcel readingApi = new ReadApiUrlsFromExcel();

        List<ApiData> testData = readingApi.readApi();
        System.out.println("Total Records: "+testData.size());
        WriteDataInCSV writeData = new WriteDataInCSV();

        writeData.writeDataToCSVFile(testData);
    }
}
