package hangulPronounce;

import java.util.*;

public class NasalizationExpression implements Expression {
    private Expression left;
    private Expression right;
    private List<String> nasalFinalList = new ArrayList<>(Arrays.asList("ng"));
    private List<String> nasalInitialList = new ArrayList<>(Arrays.asList("m", "n"));

    public NasalizationExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public List<String> interpret(String twoHangul) {
        // TODO : k u g:m u l -> k u ng m u l
        String[] hangulArray = twoHangul.split(":");
        String leftHangul = hangulArray[0];
        String rightHangul = hangulArray[1];

        /* TODO : interpret이 "한" -> [h, a, n] 으로 만들수 있도록 하는 것은 추후에.
            현재는 "h a n" -> [h, a, n] */
        List<String> leftList = left.interpret(leftHangul);
        List<String> rightList = right.interpret(rightHangul);

        // TODO : 왼쪽글자가 초성중성종성 전부 있는지 확인하는 건 추후에. 종성까지 있다 침.
        String finalConsonant = leftList.get(2);
        String initialConsonant = rightList.get(0);

        List<String> convertConsonant = convertConsonant(finalConsonant, initialConsonant);
        leftList.set(2, convertConsonant.get(0));
        rightList.set(0, convertConsonant.get(1));

        leftList.addAll(rightList);
        return leftList;
    }

    private List<String> convertConsonant(String finalConsonant, String initialConsonant) {
        // 상호동화 체크
        if(finalConsonant.equals("b") && initialConsonant.equals("r")){
            finalConsonant = convertNasal(finalConsonant);
            initialConsonant = convertNasal(initialConsonant);
        }
        // 순행동화 체크
        else if(isNasalFinal(finalConsonant)){
            initialConsonant = convertNasal(initialConsonant);
        }
        // 역행동화 체크
        else if(isNasalInitial(initialConsonant)){
            finalConsonant = convertNasal(finalConsonant);
        }

        ArrayList<String> consonantlist = new ArrayList<>();
        consonantlist.add(finalConsonant);
        consonantlist.add(initialConsonant);
        return consonantlist;
    }

    private boolean isNasalFinal(String finalConsonant){
        return nasalFinalList.contains(finalConsonant);
    }

    private boolean isNasalInitial(String initialConsonant){
        return nasalInitialList.contains(initialConsonant);
    }

    private String convertNasal(String consonant){
        String result = consonant;
        switch (consonant){
            case "g" -> result = "ng";
            case "b" -> result = "m";
            case "r" -> result = "n";
        }
        return result;
    }

}
