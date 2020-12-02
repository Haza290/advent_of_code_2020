package uk.co.schneiderweb.day2;

import lombok.Getter;
import uk.co.schneiderweb.util.ReadFile;

import java.util.List;

public class PasswordValidator {

    enum ValidationType {
        CHARACTER_FREQUENCY,
        CHARACTER_POSITION
    }

    public static void main(String[] args) {
        List<String> inputList = ReadFile.readStringListFromFile(PasswordValidator.class.getClassLoader().getResource("day2_input"));
        int characterFrequencyValidationCount = new PasswordValidator().countValidPasswords(inputList, ValidationType.CHARACTER_FREQUENCY);
        int characterPositionValidationCount = new PasswordValidator().countValidPasswords(inputList, ValidationType.CHARACTER_POSITION);
        System.out.println("characterFrequencyValidationCount: " + characterFrequencyValidationCount);
        System.out.println("characterPositionValidationCount: " + characterPositionValidationCount);
    }

    public int countValidPasswords(List<String> inputArray, ValidationType validationType) {
        return (int) inputArray.stream().map(PasswordComponents::new).filter(p -> isValidPassword(p, validationType)).count();
    }

    private boolean isValidPassword(PasswordComponents passwordComponents, ValidationType validationType) {
        switch (validationType) {
            case CHARACTER_FREQUENCY:
                long characterAppearances = passwordComponents.getPassword().chars().filter(c -> c == passwordComponents.getCharacter()).count();
                return characterAppearances >= passwordComponents.getLower() && characterAppearances <= passwordComponents.getUpper();
            case CHARACTER_POSITION:
                return passwordComponents.getPassword().charAt(passwordComponents.getLower() - 1) == passwordComponents.character ^
                        passwordComponents.getPassword().charAt(passwordComponents.getUpper() - 1) == passwordComponents.character;
        }
        return false;
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
