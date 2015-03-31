package dcll.kelt.model.Frame;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * Created by kelto on 31/03/15.
 */
public class FrameBuilder {
    private static final char SEPARATOR = '-';
    private Queue<Character> queue;

    public FrameBuilder(Queue<Character> queue) {
        this.queue = queue;
    }

    public Deque<Frame> getFrames() throws Exception {
        Deque<Frame> deque = new ArrayDeque<Frame>();
        while(!queue.isEmpty()) {
            deque.push(createFrame());
        }
        return deque;
    }

    private Frame createFrame() throws Exception {
        if(queue.size()<3) {
            throw new Exception("Not enough char to create a Frame.");
        }
        char first,second,separator;
        Frame frame;
        first = queue.poll();
        second = queue.poll();
        separator = queue.poll();
        if(separator != SEPARATOR) {
            throw new Exception("Invalid Syntax: Separator for frame should be '-'.");
        }
        if(first == Frame.STRIKE) {
            frame = new StrikeFrame(first,second);
        } else if(second == Frame.SPARE) {
            frame = new SpareFrame(first,second);
        } else {
            frame = new NormalFrame(first,second);
        }
        return frame;
    }
}
