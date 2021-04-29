package com.company;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class WritingExcelFileDemo {

    private XSSFWorkbook book;
    private XSSFSheet sheet;
    private XSSFRow row;
    private XSSFCell cell;
    //String url="\\data\\payments.xls";


    Object emptydata[][]={
                            {"EmpID","Name","job"},
                            {101,"David","Engineer"},
                            {102,"Smith","Manager"}
    };

    private int rows =emptydata.length;
    private int cols =emptydata[0].length;



    public WritingExcelFileDemo(String sheetName,Object data[][]) throws IOException
    {
//        HSSFWorkbook book = new HSSFWorkbook("C:\\Users\\Samson\\IdeaProjects\\Tax\\Data\\demo.xls");
//        HSSFSheet sheet = book.createSheet("Payments Records");
//        HSSFRow row = sheet.createRow(1);
//        HSSFCell cell= row.createCell(1);

//        File excel = new File("C:\\Users\\Samson\\IdeaProjects\\Tax\\Data\\demo.xls");
//        FileInputStream input = new FileInputStream(excel);
//        XSSFWorkbook book = new XSSFWorkbook(input);

        FileInputStream input = new FileInputStream("C:\\Users\\Samson\\IdeaProjects\\Tax\\Data\\payments.xlsx");
        this.book = new XSSFWorkbook(input);
        this.sheet = this.book.createSheet(sheetName);
        int insertRow = 0;
        if(sheet.getLastRowNum()>0){
            insertRow= sheet.getLastRowNum()+1;
        }
        this.row = sheet.createRow(insertRow);
        int dataRows= data.length;
        int dataCol=data[0].length;
        for (int r=1; r<dataRows; r++){
            for(int c=1;c<dataCol; c++){
                Object entry = data[r][c];
                this.cell = row.createCell(c);

                if(entry instanceof Integer) {
                    cell.setCellValue((Integer)entry);
                }
                if(entry instanceof Long){
                    cell.setCellValue((Long)entry);
                }
                if(entry instanceof String){
                    cell.setCellValue(String.valueOf(entry));
                }
                if(entry instanceof Date){
                    cell.setCellValue((Date)entry);
                }
                if ( entry instanceof LocalTime){
                    cell.setCellValue(LocalDateTime.from((LocalTime)entry));
                }
                if(entry instanceof Boolean){
                    cell.setCellValue((Boolean)entry);
                }
            }
        }

        this.book.write(new FileOutputStream("C:\\Users\\Samson\\IdeaProjects\\Tax\\Data\\payment.xlsx"));

    }




    // an example of a simple method for writing in a value int ot the excel sheet
    /*
    public void write(){
        //r stands for the rows while c stands for the columns... we iterate rows then columns
        for(int r =0; r<rows; r++){
            XSSFRow row =sheet.createRow(r);   //first we create the row we want to write to
            for(int c=0;c<cols;c++){
                Object value= emptydata[r][c]; //we call our data as a 2d array and store it in another variable so that it can be used for other functions
                XSSFCell cell= row.createCell(c);//create the cell we are going to use to write on
                //consecutive if statements to write the various data types
                if (value instanceof String){
                    cell.setCellValue(String.valueOf(value));
                }
                if( value instanceof Integer){
                    cell.setCellValue((Integer)value);
                }
                if(value instanceof Boolean){
                    cell.setCellValue((Boolean)value);
                }
            }
        }
    }
    */

    // for writing a new entry into the excel sheet of your choice
    // pass in the sheet name and the data as an array
    public void addEntry(String sheetName, Object entry[][]){

        this.sheet = book.getSheet(sheetName);
        int nextRow = sheet.getLastRowNum()+1;
        this.row = sheet.createRow(nextRow);
        for(int r=0;r<entry.length;r++){
            for(int c=0 ; c<entry[0].length;c++)
            {
               Object newEntry=entry[r][c];
               XSSFCell cell= this.row.createCell(c);
               if( newEntry instanceof Integer){
                   cell.setCellValue((Integer)newEntry);
               }
               if(newEntry instanceof String){
                   cell.setCellValue(String.valueOf(newEntry));
               }
               if(newEntry instanceof Date){
                   cell.setCellValue((Date)newEntry);
               }
               if(newEntry instanceof Boolean){
                   cell.setCellValue((Boolean)newEntry);
               }

               if(newEntry instanceof Long){
                   cell.setCellValue((Long)newEntry);
               }


            }
        }



    }

}
