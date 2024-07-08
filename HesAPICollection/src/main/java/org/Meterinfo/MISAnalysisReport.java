package org.Meterinfo;

import com.opencsv.CSVWriter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import static io.restassured.RestAssured.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MISAnalysisReport {

    public  void getMIS()
    {
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\KAILASH PRASAD KANAK\\Intellij-workspace\\HesAPICollection\\ExcelData\\MeterInfoAPIUrls.xlsx");
            Workbook wb = WorkbookFactory.create(fis);
            Sheet s = wb.getSheetAt(0);
            int lastRowNum = s.getLastRowNum();

            String timeStamp = new SimpleDateFormat("YYYY.MM.dd.HH.mm.ss").format(new Date());

            FileWriter outputfile = new FileWriter("C:\\Users\\KAILASH PRASAD KANAK\\Intellij-workspace\\HesAPICollection\\extentreports\\MeterInfo" + "-" + timeStamp + ".csv");
            CSVWriter writer = new CSVWriter(outputfile);
            String[] header = {"S_No", "API Link", "API Name", "API Request", "Status Code", "Status Message", "Response Time", "MSN", "Meter Categories", "Port Number", "IP Address"};
            writer.writeNext(header);

            int sno = 1;

            for (int i = 1; i <= lastRowNum; i++) {
                String apiLink = "";
                String api_name = "";
                String api_request_type = "";
                String api_request_body = "";
                Cell cell = s.getRow(i).getCell(1);
                if (cell != null) {
                    apiLink = cell.getStringCellValue();
                }

                cell = s.getRow(i).getCell(2);
                if (cell != null) {
                    api_name = cell.getStringCellValue();
                }

                cell = s.getRow(i).getCell(3);
                if (cell != null) {
                    api_request_type = cell.getStringCellValue();
                }

                cell = s.getRow(i).getCell(4);
                if (cell != null) {
                    api_request_body = cell.getStringCellValue();
                }

                System.out.println("API LINK : " + apiLink);
                System.out.println("API Name :" + api_name);
                System.out.println("API Http Request :" + api_request_type);
                System.out.println("API Request Body :" + api_request_body);

                String snum = Integer.toString(sno);

                Response res = given()
                        .header("Content-Type", "application/json")
                        .log().all()
                        .body(api_request_body)
                        .when()
                        .get(apiLink);

                String apiResponse = res.asString();

                //extracting msn number from the response
                //extracting Meter category

                String msn = "";
                String meterType = "";
                String portnum = "";
                String ipAddress = "";
                JsonPath jsonPath = new JsonPath(apiResponse);


                if (api_request_type.equalsIgnoreCase("GET") && api_name.equalsIgnoreCase("GetMeterInfo")) {
                    msn = jsonPath.getString("msn");
                    meterType = jsonPath.getString("metercategory");
                    portnum = jsonPath.getString("portnumber");
                    ipAddress = jsonPath.getString("ipaddress");

                }

                System.out.println("Meter Number : "+msn);

                System.out.println("Meter Category : "+meterType);

                System.out.println("Port Number : "+portnum);

                System.out.println("IP Address : "+ipAddress);

                System.out.println(apiResponse);

                int statusCode = res.statusCode();

                String sCode = Integer.toString(statusCode);

                System.out.println("Status Code : "+sCode);

                long time = res.getTime();
                System.out.println("Response Time : "+time+" Milli Seconds");

                String resTime = Long.toString(time)+" Millisecond";

                String messg ="";

                if(statusCode==200||statusCode==201)
                {
                    messg  ="OK";
                }
                else
                {
                    messg = "Fail";
                }

                String[] data = {snum,apiLink,api_name,api_request_type,sCode,messg,resTime,msn,meterType,portnum,ipAddress};//apiResponse
                writer.writeNext(data);
                sno++;

            }
            writer.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }


    }

}