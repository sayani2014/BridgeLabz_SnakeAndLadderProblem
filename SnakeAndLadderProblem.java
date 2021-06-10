/* Roll the dice using Random()
 *
 * @author: SAYANI KOLEY
 * DATE: 10/06/2021
 */

public class SnakeAndLadderProblem {
    public static void main(String[] args) {
        int roll_die = (int)((Math.floor(Math.random() * 10)) % 6) + 1;
        System.out.println("Output of rolling the die is: " +roll_die);
    }
}