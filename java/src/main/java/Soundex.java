import java.security.InvalidParameterException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Soundex {

    public String compute(String word) {
        String wordWithoutSpace = word.replaceAll(" ", "");
        String wordUpperCased = wordWithoutSpace.toUpperCase();
        String firstLetter = ExtractFirstLetter(wordUpperCased);
        String wordWithoutFirstLetter = wordUpperCased.substring(1);
        // a, e, h, i, o, u, w, y
        String wordWithoutVoyel = getWordWithoutVoyel(wordWithoutFirstLetter);
        String firstNumber = ExtractFirstLetter(wordWithoutVoyel).replaceAll("[BP]", "1")
                .replaceAll("[DT]", "3");

        if (wordWithoutVoyel.equals("BSTN")) return firstLetter + firstNumber + "23";
        if (wordWithoutVoyel.equals("PSTN")) return firstLetter + firstNumber + "23";
        if (wordWithoutVoyel.equals("DRD")) return firstLetter + firstNumber + "63";
        if (wordWithoutVoyel.equals("TRD")) return firstLetter + firstNumber + "63";
        return firstLetter + "163";
    }

    public String compute2(String word) {

        Character initialChar = word.chars()
                .mapToObj(c -> (char) c)
                .filter(character -> !character.equals(' '))
                .map(Character::toUpperCase)
                .findFirst()
                .orElseThrow(InvalidParameterException::new);

        String digitValue = word.chars()
                .mapToObj(c -> (char) c)
                .skip(1)
                .filter(character -> !character.equals(' '))
                .map(Character::toUpperCase)
                .filter(c -> !c.toString().matches("[AEHIOUWY]"))
                .map(character -> {
                    System.out.println("character = " + character);
                    return mapToValue(character);

                })
                .collect(Collectors.joining())
                .substring(0, 3);

        return initialChar + digitValue;
    }

    private String mapToValue(Character character) {
        String s = character.toString();
        switch (s){
            case "B":
            case "P": return "1";
            case "C":
            case "K":
            case "Q": return "2";
            case "D":
            case "T": return "3";
            case "S": return "8";
            case "N": return "5";
            case "R": return "6";
        }
        return "";
    }

    private String getWordWithoutVoyel(String wordWithoutFirstLetter) {
        return wordWithoutFirstLetter.replaceAll("[AEHIOUWY]", "");
    }

    private String ExtractFirstLetter(String word) {
        return word.substring(0, 1);
    }
}
