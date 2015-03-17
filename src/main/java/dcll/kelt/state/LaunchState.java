package dcll.kelt.state;

/**
 * Created by kelto on 14/03/15.
 */
public class LaunchState extends BowlingState {

    private static LaunchState state = null;

    public static LaunchState state()
    {
        if(state == null)
            state = new LaunchState();
        return state;
    }

    @Override
    public void init(BowlingContext context) {

    }

    @Override
    public void lancer(BowlingContext context) {

    }

    @Override
    public void strike(BowlingContext context) {

    }

    @Override
    public void spare(BowlingContext context) {

    }
}
