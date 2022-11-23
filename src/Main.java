import hangulPronounce.TerminalExpression;
import hangulPronounce.NasalizationExpression;

import java.util.*;

public class Main {

    private static final TerminalExpression terminalExpression = new TerminalExpression();
    private static final NasalizationExpression nasalizationExpression = new NasalizationExpression(terminalExpression, terminalExpression);

    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("한글 비음화 현상 영어로 만들기\n");

        String twoHangul;

        twoHangul = "k u g:m u l";
        nasalize(twoHangul);

        twoHangul = "j o ng:r o";
        nasalize(twoHangul);

        twoHangul = "j eo b:n eu n";
        nasalize(twoHangul);
    }

    private static void nasalize(String twoHangul){
        List<String> interpret;
        interpret = nasalizationExpression.interpret(twoHangul);
        System.out.print(twoHangul + " -> ");
        System.out.println(String.join("", interpret));
    }
}