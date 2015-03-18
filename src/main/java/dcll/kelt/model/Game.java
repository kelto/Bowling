package dcll.kelt.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by kelto on 18/03/15.
 */
public class Game {
    private List<Frame> listFrame;
    private int score;
    private boolean valid;
    private String error;

    public Game() {
        this.listFrame = new ArrayList<Frame>();
    }

    public boolean initFrames(Queue<Character> stack) {

        return true;
    }
}
