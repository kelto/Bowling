package dcll.kelt.model.Frame;

import java.util.ListIterator;

/**
 * Created by kelto on 31/03/15.
 */
public class NormalFrame extends Frame {

    /**
     * @param firstLaunch  score of the first launch.
     * @param secondLaunch score of the second launch
     */
    public NormalFrame(Launch firstLaunch, Launch secondLaunch) {
        super(firstLaunch, secondLaunch);
    }

    @Override
    public int getScore() {

        if (!isValid()) {
            // throw exception ?
            return 0;
        }

        return getFirst().getValue() + getSecond().getValue();

    }


    @Override
    public boolean isValid() {
        return (getFirst().isDigit() || getFirst().isZero()) &&
                (getSecond().isDigit() || getSecond().isZero());
    }
}
