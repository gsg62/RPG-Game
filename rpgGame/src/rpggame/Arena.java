package rpggame;
/**
 * 
 * @author ggear
 */
import java.util.ArrayList;
import java.util.Random;

/**
 * This class is meant to simulate an arena holding contestants
 * in an RPG game
 */
class Arena
{
 Random rand = new Random();
 ArrayList<Contestant> contestantList = new ArrayList<Contestant>(); 
    
    /**
     * Constructor for the arena class
     * Does nothing
     */
    public Arena() 
    {

    }

    /**
     * This method adds contestants into the arena
     * @param contestant
     * @return void
     */
    public void add(Contestant contestant) 
    {
        contestantList.add(contestant);
    }
    
    /**
     * This method runs through each contestant and allows each
     * contestant to attack once
     * @return void
     */
    public void playRound()
    {
        for (Contestant c : contestantList)
        {
            c.attack(contestantList);
        }
        
    }

    /**
     * This method gives a description of who is left alive in the arena
     * @return Strings of each character with their given health
     */
    public String getDescription()
    {
        System.out.println("In the Arena: ");
        for(Contestant c : contestantList)
        {
            System.out.println(c.toString());
        }
        return "";
    }

    /**
     * This method retrieves the winner of the RPG game
     * @return Last contestant alive
     */
    public Contestant getWinner() 
    {
        ArrayList<Contestant> aliveList = new ArrayList<Contestant>(); 
        Contestant winner = null;
    
        for(Contestant c : contestantList)
        {
            if (c.IsAlive()){aliveList.add(c);};
        }
       if (aliveList.size() == 1)
       {
           winner =  aliveList.get(0);
       }
       else if (aliveList.isEmpty())
       {
           int randInt  = rand.nextInt(contestantList.size());
           winner = contestantList.get(randInt);
       }
       return winner;
    }
    /**
     * Method to check victor
     */
    private void checkVictor() 
    {
        
    }
}