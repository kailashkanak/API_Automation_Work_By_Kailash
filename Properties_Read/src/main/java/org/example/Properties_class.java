package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Properties_class {
    public static String main(String[] args) throws IOException {


        FileInputStream fis = new FileInputStream("C:\\Users\\KAILASH PRASAD KANAK\\Intellij-workspace\\Properties_Read\\src\\main\\resources\\HES.properties");
        Properties pobj = new Properties();
        pobj.load(fis);
        String value = pobj.getProperty("BLP");
        System.out.println(value);
        return value;
    }
}