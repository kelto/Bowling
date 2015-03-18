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

    public void initFrames(Queue<Character> stack) throws Exception {

        Frame uneFrame = new Frame(stack.poll(), null, null);

        if (uneFrame.getFirstLaunch() != 'X')
            uneFrame.setSecond(stack.poll());

        if (!uneFrame.isValid())
            throw new Exception("Unvalid frame");

        if (!listFrame.isEmpty())
            uneFrame.setBefore(listFrame.get(listFrame.size() - 1));
        else
            uneFrame.setBefore(uneFrame);

        listFrame.add(uneFrame);
    }

    public void doAllFrames(Queue<Character> stack) throws Exception {

        if (stack.size() > 21)
            throw new Exception("Trop de lancers");

        while (!stack.isEmpty()) {
            initFrames(stack);
        }
    }
}

