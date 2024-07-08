package com.qa.readAndwrite;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ReadApiUrlsFromExcel {


    public List<ApiData> readApi()
    {
        String filepath ="ExcelData/PositiveNegativeTestcasesUrls.xlsx";
        try(FileInputStream fis = new FileInputStream(new File(filepath)); Workbook workbook = new XSSFWorkbook(fis))
        {
            Sheet sheet = workbook.getSheetAt(0);
            int lastRowNum=sheet.getLastRowNum();

            List<ApiData> apiDataList = new ArrayList<>();

            for(int i=1;i<=lastRowNum;i++)
            {
                String apiName="";
                String apiLink="";
                String apiRequest="";
                String requestBody="";
                String testCaseType="";
                String expected_code="";
                String remark="";
                String token_key="";

                Cell cell = sheet.getRow(i).getCell(0);
                if(cell!=null)
                {
                    apiName=getCellValueAsString(cell);
                  //  System.out.println("API Name : "+apiName);
                }

                cell=sheet.getRow(i).getCell(1);
                if(cell!=null)
                {
                    apiLink=getCellValueAsString(cell);
                  //  System.out.println("API Link : "+apiLink);
                }
                cell=sheet.getRow(i).getCell(2);
                if (cell!=null)
                {
                    apiRequest=getCellValueAsString(cell);
                   // System.out.println("Api Request : "+apiRequest);
                }

                cell=sheet.getRow(i).getCell(3);
                if (cell!=null)
                {
                    requestBody=getCellValueAsString(cell);
                   // System.out.println("Request Body : "+requestBody);
                }

                cell=sheet.getRow(i).getCell(4);
                if(cell!=null)
                {
                    testCaseType=getCellValueAsString(cell);
                   // System.out.println("Test Case Type : "+testCaseType);
                }
                cell=sheet.getRow(i).getCell(5);
                if (cell!=null)
                {
                    expected_code=getCellValueAsString(cell);
                   // System.out.println("Expected code : "+expected_code);
                }
                cell=sheet.getRow(i).getCell(6);
                if(cell!=null)
                {
                    remark=getCellValueAsString(cell);
                   // System.out.println("Remark : "+remark);
                }
                cell=sheet.getRow(i).getCell(7);
                if (cell!=null)
                {
                    token_key=getCellValueAsString(cell);
                   // System.out.println("Token key : "+token_key);
                }

                ApiData apiData = new ApiData(apiName, apiLink, apiRequest, requestBody, testCaseType, expected_code, remark, token_key);
                apiDataList.add(apiData);
            }

            return apiDataList;

            //Displaying ApiData class object values


            /*for(ApiData data:apiDataList)
            {

                System.out.println(data);


            }*/
        }
         catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
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
