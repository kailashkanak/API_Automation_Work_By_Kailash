package excel;
import java.util.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HashMapToExcel
{
    public static void main(String[] args)
    {
        XSSFWorkbook workbook = new XSSFWorkbook(); //Creating a workbook
        XSSFSheet sheet = workbook.createSheet("student data"); // creating sheet

        //Declaring A HashMap to store data in Key-value pair

        Map<String,String> data = new HashMap<String,String>();
        data.put("01","Kumar");

    }
}
