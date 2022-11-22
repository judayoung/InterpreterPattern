package hangulPronounce;

import java.util.List;

public interface Expression {

    List<String> interpret(String hangul);

}
