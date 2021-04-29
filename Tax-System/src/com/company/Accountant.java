package com.company;

import com.sun.jdi.IntegerValue;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.management.StringValueExp;
import java.io.*;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.SimpleFormatter;

public class Accountant {

    private XSSFWorkbook book;
    private XSSFSheet sheet;
    private XSSFRow row;
    private XSSFCell cell;
    String path="C:\\xampp\\htdocs\\Tax-System\\data\\workbook.xlsx";
    public Accountant(){

    }

    public void headings() throws FileNotFoundException {
        Object arr[][]=new Object[][]{
                {"Date","Time","Account Number","Description","Debit","Credit"}
        };
        int titleRows= arr.length;
        int titleCol=arr[0].length;
        this.row = sheet.createRow(0);
        int c = 0;
        int r=0;
        while (c < titleCol) {
            Object title = arr[r][c];
            this.cell = row.createCell(c);

            if (title instanceof Integer) {
                cell.setCellValue((Integer) title);
            }
            if (title instanceof Long) {
                cell.setCellValue((Long) title);
            }
            if (title instanceof String) {
                cell.setCellValue(String.valueOf(title));
            }
            c++;
        }
        FileOutputStream fos = new FileOutputStream(new File(path));
        try {
            this.book.write(fos);
            fos.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    public void write(String sheetName,Object data[][]) throws FileNotFoundException
    {
//        HSSFWorkbook book = new HSSFWorkbook("C:\\Users\\Samson\\IdeaProjects\\Tax\\Data\\demo.xls");
//        HSSFSheet sheet = book.createSheet("Payments Records");
//        HSSFRow row = sheet.createRow(1);
//        HSSFCell cell= row.createCell(1);
        FileInputStream input =new FileInputStream(path);
        try {
            this.book = new XSSFWorkbook(input);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        if(book.getSheet(sheetName)==null){
            this.sheet = this.book.createSheet(sheetName);
        }else if(book.getSheet(sheetName)!=null){
            this.sheet= this.book.getSheet(sheetName);
        }
        int insertRow = 0;
        if(sheet.getLastRowNum()<1){
            this.headings();
            insertRow = 1;
        }
        else if(sheet.getLastRowNum()>=1){
            insertRow= sheet.getLastRowNum()+1;
        }

        int dataRows= data.length;
        int dataCol=data[0].length;
        for (int r=0; r<dataRows; r++){
            this.row = this.sheet.createRow(insertRow+r);
            for(int c=0;c<dataCol; c++){
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
                if ( entry instanceof Time){
                    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSSz");
                    String time = format.format(entry);
                    cell.setCellValue(time);
                }
                if(entry instanceof Boolean){
                    cell.setCellValue((Boolean)entry);
                }
                insertRow=sheet.getLastRowNum();
            }
        }
        FileOutputStream output = new FileOutputStream(new File(path));
        try {
            this.book.write(output);
            output.close();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        try {

            input.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    public void total() throws FileNotFoundException {

        int row1 = 1;
        String firstRowLastCell="A";
        String firstRowSecondLastCell="B";




        int lastrow = this.sheet.getLastRowNum();
        XSSFRow totalrow= this.sheet.createRow(lastrow+2);
        XSSFCell totalCell= totalrow.createCell(1);
        totalCell.setCellValue("Total");

        String lastCell="E";
        String secondLastCell="F";
        XSSFCell debitCell= totalrow.createCell(4);
        XSSFCell creditCell= totalrow.createCell(5);
        String creditCellFormula="Sum("+lastCell+row1+":"+lastCell+lastrow+")";
        String debitCellFormula="Sum("+secondLastCell+row1+":"+secondLastCell+lastrow+")";
        System.out.println(creditCellFormula);
        System.out.println(debitCellFormula);
        creditCell.setCellFormula(creditCellFormula);
        debitCell.setCellFormula(debitCellFormula);
        FileOutputStream fis= new FileOutputStream(path);
        try {
            book.write(fis);
            fis.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
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

        this.sheet = this.book.getSheet(sheetName);
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
