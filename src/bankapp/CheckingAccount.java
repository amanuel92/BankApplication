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
public class CheckingAccount extends Account{
    

    CheckingAccount (Customer owner, double openingDeposit,long accountNumber) {
        
        super(owner, openingDeposit, "checking",accountNumber); 
  
    }

  
}
