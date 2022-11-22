package hangulPronounce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnglishExpression implements Expression{
    @Override
    public List<String> interpret(String hangul) {
        return new ArrayList<String>(Arrays.asList(hangul.split(" ")));
    }
}
