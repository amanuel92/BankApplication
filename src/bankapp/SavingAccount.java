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
public class SavingAccount extends Account {
    
    
    
    SavingAccount (Customer owner, double openingDeposit, long accountNumber) {
        
        super(owner, openingDeposit, "saving", accountNumber);   
        
        
    }

 
    
}
