/* Repeat till the Player reaches the winning position 100. 
 * Note: In case the player position moves below 0, then the player restarts from 0
 *
 * @author: SAYANI KOLEY
 * DATE: 10/06/2021
 */


public class SnakeAndLadderProblem {
    public static final int noPlay = 0;
    public static final int ladder = 1;
    public static final int snake = 2;

    public static void main(String[] args) {
        int initial_position = 0;
        int final_position = 100;
        while (initial_position <= final_position) {
            int roll_die = (int) ((Math.floor(Math.random() * 10)) % 6) + 1;
            int check_option = (int) ((Math.floor(Math.random() * 10)) % 3);
            switch (check_option) {
                case noPlay:
                    //initial_position = 0;
                    System.out.println("Its a NO PLAY! Player stays in the same position!");
                    break;
                case ladder:
                    initial_position += roll_die;
                    System.out.println("Its a LADDER! Player moves ahead by " + roll_die + " positions.");
                    break;
                case snake:
                    initial_position -= roll_die;
                    System.out.println("Its a SNAKE! Player moves behind by " + roll_die + " positions.");
                    break;
            }
            System.out.println("Position reached by the player: " +initial_position);
            if (initial_position < 0)
                initial_position = 0;
        }
        System.out.println();
        System.out.println("Player completes the game!");
    }
}