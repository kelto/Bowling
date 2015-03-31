package dcll.kelt.model.Frame;

/**
 * Created by kelto on 31/03/15.
 */
public class NormalFrame extends Frame {

    /**
     * @param firstLaunch  score of the first launch.
     * @param secondLaunch score of the second launch
     */
    public NormalFrame(Character firstLaunch, Character secondLaunch) {
        super(firstLaunch, secondLaunch);
    }

    @Override
    public int getScore(Frame frame) {

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
        int firstValue = getValue(first);
        int secondValue = getValue(second);

        return firstValue + secondValue;
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
        return (Character.isDigit(first) || first == ZERO) &&
                (Character.isDigit(second) || second == ZERO);
    }
}
