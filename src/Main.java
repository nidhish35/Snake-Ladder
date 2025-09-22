import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Player> players = new ArrayList<>();

        System.out.println("Enter number of players:");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Enter name for Player " + (i + 1) + ":");
            String name = scanner.nextLine();
            players.add(new Player(name));
        }

        Game game = new Game(players);

        while (!game.isGameOver()) {
            Player current = game.getCurrentPlayer();
            System.out.println(current.getName() + "'s turn. Press Enter to roll dice...");
            scanner.nextLine();
            System.out.println(game.playTurn());
        }
        scanner.close();
        System.out.println("Game Over!");
    }
}
