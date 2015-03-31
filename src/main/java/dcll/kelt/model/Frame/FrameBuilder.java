package dcll.kelt.model.Frame;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * Created by kelto on 31/03/15.
 */
public class FrameBuilder {

    /**
     * Class variable SEPARATOR which separates the frame.
     */
    private static final char SEPARATOR = '-';

    /**
     * A queue of characters representing the whole game.
     */
    private final Queue<Character> queue;

    /**
     * Constructor of FrameBuilder.
     * @param uneQueue
     */
    public FrameBuilder(final Queue<Character> uneQueue) {
        this.queue = uneQueue;
    }

    /**
     * Method to get a frame of the game.
     * @return deque
     * @throws Exception
     */
    public final Deque<Frame> getFrames() throws Exception {
        Deque<Frame> deque = new ArrayDeque<Frame>();
        while (!queue.isEmpty()) {
            deque.push(createFrame());
        }
        return deque;
    }

    /**
     * Method to create a frame with the queue of characters.
     *
     * @return frame
     * @throws Exception
     */
    private Frame createFrame() throws Exception {

        final int topFrame = 3;
        if (queue.size() < topFrame) {
            throw new Exception("Not enough char to create a Frame.");
        }
        char first, second, separator;
        Frame frame;
        first = queue.poll();
        second = queue.poll();
        separator = queue.poll();
        if (separator != SEPARATOR) {
            throw new
                    Exception("Invalid Syntax: "
                    + "Separator for frame should be '-'.");
        }
        if (first == Frame.STRIKE) {
            frame = new StrikeFrame(first, second);
        } else if (second == Frame.SPARE) {
            frame = new SpareFrame(first, second);
        } else {
            frame = new NormalFrame(first, second);
        }
        return frame;
    }
}
