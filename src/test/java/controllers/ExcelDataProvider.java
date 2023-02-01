package controllers;

import org.testng.annotations.DataProvider;

import java.io.File;

public class ExcelDataProvider {


    /*it is help to read data from excel with multiple sheets*/
    @DataProvider(name = "multiSheetExcelRead", parallel = true)
    public static Object[][] multiSheetExcelRead() throws Exception {
        File file = new File("src/test/resources/document.xlsx");
        String SheetName ="Sheet2";
        System.out.println(SheetName);
        System.out.println("Opening Excel File:" + file.getAbsolutePath());
        return ExcelUtils.getTableArray(file.getAbsolutePath(), SheetName);
    }


    /*it is help to read data from excel*/
    @DataProvider(name = "singleSheetExcelRead", parallel = true)
    public static Object[][] singleSheetExcelRead() throws Exception {
        File file = new File("src/test/resources/EnterCredentialsTest.xlsx" );
        System.out.println("Opening Excel File:" + file.getAbsolutePath());
        return ExcelUtils.getTableArray(file.getAbsolutePath());
    }
}
