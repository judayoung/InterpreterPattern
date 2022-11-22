import hangulPronounce.EnglishExpression;
import hangulPronounce.NasalizationExpression;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {

    private static EnglishExpression englishExpression = new EnglishExpression();
    private static NasalizationExpression nasalizationExpression = new NasalizationExpression(englishExpression, englishExpression);

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