package com.company;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

public class DataManager {
    private String date;
    private Time time;
    private String account;
    private String description;
    private Boolean isDebit;
    private Boolean isCredit;
    private long debit;
    private long credit;
    private long amount;
    private Object data[][];

    public DataManager(){}

    public DataManager(String date,Time time,String account, String description, Boolean debit, Boolean credit, long amount) {
        this.date = date;
        this.time = time;
        this.account = account;
        this.description = description;
        this.isDebit = debit;
        this.isCredit = credit;
        this.amount = amount;
        if(this.isDebit ==true&&this.isCredit ==false){
            this.debit=this.amount;
            this.credit=0;
        }else if(this.isDebit ==false&&this.isCredit ==true){
            this.debit=0;
            this.credit = this.amount;
        }else{
            String error= "Unknown error";
        }
        this.data = new Object[][]{{this.date,this.time,this.account,this.description,this.debit,this.credit}};
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Time getTime() {
        return this.time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsDebit() {
        return isDebit;
    }

    public void setIsDebit(Boolean isDebit) {
        this.isDebit = isDebit;
    }

    public Boolean getIsCredit() {
        return isCredit;
    }

    public void setIsCredit(Boolean isCredit) {
        this.isCredit = isCredit;
    }

    public long getDebit() {
        return debit;
    }

    public void setDebit(long debit) {
        this.debit = debit;
    }

    public long getCredit() {
        return credit;
    }

    public void setCredit(long credit) {
        this.credit = credit;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Object[][] getData() {
        return this.data;
    }

    public void setData(Object[][] data) {
        this.data = data;
    }
    public Object[][] password(String password) {

            this.account= password;

            this.data = new Object[][]{{this.account}};
            return this.data;
    }
    public Object[][] headers(){
        String date = "Date";
        String time= "time";
        String account ="account";
        String description="Description";
        String debit="Debit";
        String credit ="Credit";

        Object[][] data={{date,time,account,description,debit,credit}};
        return data;
    }

}
