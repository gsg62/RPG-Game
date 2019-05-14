package rpggame;
/**
 *
 * @author ggear
 */

import java.util.ArrayList;
import java.util.Random;

/**
 * This class creates Berserker contestants and extends the
 * Contestant class
 */
public class Berserker extends Contestant{
    
    Random rand = new Random();
    
    /**
     * This constructor runs every time a berserker character is created
     * It assigns a health value of 35 to each berserker
     * It assigns the name "a raging berserker" to each berserker
     * It assigns a dead name "a slain berserker" to each berserker
     */
    public Berserker(){
        
        super.health = 35;
        super.name = "A Raging Berserker";
        super.deadName = "A slain Berserker";
     
    }
    
    /**
     * This method assigns the attack type "smashing" to each berserker
     * @override attackType() method in Contestant class
     * @return String "smashing"
     */
    public String attackType() {
        return "smashing";
    }
    
    /**
     * This method returns the attack value of 20 for each berserker
     * @override getAttack() method in Contestant class
     * @return integer value of 20
     */
    public int getAttack()
    {
        //contestant.takeDamage();
        return 20;
    }
    
    /**
     * This method chooses which contestant the berserker is going to attack
     * @param contestants list 
     * @return Contestant berserker is going to attack
     */
    public Contestant getAttackContestant(ArrayList<Contestant> contestants)
    {
        int randInt  = rand.nextInt(contestants.size()); // used to pull a random contestant from the contestant list
        while(!contestants.get(randInt).IsAlive()) {
            randInt  = rand.nextInt(contestants.size());
        }  
        
        return contestants.get(randInt);
    }
    
    /**
     * This method determines how much damage the berserker takes from each Contestant
     * @override takeDamage() method from Contestant class
     * @param contestant that attacks them
     */
    public void takeDamage(Contestant contestant)
    {
        if (this.IsAlive())
        {    
            int health = this.health;
            int attack = contestant.getAttack();
        
            if (contestant.attackType() == "fire")
            {
                this.health -= (1/2) * attack;
                attack = attack/2;
            }
            else if (contestant.attackType() == "slashing") 
            {
                this.health -= 2 * attack;
                attack = attack * 2;
            }
            else 
            {
                this.health -= attack;
            }
            System.out.println(this.name +  "(" + health + ") takes " + attack + " " + contestant.attackType() + " damage from a " + contestant.name + "(" + contestant.health + ")");
        }
         
     }
    
     /**
      * This method acts as the actual attack the berserker does on the chosen Contestant
      * @ovverride attack() method from Contestant class
      * @param contestants 
      */
     public void attack(ArrayList<Contestant> contestants)
     {
        this.getAttackContestant(contestants).takeDamage(this);
     }
}