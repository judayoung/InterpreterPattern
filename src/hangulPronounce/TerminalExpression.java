package hangulPronounce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TerminalExpression implements Expression{
    @Override
    public List<String> interpret(String hangul) {
        return new ArrayList<>(Arrays.asList(hangul.split(" ")));
    }
}
