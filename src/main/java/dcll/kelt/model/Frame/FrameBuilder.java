package dcll.kelt.model.Frame;



import java.util.*;

/**
 * Created by kelto on 31/03/15.
 */
public class FrameBuilder {
    private static final char SEPARATOR = '-';
    private Queue<Character> queue;
    private char first, second;
    private Launch last;
    private ArrayList<Frame> list;

    public FrameBuilder(Queue<Character> queue) {
        this.queue = queue;
        this.list = new ArrayList<Frame>();
        last = null;
    }


    public ArrayList<Frame> getFrames() throws Exception {

        while (!queue.isEmpty()) {
            list.add(createFrame());
            //createFrame();
            setLast();
        }
        return list;
    }

    private void setLast() {
        //The second launch for a strike means nothing, just a syntax
        // so we unset it, and take the last launch of the Frame to be
        // the first one.
        if (list.get(list.size()-1).getFirst().isStrike()) {
            this.last = list.get(list.size() - 1).getFirst();
        } else {
            // we set the last launch as the secondLaunch
            // to link it to the next frame.
            this.last = list.get(list.size()-1).getSecond();
        }
    }

    private Frame createFrame() throws Exception {
        getChars();
        Frame frame;

        Launch firstLaunch, secondLaunch;

        firstLaunch = new Launch(first);
        secondLaunch = new Launch(second);

        if(! firstLaunch.isValid() || ! secondLaunch.isValid()) {
            throw new Exception("Invalid Syntax: wrong char to describe a launch.");
        }

        if (first == Launch.STRIKE) {

            frame = new StrikeFrame(firstLaunch, secondLaunch);

        } else if (second == Launch.SPARE) {

            firstLaunch.setNext(secondLaunch);
            frame = new SpareFrame(firstLaunch, secondLaunch);

        } else {

            firstLaunch.setNext(secondLaunch);
            frame = new NormalFrame(firstLaunch, secondLaunch);

        }
        // if it's the first iteration, last is null.
        if(last != null) {
            last.setNext(firstLaunch);
        }

        return frame;
    }

    private void getChars() throws Exception {
        if (queue.size() < 3) {
            throw new Exception("Not enough char to create a Frame.");
        }

        first = queue.poll();
        second= queue.poll();
        char separator = queue.poll();
        if (separator != SEPARATOR) {
            throw new Exception("Invalid Syntax: Separator for frame should be '-'.");
        }
    }

    public static Character[] toObject(String s) {
        if( s== null) {
            return null;
        }
        int length = s.length();
        Character[] ret = new Character[length];

        for(int i= 0; i < length; i++){
            ret[i] = new Character(s.charAt(i));
        }
        return ret;
    }
}
