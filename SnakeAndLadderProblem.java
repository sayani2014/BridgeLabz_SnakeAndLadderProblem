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
    public static final int final_position = 100;

    public static void main(String[] args) {

        int initial_position = 0;
        int initialPositionPerson1 = 0;
        int Person1 = 0;
        int countPerson1 = 0;
        int initialPositionPerson2 = 0;
        int Person2 = 0;
        int countPerson2 = 0;

        while (initial_position <= final_position) {
            System.out.println("Person1 has rolled the die.");
            ArrayList<Integer> initial1 = new ArrayList<>();
            Person1 = gamePlay(initial_position, final_position, initial1);
            initialPositionPerson1 += Person1;
            countPerson1++;
            System.out.println("Current position of the player1 in the game is: " + initialPositionPerson1);
            System.out.println();

            if (initialPositionPerson1 >= final_position) {
                if (initialPositionPerson1 > final_position)
                    initialPositionPerson1 -= Person1;

                else if (initialPositionPerson1 == final_position) {
                    System.out.println("Person1 has completed the game.");
                    System.out.println("Person1 rolls the dice " + countPerson1 + " times to win the game.");
                    break;
                }
            }
            System.out.println("Person2 has rolled the die.");
            ArrayList<Integer> initial2 = new ArrayList<>();
            Person2 = gamePlay(initial_position, final_position,initial2);
            initialPositionPerson2 += Person2;
            countPerson2++;
            System.out.println("Current position of the player2 in the game is: " + initialPositionPerson2);
            System.out.println();

            if (initialPositionPerson2 >= final_position) {
                if (initialPositionPerson2 > final_position)
                    initialPositionPerson2 -= Person2;
                else if (initialPositionPerson2 == final_position) {
                    System.out.println("Person2 has completed the game.");
                    System.out.println("Person2 rolls the dice " + countPerson2 + " times to win the game.");
                    break;
                }
            }
        }
    }

    private static int gamePlay(int initial_position, int final_position, ArrayList<Integer> initial) {
        int roll_die = (int) ((Math.floor(Math.random() * 10)) % 6) + 1;
        int check_option = (int) ((Math.floor(Math.random() * 10)) % 3);
        switch (check_option) {
            case noPlay:
                //initial_position = 0;
                //initial.add(initial_position);
                System.out.println("Its a NO PLAY! Player stays in the same position!");
                break;
            case ladder:
                initial_position += roll_die;
                initial.add(initial_position);
                System.out.println("Its a LADDER! Player moves ahead by " + roll_die + " positions.");
                if(initial_position < final_position)
                    gamePlay(initial_position, final_position, initial);
                break;
            case snake:
                initial_position = initial_position - roll_die;
                initial.add(initial_position);
                System.out.println("Its a SNAKE! Player moves behind by " + roll_die + " positions.");
                break;
        }
        if (initial_position < 0) {
            initial_position = 0;
            initial.add(initial_position);
        }

        int length = initial.size();
        if(length == 0)
            return initial_position;
        else {
            int i = length - 1;
            return initial.get(i);
        }
    }
}


