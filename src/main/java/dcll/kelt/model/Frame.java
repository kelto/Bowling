package dcll.kelt.model;

/**
 * Created by kelto on 15/03/15.
 */

public class Frame {
    private final static Character ZERO = '_',
            STRIKE = 'X',
            SPARE = '/';

    private int before;
    private Character first;
    private Character second;

    public Frame(char first, Character second, Character before)
    {
        this.first = first;
        this.second = second;
        this.before = before;
    }

    public int getScore() throws Exception
    {
        int val1, val2;
        try {
            val1 = getValue(first);
            val2 = getValue(second);
        } catch (Exception e) {
            // Should not be thrown if isValid() is asked.
            throw new Exception("Unvalid frame.");
        }

        if(before == 0)
            return val1 + val2;
        else if(before == 1)
            return val1*2 + val2;
        else
            return (val1+val2)*2;
    }

    public boolean isValid()
    {
        boolean valid = true;
        if(!exist(first) || !exist(second))
            valid = false;
        if(first == STRIKE && second != null)
            valid = false;

        return valid;
    }

    private boolean exist(char c)
    {
        return Character.isDigit(c) || c == ZERO || c == STRIKE || c == SPARE;
    }

    private int getValue(char c) throws Exception
    {
        if(Character.isDigit(c))
        {
            return Integer.parseInt(""+c);
        }
        else if(c == STRIKE )
            return 10;
        else if( c == SPARE)
            return 10 - getValue(first);
        else if(c == ZERO)
            return 0;
        else
            throw new Exception("can't recognize token.");
    }


}
