package dcll.kelt.state;

/**
 * Created by kelto on 14/03/15.
 */
public class StrikeState extends BowlingState {

    private static StrikeState state = null;

    public static StrikeState state()
    {
        if(state == null)
            state = new StrikeState();
        return state;
    }

    @Override
    public void init(BowlingContext context) {

    }

    @Override
    public void lancer(BowlingContext context) {
        if(context.getLancer() < 1)
        {
            context.setState(StrikeState.state());
        }
        else
        {
            context.addScore(context.getScoreFrame()*2);
            context.setState(InitState.state());
        }
    }

    @Override
    public void strike(BowlingContext context) throws Exception {
        if(context.getNbFrame() == 10)
        {
            context.addScore(10*2);
            context.setState(LastStrikeState.state());
        }
        else if(context.getNbFrame() < 10)
        {
            context.setState(StrikeState.state());
        }
        else
        {
            throw new Exception("Trop de lancer ont été fait.");
        }

    }

    @Override
    public void spare(BowlingContext context) {

    }

}
