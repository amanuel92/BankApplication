/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp;

import java.time.*;
import java.io.*;

/**
 *
 * @author amanuelgetahun
 */
public class Transaction implements Serializable{
    
    //time
  
    private final long accountNum;
    private final char transactionType;
    private final double transactionAmount;
    private final LocalDate transactionDate;
    private final LocalTime transactionTime;
    
    
    Transaction (long accountNum, char transactionType, double transactionAmount) {
        
        
        
        this.accountNum = accountNum;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.transactionDate = LocalDate.now();
        this.transactionTime = LocalTime.now(); 
        
        //track emplyee that handled transaction 
    }
    
    
    public long getAccountNumOfTransaction() {
        
        return accountNum;
    }
    public char getTransactionType(){
        
        return transactionType;
    }
    public double getTransactionAmount() {
        
        return transactionAmount;
    }
    public LocalDate getTransactionDate() {
        return transactionDate;
    }
    public LocalTime getTransactionTime(){
        
        return transactionTime;
    }
    public void displayTransaction() {
        
        //maybe show negative for withdrawals and + for deposits   
        System.out.println(accountNum + " " + transactionType + " " + transactionAmount + " " + 
                transactionDate + " " + transactionTime);
    
    }
   
}
