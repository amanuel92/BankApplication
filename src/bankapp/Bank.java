/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp;
import java.io.*;
import java.util.*;




public class Bank {
    
    
    double bankAsset;
    
    private static final ArrayList<Account> ACCOUNTS = new ArrayList<>();
    private static final ArrayList<Customer> CUSTOMERS = new ArrayList<>();
    private static final ArrayList<Transaction> TRANSACTIONS = new ArrayList<>();
    
    
 
    //adds new customer , assigns saving and checking accounts
    public static void addNewCustomer(String fname, String lname, String address) 
    {
        //create new customer
        Customer newCustomer = new Customer(fname, lname, address);
        
        
        //create a saving and checking account for customer
        long newCheckingAccountNum = getNewAccountNumber();
        long newSavingAccountNum = newCheckingAccountNum +1;
                
        Account newCheckingAcc = new CheckingAccount(newCustomer, 0.00, newCheckingAccountNum);
        Account newSavingAcc = new SavingAccount(newCustomer, 0.00, newSavingAccountNum);       
              
        
        
        //tries to add accounts to list of account for customer if customer doesnt already have one
        boolean isCheckingAdded = newCustomer.addAccount(newCheckingAcc);
        boolean isSavingAdded = newCustomer.addAccount(newSavingAcc);        
  
        
        
        
        //if account for customer was added succesfully , adds it to bank account list
        if (isCheckingAdded == true) {
            
             ACCOUNTS.add(newCheckingAcc);
             
             
            
        } else {
            
            System.out.println("customer has a checking account already!");
        }
        
        if (isSavingAdded == true) {
            
             ACCOUNTS.add(newSavingAcc);
            
        } else {
            
            System.out.println("customer has a saving account already!");
            
        }
       
        CUSTOMERS.add(newCustomer); 
        
    }
    public static void addNewAccount (Customer exsistingCustomer, Account newAccount) 
  {
        
        //tries to add accounts to list of account for customer if customer doesnt already have account type
        boolean isAccountAdded = exsistingCustomer.addAccount(newAccount);
              
  
        //if account for customer was added succesfully , adds it to bank account list
        if (isAccountAdded == true) {
            
             ACCOUNTS.add(newAccount);
            
        } else {
            
            System.out.println("customer has this type of account already!");
        }
        
    }
    private static long getNewAccountNumber(){
        
        if(ACCOUNTS.isEmpty() == true) {
            
            return 1000;
            
            
        } else {
           
            long lastAccountNum = ACCOUNTS.get(ACCOUNTS.size()-1).getAccountNumber();
            return lastAccountNum + 1;
            
        }
    
    }
    
   
    //METHODS FOR CARRYING OUT TRANSACTIONS ON ACCOUNTS // the methods add transaction to transaction list
    public static void Deposit(Account account, double balance) {
        
        Transaction depositTransaction = account.Deposit(balance);
        
        if (depositTransaction != null) {
            
            
        depositTransaction.displayTransaction();
        TRANSACTIONS.add(depositTransaction);
        
        } else {
            
            
            System.out.println("transaction is null");
            
        }
        
        
        
    }
    public static void Withdraw(Account account, double balance) {
        
        Transaction withdrawTransaction = account.Withdraw(balance);
        
        if (withdrawTransaction != null) {
            
            TRANSACTIONS.add(withdrawTransaction);
            
        } else {
            
            //wrong balance, or insufficient funds
            
        }
        
        
    }
    public static void Transfer(double amount, Account fromAccount, Account toAccount) {

            if (amount > 0) {
                
                Transaction withdrawTransaction = fromAccount.Withdraw(amount);
                Transaction depositTransaction = toAccount.Deposit(amount);
                
                TRANSACTIONS.add(withdrawTransaction);
                TRANSACTIONS.add(depositTransaction);
                
               
                
            } else {
            
                
                System.out.println("Insufficient fund!");

            }   
            
    }
    
 
   public static void showCustomers() {
       
       for (Customer customer: CUSTOMERS) {
       
           customer.displayCustomerInfo();
           
       }
       
   }  
   public static void showAccounts() {
       
       for (Account account : ACCOUNTS) {
       
           account.displayAccountInfo();
           
           
       }
       
   }  
   public static void showTransactions() {
       
       for (Transaction transaction : TRANSACTIONS) {
           
           transaction.displayTransaction();
           
       }
       
   }
   
   
   public static Customer findCustomerByName (String name) {
       
       
       for (Customer customer : CUSTOMERS) {
           
          
           
           if (customer.getCustomerName().equals(name) == true) {
               
               
               return customer;
               
           }      
        }
       
       System.out.println("Customer " + name + "can't be found!");
       return null;
       
   } 
   public static Account findAccountByNumber (long accountNum) {
       
        for (Account account : ACCOUNTS) {
           
          
           
           if (account.getAccountNumber() == accountNum) {
               
               System.out.println("Account found!");
               return account;
               
           }      
        }
       
       System.out.println("Account # " + accountNum + " is invalid!");
       return null;
       
       
       
   }
   
            
}
