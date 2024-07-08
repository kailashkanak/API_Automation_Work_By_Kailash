package org.example;

import java.io.FileInputStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public void readAPIUrls()
    {
        try
        {
            FileInputStream fis = new FileInputStream("C:\\Users\\KAILASH PRASAD KANAK\\Intellij-workspace\\EsyaHesApiCollection\\ExcelData\\MeterInfo");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}