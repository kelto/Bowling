package dcll.kelt.state;

/**
 * Created by kelto on 14/03/15.
 */
public abstract class BowlingState {

    public void init(BowlingContext context) throws Exception {
        throw new Exception("Can't go to Init State");
    }

    public void lancer(BowlingContext context) throws Exception {
        throw new Exception("Can't go to Launch State");
    }

    public void strike(BowlingContext context) throws Exception
    {
        throw new Exception("Can't go to Strike State");
    }

    public void spare(BowlingContext context) throws Exception
    {
        throw new Exception("Can't go to Spare State");
    }

}
