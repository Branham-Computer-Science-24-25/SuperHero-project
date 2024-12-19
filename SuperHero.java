import java.util.Random;

/**
 * Superhero class compares the strength of two superheroes
 */
public class SuperHero {
    private String name;
    private int max_power;
    private int min_power;

    /**
     *
     * @param hero_name name of superhero
     * @param max max power
     * @param min min power
     */
    public SuperHero(String hero_name, int max, int min) {
        name = hero_name;
        max_power = max;
        min_power = min;
         }
         /**
          * gets name
          * @return the name
          */
    public String getName() {
        return name; }

    /**
     * gets max power
     * @return the max power
     */
    public int getMaxPower() {
        return max_power;
    }

    /**
     * gets min power
     * @return min power
     */
    public int getMinPower() {
        return min_power;
    }

    /**
     * generates a random strength value between the superhero's max and min
     * @return the generated strength value
     */
    public int strength() {
        Random random = new Random();
        int strength = random.nextInt((max_power - min_power) + 1) + min_power;
        return strength;
    }

    /**
     * simulates a fight between user's hero and the chosen opponent
     * @param opponent the opponent hero in the battle
     * @return the name of the superhero who wins the round, or if it's a tie
     */
    public String fight(SuperHero opponent) {
        int my_strength = strength();
        int op_strength = opponent.strength();

        String my_name = name;
        String op_name = name;

        if (my_strength > op_strength) {
            System.out.println(my_name + " wins this round!");
            return my_name;
        } else if (op_strength > my_strength) {
            System.out.println(op_name + " wins this round!");
            return op_name;
        } else {
            System.out.println("It's a ties this round!");
            return "tie";
        }
    }
}
