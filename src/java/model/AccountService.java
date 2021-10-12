/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Connor
 */
public class AccountService {
    
    public User login(User user){        
        return (user.getUsername().equals("abe") && user.getPassword().equals("password")) ? (new User("abe", null)): 
               ((user.getUsername().equals("barb") && user.getPassword().equals("password")) ? (new User("barb", null)) : null); 
    }
    
}
