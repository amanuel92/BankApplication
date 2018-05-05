/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp;
import java.util.*;
import java.io.*;

public class Customer {
    
    private String fname;
    private String lname;
    private String address;
    private final ArrayList<Account> accounts = new ArrayList<>();
    
    
    
    
    Customer (String fname, String lname, String address) {
        
        this.fname = fname;
        this.lname = lname;
        this.address = address; 
        
    }

    public boolean addAccount(Account account) {
        
        String accountType = account.getAccountType();
        int hasChecking = 0;
        int hasSaving = 0;
        
        
        for (Account acc : accounts) {
            
            if (acc instanceof CheckingAccount) {
                
                hasChecking = hasChecking + 1;
                
                
            } else {
                
                hasSaving = hasSaving + 1;
                
            } 
        }
        
        if (accountType.equals("checking") && hasChecking == 0) {
            
            accounts.add(account);
            return true;
            
        } else if (accountType.equals("saving") && hasSaving == 0) {
        
            accounts.add(account);
            return true;
       }

        return false;
        
    }
    public void updateAddress (String address) {
        
        
        this.address = address;
        
        
    }
    public void updateFName(String newFirstName) {
        
        this.fname = newFirstName;
        
    }
    public void updateLName(String newLastName) {
        
        this.lname = newLastName;
        
    }
    
    
    public String getCustomerName () {
        
        return fname + " " + lname;
    }
    public String getCustomerAddress () {
        
        return address;
    }
    public int getNumOfAccounts() {
        
        return accounts.size();
        
    }
    public Account getCustomerAccount(String type) {
        
  
        for (Account acc : accounts) {
            
            if (acc.getAccountType().equals(type)) {
                
                return acc;
            } 
        }
            
       return null;
    }
    public ArrayList<Account> getCustomerAccounts() {
        return accounts;
    }

    
    public void displayCustomerInfo() {
        
        
        System.out.println("*******************************************");
        System.out.println("Full Name: " + getCustomerName());
        System.out.println("Customer Address : " + getCustomerAddress());
        
     
        if (accounts.isEmpty() == false) {
            
            
         for (Account acc : accounts) {
             
             System.out.println("*******************************************");
             acc.displayAccountInfo();
             acc.displayAccountTransactions();
             
         }
            
            
        } else {
            
             System.out.println("No Accounts");
            
        }      
    }
    

    
  
}
