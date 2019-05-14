/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame;

/**
 *
 * @author ggear
 */
import java.util.ArrayList;

/**
 * This class acts a general class for every contestant type
 */
public class Contestant {
   
    public int health = 0;
    public String name = "";
    public String deadName = "";
    
    /**
     * This constructor does nothing
     */
    public Contestant() 
    {
          
    }
    
    /**
     * This method gets the health of a given contestant
     * @return integer value of contestant health
     */
    public int getHealth() {
        return this.health; 
    }
    
    /**
     * This method returns a boolean for whether the contestant is alive
     * @return boolean 
     */
    public boolean IsAlive() {
        if (this.health > 0) {
            return true;
        }
        else {
            return false;         
        }
    }
    
    /**
     * This method returns the attack value of each contestant
     * Since the method is in the parent class, returns a value of 0
     * @return integer value of 0 
     */
    public int getAttack()
    {
        return 0;
    }
    
    /**
     * This method returns a string describing the contestant's health
     * @return String
     */
    public String toString()
    {
        if (this.IsAlive())
        {
            return this.name + "(" + this.getHealth() +")";
        }
        else
        {
            return this.deadName;
        }
    }
    
    /**
     * This method returns the attack type of each contestant 
     * Since this method is in the parent class, it returns a default "smashing"
     * @return String
     */
    public String attackType() {
           return "smashing";
       }
    
    /**
     * This method takes damage from whichever contestant attacks the given contestant
     * @param contestant attacking the current contestant
     */
    public void takeDamage(Contestant contestant)
     {
         if (this.IsAlive())
         {
         this.health -= contestant.getAttack();
         }
         
         if (contestant.health == 0 && contestant.attackType() == "fire") {
             
         }
        
      }
    
    /**
     * This method is meant to be overriden. If the method is not overriden
     * an error message will be returned.
     * @param contestants list
     */
    public void attack(ArrayList<Contestant> contestants)
    {
        System.out.println("if this comes up there is an error in the attack method of a subclass");
    }

}