/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp;

/**
 *
 * @author amanuelgetahun
 */
public class BankApp {
    
      public static void main(String[] args) {
        
        
        //adds new customers to bank (these customers are added to the ArrayList<Customer> of the bank class)
        //there is saving and checking account automatically created for every new customer (these accounts are added to the ArrayList<Account> of the bank class)
        Bank.addNewCustomer("Thomas", "Jefferson", "301 first st. alexandria, va 98223");
        Bank.addNewCustomer("David", "Matthew", "901 J st. baltimore,md 98229");
       
        
        //show the bank customers(shows customers in Bank.Customers)
        Bank.showCustomers();
        
       
        //shows the bank accounts (shows accounts in Bank.Accounts)
        Bank.showAccounts();
        
        //shows the bank transactions (shows transactions in Bank.Transactions)
        Bank.showTransactions();
        
        
        //find customer by name (return type is Customer)
        Bank.findCustomerByName("David Matthew").displayCustomerInfo();
        
        
        //find account by number
        Bank.findAccountByNumber(1002).displayAccountInfo();
        
        
        //depositing $50 to david saving account
        Bank.Deposit(Bank.findCustomerByName("David Matthew").getCustomerAccount("saving"), 50);
        
        //withdrawing $25 from david saving account
        Bank.Withdraw(Bank.findCustomerByName("David Matthew").getCustomerAccount("saving"), 25);
        
        
        //transfer $10 from David saving account to Thomas checking account
        Bank.Transfer(10, Bank.findCustomerByName("David Matthew").getCustomerAccount("saving"), Bank.findCustomerByName("Thomas Jefferson").getCustomerAccount("checking"));
        
        //look at bank transactions 
        Bank.showTransactions();
     
    }
    
    
    
}
