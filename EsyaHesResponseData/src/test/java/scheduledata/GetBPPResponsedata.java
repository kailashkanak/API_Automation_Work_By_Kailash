package scheduledata;

import com.opencsv.CSVWriter;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.util.HashMap;

public class GetBPPResponsedata {
    @Test
    public void getBPP1pResponsedata()
    {
        HashMap hm = new HashMap();

        hm.put("Msn", "-1");
        hm.put("EventId", "");
        hm.put("FromDate", "2022-10-01");
        hm.put("ToDate", "2022-11-21");
        hm.put("Offset", 0);
        hm.put("Limit", 1000);
        hm.put("Profile", 2);
        hm.put("Phase", 1);

        RestAssured.baseURI = "http://10.159.1.19:8001/api/scheduledata";
        Response response = RestAssured.given().header("content-type", "application/json")
                .body(hm)
                .when()
                .get()
                .then()
                .log().all()
                .extract().response();

        String responseBody = response.getBody().asString();
        String csvFilePath = "C:\\Users\\KAILASH PRASAD KANAK\\Intellij-workspace\\EsyaHesResponseData\\CSVFile\\BPP1p_ResponseData.csv";
        try {
            FileWriter outputfile = new FileWriter(csvFilePath);
            CSVWriter writer = new CSVWriter(outputfile);
            String[] data = {responseBody};
            writer.writeNext(data);
            System.out.println("Response data saved to CSV file successfully.");
            writer.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
