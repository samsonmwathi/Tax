package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class Account {

    private String Date = new SimpleDateFormat("dd/mm/yyyy").format(new Date());
    private Time time= Time.valueOf(LocalTime.now());
    private int accountNumber = 1;
    private String accountTitle = "Payments Journal";
    boolean isCashDebit;
    boolean isCashCredit;
    boolean isItemDebit;
    boolean isItemCredit;
    private long debit=0;
    private long credit=0;

    public String getDate() {
        return this.Date;
    }

    public void setDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        date = new Date();
        this.Date = format.format(date);
    }

    public Time getTime() {
        return this.time;
    }

    public void setTime(Time time) {

        this.time = time;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountTitle() {
        return this.accountTitle;
    }

    public void setAccountTitle(String accountTitle) {
        this.accountTitle = accountTitle;
    }

    public boolean getisCashDebit(){
        return this.isCashDebit;
    }

    public void setisCashDebit(boolean debit){
        this.isCashDebit =debit;
    }

    public boolean getisCashCredit(){
        return this.isCashCredit;
    }

    public void setisCashCredit(boolean credit){
        this.isCashCredit=credit;
    }

    public boolean getisItemDebit() {
        return isItemDebit;
    }

    public void setisItemDebit(boolean itemDebit) {
        isItemDebit = itemDebit;
    }

    public boolean getisItemCredit() {
        return isItemCredit;
    }

    public void setisItemCredit(boolean itemCredit) {
        isItemCredit = itemCredit;
    }

    public long getDebit() {
        return this.debit;
    }

    public void setDebit(long debit) {
        this.debit = debit;
    }

    public long getCredit() {
        return this.credit;
    }

    public void setCredit(long credit) {
        this.credit = credit;
    }

    public Account(){

    }
//    public Account(String sheetname, Object data[][]){
//        DataManager dm= new DataManager();
//        dm.headers();
//
//        //writing the 2d array into an excel file
//        try {
//            Accountant paymentEntry1= new Accountant(sheetName, entry1);
//            PaymentForm.success("success");
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//            System.out.println("input output error in entry 1 of payments form");
//        }
//        try{
//            Accountant paymentEntry2= new Accountant(sheetName, (Object[][]) entry2);
//        }catch (IOException ioException){
//            ioException.printStackTrace();
//            System.out.println("input output error in entry 2 of payments form");
//        }
//    }
    public void password(String password) throws FileNotFoundException {
        String pass= password;
        DataManager login= new DataManager();
        Object[][] user = login.password(pass);
        Accountant secure = new Accountant();
        secure.write(password,user);
    }
    public void payment(String name, String details,long money)
    {   //processing the data into a 2d array
        //setting the date and time of the transaction
        String sheetName="Petty Cash Journal";
        String date= this.getDate();
        Time time = this.getTime();

        //setting the debit and credit for a purchase
        this.setisItemDebit(true);
        this.setisItemCredit(false);
        Boolean purchasesDebit=this.getisItemDebit();
        Boolean purchasesCredit=this.getisItemCredit();
        this.setisCashDebit(false);
        this.setisCashCredit(true);
        Boolean cashDebit=this.getisCashDebit();
        Boolean cashCredit=this.getisCashCredit();

        //setting the transaction details
        String receiver=name;
        String description= details;
        String cashDescription="cash";
        Long amount= money;

        //parsing the values into the DataManager to make a 2d array
        DataManager data1 = new DataManager(date,time,receiver,description,purchasesDebit,purchasesCredit,amount);
        Object [][]entry1 = data1.getData();
        DataManager data2 = new DataManager(date,time,receiver,cashDescription,cashDebit,cashCredit,amount);
        Object [][]entry2 = data2.getData();

        //writing the 2d array into an excel file
        try {
            Accountant paymentEntry1= new Accountant();
            paymentEntry1.write(sheetName, entry1);
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.out.println("input output error in entry 1 of payments form");
        }
        try{
            Accountant paymentEntry2= new Accountant();
            paymentEntry2.write(sheetName, entry2);
            paymentEntry2.total();
            PaymentForm.success("success");
        }catch (IOException ioException){
            ioException.printStackTrace();
            System.out.println("input output error in entry 2 of payments form");
        }

    };
    public void sales(String account, String description, long money){
        String sheetName="receipts Journal";
        String date= this.getDate();
        Time time = this.getTime();

        //setting the debit and credit for a purchase
        this.setisItemDebit(false);
        this.setisItemCredit(true);
        Boolean salesDebit=this.getisItemDebit();
        Boolean stockCredit=this.getisItemCredit();
        this.setisCashDebit(true);
        this.setisCashCredit(false);
        Boolean cashDebit=this.getisCashDebit();
        Boolean cashCredit=this.getisCashCredit();

        //setting the transaction details
        String customer=account;
        String item= description;
        String cashDescription="cash";
        Long amount= money;

        //parsing the values into the DataManager to make a 2d array
        DataManager data1 = new DataManager(date,time,customer,item,salesDebit,stockCredit,amount);
        Object [][]entry1 = data1.getData();
        DataManager data2 = new DataManager(date,time,customer,cashDescription,cashDebit,cashCredit,amount);
        Object [][]entry2 = data2.getData();

        //writing the 2d array into an excel file
        try {
            Accountant paymentEntry1= new Accountant();
            paymentEntry1.write(sheetName, entry1);
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.out.println("input output error in entry 1 of payments form");
        }
        try{
            Accountant paymentEntry2= new Accountant();
            paymentEntry2.write(sheetName, entry2);
            PaymentForm.success("success");
        }catch (IOException ioException){
            ioException.printStackTrace();
            System.out.println("input output error in entry 2 of payments form");
        }

    }
    public void debt(String creditor, long money, String deadline){
        String sheetName="General Journal";
        String date= this.getDate();
        Time time = this.getTime();

        //setting the debit and credit for a purchase
        this.setisItemDebit(false);
        this.setisItemCredit(true);
        Boolean debtDebit=this.getisItemDebit();
        Boolean debtCredit=this.getisItemCredit();
        this.setisCashDebit(true);
        this.setisCashCredit(false);
        Boolean cashDebit=this.getisCashDebit();
        Boolean cashCredit=this.getisCashCredit();

        //setting the transaction details
        String customer=creditor;
        String item= deadline;
        String cashDescription="debtor";
        Long amount= money;

        //parsing the values into the DataManager to make a 2d array
        DataManager data1 = new DataManager(date,time,customer,item,debtDebit,debtCredit,amount);
        Object [][]entry1 = data1.getData();
        DataManager data2 = new DataManager(date,time,customer,cashDescription,cashDebit,cashCredit,amount);
        Object [][]entry2 = data2.getData();

        //writing the 2d array into an excel file
        try {
            Accountant paymentEntry1= new Accountant();
            paymentEntry1.write(sheetName, entry1);
            CreditorForm.success("success");

        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.out.println("input output error in entry 1 of payments form");
        }
        try{
            Accountant paymentEntry2= new Accountant();
            paymentEntry2.write(sheetName, entry2);
            PaymentForm.success("success");
        }catch (IOException ioException){
            ioException.printStackTrace();
            System.out.println("input output error in entry 2 of payments form");
        }
    }
    public void debtor(String creditor, long money, String deadline){
        String sheetName="General Journal";
        String date= this.getDate();
        Time time = this.getTime();

        //setting the debit and credit for a purchase
        this.setisItemDebit(true);
        this.setisItemCredit(false);
        Boolean debtDebit=this.getisItemDebit();
        Boolean debtCredit=this.getisItemCredit();
        this.setisCashDebit(false);
        this.setisCashCredit(true);
        Boolean cashDebit=this.getisCashDebit();
        Boolean cashCredit=this.getisCashCredit();

        //setting the transaction details
        String customer=creditor;
        String item= deadline;
        String cashDescription="debt";
        Long amount= money;

        //parsing the values into the DataManager to make a 2d array
        DataManager data1 = new DataManager(date,time,customer,item,debtDebit,debtCredit,amount);
        Object [][]entry1 = data1.getData();
        DataManager data2 = new DataManager(date,time,customer,cashDescription,cashDebit,cashCredit,amount);
        Object [][]entry2 = data2.getData();

        //writing the 2d array into an excel file
        try {
            Accountant paymentEntry1= new Accountant();
            paymentEntry1.write(sheetName, entry1);
            CreditorForm.success("success");

        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.out.println("input output error in entry 1 of payments form");
        }
        try{
            Accountant paymentEntry2= new Accountant();
            paymentEntry2.write(sheetName, entry2);
            PaymentForm.success("success");
        }catch (IOException ioException){
            ioException.printStackTrace();
            System.out.println("input output error in entry 2 of payments form");
        }
    }
}
