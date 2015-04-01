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

        try {
            return getBasicValue();
        } catch (Exception e) {
            return 0;
        }


    }

    @Override
    protected int getBasicValue() throws Exception {
        if (!isValid()) {
            throw new Exception("Invalid normal Frame");
        }

        return getFirst().getValue() + getSecond().getValue();
    }

    private int getValue(char launch) {
        // We expect the isValid() method to be called at this point, so only digit or ZERO for the char
        if (Character.isDigit(launch)) {
            return Integer.parseInt("" + launch);
        } else {
            return 0;
        }


    }

    @Override
    public boolean isValid() {
        return (getFirst().isDigit() || getFirst().isZero()) &&
                (getSecond().isDigit() || getSecond().isZero());
    }
}
