package collectNewExcelData;

import com.opencsv.CSVWriter;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class WriteDataToCSV
{
    //Declaration Global variables which will store response from Login Module Api and will be use further by other modules
    String login_token_key;
    String refreshToken;
    String CANumber;
    String HashCode;
    String Name;
    String mobilenumber;
    int roleid;
    int PaymentTypeID;
    int loginId;
    int PHASE;
    int MID;
    String Tariff;
    Response res;
    public void writeDataToCSVFile(List<ApiData> dataCollection)
    {
        String fileSource = "AutomationTestReportInCsv/TestReportIn CsvFormat.csv";
        try(FileWriter outputfile = new FileWriter(fileSource); CSVWriter writer = new CSVWriter(outputfile))
        {
            String[] header = {"SNo","API Module","API Name","API URL","API Request","Test Case Type","Expected Status Code","Actual Status code","Test Status","Response Time","Remark","Request Body"};
            writer.writeNext(header);
            int sno=1;
            System.out.println("Total records row wise ="+dataCollection.size());

            for(ApiData data:dataCollection)
            {
                String s_no = Integer.toString(sno);
                sno++;

                String apiModule = data.getAPImodule();
                String apiName = data.getAPIName();
                String apiUrl = data.getAPIUrl();
                String apiRequest = data.getApiRequest();
                String apiRequestBody = data.getRequestBody();
                String testCaseType = data.getTestCasetype();
                String expected_status_code = data.getExpected_statusCode();
                String remark = data.getRemark();
                String token_key=data.getToken_key();

                if(apiRequest.equals("POST") && apiName.equals("VerifyCIDApiConstant"))
                {
                    if (token_key.equals(""))
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .body(apiRequestBody)
                                .when()
                                .post(apiUrl);
                    }
                    else
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .auth().oauth2(token_key)
                                .body(apiRequestBody)
                                .when()
                                .post(apiUrl);
                    }
                }
                else if (apiRequest.equals("POST") && apiName.equals("VerifyOTP"))
                {
                    if (token_key.equals(""))
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .body(apiRequestBody)
                                .when()
                                .post(apiUrl);
                    }
                    else
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .auth().oauth2(token_key)
                                .body(apiRequestBody)
                                .when()
                                .post(apiUrl);
                    }
                }

                else if(apiRequest.equals("POST") && apiName.equals("Registration"))
                {
                    if (token_key.equals(""))
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .body(apiRequestBody)
                                .when()
                                .post(apiUrl);
                    }
                    else
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .auth().oauth2(token_key)
                                .body(apiRequestBody)
                                .when()
                                .post(apiUrl);
                    }
                }
                else if(apiRequest.equals("POST") && apiName.equals("Login"))
                {
                    if (token_key.equals(""))
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .body(apiRequestBody)
                                .when()
                                .post(apiUrl);
                    }
                    else
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .auth().oauth2(token_key)
                                .body(apiRequestBody)
                                .when()
                                .post(apiUrl);


                    }
                    // The below data required to be passed in other API

                    login_token_key = res.jsonPath().getString("token");
                    refreshToken = res.jsonPath().getString("refreshToken");
                    CANumber=res.jsonPath().getString("CANumber");
                    Name=res.jsonPath().getString("Name");
                    HashCode=res.jsonPath().getString("HashCode");
                    mobilenumber=res.jsonPath().getString("mobilenumber");
                    roleid=res.jsonPath().getInt("roleid");
                    PaymentTypeID=res.jsonPath().getInt("PaymentTypeID");
                    loginId = res.jsonPath().getInt("LangID");
                    PHASE=res.jsonPath().getInt("PHASE");
                    MID=res.jsonPath().getInt("MID");
                    Tariff=res.jsonPath().getString("Tariff");

                }
                else if(apiRequest.equals("POST") && apiName.equals("SideMenu"))
                {
                    if (token_key.equals(""))
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .body(apiRequestBody)
                                .when()
                                .post(apiUrl);
                    }
                    else
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .auth().oauth2(login_token_key)
                                .body(apiRequestBody)
                                .when()
                                .post(apiUrl);
                    }
                }
                else if(apiRequest.equals("POST") && apiName.equals("ProfileInformation"))
                {
                    if (token_key.equals(""))
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .body(apiRequestBody)
                                .when()
                                .post(apiUrl);
                    }
                    else
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .auth().oauth2(login_token_key)
                                .body(apiRequestBody)
                                .when()
                                .post(apiUrl);
                    }
                }
                else if(apiRequest.equals("POST") && apiName.equals("Notification"))
                {
                    HashMap hm = new HashMap();
                    hm.put("LoginID",CANumber);
                    hm.put("MeterID",MID);
                    hm.put("Phase",PHASE);
                    if (token_key.equals(""))
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .body(hm)
                                .when()
                                .post(apiUrl);
                    }
                    else
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .auth().oauth2(login_token_key)
                                .body(hm)
                                .when()
                                .post(apiUrl);
                    }
                }
                else if(apiRequest.equals("POST") && apiName.equals("AccountDetails"))
                {
                    HashMap hm1 = new HashMap();
                    hm1.put("LoginID",loginId);
                    if (token_key.equals(""))
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .body(hm1)
                                .when()
                                .post(apiUrl);
                    }
                    else
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .auth().oauth2(login_token_key)
                                .body(hm1)
                                .when()
                                .post(apiUrl);
                    }
                }
                else if(apiRequest.equals("POST") && apiName.equals("CheckBalance"))
                {
                    HashMap hm2 = new HashMap();
                    hm2.put("RRNumber",loginId);
                    if (token_key.equals(""))
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .body(hm2)
                                .when()
                                .post(apiUrl);
                    }
                    else
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .auth().oauth2(login_token_key)
                                .body(hm2)
                                .when()
                                .post(apiUrl);
                    }
                }
                else if(apiRequest.equals("POST") && apiName.equals("Dashboard"))
                {
                    HashMap hm3 = new HashMap();
                    hm3.put("LoginID",CANumber);
                    hm3.put("MeterID",MID);
                    hm3.put("Phase",PHASE);

                    if (token_key.equals(""))
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .body(hm3)
                                .when()
                                .post(apiUrl);
                    }
                    else
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .auth().oauth2(login_token_key)
                                .body(hm3)
                                .when()
                                .post(apiUrl);
                    }

                }
                else if(apiRequest.equals("POST") && apiName.equals("DayWiseConsumption"))
                {
                    HashMap hm4 = new HashMap();
                    hm4.put("LoginID",CANumber);
                    hm4.put("MeterID",MID);
                    hm4.put("Phase",PHASE);
                    hm4.put("FromDate","2024-01-01");
                    hm4.put("ToDate","2024-01-31");

                    if (token_key.equals(""))
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .body(hm4)
                                .when()
                                .post(apiUrl);
                    }
                    else
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .auth().oauth2(login_token_key)
                                .body(hm4)
                                .when()
                                .post(apiUrl);
                    }

                }
                else if(apiRequest.equals("POST") && apiName.equals("MeterDetails"))
                {
                    HashMap hm5 = new HashMap();
                    hm5.put("LoginID","11010224608");
                    hm5.put("MeterID",MID);
                    hm5.put("MeterSequence",2);
                    if (token_key.equals(""))
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .body(hm5)
                                .when()
                                .post(apiUrl);
                    }
                    else
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .auth().oauth2(login_token_key)
                                .body(hm5)
                                .when()
                                .post(apiUrl);
                    }

                }
                else if(apiRequest.equals("GET") && apiName.equals("MeterSequenceList"))
                {
                    if (token_key.equals(""))
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .body(apiRequestBody)
                                .when()
                                .get(apiUrl);
                    }
                    else
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .auth().oauth2(login_token_key)
                                .body(apiRequestBody)
                                .when()
                                .get(apiUrl);
                    }
                }
                else if(apiRequest.equals("POST") && apiName.equals("LatestIPData"))
                {
                    HashMap hm6 = new HashMap();
                    hm6.put("LoginID",CANumber);
                    hm6.put("MeterID",MID);
                    hm6.put("Phase",PHASE);

                    if (token_key.equals(""))
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .body(hm6)
                                .when()
                                .post(apiUrl);
                    }
                    else
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .auth().oauth2(login_token_key)
                                .body(hm6)
                                .when()
                                .post(apiUrl);
                    }

                }
                else if(apiRequest.equals("POST") && apiName.equals("TarrifDetails"))
                {
                    HashMap hm7 = new HashMap();
                    hm7.put("LoginID",CANumber);
                    hm7.put("MeterID",MID);
                    hm7.put("Phase",PHASE);

                    if (token_key.equals(""))
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .body(hm7)
                                .when()
                                .post(apiUrl);
                    }
                    else
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .auth().oauth2(login_token_key)
                                .body(hm7)
                                .when()
                                .post(apiUrl);
                    }

                }
                else if(apiRequest.equals("POST") && apiName.equals("PayMyBill"))
                {
                    HashMap hm8 = new HashMap();
                    hm8.put("LoginID",CANumber);
                    hm8.put("MeterID",MID);
                    hm8.put("Phase",PHASE);

                    if (token_key.equals(""))
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .body(hm8)
                                .when()
                                .post(apiUrl);
                    }
                    else
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .auth().oauth2(login_token_key)
                                .body(hm8)
                                .when()
                                .post(apiUrl);
                    }

                }
                else if(apiRequest.equals("POST") && apiName.equals("PrepaidBilling"))
                {
                    HashMap hm9 = new HashMap();
                    hm9.put("LoginID",CANumber);
                    hm9.put("MeterID",MID);
                    hm9.put("Phase",PHASE);

                    if (token_key.equals(""))
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .body(hm9)
                                .when()
                                .post(apiUrl);
                    }
                    else
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .auth().oauth2(login_token_key)
                                .body(hm9)
                                .when()
                                .post(apiUrl);
                    }
                }
                else if(apiRequest.equals("POST") && apiName.equals("ProfileInformation"))
                {
                    HashMap hm10 = new HashMap();
                    hm10.put("LoginID",loginId);
                    if (token_key.equals(""))
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .body(hm10)
                                .when()
                                .post(apiUrl);
                    }
                    else
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .auth().oauth2(login_token_key)
                                .body(hm10)
                                .when()
                                .post(apiUrl);
                    }

                }
                else if(apiRequest.equals("POST") && apiName.equals("AccountDetails"))
                {
                    HashMap hm11 = new HashMap();
                    hm11.put("LoginID",loginId);
                    if (token_key.equals(""))
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .body(hm11)
                                .when()
                                .post(apiUrl);
                    }
                    else
                    {
                        res = given()
                                .header("Content-Type", "application/json")
                                .auth().oauth2(login_token_key)
                                .body(hm11)
                                .when()
                                .post(apiUrl);
                    }

                }
                else
                {
                    System.out.println("Wrong Request");
                }

                double exp_code = Double.parseDouble(expected_status_code);
                int expectedCode = (int)exp_code;
                expected_status_code=Integer.toString(expectedCode);

                long time = res.getTime();
                String response_time = Long.toString(time)+" Milliseconds";

                int status_code = res.getStatusCode();

                String actual_status_code = Integer.toString(status_code);

                String status = "";

                if(expectedCode==status_code)
                {
                    status = "Pass";
                }
                else
                {
                    status = "Fail";
                }

                String[] data1 = {s_no,apiModule,apiName,apiUrl,apiRequest,testCaseType,expected_status_code,actual_status_code,status,response_time,remark,apiRequestBody};
                writer.writeNext(data1);

                //Displaying Data

                System.out.println(s_no);
                System.out.println("API Module : "+apiModule);
                System.out.println("Api Name : "+apiName);
                System.out.println("Api Url : "+apiUrl);
                System.out.println("HTTP Request Type :"+apiRequest);
                System.out.println("Test Case Type : "+testCaseType);
                System.out.println("Expected Status Code : "+expected_status_code);

                System.out.println("Actual Status code : "+actual_status_code);

                System.out.println("Response Time : "+response_time);
                System.out.println("Test Status : "+status);
                System.out.println("Remark :  "+remark);

            }
            writer.close();
        }
        catch(IOException ie)
        {
            throw new RuntimeException(ie);
        }
    }
}

