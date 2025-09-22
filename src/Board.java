import java.util.HashMap;
import java.util.Map;

public class Board {
    private final int size = 100;
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;

    public Board() {
        snakes = new HashMap<>();
        ladders = new HashMap<>();
        // Example snakes
        snakes.put(99, 21);
        snakes.put(56, 12);
        snakes.put(48, 26);
        // Example ladders
        ladders.put(5, 25);
        ladders.put(20, 50);
        ladders.put(70, 90);
    }

    public boolean isSnake(int pos) {
        return snakes.containsKey(pos);
    }

    public boolean isLadder(int pos) {
        return ladders.containsKey(pos);
    }

    public int getNextPosition(int pos) {
        if (snakes.containsKey(pos)) return snakes.get(pos);
        if (ladders.containsKey(pos)) return ladders.get(pos);
        return pos;
    }

    public int getSize() {
        return size;
    }
}
