/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp;
import java.time.LocalDate;
import java.util.*;
import java.io.*;

/**
 *
 * @author amanuelgetahun
 */
public abstract class Account {
    
    
    
    private final Customer owner;
    private final long accountNumber;
    private double accountBalance;
    private final String accountType;
    private final ArrayList<Transaction> accountTransactions = new ArrayList<>();

    
    Account(Customer owner,double openingDeposit, String accountType, long accountNum) {
        
       
        this.owner = owner;
        this.accountNumber = accountNum;
        this.accountBalance = openingDeposit;
        this.accountType = accountType;
     
    }
    
 

    public Transaction Deposit(double depositAmount) {
        
        if (depositAmount > 0) {
        
        accountBalance = accountBalance + depositAmount;
        Transaction trans = new Transaction(this.accountNumber, 'D', depositAmount);
        accountTransactions.add(trans);
        
        return trans;
       
        } else {
            
            System.out.println("Amount has to be greater than 0.0"); 
        }
        
        return null;
        
    }  
    public Transaction Withdraw(double withdrawAmount) {
        
        if (withdrawAmount > 0) {
        
            if (accountBalance >= withdrawAmount) {
            
                accountBalance = accountBalance - withdrawAmount;
                Transaction trans = new Transaction(this.accountNumber, 'W', withdrawAmount);       
                accountTransactions.add(trans);
                
                return trans;
                
            
            } else {
            
                System.out.println("Insufficient Funds");
            }
        
        } else {
            
            
            System.out.println("Amount has to be greater than 0.0");
            
        }
        
        return null;
        
    } 
    
    public final String getAccountType() {
        
        return accountType;
    }
    public final double getAccountBalance () {
        
        return accountBalance;
       
        
    }
    public final long getAccountNumber() {
        
        
        return accountNumber;
        
    }
    public final String getAccountOwner() {
        
        return owner.getCustomerName();
        
    }
    
  
    public void displayAccountInfo() {

        System.out.println("Account Type: " + getAccountType() + " " + "Account Number : " + getAccountNumber() );
        System.out.println("Account Balance :" + getAccountBalance());
        
    }
    
    
    
    public void displayAccountTransactions() {
        
        accountTransactions.forEach((transaction) -> {
            transaction.displayTransaction();
        });  
    }
    public void displayTodayTransactions() {
        
        for (Transaction transaction : accountTransactions) {
            
            
           if (transaction.getTransactionDate().equals(LocalDate.now())) {
               
               transaction.displayTransaction();
               
           } else {
               
               System.out.println("0 transaction today");
           }
  
        }
    }  
    public void displayTransactionsByYear(int year) {
        
        
        for (Transaction transaction : accountTransactions) {
            
            
           if (transaction.getTransactionDate().getYear() == year) {
               
               transaction.displayTransaction();
               
           } else {
               
               System.out.println("0 transaction in " + year);
           }
  
        }
 
       
    }
    public void displayTransactionsByMonth(int month) {
        
         
         for (Transaction transaction : accountTransactions) {
            
            
           if (transaction.getTransactionDate().getMonthValue() == month) {
               
               transaction.displayTransaction();
               
           } else {
               
               System.out.println("0 transaction in " + month);
           }
  
        }
         
         
         
         
    }
    public void displayTransactionbyType(String transactionType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
