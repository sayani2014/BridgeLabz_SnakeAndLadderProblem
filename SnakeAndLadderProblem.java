public class SnakeAndLadderProblem {
    public static final int noPlay = 0;
    public static final int ladder = 1;
    public static final int snake = 2;

    public static void main(String[] args) {
        int initial_position = 0;
        int roll_die = (int)((Math.floor(Math.random() * 10)) % 6) + 1;
        int check_option = (int)((Math.floor(Math.random() * 10)) % 3);
        switch (check_option) {
            case noPlay:
                initial_position = 0;
                System.out.println("Its a NO PLAY! Player stays in the same position!");
                break;
            case ladder:
                initial_position += roll_die;
                System.out.println("Its a LADDER! Player moves ahead by " +roll_die+ " positions.");
                break;
            case snake:
                initial_position -= roll_die;
                System.out.println("Its a SNAKE! Player moves behind by " +roll_die+ " positions.");
                break;
            default:
                System.out.println("Error! Please check!");
                break;
        }
        if(initial_position < 0)
            initial_position = 0;
        System.out.println("Current position of the player in the game is: " +initial_position);
    }
}
