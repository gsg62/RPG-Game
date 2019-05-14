package rpggame;
/**
 *
 * @author ggear
 */

/**
 * This class is meant to run the RPG
 */
public class RPG {

    /**
     * This main method runs the RPG
     * @param args 
     */
    public static void main(String[] args) {
        Arena arena = new Arena();

        arena.add(new Berserker());
        arena.add(new Berserker());
        arena.add(new Warrior());
        arena.add(new Warrior());
        arena.add(new WildMage());
        arena.add(new WildMage());

        while (arena.getWinner() == null) {
            System.out.println(arena.getDescription());
            arena.playRound();
        }

        System.out.println();
        System.out.println(arena.getDescription());
        System.out.println("Winner: " + arena.getWinner().toString());

    }

}
