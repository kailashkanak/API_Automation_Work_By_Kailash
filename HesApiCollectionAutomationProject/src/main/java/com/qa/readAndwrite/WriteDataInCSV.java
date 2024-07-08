package com.qa.readAndwrite;


import com.opencsv.CSVWriter;
import io.restassured.response.Response;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.List;

import static io.restassured.RestAssured.given;

public class WriteDataInCSV {


    public void writeDataToCSVFile(List<ApiData> dataCollection)
    {
        String fileSource = "TestReportCSVFile\\TestReport.csv";
        try(FileWriter outputfile = new FileWriter(fileSource);CSVWriter writer = new CSVWriter(outputfile))
        {

            String[] header = {"S_No","API Name","API Link","API Request","Test case Type","Response Time","Expected Status code","Actual Status code","Status","Remark","Request Body"};
            writer.writeNext(header);
            int sno=1;
            System.out.println("Total records row wise ="+dataCollection.size());
            System.out.println("Total records "+dataCollection.size());
            //for(int i=1;i<=dataCollection.size();i++) {
            for(ApiData data:dataCollection)
            {

                String s_no = Integer.toString(sno);
                sno++;
                String apiName= data.getApiName();
                String apiLink= data.getApiLink();
                String apiRequest=data.getApiRequest();
                String testCaseType= data.getTestCaseType();
                String expCodeInString= data.getExpected_code();
                String remark=data.getRemark();
                String token_key = data.getToken_key();
                String requestBody= data.getRequestBody();

               // Initializing Extent Report



                Response res;
                if (apiRequest.equals("GET"))
                {

                    if (token_key.equals(""))
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .body(requestBody)
                                .when()
                                .get(apiLink);
                    }
                    else
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .auth().oauth2(token_key)
                                .body(requestBody)
                                .when()
                                .get(apiLink);
                    }
                }
                else if (apiRequest.equals("POST"))
                {

                    if (token_key.equals(""))
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .body(requestBody)
                                .when()
                                .post(apiLink);
                    }
                    else
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .auth().oauth2(token_key)
                                .body(requestBody)
                                .when()
                                .post(apiLink);
                    }
                }
                else if (apiRequest.equals("PUT"))
                {

                    if (token_key.equals(""))
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .body(requestBody)
                                .when()
                                .put(apiLink);
                    }
                    else {

                        res = given()
                                .header("Content-Type", "application/json")
                                .auth().oauth2(token_key)
                                .body(requestBody)
                                .when()
                                .put(apiLink);
                    }
                }
                else
                {
                    if (token_key.equals(""))
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .body(requestBody)
                                .when()
                                .delete(apiLink);
                    }
                    else
                    {

                        res = given()
                                .header("Content-Type", "application/json")
                                .auth().oauth2(token_key)
                                .body(requestBody)
                                .when()
                                .delete(apiLink);
                    }


                }

                double exp_code = Double.parseDouble(expCodeInString);
                int expectedCode = (int)exp_code;

                long time = res.getTime();
                String resTime = Long.toString(time)+" Milliseconds";
                int status_code = res.getStatusCode();
                System.out.println(status_code);
                String actual_status_code = Integer.toString(status_code);
                String test_status = "";
                if(expectedCode==status_code)
                {
                    test_status = "Pass";
                }
                else
                {
                    test_status = "Fail";
                }
                // Displaying Data on Console
                System.out.println(s_no);
                System.out.println(apiName);
                System.out.println(apiLink);
                System.out.println(apiRequest);
                System.out.println(testCaseType);
                System.out.println("Response Time : "+resTime);
                System.out.println(expCodeInString);

                System.out.println("Expected code : "+expectedCode);

                System.out.println("Actual Status code : "+status_code);
                System.out.println("Test Status : "+test_status);
                System.out.println(remark);
                System.out.println(token_key);

                String[] data1 = {s_no,apiName,apiLink,apiRequest,testCaseType,resTime,expCodeInString,actual_status_code,test_status,remark,requestBody};
                writer.writeNext(data1);
            }
            writer.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }


}
