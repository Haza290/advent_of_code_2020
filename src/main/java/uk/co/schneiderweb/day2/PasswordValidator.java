package uk.co.schneiderweb.day2;

import lombok.Getter;
import uk.co.schneiderweb.util.ReadFile;

import java.util.List;

public class PasswordValidator {

    public static void main(String[] args) {
        List<String> inputList = ReadFile.readStringListFromFile(PasswordValidator.class.getClassLoader().getResource("day2_input"));
        int count = new PasswordValidator().countValidPasswords(inputList);
        System.out.println("Count: " + count);
    }

    public int countValidPasswords(List<String> inputArray) {
        return (int) inputArray.stream().map(PasswordComponents::new).filter(this::isValidPassword).count();
    }

    private boolean isValidPassword(PasswordComponents passwordComponents) {
        long characterAppearances = passwordComponents.getPassword().chars().filter(c -> c == passwordComponents.getCharacter()).count();
        return characterAppearances >= passwordComponents.getLower() && characterAppearances <= passwordComponents.getUpper();
    }

    @Getter
    static class PasswordComponents {

        private final int lower;
        private final int upper;
        private final char character;
        private final String password;

        PasswordComponents(String inputString) {
            this.lower = Integer.valueOf(inputString.substring(0, inputString.indexOf("-")));
            this.upper = Integer.valueOf(inputString.substring(inputString.indexOf("-") + 1, inputString.indexOf(" ")));
            this.character = inputString.charAt(inputString.indexOf(" ") + 1);
            this.password = inputString.substring(inputString.indexOf(":") + 2);
        }
    }
}
