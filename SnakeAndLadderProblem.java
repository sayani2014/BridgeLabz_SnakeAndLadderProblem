/* Play the game with 2 Player. In this case if a Player gets a Ladder then plays again.
 * Finally report which Player won the game
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
        int Person1 = 0;
        int Person2 = 0;
        int countPerson1 = 0;
        int countPerson2 = 0;
        while (initial_position <= final_position) {
            System.out.println("Person1 has rolled the die.");
            Person1 = gamePlay(initial_position,final_position);
            countPerson1++;
            System.out.println("Current position of the player1 in the game is: " +Person1);
            System.out.println();
            System.out.println("Person2 has rolled the die.");
            Person2 = gamePlay(initial_position,final_position);
            countPerson2++;
            System.out.println("Current position of the player2 in the game is: " +Person2);
            System.out.println();
            if (Person1 >= final_position) {
                System.out.println("Person1 has completed the game.");
                System.out.println("Person1 rolls the dice " +countPerson1+ " times to win the game.");
                break;
            }
            else if (Person2 >= final_position) {
                System.out.println("Person2 has completed the game.");
                System.out.println("Person2 rolls the dice " +countPerson2+ " times to win the game.");
                break;
            }
        }
    }
    private static int gamePlay(int initial_position, int final_position) {
        int roll_die = (int)((Math.floor(Math.random() * 10)) % 6) + 1;
        int check_option = (int)((Math.floor(Math.random() * 10)) % 3);
        switch (check_option) {
            case noPlay:
                //initial_position = 0;
                System.out.println("Its a NO PLAY! Player stays in the same position!");
                break;
            case ladder:
                initial_position += roll_die;
                if (initial_position <= final_position) {
                    System.out.println("Its a LADDER! Player moves ahead by " + roll_die + " positions.");
                    gamePlay(initial_position,final_position);
                }
                else if (initial_position > final_position){
                    initial_position -= roll_die;
                    System.out.println("Its a LADDER! But the player cannot move ahead by " + roll_die + " positions since it exceeds the final position.");
                }
                break;
            case snake:
                initial_position -= roll_die;
                System.out.println("Its a SNAKE! Player moves behind by " +roll_die+ " positions.");
                break;
        }
        if(initial_position < 0)
            initial_position = 0;
        //System.out.println("Current position of the player in the game is: " +initial_position);
        //System.out.println();
        return initial_position;
    }
}



