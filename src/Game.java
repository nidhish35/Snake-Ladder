import java.util.List;
import java.util.Random;

public class Game {
    private List<Player> players;
    private Board board;
    private int currentPlayerIndex = 0;
    private Random dice = new Random();

    public Game(List<Player> players) {
        this.players = players;
        this.board = new Board();
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public int rollDice() {
        return dice.nextInt(6) + 1;
    }

    public String playTurn() {
        Player player = getCurrentPlayer();
        int roll = rollDice();
        int newPos = player.getPosition() + roll;

        if (newPos > board.getSize()) {
            newPos = player.getPosition(); // can't move
        }

        StringBuilder result = new StringBuilder();
        result.append(player.getName()).append(" rolled ").append(roll);

        if (board.isSnake(newPos)) {
            int oldPos = newPos;
            newPos = board.getNextPosition(newPos);
            result.append(" and hit a SNAKE! Moved from ").append(oldPos).append(" to ").append(newPos);
        } else if (board.isLadder(newPos)) {
            int oldPos = newPos;
            newPos = board.getNextPosition(newPos);
            result.append(" and climbed a LADDER! Moved from ").append(oldPos).append(" to ").append(newPos);
        } else {
            result.append(" and moved to ").append(newPos);
        }

        player.setPosition(newPos);

        if (newPos == board.getSize()) {
            result.append(". ").append(player.getName()).append(" wins!");
        } else {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }

        return result.toString();
    }


    public boolean isGameOver() {
        return players.stream().anyMatch(p -> p.getPosition() == board.getSize());
    }
}
