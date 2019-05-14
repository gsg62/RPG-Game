package rpggame;
/**
 *
 * @author ggear
 */

import java.util.ArrayList;
import java.util.Random;

/**
 * This class creates a wild mage contestant and extends the Contestant class
 */
public class WildMage extends Contestant{
    
    Random rand = new Random();
    
    /**
     * This constructor runs every time a wild mage is created 
     * It assigns a health value from 10-60
     * It assigns a name of "a wild mage" to each mage
     * It assigns a dead name of "a dead mage" to each mage
     */
    public WildMage() 
    {
        super.health = rand.nextInt(51)+10; 
        super.name = "A Wild Mage";
        super.deadName = "A dead Mage";
    }
    
    /**
     * This method assigns the attack type of "fire" for the mage
     * @override attackType() method in Contestant class
     * @return String "fire"
     */
    public String attackType() {
        return "fire";
    }
    
    /**
     * This method returns the attack value of the mage
     * @override getAttack() method in Contestant class
     * @return integer from 0-6
     */
    public int getAttack()
    {
        //contestant.takeDamage();
        return rand.nextInt(7);
    }
    
    /**
     * This method determines how much damage the mage is going to take
     * It also attacks the contestant that killed them with a value of 5
     * @param contestant attacking the mage
     */
    public void takeDamage(Contestant contestant)
    {     
        if (this.IsAlive())
        {
        int health = this.health;

        int attack = contestant.getAttack();

        if (this.IsAlive())
        {
            this.health -= attack;
            if (this.health <= 0) {
                contestant.health -= 5; 
            }
        }
        System.out.println(this.name +  "(" + health + ") takes " + attack +" " + contestant.attackType() + " damage from a " + contestant.name + "(" + contestant.health + ")");
        }
    }
     
     
    /**
     * This method acts as the actual attack the mage does. 
     * The mage attacks every contestant in the arena, including himself
     * @override attack() method in Contestant class
     * @param contestants list
     */ 
    public void attack(ArrayList<Contestant> contestants)
    {
        for (Contestant c : contestants)
        {
            if (c.IsAlive()){c.takeDamage(this);} // attacks only the alive Contestants
        }

    }
         
}
