package rpggame;
/**
 *
 * @author ggear
 */
import java.util.Random;
import java.util.ArrayList;

/**
 * This class creates Warrior contestants and extends the parent class "Contestant"
 * @author erikpreuss
 */
public class Warrior extends Contestant {
    
    Random rand = new Random();
    
    /**
     * This constructor runs every time a Warrior contestant is created
     * It assigns a random health value from 20-40
     * It assigns a name of "a disciplined warrior" to each warrior
     * It assigns a dead name of "a slain warrior" to each warrior
     */
    public Warrior() {
        
        super.health = rand.nextInt(21)+ 20; 
        super.name = "A Disiciplined Warrior";
        super.deadName = "A slain Warrior";   
    }
    
    /**
     * This method returns the attack value of the warrior
     * @override getAttack() method in Contestant class
     * @return integer value from 10-16
     */
    public int getAttack()
    {
        //contestant.takeDamage();
        return rand.nextInt(7) + 10;
    }
    
    /**
     * This method determines who the Warrior is going to attack
     * It chooses the Contestant in the arena with the most health
     * @param contestants list
     * @return Contestant with the most health
     */
    public Contestant getAttackContestant(ArrayList<Contestant> contestants)
    {
        Contestant attackContestant = new Contestant();
        int attackContestantIndex = 0;
        // loops through all the contestants health and returns the one that is the biggest threat
        for (Contestant c : contestants)
        {
            if (!(c instanceof Warrior)) // checks to not return another warrior
            {
                if (c.IsAlive()) // checks if alive
                {
                    if (c.getHealth() >= attackContestant.getHealth()) 
                    {
                        attackContestantIndex = contestants.indexOf(c);
                    
                    }
                }
            }
        }
        
        return contestants.get(attackContestantIndex);
    }
    
    /**
     * This method assigns the attack type of "slashing" to the warrior
     * @override attackType() method in Contestant class
     * @return String "slashing"
     */
    public String attackType() {
        return "slashing";
    }

    /**
     * This method determines how much damage the warrior takes
     * @param contestant attacking the warrior
     */
    public void takeDamage(Contestant contestant)
     {
         if (this.IsAlive())
         {
         int health = this.health;
         int attack = contestant.getAttack();
         int rand_int = 1; 
         int attack_int = rand.nextInt(4);
         if (rand_int != attack_int) {
             this.health -= attack;
        }
         
        System.out.println(this.name +  "(" + health + ") takes " + attack + " " + contestant.attackType() + " damage from a " + contestant.name + "(" + contestant.health + ")");
        
        }
     }
    
    /**
     * This method acts as the actual attack the warrior does on the chosen Contestant
     * @param contestants list
     */
    public void attack(ArrayList<Contestant> contestants)
    {
        this.getAttackContestant(contestants).takeDamage(this);

    }
}
